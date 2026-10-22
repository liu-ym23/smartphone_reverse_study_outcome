package com.stepos.ailauncher.chat.wake;

import Ua.C1060i;
import Ua.CoroutineName;
import Z8.C1173v;
import Z8.C1174w;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatui.view.C2069d0;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.chat.sheet.DesktopChatResidentController;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.chat.wake.circle.CircleSelectController;
import com.stepos.ailauncher.chat.wake.homebar.HomeBarDisableManager;
import com.stepos.ailauncher.common.permission.G;
import com.stepos.ailauncher.common.permission.PermScene;
import com.stepos.ailauncher.common.permission.PermissionLaunchPolicy;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.common.utils.C3202f;
import com.stepos.ailauncher.common.utils.MicConflictPolicy;
import com.stepos.ailauncher.common.utils.MicOccupancyMonitor;
import com.stepos.ailauncher.contract.api.express.IExpressService;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.screenshot.ScreenshotClient;
import com.stepos.ailauncher.sla.C3475d;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import k5.C4814a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u0003123B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u0019\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u0019J\u000f\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001e\u0010\u0003R\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/WakeService;", "Landroid/app/Service;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "LY8/t;", "onDestroy", "l0", "n0", "", "text", "d0", "(Ljava/lang/String;)V", "", "noAnim", "f0", "(Z)V", "h0", "j0", "needCircleSelect", "b0", "c0", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "stopSelfRunnable", "Ljava/lang/Runnable;", "Lcom/stepos/ailauncher/chat/wake/WakeDialogImpl;", "activeDialog", "Lcom/stepos/ailauncher/chat/wake/WakeDialogImpl;", "LUa/M;", "silentCaptureScope", "LUa/M;", "Lcom/stepos/ailauncher/screenshot/ScreenshotClient;", "silentScreenshotClient", "Lcom/stepos/ailauncher/screenshot/ScreenshotClient;", "Lkotlinx/coroutines/g;", "silentCaptureJob", "Lkotlinx/coroutines/g;", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WakeService extends Service {
    private static final String ACTION_AI_KEY_WAKE = "com.stepos.ailauncher.action.AI_KEY_WAKE";
    public static final String ACTION_CARD_SEND_TEXT = "com.stepos.ailauncher.action.CARD_SEND_TEXT";
    public static final String ACTION_DISMISS = "com.stepos.ailauncher.action.DISMISS_WAKE";
    public static final String ACTION_HIDE = "com.stepos.ailauncher.action.HIDE_WAKE";
    public static final String ACTION_SHOW = "com.stepos.ailauncher.action.SHOW_WAKE";
    private static final String ACTION_WAKE = "com.stepos.ailauncher.action.WAKE";
    public static final String ACTION_WAKE_UP = "com.stepos.ailauncher.action.WAKE_UP";
    private static final long AGENT_WAKE_RETRY_TIMEOUT_MS = 250;
    public static final String EXTRA_CARD_TEXT = "card_text";
    private static final long LISTEN_RESTART_GUARD_MS = 150;
    private static final long NON_VOICE_WAKE_GUARD_MS = 1500;
    private static final String TAG = "WakeService";
    private static final long WAKE_POPUP_FOCUS_RETRY_MS = 16;
    private static final long WAKE_POPUP_FOCUS_TIMEOUT_MS = 250;
    private static volatile boolean aiKeyLongPressHolding;
    private static volatile boolean enableExpandScrim;
    private static volatile boolean expressAiKeyLongPressConsumed;
    private static volatile long nonVoiceWakeAtMs;
    private static volatile boolean overlayExternallyHidden;
    private static Runnable pendingAgentWakeRetry;
    private static volatile String pendingCardText;
    private static volatile boolean pendingCircleSelectEnabled;
    private static volatile ExternalSessionRef pendingExternalSession;
    private static volatile ExternalSessionRef pendingHomeExternalSession;
    private static volatile InstalledAgentRef pendingHomeInstalledSession;
    private static Pair<String, ? extends List<FileInfo>> pendingSendObj;
    private static volatile String pendingSessionId;
    private static volatile SharePayload pendingSharePayload;
    private static volatile String pendingStartSource;
    private static volatile SuggestPayload pendingSuggestPayload;
    private static Runnable pendingWakePreparation;
    private static long wakePreparationGeneration;
    private WakeDialogImpl activeDialog;
    private kotlinx.coroutines.g silentCaptureJob;
    private ScreenshotClient silentScreenshotClient;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> AI_KEY_WAKE_SOURCES = Z8.Y.j("ai_key_click", C4814a.AI_KEY_CLICK2, C4814a.AI_KEY_DOUBLE_CLICK, C4814a.AI_KEY_LONG_CLICK_START);
    private static final Handler agentWakeRetryHandler = new Handler(Looper.getMainLooper());
    private static final Ua.M wakeDispatchScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.b()).plus(new CoroutineName("Wake-Dispatch")));
    private static final Object suggestPayloadLock = new Object();
    private static final S1 wakePermissionSequence = new S1();
    private static final C3146n circleSelectWakeGate = new C3146n();
    private static final AiKeyScreenshotUploadGate screenshotUploadGate = new AiKeyScreenshotUploadGate();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Runnable stopSelfRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.a2
        @Override // java.lang.Runnable
        public final void run() {
            WakeService.t0(this.f26693a);
        }
    };
    private final Ua.M silentCaptureScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c()));

    @Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0012J\u0019\u0010\"\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\"\u0010\u001fJ\u000f\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010\u0012JK\u0010*\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010&\u001a\u00020\t2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b*\u0010+J\u0019\u0010,\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b,\u0010\u001fJ5\u00100\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010-\u001a\u00020\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010/\u001a\u00020\u0004H\u0002¢\u0006\u0004\b0\u00101J\u0011\u00102\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b2\u00103J\u0019\u00104\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b4\u0010\u001fJ\u0017\u00105\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b5\u00106J\u001b\u00108\u001a\u0004\u0018\u0001072\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b8\u00109J\u001f\u0010<\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010\u0003J%\u0010@\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0002¢\u0006\u0004\b@\u0010AJ)\u0010C\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010B\u001a\u00020\u0004H\u0002¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010\u0003J\u001d\u0010F\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0002¢\u0006\u0004\bF\u0010\u0019J\u000f\u0010G\u001a\u00020\u0006H\u0002¢\u0006\u0004\bG\u0010\u0003J)\u0010H\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010B\u001a\u00020\u0004H\u0002¢\u0006\u0004\bH\u0010DJ\u0017\u0010I\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\bI\u0010JJ\u0017\u0010K\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\bK\u0010JJ!\u0010L\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bL\u0010MJ\u001f\u0010N\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\bN\u0010OJ\u0017\u0010P\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\bP\u0010\u001cJ\u001f\u0010Q\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\bQ\u0010OJ\u000f\u0010R\u001a\u00020\u0006H\u0002¢\u0006\u0004\bR\u0010\u0003J+\u0010T\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\t2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060SH\u0002¢\u0006\u0004\bT\u0010UJ!\u0010V\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bV\u0010MJ#\u0010X\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bX\u0010MJ\u0019\u0010Y\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bY\u0010\u001fJ\u0017\u0010[\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0004H\u0000¢\u0006\u0004\b[\u0010\bJ\r\u0010\\\u001a\u00020\u0004¢\u0006\u0004\b\\\u0010\u0012J!\u0010]\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b]\u0010MJ\u0015\u0010^\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b^\u0010JJ\u000f\u0010`\u001a\u0004\u0018\u00010_¢\u0006\u0004\b`\u0010aJ\u000f\u0010c\u001a\u0004\u0018\u00010b¢\u0006\u0004\bc\u0010dJ\u001d\u0010g\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010f\u001a\u00020e¢\u0006\u0004\bg\u0010hJ\u0015\u0010j\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u0013¢\u0006\u0004\bj\u0010kJ-\u0010o\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\b\u0010l\u001a\u0004\u0018\u00010\t2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020m0\u000b¢\u0006\u0004\bo\u0010pJ)\u0010r\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\b\u0010l\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010q\u001a\u00020\u0004¢\u0006\u0004\br\u0010DJE\u0010w\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\b\u0010l\u001a\u0004\u0018\u00010\t2\u000e\u0010t\u001a\n\u0012\u0004\u0012\u00020s\u0018\u00010\u000b2\b\b\u0002\u0010u\u001a\u00020\u00042\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bw\u0010xJ\u001d\u0010y\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010l\u001a\u00020\t¢\u0006\u0004\by\u0010OJ\u001d\u0010z\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010.\u001a\u00020\t¢\u0006\u0004\bz\u0010OJ%\u0010{\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010l\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b{\u0010|J!\u0010~\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010}\u001a\u00020\u0004H\u0007¢\u0006\u0004\b~\u0010\u007fJ!\u0010\u0080\u0001\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\b\u0010l\u001a\u0004\u0018\u00010\t¢\u0006\u0005\b\u0080\u0001\u0010OJ\u0017\u0010\u0081\u0001\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$¢\u0006\u0005\b\u0081\u0001\u0010JJ\u0017\u0010\u0082\u0001\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$¢\u0006\u0005\b\u0082\u0001\u0010JJX\u0010\u0083\u0001\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010n\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0011\u0010\u0085\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0005\b\u0085\u0001\u0010\u0003J\u0011\u0010\u0086\u0001\u001a\u00020\u0004H\u0000¢\u0006\u0005\b\u0086\u0001\u0010\u0012J+\u0010\u0088\u0001\u001a\u001b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020s\u0018\u00010\u000b\u0018\u00010\u0087\u0001H\u0000¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0015\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0000¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0015\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0000¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J#\u0010\u0091\u0001\u001a\u00020\u00062\u0007\u0010\u0090\u0001\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001R/\u0010\u0094\u0001\u001a\u00020\u00042\u0007\u0010\u0093\u0001\u001a\u00020\u00048\u0006@BX\u0087\u000e¢\u0006\u0015\n\u0005\b\u0094\u0001\u0010~\u0012\u0005\b\u0096\u0001\u0010\u0003\u001a\u0005\b\u0095\u0001\u0010\u0012R&\u0010\u0097\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010~\u001a\u0005\b\u0098\u0001\u0010\u0012\"\u0005\b\u0099\u0001\u0010\bR,\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u008c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001RB\u0010\u009f\u0001\u001a\u001b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020s\u0018\u00010\u000b\u0018\u00010\u0087\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010\u0089\u0001\"\u0006\b¢\u0001\u0010£\u0001R)\u0010¤\u0001\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0005\b¦\u0001\u00103\"\u0005\b§\u0001\u0010\u001fR)\u0010¨\u0001\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0006\b¨\u0001\u0010¥\u0001\u001a\u0005\b©\u0001\u00103\"\u0005\bª\u0001\u0010\u001fR)\u0010«\u0001\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0006\b«\u0001\u0010¥\u0001\u001a\u0005\b¬\u0001\u00103\"\u0005\b\u00ad\u0001\u0010\u001fR,\u0010®\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b°\u0001\u0010\u008f\u0001\"\u0006\b±\u0001\u0010²\u0001R*\u0010³\u0001\u001a\u0004\u0018\u00010_8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b³\u0001\u0010´\u0001\u001a\u0005\bµ\u0001\u0010a\"\u0006\b¶\u0001\u0010·\u0001R*\u0010¸\u0001\u001a\u0004\u0018\u00010_8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b¸\u0001\u0010´\u0001\u001a\u0005\b¹\u0001\u0010a\"\u0006\bº\u0001\u0010·\u0001R*\u0010»\u0001\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0005\b½\u0001\u0010d\"\u0006\b¾\u0001\u0010¿\u0001R \u0010Á\u0001\u001a\u00030À\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001R&\u0010Å\u0001\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\bÅ\u0001\u0010~\u001a\u0005\bÆ\u0001\u0010\u0012\"\u0005\bÇ\u0001\u0010\bR\u0017\u0010È\u0001\u001a\u00020\t8\u0002X\u0082T¢\u0006\b\n\u0006\bÈ\u0001\u0010¥\u0001R\u001e\u0010Ê\u0001\u001a\t\u0012\u0004\u0012\u00020\t0É\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u0017\u0010Ì\u0001\u001a\u00020\t8\u0000X\u0080T¢\u0006\b\n\u0006\bÌ\u0001\u0010¥\u0001R\u0017\u0010Í\u0001\u001a\u00020\t8\u0002X\u0082T¢\u0006\b\n\u0006\bÍ\u0001\u0010¥\u0001R\u0017\u0010Î\u0001\u001a\u00020\t8\u0002X\u0082T¢\u0006\b\n\u0006\bÎ\u0001\u0010¥\u0001R\u0017\u0010Ï\u0001\u001a\u00020\t8\u0006X\u0086T¢\u0006\b\n\u0006\bÏ\u0001\u0010¥\u0001R\u0017\u0010Ð\u0001\u001a\u00020\t8\u0006X\u0086T¢\u0006\b\n\u0006\bÐ\u0001\u0010¥\u0001R\u0017\u0010Ñ\u0001\u001a\u00020\t8\u0006X\u0086T¢\u0006\b\n\u0006\bÑ\u0001\u0010¥\u0001R\u0017\u0010Ò\u0001\u001a\u00020\t8\u0006X\u0086T¢\u0006\b\n\u0006\bÒ\u0001\u0010¥\u0001R\u0017\u0010Ó\u0001\u001a\u00020\t8\u0006X\u0086T¢\u0006\b\n\u0006\bÓ\u0001\u0010¥\u0001R\u0017\u0010Õ\u0001\u001a\u00030Ô\u00018\u0002X\u0082T¢\u0006\u0007\n\u0005\bÕ\u0001\u0010XR\u0017\u0010Ö\u0001\u001a\u00030Ô\u00018\u0002X\u0082T¢\u0006\u0007\n\u0005\bÖ\u0001\u0010XR\u0017\u0010×\u0001\u001a\u00030Ô\u00018\u0002X\u0082T¢\u0006\u0007\n\u0005\b×\u0001\u0010XR\u0018\u0010Ù\u0001\u001a\u00030Ø\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001R\u001c\u0010Ü\u0001\u001a\u0005\u0018\u00010Û\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001R\u0019\u0010Þ\u0001\u001a\u00030Ô\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÞ\u0001\u0010XR\u001c\u0010ß\u0001\u001a\u0005\u0018\u00010Û\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010Ý\u0001R\u0018\u0010á\u0001\u001a\u00030à\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bá\u0001\u0010â\u0001R\u0018\u0010ã\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bã\u0001\u0010~R\u0018\u0010ä\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bä\u0001\u0010~R\u0017\u0010å\u0001\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u0017\u0010ç\u0001\u001a\u00030Ô\u00018\u0002X\u0082T¢\u0006\u0007\n\u0005\bç\u0001\u0010XR\u0017\u0010è\u0001\u001a\u00030Ô\u00018\u0002X\u0082T¢\u0006\u0007\n\u0005\bè\u0001\u0010XR\u0019\u0010é\u0001\u001a\u00030Ô\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bé\u0001\u0010XR\u0018\u0010ë\u0001\u001a\u00030ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bë\u0001\u0010ì\u0001R\u0018\u0010î\u0001\u001a\u00030í\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0001¨\u0006ð\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/WakeService$Companion;", "", "<init>", "()V", "", "holding", "LY8/t;", "k1", "(Z)V", "", "title", "", DidiCardProvider.KEY_ITEMS, "fileId", "Q0", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "O0", "M0", "()Z", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "r0", "()Lcom/stepos/ailauncher/chat/view/BaseInputView;", "Lkotlin/Function0;", "action", "Y", "(Lp9/a;)V", "source", "W0", "(Ljava/lang/String;)Z", "stopReason", "D1", "(Ljava/lang/String;)V", "C1", "B1", "I0", "L0", "Landroid/content/Context;", "context", "result", "targetState", "failReason", "notifyWakeSprite", SdCardDbCreator.FIELD_LASTLOC_ID, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "R0", "reuse", "sessionId", "appInForeground", "Y0", "(Landroid/content/Context;ZLjava/lang/String;Z)V", "X", "()Ljava/lang/String;", "X0", "X1", "(Landroid/content/Context;)Z", "Lcom/stepos/ailauncher/common/utils/MicConflictPolicy$AgentEntry;", "N0", "(Ljava/lang/String;)Lcom/stepos/ailauncher/common/utils/MicConflictPolicy$AgentEntry;", "", "messageResId", "y1", "(Landroid/content/Context;I)V", "F0", "onReady", "c1", "(Landroid/content/Context;Lp9/a;)V", "screenOffAtWake", ExifInterface.LONGITUDE_WEST, "(Landroid/content/Context;Ljava/lang/String;Z)V", "D0", "T0", "M", "d0", "b0", "(Landroid/content/Context;)V", "T1", "F1", "(Landroid/content/Context;Ljava/lang/String;)Z", "R1", "(Landroid/content/Context;Ljava/lang/String;)V", "J0", "A1", "L", "Lkotlin/Function1;", "g1", "(Ljava/lang/String;Lp9/l;)V", "O", "micSource", "J", "p0", "hidden", "P0", "K0", "N", "I1", "Lcom/stepos/ailauncher/chat/wake/p;", "Q", "()Lcom/stepos/ailauncher/chat/wake/p;", "Lcom/stepos/ailauncher/chat/wake/r;", "R", "()Lcom/stepos/ailauncher/chat/wake/r;", "Landroid/content/Intent;", "intent", "J1", "(Landroid/content/Context;Landroid/content/Intent;)V", "inputView", "S0", "(Lcom/stepos/ailauncher/chat/view/BaseInputView;)V", "text", "Landroid/net/Uri;", "uris", "K1", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)V", "defaultSendTxt", "M1", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "files", "defaultSend", "from", "L1", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;)V", "j1", "V1", "U1", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "noAnim", "Z", "(Landroid/content/Context;Z)V", "i1", "E0", "x1", "W1", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", ExifInterface.LATITUDE_SOUTH, "P", "Lkotlin/Pair;", ExifInterface.GPS_DIRECTION_TRUE, "()Lkotlin/Pair;", "Lcom/stepos/ailauncher/chat/wake/WakeService$a;", "U", "()Lcom/stepos/ailauncher/chat/wake/WakeService$a;", "Lcom/stepos/ailauncher/chat/wake/WakeService$b;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Lcom/stepos/ailauncher/chat/wake/WakeService$b;", "input", "n0", "(Lcom/stepos/ailauncher/chat/view/BaseInputView;Ljava/lang/String;)V", UxipConstants.f30680s, "overlayExternallyHidden", "t0", "getOverlayExternallyHidden$annotations", "enableExpandScrim", "s0", "m1", "pendingSharePayload", "Lcom/stepos/ailauncher/chat/wake/WakeService$a;", "z0", "u1", "(Lcom/stepos/ailauncher/chat/wake/WakeService$a;)V", "pendingSendObj", "Lkotlin/Pair;", "y0", "s1", "(Lkotlin/Pair;)V", "pendingStartSource", "Ljava/lang/String;", "A0", "v1", "pendingSessionId", "getPendingSessionId$chat_release", "t1", "pendingCardText", "getPendingCardText$chat_release", "n1", "pendingSuggestPayload", "Lcom/stepos/ailauncher/chat/wake/WakeService$b;", "B0", "w1", "(Lcom/stepos/ailauncher/chat/wake/WakeService$b;)V", "pendingExternalSession", "Lcom/stepos/ailauncher/chat/wake/p;", "v0", "p1", "(Lcom/stepos/ailauncher/chat/wake/p;)V", "pendingHomeExternalSession", "w0", "q1", "pendingHomeInstalledSession", "Lcom/stepos/ailauncher/chat/wake/r;", "x0", "r1", "(Lcom/stepos/ailauncher/chat/wake/r;)V", "Lcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate;", "screenshotUploadGate", "Lcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate;", "C0", "()Lcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate;", "pendingCircleSelectEnabled", "u0", "o1", "TAG", "", "AI_KEY_WAKE_SOURCES", "Ljava/util/Set;", "ACTION_WAKE_UP", "ACTION_WAKE", "ACTION_AI_KEY_WAKE", "ACTION_DISMISS", "ACTION_CARD_SEND_TEXT", "EXTRA_CARD_TEXT", "ACTION_HIDE", "ACTION_SHOW", "", "AGENT_WAKE_RETRY_TIMEOUT_MS", "WAKE_POPUP_FOCUS_RETRY_MS", "WAKE_POPUP_FOCUS_TIMEOUT_MS", "Landroid/os/Handler;", "agentWakeRetryHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "pendingAgentWakeRetry", "Ljava/lang/Runnable;", "wakePreparationGeneration", "pendingWakePreparation", "LUa/M;", "wakeDispatchScope", "LUa/M;", "aiKeyLongPressHolding", "expressAiKeyLongPressConsumed", "suggestPayloadLock", "Ljava/lang/Object;", "NON_VOICE_WAKE_GUARD_MS", "LISTEN_RESTART_GUARD_MS", "nonVoiceWakeAtMs", "Lcom/stepos/ailauncher/chat/wake/S1;", "wakePermissionSequence", "Lcom/stepos/ailauncher/chat/wake/S1;", "Lcom/stepos/ailauncher/chat/wake/n;", "circleSelectWakeGate", "Lcom/stepos/ailauncher/chat/wake/n;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MicOccupancyMonitor.OccupancyKind.values().length];
                try {
                    iArr[MicOccupancyMonitor.OccupancyKind.EXTERNAL_RECORDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MicOccupancyMonitor.OccupancyKind.EXTERNAL_VOIP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MicOccupancyMonitor.OccupancyKind.SYSTEM_CALL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ void E1(Companion companion, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = null;
            }
            companion.D1(str);
        }

        public static final Y8.t G0(boolean[] zArr) {
            Window window;
            View decorView;
            DialogC3116e0 dialogC3116e0Y0 = InputViewManager.INSTANCE.y0();
            if (dialogC3116e0Y0 != null && (window = dialogC3116e0Y0.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                decorView.setVisibility(4);
            }
            if (!zArr[0]) {
                zArr[0] = DesktopChatResidentController.r0();
            }
            return Y8.t.f7040a;
        }

        public static final Y8.t G1(final Context context) {
            WakeService.agentWakeRetryHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.v2
                @Override // java.lang.Runnable
                public final void run() {
                    WakeService.Companion.H1(context);
                }
            });
            return Y8.t.f7040a;
        }

        public static final Y8.t H0(boolean[] zArr) {
            Window window;
            View decorView;
            DialogC3116e0 dialogC3116e0Y0 = InputViewManager.INSTANCE.y0();
            if (dialogC3116e0Y0 != null && (window = dialogC3116e0Y0.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                decorView.setVisibility(0);
            }
            if (zArr[0]) {
                zArr[0] = false;
                DesktopChatResidentController.f1();
            }
            return Y8.t.f7040a;
        }

        public static final void H1(Context context) {
            C3146n c3146n = WakeService.circleSelectWakeGate;
            CircleSelectController.Companion aVar = CircleSelectController.INSTANCE;
            if (c3146n.b(aVar.d())) {
                aVar.i(null);
                C4148a.k(WakeService.TAG, "CircleSelect: resume held AI key after circle exit", false, 4, null);
                Companion companion = WakeService.INSTANCE;
                kotlin.jvm.internal.p.f(context);
                Intent intent = new Intent(WakeService.ACTION_AI_KEY_WAKE);
                intent.putExtra(C4814a.PARAM_SOURCE, C4814a.AI_KEY_LONG_CLICK_START);
                Y8.t tVar = Y8.t.f7040a;
                companion.J1(context, intent);
            }
        }

        public static /* synthetic */ boolean K(Companion companion, Context context, String str, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str = null;
            }
            return companion.J(context, str);
        }

        public static /* synthetic */ void N1(Companion companion, Context context, String str, List list, boolean z10, String str2, int i10, Object obj) {
            if ((i10 & 8) != 0) {
                z10 = true;
            }
            boolean z11 = z10;
            if ((i10 & 16) != 0) {
                str2 = null;
            }
            companion.L1(context, str, list, z11, str2);
        }

        public static final Y8.t O1(Context context) {
            WakeService.INSTANCE.T1(context);
            return Y8.t.f7040a;
        }

        public static final Y8.t P1(Context context, String str, boolean z10) {
            WakeService.INSTANCE.d0(context, str, z10);
            return Y8.t.f7040a;
        }

        public static final void Q1(BaseInputView baseInputView, String str, List list, boolean z10, String str2) {
            if (str == null) {
                str = "";
            }
            baseInputView.eb(str, list, z10, str2);
        }

        public static final Y8.t S1(String str, String str2, BaseInputView it) {
            kotlin.jvm.internal.p.i(it, "it");
            it.hd(str);
            BaseInputView.oc(it, null, str2, 1, null);
            WakeService.INSTANCE.p0(str);
            return Y8.t.f7040a;
        }

        public static final void U0(InterfaceC5063a interfaceC5063a) {
            WakeService.INSTANCE.T0(interfaceC5063a);
        }

        public static final void V0(long j10, long j11, InterfaceC5063a interfaceC5063a, Ref$ObjectRef ref$ObjectRef) {
            if (j10 != WakeService.wakePreparationGeneration) {
                return;
            }
            BaseInputView baseInputViewQ0 = InputViewManager.INSTANCE.q0();
            boolean z10 = baseInputViewQ0 != null && baseInputViewQ0.Y7();
            boolean z11 = SystemClock.uptimeMillis() - j11 >= 250;
            Runnable runnable = null;
            if (baseInputViewQ0 == null || z10 || z11) {
                WakeService.pendingWakePreparation = null;
                interfaceC5063a.invoke();
                return;
            }
            Handler handler = WakeService.agentWakeRetryHandler;
            T t10 = ref$ObjectRef.f34820a;
            if (t10 == 0) {
                kotlin.jvm.internal.p.A("retry");
            } else {
                runnable = (Runnable) t10;
            }
            handler.postDelayed(runnable, 16L);
        }

        public static /* synthetic */ void Z0(Companion companion, Context context, boolean z10, String str, boolean z11, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                str = companion.X();
            }
            if ((i10 & 8) != 0) {
                z11 = true;
            }
            companion.Y0(context, z10, str, z11);
        }

        public static /* synthetic */ void a0(Companion companion, Context context, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            companion.Z(context, z10);
        }

        public static /* synthetic */ void b1(Companion companion, Context context, String str, String str2, String str3, String str4, boolean z10, int i10, Object obj) {
            if ((i10 & 8) != 0) {
                str3 = null;
            }
            if ((i10 & 16) != 0) {
                str4 = null;
            }
            if ((i10 & 32) != 0) {
                z10 = true;
            }
            companion.a1(context, str, str2, str3, str4, z10);
        }

        public static final Y8.t c0(BaseInputView it) {
            kotlin.jvm.internal.p.i(it, "it");
            it.hd(C4814a.AI_KEY_LONG_CLICK_START);
            it.t4();
            WakeService.INSTANCE.p0(C4814a.AI_KEY_LONG_CLICK_START);
            return Y8.t.f7040a;
        }

        public static final boolean d1(long j10) {
            com.stepos.ailauncher.common.permission.G g10 = com.stepos.ailauncher.common.permission.G.INSTANCE;
            return !g10.S() && g10.J() == j10;
        }

        public static final Y8.t e0(Context context, String str, boolean z10) {
            WakeService.INSTANCE.d0(context, str, z10);
            return Y8.t.f7040a;
        }

        public static final Y8.t e1(Context context, final PermScene permScene, final long j10, final InterfaceC5063a done) {
            kotlin.jvm.internal.p.i(done, "done");
            WakeService.INSTANCE.F0();
            com.stepos.ailauncher.common.permission.G g10 = com.stepos.ailauncher.common.permission.G.INSTANCE;
            kotlin.jvm.internal.p.f(context);
            g10.j0(context, permScene, PermissionLaunchPolicy.INDEPENDENT_TASK, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.x2
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return WakeService.Companion.f1(j10, permScene, done, ((Boolean) obj).booleanValue());
                }
            });
            return Y8.t.f7040a;
        }

        public static final Y8.t f0(Context context, final long j10, final String str, final boolean z10) {
            final Context applicationContext = context.getApplicationContext();
            com.stepos.ailauncher.common.permission.G.INSTANCE.p0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.o2
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return WakeService.Companion.g0(j10, applicationContext, str, z10);
                }
            });
            return Y8.t.f7040a;
        }

        public static final Y8.t f1(long j10, PermScene permScene, InterfaceC5063a interfaceC5063a, boolean z10) {
            com.stepos.ailauncher.common.permission.G g10 = com.stepos.ailauncher.common.permission.G.INSTANCE;
            if (g10.S() || j10 != g10.J()) {
                return Y8.t.f7040a;
            }
            if (permScene == PermScene.PHONE_STATE && z10) {
                DialogC3116e0 dialogC3116e0Y0 = InputViewManager.INSTANCE.y0();
                WakeDialogImpl wakeDialogImpl = dialogC3116e0Y0 instanceof WakeDialogImpl ? (WakeDialogImpl) dialogC3116e0Y0 : null;
                if (wakeDialogImpl != null) {
                    wakeDialogImpl.v5();
                }
            }
            g10.p0(interfaceC5063a);
            return Y8.t.f7040a;
        }

        public static final Y8.t g0(long j10, Context context, String str, boolean z10) {
            com.stepos.ailauncher.common.permission.G g10 = com.stepos.ailauncher.common.permission.G.INSTANCE;
            if (g10.S() || j10 != g10.J()) {
                return Y8.t.f7040a;
            }
            Companion companion = WakeService.INSTANCE;
            kotlin.jvm.internal.p.f(context);
            companion.W(context, str, z10);
            return Y8.t.f7040a;
        }

        public static final Y8.t h0(Context context, boolean z10) {
            if (z10) {
                com.stepos.ailauncher.common.permission.G.z0(com.stepos.ailauncher.common.permission.G.INSTANCE, context, PermScene.MICROPHONE, null, 4, null);
            }
            return Y8.t.f7040a;
        }

        public static final void h1(InterfaceC5074l interfaceC5074l, String str) {
            WakeService.pendingAgentWakeRetry = null;
            if (DialogC3116e0.INSTANCE.a()) {
                return;
            }
            Companion companion = WakeService.INSTANCE;
            BaseInputView baseInputViewR0 = companion.r0();
            if (baseInputViewR0 == null) {
                C4148a.d(WakeService.TAG, "Agent wake retry: fallback to WakeDialog", false, 4, null);
                companion.A1(C3197a.INSTANCE.a(), str);
                return;
            }
            C4148a.d(WakeService.TAG, "Agent wake retry: reuse " + baseInputViewR0.getClass().getSimpleName(), false, 4, null);
            interfaceC5074l.invoke(baseInputViewR0);
        }

        public static final Y8.t i0(String str, Context context, boolean z10) {
            if (kotlin.jvm.internal.p.d(str, C4814a.AI_KEY_LONG_CLICK_START) && !WakeService.INSTANCE.K0()) {
                str = "ai_key_click";
            }
            Companion companion = WakeService.INSTANCE;
            kotlin.jvm.internal.p.f(context);
            companion.d0(context, str, z10);
            return Y8.t.f7040a;
        }

        public static final Y8.t j0(long j10, boolean z10, String str, Context context) {
            if (j10 != WakeService.wakePreparationGeneration) {
                return Y8.t.f7040a;
            }
            Companion companion = WakeService.INSTANCE;
            companion.O0();
            if (z10) {
                companion.X0(str);
            }
            BaseInputView baseInputViewR0 = companion.r0();
            if (baseInputViewR0 != null && baseInputViewR0.getListenModeActive() && baseInputViewR0.a8()) {
                baseInputViewR0.M4();
                companion.p0(str);
                b1(companion, context, str, "success", "listening", null, false, 48, null);
                return Y8.t.f7040a;
            }
            E1(companion, null, 1, null);
            companion.I0(str);
            if (companion.r0() == null && DesktopChatResidentController.S1()) {
                companion.A1(context, C4814a.AI_KEY_LONG_CLICK_START);
            } else {
                companion.b0(context);
            }
            b1(companion, context, str, "success", "listening", null, false, 48, null);
            return Y8.t.f7040a;
        }

        public static final Y8.t k0(long j10, Context context, String str) {
            if (j10 != WakeService.wakePreparationGeneration) {
                return Y8.t.f7040a;
            }
            WakeService.INSTANCE.R1(context, str);
            return Y8.t.f7040a;
        }

        public static final Y8.t l0(long j10, Context context, String str) {
            if (j10 != WakeService.wakePreparationGeneration) {
                return Y8.t.f7040a;
            }
            WakeService.INSTANCE.R1(context, str);
            return Y8.t.f7040a;
        }

        public static final void l1(ChatActivity chatActivity) {
            chatActivity.da();
        }

        public static final Y8.t m0(String str, Context context, String str2) {
            if (HomeBarDisableManager.INSTANCE.d(str)) {
                return Y8.t.f7040a;
            }
            C2739j.t(context, str2, str2 != null, false, false, 24, null);
            return Y8.t.f7040a;
        }

        public static final void o0(BaseInputView baseInputView, String str, List list, String str2) {
            if (str == null) {
                str = "";
            }
            baseInputView.eb(str, list, true, str2);
        }

        public static final void q0(ChatActivity chatActivity) {
            chatActivity.V6();
        }

        public static final void z1(Context context, int i10) {
            Toast.makeText(context, i10, 0).show();
        }

        public final String A0() {
            return WakeService.pendingStartSource;
        }

        public final void A1(Context context, String source) {
            L();
            v1(source);
            Intent intent = new Intent(context, (Class<?>) WakeService.class);
            intent.setAction(WakeService.ACTION_WAKE);
            context.startService(intent);
        }

        public final SuggestPayload B0() {
            return WakeService.pendingSuggestPayload;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean B1() {
            /*
                r2 = this;
                com.stepos.ailauncher.chat.view.BaseInputView r2 = r2.r0()
                r0 = 0
                if (r2 == 0) goto L18
                boolean r1 = r2.a8()
                if (r1 != 0) goto L15
                boolean r1 = r2.getListenModeActive()
                if (r1 == 0) goto L14
                goto L15
            L14:
                r2 = 0
            L15:
                if (r2 == 0) goto L18
                goto L21
            L18:
                com.stepos.ailauncher.chat.manager.InputViewManager r2 = com.stepos.ailauncher.chat.manager.InputViewManager.INSTANCE
                com.stepos.ailauncher.chat.view.BaseInputView r2 = r2.t0()
                if (r2 != 0) goto L21
                return r0
            L21:
                boolean r1 = r2.R7()
                if (r1 == 0) goto L28
                return r0
            L28:
                java.lang.String r0 = "nav_key_click"
                r2.vc(r0)
                r2.Yb()
                r2 = 1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.WakeService.Companion.B1():boolean");
        }

        public final AiKeyScreenshotUploadGate C0() {
            return WakeService.screenshotUploadGate;
        }

        public final void C1() {
            BaseInputView baseInputViewR0 = r0();
            if (baseInputViewR0 == null && (baseInputViewR0 = InputViewManager.INSTANCE.t0()) == null) {
                return;
            }
            baseInputViewR0.tc();
        }

        public final void D0() {
            boolean z10 = false;
            k1(false);
            L();
            M();
            InputViewManager inputViewManager = InputViewManager.INSTANCE;
            DialogC3116e0 dialogC3116e0Y0 = inputViewManager.y0();
            WakeDialogImpl wakeDialogImpl = dialogC3116e0Y0 instanceof WakeDialogImpl ? (WakeDialogImpl) dialogC3116e0Y0 : null;
            if (wakeDialogImpl != null && wakeDialogImpl.isShowing()) {
                wakeDialogImpl.d3(C4814a.AI_KEY_LONG_CLICK_END);
                inputViewManager.m0();
                return;
            }
            if (kotlin.jvm.internal.p.d(A0(), C4814a.AI_KEY_LONG_CLICK_START)) {
                v1(C4814a.AI_KEY_LONG_CLICK_END);
                inputViewManager.m0();
                return;
            }
            BaseInputView baseInputViewR0 = inputViewManager.r0();
            if (baseInputViewR0 != null) {
                baseInputViewR0.s4();
            }
            inputViewManager.m0();
            if (baseInputViewR0 == null) {
                BaseInputView baseInputViewW0 = inputViewManager.w0();
                boolean z11 = baseInputViewW0 != null && baseInputViewW0.R7();
                if (baseInputViewW0 != null && baseInputViewW0.S7()) {
                    z10 = true;
                }
                if (baseInputViewW0 != null) {
                    if (z11 || z10) {
                        baseInputViewW0.s4();
                    }
                }
            }
        }

        public final void D1(String stopReason) {
            BaseInputView baseInputViewR0 = r0();
            if (baseInputViewR0 == null || !baseInputViewR0.a8() || baseInputViewR0.R7()) {
                return;
            }
            baseInputViewR0.vc(stopReason);
        }

        public final void E0(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) WakeService.class);
            intent.setAction(WakeService.ACTION_HIDE);
            context.startService(intent);
        }

        public final void F0() {
            InterfaceC5063a<Y8.t> interfaceC5063aB;
            com.stepos.ailauncher.common.permission.G g10 = com.stepos.ailauncher.common.permission.G.INSTANCE;
            G.OverlayHook overlayHookI = g10.I();
            if (overlayHookI != null && (interfaceC5063aB = overlayHookI.b()) != null) {
                interfaceC5063aB.invoke();
            }
            final boolean[] zArr = {false};
            g10.t0(new G.OverlayHook(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.p2
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return WakeService.Companion.G0(zArr);
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.r2
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return WakeService.Companion.H0(zArr);
                }
            }));
        }

        public final boolean F1(Context context, String source) {
            C3146n c3146n = WakeService.circleSelectWakeGate;
            CircleSelectController.Companion aVar = CircleSelectController.INSTANCE;
            boolean zA = c3146n.a(source, aVar.d(), aVar.g());
            if (kotlin.jvm.internal.p.d(source, C4814a.AI_KEY_LONG_CLICK_END) || (kotlin.jvm.internal.p.d(source, C4814a.AI_KEY_LONG_CLICK_START) && !zA)) {
                aVar.i(null);
            }
            if (zA && kotlin.jvm.internal.p.d(source, C4814a.AI_KEY_LONG_CLICK_START)) {
                final Context applicationContext = context.getApplicationContext();
                aVar.i(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.j2
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return WakeService.Companion.G1(applicationContext);
                    }
                });
            }
            if (zA) {
                C4148a.d(WakeService.TAG, "CircleSelect: suppressed source=" + source, false, 4, null);
            }
            return zA;
        }

        public final void I0(String source) {
            BaseInputView baseInputViewR0;
            MicConflictPolicy.AgentEntry agentEntryN0 = N0(source);
            if (agentEntryN0 == null) {
                return;
            }
            if (agentEntryN0 == MicConflictPolicy.AgentEntry.AI_KEY_OR_HEADSET || agentEntryN0 == MicConflictPolicy.AgentEntry.HEADSET_WAKEUP) {
                int i10 = a.$EnumSwitchMapping$0[MicOccupancyMonitor.INSTANCE.h().ordinal()];
                if (i10 == 1 || i10 == 2 || i10 == 3 || (baseInputViewR0 = r0()) == null) {
                    return;
                }
                if (!baseInputViewR0.a8()) {
                    baseInputViewR0 = null;
                }
                if (baseInputViewR0 != null) {
                    BaseInputView.wc(baseInputViewR0, null, 1, null);
                }
            }
        }

        public final void I1(final Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            T0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.t2
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return WakeService.Companion.O1(context);
                }
            });
        }

        public final boolean J(Context context, String micSource) {
            if (P1.INSTANCE.a().d(context, micSource)) {
                return true;
            }
            s1(null);
            u1(null);
            v1(null);
            t1(null);
            w1(null);
            n1(null);
            return false;
        }

        public final boolean J0(String source) {
            return kotlin.jvm.internal.p.d(source, "ai_key_click") || kotlin.jvm.internal.p.d(source, C4814a.AI_KEY_CLICK2) || kotlin.jvm.internal.p.d(source, "voice_wakeup") || kotlin.jvm.internal.p.d(source, C4814a.HEADSET_WAKEUP);
        }

        public final void J1(final Context context, Intent intent) {
            Object objB;
            Object objB2;
            String stringExtra;
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(intent, "intent");
            String action = intent.getAction();
            if (kotlin.jvm.internal.p.d(action, "com.stepos.ailauncher.action.HEADSET_LONG_PRESS_WAKE")) {
                intent.putExtra(C4814a.PARAM_SOURCE, C4814a.HEADSET_WAKEUP);
            }
            if (kotlin.jvm.internal.p.d(action, WakeService.ACTION_AI_KEY_WAKE) && ((stringExtra = intent.getStringExtra(C4814a.PARAM_SOURCE)) == null || La.H.x0(stringExtra))) {
                intent.putExtra(C4814a.PARAM_SOURCE, "ai_key_click");
            }
            final String stringExtra2 = intent.getStringExtra(C4814a.PARAM_SOURCE);
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("wake: source=%s", Arrays.copyOf(new Object[]{stringExtra2 == null ? "unknown" : stringExtra2}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.d(WakeService.TAG, str, false, 4, null);
            if (F1(context, stringExtra2)) {
                return;
            }
            HomeBarDisableManager homeBarDisableManager = HomeBarDisableManager.INSTANCE;
            if (homeBarDisableManager.d(stringExtra2)) {
                C4148a.k(WakeService.TAG, "homebar ignored: " + homeBarDisableManager.c(), false, 4, null);
                return;
            }
            if (O(context, stringExtra2)) {
                return;
            }
            if (kotlin.jvm.internal.p.d(stringExtra2, C4814a.AI_KEY_LONG_CLICK_START)) {
                C0().c(SystemClock.elapsedRealtime());
            } else if (kotlin.jvm.internal.p.d(stringExtra2, C4814a.AI_KEY_LONG_CLICK_END)) {
                C0().f(SystemClock.elapsedRealtime());
            } else if (Z8.F.f0(C4814a.INSTANCE.b(), stringExtra2)) {
                C0().b();
            }
            C3475d.INSTANCE.c(com.stepos.ailauncher.chat.trace.h.INSTANCE.d(stringExtra2));
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(Boolean.valueOf(X1(context)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Boolean bool = Boolean.FALSE;
            if (Result.g(objB)) {
                objB = bool;
            }
            final boolean zBooleanValue = ((Boolean) objB).booleanValue();
            if (kotlin.jvm.internal.p.d(stringExtra2, C4814a.AI_KEY_LONG_CLICK_END)) {
                D0();
                return;
            }
            if (kotlin.jvm.internal.p.d(stringExtra2, C4814a.AI_KEY_LONG_CLICK_START)) {
                k1(true);
            }
            try {
                C2069d0.INSTANCE.a();
                objB2 = Result.b(Y8.t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            Throwable thE = Result.e(objB2);
            if (thE != null) {
                C4148a.t(WakeService.TAG, "dismiss SourcesPanelPopup on wake failed", thE, false, 8, null);
            }
            T0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.q2
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return WakeService.Companion.P1(context, stringExtra2, zBooleanValue);
                }
            });
        }

        public final boolean K0() {
            return WakeService.aiKeyLongPressHolding;
        }

        public final void K1(Context context, String text, List<? extends Uri> uris) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(uris, "uris");
            C1060i.d(WakeService.wakeDispatchScope, null, null, new WakeService$Companion$wake$5(text, uris, context.getApplicationContext(), null), 3, null);
        }

        public final void L() {
            Runnable runnable = WakeService.pendingAgentWakeRetry;
            if (runnable != null) {
                WakeService.agentWakeRetryHandler.removeCallbacks(runnable);
            }
            WakeService.pendingAgentWakeRetry = null;
        }

        public final boolean L0() {
            BaseInputView baseInputViewR0 = r0();
            return baseInputViewR0 != null && baseInputViewR0.R7();
        }

        public final void L1(Context context, final String text, final List<FileInfo> files, final boolean defaultSend, String from) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("WakeService.wake(text='%s' textLen=%d files=%d)", Arrays.copyOf(new Object[]{text, Integer.valueOf(text != null ? text.length() : -1), Integer.valueOf(files != null ? files.size() : 0)}, 3));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.k("DIAG-WAKE-NOSEND", str, false, 4, null);
            if (!K(this, context, null, 2, null)) {
                C4148a.u("DIAG-WAKE-NOSEND", "WakeService.wake → canWake=false, dropped pendingSendObj", false, 4, null);
                s1(null);
                return;
            }
            final String str2 = WakeDialogImpl.INSTANCE.f(from) ? WakeDialogImpl.MSG_SOURCE_AI_WAKE : null;
            final BaseInputView baseInputViewR0 = r0();
            if (baseInputViewR0 != null) {
                BaseInputView.id(baseInputViewR0, null, 1, null);
                baseInputViewR0.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.f2
                    @Override // java.lang.Runnable
                    public final void run() {
                        WakeService.Companion.Q1(baseInputViewR0, text, files, defaultSend, str2);
                    }
                }, 200L);
                s1(null);
                C4148a.k("DIAG-WAKE-NOSEND", "WakeService.wake → warm inputView, inject directly", false, 4, null);
                return;
            }
            Intent intent = new Intent(context, (Class<?>) WakeService.class);
            intent.setAction(WakeService.ACTION_WAKE);
            s1(Y8.j.a(text, files));
            if (from != null && from.length() != 0) {
                v1(from);
            }
            C4148a.k("DIAG-WAKE-NOSEND", "WakeService.wake → startService, pendingSendObj set", false, 4, null);
            context.startService(intent);
        }

        public final void M() {
            WakeService.wakePreparationGeneration++;
            Runnable runnable = WakeService.pendingWakePreparation;
            if (runnable != null) {
                WakeService.agentWakeRetryHandler.removeCallbacks(runnable);
            }
            WakeService.pendingWakePreparation = null;
        }

        public final boolean M0() {
            return System.currentTimeMillis() - WakeService.nonVoiceWakeAtMs < 1500;
        }

        public final void M1(Context context, String text, boolean defaultSendTxt) {
            kotlin.jvm.internal.p.i(context, "context");
            N1(this, context, text, null, defaultSendTxt, null, 16, null);
        }

        public final boolean N(Context context, String source) {
            kotlin.jvm.internal.p.i(context, "context");
            MicOccupancyMonitor micOccupancyMonitor = MicOccupancyMonitor.INSTANCE;
            micOccupancyMonitor.D();
            MicOccupancyMonitor.OccupancyKind occupancyKindH = micOccupancyMonitor.h();
            MicConflictPolicy.AgentEntry agentEntryN0 = N0(source);
            if (agentEntryN0 == null) {
                return true;
            }
            if (MicConflictPolicy.INSTANCE.a(agentEntryN0).getAllowed()) {
                if (agentEntryN0 != MicConflictPolicy.AgentEntry.AI_KEY_OR_HEADSET) {
                    Q.f(Q.INSTANCE, context, "checkMicPolicy:" + source, null, 4, null);
                }
                return true;
            }
            C4148a.d(WakeService.TAG, "checkMicPolicy: blocked entry=" + agentEntryN0 + " occupancy=" + occupancyKindH, false, 4, null);
            com.stepos.ailauncher.chat.trace.h hVar = com.stepos.ailauncher.chat.trace.h.INSTANCE;
            String strD = hVar.d(source);
            String strA = hVar.a(context);
            int i10 = a.$EnumSwitchMapping$0[micOccupancyMonitor.h().ordinal()];
            hVar.e(strD, strA, i10 != 1 ? i10 != 2 ? i10 != 3 ? "unknown" : "call" : "other_app" : com.stepos.ailauncher.chat.trace.h.OCCUPIED_RECORDER, com.stepos.ailauncher.chat.trace.h.BLOCK_BEFORE_WAKEUP, O6.x.INSTANCE.a());
            if (agentEntryN0 == MicConflictPolicy.AgentEntry.VOICE_WAKEUP) {
                com.stepos.agentframework.chatui.util.d.p(com.stepos.agentframework.chatui.util.d.INSTANCE, context, R$string.mic_occupied_wake, null, 4, null);
            } else if (occupancyKindH == MicOccupancyMonitor.OccupancyKind.SYSTEM_CALL) {
                y1(context, R$string.call_agent_wake_blocked);
            } else if (agentEntryN0 == MicConflictPolicy.AgentEntry.HEADSET_WAKEUP) {
                y1(context, R$string.mic_occupied_wake);
            }
            return false;
        }

        public final MicConflictPolicy.AgentEntry N0(String source) {
            if (source == null) {
                return null;
            }
            switch (source.hashCode()) {
                case -1418033720:
                    if (!source.equals(C4814a.AI_KEY_CLICK2)) {
                        return null;
                    }
                    break;
                case -1350521956:
                    if (source.equals(C4814a.HEADSET_WAKEUP)) {
                        return MicConflictPolicy.AgentEntry.HEADSET_WAKEUP;
                    }
                    return null;
                case -951070683:
                    if (!source.equals(C4814a.BOTTOM_BAR_KEY_LONG_CLICK)) {
                        return null;
                    }
                    break;
                case -926107835:
                    if (!source.equals(C4814a.HOME_KEY_LONG_CLICK)) {
                        return null;
                    }
                    break;
                case 293766892:
                    if (source.equals("voice_wakeup")) {
                        return MicConflictPolicy.AgentEntry.VOICE_WAKEUP;
                    }
                    return null;
                case 643045183:
                    if (source.equals(C4814a.AI_KEY_LONG_CLICK_START)) {
                        return MicConflictPolicy.AgentEntry.AI_KEY_LONG_PRESS;
                    }
                    return null;
                case 1080244305:
                    if (!source.equals("ai_key_click")) {
                        return null;
                    }
                    break;
                default:
                    return null;
            }
            return MicConflictPolicy.AgentEntry.AI_KEY_OR_HEADSET;
        }

        public final boolean O(Context context, String source) {
            IExpressService iExpressService = (IExpressService) D5.a.INSTANCE.a(IExpressService.class);
            boolean z10 = iExpressService != null && iExpressService.shouldSuppressAiKeyWake();
            if (kotlin.jvm.internal.p.d(source, C4814a.AI_KEY_LONG_CLICK_END)) {
                boolean z11 = WakeService.expressAiKeyLongPressConsumed && z10;
                WakeService.expressAiKeyLongPressConsumed = false;
                if (!z11) {
                    return false;
                }
                C4148a.d(WakeService.TAG, "AI_KEY_LONG_END consumed: Amoo Express is listening", false, 4, null);
                return true;
            }
            if (!Z8.F.f0(WakeService.AI_KEY_WAKE_SOURCES, source)) {
                return false;
            }
            WakeService.expressAiKeyLongPressConsumed = false;
            if (!z10) {
                return false;
            }
            if (kotlin.jvm.internal.p.d(source, C4814a.AI_KEY_LONG_CLICK_START)) {
                WakeService.expressAiKeyLongPressConsumed = true;
            }
            b1(this, context, source, com.stepos.ailauncher.chat.trace.h.RESULT_IGNORED, null, com.stepos.ailauncher.chat.trace.h.FAIL_SYSTEM_INTERRUPTED, false, 40, null);
            C4148a.d(WakeService.TAG, "AI_KEY suppressed: Amoo Express is listening, source=" + source, false, 4, null);
            return true;
        }

        public final void O0() {
            WakeService.nonVoiceWakeAtMs = System.currentTimeMillis();
        }

        public final synchronized boolean P() {
            boolean zU0;
            zU0 = u0();
            o1(false);
            return zU0;
        }

        public final void P0(boolean hidden) {
            WakeService.overlayExternallyHidden = hidden;
        }

        public final ExternalSessionRef Q() {
            ExternalSessionRef externalSessionRefW0 = w0();
            q1(null);
            return externalSessionRefW0;
        }

        public final void Q0(String title, List<String> items, String fileId) {
            List<String> listB;
            List<String> listB2;
            synchronized (WakeService.suggestPayloadLock) {
                try {
                    Companion companion = WakeService.INSTANCE;
                    SuggestPayload suggestPayloadB0 = companion.B0();
                    if (items.isEmpty() && suggestPayloadB0 != null && (listB = suggestPayloadB0.b()) != null) {
                        if (listB.isEmpty()) {
                            listB = null;
                        }
                        if (listB != null) {
                            items = listB;
                        }
                    }
                    if (fileId == null) {
                        fileId = suggestPayloadB0 != null ? suggestPayloadB0.getFileId() : null;
                    }
                    companion.w1(new SuggestPayload(title, items, fileId));
                    kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                    String str = String.format("wakeWithSuggestions: set pendingSuggestPayload title='%s' items=%d fileId=%s dialogExisted=%s (merged from existing items=%d)", Arrays.copyOf(new Object[]{title, Integer.valueOf(items.size()), fileId, Boolean.valueOf(DialogC3116e0.INSTANCE.a()), Integer.valueOf((suggestPayloadB0 == null || (listB2 = suggestPayloadB0.b()) == null) ? -1 : listB2.size())}, 5));
                    kotlin.jvm.internal.p.h(str, "format(...)");
                    C4148a.d(WakeService.TAG, str, false, 4, null);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final InstalledAgentRef R() {
            InstalledAgentRef installedAgentRefX0 = x0();
            r1(null);
            return installedAgentRefX0;
        }

        public final void R0(String source) {
            if (source != null) {
                switch (source.hashCode()) {
                    case -1418033720:
                        if (!source.equals(C4814a.AI_KEY_CLICK2)) {
                            return;
                        }
                        break;
                    case 293766892:
                        if (source.equals("voice_wakeup")) {
                            U5.b.INSTANCE.m();
                            return;
                        }
                        return;
                    case 643045183:
                        if (source.equals(C4814a.AI_KEY_LONG_CLICK_START)) {
                            U5.b.INSTANCE.l();
                            return;
                        }
                        return;
                    case 1080244305:
                        if (!source.equals("ai_key_click")) {
                            return;
                        }
                        break;
                    default:
                        return;
                }
                U5.b.INSTANCE.k();
            }
        }

        public final void R1(Context context, final String source) {
            b1(this, context, source, "success", "listening", null, false, 48, null);
            final String strC = com.stepos.ailauncher.chat.trace.g.INSTANCE.c(source);
            BaseInputView baseInputViewR0 = r0();
            if (baseInputViewR0 != null) {
                Companion companion = WakeService.INSTANCE;
                Z0(companion, context, true, null, false, 12, null);
                companion.L();
                baseInputViewR0.hd(source);
                BaseInputView.oc(baseInputViewR0, null, strC, 1, null);
                companion.p0(source);
                return;
            }
            boolean zE = com.stepos.ailauncher.common.utils.y.INSTANCE.e("agent_space");
            boolean zJ0 = J0(source);
            if (zE && zJ0 && !DialogC3116e0.INSTANCE.a()) {
                g1(source, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.u2
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return WakeService.Companion.S1(source, strC, (BaseInputView) obj);
                    }
                });
            } else {
                A1(context, source);
            }
        }

        public final void S() {
            v1(null);
            t1(null);
        }

        public final void S0(BaseInputView inputView) {
            Runnable runnable;
            kotlin.jvm.internal.p.i(inputView, "inputView");
            boolean zJ0 = InputViewManager.INSTANCE.J0(inputView);
            boolean z10 = WakeService.pendingAgentWakeRetry != null;
            C4148a.d("AgentFocusWake", "focusGained view=" + inputView.getClass().getSimpleName() + "@" + Integer.toHexString(inputView.hashCode()) + " isAgentInputView=" + zJ0 + " hasPendingRetry=" + z10, false, 4, null);
            if (zJ0 && (runnable = WakeService.pendingAgentWakeRetry) != null) {
                WakeService.agentWakeRetryHandler.removeCallbacks(runnable);
                C4148a.d(WakeService.TAG, "Agent focus restored, execute pending wake", false, 4, null);
                runnable.run();
            }
        }

        public final synchronized Pair<String, List<FileInfo>> T() {
            Pair<String, List<FileInfo>> pairY0;
            pairY0 = y0();
            s1(null);
            return pairY0;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [T, com.stepos.ailauncher.chat.wake.i2] */
        public final void T0(final InterfaceC5063a<Y8.t> action) {
            if (!kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
                WakeService.agentWakeRetryHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.h2
                    @Override // java.lang.Runnable
                    public final void run() {
                        WakeService.Companion.U0(action);
                    }
                });
                return;
            }
            M();
            final long j10 = WakeService.wakePreparationGeneration;
            InputViewManager.WakeUiPreparationResult wakeUiPreparationResultT0 = InputViewManager.INSTANCE.T0();
            if (!wakeUiPreparationResultT0.a()) {
                action.invoke();
                return;
            }
            Runnable runnable = null;
            C4148a.d(WakeService.TAG, "prepareChatWindowsForWake: dismissed=" + Z8.F.A0(wakeUiPreparationResultT0.b(), null, null, null, 0, null, null, 63, null) + ", defer dispatch one frame", false, 4, null);
            final long jUptimeMillis = SystemClock.uptimeMillis();
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ?? r12 = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.i2
                @Override // java.lang.Runnable
                public final void run() {
                    WakeService.Companion.V0(j10, jUptimeMillis, action, ref$ObjectRef);
                }
            };
            ref$ObjectRef.f34820a = r12;
            WakeService.pendingWakePreparation = (Runnable) r12;
            Handler handler = WakeService.agentWakeRetryHandler;
            T t10 = ref$ObjectRef.f34820a;
            if (t10 == 0) {
                kotlin.jvm.internal.p.A("retry");
            } else {
                runnable = (Runnable) t10;
            }
            handler.post(runnable);
        }

        public final void T1(Context context) {
            if (J(context, A0())) {
                BaseInputView baseInputViewR0 = r0();
                if (baseInputViewR0 == null) {
                    Intent intent = new Intent(context, (Class<?>) WakeService.class);
                    intent.setAction(WakeService.ACTION_WAKE);
                    context.startService(intent);
                } else {
                    Companion companion = WakeService.INSTANCE;
                    Z0(companion, context, true, null, false, 12, null);
                    baseInputViewR0.hd(companion.A0());
                    companion.p0(companion.A0());
                }
            }
        }

        public final synchronized SharePayload U() {
            SharePayload sharePayloadZ0;
            sharePayloadZ0 = z0();
            u1(null);
            return sharePayloadZ0;
        }

        public final void U1(Context context, String text, String source) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(text, "text");
            kotlin.jvm.internal.p.i(source, "source");
            if (La.H.x0(text)) {
                return;
            }
            C1060i.d(WakeService.wakeDispatchScope, null, null, new WakeService$Companion$wakeWithCardText$1(source, text, context.getApplicationContext(), null), 3, null);
        }

        public final synchronized SuggestPayload V() {
            SuggestPayload suggestPayloadB0;
            suggestPayloadB0 = B0();
            w1(null);
            return suggestPayloadB0;
        }

        public final void V1(Context context, String sessionId) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            if (La.H.x0(sessionId)) {
                I1(context);
            } else {
                C1060i.d(WakeService.wakeDispatchScope, null, null, new WakeService$Companion$wakeWithSession$1(sessionId, context.getApplicationContext(), null), 3, null);
            }
        }

        public final void W(Context context, String source, boolean screenOffAtWake) {
            if (kotlin.jvm.internal.p.d(source, C4814a.AI_KEY_LONG_CLICK_START) || kotlin.jvm.internal.p.d(source, C4814a.AI_KEY_LONG_CLICK_END)) {
                source = "ai_key_click";
            }
            d0(context, source, screenOffAtWake);
        }

        public final boolean W0(String source) {
            BaseInputView baseInputViewR0 = r0();
            if (baseInputViewR0 == null) {
                return false;
            }
            if ((!baseInputViewR0.a8() && !baseInputViewR0.getListenModeActive()) || baseInputViewR0.R7()) {
                return false;
            }
            C4148a.d(WakeService.TAG, "refreshActiveListeningInPlace: restart listening in place", false, 4, null);
            R0(source);
            baseInputViewR0.pa(com.stepos.ailauncher.chat.trace.g.INSTANCE.c(source));
            return true;
        }

        public final void W1(Context context, String title, List<String> items, String text, List<? extends Uri> uris, String fileId) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(title, "title");
            kotlin.jvm.internal.p.i(items, "items");
            C1060i.d(WakeService.wakeDispatchScope, null, null, new WakeService$Companion$wakeWithSuggestions$1(context.getApplicationContext(), title, items, fileId, text, uris, null), 3, null);
        }

        public final String X() {
            String strB;
            AgentSession.AgentConversation agentConversationR1;
            String strB2;
            SessionHandler sessionHandler;
            AgentSession.AgentConversation agentConversationR12;
            BaseInputView baseInputViewR0 = InputViewManager.INSTANCE.r0();
            if (baseInputViewR0 == null || (sessionHandler = baseInputViewR0.getSessionHandler()) == null || (agentConversationR12 = sessionHandler.R1()) == null || (strB = agentConversationR12.B()) == null || strB.length() <= 0) {
                strB = null;
            }
            if (strB != null) {
                return strB;
            }
            SessionHandler sessionHandler2 = AgentConfig.INSTANCE.a().getSessionHandler();
            if (sessionHandler2 == null || (agentConversationR1 = sessionHandler2.R1()) == null || (strB2 = agentConversationR1.B()) == null || strB2.length() <= 0) {
                return null;
            }
            return strB2;
        }

        public final void X0(String source) {
            com.stepos.ailauncher.chat.trace.h hVar = com.stepos.ailauncher.chat.trace.h.INSTANCE;
            com.stepos.ailauncher.chat.trace.h.i(hVar, hVar.d(source), "success", "success", null, O6.x.INSTANCE.a(), 8, null);
        }

        public final boolean X1(Context context) {
            Display display;
            com.stepos.ailauncher.common.utils.J j10 = com.stepos.ailauncher.common.utils.J.INSTANCE;
            j10.d(context);
            Object systemService = context.getApplicationContext().getSystemService("display");
            DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
            Integer numValueOf = (displayManager == null || (display = displayManager.getDisplay(0)) == null) ? null : Integer.valueOf(display.getState());
            Object systemService2 = context.getSystemService("power");
            PowerManager powerManager = systemService2 instanceof PowerManager ? (PowerManager) systemService2 : null;
            Boolean boolValueOf = powerManager != null ? Boolean.valueOf(powerManager.isInteractive()) : null;
            boolean zF = j10.f(context);
            boolean zG = j10.g(1500L);
            boolean zL = com.stepos.ailauncher.chat.trace.h.INSTANCE.l(zF, boolValueOf, numValueOf, zG);
            C4148a.k(WakeService.TAG, "screenOffAtWake=" + zL + " monitorOff=" + zF + " interactive=" + boolValueOf + " displayState=" + numValueOf + " recentlyWokeFromOff=" + zG, false, 4, null);
            return zL;
        }

        public final void Y(InterfaceC5063a<Y8.t> action) {
            BaseInputView baseInputViewR0 = r0();
            if (baseInputViewR0 == null || !baseInputViewR0.P7()) {
                action.invoke();
            } else {
                baseInputViewR0.Ea(true, action);
            }
        }

        public final void Y0(Context context, boolean reuse, String sessionId, boolean appInForeground) {
            com.stepos.ailauncher.chat.trace.h hVar = com.stepos.ailauncher.chat.trace.h.INSTANCE;
            hVar.j(reuse ? com.stepos.ailauncher.chat.trace.h.DISPATCH_REUSE : com.stepos.ailauncher.chat.trace.h.DISPATCH_CREATE_NEW, appInForeground ? com.stepos.ailauncher.chat.trace.h.APP_FOREGROUND : "background", hVar.a(context), Boolean.valueOf(reuse), Boolean.FALSE, sessionId, O6.x.INSTANCE.a());
        }

        public final void Z(Context context, boolean noAnim) {
            kotlin.jvm.internal.p.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) WakeService.class);
            intent.setAction(WakeService.ACTION_DISMISS);
            intent.putExtra(N5.d.EXTRA_DISMISS_NO_ANIM, noAnim);
            context.startService(intent);
        }

        public final void a1(Context context, String source, String result, String targetState, String failReason, boolean notifyWakeSprite) {
            com.stepos.ailauncher.chat.trace.h hVar = com.stepos.ailauncher.chat.trace.h.INSTANCE;
            hVar.k(X(), hVar.d(source), hVar.a(context), result, targetState, failReason, O6.x.INSTANCE.a());
            if (kotlin.jvm.internal.p.d(result, "success") && notifyWakeSprite) {
                R0(source);
            }
        }

        public final void b0(Context context) {
            DialogC3116e0 dialogC3116e0Y0 = InputViewManager.INSTANCE.y0();
            WakeDialogImpl wakeDialogImpl = dialogC3116e0Y0 instanceof WakeDialogImpl ? (WakeDialogImpl) dialogC3116e0Y0 : null;
            if (wakeDialogImpl != null && wakeDialogImpl.isShowing()) {
                wakeDialogImpl.d3(C4814a.AI_KEY_LONG_CLICK_START);
                return;
            }
            BaseInputView baseInputViewR0 = r0();
            if (baseInputViewR0 != null) {
                Companion companion = WakeService.INSTANCE;
                companion.L();
                baseInputViewR0.hd(C4814a.AI_KEY_LONG_CLICK_START);
                baseInputViewR0.t4();
                companion.p0(C4814a.AI_KEY_LONG_CLICK_START);
                return;
            }
            if (!com.stepos.ailauncher.common.utils.y.INSTANCE.e("agent_space") || DialogC3116e0.INSTANCE.a()) {
                A1(context, C4814a.AI_KEY_LONG_CLICK_START);
            } else {
                g1(C4814a.AI_KEY_LONG_CLICK_START, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.n2
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return WakeService.Companion.c0((BaseInputView) obj);
                    }
                });
            }
        }

        public final void c1(Context context, InterfaceC5063a<Y8.t> onReady) {
            final Context applicationContext = context.getApplicationContext();
            final long J10 = com.stepos.ailauncher.common.permission.G.INSTANCE.J();
            S1 s12 = WakeService.wakePermissionSequence;
            InterfaceC5063a<Boolean> interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.l2
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(WakeService.Companion.d1(J10));
                }
            };
            List<PermScene> listP = C1173v.p(PermScene.PHONE_STATE, PermScene.NOTIFICATION);
            ArrayList arrayList = new ArrayList(C1174w.x(listP, 10));
            for (final PermScene permScene : listP) {
                arrayList.add(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.m2
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return WakeService.Companion.e1(applicationContext, permScene, J10, (InterfaceC5063a) obj);
                    }
                });
            }
            s12.c(interfaceC5063a, arrayList, onReady);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x01f2, code lost:
        
            if (r18.equals(k5.C4814a.LOCK_SCREEN_LONG_CLICK) == false) goto L183;
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x03ad, code lost:
        
            if (r18.equals(k5.C4814a.AI_KEY_CLICK2) == false) goto L183;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void d0(final android.content.Context r17, final java.lang.String r18, final boolean r19) {
            /*
                Method dump skipped, instructions count: 1056
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.WakeService.Companion.d0(android.content.Context, java.lang.String, boolean):void");
        }

        public final void g1(final String source, final InterfaceC5074l<? super BaseInputView, Y8.t> action) {
            if (WakeService.pendingAgentWakeRetry != null) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.y2
                @Override // java.lang.Runnable
                public final void run() {
                    WakeService.Companion.h1(action, source);
                }
            };
            WakeService.pendingAgentWakeRetry = runnable;
            C4148a.d(WakeService.TAG, "Schedule Agent wake retry: source=" + source, false, 4, null);
            WakeService.agentWakeRetryHandler.postDelayed(runnable, 250L);
        }

        public final void i1(Context context, String text) {
            kotlin.jvm.internal.p.i(context, "context");
            if (text == null || La.H.x0(text)) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) WakeService.class);
            intent.setAction(WakeService.ACTION_CARD_SEND_TEXT);
            intent.putExtra(WakeService.EXTRA_CARD_TEXT, text);
            context.startService(intent);
        }

        public final void j1(Context context, String text) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(text, "text");
            C1060i.d(WakeService.wakeDispatchScope, null, null, new WakeService$Companion$sendTextToVisibleChatOrWake$1(context.getApplicationContext(), text, null), 3, null);
        }

        public final void k1(boolean holding) {
            if (WakeService.aiKeyLongPressHolding == holding) {
                return;
            }
            WakeService.aiKeyLongPressHolding = holding;
            C4148a.k(WakeService.TAG, "aiKeyLongPressHolding=" + holding, false, 4, null);
            Activity activityX0 = InputViewManager.INSTANCE.x0();
            final ChatActivity chatActivity = activityX0 instanceof ChatActivity ? (ChatActivity) activityX0 : null;
            if (chatActivity == null) {
                return;
            }
            chatActivity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.k2
                @Override // java.lang.Runnable
                public final void run() {
                    WakeService.Companion.l1(chatActivity);
                }
            });
        }

        public final void m1(boolean z10) {
            WakeService.enableExpandScrim = z10;
        }

        public final void n0(final BaseInputView input, String source) {
            List<FileInfo> list;
            kotlin.jvm.internal.p.i(input, "input");
            Pair<String, List<FileInfo>> pairT = T();
            if (pairT != null) {
                final String strA = pairT.a();
                final List<FileInfo> listB = pairT.b();
                if ((strA != null && strA.length() != 0) || ((list = listB) != null && !list.isEmpty())) {
                    final String str = WakeDialogImpl.INSTANCE.f(source) ? WakeDialogImpl.MSG_SOURCE_AI_WAKE : null;
                    input.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.z2
                        @Override // java.lang.Runnable
                        public final void run() {
                            WakeService.Companion.o0(input, strA, listB, str);
                        }
                    }, 200L);
                }
            }
            SharePayload sharePayloadU = U();
            if (sharePayloadU != null) {
                input.G4(sharePayloadU.getText(), sharePayloadU.b());
            }
        }

        public final void n1(String str) {
            WakeService.pendingCardText = str;
        }

        public final void o1(boolean z10) {
            WakeService.pendingCircleSelectEnabled = z10;
        }

        public final void p0(String source) {
            if (Z8.F.f0(C4814a.INSTANCE.b(), source)) {
                Activity activityX0 = InputViewManager.INSTANCE.x0();
                final ChatActivity chatActivity = activityX0 instanceof ChatActivity ? (ChatActivity) activityX0 : null;
                if (chatActivity == null) {
                    return;
                }
                chatActivity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.w2
                    @Override // java.lang.Runnable
                    public final void run() {
                        WakeService.Companion.q0(chatActivity);
                    }
                });
            }
        }

        public final void p1(ExternalSessionRef externalSessionRef) {
            WakeService.pendingExternalSession = externalSessionRef;
        }

        public final void q1(ExternalSessionRef externalSessionRef) {
            WakeService.pendingHomeExternalSession = externalSessionRef;
        }

        public final BaseInputView r0() {
            InputViewManager inputViewManager = InputViewManager.INSTANCE;
            DialogC3116e0 dialogC3116e0Y0 = inputViewManager.y0();
            WakeDialogImpl wakeDialogImpl = dialogC3116e0Y0 instanceof WakeDialogImpl ? (WakeDialogImpl) dialogC3116e0Y0 : null;
            if (wakeDialogImpl != null && wakeDialogImpl.getDismissingWithAnim()) {
                return null;
            }
            BaseInputView baseInputViewQ0 = inputViewManager.q0();
            if (baseInputViewQ0 != null) {
                BaseInputView baseInputView = baseInputViewQ0.Y7() ? baseInputViewQ0 : null;
                if (baseInputView != null) {
                    return baseInputView;
                }
            }
            return inputViewManager.r0();
        }

        public final void r1(InstalledAgentRef installedAgentRef) {
            WakeService.pendingHomeInstalledSession = installedAgentRef;
        }

        public final boolean s0() {
            return WakeService.enableExpandScrim;
        }

        public final void s1(Pair<String, ? extends List<FileInfo>> pair) {
            WakeService.pendingSendObj = pair;
        }

        public final boolean t0() {
            return WakeService.overlayExternallyHidden;
        }

        public final void t1(String str) {
            WakeService.pendingSessionId = str;
        }

        public final boolean u0() {
            return WakeService.pendingCircleSelectEnabled;
        }

        public final void u1(SharePayload sharePayload) {
            WakeService.pendingSharePayload = sharePayload;
        }

        public final ExternalSessionRef v0() {
            return WakeService.pendingExternalSession;
        }

        public final void v1(String str) {
            WakeService.pendingStartSource = str;
        }

        public final ExternalSessionRef w0() {
            return WakeService.pendingHomeExternalSession;
        }

        public final void w1(SuggestPayload suggestPayload) {
            WakeService.pendingSuggestPayload = suggestPayload;
        }

        public final InstalledAgentRef x0() {
            return WakeService.pendingHomeInstalledSession;
        }

        public final void x1(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) WakeService.class);
            intent.setAction(WakeService.ACTION_SHOW);
            context.startService(intent);
        }

        public final Pair<String, List<FileInfo>> y0() {
            return WakeService.pendingSendObj;
        }

        public final void y1(Context context, final int messageResId) {
            final Context applicationContext = context.getApplicationContext();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.s2
                @Override // java.lang.Runnable
                public final void run() {
                    WakeService.Companion.z1(applicationContext, messageResId);
                }
            });
        }

        public final SharePayload z0() {
            return WakeService.pendingSharePayload;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/WakeService$a;", "", "", "text", "", "Landroid/net/Uri;", "uris", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.WakeService$a, reason: from toString */
    public static final /* data */ class SharePayload {
        private final String text;
        private final List<Uri> uris;

        /* JADX WARN: Multi-variable type inference failed */
        public SharePayload(String str, List<? extends Uri> uris) {
            kotlin.jvm.internal.p.i(uris, "uris");
            this.text = str;
            this.uris = uris;
        }

        /* renamed from: a, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final List<Uri> b() {
            return this.uris;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharePayload)) {
                return false;
            }
            SharePayload sharePayload = (SharePayload) other;
            return kotlin.jvm.internal.p.d(this.text, sharePayload.text) && kotlin.jvm.internal.p.d(this.uris, sharePayload.uris);
        }

        public int hashCode() {
            String str = this.text;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.uris.hashCode();
        }

        public String toString() {
            return "SharePayload(text=" + this.text + ", uris=" + this.uris + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0017\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/WakeService$b;", "", "", "title", "", DidiCardProvider.KEY_ITEMS, "fileId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.WakeService$b, reason: from toString */
    public static final /* data */ class SuggestPayload {
        private final String fileId;
        private final List<String> items;
        private final String title;

        public SuggestPayload(String title, List<String> items, String str) {
            kotlin.jvm.internal.p.i(title, "title");
            kotlin.jvm.internal.p.i(items, "items");
            this.title = title;
            this.items = items;
            this.fileId = str;
        }

        /* renamed from: a, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        public final List<String> b() {
            return this.items;
        }

        /* renamed from: c, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SuggestPayload)) {
                return false;
            }
            SuggestPayload suggestPayload = (SuggestPayload) other;
            return kotlin.jvm.internal.p.d(this.title, suggestPayload.title) && kotlin.jvm.internal.p.d(this.items, suggestPayload.items) && kotlin.jvm.internal.p.d(this.fileId, suggestPayload.fileId);
        }

        public int hashCode() {
            int iHashCode = ((this.title.hashCode() * 31) + this.items.hashCode()) * 31;
            String str = this.fileId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "SuggestPayload(title=" + this.title + ", items=" + this.items + ", fileId=" + this.fileId + ")";
        }
    }

    public static final void e0(String str, WakeService wakeService) {
        InputViewManager inputViewManager = InputViewManager.INSTANCE;
        BaseInputView baseInputViewB0 = inputViewManager.B0();
        if (baseInputViewB0 != null) {
            R5.b.INSTANCE.c("wake.cardSendText.input", Y8.j.a("len", Integer.valueOf(str.length())));
            baseInputViewB0.Va(str);
            return;
        }
        WakeDialogImpl wakeDialogImpl = wakeService.activeDialog;
        if (wakeDialogImpl == null) {
            DialogC3116e0 dialogC3116e0Y0 = inputViewManager.y0();
            wakeDialogImpl = dialogC3116e0Y0 instanceof WakeDialogImpl ? (WakeDialogImpl) dialogC3116e0Y0 : null;
        }
        if (wakeDialogImpl == null) {
            R5.b.INSTANCE.h("wake.cardSendText.noHost", new Pair[0]);
        } else {
            R5.b.INSTANCE.c("wake.cardSendText.dialog", Y8.j.a("len", Integer.valueOf(str.length())));
            wakeDialogImpl.I5(str);
        }
    }

    public static final void g0(WakeService wakeService, boolean z10) {
        boolean zE1 = DesktopChatResidentController.e1();
        WakeDialogImpl wakeDialogImpl = wakeService.activeDialog;
        if (wakeDialogImpl == null) {
            DialogC3116e0 dialogC3116e0Y0 = InputViewManager.INSTANCE.y0();
            wakeDialogImpl = dialogC3116e0Y0 instanceof WakeDialogImpl ? (WakeDialogImpl) dialogC3116e0Y0 : null;
        }
        if (wakeDialogImpl == null) {
            if (zE1) {
                return;
            }
            C4148a.d(TAG, "handleDismiss: no dialog noAnim=" + z10, false, 4, null);
            return;
        }
        C4148a.d(TAG, "handleDismiss: dismissing dialog noAnim=" + z10, false, 4, null);
        if (wakeDialogImpl.isShowing()) {
            if (z10) {
                WakeDialogImpl.I3(wakeDialogImpl, null, 1, null);
            } else {
                wakeDialogImpl.J3();
            }
        }
    }

    public static final void i0(WakeService wakeService) {
        Window window;
        DialogC3116e0 dialogC3116e0Y0 = wakeService.activeDialog;
        if (dialogC3116e0Y0 == null) {
            dialogC3116e0Y0 = InputViewManager.INSTANCE.y0();
        }
        View decorView = (dialogC3116e0Y0 == null || (window = dialogC3116e0Y0.getWindow()) == null) ? null : window.getDecorView();
        if (dialogC3116e0Y0 != null && decorView != null && decorView.isAttachedToWindow()) {
            decorView.setVisibility(4);
            INSTANCE.P0(true);
            C4148a.k(TAG, "handleHideOverlay: decorView INVISIBLE (session kept, isShowing=" + dialogC3116e0Y0.isShowing() + ")", false, 4, null);
            return;
        }
        C4148a.d(TAG, "handleHideOverlay: no-op dialog=" + (dialogC3116e0Y0 != null) + " showing=" + (dialogC3116e0Y0 != null ? Boolean.valueOf(dialogC3116e0Y0.isShowing()) : null) + " decorAttached=" + (decorView != null ? Boolean.valueOf(decorView.isAttachedToWindow()) : null), false, 4, null);
    }

    public static final void k0(WakeService wakeService) {
        Window window;
        DialogC3116e0 dialogC3116e0Y0 = wakeService.activeDialog;
        if (dialogC3116e0Y0 == null) {
            dialogC3116e0Y0 = InputViewManager.INSTANCE.y0();
        }
        View decorView = (dialogC3116e0Y0 == null || (window = dialogC3116e0Y0.getWindow()) == null) ? null : window.getDecorView();
        if (dialogC3116e0Y0 == null || decorView == null) {
            boolean z10 = dialogC3116e0Y0 != null;
            C4148a.d(TAG, "handleShowOverlay: no-op dialog=" + z10 + " externallyHidden=" + overlayExternallyHidden, false, 4, null);
            INSTANCE.P0(false);
            return;
        }
        decorView.setVisibility(0);
        INSTANCE.P0(false);
        C4148a.k(TAG, "handleShowOverlay: decorView VISIBLE (isShowing=" + dialogC3116e0Y0.isShowing() + " attached=" + decorView.isAttachedToWindow() + ")", false, 4, null);
    }

    public static final Y8.t m0(WakeService wakeService) {
        wakeService.n0();
        return Y8.t.f7040a;
    }

    public static final void o0(long j10, final WakeService wakeService) {
        Context contextCreateConfigurationContext;
        WakeDialogImpl wakeDialogImpl;
        WakeDialogImpl wakeDialogImpl2;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("+%dms handleWake:main-handler post fired", Arrays.copyOf(new Object[]{Long.valueOf(SystemClock.elapsedRealtime() - j10)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.k("WakeShowTiming", str, false, 4, null);
        wakeService.mainHandler.removeCallbacks(wakeService.stopSelfRunnable);
        if (DialogC3116e0.INSTANCE.a()) {
            WakeDialogImpl wakeDialogImpl3 = wakeService.activeDialog;
            if (wakeDialogImpl3 == null) {
                wakeDialogImpl3 = null;
            }
            if (wakeDialogImpl3 != null && wakeDialogImpl3.getDismissingWithAnim()) {
                C4148a.d(TAG, "handleWake: dialog dismissing, retry after anim", false, 4, null);
                wakeService.mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.d2
                    @Override // java.lang.Runnable
                    public final void run() {
                        WakeService.p0(this.f26742a);
                    }
                }, 350L);
                return;
            }
            C4148a.d(TAG, "handleWake: dialog already exists, skip", false, 4, null);
            Pair<String, ? extends List<FileInfo>> pair = pendingSendObj;
            if (pair != null) {
                String strE = pair.e();
                List<FileInfo> listF = pair.f();
                if (strE != null && (wakeDialogImpl2 = wakeService.activeDialog) != null) {
                    wakeDialogImpl2.W2(strE, listF, true);
                }
                pendingSendObj = null;
                return;
            }
            SharePayload sharePayload = pendingSharePayload;
            if (sharePayload != null) {
                String str2 = String.format("handleWake[reuse]: applySharedPayload uriCount=%d", Arrays.copyOf(new Object[]{Integer.valueOf(sharePayload.b().size())}, 1));
                kotlin.jvm.internal.p.h(str2, "format(...)");
                C4148a.d(TAG, str2, false, 4, null);
                WakeDialogImpl wakeDialogImpl4 = wakeService.activeDialog;
                if (wakeDialogImpl4 != null) {
                    wakeDialogImpl4.b3(sharePayload.getText(), sharePayload.b());
                }
                pendingSharePayload = null;
            }
            String str3 = pendingStartSource;
            if (str3 != null) {
                WakeDialogImpl wakeDialogImpl5 = wakeService.activeDialog;
                if (wakeDialogImpl5 != null) {
                    wakeDialogImpl5.d3(str3);
                }
                pendingStartSource = null;
            }
            String strX = pendingSessionId;
            if (strX != null) {
                WakeDialogImpl wakeDialogImpl6 = wakeService.activeDialog;
                if (wakeDialogImpl6 != null) {
                    wakeDialogImpl6.a3(strX);
                }
                pendingSessionId = null;
            }
            SuggestPayload suggestPayload = pendingSuggestPayload;
            if (suggestPayload != null) {
                WakeDialogImpl wakeDialogImpl7 = wakeService.activeDialog;
                if (wakeDialogImpl7 != null) {
                    wakeDialogImpl7.g3(suggestPayload);
                }
                pendingSuggestPayload = null;
            }
            String str4 = pendingCardText;
            if (str4 != null) {
                pendingCardText = null;
                WakeDialogImpl wakeDialogImpl8 = wakeService.activeDialog;
                if (wakeDialogImpl8 != null) {
                    wakeDialogImpl8.I5(str4);
                }
            }
            if (str3 == null && strX == null) {
                return;
            }
            Companion companion = INSTANCE;
            if (strX == null) {
                strX = companion.X();
            }
            Companion.Z0(companion, wakeService, true, strX, false, 8, null);
            return;
        }
        if (pendingSuggestPayload != null && pendingSendObj == null && pendingSharePayload == null && pendingStartSource == null && pendingSessionId == null && pendingCardText == null) {
            C4148a.d(TAG, "handleWake: suggest-only but no dialog, skip", false, 4, null);
            return;
        }
        if (C3149o.a(com.stepos.ailauncher.container.m0.INSTANCE.h(), com.stepos.ailauncher.chat.lockscreen.C.INSTANCE.i(wakeService), pendingSuggestPayload != null, pendingSessionId != null) && com.stepos.ailauncher.container.o0.INSTANCE.b(pendingStartSource, null)) {
            String str5 = String.format("+%dms handleWake:home-embedded (source=%s)", Arrays.copyOf(new Object[]{Long.valueOf(SystemClock.elapsedRealtime() - j10), pendingStartSource}, 2));
            kotlin.jvm.internal.p.h(str5, "format(...)");
            C4148a.k("WakeShowTiming", str5, false, 4, null);
            pendingStartSource = null;
            return;
        }
        if (T1.INSTANCE.a()) {
            pendingCircleSelectEnabled = pendingSendObj == null && pendingSharePayload == null && pendingSuggestPayload == null && Z8.F.f0(C4814a.INSTANCE.b(), pendingStartSource);
            String str6 = String.format("+%dms handleWake:route-to-chat openWake(%s)", Arrays.copyOf(new Object[]{Long.valueOf(SystemClock.elapsedRealtime() - j10), C2739j.E(wakeService, pendingStartSource, pendingSessionId, null, 8, null)}, 2));
            kotlin.jvm.internal.p.h(str6, "format(...)");
            C4148a.k("WakeShowTiming", str6, false, 4, null);
            INSTANCE.S();
            return;
        }
        C4148a.d(TAG, "handleWake: create and show WakeDialogImpl", false, 4, null);
        boolean z10 = pendingSendObj == null && pendingSharePayload == null && pendingSuggestPayload == null && Z8.F.f0(C4814a.INSTANCE.b(), pendingStartSource);
        LocaleList locales = Resources.getSystem().getConfiguration().getLocales();
        kotlin.jvm.internal.p.h(locales, "getLocales(...)");
        LocaleList locales2 = wakeService.getApplicationContext().getResources().getConfiguration().getLocales();
        kotlin.jvm.internal.p.h(locales2, "getLocales(...)");
        if (kotlin.jvm.internal.p.d(locales, locales2)) {
            contextCreateConfigurationContext = wakeService.getApplicationContext();
        } else {
            Configuration configuration = new Configuration(wakeService.getApplicationContext().getResources().getConfiguration());
            configuration.setLocales(locales);
            contextCreateConfigurationContext = wakeService.getApplicationContext().createConfigurationContext(configuration);
        }
        kotlin.jvm.internal.p.f(contextCreateConfigurationContext);
        WakeDialogImpl wakeDialogImpl9 = new WakeDialogImpl(contextCreateConfigurationContext, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.e2
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeService.q0(this.f26745a);
            }
        }, z10);
        wakeService.activeDialog = wakeDialogImpl9;
        wakeDialogImpl9.L5(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.V1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeService.r0(this.f26668a);
            }
        });
        String str7 = String.format("+%dms handleWake:before dialog.show()", Arrays.copyOf(new Object[]{Long.valueOf(SystemClock.elapsedRealtime() - j10)}, 1));
        kotlin.jvm.internal.p.h(str7, "format(...)");
        C4148a.k("WakeShowTiming", str7, false, 4, null);
        String strX2 = pendingSessionId;
        boolean zE = C3202f.INSTANCE.e();
        wakeDialogImpl9.show();
        String str8 = String.format("+%dms handleWake:dialog.show() returned", Arrays.copyOf(new Object[]{Long.valueOf(SystemClock.elapsedRealtime() - j10)}, 1));
        kotlin.jvm.internal.p.h(str8, "format(...)");
        C4148a.k("WakeShowTiming", str8, false, 4, null);
        Companion companion2 = INSTANCE;
        boolean z11 = strX2 != null;
        if (strX2 == null) {
            strX2 = companion2.X();
        }
        companion2.Y0(wakeService, z11, strX2, zE);
        String str9 = pendingStartSource;
        if (str9 != null) {
            wakeDialogImpl9.d3(str9);
            pendingStartSource = null;
        }
        Pair<String, ? extends List<FileInfo>> pair2 = pendingSendObj;
        if (pair2 != null) {
            String strE2 = pair2.e();
            List<FileInfo> listF2 = pair2.f();
            if ((strE2 != null || listF2 != null) && (wakeDialogImpl = wakeService.activeDialog) != null) {
                if (strE2 == null) {
                    strE2 = "";
                }
                wakeDialogImpl.W2(strE2, listF2, true);
            }
            pendingSendObj = null;
            if (pendingSuggestPayload == null) {
                return;
            }
        }
        SharePayload sharePayload2 = pendingSharePayload;
        if (sharePayload2 != null) {
            String str10 = String.format("handleWake[create]: applySharedPayload uriCount=%d", Arrays.copyOf(new Object[]{Integer.valueOf(sharePayload2.b().size())}, 1));
            kotlin.jvm.internal.p.h(str10, "format(...)");
            C4148a.d(TAG, str10, false, 4, null);
            wakeDialogImpl9.b3(sharePayload2.getText(), sharePayload2.b());
            pendingSharePayload = null;
            if (pendingSuggestPayload == null) {
                return;
            }
        }
        wakeService.b0(z10);
        String str11 = pendingSessionId;
        if (str11 != null) {
            if (pendingSuggestPayload == null) {
                wakeDialogImpl9.a3(str11);
            }
            pendingSessionId = null;
        }
        SuggestPayload suggestPayload2 = pendingSuggestPayload;
        if (suggestPayload2 != null) {
            wakeDialogImpl9.g3(suggestPayload2);
            pendingSuggestPayload = null;
        }
        String str12 = pendingCardText;
        if (str12 != null) {
            pendingCardText = null;
            wakeDialogImpl9.I5(str12);
        }
    }

    public static final void p0(WakeService wakeService) {
        wakeService.l0();
    }

    public static final Y8.t q0(WakeService wakeService) {
        C4148a.d(TAG, "dialog dismissed callback", false, 4, null);
        wakeService.activeDialog = null;
        INSTANCE.P0(false);
        wakeService.c0();
        wakeService.mainHandler.removeCallbacks(wakeService.stopSelfRunnable);
        wakeService.mainHandler.postDelayed(wakeService.stopSelfRunnable, 500L);
        return Y8.t.f7040a;
    }

    public static final Y8.t r0(WakeService wakeService) {
        wakeService.c0();
        return Y8.t.f7040a;
    }

    public static final Y8.t s0() {
        return Y8.t.f7040a;
    }

    public static final void t0(WakeService wakeService) {
        wakeService.stopSelf();
    }

    public final void b0(boolean needCircleSelect) {
        if (needCircleSelect) {
            CircleSelectController.INSTANCE.h();
            WakeDialogImpl wakeDialogImpl = this.activeDialog;
            if (wakeDialogImpl != null) {
                wakeDialogImpl.i6();
            }
            c0();
            Context applicationContext = getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            ScreenshotClient screenshotClient = new ScreenshotClient(applicationContext);
            this.silentScreenshotClient = screenshotClient;
            this.silentCaptureJob = C1060i.d(this.silentCaptureScope, null, null, new WakeService$beginSilentCapture$1(screenshotClient, this, screenshotUploadGate.g(), null), 3, null);
        }
    }

    public final void c0() {
        kotlinx.coroutines.g gVar = this.silentCaptureJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.silentCaptureJob = null;
        ScreenshotClient screenshotClient = this.silentScreenshotClient;
        if (screenshotClient != null) {
            screenshotClient.i();
        }
        this.silentScreenshotClient = null;
    }

    public final void d0(final String text) {
        if (text == null || La.H.x0(text)) {
            return;
        }
        this.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.Z1
            @Override // java.lang.Runnable
            public final void run() {
                WakeService.e0(text, this);
            }
        });
    }

    public final void f0(final boolean noAnim) {
        this.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.W1
            @Override // java.lang.Runnable
            public final void run() {
                WakeService.g0(this.f26680a, noAnim);
            }
        });
    }

    public final void h0() {
        this.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.b2
            @Override // java.lang.Runnable
            public final void run() {
                WakeService.i0(this.f26697a);
            }
        });
    }

    public final void j0() {
        this.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.U1
            @Override // java.lang.Runnable
            public final void run() {
                WakeService.k0(this.f26666a);
            }
        });
    }

    public final void l0() {
        INSTANCE.T0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.Y1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeService.m0(this.f26685a);
            }
        });
    }

    public final void n0() {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        C4148a.k("WakeShowTiming", "+0ms handleWake:begin", false, 4, null);
        if (overlayExternallyHidden) {
            j0();
        }
        if (INSTANCE.J(this, pendingStartSource)) {
            this.mainHandler.removeCallbacks(this.stopSelfRunnable);
            this.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.c2
                @Override // java.lang.Runnable
                public final void run() {
                    WakeService.o0(jElapsedRealtime, this);
                }
            });
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mainHandler.removeCallbacksAndMessages(null);
        c0();
        kotlinx.coroutines.d.e(this.silentCaptureScope, null, 1, null);
        WakeDialogImpl wakeDialogImpl = this.activeDialog;
        if (wakeDialogImpl != null) {
            if (!wakeDialogImpl.isShowing()) {
                wakeDialogImpl = null;
            }
            if (wakeDialogImpl != null) {
                wakeDialogImpl.J3();
            }
        }
        WakeDialogImpl wakeDialogImpl2 = this.activeDialog;
        if (wakeDialogImpl2 != null) {
            wakeDialogImpl2.L5(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.X1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return WakeService.s0();
                }
            });
        }
        this.activeDialog = null;
        INSTANCE.P0(false);
        super.onDestroy();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            switch (action.hashCode()) {
                case -1477173634:
                    if (action.equals(ACTION_HIDE)) {
                        h0();
                        break;
                    }
                    break;
                case -946534521:
                    if (action.equals(ACTION_WAKE)) {
                        l0();
                        break;
                    }
                    break;
                case 60784035:
                    if (action.equals(ACTION_SHOW)) {
                        j0();
                        break;
                    }
                    break;
                case 559428248:
                    if (action.equals(ACTION_AI_KEY_WAKE)) {
                        if (pendingStartSource == null) {
                            pendingStartSource = "ai_key_click";
                        }
                        if (!INSTANCE.O(this, pendingStartSource)) {
                            l0();
                            break;
                        } else {
                            pendingStartSource = null;
                            return 2;
                        }
                    }
                    break;
                case 589904696:
                    if (action.equals(ACTION_CARD_SEND_TEXT)) {
                        d0(intent.getStringExtra(EXTRA_CARD_TEXT));
                        break;
                    }
                    break;
                case 603611452:
                    if (action.equals(ACTION_DISMISS)) {
                        f0(intent.getBooleanExtra(N5.d.EXTRA_DISMISS_NO_ANIM, false));
                        break;
                    }
                    break;
            }
        }
        return 2;
    }
}
