package com.obric.agent;

import android.app.ActivityManager;
import android.app.Application;
import android.app.KeyguardManager;
import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.cypress.mediacontext.MediaSessionData;
import android.cypress.mediacontext.MediaSessionMetaEntry;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.Keva;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.android.material.timepicker.TimeModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.obric.agent.auth.IAgentAuthService;
import com.obric.agent.autoaction.IAutoActionService;
import com.obric.agent.complextask.IComplexTaskService;
import com.obric.agent.intents.findphone.FindPhoneActivity;
import com.obric.agent.message.IAgentMessageExtProvider;
import com.obric.agent.message.IMessageCollectService;
import com.obric.agent.omnimodel.IOmniModelService;
import com.obric.agent.trace.IIntentMetricsService;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.IFlowAppStateIDL;
import com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL;
import com.obric.aiagent.assistant.idl.IFlowAssistantTTSStateListenerIDL;
import com.obric.aiagent.assistant.idl.IFlowDeleteMessageCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowFindMessageCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL;
import com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL;
import com.obric.aiagent.assistant.idl.IFlowUiIDL;
import com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL;
import com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aiagent.assistant.idl.bean.DataSource;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.IntentDebugReport;
import com.obric.aiagent.assistant.idl.bean.OAppIntentBizContentType;
import com.obric.aiagent.assistant.idl.bean.OComplexTaskConfig;
import com.obric.aiagent.assistant.idl.bean.OModelConfig;
import com.obric.aiagent.assistant.idl.bean.PersonalContextInfo;
import com.obric.aiagent.assistant.idl.bean.PicInfo;
import com.obric.aiagent.assistant.idl.bean.TextContent;
import com.obric.aiagent.assistant.idl.bean.TtsInfo;
import com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi;
import com.obric.aiagent.executionengine.utils.pkms.PackageInfoCache;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.obric.aiagent.skill.ovirt.api.lifecycle.OVirtLifecycleListener;
import com.obric.assistant.dm.api.IDialogManagement;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskId;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.core.TaskState;
import com.obric.assistant.dm.api.statemachine.core.TaskType;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.obric.autogui.api.IOAutoStateManager;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.CardProvider;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.RemoteCard;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.BaseOfficeJumpToLarkUrlIntent;
import com.obric.capabilitykit.common.intent.BaseSystemGetWebUrlIntent;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.OfficeJumpToLarkUrlParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.capabilitykit.common.intent.WeatherInfo;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.eventkit.EventsTaskSdk;
import com.obric.eventkit.ITaskManagerApi;
import com.obric.eventkit.eventstaskmanager.ActiveAgentEvent;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import com.obric.eventkit.eventstaskmanager.AppNotification;
import com.obric.eventkit.eventstaskmanager.EventTypeKt;
import com.obric.eventkit.eventstaskmanager.NotificationEvent;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.obric.funcall_api.IIntentActionService;
import com.obric.funcall_api.bean.IntentAppAction;
import com.obric.memorydata.sdk.assistant.AssistantStateServiceProxy;
import com.obric.memorydata.sdk.assistant.QueryContext;
import com.obric.memorydata.sdk.memory.MemoryServiceProxy;
import com.obric.memorydata.sdk.realtime.IRealTimeContextCallback;
import com.obric.memorydata.sdk.realtime.RealTimeContext;
import com.obric.memorydata.sdk.realtime.RealTimeContextServiceProxy;
import com.obric.memorydata.sdk.service.MemoryDataServiceProxy;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bs;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.dg;
import org.json.JSONObject;

