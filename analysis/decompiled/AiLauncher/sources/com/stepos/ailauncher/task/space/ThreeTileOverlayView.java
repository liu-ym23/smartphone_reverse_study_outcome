package com.stepos.ailauncher.task.space;

import A1.g;
import Ua.C1060i;
import Z8.C1173v;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Outline;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Property;
import android.util.TypedValue;
import android.view.C1399q;
import android.view.LayoutInflater;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.a0;
import androidx.dynamicanimation.animation.e;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentframework.adapter.agentbus.bff.PrimaryAgent;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.agentframework.chatui.view.C2069d0;
import com.stepos.agentframework.chatui.view.ChatRecycleView;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.ailauncher.chat.broadcast.RecentsWindowMonitor;
import com.stepos.ailauncher.chat.input.ChatStopActions;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.manager.Q0;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.chat.view.HomeChatPagerView;
import com.stepos.ailauncher.chat.view.HomeInputView;
import com.stepos.ailauncher.chat.view.LauncherChatLayout;
import com.stepos.ailauncher.chat.view.SessionCenterView;
import com.stepos.ailauncher.chat.view.UnifiedChatHostView;
import com.stepos.ailauncher.chat.voice.longpress.RecordingPresentation;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.chat.wake.C3127h;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.chat.wake.effect.SpectrumBorderConfig;
import com.stepos.ailauncher.common.utils.MicOccupancyMonitor;
import com.stepos.ailauncher.container.C3209b;
import com.stepos.ailauncher.container.api.IOverlayPageHost;
import com.stepos.ailauncher.container.api.IOverlayPageView;
import com.stepos.ailauncher.container.api.OverlayPageDestroyReason;
import com.stepos.ailauncher.container.api.OverlayPageResumeReason;
import com.stepos.ailauncher.container.glass.SheetGlassStyle;
import com.stepos.ailauncher.container.l0;
import com.stepos.ailauncher.container.o0;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.contract.api.homegesture.HomeSharedOffsetExitParticipant;
import com.stepos.ailauncher.network.model.RecommendCard;
import com.stepos.ailauncher.sheet.C3436d;
import com.stepos.ailauncher.sheet.C3440h;
import com.stepos.ailauncher.sheet.R$color;
import com.stepos.ailauncher.sheet.R$dimen;
import com.stepos.ailauncher.sheet.R$id;
import com.stepos.ailauncher.sheet.R$layout;
import com.stepos.ailauncher.sheet.SheetHeightMode;
import com.stepos.ailauncher.sheet.SheetScaleMotion;
import com.stepos.ailauncher.sheet.SheetSettleState;
import com.stepos.ailauncher.sheet.SheetSpring;
import com.stepos.ailauncher.sheet.widget.DraggableSheetLayout;
import com.stepos.ailauncher.task.R$drawable;
import com.stepos.ailauncher.task.R$string;
import com.stepos.ailauncher.task.space.HomeInputPresentationState;
import com.stepos.ailauncher.task.space.MinusOneIncomingVoiceHold;
import com.stepos.ailauncher.task.space.ThreeTileOverlayView;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k5.C4814a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import kotlin.jvm.internal.Ref$BooleanRef;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import t1.C5503a;
import v5.C5659a;
import v9.C5685n;

