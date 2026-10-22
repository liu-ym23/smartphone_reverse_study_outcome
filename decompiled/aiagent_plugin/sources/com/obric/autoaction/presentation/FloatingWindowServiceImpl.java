package com.obric.autoaction.presentation;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.VDPlayerActivity;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.assistant.LaunchMethodClient;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.presentation.AutoAgentAction;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.common.api.virtualdisplay.IAutoActionVDApi;
import com.obric.oui.avatar.OCircleImageView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.n;
import d.o;
import d.x;
import java.util.Collection;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import org.json.JSONObject;

/* JADX INFO: compiled from: FloatingWindowServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FloatingWindowServiceImpl extends PluginService {
    public static final a Companion = null;
    private static final String FOREGROUND_NOTIFICATION_SHOW = null;
    private static com.obric.autoaction.presentation.b.c currentBizStatusEvent;
    private static IAutoActionAgentEventListener.AgentStepExecInfo currentExecInfo;
    private static String currentQuery;
    private static IAutoActionAgentEventListener.SessionInfo currentSessionInfo;
    private static IAutoActionAgentEventListener.AgentStepInfo currentStepInfo;
    private final String TAG;
    private Dialog alertDialog;
    private AppWidgetManager appWidgetManager;
    private final LocalBinder binder;
    private IAutoActionAgentEventListener.OperatingAppInfo executingApp;
    private com.obric.autoaction.b.d floatingIconBinding;
    private float initialTouchX;
    private float initialTouchY;
    private int initialX;
    private int initialY;
    private boolean isClickCancelTask;
    private String lastInputText;
    private boolean mIsStartedForegroundService;
    private d.h.a.a<x> openAppAction;
    private final d orientationReceiver;
    private boolean taskIsSuccess;
    private final long timeInterval;
    private ca updateJob;
    private final com.obric.autoaction.presentation.widget.a viewModel;
    private WindowManager windowManager;

    /* JADX INFO: compiled from: FloatingWindowServiceImpl.kt */
    public final class LocalBinder extends Binder {
        final /* synthetic */ FloatingWindowServiceImpl this$0;

        public LocalBinder(FloatingWindowServiceImpl r3) {
            this.this$0 = (FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r3, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
        }

        public final FloatingWindowServiceImpl getService() {
            return this.this$0;
        }
    }

    /* JADX INFO: compiled from: FloatingWindowServiceImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final String a() {
            return FloatingWindowServiceImpl.access$getCurrentQuery$cp();
        }

        public final com.obric.autoaction.presentation.b.c b() {
            return FloatingWindowServiceImpl.access$getCurrentBizStatusEvent$cp();
        }

        public final IAutoActionAgentEventListener.AgentStepInfo c() {
            return FloatingWindowServiceImpl.access$getCurrentStepInfo$cp();
        }

        public final IAutoActionAgentEventListener.SessionInfo d() {
            return FloatingWindowServiceImpl.access$getCurrentSessionInfo$cp();
        }

        public final IAutoActionAgentEventListener.AgentStepExecInfo e() {
            return FloatingWindowServiceImpl.access$getCurrentExecInfo$cp();
        }
    }

    /* JADX INFO: compiled from: FloatingWindowServiceImpl.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24758a = null;

        static {
            int[] r0 = new int[BizStatus.values().length];
            r0[BizStatus.PREPARING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[BizStatus.OPERATING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[BizStatus.TERMINATED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[BizStatus.USER_INTERRUPTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[BizStatus.IDLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[BizStatus.PAUSED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[BizStatus.QUEUEING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f24758a = r0;
        }
    }

    /* JADX INFO: compiled from: FloatingWindowServiceImpl.kt */
    @d.c.b.a.f(b = "FloatingWindowServiceImpl.kt", c = {117}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.FloatingWindowServiceImpl$onCreate$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FloatingWindowServiceImpl f24760b;

        c(FloatingWindowServiceImpl r3, d.c.d<? super c> r4) {
            FloatingWindowServiceImpl r5 = (FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r3, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24760b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f24760b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24759a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            ab<com.obric.autoaction.presentation.b> r7 = com.obric.autoaction.presentation.c.f24841a.a();
            final FloatingWindowServiceImpl r3 = this.f24760b;
            kotlinx.coroutines.b.i<? super com.obric.autoaction.presentation.b> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24759a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FloatingWindowServiceImpl.kt */
    public static final class d extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatingWindowServiceImpl f24762a;

        private static final String a() {
            return "onReceive";
        }

        public static /* synthetic */ String lambda$Paqo5Z2VsqlT7pjd5xbjizWm6Ws(Intent r0) {
            return a(r0);
        }

        /* JADX INFO: renamed from: lambda$x6-Zpq0weEDOYVj7OTjsW0tUeOU, reason: not valid java name */
        public static /* synthetic */ String m597lambda$x6Zpq0weEDOYVj7OTjsW0tUeOU() {
            return a();
        }

        d(FloatingWindowServiceImpl r3) {
            this.f24762a = (FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r3, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
        }

        public void onReceive(Context r4, final Intent r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.dp(this.f24762a.getTAG(), new $$Lambda$FloatingWindowServiceImpl$d$Paqo5Z2VsqlT7pjd5xbjizWm6Ws(r5), $$Lambda$FloatingWindowServiceImpl$d$x6Zpq0weEDOYVj7OTjsW0tUeOU.INSTANCE);
            if (r5 == null) goto L5;
            String r7 = r5.getAction();
        L7:
            if (d.h.b.o.a(r7, "android.intent.action.CONFIGURATION_CHANGED") == false) goto L10;
            FloatingWindowServiceImpl.access$handleConfigurationChange(this.f24762a);
            return;
        L10:
            return;
        L5:
            r7 = null;
            goto L7
        }

        private static final String a(Intent r2) {
            StringBuilder r0 = new StringBuilder().append("onReceive, action: ");
            if (r2 == null) goto L5;
            String r3 = r2.getAction();
        L7:
            return r0.append(r3).toString();
        L5:
            r3 = null;
            goto L7
        }
    }

    private static final String bringTaskToMainDisplay$lambda$32() {
        return "bringing lastTask";
    }

    private final int coerceIn(int r1, int r2, int r3) {
        if (r1 < r2) goto L7;
        if (r1 > r3) goto L6;
        return r1;
    L6:
        return r3;
    L7:
        return r2;
    }

    private final void handleQueueEvent(com.obric.autoaction.presentation.b.g r1) {
    }

    /* JADX INFO: renamed from: lambda$-HfeM-pT4ZaNAMCVKl66Mygj5pg, reason: not valid java name */
    public static /* synthetic */ x m589lambda$HfeMpT4ZaNAMCVKl66Mygj5pg(FloatingWindowServiceImpl r0, int r1, Bundle r2, String r3, String r4) {
        return showInputWindow$lambda$48(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ String lambda$1sS4LB7iDyta9RI91Ah0TbJzaks(boolean r0, String r1) {
        return onStartCommand$lambda$18$lambda$16(r0, r1);
    }

    public static /* synthetic */ String lambda$4VYebjRQUQlrScNGqMq21drWrbw(IAutoActionAgentEventListener.OperatingAppInfo r0) {
        return startAppOnMainDisplay$lambda$28(r0);
    }

    /* JADX INFO: renamed from: lambda$6DsUdNb379MSFddPH-4ScBx31Lw, reason: not valid java name */
    public static /* synthetic */ String m590lambda$6DsUdNb379MSFddPH4ScBx31Lw() {
        return startSurfaceCardActivity$lambda$9();
    }

    /* JADX INFO: renamed from: lambda$CTYmdzQ8skWVgiI0SqKkqus0F-I, reason: not valid java name */
    public static /* synthetic */ boolean m591lambda$CTYmdzQ8skWVgiI0SqKkqus0FI(FloatingWindowServiceImpl r0, View r1, MotionEvent r2) {
        return setupTouchListeners$lambda$34(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$GQZ0IJ3xDwhova1cSS0oQYwf-y8, reason: not valid java name */
    public static /* synthetic */ String m592lambda$GQZ0IJ3xDwhova1cSS0oQYwfy8(FloatingWindowServiceImpl r0, boolean r1) {
        return startSurfaceCardActivity$lambda$8(r0, r1);
    }

    public static /* synthetic */ String lambda$HYXY523S3en_Bc0pUHziH_QQdmI(LinearLayout r0) {
        return showFloatingWindow$lambda$22$lambda$19(r0);
    }

    /* JADX INFO: renamed from: lambda$JiyV9EpCnBdR_MC5Zs5Q0-Srm_c, reason: not valid java name */
    public static /* synthetic */ String m593lambda$JiyV9EpCnBdR_MC5Zs5Q0Srm_c() {
        return startAppOnMainDisplay$lambda$29();
    }

    /* JADX INFO: renamed from: lambda$K-yGwMwjsyeaQudki0reT_1zjhw, reason: not valid java name */
    public static /* synthetic */ String m594lambda$KyGwMwjsyeaQudki0reT_1zjhw() {
        return showInputWindow$lambda$47();
    }

    public static /* synthetic */ String lambda$OLd8vAYRJulY5yO4BxYMG0wcld0(String r0) {
        return onStartCommand$lambda$18$lambda$14(r0);
    }

    public static /* synthetic */ x lambda$PH4BkxlM5NDT2aC7mWPbb8QWJfI(FloatingWindowServiceImpl r0, String r1, String r2) {
        return showInputWindow$lambda$49(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$SosW6XoIYGOx3XvCI3FXx_sVFwQ(WindowManager.LayoutParams r0, int r1, int r2, int r3, int r4, FloatingWindowServiceImpl r5, View r6, ValueAnimator r7) {
        animateToPosition$lambda$42$lambda$41(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ String lambda$T_zdqnXzJq4dea2l0Q3DKQN7h8g(String r0, int r1) {
        return showInputWindow$lambda$46(r0, r1);
    }

    public static /* synthetic */ String lambda$VnV7PThHIcCNgnIz4RWXv0Bcehw() {
        return startAppOnMainDisplay$lambda$26();
    }

    /* JADX INFO: renamed from: lambda$YlkV3Pf0dweScDWsr3ft-XOXUU4, reason: not valid java name */
    public static /* synthetic */ String m595lambda$YlkV3Pf0dweScDWsr3ftXOXUU4() {
        return bringTaskToMainDisplay$lambda$32();
    }

    public static /* synthetic */ String lambda$bEosz2ffiEv7Neqz4e0aulGreCY() {
        return onStartCommand$lambda$18$lambda$15();
    }

    public static /* synthetic */ String lambda$ddknQOGeboAkb_u9ZJVztDfMrww(IAutoActionAgentEventListener.OperatingAppInfo r0) {
        return startAppOnMainDisplay$lambda$25(r0);
    }

    /* JADX INFO: renamed from: lambda$kGD-yrRHAI2jshEbGVnCUczqXIk, reason: not valid java name */
    public static /* synthetic */ String m596lambda$kGDyrRHAI2jshEbGVnCUczqXIk(int r0) {
        return bringTaskToMainDisplay$lambda$31(r0);
    }

    public static /* synthetic */ x lambda$lQBVYcfAQSHqyDXCNwHietS3G_U(FloatingWindowServiceImpl r0) {
        return handleStepStatusEvent$lambda$3(r0);
    }

    public static /* synthetic */ String lambda$pAktv7RyhO5nyGh9Z_TpjD7pvSI() {
        return showInputWindow$lambda$45();
    }

    public static /* synthetic */ String lambda$pixpQRyWQdyq6kZitht4yFeYw7Y(String r0, int r1) {
        return showInputWindow$lambda$44(r0, r1);
    }

    public static /* synthetic */ void lambda$wDNNP0fmE44qXBfD3TIKj_T5HnE(FloatingWindowServiceImpl r0, WindowManager.LayoutParams r1) {
        toggleExpand$lambda$35(r0, r1);
    }

    public static /* synthetic */ String lambda$yDqnNOHvA_6GeNA5fhVM4y8vJAU() {
        return showFloatingWindow$lambda$22$lambda$20();
    }

    public static /* synthetic */ String lambda$yP7eVosDcmHb31SZZriVei8iBUo() {
        return onStartCommand$lambda$18$lambda$17();
    }

    private static final String onStartCommand$lambda$18$lambda$15() {
        return "FloatingWindowService onStartCommand action";
    }

    private static final String onStartCommand$lambda$18$lambda$17() {
        return "onStartCommand";
    }

    private static final String showFloatingWindow$lambda$22$lambda$20() {
        return "showFloatingWindow expandContent";
    }

    private static final String showInputWindow$lambda$45() {
        return "showInputWindow";
    }

    private static final String showInputWindow$lambda$47() {
        return "showInputWindow";
    }

    private static final String startAppOnMainDisplay$lambda$26() {
        return "startAppOnMainDisplay";
    }

    private static final String startAppOnMainDisplay$lambda$29() {
        return "startAppOnMainDisplay, taskId not available; opening";
    }

    private static final String startSurfaceCardActivity$lambda$9() {
        return "startSurfaceCardActivity";
    }

    public FloatingWindowServiceImpl() {
        this.TAG = "FloatingWindowServiceImpl";
        this.binder = new LocalBinder(this);
        this.timeInterval = 300000;
        this.lastInputText = "";
        this.viewModel = new com.obric.autoaction.presentation.widget.a();
        this.orientationReceiver = new d(this);
    }

    public static final /* synthetic */ com.obric.autoaction.presentation.b.c access$getCurrentBizStatusEvent$cp() {
        return currentBizStatusEvent;
    }

    public static final /* synthetic */ IAutoActionAgentEventListener.AgentStepExecInfo access$getCurrentExecInfo$cp() {
        return currentExecInfo;
    }

    public static final /* synthetic */ String access$getCurrentQuery$cp() {
        return currentQuery;
    }

    public static final /* synthetic */ IAutoActionAgentEventListener.SessionInfo access$getCurrentSessionInfo$cp() {
        return currentSessionInfo;
    }

    public static final /* synthetic */ IAutoActionAgentEventListener.AgentStepInfo access$getCurrentStepInfo$cp() {
        return currentStepInfo;
    }

    public static final /* synthetic */ String access$getFOREGROUND_NOTIFICATION_SHOW$cp() {
        return FOREGROUND_NOTIFICATION_SHOW;
    }

    public static final /* synthetic */ void access$handleConfigurationChange(FloatingWindowServiceImpl r2) {
        ((FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin")).handleConfigurationChange();
    }

    public static final /* synthetic */ void access$handleEvent(FloatingWindowServiceImpl r2, com.obric.autoaction.presentation.b r3) {
        ((FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin")).handleEvent(r3);
    }

    public static final /* synthetic */ void access$setCurrentBizStatusEvent$cp(com.obric.autoaction.presentation.b.c r0) {
        currentBizStatusEvent = r0;
    }

    public static final /* synthetic */ void access$setCurrentExecInfo$cp(IAutoActionAgentEventListener.AgentStepExecInfo r0) {
        currentExecInfo = r0;
    }

    public static final /* synthetic */ void access$setCurrentQuery$cp(String r0) {
        currentQuery = r0;
    }

    public static final /* synthetic */ void access$setCurrentSessionInfo$cp(IAutoActionAgentEventListener.SessionInfo r0) {
        currentSessionInfo = r0;
    }

    public static final /* synthetic */ void access$setCurrentStepInfo$cp(IAutoActionAgentEventListener.AgentStepInfo r0) {
        currentStepInfo = r0;
    }

    public final String getTAG() {
        return this.TAG;
    }

    static {
        Companion = new a(null);
        currentQuery = "";
        FOREGROUND_NOTIFICATION_SHOW = "obric_foreground_notification_show";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        AppWidgetManager r0 = AppWidgetManager.getInstance((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r0, "getInstance(...)");
        this.appWidgetManager = r0;
        com.obric.autoaction.e.b.f24680a.a(this.TAG, "onCreate");
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        IntentFilter r1 = new IntentFilter("android.intent.action.CONFIGURATION_CHANGED");
        ZeusTransformUtils.registerReceiver(this, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.orientationReceiver, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r1, "com.obric.aiagent.plugin");
        if (AutoActionAgent.INSTANCE.getOngoingSessionInfo().a() != null) goto L6;
        Loog.INSTANCE.w(this.TAG, "onCreate: no ongoing session; stopping foreground service");
        stopForeground(1);
        return;
    }

    private final void handleEvent(com.obric.autoaction.presentation.b r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.presentation.b.c.class) == false) goto L6;
        handleBizStatusEvent((com.obric.autoaction.presentation.b.c) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.presentation.b.c.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.presentation.b.g.class) == false) goto L9;
        handleQueueEvent((com.obric.autoaction.presentation.b.g) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.presentation.b.g.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.presentation.b.C0576b.class) == false) goto L12;
        handleStepStatusEvent((com.obric.autoaction.presentation.b.C0576b) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.presentation.b.C0576b.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.presentation.b.f.class) == false) goto L15;
        handleAppChangedEvent((com.obric.autoaction.presentation.b.f) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.presentation.b.f.class, "com.obric.aiagent.plugin"));
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.presentation.b.a.class) == false) goto L22;
        handleAfterStepEvent((com.obric.autoaction.presentation.b.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.presentation.b.a.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void handleBizStatusEvent(com.obric.autoaction.presentation.b.c r5) {
        com.obric.autoaction.e.b.f24680a.a(this.TAG, "BizStatus: " + r5.c().name());
        currentBizStatusEvent = r5;
        switch(b.f24758a[r5.c().ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        com.obric.autoaction.e.b.f24680a.a("BizStatus", "queueing");
        x r4 = x.f38692a;
    L14:
        if (r5.c() != BizStatus.IDLE) goto L16;
        return;
    L16:
        if (r5.c() == BizStatus.QUEUEING) goto L22;
        String r6 = r5.a().getTask().getUserTask();
        if (r6 == null) goto L23;
        currentQuery = r6;
        return;
    L23:
        return;
    L22:
        return;
    L7:
        handlePausedState();
        x r7 = x.f38692a;
        goto L14
    L8:
        handleIdle(r5);
        x r8 = x.f38692a;
        goto L14
    L9:
        showUserInterruptedMessage();
        x r9 = x.f38692a;
        goto L14
    L10:
        handleTerminatedState(r5);
        x r10 = x.f38692a;
        goto L14
    L11:
        handleOperatingState(r5.b(), r5.d());
        x r11 = x.f38692a;
        goto L14
    L12:
        updateStatusToPreparing();
        x r12 = x.f38692a;
        goto L14
    L5:
        throw new d.k();
    }

    private final void handleIdle(com.obric.autoaction.presentation.b.c r2) {
        if (r2.b() != BizStatus.TERMINATED) goto L9;
        d.h.a.a<x> r3 = this.openAppAction;
        if (r3 == null) goto L7;
        r3.invoke();
    L7:
        this.openAppAction = null;
        return;
    }

    private final void handleOperatingState(BizStatus r3, Bundle r4) {
        ensureForeground();
        if (r3 == BizStatus.PREPARING) goto L5;
        return;
    L5:
        if (r4 == null) goto L7;
        Integer r0 = Integer.valueOf(r4.getInt("task_to_bring", -1));
    L9:
        if (r0 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r4 == null) goto L16;
        boolean r6 = r4.getBoolean("open_player", true);
    L17:
        if (r6 == false) goto L21;
        startSurfaceCardActivity(true, r5, "click_oauto_launcher_page");
        return;
    L21:
        return;
    L16:
        r6 = true;
        goto L17
    L11:
        if (r0.intValue() == (-1)) goto L13;
        r5 = true;
        goto L14
    L7:
        r0 = null;
        goto L9
    }

    private final void handlePausedState() {
        ensureForeground();
    }

    private final void handleTerminatedState(com.obric.autoaction.presentation.b.c r4) {
        com.obric.autoaction.e.b.f24680a.a(this.TAG, "handleTerminatedState, stopForeground");
        boolean r0 = true;
        stopForeground(1);
        this.mIsStartedForegroundService = false;
        Bundle r5 = r4.a().getTask().getTaskExtras();
        if (r5 != null) goto L5;
    L7:
        r0 = false;
    L8:
        if (r0 == false) goto L11;
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - floating-window exited with `eos_exit_directly` == true");
        hideFloatingWindow();
        return;
    L11:
        return;
    L5:
        if (r5.getBoolean("eos_exit_directly", false) != true) goto L7;
        goto L7
    }

    private final void handleStepStatusEvent(com.obric.autoaction.presentation.b.C0576b r2) {
        updateFloatingView(r2.a());
        currentStepInfo = r2.a();
        if (r2.a().isLastStep() == false) goto L6;
        this.openAppAction = new $$Lambda$FloatingWindowServiceImpl$lQBVYcfAQSHqyDXCNwHietS3G_U(this);
        return;
    }

    private static final x handleStepStatusEvent$lambda$3(FloatingWindowServiceImpl r2) {
        FloatingWindowServiceImpl r3 = (FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
        IAutoActionAgentEventListener.AgentStepInfo r0 = currentStepInfo;
        if (r0 == null) goto L6;
        r3.maybeOpenApp(r0);
    L6:
        return x.f38692a;
    }

    private final void handleAppChangedEvent(com.obric.autoaction.presentation.b.f r5) {
        com.obric.autoaction.e.b.f24680a.a(this.TAG, "OperatingAppChanged " + r5.a());
        updateFloatingView(r5.a());
        this.executingApp = r5.a();
    }

    private final void handleAfterStepEvent(com.obric.autoaction.presentation.b.a r1) {
        currentSessionInfo = r1.a();
        currentExecInfo = r1.c();
        currentStepInfo = r1.b();
    }

    private final void showUserInterruptedMessage() {
        ensureForeground();
        String r0 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.auto_floating_expand_user_interrupted, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_floating_expand_user_interrupted"));
        d.h.b.o.c(r0, "getString(...)");
        setFloatingExpandedText(r0);
    }

    private final void updateStatusToPreparing() {
        currentStepInfo = null;
        this.taskIsSuccess = false;
        this.isClickCancelTask = false;
        this.executingApp = null;
        cancelPendingUpdate();
        updateFloatingViewToInit();
        hideFloatingWindow();
    }

    private final void cancelPendingUpdate() {
        ca r0 = this.updateJob;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        this.updateJob = null;
    }

    private final void updateFloatingViewToInit() {
        String r1 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.auto_floating_expand_init, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_floating_expand_init"));
        d.h.b.o.c(r1, "getString(...)");
        setFloatingExpandedText(r1);
        com.obric.autoaction.b.d r2 = this.floatingIconBinding;
        if (r2 == null) goto L7;
        OCircleImageView r3 = r2.f24601d;
        if (r3 == null) goto L7;
        r3.setImageDrawable(androidx.core.content.b.h.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.float_expand_icon, "drawable", "float_expand_icon"), null));
    L7:
        com.obric.autoaction.b.d r4 = this.floatingIconBinding;
        if (r4 == null) goto L13;
        OCircleImageView r5 = r4.f24602e;
        if (r5 == null) goto L14;
        r5.setImageDrawable(androidx.core.content.b.h.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.float_expand_icon, "drawable", "float_expand_icon"), null));
        return;
    L14:
        return;
    }

    private final void setFloatingExpandedText(String r3) {
        com.obric.autoaction.b.d r2 = this.floatingIconBinding;
        if (r2 == null) goto L8;
        TextView r4 = r2.f24599b;
        if (r4 == null) goto L9;
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        return;
    }

    public final void updateCallUserExpandedText(boolean r4) {
        if (r4 == false) goto L4;
        String r5 = getString(ZeusTransformUtils.mapRes(R.string.auto_floating_expand_user_operating, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_floating_expand_user_operating"));
        d.h.b.o.c(r5, "getString(...)");
        setFloatingExpandedText(r5);
    L8:
        com.obric.autoaction.b.d r6 = this.floatingIconBinding;
        if (r6 == null) goto L29;
        LinearLayout r7 = r6.f24598a;
        if (r7 != null) goto L13;
        return;
    L13:
        if (((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L31;
        com.obric.autoaction.b.d r9 = this.floatingIconBinding;
        WindowManager.LayoutParams r0 = null;
        if (r9 == null) goto L22;
        FrameLayout r10 = r9.b();
        if (r10 == null) goto L22;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
    L24:
        if (ZeusTransformUtils.instanceOf(r11, WindowManager.LayoutParams.class) == false) goto L26;
        r0 = (WindowManager.LayoutParams) ZeusTransformUtils.preCheckCast(r11, WindowManager.LayoutParams.class, "com.obric.aiagent.plugin");
    L26:
        if (r0 == null) goto L32;
        adjustPositionForExpandedContent(r0);
        return;
    L32:
        return;
    L22:
        r11 = null;
        goto L24
    L31:
        return;
    L15:
        r8 = false;
        goto L16
    L29:
        return;
    L4:
        IAutoActionAgentEventListener.OperatingAppInfo r12 = this.executingApp;
        if (r12 != null) goto L7;
        updateFloatingViewToInit();
        goto L8
    L7:
        updateFloatingView(r12);
        goto L8
    }

    private final void updateFloatingView(IAutoActionAgentEventListener.AgentStepInfo r8) {
        if (r8.isLastStep() == false) goto L5;
        toggleExpand$default(this, false, 1, null);
        this.taskIsSuccess = true;
        if (r8.isSuccess() == false) goto L19;
        String r0 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.auto_floating_expand_task_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_floating_expand_task_success"));
    L20:
        d.h.b.o.a(r0);
        if (r8.isSuccess() == false) goto L23;
        int r3 = R.drawable.float_expand_icon_success;
        String r6 = "float_expand_icon_success";
    L24:
        int r4 = ZeusTransformUtils.mapRes(r3, "drawable", r6);
        com.obric.autoaction.b.d r5 = this.floatingIconBinding;
        if (r5 == null) goto L29;
        TextView r7 = r5.f24599b;
        if (r7 == null) goto L29;
        r7.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"));
    L29:
        com.obric.autoaction.b.d r1 = this.floatingIconBinding;
        if (r1 == null) goto L34;
        OCircleImageView r2 = r1.f24602e;
        if (r2 == null) goto L34;
        r2.setImageDrawable(androidx.core.content.b.h.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), r4, null));
    L34:
        com.obric.autoaction.b.d r9 = this.floatingIconBinding;
        if (r9 == null) goto L40;
        OCircleImageView r10 = r9.f24601d;
        if (r10 == null) goto L40;
        r10.setImageDrawable(androidx.core.content.b.h.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), r4, null));
    L40:
        if (this.isClickCancelTask == true) goto L45;
        Bundle r11 = r8.getExtras();
        if (r11 == null) goto L45;
        r11.getInt("term_reason_type", -1);
    L45:
        if (r8.isSuccess() == false) goto L50;
        this.lastInputText = "";
        return;
    L50:
        return;
    L23:
        r3 = R.drawable.float_expand_icon_fail;
        r6 = "float_expand_icon_fail";
        goto L24
    L19:
        r0 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.auto_floating_expand_task_fail, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_floating_expand_task_fail"));
        goto L20
    L5:
        if (r8.getActionType() != 2) goto L8;
        updateFloatingViewToInit();
        String r12 = getString(ZeusTransformUtils.mapRes(R.string.auto_floating_expand_call_user, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_floating_expand_call_user"));
        d.h.b.o.c(r12, "getString(...)");
        setFloatingExpandedText(r12);
        toggleExpand$default(this, false, 1, null);
    L8:
        if (r8.getActionType() != 3) goto L11;
        updateFloatingViewToInit();
        String r13 = getString(ZeusTransformUtils.mapRes(R.string.auto_floating_expand_clarify, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_floating_expand_clarify"));
        d.h.b.o.c(r13, "getString(...)");
        setFloatingExpandedText(r13);
        toggleExpand$default(this, false, 1, null);
    L11:
        if (r8.getActionType() != 1) goto L48;
        updateFloatingViewToInit();
        IAutoActionAgentEventListener.OperatingAppInfo r14 = this.executingApp;
        if (r14 == null) goto L49;
        updateFloatingView(r14);
        return;
    L49:
        return;
    }

    private final void maybeOpenApp(IAutoActionAgentEventListener.AgentStepInfo r6) {
        if (r6.isLastStep() == true) goto L6;
        return;
    L6:
        if (isKeyguardLocked() == false) goto L12;
        if (hasExternalTopAppRunning() == false) goto L12;
        Loog.INSTANCE.d(this.TAG, "skip open app because screen locked and external app is on top");
        return;
    L12:
        if (((SurfaceCardActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.f25104a.a(), "com.obric.aiagent.plugin"), SurfaceCardActivity.class, "com.obric.aiagent.plugin")) == null) goto L22;
        SurfaceCardActivity r0 = (SurfaceCardActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.f25104a.a(), "com.obric.aiagent.plugin"), SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L18;
        androidx.lifecycle.i r1 = r0.getLifecycle();
        if (r1 == null) goto L18;
        androidx.lifecycle.i.b r2 = r1.b();
    L20:
        if (r2 != androidx.lifecycle.i.b.f2058e) goto L22;
        return;
    L18:
        r2 = null;
    L22:
        if (VDPlayerActivity.Companion.a() == false) goto L24;
        return;
    L24:
        Bundle r7 = r6.getExtras();
        boolean r3 = true;
        if (r7 != null) goto L27;
    L29:
        r3 = false;
    L30:
        Loog.INSTANCE.d(this.TAG, "open app by model config " + r3);
        if (r3 == false) goto L35;
        startAppOnMainDisplay((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        return;
    L35:
        return;
    L27:
        if (r7.getBoolean("open_app", false) != true) goto L29;
        goto L29
    }

    private final boolean isKeyguardLocked() {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L15
        Object r3 = ((FloatingWindowServiceImpl) ZeusTransformUtils.preCheckCast(this, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin")).getSystemService("keyguard");     // Catch: Throwable -> L15
        if (ZeusTransformUtils.instanceOf(r3, KeyguardManager.class) == false) goto L6;
        KeyguardManager r4 = (KeyguardManager) ZeusTransformUtils.preCheckCast(r3, KeyguardManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
    L7:
        boolean r5 = true;
        if (r4 != null) goto L10;
    L12:
        r5 = false;
    L13:
        Object r6 = n.f(Boolean.valueOf(r5));     // Catch: Throwable -> L15
    L18:
        if (n.b(r6) == false) goto L21;
        r6 = false;
    L21:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L10:
        if (r4.isKeyguardLocked() != true) goto L12;
    L6:
        r4 = null;
    L15:
        th = move-exception;
        n.a r7 = n.f38560a;
        r6 = n.f(o.a(th));
        goto L18
    }

    private final boolean hasExternalTopAppRunning() {
        boolean r1 = true;
        String r5 = null;
        Collection r0 = IAutoActionVDApi.DefaultImpls.fetchMdTopAppInfo$default((IAutoActionVDApi) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE, IAutoActionVDApi.class, "com.obric.aiagent.plugin"), 1, false, 2, null);
        if (r0 == null) goto L9;
        DisplayedAppInfo r2 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(p.f((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")), DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        ComponentName r3 = r2.getTopActivity();
        if (r3 == null) goto L9;
        r5 = r3.getPackageName();
    L9:
        String r4 = AOSystemTools.INSTANCE.getHostAppPackage();
        if (r5 != null) goto L12;
    L14:
        r1 = false;
    L15:
        Loog.INSTANCE.i(this.TAG, "current top=" + r5 + ", host=" + r4 + ", external=" + r1);
        return r1;
    L12:
        if (d.h.b.o.a(r5, r4) == false) goto L14;
        goto L14
    }

    private final void updateFloatingView(IAutoActionAgentEventListener.OperatingAppInfo r5) {
        com.obric.autoaction.b.d r0 = this.floatingIconBinding;
        if (r0 == null) goto L7;
        OCircleImageView r1 = r0.f24601d;
        if (r1 == null) goto L7;
        r1.setImageDrawable(r5.getAppIcon());
    L7:
        com.obric.autoaction.b.d r2 = this.floatingIconBinding;
        if (r2 == null) goto L12;
        OCircleImageView r3 = r2.f24602e;
        if (r3 == null) goto L12;
        r3.setImageDrawable(r5.getAppIcon());
    L12:
        com.obric.autoaction.b.d r4 = this.floatingIconBinding;
        if (r4 == null) goto L18;
        TextView r6 = r4.f24599b;
        if (r6 == null) goto L19;
        r6.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.auto_floating_expand_task_executing, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_floating_expand_task_executing"), new Object[]{r5.getAppLabel()}), CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L19:
        return;
    }

    static /* synthetic */ void startSurfaceCardActivity$default(FloatingWindowServiceImpl r1, boolean r2, boolean r3, String r4, int r5, Object r6) {
        FloatingWindowServiceImpl r7 = (FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r1, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = false;
    L8:
        r7.startSurfaceCardActivity(r2, r3, r4);
    }

    private final void startSurfaceCardActivity(final boolean r5, boolean r6, String r7) {
        Loog.INSTANCE.dp(this.TAG, new $$Lambda$FloatingWindowServiceImpl$GQZ0IJ3xDwhova1cSS0oQYwfy8(this, r5), $$Lambda$FloatingWindowServiceImpl$6DsUdNb379MSFddPH4ScBx31Lw.INSTANCE);
        if (com.obric.autogui.common.a.d.f28974a.g() == false) goto L5;
        final Intent r0 = new Intent((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), VDPlayerActivity.class);
    L6:
        r0.setFlags(268435456);
        r0.putExtra("from_finish", this.taskIsSuccess);
        r0.putExtra("new_task", r5);
        r0.putExtra("hide_placeholder", r6);
        r0.putExtra("source_from", r7);
        SurfaceCardActivity r8 = (SurfaceCardActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.f25104a.a(), "com.obric.aiagent.plugin"), SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L9;
    L15:
        ZeusTransformUtils.startActivity(this, r0, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(this.TAG, "startSurfaceCardActivity, surfaceActivity is null, startActivity Directly");
        return;
    L9:
        if (r8.isDestroyed() == true) goto L15;
        if (r8.isFinishing() == false) goto L14;
        Loog.INSTANCE.d(this.TAG, "startSurfaceCardActivity, surfaceActivity is finishing , waiting onDestroy");
        r8.getLifecycle().a((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, r0), androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
        return;
    L14:
        Loog.INSTANCE.d(this.TAG, "startSurfaceCardActivity, surfaceActivity is not finishing, startActivity Directly");
        ZeusTransformUtils.startActivity(this, r0, "com.obric.aiagent.plugin");
        return;
    L5:
        r0 = new Intent((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), SurfaceCardActivity.class);
        goto L6
    }

    private static final String startSurfaceCardActivity$lambda$8(FloatingWindowServiceImpl r2, boolean r3) {
        return "startSurfaceCardActivity, taskIsSuccess: " + ((FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin")).taskIsSuccess + " newTask: " + r3;
    }

    private final void ensureForeground() {
        if (this.mIsStartedForegroundService == true) goto L4;
    }

    private final void startForegroundWithNotification() {
        Object r0 = getSystemService(IFlowAppIntentIDL.PERMISSION_NOTIFICATION);
        d.h.b.o.a(r0, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) ZeusTransformUtils.preCheckCast(r0, NotificationManager.class, "com.obric.aiagent.plugin")).createNotificationChannel(new NotificationChannel("auto_action", (CharSequence) ZeusTransformUtils.preCheckCast("auto_action", CharSequence.class, "com.obric.aiagent.plugin"), 3));
        IAutoActionPresentationApi r1 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        Intent r2 = r1.getOpenPlayerIntent((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), "click_oauto_notif");
        if (r2 == null) goto L7;
    L11:
        if (r2 == null) goto L17;
        Intent r3 = LaunchMethodClient.INSTANCE.attachLaunchMethod(r2, LaunchMethodClient.LAUNCH_METHOD_NOTIFICATION_CENTER);
        if (r3 == null) goto L17;
        Notification r4 = new Notification.Builder((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), "auto_action").setContentTitle((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.oauto_notif_running_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_notif_running_title")), CharSequence.class, "com.obric.aiagent.plugin")).setContentText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.oauto_notif_running_content, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_notif_running_content")), CharSequence.class, "com.obric.aiagent.plugin")).setContentIntent(PendingIntent.getActivity((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.notification.a.c.f24568a.b(), r3, 201326592)).setSmallIcon(ZeusTransformUtils.mapRes(R.drawable.ai_task_icon, "drawable", "ai_task_icon")).build();
        r4.extras.putBoolean(FOREGROUND_NOTIFICATION_SHOW, false);
        d.h.b.o.c(r4, "apply(...)");
        startForeground(1, r4);
        this.mIsStartedForegroundService = true;
        return;
    L17:
        FloatingWindowServiceImpl r6 = (FloatingWindowServiceImpl) ZeusTransformUtils.preCheckCast(this, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.e(r6.TAG, "startForegroundWithNotification: playerIntent is null");
        return;
    L7:
        r2 = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (r2 == null) goto L10;
        r2.addFlags(335544320);
        goto L11
    L10:
        r2 = null;
        goto L11
    }

    public IBinder onBind(Intent r2) {
        return (IBinder) ZeusTransformUtils.preCheckCast(this.binder, IBinder.class, "com.obric.aiagent.plugin");
    }

    public int onStartCommand(Intent r9, int r10, int r11) {
        if (r9 == null) goto L31;
        final String r12 = r9.getAction();
        Loog.INSTANCE.dp(this.TAG, new $$Lambda$FloatingWindowServiceImpl$OLd8vAYRJulY5yO4BxYMG0wcld0(r12), $$Lambda$FloatingWindowServiceImpl$bEosz2ffiEv7Neqz4e0aulGreCY.INSTANCE);
        if (r12 == null) goto L31;
        int r0 = r12.hashCode();
        if (r0 == (-613818132)) goto L22;
        if (r0 == 127954849) goto L18;
        if (r0 != 1117777502) goto L31;
        if (r12.equals(AutoAgentAction.ACTION_SHOW_INPUT_WINDOW) == false) goto L31;
        String r1 = r9.getStringExtra("preset_query");
        boolean r5 = r9.getBooleanExtra("start_at_once", false);
        int r6 = r9.getIntExtra("launched_origin", 2);
        showInputWindow(r1, r9.getStringExtra("preset_query_hint"), r9.getStringExtra("preset_query_prefix"), r9.getStringExtra("preset_query_prefix_tag"), r5, r6, r9.getBundleExtra("task_extras"));
        goto L31
    L18:
        if (r12.equals(AutoAgentAction.ACTION_CANCEL_TASK) == false) goto L31;
        this.viewModel.b();
        this.isClickCancelTask = true;
        goto L31
    L22:
        if (r12.equals(AutoAgentAction.ACTION_AUTO_TESTING_TASK) == false) goto L31;
        final boolean r13 = AOSystemTools.INSTANCE.isDebuggable();
        Bundle r14 = r9.getExtras();
        if (r14 == null) goto L27;
        String r15 = r14.getString("instruction");
    L28:
        final String r2 = r15;
        Loog.INSTANCE.dp(this.TAG, new $$Lambda$FloatingWindowServiceImpl$1sS4LB7iDyta9RI91Ah0TbJzaks(r13, r2), $$Lambda$FloatingWindowServiceImpl$yP7eVosDcmHb31SZZriVei8iBUo.INSTANCE);
        if (r13 == false) goto L31;
        maybeStartTask$default(this, r2, 18, null, 4, null);
        goto L31
    L27:
        r15 = null;
    L31:
        return 1;
    }

    private static final String onStartCommand$lambda$18$lambda$14(String r2) {
        return "FloatingWindowService onStartCommand action " + r2;
    }

    private static final String onStartCommand$lambda$18$lambda$16(boolean r2, String r3) {
        return "onStartCommand, isDebuggable " + r2 + ", instruction: " + r3;
    }

    public final void showFloatingWindow() {
        com.obric.autoaction.e.b.f24680a.a(this.TAG, "showFloatingWindow");
        com.obric.autoaction.b.d r0 = this.floatingIconBinding;
        if (r0 == null) goto L7;
        FrameLayout r1 = r0.f24600c;
        if (r1 == null) goto L7;
        r1.setAlpha(1.0f);
    L7:
        com.obric.autoaction.b.d r2 = this.floatingIconBinding;
        if (r2 == null) goto L12;
        FrameLayout r3 = r2.b();
        if (r3 == null) goto L12;
        r3.setVisibility(0);
    L12:
        com.obric.autoaction.b.d r4 = this.floatingIconBinding;
        x r5 = null;
        if (r4 == null) goto L17;
        FrameLayout r6 = r4.b();
        if (r6 == null) goto L17;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
    L19:
        if (ZeusTransformUtils.instanceOf(r7, WindowManager.LayoutParams.class) == false) goto L21;
        WindowManager.LayoutParams r8 = (WindowManager.LayoutParams) ZeusTransformUtils.preCheckCast(r7, WindowManager.LayoutParams.class, "com.obric.aiagent.plugin");
    L22:
        com.obric.autoaction.b.d r9 = this.floatingIconBinding;
        if (r9 == null) goto L43;
        final LinearLayout r10 = r9.f24598a;
        if (r10 == null) goto L43;
        Loog.INSTANCE.dp(this.TAG, new $$Lambda$FloatingWindowServiceImpl$HYXY523S3en_Bc0pUHziH_QQdmI(r10), $$Lambda$FloatingWindowServiceImpl$yDqnNOHvA_6GeNA5fhVM4y8vJAU.INSTANCE);
        if (((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L29;
        boolean r11 = true;
    L30:
        if (r11 == false) goto L40;
        com.obric.autoaction.b.d r12 = this.floatingIconBinding;
        if (r12 == null) goto L36;
        TextView r13 = r12.f24599b;
        if (r13 == null) goto L36;
        CharSequence r14 = r13.getText();
    L38:
        if (d.h.b.o.a(r14, getString(ZeusTransformUtils.mapRes(R.string.auto_floating_expand_call_user, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_floating_expand_call_user"))) == true) goto L40;
        toggleExpand(true);
        r5 = x.f38692a;
    L42:
        if (r5 == null) goto L43;
        return;
    L36:
        r14 = null;
    L40:
        if (r8 == null) goto L42;
        adjustPositionForCollapsedState(r8, false);
        r5 = x.f38692a;
        goto L42
    L29:
        r11 = false;
    L43:
        FloatingWindowServiceImpl r15 = (FloatingWindowServiceImpl) ZeusTransformUtils.preCheckCast(this, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L48;
        r15.adjustPositionForCollapsedState(r8, false);
        x r16 = x.f38692a;
        return;
    L48:
        return;
    L21:
        r8 = null;
    L17:
        r7 = null;
        goto L19
    }

    private static final String showFloatingWindow$lambda$22$lambda$19(LinearLayout r3) {
        StringBuilder r0 = new StringBuilder().append("showFloatingWindow expandContent isVisible ");
        if (((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r4 = true;
    L7:
        return r0.append(r4).toString();
    L5:
        r4 = false;
        goto L7
    }

    public final void hideFloatingWindow() {
        com.obric.autoaction.e.b.f24680a.a(this.TAG, "hideFloatingWindow");
        com.obric.autoaction.b.d r3 = this.floatingIconBinding;
        if (r3 == null) goto L8;
        FrameLayout r4 = r3.b();
        if (r4 == null) goto L9;
        r4.setVisibility(8);
        return;
    L9:
        return;
    }

    public final void startAppOnMainDisplay(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "context");
        final IAutoActionAgentEventListener.OperatingAppInfo r0 = this.executingApp;
        if (r0 != null) goto L7;
        Loog.INSTANCE.d(this.TAG, "startAppOnMainDisplay, executingApp is null");
        return;
    L7:
        if (r0.getTaskId() > 0) goto L9;
        Loog.INSTANCE.ep(this.TAG, new $$Lambda$FloatingWindowServiceImpl$4VYebjRQUQlrScNGqMq21drWrbw(r0), $$Lambda$FloatingWindowServiceImpl$JiyV9EpCnBdR_MC5Zs5Q0Srm_c.INSTANCE);
        AOPackagesTools.INSTANCE.openAppOnMainDisplay(r11, r0.getPackageName());
        return;
    L9:
        if (bringTaskToMainDisplay(r0.getTaskId()).g() == false) goto L13;
        Loog.INSTANCE.dp(this.TAG, new $$Lambda$FloatingWindowServiceImpl$ddknQOGeboAkb_u9ZJVztDfMrww(r0), $$Lambda$FloatingWindowServiceImpl$VnV7PThHIcCNgnIz4RWXv0Bcehw.INSTANCE);
        IAutoActionTrackingApi r1 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r3 = new JSONObject();
        r3.put("case_type", "bring_to_md_front");
        r3.put("string_value", "pkg=" + r0.getPackageName() + "; isTaskIdChanged=" + r0.isTaskIdChanged());
        x r9 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r1, "technical_recorded_case", r3, false, false, null, 28, null);
        return;
    }

    private static final String startAppOnMainDisplay$lambda$25(IAutoActionAgentEventListener.OperatingAppInfo r2) {
        return "startAppOnMainDisplay, brought (" + r2.getTaskId() + "), isTaskIdChanged=" + r2.isTaskIdChanged();
    }

    private static final String startAppOnMainDisplay$lambda$28(IAutoActionAgentEventListener.OperatingAppInfo r2) {
        return "startAppOnMainDisplay, taskId not available; opening (" + r2.getPackageName() + ')';
    }

    private static final String bringTaskToMainDisplay$lambda$31(int r2) {
        return " - bringing lastTask: " + r2;
    }

    public final com.obric.autogui.common.e bringTaskToMainDisplay(final int r4) {
        Loog.INSTANCE.dp(this.TAG, new $$Lambda$FloatingWindowServiceImpl$kGDyrRHAI2jshEbGVnCUczqXIk(r4), $$Lambda$FloatingWindowServiceImpl$YlkV3Pf0dweScDWsr3ftXOXUU4.INSTANCE);
        return AutoActionVirtualDisplay.INSTANCE.bringTaskToMdFront(r4);
    }

    private final void setupFloatingWindow() {
        this.floatingIconBinding = com.obric.autoaction.b.d.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")));
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams(-2, -2, 2038, 262696, -3);
        r0.gravity = 8388659;
        r0.x = 1000;
        r0.y = 1800;
        com.obric.autoaction.b.d r2 = this.floatingIconBinding;
        if (r2 == null) goto L7;
        FrameLayout r3 = r2.b();
        if (r3 == null) goto L7;
        r3.setVisibility(8);
    L7:
        WindowManager r4 = this.windowManager;
        if (r4 == null) goto L14;
        com.obric.autoaction.b.d r5 = this.floatingIconBinding;
        if (r5 == null) goto L12;
        FrameLayout r6 = r5.b();
    L13:
        r4.addView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        goto L14
    L12:
        r6 = null;
    L14:
        setupTouchListeners();
    }

    private final void setupTouchListeners() {
        com.obric.autoaction.b.d r0 = this.floatingIconBinding;
        if (r0 == null) goto L8;
        FrameLayout r1 = r0.b();
        if (r1 == null) goto L9;
        r1.setOnTouchListener(new $$Lambda$FloatingWindowServiceImpl$CTYmdzQ8skWVgiI0SqKkqus0FI(this));
        return;
    L9:
        return;
    }

    private static final boolean setupTouchListeners$lambda$34(FloatingWindowServiceImpl r11, View r12, MotionEvent r13) {
        FloatingWindowServiceImpl r14 = (FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r11, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.b.d r0 = r14.floatingIconBinding;
        FrameLayout r8 = null;
        if (r0 == null) goto L7;
        FrameLayout r1 = r0.b();
        if (r1 == null) goto L7;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
    L8:
        d.h.b.o.a(r2, "null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        WindowManager.LayoutParams r3 = (WindowManager.LayoutParams) ZeusTransformUtils.preCheckCast(r2, WindowManager.LayoutParams.class, "com.obric.aiagent.plugin");
        int r4 = r13.getAction();
        if (r4 != 0) goto L11;
        r14.initialX = r3.x;
        r14.initialY = r3.y;
        r14.initialTouchX = r13.getRawX();
        r14.initialTouchY = r13.getRawY();
    L44:
        return true;
    L11:
        if (r4 == 1) goto L25;
        if (r4 != 2) goto L15;
        int r5 = (int) (r13.getRawX() - r14.initialTouchX);
        int r15 = (int) (r13.getRawY() - r14.initialTouchY);
        r3.x = r14.initialX + r5;
        r3.y = r14.initialY + r15;
        DisplayMetrics r16 = ZeusTransformUtils.getResources(r14, "com.obric.aiagent.plugin").getDisplayMetrics();
        r3.x = r14.coerceIn(r3.x, 0, r16.widthPixels - r12.getWidth());
        r3.y = r14.coerceIn(r3.y, 0, r16.heightPixels - r12.getHeight());
        WindowManager r17 = r14.windowManager;
        if (r17 == null) goto L44;
        com.obric.autoaction.b.d r18 = r14.floatingIconBinding;
        if (r18 == null) goto L23;
        r8 = r18.b();
    L23:
        r17.updateViewLayout((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        goto L44
    L15:
        if (r4 != 4) goto L44;
        r14.toggleExpand(true);
        goto L44
    L25:
        if (Math.abs(r13.getRawX() - r14.initialTouchX) < 5.0f) goto L27;
    L42:
        d.h.b.o.a(r12);
        int[] r19 = r14.calculateCollapsedTargetX(r3, r12);
        r14.animateToPosition(r3, r12, r19[0], r19[1]);
        goto L44
    L27:
        if (Math.abs(r13.getRawY() - r14.initialTouchY) >= 5.0f) goto L42;
        com.obric.autoaction.b.d r110 = r14.floatingIconBinding;
        if (r110 == null) goto L38;
        LinearLayout r111 = r110.f24598a;
        if (r111 == null) goto L38;
        if (((View) ZeusTransformUtils.preCheckCast(r111, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L35;
        boolean r112 = true;
    L36:
        if (r112 != true) goto L38;
        boolean r113 = true;
    L39:
        if (r113 == false) goto L41;
        startSurfaceCardActivity$default(r14, false, false, "N/A", 2, null);
    L41:
        toggleExpand$default(r14, false, 1, null);
        goto L44
    L35:
        r112 = false;
    L38:
        r113 = false;
    L7:
        r2 = null;
        goto L8
    }

    static /* synthetic */ void toggleExpand$default(FloatingWindowServiceImpl r1, boolean r2, int r3, Object r4) {
        FloatingWindowServiceImpl r5 = (FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r1, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = false;
    L5:
        r5.toggleExpand(r2);
    }

    private final void toggleExpand(boolean r7) {
        com.obric.autoaction.b.d r0 = this.floatingIconBinding;
        CharSequence r1 = null;
        if (r0 == null) goto L7;
        FrameLayout r2 = r0.b();
        if (r2 == null) goto L7;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
    L9:
        if (ZeusTransformUtils.instanceOf(r3, WindowManager.LayoutParams.class) == false) goto L11;
        final WindowManager.LayoutParams r4 = (WindowManager.LayoutParams) ZeusTransformUtils.preCheckCast(r3, WindowManager.LayoutParams.class, "com.obric.aiagent.plugin");
    L12:
        if (r4 != null) goto L14;
        return;
    L14:
        boolean r5 = true;
        if (r7 == false) goto L54;
        com.obric.autoaction.b.d r8 = this.floatingIconBinding;
        if (r8 == null) goto L21;
        LinearLayout r9 = r8.f24598a;
        if (r9 == null) goto L21;
        r9.setVisibility(8);
    L21:
        com.obric.autoaction.b.d r10 = this.floatingIconBinding;
        if (r10 == null) goto L31;
        FrameLayout r11 = r10.f24600c;
        if (r11 == null) goto L31;
        if (((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L28;
        boolean r12 = true;
    L29:
        if (r12 != true) goto L31;
    L32:
        if (r5 == false) goto L38;
        com.obric.autoaction.b.d r13 = this.floatingIconBinding;
        if (r13 == null) goto L48;
        FrameLayout r14 = r13.f24600c;
        if (r14 == null) goto L48;
        r14.setAlpha(0.5f);
    L48:
        com.obric.autoaction.b.d r15 = this.floatingIconBinding;
        if (r15 == null) goto L78;
        FrameLayout r16 = r15.b();
        if (r16 == null) goto L79;
        r16.post(new $$Lambda$FloatingWindowServiceImpl$wDNNP0fmE44qXBfD3TIKj_T5HnE(this, r4));
        return;
    L79:
        return;
    L78:
        return;
    L38:
        com.obric.autoaction.b.d r17 = this.floatingIconBinding;
        if (r17 == null) goto L43;
        FrameLayout r18 = r17.f24600c;
        if (r18 == null) goto L43;
        r18.setVisibility(0);
    L43:
        com.obric.autoaction.b.d r19 = this.floatingIconBinding;
        if (r19 == null) goto L48;
        FrameLayout r20 = r19.f24600c;
        if (r20 == null) goto L48;
        r20.setAlpha(1.0f);
        goto L48
    L28:
        r12 = false;
    L31:
        r5 = false;
        goto L32
    L54:
        com.obric.autoaction.b.d r21 = this.floatingIconBinding;
        if (r21 == null) goto L80;
        TextView r22 = r21.f24599b;
        if (r22 == null) goto L81;
        CharSequence r23 = r22.getText();
        if (r23 != null) goto L61;
        return;
    L61:
        if (r23.length() > 0) goto L64;
        r5 = false;
    L64:
        if (r5 == false) goto L66;
        r1 = r23;
    L66:
        if (r1 == null) goto L83;
        adjustPositionForExpandedContent(r4);
        com.obric.autoaction.b.d r24 = this.floatingIconBinding;
        if (r24 == null) goto L72;
        LinearLayout r25 = r24.f24598a;
        if (r25 == null) goto L72;
        r25.setVisibility(0);
    L72:
        com.obric.autoaction.b.d r6 = this.floatingIconBinding;
        if (r6 == null) goto L84;
        FrameLayout r26 = r6.f24600c;
        if (r26 == null) goto L85;
        r26.setVisibility(8);
        return;
    L85:
        return;
    L84:
        return;
    L83:
        return;
    L81:
        return;
    L80:
        return;
    L11:
        r4 = null;
    L7:
        r3 = null;
        goto L9
    }

    private static final void toggleExpand$lambda$35(FloatingWindowServiceImpl r3, WindowManager.LayoutParams r4) {
        adjustPositionForCollapsedState$default((FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r3, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin"), r4, false, 2, null);
    }

    private final void handleConfigurationChange() {
        Loog.INSTANCE.d(this.TAG, "handleConfigurationChange");
        com.obric.autoaction.b.d r0 = this.floatingIconBinding;
        if (r0 == null) goto L29;
        FrameLayout r1 = r0.b();
        if (r1 == null) goto L30;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r2, WindowManager.LayoutParams.class) == false) goto L9;
        WindowManager.LayoutParams r3 = (WindowManager.LayoutParams) ZeusTransformUtils.preCheckCast(r2, WindowManager.LayoutParams.class, "com.obric.aiagent.plugin");
    L10:
        if (r3 == null) goto L31;
        com.obric.autoaction.b.d r4 = this.floatingIconBinding;
        boolean r5 = true;
        if (r4 == null) goto L21;
        LinearLayout r6 = r4.f24598a;
        if (r6 == null) goto L21;
        if (((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 != true) goto L21;
    L22:
        if (r5 == false) goto L24;
        adjustPositionForExpandedContent(r3);
    L25:
        WindowManager r8 = this.windowManager;
        if (r8 == null) goto L32;
        r8.updateViewLayout((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L32:
        return;
    L24:
        adjustPositionForCollapsedState(r3, false);
        goto L25
    L18:
        r7 = false;
    L21:
        r5 = false;
        goto L22
    L31:
        return;
    L9:
        r3 = null;
        goto L10
    L30:
        return;
    }

    static /* synthetic */ void adjustPositionForCollapsedState$default(FloatingWindowServiceImpl r1, WindowManager.LayoutParams r2, boolean r3, int r4, Object r5) {
        FloatingWindowServiceImpl r6 = (FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r1, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = true;
    L5:
        r6.adjustPositionForCollapsedState(r2, r3);
    }

    private final void adjustPositionForCollapsedState(WindowManager.LayoutParams r6, boolean r7) {
        Loog.INSTANCE.d(this.TAG, "adjustPositionForCollapsedState");
        com.obric.autoaction.b.d r0 = this.floatingIconBinding;
        if (r0 == null) goto L16;
        FrameLayout r1 = r0.b();
        if (r1 == null) goto L17;
        int[] r2 = calculateCollapsedTargetX(r6, (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
        int r3 = r2[0];
        int r4 = r2[1];
        if (r6.x == r3) goto L9;
    L10:
        if (r7 == false) goto L12;
        animateToPosition(r6, (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), r3, r4);
        return;
    L12:
        r6.x = r3;
        r6.y = r4;
        WindowManager r5 = this.windowManager;
        if (r5 == null) goto L20;
        r5.updateViewLayout((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L20:
        return;
    L9:
        if (r6.y != r4) goto L10;
        return;
    L17:
        return;
    }

    private final int[] calculateCollapsedTargetX(WindowManager.LayoutParams r7, View r8) {
        DisplayMetrics r1 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics();
        int r2 = r1.widthPixels;
        int r3 = r1.heightPixels;
        int r4 = r8.getWidth();
        int r6 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.auto_ai_card_alpha_padding, "dimen", "auto_ai_card_alpha_padding"));
        if (((r7.y + r8.getHeight()) + r6) <= r3) goto L5;
        int r5 = (r3 - r8.getHeight()) - r6;
    L7:
        if ((r7.x + (r4 / 2)) <= (r2 / 2)) goto L9;
        boolean r9 = true;
    L10:
        if (r9 == false) goto L12;
        int r10 = (r2 - r4) + r6;
    L14:
        return new int[]{r10, r5};
    L12:
        r10 = -r6;
        goto L14
    L9:
        r9 = false;
        goto L10
    L5:
        r5 = r7.y;
        goto L7
    }

    private final void animateToPosition(final WindowManager.LayoutParams r11, final View r12, final int r13, final int r14) {
        final int r2 = r11.x;
        final int r4 = r11.y;
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r8.setDuration(250);
        r8.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new OvershootInterpolator(1.2f), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r8.addUpdateListener(new $$Lambda$FloatingWindowServiceImpl$SosW6XoIYGOx3XvCI3FXx_sVFwQ(r11, r2, r13, r4, r14, this, r12));
        r8.start();
    }

    private static final void animateToPosition$lambda$42$lambda$41(WindowManager.LayoutParams r4, int r5, int r6, int r7, int r8, FloatingWindowServiceImpl r9, View r10, ValueAnimator r11) {
        FloatingWindowServiceImpl r12 = (FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r9, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "it");
        float r0 = r5;
        float r13 = r6 - r5;
        Object r14 = r11.getAnimatedValue();
        d.h.b.o.a(r14, "null cannot be cast to non-null type kotlin.Float");
        r4.x = (int) (r0 + (r13 * ((Float) ZeusTransformUtils.preCheckCast(r14, Float.class, "com.obric.aiagent.plugin")).floatValue()));
        float r15 = r7;
        float r16 = r8 - r7;
        Object r17 = r11.getAnimatedValue();
        d.h.b.o.a(r17, "null cannot be cast to non-null type kotlin.Float");
        r4.y = (int) (r15 + (r16 * ((Float) ZeusTransformUtils.preCheckCast(r17, Float.class, "com.obric.aiagent.plugin")).floatValue()));
        WindowManager r18 = r12.windowManager;
        if (r18 == null) goto L6;
        r18.updateViewLayout(r10, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void adjustPositionForExpandedContent(WindowManager.LayoutParams r9) {
        Loog.INSTANCE.d(this.TAG, "adjustPositionForExpandedContent");
        int r1 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels;
        int r2 = d.i.a.a(TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics()));
        com.obric.autoaction.b.d r3 = this.floatingIconBinding;
        if (r3 == null) goto L16;
        LinearLayout r4 = r3.f24598a;
        if (r4 == null) goto L17;
        r4.measure(View.MeasureSpec.makeMeasureSpec(r1, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r5 = r4.getMeasuredWidth();
        int r6 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.auto_ai_card_alpha_padding, "dimen", "auto_ai_card_alpha_padding"));
        int r7 = (r1 + r2) - r5;
        if (r9.x <= r7) goto L18;
        r9.x = d.l.n.c(r7, -r6);
        WindowManager r8 = this.windowManager;
        if (r8 == null) goto L19;
        com.obric.autoaction.b.d r10 = this.floatingIconBinding;
        if (r10 == null) goto L13;
        FrameLayout r11 = r10.b();
    L14:
        r8.updateViewLayout((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        r11 = null;
        goto L14
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final Dialog getAlertDialog() {
        return this.alertDialog;
    }

    public final void setAlertDialog(Dialog r1) {
        this.alertDialog = r1;
    }

    static /* synthetic */ void showInputWindow$default(FloatingWindowServiceImpl r6, String r7, String r8, String r9, String r10, boolean r11, int r12, Bundle r13, int r14, Object r15) {
        FloatingWindowServiceImpl r16 = (FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r6, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        String r17 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        r11 = false;
    L21:
        boolean r4 = r11;
        if ((r14 & 32) == 0) goto L24;
        r12 = 1;
    L24:
        int r5 = r12;
        if ((r14 & 64) == 0) goto L27;
        Bundle r18 = null;
    L28:
        r16.showInputWindow(r17, r1, r2, r3, r4, r5, r18);
        return;
    L27:
        r18 = r13;
        goto L28
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r17 = r7;
        goto L7
    }

    private final void showInputWindow(String r21, String r22, String r23, String r24, boolean r25, final int r26, final Bundle r27) {
        final String r1 = r21;
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.dp(this.TAG, new $$Lambda$FloatingWindowServiceImpl$pixpQRyWQdyq6kZitht4yFeYw7Y(r1, r26), $$Lambda$FloatingWindowServiceImpl$pAktv7RyhO5nyGh9Z_TpjD7pvSI.INSTANCE);
    L7:
        if (r25 == false) goto L19;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == true) goto L19;
        Loog.INSTANCE.d(this.TAG, "showInputWindow, start immediately.");
        maybeStartTask(r1, r26, r27);
        return;
    L11:
        if (d.o.o.d(r5) == true) goto L14;
        r6 = false;
    L19:
        if (com.obric.autogui.common.a.d.f28974a.b() == false) goto L23;
        IAssistInputHost r0 = (IAssistInputHost) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistInputHost.class), IAssistInputHost.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L28;
        IAssistInputHost.DefaultImpls.openInput$default(r0, r21, IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI, null, 4, null);
        return;
    L28:
        return;
    L23:
        com.obric.autoaction.presentation.d r7 = com.obric.autoaction.presentation.d.f24844a;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int r4 = ZeusTransformUtils.mapRes(R.drawable.oic_hand_right_ai_fill_with_bg, "drawable", "oic_hand_right_ai_fill_with_bg");
        String r9 = getString(ZeusTransformUtils.mapRes(R.string.obric_input_window_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_input_window_title"));
        d.h.b.o.c(r9, "getString(...)");
        if (r1 != null) goto L26;
        r1 = this.lastInputText;
    L26:
        Integer r10 = Integer.valueOf(r4);
        m r11 = new $$Lambda$FloatingWindowServiceImpl$HfeMpT4ZaNAMCVKl66Mygj5pg(this, r26, r27);
        m r12 = new $$Lambda$FloatingWindowServiceImpl$PH4BkxlM5NDT2aC7mWPbb8QWJfI(this);
        this.alertDialog = com.obric.autoaction.presentation.d.a(r7, r8, r10, r9, "", r11, r12, r23, r24, r1, r22, null, 1024, null);
        return;
    L5:
        Loog.INSTANCE.dp(this.TAG, new $$Lambda$FloatingWindowServiceImpl$T_zdqnXzJq4dea2l0Q3DKQN7h8g(r1, r26), $$Lambda$FloatingWindowServiceImpl$KyGwMwjsyeaQudki0reT_1zjhw.INSTANCE);
        goto L7
    }

    private static final String showInputWindow$lambda$44(String r2, int r3) {
        return "showInputWindow, presetQuery: " + r2 + ", launchedOrigin: " + r3;
    }

    private static final String showInputWindow$lambda$46(String r3, int r4) {
        StringBuilder r0 = new StringBuilder().append("showInputWindow, presetQuery: ");
        if (r3 == null) goto L5;
        Character r5 = Character.valueOf(d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")));
    L7:
        return r0.append(r5).append("..., launchedOrigin: ").append(r4).toString();
    L5:
        r5 = null;
        goto L7
    }

    private static final x showInputWindow$lambda$48(FloatingWindowServiceImpl r2, int r3, Bundle r4, String r5, String r6) {
        FloatingWindowServiceImpl r7 = (FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "inputText");
        d.h.b.o.e(r6, "fullInput");
        r7.maybeStartTask(r6, r3, r4);
        return x.f38692a;
    }

    private static final x showInputWindow$lambda$49(FloatingWindowServiceImpl r2, String r3, String r4) {
        FloatingWindowServiceImpl r5 = (FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "inputText");
        d.h.b.o.e(r4, "fullInput");
        r5.lastInputText = r3;
        return x.f38692a;
    }

    static /* synthetic */ void maybeStartTask$default(FloatingWindowServiceImpl r1, String r2, int r3, Bundle r4, int r5, Object r6) {
        FloatingWindowServiceImpl r7 = (FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r1, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = null;
    L5:
        r7.maybeStartTask(r2, r3, r4);
    }

    private final void maybeStartTask(String r4, int r5, Bundle r6) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_input_content_required, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_input_content_required")), CharSequence.class, "com.obric.aiagent.plugin"), 0).show();
        return;
    L12:
        currentQuery = r4;
        this.viewModel.a(r4, false, r5, r6);
        return;
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Service*/.onDestroy();
        com.obric.autoaction.e.b.f24680a.a(this.TAG, "onDestroy");
        hideFloatingWindow();
        this.viewModel.b();
        ZeusTransformUtils.unregisterReceiver(this, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.orientationReceiver, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }
}
