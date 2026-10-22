package com.obric.autoaction.presentation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.autoaction.presentation.biztrack.PlayerActionTracker;
import com.obric.autoaction.presentation.view.GradientTextView;
import com.obric.autoaction.presentation.view.LockableScrollView;
import com.obric.autoaction.presentation.view.PlayerBubble;
import com.obric.autoaction.presentation.view.TouchAwareConstraintLayout;
import com.obric.autoaction.presentation.widget.AutoAgentEventToWidgetStateImpl;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEvent;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolder;
import com.obric.autogui.common.api.agent.blacklist.AppBlackListState;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback;
import com.obric.autogui.common.api.space.monitor.DisplayHost;
import com.obric.autogui.common.api.space.monitor.OperatingSpaceMonitor;
import com.obric.autogui.common.api.space.status.SpaceStatus;
import com.obric.autogui.common.api.space.status.SpaceStatusCallback;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.livecard.api.entity.CommonCollapseTemplate;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.Text;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUIFrameLayout;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.r;
import d.h.b.s;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: SurfaceCardActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SurfaceCardActivity extends BaseActivity implements HandUsingEventsCallback {
    static final /* synthetic */ d.m.h<Object>[] $$delegatedProperties = null;
    public static final int AUTO_EXIT_TIMEOUT_MILLIS = 5;
    public static final String CLICK_POS_KEY = "clicked_pos";
    public static final a Companion = null;
    public static final long DEFAULT_SWIPE_DURATION = 500;
    public static final String FROM_STREAMING_KEY = "from_streaming";
    public static final String SWIPE_DURATION_KEY = "swiped_duration";
    public static final String SWIPE_POS_KEY = "swiped_pos";
    public static final String TAG = "SurfaceCardActivity";
    public static final long TEXT_ANIM_DURATION = 500;
    private static volatile boolean isResumed;
    private static volatile boolean isStarted;
    private final boolean USE_ASSIST_INPUT;
    public com.obric.autoaction.b.b binding;
    private boolean bound;
    private Dialog clarifyAddingDialog;
    private EditText clarifyEditText;
    private View clarifyInputArea;
    private int collapsedHeight;
    private final SurfaceCardActivity$connection$1 connection;
    private com.obric.common.oea.foundation.animation.manager.d currentAlphaAnim;
    private com.obric.common.oea.foundation.animation.manager.d currentScaleAnim;
    private final d.h.a.b<Boolean, x> debounceConfigSecureIsland;
    private ca delayFinishJob;
    private final d.j.c draftUserClarifyInfo$delegate;
    private IAutoActionAgentEventListener.AgentStepExecInfo execInfo;
    private int expandedHeight;
    private FloatingWindowServiceImpl floatingWindowService;
    private boolean inBlockingStatus;
    private boolean isBindingInitialized;
    private boolean isCallUserInProgress;
    private boolean isCallUserOver;
    private boolean isClarifyInputDone;
    private boolean isClarifyInputInflate;
    private boolean isExpanded;
    private boolean isInHandUsingMode;
    private boolean isShadowHideAnimating;
    private boolean isShadowShowAnimating;
    private boolean isTaskSuccess;
    private final PlayerBubble.b kBubbleCallUser;
    private final PlayerBubble.b kBubbleOrdinary;
    private com.obric.autoaction.presentation.function.c mActiveAutoResumer;
    private boolean mBubbled;
    private boolean mFirstBubbled;
    private final b mMonitorImpl;
    private boolean mStartedSurfaceViewTouching;
    private final boolean mUsingBubbledThinkingCard;
    private final d.f playerActionTracker$delegate;
    private final List<String> readyToSubmitAdditionContent;
    private com.obric.autoaction.userreport.a reportController;
    private IAutoActionAgentEventListener.SessionInfo sessionInfo;
    private final float shadowHideY;
    private float shadowShowY;
    private int statusBarAppearance;
    private IAutoActionAgentEventListener.AgentStepInfo stepInfo;
    private boolean taskTerminate;
    private ca textAnimationJob;
    private final d.j.c userAdditionContent$delegate;
    private String userClarifyInfo;
    private final d.f viewModel$delegate;

    /* JADX INFO: compiled from: SurfaceCardActivity.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final boolean a() {
            return SurfaceCardActivity.access$isStarted$cp();
        }
    }

    /* JADX INFO: compiled from: SurfaceCardActivity.kt */
    public final class b implements OperatingSpaceMonitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SurfaceCardActivity f24765a;

        public b(SurfaceCardActivity r3) {
            this.f24765a = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.autogui.common.api.space.monitor.OperatingSpaceMonitor
        public DisplayHost getHost() {
            SurfaceView r2 = this.f24765a.getBinding().y;
            d.h.b.o.c(r2, "surfaceView");
            return (DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Surface(r2), DisplayHost.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SurfaceCardActivity.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24766a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f24767b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f24768c = null;

        static {
            int[] r0 = new int[DisplayAccessor.Rotation.values().length];
            r0[DisplayAccessor.Rotation.Rotation0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L36:
            r0[DisplayAccessor.Rotation.Rotation90.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L48:
            r0[DisplayAccessor.Rotation.Rotation180.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L38:
            r0[DisplayAccessor.Rotation.Rotation270.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L10:
            f24766a = r0;
            int[] r1 = new int[BizStatus.values().length];
            r1[BizStatus.TERMINATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L42:
            r1[BizStatus.OPERATING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L30:
            r1[BizStatus.PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L40:
            r1[BizStatus.USER_INTERRUPTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L15:
            f24767b = r1;
            int[] r2 = new int[com.obric.autoaction.presentation.function.a.b.values().length];
            r2[com.obric.autoaction.presentation.function.a.b.f24911c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L34:
            r2[com.obric.autoaction.presentation.function.a.b.f24909a.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L18:
            f24768c = r2;
        }
    }

    /* JADX INFO: compiled from: SurfaceCardActivity.kt */
    /* synthetic */ class d extends d.h.b.l implements d.h.a.b<Boolean, x> {
        d(Object r8) {
            super(1, r8, SurfaceCardActivity.class, "configSecureIsland", "configSecureIsland(Z)V", 0);
        }

        public final void a(boolean r3) {
            SurfaceCardActivity.access$configSecureIsland((SurfaceCardActivity) ZeusTransformUtils.preCheckCast(this.receiver, SurfaceCardActivity.class, "com.obric.aiagent.plugin"), r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Boolean r3) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SurfaceCardActivity.kt */
    @d.c.b.a.f(b = "SurfaceCardActivity.kt", c = {2570}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.SurfaceCardActivity$delayAssistClarifyInputShow$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f24770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SurfaceCardActivity f24771c;

        e(long r3, SurfaceCardActivity r5, d.c.d<? super e> r6) {
            SurfaceCardActivity r7 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r5, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24770b = r3;
            this.f24771c = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f24770b, this.f24771c, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24769a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            IAssistInputHost r8 = (IAssistInputHost) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistInputHost.class), IAssistInputHost.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L14;
            IAssistInputHost.DefaultImpls.openInput$default(r8, true, null, 2, null);
        L14:
            this.f24771c.getBinding().f24591c.setEnabled(true);
            this.f24771c.getBinding().j.setEnabled(true);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            long r4 = this.f24770b;
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24769a = 1;
            if (ax.a(r4, r9) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SurfaceCardActivity.kt */
    @d.c.b.a.f(b = "SurfaceCardActivity.kt", c = {753}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.SurfaceCardActivity$handleStepEvent$3$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SurfaceCardActivity f24773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.presentation.b.C0576b f24774c;

        /* JADX INFO: renamed from: com.obric.autoaction.presentation.SurfaceCardActivity$f$1, reason: invalid class name */
        /* JADX INFO: compiled from: SurfaceCardActivity.kt */
        @d.c.b.a.f(b = "SurfaceCardActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.SurfaceCardActivity$handleStepEvent$3$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24775a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SurfaceCardActivity f24776b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.autoaction.presentation.b.C0576b f24777c;

            AnonymousClass1(SurfaceCardActivity r3, com.obric.autoaction.presentation.b.C0576b r4, d.c.d<? super AnonymousClass1> r5) {
                SurfaceCardActivity r6 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24776b = r6;
                this.f24777c = r4;
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f24776b, this.f24777c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f24775a != 0) goto L7;
                d.o.a(r3);
                this.f24776b.getBinding().E.setScrollable(true);
                SurfaceCardActivity.access$updateContentText(this.f24776b, (CharSequence) ZeusTransformUtils.preCheckCast(this.f24777c.a().getThought(), CharSequence.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        f(SurfaceCardActivity r3, com.obric.autoaction.presentation.b.C0576b r4, d.c.d<? super f> r5) {
            SurfaceCardActivity r6 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24773b = r6;
            this.f24774c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f24773b, this.f24774c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24772a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            d.c.g r9 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin");
            d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f24773b, this.f24774c, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24772a = 1;
            if (kotlinx.coroutines.i.a(r9, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SurfaceCardActivity.kt */
    @d.c.b.a.f(b = "SurfaceCardActivity.kt", c = {798}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.SurfaceCardActivity$handleStreamingThought$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.presentation.b.h f24779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SurfaceCardActivity f24780c;

        /* JADX INFO: renamed from: com.obric.autoaction.presentation.SurfaceCardActivity$g$1, reason: invalid class name */
        /* JADX INFO: compiled from: SurfaceCardActivity.kt */
        @d.c.b.a.f(b = "SurfaceCardActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.SurfaceCardActivity$handleStreamingThought$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24781a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.obric.autoaction.presentation.b.h f24782b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SurfaceCardActivity f24783c;

            AnonymousClass1(com.obric.autoaction.presentation.b.h r3, SurfaceCardActivity r4, d.c.d<? super AnonymousClass1> r5) {
                SurfaceCardActivity r6 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r4, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24782b = r3;
                this.f24783c = r6;
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f24782b, this.f24783c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f24781a != 0) goto L13;
                d.o.a(r4);
                if (this.f24782b.b() == false) goto L8;
                this.f24783c.getBinding().E.setScrollable(true);
                SurfaceCardActivity r3 = this.f24783c;
                String r5 = r3.getString(ZeusTransformUtils.mapRes(R.string.surface_card_thinking_next_op, WsChannelMultiProcessSharedProvider.STRING_TYPE, "surface_card_thinking_next_op"));
                d.h.b.o.c(r5, "getString(...)");
                SurfaceCardActivity.access$updateTitleText(r3, (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"));
            L11:
                return x.f38692a;
            L8:
                if (this.f24782b.a() == null) goto L11;
                this.f24783c.getBinding().E.setScrollable(false);
                SurfaceCardActivity.access$updateContentText(this.f24783c, (CharSequence) ZeusTransformUtils.preCheckCast(this.f24782b.a(), CharSequence.class, "com.obric.aiagent.plugin"));
                goto L11
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        g(com.obric.autoaction.presentation.b.h r3, SurfaceCardActivity r4, d.c.d<? super g> r5) {
            SurfaceCardActivity r6 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r4, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24779b = r3;
            this.f24780c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f24779b, this.f24780c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24778a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            d.c.g r9 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin");
            d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f24779b, this.f24780c, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24778a = 1;
            if (kotlinx.coroutines.i.a(r9, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SurfaceCardActivity.kt */
    @d.c.b.a.f(b = "SurfaceCardActivity.kt", c = {878}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.SurfaceCardActivity$handleTermination$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SurfaceCardActivity f24785b;

        h(SurfaceCardActivity r3, d.c.d<? super h> r4) {
            SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24785b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f24785b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24784a;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            IAutoActionAgentEventListener.AgentStepInfo r8 = SurfaceCardActivity.access$getStepInfo$p(this.f24785b);
            if (r8 == null) goto L18;
            Bundle r9 = r8.getExtras();
            if (r9 == null) goto L18;
            if (r9.getBoolean("open_app", false) != true) goto L18;
        L19:
            Loog.INSTANCE.d(SurfaceCardActivity.TAG, "open app by model config (delayed) " + r3);
            if (r3 == false) goto L25;
            this.f24785b.finish();
            FloatingWindowServiceImpl r10 = (FloatingWindowServiceImpl) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(SurfaceCardActivity.access$getFloatingWindowService$p(this.f24785b), "com.obric.aiagent.plugin"), FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L25;
            r10.startAppOnMainDisplay((Context) ZeusTransformUtils.preCheckCast(this.f24785b, Context.class, "com.obric.aiagent.plugin"));
        L25:
            return x.f38692a;
        L18:
            r3 = false;
            goto L19
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24784a = 1;
            if (ax.a(300, r11) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SurfaceCardActivity.kt */
    @d.c.b.a.f(b = "SurfaceCardActivity.kt", c = {820}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.SurfaceCardActivity$launchTextAnimation$3")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SurfaceCardActivity f24788c;

        i(String r3, SurfaceCardActivity r4, d.c.d<? super i> r5) {
            SurfaceCardActivity r6 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r4, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24787b = r3;
            this.f24788c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f24787b, this.f24788c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24786a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            kotlinx.coroutines.b.h r11 = com.obric.autogui.animation.b.a(this.f24787b, 500, null, 2, null);
            final SurfaceCardActivity r3 = this.f24788c;
            kotlinx.coroutines.b.i r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24786a = 1;
            if (r11.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SurfaceCardActivity.kt */
    public static final class j implements SpaceStatusCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SurfaceCardActivity f24793a;

        public static /* synthetic */ void lambda$s1VS9AIN1wU0Y6TEclSpHX1MBxk(SurfaceCardActivity r0) {
            b(r0);
        }

        public static /* synthetic */ void lambda$xsWYCnQCz93T1lzg3HeNjLo2KeU(SurfaceCardActivity r0) {
            a(r0);
        }

        j(SurfaceCardActivity r3) {
            this.f24793a = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.autogui.common.api.space.status.SpaceStatusCallback
        public void onSecureChanged(boolean r4) {
            Loog.INSTANCE.i(SurfaceCardActivity.TAG, "the display has been set to " + r4);
            if (r4 == false) goto L5;
            SurfaceView r5 = this.f24793a.getBinding().y;
            final SurfaceCardActivity r3 = this.f24793a;
            r5.post(new $$Lambda$SurfaceCardActivity$j$xsWYCnQCz93T1lzg3HeNjLo2KeU(r3));
            return;
        L5:
            SurfaceView r6 = this.f24793a.getBinding().y;
            final SurfaceCardActivity r7 = this.f24793a;
            r6.post(new $$Lambda$SurfaceCardActivity$j$s1VS9AIN1wU0Y6TEclSpHX1MBxk(r7));
        }

        private static final void a(SurfaceCardActivity r2) {
            ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).getWindow().addFlags(8192);
        }

        private static final void b(SurfaceCardActivity r2) {
            ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).getWindow().clearFlags(8192);
        }

        @Override // com.obric.autogui.common.api.space.status.SpaceStatusCallback
        public void onStatusBarAppearanceChanged(int r2) {
            SurfaceCardActivity.access$setStatusBarAppearance$p(this.f24793a, r2);
            SurfaceCardActivity r1 = this.f24793a;
            SurfaceCardActivity.access$configureStatusBarAppearance(r1, SurfaceCardActivity.access$getStatusBarAppearance$p(r1));
        }
    }

    /* JADX INFO: compiled from: SurfaceCardActivity.kt */
    @d.c.b.a.f(b = "SurfaceCardActivity.kt", c = {387}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.SurfaceCardActivity$setupEventFlowCollection$1")
    static final class k extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SurfaceCardActivity f24795b;

        /* JADX INFO: renamed from: com.obric.autoaction.presentation.SurfaceCardActivity$k$1, reason: invalid class name */
        /* JADX INFO: compiled from: SurfaceCardActivity.kt */
        @d.c.b.a.f(b = "SurfaceCardActivity.kt", c = {388}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.SurfaceCardActivity$setupEventFlowCollection$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24796a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SurfaceCardActivity f24797b;

            AnonymousClass1(SurfaceCardActivity r3, d.c.d<? super AnonymousClass1> r4) {
                SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24797b = r5;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f24797b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f24796a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                d.o.a(r6);
            L12:
                throw new d.d();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                ab<com.obric.autoaction.presentation.b> r7 = com.obric.autoaction.presentation.c.f24841a.a();
                final SurfaceCardActivity r3 = this.f24797b;
                kotlinx.coroutines.b.i<? super com.obric.autoaction.presentation.b> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new C05741(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24796a = 1;
                if (r7.collect(r2, r4) != r0) goto L12;
                return r0;
            }
        }

        k(SurfaceCardActivity r3, d.c.d<? super k> r4) {
            SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24795b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f24795b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24794a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            p r9 = (p) ZeusTransformUtils.preCheckCast(this.f24795b, p.class, "com.obric.aiagent.plugin");
            androidx.lifecycle.i.b r2 = androidx.lifecycle.i.b.f2056c;
            d.h.a.m r4 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f24795b, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24794a = 1;
            if (androidx.lifecycle.ab.a(r9, r2, r4, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class l extends d.h.b.p implements d.h.a.a<androidx.lifecycle.am.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f24799a;

        public l(ComponentActivity r3) {
            this.f24799a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.am.b invoke() {
            return a();
        }

        public final androidx.lifecycle.am.b a() {
            androidx.lifecycle.am.b r1 = this.f24799a.getDefaultViewModelProviderFactory();
            d.h.b.o.c(r1, "defaultViewModelProviderFactory");
            return r1;
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class m extends d.h.b.p implements d.h.a.a<ao> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f24800a;

        public m(ComponentActivity r3) {
            this.f24800a = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.aiagent.plugin");
            super(0);
        }

        public final ao a() {
            ao r1 = this.f24800a.getViewModelStore();
            d.h.b.o.c(r1, "viewModelStore");
            return r1;
        }

        @Override // d.h.a.a
        public /* synthetic */ ao invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class n extends d.h.b.p implements d.h.a.a<androidx.lifecycle.a.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f24802b;

        public n(d.h.a.a r3, ComponentActivity r4) {
            d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            ComponentActivity r6 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r4, ComponentActivity.class, "com.obric.aiagent.plugin");
            this.f24801a = r5;
            this.f24802b = r6;
            super(0);
        }

        public final androidx.lifecycle.a.a a() {
            d.h.a.a r0 = this.f24801a;
            if (r0 == null) goto L6;
            androidx.lifecycle.a.a r1 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r0.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L6;
            return r1;
        L6:
            androidx.lifecycle.a.a r2 = this.f24802b.getDefaultViewModelCreationExtras();
            d.h.b.o.c(r2, "this.defaultViewModelCreationExtras");
            return r2;
        }

        @Override // d.h.a.a
        public /* synthetic */ androidx.lifecycle.a.a invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: SurfaceCardActivity.kt */
    @d.c.b.a.f(b = "SurfaceCardActivity.kt", c = {1569}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.SurfaceCardActivity$updateCardContent$8$1")
    static final class o extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SurfaceCardActivity f24804b;

        o(SurfaceCardActivity r3, d.c.d<? super o> r4) {
            SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24804b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f24804b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24803a;
            Boolean r2 = null;
            boolean r4 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L11:
            IAutoActionAgentApi.SessionShareInfo r9 = (IAutoActionAgentApi.SessionShareInfo) ZeusTransformUtils.preCheckCast(r8, IAutoActionAgentApi.SessionShareInfo.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L14;
            String r3 = r9.getShareUrl();
        L16:
            if (r3 != null) goto L18;
        L23:
            boolean r5 = false;
        L25:
            if (r5 == false) goto L29;
            Loog.INSTANCE.d(SurfaceCardActivity.TAG, "hasShareUrl, openUrl: " + r3);
            IAutoActionPresentationApi r6 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L38;
            Context r7 = (Context) ZeusTransformUtils.preCheckCast(this.f24804b, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.a(r3);
            r6.openSharingWebView(r7, r3, r9.getSessionId(), "oauto_player");
        L38:
            return x.f38692a;
        L29:
            Loog r10 = Loog.INSTANCE;
            StringBuilder r11 = new StringBuilder().append("noShareUrl, shareUrl is empty: ");
            if (r3 != null) goto L32;
        L36:
            r10.d(SurfaceCardActivity.TAG, r11.append(r2).toString());
            goto L38
        L32:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() == 0) goto L35;
            r4 = false;
        L35:
            r2 = d.c.b.a.b.a(r4);
            goto L36
        L18:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L20;
            boolean r12 = true;
        L21:
            if (r12 != true) goto L23;
            r5 = true;
            goto L25
        L20:
            r12 = false;
            goto L21
        L14:
            r3 = null;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            IAutoActionAgentApi r13 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
            d.c.d r14 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24803a = 1;
            r8 = IAutoActionAgentApi.DefaultImpls.fetchSessionShareUrl$default(r13, null, r14, 1, null);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    private static final String hideShadowLayout$lambda$79$lambda$78() {
        return "hideShadowLayout animation error";
    }

    private static final String initViewState$lambda$36() {
        return "[SurfaceCard] syncing status";
    }

    public static /* synthetic */ String lambda$2HKivmxiid5RqQNFuVYkbEWbb_M() {
        return hideShadowLayout$lambda$79$lambda$78();
    }

    public static /* synthetic */ String lambda$AA_h8A9W7JcayyiLpM2NtW41HZ0(String r0, SurfaceCardActivity r1) {
        return launchTextAnimation$lambda$22(r0, r1);
    }

    public static /* synthetic */ x lambda$CH99bO9sdrHV09yYX4v0ofKEZ7E(SurfaceCardActivity r0) {
        return setupClickListeners$lambda$7(r0);
    }

    public static /* synthetic */ void lambda$DQLCFYvGII5XUV8fEMJiA0FI4YU(SurfaceCardActivity r0, ValueAnimator r1) {
        collapseCard$lambda$68$lambda$67(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$EAQAWScWYlY9quJzKzd-GyZLKZE, reason: not valid java name */
    public static /* synthetic */ void m598lambda$EAQAWScWYlY9quJzKzdGyZLKZE(SurfaceCardActivity r0) {
        toggleCardState$lambda$59(r0);
    }

    public static /* synthetic */ String lambda$EHEPOj7fRO7jQ5UCN5UruQ4raIA(Throwable r0) {
        return hideShadowLayout$lambda$79$lambda$77(r0);
    }

    /* JADX INFO: renamed from: lambda$FP3Sp4dTpIZj-P8ouvEl4zhUTTI, reason: not valid java name */
    public static /* synthetic */ void m599lambda$FP3Sp4dTpIZjP8ouvEl4zhUTTI(SurfaceCardActivity r0, ValueAnimator r1) {
        expandCard$lambda$61$lambda$60(r0, r1);
    }

    public static /* synthetic */ void lambda$FfX33OxBZP94r0mTIzjQShpxWIU(SurfaceCardActivity r0) {
        setupCardCollapsedHeight$lambda$18(r0);
    }

    /* JADX INFO: renamed from: lambda$GrXAZpzuXbEapp4lmXl1-Yn0wJk, reason: not valid java name */
    public static /* synthetic */ void m600lambda$GrXAZpzuXbEapp4lmXl1Yn0wJk(SurfaceCardActivity r0, View r1) {
        setupClickListeners$lambda$16(r0, r1);
    }

    public static /* synthetic */ void lambda$IIfHayFc7sWt4xv54kqIxaAAwt4(SurfaceCardActivity r0, IAutoAgentWidgetStateListener.ClarifyOptions r1, View r2) {
        configGuiClarifyOptions$lambda$56(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$IXjwkDsfUAbBqwmsZmzHG8aWcEk(SurfaceCardActivity r0, View r1) {
        updateCardContent$lambda$44(r0, r1);
    }

    public static /* synthetic */ String lambda$JGIrVwTpCwFnrfatheMZr03sIf0(SurfaceCardActivity r0) {
        return launchTextAnimation$lambda$23(r0);
    }

    public static /* synthetic */ void lambda$OhbpU3RuCTDuQ6JsJuRR7vC13_k(SurfaceCardActivity r0) {
        fixCallUserStateForInitViewState$lambda$38(r0);
    }

    public static /* synthetic */ void lambda$PZ_MG6gp_3SjyX5IfjGofWH5jRU(SurfaceCardActivity r0, View r1, View r2) {
        updateCardContent$lambda$50$lambda$49$lambda$48(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$QsSpSK9uLc3QJSRD1iEbffa91v0(SurfaceCardActivity r0) {
        onResume$lambda$73(r0);
    }

    public static /* synthetic */ void lambda$TFm50NQwKHZIBfWVeCjdbUDwewE(View r0) {
        setupClickListeners$lambda$13(r0);
    }

    public static /* synthetic */ PlayerActionTracker lambda$U6FSHjP8FALsq8lPQ3g8S219Enc(SurfaceCardActivity r0) {
        return playerActionTracker_delegate$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$UUZsW5kEMYn9DAHI8YICKSLVViw(SurfaceCardActivity r0) {
        updateContentText$lambda$58(r0);
    }

    /* JADX INFO: renamed from: lambda$V38mKmf_crBG17gR-XVANybSrO4, reason: not valid java name */
    public static /* synthetic */ void m601lambda$V38mKmf_crBG17gRXVANybSrO4(SurfaceCardActivity r0, View r1) {
        updateCardContent$lambda$54(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$W1rb1-SyzZS_KDWz21vfDE7k2ZY, reason: not valid java name */
    public static /* synthetic */ void m602lambda$W1rb1SyzZS_KDWz21vfDE7k2ZY(SurfaceCardActivity r0) {
        updateCardContent$lambda$45(r0);
    }

    public static /* synthetic */ void lambda$W9GNKu7LR4xX9XsgxBmf2d9BinE(SurfaceCardActivity r0, View r1) {
        setupClickListeners$lambda$6(r0, r1);
    }

    public static /* synthetic */ x lambda$Z6LBQvPwdtxJirZw7ROqfF2sNPA(ImageView r0, boolean r1, Throwable r2) {
        return showTrackIcon$lambda$29$lambda$28(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$_2VObSv9vfMb24LI5bROeqcTDX0() {
        return showShadowLayout$lambda$82$lambda$81();
    }

    public static /* synthetic */ void lambda$aAKwaeLZ59iCymUlf5dLXHlYF3o(SurfaceCardActivity r0, View r1) {
        setupClickListeners$lambda$11(r0, r1);
    }

    public static /* synthetic */ void lambda$aC3lS369zwhrF2G3_kipV2dDSK0(SurfaceCardActivity r0, View r1) {
        setupClickListeners$lambda$8(r0, r1);
    }

    public static /* synthetic */ x lambda$bcl4EJqns55bVCYWKMEkZqEJPhg(SurfaceCardActivity r0, boolean r1, Throwable r2) {
        return animateShowCardLayout$lambda$87(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$bjH_1d22NE1suuR9AZTMFMUpoKs(SurfaceCardActivity r0, String r1) {
        return updateCardContent$lambda$44$lambda$43(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$cu1W30_oaCfO00PBPeUzfVT-kJM, reason: not valid java name */
    public static /* synthetic */ void m603lambda$cu1W30_oaCfO00PBPeUzfVTkJM(SurfaceCardActivity r0, View r1) {
        setupClickListeners$lambda$12(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$dKiDUk-FR7q67TjKtJQxazTsYvs, reason: not valid java name */
    public static /* synthetic */ void m604lambda$dKiDUkFR7q67TjKtJQxazTsYvs(SurfaceCardActivity r0, View r1) {
        setupClickListeners$lambda$15(r0, r1);
    }

    public static /* synthetic */ x lambda$dbVHXiyrSeSe918IS3pvlTIi90Y(SurfaceCardActivity r0, boolean r1, Throwable r2) {
        return showShadowLayout$lambda$82(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$e7gadq8DHvsVXl31QQjMdqpoMaQ(SurfaceCardActivity r0, View r1) {
        setupClickListeners$lambda$17(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$fHn1d77_hRnWV7Q-cjsQRBt0oqs, reason: not valid java name */
    public static /* synthetic */ void m605lambda$fHn1d77_hRnWV7QcjsQRBt0oqs(SurfaceCardActivity r0) {
        updateCardContent$lambda$41(r0);
    }

    public static /* synthetic */ void lambda$fmCoEMnnMRIGaVWfd1Eui9dqjLA(SurfaceCardActivity r0, View r1) {
        setupClickListeners$lambda$10(r0, r1);
    }

    public static /* synthetic */ void lambda$hwXpZza4yND4_8N6sjKnBJPVc3E(SurfaceCardActivity r0) {
        animateShowCardLayout$lambda$88(r0);
    }

    public static /* synthetic */ void lambda$i8KdTPrcuQXIoE20jyhNlpQvLzI(SurfaceCardActivity r0, View r1) {
        setupClickListeners$lambda$14(r0, r1);
    }

    public static /* synthetic */ String lambda$isdfGL5c0SyXO7kUGCKJepTWFYo(Throwable r0) {
        return showShadowLayout$lambda$82$lambda$80(r0);
    }

    public static /* synthetic */ void lambda$j1NBM0QUyRHzp6uJWcdvKIOMfWA(SurfaceCardActivity r0, ViewStub r1, View r2) {
        updateCardContent$lambda$50(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$jzXYFniqgWGPPzUy3k1j8feGsuU(SurfaceCardActivity r0, ValueAnimator r1) {
        expandCard$lambda$63$lambda$62(r0, r1);
    }

    public static /* synthetic */ WindowInsets lambda$lvczHBCliEjMSZ2iynl9zyUcb6g(SurfaceCardActivity r0, View r1, WindowInsets r2) {
        return setupWindowInsets$lambda$5(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$nkMvBqWp_5pWrgjOta-85Kxx4Vg, reason: not valid java name */
    public static /* synthetic */ void m606lambda$nkMvBqWp_5pWrgjOta85Kxx4Vg(OButton r0) {
        configGuiClarifyOptions$lambda$57(r0);
    }

    /* JADX INFO: renamed from: lambda$rJaU5MujN-ZYcr2wuexQDnVczaw, reason: not valid java name */
    public static /* synthetic */ void m607lambda$rJaU5MujNZYcr2wuexQDnVczaw(SurfaceCardActivity r0) {
        animateHideCardLayout$lambda$85(r0);
    }

    public static /* synthetic */ void lambda$sEhTFoRYHVLTahWccSK3P3ZAYIE(SurfaceCardActivity r0, View r1) {
        setupClickListeners$lambda$9(r0, r1);
    }

    public static /* synthetic */ x lambda$tX6kpm1ZxNwkvm9_WWUJy4oi8j8(SurfaceCardActivity r0, boolean r1, Throwable r2) {
        return hideShadowLayout$lambda$79(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$v8y78ua9mgVjjM22B7_Su7_hBZA(EditText r0, SurfaceCardActivity r1) {
        updateCardContent$lambda$53$lambda$51(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$vli5FHFHGVaZOCD4Es2A-aAJBHM, reason: not valid java name */
    public static /* synthetic */ x m608lambda$vli5FHFHGVaZOCD4Es2AaAJBHM(SurfaceCardActivity r0, boolean r1, Throwable r2) {
        return handleAfterStepEvent$lambda$25(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$vvwLLWSeOjQFK3b9fu-vgdEvc30, reason: not valid java name */
    public static /* synthetic */ void m609lambda$vvwLLWSeOjQFK3b9fuvgdEvc30(View r0, boolean r1) {
        updateCardContent$lambda$53$lambda$52(r0, r1);
    }

    public static /* synthetic */ String lambda$xGHJEuUsMPFlwUWHDFOlX41Jmi0(com.obric.autoaction.presentation.b.c r0) {
        return initViewState$lambda$35(r0);
    }

    /* JADX INFO: renamed from: lambda$xiHYsrlDn4Eyp8Vlv-P1pZWRg1I, reason: not valid java name */
    public static /* synthetic */ String m610lambda$xiHYsrlDn4Eyp8VlvP1pZWRg1I() {
        return initViewState$lambda$36();
    }

    /* JADX INFO: renamed from: lambda$y1cdxqI4D9Z0lTRVDJi-SOfIlMo, reason: not valid java name */
    public static /* synthetic */ void m611lambda$y1cdxqI4D9Z0lTRVDJiSOfIlMo(SurfaceCardActivity r0, ValueAnimator r1) {
        collapseCard$lambda$66$lambda$65(r0, r1);
    }

    public static /* synthetic */ x lambda$yY_IDbi2uQNty_LdU9tbzocSVpc(SurfaceCardActivity r0, boolean r1, Throwable r2) {
        return animateHideCardLayout$lambda$84(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$zMNaKELrUQ8_XzF6W_oDvcYtL6o(ImageView r0, float r1, float r2, float r3, float r4, ValueAnimator r5) {
        showScrollPath$lambda$32$lambda$31$lambda$30(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ x lambda$zsCYmdtm79t22ccLeodgwT8Cbwo(ImageView r0, boolean r1, Throwable r2) {
        return showTrackIcon$lambda$29$lambda$28$lambda$27(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$zykCuMbGDTsRPcDcWYaGtCHxOi4(SurfaceCardActivity r0, boolean r1, Throwable r2) {
        return onResume$lambda$72(r0, r1, r2);
    }

    private static final String showShadowLayout$lambda$82$lambda$81() {
        return "showShadowLayout animation error";
    }

    public final void handleOperatingAppChangedEvent(com.obric.autoaction.presentation.b.f r1) {
        d.h.b.o.e(r1, "event");
    }

    /* JADX WARN: Type inference failed for: r1v18, types: [com.obric.autoaction.presentation.SurfaceCardActivity$connection$1] */
    public SurfaceCardActivity() {
        this.isExpanded = true;
        ComponentActivity r1 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.aiagent.plugin");
        this.viewModel$delegate = (d.f) ZeusTransformUtils.preCheckCast(new al(aa.b(com.obric.autoaction.presentation.widget.a.class), (d.h.a.a) ZeusTransformUtils.preCheckCast(new m(r1), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new l(r1), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new n(null, r1), d.h.a.a.class, "com.obric.aiagent.plugin")), d.f.class, "com.obric.aiagent.plugin");
        this.readyToSubmitAdditionContent = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.userAdditionContent$delegate = com.obric.autoaction.presentation.f.a("");
        this.draftUserClarifyInfo$delegate = com.obric.autoaction.presentation.f.a("");
        this.userClarifyInfo = "";
        this.statusBarAppearance = 8;
        this.playerActionTracker$delegate = d.g.a(new $$Lambda$SurfaceCardActivity$U6FSHjP8FALsq8lPQ3g8S219Enc(this));
        this.USE_ASSIST_INPUT = com.obric.autogui.common.a.d.f28974a.b();
        this.connection = new SurfaceCardActivity$connection$1(this);
        this.debounceConfigSecureIsland = com.obric.autogui.util.e.a(100, (am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        this.kBubbleOrdinary = new PlayerBubble.b(ZeusTransformUtils.mapRes(R.drawable.ai_thinking_bubble_icon, "drawable", "ai_thinking_bubble_icon"), null, 2, null);
        this.kBubbleCallUser = new PlayerBubble.b(ZeusTransformUtils.mapRes(R.drawable.floating_play_icon, "drawable", "floating_play_icon"), null, 2, null);
        this.mUsingBubbledThinkingCard = true;
        this.shadowHideY = TypedValue.applyDimension(1, 200, Resources.getSystem().getDisplayMetrics());
        this.mMonitorImpl = new b(this);
    }

    public static final /* synthetic */ void access$configSecureIsland(SurfaceCardActivity r2, boolean r3) {
        ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).configSecureIsland(r3);
    }

    public static final /* synthetic */ void access$configureStatusBarAppearance(SurfaceCardActivity r2, int r3) {
        ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).configureStatusBarAppearance(r3);
    }

    public static final /* synthetic */ FloatingWindowServiceImpl access$getFloatingWindowService$p(SurfaceCardActivity r2) {
        return ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).floatingWindowService;
    }

    public static final /* synthetic */ int access$getStatusBarAppearance$p(SurfaceCardActivity r2) {
        return ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).statusBarAppearance;
    }

    public static final /* synthetic */ IAutoActionAgentEventListener.AgentStepInfo access$getStepInfo$p(SurfaceCardActivity r2) {
        return ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).stepInfo;
    }

    public static final /* synthetic */ void access$handleEvent(SurfaceCardActivity r2, com.obric.autoaction.presentation.b r3) {
        ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).handleEvent(r3);
    }

    public static final /* synthetic */ boolean access$isResumed$cp() {
        return isResumed;
    }

    public static final /* synthetic */ boolean access$isStarted$cp() {
        return isStarted;
    }

    public static final /* synthetic */ void access$setBound$p(SurfaceCardActivity r2, boolean r3) {
        ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).bound = r3;
    }

    public static final /* synthetic */ void access$setFloatingWindowService$p(SurfaceCardActivity r2, FloatingWindowServiceImpl r3) {
        SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        r4.floatingWindowService = (FloatingWindowServiceImpl) ZeusTransformUtils.wrapperContextForParams(r3, FloatingWindowServiceImpl.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setResumed$cp(boolean r0) {
        isResumed = r0;
    }

    public static final /* synthetic */ void access$setStarted$cp(boolean r0) {
        isStarted = r0;
    }

    public static final /* synthetic */ void access$setStatusBarAppearance$p(SurfaceCardActivity r2, int r3) {
        ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).statusBarAppearance = r3;
    }

    public static final /* synthetic */ void access$toggleCloseButtonVisibility(SurfaceCardActivity r2, boolean r3) {
        ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).toggleCloseButtonVisibility(r3);
    }

    public static final /* synthetic */ void access$updateContentText(SurfaceCardActivity r2, CharSequence r3) {
        ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).updateContentText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$updateTitleText(SurfaceCardActivity r2, CharSequence r3) {
        ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).updateTitleText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final com.obric.autoaction.b.b getBinding() {
        com.obric.autoaction.b.b r0 = this.binding;
        if (r0 == null) goto L5;
        return r0;
    L5:
        d.h.b.o.c("binding");
        return null;
    }

    public final void setBinding(com.obric.autoaction.b.b r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.binding = r2;
    }

    public final boolean isBindingInitialized() {
        return this.isBindingInitialized;
    }

    public final void setBindingInitialized(boolean r1) {
        this.isBindingInitialized = r1;
    }

    public final com.obric.autoaction.presentation.widget.a getViewModel() {
        return (com.obric.autoaction.presentation.widget.a) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.b(), com.obric.autoaction.presentation.widget.a.class, "com.obric.aiagent.plugin");
    }

    public final boolean isTaskSuccess() {
        return this.isTaskSuccess;
    }

    public final void setTaskSuccess(boolean r1) {
        this.isTaskSuccess = r1;
    }

    public final List<String> getReadyToSubmitAdditionContent() {
        return this.readyToSubmitAdditionContent;
    }

    static {
        $$delegatedProperties = new d.m.h[]{aa.a((r) ZeusTransformUtils.preCheckCast(new s(SurfaceCardActivity.class, "userAdditionContent", "getUserAdditionContent()Ljava/lang/String;", 0), r.class, "com.obric.aiagent.plugin")), aa.a((r) ZeusTransformUtils.preCheckCast(new s(SurfaceCardActivity.class, "draftUserClarifyInfo", "getDraftUserClarifyInfo()Ljava/lang/String;", 0), r.class, "com.obric.aiagent.plugin"))};
        Companion = new a(null);
    }

    public final String getUserAdditionContent() {
        return (String) ZeusTransformUtils.preCheckCast(this.userAdditionContent$delegate.getValue(this, $$delegatedProperties[0]), String.class, "com.obric.aiagent.plugin");
    }

    public final void setUserAdditionContent(String r4) {
        d.h.b.o.e(r4, "<set-?>");
        this.userAdditionContent$delegate.setValue(this, $$delegatedProperties[0], r4);
    }

    public final String getDraftUserClarifyInfo() {
        return (String) ZeusTransformUtils.preCheckCast(this.draftUserClarifyInfo$delegate.getValue(this, $$delegatedProperties[1]), String.class, "com.obric.aiagent.plugin");
    }

    public final void setDraftUserClarifyInfo(String r4) {
        d.h.b.o.e(r4, "<set-?>");
        this.draftUserClarifyInfo$delegate.setValue(this, $$delegatedProperties[1], r4);
    }

    public final Dialog getClarifyAddingDialog() {
        return this.clarifyAddingDialog;
    }

    public final void setClarifyAddingDialog(Dialog r1) {
        this.clarifyAddingDialog = r1;
    }

    public final ca getTextAnimationJob() {
        return this.textAnimationJob;
    }

    public final void setTextAnimationJob(ca r3) {
        this.textAnimationJob = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
    }

    private final void setClarifyInputDone(boolean r3) {
        this.isClarifyInputDone = r3;
        Loog.INSTANCE.d(TAG, "isClarifyInputDone set to " + r3);
    }

    private final PlayerActionTracker getPlayerActionTracker() {
        return (PlayerActionTracker) ZeusTransformUtils.preCheckCast(this.playerActionTracker$delegate.b(), PlayerActionTracker.class, "com.obric.aiagent.plugin");
    }

    private static final PlayerActionTracker playerActionTracker_delegate$lambda$0(SurfaceCardActivity r3) {
        return new PlayerActionTracker((Context) ZeusTransformUtils.preCheckCast((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    private final boolean ensureActiveSession() {
        IAutoActionAgentEventListener.AgentStepInfo r0 = FloatingWindowServiceImpl.Companion.c();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L13;
        Loog.INSTANCE.w(TAG, "ensureActiveSession: last session just finished; allow to show.");
        return true;
    L13:
        if (AutoActionAgent.INSTANCE.isOngoingSessionActive() == true) goto L16;
        Loog.INSTANCE.i(TAG, "ensureActiveSession: session is not active; finishing.");
        finish();
        return false;
    L16:
        return true;
    L5:
        if (r0.isLastStep() != true) goto L7;
        r1 = true;
        goto L9
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        com.obric.autoaction.presentation.j.f25104a.a(this);
        com.obric.autoaction.e.b.f24680a.a(TAG, "onCreate");
        setupWindowInsets();
        boolean r1 = true;
        if (ensureActiveSession() == true) goto L13;
        Loog.INSTANCE.d(TAG, "[SurfaceCard] no active session; cannot start activity.");
        IAutoActionAgentEventListener.SessionInfo r11 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE.getOngoingSessionInfo().a(), IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == false) goto L21;
        AOUserInterfaceTools.showAppToast$default(AOUserInterfaceTools.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.surface_card_create_queueing, WsChannelMultiProcessSharedProvider.STRING_TYPE, "surface_card_create_queueing"), false, 4, null);
        return;
    L21:
        return;
    L7:
        if (r11.isQueued() != true) goto L9;
    L13:
        String r12 = AutoActionAgent.INSTANCE.getOnGoingSessionKey();
        if (r12 == null) goto L16;
        com.obric.autoaction.presentation.e.f24900a.b(r12);
    L16:
        setupBindingAndContentView();
        com.obric.autogui.util.ui.b.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"), true, null, null, 6, null);
        com.obric.autogui.util.ui.b.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"), true);
        setupViewDragAndSnap();
        setupEventFlowCollection();
        setupClickListeners();
        setupCardCollapsedHeight();
        OperatingSpaceManager.INSTANCE.configureStatusListening((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), (SpaceStatusCallback) ZeusTransformUtils.preCheckCast(new j(this), SpaceStatusCallback.class, "com.obric.aiagent.plugin"));
        AOOperatingSpace r13 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r13 == null) goto L19;
        int r14 = r13.getSpaceStatus().getStatusBarAppearance();
        this.statusBarAppearance = r14;
        configureStatusBarAppearance(r14);
    L19:
        Window r15 = getWindow();
        d.h.b.o.c(r15, "getWindow(...)");
        com.obric.autoaction.presentation.i.a(r15);
        reportActivitySourceFrom();
        reportActivityShowing(true);
        getPlayerActionTracker().onVirtualPlayerCreated();
    }

    private final void configureStatusBarAppearance(int r3) {
        if (Build.VERSION.SDK_INT >= 30) goto L6;
        Loog.INSTANCE.e(TAG, "configureStatusBarAppearance: SDK_INT (" + Build.VERSION.SDK_INT + ") < R");
        return;
    L6:
        WindowInsetsController r2 = getWindow().getInsetsController();
        if (r2 == null) goto L10;
        r2.setSystemBarsAppearance(r3, 8);
        return;
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams r1) {
        super.onWindowAttributesChanged(r1);
        d.h.a.b<Boolean, x> r0 = this.debounceConfigSecureIsland;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        r0.invoke(Boolean.valueOf(r2));
        return;
    L5:
        if ((r1.flags & 8192) == 0) goto L7;
        r2 = true;
        goto L8
    }

    private final void configSecureIsland(boolean r8) {
        if (r8 == true) goto L4;
        com.obric.autoaction.presentation.i.a().c(0);
        return;
    L4:
        if (isResumed == false) goto L17;
        com.obric.autoaction.presentation.island.b r9 = com.obric.autoaction.presentation.i.a();
        CommonCollapseTemplate r7 = com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, "svg:oic_shield", null, getString(ZeusTransformUtils.mapRes(R.string.obric_privacy_protection, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_privacy_protection")), null, 10, null);
        Icon r0 = r7.getStartIcon();
        if (r0 == null) goto L8;
        r0.setWidth(24);
    L8:
        Icon r1 = r7.getStartIcon();
        if (r1 == null) goto L11;
        r1.setHeight(24);
    L11:
        Text r2 = r7.getEndText();
        if (r2 == null) goto L14;
        r2.setTextColor("#FFFFFFFF");
    L14:
        r9.a(CommonCollapseTemplate.create$default(r7, null, 1, null), null, true);
        return;
    }

    private final void setupWindowInsets() {
        Window r0 = getWindow();
        if (r0 == null) goto L8;
        View r1 = r0.getDecorView();
        if (r1 == null) goto L9;
        r1.setOnApplyWindowInsetsListener(new $$Lambda$SurfaceCardActivity$lvczHBCliEjMSZ2iynl9zyUcb6g(this));
        return;
    L9:
        return;
    }

    private static final WindowInsets setupWindowInsets$lambda$5(SurfaceCardActivity r9, View r10, WindowInsets r11) {
        SurfaceCardActivity r12 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r9, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "view");
        d.h.b.o.e(r11, "insets");
        Insets r13 = r11.getInsets(androidx.core.view.al.m.b());
        d.h.b.o.c(r13, "getInsets(...)");
        int r14 = r13.bottom;
        if (r14 <= 0) goto L5;
        LinearLayout r0 = r12.getBinding().x;
        d.h.b.o.c(r0, "shadowLayout");
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
        float r2 = 8;
        Resources r3 = Resources.getSystem();
        d.h.b.o.c(r3, "Resources.getSystem()");
        r1.setPadding(r1.getPaddingLeft(), r1.getPaddingTop(), r1.getPaddingRight(), d.i.a.a(TypedValue.applyDimension(1, r2, r3.getDisplayMetrics())) + r14);
        OUIFrameLayout r15 = r12.getBinding().n;
        d.h.b.o.c(r15, "closeButtonContainer");
        View r16 = (View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r4 = r16.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r5 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        Resources r7 = Resources.getSystem();
        d.h.b.o.c(r7, "Resources.getSystem()");
        r6.bottomMargin = d.i.a.a(TypedValue.applyDimension(1, r2, r7.getDisplayMetrics())) + r14;
        r16.setLayoutParams(r5);
    L5:
        return r11;
    }

    private final void setupBindingAndContentView() {
        com.obric.autoaction.b.b r0 = com.obric.autoaction.b.b.a(getLayoutInflater());
        d.h.b.o.c(r0, "inflate(...)");
        setBinding(r0);
        this.isBindingInitialized = true;
        setContentView((View) ZeusTransformUtils.preCheckCast(getBinding().b(), View.class, "com.obric.aiagent.plugin"));
    }

    private final void setupViewDragAndSnap() {
        getBinding().q.configureSnapping();
    }

    private final void setupEventFlowCollection() {
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void setupClickListeners() {
        getBinding().y.setOnClickListener(new $$Lambda$SurfaceCardActivity$W9GNKu7LR4xX9XsgxBmf2d9BinE(this));
        getBinding().l.setOnTouchDownListener(new $$Lambda$SurfaceCardActivity$CH99bO9sdrHV09yYX4v0ofKEZ7E(this));
        getBinding().l.setOnClickListener(new $$Lambda$SurfaceCardActivity$aC3lS369zwhrF2G3_kipV2dDSK0(this));
        getBinding().j.setOnClickListener(new $$Lambda$SurfaceCardActivity$sEhTFoRYHVLTahWccSK3P3ZAYIE(this));
        getBinding().m.setOnClickListener(new $$Lambda$SurfaceCardActivity$fmCoEMnnMRIGaVWfd1Eui9dqjLA(this));
        getBinding().i.setOnClickListener(new $$Lambda$SurfaceCardActivity$aAKwaeLZ59iCymUlf5dLXHlYF3o(this));
        getBinding().H.setOnClickListener(new $$Lambda$SurfaceCardActivity$cu1W30_oaCfO00PBPeUzfVTkJM(this));
        getBinding().f24591c.setOnClickListener($$Lambda$SurfaceCardActivity$TFm50NQwKHZIBfWVeCjdbUDwewE.INSTANCE);
        getBinding().q.setOnClickListener(new $$Lambda$SurfaceCardActivity$i8KdTPrcuQXIoE20jyhNlpQvLzI(this));
        getBinding().p.setOnClickListener(new $$Lambda$SurfaceCardActivity$dKiDUkFR7q67TjKtJQxazTsYvs(this));
        getBinding().f.setOnClickListener(new $$Lambda$SurfaceCardActivity$GrXAZpzuXbEapp4lmXl1Yn0wJk(this));
        getBinding().f24588J.setOnClickListener(new $$Lambda$SurfaceCardActivity$e7gadq8DHvsVXl31QQjMdqpoMaQ(this));
    }

    private static final void setupClickListeners$lambda$6(SurfaceCardActivity r5, View r6) {
        SurfaceCardActivity r7 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r5, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        OUIFrameLayout r8 = r7.getBinding().n;
        d.h.b.o.c(r8, "closeButtonContainer");
        boolean r1 = true;
        if (((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L9;
        return;
    L9:
        if (r7.inBlockingStatus == false) goto L17;
        LinearLayout r10 = r7.getBinding().x;
        d.h.b.o.c(r10, "shadowLayout");
        if (((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin")).getVisibility() == 0) goto L14;
        r1 = false;
    L14:
        if (r1 == false) goto L17;
        LinearLayout r11 = r7.getBinding().x;
        d.h.b.o.c(r11, "shadowLayout");
        r7.shakeView((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"));
    L17:
        if (r7.mUsingBubbledThinkingCard == false) goto L20;
        r7.handlePlayerClicking();
        return;
    L20:
        r7.toggleCardState();
        return;
    L5:
        r9 = false;
        goto L6
    }

    private static final x setupClickListeners$lambda$7(SurfaceCardActivity r3) {
        SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        ca r0 = r4.delayFinishJob;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        r4.delayFinishJob = null;
        return x.f38692a;
    }

    private static final void setupClickListeners$lambda$8(SurfaceCardActivity r6, View r7) {
        SurfaceCardActivity r0 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r6, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if (r0.mUsingBubbledThinkingCard == false) goto L9;
        if (r0.taskTerminate == true) goto L9;
        setBubbleForStatus$default(r0, r0.kBubbleOrdinary, true, false, 4, null);
        return;
    L9:
        if (r0.isExpanded == true) goto L12;
        checkNeedExpandCard$default(r0, false, 1, null);
        return;
    }

    private static final void setupClickListeners$lambda$9(SurfaceCardActivity r2, View r3) {
        SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        r4.getBinding().H.setVisibility(8);
        r4.getBinding().p.setVisibility(8);
        ca r5 = r4.textAnimationJob;
        if (r5 == null) goto L5;
        ca.a.a(r5, null, 1, null);
    L5:
        r4.getViewModel().b();
    }

    private static final void setupClickListeners$lambda$10(SurfaceCardActivity r2, View r3) {
        SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        r4.finish();
        FloatingWindowServiceImpl r5 = r4.floatingWindowService;
        if (r5 == null) goto L6;
        r5.startAppOnMainDisplay((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.aiagent.plugin"));
        return;
    }

    private static final void setupClickListeners$lambda$11(SurfaceCardActivity r1, View r2) {
        ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).invokeFeedback();
    }

    private static final void setupClickListeners$lambda$12(SurfaceCardActivity r1, View r2) {
        ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).userStartsCallUserOperation();
    }

    private static final void setupClickListeners$lambda$13(View r3) {
        IAssistInputHost r4 = (IAssistInputHost) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistInputHost.class), IAssistInputHost.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        IAssistInputHost.DefaultImpls.openInput$default(r4, true, null, 2, null);
        return;
    }

    private static final void setupClickListeners$lambda$14(SurfaceCardActivity r5, View r6) {
        SurfaceCardActivity r7 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r5, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if (r7.isInHandUsingMode == false) goto L6;
        Loog.INSTANCE.i(TAG, "[ManualOp] disabling ManualOp mode.");
        r7.stopAutoResume(true);
        com.obric.autogui.util.ui.e.a((Context) ZeusTransformUtils.preCheckCast(r7, Context.class, "com.obric.aiagent.plugin"), 6);
    L6:
        if (r7.isCallUserInProgress == false) goto L8;
        Loog.INSTANCE.i(TAG, "[CallUser] disabling CallUser mode.");
        r7.stopAutoResume(true);
        com.obric.autogui.util.ui.e.a((Context) ZeusTransformUtils.preCheckCast(r7, Context.class, "com.obric.aiagent.plugin"), 6);
    L8:
        r7.syncBubbleStatus(false);
    }

    private static final void setupClickListeners$lambda$15(SurfaceCardActivity r2, View r3) {
        SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if (r4.isCallUserInProgress == false) goto L6;
        Loog.INSTANCE.i(TAG, "[CallUser] disabling CallUser mode.");
        r4.stopAutoResume(true);
        return;
    }

    private static final void setupClickListeners$lambda$16(SurfaceCardActivity r4, View r5) {
        SurfaceCardActivity r6 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r4, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        ca r7 = r6.textAnimationJob;
        if (r7 == null) goto L5;
        ca.a.a(r7, null, 1, null);
    L5:
        r6.getBinding().f.setVisibility(8);
        OButton r8 = r6.getBinding().f24588J;
        d.h.b.o.c(r8, "userTakeOver");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"));
        r6.getBinding().t.setVisibility(0);
        if (r6.USE_ASSIST_INPUT == false) goto L10;
        IAssistInputHost r9 = (IAssistInputHost) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistInputHost.class), IAssistInputHost.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L12;
        IAssistInputHost.DefaultImpls.openInput$default(r9, true, null, 2, null);
        return;
    L12:
        return;
    L10:
        r6.getViewModel().f();
    }

    private static final void setupClickListeners$lambda$17(SurfaceCardActivity r8, View r9) {
        SurfaceCardActivity r10 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r8, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if (r10.canEnterManualOpMode() == true) goto L5;
    L7:
        AOUserInterfaceTools.showAppToast$default(AOUserInterfaceTools.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.auto_floating_tips_cant_handle_application, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_floating_tips_cant_handle_application"), false, 4, null);
        return;
    L5:
        if (AutoActionVirtualDisplay.INSTANCE.getVdOperatingApp().a() == null) goto L7;
        Loog.INSTANCE.i(TAG, "[ManualOp] enabling ManualOp mode.");
        r10.startManualOpMode();
    }

    private final void handlePlayerClicking() {
        if (this.mBubbled == true) goto L5;
    L8:
        setBubbleForStatus$default(this, this.kBubbleOrdinary, true, false, 4, null);
        return;
    L5:
        if (AutoActionAgent.INSTANCE.isOngoingSessionActive() == false) goto L8;
        setBubbleForStatus$default(this, this.kBubbleOrdinary, false, false, 4, null);
    }

    private final void userStartsCallUserOperation() {
        if (AutoActionAgent.INSTANCE.beforeCallUser() == true) goto L6;
        Loog.INSTANCE.i(TAG, " - [CallUser] early exited CallUser as it was handled elsewhere.");
        return;
    L6:
        this.inBlockingStatus = false;
        setBubbleForStatus$default(this, this.kBubbleCallUser, true, false, 4, null);
        getBinding().p.setVisibility(0);
        getBinding().f.setVisibility(8);
        getBinding().H.setVisibility(8);
        hideTrackIcon();
        getViewModel().c();
        FloatingWindowServiceImpl r1 = this.floatingWindowService;
        if (r1 == null) goto L9;
        r1.updateCallUserExpandedText(true);
    L9:
        OperatingSpaceManager r2 = OperatingSpaceManager.INSTANCE;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin");
        SurfaceView r6 = getBinding().y;
        d.h.b.o.c(r6, "surfaceView");
        if (r2.configureHandUsing(r3, true, (DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Surface(r6), DisplayHost.class, "com.obric.aiagent.plugin"), (HandUsingEventsCallback) ZeusTransformUtils.preCheckCast(this, HandUsingEventsCallback.class, "com.obric.aiagent.plugin")).isSuccess() == false) goto L13;
        this.isCallUserInProgress = true;
        setDimMode(false);
        setRootForeground(false);
        return;
    }

    private final void maybeExitCallUser() {
        Loog.INSTANCE.d(TAG, "doExitCallUser, isCallUser: " + this.isCallUserInProgress);
        if (this.isCallUserInProgress == false) goto L11;
        getBinding().H.setVisibility(8);
        getBinding().f.setVisibility(0);
        getBinding().t.setVisibility(8);
        getBinding().p.setVisibility(8);
        OButton r0 = getBinding().f24588J;
        d.h.b.o.c(r0, "userTakeOver");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        setBubbleForStatus$default(this, this.kBubbleOrdinary, false, false, 4, null);
        updateCardContentToIdle();
        getBinding().A.setVisibility(8);
        LockableScrollView r1 = getBinding().E;
        d.h.b.o.c(r1, "tvCardContentContainer");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
        getBinding().F.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.surface_card_resumed_from_manual_op, WsChannelMultiProcessSharedProvider.STRING_TYPE, "surface_card_resumed_from_manual_op")), CharSequence.class, "com.obric.aiagent.plugin"));
        getBinding().D.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.surface_card_resumed_from_call_user_th, WsChannelMultiProcessSharedProvider.STRING_TYPE, "surface_card_resumed_from_call_user_th")), CharSequence.class, "com.obric.aiagent.plugin"));
        getViewModel().e();
        FloatingWindowServiceImpl r2 = this.floatingWindowService;
        if (r2 == null) goto L7;
        r2.updateCallUserExpandedText(false);
    L7:
        OperatingSpaceManager r3 = OperatingSpaceManager.INSTANCE;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin");
        SurfaceView r5 = getBinding().y;
        d.h.b.o.c(r5, "surfaceView");
        if (r3.configureHandUsing(r4, false, (DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Surface(r5), DisplayHost.class, "com.obric.aiagent.plugin"), (HandUsingEventsCallback) ZeusTransformUtils.preCheckCast(this, HandUsingEventsCallback.class, "com.obric.aiagent.plugin")).isSuccess() == false) goto L12;
        this.isCallUserInProgress = false;
        setDimMode(false);
        setRootForeground(false);
        return;
    L12:
        return;
    }

    private final void setupCardCollapsedHeight() {
        getBinding().l.post(new $$Lambda$SurfaceCardActivity$FfX33OxBZP94r0mTIzjQShpxWIU(this));
    }

    private static final void setupCardCollapsedHeight$lambda$18(SurfaceCardActivity r2) {
        SurfaceCardActivity r3 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        r3.collapsedHeight = (r3.getBinding().F.getMeasuredHeight() + r3.getBinding().l.getPaddingTop()) + r3.getBinding().l.getPaddingBottom();
    }

    private final void setupVirtualDisplay() {
        OperatingSpaceManager.INSTANCE.attachMonitor((OperatingSpaceMonitor) ZeusTransformUtils.preCheckCast(this.mMonitorImpl, OperatingSpaceMonitor.class, "com.obric.aiagent.plugin"));
        if (this.isCallUserInProgress == false) goto L6;
        OperatingSpaceManager r0 = OperatingSpaceManager.INSTANCE;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin");
        SurfaceView r5 = getBinding().y;
        d.h.b.o.c(r5, "surfaceView");
        r0.configureHandUsing(r1, true, (DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Surface(r5), DisplayHost.class, "com.obric.aiagent.plugin"), (HandUsingEventsCallback) ZeusTransformUtils.preCheckCast(this, HandUsingEventsCallback.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void handleEvent(com.obric.autoaction.presentation.b r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.presentation.b.C0576b.class) == false) goto L6;
        handleStepEvent((com.obric.autoaction.presentation.b.C0576b) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.presentation.b.C0576b.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.presentation.b.a.class) == false) goto L9;
        handleAfterStepEvent((com.obric.autoaction.presentation.b.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.presentation.b.a.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.presentation.b.c.class) == false) goto L12;
        handleBizEvent((com.obric.autoaction.presentation.b.c) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.presentation.b.c.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.presentation.b.h.class) == false) goto L15;
        handleStreamingThought((com.obric.autoaction.presentation.b.h) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.presentation.b.h.class, "com.obric.aiagent.plugin"));
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.presentation.b.e.class) == false) goto L18;
        handleFunctionStateEvent((com.obric.autoaction.presentation.b.e) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.presentation.b.e.class, "com.obric.aiagent.plugin"));
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.presentation.b.f.class) == false) goto L20;
        handleOperatingAppChangedEvent((com.obric.autoaction.presentation.b.f) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.presentation.b.f.class, "com.obric.aiagent.plugin"));
        return;
    L20:
        logUnhandledEvent(r3);
    }

    private final void handleStepEvent(com.obric.autoaction.presentation.b.C0576b r23) {
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        com.obric.autoaction.e.b.f24680a.a(TAG, "handleStepEvent " + r23);
    L6:
        AOOperatingSpace r0 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r0 == null) goto L11;
        SpaceStatus r1 = r0.getSpaceStatus();
        if (r1 == null) goto L11;
        DisplayAccessor.Rotation r2 = r1.getRotation();
    L12:
        if (r2 != null) goto L14;
        Loog.INSTANCE.e(TAG, "[StepEvent] --> SpaceRotation is NULL.");
        r2 = DisplayAccessor.Rotation.Rotation0;
    L14:
        DisplayAccessor.Rotation r10 = r2;
        Bundle r3 = r23.a().getExtras();
        boolean r11 = true;
        if (r3 == null) goto L19;
        float[] r14 = r3.getFloatArray("clicked_pos");
        if (r14 == null) goto L19;
        d.m r4 = new d.m(Integer.valueOf(getBinding().b().getWidth()), Integer.valueOf(getBinding().b().getHeight()));
        int r15 = ((Number) ZeusTransformUtils.preCheckCast(r4.c(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r4.d(), Number.class, "com.obric.aiagent.plugin")).intValue();
        d.m<Float, Float> r6 = toNaturalCoordinates(r14[0], r14[1], r10, r15, r5);
        float r7 = ((Number) ZeusTransformUtils.preCheckCast(r6.c(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r8 = ((Number) ZeusTransformUtils.preCheckCast(r6.d(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        com.obric.autoaction.e.b.f24680a.a("ScreenTap_Display", "Tap(origin_x:" + r14[0] + ",origin_y:" + r14[1] + "  x:" + r7 + ",y:" + r8 + " ) Screen=(" + r15 + '-' + r5 + '-' + r10 + ')');
        showTrackIcon(r7, r8);
    L19:
        Bundle r9 = r23.a().getExtras();
        if (r9 == null) goto L28;
        float[] r16 = r9.getFloatArray(SWIPE_POS_KEY);
        if (r16 == null) goto L28;
        com.obric.autoaction.e.b.f24680a.a(TAG, "swipe pos x: " + r16[0] + "  y :" + r16[1] + " x2: " + r16[2] + "  y2 :" + r16[3]);
        Bundle r12 = r23.a().getExtras();
        if (r12 == null) goto L26;
        long r13 = r12.getLong(SWIPE_DURATION_KEY);
    L27:
        long r17 = r13;
        d.m r18 = new d.m(Integer.valueOf(getBinding().b().getWidth()), Integer.valueOf(getBinding().b().getHeight()));
        int r19 = ((Number) ZeusTransformUtils.preCheckCast(r18.c(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r110 = ((Number) ZeusTransformUtils.preCheckCast(r18.d(), Number.class, "com.obric.aiagent.plugin")).intValue();
        d.m<Float, Float> r20 = toNaturalCoordinates(r16[0], r16[1], r10, r19, r110);
        float r21 = ((Number) ZeusTransformUtils.preCheckCast(r20.c(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r22 = ((Number) ZeusTransformUtils.preCheckCast(r20.d(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        d.m<Float, Float> r24 = toNaturalCoordinates(r16[2], r16[3], r10, r19, r110);
        showScrollPath(r21, r22, ((Number) ZeusTransformUtils.preCheckCast(r24.c(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r24.d(), Number.class, "com.obric.aiagent.plugin")).floatValue(), r17);
        goto L28
    L26:
        r13 = 500;
    L28:
        Bundle r25 = r23.a().getExtras();
        if (r25 == null) goto L31;
        Boolean r26 = Boolean.valueOf(r25.getBoolean(FROM_STREAMING_KEY, false));
    L32:
        if (r26 != null) goto L34;
    L37:
        Bundle r27 = r23.a().getExtras();
        if (r27 != null) goto L40;
    L42:
        boolean r28 = false;
    L43:
        if (r28 == false) goto L48;
        ca r29 = this.textAnimationJob;
        if (r29 == null) goto L47;
        ca.a.a(r29, null, 1, null);
    L47:
        updateContentText((CharSequence) ZeusTransformUtils.preCheckCast(r23.a().getThought(), CharSequence.class, "com.obric.aiagent.plugin"));
    L49:
        IAutoActionAgentEventListener.AgentStepInfo r30 = this.stepInfo;
        if (r30 != null) goto L52;
    L54:
        r11 = false;
    L55:
        if (r11 == false) goto L57;
        this.readyToSubmitAdditionContent.clear();
    L57:
        setClarifyInputDone(false);
        updateCardContent$default(this, r23.a(), false, null, 6, null);
        return;
    L52:
        if (r30.isSuccess() != true) goto L54;
    L48:
        launchTextAnimation(r23.a().getThought());
        goto L49
    L40:
        if (r27.getInt("term_reason_type") != 104005) goto L42;
        r28 = true;
        goto L43
    L34:
        if (r26.booleanValue() == false) goto L37;
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, r23, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        goto L49
    L31:
        r26 = null;
    L11:
        r2 = null;
        goto L12
    L5:
        com.obric.autoaction.e.b.f24680a.a(TAG, "handleStepEvent, action=" + r23.a().getActionProtocolType());
        goto L6
    }

    public final d.m<Float, Float> toNaturalCoordinates(float r2, float r3, DisplayAccessor.Rotation r4, int r5, int r6) {
        d.h.b.o.e(r4, "rotation");
        int r1 = c.f24766a[r4.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return new d.m(Float.valueOf(r2), Float.valueOf(r3));
    L17:
        return new d.m(Float.valueOf(r3), Float.valueOf((r6 - 1) - r2));
    L18:
        return new d.m(Float.valueOf((r5 - 1) - r2), Float.valueOf((r6 - 1) - r3));
    L19:
        return new d.m(Float.valueOf((r5 - 1) - r3), Float.valueOf(r2));
    L15:
        return new d.m(Float.valueOf(r2), Float.valueOf(r3));
    }

    private final void handleStreamingThought(com.obric.autoaction.presentation.b.h r9) {
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r9, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void launchTextAnimation(final String r10) {
        Loog.INSTANCE.dp("launchTextAnimation", new $$Lambda$SurfaceCardActivity$AA_h8A9W7JcayyiLpM2NtW41HZ0(r10, this), new $$Lambda$SurfaceCardActivity$JGIrVwTpCwFnrfatheMZr03sIf0(this));
        ca r0 = this.textAnimationJob;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        this.textAnimationJob = kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(r10, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private static final String launchTextAnimation$lambda$22(String r2, SurfaceCardActivity r3) {
        return "launchTextAnimation=" + r2 + ", textAnimationJob=" + ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).textAnimationJob;
    }

    private static final String launchTextAnimation$lambda$23(SurfaceCardActivity r2) {
        return "textAnimationJob=" + ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).textAnimationJob;
    }

    private final void handleBizEvent(com.obric.autoaction.presentation.b.c r4) {
        Loog.INSTANCE.d(TAG, "handleBizEvent, status: " + r4.c());
        int r0 = c.f24767b[r4.c().ordinal()];
        if (r0 != 1) goto L5;
        handleTermination(r4);
    L16:
        if (r4.b() == BizStatus.QUEUEING) goto L18;
        return;
    L18:
        if (r4.c() != BizStatus.PREPARING) goto L22;
        com.obric.autoaction.presentation.e.f24900a.b(r4.a().getSessionKey());
        return;
    L22:
        return;
    L5:
        if (r0 != 2) goto L7;
        handleOperationResume(r4);
        goto L16
    L7:
        if (r0 != 3) goto L9;
        handlePausedState(r4.e());
        goto L16
    L9:
        if (r0 != 4) goto L16;
        handleUserInterruptedState(r4);
        goto L16
    }

    private final void handleUserInterruptedState(com.obric.autoaction.presentation.b.c r4) {
        Bundle r0 = r4.d();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getString("interrupt_reason_for_user");
    L6:
        Bundle r5 = r4.d();
        if (r5 == null) goto L9;
        r1 = r5.getString("interrupt_reason_for_user_specified");
    L9:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L12;
        r6.length();
    L12:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L15;
    L18:
        boolean r8 = true;
    L19:
        if (r8 == true) goto L22;
        getBinding().F.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L22:
        return;
    L15:
        if (r7.length() == 0) goto L18;
        r8 = false;
        goto L19
    L5:
        r2 = null;
        goto L6
    }

    private final void handleTermination(com.obric.autoaction.presentation.b.c r5) {
        hideTrackIcon();
        OButton r0 = getBinding().f24588J;
        d.h.b.o.c(r0, "userTakeOver");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        this.taskTerminate = true;
        checkNeedExpandCard(true);
        maybeExitCallUser();
        setDimMode(true);
        Bundle r6 = r5.a().getTask().getTaskExtras();
        if (r6 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r7 == false) goto L10;
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - surface card exited with `eos_exit_directly` == true");
        finish();
    L14:
        reportActivityShowing(false);
        return;
    L10:
        ca r8 = this.delayFinishJob;
        if (r8 == null) goto L13;
        ca.a.a(r8, null, 1, null);
    L13:
        this.delayFinishJob = q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")).a((d.h.a.m) ZeusTransformUtils.preCheckCast(new h(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
        goto L14
    L5:
        if (r6.getBoolean("eos_exit_directly", false) != true) goto L7;
        r7 = true;
        goto L8
    }

    private final void handleOperationResume(com.obric.autoaction.presentation.b.c r4) {
        setDimMode(false);
        if (this.taskTerminate == true) goto L8;
        IAutoActionAgentEventListener.AgentStepInfo r0 = this.stepInfo;
        if (r0 == null) goto L13;
        updateCardContent(r0, true, r4);
        return;
    L13:
        return;
    L8:
        this.taskTerminate = false;
        setRootForeground(false);
        toggleCloseButtonVisibility(false);
        ca r5 = this.delayFinishJob;
        if (r5 == null) goto L11;
        ca.a.a(r5, null, 1, null);
    L11:
        this.delayFinishJob = null;
        Loog.INSTANCE.i(TAG, " - [start_immediately_from_last_task] this activity is not exited after last task.");
        getIntent().putExtra("source_from", "start_immediately_from_last_task");
        reportActivitySourceFrom();
        reportActivityShowing(true);
    }

    private final void handlePausedState(int r5) {
        if (r5 == 1203) goto L6;
        Loog.INSTANCE.d(TAG, "paused; set dimMode to true because reason=" + r5);
        setDimMode(true);
    L6:
        if (r5 == 1201) goto L8;
        return;
    L8:
        if (this.USE_ASSIST_INPUT == true) goto L12;
        com.obric.autoaction.presentation.h.a(this, true);
        return;
    }

    private final void handleAfterStepEvent(com.obric.autoaction.presentation.b.a r14) {
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        com.obric.autoaction.e.b.f24680a.a(TAG, "handleAfterStepEvent " + r14);
    L6:
        this.sessionInfo = r14.a();
        this.stepInfo = r14.b();
        this.execInfo = r14.c();
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r14.b().getActionProtocolType(), CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("open_app", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L9;
    L11:
        boolean r0 = false;
    L12:
        if (r0 == false) goto L14;
    L15:
        Loog.INSTANCE.d(TAG, " hide surfaceview placeholder ");
        ConstraintLayout r15 = getBinding().s;
        d.h.b.o.c(r15, "ivCenterIcon");
        com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null), 0.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(1000, 0, null, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null).a(new $$Lambda$SurfaceCardActivity$vli5FHFHGVaZOCD4Es2AaAJBHM(this)).b(), null, null, 3, null);
    L16:
        updateSurfaceViewBackground();
        return;
    L14:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r14.b().getActionProtocolType(), CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("call_user", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L16;
    L9:
        if (r14.c().getSucceeded() == false) goto L11;
        r0 = true;
        goto L12
    L5:
        com.obric.autoaction.e.b.f24680a.a(TAG, "handleAfterStepEvent " + r14.b().getActionProtocolType() + ", " + r14.a().getSessionKey());
        goto L6
    }

    private static final x handleAfterStepEvent$lambda$25(SurfaceCardActivity r1, boolean r2, Throwable r3) {
        SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, " hide surfaceview placeholder 111");
        r4.getBinding().s.setVisibility(8);
        return x.f38692a;
    }

    private final void logUnhandledEvent(com.obric.autoaction.presentation.b r3) {
        com.obric.autoaction.e.b.f24680a.a(TAG, "Unhandled event type: " + aa.b(r3.getClass()).b());
    }

    @Override // com.obric.autoaction.common.base.BaseActivity
    public void finish() {
        super.finish();
        overridePendingTransition(0, ZeusTransformUtils.mapRes(R.anim.activitiy_anim_fade_out, "anim", "activitiy_anim_fade_out"));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        com.obric.autoaction.e.b.f24680a.a(TAG, "onDestroy");
        if (this.isBindingInitialized == true) goto L5;
        return;
    L5:
        Drawable r0 = getBinding().y.getBackground();
        if (ZeusTransformUtils.instanceOf(r0, BitmapDrawable.class) == false) goto L8;
        ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r0, BitmapDrawable.class, "com.obric.aiagent.plugin")).getBitmap().recycle();
        getBinding().y.setBackground(null);
        Loog.INSTANCE.i(TAG, "destroyed background bitmap for surface view");
    L8:
        OperatingSpaceManager.INSTANCE.configureStatusListening((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), null);
        clearImeInsetsListening();
        com.obric.autoaction.presentation.j.f25104a.a(null);
        if (this.isInHandUsingMode == false) goto L11;
        Loog.INSTANCE.w(TAG, "disabling HandUsing mode as the activity is going down.");
        configureHandUsingMode$default(this, false, false, 2, null);
    L11:
        com.obric.autoaction.presentation.i.a().c(0);
        reportActivityShowing(false);
    }

    public final com.obric.autoaction.userreport.a getReportController() {
        return this.reportController;
    }

    public final void setReportController(com.obric.autoaction.userreport.a r1) {
        this.reportController = r1;
    }

    private final void invokeFeedback() {
        this.reportController = new com.obric.autoaction.userreport.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        IAutoActionAgentEventListener.AgentStepInfo r0 = this.stepInfo;
        int r1 = 0;
        if (r0 != null) goto L5;
    L14:
        int r7 = r1;
        IAutoActionAgentEventListener.SessionInfo r2 = this.sessionInfo;
        String r3 = null;
        if (r2 == null) goto L18;
        String r4 = r2.getSessionId();
        if (r4 == null) goto L18;
    L22:
        IAutoActionAgentEventListener.SessionInfo r5 = FloatingWindowServiceImpl.Companion.d();
        if (r5 == null) goto L29;
        AutoOperateTask r6 = r5.getTask();
        if (r6 == null) goto L29;
        Map<String, Object> r8 = r6.getInternalExtras();
        if (r8 == null) goto L29;
        Object r9 = r8.get(AutoOperateTask.KEY_EXTRA_EVALUATED_TASK);
    L31:
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L33;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
    L34:
        IAutoActionAgentEventListener.SessionInfo r11 = FloatingWindowServiceImpl.Companion.d();
        if (r11 == null) goto L39;
        AutoOperateTask r12 = r11.getTask();
        if (r12 == null) goto L39;
        String r13 = r12.getUserTask();
    L40:
        com.obric.autoaction.userreport.a r14 = this.reportController;
        d.h.b.o.a(r14);
        String r15 = String.valueOf(r4);
        IAutoActionAgentEventListener.SessionInfo r16 = this.sessionInfo;
        if (r16 == null) goto L44;
        String r17 = r16.getSessionKey();
        if (r17 == null) goto L44;
    L45:
        String r18 = r17;
        IAutoActionAgentEventListener.AgentStepExecInfo r19 = this.execInfo;
        if (r19 == null) goto L48;
        r3 = r19.getJournalPath();
    L48:
        String r20 = String.valueOf(r3);
        if (r10 != null) goto L53;
        if (r13 != null) goto L52;
        String r21 = FloatingWindowServiceImpl.Companion.a();
    L54:
        r14.a(new com.obric.autoaction.userreport.a.C0604a(r15, r18, r20, r7, r21));
        com.obric.autoaction.userreport.a r110 = this.reportController;
        d.h.b.o.a(r110);
        r110.a();
        return;
    L52:
        r21 = r13;
        goto L54
    L53:
        r21 = r10;
    L44:
        r17 = "";
    L39:
        r13 = null;
        goto L40
    L33:
        r10 = null;
    L29:
        r9 = null;
    L18:
        IAutoActionAgentEventListener.SessionInfo r22 = this.sessionInfo;
        if (r22 == null) goto L21;
        r4 = r22.getSessionKey();
        goto L22
    L21:
        r4 = null;
        goto L22
    L5:
        if (r0.isLastStep() == false) goto L14;
        if (r0.isSuccess() == true) goto L14;
        Bundle r23 = r0.getExtras();
        if (r23 == null) goto L12;
        int r24 = r23.getInt("term_reason_type");
    L13:
        r1 = r24;
        goto L14
    L12:
        r24 = 1;
        goto L13
    }

    private final void toggleCloseButtonVisibility(boolean r6) {
        com.obric.autoaction.e.b.f24680a.a(TAG, "toggleCloseButtonVisibility shouldShowCloseButton " + r6);
        ViewGroup.LayoutParams r0 = getBinding().x.getLayoutParams();
        d.h.b.o.a(r0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (r6 == false) goto L5;
        getBinding().n.setVisibility(0);
        clearImeInsetsListening();
        r1.bottomMargin = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.auto_ai_card_margin_bottom_show_close, "dimen", "auto_ai_card_margin_bottom_show_close"));
    L11:
        getBinding().x.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        OUIFrameLayout r7 = getBinding().n;
        d.h.b.o.c(r7, "closeButtonContainer");
        if (((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == false) goto L11;
        getBinding().n.setVisibility(8);
        r1.bottomMargin = 0;
        goto L11
    L8:
        r8 = false;
        goto L9
    }

    private final void hideTrackIcon() {
        getBinding().C.setVisibility(4);
    }

    private final void showTrackIcon(float r12, float r13) {
        final ImageView r11 = getBinding().C;
        r11.setX(r12 - (r11.getWidth() / 2.0f));
        r11.setY(r13 - (r11.getHeight() / 2.0f));
        r11.setAlpha(1.0f);
        r11.setVisibility(0);
        d.h.b.o.a(r11);
        com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.b(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null), 0.67f, 0.67f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.g, com.obric.common.oea.foundation.animation.h.e.c.f32440c, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a(new $$Lambda$SurfaceCardActivity$Z6LBQvPwdtxJirZw7ROqfF2sNPA(r11)).b(), null, null, 3, null);
    }

    private static final x showTrackIcon$lambda$29$lambda$28(final ImageView r10, boolean r11, Throwable r12) {
        d.h.b.o.a(r10);
        com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.b(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null), 1.0f, 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.i, com.obric.common.oea.foundation.animation.h.e.c.g, 0), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a(new $$Lambda$SurfaceCardActivity$zsCYmdtm79t22ccLeodgwT8Cbwo(r10)).b(), null, null, 3, null);
        return x.f38692a;
    }

    private static final x showTrackIcon$lambda$29$lambda$28$lambda$27(ImageView r8, boolean r9, Throwable r10) {
        d.h.b.o.a(r8);
        com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null), 0.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.c.f32441d, com.obric.common.oea.foundation.animation.h.e.b.f32433a, com.obric.common.oea.foundation.animation.h.e.d.k), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null).b(), null, null, 3, null);
        return x.f38692a;
    }

    public final void showScrollPath(float r7, float r8, float r9, float r10, long r11) {
        final ImageView r6 = getBinding().C;
        final float r2 = r7 - (r6.getWidth() / 2.0f);
        final float r4 = r8 - (r6.getHeight() / 2.0f);
        final float r3 = r9 - (r6.getWidth() / 2.0f);
        final float r5 = r10 - (r6.getHeight() / 2.0f);
        r6.setImageDrawable(r6.getDrawable());
        r6.setAlpha(1.0f);
        r6.setVisibility(0);
        ValueAnimator r12 = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r12.addUpdateListener(new $$Lambda$SurfaceCardActivity$zMNaKELrUQ8_XzF6W_oDvcYtL6o(r6, r2, r3, r4, r5));
        r12.setDuration(r11);
        r12.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new AccelerateDecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r12.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new SurfaceCardActivity$showScrollPath$1$1$2(r6), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        r12.start();
    }

    private static final void showScrollPath$lambda$32$lambda$31$lambda$30(ImageView r2, float r3, float r4, float r5, float r6, ValueAnimator r7) {
        d.h.b.o.e(r7, "it");
        Object r8 = r7.getAnimatedValue();
        d.h.b.o.a(r8, "null cannot be cast to non-null type kotlin.Float");
        float r9 = ((Float) ZeusTransformUtils.preCheckCast(r8, Float.class, "com.obric.aiagent.plugin")).floatValue();
        r2.setX(r3 + ((r4 - r3) * r9));
        r2.setY(r5 + ((r6 - r5) * r9));
    }

    private final void updateSurfaceViewBackground() {
        IAutoActionAgentEventListener.AgentStepInfo r0 = this.stepInfo;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == false) goto L18;
        getBinding().y.setBackground(androidx.core.content.b.h.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.ai_surface_layout_bg, "drawable", "ai_surface_layout_bg"), null));
        getBinding().s.setVisibility(0);
        getBinding().s.setAlpha(1.0f);
        syncBubbleStatus(false);
        IAutoActionAgentEventListener.AgentStepExecInfo r2 = this.execInfo;
        if (r2 == null) goto L19;
        Bitmap r3 = r2.getAfterStepScreenshot();
        if (r3 == null) goto L20;
        com.obric.autoaction.e.b.f24680a.a(TAG, "screenshot " + r3);
        if (r3.isRecycled() == false) goto L16;
        com.obric.autoaction.e.b.f24680a.a(TAG, " - screenshot is recycled!");
        return;
    L16:
        SurfaceView r4 = getBinding().y;
        Resources r5 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin");
        d.h.b.o.c(r5, "getResources(...)");
        r4.setBackground((Drawable) ZeusTransformUtils.preCheckCast(new BitmapDrawable(r5, r3), Drawable.class, "com.obric.aiagent.plugin"));
        getBinding().s.setVisibility(8);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r0.isLastStep() != true) goto L7;
        goto L7
    }

    private final void setFullScreen() {
        getWindow().setStatusBarColor(0);
        getWindow().getDecorView().setSystemUiVisibility(14082);
    }

    private final void initViewState() {
        getBinding().y.setBackground(null);
        this.execInfo = FloatingWindowServiceImpl.Companion.e();
        this.sessionInfo = FloatingWindowServiceImpl.Companion.d();
        IAutoActionAgentEventListener.AgentStepInfo r2 = FloatingWindowServiceImpl.Companion.c();
        this.stepInfo = r2;
        if (r2 == null) goto L8;
        updateContentText((CharSequence) ZeusTransformUtils.preCheckCast(r2.getThought(), CharSequence.class, "com.obric.aiagent.plugin"));
        if (r2.isLastStep() == false) goto L7;
        checkNeedExpandCard(true);
    L7:
        updateCardContent$default(this, r2, false, null, 6, null);
    L8:
        updateSurfaceViewBackground();
        final com.obric.autoaction.presentation.b.c r0 = FloatingWindowServiceImpl.Companion.b();
        if (r0 == null) goto L17;
        Loog.INSTANCE.ip(TAG, new $$Lambda$SurfaceCardActivity$xGHJEuUsMPFlwUWHDFOlX41Jmi0(r0), $$Lambda$SurfaceCardActivity$xiHYsrlDn4Eyp8VlvP1pZWRg1I.INSTANCE);
        if (r0.c() != BizStatus.USER_INTERRUPTED) goto L13;
        handleUserInterruptedState(r0);
    L13:
        IAutoActionAgentEventListener.AgentStepInfo r1 = this.stepInfo;
        if (r1 == null) goto L18;
        fixCallUserStateForInitViewState(r1, r0);
        fixClarifyStateForInitViewState(r1, r0);
        return;
    L18:
        return;
    }

    private static final String initViewState$lambda$35(com.obric.autoaction.presentation.b.c r2) {
        return "[SurfaceCard] syncing status " + r2 + " from Service.";
    }

    private final void fixCallUserStateForInitViewState(IAutoActionAgentEventListener.AgentStepInfo r5, com.obric.autoaction.presentation.b.c r6) {
        if (r5.isLastStep() == false) goto L5;
        return;
    L5:
        if (this.isCallUserInProgress == false) goto L7;
        return;
    L7:
        if (r5.getActionType() == 2) goto L9;
        return;
    L9:
        if (r6.c() == BizStatus.OPERATING) goto L11;
        return;
    L11:
        if (r6.e() == 1400) goto L18;
        this.inBlockingStatus = false;
        getBinding().H.setVisibility(8);
        getBinding().f.setVisibility(0);
        getBinding().t.setVisibility(8);
        getBinding().p.setVisibility(8);
        OButton r7 = getBinding().f24588J;
        d.h.b.o.c(r7, "userTakeOver");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"));
        updateCardContentToIdle();
        getBinding().A.setVisibility(8);
        LockableScrollView r8 = getBinding().E;
        d.h.b.o.c(r8, "tvCardContentContainer");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"));
        TextView r9 = getBinding().D;
        d.h.b.o.c(r9, "tvCardContent");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin"));
        getBinding().F.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.surface_card_resumed_from_manual_op, WsChannelMultiProcessSharedProvider.STRING_TYPE, "surface_card_resumed_from_manual_op")), CharSequence.class, "com.obric.aiagent.plugin"));
        getBinding().D.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.surface_card_resumed_from_call_user_th, WsChannelMultiProcessSharedProvider.STRING_TYPE, "surface_card_resumed_from_call_user_th")), CharSequence.class, "com.obric.aiagent.plugin"));
        getBinding().F.post(new $$Lambda$SurfaceCardActivity$OhbpU3RuCTDuQ6JsJuRR7vC13_k(this));
        getBinding().F.setTextSize(2, 14.0f);
        return;
    }

    private static final void fixCallUserStateForInitViewState$lambda$38(SurfaceCardActivity r2) {
        ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).getBinding().F.setGravity(8388611);
    }

    private final void fixClarifyStateForInitViewState(IAutoActionAgentEventListener.AgentStepInfo r3, com.obric.autoaction.presentation.b.c r4) {
        if (r3.isLastStep() == false) goto L5;
        return;
    L5:
        if (r3.getActionType() == 3) goto L7;
        return;
    L7:
        if (r4.c() == BizStatus.OPERATING) goto L9;
        return;
    L9:
        if (r4.e() != 1401) goto L11;
    L12:
        Bundle r5 = r4.d();
        if (r5 == null) goto L24;
        String r6 = r5.getString("operating_reason_msg", "");
        if (r6 != null) goto L17;
        return;
    L17:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L26;
        getBinding().F.setTextSize(2, 14.0f);
        exitClarifyUI(r6);
        return;
    L26:
        return;
    L24:
        return;
    L11:
        if (r4.e() == 1403) goto L12;
    }

    public final void updateCardContentToIdle() {
        com.obric.autoaction.e.b.f24680a.a(TAG, "updateCardContentToIdle");
        getBinding().l.setBackground(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.card_bg_with_border_normal, "drawable", "card_bg_with_border_normal")));
        TouchAwareConstraintLayout r0 = getBinding().l;
        Resources r2 = Resources.getSystem();
        d.h.b.o.c(r2, "Resources.getSystem()");
        r0.setRadius(d.i.a.a(TypedValue.applyDimension(1, 28, r2.getDisplayMetrics())));
        getBinding().f.setVisibility(0);
        getBinding().t.setVisibility(8);
        getBinding().j.setVisibility(0);
        getBinding().g.setVisibility(8);
        getBinding().i.setVisibility(8);
        getBinding().p.setVisibility(8);
        getBinding().H.setVisibility(8);
        getBinding().F.setGradientColorEnabled(true);
    }

    static /* synthetic */ void updateCardContent$default(SurfaceCardActivity r1, IAutoActionAgentEventListener.AgentStepInfo r2, boolean r3, com.obric.autoaction.presentation.b.c r4, int r5, Object r6) {
        SurfaceCardActivity r7 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r7.updateCardContent(r2, r3, r4);
    }

    private final void updateCardContent(IAutoActionAgentEventListener.AgentStepInfo r29, boolean r30, com.obric.autoaction.presentation.b.c r31) {
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        com.obric.autoaction.e.b.f24680a.a(TAG, "updateCardContent action " + r29 + ", fromResume=" + r30);
    L6:
        this.isTaskSuccess = false;
        getBinding().A.setVisibility(8);
        getBinding().f24589a.setVisibility(8);
        getBinding().F.setGravity(8388611);
        getBinding().F.setTextSize(2, 14.0f);
        getBinding().h.setVisibility(8);
        getBinding().f24591c.setVisibility(8);
        OButton r4 = getBinding().f24588J;
        d.h.b.o.c(r4, "userTakeOver");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        if (r29.isLastStep() == true) goto L72;
        updateTitleText((CharSequence) ZeusTransformUtils.preCheckCast(r29.getThought(), CharSequence.class, "com.obric.aiagent.plugin"));
        getBinding().f.setEnabled(r29.getSupportsUserAddition());
        getBinding().y.setBackground(null);
        updateCardContentToIdle();
        ViewStub r3 = getBinding().r;
        d.h.b.o.c(r3, "inputContent");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        TextView r5 = getBinding().D;
        d.h.b.o.c(r5, "tvCardContent");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
        LockableScrollView r6 = getBinding().E;
        d.h.b.o.c(r6, "tvCardContentContainer");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
        if (r30 == false) goto L20;
        if (r31 == null) goto L20;
        if (r31.e() != com.obric.autogui.session.state.a.h.b.f31244d.a()) goto L20;
        Bundle r7 = r31.d();
        if (r7 == null) goto L20;
        String r8 = r7.getString("operating_reason_msg");
        if (r8 == null) goto L20;
        String r16 = "operating_reason_msg";
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L23;
        String r9 = getString(ZeusTransformUtils.mapRes(R.string.surface_card_get_user_clarify, WsChannelMultiProcessSharedProvider.STRING_TYPE, "surface_card_get_user_clarify"), new Object[]{r8});
        d.h.b.o.c(r9, "getString(...)");
        updateTitleText((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"));
        updateContentText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
    L23:
        if (r30 == false) goto L30;
        if (r31 == null) goto L30;
        if (r31.e() != com.obric.autogui.session.state.a.h.b.f31245e.a()) goto L28;
    L29:
        LockableScrollView r10 = getBinding().E;
        d.h.b.o.c(r10, "tvCardContentContainer");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"));
        getBinding().F.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.surface_card_resumed_from_manual_op, WsChannelMultiProcessSharedProvider.STRING_TYPE, "surface_card_resumed_from_manual_op")), CharSequence.class, "com.obric.aiagent.plugin"));
        getBinding().D.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.surface_card_resumed_from_manual_op_th, WsChannelMultiProcessSharedProvider.STRING_TYPE, "surface_card_resumed_from_manual_op_th")), CharSequence.class, "com.obric.aiagent.plugin"));
        goto L30
    L28:
        if (r31.e() == com.obric.autogui.session.state.a.h.b.f31243c.a()) goto L29;
    L30:
        String r18 = "";
        if (r29.getActionType() != 2) goto L50;
        if (this.isCallUserInProgress == true) goto L48;
        updateTitleText((CharSequence) ZeusTransformUtils.preCheckCast(r29.getAction(), CharSequence.class, "com.obric.aiagent.plugin"));
        setBubbled(false);
        if (r30 == true) goto L43;
        this.inBlockingStatus = true;
        OButton r11 = getBinding().f24588J;
        d.h.b.o.c(r11, "userTakeOver");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"));
        getBinding().H.setVisibility(0);
        OButton r12 = getBinding().H;
        Bundle r13 = r29.getExtras();
        if (r13 == null) goto L41;
        String r14 = r13.getString("action_for_user");
        if (r14 == null) goto L41;
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin");
    L42:
        r12.setText(r15);
        getBinding().A.setVisibility(0);
        getBinding().z.setImageResource(ZeusTransformUtils.mapRes(R.drawable.oui_right_hand_point_up_fill, "drawable", "oui_right_hand_point_up_fill"));
        getBinding().B.setText(ZeusTransformUtils.mapRes(R.string.obric_surface_card_manual_action_required, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_surface_card_manual_action_required"));
        TextView r17 = getBinding().D;
        d.h.b.o.c(r17, "tvCardContent");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.aiagent.plugin"));
        getBinding().H.post(new $$Lambda$SurfaceCardActivity$fHn1d77_hRnWV7QcjsQRBt0oqs(this));
        getBinding().F.setTextSize(2, 16.0f);
        GradientTextView r19 = getBinding().F;
        d.h.b.o.c(r19, "tvCardTitle");
        com.obric.autoaction.presentation.k.a((TextView) ZeusTransformUtils.preCheckCast(r19, TextView.class, "com.obric.aiagent.plugin"));
        hideTrackIcon();
    L44:
        com.obric.autoaction.presentation.function.c r20 = this.mActiveAutoResumer;
        if (r20 == null) goto L47;
        r20.b();
    L47:
        com.obric.autoaction.presentation.function.c r110 = new com.obric.autoaction.presentation.function.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), getBinding().q, com.obric.autoaction.presentation.function.a.a.a.class, (am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), 0, 16, null);
        r110.a();
        this.mActiveAutoResumer = r110;
    L41:
        String r21 = getString(ZeusTransformUtils.mapRes(R.string.auto_execute_by_user, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_execute_by_user"));
        d.h.b.o.c(r21, "getString(...)");
        r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin");
        goto L42
    L43:
        LockableScrollView r22 = getBinding().E;
        d.h.b.o.c(r22, "tvCardContentContainer");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r22, View.class, "com.obric.aiagent.plugin"));
        getBinding().F.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.surface_card_resumed_from_manual_op, WsChannelMultiProcessSharedProvider.STRING_TYPE, "surface_card_resumed_from_manual_op")), CharSequence.class, "com.obric.aiagent.plugin"));
        getBinding().D.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.surface_card_resumed_from_call_user_th, WsChannelMultiProcessSharedProvider.STRING_TYPE, "surface_card_resumed_from_call_user_th")), CharSequence.class, "com.obric.aiagent.plugin"));
        this.inBlockingStatus = false;
        goto L44
    L48:
        setBubbled(true);
        getBinding().p.setVisibility(0);
        getBinding().f.setVisibility(8);
    L50:
        if (r29.getActionType() != 3) goto L71;
        updateTitleText((CharSequence) ZeusTransformUtils.preCheckCast(r29.getAction(), CharSequence.class, "com.obric.aiagent.plugin"));
        setBubbled(false);
        TextView r2 = getBinding().D;
        d.h.b.o.c(r2, "tvCardContent");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        if (this.isClarifyInputDone == true) goto L70;
        OButton r23 = getBinding().f24588J;
        d.h.b.o.c(r23, "userTakeOver");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r23, View.class, "com.obric.aiagent.plugin"));
        getBinding().A.setVisibility(0);
        getBinding().z.setImageResource(ZeusTransformUtils.mapRes(R.drawable.oic_ellipsis_message_fill, "drawable", "oic_ellipsis_message_fill"));
        getBinding().B.setText(ZeusTransformUtils.mapRes(R.string.obric_surface_card_waiting_reply, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_surface_card_waiting_reply"));
        getBinding().F.setTextSize(2, 16.0f);
        GradientTextView r24 = getBinding().F;
        d.h.b.o.c(r24, "tvCardTitle");
        com.obric.autoaction.presentation.k.a((TextView) ZeusTransformUtils.preCheckCast(r24, TextView.class, "com.obric.aiagent.plugin"));
        List<IAutoAgentWidgetStateListener.ClarifyOptions> r25 = AutoAgentEventToWidgetStateImpl.Companion.a(r29);
        if (r25 == null) goto L61;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r25, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L61;
        if (r25.size() != 2) goto L61;
        Loog.INSTANCE.d(TAG, "step into gui clarify");
        getBinding().f24589a.setVisibility(0);
        OButton r26 = getBinding().u;
        d.h.b.o.c(r26, "option1");
        configGuiClarifyOptions(r26, (IAutoAgentWidgetStateListener.ClarifyOptions) ZeusTransformUtils.preCheckCast(r25.get(0), IAutoAgentWidgetStateListener.ClarifyOptions.class, "com.obric.aiagent.plugin"));
        OButton r27 = getBinding().v;
        d.h.b.o.c(r27, "option2");
        configGuiClarifyOptions(r27, (IAutoAgentWidgetStateListener.ClarifyOptions) ZeusTransformUtils.preCheckCast(r25.get(1), IAutoAgentWidgetStateListener.ClarifyOptions.class, "com.obric.aiagent.plugin"));
        getBinding().f.setVisibility(8);
        getBinding().h.setVisibility(0);
        getBinding().h.setOnClickListener(new $$Lambda$SurfaceCardActivity$IXjwkDsfUAbBqwmsZmzHG8aWcEk(this));
    L61:
        if (this.USE_ASSIST_INPUT == false) goto L63;
        getBinding().f24591c.setVisibility(0);
        getBinding().f24591c.post(new $$Lambda$SurfaceCardActivity$W1rb1SyzZS_KDWz21vfDE7k2ZY(this));
        getBinding().f.setEnabled(false);
        goto L71
    L63:
        Loog.INSTANCE.d(TAG, "step into text clarify");
        if (this.isClarifyInputInflate == true) goto L66;
        getBinding().r.setOnInflateListener(new $$Lambda$SurfaceCardActivity$j1NBM0QUyRHzp6uJWcdvKIOMfWA(this));
        getBinding().r.inflate();
        getBinding().f.setEnabled(false);
    L66:
        final EditText r28 = this.clarifyEditText;
        if (r28 == null) goto L69;
        r28.setText((CharSequence) ZeusTransformUtils.preCheckCast(getDraftUserClarifyInfo(), CharSequence.class, "com.obric.aiagent.plugin"));
        r28.setSelection(getDraftUserClarifyInfo().length());
        r28.post(new $$Lambda$SurfaceCardActivity$v8y78ua9mgVjjM22B7_Su7_hBZA(r28, this));
        r28.setOnFocusChangeListener($$Lambda$SurfaceCardActivity$vvwLLWSeOjQFK3b9fuvgdEvc30.INSTANCE);
    L69:
        TextView r32 = getBinding().D;
        d.h.b.o.c(r32, "tvCardContent");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r32, View.class, "com.obric.aiagent.plugin"));
        ViewStub r33 = getBinding().r;
        d.h.b.o.c(r33, "inputContent");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r33, View.class, "com.obric.aiagent.plugin"));
        clearImeInsetsListening();
        setupImeInsets();
        goto L71
    L70:
        this.inBlockingStatus = false;
        String r34 = "surface_card_get_user_clarify";
        String r35 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.surface_card_get_user_clarify, WsChannelMultiProcessSharedProvider.STRING_TYPE, r34), new Object[]{this.userClarifyInfo});
        d.h.b.o.c(r35, "getString(...)");
        updateTitleText((CharSequence) ZeusTransformUtils.preCheckCast(r35, CharSequence.class, "com.obric.aiagent.plugin"));
        ViewStub r36 = getBinding().r;
        d.h.b.o.c(r36, "inputContent");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r36, View.class, "com.obric.aiagent.plugin"));
        OButton r37 = getBinding().f24588J;
        d.h.b.o.c(r37, "userTakeOver");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r37, View.class, "com.obric.aiagent.plugin"));
    L74:
        if (r29.isLastStep() == false) goto L87;
        LockableScrollView r38 = getBinding().E;
        d.h.b.o.c(r38, "tvCardContentContainer");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r38, View.class, "com.obric.aiagent.plugin"));
        OButton r39 = getBinding().f24588J;
        d.h.b.o.c(r39, "userTakeOver");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r39, View.class, "com.obric.aiagent.plugin"));
        getBinding().H.setVisibility(8);
        getBinding().f.setVisibility(8);
        getBinding().j.setVisibility(8);
        getBinding().p.setVisibility(8);
        if (com.obric.autoaction.e.e.f24684a.a() == false) goto L78;
        getBinding().g.setVisibility(0);
    L79:
        getBinding().t.setVisibility(8);
        if (this.isClarifyInputInflate == false) goto L82;
        ViewStub r40 = getBinding().r;
        d.h.b.o.c(r40, "inputContent");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r40, View.class, "com.obric.aiagent.plugin"));
    L82:
        TextView r41 = getBinding().D;
        d.h.b.o.c(r41, "tvCardContent");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r41, View.class, "com.obric.aiagent.plugin"));
        getBinding().g.setOnClickListener(new $$Lambda$SurfaceCardActivity$V38mKmf_crBG17gRXVANybSrO4(this));
        updateTitleText((CharSequence) ZeusTransformUtils.preCheckCast(r29.getAction(), CharSequence.class, "com.obric.aiagent.plugin"));
        setRootForeground(r29.isSuccess());
        if (r29.isSuccess() == false) goto L85;
        this.isTaskSuccess = true;
        getBinding().F.setGradientColorEnabled(false);
        getBinding().F.setTextColor(getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_green_7, "color", "oui_functional_green_7")));
        TouchAwareConstraintLayout r42 = getBinding().l;
        Resources r43 = Resources.getSystem();
        d.h.b.o.c(r43, "Resources.getSystem()");
        r42.setRadius(d.i.a.a(TypedValue.applyDimension(1, 28, r43.getDisplayMetrics())));
        String r44 = r18;
        setUserAdditionContent(r44);
    L86:
        getBinding().i.setVisibility(0);
        this.mFirstBubbled = false;
        this.inBlockingStatus = false;
    L88:
        if (r30 == true) goto L90;
    L101:
        maybeSetupManualOpMode(r29, false);
        if (this.mUsingBubbledThinkingCard == false) goto L105;
        syncBubbleStatus(this.mBubbled);
    L105:
        if (r29.getActionType() != 2) goto L107;
    L110:
        getBinding().o.setAutoFreeze(true);
        return;
    L107:
        if (r29.getActionType() == 3) goto L110;
        getBinding().o.setAutoFreeze(false);
        return;
    L90:
        if (r29.getActionType() != 2) goto L101;
        if (r31 == null) goto L101;
        if (r31.e() != com.obric.autogui.session.state.a.h.b.f31244d.a()) goto L101;
        Bundle r45 = r31.d();
        if (r45 == null) goto L101;
        String r46 = r45.getString(r16);
        if (r46 == null) goto L101;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r46, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L101;
        String r47 = getString(ZeusTransformUtils.mapRes(R.string.surface_card_get_user_clarify, WsChannelMultiProcessSharedProvider.STRING_TYPE, r34), new Object[]{r46});
        d.h.b.o.c(r47, "getString(...)");
        updateTitleText((CharSequence) ZeusTransformUtils.preCheckCast(r47, CharSequence.class, "com.obric.aiagent.plugin"));
        TextView r48 = getBinding().D;
        d.h.b.o.c(r48, "tvCardContent");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r48, View.class, "com.obric.aiagent.plugin"));
        updateContentText((CharSequence) ZeusTransformUtils.preCheckCast(r44, CharSequence.class, "com.obric.aiagent.plugin"));
        goto L101
    L85:
        r44 = r18;
        goto L86
    L78:
        getBinding().g.setVisibility(8);
        goto L79
    L87:
        r44 = r18;
    L71:
        r34 = r12;
    L20:
        r16 = "operating_reason_msg";
        goto L23
    L72:
        r16 = "operating_reason_msg";
        r34 = "surface_card_get_user_clarify";
        r18 = "";
        goto L74
    L5:
        com.obric.autoaction.e.b.f24680a.a(TAG, "updateCardContent action " + r29.getActionProtocolType() + ", fromResume=" + r30);
        goto L6
    }

    private static final void updateCardContent$lambda$41(SurfaceCardActivity r3) {
        SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.module.view.e r0 = com.obric.autoaction.app.launcherpage.module.view.e.f24295a;
        OButton r5 = r4.getBinding().H;
        d.h.b.o.c(r5, "userExecuteButton");
        r0.a((TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.aiagent.plugin"));
    }

    private static final void updateCardContent$lambda$44(SurfaceCardActivity r2, View r3) {
        final SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if (r4.USE_ASSIST_INPUT == false) goto L7;
        IAssistInputHost r5 = (IAssistInputHost) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistInputHost.class), IAssistInputHost.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L12;
        IAssistInputHost.DefaultImpls.openInput$default(r5, true, null, 2, null);
        return;
    L12:
        return;
    L7:
        Dialog r6 = r4.clarifyAddingDialog;
        if (r6 == null) goto L10;
        r6.dismiss();
    L10:
        r4.clarifyAddingDialog = com.obric.autoaction.presentation.h.a(r4, new $$Lambda$SurfaceCardActivity$bjH_1d22NE1suuR9AZTMFMUpoKs(r4));
    }

    private static final x updateCardContent$lambda$44$lambda$43(SurfaceCardActivity r2, String r3) {
        SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "input");
        r4.exitClarifyUI(r3);
        r4.getViewModel().a(r3, "gui_another");
        return x.f38692a;
    }

    private static final void updateCardContent$lambda$45(SurfaceCardActivity r3) {
        SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.module.view.e r0 = com.obric.autoaction.app.launcherpage.module.view.e.f24295a;
        OButton r5 = r4.getBinding().f24591c;
        d.h.b.o.c(r5, "assistClarfiyBtn");
        r0.a((TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.aiagent.plugin"));
    }

    private static final void updateCardContent$lambda$50(SurfaceCardActivity r6, ViewStub r7, final View r8) {
        final SurfaceCardActivity r9 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r6, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        r9.isClarifyInputInflate = true;
        r9.clarifyInputArea = r8;
        EditText r10 = (EditText) ZeusTransformUtils.preCheckCast(r8.findViewById(ZeusTransformUtils.mapRes(R.id.input_text, DbHelper.COL_ID, "input_text")), EditText.class, "com.obric.aiagent.plugin");
        r9.clarifyEditText = r10;
        if (r10 == null) goto L5;
        r10.setHint((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.surface_card_input_content, WsChannelMultiProcessSharedProvider.STRING_TYPE, "surface_card_input_content")), CharSequence.class, "com.obric.aiagent.plugin"));
    L5:
        EditText r11 = r9.clarifyEditText;
        if (r11 == null) goto L8;
        TextView r12 = (TextView) ZeusTransformUtils.preCheckCast(r11, TextView.class, "com.obric.aiagent.plugin");
        TextWatcher r2 = new SurfaceCardActivity$updateCardContent$lambda$50$$inlined$doAfterTextChanged$1(r9);
        r12.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r2, TextWatcher.class, "com.obric.aiagent.plugin"));
        TextWatcher r13 = (TextWatcher) ZeusTransformUtils.preCheckCast(r2, TextWatcher.class, "com.obric.aiagent.plugin");
    L8:
        View r14 = r8.findViewById(ZeusTransformUtils.mapRes(R.id.send_button, DbHelper.COL_ID, "send_button"));
        r14.setOnClickListener(new $$Lambda$SurfaceCardActivity$PZ_MG6gp_3SjyX5IfjGofWH5jRU(r9, r8));
        d.h.b.o.a(r14);
        com.obric.autoaction.presentation.k.a(r14, r9.clarifyEditText);
    }

    private static final void updateCardContent$lambda$50$lambda$49$lambda$48(SurfaceCardActivity r7, View r8, View r9) {
        SurfaceCardActivity r10 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r7, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        boolean r11 = false;
        r10.inBlockingStatus = false;
        EditText r1 = r10.clarifyEditText;
        if (r1 == null) goto L5;
        Editable r2 = r1.getText();
    L6:
        String r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r2), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L9;
        r11 = true;
    L9:
        if (r11 == false) goto L11;
        AOUserInterfaceTools r12 = AOUserInterfaceTools.INSTANCE;
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.aiagent.plugin");
        String r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.surface_card_please_input_content, WsChannelMultiProcessSharedProvider.STRING_TYPE, "surface_card_please_input_content"));
        d.h.b.o.c(r14, "getString(...)");
        r12.showAppToast(r13, (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        com.obric.autoaction.presentation.widget.a r15 = r10.getViewModel();
        EditText r4 = r10.clarifyEditText;
        if (r4 == null) goto L14;
        Editable r5 = r4.getText();
    L15:
        String r6 = String.valueOf(r5);
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        com.obric.autoaction.presentation.widget.a.a(r15, r6, null, 2, null);
        EditText r16 = r10.clarifyEditText;
        if (r16 == null) goto L21;
        r16.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
    L21:
        r10.userClarifyInfo = r3;
        d.h.b.o.a(r8);
        com.obric.oui.animation.style.b.b(r8);
        r10.setClarifyInputDone(true);
        return;
    L14:
        r5 = null;
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    private static final void updateCardContent$lambda$53$lambda$51(EditText r3, SurfaceCardActivity r4) {
        SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r4, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        boolean r0 = true;
        if (((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L20;
        View r7 = r5.clarifyInputArea;
        if (r7 != null) goto L10;
    L15:
        r0 = false;
    L16:
        if (r0 == false) goto L20;
        EditText r8 = r5.clarifyEditText;
        if (r8 == null) goto L22;
        com.obric.autogui.util.ui.d.f31580a.a(r8, (p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.aiagent.plugin"));
        return;
    L22:
        return;
    L10:
        if (r7.getVisibility() != 0) goto L12;
        boolean r9 = true;
    L13:
        if (r9 != true) goto L15;
    L12:
        r9 = false;
    L20:
        Loog.INSTANCE.d(TAG, "activity is not visible, not request focus and show soft keyboard");
        return;
    L5:
        r6 = false;
        goto L6
    }

    private static final void updateCardContent$lambda$53$lambda$52(View r0, boolean r1) {
        if (r1 == true) goto L5;
        d.h.b.o.a(r0);
        com.obric.oui.animation.style.b.b(r0);
        return;
    }

    private static final void updateCardContent$lambda$54(SurfaceCardActivity r7, View r8) {
        SurfaceCardActivity r9 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r7, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(r9, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new o(r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void configGuiClarifyOptions(final OButton r4, final IAutoAgentWidgetStateListener.ClarifyOptions r5) {
        d.h.b.o.e(r4, "button");
        d.h.b.o.e(r5, "option");
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5.getOption(), CharSequence.class, "com.obric.aiagent.plugin"));
        r4.setOnClickListener(new $$Lambda$SurfaceCardActivity$IIfHayFc7sWt4xv54kqIxaAAwt4(this, r5));
        if (r5.getHighLight() == false) goto L5;
        r4.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.bg_button_gradient, "drawable", "bg_button_gradient"));
        r4.post(new $$Lambda$SurfaceCardActivity$nkMvBqWp_5pWrgjOta85Kxx4Vg(r4));
        return;
    L5:
        r4.setBackgroundResource(ZeusTransformUtils.mapRes(R.color.oui_fill_element_2, "color", "oui_fill_element_2"));
        r4.getPaint().setShader(null);
        r4.setTextColor(getColor(ZeusTransformUtils.mapRes(R.color.oui_text_1, "color", "oui_text_1")));
    }

    private static final void configGuiClarifyOptions$lambda$56(SurfaceCardActivity r1, IAutoAgentWidgetStateListener.ClarifyOptions r2, View r3) {
        SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        r4.exitClarifyUI(r2.getOption());
        r4.getViewModel().a(r2.getOption(), "gui_player_btn");
    }

    private static final void configGuiClarifyOptions$lambda$57(OButton r3) {
        com.obric.autoaction.app.launcherpage.module.view.e.f24295a.a((TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin"));
    }

    public final void exitClarifyUI(String r8) {
        d.h.b.o.e(r8, "text");
        this.inBlockingStatus = false;
        setClarifyInputDone(true);
        this.userClarifyInfo = r8;
        setDraftUserClarifyInfo("");
        Dialog r2 = this.clarifyAddingDialog;
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        updateCardContentToIdle();
        getBinding().A.setVisibility(8);
        getBinding().f24589a.setVisibility(8);
        getBinding().F.setGravity(8388611);
        getBinding().h.setVisibility(8);
        getBinding().f24591c.setVisibility(8);
        String r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.surface_card_get_user_clarify, WsChannelMultiProcessSharedProvider.STRING_TYPE, "surface_card_get_user_clarify"), new Object[]{this.userClarifyInfo});
        d.h.b.o.c(r0, "getString(...)");
        updateTitleText((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"));
        getBinding().D.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
        ViewStub r7 = getBinding().r;
        d.h.b.o.c(r7, "inputContent");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"));
    }

    private final void updateTitleText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        getBinding().F.setText(r4);
    }

    private final void updateContentText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        getBinding().D.setText(r4);
        getBinding().E.post(new $$Lambda$SurfaceCardActivity$UUZsW5kEMYn9DAHI8YICKSLVViw(this));
    }

    private static final void updateContentText$lambda$58(SurfaceCardActivity r2) {
        ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).getBinding().E.fullScroll(ApWakeEvent.ACCELERATING_START);
    }

    private final void setCompoundButtonTextColor(OButton r3, int r4) {
        int r2 = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), r4);
        r3.setTextColor(r2);
        TextViewCompat.a((TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin"), ColorStateList.valueOf(r2));
    }

    private final void setRootForeground(boolean r1) {
        if (r1 == false) goto L4;
        getBinding().o.playColorAnimation(0.0f);
        return;
    L4:
        getBinding().o.playColorAnimation(1.0f);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public void onConfigurationChanged(Configuration r2) {
        d.h.b.o.e(r2, "newConfig");
        super.onConfigurationChanged(r2);
        com.obric.autoaction.presentation.g.a(this, r2);
    }

    private final void toggleCardState() {
        getBinding().l.post(new $$Lambda$SurfaceCardActivity$EAQAWScWYlY9quJzKzdGyZLKZE(this));
        if (this.isExpanded == false) goto L6;
        collapseCard();
        this.isExpanded = false;
        return;
    }

    private static final void toggleCardState$lambda$59(SurfaceCardActivity r2) {
        SurfaceCardActivity r3 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        r3.expandedHeight = r3.getBinding().l.getMeasuredHeight();
    }

    static /* synthetic */ void expandCard$default(SurfaceCardActivity r1, boolean r2, int r3, Object r4) {
        SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = false;
    L5:
        r5.expandCard(r2);
    }

    private final void expandCard(final boolean r11) {
        if (this.mUsingBubbledThinkingCard == false) goto L6;
        setBubbleForStatus$default(this, this.kBubbleOrdinary, true, false, 4, null);
        return;
    L6:
        ViewGroup.LayoutParams r0 = getBinding().x.getLayoutParams();
        d.h.b.o.a(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        int r1 = ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).bottomMargin;
        ValueAnimator r3 = ValueAnimator.ofInt(new int[]{this.collapsedHeight, this.expandedHeight});
        r3.addUpdateListener(new $$Lambda$SurfaceCardActivity$FP3Sp4dTpIZjP8ouvEl4zhUTTI(this));
        r3.setDuration(300);
        r3.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new AccelerateDecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{r1, 0});
        r2.addUpdateListener(new $$Lambda$SurfaceCardActivity$jzXYFniqgWGPPzUy3k1j8feGsuU(this));
        r2.setDuration(300);
        r2.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new AccelerateDecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        AnimatorSet r4 = new AnimatorSet();
        r4.playTogether(new Animator[]{r3, r2});
        r4.start();
        r4.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new SurfaceCardActivity$expandCard$1$1(this, r11), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
    }

    private static final void expandCard$lambda$61$lambda$60(SurfaceCardActivity r3, ValueAnimator r4) {
        SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "animation");
        ViewGroup.LayoutParams r0 = r5.getBinding().l.getLayoutParams();
        Object r6 = r4.getAnimatedValue();
        d.h.b.o.a(r6, "null cannot be cast to non-null type kotlin.Int");
        r0.height = ((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r5.getBinding().l.requestLayout();
    }

    private static final void expandCard$lambda$63$lambda$62(SurfaceCardActivity r3, ValueAnimator r4) {
        SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "animation");
        ViewGroup.LayoutParams r0 = r5.getBinding().x.getLayoutParams();
        d.h.b.o.a(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        Object r6 = r4.getAnimatedValue();
        d.h.b.o.a(r6, "null cannot be cast to non-null type kotlin.Int");
        r1.bottomMargin = ((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r5.getBinding().x.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    }

    private final void collapseCard() {
        if (this.mUsingBubbledThinkingCard == false) goto L6;
        setBubbleForStatus$default(this, this.kBubbleOrdinary, true, false, 4, null);
        return;
    L6:
        ViewGroup.LayoutParams r0 = getBinding().x.getLayoutParams();
        d.h.b.o.a(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        int r1 = ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).bottomMargin;
        int r2 = -ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.auto_ai_card_margin_bottom, "dimen", "auto_ai_card_margin_bottom"));
        ValueAnimator r4 = ValueAnimator.ofInt(new int[]{this.expandedHeight, this.collapsedHeight});
        r4.addUpdateListener(new $$Lambda$SurfaceCardActivity$y1cdxqI4D9Z0lTRVDJiSOfIlMo(this));
        r4.setDuration(300);
        r4.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new AccelerateDecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        ValueAnimator r3 = ValueAnimator.ofInt(new int[]{r1, r2});
        r3.addUpdateListener(new $$Lambda$SurfaceCardActivity$DQLCFYvGII5XUV8fEMJiA0FI4YU(this));
        r3.setDuration(300);
        r3.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new AccelerateDecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        AnimatorSet r11 = new AnimatorSet();
        r11.playTogether(new Animator[]{r4, r3});
        r11.start();
    }

    private static final void collapseCard$lambda$66$lambda$65(SurfaceCardActivity r3, ValueAnimator r4) {
        SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "animation");
        ViewGroup.LayoutParams r0 = r5.getBinding().l.getLayoutParams();
        Object r6 = r4.getAnimatedValue();
        d.h.b.o.a(r6, "null cannot be cast to non-null type kotlin.Int");
        r0.height = ((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r5.getBinding().l.requestLayout();
    }

    private static final void collapseCard$lambda$68$lambda$67(SurfaceCardActivity r3, ValueAnimator r4) {
        SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "animation");
        ViewGroup.LayoutParams r0 = r5.getBinding().x.getLayoutParams();
        d.h.b.o.a(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        Object r6 = r4.getAnimatedValue();
        d.h.b.o.a(r6, "null cannot be cast to non-null type kotlin.Int");
        r1.bottomMargin = ((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r5.getBinding().x.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    }

    public void onRestart() {
        super.onRestart();
        com.obric.autoaction.e.b.f24680a.a(TAG, "onRestart");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        isStarted = true;
        com.obric.autoaction.e.b.f24680a.a(TAG, "onStart");
        kotlinx.coroutines.b.x<GlobalUIContext> r1 = AutoActionUIContext.INSTANCE.getState();
    L3:
        GlobalUIContext r2 = r1.c();
        GlobalUIContext r5 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r2, GlobalUIContext.class, "com.obric.aiagent.plugin");
        if (r1.a(r2, GlobalUIContext.copy$default(r5, r5.getPlayer().copy(IAutoActionPresentationApi.PlayerVisibility.Visible), null, null, null, 14, null)) == false) goto L3;
        OperatingSpaceManager.INSTANCE.setMuted(false);
        ZeusTransformUtils.bindService(this, new Intent((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), FloatingWindowServiceImpl.class), (ServiceConnection) ZeusTransformUtils.preCheckCast(this.connection, ServiceConnection.class, "com.obric.aiagent.plugin"), 1, "com.obric.aiagent.plugin");
        initViewState();
        setupVirtualDisplay();
        reportActivityShowing(true);
    }

    static /* synthetic */ void checkNeedExpandCard$default(SurfaceCardActivity r1, boolean r2, int r3, Object r4) {
        SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = false;
    L5:
        r5.checkNeedExpandCard(r2);
    }

    private final void checkNeedExpandCard(boolean r2) {
        if (this.isExpanded == true) goto L5;
        expandCard(r2);
        this.isExpanded = true;
        return;
    L5:
        toggleCloseButtonVisibility(r2);
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Loog.INSTANCE.d(TAG, "onResume");
        boolean r0 = true;
        isResumed = true;
        getWindow().getDecorView().setBackgroundColor(0);
        SpaceStatus r7 = null;
        if (getIntent().getBooleanExtra("new_task", false) == false) goto L12;
        Loog.INSTANCE.d(TAG, " show surfaceview placeholder " + getIntent().hashCode());
        getIntent().putExtra("new_task", false);
        if (getIntent().getBooleanExtra("hide_placeholder", false) == false) goto L7;
        ConstraintLayout r2 = getBinding().s;
        d.h.b.o.c(r2, "ivCenterIcon");
        com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null), 0.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(1000, 0, null, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null).a(new $$Lambda$SurfaceCardActivity$zykCuMbGDTsRPcDcWYaGtCHxOi4(this)).b(), null, null, 3, null);
    L9:
        if (this.mUsingBubbledThinkingCard == false) goto L12;
        setBubbleForStatus$default(this, this.kBubbleOrdinary, false, false, 4, null);
        goto L12
    L7:
        getBinding().s.setAlpha(1.0f);
        ConstraintLayout r3 = getBinding().s;
        d.h.b.o.c(r3, "ivCenterIcon");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
    L12:
        if (getIntent().getBooleanExtra("auto_enter_call_user", false) == false) goto L22;
        IAutoActionAgentEventListener.AgentStepInfo r4 = this.stepInfo;
        if (r4 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == false) goto L22;
        getIntent().putExtra("auto_enter_call_user", false);
        userStartsCallUserOperation();
        getBinding().b().postDelayed(new $$Lambda$SurfaceCardActivity$QsSpSK9uLc3QJSRD1iEbffa91v0(this), 1000);
        goto L22
    L16:
        if (r4.getActionType() != 2) goto L18;
        r5 = true;
    L22:
        if (getIntent().getBooleanExtra("start_clarify_input", false) == false) goto L48;
        getIntent().putExtra("start_clarify_input", false);
        IAutoActionAgentEventListener.AgentStepInfo r6 = this.stepInfo;
        if (r6 != null) goto L26;
    L28:
        boolean r8 = false;
    L29:
        if (r8 == false) goto L48;
        if (this.isClarifyInputDone == true) goto L48;
        IAutoActionAgentEventListener.AgentStepInfo r9 = this.stepInfo;
        if (r9 == null) goto L44;
        List<IAutoAgentWidgetStateListener.ClarifyOptions> r10 = AutoAgentEventToWidgetStateImpl.Companion.a(r9);
        if (r10 == null) goto L44;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L39;
    L41:
        boolean r11 = false;
    L42:
        if (r11 != true) goto L44;
    L45:
        Loog.INSTANCE.i(TAG, " - [AssistInput] startClarifyInputOnShown; optionsDisplay=" + r0);
        if (r0 == true) goto L48;
        delayAssistClarifyInputShow(1000);
        goto L48
    L39:
        if (r10.size() > 2) goto L41;
        r11 = true;
    L44:
        r0 = false;
        goto L45
    L26:
        if (r6.getActionType() != 3) goto L28;
        r8 = true;
    L48:
        AOOperatingSpace r1 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r1 == null) goto L51;
        r7 = r1.getSpaceStatus();
    L51:
        if (r7 == null) goto L57;
        configSecureIsland(r7.isSecure());
        if (r7.isSecure() == false) goto L55;
        getWindow().addFlags(8192);
        return;
    L55:
        getWindow().clearFlags(8192);
        return;
    }

    private static final x onResume$lambda$72(SurfaceCardActivity r1, boolean r2, Throwable r3) {
        SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, " hide surfaceview placeholder for `hide_placeholder`");
        r4.getBinding().s.setVisibility(8);
        return x.f38692a;
    }

    private static final void onResume$lambda$73(SurfaceCardActivity r2) {
        SurfaceCardActivity r3 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r2, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if (r3.isCallUserInProgress == false) goto L6;
        r3.syncBubbleStatus(true);
        return;
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        com.obric.autoaction.e.b.f24680a.a(TAG, "onPause");
        isResumed = false;
        com.obric.autoaction.presentation.i.a().c(0);
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public void onNewIntent(Intent r4) {
        super.onNewIntent(r4);
        Loog r0 = Loog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("onNewIntent: ");
        if (r4 == null) goto L5;
        int r2 = r4.hashCode();
    L6:
        r0.i(TAG, r1.append(r2).toString());
        if (r4 == null) goto L10;
        setIntent(r4);
        reportActivitySourceFrom();
        return;
    L10:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        isStarted = false;
        kotlinx.coroutines.b.x<GlobalUIContext> r1 = AutoActionUIContext.INSTANCE.getState();
    L3:
        GlobalUIContext r2 = r1.c();
        GlobalUIContext r4 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r2, GlobalUIContext.class, "com.obric.aiagent.plugin");
        if (r1.a(r2, GlobalUIContext.copy$default(r4, r4.getPlayer().copy(IAutoActionPresentationApi.PlayerVisibility.Invisible), null, null, null, 14, null)) == false) goto L3;
        com.obric.autoaction.e.b.f24680a.a(TAG, "onStop");
        OperatingSpaceManager.INSTANCE.setMuted(true);
        reportActivityShowing(false);
        com.obric.autoaction.userreport.a r3 = this.reportController;
        if (r3 == null) goto L8;
        r3.c();
    L8:
        toggleCloseButtonVisibility(false);
        boolean r0 = getIntent().getBooleanExtra("from_finish", false);
        if (r0 == false) goto L11;
    L19:
        com.obric.autoaction.e.b.f24680a.a(TAG, "return in onStop, fromFinish " + r0 + " taskTerminate " + this.taskTerminate);
        unbindService();
        return;
    L11:
        if (this.taskTerminate == true) goto L19;
        FloatingWindowServiceImpl r5 = this.floatingWindowService;
        if (r5 == null) goto L16;
        r5.showFloatingWindow();
    L17:
        unbindService();
        return;
    L16:
        com.obric.autoaction.e.b.f24680a.a(TAG, "floatingWindowService is null");
        goto L17
    }

    private final void unbindService() {
        if (this.bound == false) goto L6;
        ZeusTransformUtils.unbindService(this, (ServiceConnection) ZeusTransformUtils.preCheckCast(this.connection, ServiceConnection.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.bound = false;
        return;
    }

    @Override // com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback
    public void onSurfaceViewOriginTouchEvent(MotionEvent r4) {
        d.h.b.o.e(r4, "e");
        Loog.INSTANCE.d(TAG, "onSurfaceViewOriginTouchEvent: " + r4);
        getPlayerActionTracker().onReceiveTouchEvent(r4);
    }

    @Override // com.obric.autogui.common.api.platform.special.VDBackNavListener
    public void onVDBackNavigationStarted() {
        Loog.INSTANCE.d(TAG, "onSurfaceViewBackNavigationStarted, isCallUser " + this.isCallUserInProgress);
        syncBubbleStatus(true);
        stopAutoResume(false);
    }

    @Override // com.obric.autogui.common.api.platform.special.VDBackNavListener
    public void onVDBackNavigationDone() {
        Loog.INSTANCE.d(TAG, "onSurfaceViewBackNavigationDone");
        startAutoResume$default(this, false, 1, null);
    }

    @Override // com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback
    public void onSurfaceViewTouched() {
        Loog.INSTANCE.d(TAG, "onSurfaceViewTouched, isCallUser " + this.isCallUserInProgress);
        syncBubbleStatus(true);
        stopAutoResume(false);
        this.mStartedSurfaceViewTouching = true;
    }

    @Override // com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback
    public void onSurfaceViewTouchEnded() {
        Loog.INSTANCE.d(TAG, "onSurfaceViewTouchEnded");
        if (this.mStartedSurfaceViewTouching == false) goto L6;
        startAutoResume$default(this, false, 1, null);
        this.mStartedSurfaceViewTouching = false;
        return;
    }

    @Override // com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback
    public void onSurfaceViewTouchCanceled() {
        Loog.INSTANCE.d(TAG, "onSurfaceViewTouchCancelled");
        if (this.mStartedSurfaceViewTouching == false) goto L6;
        startAutoResume$default(this, false, 1, null);
        this.mStartedSurfaceViewTouching = false;
        return;
    }

    private final void setDimMode(boolean r6) {
        SurfaceView r0 = getBinding().y;
        if (r6 == false) goto L5;
        int r5 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.window_dim_color, "color", "window_dim_color"));
    L6:
        r0.setForeground((Drawable) ZeusTransformUtils.preCheckCast(new ColorDrawable(r5), Drawable.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r5 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.sf_normal_dim, "color", "sf_normal_dim"));
        goto L6
    }

    static /* synthetic */ void setBubbleForStatus$default(SurfaceCardActivity r1, PlayerBubble.b r2, boolean r3, boolean r4, int r5, Object r6) {
        SurfaceCardActivity r7 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = true;
    L5:
        r7.setBubbleForStatus(r2, r3, r4);
    }

    private final void setBubbleForStatus(PlayerBubble.b r2, boolean r3, boolean r4) {
        this.mBubbled = r3;
        getBinding().q.setStaticStatus(r2);
        if (r4 == false) goto L6;
        syncBubbleStatus(r3);
        return;
    }

    private final void setBubbled(boolean r1) {
        this.mBubbled = r1;
    }

    private final void syncBubbleStatus(boolean r2) {
        if (this.inBlockingStatus == false) goto L5;
        r2 = false;
    L5:
        this.mBubbled = r2;
        if (r2 == false) goto L8;
        getBinding().q.showBubble();
        hideShadowLayout();
    L9:
        this.mBubbled = r2;
        return;
    L8:
        getBinding().q.hideBubble();
        showShadowLayout();
        goto L9
    }

    private final void hideShadowLayout() {
        LinearLayout r1 = getBinding().x;
        d.h.b.o.c(r1, "shadowLayout");
        if (com.obric.oui.common.util.k.e((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        if (getBinding().x.getAlpha() != 0.0f) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        if (this.isShadowHideAnimating == true) goto L15;
        this.isShadowHideAnimating = true;
        LinearLayout r3 = getBinding().x;
        d.h.b.o.c(r3, "shadowLayout");
        com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null).a(com.obric.common.oea.foundation.animation.h.a.EnumC0885a.i, null, this.shadowHideY, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32430c, com.obric.common.oea.foundation.animation.h.e.c.g, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null), 0.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.c.f32439b, com.obric.common.oea.foundation.animation.h.e.b.f32433a, com.obric.common.oea.foundation.animation.h.e.d.f32443a), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null).a(new $$Lambda$SurfaceCardActivity$tX6kpm1ZxNwkvm9_WWUJy4oi8j8(this)).b(), null, null, 3, null);
        return;
    L15:
        return;
    L7:
        r2 = false;
        goto L8
    }

    private static final x hideShadowLayout$lambda$79(SurfaceCardActivity r1, boolean r2, final Throwable r3) {
        SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        r4.isShadowHideAnimating = false;
        if (r4.isShadowShowAnimating == true) goto L5;
        LinearLayout r5 = r4.getBinding().x;
        d.h.b.o.c(r5, "shadowLayout");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
    L5:
        if (r3 == null) goto L8;
        Loog.INSTANCE.ep(TAG, new $$Lambda$SurfaceCardActivity$EHEPOj7fRO7jQ5UCN5UruQ4raIA(r3), $$Lambda$SurfaceCardActivity$2HKivmxiid5RqQNFuVYkbEWbb_M.INSTANCE);
    L8:
        return x.f38692a;
    }

    private static final String hideShadowLayout$lambda$79$lambda$77(Throwable r2) {
        return "hideShadowLayout animation error: " + r2.getMessage();
    }

    private final void showShadowLayout() {
        LinearLayout r1 = getBinding().x;
        d.h.b.o.c(r1, "shadowLayout");
        if (com.obric.oui.common.util.k.e((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin")) == true) goto L10;
        if (getBinding().x.getAlpha() != 1.0f) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        return;
    L7:
        r2 = false;
    L10:
        if (this.isShadowShowAnimating == true) goto L14;
        this.isShadowShowAnimating = true;
        LinearLayout r3 = getBinding().x;
        d.h.b.o.c(r3, "shadowLayout");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        LinearLayout r4 = getBinding().x;
        d.h.b.o.c(r4, "shadowLayout");
        com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null).a(com.obric.common.oea.foundation.animation.h.a.EnumC0885a.i, null, this.shadowShowY, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32430c, com.obric.common.oea.foundation.animation.h.e.c.g, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null), 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.c.f32439b, com.obric.common.oea.foundation.animation.h.e.b.f32433a, com.obric.common.oea.foundation.animation.h.e.d.f32443a), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null).a(new $$Lambda$SurfaceCardActivity$dbVHXiyrSeSe918IS3pvlTIi90Y(this)).b(), null, null, 3, null);
        return;
    }

    private static final x showShadowLayout$lambda$82(SurfaceCardActivity r1, boolean r2, final Throwable r3) {
        ((SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin")).isShadowShowAnimating = false;
        if (r3 == null) goto L6;
        Loog.INSTANCE.ep(TAG, new $$Lambda$SurfaceCardActivity$isdfGL5c0SyXO7kUGCKJepTWFYo(r3), $$Lambda$SurfaceCardActivity$_2VObSv9vfMb24LI5bROeqcTDX0.INSTANCE);
    L6:
        return x.f38692a;
    }

    private static final String showShadowLayout$lambda$82$lambda$80(Throwable r2) {
        return "showShadowLayout animation error: " + r2.getMessage();
    }

    private final void setupImeInsets() {
        if (this.USE_ASSIST_INPUT == false) goto L6;
        LinearLayout r2 = getBinding().x;
        d.h.b.o.c(r2, "shadowLayout");
        com.obric.autogui.util.ui.b.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void clearImeInsetsListening() {
        if (this.USE_ASSIST_INPUT == false) goto L6;
        LinearLayout r2 = getBinding().x;
        d.h.b.o.c(r2, "shadowLayout");
        com.obric.autogui.util.ui.b.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final boolean canEnterManualOpMode() {
        if (ensureActiveSession() == true) goto L5;
        return false;
    L5:
        VDTrackingApp r5 = (VDTrackingApp) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE.getTrackingApp().a(), VDTrackingApp.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L9;
        Loog.INSTANCE.d(TAG, "canEnterManualOpMode ==> false, no tracking app.");
        return false;
    L9:
        AppBlackListEvent r2 = AppBlackListEventHolder.INSTANCE.getBlackListEvent();
        if (r2 != null) goto L12;
    L17:
        String r6 = com.obric.autoaction.presentation.function.b.f24937a.a();
        if (r6 == null) goto L21;
        Loog.INSTANCE.d(TAG, "canEnterManualOpMode ==> false, activeFunction: " + r6);
        return false;
    L21:
        return true;
    L12:
        if (d.h.b.o.a(r2.getActivityName().getPackageName(), r5.getPackageName()) == false) goto L17;
        if (r2.getBlackListState() == AppBlackListState.UserDefinedBlackList) goto L17;
        Loog.INSTANCE.d(TAG, "blocked by BL event: " + r2);
        return false;
    }

    static /* synthetic */ boolean configureHandUsingMode$default(SurfaceCardActivity r1, boolean r2, boolean r3, int r4, Object r5) {
        SurfaceCardActivity r6 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = true;
    L6:
        return r6.configureHandUsingMode(r2, r3);
    }

    private final boolean configureHandUsingMode(boolean r7, boolean r8) {
        OperatingSpaceManager r0 = OperatingSpaceManager.INSTANCE;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin");
        SurfaceView r4 = getBinding().y;
        d.h.b.o.c(r4, "surfaceView");
        DisplayHost r3 = (DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Surface(r4), DisplayHost.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L5;
        SurfaceCardActivity r5 = this;
    L6:
        boolean r2 = r0.configureHandUsing(r1, r7, r3, (HandUsingEventsCallback) ZeusTransformUtils.preCheckCast(r5, HandUsingEventsCallback.class, "com.obric.aiagent.plugin")).isSuccess();
        if (r2 == false) goto L13;
        this.isInHandUsingMode = r7;
        if (r7 == false) goto L11;
        setBubbleForStatus(this.kBubbleCallUser, true, r8);
    L12:
        setDimMode(false);
        setRootForeground(false);
        goto L13
    L11:
        setBubbleForStatus(this.kBubbleOrdinary, false, r8);
    L13:
        return r2;
    L5:
        r5 = null;
        goto L6
    }

    private final void startManualOpMode() {
        com.obric.autoaction.presentation.function.a r0 = com.obric.autoaction.presentation.function.b.f24937a.b("ManualOperating");
        if (r0 == null) goto L5;
        r0.c();
    L5:
        maybeSetupManualOpMode$default(this, null, false, 3, null);
    }

    static /* synthetic */ void maybeSetupManualOpMode$default(SurfaceCardActivity r1, IAutoActionAgentEventListener.AgentStepInfo r2, boolean r3, int r4, Object r5) {
        SurfaceCardActivity r6 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = true;
    L8:
        r6.maybeSetupManualOpMode(r2, r3);
    }

    private final void maybeSetupManualOpMode(IAutoActionAgentEventListener.AgentStepInfo r14, boolean r15) {
        com.obric.autoaction.presentation.function.a r0 = com.obric.autoaction.presentation.function.b.f24937a.b("ManualOperating");
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = r0.b();
        if (r14 != null) goto L8;
        r14 = this.stepInfo;
    L8:
        if (r14 == null) goto L10;
        long r3 = r14.getCreationTimeMillis();
    L12:
        if (r1 <= r3) goto L14;
        boolean r16 = true;
    L15:
        int r2 = c.f24768c[r0.a().ordinal()];
        if (r2 != 1) goto L18;
        this.inBlockingStatus = false;
        configureHandUsingMode(true, r15);
        this.mBubbled = true;
        com.obric.autoaction.presentation.function.c r17 = this.mActiveAutoResumer;
        if (r17 == null) goto L27;
        r17.b();
    L27:
        androidx.lifecycle.k r18 = q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin"));
        this.mActiveAutoResumer = new com.obric.autoaction.presentation.function.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), getBinding().q, com.obric.autoaction.presentation.function.a.a.b.class, (am) ZeusTransformUtils.preCheckCast(r18, am.class, "com.obric.aiagent.plugin"), 0, 16, null);
        startAutoResume(false);
        return;
    L18:
        if (r2 != 2) goto L32;
        if (r16 == false) goto L29;
        this.inBlockingStatus = false;
        configureHandUsingMode(false, r15);
        stopAutoResume(false);
        this.mActiveAutoResumer = null;
        if (this.isClarifyInputInflate == false) goto L30;
        ViewStub r19 = getBinding().r;
        d.h.b.o.c(r19, "inputContent");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.aiagent.plugin"));
        TextView r13 = getBinding().D;
        d.h.b.o.c(r13, "tvCardContent");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.aiagent.plugin"));
        return;
    L30:
        return;
    L29:
        return;
    L32:
        return;
    L14:
        r16 = false;
        goto L15
    L10:
        r3 = Long.MAX_VALUE;
        goto L12
    }

    static /* synthetic */ void maybeSetupCallUserMode$default(SurfaceCardActivity r1, IAutoActionAgentEventListener.AgentStepInfo r2, int r3, Object r4) {
        SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        r5.maybeSetupCallUserMode(r2);
    }

    private final void maybeSetupCallUserMode(IAutoActionAgentEventListener.AgentStepInfo r6) {
        com.obric.autoaction.presentation.function.a r0 = com.obric.autoaction.presentation.function.b.f24937a.b("CallUser");
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = r0.b();
        if (r6 != null) goto L8;
        r6 = this.stepInfo;
    L8:
        if (r6 == null) goto L10;
        long r3 = r6.getCreationTimeMillis();
    L12:
        if (r1 <= r3) goto L14;
        boolean r7 = true;
    L15:
        com.obric.autoaction.presentation.function.a.b r2 = r0.a();
        if (c.f24768c[r2.ordinal()] != 2) goto L20;
        if (r7 == false) goto L21;
        maybeExitCallUser();
        this.mActiveAutoResumer = null;
        return;
    L21:
        return;
    L20:
        return;
    L14:
        r7 = false;
        goto L15
    L10:
        r3 = Long.MAX_VALUE;
        goto L12
    }

    private final void handleFunctionStateEvent(com.obric.autoaction.presentation.b.e r4) {
        String r0 = r4.a();
        if (d.h.b.o.a(r0, "ManualOperating") == false) goto L6;
        maybeSetupManualOpMode$default(this, null, false, 3, null);
    L8:
        getPlayerActionTracker().onFunctionStateChange(r4);
        return;
    L6:
        if (d.h.b.o.a(r0, "CallUser") == false) goto L8;
        maybeSetupCallUserMode$default(this, null, 1, null);
        goto L8
    }

    static /* synthetic */ void startAutoResume$default(SurfaceCardActivity r1, boolean r2, int r3, Object r4) {
        SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = false;
    L5:
        r5.startAutoResume(r2);
    }

    private final void startAutoResume(boolean r1) {
        com.obric.autoaction.presentation.function.c r0 = this.mActiveAutoResumer;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    private final void stopAutoResume(boolean r5) {
        com.obric.autoaction.presentation.function.c r4 = this.mActiveAutoResumer;
        if (r4 != null) goto L6;
        Loog.INSTANCE.w(TAG, " - [AutoResume] with NULL resumer!");
        return;
    L6:
        Loog.INSTANCE.d(TAG, " - [AutoResume] with resumer: " + r4 + " (immd=" + r5 + ')');
        if (r5 == false) goto L9;
        r4.d();
        return;
    L9:
        r4.c();
    }

    public final com.obric.common.oea.foundation.animation.manager.d getCurrentAlphaAnim() {
        return this.currentAlphaAnim;
    }

    public final void setCurrentAlphaAnim(com.obric.common.oea.foundation.animation.manager.d r1) {
        this.currentAlphaAnim = r1;
    }

    public final com.obric.common.oea.foundation.animation.manager.d getCurrentScaleAnim() {
        return this.currentScaleAnim;
    }

    public final void setCurrentScaleAnim(com.obric.common.oea.foundation.animation.manager.d r1) {
        this.currentScaleAnim = r1;
    }

    private final void cancelRunningAnimations() {
        com.obric.common.oea.foundation.animation.manager.d r0 = this.currentAlphaAnim;
        if (r0 == null) goto L5;
        r0.a(true);
    L5:
        com.obric.common.oea.foundation.animation.manager.d r2 = this.currentScaleAnim;
        if (r2 == null) goto L9;
        r2.a(true);
        return;
    }

    public final void animateHideCardLayout() {
        Loog.INSTANCE.d(TAG, "animateHideCardLayout");
        cancelRunningAnimations();
        LinearLayout r1 = getBinding().x;
        d.h.b.o.c(r1, "shadowLayout");
        com.obric.common.oea.foundation.animation.a.b.a r15 = com.obric.common.oea.foundation.animation.a.b.a.b(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null), 0.9f, 0.9f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32432e, com.obric.common.oea.foundation.animation.h.e.c.g, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null);
        com.obric.common.oea.foundation.animation.h.a.b r16 = com.obric.common.oea.foundation.animation.h.a.b.f;
        Resources r6 = Resources.getSystem();
        d.h.b.o.c(r6, "Resources.getSystem()");
        this.currentScaleAnim = com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(r15, r16, null, d.i.a.a(TypedValue.applyDimension(1, 200, r6.getDisplayMetrics())), (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.b(com.obric.common.oea.foundation.animation.h.e.a.f32432e, com.obric.common.oea.foundation.animation.h.e.c.g, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 16, null).a(new $$Lambda$SurfaceCardActivity$yY_IDbi2uQNty_LdU9tbzocSVpc(this)).b(), null, null, 3, null);
        ConstraintLayout r2 = getBinding().k;
        d.h.b.o.c(r2, "cardContentGroup");
        this.currentAlphaAnim = com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null), 0.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.c.f32439b, com.obric.common.oea.foundation.animation.h.e.b.f32433a, com.obric.common.oea.foundation.animation.h.e.d.l), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null).b(), null, null, 3, null);
        getBinding().b().postDelayed(new $$Lambda$SurfaceCardActivity$rJaU5MujNZYcr2wuexQDnVczaw(this), 64);
    }

    private static final x animateHideCardLayout$lambda$84(SurfaceCardActivity r3, boolean r4, Throwable r5) {
        SurfaceCardActivity r6 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        TouchAwareConstraintLayout r7 = r6.getBinding().l;
        Resources r1 = Resources.getSystem();
        d.h.b.o.c(r1, "Resources.getSystem()");
        r7.setRadius(d.i.a.a(TypedValue.applyDimension(1, 16, r1.getDisplayMetrics())));
        r6.getBinding().l.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.card_bg_with_border_normal_16, "drawable", "card_bg_with_border_normal_16"));
        Loog.INSTANCE.d(TAG, " hide card animation end " + r4 + ' ');
        return x.f38692a;
    }

    private static final void animateHideCardLayout$lambda$85(SurfaceCardActivity r4) {
        SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r4, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        TouchAwareConstraintLayout r0 = r5.getBinding().l;
        Resources r2 = Resources.getSystem();
        d.h.b.o.c(r2, "Resources.getSystem()");
        r0.setRadius(d.i.a.a(TypedValue.applyDimension(1, 16, r2.getDisplayMetrics())));
        r5.getBinding().l.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.card_bg_with_border_normal_16, "drawable", "card_bg_with_border_normal_16"));
    }

    public final void animateShowCardLayout() {
        if (this.binding != null) goto L5;
        return;
    L5:
        Loog.INSTANCE.d(TAG, "animateShowCardLayout");
        cancelRunningAnimations();
        ViewParent r1 = getBinding().x.getParent();
        d.h.b.o.a(r1, "null cannot be cast to non-null type android.view.View");
        int r2 = ((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin")).getWidth();
        getBinding().x.measure(View.MeasureSpec.makeMeasureSpec(r2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r8 = getBinding().x.getMeasuredHeight();
        LinearLayout r3 = getBinding().x;
        d.h.b.o.c(r3, "shadowLayout");
        this.currentScaleAnim = com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.b.a.b(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null), 1.0f, 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.g, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null), com.obric.common.oea.foundation.animation.h.a.b.f, null, r8, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.g, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 16, null).a(new $$Lambda$SurfaceCardActivity$bcl4EJqns55bVCYWKMEkZqEJPhg(this)).b(), null, null, 3, null);
        getBinding().b().postDelayed(new $$Lambda$SurfaceCardActivity$hwXpZza4yND4_8N6sjKnBJPVc3E(this), 64);
        ConstraintLayout r4 = getBinding().k;
        d.h.b.o.c(r4, "cardContentGroup");
        this.currentAlphaAnim = com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null), 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.c.f32439b, com.obric.common.oea.foundation.animation.h.e.b.f32433a, com.obric.common.oea.foundation.animation.h.e.d.l), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null).b(), null, null, 3, null);
    }

    private static final x animateShowCardLayout$lambda$87(SurfaceCardActivity r3, boolean r4, Throwable r5) {
        SurfaceCardActivity r6 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, " show card animation end " + r4 + ' ');
        TouchAwareConstraintLayout r7 = r6.getBinding().l;
        Resources r1 = Resources.getSystem();
        d.h.b.o.c(r1, "Resources.getSystem()");
        r7.setRadius(d.i.a.a(TypedValue.applyDimension(1, 28, r1.getDisplayMetrics())));
        r6.getBinding().l.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.card_bg_with_border_normal, "drawable", "card_bg_with_border_normal"));
        LinearLayout r8 = r6.getBinding().x;
        d.h.b.o.c(r8, "shadowLayout");
        View r9 = (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        Objects.requireNonNull(r10, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r10.height = -2;
        r9.setLayoutParams(r10);
        return x.f38692a;
    }

    private static final void animateShowCardLayout$lambda$88(SurfaceCardActivity r4) {
        SurfaceCardActivity r5 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r4, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        TouchAwareConstraintLayout r0 = r5.getBinding().l;
        Resources r2 = Resources.getSystem();
        d.h.b.o.c(r2, "Resources.getSystem()");
        r0.setRadius(d.i.a.a(TypedValue.applyDimension(1, 28, r2.getDisplayMetrics())));
        r5.getBinding().l.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.card_bg_with_border_normal, "drawable", "card_bg_with_border_normal"));
    }

    private final void reportActivitySourceFrom() {
        ComponentName r0 = getIntent().getComponent();
        String r7 = getIntent().getStringExtra("source_from");
        if (r7 != null) goto L14;
        boolean r1 = true;
        if (r0 == null) goto L11;
        String r3 = r0.getClassName();
        if (r3 == null) goto L11;
        if (d.o.o.c(r3, "SurfaceCardStarterActivity", false, 2, null) != true) goto L11;
    L12:
        if (r1 == false) goto L14;
        r7 = "virtual_screen";
    L11:
        r1 = false;
    L14:
        com.obric.autoaction.presentation.biztrack.b.f24834a.a(r7, r0);
    }

    private final void reportActivityShowing(boolean r2) {
        if (r2 == false) goto L8;
        IAutoActionAgentEventListener.SessionInfo r1 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE.getOngoingSessionInfo().a(), IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        Loog.INSTANCE.e(TAG, "reportActivityShowing() failed -- no session info.");
        return;
    L7:
        com.obric.autoaction.presentation.biztrack.b.f24834a.a(r1);
        return;
    L8:
        reportActivitySourceFrom();
        com.obric.autoaction.presentation.biztrack.b.f24834a.a();
    }

    private final void delayAssistClarifyInputShow(long r9) {
        getBinding().f24591c.setEnabled(false);
        getBinding().j.setEnabled(false);
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r9, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void shakeView(View r13) {
        float r0 = TypedValue.applyDimension(1, 2, Resources.getSystem().getDisplayMetrics());
        float r7 = -r0;
        ObjectAnimator r12 = ObjectAnimator.ofPropertyValuesHolder(r13, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f, r7, r7, r0, r0, 0.0f}), PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f, 0.0f, r7, r7, r0, 0.0f})});
        d.h.b.o.c(r12, "ofPropertyValuesHolder(...)");
        r12.setDuration(300);
        r12.start();
    }
}