@Metadata(d1 = {"\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b[\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0004½\u0002\u00ad\u0003\u0018\u0000 ¶\u00032\u00020\u00012\u00020\u00022\u00020\u0003:\u0006·\u0003¸\u0003¹\u0003B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001e\u0010\u0016J\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010\u0016J\u000f\u0010#\u001a\u00020\u000eH\u0016¢\u0006\u0004\b#\u0010\u0016J\u0017\u0010%\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u001bH\u0016¢\u0006\u0004\b%\u0010!J\u0017\u0010(\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u001bH\u0002¢\u0006\u0004\b*\u0010\u001dJ\u0017\u0010-\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u000eH\u0002¢\u0006\u0004\b/\u0010\u0016J\u000f\u00100\u001a\u00020\u000eH\u0002¢\u0006\u0004\b0\u0010\u0016J\u000f\u00101\u001a\u00020\u000eH\u0002¢\u0006\u0004\b1\u0010\u0016J\u000f\u00102\u001a\u00020\u000eH\u0002¢\u0006\u0004\b2\u0010\u0016J\u000f\u00103\u001a\u00020\u000eH\u0002¢\u0006\u0004\b3\u0010\u0016J\u000f\u00104\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u0010\u0016J\u000f\u00105\u001a\u00020\u000eH\u0002¢\u0006\u0004\b5\u0010\u0016J\u0017\u00108\u001a\u00020\u000e2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u001bH\u0002¢\u0006\u0004\b;\u0010!J\u000f\u0010<\u001a\u00020\u000eH\u0002¢\u0006\u0004\b<\u0010\u0016J\u000f\u0010=\u001a\u00020\u000eH\u0002¢\u0006\u0004\b=\u0010\u0016J\u0019\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020>H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u000eH\u0002¢\u0006\u0004\bA\u0010\u0016J\u000f\u0010B\u001a\u00020\u001bH\u0002¢\u0006\u0004\bB\u0010\u001dJ\u0017\u0010D\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u001bH\u0002¢\u0006\u0004\bD\u0010!J\u000f\u0010E\u001a\u00020\u000eH\u0002¢\u0006\u0004\bE\u0010\u0016J\u000f\u0010F\u001a\u00020\u000eH\u0002¢\u0006\u0004\bF\u0010\u0016J\u0017\u0010I\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bI\u0010JJ\u0017\u0010L\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020\u001bH\u0002¢\u0006\u0004\bL\u0010!J\u0013\u0010N\u001a\u00020>*\u00020MH\u0002¢\u0006\u0004\bN\u0010OJ\u0011\u0010P\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0004\bP\u0010QJ\u001f\u0010T\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020>2\u0006\u0010S\u001a\u00020>H\u0002¢\u0006\u0004\bT\u0010UJ+\u0010W\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020>2\b\b\u0002\u0010S\u001a\u00020>2\b\b\u0002\u0010V\u001a\u00020>H\u0002¢\u0006\u0004\bW\u0010XJ\u0017\u0010Y\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020>H\u0002¢\u0006\u0004\bY\u0010@J\u0019\u0010Z\u001a\u00020\u000e2\b\u0010S\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0004\bZ\u0010@J#\u0010]\u001a\u00020\u001b2\b\u0010[\u001a\u0004\u0018\u00010>2\b\u0010\\\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020\u000eH\u0002¢\u0006\u0004\b_\u0010\u0016J\u000f\u0010`\u001a\u00020\u000eH\u0002¢\u0006\u0004\b`\u0010\u0016J=\u0010h\u001a\u00020\u000e2\u0006\u0010b\u001a\u00020a2\b\b\u0002\u0010c\u001a\u00020\u001b2\b\b\u0002\u0010e\u001a\u00020d2\u0010\b\u0002\u0010g\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010fH\u0002¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u00020\u000eH\u0002¢\u0006\u0004\bj\u0010\u0016J'\u0010k\u001a\u00020\u000e2\u0006\u0010b\u001a\u00020a2\u000e\u0010g\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010fH\u0002¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020\u001bH\u0002¢\u0006\u0004\bm\u0010\u001dJ!\u0010o\u001a\u00020\u001b2\b\u0010\\\u001a\u0004\u0018\u00010>2\u0006\u0010n\u001a\u00020\u001bH\u0002¢\u0006\u0004\bo\u0010pJ+\u0010t\u001a\u00020\u001b2\b\u0010q\u001a\u0004\u0018\u00010>2\u0006\u0010r\u001a\u00020>2\b\u0010s\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0004\bt\u0010uJ\u0017\u0010w\u001a\u00020\u001b2\u0006\u0010v\u001a\u00020>H\u0002¢\u0006\u0004\bw\u0010xJ\u000f\u0010y\u001a\u00020\u001bH\u0002¢\u0006\u0004\by\u0010\u001dJ\u000f\u0010z\u001a\u00020\u000eH\u0002¢\u0006\u0004\bz\u0010\u0016J\u0017\u0010{\u001a\u00020\u000e2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b{\u00109J\u000f\u0010|\u001a\u00020dH\u0002¢\u0006\u0004\b|\u0010}J\u0018\u0010\u007f\u001a\u00020d2\u0006\u0010~\u001a\u00020\u001bH\u0002¢\u0006\u0005\b\u007f\u0010\u0080\u0001J1\u0010\u0084\u0001\u001a\u00020\u000e2\u0007\u0010\u0081\u0001\u001a\u00020\u001b2\u0007\u0010\u0082\u0001\u001a\u00020\u001b2\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0011\u0010\u0086\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0086\u0001\u0010\u0016J\u0011\u0010\u0087\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0087\u0001\u0010\u0016J\u0019\u0010\u0089\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0088\u0001H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u0011\u0010\u008b\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u008b\u0001\u0010\u0016J\u001e\u0010\u008d\u0001\u001a\u00020\u000e2\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0005\b\u008d\u0001\u0010@J\u0019\u0010\u008e\u0001\u001a\u00020\u000e2\u0006\u0010~\u001a\u00020\u001bH\u0002¢\u0006\u0005\b\u008e\u0001\u0010!J\u001b\u0010\u0090\u0001\u001a\u00020\u000e2\u0007\u0010\u008f\u0001\u001a\u00020dH\u0002¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u0011\u0010\u0092\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0092\u0001\u0010\u0016J\u001c\u0010\u0095\u0001\u001a\u00020\u000e2\b\u0010\u0094\u0001\u001a\u00030\u0093\u0001H\u0002¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u0011\u0010\u0097\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0097\u0001\u0010\u0016J\u0011\u0010\u0098\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0098\u0001\u0010\u0016J\u0011\u0010\u0099\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0099\u0001\u0010\u0016J\u001c\u0010\u009b\u0001\u001a\u00020\u000e2\t\b\u0002\u0010\u009a\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0005\b\u009b\u0001\u0010!J\u0013\u0010\u009d\u0001\u001a\u00030\u009c\u0001H\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u0011\u0010\u009f\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u009f\u0001\u0010\u0016J\u0011\u0010 \u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b \u0001\u0010\u0016J\u0011\u0010¡\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b¡\u0001\u0010\u0016J\u0012\u0010¢\u0001\u001a\u00020\bH\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u0011\u0010¤\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b¤\u0001\u0010\u0016J\u0019\u0010¥\u0001\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0005\b¥\u0001\u0010)J$\u0010¨\u0001\u001a\u00020\u001b2\u0007\u0010¦\u0001\u001a\u00020a2\u0007\u0010§\u0001\u001a\u00020aH\u0002¢\u0006\u0006\b¨\u0001\u0010©\u0001J.\u0010«\u0001\u001a\u00020\u001b2\u0007\u0010¦\u0001\u001a\u00020a2\u0007\u0010§\u0001\u001a\u00020a2\b\u0010ª\u0001\u001a\u00030\u0093\u0001H\u0002¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u0019\u0010\u00ad\u0001\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020>H\u0002¢\u0006\u0005\b\u00ad\u0001\u0010@J\u0011\u0010®\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b®\u0001\u0010\u0016J\u001b\u0010°\u0001\u001a\u00020\u000e2\u0007\u0010¯\u0001\u001a\u00020\bH\u0002¢\u0006\u0006\b°\u0001\u0010±\u0001J%\u0010³\u0001\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020>2\t\b\u0002\u0010²\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0006\b³\u0001\u0010´\u0001J\u0011\u0010µ\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bµ\u0001\u0010\u0016J\u0011\u0010¶\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b¶\u0001\u0010\u0016J\u0019\u0010·\u0001\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020>H\u0002¢\u0006\u0005\b·\u0001\u0010@J\u001b\u0010¸\u0001\u001a\u00020\u000e2\u0007\u0010¯\u0001\u001a\u00020\bH\u0002¢\u0006\u0006\b¸\u0001\u0010±\u0001J\u001a\u0010º\u0001\u001a\u00020\u000e2\u0007\u0010¹\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0005\bº\u0001\u0010!J\u001b\u0010»\u0001\u001a\u00020\u000e2\u0007\u0010¯\u0001\u001a\u00020\bH\u0002¢\u0006\u0006\b»\u0001\u0010±\u0001J\u001b\u0010½\u0001\u001a\u00020\u000e2\u0007\u0010¼\u0001\u001a\u00020aH\u0002¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u0011\u0010¿\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b¿\u0001\u0010\u0016J\u0011\u0010À\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bÀ\u0001\u0010\u0016J\u001d\u0010Â\u0001\u001a\u00020\u000e2\t\b\u0002\u0010Á\u0001\u001a\u00020\bH\u0002¢\u0006\u0006\bÂ\u0001\u0010±\u0001J\u001a\u0010Ä\u0001\u001a\u00020\u000e2\u0007\u0010Ã\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0005\bÄ\u0001\u0010!J\u0011\u0010Å\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bÅ\u0001\u0010\u0016J\u0011\u0010Æ\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bÆ\u0001\u0010\u0016J\u0011\u0010Ç\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bÇ\u0001\u0010\u0016J\u001c\u0010È\u0001\u001a\u00020\u000e2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0005\bÈ\u0001\u0010!J#\u0010É\u0001\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001b2\u0007\u0010\u0082\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J\u0011\u0010Ë\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bË\u0001\u0010\u0016J\u0011\u0010Ì\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bÌ\u0001\u0010\u0016J\u0011\u0010Í\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bÍ\u0001\u0010\u0016J\u0012\u0010Î\u0001\u001a\u00020\bH\u0002¢\u0006\u0006\bÎ\u0001\u0010£\u0001J\u0012\u0010Ï\u0001\u001a\u00020\bH\u0002¢\u0006\u0006\bÏ\u0001\u0010£\u0001J\u001b\u0010Ñ\u0001\u001a\u00020\b2\u0007\u0010Ð\u0001\u001a\u00020aH\u0002¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001J\u001b\u0010Ó\u0001\u001a\u00020\b2\u0007\u0010Ð\u0001\u001a\u00020aH\u0002¢\u0006\u0006\bÓ\u0001\u0010Ò\u0001J\u001b\u0010Ô\u0001\u001a\u00020\b2\u0007\u0010Ð\u0001\u001a\u00020aH\u0002¢\u0006\u0006\bÔ\u0001\u0010Ò\u0001J\u0011\u0010Õ\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bÕ\u0001\u0010\u0016J\u0011\u0010Ö\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bÖ\u0001\u0010\u0016J\u0011\u0010×\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0005\b×\u0001\u0010\u001dJ\u0011\u0010Ø\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bØ\u0001\u0010\u0016J\u0011\u0010Ù\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0005\bÙ\u0001\u0010\u001dJ\u0011\u0010Ú\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bÚ\u0001\u0010\u0016J\u0011\u0010Û\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bÛ\u0001\u0010\u0016J\u0011\u0010Ü\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bÜ\u0001\u0010\u0016J\u0011\u0010Ý\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bÝ\u0001\u0010\u0016J\u001c\u0010ß\u0001\u001a\u00020\u000e2\b\u0010Þ\u0001\u001a\u00030\u0093\u0001H\u0002¢\u0006\u0006\bß\u0001\u0010\u0096\u0001J\u001c\u0010á\u0001\u001a\u00020a2\b\u0010à\u0001\u001a\u00030\u0093\u0001H\u0002¢\u0006\u0006\bá\u0001\u0010â\u0001J\u001c\u0010ã\u0001\u001a\u00020\u001b2\b\u0010Þ\u0001\u001a\u00030\u0093\u0001H\u0002¢\u0006\u0006\bã\u0001\u0010ä\u0001J'\u0010å\u0001\u001a\u00020\u000e2\b\u0010Þ\u0001\u001a\u00030\u0093\u00012\t\b\u0002\u0010Ã\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0006\bå\u0001\u0010æ\u0001J\u001c\u0010ç\u0001\u001a\u00020\u001b2\b\u0010Þ\u0001\u001a\u00030\u0093\u0001H\u0002¢\u0006\u0006\bç\u0001\u0010ä\u0001J\u0011\u0010è\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bè\u0001\u0010\u0016J\u0011\u0010é\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bé\u0001\u0010\u0016J\u0011\u0010ê\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bê\u0001\u0010\u0016J\u0011\u0010ë\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bë\u0001\u0010\u0016J\u0011\u0010ì\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bì\u0001\u0010\u0016JF\u0010ð\u0001\u001a\u00020\u000e2\b\u0010à\u0001\u001a\u00030\u0093\u00012\u0007\u0010í\u0001\u001a\u00020a2\t\b\u0002\u0010Ã\u0001\u001a\u00020\u001b2\t\b\u0002\u0010î\u0001\u001a\u00020\u001b2\t\b\u0002\u0010ï\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0006\bð\u0001\u0010ñ\u0001J\u0011\u0010ò\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\bò\u0001\u0010\u0016J\u0011\u0010ó\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0005\bó\u0001\u0010\u001dJ\u0011\u0010ô\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0005\bô\u0001\u0010\u001dJ\u001b\u0010ö\u0001\u001a\u00020\u000e2\u0007\u0010õ\u0001\u001a\u00020aH\u0002¢\u0006\u0006\bö\u0001\u0010¾\u0001J\u0011\u0010÷\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0005\b÷\u0001\u0010\u001dJ\u0013\u0010ù\u0001\u001a\u00030ø\u0001H\u0002¢\u0006\u0006\bù\u0001\u0010ú\u0001J\u0011\u0010û\u0001\u001a\u00020\u001bH\u0002¢\u0006\u0005\bû\u0001\u0010\u001dJ\u001c\u0010ý\u0001\u001a\u00020\u001b2\b\u0010ü\u0001\u001a\u00030ø\u0001H\u0002¢\u0006\u0006\bý\u0001\u0010þ\u0001J\u001c\u0010ÿ\u0001\u001a\u00020\u001b2\b\u0010ü\u0001\u001a\u00030ø\u0001H\u0002¢\u0006\u0006\bÿ\u0001\u0010þ\u0001J\u0011\u0010\u0080\u0002\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0080\u0002\u0010\u0016J\u0011\u0010\u0081\u0002\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0081\u0002\u0010\u0016J\u0011\u0010\u0082\u0002\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0082\u0002\u0010\u0016J\u0011\u0010\u0083\u0002\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0083\u0002\u0010\u0016J\u0011\u0010\u0084\u0002\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0084\u0002\u0010\u0016J#\u0010\u0087\u0002\u001a\u00020\u000e2\u000f\u0010\u0086\u0002\u001a\n\u0012\u0005\u0012\u00030\u0085\u00020\u0088\u0001H\u0002¢\u0006\u0006\b\u0087\u0002\u0010\u0088\u0002J\u0011\u0010\u0089\u0002\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0089\u0002\u0010\u0016J\u001c\u0010\u008a\u0002\u001a\u00020\u000e2\b\u0010à\u0001\u001a\u00030\u0093\u0001H\u0002¢\u0006\u0006\b\u008a\u0002\u0010\u0096\u0001J-\u0010\u008e\u0002\u001a\u00020\u000e2\u0007\u0010\u008b\u0002\u001a\u00020\b2\u0007\u0010\u008c\u0002\u001a\u00020\b2\u0007\u0010\u008d\u0002\u001a\u00020>H\u0002¢\u0006\u0006\b\u008e\u0002\u0010\u008f\u0002J\u0011\u0010\u0090\u0002\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0090\u0002\u0010\u0016J\u0011\u0010\u0091\u0002\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0091\u0002\u0010\u0016J\u0011\u0010\u0092\u0002\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0092\u0002\u0010\u0016J\u001a\u0010\u0093\u0002\u001a\u00020\u000e2\u0007\u0010\u008d\u0002\u001a\u00020>H\u0002¢\u0006\u0005\b\u0093\u0002\u0010@J\u001a\u0010\u0095\u0002\u001a\u00020\u000e2\u0007\u0010\u0094\u0002\u001a\u00020>H\u0002¢\u0006\u0005\b\u0095\u0002\u0010@J\u0019\u0010\u0096\u0002\u001a\u00020\u000e2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0005\b\u0096\u0002\u00109J\u0019\u0010\u0097\u0002\u001a\u00020\u000e2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0005\b\u0097\u0002\u00109J\u0011\u0010\u0098\u0002\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0098\u0002\u0010\u0016J\u0011\u0010\u0099\u0002\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0099\u0002\u0010\u0016J\u0011\u0010\u009a\u0002\u001a\u00020\u001bH\u0002¢\u0006\u0005\b\u009a\u0002\u0010\u001dJ\u0011\u0010\u009b\u0002\u001a\u00020\u001bH\u0002¢\u0006\u0005\b\u009b\u0002\u0010\u001dR\u0018\u0010\u009d\u0002\u001a\u00030\u009c\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009d\u0002\u0010\u009e\u0002R\u0018\u0010 \u0002\u001a\u00030\u009f\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0002\u0010¡\u0002R\u001b\u0010¢\u0002\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0002\u0010£\u0002R&\u0010¦\u0002\u001a\u0011\u0012\u0005\u0012\u00030\u0093\u0001\u0012\u0005\u0012\u00030¥\u00020¤\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0002\u0010§\u0002R\u001b\u0010¨\u0002\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0002\u0010©\u0002R\u001c\u0010«\u0002\u001a\u0005\u0018\u00010ª\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0002\u0010¬\u0002R!\u0010\u00ad\u0002\u001a\n\u0012\u0005\u0012\u00030\u0085\u00020\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0002\u0010®\u0002R\u0019\u0010¯\u0002\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0002\u0010°\u0002R\u0019\u0010±\u0002\u001a\u00020d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0002\u0010²\u0002R\u0019\u0010³\u0002\u001a\u00020d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0002\u0010²\u0002R\u0019\u0010´\u0002\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0002\u0010°\u0002R\u0019\u0010µ\u0002\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0002\u0010°\u0002R\u001c\u0010·\u0002\u001a\u0005\u0018\u00010¶\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0002\u0010¸\u0002R\u001b\u0010¹\u0002\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0002\u0010º\u0002R\u001b\u0010»\u0002\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0002\u0010¼\u0002R\u0018\u0010¾\u0002\u001a\u00030½\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0002\u0010¿\u0002R\u001c\u0010Á\u0002\u001a\u0005\u0018\u00010À\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0002\u0010Â\u0002R\u001b\u0010Ã\u0002\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0002\u0010Ä\u0002R\u001c\u0010Å\u0002\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0002\u0010Æ\u0002R!\u0010Ç\u0002\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0002\u0010È\u0002R\u001c\u0010É\u0002\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0002\u0010Æ\u0002R\u001c\u0010Ê\u0002\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0002\u0010Æ\u0002R\u001c\u0010Ì\u0002\u001a\u0005\u0018\u00010Ë\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0002\u0010Í\u0002R\u001b\u0010Î\u0002\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0002\u0010Ï\u0002R\u0019\u0010Ð\u0002\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0002\u0010°\u0002R\u001c\u0010Ñ\u0002\u001a\u0005\u0018\u00010¥\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0002\u0010Ò\u0002R\u001c\u0010Ó\u0002\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0002\u0010Ô\u0002R\u0019\u0010Õ\u0002\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0002\u0010Ö\u0002R\u0019\u0010×\u0002\u001a\u00020a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0002\u0010Ø\u0002R\u0018\u0010Ú\u0002\u001a\u00030Ù\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÚ\u0002\u0010Û\u0002R\u001c\u0010Ý\u0002\u001a\u0005\u0018\u00010Ü\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0002\u0010Þ\u0002R\u0019\u0010ß\u0002\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0002\u0010à\u0002R\u001b\u0010á\u0002\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0002\u0010à\u0002R\u001b\u0010â\u0002\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0002\u0010à\u0002R\u0019\u0010ã\u0002\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0002\u0010°\u0002R\u001c\u0010å\u0002\u001a\u0005\u0018\u00010ä\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0002\u0010æ\u0002R\u001c\u0010è\u0002\u001a\u0005\u0018\u00010ç\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0002\u0010é\u0002R\u001c\u0010ê\u0002\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0002\u0010Æ\u0002R\u0019\u0010ë\u0002\u001a\u00020d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0002\u0010²\u0002R\u0019\u0010ì\u0002\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0002\u0010°\u0002R \u0010í\u0002\u001a\t\u0012\u0004\u0012\u00020>0\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0002\u0010®\u0002R)\u0010ï\u0002\u001a\u00020\u001b2\u0007\u0010î\u0002\u001a\u00020\u001b8\u0002@BX\u0082\u000e¢\u0006\u000f\n\u0006\bï\u0002\u0010°\u0002\"\u0005\bð\u0002\u0010!R\u0019\u0010ñ\u0002\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bñ\u0002\u0010°\u0002R\u0018\u0010ó\u0002\u001a\u00030ò\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bó\u0002\u0010ô\u0002R\u001c\u0010ö\u0002\u001a\u0005\u0018\u00010õ\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0002\u0010÷\u0002R\u0018\u0010ù\u0002\u001a\u00030ø\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bù\u0002\u0010ú\u0002R\u0019\u0010û\u0002\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0002\u0010°\u0002R\u0018\u0010ý\u0002\u001a\u00030ü\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bý\u0002\u0010þ\u0002R\u0019\u0010ÿ\u0002\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÿ\u0002\u0010°\u0002R\u001c\u0010\u0080\u0003\u001a\u0005\u0018\u00010õ\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0003\u0010÷\u0002R\u0019\u0010\u0081\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0003\u0010°\u0002R\u001c\u0010\u0083\u0003\u001a\u0005\u0018\u00010\u0082\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0003\u0010\u0084\u0003R\u0019\u0010\u0085\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0003\u0010°\u0002R\u0019\u0010\u0086\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0003\u0010°\u0002R\u0019\u0010\u0087\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0003\u0010°\u0002R\u0019\u0010\u0088\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0003\u0010°\u0002R\u0019\u0010\u0089\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0003\u0010°\u0002R\u001c\u0010\u008a\u0003\u001a\u0005\u0018\u00010\u0082\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0003\u0010\u0084\u0003R\u001b\u0010\u008b\u0003\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0003\u0010©\u0002R\u0019\u0010\u008c\u0003\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0003\u0010Ö\u0002R\u0019\u0010\u008d\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0003\u0010°\u0002R\u0019\u0010\u008e\u0003\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0003\u0010Ö\u0002R\u0019\u0010\u008f\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0003\u0010°\u0002R\u0019\u0010\u0090\u0003\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0003\u0010Ö\u0002R\u001c\u0010\u0091\u0003\u001a\u0005\u0018\u00010ø\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0003\u0010\u0092\u0003R\u0019\u0010\u0093\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0003\u0010°\u0002R\u0019\u0010\u0094\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0003\u0010°\u0002R\u0019\u0010\u0095\u0003\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0003\u0010Ö\u0002R$\u0010\u0097\u0003\u001a\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u0096\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0003\u0010\u0098\u0003R\u0019\u0010\u0099\u0003\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0003\u0010Ö\u0002R\u0019\u0010\u009a\u0003\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0003\u0010Ö\u0002R\u0019\u0010\u009b\u0003\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0003\u0010Ö\u0002R\u0019\u0010\u009c\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0003\u0010°\u0002R\u0019\u0010\u009d\u0003\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0003\u0010Ö\u0002R\u001c\u0010\u009f\u0003\u001a\u0005\u0018\u00010\u009e\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0003\u0010 \u0003R\u0019\u0010¡\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0003\u0010°\u0002R\u0019\u0010¢\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0003\u0010°\u0002R\u0019\u0010£\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0003\u0010°\u0002R\u0019\u0010¤\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0003\u0010°\u0002R\u0019\u0010¥\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0003\u0010°\u0002R\u0019\u0010¦\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0003\u0010°\u0002R\u001c\u0010§\u0003\u001a\u0005\u0018\u00010Ë\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0003\u0010Í\u0002R\u001c\u0010¨\u0003\u001a\u0005\u0018\u00010õ\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0003\u0010÷\u0002R\u0019\u0010©\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0003\u0010°\u0002R\u001b\u0010ª\u0003\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0003\u0010©\u0002R$\u0010«\u0003\u001a\u000f\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e0\u0096\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0003\u0010\u0098\u0003R\u0019\u0010¬\u0003\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0003\u0010Ö\u0002R\u0018\u0010®\u0003\u001a\u00030\u00ad\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0003\u0010¯\u0003R\u0019\u0010°\u0003\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0003\u0010°\u0002R\u0018\u0010´\u0003\u001a\u00030±\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b²\u0003\u0010³\u0003R\u001c\u0010Ã\u0001\u001a\u00020\u001b*\u00030ø\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bµ\u0003\u0010þ\u0001¨\u0006º\u0003"}, d2 = {"Lcom/stepos/ailauncher/task/space/ThreeTileOverlayView;", "Landroid/widget/FrameLayout;", "Lcom/stepos/ailauncher/container/api/IOverlayPageView;", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/stepos/ailauncher/container/api/IOverlayPageHost;", "host", "LY8/t;", "onPageCreate", "(Lcom/stepos/ailauncher/container/api/IOverlayPageHost;)V", "Lcom/stepos/ailauncher/container/api/OverlayPageResumeReason;", "reason", "onPageResume", "(Lcom/stepos/ailauncher/container/api/OverlayPageResumeReason;)V", "onPagePause", "()V", "onPageStop", "Lcom/stepos/ailauncher/container/api/OverlayPageDestroyReason;", "onPageDestroy", "(Lcom/stepos/ailauncher/container/api/OverlayPageDestroyReason;)V", "", "onBackPressed", "()Z", "onNavigateHome", "visible", "onAllTasksEntryVisibilityChanged", "(Z)V", "onEnterSystemRecents", "hideImeForHomeConsume", "hasWindowFocus", "onWindowFocusChanged", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "L3", "Lcom/stepos/ailauncher/task/space/ThreeTileOverlayView$b;", "motion", "G4", "(Lcom/stepos/ailauncher/task/space/ThreeTileOverlayView$b;)V", "K4", "J4", "L4", "M1", "x1", "y1", "h4", "Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;", ChatTracker.CONTENT_SHEET, "B4", "(Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;)V", "covered", "j4", "A5", "w4", "", "L2", "(Ljava/lang/String;)V", "A3", "I3", "finalizing", "X1", "i5", "m5", "Lcom/stepos/ailauncher/chat/view/HomeChatPagerView;", "pager", "j2", "(Lcom/stepos/ailauncher/chat/view/HomeChatPagerView;)V", "show", SdCardDbCreator.FIELD_LASTLOC_INFO, "Lcom/stepos/ailauncher/sheet/SheetSettleState;", "B5", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)Ljava/lang/String;", "d3", "()Ljava/lang/String;", "toStage", "triggerSource", "N4", "(Ljava/lang/String;Ljava/lang/String;)V", "openTriggerSource", "O4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "S3", "R3", "source", "sessionId", "t3", "(Ljava/lang/String;Ljava/lang/String;)Z", "Z4", "W4", "", "to", "holdSlide", "", "startDelayMs", "Lkotlin/Function0;", "onEnd", "B1", "(FZJLp9/a;)V", "P2", "t5", "(FLp9/a;)V", "K2", "restoreLast", "s3", "(Ljava/lang/String;Z)Z", "agentId", "deviceId", "agentDisplayName", "q3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", HighlightArgsBundle.KEY_PROMPT, "r3", "(Ljava/lang/String;)Z", "x5", "Y4", "z4", "n3", "()J", "nineSplit", "m4", "(Z)J", "reset", "animate", "groupMotion", "U2", "(ZZLcom/stepos/ailauncher/task/space/ThreeTileOverlayView$b;)V", "L1", "S2", "", "C5", "()Ljava/util/List;", "W3", Parameters.SESSION_ID, "y5", "a5", "durationMs", "q5", "(J)V", "M2", "Landroid/view/View;", "panel", "T2", "(Landroid/view/View;)V", "V4", "w3", "m3", "force", "Y1", "Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;", "o5", "()Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;", "I4", "D4", "D5", "P3", "()I", "d2", "p5", "rawX", "rawY", "N3", "(FF)Z", "target", "O3", "(FFLandroid/view/View;)Z", "z1", "b5", "kb", "R1", "(I)V", "imeConfirmedGone", "T4", "(Ljava/lang/String;Z)V", "X3", "Y3", "f3", "O1", com.stepos.ailauncher.chat.trace.f.ACTION_PIN, "o4", "S1", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "T1", "(F)V", "r5", "N2", "color", "U1", "crossWindow", "C4", "F4", "S4", "c2", "H1", "w1", "(ZZ)V", "F1", "G1", "E1", "v1", "u1", "dp", "Q3", "(F)I", "n4", "w5", "l4", "Z3", "u3", "P1", "M3", "H4", "l3", "Q1", "l5", "chip", "h2", "view", "Q2", "(Landroid/view/View;)F", "R2", "(Landroid/view/View;)Z", "f2", "(Landroid/view/View;Z)V", "K3", "h5", "i3", "g3", "v3", "E4", "cornerRadiusDp", "clearXmlFallback", "innerShadow", "j3", "(Landroid/view/View;FZZZ)V", "K1", "J3", "H3", "progress", "T3", "E3", "Lcom/stepos/ailauncher/task/space/ThreeTileOverlayView$InputBarGlassPhase;", "R4", "()Lcom/stepos/ailauncher/task/space/ThreeTileOverlayView$InputBarGlassPhase;", "e3", "phase", "F3", "(Lcom/stepos/ailauncher/task/space/ThreeTileOverlayView$InputBarGlassPhase;)Z", "G3", "x4", "W1", "h3", "J1", "o3", "Lcom/stepos/ailauncher/network/model/RecommendCard;", "cards", "J2", "(Ljava/util/List;)V", "H5", "p4", "index", "fallbackRes", "pageFrom", "k4", "(IILjava/lang/String;)V", "Q4", "V3", "U3", "M4", "text", "g5", AMapLocationStaticsEntity.IPV4, "r4", "e5", "O2", "z3", "E5", "Lr6/s;", "binding", "Lr6/s;", "Landroidx/lifecycle/q;", "lifecycleRegistry", "Landroidx/lifecycle/q;", "overlayHost", "Lcom/stepos/ailauncher/container/api/IOverlayPageHost;", "", "Ly7/E;", "glassedViews", "Ljava/util/Map;", "greetingGlassKeyboardUp", "Ljava/lang/Boolean;", "LUa/M;", "pageScope", "LUa/M;", "suggestCards", "Ljava/util/List;", "agentViewReported", "Z", "agentEnterElapsedMs", "J", "traditionalEnterElapsedMs", "suggestExposeReported", "chatRecommendExposeReported", "Lcom/stepos/ailauncher/task/space/E;", "sheetHostRoot", "Lcom/stepos/ailauncher/task/space/E;", "sheetLayout", "Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;", "embeddedGroupExit", "Lcom/stepos/ailauncher/task/space/ThreeTileOverlayView$b;", "com/stepos/ailauncher/task/space/ThreeTileOverlayView$l", "homeGroupExitParticipant", "Lcom/stepos/ailauncher/task/space/ThreeTileOverlayView$l;", "Landroid/view/ViewGroup;", "sheetPanel", "Landroid/view/ViewGroup;", "contentContainer", "Landroid/widget/FrameLayout;", "dimView", "Landroid/view/View;", "releaseCoveredPanelScrim", "Lp9/a;", "coveredPanelScrimView", "dragHandle", "Landroidx/dynamicanimation/animation/i;", "dragHandleAlphaAnim", "Landroidx/dynamicanimation/animation/i;", "pagerView", "Lcom/stepos/ailauncher/chat/view/HomeChatPagerView;", "artifactsActive", "panelGlassHandle", "Ly7/E;", "panelGlassStyle", "Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;", "panelGlassTint", "I", "panelGlassBlurPx", "F", "Lcom/stepos/ailauncher/container/glass/j;", "panelGlassCommit", "Lcom/stepos/ailauncher/container/glass/j;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sessionHandler", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "analyticsStage", "Ljava/lang/String;", "analyticsResizeTrigger", "analyticsOpenTriggerSource", "chatviewOpenReported", "Lcom/stepos/ailauncher/task/space/C;", "chatInputComponent", "Lcom/stepos/ailauncher/task/space/C;", "Lcom/stepos/ailauncher/chat/wake/effect/c;", "recordingSpectrum", "Lcom/stepos/ailauncher/chat/wake/effect/c;", "recordingScrimView", "panelTransitionSeq", "pendingFreshSessionAfterCollapse", "pendingFreshSessionKeys", UxipConstants.f30680s, "panelShown", "setPanelShown", "pageResumed", "Lcom/stepos/ailauncher/task/space/MinusOneIncomingVoiceHold;", "incomingVoiceHold", "Lcom/stepos/ailauncher/task/space/MinusOneIncomingVoiceHold;", "Ljava/lang/Runnable;", "incomingVoiceWait", "Ljava/lang/Runnable;", "Lcom/stepos/ailauncher/task/space/HomeInputPresentationState;", "inputPresentationState", "Lcom/stepos/ailauncher/task/space/HomeInputPresentationState;", "freshSessionMintedForHome", "Lcom/stepos/ailauncher/chat/manager/Q0$a;", "onSessionExternallyMarked", "Lcom/stepos/ailauncher/chat/manager/Q0$a;", "sysUiClosePending", "sysUiCloseRunnable", "collapsingAfterSysUiAlign", "Landroid/animation/Animator;", "exitColorAnim", "Landroid/animation/Animator;", "collapseExposeWallpaperForInputBar", "sheetReady", "imeVisible", "swallowingImeDismiss", "allTasksEntryVisible", "allTasksEntryAnimator", "allTasksTargetVisible", "keyboardHeightPx", "holdHalfOverExistingIme", "chipsToInputGapPx", "desktopGreetingPinned", "imePeakHeightPx", "committedInputBarGlassPhase", "Lcom/stepos/ailauncher/task/space/ThreeTileOverlayView$InputBarGlassPhase;", "imeRising", "imeGlowHiding", "imeGlowAppliedRes", "Lkotlin/Function1;", "imeGlowThemeListener", "Lp9/l;", "imeHeightFromInsets", "navBottomPx", "statusBarTopPx", "imePinnedByDialog", "imeHideResetGeneration", "Landroid/animation/ValueAnimator;", "homeConsumeImeGeomAnim", "Landroid/animation/ValueAnimator;", "suppressGreetChipsLiftUntilKbZero", "chatRecording", "allTasksLongPressFadeActive", "inputHasContent", "chatConversationEmpty", "isExternalSession", "inputBarAlphaAnim", "inputBarAlphaDelayRunnable", "inputBarSlideHeld", "lastWakeDialogShowing", "wakeDialogVisibilityListener", "restoreSeq", "com/stepos/ailauncher/task/space/ThreeTileOverlayView$p", "screenOffReceiver", "Lcom/stepos/ailauncher/task/space/ThreeTileOverlayView$p;", "screenOffReceiverRegistered", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "p3", "Companion", Const.INTENT_KEY_PKGNAME, "InputBarGlassPhase", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ThreeTileOverlayView extends FrameLayout implements IOverlayPageView, LifecycleOwner {
    private static final String ACTION_OPEN_ALL_TASK_NOTIFY = "com.stepos.ailauncher.action.OPEN_ALL_TASK_NOTIFY";
    private static final float ALL_TASKS_CHEVRON_HEIGHT_DP = 14.0f;
    private static final float ALL_TASKS_CHEVRON_MARGIN_START_DP = 4.0f;
    private static final float ALL_TASKS_CHEVRON_WIDTH_DP = 10.0f;
    private static final long ALL_TASKS_FADE_MS = 220;
    private static final float ALL_TASKS_MARGIN_BOTTOM_DP = 94.0f;
    private static final float ALL_TASKS_NUDGE_UP_PX = 2.0f;
    private static final float ALL_TASKS_PAD_H_DP = 12.0f;
    private static final float ALL_TASKS_PAD_V_DP = 6.0f;
    private static final float ALL_TASKS_PILL_HEIGHT_DP = 26.0f;
    private static final float ALL_TASKS_PILL_WIDTH_DP = 55.0f;
    private static final float ALL_TASKS_TEXT_MARGIN_END_DP = -1.0f;
    private static final int CHIPS_TO_INPUT_BAR_IME_DP = 32;
    private static final long CHIP_BOUNCE_DOWN_MS = 380;
    private static final float CHIP_BOUNCE_SCALE = 0.9f;
    private static final long CHIP_BOUNCE_UP_MS = 430;
    private static final float CHIP_CORNER_DP = 21.0f;
    private static final int GREETING_MIN_TOP_GAP_DP = 24;
    private static final long HOME_CONSUME_IME_HIDE_MS = 160;
    private static final float HOME_DIM_ALPHA = 0.4f;
    private static final int IME_GLOW_FALLBACK_HEIGHT_DP = 300;
    private static final long IME_GLOW_HIDE_MS = 220;
    private static final float IME_GLOW_HIDE_SNAP_ALPHA = 0.05f;
    private static final long INCOMING_VOICE_HOLD_DELAY_MS = 400;
    private static final float INPUT_BAR_ALPHA_DAMPING_RATIO = 1.0f;
    private static final long INPUT_BAR_ALPHA_DURATION_MS = 400;
    private static final float INPUT_BAR_ALPHA_STIFFNESS = 400.0f;
    private static final float INPUT_BAR_GLASS_CROSS_WINDOW_PROGRESS = 0.78f;
    private static final int INPUT_BAR_IDLE_HEIGHT_DP = 73;
    private static final float LAUNCHER_DP_TO_PX_DENOMINATOR = 2400.0f;
    private static final float LAUNCHER_DP_TO_PX_NUMERATOR = 2.75f;
    private static final String LAUNCHER_PACKAGE = "com.android.launcher3";
    private static final float PANEL_CORNER_DP = 28.0f;
    private static final String TAG = "ThreeTileOverlayView";
    private static volatile int cachedInitialDensityDpi;
    private long agentEnterElapsedMs;
    private boolean agentViewReported;
    private Animator allTasksEntryAnimator;
    private boolean allTasksEntryVisible;
    private boolean allTasksLongPressFadeActive;
    private Boolean allTasksTargetVisible;
    private String analyticsOpenTriggerSource;
    private String analyticsResizeTrigger;
    private String analyticsStage;
    private boolean artifactsActive;
    private final r6.s binding;
    private boolean chatConversationEmpty;
    private C chatInputComponent;
    private boolean chatRecommendExposeReported;
    private boolean chatRecording;
    private boolean chatviewOpenReported;
    private int chipsToInputGapPx;
    private boolean collapseExposeWallpaperForInputBar;
    private boolean collapsingAfterSysUiAlign;
    private InputBarGlassPhase committedInputBarGlassPhase;
    private FrameLayout contentContainer;
    private View coveredPanelScrimView;
    private boolean desktopGreetingPinned;
    private View dimView;
    private View dragHandle;
    private androidx.dynamicanimation.animation.i dragHandleAlphaAnim;
    private b embeddedGroupExit;
    private Animator exitColorAnim;
    private boolean freshSessionMintedForHome;
    private final Map<View, y7.E> glassedViews;
    private Boolean greetingGlassKeyboardUp;
    private boolean holdHalfOverExistingIme;
    private ValueAnimator homeConsumeImeGeomAnim;
    private final l homeGroupExitParticipant;
    private int imeGlowAppliedRes;
    private boolean imeGlowHiding;
    private final InterfaceC5074l<Integer, Y8.t> imeGlowThemeListener;
    private int imeHeightFromInsets;
    private int imeHideResetGeneration;
    private int imePeakHeightPx;
    private boolean imePinnedByDialog;
    private boolean imeRising;
    private boolean imeVisible;
    private final MinusOneIncomingVoiceHold incomingVoiceHold;
    private Runnable incomingVoiceWait;
    private androidx.dynamicanimation.animation.i inputBarAlphaAnim;
    private Runnable inputBarAlphaDelayRunnable;
    private boolean inputBarSlideHeld;
    private boolean inputHasContent;
    private final HomeInputPresentationState inputPresentationState;
    private boolean isExternalSession;
    private int keyboardHeightPx;
    private Boolean lastWakeDialogShowing;
    private final C1399q lifecycleRegistry;
    private int navBottomPx;
    private final Q0.a onSessionExternallyMarked;
    private IOverlayPageHost overlayHost;
    private boolean pageResumed;
    private Ua.M pageScope;
    private HomeChatPagerView pagerView;
    private float panelGlassBlurPx;
    private final com.stepos.ailauncher.container.glass.j panelGlassCommit;
    private y7.E panelGlassHandle;
    private SheetGlassStyle panelGlassStyle;
    private int panelGlassTint;
    private boolean panelShown;
    private long panelTransitionSeq;
    private boolean pendingFreshSessionAfterCollapse;
    private List<String> pendingFreshSessionKeys;
    private View recordingScrimView;
    private com.stepos.ailauncher.chat.wake.effect.c recordingSpectrum;
    private InterfaceC5063a<Y8.t> releaseCoveredPanelScrim;
    private int restoreSeq;
    private final p screenOffReceiver;
    private boolean screenOffReceiverRegistered;
    private SessionHandler sessionHandler;
    private E sheetHostRoot;
    private DraggableSheetLayout sheetLayout;
    private ViewGroup sheetPanel;
    private boolean sheetReady;
    private int statusBarTopPx;
    private List<RecommendCard> suggestCards;
    private boolean suggestExposeReported;
    private boolean suppressGreetChipsLiftUntilKbZero;
    private boolean swallowingImeDismiss;
    private boolean sysUiClosePending;
    private Runnable sysUiCloseRunnable;
    private long traditionalEnterElapsedMs;
    private final InterfaceC5074l<Boolean, Y8.t> wakeDialogVisibilityListener;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PathInterpolator CHIP_BOUNCE_INTERPOLATOR = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/task/space/ThreeTileOverlayView$InputBarGlassPhase;", "", "<init>", "(Ljava/lang/String;I)V", "CHAT", "DESKTOP", "DESKTOP_IME", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class InputBarGlassPhase {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ InputBarGlassPhase[] $VALUES;
        public static final InputBarGlassPhase CHAT = new InputBarGlassPhase("CHAT", 0);
        public static final InputBarGlassPhase DESKTOP = new InputBarGlassPhase("DESKTOP", 1);
        public static final InputBarGlassPhase DESKTOP_IME = new InputBarGlassPhase("DESKTOP_IME", 2);

        private static final /* synthetic */ InputBarGlassPhase[] $values() {
            return new InputBarGlassPhase[]{CHAT, DESKTOP, DESKTOP_IME};
        }

        static {
            InputBarGlassPhase[] inputBarGlassPhaseArr$values = $values();
            $VALUES = inputBarGlassPhaseArr$values;
            $ENTRIES = kotlin.enums.a.a(inputBarGlassPhaseArr$values);
        }

        private InputBarGlassPhase(String str, int i10) {
        }

        public static InterfaceC4149a<InputBarGlassPhase> getEntries() {
            return $ENTRIES;
        }

        public static InputBarGlassPhase valueOf(String str) {
            return (InputBarGlassPhase) Enum.valueOf(InputBarGlassPhase.class, str);
        }

        public static InputBarGlassPhase[] values() {
            return (InputBarGlassPhase[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0014\u0010\u001a\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0014\u0010\u001b\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0014\u0010\u001d\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\u0014\u0010\u001f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0010R\u0014\u0010 \u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0013R\u0014\u0010!\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0013R\u0014\u0010\"\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0013R\u0014\u0010#\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u0013R\u0014\u0010$\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u0013R\u0014\u0010%\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u0013R\u0014\u0010&\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u0013R\u0014\u0010'\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\u0013R\u0014\u0010(\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\u0013R\u0014\u0010)\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010\u0013R\u0014\u0010*\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010\u0013R\u0014\u0010+\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010\u0013R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010\u0015R\u0014\u0010-\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010\rR\u0014\u0010.\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010\rR\u0014\u0010/\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010\u0013R\u0014\u00100\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010\u0010R\u0014\u00101\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010\u0010R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u0010\u0013R\u0014\u00106\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u0010\u0013R\u0014\u00107\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u0010\u0010¨\u00068"}, d2 = {"Lcom/stepos/ailauncher/task/space/ThreeTileOverlayView$a;", "", "<init>", "()V", "", "color", "c", "(I)I", Const.INTENT_KEY_UMID, "()I", "e", "", "TAG", "Ljava/lang/String;", "", "INCOMING_VOICE_HOLD_DELAY_MS", "J", "", "CHIP_CORNER_DP", "F", "CHIPS_TO_INPUT_BAR_IME_DP", "I", "INPUT_BAR_IDLE_HEIGHT_DP", "GREETING_MIN_TOP_GAP_DP", "IME_GLOW_FALLBACK_HEIGHT_DP", "IME_GLOW_HIDE_MS", "HOME_CONSUME_IME_HIDE_MS", "IME_GLOW_HIDE_SNAP_ALPHA", "PANEL_CORNER_DP", "HOME_DIM_ALPHA", "INPUT_BAR_GLASS_CROSS_WINDOW_PROGRESS", "ALL_TASKS_FADE_MS", "ALL_TASKS_PILL_WIDTH_DP", "ALL_TASKS_PILL_HEIGHT_DP", "ALL_TASKS_NUDGE_UP_PX", "ALL_TASKS_MARGIN_BOTTOM_DP", "ALL_TASKS_CHEVRON_WIDTH_DP", "ALL_TASKS_CHEVRON_HEIGHT_DP", "ALL_TASKS_PAD_H_DP", "ALL_TASKS_PAD_V_DP", "ALL_TASKS_CHEVRON_MARGIN_START_DP", "ALL_TASKS_TEXT_MARGIN_END_DP", "LAUNCHER_DP_TO_PX_NUMERATOR", "LAUNCHER_DP_TO_PX_DENOMINATOR", "cachedInitialDensityDpi", "ACTION_OPEN_ALL_TASK_NOTIFY", "LAUNCHER_PACKAGE", "CHIP_BOUNCE_SCALE", "CHIP_BOUNCE_DOWN_MS", "CHIP_BOUNCE_UP_MS", "Landroid/view/animation/PathInterpolator;", "CHIP_BOUNCE_INTERPOLATOR", "Landroid/view/animation/PathInterpolator;", "INPUT_BAR_ALPHA_STIFFNESS", "INPUT_BAR_ALPHA_DAMPING_RATIO", "INPUT_BAR_ALPHA_DURATION_MS", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.ThreeTileOverlayView$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final int c(int color) {
            return color != 2 ? color != 3 ? R$drawable.bg_three_tile_ime_glow : R$drawable.bg_three_tile_ime_glow_yellow : R$drawable.bg_three_tile_ime_glow_blue;
        }

        public final int d() {
            int i10 = ThreeTileOverlayView.cachedInitialDensityDpi;
            if (i10 > 0) {
                return i10;
            }
            int iE = e();
            ThreeTileOverlayView.cachedInitialDensityDpi = iE;
            return iE;
        }

        public final int e() {
            try {
                Object objInvoke = Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "window");
                kotlin.jvm.internal.p.g(objInvoke, "null cannot be cast to non-null type android.os.IBinder");
                Object objInvoke2 = Class.forName("android.view.IWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, (IBinder) objInvoke);
                Object objInvoke3 = objInvoke2.getClass().getMethod("getInitialDisplayDensity", Integer.TYPE).invoke(objInvoke2, 0);
                kotlin.jvm.internal.p.g(objInvoke3, "null cannot be cast to non-null type kotlin.Int");
                int iIntValue = ((Integer) objInvoke3).intValue();
                if (iIntValue > 0) {
                    return iIntValue;
                }
            } catch (Throwable unused) {
            }
            return DisplayMetrics.DENSITY_DEVICE_STABLE;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\b\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\f\u0010\nR*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R0\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/task/space/ThreeTileOverlayView$b;", "", "", "anchorEnabled", "dragEnabled", "dismissEnabled", "<init>", "(ZZZ)V", "Z", Const.INTENT_KEY_APIKEY, "()Z", "c", Const.INTENT_KEY_PKGNAME, "Lkotlin/Function0;", "LY8/t;", "startAnimation", "Lp9/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lp9/a;", "l", "(Lp9/a;)V", "finishImmediately", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lkotlin/Function1;", "", "onProgress", "Lp9/l;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lp9/l;", "k", "(Lp9/l;)V", "onEnd", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", "durationMs", "J", Const.INTENT_KEY_UMID, "()J", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {
        private final boolean anchorEnabled;
        private final boolean dismissEnabled;
        private final boolean dragEnabled;
        private final long durationMs;
        private InterfaceC5063a<Y8.t> finishImmediately;
        private InterfaceC5063a<Y8.t> onEnd;
        private InterfaceC5074l<? super Float, Y8.t> onProgress;
        private InterfaceC5063a<Y8.t> startAnimation;

        public b(boolean z10, boolean z11, boolean z12) {
            this.anchorEnabled = z10;
            this.dragEnabled = z11;
            this.dismissEnabled = z12;
            com.stepos.ailauncher.sheet.i0 i0Var = com.stepos.ailauncher.sheet.i0.INSTANCE;
            this.durationMs = com.stepos.ailauncher.chat.wake.homebar.A.f(i0Var.v().getStiffness(), i0Var.v().getDampingRatio(), 0.0f, 871.0f, 0.0f, 16, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getAnchorEnabled() {
            return this.anchorEnabled;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getDismissEnabled() {
            return this.dismissEnabled;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getDragEnabled() {
            return this.dragEnabled;
        }

        /* renamed from: d, reason: from getter */
        public final long getDurationMs() {
            return this.durationMs;
        }

        public final InterfaceC5063a<Y8.t> e() {
            return this.finishImmediately;
        }

        public final InterfaceC5063a<Y8.t> f() {
            return this.onEnd;
        }

        public final InterfaceC5074l<Float, Y8.t> g() {
            return this.onProgress;
        }

        public final InterfaceC5063a<Y8.t> h() {
            return this.startAnimation;
        }

        public final void i(InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.finishImmediately = interfaceC5063a;
        }

        public final void j(InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.onEnd = interfaceC5063a;
        }

        public final void k(InterfaceC5074l<? super Float, Y8.t> interfaceC5074l) {
            this.onProgress = interfaceC5074l;
        }

        public final void l(InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.startAnimation = interfaceC5063a;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SheetSettleState.values().length];
            try {
                iArr[SheetSettleState.HALF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetSettleState.FULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SheetSettleState.IMMERSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SheetSettleState.MINIFY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SheetSettleState.HIDDEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MinusOneIncomingVoiceHold.PauseAction.values().length];
            try {
                iArr2[MinusOneIncomingVoiceHold.PauseAction.STOP_NOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[MinusOneIncomingVoiceHold.PauseAction.KEEP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[MinusOneIncomingVoiceHold.PauseAction.WAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements View.OnLayoutChangeListener {
        public d() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            ThreeTileOverlayView.this.g3();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            ThreeTileOverlayView.this.g3();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements View.OnLayoutChangeListener {
        public f() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            ThreeTileOverlayView.this.h3();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g implements View.OnLayoutChangeListener {
        public g() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            ThreeTileOverlayView.this.l3();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h implements View.OnLayoutChangeListener {
        public h() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            ThreeTileOverlayView.this.i3();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/task/space/ThreeTileOverlayView$i", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class i extends ViewOutlineProvider {
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), Math.min(view.getWidth(), view.getHeight()) / 2.0f);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ+\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/ailauncher/task/space/ThreeTileOverlayView$j", "Lcom/stepos/ailauncher/container/l0$a;", "", "sessionId", "", "restoreLast", "f", "(Ljava/lang/String;Z)Z", "c", "()Z", "agentId", "deviceId", "agentDisplayName", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", HighlightArgsBundle.KEY_PROMPT, "e", "(Ljava/lang/String;)Z", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", "Lkotlin/Function0;", Const.INTENT_KEY_APIKEY, "()Lp9/a;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class j implements l0.a {
        public j() {
        }

        public static final Y8.t h(ConstraintLayout constraintLayout, View view, ThreeTileOverlayView threeTileOverlayView) {
            constraintLayout.removeView(view);
            if (threeTileOverlayView.coveredPanelScrimView == view) {
                threeTileOverlayView.coveredPanelScrimView = null;
                threeTileOverlayView.releaseCoveredPanelScrim = null;
            }
            return Y8.t.f7040a;
        }

        @Override // com.stepos.ailauncher.container.l0.a
        public InterfaceC5063a<Y8.t> a() throws Resources.NotFoundException {
            InterfaceC5063a<Y8.t> interfaceC5063a;
            if (!ThreeTileOverlayView.this.panelShown && (interfaceC5063a = ThreeTileOverlayView.this.releaseCoveredPanelScrim) != null) {
                return interfaceC5063a;
            }
            View view = ThreeTileOverlayView.this.dimView;
            E e10 = ThreeTileOverlayView.this.sheetHostRoot;
            float alpha = view != null ? view.getAlpha() : 0.0f;
            if (!ThreeTileOverlayView.this.panelShown || e10 == null || e10.getVisibility() != 0 || view == null || view.getVisibility() != 0 || alpha <= 0.0f) {
                b();
                return null;
            }
            b();
            final ConstraintLayout constraintLayoutB = ThreeTileOverlayView.this.binding.b();
            kotlin.jvm.internal.p.h(constraintLayoutB, "getRoot(...)");
            final View view2 = new View(ThreeTileOverlayView.this.getContext());
            view2.setBackgroundColor(-16777216);
            view2.setAlpha(alpha);
            view2.setImportantForAccessibility(2);
            int iIndexOfChild = constraintLayoutB.indexOfChild(e10);
            ConstraintLayout.b bVar = new ConstraintLayout.b(0, 0);
            bVar.f12642i = 0;
            bVar.f12648l = 0;
            bVar.f12664t = 0;
            bVar.f12668v = 0;
            Y8.t tVar = Y8.t.f7040a;
            constraintLayoutB.addView(view2, iIndexOfChild, bVar);
            final ThreeTileOverlayView threeTileOverlayView = ThreeTileOverlayView.this;
            InterfaceC5063a<Y8.t> interfaceC5063a2 = new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.D3
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ThreeTileOverlayView.j.h(constraintLayoutB, view2, threeTileOverlayView);
                }
            };
            ThreeTileOverlayView.this.coveredPanelScrimView = view2;
            ThreeTileOverlayView.this.releaseCoveredPanelScrim = interfaceC5063a2;
            return interfaceC5063a2;
        }

        @Override // com.stepos.ailauncher.container.l0.a
        public void b() throws Resources.NotFoundException {
            InterfaceC5063a interfaceC5063a = ThreeTileOverlayView.this.releaseCoveredPanelScrim;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
            if (ThreeTileOverlayView.this.panelShown) {
                ThreeTileOverlayView.V2(ThreeTileOverlayView.this, false, false, null, 4, null);
            }
        }

        @Override // com.stepos.ailauncher.container.l0.a
        public boolean c() {
            return ThreeTileOverlayView.this.K2();
        }

        @Override // com.stepos.ailauncher.container.l0.a
        public boolean d(String agentId, String deviceId, String agentDisplayName) {
            kotlin.jvm.internal.p.i(deviceId, "deviceId");
            return ThreeTileOverlayView.this.q3(agentId, deviceId, agentDisplayName);
        }

        @Override // com.stepos.ailauncher.container.l0.a
        public boolean e(String prompt) {
            kotlin.jvm.internal.p.i(prompt, "prompt");
            return ThreeTileOverlayView.this.r3(prompt);
        }

        @Override // com.stepos.ailauncher.container.l0.a
        public boolean f(String sessionId, boolean restoreLast) {
            return ThreeTileOverlayView.this.s3(sessionId, restoreLast);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class k<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            String displayText = ((RecommendCard) t10).getDisplayText();
            Integer numValueOf = Integer.valueOf(displayText != null ? displayText.length() : 0);
            String displayText2 = ((RecommendCard) t11).getDisplayText();
            return b9.b.d(numValueOf, Integer.valueOf(displayText2 != null ? displayText2.length() : 0));
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0011\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\rJ\u000f\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"com/stepos/ailauncher/task/space/ThreeTileOverlayView$l", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeSharedOffsetExitParticipant;", "", "isShowing", "()Z", "", "prepareSharedOffsetExit", "()Ljava/lang/Float;", "prepareForHomeGroupExit", "positionPx", "progress", "LY8/t;", "applyHomeGroupExit", "(FF)V", "Lkotlin/Function0;", "startAnimation", "finishImmediately", "startSharedOffsetExit", "(Lp9/a;Lp9/a;)V", "offsetPx", "applySharedOffsetExit", "finishHomeGroupExit", "()V", "cancelHomeGroupExit", "", "participantId", "Ljava/lang/String;", "getParticipantId", "()Ljava/lang/String;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class l implements HomeSharedOffsetExitParticipant {
        private final String participantId;

        public l() {
            this.participantId = "minus-one-base:" + System.identityHashCode(ThreeTileOverlayView.this);
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
        public void applyHomeGroupExit(float positionPx, float progress) {
            applySharedOffsetExit(positionPx, progress);
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeSharedOffsetExitParticipant
        public void applySharedOffsetExit(float offsetPx, float progress) {
            InterfaceC5074l<Float, Y8.t> interfaceC5074lG;
            if (ThreeTileOverlayView.this.embeddedGroupExit == null) {
                return;
            }
            DraggableSheetLayout draggableSheetLayout = ThreeTileOverlayView.this.sheetLayout;
            if (draggableSheetLayout != null) {
                draggableSheetLayout.setHomeGroupExitOffsetY(offsetPx);
            }
            b bVar = ThreeTileOverlayView.this.embeddedGroupExit;
            if (bVar == null || (interfaceC5074lG = bVar.g()) == null) {
                return;
            }
            interfaceC5074lG.invoke(Float.valueOf(progress));
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
        public void cancelHomeGroupExit() {
            b bVar = ThreeTileOverlayView.this.embeddedGroupExit;
            if (bVar != null) {
                ThreeTileOverlayView.this.G4(bVar);
            }
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
        public void finishHomeGroupExit() {
            b bVar = ThreeTileOverlayView.this.embeddedGroupExit;
            if (bVar == null) {
                return;
            }
            com.stepos.ailauncher.chat.wake.homebar.A.c(ThreeTileOverlayView.this.sysUiCloseRunnable);
            ThreeTileOverlayView.this.sysUiCloseRunnable = null;
            ThreeTileOverlayView.this.sysUiClosePending = false;
            try {
                if (bVar.f() == null) {
                    ThreeTileOverlayView.this.collapsingAfterSysUiAlign = true;
                    try {
                        ThreeTileOverlayView.this.U2(true, true, bVar);
                        ThreeTileOverlayView.this.collapsingAfterSysUiAlign = false;
                        com.stepos.ailauncher.chat.wake.homebar.A.i(0L, 0L, 0L, 7, null);
                    } catch (Throwable th) {
                        ThreeTileOverlayView.this.collapsingAfterSysUiAlign = false;
                        throw th;
                    }
                }
                InterfaceC5063a<Y8.t> interfaceC5063aF = bVar.f();
                if (interfaceC5063aF != null) {
                    interfaceC5063aF.invoke();
                }
                E e10 = ThreeTileOverlayView.this.sheetHostRoot;
                if (e10 != null) {
                    e10.setVisibility(4);
                }
                ThreeTileOverlayView.this.G4(bVar);
            } catch (Throwable th2) {
                E e11 = ThreeTileOverlayView.this.sheetHostRoot;
                if (e11 != null) {
                    e11.setVisibility(4);
                }
                ThreeTileOverlayView.this.G4(bVar);
                throw th2;
            }
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
        public String getParticipantId() {
            return this.participantId;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
        public /* bridge */ HomeRootToken getVisualStackRootToken() {
            return super.getVisualStackRootToken();
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
        public boolean isShowing() {
            return ThreeTileOverlayView.this.L3();
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant
        public boolean prepareForHomeGroupExit() {
            return prepareSharedOffsetExit() != null;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeSharedOffsetExitParticipant
        public Float prepareSharedOffsetExit() {
            DraggableSheetLayout draggableSheetLayout;
            if (!isShowing() || ThreeTileOverlayView.this.embeddedGroupExit != null || (draggableSheetLayout = ThreeTileOverlayView.this.sheetLayout) == null) {
                return null;
            }
            ThreeTileOverlayView.this.embeddedGroupExit = new b(draggableSheetLayout.getBottomAnchorEnabled(), draggableSheetLayout.getDragEnabled(), draggableSheetLayout.getDismissEnabled());
            Float fH0 = draggableSheetLayout.h0();
            if (fH0 != null) {
                ThreeTileOverlayView.this.M2();
                ThreeTileOverlayView.this.L2("homeGroupExit");
                ThreeTileOverlayView.this.P2();
                draggableSheetLayout.setBottomAnchorEnabled(false);
                draggableSheetLayout.setDragEnabled(false);
                draggableSheetLayout.setDismissEnabled(false);
                return fH0;
            }
            return null;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.HomeSharedOffsetExitParticipant
        public void startSharedOffsetExit(InterfaceC5063a<Y8.t> startAnimation, InterfaceC5063a<Y8.t> finishImmediately) throws Resources.NotFoundException {
            kotlin.jvm.internal.p.i(startAnimation, "startAnimation");
            kotlin.jvm.internal.p.i(finishImmediately, "finishImmediately");
            b bVar = ThreeTileOverlayView.this.embeddedGroupExit;
            if (bVar == null) {
                throw new IllegalStateException("Required value was null.");
            }
            bVar.l(startAnimation);
            bVar.i(finishImmediately);
            ThreeTileOverlayView.this.U2(true, true, bVar);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class m implements View.OnLayoutChangeListener {
        public m() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            ThreeTileOverlayView.this.i3();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class n implements View.OnLayoutChangeListener {
        public n() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            if (ThreeTileOverlayView.this.panelShown) {
                return;
            }
            ThreeTileOverlayView.this.i3();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class o implements View.OnLayoutChangeListener {
        public o() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            ThreeTileOverlayView.this.l3();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/task/space/ThreeTileOverlayView$p", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class p extends BroadcastReceiver {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ScreenOffInputAction.values().length];
                try {
                    iArr[ScreenOffInputAction.NONE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ScreenOffInputAction.DISMISS_IME_PRESERVING_DRAFT_LAYOUT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public p() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (kotlin.jvm.internal.p.d(intent != null ? intent.getAction() : null, "android.intent.action.SCREEN_OFF")) {
                int i10 = a.$EnumSwitchMapping$0[C3661q1.INSTANCE.a(ThreeTileOverlayView.this.keyboardHeightPx).ordinal()];
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    C4148a.k(ThreeTileOverlayView.TAG, "SCREEN_OFF with keyboard up (kb=" + ThreeTileOverlayView.this.keyboardHeightPx + "): dismiss IME preserving draft layout", false, 4, null);
                    ThreeTileOverlayView.this.binding.layoutInputBarNew.n6();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/task/space/ThreeTileOverlayView$q", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class q extends ViewOutlineProvider {
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), Math.min(view.getWidth(), view.getHeight()) / 2.0f);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/task/space/ThreeTileOverlayView$r", "Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout$a;", "", "progress", "LY8/t;", Const.INTENT_KEY_APIKEY, "(F)V", "c", "()V", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class r implements DraggableSheetLayout.a {
        public r() {
        }

        @Override // com.stepos.ailauncher.sheet.widget.DraggableSheetLayout.a
        public void a(float progress) {
            View view = ThreeTileOverlayView.this.dimView;
            if (view != null && view.getVisibility() == 0) {
                view.setAlpha(C5685n.m(1.0f - progress, 0.0f, 1.0f) * 0.4f);
            }
            ThreeTileOverlayView.this.J1();
            if (ThreeTileOverlayView.this.panelShown) {
                ThreeTileOverlayView.Z1(ThreeTileOverlayView.this, false, 1, null);
            }
            com.stepos.ailauncher.container.d0.INSTANCE.b(ThreeTileOverlayView.this.M3());
        }

        @Override // com.stepos.ailauncher.sheet.widget.DraggableSheetLayout.a
        public void b(SheetSettleState state) {
            kotlin.jvm.internal.p.i(state, "state");
            ThreeTileOverlayView threeTileOverlayView = ThreeTileOverlayView.this;
            ThreeTileOverlayView.P4(threeTileOverlayView, threeTileOverlayView.B5(state), null, null, 6, null);
            HomeChatPagerView homeChatPagerView = ThreeTileOverlayView.this.pagerView;
            if (homeChatPagerView != null) {
                homeChatPagerView.c0(state);
            }
            ThreeTileOverlayView.this.K1();
            ThreeTileOverlayView.this.binding.layoutInputBarNew.ca();
            ThreeTileOverlayView.z5(ThreeTileOverlayView.this, null, 1, null);
            if (ThreeTileOverlayView.this.panelShown) {
                ThreeTileOverlayView.this.m3();
                if (state == SheetSettleState.HALF) {
                    ThreeTileOverlayView.this.F4();
                    ThreeTileOverlayView.this.l3();
                } else if (state == SheetSettleState.FULL && ThreeTileOverlayView.this.M3()) {
                    ThreeTileOverlayView.this.F4();
                    ThreeTileOverlayView.this.H4();
                }
                com.stepos.ailauncher.container.d0.INSTANCE.b(ThreeTileOverlayView.this.M3());
            }
        }

        @Override // com.stepos.ailauncher.sheet.widget.DraggableSheetLayout.a
        public void c() throws Resources.NotFoundException {
            ThreeTileOverlayView.V2(ThreeTileOverlayView.this, true, true, null, 4, null);
        }

        @Override // com.stepos.ailauncher.sheet.widget.DraggableSheetLayout.a
        public /* bridge */ void d() {
            super.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreeTileOverlayView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        r6.s sVarC = r6.s.c(LayoutInflater.from(context), this, true);
        kotlin.jvm.internal.p.h(sVarC, "inflate(...)");
        this.binding = sVarC;
        this.lifecycleRegistry = new C1399q(this);
        this.glassedViews = new LinkedHashMap();
        this.suggestCards = C1173v.m();
        this.homeGroupExitParticipant = new l();
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        SheetGlassStyle sheetGlassStyle = SheetGlassStyle.HALF;
        this.panelGlassTint = hVar.K(sheetGlassStyle);
        this.panelGlassBlurPx = hVar.I(sheetGlassStyle);
        this.panelGlassCommit = new com.stepos.ailauncher.container.glass.j(0L, 1, null);
        this.analyticsStage = "close";
        this.pendingFreshSessionKeys = C1173v.m();
        this.incomingVoiceHold = new MinusOneIncomingVoiceHold();
        this.inputPresentationState = new HomeInputPresentationState();
        this.onSessionExternallyMarked = new Q0.a() { // from class: com.stepos.ailauncher.task.space.s2
            @Override // com.stepos.ailauncher.chat.manager.Q0.a
            public final void a(Set set) {
                ThreeTileOverlayView.i4(this.f29110a, set);
            }
        };
        this.imeGlowThemeListener = new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.t2
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.y3(this.f29115a, ((Integer) obj).intValue());
            }
        };
        this.chatConversationEmpty = true;
        this.wakeDialogVisibilityListener = new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.u2
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.F5(this.f29119a, ((Boolean) obj).booleanValue());
            }
        };
        this.screenOffReceiver = new p();
    }

    public static final void A1(ThreeTileOverlayView threeTileOverlayView, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        threeTileOverlayView.R1(((Integer) animatedValue).intValue());
    }

    public static final boolean A2(ThreeTileOverlayView threeTileOverlayView, String str, String str2) {
        return threeTileOverlayView.t3(str, str2);
    }

    public static final void A4(ThreeTileOverlayView threeTileOverlayView, View view) throws Resources.NotFoundException {
        V2(threeTileOverlayView, true, true, null, 4, null);
    }

    public static final Y8.t B2(HomeInputView homeInputView, ThreeTileOverlayView threeTileOverlayView, String str) {
        homeInputView.m6(str);
        threeTileOverlayView.y5(str);
        return Y8.t.f7040a;
    }

    public static final Y8.t B3(ThreeTileOverlayView threeTileOverlayView, boolean z10) {
        threeTileOverlayView.X1(z10);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String B5(SheetSettleState sheetSettleState) {
        int i10 = c.$EnumSwitchMapping$0[sheetSettleState.ordinal()];
        if (i10 == 1) {
            return ChatTracker.STAGE_HALF;
        }
        if (i10 == 2 || i10 == 3) {
            return ChatTracker.STAGE_FULL;
        }
        if (i10 == 4 || i10 == 5) {
            return "close";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ void C1(ThreeTileOverlayView threeTileOverlayView, float f10, boolean z10, long j10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i10 & 4) != 0) {
            j10 = 0;
        }
        long j11 = j10;
        if ((i10 & 8) != 0) {
            interfaceC5063a = null;
        }
        threeTileOverlayView.B1(f10, z11, j11, interfaceC5063a);
    }

    public static final Y8.t C2(ThreeTileOverlayView threeTileOverlayView, HomeChatPagerView homeChatPagerView, boolean z10, int i10) {
        int iF = C5685n.f(i10 - threeTileOverlayView.navBottomPx, 0);
        if (!z10 && !threeTileOverlayView.imePinnedByDialog && iF == 0) {
            threeTileOverlayView.imeHeightFromInsets = 0;
            threeTileOverlayView.T4("imeAnimEnd", true);
        }
        homeChatPagerView.getChatHost().getChatLayout().p5(z10);
        homeChatPagerView.getChatHost().getChatLayout().c9();
        return Y8.t.f7040a;
    }

    public static final boolean C3(ThreeTileOverlayView threeTileOverlayView) {
        return threeTileOverlayView.I3();
    }

    public static final void D1(ThreeTileOverlayView threeTileOverlayView, float f10, InterfaceC5063a interfaceC5063a) {
        threeTileOverlayView.inputBarAlphaDelayRunnable = null;
        threeTileOverlayView.t5(f10, interfaceC5063a);
    }

    public static final Y8.t D2(ThreeTileOverlayView threeTileOverlayView, boolean z10) {
        threeTileOverlayView.chatConversationEmpty = z10;
        threeTileOverlayView.K1();
        return Y8.t.f7040a;
    }

    public static final void D3(ThreeTileOverlayView threeTileOverlayView, View view) {
        threeTileOverlayView.binding.layoutInputBarNew.t5();
    }

    private final void D4() {
        Object objB;
        if (this.screenOffReceiverRegistered) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            getContext().getApplicationContext().registerReceiver(this.screenOffReceiver, new IntentFilter("android.intent.action.SCREEN_OFF"), 2);
            this.screenOffReceiverRegistered = true;
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "registerScreenOffReceiver failed", thE, false, 8, null);
        }
    }

    private final void D5() {
        if (this.screenOffReceiverRegistered) {
            this.screenOffReceiverRegistered = false;
            try {
                Result.Companion companion = Result.INSTANCE;
                getContext().getApplicationContext().unregisterReceiver(this.screenOffReceiver);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public static final Y8.t E2(ThreeTileOverlayView threeTileOverlayView, String str) {
        z5(threeTileOverlayView, null, 1, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t F2(ThreeTileOverlayView threeTileOverlayView, boolean z10) {
        z5(threeTileOverlayView, null, 1, null);
        threeTileOverlayView.K1();
        threeTileOverlayView.R1(threeTileOverlayView.imeHeightFromInsets);
        return Y8.t.f7040a;
    }

    public static final Y8.t F5(final ThreeTileOverlayView threeTileOverlayView, boolean z10) {
        threeTileOverlayView.A5();
        boolean z11 = kotlin.jvm.internal.p.d(threeTileOverlayView.lastWakeDialogShowing, Boolean.TRUE) && !z10;
        threeTileOverlayView.lastWakeDialogShowing = Boolean.valueOf(z10);
        if (!z10) {
            threeTileOverlayView.X1(false);
            if (z11) {
                HomeInputView layoutInputBarNew = threeTileOverlayView.binding.layoutInputBarNew;
                kotlin.jvm.internal.p.h(layoutInputBarNew, "layoutInputBarNew");
                BaseInputView.za(layoutInputBarNew, false, 1, null);
                threeTileOverlayView.binding.layoutInputBarNew.post(new Runnable() { // from class: com.stepos.ailauncher.task.space.z2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ThreeTileOverlayView.G5(this.f29148a);
                    }
                });
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t G2(ThreeTileOverlayView threeTileOverlayView, boolean z10) {
        threeTileOverlayView.R1(threeTileOverlayView.imeHeightFromInsets);
        return Y8.t.f7040a;
    }

    public static final void G5(ThreeTileOverlayView threeTileOverlayView) {
        threeTileOverlayView.binding.layoutInputBarNew.td();
    }

    public static final Y8.t H2(ThreeTileOverlayView threeTileOverlayView) throws Resources.NotFoundException {
        V2(threeTileOverlayView, true, true, null, 4, null);
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void I1(ThreeTileOverlayView threeTileOverlayView, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        threeTileOverlayView.H1(z10);
    }

    public static final Y8.t I2(HomeInputView homeInputView, ThreeTileOverlayView threeTileOverlayView) {
        homeInputView.d();
        if (threeTileOverlayView.pendingFreshSessionAfterCollapse) {
            C4148a.k(TAG, "onConversationSwitch: clear pending fresh-after-collapse", false, 4, null);
        }
        threeTileOverlayView.S2();
        return Y8.t.f7040a;
    }

    public static final void I5(ThreeTileOverlayView threeTileOverlayView, String str, View view) {
        kotlin.jvm.internal.p.f(view);
        threeTileOverlayView.p4(view);
        threeTileOverlayView.k4(0, R$string.three_tile_suggest_schedule, str);
    }

    public static final void J5(ThreeTileOverlayView threeTileOverlayView, String str, View view) {
        kotlin.jvm.internal.p.f(view);
        threeTileOverlayView.p4(view);
        threeTileOverlayView.k4(1, R$string.three_tile_suggest_bills, str);
    }

    public static final void K5(ThreeTileOverlayView threeTileOverlayView, String str, View view) {
        kotlin.jvm.internal.p.f(view);
        threeTileOverlayView.p4(view);
        threeTileOverlayView.k4(2, R$string.three_tile_suggest_trips, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L2(String reason) {
        androidx.dynamicanimation.animation.i iVar = this.dragHandleAlphaAnim;
        if (iVar != null) {
            boolean zI = iVar.i();
            View view = this.dragHandle;
            Log.i("DragHandleAlpha", "cancel host=ThreeTile reason=" + reason + " wasRunning=" + zI + " alpha=" + (view != null ? Float.valueOf(view.getAlpha()) : null));
        }
        if (iVar != null) {
            iVar.d();
        }
        this.dragHandleAlphaAnim = null;
    }

    public static final void L5(ThreeTileOverlayView threeTileOverlayView, String str, View view) {
        kotlin.jvm.internal.p.f(view);
        threeTileOverlayView.p4(view);
        threeTileOverlayView.k4(0, R$string.three_tile_suggest_schedule, str);
    }

    public static final void M5(ThreeTileOverlayView threeTileOverlayView, String str, View view) {
        kotlin.jvm.internal.p.f(view);
        threeTileOverlayView.p4(view);
        threeTileOverlayView.k4(1, R$string.three_tile_suggest_bills, str);
    }

    public static final Y8.t N1(ThreeTileOverlayView threeTileOverlayView, View view) {
        if (!threeTileOverlayView.pageResumed || threeTileOverlayView.artifactsActive) {
            view.setVisibility(8);
        }
        return Y8.t.f7040a;
    }

    private final boolean N3(float rawX, float rawY) {
        ConstraintLayout conLayoutInput = this.binding.conLayoutInput;
        kotlin.jvm.internal.p.h(conLayoutInput, "conLayoutInput");
        if (O3(rawX, rawY, conLayoutInput)) {
            return true;
        }
        if (this.binding.layoutSuggestions.getVisibility() == 0) {
            LinearLayout layoutSuggestions = this.binding.layoutSuggestions;
            kotlin.jvm.internal.p.h(layoutSuggestions, "layoutSuggestions");
            if (O3(rawX, rawY, layoutSuggestions)) {
                return true;
            }
        }
        if (this.binding.btnAllTasks.getVisibility() != 0) {
            return false;
        }
        LinearLayout btnAllTasks = this.binding.btnAllTasks;
        kotlin.jvm.internal.p.h(btnAllTasks, "btnAllTasks");
        return O3(rawX, rawY, btnAllTasks);
    }

    public static final void N5(ThreeTileOverlayView threeTileOverlayView, String str, View view) {
        kotlin.jvm.internal.p.f(view);
        threeTileOverlayView.p4(view);
        threeTileOverlayView.k4(2, R$string.three_tile_suggest_trips, str);
    }

    private final boolean O3(float rawX, float rawY, View target) {
        if (target.getVisibility() == 0 && target.getWidth() > 0 && target.getHeight() > 0) {
            int[] iArr = new int[2];
            target.getLocationOnScreen(iArr);
            if (rawX >= iArr[0] && rawX <= r1 + target.getWidth()) {
                if (rawY >= iArr[1] && rawY <= r3 + target.getHeight()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ void P4(ThreeTileOverlayView threeTileOverlayView, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0 && (str2 = threeTileOverlayView.analyticsResizeTrigger) == null) {
            str2 = ChatTracker.TRIGGER_DRAG;
        }
        if ((i10 & 4) != 0 && (str3 = threeTileOverlayView.analyticsOpenTriggerSource) == null) {
            str3 = ChatTracker.OPEN_DESKTOP_CARD;
        }
        threeTileOverlayView.O4(str, str2, str3);
    }

    private final float Q2(View view) {
        return view.getHeight() <= 0 ? CHIP_CORNER_DP : (Math.min(view.getWidth(), r0) / 2.0f) / getResources().getDisplayMetrics().density;
    }

    private final void R3(String triggerSource) {
        this.analyticsOpenTriggerSource = triggerSource;
    }

    private final void S3(String triggerSource) {
        this.analyticsResizeTrigger = triggerSource;
    }

    public static /* synthetic */ void U4(ThreeTileOverlayView threeTileOverlayView, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        threeTileOverlayView.T4(str, z10);
    }

    public static /* synthetic */ void V1(ThreeTileOverlayView threeTileOverlayView, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = com.stepos.ailauncher.container.wallpaper.c.INSTANCE.c();
        }
        threeTileOverlayView.U1(i10);
    }

    public static /* synthetic */ void V2(ThreeTileOverlayView threeTileOverlayView, boolean z10, boolean z11, b bVar, int i10, Object obj) throws Resources.NotFoundException {
        if ((i10 & 4) != 0) {
            bVar = null;
        }
        threeTileOverlayView.U2(z10, z11, bVar);
    }

    public static final boolean W2(ThreeTileOverlayView threeTileOverlayView) {
        return threeTileOverlayView.isAttachedToWindow();
    }

    public static final Y8.t X2(ThreeTileOverlayView threeTileOverlayView, boolean z10, b bVar) {
        threeTileOverlayView.sysUiClosePending = false;
        threeTileOverlayView.sysUiCloseRunnable = null;
        threeTileOverlayView.collapsingAfterSysUiAlign = true;
        try {
            try {
                threeTileOverlayView.U2(z10, true, bVar);
            } catch (Exception e10) {
                if (bVar == null) {
                    throw e10;
                }
                C4148a.u(TAG, "group collapse failed: " + e10.getMessage(), false, 4, null);
                InterfaceC5063a<Y8.t> interfaceC5063aE = bVar.e();
                if (interfaceC5063aE != null) {
                    interfaceC5063aE.invoke();
                }
            }
            return Y8.t.f7040a;
        } finally {
            threeTileOverlayView.collapsingAfterSysUiAlign = false;
        }
    }

    private final void X3() {
        Ua.M m10 = this.pageScope;
        if (m10 != null) {
            C1060i.d(m10, null, null, new ThreeTileOverlayView$observeDialogImePin$1(this, null), 3, null);
        }
    }

    public static final Y8.t X4(ThreeTileOverlayView threeTileOverlayView) {
        threeTileOverlayView.binding.conLayoutInput.setAlpha(1.0f);
        HomeChatPagerView homeChatPagerView = threeTileOverlayView.pagerView;
        if (homeChatPagerView == null || !homeChatPagerView.Z()) {
            threeTileOverlayView.binding.conLayoutInput.setTranslationX(r2.b().getWidth());
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t Y2(final ThreeTileOverlayView threeTileOverlayView, final long j10, boolean z10, Ref$BooleanRef ref$BooleanRef, b bVar) {
        if (!threeTileOverlayView.panelShown && j10 == threeTileOverlayView.panelTransitionSeq) {
            threeTileOverlayView.w3();
            if (z10 && !ref$BooleanRef.f34815a) {
                final E e10 = threeTileOverlayView.sheetHostRoot;
                if (bVar == null && e10 != null) {
                    e10.post(new Runnable() { // from class: com.stepos.ailauncher.task.space.B2
                        @Override // java.lang.Runnable
                        public final void run() {
                            ThreeTileOverlayView.Z2(e10, threeTileOverlayView, j10);
                        }
                    });
                } else {
                    threeTileOverlayView.L1();
                }
            }
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void Z1(ThreeTileOverlayView threeTileOverlayView, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        threeTileOverlayView.Y1(z10);
    }

    public static final void Z2(E e10, ThreeTileOverlayView threeTileOverlayView, long j10) {
        if (e10.isAttachedToWindow() && !threeTileOverlayView.panelShown && j10 == threeTileOverlayView.panelTransitionSeq) {
            threeTileOverlayView.L1();
        }
    }

    private final void a2(boolean show) {
        final View view = this.recordingScrimView;
        if (view == null) {
            if (!show) {
                return;
            }
            view = new View(getContext());
            view.setBackgroundResource(com.stepos.ailauncher.chat.R$drawable.bg_recording_bottom_scrim);
            view.setClickable(false);
            view.setFocusable(false);
            view.setVisibility(8);
            ConstraintLayout.b bVar = new ConstraintLayout.b(-1, (int) (view.getResources().getDisplayMetrics().heightPixels * 0.5f));
            bVar.f12648l = 0;
            bVar.f12664t = 0;
            bVar.f12668v = 0;
            view.setLayoutParams(bVar);
            this.recordingScrimView = view;
            this.binding.b().addView(view, this.binding.b().indexOfChild(this.binding.conLayoutInput));
        }
        view.animate().cancel();
        if (!show) {
            view.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.task.space.g2
                @Override // java.lang.Runnable
                public final void run() {
                    ThreeTileOverlayView.b2(view);
                }
            }).start();
            return;
        }
        view.setAlpha(0.0f);
        view.setVisibility(0);
        view.animate().alpha(1.0f).setDuration(200L).start();
    }

    public static final Y8.t a3(ThreeTileOverlayView threeTileOverlayView, View view, float f10, float f11, float f12) {
        threeTileOverlayView.T3(f12);
        if (view != null) {
            view.setAlpha(f10 * (1.0f - f12));
        }
        threeTileOverlayView.binding.conLayoutInput.setAlpha(f11 + ((1.0f - f11) * f12));
        return Y8.t.f7040a;
    }

    public static final void a4(ThreeTileOverlayView threeTileOverlayView, View view) {
        threeTileOverlayView.l4();
    }

    public static final void b2(View view) {
        view.setVisibility(8);
    }

    public static final Y8.t b3(ThreeTileOverlayView threeTileOverlayView, View view, float f10, boolean z10, float f11) {
        threeTileOverlayView.T3(f11);
        if (view != null) {
            view.setAlpha(f10 * (1.0f - f11));
        }
        if (z10) {
            FrameLayout frameLayout = threeTileOverlayView.contentContainer;
            if (frameLayout != null) {
                frameLayout.setAlpha(com.stepos.ailauncher.sheet.a0.b(f11));
            }
        } else {
            ViewGroup viewGroup = threeTileOverlayView.sheetPanel;
            if (viewGroup != null) {
                int iH = C3436d.h(com.stepos.ailauncher.chat.wake.homebar.A.g());
                int iC = androidx.core.content.a.c(threeTileOverlayView.getContext(), R$color.ail_sheet_bg);
                float f12 = C3436d.f(f11);
                if (f12 > 0.0f) {
                    C3436d.q(viewGroup, C3436d.i(iC, iH, f12));
                }
            }
        }
        return Y8.t.f7040a;
    }

    public static final void b4(ThreeTileOverlayView threeTileOverlayView, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i11 != i15) {
            threeTileOverlayView.O1(threeTileOverlayView.keyboardHeightPx);
        }
    }

    public static final Y8.t c3(ThreeTileOverlayView threeTileOverlayView, long j10, boolean z10, Ref$BooleanRef ref$BooleanRef, boolean z11) {
        if (!threeTileOverlayView.panelShown && j10 == threeTileOverlayView.panelTransitionSeq) {
            if (z10 && !ref$BooleanRef.f34815a) {
                ref$BooleanRef.f34815a = true;
                threeTileOverlayView.L1();
            }
            if (!threeTileOverlayView.panelShown && j10 == threeTileOverlayView.panelTransitionSeq) {
                E e10 = threeTileOverlayView.sheetHostRoot;
                if (e10 != null) {
                    e10.setTouchPassthrough(true);
                }
                IOverlayPageHost iOverlayPageHost = threeTileOverlayView.overlayHost;
                if (iOverlayPageHost != null) {
                    iOverlayPageHost.setContentOwnsHorizontalGesture(false);
                }
                threeTileOverlayView.w4();
                C4148a.d(TAG, "collapsed to bar: release embedded sheet touch nineSplit=" + z11, false, 4, null);
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t c4(ThreeTileOverlayView threeTileOverlayView) throws Resources.NotFoundException {
        V2(threeTileOverlayView, true, true, null, 4, null);
        return Y8.t.f7040a;
    }

    public static final void c5(final int i10, final ThreeTileOverlayView threeTileOverlayView) {
        if (i10 != threeTileOverlayView.imeHideResetGeneration) {
            return;
        }
        threeTileOverlayView.binding.b().postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.task.space.r2
            @Override // java.lang.Runnable
            public final void run() {
                ThreeTileOverlayView.d5(i10, threeTileOverlayView);
            }
        });
    }

    public static final Y8.t d4(ThreeTileOverlayView threeTileOverlayView) {
        UnifiedChatHostView chatHost;
        LauncherChatLayout chatLayout;
        com.stepos.ailauncher.chat.tts.a.INSTANCE.x();
        HomeChatPagerView homeChatPagerView = threeTileOverlayView.pagerView;
        if (homeChatPagerView != null && (chatHost = homeChatPagerView.getChatHost()) != null && (chatLayout = chatHost.getChatLayout()) != null) {
            chatLayout.p7();
        }
        return Y8.t.f7040a;
    }

    public static final void d5(int i10, ThreeTileOverlayView threeTileOverlayView) {
        if (i10 == threeTileOverlayView.imeHideResetGeneration && threeTileOverlayView.imeHeightFromInsets == 0 && threeTileOverlayView.keyboardHeightPx > 0) {
            C4148a.k(TAG, "ime hide reset applied (no ime animation)", false, 4, null);
            threeTileOverlayView.R1(0);
        }
    }

    public static final androidx.core.view.a0 e2(ThreeTileOverlayView threeTileOverlayView, View view, androidx.core.view.a0 insets) {
        DraggableSheetLayout draggableSheetLayout;
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        t0.e eVarF2 = insets.f(a0.o.b());
        kotlin.jvm.internal.p.h(eVarF2, "getInsets(...)");
        int iF = C5685n.f(eVarF2.f41980d - eVarF.f41980d, 0);
        threeTileOverlayView.imeHeightFromInsets = iF;
        if (iF > 0) {
            threeTileOverlayView.imePeakHeightPx = Math.max(threeTileOverlayView.imePeakHeightPx, iF);
        }
        threeTileOverlayView.navBottomPx = eVarF.f41980d;
        threeTileOverlayView.statusBarTopPx = eVarF.f41978b;
        ConstraintLayout conLayoutInput = threeTileOverlayView.binding.conLayoutInput;
        kotlin.jvm.internal.p.h(conLayoutInput, "conLayoutInput");
        conLayoutInput.setPadding(conLayoutInput.getPaddingLeft(), conLayoutInput.getPaddingTop(), conLayoutInput.getPaddingRight(), eVarF.f41980d);
        threeTileOverlayView.E1();
        threeTileOverlayView.binding.btnAllTasks.setTranslationY((-eVarF.f41980d) - 2.0f);
        if (threeTileOverlayView.sheetReady && (draggableSheetLayout = threeTileOverlayView.sheetLayout) != null) {
            float f10 = threeTileOverlayView.getResources().getDisplayMetrics().heightPixels;
            if (f10 > 0.0f) {
                draggableSheetLayout.setFullTopRatio(Math.max(0.06f, (eVarF.f41978b / f10) + 0.02f));
            }
            draggableSheetLayout.setMinPanelTopForImePx(eVarF.f41978b);
        }
        if (iF == 0) {
            if (threeTileOverlayView.keyboardHeightPx > 0) {
                threeTileOverlayView.b5();
                return insets;
            }
            threeTileOverlayView.R1(0);
        }
        return insets;
    }

    public static final void e4(ThreeTileOverlayView threeTileOverlayView) {
        threeTileOverlayView.binding.layoutInputBarNew.td();
    }

    public static final void f4(ThreeTileOverlayView threeTileOverlayView) {
        threeTileOverlayView.binding.layoutInputBarNew.Y9();
    }

    public static final void f5(ThreeTileOverlayView threeTileOverlayView) {
        threeTileOverlayView.incomingVoiceWait = null;
        boolean z10 = threeTileOverlayView.pageResumed;
        boolean zZ3 = threeTileOverlayView.z3();
        int i10 = c.$EnumSwitchMapping$1[threeTileOverlayView.incomingVoiceHold.c(!z10, threeTileOverlayView.E5(), zZ3).ordinal()];
        if (i10 == 1) {
            InputViewManager.f1(InputViewManager.INSTANCE, null, 1, null);
            return;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            if (z10 || !zZ3) {
                return;
            }
            threeTileOverlayView.binding.layoutInputBarNew.y8();
        }
    }

    public static /* synthetic */ void g2(ThreeTileOverlayView threeTileOverlayView, View view, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = threeTileOverlayView.R2(view);
        }
        threeTileOverlayView.f2(view, z10);
    }

    public static final void g4(ThreeTileOverlayView threeTileOverlayView) {
        U4(threeTileOverlayView, "pageResume", false, 2, null);
    }

    public static final void i2(ThreeTileOverlayView threeTileOverlayView, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return;
        }
        if (threeTileOverlayView.glassedViews.get(view) == null) {
            kotlin.jvm.internal.p.f(view);
            g2(threeTileOverlayView, view, false, 2, null);
        } else {
            if (i13 - i11 == i17 - i15) {
                return;
            }
            view.invalidateOutline();
            com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
            y7.E e10 = threeTileOverlayView.glassedViews.get(view);
            kotlin.jvm.internal.p.f(view);
            hVar.M(e10, threeTileOverlayView.Q2(view), view);
        }
    }

    public static final void i4(ThreeTileOverlayView threeTileOverlayView, Set it) {
        kotlin.jvm.internal.p.i(it, "it");
        threeTileOverlayView.J4();
    }

    public static final ChatRecycleView j5(ThreeTileOverlayView threeTileOverlayView) {
        UnifiedChatHostView chatHost;
        LauncherChatLayout chatLayout;
        HomeChatPagerView homeChatPagerView = threeTileOverlayView.pagerView;
        if (homeChatPagerView == null || (chatHost = homeChatPagerView.getChatHost()) == null || (chatLayout = chatHost.getChatLayout()) == null) {
            return null;
        }
        return chatLayout.getMessageList();
    }

    public static final RecordingPresentation k2() {
        return RecordingPresentation.INPUT_BAR;
    }

    public static /* synthetic */ void k3(ThreeTileOverlayView threeTileOverlayView, View view, float f10, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        if ((i10 & 16) != 0) {
            z12 = true;
        }
        threeTileOverlayView.j3(view, f10, z10, z11, z12);
    }

    public static final Boolean k5(ThreeTileOverlayView threeTileOverlayView, View target) {
        UnifiedChatHostView chatHost;
        LauncherChatLayout chatLayout;
        kotlin.jvm.internal.p.i(target, "target");
        HomeChatPagerView homeChatPagerView = threeTileOverlayView.pagerView;
        if (homeChatPagerView == null || (chatHost = homeChatPagerView.getChatHost()) == null || (chatLayout = chatHost.getChatLayout()) == null || target != chatLayout.getMessageList()) {
            return null;
        }
        return Boolean.valueOf(chatLayout.v8());
    }

    public static final Y8.t l2(ThreeTileOverlayView threeTileOverlayView, HomeChatPagerView homeChatPagerView, int i10, boolean z10) {
        int iF = C5685n.f(i10 - threeTileOverlayView.navBottomPx, 0);
        threeTileOverlayView.imeHeightFromInsets = iF;
        if (!threeTileOverlayView.imePinnedByDialog) {
            threeTileOverlayView.R1(iF);
        }
        homeChatPagerView.getChatHost().getChatLayout().C8(i10, z10);
        return Y8.t.f7040a;
    }

    public static final Y8.t m2(ThreeTileOverlayView threeTileOverlayView, boolean z10) {
        threeTileOverlayView.isExternalSession = z10;
        threeTileOverlayView.K1();
        return Y8.t.f7040a;
    }

    private final void m5() {
        View view = this.dimView;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setAlpha(0.0f);
        view.setBackgroundColor(-16777216);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.s3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws Resources.NotFoundException {
                ThreeTileOverlayView.n5(this.f29111a, view2);
            }
        });
    }

    public static final Y8.t n2(ThreeTileOverlayView threeTileOverlayView, boolean z10) {
        threeTileOverlayView.artifactsActive = z10;
        threeTileOverlayView.A5();
        threeTileOverlayView.M1();
        return Y8.t.f7040a;
    }

    public static final void n5(ThreeTileOverlayView threeTileOverlayView, View view) throws Resources.NotFoundException {
        V2(threeTileOverlayView, true, true, null, 4, null);
    }

    public static final Y8.t o2(ThreeTileOverlayView threeTileOverlayView, float f10) {
        if (!threeTileOverlayView.inputBarSlideHeld) {
            threeTileOverlayView.binding.conLayoutInput.setTranslationX(threeTileOverlayView.panelShown ? r0.getWidth() * (1.0f - f10) : 0.0f);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t p2(ThreeTileOverlayView threeTileOverlayView) {
        threeTileOverlayView.binding.layoutInputBarNew.n6();
        return Y8.t.f7040a;
    }

    public static final Y8.t q2(ThreeTileOverlayView threeTileOverlayView) throws Resources.NotFoundException {
        threeTileOverlayView.W3();
        threeTileOverlayView.Z4();
        return Y8.t.f7040a;
    }

    public static final void q4(View view) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(CHIP_BOUNCE_UP_MS).setInterpolator(CHIP_BOUNCE_INTERPOLATOR).withEndAction(null).start();
    }

    public static final Y8.t r2(ThreeTileOverlayView threeTileOverlayView, boolean z10) {
        threeTileOverlayView.inputHasContent = z10;
        I1(threeTileOverlayView, false, 1, null);
        threeTileOverlayView.c2();
        threeTileOverlayView.K1();
        return Y8.t.f7040a;
    }

    public static final Y8.t s2(ThreeTileOverlayView threeTileOverlayView, String str) throws Resources.NotFoundException {
        if (threeTileOverlayView.panelShown) {
            threeTileOverlayView.Z4();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t s4(View view, float f10) {
        if (view != null) {
            view.setAlpha(f10 * 0.4f);
        }
        return Y8.t.f7040a;
    }

    public static final void s5(ThreeTileOverlayView threeTileOverlayView, ImageView imageView) {
        threeTileOverlayView.imeGlowHiding = false;
        imageView.setAlpha(0.0f);
        if (imageView.getVisibility() != 4) {
            imageView.setVisibility(4);
        }
    }

    private final void setPanelShown(boolean z10) {
        this.panelTransitionSeq++;
        this.panelShown = z10;
        MinusOneHomeRoots.INSTANCE.f(z10);
        IOverlayPageHost iOverlayPageHost = this.overlayHost;
        if (iOverlayPageHost != null) {
            iOverlayPageHost.setEdgeBackGestureEnabled(z10);
        }
        if (z10) {
            IOverlayPageHost iOverlayPageHost2 = this.overlayHost;
            if (iOverlayPageHost2 != null) {
                iOverlayPageHost2.setContentOwnsHorizontalGesture(true);
            }
            this.collapseExposeWallpaperForInputBar = false;
            W1();
            o4(true);
        }
    }

    public static final boolean t2(LauncherChatLayout launcherChatLayout, ThreeTileOverlayView threeTileOverlayView, HomeInputView homeInputView) {
        AgentSession.AgentConversation agentConversationR1;
        com.stepos.ailauncher.chat.tts.a.INSTANCE.x();
        launcherChatLayout.p7();
        SessionHandler sessionHandler = threeTileOverlayView.sessionHandler;
        String strB = (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) ? null : agentConversationR1.B();
        ChatTracker.INSTANCE.a(strB, strB, null, ChatTracker.INTERRUPT_GENERATING_RESPONSE, null);
        BaseInputView.k6(homeInputView, false, false, 3, null);
        ChatStopActions.INSTANCE.e(threeTileOverlayView.sessionHandler);
        return false;
    }

    public static final Y8.t t4(LauncherChatLayout launcherChatLayout) {
        if (launcherChatLayout != null) {
            launcherChatLayout.s8(false);
        }
        return Y8.t.f7040a;
    }

    public static final boolean u2(LauncherChatLayout launcherChatLayout, HomeInputView homeInputView, ThreeTileOverlayView threeTileOverlayView) {
        return launcherChatLayout.isAttachedToWindow() && !homeInputView.a8() && threeTileOverlayView.panelShown;
    }

    public static final Y8.t u4(LauncherChatLayout launcherChatLayout) {
        if (launcherChatLayout != null) {
            launcherChatLayout.s8(false);
        }
        return Y8.t.f7040a;
    }

    public static final void u5(ConstraintLayout constraintLayout, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        constraintLayout.setAlpha(C5685n.m(f10, 0.0f, 1.0f));
    }

    public static final Y8.t v2(ThreeTileOverlayView threeTileOverlayView, HomeChatPagerView homeChatPagerView, boolean z10, int i10) {
        threeTileOverlayView.imeHideResetGeneration++;
        boolean z11 = z10 && !threeTileOverlayView.panelShown;
        threeTileOverlayView.imeRising = z11;
        if (z11) {
            threeTileOverlayView.W1();
        }
        if (threeTileOverlayView.panelShown && homeChatPagerView.Z()) {
            homeChatPagerView.getChatHost().getChatLayout().q5(z10);
            homeChatPagerView.getChatHost().getChatLayout().c9();
        }
        return Y8.t.f7040a;
    }

    public static final void v5(ThreeTileOverlayView threeTileOverlayView, ConstraintLayout constraintLayout, float f10, InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z10, float f11, float f12) {
        threeTileOverlayView.inputBarSlideHeld = false;
        if (z10) {
            return;
        }
        constraintLayout.setAlpha(f10);
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final Y8.t w2(HomeInputView homeInputView) {
        BaseInputView.k6(homeInputView, false, false, 3, null);
        return Y8.t.f7040a;
    }

    private final void x1() {
        View view = this.dragHandle;
        if (view == null) {
            Log.w("DragHandleAlpha", "ThreeTile.enter skip: null");
        } else {
            if (this.artifactsActive) {
                Log.i("DragHandleAlpha", "ThreeTile.enter skip artifacts=true");
                return;
            }
            view.setVisibility(0);
            L2("before:ThreeTile.enter");
            this.dragHandleAlphaAnim = C3440h.d(view, 0.34f, Float.valueOf(0.0f), false, null, "ThreeTile.enter", null, 88, null);
        }
    }

    public static final Y8.t x2(ThreeTileOverlayView threeTileOverlayView, boolean z10) {
        threeTileOverlayView.a2(z10);
        threeTileOverlayView.chatRecording = z10;
        I1(threeTileOverlayView, false, 1, null);
        return Y8.t.f7040a;
    }

    public static final void x3(ThreeTileOverlayView threeTileOverlayView, View view) throws Resources.NotFoundException {
        V2(threeTileOverlayView, true, true, null, 4, null);
    }

    private final void y1() {
        View view = this.dragHandle;
        if (view == null) {
            Log.w("DragHandleAlpha", "ThreeTile.exit skip: null");
            return;
        }
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
            if (view.getAlpha() < 0.01f) {
                view.setAlpha(0.34f);
            }
            Log.i("DragHandleAlpha", "ThreeTile.exit force-VISIBLE alpha=" + view.getAlpha());
        }
        L2("before:ThreeTile.exit");
        this.dragHandleAlphaAnim = C3440h.d(view, 0.0f, null, false, null, "ThreeTile.exit", null, 92, null);
    }

    public static final Y8.t y2(ThreeTileOverlayView threeTileOverlayView, boolean z10) {
        threeTileOverlayView.a2(z10);
        threeTileOverlayView.chatRecording = z10;
        if (z10) {
            Animator animator = threeTileOverlayView.allTasksEntryAnimator;
            if (animator != null) {
                animator.cancel();
            }
            threeTileOverlayView.allTasksEntryAnimator = null;
            threeTileOverlayView.allTasksLongPressFadeActive = threeTileOverlayView.binding.btnAllTasks.getVisibility() == 0;
        } else {
            threeTileOverlayView.allTasksLongPressFadeActive = false;
            threeTileOverlayView.binding.btnAllTasks.setAlpha(1.0f);
            threeTileOverlayView.allTasksTargetVisible = null;
            I1(threeTileOverlayView, false, 1, null);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t y3(ThreeTileOverlayView threeTileOverlayView, int i10) {
        threeTileOverlayView.U1(i10);
        return Y8.t.f7040a;
    }

    public static final void y4(ThreeTileOverlayView threeTileOverlayView) {
        if (threeTileOverlayView.H3()) {
            threeTileOverlayView.W1();
        }
    }

    public static final Y8.t z2(ThreeTileOverlayView threeTileOverlayView, float f10) {
        if (threeTileOverlayView.allTasksLongPressFadeActive) {
            threeTileOverlayView.binding.btnAllTasks.setAlpha(f10);
            if (f10 <= 0.0f) {
                threeTileOverlayView.allTasksLongPressFadeActive = false;
                threeTileOverlayView.v3();
            }
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void z5(ThreeTileOverlayView threeTileOverlayView, String str, int i10, Object obj) {
        AgentSession.AgentConversation agentConversationR1;
        if ((i10 & 1) != 0) {
            SessionHandler sessionHandler = threeTileOverlayView.sessionHandler;
            str = (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) ? null : agentConversationR1.B();
        }
        threeTileOverlayView.y5(str);
    }

    public final void A3() {
        this.binding.layoutInputBarNew.setOnAsrFinalizingChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.E2
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.B3(this.f28795a, ((Boolean) obj).booleanValue());
            }
        });
        this.binding.layoutInputBarNew.setAsrWaitingMessageListVisibilityProvider(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.F2
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(ThreeTileOverlayView.C3(this.f28798a));
            }
        });
        this.binding.homeInputThinkingStop.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.G2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ThreeTileOverlayView.D3(this.f28801a, view);
            }
        });
    }

    public final void A5() {
        HomeInputPresentationState.Presentation presentationC = this.inputPresentationState.c(InputViewManager.INSTANCE.y0() != null, this.artifactsActive);
        this.binding.conLayoutInput.setVisibility(presentationC.getVisible() ? 0 : 4);
        this.binding.layoutInputBarNew.setInputBarGlassSuspended(presentationC.getGlassSuspended());
    }

    public final void B1(final float to, boolean holdSlide, long startDelayMs, final InterfaceC5063a<Y8.t> onEnd) {
        P2();
        if (holdSlide) {
            this.inputBarSlideHeld = true;
        }
        if (startDelayMs <= 0) {
            t5(to, onEnd);
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.task.space.A2
            @Override // java.lang.Runnable
            public final void run() {
                ThreeTileOverlayView.D1(this.f28776a, to, onEnd);
            }
        };
        this.inputBarAlphaDelayRunnable = runnable;
        this.binding.conLayoutInput.postDelayed(runnable, startDelayMs);
    }

    public final void B4(DraggableSheetLayout sheet) {
        com.stepos.ailauncher.sheet.s0.INSTANCE.b(com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE).L(sheet, new ThreeTileOverlayView$pushMinusOneBase$1(this), new ThreeTileOverlayView$pushMinusOneBase$2(this));
    }

    public final void C4(boolean crossWindow) {
        if (this.panelShown) {
            return;
        }
        r6.s sVar = this.binding;
        for (LinearLayout linearLayout : C1173v.p(sVar.chipSuggest1, sVar.chipSuggest2, sVar.chipSuggest3)) {
            y7.E eRemove = this.glassedViews.remove(linearLayout);
            if (eRemove != null) {
                com.stepos.ailauncher.container.glass.h.INSTANCE.F(eRemove);
            }
            kotlin.jvm.internal.p.f(linearLayout);
            k3(this, linearLayout, Q2(linearLayout), crossWindow, true, false, 16, null);
        }
    }

    public final List<String> C5() {
        SessionHandler sessionHandler = this.sessionHandler;
        AgentSession.AgentConversation agentConversationR1 = sessionHandler != null ? sessionHandler.R1() : null;
        List listR = C1173v.r(agentConversationR1 != null ? agentConversationR1.B() : null, agentConversationR1 != null ? agentConversationR1.getSessionId() : null, agentConversationR1 != null ? agentConversationR1.getTempSessionId() : null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return Z8.F.g0(arrayList);
    }

    public final void E1() {
        int iN4;
        LinearLayout btnAllTasks = this.binding.btnAllTasks;
        kotlin.jvm.internal.p.h(btnAllTasks, "btnAllTasks");
        ViewGroup.LayoutParams layoutParams = btnAllTasks.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
        if (bVar == null || ((ViewGroup.MarginLayoutParams) bVar).bottomMargin == (iN4 = n4(ALL_TASKS_MARGIN_BOTTOM_DP))) {
            return;
        }
        ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = iN4;
        btnAllTasks.setLayoutParams(bVar);
    }

    public final boolean E3() {
        return F3(R4());
    }

    public final void E4() {
        y7.E eRemove = this.glassedViews.remove(this.binding.btnAllTasks);
        if (eRemove != null) {
            com.stepos.ailauncher.container.glass.h.INSTANCE.F(eRemove);
        }
    }

    public final boolean E5() {
        HomeInputView layoutInputBarNew = this.binding.layoutInputBarNew;
        kotlin.jvm.internal.p.h(layoutInputBarNew, "layoutInputBarNew");
        return layoutInputBarNew.a8() || layoutInputBarNew.getListenModeActive() || layoutInputBarNew.S7() || layoutInputBarNew.R7();
    }

    public final void F1() {
        this.binding.tvAllTask.setVisibility(u3() ? 8 : 0);
        G1();
        this.binding.btnAllTasks.invalidateOutline();
    }

    public final boolean F3(InputBarGlassPhase phase) {
        return phase != InputBarGlassPhase.DESKTOP ? p3(phase) : !e3();
    }

    public final void F4() {
        r6.s sVar = this.binding;
        Iterator it = C1173v.p(sVar.chipSuggest1, sVar.chipSuggest2, sVar.chipSuggest3, sVar.btnAllTasks).iterator();
        while (it.hasNext()) {
            y7.E eRemove = this.glassedViews.remove((LinearLayout) it.next());
            if (eRemove != null) {
                com.stepos.ailauncher.container.glass.h.INSTANCE.F(eRemove);
            }
        }
    }

    public final void G1() {
        LinearLayout btnAllTasks = this.binding.btnAllTasks;
        kotlin.jvm.internal.p.h(btnAllTasks, "btnAllTasks");
        boolean zU3 = u3();
        int iV1 = v1();
        int iU1 = u1();
        if (zU3) {
            btnAllTasks.setPadding(0, 0, 0, 0);
        } else {
            int iQ3 = Q3(12.0f);
            int iQ32 = Q3(6.0f);
            btnAllTasks.setPaddingRelative(iQ3, iQ32, iQ3, iQ32);
        }
        btnAllTasks.setMinimumWidth(iV1);
        btnAllTasks.setMinimumHeight(iU1);
        ViewGroup.LayoutParams layoutParams = btnAllTasks.getLayoutParams();
        if (!zU3) {
            iV1 = -2;
        }
        layoutParams.width = iV1;
        layoutParams.height = iU1;
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).bottomMargin = n4(ALL_TASKS_MARGIN_BOTTOM_DP);
        }
        btnAllTasks.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.binding.ivAllTasksChevron.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
        layoutParams3.width = w5(10.0f);
        layoutParams3.height = w5(14.0f);
        layoutParams3.setMarginStart(zU3 ? 0 : w5(4.0f));
        this.binding.ivAllTasksChevron.setLayoutParams(layoutParams3);
        TextView textView = this.binding.tvAllTask;
        ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams4, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) layoutParams4;
        layoutParams5.setMarginEnd(zU3 ? 0 : w5(-1.0f));
        textView.setLayoutParams(layoutParams5);
    }

    public final boolean G3(InputBarGlassPhase phase) {
        if (phase == InputBarGlassPhase.DESKTOP_IME) {
            return true;
        }
        if (phase != InputBarGlassPhase.DESKTOP) {
            return false;
        }
        return e3();
    }

    public final void G4(b motion) {
        DraggableSheetLayout draggableSheetLayout = this.sheetLayout;
        if (draggableSheetLayout != null) {
            draggableSheetLayout.n1();
            draggableSheetLayout.setBottomAnchorEnabled(motion.getAnchorEnabled());
            draggableSheetLayout.setDragEnabled(motion.getDragEnabled());
            draggableSheetLayout.setDismissEnabled(motion.getDismissEnabled());
        }
        this.embeddedGroupExit = null;
    }

    public final void H1(boolean animate) {
        boolean z10 = this.chatRecording;
        if (z10 && this.allTasksLongPressFadeActive) {
            return;
        }
        w1(this.allTasksEntryVisible && this.keyboardHeightPx <= 0 && !z10 && !this.inputHasContent, animate);
    }

    public final boolean H3() {
        return this.collapseExposeWallpaperForInputBar || J3();
    }

    public final void H4() {
        y7.E eRemove = this.glassedViews.remove(this.binding.tvGreeting);
        if (eRemove != null) {
            com.stepos.ailauncher.container.glass.h.INSTANCE.F(eRemove);
        }
        this.greetingGlassKeyboardUp = null;
    }

    public final void H5() {
        final String str = "desktop";
        this.binding.chipSuggest1.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.H2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ThreeTileOverlayView.I5(this.f28805a, str, view);
            }
        });
        this.binding.chipSuggest2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.I2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ThreeTileOverlayView.J5(this.f28811a, str, view);
            }
        });
        this.binding.chipSuggest3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.J2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ThreeTileOverlayView.K5(this.f28815a, str, view);
            }
        });
        final String str2 = "chatview";
        this.binding.chatRecommend1.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.K2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ThreeTileOverlayView.L5(this.f28828a, str2, view);
            }
        });
        this.binding.chatRecommend2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.L2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ThreeTileOverlayView.M5(this.f28834a, str2, view);
            }
        });
        this.binding.chatRecommend3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.M2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ThreeTileOverlayView.N5(this.f28841a, str2, view);
            }
        });
    }

    public final boolean I3() {
        HomeChatPagerView homeChatPagerView;
        return this.pageResumed && L3() && (homeChatPagerView = this.pagerView) != null && homeChatPagerView.Z() && !com.stepos.ailauncher.sheet.s0.INSTANCE.b(com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE).x();
    }

    public final void I4() {
        y7.E e10 = this.panelGlassHandle;
        if (e10 != null) {
            com.stepos.ailauncher.container.glass.h.INSTANCE.F(e10);
        }
        this.panelGlassHandle = null;
        this.panelGlassStyle = null;
    }

    public final void J1() {
        LinearLayout chatRecommendChips = this.binding.chatRecommendChips;
        kotlin.jvm.internal.p.h(chatRecommendChips, "chatRecommendChips");
        if (chatRecommendChips.getVisibility() != 0) {
            chatRecommendChips.setTranslationY(0.0f);
            return;
        }
        DraggableSheetLayout draggableSheetLayout = this.sheetLayout;
        if (draggableSheetLayout == null) {
            return;
        }
        chatRecommendChips.setTranslationY(C5685n.e(draggableSheetLayout.getPanelTopPx() - draggableSheetLayout.J1(SheetSettleState.FULL), 0.0f));
    }

    public final void J2(List<RecommendCard> cards) {
        if (com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            List<RecommendCard> listC1 = Z8.F.c1(cards, new k());
            if (kotlin.jvm.internal.p.d(listC1, this.suggestCards)) {
                return;
            }
            this.suggestCards = listC1;
            r6.s sVar = this.binding;
            TextView textView = sVar.tvSuggest1;
            ImageView imageView = sVar.ivSuggest1;
            int i10 = R$drawable.ic_suggest_schedule;
            Triple triple = new Triple(textView, imageView, Integer.valueOf(i10));
            r6.s sVar2 = this.binding;
            TextView textView2 = sVar2.tvSuggest2;
            ImageView imageView2 = sVar2.ivSuggest2;
            int i11 = R$drawable.ic_suggest_bills;
            Triple triple2 = new Triple(textView2, imageView2, Integer.valueOf(i11));
            r6.s sVar3 = this.binding;
            TextView textView3 = sVar3.tvSuggest3;
            ImageView imageView3 = sVar3.ivSuggest3;
            int i12 = R$drawable.ic_suggest_trips;
            Triple triple3 = new Triple(textView3, imageView3, Integer.valueOf(i12));
            r6.s sVar4 = this.binding;
            Triple triple4 = new Triple(sVar4.tvChatRecommend1, sVar4.ivChatRecommend1, Integer.valueOf(i10));
            r6.s sVar5 = this.binding;
            Triple triple5 = new Triple(sVar5.tvChatRecommend2, sVar5.ivChatRecommend2, Integer.valueOf(i11));
            r6.s sVar6 = this.binding;
            int i13 = 0;
            for (Object obj : C1173v.p(triple, triple2, triple3, triple4, triple5, new Triple(sVar6.tvChatRecommend3, sVar6.ivChatRecommend3, Integer.valueOf(i12)))) {
                int i14 = i13 + 1;
                if (i13 < 0) {
                    C1173v.w();
                }
                Triple triple6 = (Triple) obj;
                Object objA = triple6.a();
                kotlin.jvm.internal.p.h(objA, "component1(...)");
                TextView textView4 = (TextView) objA;
                Object objB = triple6.b();
                kotlin.jvm.internal.p.h(objB, "component2(...)");
                ImageView imageView4 = (ImageView) objB;
                int iIntValue = ((Number) triple6.c()).intValue();
                RecommendCard recommendCard = (RecommendCard) Z8.F.t0(listC1, i13 % 3);
                if (recommendCard != null) {
                    String displayText = recommendCard.getDisplayText();
                    if (displayText != null) {
                        if (La.H.x0(displayText)) {
                            displayText = null;
                        }
                        if (displayText != null) {
                            textView4.setText(displayText);
                        }
                    }
                    String iconUrl = recommendCard.getIconUrl();
                    if (iconUrl != null) {
                        String str = La.H.x0(iconUrl) ? null : iconUrl;
                        if (str != null) {
                            coil.c cVarA = C5503a.a(imageView4.getContext());
                            g.a aVarR = new g.a(imageView4.getContext()).d(str).r(imageView4);
                            aVarR.a(false);
                            aVarR.k(iIntValue);
                            aVarR.g(iIntValue);
                            cVarA.c(aVarR.c());
                        }
                    }
                }
                i13 = i14;
            }
            V3();
            U3();
        }
    }

    public final boolean J3() {
        if (this.panelShown) {
            return false;
        }
        E e10 = this.sheetHostRoot;
        return e10 == null || e10.getVisibility() != 0;
    }

    public final void J4() {
        AgentSession.AgentConversation agentConversationR1;
        UnifiedChatHostView chatHost;
        UnifiedChatHostView chatHost2;
        LauncherChatLayout chatLayout;
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) {
            return;
        }
        List listR = C1173v.r(agentConversationR1.B(), agentConversationR1.getSessionId(), agentConversationR1.getTempSessionId());
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        List listG0 = Z8.F.g0(arrayList);
        if (listG0.isEmpty()) {
            return;
        }
        com.stepos.ailauncher.chat.manager.Q0 q02 = com.stepos.ailauncher.chat.manager.Q0.INSTANCE;
        List list = listG0;
        Long lG = q02.g(list);
        if (q02.h(list) || lG != null) {
            C4148a.k(TAG, "external edit hit -> reload messages keys=" + listG0, false, 4, null);
            if (lG != null) {
                long jLongValue = lG.longValue();
                HomeChatPagerView homeChatPagerView = this.pagerView;
                if (homeChatPagerView != null && (chatHost2 = homeChatPagerView.getChatHost()) != null && (chatLayout = chatHost2.getChatLayout()) != null) {
                    chatLayout.X7(jLongValue);
                }
            }
            HomeChatPagerView homeChatPagerView2 = this.pagerView;
            if (homeChatPagerView2 == null || (chatHost = homeChatPagerView2.getChatHost()) == null) {
                return;
            }
            chatHost.a1();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K1() {
        /*
            r4 = this;
            boolean r0 = r4.panelShown
            r1 = 0
            if (r0 == 0) goto L21
            com.stepos.ailauncher.sheet.widget.DraggableSheetLayout r0 = r4.sheetLayout
            if (r0 == 0) goto Le
            com.stepos.ailauncher.sheet.SheetSettleState r0 = r0.getSettleState()
            goto Lf
        Le:
            r0 = 0
        Lf:
            com.stepos.ailauncher.sheet.SheetSettleState r2 = com.stepos.ailauncher.sheet.SheetSettleState.FULL
            if (r0 != r2) goto L21
            boolean r0 = r4.chatConversationEmpty
            if (r0 == 0) goto L21
            boolean r0 = r4.inputHasContent
            if (r0 != 0) goto L21
            boolean r0 = r4.isExternalSession
            if (r0 != 0) goto L21
            r0 = 1
            goto L22
        L21:
            r0 = r1
        L22:
            r6.s r2 = r4.binding
            android.widget.LinearLayout r2 = r2.chatRecommendChips
            java.lang.String r3 = "chatRecommendChips"
            kotlin.jvm.internal.p.h(r2, r3)
            if (r0 == 0) goto L52
            int r0 = r2.getVisibility()
            if (r0 == 0) goto L36
            r2.setVisibility(r1)
        L36:
            boolean r0 = r2.isLaidOut()
            if (r0 == 0) goto L46
            boolean r0 = r2.isLayoutRequested()
            if (r0 != 0) goto L46
            I0(r4)
            goto L4e
        L46:
            com.stepos.ailauncher.task.space.ThreeTileOverlayView$f r0 = new com.stepos.ailauncher.task.space.ThreeTileOverlayView$f
            r0.<init>()
            r2.addOnLayoutChangeListener(r0)
        L4e:
            r4.U3()
            goto L5d
        L52:
            int r0 = r2.getVisibility()
            r1 = 8
            if (r0 == r1) goto L5d
            r2.setVisibility(r1)
        L5d:
            r4.J1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.ThreeTileOverlayView.K1():void");
    }

    public final boolean K2() {
        return this.sheetReady && com.stepos.ailauncher.container.m0.INSTANCE.h() && this.pageResumed && !com.stepos.ailauncher.sheet.s0.INSTANCE.b(com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE).x();
    }

    public final boolean K3(View chip) {
        r6.s sVar = this.binding;
        return chip == sVar.chipSuggest1 || chip == sVar.chipSuggest2 || chip == sVar.chipSuggest3;
    }

    public final void K4() {
        if (this.agentViewReported) {
            return;
        }
        this.agentViewReported = true;
        this.agentEnterElapsedMs = SystemClock.elapsedRealtime();
        com.stepos.ailauncher.chat.trace.d dVar = com.stepos.ailauncher.chat.trace.d.INSTANCE;
        dVar.a();
        Long lValueOf = Long.valueOf(this.traditionalEnterElapsedMs);
        Long lValueOf2 = null;
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            lValueOf2 = Long.valueOf((this.agentEnterElapsedMs - lValueOf.longValue()) / 1000);
        }
        dVar.g("agent", lValueOf2);
        V3();
    }

    public final void L1() {
        AgentSession.AgentConversation agentConversationR1;
        String agentId;
        AgentSession.AgentConversation agentConversationR12;
        SessionHandler sessionHandler = this.sessionHandler;
        String strB = (sessionHandler == null || (agentConversationR12 = sessionHandler.R1()) == null) ? null : agentConversationR12.B();
        SessionHandler sessionHandler2 = this.sessionHandler;
        String string = (sessionHandler2 == null || (agentConversationR1 = sessionHandler2.R1()) == null || (agentId = agentConversationR1.getAgentId()) == null) ? null : La.H.D1(agentId).toString();
        if (string == null) {
            string = "";
        }
        boolean z10 = string.length() > 0 && !PrimaryAgent.INSTANCE.a(string);
        C4148a.k("RestoreTrace", "applyCollapseReset: topSid=" + strB + " topAgent=" + string, false, 4, null);
        this.binding.layoutInputBarNew.d();
        HomeChatPagerView homeChatPagerView = this.pagerView;
        UnifiedChatHostView chatHost = homeChatPagerView != null ? homeChatPagerView.getChatHost() : null;
        LauncherChatLayout chatLayout = chatHost != null ? chatHost.getChatLayout() : null;
        if (chatLayout != null && chatLayout.l4()) {
            this.pendingFreshSessionAfterCollapse = true;
            this.pendingFreshSessionKeys = C5();
            this.freshSessionMintedForHome = false;
            C4148a.k("RestoreTrace", "applyCollapseReset: skip createNewChat (active send round) → pending fresh topSid=" + strB, false, 4, null);
            return;
        }
        if (this.freshSessionMintedForHome && ((chatLayout == null || chatLayout.Q4()) && !z10)) {
            C4148a.k(TAG, "applyCollapseReset: already on fresh empty session, skip createNewChat topSid=" + strB, false, 4, null);
            return;
        }
        if (chatHost != null) {
            AgentChatLayout.K3(chatHost.getChatLayout(), false, null, "", 2, null);
            UnifiedChatHostView.q1(chatHost, null, 1, null);
            this.freshSessionMintedForHome = true;
        }
        this.isExternalSession = false;
        S2();
    }

    public final boolean L3() {
        E e10;
        return isAttachedToWindow() && com.stepos.ailauncher.container.m0.INSTANCE.h() && this.panelShown && (e10 = this.sheetHostRoot) != null && e10.isShown() && getRootView().getAlpha() >= 0.08f && !this.sysUiClosePending && !RecentsWindowMonitor.INSTANCE.l();
    }

    public final void L4() {
        if (!com.stepos.ailauncher.container.m0.INSTANCE.h() && this.agentViewReported) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Long lValueOf = Long.valueOf(this.agentEnterElapsedMs);
            if (lValueOf.longValue() <= 0) {
                lValueOf = null;
            }
            Long lValueOf2 = lValueOf != null ? Long.valueOf((jElapsedRealtime - lValueOf.longValue()) / 1000) : null;
            com.stepos.ailauncher.chat.trace.d dVar = com.stepos.ailauncher.chat.trace.d.INSTANCE;
            dVar.g("app", lValueOf2);
            dVar.h();
            this.traditionalEnterElapsedMs = jElapsedRealtime;
            this.agentViewReported = false;
            this.suggestExposeReported = false;
            this.chatRecommendExposeReported = false;
            InputViewManager.INSTANCE.S0();
        }
    }

    public final void M1() {
        final View view;
        if (this.embeddedGroupExit == null && (view = this.dragHandle) != null) {
            if (!this.pageResumed || this.artifactsActive) {
                if (view.getVisibility() == 0 && view.getAlpha() >= 0.01f) {
                    this.dragHandleAlphaAnim = C3440h.d(view, 0.0f, null, false, null, "ThreeTile.visibility.fadeOut", new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.y2
                        @Override // p9.InterfaceC5063a
                        public final Object invoke() {
                            return ThreeTileOverlayView.N1(this.f29139a, view);
                        }
                    }, 28, null);
                    return;
                }
                L2("visibility.hide.already pageResumed=" + this.pageResumed + " artifacts=" + this.artifactsActive);
                view.setVisibility(8);
                view.setAlpha(0.0f);
                return;
            }
            view.setVisibility(0);
            E e10 = this.sheetHostRoot;
            if (e10 == null || e10.getVisibility() != 0) {
                L2("visibility.show.hostHidden");
                view.setAlpha(0.0f);
                Log.i("DragHandleAlpha", "ThreeTile.visibility hold alpha=0 (host hidden)");
                return;
            }
            androidx.dynamicanimation.animation.i iVar = this.dragHandleAlphaAnim;
            if (iVar == null || !iVar.i()) {
                float fM = C5685n.m(view.getAlpha(), 0.0f, 1.0f);
                if (fM >= 0.33f) {
                    C3440h.g(view, "ThreeTile.visibility.alreadyRest");
                    return;
                } else {
                    this.dragHandleAlphaAnim = C3440h.d(view, 0.34f, Float.valueOf(fM), false, null, "ThreeTile.visibility.fadeIn", null, 88, null);
                    return;
                }
            }
            Log.i("DragHandleAlpha", "ThreeTile.visibility keep-spring alpha=" + view.getAlpha());
        }
    }

    public final void M2() {
        Animator animator = this.exitColorAnim;
        if (animator != null) {
            animator.cancel();
        }
        this.exitColorAnim = null;
    }

    public final boolean M3() {
        E e10;
        DraggableSheetLayout draggableSheetLayout;
        return this.panelShown && (e10 = this.sheetHostRoot) != null && e10.isShown() && (draggableSheetLayout = this.sheetLayout) != null && !draggableSheetLayout.x0() && draggableSheetLayout.getHalfFullFraction() >= 0.99f;
    }

    public final void M4(String pageFrom) {
        int i10 = 0;
        while (i10 < 3) {
            com.stepos.ailauncher.chat.trace.d dVar = com.stepos.ailauncher.chat.trace.d.INSTANCE;
            RecommendCard recommendCard = (RecommendCard) Z8.F.t0(this.suggestCards, i10);
            i10++;
            dVar.d(recommendCard != null ? recommendCard.getId() : null, pageFrom, i10);
        }
    }

    public final void N2() {
        if (this.imeGlowHiding) {
            this.imeGlowHiding = false;
            this.binding.ivImeGlow.animate().withEndAction(null).cancel();
        }
    }

    public final void N4(String toStage, String triggerSource) {
        if (this.chatviewOpenReported || kotlin.jvm.internal.p.d(toStage, "close")) {
            return;
        }
        this.chatviewOpenReported = true;
        ChatTracker.INSTANCE.i(triggerSource, toStage);
    }

    public final void O1(int kb2) {
        float fI;
        int i10 = this.chipsToInputGapPx;
        C5659a c5659a = C5659a.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        int iA = i10 - c5659a.a(context, 32);
        if (this.panelShown || kb2 <= 0 || this.suppressGreetChipsLiftUntilKbZero) {
            fI = 0.0f;
        } else {
            int iF = this.imePeakHeightPx;
            if (iF <= 0) {
                Context context2 = getContext();
                kotlin.jvm.internal.p.h(context2, "getContext(...)");
                iF = C5685n.f(c5659a.a(context2, 300), 1);
            }
            fI = C5685n.i(this.binding.conLayoutInput.getTranslationY() + (iA * C5685n.m(kb2 / iF, 0.0f, 1.0f)), 0.0f);
        }
        int i11 = this.statusBarTopPx;
        kotlin.jvm.internal.p.h(getContext(), "getContext(...)");
        float fE = fI + C5685n.e((i11 + c5659a.a(r5, 24)) - (this.binding.tvGreeting.getTop() + fI), 0.0f);
        this.binding.tvGreeting.setTranslationY(fE);
        this.binding.layoutSuggestions.setTranslationY(fE);
        S1(kb2);
    }

    public final void O2() {
        Runnable runnable = this.incomingVoiceWait;
        if (runnable != null) {
            this.binding.layoutInputBarNew.removeCallbacks(runnable);
        }
        this.incomingVoiceWait = null;
    }

    public final void O4(String toStage, String triggerSource, String openTriggerSource) {
        String str = this.analyticsStage;
        this.analyticsResizeTrigger = null;
        if (kotlin.jvm.internal.p.d(str, toStage)) {
            N4(toStage, openTriggerSource);
            return;
        }
        ChatTracker.INSTANCE.B(d3(), str, toStage, triggerSource);
        this.analyticsStage = toStage;
        if (kotlin.jvm.internal.p.d(toStage, "close")) {
            this.chatviewOpenReported = false;
            this.analyticsOpenTriggerSource = null;
        }
        N4(toStage, openTriggerSource);
    }

    public final void P1() {
        SoftLightGreetingView tvGreeting = this.binding.tvGreeting;
        kotlin.jvm.internal.p.h(tvGreeting, "tvGreeting");
        if (!tvGreeting.isLaidOut() || tvGreeting.isLayoutRequested()) {
            tvGreeting.addOnLayoutChangeListener(new g());
        } else {
            l3();
        }
    }

    public final void P2() {
        Runnable runnable = this.inputBarAlphaDelayRunnable;
        if (runnable != null) {
            this.binding.conLayoutInput.removeCallbacks(runnable);
            this.inputBarAlphaDelayRunnable = null;
            this.inputBarSlideHeld = false;
        }
        androidx.dynamicanimation.animation.i iVar = this.inputBarAlphaAnim;
        if (iVar != null) {
            iVar.d();
        }
    }

    public final int P3() {
        return getResources().getDimensionPixelSize(R$dimen.ail_sheet_keyboard_gap);
    }

    public final void Q1() {
        l3();
    }

    public final int Q3(float dp) {
        return (int) (((getResources().getDisplayMetrics().heightPixels * dp) * LAUNCHER_DP_TO_PX_NUMERATOR) / LAUNCHER_DP_TO_PX_DENOMINATOR);
    }

    public final void Q4() {
        if (this.imeGlowHiding) {
            return;
        }
        ImageView ivImeGlow = this.binding.ivImeGlow;
        kotlin.jvm.internal.p.h(ivImeGlow, "ivImeGlow");
        if ((ivImeGlow.getVisibility() == 0 ? ivImeGlow.getAlpha() : 0.0f) > 0.05f) {
            r5();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R1(int r11) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.ThreeTileOverlayView.R1(int):void");
    }

    public final boolean R2(View chip) {
        if (kotlin.jvm.internal.p.d(chip, this.binding.chatRecommend1) || kotlin.jvm.internal.p.d(chip, this.binding.chatRecommend2) || kotlin.jvm.internal.p.d(chip, this.binding.chatRecommend3)) {
            return false;
        }
        return E3();
    }

    public final InputBarGlassPhase R4() {
        return !H3() ? InputBarGlassPhase.CHAT : (this.panelShown || this.keyboardHeightPx <= 0 || this.suppressGreetChipsLiftUntilKbZero || this.imeGlowHiding || !J3()) ? InputBarGlassPhase.DESKTOP : InputBarGlassPhase.DESKTOP_IME;
    }

    public final void S1(int kb2) {
        int iF = this.imePeakHeightPx;
        if (iF <= 0) {
            C5659a c5659a = C5659a.INSTANCE;
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            iF = C5685n.f(c5659a.a(context, 300), 1);
        }
        float fM = (this.panelShown || this.suppressGreetChipsLiftUntilKbZero || kb2 <= 0) ? 0.0f : C5685n.m(kb2 / iF, 0.0f, 1.0f);
        if (!this.imeGlowHiding) {
            T1(fM);
        } else if (fM > 0.0f) {
            N2();
            T1(fM);
        }
    }

    public final void S2() {
        this.pendingFreshSessionAfterCollapse = false;
        this.pendingFreshSessionKeys = C1173v.m();
    }

    public final void S4() {
        i3();
        l3();
        LinearLayout layoutSuggestions = this.binding.layoutSuggestions;
        kotlin.jvm.internal.p.h(layoutSuggestions, "layoutSuggestions");
        if (!layoutSuggestions.isLaidOut() || layoutSuggestions.isLayoutRequested()) {
            layoutSuggestions.addOnLayoutChangeListener(new n());
        } else if (!this.panelShown) {
            i3();
        }
        SoftLightGreetingView tvGreeting = this.binding.tvGreeting;
        kotlin.jvm.internal.p.h(tvGreeting, "tvGreeting");
        if (!tvGreeting.isLaidOut() || tvGreeting.isLayoutRequested()) {
            tvGreeting.addOnLayoutChangeListener(new o());
        } else {
            l3();
        }
    }

    public final void T1(float alpha) {
        ImageView ivImeGlow = this.binding.ivImeGlow;
        kotlin.jvm.internal.p.h(ivImeGlow, "ivImeGlow");
        if (alpha <= 0.0f) {
            ivImeGlow.setAlpha(0.0f);
            if (ivImeGlow.getVisibility() != 4) {
                ivImeGlow.setVisibility(4);
            }
        } else {
            V1(this, 0, 1, null);
            if (ivImeGlow.getVisibility() != 0) {
                ivImeGlow.setVisibility(0);
            }
            ivImeGlow.setAlpha(alpha);
        }
        W1();
    }

    public final void T2(View panel) {
        C3436d.g(panel);
        com.stepos.ailauncher.container.glass.h.INSTANCE.B(panel);
    }

    public final void T3(float progress) {
        if (this.collapseExposeWallpaperForInputBar || this.panelShown || progress < 0.78f) {
            return;
        }
        this.collapseExposeWallpaperForInputBar = true;
        W1();
    }

    public final void T4(String reason, boolean imeConfirmedGone) {
        int iF;
        if (this.sheetReady && this.panelShown && !this.imePinnedByDialog) {
            if (!imeConfirmedGone) {
                if (this.binding.layoutInputBarNew.hasFocus()) {
                    return;
                }
                androidx.core.view.a0 a0VarB = androidx.core.view.N.B(this.binding.b());
                if (a0VarB != null) {
                    iF = C5685n.f(a0VarB.f(a0.o.b()).f41980d - a0VarB.f(a0.o.g()).f41980d, 0);
                } else {
                    iF = this.imeHeightFromInsets;
                }
                if (iF > 0) {
                    return;
                }
            }
            this.imeHeightFromInsets = 0;
            DraggableSheetLayout draggableSheetLayout = this.sheetLayout;
            if (draggableSheetLayout == null) {
                return;
            }
            if (this.keyboardHeightPx <= 0 && draggableSheetLayout.getImeInsetPx() <= 0.5f) {
                draggableSheetLayout.d0();
                return;
            }
            C4148a.k(TAG, "restore sheet content height reason=" + reason + " kb=" + this.keyboardHeightPx + " inset=" + draggableSheetLayout.getImeInsetPx(), false, 4, null);
            R1(0);
        }
    }

    public final void U1(int color) {
        int iC = INSTANCE.c(color);
        if (this.imeGlowAppliedRes == iC) {
            return;
        }
        this.imeGlowAppliedRes = iC;
        this.binding.ivImeGlow.setImageResource(iC);
    }

    public final void U2(final boolean reset, boolean animate, final b groupMotion) throws Resources.NotFoundException {
        long j10;
        final View view;
        final float f10;
        final boolean z10;
        UnifiedChatHostView chatHost;
        LauncherChatLayout chatLayout;
        long jN3;
        HomeChatPagerView homeChatPagerView;
        UnifiedChatHostView chatHost2;
        InterfaceC5063a<Y8.t> interfaceC5063aE;
        final ThreeTileOverlayView threeTileOverlayView = this;
        InterfaceC5063a<Y8.t> interfaceC5063a = threeTileOverlayView.releaseCoveredPanelScrim;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        b bVar = threeTileOverlayView.embeddedGroupExit;
        if (bVar != null && groupMotion == null) {
            if (animate || bVar == null || (interfaceC5063aE = bVar.e()) == null) {
                return;
            }
            interfaceC5063aE.invoke();
            return;
        }
        if (threeTileOverlayView.panelShown && (homeChatPagerView = threeTileOverlayView.pagerView) != null && (chatHost2 = homeChatPagerView.getChatHost()) != null) {
            UnifiedChatHostView.i1(chatHost2, false, 1, null);
        }
        com.stepos.ailauncher.foundation.appui.card.provider.appauther.u.a(threeTileOverlayView.getRootView());
        if (animate && threeTileOverlayView.panelShown && !threeTileOverlayView.collapsingAfterSysUiAlign) {
            DraggableSheetLayout draggableSheetLayout = threeTileOverlayView.sheetLayout;
            boolean z11 = (draggableSheetLayout != null ? draggableSheetLayout.getSettleState() : null) == SheetSettleState.FULL;
            if (groupMotion != null) {
                jN3 = groupMotion.getDurationMs();
            } else if (z11) {
                DraggableSheetLayout draggableSheetLayout2 = threeTileOverlayView.sheetLayout;
                jN3 = draggableSheetLayout2 != null ? draggableSheetLayout2.f0() : 0L;
            } else {
                jN3 = threeTileOverlayView.n3();
            }
            DraggableSheetLayout draggableSheetLayout3 = threeTileOverlayView.sheetLayout;
            if (draggableSheetLayout3 == null || !draggableSheetLayout3.getDismissFromDragPending()) {
                if (threeTileOverlayView.sysUiClosePending) {
                    return;
                }
                threeTileOverlayView.sysUiClosePending = true;
                threeTileOverlayView.sysUiCloseRunnable = com.stepos.ailauncher.chat.wake.homebar.A.k(0L, jN3, 0L, false, !z11, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.l2
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return Boolean.valueOf(ThreeTileOverlayView.W2(this.f29055a));
                    }
                }, null, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.m2
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return ThreeTileOverlayView.X2(this.f29061a, reset, groupMotion);
                    }
                }, 69, null);
                return;
            }
            threeTileOverlayView.collapsingAfterSysUiAlign = true;
            try {
                threeTileOverlayView.U2(reset, true, groupMotion);
                threeTileOverlayView.collapsingAfterSysUiAlign = false;
                com.stepos.ailauncher.chat.wake.homebar.A.i(SystemClock.elapsedRealtime() + C5685n.g(jN3, 0L), 0L, 0L, 2, null);
                return;
            } catch (Throwable th) {
                threeTileOverlayView.collapsingAfterSysUiAlign = false;
                throw th;
            }
        }
        HomeChatPagerView homeChatPagerView2 = threeTileOverlayView.pagerView;
        if (homeChatPagerView2 != null) {
            homeChatPagerView2.U();
        }
        threeTileOverlayView.binding.layoutInputBarNew.n6();
        threeTileOverlayView.binding.layoutInputBarNew.j6(false, animate);
        threeTileOverlayView.f3("collapseChatPanel");
        HomeChatPagerView homeChatPagerView3 = threeTileOverlayView.pagerView;
        if (homeChatPagerView3 != null) {
            HomeChatPagerView.W(homeChatPagerView3, false, 1, null);
        }
        boolean z12 = threeTileOverlayView.panelShown;
        if (z12) {
            String str = threeTileOverlayView.analyticsResizeTrigger;
            if (str == null) {
                str = ChatTracker.TRIGGER_DOWNSLIDE;
            }
            P4(threeTileOverlayView, "close", str, null, 4, null);
        }
        if (reset) {
            threeTileOverlayView.binding.layoutInputBarNew.M5();
            threeTileOverlayView.collapseExposeWallpaperForInputBar = true;
        } else {
            threeTileOverlayView.collapseExposeWallpaperForInputBar = false;
        }
        threeTileOverlayView.setPanelShown(false);
        com.stepos.ailauncher.container.d0.INSTANCE.b(false);
        long j11 = threeTileOverlayView.panelTransitionSeq;
        if (reset) {
            threeTileOverlayView.W1();
            threeTileOverlayView.S4();
        }
        if (z12 && !animate) {
            com.stepos.ailauncher.chat.wake.homebar.A.i(0L, 0L, 0L, 7, null);
        }
        if (z12 && animate) {
            DraggableSheetLayout draggableSheetLayout4 = threeTileOverlayView.sheetLayout;
            if ((draggableSheetLayout4 != null ? draggableSheetLayout4.getSettleState() : null) == SheetSettleState.FULL) {
                com.stepos.ailauncher.chat.wake.homebar.g.INSTANCE.h();
            }
        }
        if (z12 && threeTileOverlayView.keyboardHeightPx > 0) {
            threeTileOverlayView.suppressGreetChipsLiftUntilKbZero = true;
        }
        HomeChatPagerView homeChatPagerView4 = threeTileOverlayView.pagerView;
        if (homeChatPagerView4 != null) {
            homeChatPagerView4.setPanelShown(false);
        }
        z5(threeTileOverlayView, null, 1, null);
        C c10 = threeTileOverlayView.chatInputComponent;
        if (c10 != null) {
            c10.g();
        }
        com.stepos.ailauncher.chat.tts.a.INSTANCE.x();
        HomeChatPagerView homeChatPagerView5 = threeTileOverlayView.pagerView;
        if (homeChatPagerView5 != null && (chatHost = homeChatPagerView5.getChatHost()) != null && (chatLayout = chatHost.getChatLayout()) != null) {
            chatLayout.p7();
        }
        DraggableSheetLayout draggableSheetLayout5 = threeTileOverlayView.sheetLayout;
        View view2 = threeTileOverlayView.dimView;
        if (animate && z12 && draggableSheetLayout5 != null) {
            if (view2 != null) {
                view2.setClickable(false);
            }
            if (view2 != null) {
                view2.setOnClickListener(null);
            }
            if (groupMotion == null) {
                threeTileOverlayView.y1();
            }
            float alpha = view2 != null ? view2.getAlpha() : 0.0f;
            boolean z13 = draggableSheetLayout5.getSettleState() == SheetSettleState.FULL;
            boolean z14 = threeTileOverlayView.binding.conLayoutInput.getTranslationX() == 0.0f;
            threeTileOverlayView.binding.conLayoutInput.setTranslationX(0.0f);
            if (!z14) {
                threeTileOverlayView.binding.conLayoutInput.setAlpha(0.0f);
            }
            if (groupMotion == null) {
                f10 = alpha;
                view = view2;
                j10 = j11;
                z10 = z13;
                C1(threeTileOverlayView, 1.0f, false, C5685n.g(threeTileOverlayView.m4(z13) - 400, 0L), null, 10, null);
            } else {
                j10 = j11;
                view = view2;
                f10 = alpha;
                z10 = z13;
            }
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            threeTileOverlayView = this;
            final long j12 = j10;
            InterfaceC5063a<Y8.t> interfaceC5063a2 = new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.n2
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ThreeTileOverlayView.Y2(this.f29071a, j12, reset, ref$BooleanRef, groupMotion);
                }
            };
            if (groupMotion != null) {
                final float alpha2 = threeTileOverlayView.binding.conLayoutInput.getAlpha();
                groupMotion.k(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.o2
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return ThreeTileOverlayView.a3(this.f29081a, view, f10, alpha2, ((Float) obj).floatValue());
                    }
                });
                groupMotion.j(interfaceC5063a2);
                InterfaceC5063a<Y8.t> interfaceC5063aH = groupMotion.h();
                if (interfaceC5063aH != null) {
                    interfaceC5063aH.invoke();
                }
            } else {
                com.stepos.ailauncher.sheet.i0 i0Var = com.stepos.ailauncher.sheet.i0.INSTANCE;
                SheetScaleMotion sheetScaleMotionR1 = draggableSheetLayout5.r1(i0Var.n());
                threeTileOverlayView.M2();
                if (z10) {
                    threeTileOverlayView.a5(true);
                }
                final long j13 = j10;
                final boolean z15 = z10;
                draggableSheetLayout5.a1(sheetScaleMotionR1.getCollapsedScale(), draggableSheetLayout5.getWidth() * sheetScaleMotionR1.getTravelWidthFraction(), z10 ? i0Var.o().getStiffness() : sheetScaleMotionR1.getOffset().getStiffness(), z10 ? i0Var.o().getDampingRatio() : sheetScaleMotionR1.getOffset().getDampingRatio(), z10 ? i0Var.p().getStiffness() : sheetScaleMotionR1.getScale().getStiffness(), z10 ? i0Var.p().getDampingRatio() : sheetScaleMotionR1.getScale().getDampingRatio(), sheetScaleMotionR1.getCollapsedScaleY(), z10 ? 2.0f : 0.0f, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.p2
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return ThreeTileOverlayView.b3(this.f29088a, view, f10, z10, ((Float) obj).floatValue());
                    }
                }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.q2
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return ThreeTileOverlayView.c3(this.f29098a, j13, reset, ref$BooleanRef, z15);
                    }
                }, interfaceC5063a2);
            }
        } else {
            if (reset) {
                threeTileOverlayView.L1();
            }
            threeTileOverlayView.w3();
        }
        threeTileOverlayView.O1(threeTileOverlayView.keyboardHeightPx);
        threeTileOverlayView.K1();
        z5(threeTileOverlayView, null, 1, null);
    }

    public final void U3() {
        HomeChatPagerView homeChatPagerView;
        if (this.chatRecommendExposeReported || this.binding.chatRecommendChips.getVisibility() != 0 || (homeChatPagerView = this.pagerView) == null || !homeChatPagerView.Z() || this.suggestCards.isEmpty()) {
            return;
        }
        this.chatRecommendExposeReported = true;
        M4("chatview");
    }

    public final void V3() {
        if (!this.suggestExposeReported && this.pageResumed && this.binding.layoutSuggestions.getVisibility() == 0 && !this.suggestCards.isEmpty()) {
            this.suggestExposeReported = true;
            M4("desktop");
        }
    }

    public final void V4() {
        ViewGroup viewGroup = this.sheetPanel;
        if (viewGroup == null) {
            return;
        }
        T2(viewGroup);
    }

    public final void W1() {
        InputBarGlassPhase inputBarGlassPhaseR4 = R4();
        boolean zF3 = F3(inputBarGlassPhaseR4);
        boolean zG3 = G3(inputBarGlassPhaseR4);
        InputBarGlassPhase inputBarGlassPhase = this.committedInputBarGlassPhase;
        HomeInputView layoutInputBarNew = this.binding.layoutInputBarNew;
        kotlin.jvm.internal.p.h(layoutInputBarNew, "layoutInputBarNew");
        boolean z10 = layoutInputBarNew.getInputBarGlassCrossWindow() != zF3;
        if (inputBarGlassPhase != inputBarGlassPhaseR4 || z10) {
            layoutInputBarNew.setInputBarGlassCrossWindow(zF3);
            boolean zG32 = inputBarGlassPhase != null ? G3(inputBarGlassPhase) : false;
            layoutInputBarNew.setDesktopKeyboardRaised(zG3);
            boolean z11 = inputBarGlassPhaseR4 == InputBarGlassPhase.DESKTOP_IME && inputBarGlassPhase != inputBarGlassPhaseR4;
            if ((inputBarGlassPhase == null || zG32 == zG3) && (inputBarGlassPhase == null || z10 || z11)) {
                layoutInputBarNew.H9();
            }
            if (z10 && inputBarGlassPhase != null) {
                C4(zF3);
            }
            this.committedInputBarGlassPhase = inputBarGlassPhaseR4;
        }
    }

    public final void W3() {
        AgentSession.AgentConversation agentConversationR1;
        if (this.pendingFreshSessionAfterCollapse) {
            HomeChatPagerView homeChatPagerView = this.pagerView;
            UnifiedChatHostView chatHost = homeChatPagerView != null ? homeChatPagerView.getChatHost() : null;
            LauncherChatLayout chatLayout = chatHost != null ? chatHost.getChatLayout() : null;
            if (chatHost == null || chatLayout == null) {
                C4148a.u(TAG, "maybeStartFreshAfterCollapse: no chatLayout, keep pending", false, 4, null);
                return;
            }
            SessionHandler sessionHandler = this.sessionHandler;
            String strB = (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) ? null : agentConversationR1.B();
            if (strB == null) {
                strB = "";
            }
            String str = strB;
            if (str.length() == 0) {
                S2();
                C4148a.k(TAG, "maybeStartFreshAfterCollapse: already empty session, clear pending", false, 4, null);
                return;
            }
            SessionHandler sessionHandler2 = this.sessionHandler;
            AgentSession.AgentConversation agentConversationR12 = sessionHandler2 != null ? sessionHandler2.R1() : null;
            if (agentConversationR12 != null) {
                List<String> list = this.pendingFreshSessionKeys;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (agentConversationR12.S((String) it.next())) {
                            if (chatLayout.l4()) {
                                com.stepos.ailauncher.chat.tts.a.INSTANCE.x();
                                chatLayout.p7();
                                ChatStopActions.INSTANCE.e(this.sessionHandler);
                                C4148a.k(TAG, "maybeStartFreshAfterCollapse: cancel in-flight before createNewChat top=" + str, false, 4, null);
                            }
                            AgentChatLayout.K3(chatLayout, false, null, "", 2, null);
                            UnifiedChatHostView.q1(chatHost, null, 1, null);
                            this.isExternalSession = false;
                            this.freshSessionMintedForHome = true;
                            S2();
                            C4148a.k(TAG, "maybeStartFreshAfterCollapse: createNewChat from=" + str, false, 4, null);
                            return;
                        }
                    }
                }
            }
            C4148a.k(TAG, "maybeStartFreshAfterCollapse: top changed since collapse pending=" + this.pendingFreshSessionKeys + " now=" + str + " → clear pending, keep session", false, 4, null);
            S2();
        }
    }

    public final void W4() {
        InterfaceC5063a<Y8.t> interfaceC5063aE;
        b bVar = this.embeddedGroupExit;
        if (bVar != null && (interfaceC5063aE = bVar.e()) != null) {
            interfaceC5063aE.invoke();
        }
        HomeChatPagerView homeChatPagerView = this.pagerView;
        if (homeChatPagerView == null) {
            return;
        }
        C c10 = this.chatInputComponent;
        if (c10 != null) {
            c10.h();
        }
        S3(ChatTracker.TRIGGER_UPSLIDE);
        R3(ChatTracker.OPEN_DESKTOP_CARD);
        if (this.panelShown) {
            C4148a.k(TAG, "riseForAllTasks: already shown → session center + settle FULL", false, 4, null);
            homeChatPagerView.q0(false);
            DraggableSheetLayout draggableSheetLayout = this.sheetLayout;
            if (draggableSheetLayout != null) {
                SheetSettleState settleState = draggableSheetLayout.getSettleState();
                SheetSettleState sheetSettleState = SheetSettleState.FULL;
                if (settleState != sheetSettleState) {
                    DraggableSheetLayout.y1(draggableSheetLayout, sheetSettleState, true, null, 4, null);
                }
            }
            z5(this, null, 1, null);
            return;
        }
        C4148a.k(TAG, "riseForAllTasks: open FULL session center", false, 4, null);
        DraggableSheetLayout draggableSheetLayout2 = this.sheetLayout;
        if (draggableSheetLayout2 == null) {
            return;
        }
        z4(draggableSheetLayout2);
        setPanelShown(true);
        draggableSheetLayout2.setDismissEnabled(true);
        draggableSheetLayout2.setHeightMode(SheetHeightMode.FULL_9);
        B4(draggableSheetLayout2);
        E e10 = this.sheetHostRoot;
        if (e10 != null) {
            e10.setVisibility(0);
        }
        m3();
        View view = this.dimView;
        if (view != null) {
            view.setVisibility(0);
        }
        this.binding.conLayoutInput.setTranslationX(0.0f);
        C1(this, 0.0f, true, 0L, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.t3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThreeTileOverlayView.X4(this.f29116a);
            }
        }, 4, null);
        homeChatPagerView.q0(false);
        x1();
        SheetSpring sheetSpringE = com.stepos.ailauncher.sheet.i0.INSTANCE.a().e(1.25f, 0.78f);
        DraggableSheetLayout.R0(draggableSheetLayout2, sheetSpringE.getStiffness(), sheetSpringE.getDampingRatio(), null, 4, null);
        homeChatPagerView.setPanelShown(true);
        O1(this.keyboardHeightPx);
        z5(this, null, 1, null);
    }

    public final void X1(boolean finalizing) {
        this.binding.homeInputThinkingBar.setVisibility(finalizing ? 0 : 8);
        this.binding.layoutInputBarNew.setVisibility(finalizing ? 4 : 0);
    }

    public final void Y1(boolean force) {
        DraggableSheetLayout draggableSheetLayout;
        ViewGroup viewGroup = this.sheetPanel;
        if (viewGroup == null || (draggableSheetLayout = this.sheetLayout) == null) {
            return;
        }
        float halfFullFraction = draggableSheetLayout.getHalfFullFraction();
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        Pair<Integer, Float> pairJ = hVar.J(halfFullFraction);
        int iIntValue = pairJ.a().intValue();
        float fFloatValue = pairJ.b().floatValue();
        if ((force || iIntValue != this.panelGlassTint || Math.abs(fFloatValue - this.panelGlassBlurPx) >= 0.5f) && this.panelGlassCommit.a(force)) {
            this.panelGlassTint = iIntValue;
            this.panelGlassBlurPx = fFloatValue;
            y7.E e10 = this.panelGlassHandle;
            y7.E eX = hVar.x(viewGroup, iIntValue, fFloatValue, true, Float.valueOf(28.0f));
            this.panelGlassHandle = eX;
            if (e10 != null && e10 != eX) {
                hVar.F(e10);
            }
            if (this.panelGlassHandle == null) {
                viewGroup.setBackgroundColor(1713118238);
            }
        }
    }

    public final void Y3() {
        Ua.M m10 = this.pageScope;
        if (m10 != null) {
            C1060i.d(m10, null, null, new ThreeTileOverlayView$observeSourcesPanelAutoDismiss$1(this, null), 3, null);
        }
        Ua.M m11 = this.pageScope;
        if (m11 != null) {
            C1060i.d(m11, null, null, new ThreeTileOverlayView$observeSourcesPanelAutoDismiss$2(this, null), 3, null);
        }
        Ua.M m12 = this.pageScope;
        if (m12 != null) {
            C1060i.d(m12, null, null, new ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3(this, null), 3, null);
        }
    }

    public final void Y4() {
        DraggableSheetLayout draggableSheetLayout;
        InterfaceC5063a<Y8.t> interfaceC5063aE;
        b bVar = this.embeddedGroupExit;
        if (bVar != null && (interfaceC5063aE = bVar.e()) != null) {
            interfaceC5063aE.invoke();
        }
        HomeChatPagerView homeChatPagerView = this.pagerView;
        if (homeChatPagerView == null || (draggableSheetLayout = this.sheetLayout) == null) {
            return;
        }
        C c10 = this.chatInputComponent;
        if (c10 != null) {
            c10.h();
        }
        S3(ChatTracker.TRIGGER_UPSLIDE);
        R3(ChatTracker.OPEN_DESKTOP_CARD);
        if (this.panelShown) {
            z4(draggableSheetLayout);
            HomeChatPagerView.o0(homeChatPagerView, false, 1, null);
            SheetSettleState settleState = draggableSheetLayout.getSettleState();
            SheetSettleState sheetSettleState = SheetSettleState.FULL;
            if (settleState != sheetSettleState) {
                DraggableSheetLayout.y1(draggableSheetLayout, sheetSettleState, true, null, 4, null);
            }
            z5(this, null, 1, null);
            return;
        }
        z4(draggableSheetLayout);
        setPanelShown(true);
        draggableSheetLayout.setDismissEnabled(true);
        draggableSheetLayout.setHeightMode(SheetHeightMode.FULL_9);
        B4(draggableSheetLayout);
        E e10 = this.sheetHostRoot;
        if (e10 != null) {
            e10.setVisibility(0);
        }
        m3();
        View view = this.dimView;
        if (view != null) {
            view.setVisibility(0);
        }
        homeChatPagerView.n0(false);
        homeChatPagerView.e0();
        this.binding.conLayoutInput.setTranslationX(0.0f);
        homeChatPagerView.getChatHost().getChatLayout().setAutomaticBottomScrollPaused(true);
        homeChatPagerView.setPanelShown(true);
        v4(draggableSheetLayout);
        O1(this.keyboardHeightPx);
        z5(this, null, 1, null);
    }

    public final void Z3() {
        Object objB;
        C3127h.INSTANCE.c();
        try {
            Result.Companion companion = Result.INSTANCE;
            getContext().sendBroadcast(new Intent(ACTION_OPEN_ALL_TASK_NOTIFY).setPackage("com.android.launcher3").addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "notify launcher OPEN_ALL_TASK_NOTIFY failed", thE, false, 8, null);
        }
    }

    public final void Z4() throws Resources.NotFoundException {
        InterfaceC5063a<Y8.t> interfaceC5063aE;
        b bVar = this.embeddedGroupExit;
        if (bVar != null && (interfaceC5063aE = bVar.e()) != null) {
            interfaceC5063aE.invoke();
        }
        HomeChatPagerView homeChatPagerView = this.pagerView;
        if (homeChatPagerView == null) {
            return;
        }
        C c10 = this.chatInputComponent;
        if (c10 != null) {
            c10.h();
        }
        S3(ChatTracker.TRIGGER_UPSLIDE);
        if (this.analyticsOpenTriggerSource == null) {
            R3("input");
        }
        if (this.panelShown) {
            C4148a.k(TAG, "riseForSend: already shown → showChatPage (keep current settle)", false, 4, null);
            HomeChatPagerView.o0(homeChatPagerView, false, 1, null);
            z5(this, null, 1, null);
            return;
        }
        C4148a.k(TAG, "riseForSend: open HALF chat page kb=" + this.keyboardHeightPx, false, 4, null);
        DraggableSheetLayout draggableSheetLayout = this.sheetLayout;
        if (draggableSheetLayout == null) {
            return;
        }
        Q4();
        this.holdHalfOverExistingIme = this.keyboardHeightPx > 0;
        z4(draggableSheetLayout);
        if (this.holdHalfOverExistingIme) {
            draggableSheetLayout.setImeInsetPx(0.0f);
        }
        setPanelShown(true);
        draggableSheetLayout.setDismissEnabled(true);
        draggableSheetLayout.setHeightMode(SheetHeightMode.HALF_EXPANDABLE);
        B4(draggableSheetLayout);
        E e10 = this.sheetHostRoot;
        if (e10 != null) {
            e10.setVisibility(0);
        }
        m3();
        View view = this.dimView;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.dimView;
        if (view2 != null) {
            view2.setAlpha(0.0f);
        }
        homeChatPagerView.n0(false);
        homeChatPagerView.e0();
        this.binding.conLayoutInput.setTranslationX(0.0f);
        r4(draggableSheetLayout);
        homeChatPagerView.setPanelShown(true);
        O1(this.keyboardHeightPx);
        z5(this, null, 1, null);
    }

    public final void a5(boolean nineSplit) {
        if (nineSplit) {
            q5(com.stepos.ailauncher.sheet.a0.a(m4(true)));
        }
    }

    public final void b5() {
        final int i10 = this.imeHideResetGeneration + 1;
        this.imeHideResetGeneration = i10;
        this.binding.b().postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.task.space.z3
            @Override // java.lang.Runnable
            public final void run() {
                ThreeTileOverlayView.c5(i10, this);
            }
        });
    }

    public final void c2() {
        LinearLayout layoutSuggestions = this.binding.layoutSuggestions;
        kotlin.jvm.internal.p.h(layoutSuggestions, "layoutSuggestions");
        layoutSuggestions.animate().cancel();
        if (this.inputHasContent) {
            layoutSuggestions.setVisibility(4);
            return;
        }
        layoutSuggestions.setAlpha(1.0f);
        layoutSuggestions.setVisibility(0);
        if (!this.panelShown) {
            if (!layoutSuggestions.isLaidOut() || layoutSuggestions.isLayoutRequested()) {
                layoutSuggestions.addOnLayoutChangeListener(new h());
            } else {
                i3();
            }
        }
        V3();
    }

    public final void d2() {
        androidx.core.view.N.u0(this.binding.b(), new androidx.core.view.A() { // from class: com.stepos.ailauncher.task.space.D2
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return ThreeTileOverlayView.e2(this.f28790a, view, a0Var);
            }
        });
        androidx.core.view.N.e0(this.binding.b());
    }

    public final String d3() {
        AgentSession.AgentConversation agentConversationR1;
        String strB;
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null || (strB = agentConversationR1.B()) == null || strB.length() <= 0) {
            return null;
        }
        return strB;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        if (this.embeddedGroupExit != null) {
            return true;
        }
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 0) {
            boolean zP5 = p5(ev);
            this.swallowingImeDismiss = zP5;
            if (zP5) {
                this.binding.layoutInputBarNew.n6();
                return true;
            }
        } else if (actionMasked == 1 || actionMasked == 3) {
            if (this.swallowingImeDismiss) {
                this.swallowingImeDismiss = false;
                return true;
            }
        } else if (this.swallowingImeDismiss) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    public final boolean e3() {
        if (this.panelShown) {
            return false;
        }
        return ((this.keyboardHeightPx <= 0 && !this.imeRising) || this.suppressGreetChipsLiftUntilKbZero || this.imeGlowHiding) ? false : true;
    }

    public final void e5() {
        O2();
        int i10 = c.$EnumSwitchMapping$1[this.incomingVoiceHold.a(com.stepos.ailauncher.container.m0.INSTANCE.h(), E5(), z3()).ordinal()];
        if (i10 == 1) {
            InputViewManager.f1(InputViewManager.INSTANCE, null, 1, null);
            return;
        }
        if (i10 == 2) {
            this.binding.layoutInputBarNew.y8();
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.task.space.P2
                @Override // java.lang.Runnable
                public final void run() {
                    ThreeTileOverlayView.f5(this.f28859a);
                }
            };
            this.incomingVoiceWait = runnable;
            this.binding.layoutInputBarNew.postDelayed(runnable, 400L);
        }
    }

    public final void f2(View chip, boolean crossWindow) {
        if (this.panelShown && K3(chip)) {
            return;
        }
        k3(this, chip, Q2(chip), crossWindow, true, false, 16, null);
    }

    public final void f3(String reason) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            C2069d0.INSTANCE.a();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, "dismissSourcesPanel(" + reason + ") failed: " + thE.getMessage(), false, 4, null);
        }
    }

    public final void g3() {
        if (this.panelShown) {
            return;
        }
        LinearLayout btnAllTasks = this.binding.btnAllTasks;
        kotlin.jvm.internal.p.h(btnAllTasks, "btnAllTasks");
        k3(this, btnAllTasks, btnAllTasks.getHeight() > 0 ? (Math.min(btnAllTasks.getWidth(), btnAllTasks.getHeight()) / 2.0f) / getResources().getDisplayMetrics().density : 13.0f, false, false, false, 12, null);
    }

    public final void g5(String text) {
        if (La.H.x0(text)) {
            return;
        }
        AuthManager authManager = AuthManager.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (AuthManager.O(authManager, context, true, false, 4, null)) {
            this.binding.layoutInputBarNew.E4(text);
        }
    }

    @Override // android.view.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    public final void h2(View chip) {
        chip.setOutlineProvider(new i());
        chip.setClipToOutline(true);
        chip.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.task.space.x2
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                ThreeTileOverlayView.i2(this.f29135a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
    }

    public final void h3() {
        LinearLayout chatRecommend1 = this.binding.chatRecommend1;
        kotlin.jvm.internal.p.h(chatRecommend1, "chatRecommend1");
        f2(chatRecommend1, false);
        LinearLayout chatRecommend2 = this.binding.chatRecommend2;
        kotlin.jvm.internal.p.h(chatRecommend2, "chatRecommend2");
        f2(chatRecommend2, false);
        LinearLayout chatRecommend3 = this.binding.chatRecommend3;
        kotlin.jvm.internal.p.h(chatRecommend3, "chatRecommend3");
        f2(chatRecommend3, false);
    }

    public final void h4() {
        E e10;
        View view;
        IOverlayPageHost iOverlayPageHost = this.overlayHost;
        if (iOverlayPageHost != null) {
            iOverlayPageHost.flushPendingPageResume();
        }
        if (!this.pageResumed) {
            onPageResume(OverlayPageResumeReason.OVERLAY_ACTIVITY_RESUME);
        }
        if (this.artifactsActive || (e10 = this.sheetHostRoot) == null || e10.getVisibility() != 0 || (view = this.dragHandle) == null) {
            return;
        }
        view.setVisibility(0);
        androidx.dynamicanimation.animation.i iVar = this.dragHandleAlphaAnim;
        if (iVar == null || !iVar.i() || view.getAlpha() >= 0.34f) {
            float fM = C5685n.m(view.getAlpha(), 0.0f, 1.0f);
            if (fM >= 0.33f) {
                return;
            }
            this.dragHandleAlphaAnim = C3440h.d(view, 0.34f, Float.valueOf(fM), false, null, "ThreeTile.stackReveal.fadeIn", null, 88, null);
        }
    }

    public final void h5() {
        LinearLayout btnAllTasks = this.binding.btnAllTasks;
        kotlin.jvm.internal.p.h(btnAllTasks, "btnAllTasks");
        btnAllTasks.setOutlineProvider(new q());
        btnAllTasks.setClipToOutline(true);
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void hideImeForHomeConsume() {
        if (this.binding.layoutInputBarNew.V6() || this.keyboardHeightPx <= 0 || this.imePinnedByDialog) {
            return;
        }
        z1("home-consume-no-window-focus");
    }

    public final void i3() {
        boolean zE3 = E3();
        LinearLayout chipSuggest1 = this.binding.chipSuggest1;
        kotlin.jvm.internal.p.h(chipSuggest1, "chipSuggest1");
        f2(chipSuggest1, zE3);
        LinearLayout chipSuggest2 = this.binding.chipSuggest2;
        kotlin.jvm.internal.p.h(chipSuggest2, "chipSuggest2");
        f2(chipSuggest2, zE3);
        LinearLayout chipSuggest3 = this.binding.chipSuggest3;
        kotlin.jvm.internal.p.h(chipSuggest3, "chipSuggest3");
        f2(chipSuggest3, zE3);
        g3();
    }

    public final void i5() {
        ConstraintLayout constraintLayoutB = this.binding.b();
        kotlin.jvm.internal.p.h(constraintLayoutB, "getRoot(...)");
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        E e10 = new E(context);
        LayoutInflater.from(getContext()).inflate(R$layout.ail_lite_sheet_host, (ViewGroup) e10, true);
        ConstraintLayout.b bVar = new ConstraintLayout.b(0, 0);
        bVar.f12642i = 0;
        bVar.f12648l = 0;
        bVar.f12664t = 0;
        bVar.f12668v = 0;
        e10.setLayoutParams(bVar);
        constraintLayoutB.addView(e10, constraintLayoutB.indexOfChild(this.binding.conLayoutInput));
        e10.setVisibility(4);
        this.sheetHostRoot = e10;
        DraggableSheetLayout draggableSheetLayout = (DraggableSheetLayout) e10.findViewById(R$id.ail_sheet_layout);
        this.sheetLayout = draggableSheetLayout;
        this.sheetPanel = (ViewGroup) e10.findViewById(R$id.ail_sheet_panel);
        FrameLayout frameLayout = (FrameLayout) e10.findViewById(R$id.ail_content_container);
        this.contentContainer = frameLayout;
        frameLayout.setPadding(0, 0, 0, frameLayout.getPaddingBottom());
        this.dimView = e10.findViewById(R$id.ail_dim_view);
        View viewFindViewById = e10.findViewById(R$id.ail_drag_handle);
        this.dragHandle = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setAlpha(0.0f);
        }
        Context context2 = getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        HomeChatPagerView homeChatPagerView = new HomeChatPagerView(context2, null, 0, 6, null);
        frameLayout.addView(homeChatPagerView, new FrameLayout.LayoutParams(-1, -1));
        this.pagerView = homeChatPagerView;
        draggableSheetLayout.setHeightMode(SheetHeightMode.HALF_EXPANDABLE);
        draggableSheetLayout.setAllowCollapseToHalf(true);
        draggableSheetLayout.setContentAnchorView(frameLayout);
        draggableSheetLayout.setBottomAnchorEnabled(true);
        draggableSheetLayout.setFreezeContentHeightOnFullDrag(true);
        draggableSheetLayout.setSealHorizontalGesture(true);
        draggableSheetLayout.setTopDragStripHeightPx(getResources().getDimensionPixelSize(R$dimen.ail_sheet_content_top_inset));
        draggableSheetLayout.setFullTopDragStripHeightPx(getResources().getDimensionPixelSize(R$dimen.ail_sheet_chat_full_top_drag_strip_height));
        draggableSheetLayout.setTouchScrollableContentProvider(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.v2
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThreeTileOverlayView.j5(this.f29126a);
            }
        });
        draggableSheetLayout.setHalfExpandContentAtBottom(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.w2
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.k5(this.f29131a, (View) obj);
            }
        });
        m5();
        draggableSheetLayout.setCallback(new r());
        ViewGroup viewGroup = this.sheetPanel;
        if (viewGroup != null) {
            com.stepos.ailauncher.container.glass.h.INSTANCE.k(viewGroup, 28.0f);
        }
        j2(homeChatPagerView);
        this.sheetReady = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j2(final HomeChatPagerView pager) {
        final HomeInputView layoutInputBarNew = this.binding.layoutInputBarNew;
        kotlin.jvm.internal.p.h(layoutInputBarNew, "layoutInputBarNew");
        layoutInputBarNew.setRecordingPresentationProvider(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.R2
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThreeTileOverlayView.k2();
            }
        });
        layoutInputBarNew.Yb();
        layoutInputBarNew.setInputBarGlassEnabled(true);
        layoutInputBarNew.setInputBarHeightBlurEnabled(true);
        layoutInputBarNew.setInputBarGlassCrossWindow(true);
        layoutInputBarNew.setInputBarGlassEffect(y7.o.INSTANCE.i());
        layoutInputBarNew.setOnImeInsetsFrame(new p9.p() { // from class: com.stepos.ailauncher.task.space.d3
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ThreeTileOverlayView.l2(this.f29017a, pager, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        });
        layoutInputBarNew.setOnImeAnimationStart(new p9.p() { // from class: com.stepos.ailauncher.task.space.k3
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ThreeTileOverlayView.v2(this.f29051a, pager, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
            }
        });
        layoutInputBarNew.setOnImeAnimationEnd(new p9.p() { // from class: com.stepos.ailauncher.task.space.l3
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ThreeTileOverlayView.C2(this.f29056a, pager, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
            }
        });
        SessionHandler sessionHandlerM = AgentConfig.INSTANCE.a().m();
        this.sessionHandler = sessionHandlerM;
        pager.getChatHost().setOnEmptyStateChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.m3
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.D2(this.f29064a, ((Boolean) obj).booleanValue());
            }
        });
        pager.getChatHost().setOnConversationChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.n3
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.E2(this.f29076a, (String) obj);
            }
        });
        pager.setOnSettledPageChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.o3
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.F2(this.f29085a, ((Boolean) obj).booleanValue());
            }
        });
        pager.setOnSessionSearchActiveChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.p3
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.G2(this.f29092a, ((Boolean) obj).booleanValue());
            }
        });
        pager.setOnCloseRequested(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.q3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThreeTileOverlayView.H2(this.f29103a);
            }
        });
        pager.setOnConversationSwitch(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.r3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThreeTileOverlayView.I2(layoutInputBarNew, this);
            }
        });
        pager.setOnExternalSessionChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.S2
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.m2(this.f28873a, ((Boolean) obj).booleanValue());
            }
        });
        pager.setOnArtifactsModeChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.T2
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.n2(this.f28880a, ((Boolean) obj).booleanValue());
            }
        });
        pager.setOnPagerFraction(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.U2
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.o2(this.f28885a, ((Float) obj).floatValue());
            }
        });
        pager.setOnLeaveChatPage(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.V2
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThreeTileOverlayView.p2(this.f28893a);
            }
        });
        DraggableSheetLayout draggableSheetLayout = this.sheetLayout;
        SpectrumBorderConfig spectrumBorderConfig = null;
        Object[] objArr = 0;
        if (draggableSheetLayout != null) {
            LauncherChatLayout chatLayout = pager.getChatHost().getChatLayout();
            chatLayout.setAutomaticBottomScrollPaused(draggableSheetLayout.getScaleEnterRunning().getValue().booleanValue());
            Ua.M m10 = this.pageScope;
            if (m10 != null) {
                C1060i.d(m10, null, null, new ThreeTileOverlayView$bindEmbeddedChat$15$1(draggableSheetLayout, chatLayout, null), 3, null);
            }
        }
        View conLayoutInput = this.binding.conLayoutInput;
        kotlin.jvm.internal.p.h(conLayoutInput, "conLayoutInput");
        pager.C(this, sessionHandlerM, layoutInputBarNew, conLayoutInput);
        z5(this, null, 1, null);
        final LauncherChatLayout chatLayout2 = pager.getChatHost().getChatLayout();
        C c10 = new C(layoutInputBarNew);
        this.chatInputComponent = c10;
        chatLayout2.m3(c10);
        layoutInputBarNew.b(sessionHandlerM);
        layoutInputBarNew.setOnSendInitiated(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.W2
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThreeTileOverlayView.q2(this.f28895a);
            }
        });
        layoutInputBarNew.setOnInputContentChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.X2
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.r2(this.f28897a, ((Boolean) obj).booleanValue());
            }
        });
        layoutInputBarNew.setOnWakeSwitchToChatPage(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.Z2
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.s2(this.f28908a, (String) obj);
            }
        });
        layoutInputBarNew.setOnStopClicked(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.a3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(ThreeTileOverlayView.t2(chatLayout2, this, layoutInputBarNew));
            }
        });
        layoutInputBarNew.setActiveArtifactFlow(null);
        chatLayout2.setCanPlayTTS(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.b3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(ThreeTileOverlayView.u2(chatLayout2, layoutInputBarNew, this));
            }
        });
        chatLayout2.setOnRoundUnsuccessfulListener(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.c3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThreeTileOverlayView.w2(layoutInputBarNew);
            }
        });
        layoutInputBarNew.setOnSpeechPopupShown(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.e3
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.x2(this.f29021a, ((Boolean) obj).booleanValue());
            }
        });
        layoutInputBarNew.setOnVoiceLongPressVisualChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.f3
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.y2(this.f29028a, ((Boolean) obj).booleanValue());
            }
        });
        layoutInputBarNew.setOnVoiceLongPressOutgoingAlphaChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.g3
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.z2(this.f29031a, ((Float) obj).floatValue());
            }
        });
        com.stepos.ailauncher.chat.wake.effect.c cVar = this.recordingSpectrum;
        if (cVar != null) {
            cVar.h();
        }
        ConstraintLayout constraintLayoutB = this.binding.b();
        kotlin.jvm.internal.p.h(constraintLayoutB, "getRoot(...)");
        com.stepos.ailauncher.chat.wake.effect.c cVar2 = new com.stepos.ailauncher.chat.wake.effect.c(constraintLayoutB, spectrumBorderConfig, 2, objArr == true ? 1 : 0);
        cVar2.d(layoutInputBarNew);
        this.recordingSpectrum = cVar2;
        c10.g();
        layoutInputBarNew.td();
        com.stepos.ailauncher.container.o0.INSTANCE.a(new o0.a() { // from class: com.stepos.ailauncher.task.space.h3
            @Override // com.stepos.ailauncher.container.o0.a
            public final boolean a(String str, String str2) {
                return ThreeTileOverlayView.A2(this.f29036a, str, str2);
            }
        });
        com.stepos.ailauncher.container.l0.INSTANCE.j(new j());
        pager.setOnConversationChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.i3
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.B2(layoutInputBarNew, this, (String) obj);
            }
        });
    }

    public final void j3(View view, float cornerRadiusDp, boolean crossWindow, boolean clearXmlFallback, boolean innerShadow) {
        if (this.glassedViews.containsKey(view) || view.getVisibility() != 0 || view.getWidth() == 0) {
            return;
        }
        if (clearXmlFallback) {
            view.setBackground(null);
        }
        y7.E eL = com.stepos.ailauncher.container.glass.h.INSTANCE.l(view, crossWindow, Float.valueOf(cornerRadiusDp), y7.o.INSTANCE.i(), innerShadow);
        if (eL != null) {
            this.glassedViews.put(view, eL);
        }
    }

    public final void j4(boolean covered) {
        HomeChatPagerView homeChatPagerView;
        UnifiedChatHostView chatHost;
        LauncherChatLayout chatLayout;
        this.inputPresentationState.b(covered);
        A5();
        FrameLayout frameLayout = this.contentContainer;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(covered ? 4 : 0);
        if (!covered || (homeChatPagerView = this.pagerView) == null || (chatHost = homeChatPagerView.getChatHost()) == null || (chatLayout = chatHost.getChatLayout()) == null) {
            return;
        }
        chatLayout.p7();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k4(int r5, int r6, java.lang.String r7) {
        /*
            r4 = this;
            com.stepos.ailauncher.chat.trace.d r0 = com.stepos.ailauncher.chat.trace.d.INSTANCE
            java.util.List<com.stepos.ailauncher.network.model.RecommendCard> r1 = r4.suggestCards
            java.lang.Object r1 = Z8.F.t0(r1, r5)
            com.stepos.ailauncher.network.model.RecommendCard r1 = (com.stepos.ailauncher.network.model.RecommendCard) r1
            r2 = 0
            if (r1 == 0) goto L12
            java.lang.String r1 = r1.getId()
            goto L13
        L12:
            r1 = r2
        L13:
            int r3 = r5 + 1
            r0.c(r1, r7, r3)
            java.util.List<com.stepos.ailauncher.network.model.RecommendCard> r7 = r4.suggestCards
            java.lang.Object r5 = Z8.F.t0(r7, r5)
            com.stepos.ailauncher.network.model.RecommendCard r5 = (com.stepos.ailauncher.network.model.RecommendCard) r5
            if (r5 == 0) goto L31
            java.lang.String r5 = r5.getPrompt()
            if (r5 == 0) goto L31
            boolean r7 = La.H.x0(r5)
            if (r7 != 0) goto L2f
            r2 = r5
        L2f:
            if (r2 != 0) goto L3e
        L31:
            android.content.Context r5 = r4.getContext()
            java.lang.String r2 = r5.getString(r6)
            java.lang.String r5 = "getString(...)"
            kotlin.jvm.internal.p.h(r2, r5)
        L3e:
            r4.Q4()
            r4.g5(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.ThreeTileOverlayView.k4(int, int, java.lang.String):void");
    }

    public final void l3() {
        if (M3()) {
            return;
        }
        SoftLightGreetingView tvGreeting = this.binding.tvGreeting;
        kotlin.jvm.internal.p.h(tvGreeting, "tvGreeting");
        boolean z10 = this.keyboardHeightPx > 0;
        if ((this.glassedViews.get(tvGreeting) == null || !kotlin.jvm.internal.p.d(this.greetingGlassKeyboardUp, Boolean.valueOf(z10))) && tvGreeting.getVisibility() == 0 && tvGreeting.getWidth() != 0) {
            y7.E eRemove = this.glassedViews.remove(tvGreeting);
            if (eRemove != null) {
                com.stepos.ailauncher.container.glass.h.INSTANCE.F(eRemove);
            }
            y7.E eQ = com.stepos.ailauncher.container.glass.h.INSTANCE.q(tvGreeting, true, z10);
            if (eQ == null) {
                this.greetingGlassKeyboardUp = null;
            } else {
                this.glassedViews.put(tvGreeting, eQ);
                this.greetingGlassKeyboardUp = Boolean.valueOf(z10);
            }
        }
    }

    public final void l4() {
        AuthManager authManager = AuthManager.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (AuthManager.O(authManager, context, true, false, 4, null)) {
            boolean z10 = this.panelShown;
            E e10 = this.sheetHostRoot;
            Boolean boolValueOf = e10 != null ? Boolean.valueOf(e10.isShown()) : null;
            DraggableSheetLayout draggableSheetLayout = this.sheetLayout;
            C4148a.k(TAG, "openAllTasks click: panelShown=" + z10 + " hostShown=" + boolValueOf + " settle=" + (draggableSheetLayout != null ? draggableSheetLayout.getSettleState() : null), false, 4, null);
            Z3();
            W4();
        }
    }

    public final void l5() {
        r6.s sVar = this.binding;
        for (LinearLayout linearLayout : C1173v.p(sVar.chipSuggest1, sVar.chipSuggest2, sVar.chipSuggest3, sVar.chatRecommend1, sVar.chatRecommend2, sVar.chatRecommend3)) {
            kotlin.jvm.internal.p.f(linearLayout);
            h2(linearLayout);
        }
    }

    public final void m3() {
        ViewGroup viewGroup = this.sheetPanel;
        if (viewGroup != null && viewGroup.isAttachedToWindow()) {
            SheetGlassStyle sheetGlassStyleO5 = o5();
            boolean z10 = this.panelGlassHandle == null;
            if (z10) {
                T2(viewGroup);
            } else {
                C3436d.g(viewGroup);
            }
            this.panelGlassStyle = sheetGlassStyleO5;
            Y1(z10);
        }
    }

    public final long m4(boolean nineSplit) {
        DraggableSheetLayout draggableSheetLayout = this.sheetLayout;
        if (draggableSheetLayout == null) {
            return 0L;
        }
        if (nineSplit) {
            return draggableSheetLayout.f0();
        }
        SheetScaleMotion sheetScaleMotionR1 = draggableSheetLayout.r1(com.stepos.ailauncher.sheet.i0.INSTANCE.n());
        return com.stepos.ailauncher.chat.wake.homebar.A.f(sheetScaleMotionR1.getOffset().getStiffness(), sheetScaleMotionR1.getOffset().getDampingRatio(), 0.0f, draggableSheetLayout.getWidth() * sheetScaleMotionR1.getTravelWidthFraction(), 0.0f, 16, null);
    }

    public final long n3() {
        DraggableSheetLayout draggableSheetLayout = this.sheetLayout;
        if (draggableSheetLayout == null) {
            return 0L;
        }
        SheetScaleMotion sheetScaleMotionR1 = draggableSheetLayout.r1(com.stepos.ailauncher.sheet.i0.INSTANCE.n());
        long jF = com.stepos.ailauncher.chat.wake.homebar.A.f(sheetScaleMotionR1.getOffset().getStiffness(), sheetScaleMotionR1.getOffset().getDampingRatio(), 0.0f, draggableSheetLayout.getWidth() * sheetScaleMotionR1.getTravelWidthFraction(), 0.0f, 16, null);
        float width = draggableSheetLayout.getWidth();
        return Math.max(jF, com.stepos.ailauncher.chat.wake.homebar.A.f(sheetScaleMotionR1.getScale().getStiffness(), sheetScaleMotionR1.getScale().getDampingRatio(), width, sheetScaleMotionR1.getCollapsedScale() * width, 0.0f, 16, null));
    }

    public final int n4(float dp) {
        return (int) (((dp * INSTANCE.d()) / com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME) + 0.5f);
    }

    public final void o3() {
        Ua.M m10;
        if (com.stepos.ailauncher.common.privacy.b.INSTANCE.b() && (m10 = this.pageScope) != null) {
            C1060i.d(m10, Ua.Y.b(), null, new ThreeTileOverlayView$fetchSuggestData$1(this, null), 2, null);
        }
    }

    public final void o4(boolean pin) {
        if (pin == this.desktopGreetingPinned) {
            return;
        }
        LinearLayout layoutSuggestions = this.binding.layoutSuggestions;
        kotlin.jvm.internal.p.h(layoutSuggestions, "layoutSuggestions");
        ViewGroup.LayoutParams layoutParams = layoutSuggestions.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
        if (bVar == null) {
            return;
        }
        if (pin) {
            int i10 = this.chipsToInputGapPx;
            C5659a c5659a = C5659a.INSTANCE;
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            int iA = i10 + c5659a.a(context, 73) + this.binding.conLayoutInput.getPaddingBottom();
            if (iA <= 0) {
                return;
            }
            bVar.f12646k = -1;
            bVar.f12648l = 0;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = iA;
        } else {
            bVar.f12648l = -1;
            bVar.f12646k = this.binding.conLayoutInput.getId();
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = this.chipsToInputGapPx;
        }
        layoutSuggestions.setLayoutParams(bVar);
        this.desktopGreetingPinned = pin;
        O1(this.keyboardHeightPx);
    }

    public final SheetGlassStyle o5() {
        DraggableSheetLayout draggableSheetLayout = this.sheetLayout;
        return (draggableSheetLayout != null ? draggableSheetLayout.getSettleState() : null) == SheetSettleState.FULL ? SheetGlassStyle.FULL : SheetGlassStyle.HALF;
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onAllTasksEntryVisibilityChanged(boolean visible) {
        this.allTasksEntryVisible = visible;
        if (!visible && this.keyboardHeightPx > 0) {
            this.binding.layoutInputBarNew.n6();
        }
        H1(true);
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public boolean onBackPressed() throws Resources.NotFoundException {
        InputViewManager.f1(InputViewManager.INSTANCE, null, 1, null);
        if (com.stepos.agentframework.util.u.INSTANCE.d()) {
            return true;
        }
        HomeChatPagerView homeChatPagerView = this.pagerView;
        if (homeChatPagerView != null && HomeChatPagerView.S(homeChatPagerView, false, 1, null)) {
            return true;
        }
        if (!this.panelShown) {
            return false;
        }
        HomeChatPagerView homeChatPagerView2 = this.pagerView;
        if (homeChatPagerView2 != null && homeChatPagerView2.B()) {
            return true;
        }
        V2(this, true, true, null, 4, null);
        return true;
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onEnterSystemRecents() {
        SessionCenterView sessionCenter;
        this.binding.layoutInputBarNew.n6();
        f3("onEnterSystemRecents");
        HomeChatPagerView homeChatPagerView = this.pagerView;
        if (homeChatPagerView != null && (sessionCenter = homeChatPagerView.getSessionCenter()) != null) {
            sessionCenter.F();
        }
        this.allTasksEntryVisible = false;
        v3();
        C4148a.k(TAG, "all-tasks hidden + glass released on recents", false, 4, null);
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onNavigateHome() throws Resources.NotFoundException {
        InputViewManager.f1(InputViewManager.INSTANCE, null, 1, null);
        f3("onNavigateHome");
        if (this.panelShown) {
            V2(this, true, true, null, 4, null);
        }
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPageCreate(IOverlayPageHost host) {
        kotlin.jvm.internal.p.i(host, "host");
        this.overlayHost = host;
        com.stepos.ailauncher.chat.tts.f fVar = com.stepos.ailauncher.chat.tts.f.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        fVar.h(context);
        this.pageScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
        this.lifecycleRegistry.n(Lifecycle.State.CREATED);
        P1();
        l5();
        h5();
        H5();
        this.binding.btnAllTasks.setAlpha(1.0f);
        this.binding.btnAllTasks.setVisibility(8);
        this.binding.btnAllTasks.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.C3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ThreeTileOverlayView.a4(this.f28788a, view);
            }
        });
        G1();
        ViewGroup.LayoutParams layoutParams = this.binding.layoutSuggestions.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        this.chipsToInputGapPx = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        i5();
        d2();
        V1(this, 0, 1, null);
        com.stepos.ailauncher.container.wallpaper.c.INSTANCE.b(this.imeGlowThemeListener);
        A3();
        this.binding.tvGreeting.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.task.space.h2
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                ThreeTileOverlayView.b4(this.f29035a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
        X3();
        Y3();
        D4();
        o3();
        MinusOneHomeRoots minusOneHomeRoots = MinusOneHomeRoots.INSTANCE;
        minusOneHomeRoots.e(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.i2
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThreeTileOverlayView.c4(this.f29040a);
            }
        });
        minusOneHomeRoots.g(this.homeGroupExitParticipant);
        C4148a.d(TAG, "onPageCreate", false, 4, null);
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPageDestroy(OverlayPageDestroyReason reason) {
        InterfaceC5063a<Y8.t> interfaceC5063aE;
        kotlin.jvm.internal.p.i(reason, "reason");
        InterfaceC5063a<Y8.t> interfaceC5063a = this.releaseCoveredPanelScrim;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        O2();
        b bVar = this.embeddedGroupExit;
        if (bVar != null && (interfaceC5063aE = bVar.e()) != null) {
            interfaceC5063aE.invoke();
        }
        this.binding.layoutInputBarNew.setRecordingPresentationProvider(null);
        this.binding.layoutInputBarNew.setAsrWaitingMessageListVisibilityProvider(null);
        D5();
        com.stepos.ailauncher.container.wallpaper.c.INSTANCE.e(this.imeGlowThemeListener);
        boolean z10 = this.panelShown;
        com.stepos.ailauncher.chat.wake.homebar.A.c(this.sysUiCloseRunnable);
        this.sysUiCloseRunnable = null;
        this.sysUiClosePending = false;
        this.collapsingAfterSysUiAlign = false;
        M2();
        L2("onPageDestroy");
        com.stepos.ailauncher.container.o0.INSTANCE.a(null);
        com.stepos.ailauncher.container.l0.INSTANCE.j(null);
        this.pageResumed = false;
        setPanelShown(false);
        com.stepos.ailauncher.container.d0.INSTANCE.b(false);
        if (z10) {
            com.stepos.ailauncher.chat.wake.homebar.A.i(0L, 0L, 0L, 7, null);
        }
        IOverlayPageHost iOverlayPageHost = this.overlayHost;
        if (iOverlayPageHost != null) {
            iOverlayPageHost.setContentOwnsHorizontalGesture(false);
        }
        o4(false);
        z5(this, null, 1, null);
        this.binding.layoutInputBarNew.ud();
        C c10 = this.chatInputComponent;
        if (c10 != null) {
            c10.g();
        }
        this.binding.layoutInputBarNew.setOnImeInsetsFrame(null);
        this.binding.layoutInputBarNew.setOnImeAnimationStart(null);
        this.binding.layoutInputBarNew.setOnImeAnimationEnd(null);
        this.imeHideResetGeneration++;
        this.binding.layoutInputBarNew.b(null);
        this.binding.layoutInputBarNew.setOnSpeechPopupShown(null);
        this.binding.layoutInputBarNew.setOnAsrFinalizingChanged(null);
        X1(false);
        this.binding.layoutInputBarNew.setOnVoiceLongPressVisualChanged(null);
        this.binding.layoutInputBarNew.setOnVoiceLongPressOutgoingAlphaChanged(null);
        this.allTasksLongPressFadeActive = false;
        this.binding.btnAllTasks.setAlpha(1.0f);
        com.stepos.ailauncher.chat.wake.effect.c cVar = this.recordingSpectrum;
        if (cVar != null) {
            cVar.h();
        }
        this.recordingSpectrum = null;
        this.recordingScrimView = null;
        P2();
        this.inputBarAlphaAnim = null;
        N2();
        ValueAnimator valueAnimator = this.homeConsumeImeGeomAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.homeConsumeImeGeomAnim = null;
        this.inputBarSlideHeld = false;
        HomeChatPagerView homeChatPagerView = this.pagerView;
        if (homeChatPagerView != null) {
            homeChatPagerView.g0();
        }
        com.stepos.ailauncher.sheet.s0.INSTANCE.b(com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE).E();
        I4();
        this.sessionHandler = null;
        this.freshSessionMintedForHome = false;
        S2();
        this.chatInputComponent = null;
        this.sheetReady = false;
        Animator animator = this.allTasksEntryAnimator;
        if (animator != null) {
            animator.cancel();
        }
        this.allTasksEntryAnimator = null;
        Iterator<T> it = this.glassedViews.values().iterator();
        while (it.hasNext()) {
            com.stepos.ailauncher.container.glass.h.INSTANCE.F((y7.E) it.next());
        }
        this.glassedViews.clear();
        this.greetingGlassKeyboardUp = null;
        Ua.M m10 = this.pageScope;
        if (m10 != null) {
            kotlinx.coroutines.d.e(m10, null, 1, null);
        }
        this.pageScope = null;
        this.overlayHost = null;
        MinusOneHomeRoots minusOneHomeRoots = MinusOneHomeRoots.INSTANCE;
        minusOneHomeRoots.e(null);
        if (minusOneHomeRoots.b() == this.homeGroupExitParticipant) {
            minusOneHomeRoots.g(null);
        }
        minusOneHomeRoots.f(false);
        this.lifecycleRegistry.n(Lifecycle.State.DESTROYED);
        C4148a.d(TAG, "onPageDestroy", false, 4, null);
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPagePause() {
        UnifiedChatHostView chatHost;
        HomeChatPagerView homeChatPagerView = this.pagerView;
        if (homeChatPagerView != null && (chatHost = homeChatPagerView.getChatHost()) != null) {
            chatHost.E1(false);
        }
        this.lifecycleRegistry.n(Lifecycle.State.STARTED);
        this.pageResumed = false;
        com.stepos.ailauncher.chat.manager.Q0.r(this.onSessionExternallyMarked);
        M1();
        z5(this, null, 1, null);
        InputViewManager inputViewManager = InputViewManager.INSTANCE;
        HomeInputView layoutInputBarNew = this.binding.layoutInputBarNew;
        kotlin.jvm.internal.p.h(layoutInputBarNew, "layoutInputBarNew");
        inputViewManager.h1(layoutInputBarNew);
        e5();
        com.stepos.ailauncher.chat.tts.f fVar = com.stepos.ailauncher.chat.tts.f.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        fVar.o(context, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.j2
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThreeTileOverlayView.d4(this.f29046a);
            }
        });
        f3("onPagePause");
        L4();
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPageResume(OverlayPageResumeReason reason) {
        UnifiedChatHostView chatHost;
        LauncherChatLayout chatLayout;
        UnifiedChatHostView chatHost2;
        kotlin.jvm.internal.p.i(reason, "reason");
        boolean z10 = this.pageResumed;
        this.lifecycleRegistry.n(Lifecycle.State.RESUMED);
        this.pageResumed = true;
        A5();
        o3();
        com.stepos.ailauncher.common.utils.r.INSTANCE.x();
        M1();
        InputViewManager inputViewManager = InputViewManager.INSTANCE;
        HomeInputView layoutInputBarNew = this.binding.layoutInputBarNew;
        kotlin.jvm.internal.p.h(layoutInputBarNew, "layoutInputBarNew");
        inputViewManager.N0(layoutInputBarNew);
        HomeInputView layoutInputBarNew2 = this.binding.layoutInputBarNew;
        kotlin.jvm.internal.p.h(layoutInputBarNew2, "layoutInputBarNew");
        inputViewManager.P0(layoutInputBarNew2);
        inputViewManager.M(this.wakeDialogVisibilityListener);
        this.binding.layoutInputBarNew.setEnabled(true);
        HomeInputView layoutInputBarNew3 = this.binding.layoutInputBarNew;
        kotlin.jvm.internal.p.h(layoutInputBarNew3, "layoutInputBarNew");
        inputViewManager.Y0(layoutInputBarNew3);
        this.binding.layoutInputBarNew.post(new Runnable() { // from class: com.stepos.ailauncher.task.space.u3
            @Override // java.lang.Runnable
            public final void run() {
                ThreeTileOverlayView.e4(this.f29120a);
            }
        });
        if (reason != OverlayPageResumeReason.PAGE_SWITCH) {
            inputViewManager.i1();
        }
        this.binding.layoutInputBarNew.I9();
        O2();
        boolean z11 = this.incomingVoiceHold.b() || this.binding.layoutInputBarNew.f8();
        if (!z10) {
            if (z11) {
                this.binding.layoutInputBarNew.post(new Runnable() { // from class: com.stepos.ailauncher.task.space.A3
                    @Override // java.lang.Runnable
                    public final void run() {
                        ThreeTileOverlayView.f4(this.f28779a);
                    }
                });
            } else {
                InputViewManager.f1(inputViewManager, null, 1, null);
            }
        }
        this.binding.layoutInputBarNew.Aa();
        HomeChatPagerView homeChatPagerView = this.pagerView;
        if (homeChatPagerView != null && (chatHost2 = homeChatPagerView.getChatHost()) != null) {
            chatHost2.E0();
        }
        com.stepos.ailauncher.chat.manager.Q0.d(this.onSessionExternallyMarked);
        J4();
        F1();
        HomeChatPagerView homeChatPagerView2 = this.pagerView;
        if (homeChatPagerView2 != null && (chatHost = homeChatPagerView2.getChatHost()) != null && (chatLayout = chatHost.getChatLayout()) != null) {
            HomeInputView layoutInputBarNew4 = this.binding.layoutInputBarNew;
            kotlin.jvm.internal.p.h(layoutInputBarNew4, "layoutInputBarNew");
            chatLayout.X8(layoutInputBarNew4);
        }
        i3();
        LinearLayout layoutSuggestions = this.binding.layoutSuggestions;
        kotlin.jvm.internal.p.h(layoutSuggestions, "layoutSuggestions");
        if (!layoutSuggestions.isLaidOut() || layoutSuggestions.isLayoutRequested()) {
            layoutSuggestions.addOnLayoutChangeListener(new m());
        } else {
            i3();
        }
        l3();
        z5(this, null, 1, null);
        K4();
        com.stepos.ailauncher.chat.tts.f.INSTANCE.s();
        this.binding.b().post(new Runnable() { // from class: com.stepos.ailauncher.task.space.B3
            @Override // java.lang.Runnable
            public final void run() {
                ThreeTileOverlayView.g4(this.f28785a);
            }
        });
        C4148a.d(TAG, "onPageResume reason=" + reason, false, 4, null);
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPageStop() throws Resources.NotFoundException {
        AgentSession.AgentConversation agentConversationR1;
        UnifiedChatHostView chatHost;
        UnifiedChatHostView chatHost2;
        HomeChatPagerView homeChatPagerView = this.pagerView;
        if (homeChatPagerView != null && (chatHost2 = homeChatPagerView.getChatHost()) != null) {
            chatHost2.h1(false);
        }
        HomeChatPagerView homeChatPagerView2 = this.pagerView;
        if (homeChatPagerView2 != null && (chatHost = homeChatPagerView2.getChatHost()) != null) {
            chatHost.E1(false);
        }
        this.pageResumed = false;
        this.lifecycleRegistry.n(Lifecycle.State.CREATED);
        z5(this, null, 1, null);
        f3("onPageStop");
        boolean z10 = this.panelShown;
        SessionHandler sessionHandler = this.sessionHandler;
        C4148a.k("RestoreTrace", "onPageStop: panelShown=" + z10 + " topSid=" + ((sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) ? null : agentConversationR1.B()), false, 4, null);
        InputViewManager inputViewManager = InputViewManager.INSTANCE;
        HomeInputView layoutInputBarNew = this.binding.layoutInputBarNew;
        kotlin.jvm.internal.p.h(layoutInputBarNew, "layoutInputBarNew");
        inputViewManager.b0(layoutInputBarNew);
        inputViewManager.X0(this.wakeDialogVisibilityListener);
        this.binding.layoutInputBarNew.setEnabled(false);
        if (com.stepos.ailauncher.container.m0.INSTANCE.h()) {
            return;
        }
        V2(this, true, false, null, 4, null);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus && this.panelShown) {
            com.stepos.ailauncher.sheet.s0.INSTANCE.b(com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE).N();
        }
    }

    public final boolean p3(InputBarGlassPhase inputBarGlassPhase) {
        return inputBarGlassPhase == InputBarGlassPhase.DESKTOP;
    }

    public final void p4(final View view) {
        view.animate().cancel();
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(380L).setInterpolator(CHIP_BOUNCE_INTERPOLATOR).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.task.space.w3
            @Override // java.lang.Runnable
            public final void run() {
                ThreeTileOverlayView.q4(view);
            }
        }).start();
    }

    public final boolean p5(MotionEvent ev) {
        ViewGroup viewGroup;
        if (this.keyboardHeightPx <= 0 || this.imePinnedByDialog || C3209b.INSTANCE.b().getValue().booleanValue() || com.stepos.agentframework.util.u.INSTANCE.f()) {
            return false;
        }
        HomeInputView layoutInputBarNew = this.binding.layoutInputBarNew;
        kotlin.jvm.internal.p.h(layoutInputBarNew, "layoutInputBarNew");
        if (layoutInputBarNew.a8() || layoutInputBarNew.R7() || N3(ev.getRawX(), ev.getRawY())) {
            return false;
        }
        if (!this.panelShown) {
            return true;
        }
        HomeChatPagerView homeChatPagerView = this.pagerView;
        if (homeChatPagerView == null || !homeChatPagerView.Z() || (viewGroup = this.sheetPanel) == null) {
            return false;
        }
        return O3(ev.getRawX(), ev.getRawY(), viewGroup);
    }

    public final boolean q3(String agentId, String deviceId, String agentDisplayName) {
        if (!this.sheetReady || !com.stepos.ailauncher.container.m0.INSTANCE.h()) {
            return false;
        }
        AuthManager authManager = AuthManager.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (!AuthManager.O(authManager, context, true, false, 4, null)) {
            return true;
        }
        this.pendingFreshSessionAfterCollapse = false;
        HomeChatPagerView homeChatPagerView = this.pagerView;
        if (homeChatPagerView != null) {
            homeChatPagerView.O(agentId, deviceId, agentDisplayName);
        }
        Y4();
        C4148a.k(TAG, "handleEmbeddedAgentConversation → agentId=" + agentId + " deviceId=" + deviceId, false, 4, null);
        return true;
    }

    public final void q5(long durationMs) {
        ViewGroup viewGroup;
        if (this.exitColorAnim != null || this.panelShown || (viewGroup = this.sheetPanel) == null) {
            return;
        }
        this.exitColorAnim = C3436d.o(viewGroup, C3436d.h(com.stepos.ailauncher.chat.wake.homebar.A.g()), durationMs, null, 0.0f, 24, null);
    }

    public final boolean r3(String prompt) {
        if (La.H.x0(prompt) || !this.sheetReady || !com.stepos.ailauncher.container.m0.INSTANCE.h()) {
            return false;
        }
        AuthManager authManager = AuthManager.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (!AuthManager.O(authManager, context, true, false, 4, null)) {
            return true;
        }
        this.pendingFreshSessionAfterCollapse = false;
        HomeChatPagerView homeChatPagerView = this.pagerView;
        if (homeChatPagerView != null) {
            homeChatPagerView.P(prompt);
        }
        Y4();
        C4148a.k(TAG, "handleEmbeddedNewChatPrompt → len=" + prompt.length(), false, 4, null);
        return true;
    }

    public final void r4(DraggableSheetLayout sheet) throws Resources.NotFoundException {
        UnifiedChatHostView chatHost;
        x1();
        final View view = this.dimView;
        HomeChatPagerView homeChatPagerView = this.pagerView;
        final LauncherChatLayout chatLayout = (homeChatPagerView == null || (chatHost = homeChatPagerView.getChatHost()) == null) ? null : chatHost.getChatLayout();
        if (chatLayout != null) {
            chatLayout.s8(true);
        }
        sheet.G0(true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.N2
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThreeTileOverlayView.s4(view, ((Float) obj).floatValue());
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.Y2
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThreeTileOverlayView.t4(chatLayout);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.j3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ThreeTileOverlayView.u4(chatLayout);
            }
        });
    }

    public final void r5() {
        final ImageView ivImeGlow = this.binding.ivImeGlow;
        kotlin.jvm.internal.p.h(ivImeGlow, "ivImeGlow");
        if (ivImeGlow.getVisibility() != 0) {
            T1(0.0f);
            return;
        }
        this.imeGlowHiding = true;
        W1();
        ivImeGlow.animate().cancel();
        ivImeGlow.animate().alpha(0.0f).setDuration(220L).setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f)).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.task.space.Q2
            @Override // java.lang.Runnable
            public final void run() {
                ThreeTileOverlayView.s5(this.f28862a, ivImeGlow);
            }
        }).start();
    }

    public final boolean s3(String sessionId, boolean restoreLast) {
        HomeChatPagerView homeChatPagerView;
        UnifiedChatHostView chatHost;
        if (!this.sheetReady || !com.stepos.ailauncher.container.m0.INSTANCE.h() || !this.pageResumed || com.stepos.ailauncher.sheet.s0.INSTANCE.b(com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE).x()) {
            return false;
        }
        boolean z10 = (sessionId == null || sessionId.length() == 0 || restoreLast) ? false : true;
        if (this.panelShown && !z10) {
            if (x5()) {
                C4148a.k(TAG, "handleEmbeddedRestore: stop listening, keep current sheet", false, 4, null);
            } else {
                C4148a.d(TAG, "handleEmbeddedRestore ignored: panel already foreground (chat or session center)", false, 4, null);
            }
            return true;
        }
        AuthManager authManager = AuthManager.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (!AuthManager.O(authManager, context, true, false, 4, null)) {
            return true;
        }
        int i10 = this.restoreSeq + 1;
        this.restoreSeq = i10;
        S2();
        if (restoreLast && (homeChatPagerView = this.pagerView) != null && (chatHost = homeChatPagerView.getChatHost()) != null) {
            chatHost.U0(sessionId);
        }
        HomeChatPagerView homeChatPagerView2 = this.pagerView;
        if (homeChatPagerView2 != null) {
            homeChatPagerView2.i0(sessionId);
        }
        Y4();
        if (restoreLast) {
            SessionHandler sessionHandler = this.sessionHandler;
            Ua.M m10 = this.pageScope;
            if (sessionHandler != null && m10 != null) {
                C1060i.d(m10, null, null, new ThreeTileOverlayView$handleEmbeddedRestore$1(sessionId, sessionHandler, i10, this, null), 3, null);
            }
        }
        C4148a.k(TAG, "handleEmbeddedRestore → embedded nine-split restore sessionId=" + sessionId + " restoreLast=" + restoreLast, false, 4, null);
        return true;
    }

    public final boolean t3(String source, String sessionId) {
        if (!this.sheetReady) {
            return false;
        }
        com.stepos.ailauncher.container.m0 m0Var = com.stepos.ailauncher.container.m0.INSTANCE;
        if (!m0Var.h() || RecentsWindowMonitor.INSTANCE.l() || !this.pageResumed || com.stepos.ailauncher.sheet.s0.INSTANCE.b(com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE).x()) {
            return false;
        }
        HomeInputView layoutInputBarNew = this.binding.layoutInputBarNew;
        kotlin.jvm.internal.p.h(layoutInputBarNew, "layoutInputBarNew");
        m0Var.j();
        R3(ChatTracker.INSTANCE.u(source));
        layoutInputBarNew.hd(source);
        if (kotlin.jvm.internal.p.d(source, C4814a.AI_KEY_LONG_CLICK_START)) {
            layoutInputBarNew.t4();
        } else if (C4814a.INSTANCE.f(source)) {
            BaseInputView.oc(layoutInputBarNew, null, null, 3, null);
        }
        WakeService.INSTANCE.n0(layoutInputBarNew, source);
        return true;
    }

    public final void t5(final float to, final InterfaceC5063a<Y8.t> onEnd) {
        final ConstraintLayout conLayoutInput = this.binding.conLayoutInput;
        kotlin.jvm.internal.p.h(conLayoutInput, "conLayoutInput");
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g(conLayoutInput.getAlpha()));
        iVar.o(0.00390625f);
        iVar.B(new androidx.dynamicanimation.animation.j(to).h(INPUT_BAR_ALPHA_STIFFNESS).f(1.0f));
        iVar.c(new e.r() { // from class: com.stepos.ailauncher.task.space.x3
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                ThreeTileOverlayView.u5(conLayoutInput, eVar, f10, f11);
            }
        });
        iVar.b(new e.q() { // from class: com.stepos.ailauncher.task.space.y3
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                ThreeTileOverlayView.v5(this.f29141a, conLayoutInput, to, onEnd, eVar, z10, f10, f11);
            }
        });
        iVar.t();
        this.inputBarAlphaAnim = iVar;
    }

    public final int u1() {
        return Q3(ALL_TASKS_PILL_HEIGHT_DP);
    }

    public final boolean u3() {
        return C3127h.INSTANCE.b();
    }

    public final int v1() {
        return Q3(ALL_TASKS_PILL_WIDTH_DP);
    }

    public final void v3() {
        Animator animator = this.allTasksEntryAnimator;
        if (animator != null) {
            animator.cancel();
        }
        this.allTasksEntryAnimator = null;
        this.allTasksTargetVisible = Boolean.FALSE;
        this.binding.btnAllTasks.setVisibility(8);
        E4();
    }

    public final void v4(DraggableSheetLayout sheet) {
        x1();
        SheetScaleMotion sheetScaleMotionR = com.stepos.ailauncher.sheet.i0.INSTANCE.r();
        sheet.T0(sheetScaleMotionR.getCollapsedScale(), sheetScaleMotionR.getTravelWidthFraction() * sheet.getWidth(), sheetScaleMotionR.getOffset().getStiffness(), sheetScaleMotionR.getOffset().getDampingRatio(), sheetScaleMotionR.getScale().getStiffness(), sheetScaleMotionR.getScale().getDampingRatio(), (128 & 64) != 0 ? false : false, (128 & 128) != 0 ? null : null);
    }

    public final void w1(boolean visible, boolean animate) {
        int iA;
        if (kotlin.jvm.internal.p.d(this.allTasksTargetVisible, Boolean.valueOf(visible))) {
            return;
        }
        this.allTasksTargetVisible = Boolean.valueOf(visible);
        LinearLayout btnAllTasks = this.binding.btnAllTasks;
        kotlin.jvm.internal.p.h(btnAllTasks, "btnAllTasks");
        Animator animator = this.allTasksEntryAnimator;
        if (animator != null) {
            animator.cancel();
        }
        btnAllTasks.setScaleX(1.0f);
        if (!visible) {
            btnAllTasks.setVisibility(8);
            E4();
            return;
        }
        F1();
        if (!animate) {
            btnAllTasks.setVisibility(0);
            if (!btnAllTasks.isLaidOut() || btnAllTasks.isLayoutRequested()) {
                btnAllTasks.addOnLayoutChangeListener(new d());
                return;
            } else {
                g3();
                return;
            }
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        btnAllTasks.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        if (btnAllTasks.getMeasuredWidth() > 0) {
            iA = btnAllTasks.getMeasuredWidth();
        } else {
            C5659a c5659a = C5659a.INSTANCE;
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            iA = c5659a.a(context, 76);
        }
        float fV1 = v1() / iA;
        btnAllTasks.setScaleX(fV1);
        if (btnAllTasks.getVisibility() != 0) {
            btnAllTasks.setVisibility(0);
        }
        if (!btnAllTasks.isLaidOut() || btnAllTasks.isLayoutRequested()) {
            btnAllTasks.addOnLayoutChangeListener(new e());
        } else {
            g3();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(btnAllTasks, (Property<LinearLayout, Float>) View.SCALE_X, fV1, 1.0f);
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.73f, 1.0f));
        objectAnimatorOfFloat.start();
        this.allTasksEntryAnimator = objectAnimatorOfFloat;
    }

    public final void w3() {
        E e10 = this.sheetHostRoot;
        if (e10 == null || e10.getVisibility() != 0) {
            IOverlayPageHost iOverlayPageHost = this.overlayHost;
            if (iOverlayPageHost != null) {
                iOverlayPageHost.setContentOwnsHorizontalGesture(false);
            }
            L2("hideSheetHost.alreadyHidden");
            View view = this.dragHandle;
            if (view != null) {
                view.animate().cancel();
                view.setAlpha(0.0f);
            }
            FrameLayout frameLayout = this.contentContainer;
            if (frameLayout != null) {
                frameLayout.setAlpha(1.0f);
            }
            FrameLayout frameLayout2 = this.contentContainer;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            o4(false);
            S4();
            W1();
            w4();
            return;
        }
        L2("hideSheetHost");
        View view2 = this.dragHandle;
        if (view2 != null) {
            view2.animate().cancel();
            view2.setAlpha(0.0f);
            Log.i("DragHandleAlpha", "hideSheetHost reset alpha=0");
        }
        I4();
        E e11 = this.sheetHostRoot;
        if (e11 != null) {
            e11.setVisibility(4);
        }
        M2();
        V4();
        x4();
        IOverlayPageHost iOverlayPageHost2 = this.overlayHost;
        if (iOverlayPageHost2 != null) {
            iOverlayPageHost2.setContentOwnsHorizontalGesture(false);
        }
        DraggableSheetLayout draggableSheetLayout = this.sheetLayout;
        if (draggableSheetLayout != null) {
            draggableSheetLayout.b0();
        }
        View view3 = this.dimView;
        if (view3 != null) {
            view3.setVisibility(8);
            view3.setAlpha(0.0f);
            view3.setClickable(true);
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.O2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) throws Resources.NotFoundException {
                    ThreeTileOverlayView.x3(this.f28854a, view4);
                }
            });
        }
        HomeChatPagerView homeChatPagerView = this.pagerView;
        if (homeChatPagerView != null) {
            homeChatPagerView.R(false);
        }
        HomeChatPagerView homeChatPagerView2 = this.pagerView;
        if (homeChatPagerView2 != null) {
            homeChatPagerView2.n0(false);
        }
        this.binding.conLayoutInput.setTranslationX(0.0f);
        P2();
        this.binding.conLayoutInput.setAlpha(1.0f);
        FrameLayout frameLayout3 = this.contentContainer;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(0);
        }
        FrameLayout frameLayout4 = this.contentContainer;
        if (frameLayout4 != null) {
            frameLayout4.setAlpha(1.0f);
        }
        o4(false);
        S4();
        W1();
        w4();
    }

    public final void w4() {
        com.stepos.ailauncher.sheet.s0.INSTANCE.b(com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE).E();
        this.inputPresentationState.a();
        A5();
    }

    public final int w5(float dp) {
        return (int) TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }

    public final void x4() {
        this.binding.layoutInputBarNew.post(new Runnable() { // from class: com.stepos.ailauncher.task.space.v3
            @Override // java.lang.Runnable
            public final void run() {
                ThreeTileOverlayView.y4(this.f29127a);
            }
        });
    }

    public final boolean x5() {
        HomeInputView layoutInputBarNew = this.binding.layoutInputBarNew;
        kotlin.jvm.internal.p.h(layoutInputBarNew, "layoutInputBarNew");
        if (layoutInputBarNew.R7()) {
            return false;
        }
        if (!layoutInputBarNew.a8() && !layoutInputBarNew.getListenModeActive()) {
            return false;
        }
        layoutInputBarNew.vc("nav_key_click");
        return true;
    }

    public final void y5(String sid) {
        UnifiedChatHostView chatHost;
        SessionHandler sessionHandler = this.sessionHandler;
        AgentSession.AgentConversation agentConversationR1 = sessionHandler != null ? sessionHandler.R1() : null;
        List listR = C1173v.r(agentConversationR1 != null ? agentConversationR1.B() : null, agentConversationR1 != null ? agentConversationR1.getSessionId() : null, agentConversationR1 != null ? agentConversationR1.getTempSessionId() : null);
        List arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        if (sid == null || !arrayList.contains(sid)) {
            arrayList = C1173v.m();
        }
        C3675u0 c3675u0 = C3675u0.INSTANCE;
        boolean z10 = this.pageResumed;
        boolean z11 = this.panelShown;
        HomeChatPagerView homeChatPagerView = this.pagerView;
        boolean z12 = false;
        if (homeChatPagerView != null && homeChatPagerView.Z()) {
            z12 = true;
        }
        boolean zA = c3675u0.a(z10, z11, z12, sid, arrayList);
        HomeChatPagerView homeChatPagerView2 = this.pagerView;
        if (homeChatPagerView2 != null && (chatHost = homeChatPagerView2.getChatHost()) != null) {
            chatHost.E1(zA);
        }
        HomeChatPagerView homeChatPagerView3 = this.pagerView;
        if (homeChatPagerView3 != null) {
            homeChatPagerView3.setConversationPageVisible(zA);
        }
    }

    public final void z1(String reason) {
        ValueAnimator valueAnimator = this.homeConsumeImeGeomAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int i10 = this.keyboardHeightPx;
        if (i10 <= 0) {
            return;
        }
        C4148a.k(TAG, "animate IME geometry to 0 reason=" + reason + " from=" + i10, false, 4, null);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i10, 0);
        valueAnimatorOfInt.setDuration(HOME_CONSUME_IME_HIDE_MS);
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.task.space.k2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ThreeTileOverlayView.A1(this.f29050a, valueAnimator2);
            }
        });
        valueAnimatorOfInt.start();
        this.homeConsumeImeGeomAnim = valueAnimatorOfInt;
    }

    public final boolean z3() {
        return MicOccupancyMonitor.INSTANCE.p() || this.binding.layoutInputBarNew.J7();
    }

    public final void z4(DraggableSheetLayout sheet) {
        InterfaceC5063a<Y8.t> interfaceC5063a = this.releaseCoveredPanelScrim;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        com.stepos.ailauncher.chat.wake.homebar.A.c(this.sysUiCloseRunnable);
        this.sysUiCloseRunnable = null;
        this.sysUiClosePending = false;
        DraggableSheetLayout.P(sheet, false, 1, null);
        M2();
        ViewGroup viewGroup = this.sheetPanel;
        if (viewGroup != null) {
            C3436d.g(viewGroup);
        }
        P2();
        sheet.setBottomAnchorEnabled(true);
        FrameLayout frameLayout = this.contentContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            frameLayout.setAlpha(1.0f);
            frameLayout.setScaleX(1.0f);
            frameLayout.setScaleY(1.0f);
            frameLayout.setTranslationY(0.0f);
        }
        sheet.setImeInsetPx(this.keyboardHeightPx > 0 ? r0 + this.navBottomPx : 0.0f);
        E e10 = this.sheetHostRoot;
        if (e10 != null) {
            e10.setTouchPassthrough(false);
        }
        this.binding.conLayoutInput.setAlpha(1.0f);
        View view = this.dimView;
        if (view != null) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.C2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) throws Resources.NotFoundException {
                    ThreeTileOverlayView.A4(this.f28787a, view2);
                }
            });
        }
    }

    public /* synthetic */ ThreeTileOverlayView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
