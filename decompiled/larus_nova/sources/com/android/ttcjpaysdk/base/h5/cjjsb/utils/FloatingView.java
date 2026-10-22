package com.android.ttcjpaysdk.base.h5.cjjsb.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.ui.widget.CJAnnieXCard;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0003`abB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\n\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002J\u0006\u0010B\u001a\u00020CJ\b\u0010D\u001a\u00020\u000fH\u0002J\u0016\u0010E\u001a\u00020>2\u0006\u0010F\u001a\u00020(2\u0006\u0010G\u001a\u00020\tJ\u0006\u0010H\u001a\u00020>J\u0006\u0010I\u001a\u00020\tJ\u0006\u0010$\u001a\u00020\tJ\b\u0010&\u001a\u00020\tH\u0002J\u001c\u0010J\u001a\u00020>2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\tH\u0007J\u0012\u0010M\u001a\u00020>2\b\u0010N\u001a\u0004\u0018\u00010OH\u0014J\u0006\u0010P\u001a\u00020>J\u0012\u0010Q\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0006\u0010R\u001a\u00020>J(\u0010S\u001a\u00020>2\u0006\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020(2\u0006\u0010W\u001a\u00020(H\u0014J\u0012\u0010X\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0006\u0010Y\u001a\u00020>J\u0006\u0010Z\u001a\u00020>J\u0006\u0010[\u001a\u00020>J\u000e\u0010\\\u001a\u00020>2\u0006\u0010]\u001a\u00020^J\b\u0010_\u001a\u00020>H\u0002R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u000e\u0010$\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u000e\u00100\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u000602R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0011\"\u0004\b9\u0010\u0013R\u000e\u0010:\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/FloatingView;", "Landroid/widget/FrameLayout;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Activity;", "contentView", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard;", "(Landroid/app/Activity;Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard;)V", "autoToEdge", "", "getAutoToEdge", "()Z", "setAutoToEdge", "(Z)V", "bottomMargin", "", "getBottomMargin", "()F", "setBottomMargin", "(F)V", "callback", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/FloatingView$FloatingViewCallback;", "getCallback", "()Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/FloatingView$FloatingViewCallback;", "setCallback", "(Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/FloatingView$FloatingViewCallback;)V", "getContentView", "()Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard;", "draggable", "getDraggable", "setDraggable", "hasMoveUp", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initTransitionX", "getInitTransitionX", "setInitTransitionX", "isHalfShow", "isMoving", "isNearestLeft", "layoutGravity", "", "getLayoutGravity", "()I", "setLayoutGravity", "(I)V", "marginToEdge", "getMarginToEdge", "setMarginToEdge", "maxXPositionValue", "moveAnimator", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/FloatingView$MoveAnimator;", "originalRawX", "originalRawY", "originalX", "originalY", "topMargin", "getTopMargin", "setTopMargin", "touchSlop", "CJTag", "", "changeOriginalTouchParams", "", "event", "Landroid/view/MotionEvent;", "dragView", "getCurPosition", "Lorg/json/JSONObject;", "getSafeYPosition", "halfShow", "peekValue", "isPercentage", "hide", "isDraggable", "moveToEdge", "isLeft", "needAnim", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onHide", "onInterceptTouchEvent", SendEventContainerMethodParamModel.EventKinds.onShow, "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "release", SVGRenderEngine.RESTORE, "show", "updatePosition", "positionConfig", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/PositionConfigV2;", "updateSize", "Companion", "FloatingViewCallback", "MoveAnimator", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FloatingView extends FrameLayout implements ICJTag {
    public static final Companion Companion = null;
    public static final int MARGIN_EDGE = 0;
    private static int screenHeight;
    private static int screenWidth;
    private static int statusBarHeight;
    private boolean autoToEdge;
    private float bottomMargin;
    private FloatingViewCallback callback;
    private final CJAnnieXCard contentView;
    private boolean draggable;
    private final AtomicBoolean hasMoveUp;
    private float initTransitionX;
    private final AtomicBoolean isHalfShow;
    private AtomicBoolean isMoving;
    private boolean isNearestLeft;
    private int layoutGravity;
    private int marginToEdge;
    private int maxXPositionValue;
    private MoveAnimator moveAnimator;
    private float originalRawX;
    private float originalRawY;
    private float originalX;
    private float originalY;
    private float topMargin;
    private final int touchSlop;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/FloatingView$Companion;", "", "()V", "MARGIN_EDGE", "", "screenHeight", "screenWidth", "statusBarHeight", "getScreenHeight", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getScreenWidth", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_base_h5_cjjsb_utils_FloatingView$Companion_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
            return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        }

        public final int getScreenHeight(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
            if (FloatingView.access$getScreenHeight$cp() > 0) goto L6;
            Object r102 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L17
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Throwable -> L17
            WindowManager r103 = (WindowManager) r102;     // Catch: Throwable -> L17
            if (r103 == null) goto L16;
            Display r104 = r103.getDefaultDisplay();     // Catch: Throwable -> L17
            Point r105 = new Point();     // Catch: Throwable -> L17
            if (r104 == null) goto L12;
            r104.getRealSize(r105);     // Catch: Throwable -> L17
            return r105.y;
        L12:
            return CJPayBasicUtils.getScreenHeight(r100);
        L16:
            return INVOKEVIRTUAL_com_android_ttcjpaysdk_base_h5_cjjsb_utils_FloatingView$Companion_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).heightPixels;
        L6:
            return FloatingView.access$getScreenHeight$cp();
        L17:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            if (Result.m9452exceptionOrNullimpl(r107) == null) goto L22;
            r107 = Integer.valueOf(CJPayBasicUtils.getScreenHeight(r100));
        L22:
            Number r108 = (Number) r107;
            FloatingView.access$setScreenHeight$cp(r108.intValue());
            return r108.intValue();
        }

        public final int getScreenWidth(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (FloatingView.access$getScreenWidth$cp() > 0) goto L5;
            int r101 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r100);
            FloatingView.access$setScreenWidth$cp(r101);
            return r101;
        L5:
            return FloatingView.access$getScreenWidth$cp();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/FloatingView$FloatingViewCallback;", "", "onMoveTo", "", "side", "", "y", "", "onMoving", "x", "startMove", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface FloatingViewCallback {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onMoveTo(FloatingViewCallback r100, String r101, float r102) {
                Intrinsics.checkNotNullParameter(r101, "side");
            }

            public static void onMoving(FloatingViewCallback r100, float r101, float r102) {
            }

            public static void startMove(FloatingViewCallback r100) {
            }
        }

        void onMoveTo(String r100, float r101);

        void onMoving(float r100, float r101);

        void startMove();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/FloatingView$MoveAnimator;", "Ljava/lang/Runnable;", "(Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/FloatingView;)V", "destinationX", "", "destinationY", "handler", "Landroid/os/Handler;", "startingTime", "", "run", "", "start", "x", "y", "stop", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class MoveAnimator implements Runnable {
        private float destinationX;
        private float destinationY;
        private final Handler handler;
        private long startingTime;
        final /* synthetic */ FloatingView this$0;

        @Override // java.lang.Runnable
        public void run() {
            com_android_ttcjpaysdk_base_h5_cjjsb_utils_FloatingView$MoveAnimator_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_android_ttcjpaysdk_base_h5_cjjsb_utils_FloatingView$MoveAnimator__run$___twin___() {
            if (this.this$0.getRootView() != null) goto L5;
            return;
        L5:
            if (this.this$0.getRootView().getParent() == null) goto L10;
            AnimatorSet r100 = new AnimatorSet();
            final FloatingView r101 = this.this$0;
            ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r101.getTranslationX(), this.destinationX});
            r102.setDuration(300);
            r102.addListener(new FloatingView$MoveAnimator$run$1$1$1(r101));
            Unit r103 = Unit.INSTANCE;
            r100.playTogether(new Animator[]{r102});
            ObjectAnimator r104 = ObjectAnimator.ofFloat(r101, "y", new float[]{r101.getY(), this.destinationY});
            r104.setDuration(300);
            r100.playTogether(new Animator[]{r104});
            r100.start();
            return;
        }

        public final void stop() {
            this.handler.removeCallbacks(this);
        }

        public MoveAnimator(FloatingView r100) {
            this.this$0 = r100;
            this.handler = new Handler(Looper.getMainLooper());
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_android_ttcjpaysdk_base_h5_cjjsb_utils_FloatingView$MoveAnimator_com_larus_apm_impl_protector_RunnableLancet_run(MoveAnimator r100) {
            r100.com_android_ttcjpaysdk_base_h5_cjjsb_utils_FloatingView$MoveAnimator__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public final void start(float r100, float r101) {
            this.destinationX = r100;
            this.destinationY = r101;
            this.startingTime = System.currentTimeMillis();
            this.handler.post(this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public String CJTag() {
        return "FloatingView";
    }

    public final void moveToEdge() {
        moveToEdge$default(this, false, false, 3, null);
    }

    public final void moveToEdge(boolean r100) {
        moveToEdge$default(this, r100, false, 2, null);
    }

    private final boolean isNearestLeft() {
        if (getX() >= (this.maxXPositionValue / 2)) goto L5;
        boolean r100 = true;
    L6:
        this.isNearestLeft = r100;
        return r100;
    L5:
        r100 = false;
        goto L6
    }

    private final void updateSize() {
        Companion r100 = Companion;
        this.maxXPositionValue = r100.getScreenWidth(getContext()) - getWidth();
        screenHeight = r100.getScreenHeight(getContext());
    }

    public final JSONObject getCurPosition() {
        JSONObject r100 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r100, "top", Integer.valueOf(CJPayBasicExtensionKt.px(getY())));
        KtSafeMethodExtensionKt.safePut(r100, "left", Integer.valueOf(CJPayBasicExtensionKt.px(getX())));
        KtSafeMethodExtensionKt.safePut(r100, "width", Integer.valueOf(CJPayBasicExtensionKt.px(getWidth())));
        KtSafeMethodExtensionKt.safePut(r100, "height", Integer.valueOf(CJPayBasicExtensionKt.px(getHeight())));
        return r100;
    }

    public final boolean isHalfShow() {
        return this.isHalfShow.get();
    }

    private final float getSafeYPosition() {
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(getY(), this.topMargin), statusBarHeight), (Companion.getScreenHeight(getContext()) - getHeight()) - this.bottomMargin);
    }

    public final void hide() {
        if (getVisibility() != 0) goto L6;
        setVisibility(8);
        CJAnnieXCard.dispatchEvent$default(this.contentView, "ttcjpay.widget.hide", null, 2, null);
        return;
    }

    public final void onHide() {
        if (getVisibility() != 0) goto L6;
        CJAnnieXCard.dispatchEvent$default(this.contentView, "ttcjpay.widget.viewDisappeared", null, 2, null);
        return;
    }

    public final void onShow() {
        if (getVisibility() != 0) goto L6;
        CJAnnieXCard.dispatchEvent$default(this.contentView, "ttcjpay.widget.viewAppeared", null, 2, null);
        return;
    }

    public final void release() {
        ViewParent r100 = getParent();
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r101 = (ViewGroup) r100;
    L6:
        if (r101 == null) goto L8;
        r101.removeView(this);
    L8:
        this.contentView.release();
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void restore() {
        if (isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (getVisibility() == 0) goto L7;
        return;
    L7:
        if (this.isHalfShow.compareAndSet(true, false) == false) goto L12;
        moveToEdge$default(this, false, false, 3, null);
        setAlpha(1.0f);
        this.draggable = true;
        CJAnnieXCard.dispatchEvent$default(this.contentView, "ttcjpay.widget.restore", null, 2, null);
        return;
    }

    public final void show() {
        if (getVisibility() != 8) goto L6;
        setVisibility(0);
        CJAnnieXCard.dispatchEvent$default(this.contentView, "ttcjpay.widget.show", null, 2, null);
        return;
    }

    public static final /* synthetic */ int access$getScreenHeight$cp() {
        return screenHeight;
    }

    public static final /* synthetic */ int access$getScreenWidth$cp() {
        return screenWidth;
    }

    public final boolean getAutoToEdge() {
        return this.autoToEdge;
    }

    public final float getBottomMargin() {
        return this.bottomMargin;
    }

    public final FloatingViewCallback getCallback() {
        return this.callback;
    }

    public final CJAnnieXCard getContentView() {
        return this.contentView;
    }

    public final boolean getDraggable() {
        return this.draggable;
    }

    public final float getInitTransitionX() {
        return this.initTransitionX;
    }

    public final int getLayoutGravity() {
        return this.layoutGravity;
    }

    public final int getMarginToEdge() {
        return this.marginToEdge;
    }

    public final float getTopMargin() {
        return this.topMargin;
    }

    public final boolean isDraggable() {
        return this.draggable;
    }

    public static final /* synthetic */ void access$setScreenHeight$cp(int r100) {
        screenHeight = r100;
    }

    public static final /* synthetic */ void access$setScreenWidth$cp(int r100) {
        screenWidth = r100;
    }

    private final void changeOriginalTouchParams(MotionEvent r100) {
        this.originalX = getX();
        this.originalY = getY();
        this.originalRawX = r100.getRawX();
        this.originalRawY = r100.getRawY();
    }

    private final void dragView(MotionEvent r100) {
        if (this.draggable == true) goto L5;
        return;
    L5:
        ViewParent r101 = getParent();
        if ((r101 instanceof ViewGroup) == false) goto L8;
        ViewGroup r102 = (ViewGroup) r101;
    L9:
        if (r102 == null) goto L11;
        r102.invalidate();
    L11:
        setX((this.originalX + r100.getRawX()) - this.originalRawX);
        setY((this.originalY + r100.getRawY()) - this.originalRawY);
        if (this.hasMoveUp.getAndSet(false) == false) goto L16;
        FloatingViewCallback r103 = this.callback;
        if (r103 == null) goto L16;
        r103.startMove();
    L16:
        FloatingViewCallback r104 = this.callback;
        if (r104 == null) goto L20;
        r104.onMoving(getX(), getY());
        return;
    L20:
        return;
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        updateSize();
        if (this.autoToEdge == false) goto L6;
        moveToEdge$default(this, false, false, 3, null);
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        StringBuilder r101 = new StringBuilder("[onInterceptTouchEvent] MotionEvent: ");
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.getAction());
    L6:
        r101.append(r102);
        i(r101.toString());
        if (r100 != null) goto L10;
        return false;
    L10:
        if (this.isHalfShow.get() == false) goto L12;
        return true;
    L12:
        int r103 = r100.getAction();
        if (r103 != 0) goto L15;
        changeOriginalTouchParams(r100);
        updateSize();
        this.moveAnimator.stop();
        return false;
    L15:
        if (r103 == 2) goto L18;
    L27:
        return false;
    L18:
        if (this.draggable == true) goto L21;
        return false;
    L21:
        if (this.isMoving.get() == false) goto L23;
        return true;
    L23:
        float r104 = r100.getRawX() - this.originalRawX;
        float r105 = r100.getRawY() - this.originalRawY;
        float r106 = (r104 * r104) + (r105 * r105);
        int r107 = this.touchSlop;
        if (r106 < (r107 * r107)) goto L27;
        i("[onInterceptTouchEvent] set isMoving = true");
        this.isMoving.set(true);
        return true;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.isHalfShow.get() == false) goto L9;
        i("[onTouchEvent] 半展示状态不允许操作");
        return true;
    L9:
        int r101 = r100.getAction();
        if (r101 != 1) goto L12;
        i("[onTouchEvent] ACTION_UP");
        this.hasMoveUp.set(true);
        this.isMoving.compareAndSet(true, false);
        if (this.autoToEdge == false) goto L19;
        moveToEdge$default(this, false, false, 3, null);
    L19:
        return false;
    L12:
        if (r101 != 2) goto L19;
        dragView(r100);
        return true;
    }

    public final void setAutoToEdge(boolean r100) {
        this.autoToEdge = r100;
    }

    public final void setBottomMargin(float r100) {
        this.bottomMargin = r100;
    }

    public final void setCallback(FloatingViewCallback r100) {
        this.callback = r100;
    }

    public final void setDraggable(boolean r100) {
        this.draggable = r100;
    }

    public final void setInitTransitionX(float r100) {
        this.initTransitionX = r100;
    }

    public final void setLayoutGravity(int r100) {
        this.layoutGravity = r100;
    }

    public final void setMarginToEdge(int r100) {
        this.marginToEdge = r100;
    }

    public final void setTopMargin(float r100) {
        this.topMargin = r100;
    }

    public final void updatePosition(PositionConfigV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "positionConfig");
        if (Intrinsics.areEqual(r100.offsetType, LayoutSizeLargeModeConfig.TYPE_PERCENTAGE) == false) goto L5;
        float r101 = (Companion.getScreenWidth(getContext()) * r100.horizontalOffset) / 100.0f;
    L7:
        if (Intrinsics.areEqual(r100.offsetType, LayoutSizeLargeModeConfig.TYPE_PERCENTAGE) == false) goto L9;
        float r102 = (Companion.getScreenHeight(getContext()) * r100.verticalOffset) / 100.0f;
    L10:
        int r103 = ((Number) KtSafeMethodExtensionKt.tf(Intrinsics.areEqual(r100.horizontalAnchor, "left"), 3, 5)).intValue();
        int r104 = ((Number) KtSafeMethodExtensionKt.tf(Intrinsics.areEqual(r100.verticalAnchor, "top"), 48, 80)).intValue();
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.gravity = r103 | r104;
        if (r103 != 3) goto L13;
        r105.leftMargin = (int) r101;
    L14:
        if (r104 != 48) goto L16;
        r105.topMargin = (int) r102;
    L17:
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        setLayoutParams(r105);
        return;
    L16:
        r105.bottomMargin = (int) r102;
        goto L17
    L13:
        r105.rightMargin = (int) r101;
        goto L14
    L9:
        r102 = CJPayBasicExtensionKt.dpF(r100.verticalOffset);
        goto L10
    L5:
        r101 = CJPayBasicExtensionKt.dpF(r100.horizontalOffset);
        goto L7
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    public FloatingView(Activity r100, CJAnnieXCard r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "contentView");
        super(r100);
        this.contentView = r101;
        this.moveAnimator = new MoveAnimator(this);
        this.touchSlop = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.isNearestLeft = true;
        this.autoToEdge = true;
        Companion r102 = Companion;
        this.topMargin = r102.getScreenHeight(r100) * 0.05f;
        this.bottomMargin = r102.getScreenHeight(r100) * 0.12f;
        this.layoutGravity = 3;
        if (statusBarHeight > 0) goto L6;
        statusBarHeight = CJPayBasicUtils.getStatusBarHeight(r100);
    L6:
        if (screenHeight > 0) goto L8;
        screenHeight = r102.getScreenHeight(r100);
    L8:
        addView(r101);
        updateSize();
        this.isMoving = new AtomicBoolean(false);
        this.hasMoveUp = new AtomicBoolean(true);
        this.isHalfShow = new AtomicBoolean(false);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    public final void halfShow(int r100, boolean r101) {
        if (isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (getVisibility() == 0) goto L7;
        return;
    L7:
        if (this.isHalfShow.compareAndSet(false, true) == true) goto L9;
        return;
    L9:
        if (isNearestLeft() == false) goto L15;
        float r102 = (getTranslationX() - getX()) - getWidth();
        if (r101 == false) goto L13;
        int r103 = r100 * getWidth();
    L14:
        float r104 = r102 + r103;
    L20:
        this.moveAnimator.start(r104, getY());
        setAlpha(0.34f);
        this.draggable = false;
        CJAnnieXCard.dispatchEvent$default(this.contentView, "ttcjpay.widget.halfShow", null, 2, null);
        return;
    L13:
        r103 = CJPayBasicExtensionKt.dp(r100);
        goto L14
    L15:
        float r105 = (getTranslationX() + screenWidth) - getX();
        if (r101 == false) goto L18;
        int r106 = r100 * getWidth();
    L19:
        r104 = r105 - r106;
        goto L20
    L18:
        r106 = CJPayBasicExtensionKt.dp(r100);
        goto L19
    }

    public final void moveToEdge(boolean r100, boolean r101) {
        if (this.layoutGravity != 3) goto L7;
        if (r100 == false) goto L6;
        float r102 = this.initTransitionX;
    L11:
        float r103 = getSafeYPosition();
        if (r101 == false) goto L14;
        this.moveAnimator.start(r102, r103);
        return;
    L14:
        setTranslationX(r102);
        setY(r103);
        return;
    L6:
        float r104 = (this.initTransitionX + Companion.getScreenWidth(getContext())) - (this.marginToEdge * 2);
        int r105 = getWidth();
    L10:
        r102 = r104 - r105;
        goto L11
    L7:
        if (r100 == true) goto L9;
        r102 = this.initTransitionX;
        goto L11
    L9:
        r104 = this.initTransitionX;
        r105 = (Companion.getScreenWidth(getContext()) - (this.marginToEdge * 2)) - getWidth();
        goto L10
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        updateSize();
        this.initTransitionX = getTranslationX();
    }

    public static /* synthetic */ void moveToEdge$default(FloatingView r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isNearestLeft();
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = true;
    L8:
        r100.moveToEdge(r101, r102);
    }
}