/* JADX INFO: compiled from: AgentServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AgentServiceImpl implements IAgentService {
    private static final String CACHED_FILE_ENTITY_MAP = "cached_file_entity_map";
    private static final String CALL_SCENE_DOUBAO_CHAT_PAGE = "doubao_chat_page";
    private static final String CALL_SCENE_LOCK_SCREEN = "lock_screen";
    private static final String COLLECTION_ID = "collection_id";
    private static final long CONDITION_TASK_SEND_TIMEOUT_MILLIS = 300000;
    public static final a Companion = null;
    private static final String EXT_IS_OBRIC_CONTINUOUS_TALK = "is_obric_continuous_talk";
    private static final String EXT_OBRIC_MESSAGE_POSITION_LEVEL1 = "obric_message_position_level1";
    private static final String EXT_OBRIC_MESSAGE_POSITION_LEVEL2 = "obric_message_position_level2";
    private static final String EXT_OBRIC_WINDOW_MODE = "obric_window_mode";
    private static final String EXT_O_COMPLEX_TASK = "o_complex_task";
    private static final String EXT_O_IS_DEVICE_LOCKED = "o_is_device_locked";
    private static final String EXT_O_IS_MIC_ON = "o_is_mic_on";
    private static final String EXT_O_SCREEN_POSITION = "o_screen_position";
    private static final String EXT_O_TOP_APP = "o_top_app";
    private static final String EXT_TO_SERVER = "to_server";
    private static final int EXT_VALUE_SIZE_THRESHOLD = 500;
    private static final String FILE_PREFIX = "entity_url_";
    private static final String KEY_LAST_REMOTE_CARD_ID = "last_remote_card_id";
    private static final String KEY_REFERENCE_ID = "reference_id";
    private static final int MAX_COUNT_FILE = 10;
    private static final int MAX_REALTIME_ENTITIES = 10;
    private static final int OPEN_MIC_SIGNAL_CACHE_SIZE = 20;
    private static final Set<String> O_SESSION_VOLATILE_ALLOWED_KEYS = null;
    private static final String REASON_AUTO_UPLOAD_DISABLED = "auto_upload_disabled";
    private static final String REASON_FOREGROUND_IS_HOST = "foreground_is_host";
    private static final String REASON_FULL_SCREEN = "full_screen";
    private static final String REASON_HOME_ACTIVITY = "home_activity";
    private static final String REASON_KEYGUARD_LOCKED = "keyguard_locked";
    private static final String REASON_NO_SCREENSHOT_TO_UPLOAD = "no_screenshot_to_upload";
    private static final String REASON_REALTIME_IMG_NO_SCREENSHOT = "realtime_img_no_screenshot";
    private static final String REASON_SECURE_WINDOW = "secure_window";
    private static final String REASON_UPLOAD_FAILED = "upload_failed";
    private static final String REASON_UPLOAD_TIMEOUT = "upload_timeout";
    private static final String TAG = "AgentServiceImpl";
    private static final String WINDOW_MODE_FULL_SCREEN = "full_screen";
    private final String CHAT_CLASS;
    private final String DEACTIVATE_MULTIMODAL_REASON_CAMERA_BUTTON;
    private final String DEACTIVATE_MULTIMODAL_REASON_CAMERA_WINDOW_REMOVED;
    private final ComponentName LAUNCHER;
    private final long MAX_INTERVAL_HANDLE_ASSIST;
    private final ComponentName SECURE_CAMERA_N;
    private final ComponentName SECURE_CAMERA_P;
    private final String SS_WEB_CLASS;
    private final int TYPE_REALTIMEIMG;
    private final int TYPE_SCREENSHOT;
    private volatile int activeRound;
    private long activeTime;
    private long asrEndTime;
    private boolean asrIng;
    private long asrStartTime;
    private boolean assistActive;
    private AssistContent assistContent;
    private boolean assistHanlded;
    private AssistStructure assistStructure;
    private String cacheAssistImgUri;
    private String cacheScreenshotUri;
    private int cachedAudioSize;
    private int cachedEntityUrlSize;
    private int chatWindowState;
    private final kotlinx.coroutines.a.d<com.obric.eventkit.task.model.a> conditionTaskChannel;
    private final kotlinx.coroutines.a.d<String> conditionTaskSendResultChannel;
    private final d.f context$delegate;
    private String debugImageTos;
    private final d.f entityManager$delegate;
    private volatile boolean entityUploading;
    private volatile boolean firstQuery;
    private final AgentServiceImpl$flowStreamObserver$1 flowStreamObserver;
    private final AgentServiceImpl$flowTTSListener$1 flowTTSListener;
    private final AgentServiceImpl$ipcAppStateChangedListener$1 ipcAppStateChangedListener;
    private final AgentServiceImpl$ipcMessageExtCallback$1 ipcMessageExtCallback;
    private boolean isChatWindow;
    private volatile boolean isFocusedWindowSecure;
    private final Keva keva;
    private final d.f keyguardManager$delegate;
    private final Set<com.obric.agent.p> larkSendCardListeners;
    private final AtomicInteger lastReportedScreenshotStateRound;
    private IMMessage lastSentMessage;
    private final CopyOnWriteArraySet<String> lastSentRoundMessageIds;
    private String mAsrLocalMsgId;
    private final com.obric.agent.o<String, File> mCachedFileEntityMap;
    private final com.obric.agent.o<String, File> mCachedFileUriMap;
    private final ConcurrentHashMap<String, d.m<String, Long>> mLastRemoteCardMessage;
    private RealTimeContext mRealTimeContext;
    private boolean mainBotChatPageResume;
    private final r messageChangedObserver;
    private AtomicBoolean needRestartSession;
    private final com.obric.agent.o<String, c> openMicSignalCache;
    private final Object openMicSignalCacheLock;
    private final CopyOnWriteArraySet<String> openedClickTalkReplyIds;
    private ca preLoadMemoryjob;
    private final com.obric.agent.o<String, Uri> queryAudioFilesByLocalMsgId;
    private final com.obric.agent.o<String, Uri> queryAudioFilesByMsgId;
    private final com.obric.agent.o<String, String> queryMessageIdAndLocalMsg;
    private String realtimeCollectionId;
    private final CopyOnWriteArraySet<PicInfo> realtimeImgInfo;
    private String recentMemoryData;
    private Bitmap screenshot;
    private final CopyOnWriteArraySet<PicInfo> screenshotInfo;
    private volatile boolean screenshotUploadFailed;
    private final AtomicLong screenshotUploadState;
    private final com.obric.agent.o<String, String> semanticUsedUpdateImageInfo;
    private List<ShortcutTask> shortCutTasks;
    private boolean shouldRequestAssist;
    private boolean skipWaitForScreenShot;
    private final CopyOnWriteArraySet<com.obric.agent.q> streamObservers;
    private final LinkedHashSet<String> timeoutMsgSet;
    private int ttsPlayState;
    private final CopyOnWriteArraySet<com.obric.agent.y> ttsStateListeners;
    private final com.obric.agent.o<String, String> unUsedUpdateImageInfo;
    private final LinkedHashSet<com.obric.agent.z> uploadingRealTimeImagInfo;
    private final LinkedHashSet<com.obric.agent.z> uploadingScreenshotInfo;
    private final com.obric.agent.s urlCallback;
    private final LinkedHashSet<ComponentName> visibleActivities;

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$onMessageInputtingStateChange$1")
    static final class aa extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f13935b;

        aa(AgentServiceImpl r3, d.c.d<? super aa> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13935b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((aa) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), aa.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new aa(this.f13935b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f13934a != 0) goto L10;
            d.o.a(r3);
            ILogDepend.Companion.d(AgentServiceImpl.TAG, "start input wakeupAssistant");
            IFlowVoiceInteractionIDL r4 = com.obric.aiagent.assistant.idl.ax.a(d.h.b.aa.b(IFlowVoiceInteractionIDL.class));
            if (r4 == null) goto L7;
            r4.wakeupAssistant("start input");
        L7:
            AgentServiceImpl.access$setShouldRequestAssist$p(this.f13935b, false);
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$onQueryAudioFile$1$1$1")
    static final class ab extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f13937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f13938c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f13939d;

        ab(AgentServiceImpl r3, String r4, String r5, d.c.d<? super ab> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13937b = r3;
            this.f13938c = r4;
            this.f13939d = r5;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ab) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ab.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ab(this.f13937b, this.f13938c, this.f13939d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f13936a != 0) goto L15;
            d.o.a(r5);
            StringBuilder r6 = new StringBuilder().append("query_audio_");
            int r0 = AgentServiceImpl.access$getCachedAudioSize$p(this.f13937b);
            AgentServiceImpl.access$setCachedAudioSize$p(this.f13937b, r0 + 1);
            File r1 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AgentServiceImpl.access$getContext(this.f13937b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getCacheDir(), r6.append(r0 % 5).toString() + ".opus");
            if (r1.exists() == false) goto L8;
            r1.delete();
        L8:
            if (AgentServiceImpl.access$saveAudioFileToLocal(this.f13937b, this.f13938c, this.f13939d, r1) == false) goto L13;
            Uri r7 = ZeusTransformUtils.getUriForFile((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AgentServiceImpl.access$getContext(this.f13937b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.agent.fileprovider", r1, "com.obric.aiagent.plugin");
            ((Map) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getQueryAudioFilesByLocalMsgId$p(this.f13937b), Map.class, "com.obric.aiagent.plugin")).put(this.f13939d, r7);
            String r2 = (String) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getQueryMessageIdAndLocalMsg$p(this.f13937b).get(this.f13939d), String.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L13;
            ((Map) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getQueryAudioFilesByMsgId$p(this.f13937b), Map.class, "com.obric.aiagent.plugin")).put(r2, r7);
        L13:
            return d.x.f38692a;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$onStartChatWindow$1")
    static final class ac extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f13941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f13942c;

        ac(AgentServiceImpl r3, int r4, d.c.d<? super ac> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13941b = r3;
            this.f13942c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ac) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ac.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ac(this.f13941b, this.f13942c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f13940a != 0) goto L19;
            d.o.a(r3);
            int r4 = AgentServiceImpl.access$getChatWindowState$p(this.f13941b);
            int r0 = this.f13942c;
            if (r4 == r0) goto L17;
            AgentServiceImpl.access$setChatWindowState$p(this.f13941b, r0);
            if (AgentServiceImpl.access$getChatWindowState$p(this.f13941b) == com.obric.agent.h.f14567d.ordinal()) goto L17;
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "onStartChatWindow CHAT_WINDOW handleAssist & handlescreenshot");
            if (AgentServiceImpl.access$getAssistStructure$p(this.f13941b) == null) goto L11;
        L12:
            AgentServiceImpl r5 = this.f13941b;
            AgentServiceImpl.access$handleAssistInternal(r5, AgentServiceImpl.access$getAssistStructure$p(r5), AgentServiceImpl.access$getAssistContent$p(this.f13941b));
        L14:
            if (AgentServiceImpl.access$getScreenshot$p(this.f13941b) == null) goto L17;
            AgentServiceImpl r2 = this.f13941b;
            r2.onHandleScreenshot(AgentServiceImpl.access$getScreenshot$p(r2));
            goto L17
        L11:
            if (AgentServiceImpl.access$getAssistContent$p(this.f13941b) == null) goto L14;
        L17:
            return d.x.f38692a;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$onUserConfirm$2$1")
    static final class ad extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f13944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String[] f13945c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.c.d<IntentResult<AppEntity[]>> f13946d;

        ad(String r3, String[] r4, d.c.d<? super IntentResult<AppEntity[]>> r5, d.c.d<? super ad> r6) {
            d.c.d<IntentResult<AppEntity[]>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13944b = r3;
            this.f13945c = r4;
            this.f13946d = r7;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ad) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ad.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ad(this.f13944b, this.f13945c, this.f13946d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f13943a != 0) goto L10;
            d.o.a(r5);
            IDialogManagement r6 = (IDialogManagement) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogManagement.class), IDialogManagement.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L8;
            String r0 = this.f13944b;
            List<String> r2 = d.a.i.g(this.f13945c);
            final d.c.d<IntentResult<AppEntity[]>> r4 = this.f13946d;
            r6.getConfirmationPhraseForSecondTime(r0, r2, (d.h.a.s) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), d.h.a.s.class, "com.obric.aiagent.plugin"));
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$onUserSelect$2$1")
    static final class ae extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<String> f13949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f13950c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f13951d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.c.d<IntentResult<AppEntity[]>> f13952e;
        final /* synthetic */ DispatchContext f;

        ae(List<String> r3, String r4, String r5, d.c.d<? super IntentResult<AppEntity[]>> r6, DispatchContext r7, d.c.d<? super ae> r8) {
            List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d<IntentResult<AppEntity[]>> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13949b = r9;
            this.f13950c = r4;
            this.f13951d = r5;
            this.f13952e = r10;
            this.f = r7;
            super(2, r11);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ae) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ae.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ae(this.f13949b, this.f13950c, this.f13951d, this.f13952e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f13948a != 0) goto L10;
            d.o.a(r7);
            IDialogManagement r8 = (IDialogManagement) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogManagement.class), IDialogManagement.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L8;
            List<String> r0 = this.f13949b;
            String r2 = this.f13950c;
            String r3 = this.f13951d;
            final d.c.d<IntentResult<AppEntity[]>> r5 = this.f13952e;
            final DispatchContext r6 = this.f;
            r8.getPopupContent(r0, r2, r3, (d.h.a.q) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5, r6), d.h.a.q.class, "com.obric.aiagent.plugin"));
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    public static final class af implements com.obric.agent.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f13956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f13957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f13958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<d.h.a.a<d.x>> f13959d;

        @Override // com.obric.agent.q
        public void a(IMMessage r1) {
        }

        af(String r1, AtomicBoolean r2, AgentServiceImpl r3, d.h.b.z.f<d.h.a.a<d.x>> r4) {
            this.f13956a = r1;
            this.f13957b = r2;
            this.f13958c = r3;
            this.f13959d = r4;
        }

        @Override // com.obric.agent.q
        public void b(IMMessage r3) {
            d.h.a.a r0 = null;
            if (r3 == null) goto L5;
            String r4 = r3.getMessageId();
        L7:
            if (d.h.b.o.a(r4, this.f13956a) == false) goto L14;
            this.f13957b.set(true);
            AgentServiceImpl.access$getStreamObservers$p(this.f13958c).remove(this);
            if (this.f13959d.f38504a != null) goto L11;
            d.h.b.o.c("tryComplete");
        L12:
            r0.invoke();
            return;
        L11:
            r0 = (d.h.a.a) ZeusTransformUtils.preCheckCast(this.f13959d.f38504a, d.h.a.a.class, "com.obric.aiagent.plugin");
            goto L12
        L14:
            return;
        L5:
            r4 = null;
            goto L7
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {3450}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$openClickTalkWhenTTSEnd$3")
    static final class ag extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f13961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f13962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f13963d;

        ag(AtomicBoolean r3, String r4, d.h.a.a<d.x> r5, d.c.d<? super ag> r6) {
            d.h.a.a<d.x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13961b = r3;
            this.f13962c = r4;
            this.f13963d = r7;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ag) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ag.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ag(this.f13961b, this.f13962c, this.f13963d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f13960a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            if (this.f13961b.compareAndSet(false, true) == false) goto L15;
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "openClickTalkWhenTTSEnd timeout messageId=" + this.f13962c);
            this.f13963d.invoke();
        L15:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13960a = 1;
            if (kotlinx.coroutines.ax.a(10000, r7) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    public static final class ah implements com.obric.agent.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f13964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f13965b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f13966c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<d.h.a.a<d.x>> f13967d;

        ah(String r1, AgentServiceImpl r2, AtomicBoolean r3, d.h.b.z.f<d.h.a.a<d.x>> r4) {
            this.f13964a = r1;
            this.f13965b = r2;
            this.f13966c = r3;
            this.f13967d = r4;
        }

        @Override // com.obric.agent.y
        public void a(TtsInfo r4) {
            d.h.a.a r0 = null;
            if (r4 == null) goto L5;
            String r1 = r4.getMessageId();
        L7:
            if (d.h.b.o.a(r1, this.f13964a) == true) goto L9;
            return;
        L9:
            if (AgentServiceImpl.access$isTtsTerminalState(this.f13965b, r4.getPlayStateEnum()) == false) goto L17;
            this.f13966c.set(true);
            AgentServiceImpl.access$getTtsStateListeners$p(this.f13965b).remove(this);
            if (this.f13967d.f38504a != null) goto L13;
            d.h.b.o.c("tryComplete");
        L14:
            r0.invoke();
            return;
        L13:
            r0 = (d.h.a.a) ZeusTransformUtils.preCheckCast(this.f13967d.f38504a, d.h.a.a.class, "com.obric.aiagent.plugin");
            goto L14
        L17:
            return;
        L5:
            r1 = null;
            goto L7
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {3377}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$openClickTalkWhenTTSEnd$doOpen$1$1")
    static final class ai extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f13969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IMMessage f13970c;

        ai(AgentServiceImpl r3, IMMessage r4, d.c.d<? super ai> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13969b = r3;
            this.f13970c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ai) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ai.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ai(this.f13969b, this.f13970c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f13968a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            if (AgentServiceImpl.access$isLastSentRound(this.f13969b, this.f13970c.getReplyId()) == false) goto L17;
            IFlowVoiceInteractionIDL r5 = com.obric.aiagent.assistant.idl.ax.a(d.h.b.aa.b(IFlowVoiceInteractionIDL.class));
            if (r5 == null) goto L17;
            r5.tryOpenClickTalk(4);
        L17:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13968a = 1;
            if (kotlinx.coroutines.ax.a(500, r7) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {383}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$preLoadMemoryjob$1")
    static final class aj extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f13972b;

        aj(AgentServiceImpl r3, d.c.d<? super aj> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13972b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((aj) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), aj.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new aj(this.f13972b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f13971a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            if (AgentServiceImpl.access$getMainBotChatPageResume$p(this.f13972b) == false) goto L15;
            AgentServiceImpl.access$notifyMemoryForPreload(this.f13972b);
        L15:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13971a = 1;
            if (kotlinx.coroutines.ax.a(50000, r7) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$removeLarkSendCardListener$1")
    static final class ak extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f13974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.p f13975c;

        ak(AgentServiceImpl r3, com.obric.agent.p r4, d.c.d<? super ak> r5) {
            com.obric.agent.p r6 = (com.obric.agent.p) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.agent.p.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13974b = r3;
            this.f13975c = r6;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ak) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ak.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ak(this.f13974b, this.f13975c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f13973a != 0) goto L7;
            d.o.a(r2);
            AgentServiceImpl.access$getLarkSendCardListeners$p(this.f13974b).remove(this.f13975c);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {1453}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$resetRequestAssist$1")
    static final class al extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f13977b;

        al(AgentServiceImpl r3, d.c.d<? super al> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13977b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((al) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), al.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new al(this.f13977b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f13976a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            AgentServiceImpl.access$setShouldRequestAssist$p(this.f13977b, true);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13976a = 1;
            if (kotlinx.coroutines.ax.a(500, r7) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$saveBitMapToFile$2")
    static final class am extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super File>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f13979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f13980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bitmap f13981d;

        am(Context r3, String r4, Bitmap r5, d.c.d<? super am> r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13979b = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            this.f13980c = r4;
            this.f13981d = r5;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super File> r4) {
            return ((am) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new am(this.f13979b, this.f13980c, this.f13981d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super File> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f13978a != 0) goto L22;
            d.o.a(r7);
            Context r8 = this.f13979b;
            if (r8 != null) goto L7;
            r8 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        L7:
            File r9 = r8.getCacheDir();
            if (r9.exists() == false) goto L10;
        L12:
            File r1 = new File(r9, this.f13980c);
        L18:
            e = move-exception;
            ILogDepend.Companion.e("saveBitMapToFile", "errorMsg: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return null;
        L14:
            if (r1.exists() == false) goto L16;
            r1.delete();     // Catch: Exception -> L18
        L16:
            BufferedOutputStream r10 = new BufferedOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r1), OutputStream.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L18
            this.f13981d.compress(Bitmap.CompressFormat.JPEG, 70, (OutputStream) ZeusTransformUtils.preCheckCast(r10, OutputStream.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L18
            r10.flush();     // Catch: Exception -> L18
            r10.close();     // Catch: Exception -> L18
            return r1;
        L10:
            if (r9.mkdirs() == true) goto L12;
            return null;
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {2864, 2873}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$saveEntityFileToLocal$2")
    static final class an extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Uri>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppEntity f13983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f13984c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f13985d;

        an(AppEntity r3, AgentServiceImpl r4, b r5, d.c.d<? super an> r6) {
            b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13983b = r3;
            this.f13984c = r4;
            this.f13985d = r7;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Uri> r4) {
            return ((an) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), an.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new an(this.f13983b, this.f13984c, this.f13985d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Uri> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f13982a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r13);
        L27:
            return (Uri) ZeusTransformUtils.preCheckCast(r13, Uri.class, "com.obric.aiagent.plugin");
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r13);
        L29:
            return (Uri) ZeusTransformUtils.preCheckCast(r13, Uri.class, "com.obric.aiagent.plugin");
        L10:
            d.o.a(r13);
            File r6 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getCacheDir();
            if (r6.exists() == false) goto L13;
        L15:
            AppEntity r14 = this.f13983b;
            if (ZeusTransformUtils.instanceOf(r14, PhotoEntity.class) == false) goto L22;
            AgentServiceImpl r5 = this.f13984c;
            d.h.b.o.a(r6);
            String r7 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(this.f13983b, PhotoEntity.class, "com.obric.aiagent.plugin")).getFile().getFileName();
            AppEntity r8 = this.f13983b;
            Uri r9 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r8, PhotoEntity.class, "com.obric.aiagent.plugin")).getFile().getContentUrl();
            b r10 = this.f13985d;
            d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13982a = 1;
            r13 = AgentServiceImpl.access$saveFileFromStream(r5, r6, r7, r8, r9, r10, r11);
            if (r13 != r0) goto L29;
            return r0;
        L22:
            if (ZeusTransformUtils.instanceOf(r14, FileEntity.class) == false) goto L28;
            AgentServiceImpl r12 = this.f13984c;
            d.h.b.o.a(r6);
            String r15 = ((FileEntity) ZeusTransformUtils.preCheckCast(this.f13983b, FileEntity.class, "com.obric.aiagent.plugin")).getFileName();
            AppEntity r16 = this.f13983b;
            Uri r17 = ((FileEntity) ZeusTransformUtils.preCheckCast(r16, FileEntity.class, "com.obric.aiagent.plugin")).getContentUrl();
            b r18 = this.f13985d;
            d.c.d r19 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13982a = 2;
            r13 = AgentServiceImpl.access$saveFileFromStream(r12, r6, r15, r16, r17, r18, r19);
            if (r13 != r0) goto L27;
            return r0;
        L28:
            return null;
        L13:
            if (r6.mkdirs() == true) goto L15;
            return null;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {2935}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$saveFileFromStream$2")
    static final class ao extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<File> f13987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f13988c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppEntity f13989d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Uri f13990e;
        final /* synthetic */ b f;
        final /* synthetic */ String g;

        /* JADX INFO: compiled from: AgentServiceImpl.kt */
        @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$saveFileFromStream$2$status$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<InputStream, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f13991a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f13992b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ d.h.b.z.f<File> f13993c;

            a(d.h.b.z.f<File> r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f13993c = r3;
                super(2, r5);
            }

            public final Object a(InputStream r3, d.c.d<? super d.x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                a r0 = new a(this.f13993c, r5);
                r0.f13992b = r3;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(InputStream r3, d.c.d<? super d.x> r4) {
                return a((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                d.c.a.b.a();
                if (this.f13991a != 0) goto L14;
                d.o.a(r6);
                InputStream r7 = (InputStream) ZeusTransformUtils.preCheckCast(this.f13992b, InputStream.class, "com.obric.aiagent.plugin");
                int r0 = Math.min(Math.max(4096, r7.available()), 20971520);
                ILogDepend.Companion.d(AgentServiceImpl.TAG, "updateActionContext bufferSize=" + r0);
                Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream((File) ZeusTransformUtils.preCheckCast(this.f13993c.f38504a, File.class, "com.obric.aiagent.plugin")), Closeable.class, "com.obric.aiagent.plugin");
                d.f.b.a(r7, (OutputStream) ZeusTransformUtils.preCheckCast((FileOutputStream) ZeusTransformUtils.preCheckCast(r5, FileOutputStream.class, "com.obric.aiagent.plugin"), OutputStream.class, "com.obric.aiagent.plugin"), r0);     // Catch: Throwable -> L8
                d.x r8 = d.x.f38692a;     // Catch: Throwable -> L8
                d.f.c.a(r5, null);
                return d.x.f38692a;
            L8:
                th = move-exception;
                throw th;     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                d.f.c.a(r5, th);
                throw th;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        ao(d.h.b.z.f<File> r3, AgentServiceImpl r4, AppEntity r5, Uri r6, b r7, String r8, d.c.d<? super ao> r9) {
            b r10 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13987b = r3;
            this.f13988c = r4;
            this.f13989d = r5;
            this.f13990e = r6;
            this.f = r10;
            this.g = r8;
            super(2, r11);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ao) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ao.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ao(this.f13987b, this.f13988c, this.f13989d, this.f13990e, this.f, this.g, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f13986a;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L24:
            int r11 = ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue();
            b r2 = this.f;
            if (r2 == null) goto L30;
            if (r11 == 0) goto L29;
            r3 = false;
        L29:
            r2.a(r3);
        L30:
            ILogDepend.Companion.d(AgentServiceImpl.TAG, "updateActionContext savefile done");
            String r12 = this.g;
            if (r12 == null) goto L33;
            ((Map) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getMCachedFileEntityMap$p(this.f13988c), Map.class, "com.obric.aiagent.plugin")).put(r12, this.f13987b.f38504a);
        L33:
            AgentServiceImpl.access$getKeva$p(this.f13988c).storeString(AgentServiceImpl.CACHED_FILE_ENTITY_MAP, EntityExtKt.a().toJson(AgentServiceImpl.access$getMCachedFileEntityMap$p(this.f13988c)));
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            if (((File) ZeusTransformUtils.preCheckCast(this.f13987b.f38504a, File.class, "com.obric.aiagent.plugin")).exists() == false) goto L21;
            Set r13 = AgentServiceImpl.access$getMCachedFileEntityMap$p(this.f13988c).entrySet();
            d.h.b.o.c(r13, "<get-entries>(...)");
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
            d.h.b.z.f<File> r5 = this.f13987b;
            Iterator r15 = r14.iterator();
        L12:
            if (r15.hasNext() == false) goto L16;
            Object r6 = r15.next();
            if (d.h.b.o.a(((Map.Entry) ZeusTransformUtils.preCheckCast(r6, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), r5.f38504a) == false) goto L12;
        L17:
            Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6, Map.Entry.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L20;
            File r17 = (File) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getMCachedFileEntityMap$p(this.f13988c).remove(r16.getKey()), File.class, "com.obric.aiagent.plugin");
        L20:
            ((File) ZeusTransformUtils.preCheckCast(this.f13987b.f38504a, File.class, "com.obric.aiagent.plugin")).delete();
            ILogDepend.Companion.d(AgentServiceImpl.TAG, "updateActionContext file.delete");
            goto L21
        L16:
            r6 = null;
        L21:
            AtomicCapabilitySdk r18 = AtomicCapabilitySdk.INSTANCE;
            AppEntity r7 = this.f13989d;
            Uri r8 = this.f13990e;
            d.h.a.m<? super InputStream, ? super d.c.d<? super d.x>, ? extends Object> r4 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f13987b, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d<? super Integer> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13986a = 1;
            r10 = r18.openInputStream(r7, r8, r4, r9);
            if (r10 != r0) goto L24;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {3035}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$scheduleConditionTask$1")
    static final class ap extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IntentParams f13995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConditionTask f13996c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f13997d;

        ap(IntentParams r3, ConditionTask r4, AgentServiceImpl r5, d.c.d<? super ap> r6) {
            IntentParams r7 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r3, IntentParams.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13995b = r7;
            this.f13996c = r4;
            this.f13997d = r5;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ap) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ap.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ap(this.f13995b, this.f13996c, this.f13997d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f13994a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L14:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            if (ZeusTransformUtils.instanceOf(this.f13995b, SystemAutoActionParams.class) == false) goto L14;
            com.obric.eventkit.task.model.a r7 = com.obric.agent.intents.a.f14662a.a((EventTask) ZeusTransformUtils.preCheckCast(this.f13996c, EventTask.class, "com.obric.aiagent.plugin"));
            r7.a(d.c.b.a.b.a(2));
            kotlinx.coroutines.a.d r2 = AgentServiceImpl.access$getConditionTaskChannel$p(this.f13997d);
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13994a = 1;
            if (r2.a(r7, r3) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {3010}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$scheduleShortcutTask$1")
    static final class aq extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13998a;

        aq(d.c.d<? super aq> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((aq) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), aq.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new aq((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f13998a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            IFlowUiIDL r5 = com.obric.aiagent.assistant.idl.aw.a(d.h.b.aa.b(IFlowUiIDL.class));
            if (r5 == null) goto L15;
            r5.openChatActivity(com.obric.agent.h.f14566c.ordinal());
        L15:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f13998a = 1;
            if (kotlinx.coroutines.ax.a(100, r7) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {1333}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$screenShot$1")
    static final class ar extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.t f14001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f14002d;

        ar(AgentServiceImpl r3, com.obric.agent.t r4, d.c.d<? super ar> r5) {
            com.obric.agent.t r6 = (com.obric.agent.t) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.agent.t.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14000b = r3;
            this.f14001c = r6;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ar) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ar.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            ar r0 = new ar(this.f14000b, this.f14001c, r6);
            r0.f14002d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f13999a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            kotlinx.coroutines.am r2 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f14002d, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            d.o.a(r6);
        L11:
            File r7 = (File) ZeusTransformUtils.preCheckCast(r6, File.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L14;
            AgentServiceImpl r3 = this.f14000b;
            com.obric.agent.t r5 = this.f14001c;
            Uri r8 = Uri.fromFile(r7);
            ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AgentServiceImpl.access$getContext(r3), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).grantUriPermission("com.larus.nova", r8, 1);
            d.h.b.o.a(r8);
            r5.a(r8);
        L16:
            return d.x.f38692a;
        L14:
            com.obric.agent.t r9 = this.f14001c;
            String r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_get_screenshot_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_get_screenshot_failed"));
            d.h.b.o.c(r10, "getString(...)");
            r9.a(r10);
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.am r11 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f14002d, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            AgentServiceImpl r4 = this.f14000b;
            d.c.d r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14002d = r11;
            this.f13999a = 1;
            r6 = AgentServiceImpl.access$getScreenshot(r4, "screenshotX.jpg", r12);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {1357}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$takeScreenshotForScreenPerception$1")
    static final class as extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.t f14005c;

        as(AgentServiceImpl r3, com.obric.agent.t r4, d.c.d<? super as> r5) {
            com.obric.agent.t r6 = (com.obric.agent.t) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.agent.t.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14004b = r3;
            this.f14005c = r6;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((as) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), as.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new as(this.f14004b, this.f14005c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14003a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L13:
            File r12 = (File) ZeusTransformUtils.preCheckCast(r11, File.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L16;
            Uri r13 = ZeusTransformUtils.getUriForFile((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AgentServiceImpl.access$getContext(this.f14004b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.agent.fileprovider", r12, "com.obric.aiagent.plugin");
            ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AgentServiceImpl.access$getContext(this.f14004b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).grantUriPermission("com.larus.nova", r13, 1);
            com.obric.agent.t r10 = this.f14005c;
            d.h.b.o.a(r13);
            r10.a(r13);
        L19:
            return d.x.f38692a;
        L16:
            com.obric.agent.t r14 = this.f14005c;
            String r15 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_get_screenshot_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_get_screenshot_failed"));
            d.h.b.o.c(r15, "getString(...)");
            r14.a(r15);
            goto L19
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            Bitmap r16 = AgentServiceImpl.access$takeScreenshotByObricWindow(this.f14004b);
            if (r16 == null) goto L17;
            AgentServiceImpl r2 = this.f14004b;
            Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AgentServiceImpl.access$getContext(r2), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.c.d<? super File> r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14003a = 1;
            r11 = r2.saveBitMapToFile(r7, r16, "screenshotForScreenPerception.jpg", r8);
            if (r11 != r0) goto L13;
            return r0;
        L17:
            com.obric.agent.t r17 = this.f14005c;
            String r18 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_get_screenshot_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_get_screenshot_failed"));
            d.h.b.o.c(r18, "getString(...)");
            r17.a(r18);
            goto L19
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {3142}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$tryScheduleConditionTask$2")
    static final class at extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14006a;

        at(d.c.d<? super at> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((at) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), at.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new at((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14006a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            IFlowUiIDL r5 = com.obric.aiagent.assistant.idl.aw.a(d.h.b.aa.b(IFlowUiIDL.class));
            if (r5 == null) goto L15;
            r5.openChatActivity(com.obric.agent.h.f14566c.ordinal());
        L15:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14006a = 1;
            if (kotlinx.coroutines.ax.a(100, r7) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$updateMutableMessageForLark$1$1")
    static final class au extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14007a;

        au(d.c.d<? super au> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((au) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), au.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new au((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r1) {
            d.c.a.b.a();
            if (this.f14007a != 0) goto L7;
            d.o.a(r1);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {3739}, d = "updateShortCutTasks", e = "com.obric.agent.AgentServiceImpl")
    static final class av extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f14009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f14011d;

        av(AgentServiceImpl r3, d.c.d<? super av> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14010c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14009b = r3;
            this.f14011d |= Integer.MIN_VALUE;
            return this.f14010c.updateShortCutTasks((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {3754}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$updateUserRecentMemoryDataAsync$1")
    static final class aw extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14013b;

        aw(AgentServiceImpl r3, d.c.d<? super aw> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14013b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((aw) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), aw.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new aw(this.f14013b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14012a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");
            ISecureLogDepend.Companion.d(AgentServiceImpl.TAG, "getUserRecentMemoryData " + r7);
            AgentServiceImpl r5 = this.f14013b;
            monitor-enter(r5);
            AgentServiceImpl.access$setRecentMemoryData$p(r5, r7);     // Catch: Throwable -> L17
            ISecureLogDepend.Companion.i(AgentServiceImpl.TAG, "getUserRecentMemoryData " + AgentServiceImpl.access$getRecentMemoryData$p(r5));     // Catch: Throwable -> L17
            d.x r8 = d.x.f38692a;     // Catch: Throwable -> L17
            monitor-exit(r5);
            return d.x.f38692a;
        L17:
            th = move-exception;
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            AgentServiceImpl r9 = this.f14013b;
            int r2 = com.obric.agent.d.f14409a.e();
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14012a = 1;
            r6 = AgentServiceImpl.access$getUserRecentMemoryData(r9, r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$uploadImageIfNeeded$1")
    static final class ax extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.l f14015b;

        ax(com.obric.agent.l r3, d.c.d<? super ax> r4) {
            com.obric.agent.l r5 = (com.obric.agent.l) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.agent.l.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14015b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ax) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ax.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ax(this.f14015b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f14014a != 0) goto L7;
            d.o.a(r8);
            this.f14015b.a(false, null, null, "flow_message_ipc_unavailable", "flow message ipc unavailable");
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$uploadImageIfNeeded$3$1")
    static final class ay extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.l f14017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Throwable f14018c;

        ay(com.obric.agent.l r3, Throwable r4, d.c.d<? super ay> r5) {
            com.obric.agent.l r6 = (com.obric.agent.l) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.agent.l.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14017b = r6;
            this.f14018c = r4;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ay) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ay.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ay(this.f14017b, this.f14018c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f14016a != 0) goto L7;
            d.o.a(r8);
            this.f14017b.a(false, null, null, "flow_message_ipc_exception", this.f14018c.getMessage());
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    public static final class az implements com.obric.agent.s {
        az() {
        }

        @Override // com.obric.agent.s
        public void a(Uri r7) {
            d.h.b.o.e(r7, "uri");
            ISecureLogDepend.Companion.i(AgentServiceImpl.TAG, "urlCallback onUri: " + r7);
            IFlowUiIDL r0 = com.obric.aiagent.assistant.idl.aw.a(d.h.b.aa.b(IFlowUiIDL.class));
            if (r0 == null) goto L6;
            r0.addCustomBarAction(IFlowAppIntentIDL.ACTION_BAR_KEY_WEB_PERCEIVE, r7.toString(), "", -1);
            return;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    public interface b {
        void a(boolean r1);
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f14019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Integer f14020b;

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ c a(c r0, boolean r1, Integer r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.f14019a;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.f14020b;
        L9:
            return r0.a(r1, r2);
        }

        public final c a(boolean r1, Integer r2) {
            return new c(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f14019a == r6.f14019a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f14020b, r6.f14020b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f14019a) * 31;
            Integer r1 = this.f14020b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "OpenMicSignalState(streamEnded=" + this.f14019a + ", ttsState=" + this.f14020b + ')';
        }

        public c(boolean r1, Integer r2) {
            this.f14019a = r1;
            this.f14020b = r2;
        }

        public /* synthetic */ c(boolean r1, Integer r2, int r3, d.h.b.h r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = false;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = null;
        L8:
            this(r1, r2);
        }

        public final boolean a() {
            return this.f14019a;
        }

        public final Integer b() {
            return this.f14020b;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14022b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f14021a, r6.f14021a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f14022b, r6.f14022b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.f14021a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f14022b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "QuestionContext(conversationId=" + this.f14021a + ", displayContent=" + this.f14022b + ')';
        }

        public d(String r1, String r2) {
            this.f14021a = r1;
            this.f14022b = r2;
        }

        public final String a() {
            return this.f14021a;
        }

        public final String b() {
            return this.f14022b;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$addLarkSendCardListener$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.p f14025c;

        e(AgentServiceImpl r3, com.obric.agent.p r4, d.c.d<? super e> r5) {
            com.obric.agent.p r6 = (com.obric.agent.p) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.agent.p.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14024b = r3;
            this.f14025c = r6;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f14024b, this.f14025c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f14023a != 0) goto L7;
            d.o.a(r2);
            AgentServiceImpl.access$getLarkSendCardListeners$p(this.f14024b).add(this.f14025c);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {1600}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$addMessage$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f14026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f14029d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14030e;
        final /* synthetic */ String f;
        final /* synthetic */ int g;
        final /* synthetic */ String h;

        f(String r3, String r4, AgentServiceImpl r5, String r6, int r7, String r8, d.c.d<? super f> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14028c = r3;
            this.f14029d = r4;
            this.f14030e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            super(2, r10);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f14028c, this.f14029d, this.f14030e, this.f, this.g, this.h, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r39) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f14027b;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            boolean r3 = this.f14026a;
            d.o.a(r39);
            Object r7 = r39;
            boolean r13 = true;
            String r9 = null;
            boolean r11 = false;
        L62:
            IMMessage r12 = (IMMessage) ZeusTransformUtils.preCheckCast(r7, IMMessage.class, "com.obric.aiagent.plugin");
            boolean r4 = r3;
        L64:
            if (r12 == null) goto L68;
            Map<String, String> r5 = r12.getExt();
            if (r5 == null) goto L68;
            String r14 = (String) ZeusTransformUtils.preCheckCast(r5.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
        L69:
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "addMessage, questionId: " + this.f14029d + ", type: " + this.f14028c + " taskType: " + r14);
        L70:
            if (r4 == false) goto L72;
        L75:
            CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f, CharSequence.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L78;
        L81:
            boolean r8 = r13;
        L82:
            if (r8 == true) goto L84;
            String r10 = this.f;
        L89:
            Map<String, String> r15 = AgentServiceImpl.access$getExtForSendMessage(this.f14030e, this.f14029d, this.g);
            if (r15 != null) goto L92;
            r15 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        L92:
            r15.put("tts_not_supported", "1");
            if (r12 == null) goto L97;
            Map<String, String> r16 = r12.getExt();
            if (r16 == null) goto L97;
            com.obric.agent.utils.o.f16054a.a(r16, r15);
        L97:
            d r17 = AgentServiceImpl.access$getQuestionContext(this.f14030e, this.f14029d, r12);
            IMMessage r18 = new IMMessage(null, null, 0, 0, 0, this.g, false, this.h, null, r15, r10, null, 0, 0, null, null, this.f14029d, this.f14028c, 0, 325983, null);
            String r19 = this.f14028c;
            String r110 = this.h;
            AgentServiceImpl r20 = this.f14030e;
            String r0 = this.f14029d;
            if (d.h.b.o.a(r19, OAppIntentBizContentType.REMOTE_CARD) == false) goto L109;
            Object r21 = EntityExtKt.a().fromJson(r110, new AgentServiceImpl$addMessage$1$2$type$1().getType());     // Catch: Exception -> L124
            d.h.b.o.a(r21, "null cannot be cast to non-null type com.obric.aiagent.assistant.idl.bean.AppIntentMessage");     // Catch: Exception -> L124
            if (d.h.b.o.a(((AppIntentMessage) ZeusTransformUtils.preCheckCast(r21, AppIntentMessage.class, "com.obric.aiagent.plugin")).getDataSource().getIntentName(), "System_AutoAction") == false) goto L109;
            d.m r22 = (d.m) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getMLastRemoteCardMessage$p(r20).get(r0), d.m.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L124
            if (r22 != null) goto L104;
        L107:
            ((Map) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getMLastRemoteCardMessage$p(r20), Map.class, "com.obric.aiagent.plugin")).put(r0, new d.m(r10, d.c.b.a.b.a(System.currentTimeMillis())));     // Catch: Exception -> L124
            goto L109
        L104:
            if ((System.currentTimeMillis() - ((Number) ZeusTransformUtils.preCheckCast(r22.b(), Number.class, "com.obric.aiagent.plugin")).longValue()) >= 50) goto L107;
            ILogDepend.Companion.e(AgentServiceImpl.TAG, "add remote card message < 50ms, ignore!!");     // Catch: Exception -> L124
            return d.x.f38692a;
        L109:
            if (d.h.b.o.a(r19, OAppIntentBizContentType.CLOCK_CARD) == false) goto L111;
        L112:
            com.obric.agent.a.b.a(com.obric.agent.a.b.f14218a, r10, r110, null, 4, null);
        L113:
            IFlowMessageIDL r23 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
            if (r23 == null) goto L123;
            if (r17 == null) goto L117;
            String r111 = r17.a();
        L118:
            if (r17 == null) goto L120;
            String r24 = r17.b();
        L121:
            r23.addMessage(r18, r111, r24);
            goto L123
        L120:
            r24 = r9;
            goto L121
        L117:
            r111 = r9;
        L123:
            return d.x.f38692a;
        L111:
            if (AgentServiceImpl.access$isFirstAlarmEntityContent(r20, r110) == false) goto L113;
        L84:
            IFlowMessageIDL r25 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
            if (r25 == null) goto L88;
            r10 = r25.generateLocalMessageId();
            if (r10 != null) goto L89;
        L88:
            r10 = "";
            goto L89
        L78:
            if (r6.length() == 0) goto L81;
            r8 = r11;
            goto L82
        L72:
            if (d.h.b.o.a(r14, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == false) goto L75;
            if (d.h.b.o.a(this.f14028c, OAppIntentBizContentType.EVENT_TASK_CARD) == false) goto L123;
        L68:
            r14 = r9;
            goto L69
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r39);
            r4 = d.h.b.o.a(this.f14028c, OAppIntentBizContentType.USER_REMIND_CARD);
            IDialogStateManager r112 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
            if (r112 == null) goto L11;
            DMState r113 = r112.getCurrentDMState();
        L12:
            r12 = com.obric.agent.j.f15187a.a(this.f14029d);
            if (r113 == null) goto L32;
            List<State> r114 = r113.getActiveTasks();
            if (r114 == null) goto L32;
            Iterable r115 = (Iterable) ZeusTransformUtils.preCheckCast(r114, Iterable.class, "com.obric.aiagent.plugin");
            String r116 = this.f14029d;
            Collection r26 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r117 = r115.iterator();
        L18:
            if (r117.hasNext() == false) goto L31;
            Object r118 = r117.next();
            TaskId r27 = ((State) ZeusTransformUtils.preCheckCast(r118, State.class, "com.obric.aiagent.plugin")).getTaskId();
            if (r27 == null) goto L26;
            String r28 = r27.getValue();
            if (r28 == null) goto L26;
            Iterator r310 = r117;
            String r119 = r116;
            if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r28, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r116, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) != true) goto L27;
            boolean r29 = true;
        L28:
            if (r29 == false) goto L30;
            r26.add(r118);
        L30:
            r117 = r310;
            r116 = r119;
        L27:
            r29 = false;
        L26:
            r310 = r117;
            r119 = r116;
            goto L27
        L31:
            List r120 = (List) ZeusTransformUtils.preCheckCast(r26, List.class, "com.obric.aiagent.plugin");
        L33:
            if (r120 != null) goto L35;
        L37:
            boolean r121 = false;
        L38:
            if (r121 == false) goto L56;
            Iterator r30 = ((Iterable) ZeusTransformUtils.preCheckCast(r120, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L41:
            if (r30.hasNext() == false) goto L45;
            Object r122 = r30.next();
            r9 = null;
            r11 = false;
            if (d.o.o.b(((State) ZeusTransformUtils.preCheckCast(r122, State.class, "com.obric.aiagent.plugin")).getStateName(), "ComplexTask", false, 2, null) == false) goto L41;
        L46:
            if (r122 == null) goto L48;
            boolean r31 = true;
        L49:
            if (r31 == false) goto L54;
            ILogDepend.Companion.d(AgentServiceImpl.TAG, "addMessage, questionId: " + this.f14029d + ", type: " + this.f14028c + ", hasComplexTask: true");
            IComplexTaskService r32 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
            if (r32 == null) goto L53;
            r32.addComplexTaskExt(this.f14029d);
        L53:
            r14 = IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK;
        L55:
            r13 = true;
            goto L70
        L54:
            r14 = r9;
            goto L55
        L48:
            r31 = r11;
            goto L49
        L45:
            r9 = null;
            r11 = false;
            r122 = null;
            goto L46
        L56:
            r9 = null;
            r11 = false;
            if (r12 != null) goto L63;
            AgentServiceImpl r33 = this.f14030e;
            String r34 = this.f14029d;
            d.c.d r123 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14026a = r4;
            r13 = true;
            this.f14027b = 1;
            r7 = AgentServiceImpl.access$findMessageByMsgId(r33, r34, r123);
            if (r7 != r1) goto L61;
            return r1;
        L61:
            r3 = r4;
            goto L62
        L63:
            r13 = true;
            goto L64
        L35:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r120, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L37;
            r121 = true;
        L32:
            r120 = null;
            goto L33
        L11:
            r113 = null;
            goto L12
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$addMutableMessageForLark$1$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IMMessage f14032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f14033c;

        g(IMMessage r3, d r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14032b = r3;
            this.f14033c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f14032b, this.f14033c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f14031a != 0) goto L17;
            d.o.a(r4);
            IFlowMessageIDL r5 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
            if (r5 == null) goto L15;
            IMMessage r0 = this.f14032b;
            d r1 = this.f14033c;
            String r2 = null;
            if (r1 == null) goto L9;
            String r3 = r1.a();
        L10:
            d r6 = this.f14033c;
            if (r6 == null) goto L13;
            r2 = r6.b();
        L13:
            r5.addMessage(r0, r3, r2);
            goto L15
        L9:
            r3 = null;
        L15:
            return d.x.f38692a;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$checkExtValueSize$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap<String, String> f14035b;

        h(HashMap<String, String> r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14035b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f14035b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f14034a != 0) goto L13;
            d.o.a(r10);
            int r11 = this.f14035b.toString().length();
            List<d.m<String, Integer>> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            Iterator r1 = ((Map) ZeusTransformUtils.preCheckCast(this.f14035b, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            String r5 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin");
            int r4 = ((String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin")).length();
            r0.add(d.s.a(r5, d.c.b.a.b.a(r4)));
            if (r4 <= 500) goto L6;
            ISecureLogDepend.Companion.w(AgentServiceImpl.TAG, "ext value oversized: key=" + r5 + ", size=" + r4);
            com.obric.agent.trace.g r6 = com.obric.agent.trace.g.f15449a;
            d.h.b.o.a(r5);
            r6.a(r5, r4);
            goto L6
        L10:
            ISecureLogDepend.Companion.i(AgentServiceImpl.TAG, "getExtraForSendMessage ext map size=" + this.f14035b.size() + ", total size=" + r11);
            com.obric.agent.trace.g.f15449a.a(r0, r11);
            return d.x.f38692a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {2275}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$getExtraForSendMessage$11")
    static final class i extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<JSONObject> f14058c;

        i(AgentServiceImpl r3, d.h.b.z.f<JSONObject> r4, d.c.d<? super i> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14057b = r3;
            this.f14058c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f14057b, this.f14058c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14056a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            com.obric.agent.u r2 = com.obric.agent.u.f15968a;
            Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AgentServiceImpl.access$getContext(this.f14057b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            JSONObject r4 = (JSONObject) ZeusTransformUtils.preCheckCast(this.f14058c.f38504a, JSONObject.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14056a = 1;
            if (com.obric.agent.u.a(r2, r12, r4, 0, r7, 4, null) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {1987}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$getExtraForSendMessage$4$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f14068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14069c;

        /* JADX INFO: renamed from: com.obric.agent.AgentServiceImpl$j$1, reason: invalid class name */
        /* JADX INFO: compiled from: AgentServiceImpl.kt */
        @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {1989}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$getExtraForSendMessage$4$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f14070a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f14071b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f14072c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ AgentServiceImpl f14073d;

            AnonymousClass1(long r3, AgentServiceImpl r5, d.c.d<? super AnonymousClass1> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f14072c = r3;
                this.f14073d = r5;
                super(2, r7);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f14072c, this.f14073d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0039 -> B:14:0x003c). Please report as a decompilation issue!!! */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r9) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f14071b;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                int r2 = this.f14070a;
                d.o.a(r9);
            L15:
                if ((!((Collection) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getScreenshotInfo$p(this.f14073d), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L19;
                r2 = r2 + 1;
            L10:
                if (r2 >= 21) goto L19;
                long r4 = this.f14072c / ((long) 25);
                d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f14070a = r2;
                this.f14071b = 1;
                if (kotlinx.coroutines.ax.a(r4, r10) != r0) goto L15;
                return r0;
            L19:
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r9);
                r2 = 1;
                goto L10
            }
        }

        j(long r3, AgentServiceImpl r5, d.c.d<? super j> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14068b = r3;
            this.f14069c = r5;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f14068b, this.f14069c, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14067a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r9);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r9);
            d.c.g r10 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");
            d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f14068b, this.f14069c, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14067a = 1;
            if (kotlinx.coroutines.i.a(r10, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$getScreenshot$2")
    static final class k extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super File>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14076c;

        k(AgentServiceImpl r3, String r4, d.c.d<? super k> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14075b = r3;
            this.f14076c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super File> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f14075b, this.f14076c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super File> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f14074a != 0) goto L18;
            d.o.a(r7);
            Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AgentServiceImpl.access$getContext(this.f14075b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L7;
            r8 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        L7:
            File r0 = new File(r8.getCacheDir(), this.f14076c);
            if (r0.exists() == true) goto L10;
        L16:
            return null;
        L10:
            if (r0.isFile() == false) goto L16;
            if (r0.lastModified() >= AgentServiceImpl.access$getActiveTime$p(this.f14075b)) goto L15;
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "getScreenshot stale file, lastModified=" + r0.lastModified() + ", activeTime=" + AgentServiceImpl.access$getActiveTime$p(this.f14075b));
            return null;
        L15:
            return r0;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$getUserRecentMemoryData$2")
    static final class l extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f14079c;

        l(AgentServiceImpl r3, int r4, d.c.d<? super l> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14078b = r3;
            this.f14079c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super String> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f14078b, this.f14079c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super String> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f14077a != 0) goto L7;
            d.o.a(r4);
            return com.obric.memorydata.sdk.a.f33793a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AgentServiceImpl.access$getContext(this.f14078b), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f14079c).getData();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    public static final class m implements com.obric.agent.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f14080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.s f14081b;

        m(long r3, com.obric.agent.s r5) {
            com.obric.agent.s r6 = (com.obric.agent.s) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.agent.s.class, "com.obric.aiagent.plugin");
            this.f14080a = r3;
            this.f14081b = r6;
        }

        @Override // com.obric.agent.f
        public Object a(IntentAppAction r7, JobResult r8, d.c.d<? super d.x> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            if (r7.getQuestionId() != this.f14080a) goto L33;
            ILogDepend.Companion.d(AgentServiceImpl.TAG, "getWebUrl local action finished");
            boolean r11 = true;
            if (r8 == null) goto L11;
            List<IntentExecutionRecord> r2 = r8.getExecRecords();
            if (r2 == null) goto L11;
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L11;
        L12:
            if (r11 == false) goto L29;
            Uri r12 = null;
            if (r8 == null) goto L22;
            List<IntentExecutionRecord> r13 = r8.getExecRecords();
            if (r13 == null) goto L22;
            IntentExecutionRecord r14 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r13.get(0), IntentExecutionRecord.class, "com.obric.aiagent.plugin");
            if (r14 == null) goto L22;
            IntentResult<?> r15 = r14.getResult();
            if (r15 == null) goto L22;
            Object r16 = r15.getEntity();
        L24:
            if (ZeusTransformUtils.instanceOf(r16, Uri.class) == false) goto L26;
            r12 = (Uri) ZeusTransformUtils.preCheckCast(r16, Uri.class, "com.obric.aiagent.plugin");
        L26:
            ILogDepend.Companion.d(AgentServiceImpl.TAG, "getWebUrl: " + r12);
            if (r12 == null) goto L29;
            this.f14081b.a(r12);
        L22:
            r16 = null;
        L29:
            IAppIntentFeedback r17 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
            if (r17 == null) goto L33;
            r17.removeActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(this, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
        L11:
            r11 = false;
        L33:
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {3227}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$handleUpdateIntentResult$1")
    static final class n extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14084c;

        n(AgentServiceImpl r3, String r4, d.c.d<? super n> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14083b = r3;
            this.f14084c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f14083b, this.f14084c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14082a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L11:
            IFlowUiIDL r12 = com.obric.aiagent.assistant.idl.aw.a(d.h.b.aa.b(IFlowUiIDL.class));
            if (r12 == null) goto L14;
            r12.showWindow();
        L14:
            HashMap r13 = new HashMap();
            ((Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.aiagent.plugin")).put("o_not_clear_context", "1");
            IFlowMessageIDL r4 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
            if (r4 == null) goto L22;
            IMMessage r2 = AgentServiceImpl.access$getLastSentMessage$p(this.f14083b);
            if (r2 == null) goto L19;
            String r3 = r2.getConversationId();
        L20:
            r4.sendMessageWithExtra(r3, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_privacy_statement_agreed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_privacy_statement_agreed")), "handleUpdateIntentResult#" + this.f14084c, "card", (Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.aiagent.plugin"));
            goto L22
        L19:
            r3 = null;
        L22:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            d.c.d r14 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14082a = 1;
            if (kotlinx.coroutines.ax.a(1000, r14) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$init$3")
    static final class o extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f14086b;

        o(int r3, d.c.d<? super o> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14086b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f14086b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f14085a != 0) goto L7;
            d.o.a(r4);
            MemoryDataServiceProxy.f33905a.bindService((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f14086b);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {687, 689, 699, 703, 706}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$init$6")
    static final class p extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f14089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14090d;

        /* JADX INFO: renamed from: com.obric.agent.AgentServiceImpl$p$1, reason: invalid class name */
        /* JADX INFO: compiled from: AgentServiceImpl.kt */
        @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {704}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$init$6$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f14091a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AgentServiceImpl f14092b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.eventkit.task.model.a f14093c;

            AnonymousClass1(AgentServiceImpl r3, com.obric.eventkit.task.model.a r4, d.c.d<? super AnonymousClass1> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f14092b = r3;
                this.f14093c = r4;
                super(2, r6);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f14092b, this.f14093c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0030 -> B:12:0x0033). Please report as a decompilation issue!!! */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f14091a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r5);
            L13:
                if (d.h.b.o.a(r5, this.f14093c.b()) == true) goto L15;
            L9:
                kotlinx.coroutines.a.d r6 = AgentServiceImpl.access$getConditionTaskSendResultChannel$p(this.f14092b);
                d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f14091a = 1;
                r5 = r6.a(r2);
                if (r5 != r0) goto L13;
                return r0;
            L15:
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r5);
                goto L9
            }
        }

        p(AgentServiceImpl r3, d.c.d<? super p> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14090d = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((p) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), p.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new p(this.f14090d, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x01bf -> B:58:0x01c2). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r20) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f14089c;
            if (r2 == 0) goto L16;
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L14;
            if (r2 == 3) goto L13;
            if (r2 == 4) goto L12;
            if (r2 != 5) goto L11;
            kotlinx.coroutines.a.f r3 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(this.f14087a, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
            d.o.a(r20);
            char r12 = 5;
        L17:
            d.c.d<? super Boolean> r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14087a = r3;
            this.f14089c = 1;
            Object r11 = r3.a(r10);
            if (r11 != r1) goto L21;
            return r1;
        L21:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L60;
            com.obric.eventkit.task.model.a r13 = (com.obric.eventkit.task.model.a) ZeusTransformUtils.preCheckCast(r3.a(), com.obric.eventkit.task.model.a.class, "com.obric.aiagent.plugin");
            com.obric.agent.trace.q.f15713a.a(String.valueOf(r13.b()), true);
            ITaskManagerApi r14 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
            if (r14 == null) goto L27;
            d.c.d<? super d.x> r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14087a = r3;
            this.f14088b = r13;
            this.f14089c = 2;
            if (r14.tryRecoverFromSleepMode("scheduleConditionTask", 10, r15) != r1) goto L27;
            return r1;
        L27:
            kotlinx.coroutines.a.f r16 = r3;
            com.obric.eventkit.task.model.a r4 = r13;
        L28:
            IFlowMessageIDL r17 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
            if (r17 == null) goto L34;
            String r18 = r4.c();
            if (r18 != null) goto L33;
            r18 = " ";
        L33:
            String r19 = r18;
            com.obric.agent.utils.o r110 = com.obric.agent.utils.o.f16054a;
            String r111 = com.obric.capabilitykit.common.a.a().toJson(r4);
            d.h.b.o.c(r111, "toJson(...)");
            r17.sendMessageWithExtra(null, r19, "obric_conditional_task", "obric_conditional_task", com.obric.agent.utils.o.a(r110, r111, null, 2, null));
        L34:
            IFlowSettingsIDL r5 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));
            boolean r112 = false;
            if (r5 == null) goto L37;
            int r6 = r5.getAutoGuiEnabledScene();
        L38:
            if (r6 == 2) goto L51;
            IFlowAppStateIDL r7 = com.obric.aiagent.assistant.idl.s.a(d.h.b.aa.b(IFlowAppStateIDL.class));
            if (r7 != null) goto L42;
        L44:
            if (r112 == false) goto L51;
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14087a = r16;
            this.f14088b = r4;
            this.f14089c = 3;
            if (kotlinx.coroutines.ax.a(100, r8) != r1) goto L48;
            return r1;
        L48:
            IFlowUiIDL r9 = com.obric.aiagent.assistant.idl.aw.a(d.h.b.aa.b(IFlowUiIDL.class));
            if (r9 == null) goto L51;
            r9.openChatActivity(com.obric.agent.h.f14566c.ordinal());
            goto L51
        L42:
            if (r7.isAppBackground() != true) goto L44;
            r112 = true;
        L51:
            d.h.a.m r21 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f14090d, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r22 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14087a = r16;
            this.f14088b = null;
            this.f14089c = 4;
            if (dg.b(AgentServiceImpl.CONDITION_TASK_SEND_TIMEOUT_MILLIS, r21, r22) != r1) goto L54;
            return r1;
        L54:
            r3 = r16;
        L55:
            d.c.d r23 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14087a = r3;
            r12 = 5;
            this.f14089c = 5;
            if (kotlinx.coroutines.ax.a(1000, r23) != r1) goto L17;
            return r1;
        L37:
            r6 = 0;
            goto L38
        L60:
            return d.x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            r3 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(this.f14087a, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
            d.o.a(r20);
            goto L55
        L13:
            r4 = (com.obric.eventkit.task.model.a) ZeusTransformUtils.preCheckCast(this.f14088b, com.obric.eventkit.task.model.a.class, "com.obric.aiagent.plugin");
            r16 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(this.f14087a, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
            d.o.a(r20);
            goto L48
        L14:
            r4 = (com.obric.eventkit.task.model.a) ZeusTransformUtils.preCheckCast(this.f14088b, com.obric.eventkit.task.model.a.class, "com.obric.aiagent.plugin");
            r16 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(this.f14087a, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
            d.o.a(r20);
            goto L28
        L15:
            r3 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(this.f14087a, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
            d.o.a(r20);
            r11 = r20;
            goto L21
        L16:
            d.o.a(r20);
            r3 = AgentServiceImpl.access$getConditionTaskChannel$p(this.f14090d).g();
            goto L17
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {2792}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$isQueryTimeout$localMsgId$1")
    static final class q extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14095b;

        q(String r3, d.c.d<? super q> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14095b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super String> r4) {
            return ((q) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new q(this.f14095b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super String> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14094a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.agent.trace.q r7 = com.obric.agent.trace.q.f15713a;
            String r2 = this.f14095b;
            d.c.d<? super String> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14094a = 1;
            r6 = r7.e(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    public static final class r implements com.obric.agent.im.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14096a;

        @Override // com.obric.agent.im.d
        public void onRegenMessage(IMMessage r1) {
            d.h.b.o.e(r1, "message");
        }

        r(AgentServiceImpl r1) {
            this.f14096a = r1;
        }

        @Override // com.obric.agent.im.d
        public void onInsertMessageList(List<IMMessage> r3) {
            com.obric.agent.im.d.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.agent.im.d
        public void onSendMessage(IMMessage r21) {
            d.h.b.o.e(r21, "message");
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "onSendMessage " + r21.getLocalMessageId() + ", " + r21.getMessageStatusLocal() + ", " + r21.getMessageId());
            boolean r6 = true;
            if (r21.getUserType() != 1) goto L52;
            if (r21.getMessageStatusLocal() != 11) goto L52;
            Map<String, String> r2 = r21.getExt();
            if (r2 == null) goto L16;
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2.get(AgentServiceImpl.COLLECTION_ID), String.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L16;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L13;
            boolean r11 = true;
        L14:
            if (r11 == false) goto L16;
        L17:
            IMMessage r12 = AgentServiceImpl.access$getLastSentMessage$p(this.f14096a);
            if (r12 == null) goto L29;
            Map<String, String> r13 = r12.getExt();
            if (r13 == null) goto L29;
            String r10 = (String) ZeusTransformUtils.preCheckCast(r13.get(AgentServiceImpl.COLLECTION_ID), String.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L29;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L27;
            r6 = false;
        L27:
            if (r6 == false) goto L29;
        L30:
            if (r3 != null) goto L32;
        L33:
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "onSendMessage new round, clear lastSentRoundMessageIds, collectionId=" + r3 + ", lastCollectionId=" + r10);
            if (com.obric.agent.w.a(r21.getMessageId()) == false) goto L41;
            Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getLastSentRoundMessageIds$p(this.f14096a), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L37:
            if (r7.hasNext() == false) goto L41;
            String r14 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
            IIntentMetricsService r9 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L37;
            d.h.b.o.a(r14);
            r9.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.f(r14, "merged_to_next_query", "on_send_message_new_round", false, r21.getMessageId(), null, 32, null), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
        L41:
            AgentServiceImpl.access$getLastSentRoundMessageIds$p(this.f14096a).clear();
            AgentServiceImpl.access$getOpenedClickTalkReplyIds$p(this.f14096a).clear();
            AgentServiceImpl.access$getStreamObservers$p(this.f14096a).clear();
            AgentServiceImpl.access$getTtsStateListeners$p(this.f14096a).clear();
            AgentServiceImpl.access$clearOpenMicSignalCache(this.f14096a);
            IJobManagerApi r8 = (IJobManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJobManagerApi.class), IJobManagerApi.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L44;
            r8.cancelAppFunctionPrivacyWatch();
        L44:
            String r15 = r21.getMessageId();
            if (com.obric.agent.w.a(r15) == true) goto L48;
            r15 = null;
        L48:
            if (r15 == null) goto L50;
            AgentServiceImpl.access$getLastSentRoundMessageIds$p(this.f14096a).add(r15);
        L50:
            AgentServiceImpl.access$setLastSentMessage$p(this.f14096a, r21);
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "onSendMessage update lastSentMessage messageId=" + r21.getMessageId() + ", collectionId=" + r3 + ", roundIds=" + AgentServiceImpl.access$getLastSentRoundMessageIds$p(this.f14096a));
            goto L52
        L32:
            if (d.h.b.o.a(r3, r10) == true) goto L44;
        L29:
            r10 = null;
            goto L30
        L13:
            r11 = false;
        L16:
            r3 = null;
        L52:
            if (r21.getMessageStatusLocal() != 13) goto L55;
            com.obric.agent.trace.q.f15713a.b(r21.getLocalMessageId(), r21.getExt());
            AgentServiceImpl.access$notifyEventTaskScheduleInterrupted(this.f14096a, r21);
        L55:
            if (r21.getMessageStatusLocal() != 12) goto L58;
            AgentServiceImpl.access$notifyEventTaskScheduleFailed(this.f14096a, r21);
        L58:
            if (r21.getMessageStatusLocal() != 11) goto L77;
            String r4 = com.obric.agent.im.b.a(r21);
            if (r4 == null) goto L62;
            com.obric.agent.trace.q.f15713a.a(r21.getLocalMessageId(), r4);
        L62:
            String r16 = r21.getMessageId();
            AgentServiceImpl r5 = this.f14096a;
            Uri r17 = (Uri) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getQueryAudioFilesByLocalMsgId$p(r5).get(r21.getLocalMessageId()), Uri.class, "com.obric.aiagent.plugin");
            if (r17 == null) goto L65;
            ((Map) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getQueryAudioFilesByMsgId$p(r5), Map.class, "com.obric.aiagent.plugin")).put(r16, r17);
        L65:
            ((Map) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getQueryMessageIdAndLocalMsg$p(r5), Map.class, "com.obric.aiagent.plugin")).put(r21.getLocalMessageId(), r16);
            Map<String, String> r18 = r21.getExt();
            if (r18 == null) goto L68;
            String r19 = (String) ZeusTransformUtils.preCheckCast(r18.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
        L69:
            com.obric.agent.trace.q.f15713a.b(r21.getLocalMessageId(), r16, r19);
            IIntentMetricsService r20 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");
            if (r20 == null) goto L72;
            r20.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.d(r16, r21.getLocalMessageId(), AgentServiceImpl.access$resolveQueryCallScene(r5, r21.getExt()), AgentServiceImpl.access$isOmniTask(r5, r21.getExt()), AgentServiceImpl.access$isContinuousTalk(r5, r21.getExt())), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
        L72:
            AgentServiceImpl.access$notifyEventTaskScheduleSent(r5, r21);
            com.obric.agent.trace.g r22 = com.obric.agent.trace.g.f15449a;
            Map<String, String> r23 = r21.getExt();
            if (r23 == null) goto L75;
            String r24 = (String) ZeusTransformUtils.preCheckCast(r23.get("o_event_task"), String.class, "com.obric.aiagent.plugin");
        L76:
            r22.a(r24);
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "onSendMessage success " + r21.getLocalMessageId() + ", " + r21.getMessageId());
            goto L77
        L75:
            r24 = null;
            goto L76
        L68:
            r19 = null;
        L77:
            AgentServiceImpl.access$notifyConditionTaskSendTerminal(this.f14096a, r21);
        }

        @Override // com.obric.agent.im.d
        public void onReceiveMessage(IMMessage r22) {
            d.h.b.o.e(r22, "message");
            String r5 = ", ";
            ILogDepend.Companion.i(AgentServiceImpl.TAG, new StringBuilder().append("onReceiveMessage ").append(r22.getLocalMessageId()).append(", ").append(r22.getReplyId()).append(", ").append(r22.getMessageStatusLocal()).toString());
            String r2 = r22.getReplyId();
            if (r2 != null) goto L5;
            return;
        L5:
            boolean r15 = true;
            if (r22.getMessageStatus() != com.obric.agent.im.c.f14586c.f14589b) goto L8;
            boolean r3 = true;
        L10:
            if (r22.getMessageStatusLocal() != 20) goto L28;
            if (AgentServiceImpl.access$isLastSentRound(this.f14096a, r2) == false) goto L17;
            IIntentMetricsService r4 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L16;
            r4.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.a(r2), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
        L16:
            r15 = true;
        L26:
            AgentServiceImpl.access$onServerReply(this.f14096a, r2, com.obric.agent.im.b.a(r22), r22.getExt(), r15);
            r5 = ", ";
        L62:
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "onReceiveMessage " + r22.getLocalMessageId() + r5 + r22.getReplyId());
            AgentServiceImpl.access$tryOpenClickTalkIfNeeded(this.f14096a, r22);
            return;
        L17:
            IIntentMetricsService r6 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L25;
            IMMessage r7 = AgentServiceImpl.access$getLastSentMessage$p(this.f14096a);
            if (r7 == null) goto L22;
            String r12 = r7.getMessageId();
        L23:
            r6.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.f(r2, "merged_to_next_query", "stale_update_skip", false, r12, null, 32, null), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
            goto L25
        L22:
            r12 = null;
        L25:
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "skip metrics first token for stale receive replyId=" + r2);
            goto L26
        L28:
            if (r22.getMessageStatusLocal() != 21) goto L46;
            if (r3 == false) goto L46;
            if (AgentServiceImpl.access$isLastSentRound(this.f14096a, r2) == false) goto L36;
            IIntentMetricsService r1 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L35;
            r1.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.e(r2), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
        L35:
            r5 = ", ";
        L45:
            AgentServiceImpl.access$onServerReply(this.f14096a, r2, com.obric.agent.im.b.a(r22), r22.getExt(), false);
            goto L62
        L36:
            IIntentMetricsService r8 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L44;
            IMMessage r9 = AgentServiceImpl.access$getLastSentMessage$p(this.f14096a);
            if (r9 == null) goto L41;
            String r13 = r9.getMessageId();
        L42:
            r8.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.f(r2, "merged_to_next_query", "stale_update_skip", false, r13, null, 32, null), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
            goto L44
        L41:
            r13 = null;
        L44:
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "skip metrics screen finish for stale receive replyId=" + r2);
        L46:
            r5 = ", ";
            if (r22.getMessageStatusLocal() != 23) goto L49;
        L50:
            IIntentMetricsService r10 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");
            if (r10 != null) goto L53;
        L61:
            com.obric.agent.trace.q.f15713a.b(r22.getLocalMessageId(), r22.getExt());
            goto L62
        L53:
            if (r22.getMessageStatusLocal() != 22) goto L55;
            String r11 = "receive_failed";
        L57:
            if (r22.getMessageStatusLocal() != 22) goto L59;
            String r14 = "receive_failed";
        L60:
            r10.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.f(r2, r11, r14, false, null, null, 48, null), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
            goto L61
        L59:
            r14 = "receive_interrupt";
            goto L60
        L55:
            r11 = "interrupted";
            goto L57
        L49:
            if (r22.getMessageStatusLocal() != 22) goto L62;
        L8:
            r3 = false;
            goto L10
        }

        @Override // com.obric.agent.im.d
        public void onUpdateMessage(IMMessage r18) {
            d.h.b.o.e(r18, "message");
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "onUpdateMessage " + r18.getLocalMessageId() + ", " + r18.getReplyId() + ", " + r18.getMessageStatusLocal());
            if (r18.getMessageStatus() != com.obric.agent.im.c.f14586c.f14589b) goto L5;
            boolean r2 = true;
        L7:
            if (r18.getMessageStatusLocal() != 21) goto L26;
            if (r2 == false) goto L26;
            String r3 = r18.getReplyId();
            if (r3 == null) goto L24;
            AgentServiceImpl r4 = this.f14096a;
            if (AgentServiceImpl.access$isLastSentRound(r4, r3) == false) goto L16;
            IIntentMetricsService r5 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L24;
            r5.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.e(r3), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
            goto L24
        L16:
            IIntentMetricsService r6 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L23;
            IMMessage r7 = AgentServiceImpl.access$getLastSentMessage$p(r4);
            if (r7 == null) goto L21;
            String r8 = r7.getMessageId();
        L22:
            r6.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.f(r3, "merged_to_next_query", "stale_update_skip", false, r8, null, 32, null), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
            goto L23
        L21:
            r8 = null;
        L23:
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "skip metrics screen finish for stale update replyId=" + r3);
        L24:
            AgentServiceImpl.access$onServerReply(this.f14096a, r18.getReplyId(), com.obric.agent.im.b.a(r18), r18.getExt(), false);
        L48:
            AgentServiceImpl.access$tryOpenClickTalkIfNeeded(this.f14096a, r18);
            return;
        L26:
            if (r18.getMessageStatusLocal() != 13) goto L28;
        L31:
            String r9 = r18.getReplyId();
            if (r9 == null) goto L47;
            IIntentMetricsService r10 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L47;
            if (r18.getMessageStatusLocal() != 22) goto L38;
            String r11 = "receive_failed";
        L39:
            int r12 = r18.getMessageStatusLocal();
            if (r12 == 13) goto L44;
            if (r12 == 22) goto L43;
            String r13 = "receive_interrupt";
        L45:
            String r14 = r13;
        L46:
            r10.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.f(r9, r11, r14, false, null, null, 48, null), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
            goto L47
        L43:
            r14 = "receive_failed";
            goto L46
        L44:
            r13 = "send_interrupt";
            goto L45
        L38:
            r11 = "interrupted";
        L47:
            com.obric.agent.trace.q.f15713a.b(r18.getLocalMessageId(), r18.getExt());
            goto L48
        L28:
            if (r18.getMessageStatusLocal() == 23) goto L31;
            if (r18.getMessageStatusLocal() != 22) goto L48;
        L5:
            r2 = false;
            goto L7
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {3692}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$notifyLarkSendStatusChanged$1")
    static final class s extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f14099c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f14100d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14101e;
        final /* synthetic */ String f;
        final /* synthetic */ int g;

        s(AgentServiceImpl r3, String r4, int r5, d.c.d<? super s> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14101e = r3;
            this.f = r4;
            this.g = r5;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((s) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), s.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new s(this.f14101e, this.f, this.g, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14100d;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            int r2 = this.f14099c;
            Iterator r4 = (Iterator) ZeusTransformUtils.preCheckCast(this.f14098b, Iterator.class, "com.obric.aiagent.plugin");
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f14097a, String.class, "com.obric.aiagent.plugin");
            d.o.a(r8);
        L10:
            if (r4.hasNext() == false) goto L15;
            com.obric.agent.p r9 = (com.obric.agent.p) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.agent.p.class, "com.obric.aiagent.plugin");
            this.f14097a = r5;
            this.f14098b = r4;
            this.f14099c = r2;
            this.f14100d = 1;
            if (r9.a(r5, r2, this) != r0) goto L10;
            return r0;
        L15:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getLarkSendCardListeners$p(this.f14101e), Iterable.class, "com.obric.aiagent.plugin");
            String r3 = this.f;
            int r6 = this.g;
            r5 = r3;
            r2 = r6;
            r4 = r10.iterator();
            goto L10
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {723}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$notifyMemoryForPreload$1")
    static final class t extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14103b;

        t(AgentServiceImpl r3, d.c.d<? super t> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14103b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((t) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new t(this.f14103b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14102a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            if (AgentServiceImpl.access$getMainBotChatPageResume$p(this.f14103b) == false) goto L15;
            AgentServiceImpl.access$notifyMemoryForPreload(this.f14103b);
        L15:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14102a = 1;
            if (kotlinx.coroutines.ax.a(50000, r7) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$onAsrEnd$1")
    static final class u extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14105b;

        u(AgentServiceImpl r3, d.c.d<? super u> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14105b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((u) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), u.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new u(this.f14105b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f14104a != 0) goto L7;
            d.o.a(r2);
            AgentServiceImpl.access$setMAsrLocalMsgId$p(this.f14105b, "");
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$onAsrStart$1")
    static final class v extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14112b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14113c;

        v(String r3, AgentServiceImpl r4, d.c.d<? super v> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14112b = r3;
            this.f14113c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((v) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), v.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new v(this.f14112b, this.f14113c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f14111a != 0) goto L10;
            d.o.a(r2);
            String r3 = this.f14112b;
            if (r3 == null) goto L8;
            AgentServiceImpl.access$setMAsrLocalMsgId$p(this.f14113c, r3);
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {904}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$onAssistantShow$1")
    static final class w extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bundle f14116c;

        /* JADX INFO: renamed from: com.obric.agent.AgentServiceImpl$w$1, reason: invalid class name */
        /* JADX INFO: compiled from: AgentServiceImpl.kt */
        @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$onAssistantShow$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f14117a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AgentServiceImpl f14118b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Map<String, String> f14119c;

            AnonymousClass1(AgentServiceImpl r3, Map<String, String> r4, d.c.d<? super AnonymousClass1> r5) {
                Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f14118b = r3;
                this.f14119c = r6;
                super(2, r7);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f14118b, this.f14119c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                d.c.a.b.a();
                if (this.f14117a != 0) goto L16;
                d.o.a(r7);
                Set r8 = AgentServiceImpl.access$getSemanticUsedUpdateImageInfo$p(this.f14118b).keySet();
                d.h.b.o.c(r8, "<get-keys>(...)");
                List r9 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin"));
                IFlowMessageIDL r0 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
                if (r0 == null) goto L14;
                Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f14119c.values(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
                Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
                Iterator r10 = r6.iterator();
            L8:
                if (r10.hasNext() == false) goto L12;
                Object r3 = r10.next();
                String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
                if (d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin"), r4) == true) goto L8;
                r2.add(r3);
                goto L8
            L12:
                r0.deleteRemoteResource((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"));
            L14:
                return d.x.f38692a;
            L16:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: AgentServiceImpl.kt */
        public static final class a implements com.obric.agent.t {
            a() {
            }

            @Override // com.obric.agent.t
            public void a(Uri r3) {
                d.h.b.o.e(r3, "uri");
                ILogDepend.Companion.i(AgentServiceImpl.TAG, "onReceivedScreenshotUri " + r3);
            }

            @Override // com.obric.agent.t
            public void a(String r3) {
                d.h.b.o.e(r3, WsConstants.KEY_CONNECTION_ERROR);
                ILogDepend.Companion.i(AgentServiceImpl.TAG, "onScreenshotError " + r3);
            }
        }

        w(AgentServiceImpl r3, Bundle r4, d.c.d<? super w> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14115b = r3;
            this.f14116c = r4;
            super(2, r6);
        }

        public static /* synthetic */ boolean lambda$fjMFli92nUkJEviCpgnaSuaP8Ks(AgentServiceImpl r0, ComponentName r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ boolean lambda$r4NYe8mKDQ4EkB95oZooKtnWKOQ(d.h.a.b r0, Object r1) {
            return a(r0, r1);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((w) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), w.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new w(this.f14115b, this.f14116c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14114a;
            List r3 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L33:
            r3 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
        L34:
            if (r3 != null) goto L36;
            r3 = d.a.p.b();
        L36:
            AgentServiceImpl r10 = this.f14115b;
            monitor-enter(r10);
            AgentServiceImpl.access$setShortCutTasks$p(r10, r3);     // Catch: Throwable -> L42
            ISecureLogDepend.Companion.i(AgentServiceImpl.TAG, "update ShortInstructShortcutTasks " + AgentServiceImpl.access$getShortCutTasks$p(r10));     // Catch: Throwable -> L42
            d.x r12 = d.x.f38692a;     // Catch: Throwable -> L42
            monitor-exit(r10);
            new a();
            return d.x.f38692a;
        L42:
            th = move-exception;
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "onAssistantShow");
            FindPhoneActivity.Companion.a();
            AgentServiceImpl.access$setActiveTime$p(this.f14115b, System.currentTimeMillis());
            AgentServiceImpl.access$getVisibleActivities$p(this.f14115b).clear();
            AgentServiceImpl.access$setMRealTimeContext$p(this.f14115b, RealTimeContext.Companion.a());
            AgentServiceImpl.access$setChatWindow$p(this.f14115b, false);
            AgentServiceImpl.access$setChatWindowState$p(this.f14115b, com.obric.agent.h.f14564a.ordinal());
            AgentServiceImpl.access$setAssistStructure$p(this.f14115b, null);
            AgentServiceImpl.access$setAssistContent$p(this.f14115b, null);
            AgentServiceImpl.access$setScreenshot$p(this.f14115b, null);
            AgentServiceImpl.access$setAssistHanlded$p(this.f14115b, false);
            AgentServiceImpl.access$setFirstQuery$p(this.f14115b, true);
            AgentServiceImpl.access$setRealtimeCollectionId$p(this.f14115b, null);
            AgentServiceImpl.access$getLastSentRoundMessageIds$p(this.f14115b).clear();
            AgentServiceImpl.access$setActiveRound$p(this.f14115b, UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE);
            AgentServiceImpl.access$getScreenshotInfo$p(this.f14115b).clear();
            AgentServiceImpl.access$getRealtimeImgInfo$p(this.f14115b).clear();
            AgentServiceImpl.access$setCacheScreenshotUri$p(this.f14115b, null);
            AgentServiceImpl.access$setCacheAssistImgUri$p(this.f14115b, null);
            AgentServiceImpl.access$setSkipWaitForScreenShot$p(this.f14115b, false);
            AgentServiceImpl.access$setScreenshotUploadFailed$p(this.f14115b, false);
            AgentServiceImpl.access$clearScreenshotUploading(this.f14115b);
            Map r13 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            r13.putAll((Map) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getUnUsedUpdateImageInfo$p(this.f14115b), Map.class, "com.obric.aiagent.plugin"));
            if ((!((Map) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getUnUsedUpdateImageInfo$p(this.f14115b), Map.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L11;
            kotlinx.coroutines.i.a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(bs.f39169a, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f14115b, r13, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        L11:
            AgentServiceImpl.access$getUnUsedUpdateImageInfo$p(this.f14115b).clear();
            AgentServiceImpl.access$getUploadingScreenshotInfo$p(this.f14115b).clear();
            AgentServiceImpl.access$getUploadingRealTimeImagInfo$p(this.f14115b).clear();
            Bundle r14 = this.f14116c;
            if (r14 == null) goto L17;
            ArrayList r15 = (ArrayList) ZeusTransformUtils.preCheckCast(r14.getParcelable("android.service.voice.FOREGROUND_ACTIVITIES", new ArrayList().getClass()), ArrayList.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L17;
            d.c.b.a.b.a(AgentServiceImpl.access$getVisibleActivities$p(this.f14115b).addAll((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")));
        L17:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getVisibleActivities$p(this.f14115b), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L25;
            LinkedHashSet r16 = AgentServiceImpl.access$getVisibleActivities$p(this.f14115b);
            final AgentServiceImpl r2 = this.f14115b;
            final d.h.a.b r4 = new $$Lambda$AgentServiceImpl$w$fjMFli92nUkJEviCpgnaSuaP8Ks(r2);
            r16.removeIf(new $$Lambda$AgentServiceImpl$w$r4NYe8mKDQ4EkB95oZooKtnWKOQ(r4));
            Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getVisibleActivities$p(this.f14115b), Iterable.class, "com.obric.aiagent.plugin");
            AgentServiceImpl r5 = this.f14115b;
            Iterator r18 = r17.iterator();
        L20:
            if (r18.hasNext() == false) goto L25;
            if (((ComponentName) ZeusTransformUtils.preCheckCast(r18.next(), ComponentName.class, "com.obric.aiagent.plugin")).getClassName().equals(AgentServiceImpl.access$getSS_WEB_CLASS$p(r5)) == false) goto L20;
            ILogDepend.Companion.i(AgentServiceImpl.TAG, "getWebUrl");
            r5.getWebUrl(r5.getUrlCallback());
        L25:
            if (AgentServiceImpl.access$isNeedRealtimeContext(this.f14115b) == false) goto L27;
            AgentServiceImpl.access$setFocusedWindowSecure$p(this.f14115b, ObricProductSdk.INSTANCE.platformService().windowManager().focusedWindowIsSecure());
            AssistantStateServiceProxy.f33799a.a();
            ITaskManagerApi r19 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
            if (r19 == null) goto L34;
            d.c.d<? super List<ShortcutTask>> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14114a = 1;
            r11 = r19.getEnableShortInstructShortcutTasks(r6);
            if (r11 != r0) goto L33;
            return r0;
        L27:
            return d.x.f38692a;
        }

        private static final boolean a(d.h.a.b r2, Object r3) {
            return ((Boolean) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        }

        private static final boolean a(AgentServiceImpl r0, ComponentName r1) {
            return d.h.b.o.a(r1.getClassName(), AgentServiceImpl.access$getCHAT_CLASS$p(r0));
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$onFlowUnbind$1")
    static final class x extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14121b;

        x(AgentServiceImpl r3, d.c.d<? super x> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14121b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((x) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), x.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new x(this.f14121b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f14120a != 0) goto L7;
            d.o.a(r2);
            AgentServiceImpl.access$setMainBotChatPageResume$p(this.f14121b, false);
            AgentServiceImpl.access$setChatWindowState$p(this.f14121b, com.obric.agent.h.f14564a.ordinal());
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$onHandleAssist$1")
    static final class y extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AssistStructure f14124c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AssistContent f14125d;

        y(AgentServiceImpl r3, AssistStructure r4, AssistContent r5, d.c.d<? super y> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14123b = r3;
            this.f14124c = r4;
            this.f14125d = r5;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((y) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), y.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new y(this.f14123b, this.f14124c, this.f14125d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f14122a != 0) goto L7;
            d.o.a(r2);
            AgentServiceImpl.access$handleAssistInternal(this.f14123b, this.f14124c, this.f14125d);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentServiceImpl.kt */
    @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$onHandleScreenshot$1")
    static final class z extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentServiceImpl f14127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bitmap f14128c;

        /* JADX INFO: compiled from: AgentServiceImpl.kt */
        @d.c.b.a.f(b = "AgentServiceImpl.kt", c = {1479}, d = "invokeSuspend", e = "com.obric.agent.AgentServiceImpl$onHandleScreenshot$1$1$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f14129a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AgentServiceImpl f14130b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bitmap f14131c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bitmap f14132d;

            /* JADX INFO: renamed from: com.obric.agent.AgentServiceImpl$z$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: AgentServiceImpl.kt */
            public static final class C0282a implements com.obric.agent.l {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f14133a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ AgentServiceImpl f14134b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ Bitmap f14135c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f14136d;

                C0282a(int r1, AgentServiceImpl r2, Bitmap r3, long r4) {
                    this.f14133a = r1;
                    this.f14134b = r2;
                    this.f14135c = r3;
                    this.f14136d = r4;
                }

                @Override // com.obric.agent.l
                public void a(boolean r17, String r18, String r19, String r20, String r21) {
                    ILogDepend.Companion.i(AgentServiceImpl.TAG, "onHandleScreenshot called, uploadImageIfNeeded onResult, success:" + r17 + ", tosKey:" + r18 + ", resId:" + r19);
                    JSONObject r9 = new JSONObject();
                    boolean r11 = true;
                    if (r17 == false) goto L22;
                    if (r18 != null) goto L6;
                    long r3 = 0;
                L23:
                    r11 = false;
                    long r1 = r3;
                L25:
                    if (this.f14133a != AgentServiceImpl.access$getActiveRound$p(this.f14134b)) goto L27;
                    AgentServiceImpl.access$clearScreenshotUploading(this.f14134b);
                    AgentServiceImpl.access$setScreenshotUploadFailed$p(this.f14134b, !r11);
                L27:
                    r9.put("upload_result", r11);
                    r9.put("time_cost", r1);
                    r9.put("upload_failed_code", r20);
                    r9.put("upload_failed_msg", r21);
                    IAppLog r0 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
                    if (r0 == null) goto L31;
                    r0.reportToFlow("o_screenshot_upload", r9);
                    return;
                L31:
                    return;
                L6:
                    if (this.f14133a != AgentServiceImpl.access$getActiveRound$p(this.f14134b)) goto L20;
                    AgentServiceImpl.access$getScreenshotInfo$p(this.f14134b).add(new PicInfo(r18, Integer.valueOf(this.f14135c.getWidth()), Integer.valueOf(this.f14135c.getHeight()), r19, Long.valueOf(System.currentTimeMillis())));
                    if (AgentServiceImpl.access$getAsrIng$p(this.f14134b) == false) goto L20;
                    IFlowVoiceInteractionIDL r2 = com.obric.aiagent.assistant.idl.ax.a(d.h.b.aa.b(IFlowVoiceInteractionIDL.class));
                    if (r2 == null) goto L12;
                    r2.updateScreenshotForAsr(r18);
                L12:
                    ILogDepend.Companion.i(AgentServiceImpl.TAG, "onHandleScreenshot called, whether do updateIntentExt? " + (!AgentServiceImpl.access$getFirstQuery$p(this.f14134b)));
                    if (AgentServiceImpl.access$getFirstQuery$p(this.f14134b) == true) goto L17;
                    IFlowVoiceInteractionIDL r4 = com.obric.aiagent.assistant.idl.ax.a(d.h.b.aa.b(IFlowVoiceInteractionIDL.class));
                    if (r4 == null) goto L17;
                    r4.updateIntentExt(this.f14134b.getExtraForSendMessage(d.a.ao.b(), "", true));
                L17:
                    JSONObject r5 = new JSONObject();
                    r5.put("screenshotInfo", 1);
                    IAppLog r6 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
                    if (r6 == null) goto L20;
                    r6.reportToFlow("o_asr_pc", r5);
                L20:
                    r1 = System.currentTimeMillis() - this.f14136d;
                    ILogDepend.Companion.d(AgentServiceImpl.TAG, "imageXUpload screenshot success " + r18 + ", time cost: " + r1);
                    goto L25
                L22:
                    r3 = System.currentTimeMillis() - this.f14136d;
                    ILogDepend.Companion.e(AgentServiceImpl.TAG, "imageXUpload screenshot failed, time cost: " + r3);
                    goto L23
                }
            }

            a(AgentServiceImpl r3, Bitmap r4, Bitmap r5, d.c.d<? super a> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f14130b = r3;
                this.f14131c = r4;
                this.f14132d = r5;
                super(2, r7);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f14130b, this.f14131c, this.f14132d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r13) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f14129a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r13);
            L11:
                File r14 = (File) ZeusTransformUtils.preCheckCast(r13, File.class, "com.obric.aiagent.plugin");
                if (r14 == null) goto L41;
                AgentServiceImpl r2 = this.f14130b;
                Bitmap r7 = this.f14132d;
                Uri r12 = Uri.fromFile(r14);
                d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L25
                IFlowSettingsIDL r4 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));     // Catch: Throwable -> L25
                if (r4 != null) goto L17;
            L19:
                boolean r5 = false;
            L20:
                if (r5 == true) goto L22;
                boolean r6 = true;
            L23:
                Object r8 = d.n.f(d.c.b.a.b.a(r6));     // Catch: Throwable -> L25
            L27:
                Boolean r9 = d.c.b.a.b.a(true);
                if (d.n.b(r8) == false) goto L31;
                r8 = r9;
            L31:
                if (((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L34;
                AgentServiceImpl.access$setCacheScreenshotUri$p(r2, r12.toString());
                ISecureLogDepend.Companion.i(AgentServiceImpl.TAG, "auto image upload disabled, cache screenshot uri: " + r12);
                return d.x.f38692a;
            L34:
                AgentServiceImpl.access$setScreenshotUploadFailed$p(r2, false);
                long r10 = System.currentTimeMillis();
                int r11 = AgentServiceImpl.access$getActiveRound$p(r2);
                AgentServiceImpl.access$markScreenshotUploading(r2, r11);
                d.h.b.o.a(r12);
                if (r2.uploadImageIfNeeded(r12, AgentServiceImpl.access$getTYPE_SCREENSHOT$p(r2), (com.obric.agent.l) ZeusTransformUtils.preCheckCast(new C0282a(r11, r2, r7, r10), com.obric.agent.l.class, "com.obric.aiagent.plugin")) == true) goto L41;
                if (r11 != AgentServiceImpl.access$getActiveRound$p(r2)) goto L39;
                AgentServiceImpl.access$clearScreenshotUploading(r2);
                AgentServiceImpl.access$setScreenshotUploadFailed$p(r2, false);
            L39:
                ILogDepend.Companion.i(AgentServiceImpl.TAG, "screenshot upload skipped by config");
                goto L41
            L22:
                r6 = false;
                goto L23
            L17:
                if (r4.getAutoImageUploadEnabled() == true) goto L19;
                r5 = true;
            L25:
                th = move-exception;
                d.n.a r15 = d.n.f38560a;
                r8 = d.n.f(d.o.a(th));
            L41:
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r13);
                AgentServiceImpl r16 = this.f14130b;
                Context r17 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AgentServiceImpl.access$getContext(r16), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
                Bitmap r18 = this.f14131c;
                d.c.d<? super File> r19 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f14129a = 1;
                r13 = r16.saveBitMapToFile(r17, r18, "screenshotX.jpg", r19);
                if (r13 != r0) goto L11;
                return r0;
            }
        }

        z(AgentServiceImpl r3, Bitmap r4, d.c.d<? super z> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14127b = r3;
            this.f14128c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((z) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), z.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new z(this.f14127b, this.f14128c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            d.c.a.b.a();
            if (this.f14126a != 0) goto L12;
            d.o.a(r11);
            AgentServiceImpl.access$setScreenshot$p(this.f14127b, null);
            Bitmap r12 = this.f14128c;
            if (r12 == null) goto L10;
            AgentServiceImpl r10 = this.f14127b;
            kotlinx.coroutines.i.a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(bs.f39169a, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r10, r12, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
            RealTimeContextServiceProxy r13 = RealTimeContextServiceProxy.f33846a;
            if (r13 == null) goto L10;
            r13.a(r12);
        L10:
            return d.x.f38692a;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final boolean getDeviceAgentChain() {
        return false;
    }

    public static /* synthetic */ d.x lambda$6jUwbvi17b85ag7QJr9hQhHPRGU(AtomicBoolean r0, d.h.a.a r1, AgentServiceImpl r2, IMMessage r3) {
        return openClickTalkWhenTTSEnd$lambda$88(r0, r1, r2, r3);
    }

    public static /* synthetic */ d.x lambda$Mff8MtjBTylmy7ecTA1hOOOINe8(AtomicBoolean r0, AtomicBoolean r1, AgentServiceImpl r2, String r3, AtomicBoolean r4, boolean r5, d.h.a.a r6, d.h.a.a r7) {
        return openClickTalkWhenTTSEnd$lambda$90(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void lambda$NtZd_55ovNvhnt71a6YBswJH3VA(AgentServiceImpl r0, IFlowAssistantStateIDL r1) {
        init$lambda$8(r0, r1);
    }

    public static /* synthetic */ boolean lambda$P5XrQi3oXcwcMs5DkINgzBYNmEs(ShortcutTask r0) {
        return buildShortCutInstructionCandidates$lambda$67$lambda$63(r0);
    }

    public static /* synthetic */ d.x lambda$SnPnqmNRCcxxrwrcr4eMc4NPYe0(d.h.b.z.f r0, d.h.b.z.f r1, AgentServiceImpl r2, String r3) {
        return openClickTalkWhenTTSEnd$lambda$87(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$X2M22uoLRDZTpNjBhlU3fOf0pnM(AgentServiceImpl r0, IFlowMessageIDL r1) {
        init$lambda$7(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ZGZfLWQCK7XOuEUP-XntWEvOec0, reason: not valid java name */
    public static /* synthetic */ boolean m53lambda$ZGZfLWQCK7XOuEUPXntWEvOec0(Integer r0, ShortcutTask r1) {
        return buildShortCutInstructionCandidates$lambda$67$lambda$64(r0, r1);
    }

    public static /* synthetic */ Context lambda$ZzxOVw2qBgYjPg8R1GkYidZBonE() {
        return context_delegate$lambda$1();
    }

    public static /* synthetic */ IEntityManager lambda$ae6ehwfE6MbfXcRkZdq5HJF2Bt8() {
        return entityManager_delegate$lambda$0();
    }

    public static /* synthetic */ d.x lambda$auewV5fqeKwv9_G1jyK5JssjF78(AtomicBoolean r0, d.h.b.z.f r1, AgentServiceImpl r2, String r3, AtomicBoolean r4, d.h.b.z.f r5) {
        return openClickTalkWhenTTSEnd$lambda$89(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$iR78XsqGC-1j-9w_SBl6YA5s38w, reason: not valid java name */
    public static /* synthetic */ KeyguardManager m54lambda$iR78XsqGC1j9w_SBl6YA5s38w() {
        return keyguardManager_delegate$lambda$2();
    }

    public static /* synthetic */ void lambda$lxfT6e7cLJc1PvEZhQSc1bfHAYA(AgentServiceImpl r0, IFlowAppStateIDL r1) {
        init$lambda$10(r0, r1);
    }

    private final void showSearchResult(String r1, List<? extends AppEntity> r2, String r3) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.agent.IAgentService
    public void getAppVersionFromStore(boolean r1, String r2, com.obric.agent.g r3) {
        com.obric.agent.g r0 = (com.obric.agent.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.agent.g.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "packageName");
        d.h.b.o.e(r0, "callback");
    }

    @Override // com.obric.agent.IAgentService
    public boolean isAutoGuiInstall() {
        return true;
    }

    @Override // com.obric.agent.IAgentService
    public void jumpToAppStore(String r2, com.obric.agent.g r3) {
        com.obric.agent.g r1 = (com.obric.agent.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.agent.g.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "packageName");
        d.h.b.o.e(r1, "callback");
    }

    /* JADX WARN: Type inference failed for: r0v47, types: [com.obric.agent.AgentServiceImpl$ipcAppStateChangedListener$1] */
    /* JADX WARN: Type inference failed for: r0v48, types: [com.obric.agent.AgentServiceImpl$ipcMessageExtCallback$1] */
    public AgentServiceImpl() {
        this.DEACTIVATE_MULTIMODAL_REASON_CAMERA_BUTTON = "CAMERA_BUTTON";
        this.DEACTIVATE_MULTIMODAL_REASON_CAMERA_WINDOW_REMOVED = "CAMERA_WINDOW_REMOVED";
        this.MAX_INTERVAL_HANDLE_ASSIST = 1000;
        this.TYPE_REALTIMEIMG = 1;
        this.keva = Keva.getRepo("agent", 0);
        this.entityManager$delegate = d.g.a($$Lambda$AgentServiceImpl$ae6ehwfE6MbfXcRkZdq5HJF2Bt8.INSTANCE);
        this.context$delegate = d.g.a($$Lambda$AgentServiceImpl$ZzxOVw2qBgYjPg8R1GkYidZBonE.INSTANCE);
        this.firstQuery = true;
        this.needRestartSession = new AtomicBoolean(false);
        this.timeoutMsgSet = new LinkedHashSet();
        this.mLastRemoteCardMessage = new ConcurrentHashMap();
        this.mRealTimeContext = RealTimeContext.Companion.a();
        this.mAsrLocalMsgId = "";
        this.chatWindowState = com.obric.agent.h.f14564a.ordinal();
        this.screenshotUploadState = new AtomicLong(0);
        this.lastSentRoundMessageIds = new CopyOnWriteArraySet();
        this.lastReportedScreenshotStateRound = new AtomicInteger(-1);
        this.shortCutTasks = d.a.p.b();
        this.preLoadMemoryjob = kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new aj(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        this.visibleActivities = new LinkedHashSet();
        this.SS_WEB_CLASS = "com.sec.android.app.sbrowser.SBrowserMainActivity";
        this.SECURE_CAMERA_P = new ComponentName("com.obric.camera2", "com.obric.camera2.SecureCameraActivity");
        this.SECURE_CAMERA_N = new ComponentName("com.android.camera", "cn.nubia.camera.CameraActivity");
        this.CHAT_CLASS = "com.larus.home.obric.ObricChatActivity";
        this.LAUNCHER = new ComponentName("com.android.launcher3", "com.obric.feature.ObricLauncher");
        this.screenshotInfo = new CopyOnWriteArraySet();
        this.realtimeImgInfo = new CopyOnWriteArraySet();
        this.unUsedUpdateImageInfo = new com.obric.agent.o(20, false, 2, null);
        this.uploadingScreenshotInfo = new LinkedHashSet();
        this.uploadingRealTimeImagInfo = new LinkedHashSet();
        this.streamObservers = new CopyOnWriteArraySet();
        this.ttsStateListeners = new CopyOnWriteArraySet();
        this.openMicSignalCache = new com.obric.agent.o(20, false, 2, null);
        this.openMicSignalCacheLock = new Object();
        this.openedClickTalkReplyIds = new CopyOnWriteArraySet();
        this.conditionTaskChannel = kotlinx.coroutines.a.g.a(Integer.MAX_VALUE, null, null, 6, null);
        this.conditionTaskSendResultChannel = kotlinx.coroutines.a.g.a(Integer.MAX_VALUE, null, null, 6, null);
        this.semanticUsedUpdateImageInfo = new com.obric.agent.o(20, false, 2, null);
        this.queryAudioFilesByLocalMsgId = new com.obric.agent.o(5, false);
        this.queryAudioFilesByMsgId = new com.obric.agent.o(5, false);
        this.queryMessageIdAndLocalMsg = new com.obric.agent.o(5, false);
        this.keyguardManager$delegate = d.g.a($$Lambda$AgentServiceImpl$iR78XsqGC1j9w_SBl6YA5s38w.INSTANCE);
        this.urlCallback = (com.obric.agent.s) ZeusTransformUtils.preCheckCast(new az(), com.obric.agent.s.class, "com.obric.aiagent.plugin");
        this.ipcAppStateChangedListener = new AgentServiceImpl$ipcAppStateChangedListener$1(this);
        this.ipcMessageExtCallback = new AgentServiceImpl$ipcMessageExtCallback$1();
        this.mCachedFileEntityMap = new com.obric.agent.o(10, false, 2, null);
        this.mCachedFileUriMap = new com.obric.agent.o(10, false, 2, null);
        this.larkSendCardListeners = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        this.flowTTSListener = new AgentServiceImpl$flowTTSListener$1(this);
        this.flowStreamObserver = new AgentServiceImpl$flowStreamObserver$1(this);
        this.messageChangedObserver = new r(this);
    }

    public static final /* synthetic */ void access$clearOpenMicSignalCache(AgentServiceImpl r0) {
        r0.clearOpenMicSignalCache();
    }

    public static final /* synthetic */ void access$clearScreenshotUploading(AgentServiceImpl r0) {
        r0.clearScreenshotUploading();
    }

    public static final /* synthetic */ Object access$findMessageByMsgId(AgentServiceImpl r2, String r3, d.c.d r4) {
        return r2.findMessageByMsgId(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ int access$getActiveRound$p(AgentServiceImpl r0) {
        return r0.activeRound;
    }

    public static final /* synthetic */ long access$getActiveTime$p(AgentServiceImpl r2) {
        return r2.activeTime;
    }

    public static final /* synthetic */ boolean access$getAsrIng$p(AgentServiceImpl r0) {
        return r0.asrIng;
    }

    public static final /* synthetic */ AssistContent access$getAssistContent$p(AgentServiceImpl r0) {
        return r0.assistContent;
    }

    public static final /* synthetic */ AssistStructure access$getAssistStructure$p(AgentServiceImpl r0) {
        return r0.assistStructure;
    }

    public static final /* synthetic */ String access$getCHAT_CLASS$p(AgentServiceImpl r0) {
        return r0.CHAT_CLASS;
    }

    public static final /* synthetic */ int access$getCachedAudioSize$p(AgentServiceImpl r0) {
        return r0.cachedAudioSize;
    }

    public static final /* synthetic */ int access$getChatWindowState$p(AgentServiceImpl r0) {
        return r0.chatWindowState;
    }

    public static final /* synthetic */ kotlinx.coroutines.a.d access$getConditionTaskChannel$p(AgentServiceImpl r0) {
        return r0.conditionTaskChannel;
    }

    public static final /* synthetic */ kotlinx.coroutines.a.d access$getConditionTaskSendResultChannel$p(AgentServiceImpl r0) {
        return r0.conditionTaskSendResultChannel;
    }

    public static final /* synthetic */ Context access$getContext(AgentServiceImpl r2) {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ Map access$getExtForSendMessage(AgentServiceImpl r0, String r1, int r2) {
        return r0.getExtForSendMessage(r1, r2);
    }

    public static final /* synthetic */ boolean access$getFirstQuery$p(AgentServiceImpl r0) {
        return r0.firstQuery;
    }

    public static final /* synthetic */ Keva access$getKeva$p(AgentServiceImpl r0) {
        return r0.keva;
    }

    public static final /* synthetic */ Set access$getLarkSendCardListeners$p(AgentServiceImpl r0) {
        return r0.larkSendCardListeners;
    }

    public static final /* synthetic */ IMMessage access$getLastSentMessage$p(AgentServiceImpl r0) {
        return r0.lastSentMessage;
    }

    public static final /* synthetic */ CopyOnWriteArraySet access$getLastSentRoundMessageIds$p(AgentServiceImpl r0) {
        return r0.lastSentRoundMessageIds;
    }

    public static final /* synthetic */ com.obric.agent.o access$getMCachedFileEntityMap$p(AgentServiceImpl r0) {
        return r0.mCachedFileEntityMap;
    }

    public static final /* synthetic */ com.obric.agent.o access$getMCachedFileUriMap$p(AgentServiceImpl r0) {
        return r0.mCachedFileUriMap;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMLastRemoteCardMessage$p(AgentServiceImpl r0) {
        return r0.mLastRemoteCardMessage;
    }

    public static final /* synthetic */ boolean access$getMainBotChatPageResume$p(AgentServiceImpl r0) {
        return r0.mainBotChatPageResume;
    }

    public static final /* synthetic */ CopyOnWriteArraySet access$getOpenedClickTalkReplyIds$p(AgentServiceImpl r0) {
        return r0.openedClickTalkReplyIds;
    }

    public static final /* synthetic */ com.obric.agent.o access$getQueryAudioFilesByLocalMsgId$p(AgentServiceImpl r0) {
        return r0.queryAudioFilesByLocalMsgId;
    }

    public static final /* synthetic */ com.obric.agent.o access$getQueryAudioFilesByMsgId$p(AgentServiceImpl r0) {
        return r0.queryAudioFilesByMsgId;
    }

    public static final /* synthetic */ com.obric.agent.o access$getQueryMessageIdAndLocalMsg$p(AgentServiceImpl r0) {
        return r0.queryMessageIdAndLocalMsg;
    }

    public static final /* synthetic */ d access$getQuestionContext(AgentServiceImpl r0, String r1, IMMessage r2) {
        return r0.getQuestionContext(r1, r2);
    }

    public static final /* synthetic */ CopyOnWriteArraySet access$getRealtimeImgInfo$p(AgentServiceImpl r0) {
        return r0.realtimeImgInfo;
    }

    public static final /* synthetic */ String access$getRecentMemoryData$p(AgentServiceImpl r0) {
        return r0.recentMemoryData;
    }

    public static final /* synthetic */ String access$getSS_WEB_CLASS$p(AgentServiceImpl r0) {
        return r0.SS_WEB_CLASS;
    }

    public static final /* synthetic */ Object access$getScreenshot(AgentServiceImpl r2, String r3, d.c.d r4) {
        return r2.getScreenshot(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Bitmap access$getScreenshot$p(AgentServiceImpl r0) {
        return r0.screenshot;
    }

    public static final /* synthetic */ CopyOnWriteArraySet access$getScreenshotInfo$p(AgentServiceImpl r0) {
        return r0.screenshotInfo;
    }

    public static final /* synthetic */ com.obric.agent.o access$getSemanticUsedUpdateImageInfo$p(AgentServiceImpl r0) {
        return r0.semanticUsedUpdateImageInfo;
    }

    public static final /* synthetic */ List access$getShortCutTasks$p(AgentServiceImpl r0) {
        return r0.shortCutTasks;
    }

    public static final /* synthetic */ CopyOnWriteArraySet access$getStreamObservers$p(AgentServiceImpl r0) {
        return r0.streamObservers;
    }

    public static final /* synthetic */ int access$getTYPE_REALTIMEIMG$p(AgentServiceImpl r0) {
        return r0.TYPE_REALTIMEIMG;
    }

    public static final /* synthetic */ int access$getTYPE_SCREENSHOT$p(AgentServiceImpl r0) {
        return r0.TYPE_SCREENSHOT;
    }

    public static final /* synthetic */ CopyOnWriteArraySet access$getTtsStateListeners$p(AgentServiceImpl r0) {
        return r0.ttsStateListeners;
    }

    public static final /* synthetic */ com.obric.agent.o access$getUnUsedUpdateImageInfo$p(AgentServiceImpl r0) {
        return r0.unUsedUpdateImageInfo;
    }

    public static final /* synthetic */ LinkedHashSet access$getUploadingRealTimeImagInfo$p(AgentServiceImpl r0) {
        return r0.uploadingRealTimeImagInfo;
    }

    public static final /* synthetic */ LinkedHashSet access$getUploadingScreenshotInfo$p(AgentServiceImpl r0) {
        return r0.uploadingScreenshotInfo;
    }

    public static final /* synthetic */ Object access$getUserRecentMemoryData(AgentServiceImpl r2, int r3, d.c.d r4) {
        return r2.getUserRecentMemoryData(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ LinkedHashSet access$getVisibleActivities$p(AgentServiceImpl r0) {
        return r0.visibleActivities;
    }

    public static final /* synthetic */ void access$handleAssistInternal(AgentServiceImpl r0, AssistStructure r1, AssistContent r2) {
        r0.handleAssistInternal(r1, r2);
    }

    public static final /* synthetic */ boolean access$isContinuousTalk(AgentServiceImpl r2, Map r3) {
        return r2.isContinuousTalk((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean access$isFirstAlarmEntityContent(AgentServiceImpl r0, String r1) {
        return r0.isFirstAlarmEntityContent(r1);
    }

    public static final /* synthetic */ boolean access$isLastSentRound(AgentServiceImpl r0, String r1) {
        return r0.isLastSentRound(r1);
    }

    public static final /* synthetic */ boolean access$isNeedRealtimeContext(AgentServiceImpl r0) {
        return r0.isNeedRealtimeContext();
    }

    public static final /* synthetic */ boolean access$isOmniTask(AgentServiceImpl r2, Map r3) {
        return r2.isOmniTask((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean access$isTtsTerminalState(AgentServiceImpl r0, Integer r1) {
        return r0.isTtsTerminalState(r1);
    }

    public static final /* synthetic */ void access$markScreenshotUploading(AgentServiceImpl r0, int r1) {
        r0.markScreenshotUploading(r1);
    }

    public static final /* synthetic */ void access$notifyConditionTaskSendTerminal(AgentServiceImpl r0, IMMessage r1) {
        r0.notifyConditionTaskSendTerminal(r1);
    }

    public static final /* synthetic */ void access$notifyEventTaskScheduleFailed(AgentServiceImpl r0, IMMessage r1) {
        r0.notifyEventTaskScheduleFailed(r1);
    }

    public static final /* synthetic */ void access$notifyEventTaskScheduleInterrupted(AgentServiceImpl r0, IMMessage r1) {
        r0.notifyEventTaskScheduleInterrupted(r1);
    }

    public static final /* synthetic */ void access$notifyEventTaskScheduleSent(AgentServiceImpl r0, IMMessage r1) {
        r0.notifyEventTaskScheduleSent(r1);
    }

    public static final /* synthetic */ void access$notifyMemoryForPreload(AgentServiceImpl r0) {
        r0.notifyMemoryForPreload();
    }

    public static final /* synthetic */ void access$onServerReply(AgentServiceImpl r2, String r3, String r4, Map r5, boolean r6) {
        r2.onServerReply(r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"), r6);
    }

    public static final /* synthetic */ String access$resolveQueryCallScene(AgentServiceImpl r2, Map r3) {
        return r2.resolveQueryCallScene((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean access$saveAudioFileToLocal(AgentServiceImpl r0, String r1, String r2, File r3) {
        return r0.saveAudioFileToLocal(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$saveFileFromStream(AgentServiceImpl r9, File r10, String r11, AppEntity r12, Uri r13, b r14, d.c.d r15) {
        return r9.saveFileFromStream(r10, r11, r12, r13, (b) ZeusTransformUtils.wrapperContextForParams(r14, b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$setActiveRound$p(AgentServiceImpl r0, int r1) {
        r0.activeRound = r1;
    }

    public static final /* synthetic */ void access$setActiveTime$p(AgentServiceImpl r0, long r1) {
        r0.activeTime = r1;
    }

    public static final /* synthetic */ void access$setAssistContent$p(AgentServiceImpl r0, AssistContent r1) {
        r0.assistContent = r1;
    }

    public static final /* synthetic */ void access$setAssistHanlded$p(AgentServiceImpl r0, boolean r1) {
        r0.assistHanlded = r1;
    }

    public static final /* synthetic */ void access$setAssistStructure$p(AgentServiceImpl r0, AssistStructure r1) {
        r0.assistStructure = r1;
    }

    public static final /* synthetic */ void access$setCacheAssistImgUri$p(AgentServiceImpl r0, String r1) {
        r0.cacheAssistImgUri = r1;
    }

    public static final /* synthetic */ void access$setCacheScreenshotUri$p(AgentServiceImpl r0, String r1) {
        r0.cacheScreenshotUri = r1;
    }

    public static final /* synthetic */ void access$setCachedAudioSize$p(AgentServiceImpl r0, int r1) {
        r0.cachedAudioSize = r1;
    }

    public static final /* synthetic */ void access$setChatWindow$p(AgentServiceImpl r0, boolean r1) {
        r0.isChatWindow = r1;
    }

    public static final /* synthetic */ void access$setChatWindowState$p(AgentServiceImpl r0, int r1) {
        r0.chatWindowState = r1;
    }

    public static final /* synthetic */ void access$setEntityUploading$p(AgentServiceImpl r0, boolean r1) {
        r0.entityUploading = r1;
    }

    public static final /* synthetic */ void access$setFirstQuery$p(AgentServiceImpl r0, boolean r1) {
        r0.firstQuery = r1;
    }

    public static final /* synthetic */ void access$setFocusedWindowSecure$p(AgentServiceImpl r0, boolean r1) {
        r0.isFocusedWindowSecure = r1;
    }

    public static final /* synthetic */ void access$setLastSentMessage$p(AgentServiceImpl r0, IMMessage r1) {
        r0.lastSentMessage = r1;
    }

    public static final /* synthetic */ void access$setMAsrLocalMsgId$p(AgentServiceImpl r0, String r1) {
        r0.mAsrLocalMsgId = r1;
    }

    public static final /* synthetic */ void access$setMRealTimeContext$p(AgentServiceImpl r0, RealTimeContext r1) {
        r0.mRealTimeContext = r1;
    }

    public static final /* synthetic */ void access$setMainBotChatPageResume$p(AgentServiceImpl r0, boolean r1) {
        r0.mainBotChatPageResume = r1;
    }

    public static final /* synthetic */ void access$setRealtimeCollectionId$p(AgentServiceImpl r0, String r1) {
        r0.realtimeCollectionId = r1;
    }

    public static final /* synthetic */ void access$setRecentMemoryData$p(AgentServiceImpl r0, String r1) {
        r0.recentMemoryData = r1;
    }

    public static final /* synthetic */ void access$setScreenshot$p(AgentServiceImpl r0, Bitmap r1) {
        r0.screenshot = r1;
    }

    public static final /* synthetic */ void access$setScreenshotUploadFailed$p(AgentServiceImpl r0, boolean r1) {
        r0.screenshotUploadFailed = r1;
    }

    public static final /* synthetic */ void access$setShortCutTasks$p(AgentServiceImpl r2, List r3) {
        r2.shortCutTasks = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setShouldRequestAssist$p(AgentServiceImpl r0, boolean r1) {
        r0.shouldRequestAssist = r1;
    }

    public static final /* synthetic */ void access$setSkipWaitForScreenShot$p(AgentServiceImpl r0, boolean r1) {
        r0.skipWaitForScreenShot = r1;
    }

    public static final /* synthetic */ void access$setTtsPlayState$p(AgentServiceImpl r0, int r1) {
        r0.ttsPlayState = r1;
    }

    public static final /* synthetic */ Bitmap access$takeScreenshotByObricWindow(AgentServiceImpl r0) {
        return r0.takeScreenshotByObricWindow();
    }

    public static final /* synthetic */ void access$tryOpenClickTalkIfNeeded(AgentServiceImpl r0, IMMessage r1) {
        r0.tryOpenClickTalkIfNeeded(r1);
    }

    public static final /* synthetic */ void access$updateOpenMicSignalState(AgentServiceImpl r2, String r3, d.h.a.b r4) {
        r2.updateOpenMicSignalState(r3, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$updateUserRecentMemoryDataAsync(AgentServiceImpl r0) {
        r0.updateUserRecentMemoryDataAsync();
    }

    static {
        Companion = new a(null);
        O_SESSION_VOLATILE_ALLOWED_KEYS = d.a.ax.a(new String[]{DBDefinition.TITLE, "artist", "album", "duration", "mediaId", "hasAlbumArt", "playbackState", "position", "speed", "lastPositionUpdateTime"});
    }

    private final IEntityManager getEntityManager() {
        return (IEntityManager) ZeusTransformUtils.preCheckCast(this.entityManager$delegate.b(), IEntityManager.class, "com.obric.aiagent.plugin");
    }

    private static final Context context_delegate$lambda$1() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    private final Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(this.context$delegate.b(), Context.class, "com.obric.aiagent.plugin");
    }

    private final void markScreenshotUploading(int r5) {
        this.screenshotUploadState.set((((long) r5) << 1) | 1);
    }

    private final void clearScreenshotUploading() {
        this.screenshotUploadState.set(0);
    }

    private final boolean isScreenshotUploading() {
        if ((this.screenshotUploadState.get() & 1) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean isScreenshotUploadingInRound(int r7) {
        long r0 = this.screenshotUploadState.get();
        if ((r0 & 1) == 1) goto L5;
    L7:
        return false;
    L5:
        if ((r0 >> 1) != r7) goto L7;
        return true;
    }

    private final KeyguardManager getKeyguardManager() {
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(this.keyguardManager$delegate.b(), KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    private static final KeyguardManager keyguardManager_delegate$lambda$2() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("keyguard");
        d.h.b.o.a(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(r0, KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    public final com.obric.agent.s getUrlCallback() {
        return this.urlCallback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateOpenMicSignalState(String r6, d.h.a.b<? super c, c> r7) {
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        Object r3 = this.openMicSignalCacheLock;
        monitor-enter(r3);
        c r4 = (c) ZeusTransformUtils.preCheckCast(this.openMicSignalCache.get(r6), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r4 != null) goto L16;
        r4 = new c(r1, null, 3, 0 == true ? 1 : 0);     // Catch: Throwable -> L19
    L16:
        ((Map) ZeusTransformUtils.preCheckCast(this.openMicSignalCache, Map.class, "com.obric.aiagent.plugin")).put(r6, r8.invoke(r4));     // Catch: Throwable -> L19
        d.x r5 = d.x.f38692a;     // Catch: Throwable -> L19
        monitor-exit(r3);
        return;
    L19:
        th = move-exception;
        throw th;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private final c getOpenMicSignalState(String r3) {
        Object r0 = this.openMicSignalCacheLock;
        monitor-enter(r0);
        c r2 = (c) ZeusTransformUtils.preCheckCast(this.openMicSignalCache.get(r3), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    private final void removeOpenMicSignalState(String r3) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Object r2 = this.openMicSignalCacheLock;
        monitor-enter(r2);
        c r4 = (c) ZeusTransformUtils.preCheckCast(this.openMicSignalCache.remove(r3), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        monitor-exit(r2);
        return;
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private final void clearOpenMicSignalCache() {
        Object r0 = this.openMicSignalCacheLock;
        monitor-enter(r0);
        this.openMicSignalCache.clear();     // Catch: Throwable -> L7
        d.x r1 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final boolean isTtsTerminalState(Integer r2) {
        int r1 = com.obric.aiagent.assistant.idl.bean.b.a.f16264a.a();
        if (r2 != null) goto L6;
    L7:
        int r3 = com.obric.aiagent.assistant.idl.bean.b.a.f16268e.a();
        if (r2 != null) goto L11;
    L13:
        return false;
    L11:
        if (r2.intValue() != r3) goto L13;
    L14:
        return true;
    L6:
        if (r2.intValue() == r1) goto L14;
        goto L7
    }

    @Override // com.obric.agent.IAgentService
    public void init(Context r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "context");
        ILogDepend.Companion.i(TAG, "AgentServiceImpl.init() called");
        IOVirtService r0 = IOVirtService.Companion.a();
        if (r0 != null) goto L5;
        ILogDepend.Companion.w(TAG, "AgentServiceImpl.init: IOVirtService unavailable");
    L6:
        IIntentActionService r1 = (IIntentActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentActionService.class), IIntentActionService.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "IIntentActionService: " + r1);
        if (r1 == null) goto L9;
        r1.init();
    L9:
        ILogDepend.Companion.i(TAG, "IIntentActionService.init() done");
        com.obric.agent.card.weather.h.f14294a.a();
        ObricService.INSTANCE.init();
        com.obric.agent.office.a.f15240a.a((IAgentService) ZeusTransformUtils.preCheckCast(this, IAgentService.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class), false, false, new $$Lambda$AgentServiceImpl$X2M22uoLRDZTpNjBhlU3fOf0pnM(this), 3, null);
        com.obric.aiagent.assistant.idl.u.a(d.h.b.aa.b(IFlowAssistantStateIDL.class), false, false, new $$Lambda$AgentServiceImpl$NtZd_55ovNvhnt71a6YBswJH3VA(this), 3, null);
        EventsTaskSdk.init(new EventsTaskSdk.InitConfig((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")));
        com.obric.agent.trace.q.f15713a.a();
        IAgentExecutor r2 = (IAgentExecutor) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentExecutor.class), IAgentExecutor.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L12;
        r2.init();
    L12:
        IEntityManager r3 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L15;
        r3.init();
    L15:
        IAutoActionService r4 = (IAutoActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionService.class), IAutoActionService.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L18;
        r4.init();
    L18:
        com.obric.agent.a.b.f14218a.a();
        com.obric.agent.k.f15191a.a((com.obric.agent.im.d) ZeusTransformUtils.preCheckCast(this.messageChangedObserver, com.obric.agent.im.d.class, "com.obric.aiagent.plugin"));
        kotlinx.coroutines.i.a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(bs.f39169a, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new o(32, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        String r5 = this.keva.getString(CACHED_FILE_ENTITY_MAP, null);
        if (r5 == null) goto L23;
        Object r6 = EntityExtKt.a().fromJson(r5, new AgentServiceImpl$init$4$cachedEntityMap$1().getType());
        d.h.b.o.c(r6, "fromJson(...)");
        LinkedHashMap r7 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r6, LinkedHashMap.class, "com.obric.aiagent.plugin");
        ISecureLogDepend.Companion.i(TAG, "init mCachedFileEntityMap " + this.mCachedFileEntityMap + " cachedEntityMap " + r5);
        if ((!((Map) ZeusTransformUtils.preCheckCast(this.mCachedFileEntityMap, Map.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L23;
        this.mCachedFileEntityMap.putAll((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.aiagent.plugin"));
    L23:
        com.obric.aiagent.assistant.idl.s.a(d.h.b.aa.b(IFlowAppStateIDL.class), false, false, new $$Lambda$AgentServiceImpl$lxfT6e7cLJc1PvEZhQSc1bfHAYA(this), 3, null);
        IComplexTaskService r8 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L26;
        r8.init(r13);
    L26:
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new p(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        IMessageCollectService r11 = IMessageCollectService.Companion.a();
        if (r11 == null) goto L30;
        r11.start();
        return;
    L30:
        return;
    L5:
        List<OVirtLifecycleListener> r9 = OVirtLifecycleListener.Companion.a();
        r0.registerLifecycleListeners(r9);
        ILogDepend.Companion.i(TAG, "AgentServiceImpl.init: IOVirtService ready listenerCount=" + r9.size());
        goto L6
    }

    private static final void init$lambda$7(AgentServiceImpl r3, IFlowMessageIDL r4) {
        IFlowMessageIDL r5 = (IFlowMessageIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowMessageIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "it");
        com.obric.agent.im.a.f14573a.a(r5, 23);
        r5.registerSendMessageExtCallback((IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.preCheckCast(r3.ipcMessageExtCallback, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin"));
        r5.registerStreamObserver((IFlowStreamObserverIDL) ZeusTransformUtils.preCheckCast(r3.flowStreamObserver, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin"));
    }

    private static final void init$lambda$8(AgentServiceImpl r2, IFlowAssistantStateIDL r3) {
        IFlowAssistantStateIDL r4 = (IFlowAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "it");
        r4.registerTTSStateListener((IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.preCheckCast(r2.flowTTSListener, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin"));
    }

    private static final void init$lambda$10(AgentServiceImpl r2, IFlowAppStateIDL r3) {
        IFlowAppStateIDL r4 = (IFlowAppStateIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "it");
        r4.registerAppStateListener((IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.preCheckCast(r2.ipcAppStateChangedListener, IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.agent.IAgentService
    public void dispatchIMAction(IntentAppAction r1) {
        d.h.b.o.e(r1, "action");
        ObricService.INSTANCE.dispatchIMAction(r1);
    }

    private final void notifyMemoryForPreload() {
        ca.a.a(this.preLoadMemoryjob, null, 1, null);
        ILogDepend.Companion.i(TAG, "preloadAssistantSearchModels");
        com.obric.memorydata.sdk.a.f33793a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        ILogDepend.Companion.i(TAG, "preloadAssistantSearchModels done");
        this.preLoadMemoryjob = kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new t(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.IAgentService
    public int getTtsState() {
        return this.ttsPlayState;
    }

    @Override // com.obric.agent.IAgentService
    public void onFlowUnbind() {
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new x(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        this.streamObservers.clear();
        this.ttsStateListeners.clear();
        this.openedClickTalkReplyIds.clear();
        clearOpenMicSignalCache();
        IFlowMessageIDL r0 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
        if (r0 == null) goto L5;
        com.obric.agent.im.a.f14573a.a(r0);
        r0.unregisterSendMessageExtCallback((IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.preCheckCast(this.ipcMessageExtCallback, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin"));
        r0.unregisterStreamObserver((IFlowStreamObserverIDL) ZeusTransformUtils.preCheckCast(this.flowStreamObserver, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin"));
    L5:
        IFlowAssistantStateIDL r1 = com.obric.aiagent.assistant.idl.u.a(d.h.b.aa.b(IFlowAssistantStateIDL.class));
        if (r1 == null) goto L8;
        r1.unregisterTTSStateListener((IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.preCheckCast(this.flowTTSListener, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin"));
    L8:
        IFlowAppStateIDL r2 = com.obric.aiagent.assistant.idl.s.a(d.h.b.aa.b(IFlowAppStateIDL.class));
        if (r2 == null) goto L12;
        r2.unregisterAppStateListener((IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.preCheckCast(this.ipcAppStateChangedListener, IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.obric.agent.IAgentService
    public void onStartChatWindow(int r8) {
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ac(this, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.IAgentService
    public PicInfo getScreenPicInfo(boolean r10, boolean r11) {
        String r1 = this.debugImageTos;
        if (r1 == null) goto L8;
        PicInfo r12 = new PicInfo(r1, null, null, null, null, 30, null);
        if (r10 == false) goto L7;
        this.realtimeImgInfo.clear();
        this.screenshotInfo.clear();
        this.debugImageTos = null;
    L7:
        return r12;
    L8:
        JSONObject r0 = new JSONObject();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.realtimeImgInfo, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L20;
        PicInfo r2 = (PicInfo) ZeusTransformUtils.preCheckCast(d.a.p.e((Iterable) ZeusTransformUtils.preCheckCast(this.realtimeImgInfo, Iterable.class, "com.obric.aiagent.plugin")), PicInfo.class, "com.obric.aiagent.plugin");
        if (r11 == false) goto L15;
        r0.put("pic_result", 1);
        IAppLog r13 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L15;
        r13.reportToFlow("o_screen_pic_info", r0);
    L15:
        Map r14 = (Map) ZeusTransformUtils.preCheckCast(this.unUsedUpdateImageInfo, Map.class, "com.obric.aiagent.plugin");
        d.h.b.ae.j(r14).remove(r2.getTosKey());
        if (r10 == false) goto L18;
        this.realtimeImgInfo.clear();
        this.screenshotInfo.clear();
    L18:
        return r2;
    L20:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.screenshotInfo, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L30;
        PicInfo r3 = (PicInfo) ZeusTransformUtils.preCheckCast(d.a.p.e((Iterable) ZeusTransformUtils.preCheckCast(this.screenshotInfo, Iterable.class, "com.obric.aiagent.plugin")), PicInfo.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(this.unUsedUpdateImageInfo, Map.class, "com.obric.aiagent.plugin");
        d.h.b.ae.j(r4).remove(r3.getTosKey());
        if (r11 == false) goto L26;
        r0.put("pic_result", 2);
        IAppLog r15 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L26;
        r15.reportToFlow("o_screen_pic_info", r0);
    L26:
        if (r10 == false) goto L28;
        this.realtimeImgInfo.clear();
        this.screenshotInfo.clear();
    L28:
        return r3;
    L30:
        if (this.entityUploading == false) goto L32;
    L33:
        if (r11 == false) goto L37;
        r0.put("pic_result", 0);
        IAppLog r9 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L37;
        r9.reportToFlow("o_screen_pic_info", r0);
    L37:
        return null;
    L32:
        if (isScreenshotUploading() == false) goto L37;
        goto L33
    }

    @Override // com.obric.agent.IAgentService
    public void onAssistantStateChanged(String r4, String r5) {
        d.h.b.o.e(r4, "fromState");
        d.h.b.o.e(r5, "toState");
        ILogDepend.Companion.i(TAG, "onAssistantStateChanged fromState:" + r4 + " toState:" + r5);
        if (d.h.b.o.a(r5, "Standby") == false) goto L6;
        this.mRealTimeContext = RealTimeContext.Companion.a();
        this.needRestartSession.set(false);
        com.obric.agent.trace.q.f15713a.b();
        this.assistActive = false;
        return;
    L6:
        if (d.h.b.o.a(r4, "Standby") == false) goto L10;
        this.assistActive = true;
        return;
    }

    @Override // com.obric.agent.IAgentService
    public void onAssistantShow(Bundle r8) {
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new w(this, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.IAgentService
    public void onHandleAssist(AssistStructure r8, AssistContent r9) {
        ILogDepend.Companion.i(TAG, "onHandleAssist");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new y(this, r8, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final ComponentName getTopActivity() {
        Object r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("activity");
        d.h.b.o.a(r5, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningTaskInfo> r6 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r5, ActivityManager.class, "com.obric.aiagent.plugin")).getRunningTasks(2);
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L37;
        Iterator<ActivityManager.RunningTaskInfo> r7 = r6.iterator();
    L13:
        if (r7.hasNext() == false) goto L37;
        ActivityManager.RunningTaskInfo r3 = (ActivityManager.RunningTaskInfo) ZeusTransformUtils.preCheckCast(r7.next(), ActivityManager.RunningTaskInfo.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L13;
        if (r3.topActivity == null) goto L28;
        ComponentName r4 = r3.topActivity;
        if (r4 == null) goto L22;
        String r8 = r4.getPackageName();
    L24:
        if (d.h.b.o.a(r8, "com.larus.nova") == true) goto L28;
        return r3.topActivity;
    L22:
        r8 = null;
    L28:
        if (r3.baseActivity == null) goto L13;
        ComponentName r9 = r3.baseActivity;
        if (r9 == null) goto L32;
        String r10 = r9.getPackageName();
    L34:
        if (d.h.b.o.a(r10, "com.larus.nova") == true) goto L13;
        return r3.baseActivity;
    L32:
        r10 = null;
    L37:
        return null;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L10
    }

    private final void handleAssistInternal(AssistStructure r11, AssistContent r12) {
        ISecureLogDepend.Companion.i(TAG, "handleAssistInternal " + r11 + ' ' + r12);
        if (isNeedRealtimeContext() == true) goto L5;
        return;
    L5:
        if (this.assistHanlded == true) goto L48;
        ComponentName r0 = getTopActivity();
        List<AppEntity> r1 = null;
        if (r0 == null) goto L10;
        String r2 = r0.getPackageName();
    L11:
        String r3 = ObricProductSdk.INSTANCE.featureService().getObricProductName();
        if (d.h.b.o.a(r3, IFeatureServiceKt.PRODUCT_GENESIS_R) == true) goto L14;
    L16:
        boolean r4 = false;
    L17:
        ILogDepend.Companion.i(TAG, "handleAssistInternal, pkg=" + r2 + ", product=" + r3);
        if (r11 == null) goto L20;
        if (r12 == null) goto L20;
    L24:
        if (this.chatWindowState != com.obric.agent.h.f14567d.ordinal()) goto L27;
        ILogDepend.Companion.i(TAG, "FULL_SCREEN window, delay notify onHandleAssist");
        this.assistStructure = r11;
        this.assistContent = r12;
        return;
    L27:
        this.assistStructure = null;
        this.assistContent = null;
        this.assistHanlded = true;
        ClassLoader r5 = AppEntity.class.getClassLoader();
        if (r12 == null) goto L33;
        Bundle r7 = r12.getExtras();
        if (r7 == null) goto L33;
        r7.setClassLoader(r5);
    L33:
        if (r4 == false) goto L37;
        ILogDepend.Companion.i(TAG, "handleAssistInternal, enter EntityProvider");
        List<AppEntity> r13 = EntityProvider.INSTANCE.getOnScreenData(r3, r2);
        if (r13 == null) goto L42;
        r1 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin"));
    L42:
        ILogDepend.Companion.i(TAG, "handleAssistInternal, entities=" + r1);
        ISecureLogDepend.Companion.i("IntentTracer", "onHandleAssist " + r1);
        if (getDeviceAgentChain() == true) goto L45;
        RealTimeContextServiceProxy.f33846a.a(r11, r1, (IRealTimeContextCallback) ZeusTransformUtils.preCheckCast(new AgentServiceImpl$handleAssistInternal$realTimeCallback$1(this), IRealTimeContextCallback.class, "com.obric.aiagent.plugin"));
    L45:
        this.shouldRequestAssist = false;
        resetRequestAssist();
        return;
    L37:
        if (r12 == null) goto L41;
        Bundle r14 = r12.getExtras();
        if (r14 == null) goto L41;
        r1 = r14.getParcelableArrayList("entities");
    L41:
        r1 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L20:
        if (r4 == true) goto L24;
        ILogDepend.Companion.i(TAG, "handleAssistInternal skip: assist data is null, likely framework getAssistContextExtras timeout, structure=" + r11 + ", content=" + r12 + ", pkg=" + r2);
        return;
    L14:
        if (d.h.b.o.a(r2, "com.miui.gallery") == false) goto L16;
        r4 = true;
        goto L17
    L10:
        r2 = null;
        goto L11
    }

    public final boolean uploadImageIfNeeded(Uri r13, int r14, com.obric.agent.l r15) {
        final com.obric.agent.l r16 = (com.obric.agent.l) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.agent.l.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "uri");
        d.h.b.o.e(r16, "callback");
        IFlowSettingsIDL r0 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));
        if (r0 == null) goto L7;
        OModelConfig r3 = r0.getObricModelConfig();
        if (r3 == null) goto L7;
        String r4 = r3.getIntentModel();
    L9:
        if (r0 != null) goto L11;
    L13:
        boolean r1 = false;
    L14:
        if (r1 == false) goto L16;
    L18:
        IFlowMessageIDL r2 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
        if (r2 != null) goto L22;
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ax(r16, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return true;
    L22:
        final String r5 = UUID.randomUUID().toString();
        d.h.b.o.c(r5, "toString(...)");
        if (r14 != this.TYPE_SCREENSHOT) goto L26;
        this.uploadingScreenshotInfo.add(new com.obric.agent.z(r5, r13.toString()));
    L36:
        d.n.a r17 = d.n.f38560a;     // Catch: Throwable -> L30
        final AgentServiceImpl r12 = (AgentServiceImpl) ZeusTransformUtils.preCheckCast(this, AgentServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        r2.uploadImage(r13.toString(), r5, (IImageXUploadCallbackIDL) ZeusTransformUtils.preCheckCast(new AgentServiceImpl$uploadImageIfNeeded$2$1(r16, r12, r5), IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L30
        Object r18 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L30
    L32:
        Throwable r19 = d.n.c(r18);
        if (r19 == null) goto L35;
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ay(r16, r19, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    L35:
        return true;
    L30:
        th = move-exception;
        d.n.a r110 = d.n.f38560a;
        r18 = d.n.f(d.o.a(th));
        goto L32
    L26:
        if (r14 != this.TYPE_REALTIMEIMG) goto L36;
        this.uploadingRealTimeImagInfo.add(new com.obric.agent.z(r5, r13.toString()));
        goto L36
    L16:
        if (d.h.b.o.a(com.obric.agent.d.f14409a.d(), r4) == true) goto L18;
        return false;
    L11:
        if (r0.getSemanticeScreenShotEnabled() != true) goto L13;
        r1 = true;
    L7:
        r4 = null;
        goto L9
    }

    public final String mapTypeToActionBarKey(Integer r2) {
        if (r2 == null) goto L8;
        if (r2.intValue() != 1) goto L8;
        return IFlowAppIntentIDL.ACTION_BAR_KEY_PHOTO_PERCEIVE;
    L8:
        if (r2 == null) goto L14;
        if (r2.intValue() != 2) goto L14;
        return IFlowAppIntentIDL.ACTION_BAR_KEY_FILE_PERCEIVE;
    L14:
        if (r2 == null) goto L20;
        if (r2.intValue() != 3) goto L20;
        return IFlowAppIntentIDL.ACTION_BAR_KEY_WEB_PERCEIVE;
    L20:
        if (r2 == null) goto L26;
        if (r2.intValue() != 4) goto L26;
        return IFlowAppIntentIDL.ACTION_BAR_KEY_IM_PERCEIVE;
    L26:
        if (r2 != null) goto L29;
    L31:
        return SensitiveType.UNKNOWN;
    L29:
        if (r2.intValue() != 5) goto L31;
        return IFlowAppIntentIDL.ACTION_BAR_KEY_VIDEO_PERCEIVE;
    }

    @Override // com.obric.agent.IAgentService
    public void getWebUrl(com.obric.agent.s r10) {
        com.obric.agent.s r9 = (com.obric.agent.s) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.agent.s.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "callback");
        long r7 = UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
        com.obric.agent.utils.b.f15994a.a(new BaseSystemGetWebUrlIntent().getName(), null, null, r7);
        m r11 = new m(r7, r9);
        IAppIntentFeedback r12 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L6;
        r12.addLocalActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(r11, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.obric.agent.IAgentService
    public void screenShot(com.obric.agent.t r9) {
        com.obric.agent.t r10 = (com.obric.agent.t) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.agent.t.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "callback");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ar(this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.IAgentService
    public void takeScreenshotForScreenPerception(com.obric.agent.t r9) {
        com.obric.agent.t r10 = (com.obric.agent.t) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.agent.t.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "callback");
        if (this.isFocusedWindowSecure == false) goto L6;
        ILogDepend.Companion.i(TAG, "invalid screenshot for screen perception due to secure window");
        String r8 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_screenshot_not_support_for_screen_perception, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_screenshot_not_support_for_screen_perception"));
        d.h.b.o.c(r8, "getString(...)");
        r10.a(r8);
        return;
    L6:
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new as(this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final Bitmap takeScreenshotByObricWindow() {
        Object r1 = null;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L5
        AgentServiceImpl r6 = (AgentServiceImpl) ZeusTransformUtils.preCheckCast(this, AgentServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r7 = d.n.f(ObricProductSdk.INSTANCE.platformService().windowManager().takeScreenshot(null, d.a.p.a("com.larus.nova")));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = d.n.c(r7);
        if (r3 == null) goto L11;
        ILogDepend.Companion.e(TAG, "takeScreenshot failed", r3);
    L11:
        if (d.n.b(r7) == true) goto L15;
        r1 = r7;
    L15:
        return (Bitmap) ZeusTransformUtils.preCheckCast(r1, Bitmap.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L7
    }

    private final Object getScreenshot(String r5, d.c.d<? super File> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(this, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    public final Object saveBitMapToFile(Context r4, Bitmap r5, String r6, d.c.d<? super File> r7) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new am(r3, r6, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r8);
    }

    private final void resetRequestAssist() {
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new al(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.IAgentService
    public void onHandleScreenshot(Bitmap r8) {
        ILogDepend.Companion.i(TAG, "onHandleScreenshot");
        if (isNeedRealtimeContext() == true) goto L6;
        return;
    L6:
        if (this.isFocusedWindowSecure == false) goto L9;
        ILogDepend.Companion.i(TAG, "invalid screenshot due to secure window");
        return;
    L9:
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new z(this, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.IAgentService
    public void addMessage(String r14, String r15, String r16, int r17, String r18) {
        d.h.b.o.e(r14, "content");
        d.h.b.o.e(r16, "questionId");
        if (com.obric.agent.n.a(com.obric.agent.n.f15202a, r16, 0, 2, null) == false) goto L6;
        ILogDepend.Companion.i(TAG, "skip local addMessage because model decode card is enabled, questionId=" + r16);
        return;
    L6:
        ILogDepend.Companion.d(TAG, "addMessage, questionId: " + r16 + ", type: " + r15);
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.c(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r15, r16, this, r18, r17, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final boolean isFirstAlarmEntityContent(String r7) {
        JsonArray r8 = JsonParser.parseString(r7).getAsJsonObject().getAsJsonArray("dataV2");     // Catch: Exception -> L26
        if (r8 != null) goto L6;
        return false;
    L6:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L26
    L7:
        Object r3 = null;
        if (r9.hasNext() == false) goto L24;
        JsonElement r2 = (JsonElement) ZeusTransformUtils.preCheckCast(r9.next(), JsonElement.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L26
        d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L16
        AgentServiceImpl r5 = (AgentServiceImpl) ZeusTransformUtils.preCheckCast(this, AgentServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        JsonObject r6 = r2.getAsJsonObject().getAsJsonObject("appEntity");     // Catch: Throwable -> L16
        if (r6 != null) goto L13;
        AppEntity r10 = null;
    L14:
        Object r11 = d.n.f(r10);     // Catch: Throwable -> L16
    L19:
        if (d.n.b(r11) == true) goto L22;
        r3 = r11;
    L22:
        r3 = (AppEntity) ZeusTransformUtils.preCheckCast(r3, AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L26
        if (r3 == null) goto L7;
    L13:
        r10 = (AppEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r6, JsonElement.class, "com.obric.aiagent.plugin"), AppEntity.class), AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        goto L14
    L16:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;     // Catch: Exception -> L26
        r11 = d.n.f(d.o.a(th));     // Catch: Exception -> L26
    L24:
        return ZeusTransformUtils.instanceOf(r3, AlarmEntity.class);
    L26:
        e = move-exception;
        ILogDepend.Companion.i(TAG, "isFirstAlarmEntityContent parse failed: " + e.getMessage());
        return false;
    }

    private final Map<String, String> getExtForSendMessage(String r4, int r5) {
        Map<String, String> r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        r3.put(KEY_REFERENCE_ID, r4);
        ISecureLogDepend.Companion.i(TAG, "getExtForSendMessage messageId=" + r4 + ", contentType=" + r5 + ", add ext:" + r3);
        return r3;
    }

    private final boolean isLastSentRound(String r9) {
        boolean r0 = false;
        if (r9 != null) goto L6;
        ILogDepend.Companion.i(TAG, "isLastSentRound questionId is null, return false");
        return false;
    L6:
        IMMessage r2 = this.lastSentMessage;
        String r3 = null;
        if (r2 == null) goto L9;
        String r4 = r2.getMessageId();
    L10:
        boolean r5 = d.h.b.o.a(r9, r4);
        boolean r6 = this.lastSentRoundMessageIds.contains(r9);
        if (r5 == true) goto L13;
        if (r6 == true) goto L13;
    L14:
        ILogDepend.Companion r7 = ILogDepend.Companion;
        StringBuilder r10 = new StringBuilder().append("isLastSentRound questionId=").append(r9).append(", lastSentMessageId=");
        IMMessage r8 = this.lastSentMessage;
        if (r8 == null) goto L17;
        r3 = r8.getMessageId();
    L17:
        r7.i(TAG, r10.append(r3).append(", matchLast=").append(r5).append(", matchRound=").append(r6).append(", roundIds=").append(this.lastSentRoundMessageIds).append(", result=").append(r0).toString());
        return r0;
    L13:
        r0 = true;
        goto L14
    L9:
        r4 = null;
        goto L10
    }

    private final d getQuestionContext(String r8, IMMessage r9) {
        if (r9 != null) goto L7;
        r9 = com.obric.agent.j.f15187a.a(r8);
        if (r9 != null) goto L7;
        return null;
    L7:
        String r0 = r9.getConversationId();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        r0 = null;
    L14:
        String r2 = com.obric.agent.im.b.a(r9);
        if (r2 != null) goto L17;
    L22:
        r2 = null;
    L23:
        if (r2 != null) goto L56;
        Map<String, String> r10 = r9.getExt();
        if (r10 == null) goto L27;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.get(COLLECTION_ID), String.class, "com.obric.aiagent.plugin");
    L28:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L31;
    L34:
        boolean r6 = true;
    L35:
        if (r6 == true) goto L56;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(com.obric.agent.j.f15187a.b(r11), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L38:
        if (r3.hasNext() == false) goto L50;
        String r7 = com.obric.agent.im.b.a((IMMessage) ZeusTransformUtils.preCheckCast(r3.next(), IMMessage.class, "com.obric.aiagent.plugin"));
        if (r7 != null) goto L42;
    L47:
        r7 = null;
    L48:
        if (r7 == null) goto L38;
        r2 = r7;
    L51:
        ILogDepend.Companion r4 = ILogDepend.Companion;
        StringBuilder r12 = new StringBuilder().append("getQuestionContext fallback by collectionId=").append(r11).append(", questionId=").append(r8).append(", fallbackDisplayContent=");
        if (r2 == null) goto L54;
        Object r13 = Integer.valueOf(r2.length());
    L55:
        r4.i(TAG, r12.append(r13).toString());
        goto L56
    L54:
        r13 = "null";
        goto L55
    L42:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L44;
        boolean r14 = true;
    L45:
        if (r14 == false) goto L47;
    L44:
        r14 = false;
        goto L45
    L50:
        r2 = null;
        goto L51
    L31:
        if (r5.length() == 0) goto L34;
        r6 = false;
        goto L35
    L27:
        r11 = null;
    L56:
        if (r0 != null) goto L60;
        if (r2 != null) goto L60;
        return null;
    L60:
        return new d(r0, r2);
    L17:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L19;
        boolean r15 = true;
    L20:
        if (r15 == false) goto L22;
    L19:
        r15 = false;
        goto L20
    L10:
        r1 = false;
        goto L11
    }

    @Override // com.obric.agent.IAgentService
    public void deleteRemoteCardMessageByQuestionId(String r6) {
        d.h.b.o.e(r6, "questionId");
        d.m r0 = (d.m) ZeusTransformUtils.preCheckCast(this.mLastRemoteCardMessage.get(r6), d.m.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        ILogDepend.Companion.i(TAG, "deleteRemoteCardMessageByQuestionId " + r6 + " localMessageId:" + r0);
        deleteMessage((String) ZeusTransformUtils.preCheckCast(r0.a(), String.class, "com.obric.aiagent.plugin"));
    L5:
        this.mLastRemoteCardMessage.remove(r6);
    }

    @Override // com.obric.agent.IAgentService
    public void deleteMessage(String r4) {
        d.h.b.o.e(r4, "localMessageId");
        IFlowMessageIDL r3 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
        if (r3 == null) goto L6;
        r3.deleteMessage(r4, (IFlowDeleteMessageCallbackIDL) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), IFlowDeleteMessageCallbackIDL.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.obric.agent.IAgentService
    public Object onUserSelect(List<String> r14, String r15, String r16, DispatchContext r17, d.c.d<? super IntentResult<AppEntity[]>> r18) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r9 = new d.c.i(d.c.a.b.a(r0));
        d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(r9, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ae(r3, r15, r16, r6, r17, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        Object r1 = r9.a();
        if (r1 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r0);
    L5:
        return r1;
    }

    public final /* synthetic */ <T> T asTypeOrNull(IntentResult<?> r3) {
        d.h.b.o.e(r3, "<this>");
        Object r2 = r3.getEntity();
        d.h.b.o.a(3, "T");
        if (ZeusTransformUtils.instanceOf(r2, Object.class) == false) goto L5;
        Object r4 = r3.getEntity();
        d.h.b.o.a(1, "T");
        return (T) ZeusTransformUtils.preCheckCast(r4, Object.class, "com.obric.aiagent.plugin");
    L5:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v85, types: [T, org.json.JSONObject] */
    @Override // com.obric.agent.IAgentService
    public Map<String, String> getExtraForSendMessage(Map<String, String> r24, String r25, boolean r26) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "map");
        d.h.b.o.e(r25, "content");
        ILogDepend.Companion.i(TAG, "getExtraForSendMessage start");
        Map<String, String> r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.get(COLLECTION_ID), String.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
    L7:
        boolean r9 = false;
    L9:
        if (this.firstQuery == true) goto L14;
        if (r26 == true) goto L14;
        if (r9 == true) goto L14;
        boolean r10 = false;
    L15:
        ILogDepend.Companion.i(TAG, "getExtraForSendMessage realtimeContext decision: firstQuery=" + this.firstQuery + ", forceGet=" + r26 + ", collectionId=" + r6 + ", realtimeCollectionId=" + this.realtimeCollectionId + ", isSameCollectionRound=" + r9 + ", injectRealtimeContext=" + r10);
        d.h.b.z.f r11 = new d.h.b.z.f();
        String r12 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_session"), String.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L18;
        T r14 = new JSONObject(r12);
    L19:
        r11.f38504a = r14;
        if (r11.f38504a != 0) goto L22;
        r11.f38504a = new JSONObject();
    L22:
        String r13 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Long.valueOf(System.currentTimeMillis()));
        if (IAppContext.Companion.isDebug() == false) goto L33;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4.get("current_system_time"), String.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L33;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L30;
        r7 = null;
    L30:
        if (r7 == null) goto L33;
        r13 = r7;
    L33:
        boolean r16 = r9;
        long r15 = System.currentTimeMillis() - this.activeTime;
        r5.put("current_system_time", r13);
        ((JSONObject) ZeusTransformUtils.preCheckCast(r11.f38504a, JSONObject.class, "com.obric.aiagent.plugin")).put("current_system_time", r13);
        r5.put("o_timezone", TimeZone.getDefault().getID());
        r5.put("o_telephone_select_switch", "1");
        r5.put("o_playing_media_session_apps", com.obric.agent.intents.audio.a.f14676a.a(com.obric.agent.intents.audio.a.f14676a.b()));
        r5.put("o_paused_media_session_apps", com.obric.agent.intents.audio.a.f14676a.a(com.obric.agent.intents.audio.a.f14676a.c()));
        JSONObject r8 = new JSONObject();
        MediaSessionData r17 = com.obric.agent.utils.m.f16044a.a();
        if (r17 == null) goto L48;
        ILogDepend.Companion r18 = ILogDepend.Companion;
        StringBuilder r2 = new StringBuilder().append("getExtraForSendMessage media session data size = ");
        List<MediaSessionMetaEntry> r3 = r17.data;
        if (r3 == null) goto L38;
        Integer r19 = Integer.valueOf(r3.size());
    L39:
        r18.i(TAG, r2.append(r19).toString());
        List<MediaSessionMetaEntry> r20 = r17.data;
        if (r20 == null) goto L48;
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L43:
        if (r21.hasNext() == false) goto L47;
        MediaSessionMetaEntry r22 = (MediaSessionMetaEntry) ZeusTransformUtils.preCheckCast(r21.next(), MediaSessionMetaEntry.class, "com.obric.aiagent.plugin");
        if (O_SESSION_VOLATILE_ALLOWED_KEYS.contains(r22.key) == false) goto L43;
        r8.put(r22.key, r22.value);
        goto L43
    L47:
        d.x r23 = d.x.f38692a;
        goto L48
    L38:
        r19 = null;
    L48:
        r8.put("is_traffic_downloadable", com.obric.agent.g.a.f14560a.b() ? 1 : 0);
        r5.put("o_session_volatile", r8.toString());
        IFlowSettingsIDL r27 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));
        if (r27 == null) goto L51;
        OModelConfig r28 = r27.getObricModelConfig();
    L558:
        d.n.a r29 = d.n.f38560a;     // Catch: Throwable -> L63
        IFlowSettingsIDL r30 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));     // Catch: Throwable -> L63
        if (r30 != null) goto L55;
    L57:
        boolean r31 = false;
    L58:
        if (r31 == true) goto L60;
        boolean r32 = true;
    L61:
        Object r33 = d.n.f(Boolean.valueOf(r32));     // Catch: Throwable -> L63
    L66:
        if (d.n.b(r33) == false) goto L68;
        r33 = true;
    L68:
        boolean r34 = ((Boolean) ZeusTransformUtils.preCheckCast(r33, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (r28 == null) goto L71;
        r5.put("o_intent_model", r28.getIntentModel());
        r5.put("o_pc_model", r28.getPcSearchModel());
        d.x r35 = d.x.f38692a;
        d.x r36 = d.x.f38692a;
    L71:
        String r37 = ObricProductSdk.INSTANCE.platformService().romInfo().getShortOSVersion();
        r5.put("o_rom_version", r37);
        JSONObject r38 = new JSONObject();
        r38.put("o_rom_version", r37);
        r38.put("o_release_region", ObricProductSdk.INSTANCE.platformService().romInfo().getRomReleaseRegion());
        r38.put("o_tenant", ObricProductSdk.INSTANCE.featureService().getObricProductName());
        r38.put("o_is_ut_rom", ObricProductSdk.INSTANCE.platformService().romInfo().isUTRom());
        r5.put("o_device_context", r38.toString());
        ILogDepend.Companion.i(TAG, "getExtraForSendMessage common extras " + r5);
        IFlowUiIDL r39 = com.obric.aiagent.assistant.idl.aw.a(d.h.b.aa.b(IFlowUiIDL.class));
        if (r39 == null) goto L74;
        int r40 = r39.getWindowState();
    L76:
        if (r40 != com.obric.memorydata.sdk.assistant.b.f.ordinal()) goto L78;
        r40 = com.obric.memorydata.sdk.assistant.b.f33808c.ordinal();
    L78:
        ILogDepend.Companion.i(TAG, "AssistantStateServiceProxy onQuery " + r40);
        if (getKeyguardManager().isKeyguardLocked() == false) goto L81;
        String r41 = CALL_SCENE_LOCK_SCREEN;
    L82:
        ((JSONObject) ZeusTransformUtils.preCheckCast(r11.f38504a, JSONObject.class, "com.obric.aiagent.plugin")).put(EXT_O_SCREEN_POSITION, r41);
        if (r10 == true) goto L554;
    L277:
        Map<String, String> r210 = r4;
        int r110 = r40;
        r40 = r110;
        ILogDepend.Companion.i(TAG, "getExtraForSendMessage skip realtimeContext, injectRealtimeContext=" + r10 + ", isNeedRealtimeContext=" + isNeedRealtimeContext() + ", windowState=" + r40 + ", collectionId=" + r6);     // Catch: JsonSyntaxException -> L323
        String r42 = this.debugImageTos;     // Catch: JsonSyntaxException -> L323
        if (r42 == null) goto L284;
        d.h.b.o.a(r42);     // Catch: JsonSyntaxException -> L323
        r5.put("o_screenshot", r42);     // Catch: JsonSyntaxException -> L323
        r5.put("o_screenshot_state", "1");     // Catch: JsonSyntaxException -> L323
        r5.put("o_global_search_eval", "1");     // Catch: JsonSyntaxException -> L323
    L283:
        String r43 = null;
    L293:
        this.mRealTimeContext = RealTimeContext.Companion.a();     // Catch: JsonSyntaxException -> L323
        d.x r44 = d.x.f38692a;     // Catch: JsonSyntaxException -> L323
    L294:
        String r45 = (String) ZeusTransformUtils.preCheckCast(r5.get("o_screenshot"), String.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L323
        if (r45 != null) goto L297;
    L301:
        r45 = ((JSONObject) ZeusTransformUtils.preCheckCast(r11.f38504a, JSONObject.class, "com.obric.aiagent.plugin")).optString("o_screenshot");     // Catch: JsonSyntaxException -> L323
        d.h.b.o.a(r45);     // Catch: JsonSyntaxException -> L323
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r45, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L305;
        r45 = null;
    L305:
        if (r45 != null) goto L307;
    L309:
        if (r43 != null) goto L311;
    L317:
        ((JSONObject) ZeusTransformUtils.preCheckCast(r11.f38504a, JSONObject.class, "com.obric.aiagent.plugin")).remove("o_screenshot_state_reason");     // Catch: JsonSyntaxException -> L323
    L318:
        if (r26 == true) goto L330;
        if (this.lastReportedScreenshotStateRound.getAndSet(this.activeRound) == this.activeRound) goto L330;
        com.obric.agent.trace.g.f15449a.a((String) ZeusTransformUtils.preCheckCast(r5.get("o_screenshot_state"), String.class, "com.obric.aiagent.plugin"), r43);     // Catch: JsonSyntaxException -> L323
    L330:
        if (MemoryServiceProxy.f33843a.a() == false) goto L332;
        JSONObject r46 = new JSONObject();
        r46.put("dialogueMemory", true);
        String r47 = r46.toString();
        d.h.b.o.c(r47, "toString(...)");
        r5.put("memorySetting", r47);
    L332:
        ILogDepend.Companion.i(TAG, "onMemoryIPC start");
        IFlowSettingsIDL r48 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));
        if (r48 != null) goto L335;
    L337:
        boolean r49 = false;
    L338:
        if (r49 == false) goto L340;
        r5.put("o_use_memory", "1");
    L340:
        ILogDepend.Companion.i(TAG, "onMemoryIPC end");
        Map<String, String> r50 = r210;
        String r51 = (String) ZeusTransformUtils.preCheckCast(r50.get("o_omni_handoff_model"), String.class, "com.obric.aiagent.plugin");
        if (r51 != null) goto L343;
    L348:
        IFlowSettingsIDL r52 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));
        if (r52 == null) goto L351;
        String r53 = r52.getAutoGuiFastModeUseSettings();
    L353:
        if (r53 != null) goto L355;
        r53 = com.obric.capabilitykit.common.a.a().toJson(d.a.ao.a(new d.m[]{d.s.a("display_model", "Seed 2.1 Lite"), d.s.a("model", IOmniModelService.MODEL_LITE)}));
    L355:
        r5.put("o_omni_handoff_model", r53);
        IFlowSettingsIDL r54 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));
        if (r54 == null) goto L358;
        int r55 = r54.getAutoGuiEnabledScene();
    L359:
        r5.put("o_autogui_mode", String.valueOf(r55));
        if (r55 == 0) goto L372;
        IFlowSettingsIDL r56 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));
        if (r56 == null) goto L372;
        OComplexTaskConfig r57 = r56.getObricComplexTaskConfig();
        if (r57 == null) goto L372;
        r5.put("o_complex_task_mode", "planexecute");
        r5.put("o_local_deep_search", "1");
        r5.put("o_autogui_task_mode", "pro");
        if (com.obric.agent.w.a(r57.getModeLevel()) == true) goto L368;
    L370:
        d.x r58 = d.x.f38692a;
        d.x r59 = d.x.f38692a;
        goto L372
    L368:
        if (r50.get("o_autogui_task_mode") != null) goto L370;
        r5.put("o_autogui_task_mode", r57.getModeLevel());
        com.obric.agent.trace.g.f15449a.b(r57.getModeLevel());
    L372:
        if (PackageInfoCache.f18569a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.ss.android.lark") == false) goto L374;
    L377:
        String r60 = "1";
    L378:
        r5.put("o_is_lark_installed", r60);
        String r61 = (String) ZeusTransformUtils.preCheckCast(r50.get("o_auto_mic"), String.class, "com.obric.aiagent.plugin");
        if (r61 == null) goto L381;
        JSONObject r62 = new JSONObject(r61);
    L382:
        if (r62 == null) goto L446;
        String r63 = r62.optString("appEvent");
        if (com.obric.agent.w.a(r63) == true) goto L544;
    L445:
        d.x r64 = d.x.f38692a;
        d.x r65 = d.x.f38692a;
        goto L446
    L544:
        d.n.a r66 = d.n.f38560a;     // Catch: Throwable -> L410
        String r67 = new JSONObject(r63).optString("eventType");     // Catch: Throwable -> L410
        CharSequence r68 = (CharSequence) ZeusTransformUtils.preCheckCast(r67, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L410
        if (r68 != null) goto L388;
    L391:
        boolean r69 = true;
    L392:
        if (r69 == false) goto L394;
        AppEvent r70 = (AppEvent) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r63, NotificationEvent.class), AppEvent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L410
    L408:
        Object r71 = d.n.f(r70);     // Catch: Throwable -> L410
    L413:
        if (d.n.b(r71) == false) goto L415;
        r71 = null;
    L415:
        AppEvent r72 = (AppEvent) ZeusTransformUtils.preCheckCast(r71, AppEvent.class, "com.obric.aiagent.plugin");
        ISecureLogDepend.Companion.i(TAG, "auto mic, appEvent: " + r72);
        if (ZeusTransformUtils.instanceOf(r72, NotificationEvent.class) == false) goto L432;
        r5.put("o_notification_event", r63);
        AppNotification[] r73 = ((NotificationEvent) ZeusTransformUtils.preCheckCast(r72, NotificationEvent.class, "com.obric.aiagent.plugin")).getNotifications();
        if (r73 == null) goto L445;
        ILogDepend.Companion r74 = ILogDepend.Companion;
        StringBuilder r75 = new StringBuilder().append("notifications.packageName = ");
        AppNotification r111 = (AppNotification) ZeusTransformUtils.preCheckCast(d.a.i.c(r73), AppNotification.class, "com.obric.aiagent.plugin");
        if (r111 == null) goto L422;
        String r112 = r111.getPackageName();
    L423:
        r74.i(TAG, r75.append(r112).toString());
        AppNotification r76 = (AppNotification) ZeusTransformUtils.preCheckCast(d.a.i.c(r73), AppNotification.class, "com.obric.aiagent.plugin");
        if (r76 == null) goto L426;
        String r77 = r76.getPackageName();
    L428:
        if (d.h.b.o.a(r77, "com.ss.android.lark") == true) goto L430;
        r5.put("o_task_type", IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK);
        r5.put("o_is_omni_agent", "1");
        r5.put("o_omni_instruction_type", "normal");
        r5.put("o_instruction_entry", "priority_notice");
    L430:
        d.x r78 = d.x.f38692a;
        d.x r79 = d.x.f38692a;
        goto L445
    L426:
        r77 = null;
        goto L428
    L422:
        r112 = null;
        goto L423
    L432:
        if (ZeusTransformUtils.instanceOf(r72, ActiveAgentEvent.class) == false) goto L444;
        String r80 = ((ActiveAgentEvent) ZeusTransformUtils.preCheckCast(r72, ActiveAgentEvent.class, "com.obric.aiagent.plugin")).getInstructionType();
        if (r80 == null) goto L436;
        r5.put("o_omni_instruction_type", r80);
        d.x r81 = d.x.f38692a;
        d.x r82 = d.x.f38692a;
    L436:
        String r83 = ((ActiveAgentEvent) ZeusTransformUtils.preCheckCast(r72, ActiveAgentEvent.class, "com.obric.aiagent.plugin")).getInstructionEntry();
        if (r83 == null) goto L439;
        r5.put("o_instruction_entry", r83);
        d.x r84 = d.x.f38692a;
        d.x r85 = d.x.f38692a;
    L439:
        ConcurrentHashMap<String, Object> r86 = ((ActiveAgentEvent) ZeusTransformUtils.preCheckCast(r72, ActiveAgentEvent.class, "com.obric.aiagent.plugin")).getExtra();
        if (r86 == null) goto L445;
        Object r87 = r86.get("o_ext_context");
        if (r87 == null) goto L445;
        ((JSONObject) ZeusTransformUtils.preCheckCast(r11.f38504a, JSONObject.class, "com.obric.aiagent.plugin")).put("o_ext_context", r87);
        goto L445
    L444:
        ILogDepend.Companion.i(TAG, "auto mic, unknown appEvent type, skip");
        d.x r88 = d.x.f38692a;
        goto L445
    L394:
        Iterator r89 = ((Iterable) ZeusTransformUtils.preCheckCast(EventTypeKt.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L410
    L396:
        if (r89.hasNext() == false) goto L400;
        Object r90 = r89.next();     // Catch: Throwable -> L410
        if (d.h.b.o.a(((d.r) ZeusTransformUtils.preCheckCast(r90, d.r.class, "com.obric.aiagent.plugin")).a(), r67) == false) goto L396;
        Object r91 = r90;
    L401:
        d.r r92 = (d.r) ZeusTransformUtils.preCheckCast(r91, d.r.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L410
        if (r92 == null) goto L407;
        Class r93 = (Class) ZeusTransformUtils.preCheckCast(r92.b(), Class.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L410
        if (r93 == null) goto L407;
        r70 = (AppEvent) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r63, r93), AppEvent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L410
    L407:
        r70 = null;
        goto L408
    L400:
        r91 = null;
        goto L401
    L388:
        if (r68.length() == 0) goto L391;
        r69 = false;
    L410:
        th = move-exception;
        d.n.a r94 = d.n.f38560a;
        r71 = d.n.f(d.o.a(th));
    L446:
        com.obric.agent.utils.b.f15994a.a(r5);
        if (r50.get("o_event_task") != null) goto L485;
        String r95 = (String) ZeusTransformUtils.preCheckCast(r50.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r95, IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI) == false) goto L452;
        Integer r96 = 0;
    L455:
        Map<String, String> r97 = buildShortCutInstructionCandidates(r96);
        if ((!r97.isEmpty()) == false) goto L546;
        r5.put("o_short_cut_instructions", com.obric.capabilitykit.common.a.a().toJson(r97));
    L546:
        d.n.a r98 = d.n.f38560a;     // Catch: Throwable -> L468
        String r99 = r25;
        TextContent r100 = (TextContent) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r99, TextContent.class), TextContent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L466
        if (r100 == null) goto L463;
        String r101 = r100.text;     // Catch: Throwable -> L466
    L464:
        Object r102 = d.n.f(r101);     // Catch: Throwable -> L466
    L472:
        if (d.n.b(r102) == false) goto L474;
        r102 = null;
    L474:
        String r103 = (String) ZeusTransformUtils.preCheckCast(r102, String.class, "com.obric.aiagent.plugin");
        if (r103 == null) goto L486;
        List<ShortcutTask> r104 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
        r104.addAll((Collection) ZeusTransformUtils.preCheckCast(this.shortCutTasks, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L481
        monitor-exit(this);
        getShortTaskForQuery(r103, r104, r96);
    L481:
        th = move-exception;
        throw th;
    L486:
        com.obric.agent.utils.o.f16054a.a(r5);
        boolean r105 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new String[]{"task_addition", "task_reply"}), Iterable.class, "com.obric.aiagent.plugin"), r50.get("o_omni_intention"));
        ILogDepend.Companion.i(TAG, "o_in_gui_virtual_display check start");
        IOAutoStateManager r106 = (IOAutoStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOAutoStateManager.class), IOAutoStateManager.class, "com.obric.aiagent.plugin");
        if (r106 == null) goto L489;
        com.obric.autogui.api.a r107 = r106.fetchTopDisplayed();
    L490:
        if (r107 == null) goto L494;
        ComponentName r108 = r107.a();
        if (r108 == null) goto L494;
        String r109 = r108.getPackageName();
    L495:
        ILogDepend.Companion.i(TAG, "o_in_gui_virtual_display checked: clarify=" + r105 + " topPkg=" + r109);
        if (r105 == false) goto L498;
    L500:
        kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(this, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);
        r5.put("o_session", ((JSONObject) ZeusTransformUtils.preCheckCast(r11.f38504a, JSONObject.class, "com.obric.aiagent.plugin")).toString());
        ISecureLogDepend.Companion.i("IntentTracer", "AssistantStateServiceProxy getExtraForSendMessage extras " + r5);
        AssistantStateServiceProxy.f33799a.a(new QueryContext(r40, com.obric.memorydata.sdk.assistant.a.f33802b.ordinal()));
        IAgentAuthService r113 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAuthService.class), IAgentAuthService.class, "com.obric.aiagent.plugin");
        if (r113 != null) goto L503;
    L505:
        boolean r114 = false;
    L506:
        if (r114 == false) goto L508;
        String r115 = "1";
    L509:
        r5.put(EXT_O_IS_DEVICE_LOCKED, r115);
        com.obric.agent.message.b r116 = new com.obric.agent.message.b(r50, r99);
        Set r117 = ServiceManager.get().getServices(IAgentMessageExtProvider.class);
        d.h.b.o.b(r117, "ServiceManager.get().getServices(T::class.java)");
        Iterator r118 = ((Iterable) ZeusTransformUtils.preCheckCast(r117, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L511:
        if (r118.hasNext() == false) goto L513;
        r5.putAll(((IAgentMessageExtProvider) ZeusTransformUtils.preCheckCast(r118.next(), IAgentMessageExtProvider.class, "com.obric.aiagent.plugin")).getExtraForSendMessage(r116));
        goto L511
    L513:
        boolean r119 = !d.h.b.o.a(r5.get("o_screenshot_state"), "2");
        ILogDepend.Companion.d(TAG, "getExtraForSendMessage called, isUploadComplete=" + r119);
        if (r119 == false) goto L516;
        String r120 = "1";
    L517:
        r5.put("o_agent_ext_completed", r120);
        if (d.h.b.o.a(r50.get("o_task_type"), IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == false) goto L520;
    L523:
        IComplexTaskService r121 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
        if (r121 == null) goto L532;
        Map<String, String> r122 = r121.getExtraForAgentSendMessage();
        if (r122 == null) goto L532;
        Iterator<Map.Entry<String, String>> r123 = r122.entrySet().iterator();
    L529:
        if (r123.hasNext() == false) goto L531;
        Map.Entry r124 = (Map.Entry) ZeusTransformUtils.preCheckCast(r123.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r5.put((String) ZeusTransformUtils.preCheckCast(r124.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r124.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L529
    L531:
        d.x r125 = d.x.f38692a;
    L532:
        checkExtValueSize(r5);
        if (r26 == true) goto L535;
        this.firstQuery = false;
        ILogDepend.Companion.i(TAG, "getExtraForSendMessage end");
    L535:
        return r5;
    L520:
        if (d.h.b.o.a(r5.get("o_is_omni_agent"), "1") == true) goto L523;
        if (d.h.b.o.a(r50.get("o_is_omni_agent"), "1") == false) goto L532;
    L516:
        r120 = "0";
        goto L517
    L508:
        r115 = "0";
        goto L509
    L503:
        if (r113.isKeyguardReallyLocked() != true) goto L505;
        r114 = true;
        goto L506
    L498:
        if (d.h.b.o.a(r109, "com.larus.nova") == false) goto L500;
        ILogDepend.Companion.i(TAG, "o_in_gui_virtual_display=1");
        r5.put("o_in_gui_virtual_display", "1");
    L494:
        r109 = null;
        goto L495
    L489:
        r107 = null;
        goto L490
    L463:
        r101 = null;
    L466:
        th = th;
    L470:
        d.n.a r126 = d.n.f38560a;
        r102 = d.n.f(d.o.a(th));
    L468:
        th = th;
        r99 = r25;
        goto L470
    L452:
        if (d.h.b.o.a(r95, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == false) goto L454;
        r96 = 1;
        goto L455
    L454:
        r96 = null;
        goto L455
    L485:
        r99 = r25;
        com.obric.agent.utils.o.f16054a.a(r50, r5);
        d.x r127 = d.x.f38692a;
        goto L486
    L381:
        r62 = null;
        goto L382
    L374:
        if (PackageInfoCache.f18569a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.ss.android.lark.debug") == true) goto L377;
        r60 = "0";
        goto L378
    L358:
        r55 = 0;
        goto L359
    L351:
        r53 = null;
        goto L353
    L343:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r51, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L345;
        r53 = r51;
    L346:
        if (r53 == null) goto L348;
    L345:
        r53 = null;
        goto L346
    L335:
        if (r48.getOUseMemoryEnabled() != true) goto L337;
        r49 = true;
        goto L338
    L311:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r43, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L313;
        String r128 = r43;
    L314:
        if (r128 == null) goto L317;
        if (((JSONObject) ZeusTransformUtils.preCheckCast(r11.f38504a, JSONObject.class, "com.obric.aiagent.plugin")).put("o_screenshot_state_reason", r128) != null) goto L318;
    L313:
        r128 = null;
        goto L314
    L307:
        if (d.h.b.o.a(r5.get("o_screenshot_state"), "1") == true) goto L309;
        ILogDepend.Companion.i(TAG, "getExtraForSendMessage screenshot attached but mislabeled: o_screenshot_hash=" + r45.hashCode() + ", len=" + r45.length() + ", state=" + ((String) ZeusTransformUtils.preCheckCast(r5.get("o_screenshot_state"), String.class, "com.obric.aiagent.plugin")) + ", reason=" + r43 + " -> correct state=1");     // Catch: JsonSyntaxException -> L323
        r5.put("o_screenshot_state", "1");     // Catch: JsonSyntaxException -> L323
        ((JSONObject) ZeusTransformUtils.preCheckCast(r11.f38504a, JSONObject.class, "com.obric.aiagent.plugin")).put("o_screenshot_state", "1");     // Catch: JsonSyntaxException -> L323
        r43 = null;
        goto L309
    L297:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r45, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L300;
        r45 = null;
    L300:
        if (r45 != null) goto L305;
    L284:
        r5.put("o_screenshot_state", "0");     // Catch: JsonSyntaxException -> L323
        if (r40 != com.obric.memorydata.sdk.assistant.b.f33810e.ordinal()) goto L289;
        String r129 = "full_screen";
    L287:
        r43 = r129;
        goto L293
    L289:
        if (isNeedRealtimeContext() == true) goto L291;
        r129 = REASON_KEYGUARD_LOCKED;
        goto L287
    L291:
        if (r34 == true) goto L283;
        r129 = REASON_AUTO_UPLOAD_DISABLED;
    L323:
        e = e;
    L327:
        JsonSyntaxException r130 = e;
    L328:
        ILogDepend.Companion.e(TAG, "getExtraForSendMessage fromJson failed", (Throwable) ZeusTransformUtils.preCheckCast(r130, Throwable.class, "com.obric.aiagent.plugin"));
    L325:
        e = e;
        r40 = r110;
        goto L327
    L554:
    L275:
        e = e;
        r210 = r4;
        goto L327
    L85:
        if (isNeedRealtimeContext() == false) goto L277;
        if (r40 == com.obric.memorydata.sdk.assistant.b.f33810e.ordinal()) goto L277;
        if (this.firstQuery == false) goto L95;
        if (r6 == null) goto L95;
        this.realtimeCollectionId = r6;     // Catch: JsonSyntaxException -> L93
        ILogDepend.Companion.i(TAG, "getExtraForSendMessage record realtimeCollectionId=" + r6 + " for sibling reuse");     // Catch: JsonSyntaxException -> L93
    L93:
        e = move-exception;
        r130 = e;
        r210 = r4;
    L95:
        ILogDepend.Companion.i(TAG, "getExtraForSendMessage inject realtimeContext, windowState=" + r40 + ", collectionId=" + r6 + ", reusedByCollection=" + r16);     // Catch: JsonSyntaxException -> L275
        if (com.obric.agent.w.a(this.mRealTimeContext.getCurTopAppPackageName()) == false) goto L99;
        String r131 = this.mRealTimeContext.getCurTopAppPackageName();     // Catch: JsonSyntaxException -> L93
    L105:
        if (com.obric.agent.w.a(this.mRealTimeContext.getCurTopActivityName()) == false) goto L108;
        String r132 = this.mRealTimeContext.getCurTopActivityName();     // Catch: JsonSyntaxException -> L93
    L114:
        if (com.obric.agent.w.a(this.mRealTimeContext.getCurTopAppName()) == true) goto L116;
        com.obric.aiagent.executionengine.utils.d r133 = com.obric.aiagent.executionengine.utils.d.f18567a;     // Catch: JsonSyntaxException -> L275
        Context r134 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L275
        if (r131 != null) goto L121;
        String r135 = "";
    L122:
        PackageInfoCache.a r136 = r133.a(r134, r135);     // Catch: JsonSyntaxException -> L275
        if (r136 == null) goto L125;
        CharSequence r137 = r136.b();     // Catch: JsonSyntaxException -> L93
    L126:
        if (r131 == null) goto L132;
        int r138 = r40;
        boolean r139 = r34;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r131, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("com.obric.camera", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L133;
        boolean r140 = true;
    L134:
        if (r140 == false) goto L538;
        r5.put("o_app_entity", EntityExtKt.a().toJson(d.a.p.c((Iterable) ZeusTransformUtils.preCheckCast(this.mRealTimeContext.getAppEntities(), Iterable.class, "com.obric.aiagent.plugin"), 10)));     // Catch: JsonSyntaxException -> L137
    L538:
        r5.put("o_meta_value", EntityExtKt.a().toJson(this.mRealTimeContext.getScreenMetaValue()));     // Catch: JsonSyntaxException -> L271
        if (r131 != null) goto L143;
        String r141 = "";
    L144:
        r5.put(EXT_O_TOP_APP, r141);     // Catch: JsonSyntaxException -> L271
        r5.put("o_top_app_name", String.valueOf(r137));     // Catch: JsonSyntaxException -> L271
        r5.put("o_top_activity", String.valueOf(r132));     // Catch: JsonSyntaxException -> L271
        JSONObject r142 = (JSONObject) ZeusTransformUtils.preCheckCast(r11.f38504a, JSONObject.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L271
        if (r131 != null) goto L147;
        r131 = "";
    L147:
        r142.put(EXT_O_TOP_APP, r131);     // Catch: JsonSyntaxException -> L271
        ((JSONObject) ZeusTransformUtils.preCheckCast(r11.f38504a, JSONObject.class, "com.obric.aiagent.plugin")).put("o_top_app_name", String.valueOf(r137));     // Catch: JsonSyntaxException -> L271
        ((JSONObject) ZeusTransformUtils.preCheckCast(r11.f38504a, JSONObject.class, "com.obric.aiagent.plugin")).put("o_top_activity", String.valueOf(r132));     // Catch: JsonSyntaxException -> L271
        int r143 = IAppContext.Companion.getUpdateVersionCode();     // Catch: JsonSyntaxException -> L271
        ILogDepend.Companion r144 = ILogDepend.Companion;     // Catch: JsonSyntaxException -> L271
        StringBuilder r145 = new StringBuilder().append("getExtraForSendMessage onQuery, semanticeScreenShotEnabled:");     // Catch: JsonSyntaxException -> L271
        IFlowSettingsIDL r146 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));     // Catch: JsonSyntaxException -> L271
        if (r146 == null) goto L151;
        Boolean r147 = Boolean.valueOf(r146.getSemanticeScreenShotEnabled());     // Catch: JsonSyntaxException -> L137
    L152:
        r144.i(TAG, r145.append(r147).append(",aiAgent updateVersionCode: ").append(r143).toString());     // Catch: JsonSyntaxException -> L271
        if (r143 < 80000) goto L156;
        IFlowSettingsIDL r148 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));     // Catch: JsonSyntaxException -> L271
        if (r148 != null) goto L164;
    L166:
        boolean r149 = false;
    L167:
        if (r149 == false) goto L169;
        r5.put("o_need_upload_screenshot", "1");     // Catch: JsonSyntaxException -> L137
    L169:
        String r150 = (String) ZeusTransformUtils.preCheckCast(r4.get("is_semantic_screen_qa"), String.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L271
        if (r150 == null) goto L172;
        ((JSONObject) ZeusTransformUtils.preCheckCast(r11.f38504a, JSONObject.class, "com.obric.aiagent.plugin")).put("is_semantic_screen_qa", r150);     // Catch: JsonSyntaxException -> L137
    L172:
        if (r28 == null) goto L270;
        Iterable r151 = (Iterable) ZeusTransformUtils.preCheckCast(this.visibleActivities, Iterable.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L271
        if (ZeusTransformUtils.instanceOf(r151, Collection.class) == true) goto L176;
    L178:
        Iterator r152 = r151.iterator();     // Catch: JsonSyntaxException -> L271
    L180:
        if (r152.hasNext() == false) goto L184;
        if (isHomeActivity((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (ComponentName) ZeusTransformUtils.preCheckCast(r152.next(), ComponentName.class, "com.obric.aiagent.plugin")) == false) goto L180;
        boolean r153 = true;
    L185:
        boolean r154 = isHostForeground();     // Catch: JsonSyntaxException -> L271
        if (hasSemantic() == false) goto L249;
        if (r153 == true) goto L249;
        JSONObject r155 = new JSONObject();     // Catch: JsonSyntaxException -> L271
        if (this.isFocusedWindowSecure == false) goto L191;
    L201:
        long r156 = System.currentTimeMillis() - this.activeTime;     // Catch: JsonSyntaxException -> L271
        int r157 = this.activeRound;     // Catch: JsonSyntaxException -> L271
        if (((Collection) ZeusTransformUtils.preCheckCast(this.screenshotInfo, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L204;
        boolean r158 = true;
    L205:
        boolean r159 = isScreenshotUploadingInRound(r157);     // Catch: JsonSyntaxException -> L271
        r210 = r4;
        if (((Collection) ZeusTransformUtils.preCheckCast(this.realtimeImgInfo, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L210;
        boolean r160 = true;
    L211:
        boolean r161 = this.entityUploading;     // Catch: JsonSyntaxException -> L268
        if (r158 == false) goto L214;
    L229:
        Long r162 = ((PicInfo) ZeusTransformUtils.preCheckCast(d.a.p.e((Iterable) ZeusTransformUtils.preCheckCast(this.screenshotInfo, Iterable.class, "com.obric.aiagent.plugin")), PicInfo.class, "com.obric.aiagent.plugin")).getTime();     // Catch: JsonSyntaxException -> L268
        if (r162 == null) goto L232;
        Long r163 = Long.valueOf(r162.longValue() - this.activeTime);     // Catch: JsonSyntaxException -> L268
    L233:
        d.h.b.o.a(r163);     // Catch: JsonSyntaxException -> L268
        long r164 = r163.longValue();     // Catch: JsonSyntaxException -> L268
        String r165 = this.debugImageTos;     // Catch: JsonSyntaxException -> L268
        if (r165 != null) goto L236;
        r165 = String.valueOf(((PicInfo) ZeusTransformUtils.preCheckCast(d.a.p.e((Iterable) ZeusTransformUtils.preCheckCast(this.screenshotInfo, Iterable.class, "com.obric.aiagent.plugin")), PicInfo.class, "com.obric.aiagent.plugin")).getTosKey());     // Catch: JsonSyntaxException -> L268
    L236:
        r5.put("o_screenshot", r165);     // Catch: JsonSyntaxException -> L268
        if (this.debugImageTos == null) goto L239;
        r5.put("o_global_search_eval", "1");     // Catch: JsonSyntaxException -> L268
        d.x r166 = d.x.f38692a;     // Catch: JsonSyntaxException -> L268
        d.x r167 = d.x.f38692a;     // Catch: JsonSyntaxException -> L268
    L239:
        JSONObject r168 = (JSONObject) ZeusTransformUtils.preCheckCast(r11.f38504a, JSONObject.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L268
        String r169 = this.debugImageTos;     // Catch: JsonSyntaxException -> L268
        if (r169 != null) goto L243;
        r169 = String.valueOf(((PicInfo) ZeusTransformUtils.preCheckCast(d.a.p.e((Iterable) ZeusTransformUtils.preCheckCast(this.screenshotInfo, Iterable.class, "com.obric.aiagent.plugin")), PicInfo.class, "com.obric.aiagent.plugin")).getTosKey());     // Catch: JsonSyntaxException -> L268
    L243:
        r168.put("o_screenshot", r169);     // Catch: JsonSyntaxException -> L268
        d.h.b.ae.j((Map) ZeusTransformUtils.preCheckCast(this.unUsedUpdateImageInfo, Map.class, "com.obric.aiagent.plugin")).remove(((PicInfo) ZeusTransformUtils.preCheckCast(d.a.p.e((Iterable) ZeusTransformUtils.preCheckCast(this.screenshotInfo, Iterable.class, "com.obric.aiagent.plugin")), PicInfo.class, "com.obric.aiagent.plugin")).getTosKey());     // Catch: JsonSyntaxException -> L268
        r5.put("o_screenshot_state", "1");     // Catch: JsonSyntaxException -> L268
        long r170 = r164;
        String r171 = null;
    L244:
        r155.put("image_upload_latency", r170);     // Catch: JsonSyntaxException -> L268
        r155.put("query_ready_latency", r15);     // Catch: JsonSyntaxException -> L268
        r155.put("query_uplink_latency", r156);     // Catch: JsonSyntaxException -> L268
        long r172 = Math.max(this.asrStartTime, this.activeTime);     // Catch: JsonSyntaxException -> L268
        this.asrStartTime = r172;     // Catch: JsonSyntaxException -> L268
        r155.put("asr_start_latency", r172 - this.activeTime);     // Catch: JsonSyntaxException -> L268
        long r173 = this.asrEndTime;     // Catch: JsonSyntaxException -> L268
        if (r173 > this.asrStartTime) goto L248;
        r173 = System.currentTimeMillis();     // Catch: JsonSyntaxException -> L268
    L248:
        this.asrEndTime = r173;     // Catch: JsonSyntaxException -> L268
        r155.put("asr_end_latency", r173 - this.activeTime);     // Catch: JsonSyntaxException -> L268
        r5.put("o_latency_info", r155.toString());     // Catch: JsonSyntaxException -> L268
    L263:
        if (r153 == false) goto L265;
        String r174 = "1";
    L266:
        r5.put("o_is_desktop", r174);     // Catch: JsonSyntaxException -> L268
        ((JSONObject) ZeusTransformUtils.preCheckCast(r11.f38504a, JSONObject.class, "com.obric.aiagent.plugin")).put("o_screenshot_state", r5.get("o_screenshot_state"));     // Catch: JsonSyntaxException -> L268
        r43 = r171;
        r40 = r138;
        goto L294
    L265:
        r174 = "0";
        goto L266
    L232:
        r163 = null;
        goto L233
    L214:
        if (this.debugImageTos != null) goto L229;
        if (this.isFocusedWindowSecure == false) goto L220;
        r5.put("o_screenshot_state", "0");     // Catch: JsonSyntaxException -> L268
        r171 = REASON_SECURE_WINDOW;
    L219:
        r170 = r156;
        goto L244
    L220:
        if (r159 == false) goto L222;
        r5.put("o_screenshot_state", "2");     // Catch: JsonSyntaxException -> L268
        r171 = REASON_UPLOAD_TIMEOUT;
        goto L219
    L222:
        if (r160 == true) goto L228;
        if (r161 == true) goto L228;
        if (r154 == false) goto L227;
        r5.put("o_screenshot_state", "0");     // Catch: JsonSyntaxException -> L268
        r171 = REASON_FOREGROUND_IS_HOST;
        goto L219
    L227:
        r5.put("o_screenshot_state", "0");     // Catch: JsonSyntaxException -> L268
        r171 = REASON_NO_SCREENSHOT_TO_UPLOAD;
    L228:
        r5.put("o_screenshot_state", "0");     // Catch: JsonSyntaxException -> L268
        r171 = REASON_REALTIME_IMG_NO_SCREENSHOT;
        goto L219
    L210:
        r160 = false;
        goto L211
    L204:
        r158 = false;
        goto L205
    L191:
        if (this.skipWaitForScreenShot == true) goto L201;
        if (this.screenshotInfo.isEmpty() == false) goto L201;
        if (d.h.b.o.a(com.obric.agent.d.f14409a.d(), r28.getIntentModel()) == false) goto L201;
        this.skipWaitForScreenShot = true;     // Catch: JsonSyntaxException -> L137
        if (r28.getQueryWithPicTimeout() <= 0) goto L199;
        long r175 = r28.getQueryWithPicTimeout();     // Catch: JsonSyntaxException -> L137
    L200:
        kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r175, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);     // Catch: JsonSyntaxException -> L137
        goto L201
    L199:
        r175 = 5000;
    L249:
        r210 = r4;
        r5.put("o_screenshot_state", "0");     // Catch: JsonSyntaxException -> L268
        if (this.isFocusedWindowSecure == false) goto L253;
        r171 = REASON_SECURE_WINDOW;
        goto L263
    L253:
        if (this.screenshotUploadFailed == false) goto L255;
        r171 = REASON_UPLOAD_FAILED;
        goto L263
    L255:
        if (r153 == false) goto L257;
        r171 = REASON_HOME_ACTIVITY;
        goto L263
    L257:
        if (r154 == false) goto L259;
        r171 = REASON_FOREGROUND_IS_HOST;
        goto L263
    L259:
        if (r139 == true) goto L261;
        r171 = REASON_AUTO_UPLOAD_DISABLED;
        goto L263
    L261:
        r171 = REASON_NO_SCREENSHOT_TO_UPLOAD;
    L268:
        e = e;
    L273:
        r130 = e;
    L274:
        r40 = r138;
    L184:
        r153 = false;
        goto L185
    L176:
        if (((Collection) ZeusTransformUtils.preCheckCast(r151, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L178;
    L270:
        r210 = r4;
        r40 = r138;
        r43 = null;
        goto L294
    L164:
        if (r148.getSemanticeScreenShotEnabled() != true) goto L166;
        r149 = true;
        goto L167
    L156:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.screenshotInfo, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L158;
    L159:
        r5.put("o_upload_screenshot", "true");     // Catch: JsonSyntaxException -> L137
        goto L169
    L158:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.realtimeImgInfo, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L169;
    L151:
        r147 = null;
        goto L152
    L143:
        r141 = r131;
    L271:
        e = e;
        r210 = r4;
    L133:
        r140 = false;
    L137:
        e = move-exception;
        r130 = e;
        r210 = r4;
        goto L274
    L132:
        r139 = r34;
        r138 = r40;
        goto L133
    L125:
        r137 = null;
        goto L126
    L121:
        r135 = r131;
        goto L122
    L116:
        r137 = (CharSequence) ZeusTransformUtils.preCheckCast(this.mRealTimeContext.getCurTopAppName(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L93
        goto L126
    L108:
        ComponentName r176 = (ComponentName) ZeusTransformUtils.preCheckCast(d.a.p.f((Iterable) ZeusTransformUtils.preCheckCast(this.visibleActivities, Iterable.class, "com.obric.aiagent.plugin")), ComponentName.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L275
        if (r176 == null) goto L112;
        r132 = r176.getClassName();     // Catch: JsonSyntaxException -> L93
        goto L114
    L112:
        r132 = null;
        goto L114
    L99:
        ComponentName r177 = (ComponentName) ZeusTransformUtils.preCheckCast(d.a.p.f((Iterable) ZeusTransformUtils.preCheckCast(this.visibleActivities, Iterable.class, "com.obric.aiagent.plugin")), ComponentName.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L275
        if (r177 == null) goto L103;
        r131 = r177.getPackageName();     // Catch: JsonSyntaxException -> L93
        goto L105
    L103:
        r131 = null;
        goto L105
    L81:
        r41 = "unlocked_screen";
        goto L82
    L74:
        r40 = 0;
        goto L76
    L60:
        r32 = false;
        goto L61
    L55:
        if (r30.getAutoImageUploadEnabled() == true) goto L57;
        r31 = true;
    L63:
        th = move-exception;
        d.n.a r178 = d.n.f38560a;
        r33 = d.n.f(d.o.a(th));
        goto L66
    L51:
        r28 = null;
        goto L558
    L18:
        r14 = 0;
    L14:
        r10 = true;
        goto L15
    L5:
        if (d.h.b.o.a(r6, this.realtimeCollectionId) == false) goto L7;
        r9 = true;
        goto L9
    }

    private final void checkExtValueSize(Map<String, String> r8) {
        HashMap r9 = new HashMap((Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin"));
        kotlinx.coroutines.i.a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(bs.f39169a, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final boolean isHomeActivity(Context r6, ComponentName r7) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        Intent r8 = new Intent("android.intent.action.MAIN");
        r8.addCategory("android.intent.category.HOME");
        List<ResolveInfo> r9 = r5.getPackageManager().queryIntentActivities(r8, 65536);
        d.h.b.o.c(r9, "queryIntentActivities(...)");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L5;
    L7:
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L19;
        ActivityInfo r12 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r11.next(), ResolveInfo.class, "com.obric.aiagent.plugin")).activityInfo;
        if (r12 != null) goto L14;
    L12:
        boolean r13 = false;
    L18:
        if (r13 == false) goto L9;
        return true;
    L14:
        if (d.h.b.o.a(r12.packageName, r7.getPackageName()) == false) goto L12;
        if (d.h.b.o.a(r12.name, r7.getClassName()) == false) goto L12;
        r13 = true;
    L19:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final boolean isHostForeground() {
        if (this.visibleActivities.isEmpty() == false) goto L5;
        return true;
    L5:
        String r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageName();
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.visibleActivities, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L8;
    L10:
        Iterator r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L28;
        String r3 = ((ComponentName) ZeusTransformUtils.preCheckCast(r7.next(), ComponentName.class, "com.obric.aiagent.plugin")).getPackageName();
        d.h.b.o.c(r3, "getPackageName(...)");
        if (d.h.b.o.a(r3, r0) == false) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == false) goto L12;
        return false;
    L16:
        if (d.h.b.o.a(r3, "com.larus.nova") == true) goto L18;
        r4 = true;
        goto L19
    L28:
        return true;
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L10;
        return true;
    }

    private final Map<String, String> buildShortCutInstructionCandidates(final Integer r6) {
        monitor-enter(this);
        d.n.j r7 = d.n.m.a(d.n.m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(this.shortCutTasks, Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$AgentServiceImpl$P5XrQi3oXcwcMs5DkINgzBYNmEs.INSTANCE), new $$Lambda$AgentServiceImpl$ZGZfLWQCK7XOuEUPXntWEvOec0(r6));     // Catch: Throwable -> L22
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        Iterator r8 = r7.a();     // Catch: Throwable -> L22
    L5:
        if (r8.hasNext() == false) goto L13;
        ShortcutTask r1 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r8.next(), ShortcutTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        String r2 = r1.getId();     // Catch: Throwable -> L22
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        String r3 = r1.getShortInstruct();     // Catch: Throwable -> L22
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        d.m r4 = d.s.a(r2, r3);     // Catch: Throwable -> L22
        r0.put(r4.a(), r4.b());     // Catch: Throwable -> L22
        goto L5
    L13:
        LinkedHashMap r9 = new LinkedHashMap();     // Catch: Throwable -> L22
        Iterator r5 = r0.entrySet().iterator();     // Catch: Throwable -> L22
    L15:
        if (r5.hasNext() == false) goto L19;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L15;
        r9.put(r10.getKey(), r10.getValue());     // Catch: Throwable -> L22
        goto L15
    L19:
        Map<String, String> r11 = (Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(this);
        return r11;
    L22:
        th = move-exception;
        throw th;
    }

    private static final boolean buildShortCutInstructionCandidates$lambda$67$lambda$63(ShortcutTask r2) {
        d.h.b.o.e(r2, "it");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.getShortInstruct(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        return !r4;
    L5:
        if (d.o.o.d(r3) == true) goto L8;
        r4 = false;
        goto L10
    }

    private static final boolean buildShortCutInstructionCandidates$lambda$67$lambda$64(Integer r1, ShortcutTask r2) {
        d.h.b.o.e(r2, "it");
        if (r1 == null) goto L8;
        int r3 = r2.getTaskMode();
        if (r1.intValue() == r3) goto L8;
        return false;
    L8:
        return true;
    }

    private final ShortcutTask getShortTaskForQuery(String r9, List<ShortcutTask> r10, Integer r11) {
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r8.iterator();
        float r1 = -1.0f;
    L3:
        boolean r3 = true;
        if (r13.hasNext() == false) goto L19;
        Object r2 = r13.next();
        ShortcutTask r4 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r2, ShortcutTask.class, "com.obric.aiagent.plugin");
        String r5 = r4.getShortInstruct();
        if (r5 == null) goto L16;
        r1 = Math.max(r1, com.obric.agent.e.b.f14446a.b(r5, r9));
        if (com.obric.agent.e.b.f14446a.a(r5, r9) == false) goto L13;
        if (r11 != null) goto L11;
    L12:
        boolean r6 = true;
    L14:
        if (r6 != true) goto L16;
    L17:
        if (r3 == false) goto L3;
        r12.add(r2);
        goto L3
    L11:
        if (r11.intValue() == r4.getTaskMode()) goto L12;
    L13:
        r6 = false;
    L16:
        r3 = false;
        goto L17
    L19:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
        com.obric.agent.e.a.f14445a.a(r1, !((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty());
        return (ShortcutTask) ZeusTransformUtils.preCheckCast(d.a.p.l(r14), ShortcutTask.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.agent.IAgentService
    public void onMessageInputtingStateChange(boolean r7) {
        if (r7 == true) goto L4;
        return;
    L4:
        if (this.shouldRequestAssist == false) goto L8;
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new aa(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }

    @Override // com.obric.agent.IAgentService
    public void onAsrStart(String r10) {
        ILogDepend.Companion.d(TAG, "onAsrStart localMsgId: " + r10);
        String r1 = null;
        if (com.obric.agent.w.a(r10) == false) goto L5;
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new v(r10, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    L5:
        this.asrStartTime = System.currentTimeMillis();
        this.asrEndTime = 0;
        this.asrIng = true;
        PicInfo r0 = (PicInfo) ZeusTransformUtils.preCheckCast(d.a.p.f((Iterable) ZeusTransformUtils.preCheckCast(this.screenshotInfo, Iterable.class, "com.obric.aiagent.plugin")), PicInfo.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        r1 = r0.getTosKey();
    L9:
        if (this.firstQuery == true) goto L11;
        return;
    L11:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.uploadingScreenshotInfo, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L25;
        JSONObject r9 = new JSONObject();
        r9.put("screenshotInfo", 0);
        IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L16;
        r2.reportToFlow("o_asr_pc", r9);
    L16:
        if (com.obric.agent.w.a(r1) == false) goto L26;
        IFlowVoiceInteractionIDL r3 = com.obric.aiagent.assistant.idl.ax.a(d.h.b.aa.b(IFlowVoiceInteractionIDL.class));
        if (r3 == null) goto L20;
        r3.updateScreenshotForAsr(r1);
    L20:
        r9.put("screenshotInfo", 1);
        IAppLog r11 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L27;
        r11.reportToFlow("o_asr_pc", r9);
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // com.obric.agent.IAgentService
    public void onAsrEnd() {
        ILogDepend.Companion.d(TAG, "onAsrEnd mAsrLocalMsgId: " + this.mAsrLocalMsgId);
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new u(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        this.asrEndTime = System.currentTimeMillis();
        ILogDepend.Companion.d(TAG, "onAsrEnd asrEndTime: " + this.asrEndTime);
        this.asrIng = false;
    }

    private final String resolveQueryCallScene(Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        return null;
    L13:
        if (d.h.b.o.a(r6.get(EXT_O_IS_DEVICE_LOCKED), "1") == false) goto L15;
    L38:
        return CALL_SCENE_LOCK_SCREEN;
    L15:
        if (d.h.b.o.a(r6.get(EXT_OBRIC_MESSAGE_POSITION_LEVEL1), CALL_SCENE_LOCK_SCREEN) == true) goto L38;
        if (d.h.b.o.a(r6.get(EXT_O_SCREEN_POSITION), CALL_SCENE_LOCK_SCREEN) == true) goto L38;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r6.get(EXT_O_TOP_APP), String.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L23;
        String r2 = takeIfUsefulScene(r1);
        if (r2 == null) goto L23;
    L27:
        if (r2 == null) goto L34;
        if (d.h.b.o.a(r2, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageName()) == true) goto L34;
        if (d.h.b.o.a(r2, "com.larus.nova") == true) goto L34;
        return r2;
    L34:
        if (d.h.b.o.a(r6.get(EXT_OBRIC_WINDOW_MODE), "full_screen") == false) goto L37;
        return CALL_SCENE_DOUBAO_CHAT_PAGE;
    L37:
        return null;
    L23:
        String r3 = (String) ZeusTransformUtils.preCheckCast(r6.get(EXT_OBRIC_MESSAGE_POSITION_LEVEL2), String.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L26;
        r2 = takeIfUsefulScene(r3);
        goto L27
    L26:
        r2 = null;
        goto L27
    L5:
        if (r6.isEmpty() == true) goto L8;
        r0 = false;
        goto L10
    }

    private final boolean isContinuousTalk(Map<String, String> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.get(EXT_IS_OBRIC_CONTINUOUS_TALK), String.class, "com.obric.aiagent.plugin");
    L7:
        return d.h.b.o.a(r3, "1");
    L5:
        r3 = null;
        goto L7
    }

    private final boolean isOmniTask(Map<String, String> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        String r6 = null;
        if (r4 == null) goto L5;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 == null) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L9:
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L14;
        return true;
    L14:
        if (d.h.b.o.a(r1, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == false) goto L16;
        return true;
    L16:
        if (d.h.b.o.a(r1, IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI) == true) goto L26;
        if (r4 == null) goto L20;
        r6 = (String) ZeusTransformUtils.preCheckCast(r4.get(EXT_O_COMPLEX_TASK), String.class, "com.obric.aiagent.plugin");
    L20:
        if (d.h.b.o.a(r6, "1") == true) goto L27;
        return false;
    L27:
        return true;
    L26:
        return true;
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    private final String takeIfUsefulScene(String r3) {
        if (r3 == null) goto L17;
        boolean r1 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
    L13:
        r1 = false;
    L14:
        if (r1 == false) goto L17;
        return r3;
    L7:
        if (d.h.b.o.a(r3, "other") == true) goto L13;
        if (d.h.b.o.a(r3, "unlocked_screen") == true) goto L13;
        if (d.h.b.o.a(r3, CALL_SCENE_LOCK_SCREEN) == true) goto L13;
    L17:
        return null;
    }

    private final void onServerReply(String r3, String r4, Map<String, String> r5, boolean r6) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        com.obric.agent.trace.q r7 = com.obric.agent.trace.q.f15713a;
        if (r3 != null) goto L5;
        String r1 = "";
    L6:
        r7.a(r1, r4, r2, r6);
        com.obric.agent.utils.n r8 = com.obric.agent.utils.n.f16046a;
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r8.a(r3, r4, r2, r6);
        return;
    L5:
        r1 = r3;
        goto L6
    }

    @Override // com.obric.agent.IAgentService
    public void handleQAWithSearchIntent(String[] r21, String r22, DispatchContext r23) {
        d.h.b.o.e(r23, "dispatchContext");
        Long r1 = r23.getQuestionId();
        if (r1 == null) goto L6;
        String r2 = r1.toString();
        if (r2 == null) goto L6;
    L7:
        String r6 = r2;
        ArrayList r3 = new ArrayList();
        if (r21 == null) goto L19;
        int r4 = 0;
        int r5 = r21.length;
    L10:
        if (r4 >= r5) goto L19;
        String r7 = r21[r4];
        IEntityManager r8 = getEntityManager();
        if (r8 == null) goto L14;
        List<AppEntity> r9 = r8.getEntityByEcaId(r7);
    L15:
        if (r9 != null) goto L17;
        r9 = d.a.p.b();
    L17:
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin"));
        r4 = r4 + 1;
        goto L10
    L14:
        r9 = null;
    L19:
        if (r3.isEmpty() == false) goto L22;
        ILogDepend.Companion.i(TAG, "handleIntentMessageCard, realEntities is empty");
        return;
    L22:
        Gson r0 = EntityExtKt.a();
        DataSource r10 = new DataSource("System", "System_QAWithSearch", null, 4, null);
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r11, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r11.iterator();
    L24:
        if (r13.hasNext() == false) goto L26;
        AppEntity r14 = (AppEntity) ZeusTransformUtils.preCheckCast(r13.next(), AppEntity.class, "com.obric.aiagent.plugin");
        r12.add(AppIntentCardData.Companion.a(r14));
        goto L24
    L26:
        String r15 = r0.toJson(new AppIntentMessage(r10, true, false, null, null, false, false, null, (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin"), null, 764, null));
        ILogDepend.Companion.d(TAG, "handleQAWithSearchIntent");
        IAgentService r16 = (IAgentService) ZeusTransformUtils.preCheckCast(this, IAgentService.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r15);
        IAgentService.a.a(r16, r15, OAppIntentBizContentType.SEARCH_RESULT_CARD, r6, 0, null, 24, null);
        return;
    L6:
        r2 = UUID.randomUUID().toString();
        d.h.b.o.c(r2, "toString(...)");
        goto L7
    }

    @Override // com.obric.agent.IAgentService
    public void showSearchCard(String r3, List<? extends AppEntity> r4, String r5) {
        List<? extends AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "replyId");
        d.h.b.o.e(r6, "entityList");
        d.h.b.o.e(r5, "response");
        showSearchResult(r3, r6, r5);
    }

    @Override // com.obric.agent.IAgentService
    public void onLiveViewModeDeactivate(String r2) {
        d.h.b.o.e(r2, "reason");
        if (d.h.b.o.a(r2, this.DEACTIVATE_MULTIMODAL_REASON_CAMERA_BUTTON) == true) goto L7;
        if (d.h.b.o.a(r2, this.DEACTIVATE_MULTIMODAL_REASON_CAMERA_WINDOW_REMOVED) == true) goto L7;
        return;
    L7:
        if (this.needRestartSession.get() == false) goto L11;
        this.needRestartSession.set(false);
        ILogDepend.Companion.d(TAG, "onLiveViewModeDeactivate restart session");
        return;
    }

    @Override // com.obric.agent.IAgentService
    public Object isQueryInterrupt(String r1, d.c.d<? super Boolean> r2) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return d.c.b.a.b.a(false);
    }

    @Override // com.obric.agent.IAgentService
    public boolean isQueryTimeout(String r4) {
        d.h.b.o.e(r4, "messageId");
        String r5 = (String) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new q(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), String.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
        boolean r6 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(this.timeoutMsgSet, Iterable.class, "com.obric.aiagent.plugin"), r5);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r6;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.agent.IAgentService
    public Object onUserConfirm(String[] r9, String r10, DispatchContext r11, d.c.d<? super IntentResult<AppEntity[]>> r12) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r13 = new d.c.i(d.c.a.b.a(r8));
        d.c.d r0 = (d.c.d) ZeusTransformUtils.preCheckCast(r13, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ad(r10, r9, r0, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        Object r14 = r13.a();
        if (r14 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r8);
    L5:
        return r14;
    }

    @Override // com.obric.agent.IAgentService
    public void notifyUserAgreePrivacy() {
        com.obric.memorydata.sdk.a.f33793a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.agent.IAgentService
    public void terminateService() {
        com.obric.memorydata.sdk.a.f33793a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.agent.IAgentService
    public void setObricStrategy(String r1) {
        d.h.b.o.e(r1, "appVariant");
        com.obric.agent.h.a.f14569a.a(r1);
    }

    @Override // com.obric.agent.IAgentService
    public IntentDebugReport getIntentExecution(String r1) {
        d.h.b.o.e(r1, "messageId");
        return com.obric.agent.trace.q.f15713a.d(r1);
    }

    public final Object saveEntityFileToLocal(AppEntity r5, b r6, d.c.d<? super Uri> r7) {
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new an(r5, this, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r9);
    }

    private final boolean isNeedRealtimeContext() {
        if (getKeyguardManager().isKeyguardLocked() == true) goto L5;
        return true;
    L5:
        if (this.visibleActivities.contains(this.SECURE_CAMERA_P) == false) goto L7;
        return true;
    L7:
        if (this.visibleActivities.contains(this.SECURE_CAMERA_N) == true) goto L13;
        ILogDepend.Companion.d(TAG, "isNeedRealtimeContext isKeyguardLocked");
        return false;
    L13:
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [T, java.io.File] */
    private final Object saveFileFromStream(File r16, String r17, AppEntity r18, Uri r19, b r20, d.c.d<? super Uri> r21) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r20, b.class, "com.obric.aiagent.plugin");
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (this.mCachedFileEntityMap.a() != null) goto L6;
        StringBuilder r2 = new StringBuilder().append(FILE_PREFIX);
        String r3 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{d.c.b.a.b.a(this.mCachedFileEntityMap.size())}, 1));
        d.h.b.o.c(r3, "format(...)");
        String r4 = r2.append(r3).toString();
    L5:
        String r7 = r4;
        File r5 = new File(r16, r7);
        if (r5.exists() == true) goto L12;
        r5.mkdirs();
    L12:
        d.h.b.z.f r10 = new d.h.b.z.f();
        r10.f38504a = new File(r5, r17);
        ILogDepend.Companion.d(TAG, "updateActionContext saveFileFromStream");     // Catch: Exception -> L15
        kotlinx.coroutines.i.a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(bs.f39169a, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ao(r10, this, r18, r19, r6, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);     // Catch: Exception -> L15
        Uri r8 = Uri.fromFile((File) ZeusTransformUtils.preCheckCast(r10.f38504a, File.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L15
        ((Map) ZeusTransformUtils.preCheckCast(this.mCachedFileUriMap, Map.class, "com.obric.aiagent.plugin")).put(r8.toString(), r10.f38504a);     // Catch: Exception -> L15
        return r8;
    L15:
        e = move-exception;
        ILogDepend.Companion.e("saveEntityFileToLocal", "errorMsg: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L6:
        r4 = (String) ZeusTransformUtils.preCheckCast(this.mCachedFileEntityMap.a(), String.class, "com.obric.aiagent.plugin");
        File r9 = (File) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(this.mCachedFileEntityMap, Map.class, "com.obric.aiagent.plugin")).get(r4), File.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L5;
        d.c.b.a.b.a(r9.delete());
        goto L5
    }

    @Override // com.obric.agent.IAgentService
    public void scheduleTimerTask(int r3, String r4, String r5, String r6) {
        d.h.b.o.e(r4, "packageName");
        ISecureLogDepend.Companion.i(TAG, "scheduleTimerTask id:" + r3 + " package:" + r4 + " query:" + r5 + " intent:" + r6);
        IAutoActionService r2 = (IAutoActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionService.class), IAutoActionService.class, "com.obric.aiagent.plugin");
        boolean r0 = true;
        if (r2 != null) goto L5;
    L7:
        r0 = false;
    L8:
        if (r0 == true) goto L9;
    L9:
        return;
    L5:
        if (r2.scheduleTimerTask(r3, r4, r5, r6) != true) goto L7;
        goto L7
    }

    @Override // com.obric.agent.IAgentService
    public void scheduleShortcutTask(ShortcutTask r10, String r11, IntentParams r12, String r13) {
        IntentParams r9 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r12, IntentParams.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "task");
        d.h.b.o.e(r11, MemorySourceLinkType.INTENT);
        ILogDepend.Companion.i(TAG, "scheduleShortcutTask");
        IDialogStateManager r14 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        boolean r1 = true;
        if (r14 != null) goto L5;
    L7:
        boolean r15 = false;
    L8:
        if (r15 == false) goto L14;
        ILogDepend.Companion.e(TAG, "not login, cancel ShortcutTask");
        IFlowUiIDL r16 = com.obric.aiagent.assistant.idl.aw.a(d.h.b.aa.b(IFlowUiIDL.class));
        if (r16 == null) goto L30;
        r16.openChatActivity(com.obric.agent.h.f14566c.ordinal());
        return;
    L30:
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(r9, SystemAutoActionParams.class) == false) goto L31;
        com.obric.eventkit.task.model.a r17 = com.obric.agent.intents.a.f14662a.a((EventTask) ZeusTransformUtils.preCheckCast(r10, EventTask.class, "com.obric.aiagent.plugin"));
        r17.a(1);
        com.obric.agent.utils.o r18 = com.obric.agent.utils.o.f16054a;
        String r19 = com.obric.capabilitykit.common.a.a().toJson(r17);
        d.h.b.o.c(r19, "toJson(...)");
        Map<String, String> r8 = r18.a(r19, r13);
        IFlowMessageIDL r3 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
        if (r3 == null) goto L21;
        String r20 = r17.c();
        if (r20 != null) goto L20;
        r20 = " ";
    L20:
        r3.sendMessageWithExtra(null, r20, "obric_conditional_task", "obric_conditional_task", r8);
    L21:
        IFlowAppStateIDL r21 = com.obric.aiagent.assistant.idl.s.a(d.h.b.aa.b(IFlowAppStateIDL.class));
        if (r21 != null) goto L24;
    L26:
        r1 = false;
    L27:
        if (r1 == false) goto L32;
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new aq(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L32:
        return;
    L24:
        if (r21.isAppBackground() != true) goto L26;
    L31:
        return;
    L5:
        if (r14.isLogin() == true) goto L7;
        r15 = true;
        goto L8
    }

    @Override // com.obric.agent.IAgentService
    public void scheduleConditionTask(ConditionTask r11, String r12, IntentParams r13) {
        IntentParams r14 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r13, IntentParams.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "task");
        d.h.b.o.e(r12, MemorySourceLinkType.INTENT);
        IDialogStateManager r15 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        boolean r0 = false;
        if (r15 == null) goto L8;
        if (r15.isLogin() == true) goto L8;
        r0 = true;
    L8:
        if (r0 == false) goto L13;
        ILogDepend.Companion.i(TAG, "not login, cancel ConditionTask");
        IFlowUiIDL r10 = com.obric.aiagent.assistant.idl.aw.a(d.h.b.aa.b(IFlowUiIDL.class));
        if (r10 == null) goto L15;
        r10.openChatActivity(com.obric.agent.h.f14566c.ordinal());
        return;
    L15:
        return;
    L13:
        ILogDepend.Companion.i(TAG, "scheduleConditionTask");
        com.obric.agent.e.a(com.obric.agent.e.f14435a, "scheduleConditionTask", 0, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ap(r14, r11, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final void notifyEventTaskScheduleSent(IMMessage r3) {
        com.obric.eventkit.task.model.a r2 = parseEventTaskInfo(r3);
        if (r2 != null) goto L5;
        return;
    L5:
        ITaskManagerApi r4 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        r4.onTaskScheduleMessageSent(r2.b());
        return;
    }

    private final void notifyConditionTaskSendTerminal(IMMessage r3) {
        switch(r3.getMessageStatusLocal()) {
            case 11: goto L5;
            case 12: goto L5;
            case 13: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        com.obric.eventkit.task.model.a r4 = parseEventTaskInfo(r3);
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.a() != 2) goto L21;
        Integer r0 = r4.g();
        if (r0 != null) goto L14;
        return;
    L14:
        if (r0.intValue() != 2) goto L23;
        String r5 = r4.b();
        if (r5 != null) goto L19;
        return;
    L19:
        this.conditionTaskSendResultChannel.a_(r5);
        return;
    L23:
        return;
    }

    private final void notifyEventTaskScheduleInterrupted(IMMessage r3) {
        com.obric.eventkit.task.model.a r2 = parseEventTaskInfo(r3);
        if (r2 != null) goto L5;
        return;
    L5:
        ITaskManagerApi r4 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        r4.onTaskScheduleFailed(r2.b(), -5, "message send interrupted");
        return;
    }

    private final void notifyEventTaskScheduleFailed(IMMessage r3) {
        com.obric.eventkit.task.model.a r2 = parseEventTaskInfo(r3);
        if (r2 != null) goto L5;
        return;
    L5:
        ITaskManagerApi r4 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        r4.onTaskScheduleFailed(r2.b(), -4, "message send failed");
        return;
    }

    private final com.obric.eventkit.task.model.a parseEventTaskInfo(IMMessage r4) {
        Map<String, String> r3 = r4.getExt();
        Object r5 = null;
        if (r3 == null) goto L17;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3.get("o_event_task"), String.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L17;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L9
        Object r7 = d.n.f((com.obric.eventkit.task.model.a) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r6, com.obric.eventkit.task.model.a.class), com.obric.eventkit.task.model.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
    L12:
        if (d.n.b(r7) == true) goto L16;
        r5 = r7;
    L16:
        return (com.obric.eventkit.task.model.a) ZeusTransformUtils.preCheckCast(r5, com.obric.eventkit.task.model.a.class, "com.obric.aiagent.plugin");
    L9:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
    L17:
        return null;
    }

    @Override // com.obric.agent.IAgentService
    public void tryScheduleConditionTask(ConditionTask r30, String r31, IntentParams r32, TaskKnowledge r33, int r34, String r35) {
        IntentParams r2 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r32, IntentParams.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r31, MemorySourceLinkType.INTENT);
        IDialogStateManager r4 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        boolean r5 = false;
        if (r4 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == false) goto L14;
        ILogDepend.Companion.e(TAG, "not login, cancel ConditionTask");
        onConditionTaskScheduleFail(r30, "not login, cancel ConditionTask");
        IFlowUiIDL r0 = com.obric.aiagent.assistant.idl.aw.a(d.h.b.aa.b(IFlowUiIDL.class));
        if (r0 == null) goto L56;
        r0.openChatActivity(com.obric.agent.h.f14566c.ordinal());
        return;
    L56:
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(r2, SystemAutoActionParams.class) == true) goto L17;
        onConditionTaskScheduleFail(r30, "intentParams is not SystemAutoActionParams");
        return;
    L17:
        if (r33 != null) goto L19;
        TaskKnowledge r23 = new TaskKnowledge(false, null, null, 0, true, null, 32, null);
    L21:
        if (r30 == null) goto L23;
        String r18 = r30.getId();
    L24:
        if (r30 == null) goto L27;
        String r7 = r30.getOmniModel();
        if (r7 == null) goto L27;
    L28:
        String r22 = r7;
        String r19 = ((SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r2, SystemAutoActionParams.class, "com.obric.aiagent.plugin")).getInstruction();
        if (r30 == null) goto L31;
        Map<String, String> r26 = r30.getExt();
    L32:
        com.obric.eventkit.task.model.a r3 = new com.obric.eventkit.task.model.a(2, r18, r19, null, Integer.valueOf(r34), r22, r23, 1, true, r26, 8, null);
        if (r30 == null) goto L35;
        r3.a(r30.getId());
    L35:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.c(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L38;
    L41:
        boolean r9 = true;
    L42:
        if (r9 == false) goto L45;
        onConditionTaskScheduleFail(r30, "instruction is empty");
        return;
    L45:
        com.obric.agent.utils.o r1 = com.obric.agent.utils.o.f16054a;
        String r10 = com.obric.capabilitykit.common.a.a().toJson(r3);
        d.h.b.o.c(r10, "toJson(...)");
        Map<String, String> r11 = r1.a(r10, r35);
        IFlowMessageIDL r12 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
        if (r12 == null) goto L48;
        r12.sendMessageWithExtra(null, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_try_run_prefix, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_try_run_prefix")) + r3.c(), "obric_conditional_task", "obric_conditional_task", r11);
    L48:
        IFlowAppStateIDL r13 = com.obric.aiagent.assistant.idl.s.a(d.h.b.aa.b(IFlowAppStateIDL.class));
        if (r13 != null) goto L51;
    L53:
        if (r5 == false) goto L57;
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new at(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L57:
        return;
    L51:
        if (r13.isAppBackground() != true) goto L53;
        r5 = true;
        goto L53
    L38:
        if (d.o.o.d(r8) == true) goto L41;
        r9 = false;
        goto L42
    L31:
        r26 = null;
    L27:
        r7 = IOmniModelService.Companion.a().defaultDisplayModel();
        goto L28
    L23:
        r18 = null;
        goto L24
    L19:
        r23 = r33;
        goto L21
    L5:
        if (r4.isLogin() == true) goto L7;
        r6 = true;
        goto L8
    }

    private final void onConditionTaskScheduleFail(ConditionTask r3, String r4) {
        ITaskManagerApi r2 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L10;
        if (r3 == null) goto L11;
        String r5 = r3.getId();
        if (r5 == null) goto L12;
        r2.onTaskScheduleFailed(r5, 1, r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.obric.agent.IAgentService
    public boolean hasSemantic() {
        if (this.entityUploading == false) goto L5;
        return true;
    L5:
        if (isScreenshotUploading() == false) goto L7;
        return true;
    L7:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.realtimeImgInfo, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L9;
        return true;
    L9:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.screenshotInfo, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L16;
        return false;
    L16:
        return true;
    }

    @Override // com.obric.agent.IAgentService
    public boolean isScreenshotSecure() {
        return this.isFocusedWindowSecure;
    }

    @Override // com.obric.agent.IAgentService
    public boolean isMemoryRecommendActivityEnable() {
        boolean r1 = com.obric.agent.utils.t.f16075a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.memorydata", "com.obric.memorydata.recommend.ui.recommend.RecommendActivity");
        boolean r2 = com.obric.agent.utils.t.f16075a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.proactive", "com.obric.proactive.ui.recommend.RecommendActivity");
        boolean r4 = com.obric.agent.utils.t.f16075a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.proactive", " com.obric.proactive.ui.recommend.ProactiveActivity");
        int r8 = Settings.Global.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver(), "settings_proactive_memory_is_enabled");     // Catch: Exception -> L5
    L7:
        ILogDepend.Companion.i(TAG, "isMemoryRecommendActivityEnable, deprecatedRecommendActivityEnable: " + r1 + ", newRecommendActivityEnable: " + r2 + ", RecommendActivityEnableForPacific087: " + r4 + ", recommendActivityEnableAfterPacific087: " + r8);
        if (r1 == true) goto L12;
        if (r2 == true) goto L12;
        if (r8 == 1) goto L12;
        return false;
    L12:
        return true;
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "recommendActivityEnableAfterPacific087, getInt, error: " + e);
        r8 = 0;
        goto L7
    }

    @Override // com.obric.agent.IAgentService
    public void setSystemProperty(String r1, String r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L7;
        com.obric.aiagent.utils.a.c.f22312a.b(r1, r2);
        return;
    L7:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.agent.IAgentService
    public boolean handleUpdateIntentResult(long r18, IntentResult<?> r20, boolean r21, Map<?, ?> r22, IntentAppAction r23) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r20, "intentResult");
        Object r8 = null;
        if (r23 == null) goto L7;
        ConcurrentHashMap<String, String> r3 = r23.getExt();
        if (r3 == null) goto L7;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L8:
        boolean r9 = d.h.b.o.a(r4, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK);
        ILogDepend.Companion r5 = ILogDepend.Companion;
        StringBuilder r6 = new StringBuilder().append("onUpdateIntentResult questionId: ").append(r18).append(" isFinal: ").append(r20.isFinal()).append(" isStatusChange: ").append(r21).append(" content:");
        String r12 = r20.getDetails();
        if (r12 == null) goto L11;
        Integer r13 = Integer.valueOf(r12.length());
    L12:
        r5.i(TAG, r6.append(r13).append(" ext: ").append(r1).append(" intentResult.ext:").append(r20.getExt()).toString());
        ILogDepend.Companion r7 = ILogDepend.Companion;
        StringBuilder r10 = new StringBuilder().append("onUpdateIntentResult lastSentMessage messageId: ");
        IMMessage r14 = this.lastSentMessage;
        if (r14 == null) goto L15;
        String r15 = r14.getMessageId();
    L16:
        r7.i(TAG, r10.append(r15).toString());
        if (r1 == null) goto L19;
        Object r2 = r1.get(Ext.KEY_INTENT_NAME);
    L21:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L23;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L24:
        ConcurrentHashMap<String, String> r11 = r20.getExt();
        if (r11 == null) goto L27;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r11.get(Ext.KEY_PRIVACY_STATEMENT_AGREED), String.class, "com.obric.aiagent.plugin");
    L28:
        boolean r19 = false;
        if (d.h.b.o.a(r17, "1") == true) goto L31;
        ConcurrentHashMap<String, String> r24 = r20.getExt();
        if (r24 == null) goto L48;
        String r25 = (String) ZeusTransformUtils.preCheckCast(r24.get(Ext.KEY_CONTINUE_DOWNLOAD_CONFIRMED), String.class, "com.obric.aiagent.plugin");
    L50:
        if (d.h.b.o.a(r25, "1") == true) goto L52;
    L64:
        if (r16 == null) goto L68;
        handleRemoteCard(r23, r20, r16, r18);
    L68:
        if (d.h.b.o.a(r16, "System_AutoAction") == false) goto L143;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(r20.getExt(), Map.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L72;
    L75:
        boolean r26 = true;
    L76:
        if (r26 == true) goto L143;
        ConcurrentHashMap<String, String> r27 = r20.getExt();
        if (r27 == null) goto L88;
        String r28 = (String) ZeusTransformUtils.preCheckCast(r27.get("obric_reply_clarify"), String.class, "com.obric.aiagent.plugin");
        if (r28 == null) goto L88;
        if (d.h.b.o.a("1", r28) == false) goto L88;
        if (r9 == false) goto L87;
        IComplexTaskService r29 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
        if (r29 == null) goto L87;
        r29.replyAskUser(String.valueOf(r18), null, r20.getDetails(), null);
    L87:
        return true;
    L88:
        ConcurrentHashMap<String, String> r30 = r20.getExt();
        if (r30 == null) goto L143;
        String r31 = (String) ZeusTransformUtils.preCheckCast(r30.get("obric_session_info"), String.class, "com.obric.aiagent.plugin");
        if (r31 == null) goto L143;
        com.obric.agent.autoaction.a r32 = (com.obric.agent.autoaction.a) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r31, com.obric.agent.autoaction.a.class), com.obric.agent.autoaction.a.class, "com.obric.aiagent.plugin");
        if (r32.a() != 7) goto L95;
    L96:
        String r33 = r20.getDetails();
        if (r33 == null) goto L143;
        IDialogStateManager r34 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r34 == null) goto L101;
        DMState r35 = r34.getCurrentDMState();
    L102:
        if (r35 == null) goto L135;
        List<State> r36 = r35.getActiveTasks();
        if (r36 == null) goto L135;
        Iterator r37 = ((Iterable) ZeusTransformUtils.preCheckCast(r36, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        String r38 = null;
    L107:
        if (r37.hasNext() == false) goto L134;
        Object r39 = r37.next();
        State r40 = (State) ZeusTransformUtils.preCheckCast(r39, State.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r40, TaskState.class) == false) goto L111;
        TaskState r41 = (TaskState) ZeusTransformUtils.preCheckCast(r40, TaskState.class, "com.obric.aiagent.plugin");
    L112:
        if (r41 == null) goto L114;
        TaskInfo r42 = r41.getTaskInfo();
    L115:
        if (r42 == null) goto L119;
        IMMessage r43 = r42.getMessage();
        if (r43 == null) goto L119;
        String r44 = r43.getConversationId();
    L120:
        if (r42 == null) goto L124;
        IMMessage r45 = r42.getMessage();
        if (r45 == null) goto L124;
        String r46 = r45.getMessageId();
    L126:
        if (d.h.b.o.a(r46, String.valueOf(r18)) == true) goto L128;
    L130:
        boolean r47 = r19;
    L131:
        if (r47 == true) goto L132;
        r38 = r44;
        goto L107
    L132:
        r8 = r39;
        r38 = r44;
        goto L134
    L128:
        if (r42.getTaskType() != TaskType.COMPLEX) goto L130;
        r47 = true;
    L124:
        r46 = null;
    L119:
        r44 = null;
        goto L120
    L114:
        r42 = null;
        goto L115
    L111:
        r41 = null;
    L134:
        r8 = (State) ZeusTransformUtils.preCheckCast(r8, State.class, "com.obric.aiagent.plugin");
    L136:
        if (r8 == null) goto L143;
        if (r32.a() != 7) goto L143;
        IComplexTaskService r48 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
        if (r48 == null) goto L142;
        r48.playTts(String.valueOf(r18), r38, r33, "complex_task_oauto_call_user_tts");
    L142:
        ILogDepend.Companion.i(TAG, "onUpdateIntentResult playTts oAuto: state:" + r32.a() + " scene:complex_task_oauto_call_user_tts");
    L135:
        r38 = null;
        goto L136
    L101:
        r35 = null;
        goto L102
    L95:
        if (r32.a() != 8) goto L143;
    L72:
        if (r0.isEmpty() == true) goto L75;
        r26 = false;
    L143:
        return r19;
    L52:
        if (isLastSentRound(String.valueOf(r18)) == false) goto L64;
        IFlowMessageIDL r49 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
        if (r49 == null) goto L63;
        IMMessage r50 = this.lastSentMessage;
        if (r50 == null) goto L58;
        r8 = r50.getConversationId();
    L58:
        String r51 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_continue_download_confirmed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_continue_download_confirmed"));
        String r52 = "handleUpdateIntentResult#" + r16;
        if (r9 == false) goto L61;
        Map r53 = d.a.ao.a(d.s.a("o_task_type", IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK));
    L62:
        r49.sendMessageWithExtra(r8, r51, r52, "card", r53);
        goto L63
    L61:
        r53 = d.a.ao.b();
    L63:
        return true;
    L48:
        r25 = null;
        goto L50
    L31:
        if (isLastSentRound(String.valueOf(r18)) == false) goto L34;
        if (r9 == true) goto L34;
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new n(this, r16, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    L44:
        return true;
    L34:
        if (r16 == null) goto L40;
        String r54 = d.o.o.b(r16, "_", null, 2, null);
        if (r54 == null) goto L40;
        if (d.o.o.b(r54, "Show", false, 2, null) != true) goto L40;
        r19 = true;
    L40:
        if (r19 == false) goto L44;
        IFlowIntentActionService r55 = (IFlowIntentActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowIntentActionService.class), IFlowIntentActionService.class, "com.obric.aiagent.plugin");
        if (r55 == null) goto L44;
        r55.retryLastShowEntity();
        goto L44
    L27:
        r17 = null;
        goto L28
    L23:
        r16 = null;
        goto L24
    L19:
        r2 = null;
        goto L21
    L15:
        r15 = null;
        goto L16
    L11:
        r13 = null;
    L7:
        r4 = null;
        goto L8
    }

    private final void tryOpenClickTalkIfNeeded(IMMessage r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Map<String, String> r0 = r6.getExt();
        String r2 = null;
        if (r0 == null) goto L7;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get(EXT_O_IS_MIC_ON), String.class, "com.obric.aiagent.plugin");
    L9:
        if (d.h.b.o.a(r1, "1") == true) goto L11;
        return;
    L11:
        String r3 = r6.getReplyId();
        if (r3 != null) goto L14;
    L17:
        r2 = r6.getLocalMessageId();
    L18:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L21;
    L24:
        boolean r5 = true;
    L26:
        if (r5 == false) goto L30;
        ILogDepend.Companion.i(TAG, "tryOpenClickTalkIfNeeded skip: empty dedupKey");
        return;
    L30:
        if (this.openedClickTalkReplyIds.add(r2) == true) goto L33;
        ILogDepend.Companion.i(TAG, "tryOpenClickTalkIfNeeded skip: already opened for " + r2);
        return;
    L33:
        ILogDepend.Companion.i(TAG, "tryOpenClickTalkIfNeeded open clickTalk for " + r2);
        tryOpenClickTalk(r6);
        return;
    L21:
        if (r4.length() == 0) goto L24;
        r5 = false;
        goto L26
    L14:
        if (com.obric.agent.w.a(r3) == false) goto L16;
        r2 = r3;
    L16:
        if (r2 != null) goto L18;
    L7:
        r1 = null;
        goto L9
    }

    private final void tryOpenClickTalk(IMMessage r5) {
        if (r5 == null) goto L44;
        IFlowAppStateIDL r0 = com.obric.aiagent.assistant.idl.s.a(d.h.b.aa.b(IFlowAppStateIDL.class));
        boolean r1 = true;
        if (r0 != null) goto L6;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L19;
        IFlowSettingsIDL r3 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));
        if (r3 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L19;
        removeOpenMicSignalState(r5.getMessageId());
        return;
    L13:
        if (r3.isTtsPlayBackgroundEnabled() == true) goto L15;
        r4 = true;
    L19:
        IFlowMessageIDL r6 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
        if (r6 != null) goto L22;
    L24:
        boolean r7 = false;
    L25:
        if (r7 == false) goto L41;
        IFlowSettingsIDL r8 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));
        if (r8 != null) goto L29;
    L31:
        boolean r9 = false;
    L32:
        if (r9 == true) goto L42;
        IFlowAppStateIDL r10 = com.obric.aiagent.assistant.idl.s.a(d.h.b.aa.b(IFlowAppStateIDL.class));
        if (r10 != null) goto L36;
    L38:
        boolean r11 = false;
    L39:
        if (r11 == false) goto L41;
    L36:
        if (r10.isAppBackground() == true) goto L38;
        r11 = true;
    L42:
        openClickTalkWhenTTSEnd(r5, r1);
        return;
    L29:
        if (r8.isTtsPlayBackgroundEnabled() != true) goto L31;
        r9 = true;
    L41:
        r1 = false;
        goto L42
    L22:
        if (r6.isConversationTtsEnabled(null) != true) goto L24;
        r7 = true;
        goto L25
    L6:
        if (r0.isAppBackground() != true) goto L8;
        r2 = true;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, com.obric.agent.AgentServiceImpl$af] */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, com.obric.agent.-$$Lambda$AgentServiceImpl$Mff8MtjBTylmy7ecTA1hOOOINe8] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private final void openClickTalkWhenTTSEnd(final IMMessage r23, final boolean r24) {
        final String r10 = r23.getMessageId();
        final AtomicBoolean r11 = new AtomicBoolean(false);
        final AtomicBoolean r7 = new AtomicBoolean(false);
        final AtomicBoolean r13 = new AtomicBoolean(false);
        final AtomicBoolean r1 = new AtomicBoolean(false);
        final d.h.b.z.f r14 = new d.h.b.z.f();
        final d.h.b.z.f r2 = new d.h.b.z.f();
        final d.h.a.a r15 = new $$Lambda$AgentServiceImpl$SnPnqmNRCcxxrwrcr4eMc4NPYe0(r14, r2, this, r10);
        final d.h.a.a r8 = new $$Lambda$AgentServiceImpl$6jUwbvi17b85ag7QJr9hQhHPRGU(r13, r15, this, r23);
        final d.h.b.z.f r6 = new d.h.b.z.f();
        final d.h.a.a r16 = new $$Lambda$AgentServiceImpl$auewV5fqeKwv9_G1jyK5JssjF78(r1, r2, this, r10, r7, r6);
        r6.f38504a = new $$Lambda$AgentServiceImpl$Mff8MtjBTylmy7ecTA1hOOOINe8(r13, r11, this, r10, r7, r24, r16, r8);
        r14.f38504a = new af(r10, r11, this, r6);
        this.streamObservers.add((com.obric.agent.q) r14.f38504a);
        c r3 = getOpenMicSignalState(r10);
        if (r3 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L10;
        r11.set(true);
        this.streamObservers.remove(r14.f38504a);
    L10:
        ILogDepend.Companion r4 = ILogDepend.Companion;
        StringBuilder r5 = new StringBuilder().append("openClickTalkWhenTTSEnd messageId=").append(r10).append(" waitTts=").append(r24).append(" cachedStreamEnded=");
        if (r3 == null) goto L13;
        Boolean r9 = Boolean.valueOf(r3.a());
    L14:
        StringBuilder r17 = r5.append(r9).append(" cachedTtsState=");
        if (r3 == null) goto L17;
        Integer r18 = r3.b();
    L18:
        r4.i(TAG, r17.append(r18).toString());
        if (r6.f38504a != 0) goto L21;
        d.h.b.o.c("tryComplete");
        d.h.a.a r0 = null;
    L22:
        r0.invoke();
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ag(r13, r10, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L21:
        r0 = (d.h.a.a) ZeusTransformUtils.preCheckCast(r6.f38504a, d.h.a.a.class, "com.obric.aiagent.plugin");
        goto L22
    L17:
        r18 = null;
        goto L18
    L13:
        r9 = null;
        goto L14
    L5:
        if (r3.a() != true) goto L7;
        r12 = true;
        goto L8
    }

    private static final d.x openClickTalkWhenTTSEnd$lambda$87(d.h.b.z.f r2, d.h.b.z.f r3, AgentServiceImpl r4, String r5) {
        com.obric.agent.q r6 = (com.obric.agent.q) ZeusTransformUtils.preCheckCast(r2.f38504a, com.obric.agent.q.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L5;
        r4.streamObservers.remove(r6);
    L5:
        com.obric.agent.y r7 = (com.obric.agent.y) ZeusTransformUtils.preCheckCast(r3.f38504a, com.obric.agent.y.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L8;
        r4.ttsStateListeners.remove(r7);
    L8:
        r4.removeOpenMicSignalState(r5);
        return d.x.f38692a;
    }

    private static final d.x openClickTalkWhenTTSEnd$lambda$88(AtomicBoolean r8, d.h.a.a r9, AgentServiceImpl r10, IMMessage r11) {
        d.h.a.a r12 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r8.compareAndSet(false, true) == false) goto L6;
        r12.invoke();
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ai(r10, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    L6:
        return d.x.f38692a;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, com.obric.agent.AgentServiceImpl$ah] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private static final d.x openClickTalkWhenTTSEnd$lambda$89(AtomicBoolean r2, d.h.b.z.f r3, AgentServiceImpl r4, String r5, AtomicBoolean r6, d.h.b.z.f r7) {
        if (r2.compareAndSet(false, true) == false) goto L16;
        r3.f38504a = new ah(r5, r4, r6, r7);
        CopyOnWriteArraySet<com.obric.agent.y> r8 = r4.ttsStateListeners;
        T r9 = r3.f38504a;
        d.h.b.o.a(r9);
        r8.add((com.obric.agent.y) r9);
        c r10 = r4.getOpenMicSignalState(r5);
        d.h.a.a r11 = null;
        if (r10 == null) goto L7;
        Integer r12 = r10.b();
    L9:
        if (r4.isTtsTerminalState(r12) == false) goto L16;
        r6.set(true);
        if (r7.f38504a != 0) goto L13;
        d.h.b.o.c("tryComplete");
    L14:
        r11.invoke();
        goto L16
    L13:
        r11 = (d.h.a.a) ZeusTransformUtils.preCheckCast(r7.f38504a, d.h.a.a.class, "com.obric.aiagent.plugin");
        goto L14
    L7:
        r12 = null;
    L16:
        return d.x.f38692a;
    }

    private static final d.x openClickTalkWhenTTSEnd$lambda$90(AtomicBoolean r2, AtomicBoolean r3, AgentServiceImpl r4, String r5, AtomicBoolean r6, boolean r7, d.h.a.a r8, d.h.a.a r9) {
        d.h.a.a r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r2.get() == true) goto L30;
        if (r3.get() == false) goto L30;
        c r12 = r4.getOpenMicSignalState(r5);
        if (r12 == null) goto L10;
        Integer r13 = r12.b();
    L11:
        boolean r14 = r4.isTtsTerminalState(r13);
        boolean r15 = true;
        if (r14 == false) goto L14;
        r6.set(true);
    L14:
        if (r7 == true) goto L22;
        int r16 = com.obric.aiagent.assistant.idl.bean.b.a.f16267d.a();
        if (r13 != null) goto L19;
    L21:
        r15 = false;
        goto L22
    L19:
        if (r13.intValue() != r16) goto L21;
    L22:
        if (r15 == true) goto L24;
    L27:
        r11.invoke();
        return d.x.f38692a;
    L24:
        if (r6.get() == true) goto L27;
        r10.invoke();
        return d.x.f38692a;
    L10:
        r13 = null;
    L30:
        return d.x.f38692a;
    }

    @Override // com.obric.agent.IAgentService
    public void handleRemoteCard(IntentAppAction r39, IntentResult<?> r40, String r41, long r42) {
        d.h.b.o.e(r40, "intentResult");
        d.h.b.o.e(r41, "intentName");
        com.obric.agent.n r0 = com.obric.agent.n.f15202a;
        if (r39 == null) goto L5;
        ConcurrentHashMap<String, String> r7 = r39.getExt();
    L7:
        if (r0.a((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.aiagent.plugin")) == false) goto L10;
        ILogDepend.Companion.i(TAG, "skip local remote card because model decode card is enabled");
        return;
    L10:
        boolean r8 = false;
        if (r40.getUiType() != 2097152) goto L28;
        ConcurrentHashMap<String, String> r1 = r40.getExt();
        if (r1 != null) goto L15;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L28;
        ConcurrentHashMap<String, String> r11 = r40.getExt();
        if (r11 == null) goto L26;
        CardProvider[] r12 = new CardProvider[1];
        String r9 = (String) ZeusTransformUtils.preCheckCast(r11.get("obric_remoteCardViewUri"), String.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r11.get("obric_remoteCardViewHeight"), String.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L24;
        Integer r15 = d.o.o.d(r14);
    L25:
        r12[0] = new CardProvider(r9, r15, (String) ZeusTransformUtils.preCheckCast(r11.get("obric_remoteCardViewTitle"), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r11.get("obric_remoteCardViewExtraParams"), String.class, "com.obric.aiagent.plugin"));
    L27:
        RemoteCard r6 = new RemoteCard(true, r12);
    L30:
        if (r40.getRet() == 0) goto L32;
    L139:
        RemoteCard r3 = r6;
    L140:
        if (r3 == null) goto L144;
        CardProvider[] r4 = r3.getCardProviders();
        if (r4 == null) goto L144;
        List r13 = d.a.i.e(r4);
    L145:
        if (r3 == null) goto L185;
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L149;
    L150:
        r8 = true;
    L151:
        if (r8 == true) goto L186;
        if (r39 == null) goto L156;
        ConcurrentHashMap<String, String> r10 = r39.getExt();
        if (r10 == null) goto L156;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r10.get(EXT_TO_SERVER), String.class, "com.obric.aiagent.plugin");
    L157:
        boolean r17 = d.h.b.o.a(r16, "false");
        if (d.h.b.o.a(r41, "System_AutoAction") == false) goto L160;
        deleteRemoteCardMessageByQuestionId(String.valueOf(r42));
    L160:
        Gson r18 = EntityExtKt.a();
        DataSource r19 = new DataSource(d.o.o.a(r41, "_", null, 2, null), r41, null, 4, null);
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r20, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r22 = r20.iterator();
    L162:
        if (r22.hasNext() == false) goto L164;
        r21.add(AppIntentCardData.Companion.a((CardProvider) ZeusTransformUtils.preCheckCast(r22.next(), CardProvider.class, "com.obric.aiagent.plugin")));
        goto L162
    L164:
        String r31 = r18.toJson(new AppIntentMessage(r19, true, false, null, null, false, false, null, (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin"), null, 764, null));
        if (d.h.b.o.a(r3.isIndependent(), true) == true) goto L167;
    L169:
        String r23 = OAppIntentBizContentType.REMOTE_CARD_ITEM;
    L170:
        IAgentService r30 = (IAgentService) ZeusTransformUtils.preCheckCast(this, IAgentService.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r31);
        IAgentService.a.a(r30, r31, r23, String.valueOf(r42), 0, null, 24, null);
        if (r17 == false) goto L187;
        IIntentMetricsService r24 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L188;
        r24.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.f(String.valueOf(r42), "local_card_done", "local_card", false, null, null, 48, null), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
        return;
    L188:
        return;
    L187:
        return;
    L167:
        if (r13.size() != 1) goto L169;
        r23 = OAppIntentBizContentType.REMOTE_CARD;
    L156:
        r16 = null;
        goto L157
    L186:
        return;
    L149:
        if (r5.isEmpty() == false) goto L151;
    L185:
        return;
    L144:
        r13 = null;
        goto L145
    L32:
        if (d.h.b.o.a(r41, "Weather_Search") == false) goto L139;
        Object r25 = r40.getEntity();
        if (ZeusTransformUtils.instanceOf(r25, WeatherInfo.class) == false) goto L36;
        WeatherInfo r26 = (WeatherInfo) ZeusTransformUtils.preCheckCast(r25, WeatherInfo.class, "com.obric.aiagent.plugin");
    L37:
        if (r39 == null) goto L61;
        String r27 = r39.getContent();
        if (r27 == null) goto L61;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r27, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L44;
        r27 = null;
    L44:
        if (r27 == null) goto L61;
        com.obric.agent.dm.e r28 = (com.obric.agent.dm.e) ZeusTransformUtils.preCheckCast(ObricService.INSTANCE.getGson().fromJson(JsonParser.parseString(r27).getAsJsonObject().get("Content").getAsString(), com.obric.agent.dm.e.class), com.obric.agent.dm.e.class, "com.obric.aiagent.plugin");
        if (r28 == null) goto L54;
        List<com.obric.agent.dm.f> r29 = r28.a();
        if (r29 == null) goto L54;
        com.obric.agent.dm.f r32 = (com.obric.agent.dm.f) ZeusTransformUtils.preCheckCast(d.a.p.l(r29), com.obric.agent.dm.f.class, "com.obric.aiagent.plugin");
        if (r32 == null) goto L54;
        List<com.obric.agent.dm.b> r33 = r32.a();
        if (r33 == null) goto L54;
        com.obric.agent.dm.b r34 = (com.obric.agent.dm.b) ZeusTransformUtils.preCheckCast(d.a.p.n(r33), com.obric.agent.dm.b.class, "com.obric.aiagent.plugin");
    L55:
        if (r34 == null) goto L59;
        JsonObject r35 = r34.c();
        if (r35 == null) goto L59;
        JsonObject r36 = r35.getAsJsonObject();
    L60:
        JsonObject r37 = r36;
    L182:
        d.n.a r38 = d.n.f38560a;     // Catch: Throwable -> L74
        AgentServiceImpl r43 = (AgentServiceImpl) ZeusTransformUtils.preCheckCast(this, AgentServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L74
        if (r37 == null) goto L71;
        JsonElement r44 = r37.get("type");     // Catch: Throwable -> L74
        if (r44 == null) goto L71;
        JsonObject r45 = r44.getAsJsonObject();     // Catch: Throwable -> L74
        if (r45 == null) goto L71;
        JsonElement r46 = r45.get("value");     // Catch: Throwable -> L74
        if (r46 == null) goto L71;
        String r47 = r46.getAsString();     // Catch: Throwable -> L74
    L72:
        Object r48 = d.n.f(r47);     // Catch: Throwable -> L74
    L77:
        if (d.n.b(r48) == false) goto L79;
        r48 = null;
    L79:
        String r110 = (String) ZeusTransformUtils.preCheckCast(r48, String.class, "com.obric.aiagent.plugin");
        d.n.a r49 = d.n.f38560a;     // Catch: Throwable -> L92
        AgentServiceImpl r50 = (AgentServiceImpl) ZeusTransformUtils.preCheckCast(this, AgentServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L92
        if (r37 == null) goto L89;
        JsonElement r51 = r37.get("time");     // Catch: Throwable -> L92
        if (r51 == null) goto L89;
        JsonObject r52 = r51.getAsJsonObject();     // Catch: Throwable -> L92
        if (r52 == null) goto L89;
        JsonElement r53 = r52.get("value");     // Catch: Throwable -> L92
        if (r53 == null) goto L89;
        String r54 = r53.getAsString();     // Catch: Throwable -> L92
    L90:
        Object r55 = d.n.f(r54);     // Catch: Throwable -> L92
    L95:
        if (d.n.b(r55) == false) goto L97;
        r55 = null;
    L97:
        String r210 = (String) ZeusTransformUtils.preCheckCast(r55, String.class, "com.obric.aiagent.plugin");
        d.n.a r56 = d.n.f38560a;     // Catch: Throwable -> L110
        AgentServiceImpl r57 = (AgentServiceImpl) ZeusTransformUtils.preCheckCast(this, AgentServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L110
        if (r37 == null) goto L107;
        JsonElement r58 = r37.get("startTime");     // Catch: Throwable -> L110
        if (r58 == null) goto L107;
        JsonObject r59 = r58.getAsJsonObject();     // Catch: Throwable -> L110
        if (r59 == null) goto L107;
        JsonElement r60 = r59.get("value");     // Catch: Throwable -> L110
        if (r60 == null) goto L107;
        String r61 = r60.getAsString();     // Catch: Throwable -> L110
    L108:
        Object r62 = d.n.f(r61);     // Catch: Throwable -> L110
    L113:
        if (d.n.b(r62) == false) goto L115;
        r62 = null;
    L115:
        String r211 = (String) ZeusTransformUtils.preCheckCast(r62, String.class, "com.obric.aiagent.plugin");
        d.n.a r63 = d.n.f38560a;     // Catch: Throwable -> L128
        AgentServiceImpl r64 = (AgentServiceImpl) ZeusTransformUtils.preCheckCast(this, AgentServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L128
        if (r37 == null) goto L125;
        JsonElement r65 = r37.get("endTime");     // Catch: Throwable -> L128
        if (r65 == null) goto L125;
        JsonObject r66 = r65.getAsJsonObject();     // Catch: Throwable -> L128
        if (r66 == null) goto L125;
        JsonElement r67 = r66.get("value");     // Catch: Throwable -> L128
        if (r67 == null) goto L125;
        String r68 = r67.getAsString();     // Catch: Throwable -> L128
    L126:
        Object r69 = d.n.f(r68);     // Catch: Throwable -> L128
    L131:
        if (d.n.b(r69) == false) goto L133;
        r69 = null;
    L133:
        String r212 = (String) ZeusTransformUtils.preCheckCast(r69, String.class, "com.obric.aiagent.plugin");
        if (r110 == null) goto L139;
        if (r26 == null) goto L139;
        r3 = com.obric.agent.card.weather.h.f14294a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r110, r210, r211, r212, r26);
        if (r3 == null) goto L139;
    L125:
        r68 = null;
    L128:
        th = move-exception;
        d.n.a r70 = d.n.f38560a;
        r69 = d.n.f(d.o.a(th));
    L107:
        r61 = null;
    L110:
        th = move-exception;
        d.n.a r71 = d.n.f38560a;
        r62 = d.n.f(d.o.a(th));
    L89:
        r54 = null;
    L92:
        th = move-exception;
        d.n.a r72 = d.n.f38560a;
        r55 = d.n.f(d.o.a(th));
    L71:
        r47 = null;
    L74:
        th = move-exception;
        d.n.a r73 = d.n.f38560a;
        r48 = d.n.f(d.o.a(th));
    L59:
        r36 = null;
    L54:
        r34 = null;
    L61:
        r37 = null;
        goto L182
    L36:
        r26 = null;
        goto L37
    L24:
        r15 = null;
        goto L25
    L26:
        r12 = null;
        goto L27
    L15:
        if (r1.containsKey("obric_remoteCardViewUri") != true) goto L17;
        r2 = true;
    L28:
        r6 = r40.getRemoteCard();
        goto L30
    L5:
        r7 = null;
        goto L7
    }

    @Override // com.obric.agent.IAgentService
    public void setDebugReferImg(String r1) {
        this.debugImageTos = r1;
    }

    @Override // com.obric.agent.IAgentService
    public com.obric.agent.z getUploadingImgInfo(boolean r5) {
        if (r5 == false) goto L14;
        JSONObject r6 = new JSONObject();
        int r2 = 1;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.uploadingRealTimeImagInfo, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L8;
    L11:
        r6.put("pic_result", r2);
        IAppLog r1 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L14;
        r1.reportToFlow("o_screen_pic_info", r6);
        goto L14
    L8:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.uploadingScreenshotInfo, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L10;
        r2 = 2;
        goto L11
    L10:
        r2 = 0;
    L14:
        com.obric.agent.z r7 = (com.obric.agent.z) ZeusTransformUtils.preCheckCast(d.a.p.h((Iterable) ZeusTransformUtils.preCheckCast(this.uploadingRealTimeImagInfo, Iterable.class, "com.obric.aiagent.plugin")), com.obric.agent.z.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L17;
        r7 = (com.obric.agent.z) ZeusTransformUtils.preCheckCast(d.a.p.h((Iterable) ZeusTransformUtils.preCheckCast(this.uploadingScreenshotInfo, Iterable.class, "com.obric.aiagent.plugin")), com.obric.agent.z.class, "com.obric.aiagent.plugin");
    L17:
        if (r7 == null) goto L21;
        String r3 = r7.getIdentifier();
        if (r3 == null) goto L21;
        ((Map) ZeusTransformUtils.preCheckCast(this.semanticUsedUpdateImageInfo, Map.class, "com.obric.aiagent.plugin")).put(r3, r7.a());
    L21:
        return r7;
    }

    @Override // com.obric.agent.IAgentService
    public String getCachedAutoUploadImageUri() {
        String r0 = this.cacheAssistImgUri;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.cacheScreenshotUri;
    }

    @Override // com.obric.agent.IAgentService
    public List<AppEntity> getAppEntityList(Map<String, ? extends List<String>> r4) {
        Map<String, ? extends List<String>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L7;
        return null;
    L7:
        return (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.a.f33793a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5).getData(), List.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.agent.IAgentService
    public List<AppEntity> getAppEntityListByType(int r4, int r5) {
        return (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.a.f33793a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, r5).getData(), List.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.agent.IAgentService
    public PersonalContextInfo getUserRecentData() {
        monitor-enter(this);
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L24
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(this.recentMemoryData, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        boolean r3 = false;
        if (r2 != null) goto L6;
    L9:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        int r5 = 0;
    L13:
        r0.put("personalcontext", r5);     // Catch: Throwable -> L24
        IAppLog r1 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        if (r1 == null) goto L16;
        r1.reportToFlow("o_asr_pc", r0);     // Catch: Throwable -> L24
    L16:
        String r6 = this.recentMemoryData;     // Catch: Throwable -> L24
        if (this.uploadingScreenshotInfo.isEmpty() == false) goto L19;
    L20:
        r3 = true;
    L21:
        PersonalContextInfo r7 = new PersonalContextInfo(r6, Boolean.valueOf(r3));     // Catch: Throwable -> L24
        monitor-exit(this);
        return r7;
    L19:
        if (this.firstQuery == true) goto L21;
    L12:
        r5 = 1;
        goto L13
    L6:
        if (r2.length() == 0) goto L9;
        r4 = false;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.agent.IAgentService
    public List<Uri> getAudioFileForQuery(String r5) {
        d.h.b.o.e(r5, "msgId");
        monitor-enter(this);
        Uri r6 = (Uri) ZeusTransformUtils.preCheckCast(this.queryAudioFilesByMsgId.get(r5), Uri.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r6 == null) goto L10;
        List<Uri> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        r0.add(r6);     // Catch: Throwable -> L14
        Collection<Uri> r1 = this.queryAudioFilesByLocalMsgId.values();     // Catch: Throwable -> L14
        d.h.b.o.c(r1, "<get-values>(...)");     // Catch: Throwable -> L14
        List r2 = d.a.p.h(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L14
        int r7 = r2.indexOf(r6);     // Catch: Throwable -> L14
        if (r7 == (-1)) goto L9;
        r2 = r2.subList(0, r7);     // Catch: Throwable -> L14
    L9:
        d.h.b.o.a(r2, "null cannot be cast to non-null type kotlin.collections.Collection<android.net.Uri>");     // Catch: Throwable -> L14
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return r0;
    L10:
        AgentServiceImpl r8 = (AgentServiceImpl) ZeusTransformUtils.preCheckCast(this, AgentServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        r0 = null;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.agent.IAgentService
    public void onQueryAudioFile(String r8, String r9) {
        monitor-enter(this);
        if (r8 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        kotlinx.coroutines.i.a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(bs.f39169a, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ab(this, r9, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.agent.IAgentService
    public void showLarkUrl(String r7) {
        com.obric.agent.utils.b.f15994a.a(new BaseOfficeJumpToLarkUrlIntent().getName(), com.obric.agent.utils.b.f15994a.a(new OfficeJumpToLarkUrlParams(r7)), null, UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE);
    }

    @Override // com.obric.agent.IAgentService
    public IMMessage addMutableMessageForLark(String r28, String r29, String r30, int r31) {
        d.h.b.o.e(r28, "content");
        d.h.b.o.e(r30, "questionId");
        ILogDepend.Companion.d(TAG, "addMutableMessageForLark, questionId: " + r30 + ", type: " + r29);
        IFlowMessageIDL r1 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
        if (r1 == null) goto L6;
        String r2 = r1.generateLocalMessageId();
        if (r2 == null) goto L6;
    L7:
        IMMessage r15 = new IMMessage(null, null, 0, 0, 0, r31, false, r28, null, getExtForSendMessage(r30, r31), r2, null, 0, 0, null, null, r30, r29, 0, 325983, null);
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.c(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r15, getQuestionContext(r30, com.obric.agent.j.f15187a.a(r30)), null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return r15;
    L6:
        r2 = "";
        goto L7
    }

    @Override // com.obric.agent.IAgentService
    public void addLarkSendCardListener(com.obric.agent.p r9) {
        com.obric.agent.p r10 = (com.obric.agent.p) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.agent.p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "listener");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.IAgentService
    public void removeLarkSendCardListener(com.obric.agent.p r9) {
        com.obric.agent.p r10 = (com.obric.agent.p) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.agent.p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "listener");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ak(this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.IAgentService
    public void notifyLarkSendStatusChanged(String r8, int r9) {
        d.h.b.o.e(r8, "localMsgId");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new s(this, r8, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.IAgentService
    public void updateMutableMessageForLark(String r26, String r27, String r28, String r29, int r30) {
        d.h.b.o.e(r26, "content");
        d.h.b.o.e(r28, "localMsgId");
        d.h.b.o.e(r29, "questionId");
        ILogDepend.Companion.d(TAG, "updateMutableMessageForLark, questionId: " + r29 + ", type: " + r27);
        new IMMessage(null, null, 0, 0, 0, r30, false, r26, null, getExtForSendMessage(r29, r30), r28, null, 0, 0, null, null, r29, r27, 0, 325983, null);
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.c(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new au(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final boolean saveAudioFileToLocal(String r7, String r8, File r9) {
        InputStream r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver().openInputStream(Uri.parse(r7));     // Catch: Exception -> L22
        if (r6 == null) goto L21;
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r6, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22
        InputStream r11 = (InputStream) ZeusTransformUtils.preCheckCast(r10, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r9), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        long r4 = d.f.b.a(r11, (OutputStream) ZeusTransformUtils.preCheckCast((FileOutputStream) ZeusTransformUtils.preCheckCast(r12, FileOutputStream.class, "com.obric.aiagent.plugin"), OutputStream.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L11
        d.f.c.a(r12, null);     // Catch: Throwable -> L16
        Long.valueOf(r4);     // Catch: Throwable -> L16
        d.f.c.a(r10, null);     // Catch: Exception -> L22
        goto L21
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        d.f.c.a(r12, th);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        d.f.c.a(r10, th);     // Catch: Exception -> L22
        throw th;     // Catch: Exception -> L22
    L21:
        return true;
    L22:
        e = move-exception;
        ILogDepend.Companion.i(TAG, "saveAudioFileToLocal failed, msgId: " + r8 + ", e: " + e);
        return false;
    }

    @Override // com.obric.agent.IAgentService
    public Object updateShortCutTasks(d.c.d<? super d.x> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, av.class) == false) goto L7;
        av r0 = (av) ZeusTransformUtils.preCheckCast(r7, av.class, "com.obric.aiagent.plugin");
        if ((r0.f14011d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f14011d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f14009b;
        Object r1 = d.c.a.b.a();
        int r2 = r0.f14011d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        AgentServiceImpl this = (AgentServiceImpl) ZeusTransformUtils.preCheckCast(r0.f14008a, AgentServiceImpl.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L19:
        List<ShortcutTask> r9 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
    L21:
        if (r9 != null) goto L23;
        r9 = d.a.p.b();
    L23:
        monitor-enter(this);
        this.shortCutTasks = r9;     // Catch: Throwable -> L28
        ISecureLogDepend.Companion.i(TAG, "update ShortInstructShortcutTasks " + this.shortCutTasks);     // Catch: Throwable -> L28
        d.x r10 = d.x.f38692a;     // Catch: Throwable -> L28
        monitor-exit(this);
        return d.x.f38692a;
    L28:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        ITaskManagerApi r11 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L20;
        r0.f14008a = this;
        r0.f14011d = 1;
        r8 = r11.getEnableShortInstructShortcutTasks(r0);
        if (r8 != r1) goto L19;
        return r1;
    L20:
        r9 = null;
    L7:
        r0 = new av(this, r7);
        goto L8
    }

    private final Object getUserRecentMemoryData(int r5, d.c.d<? super String> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(this, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    private final void updateUserRecentMemoryDataAsync() {
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new aw(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    @Override // com.obric.agent.IAgentService
    public void callShortLink(String r4) {
        d.h.b.o.e(r4, "data");
        ISecureLogDepend.Companion.i(TAG, "get call short link " + r4);     // Catch: Exception -> L9
        if (d.h.b.o.a(new JSONObject(r4).opt(DBHelper.BATTERY_COL_SCENE), "operateQueue") == false) goto L12;
        IComplexTaskService r3 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
        if (r3 == null) goto L13;
        r3.operateQueue(r4);     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @Override // com.obric.agent.IAgentService
    public <T> JsonObject constructInputParams(T r1) {
        return com.obric.agent.utils.b.f15994a.a(r1);
    }

    @Override // com.obric.agent.IAgentService
    public void execLocalAppIntent(String r7, JsonObject r8, String r9, long r10) {
        d.h.b.o.e(r7, MemorySourceLinkType.INTENT);
        com.obric.agent.utils.b.f15994a.a(r7, r8, r9, r10);
    }

    private final Object findMessageByMsgId(final String r5, d.c.d<? super IMMessage> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(d.c.a.b.a(r7), 1);
        r0.e();
        final kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        IFlowMessageIDL r3 = com.obric.aiagent.assistant.idl.ak.a(d.h.b.aa.b(IFlowMessageIDL.class));
        if (r3 == null) goto L5;
        r3.findMessagebyId(r5, (IFlowFindMessageCallbackIDL) ZeusTransformUtils.preCheckCast(new AgentServiceImpl$findMessageByMsgId$2$1(r2, r5), IFlowFindMessageCallbackIDL.class, "com.obric.aiagent.plugin"));
    L6:
        Object r4 = r0.h();
        if (r4 != d.c.a.b.a()) goto L9;
        d.c.b.a.h.c(r7);
    L9:
        return r4;
    L5:
        AgentServiceImpl r8 = (AgentServiceImpl) ZeusTransformUtils.preCheckCast(this, AgentServiceImpl.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e(TAG, "findMessageByMsgId IPC not available");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r10 = d.n.f38560a;
        r9.resumeWith(d.n.f(null));
        goto L6
    }

    private static final IEntityManager entityManager_delegate$lambda$0() {
        return (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
    }
}
