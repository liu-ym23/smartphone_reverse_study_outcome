package com.android.ttcjpaysdk.base.h5.cjjsb;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 N2\u00020\u0001:\u0003NOPB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020>H\u0002J\b\u0010B\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\nH\u0002J\u0012\u0010C\u001a\u00020>2\b\b\u0002\u0010D\u001a\u00020\nH\u0007J\u0012\u0010E\u001a\u00020>2\b\u0010F\u001a\u0004\u0018\u00010GH\u0014J\u0012\u0010H\u001a\u00020\n2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010I\u001a\u00020\n2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0010\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020\u0007H\u0016J\b\u0010L\u001a\u00020>H\u0002J\u0010\u0010M\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R\u0014\u00104\u001a\b\u0018\u000105R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/StarkFloatingView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoToEdge", "", "getAutoToEdge", "()Z", "setAutoToEdge", "(Z)V", "callback", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/StarkFloatingView$FloatingViewCallback;", "getCallback", "()Lcom/android/ttcjpaysdk/base/h5/cjjsb/StarkFloatingView$FloatingViewCallback;", "setCallback", "(Lcom/android/ttcjpaysdk/base/h5/cjjsb/StarkFloatingView$FloatingViewCallback;)V", "value", "Landroid/view/View;", "contentView", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "enableHorizontalMoving", "getEnableHorizontalMoving", "setEnableHorizontalMoving", "hasMoveUp", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isMoving", "isNearestLeft", "lastTouchDownTime", "", "layoutGravity", "getLayoutGravity", "()I", "setLayoutGravity", "(I)V", "maxVerticalPercent", "", "getMaxVerticalPercent", "()F", "setMaxVerticalPercent", "(F)V", "maxXPositionValue", "minVerticalPercent", "getMinVerticalPercent", "setMinVerticalPercent", "moveAnimator", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/StarkFloatingView$MoveAnimator;", "originalRawX", "originalRawY", "originalX", "originalY", "scaledTouchSlop", "screenHeight", "statusBarHeight", "changeOriginalTouchParams", "", "event", "Landroid/view/MotionEvent;", "dealClickEvent", "isClickEvent", "moveToEdge", "isLeft", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInterceptTouchEvent", "onTouchEvent", "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "updateSize", "updateViewPosition", "Companion", "FloatingViewCallback", "MoveAnimator", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class StarkFloatingView extends FrameLayout {
    public static final Companion Companion = null;
    public static final int MARGIN_EDGE = 0;
    private static final int TOUCH_TIME_THRESHOLD = 150;
    private boolean autoToEdge;
    private FloatingViewCallback callback;
    private View contentView;
    private boolean enableHorizontalMoving;
    private final AtomicBoolean hasMoveUp;
    private final AtomicBoolean isMoving;
    private boolean isNearestLeft;
    private long lastTouchDownTime;
    private int layoutGravity;
    private float maxVerticalPercent;
    private int maxXPositionValue;
    private float minVerticalPercent;
    private MoveAnimator moveAnimator;
    private float originalRawX;
    private float originalRawY;
    private float originalX;
    private float originalY;
    private final int scaledTouchSlop;
    private int screenHeight;
    private int statusBarHeight;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/StarkFloatingView$Companion;", "", "()V", "MARGIN_EDGE", "", "TOUCH_TIME_THRESHOLD", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/StarkFloatingView$FloatingViewCallback;", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", GXTemplateKey.GAIAX_ANIMATION, "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onMoveTo", "side", "", "y", "", "onMoving", "x", "startMove", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface FloatingViewCallback extends Animator.AnimatorListener {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onAnimationCancel(FloatingViewCallback r100, Animator r101) {
                Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_ANIMATION);
            }

            public static void onAnimationEnd(FloatingViewCallback r100, Animator r101) {
                Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_ANIMATION);
            }

            public static void onAnimationRepeat(FloatingViewCallback r100, Animator r101) {
                Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_ANIMATION);
            }

            public static void onAnimationStart(FloatingViewCallback r100, Animator r101) {
                Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_ANIMATION);
            }

            public static void onMoveTo(FloatingViewCallback r100, String r101, float r102) {
                Intrinsics.checkNotNullParameter(r101, "side");
            }

            public static void onMoving(FloatingViewCallback r100, float r101, float r102) {
            }

            public static void startMove(FloatingViewCallback r100) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        void onAnimationCancel(Animator r100);

        @Override // android.animation.Animator.AnimatorListener
        void onAnimationEnd(Animator r100);

        @Override // android.animation.Animator.AnimatorListener
        void onAnimationRepeat(Animator r100);

        @Override // android.animation.Animator.AnimatorListener
        void onAnimationStart(Animator r100);

        void onMoveTo(String r100, float r101);

        void onMoving(float r100, float r101);

        void startMove();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0084\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/StarkFloatingView$MoveAnimator;", "Ljava/lang/Runnable;", "(Lcom/android/ttcjpaysdk/base/h5/cjjsb/StarkFloatingView;)V", "destinationX", "", "destinationY", "handler", "Landroid/os/Handler;", "startingTime", "", "run", "", "start", "x", "y", "stop", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class MoveAnimator implements Runnable {
        private float destinationX;
        private float destinationY;
        private final Handler handler;
        private long startingTime;
        final /* synthetic */ StarkFloatingView this$0;

        @Override // java.lang.Runnable
        public void run() {
            com_android_ttcjpaysdk_base_h5_cjjsb_StarkFloatingView$MoveAnimator_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_android_ttcjpaysdk_base_h5_cjjsb_StarkFloatingView$MoveAnimator__run$___twin___() {
            if (this.this$0.getRootView() != null) goto L5;
            return;
        L5:
            if (this.this$0.getRootView().getParent() == null) goto L10;
            AnimatorSet r100 = new AnimatorSet();
            final StarkFloatingView r101 = this.this$0;
            ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r101.getTranslationX(), this.destinationX});
            r102.setDuration(300);
            r102.addListener(new StarkFloatingView$MoveAnimator$run$1$1$1(r101));
            Unit r103 = Unit.INSTANCE;
            r100.playTogether(new Animator[]{r102});
            ObjectAnimator r104 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r101.getY(), this.destinationY});
            r104.setDuration(300);
            r100.playTogether(new Animator[]{r104});
            r100.start();
            return;
        }

        public final void stop() {
            this.handler.removeCallbacks(this);
        }

        public MoveAnimator(StarkFloatingView r100) {
            this.this$0 = r100;
            this.handler = new Handler(Looper.getMainLooper());
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_android_ttcjpaysdk_base_h5_cjjsb_StarkFloatingView$MoveAnimator_com_larus_apm_impl_protector_RunnableLancet_run(MoveAnimator r100) {
            r100.com_android_ttcjpaysdk_base_h5_cjjsb_StarkFloatingView$MoveAnimator__run$___twin___();     // Catch: Throwable -> L4
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

    public StarkFloatingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public StarkFloatingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final void dealClickEvent() {
    }

    public final void moveToEdge() {
        moveToEdge$default(this, false, 1, null);
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

    private final boolean isClickEvent() {
        if ((System.currentTimeMillis() - this.lastTouchDownTime) >= 150) goto L5;
        return true;
    L5:
        return false;
    }

    private final void updateSize() {
        this.maxXPositionValue = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(getContext()) - getWidth();
        this.screenHeight = PluginFloatingViewManager.INSTANCE.getScreenHeight(getContext());
    }

    public final boolean getAutoToEdge() {
        return this.autoToEdge;
    }

    public final FloatingViewCallback getCallback() {
        return this.callback;
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final boolean getEnableHorizontalMoving() {
        return this.enableHorizontalMoving;
    }

    public final int getLayoutGravity() {
        return this.layoutGravity;
    }

    public final float getMaxVerticalPercent() {
        return this.maxVerticalPercent;
    }

    public final float getMinVerticalPercent() {
        return this.minVerticalPercent;
    }

    private final void changeOriginalTouchParams(MotionEvent r100) {
        this.originalX = getX();
        this.originalY = getY();
        this.originalRawX = r100.getRawX();
        this.originalRawY = r100.getRawY();
        this.lastTouchDownTime = System.currentTimeMillis();
    }

    private final void updateViewPosition(MotionEvent r100) {
        ViewParent r101 = getParent();
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r102 = (ViewGroup) r101;
    L6:
        if (r102 == null) goto L9;
        r102.invalidate();
    L9:
        if (this.enableHorizontalMoving == false) goto L11;
        setX((this.originalX + r100.getRawX()) - this.originalRawX);
    L11:
        float r103 = (this.originalY + r100.getRawY()) - this.originalRawY;
        int r104 = this.statusBarHeight;
        if (r103 >= r104) goto L14;
        r103 = r104;
    L14:
        int r105 = this.screenHeight;
        if (r103 <= r105) goto L17;
        r103 = r105;
    L17:
        setY(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r103, r105 * (1.0f - this.maxVerticalPercent)), (this.screenHeight * (1 - this.minVerticalPercent)) - getHeight()));
        if (this.hasMoveUp.getAndSet(false) == false) goto L22;
        FloatingViewCallback r106 = this.callback;
        if (r106 == null) goto L22;
        r106.startMove();
    L22:
        FloatingViewCallback r107 = this.callback;
        if (r107 == null) goto L26;
        r107.onMoving(getX(), getY());
        return;
    L26:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void moveToEdge(boolean r100) {
        int r101 = 0;
        if (this.layoutGravity != 3) goto L7;
        if (r100 == true) goto L9;
        r101 = this.maxXPositionValue + 0;
    L9:
        MoveAnimator r102 = this.moveAnimator;
        Intrinsics.checkNotNull(r102);
        r102.start(r101, getY());
        return;
    L7:
        if (r100 == false) goto L9;
        r101 = 0 - this.maxXPositionValue;
        goto L9
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        updateSize();
        if (this.autoToEdge == false) goto L6;
        moveToEdge(this.isNearestLeft);
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.getAction();
        if (r101 != 0) goto L8;
        this.isMoving.set(false);
        changeOriginalTouchParams(r100);
        updateSize();
        MoveAnimator r102 = this.moveAnimator;
        if (r102 == null) goto L30;
        r102.stop();
    L30:
        return false;
    L8:
        if (r101 != 1) goto L10;
    L25:
        this.isMoving.set(false);
    L26:
        return false;
    L10:
        if (r101 == 2) goto L15;
        if (r101 == 3) goto L25;
    L15:
        if (this.isMoving.get() == false) goto L18;
        return true;
    L18:
        if (this.enableHorizontalMoving == false) goto L20;
        float r103 = r100.getRawX() - this.originalRawX;
    L21:
        float r104 = r100.getRawY() - this.originalRawY;
        float r105 = this.scaledTouchSlop;
        if (((r103 * r103) + (r104 * r104)) < (r105 * r105)) goto L26;
        this.isMoving.set(true);
        return true;
    L20:
        r103 = 0.0f;
        goto L21
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (isClickable() == false) goto L23;
        if (r100 == null) goto L23;
        int r101 = r100.getAction();
        if (r101 == 0) goto L19;
        if (r101 != 1) goto L10;
        this.hasMoveUp.set(true);
        if (this.autoToEdge == false) goto L17;
        moveToEdge$default(this, false, 1, null);
    L17:
        if (isClickEvent() == false) goto L22;
        dealClickEvent();
    L22:
        return true;
    L10:
        if (r101 != 2) goto L22;
        updateViewPosition(r100);
        goto L22
    L19:
        changeOriginalTouchParams(r100);
        updateSize();
        MoveAnimator r102 = this.moveAnimator;
        if (r102 == null) goto L22;
        r102.stop();
    L23:
        return false;
    }

    public final void setAutoToEdge(boolean r100) {
        this.autoToEdge = r100;
    }

    public final void setCallback(FloatingViewCallback r100) {
        this.callback = r100;
    }

    public final void setContentView(View r100) {
        removeAllViews();
        ViewGroup r101 = null;
        if (r100 == null) goto L5;
        ViewParent r102 = r100.getParent();
    L7:
        if ((r102 instanceof ViewGroup) == false) goto L9;
        r101 = (ViewGroup) r102;
    L9:
        if (r101 == null) goto L11;
        r101.removeAllViews();
    L11:
        addView(r100);
        updateSize();
        this.contentView = r100;
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void setEnableHorizontalMoving(boolean r100) {
        this.enableHorizontalMoving = r100;
    }

    public final void setLayoutGravity(int r100) {
        this.layoutGravity = r100;
    }

    public final void setMaxVerticalPercent(float r100) {
        this.maxVerticalPercent = r100;
    }

    public final void setMinVerticalPercent(float r100) {
        this.minVerticalPercent = r100;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(0);
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        getChildAt(r102).setVisibility(0);
        r102 = r102 + 1;
        goto L3
    }

    public StarkFloatingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.isNearestLeft = true;
        this.scaledTouchSlop = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.autoToEdge = true;
        this.layoutGravity = 3;
        this.minVerticalPercent = 0.05f;
        this.maxVerticalPercent = 0.88f;
        this.moveAnimator = new MoveAnimator(this);
        this.statusBarHeight = CJPayBasicUtils.getStatusBarHeight(r100);
        setClickable(true);
        this.screenHeight = PluginFloatingViewManager.INSTANCE.getScreenHeight(r100);
        updateSize();
        this.isMoving = new AtomicBoolean(false);
        this.hasMoveUp = new AtomicBoolean(true);
    }

    public static /* synthetic */ void moveToEdge$default(StarkFloatingView r100, boolean r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.isNearestLeft();
    L6:
        r100.moveToEdge(r101);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveToEdge");
    }

    public /* synthetic */ StarkFloatingView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
