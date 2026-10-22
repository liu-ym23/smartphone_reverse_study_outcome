package com.bytedance.android.ec.window.base.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.window.base.setting.ECWindowSettings;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 e2\u00020\u0001:\u0003fghB\t\b\u0016¢\u0006\u0004\bX\u0010YB\u0011\b\u0016\u0012\u0006\u0010[\u001a\u00020Z¢\u0006\u0004\bX\u0010\\B\u0019\b\u0016\u0012\u0006\u0010]\u001a\u00020&\u0012\u0006\u0010^\u001a\u00020&¢\u0006\u0004\bX\u0010_B\u001d\b\u0016\u0012\b\u0010a\u001a\u0004\u0018\u00010`\u0012\b\u0010c\u001a\u0004\u0018\u00010b¢\u0006\u0004\bX\u0010dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bJ\u0019\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J8\u0010 \u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0016J@\u0010%\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\bH\u0016J0\u0010)\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J(\u0010+\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u001a\u0010,\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010-\u001a\u00020\u0005H\u0004R$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010>\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010D\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010?\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\"\u0010G\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010?\u001a\u0004\bH\u0010A\"\u0004\bI\u0010CR\u0016\u0010J\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010KR\u0016\u0010M\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010?R\u0016\u0010N\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010KR\"\u0010O\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010?\u001a\u0004\bP\u0010A\"\u0004\bQ\u0010CR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006i"}, d2 = {"Lcom/bytedance/android/ec/window/base/widget/ECWindowOverScrollExpandBehavior;", "Lcom/bytedance/android/ec/window/base/widget/WindowControllableAppBarSnapBehavior;", "", "cancelRecover", "fullyCollapse", "", "readyToExpand", "readyToCollapse", "", "expandLimit", "optEnable", "Landroid/view/View;", "coordinator", "initOnce", "targetOriginHeight", "targetMaxHeight", "height", "refreshTargetOriginHeight", "(Ljava/lang/Integer;)V", "enable", "setExpandEnable", "dy", "applyAdjust", "recover", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", "Lcom/google/android/material/appbar/AppBarLayout;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "directTargetChild", PickerReporterConstants.KEY.TARGET, "nestedScrollAxes", "type", "onStartNestedScroll", "coordinatorLayout", "dx", "", "consumed", "onNestedPreScroll", "", "velocityX", "velocityY", "onNestedPreFling", "abl", "onStopNestedScroll", "adjustTarget", "isExpand", "Lcom/bytedance/android/ec/window/base/widget/ECWindowOverScrollExpandBehavior$a;", "relatingAdjustTarget", "Lcom/bytedance/android/ec/window/base/widget/ECWindowOverScrollExpandBehavior$a;", "getRelatingAdjustTarget", "()Lcom/bytedance/android/ec/window/base/widget/ECWindowOverScrollExpandBehavior$a;", "setRelatingAdjustTarget", "(Lcom/bytedance/android/ec/window/base/widget/ECWindowOverScrollExpandBehavior$a;)V", "Lcom/bytedance/android/ec/window/base/widget/ECWindowOverScrollExpandBehavior$c;", "expandController", "Lcom/bytedance/android/ec/window/base/widget/ECWindowOverScrollExpandBehavior$c;", "getExpandController", "()Lcom/bytedance/android/ec/window/base/widget/ECWindowOverScrollExpandBehavior$c;", "setExpandController", "(Lcom/bytedance/android/ec/window/base/widget/ECWindowOverScrollExpandBehavior$c;)V", "expandTarget", "Landroid/view/View;", "originHeight", "I", "getOriginHeight", "()I", "setOriginHeight", "(I)V", "deltaY", "getDeltaY", "setDeltaY", "lastHeight", "getLastHeight", "setLastHeight", "couldAnimate", "Z", "isFullyCollapsing", "dyLast", "expandEnable", "snapToHeadHeight", "getSnapToHeadHeight", "setSnapToHeadHeight", "Landroid/graphics/Rect;", "expandTargetBounds", "Landroid/graphics/Rect;", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator;", "<init>", "()V", "Lcom/bytedance/android/ec/window/base/widget/WindowSnapStrategy;", "snapStrategy", "(Lcom/bytedance/android/ec/window/base/widget/WindowSnapStrategy;)V", "snapTopDownThreshold", "snapBottomUpThreshold", "(FF)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECWindowOverScrollExpandBehavior extends WindowControllableAppBarSnapBehavior {
    public static final b Companion = null;
    public static final String TAG_OVER_SCROLL_EXPAND_TARGET = "ecOverScrollExpandTarget";
    private ValueAnimator animator;
    private boolean couldAnimate;
    private int deltaY;
    private int dyLast;
    private c expandController;
    private boolean expandEnable;
    private View expandTarget;
    private final Rect expandTargetBounds;
    private boolean isFullyCollapsing;
    private int lastHeight;
    private int originHeight;
    private a relatingAdjustTarget;
    private int snapToHeadHeight;

    public static abstract class a {
    }

    public static final class b {
        public b() {
        }
    }

    public interface c {
        int a();

        void b();

        void c(int r100);

        boolean d();

        void e();

        long f();

        void onRelease(int r100);
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowOverScrollExpandBehavior f49905a;

        public d(ECWindowOverScrollExpandBehavior r100) {
            this.f49905a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Integer) == true) goto L5;
            r101 = null;
        L5:
            Integer r102 = (Integer) r101;
            if (r102 == null) goto L15;
            int r103 = r102.intValue();
            ECWindowOverScrollExpandBehavior.adjustTarget$default(this.f49905a, r103, 0, 2, null);
            c r104 = this.f49905a.getExpandController();
            if (r104 != null) goto L10;
            return;
        L10:
            if (r104.d() != true) goto L17;
            c r105 = this.f49905a.getExpandController();
            if (r105 == null) goto L18;
            r105.c(r103);
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    public static final class e implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowOverScrollExpandBehavior f49906a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public e(ECWindowOverScrollExpandBehavior r100) {
            this.f49906a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ECWindowOverScrollExpandBehavior r101 = this.f49906a;
            ECWindowOverScrollExpandBehavior.adjustTarget$default(r101, r101.getOriginHeight(), 0, 2, null);
            ECWindowOverScrollExpandBehavior.access$setFullyCollapsing$p(this.f49906a, false);
            c r102 = this.f49906a.getExpandController();
            if (r102 == null) goto L6;
            r102.b();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ECWindowOverScrollExpandBehavior.access$setFullyCollapsing$p(this.f49906a, false);
            c r101 = this.f49906a.getExpandController();
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    static {
        Companion = new b();
    }

    public final a getRelatingAdjustTarget() {
        return null;
    }

    public final void setRelatingAdjustTarget(a r100) {
    }

    private final void cancelRecover() {
        if (this.isFullyCollapsing == false) goto L8;
        ValueAnimator r100 = this.animator;
        if (r100 == null) goto L9;
        r100.cancel();
        return;
    L9:
        return;
    }

    private final int expandLimit() {
        c r100 = this.expandController;
        if (r100 == null) goto L6;
        return r100.a();
    L6:
        return com.bytedance.android.shopping.extensions.b.b(0);
    }

    private final void fullyCollapse() {
        int r100 = this.deltaY;
        if (r100 > 0) goto L5;
        return;
    L5:
        this.isFullyCollapsing = true;
        c r101 = this.expandController;
        if (r101 == null) goto L8;
        r101.onRelease(this.originHeight + r100);
    L8:
        this.deltaY = 0;
        if (this.couldAnimate == false) goto L15;
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{this.lastHeight, this.originHeight});
        c r103 = this.expandController;
        if (r103 == null) goto L13;
        long r104 = r103.f();
    L14:
        ValueAnimator r105 = r102.setDuration(r104);
        this.animator = r105;
        r105.setInterpolator(new DecelerateInterpolator());
        r105.addUpdateListener(new d(this));
        r105.addListener(new e(this));
        r105.start();
        return;
    L13:
        r104 = 200;
        goto L14
    L15:
        adjustTarget$default(this, this.originHeight, 0, 2, null);
        this.isFullyCollapsing = false;
        c r106 = this.expandController;
        if (r106 == null) goto L20;
        r106.b();
        return;
    }

    private final boolean readyToCollapse() {
        this.expandTargetBounds.setEmpty();
        View r100 = this.expandTarget;
        if (r100 == null) goto L5;
        r100.getGlobalVisibleRect(this.expandTargetBounds);
    L5:
        int r101 = this.expandTargetBounds.bottom;
        int r102 = this.originHeight;
        if (r101 > r102) goto L8;
    L10:
        return false;
    L8:
        if (r101 > (r102 + expandLimit())) goto L10;
        return true;
    }

    private final boolean readyToExpand() {
        this.expandTargetBounds.setEmpty();
        View r100 = this.expandTarget;
        if (r100 == null) goto L5;
        r100.getGlobalVisibleRect(this.expandTargetBounds);
    L5:
        int r101 = this.expandTargetBounds.bottom;
        int r102 = this.originHeight;
        if (r101 >= r102) goto L8;
    L10:
        return false;
    L8:
        if (r101 >= (r102 + expandLimit())) goto L10;
        return true;
    }

    public final boolean isExpand() {
        this.expandTargetBounds.setEmpty();
        View r100 = this.expandTarget;
        if (r100 == null) goto L6;
        r100.getGlobalVisibleRect(this.expandTargetBounds);
    L6:
        if (this.expandTargetBounds.bottom <= this.originHeight) goto L8;
        return true;
    L8:
        return false;
    }

    public void recover() {
        if (this.isFullyCollapsing == true) goto L6;
        fullyCollapse();
        return;
    }

    public ECWindowOverScrollExpandBehavior() {
        this.expandTargetBounds = new Rect();
    }

    private final boolean optEnable() {
        return ECWindowSettings.a();
    }

    public final int targetMaxHeight() {
        return targetOriginHeight() + expandLimit();
    }

    public final int getDeltaY() {
        return this.deltaY;
    }

    public final c getExpandController() {
        return this.expandController;
    }

    public final int getLastHeight() {
        return this.lastHeight;
    }

    public final int getOriginHeight() {
        return this.originHeight;
    }

    public final int getSnapToHeadHeight() {
        return this.snapToHeadHeight;
    }

    public final int targetOriginHeight() {
        return this.originHeight;
    }

    public ECWindowOverScrollExpandBehavior(WindowSnapStrategy r100) {
        Intrinsics.checkNotNullParameter(r100, "snapStrategy");
        super(r100);
        this.expandTargetBounds = new Rect();
    }

    public static final /* synthetic */ boolean access$isFullyCollapsing$p(ECWindowOverScrollExpandBehavior r100) {
        return r100.isFullyCollapsing;
    }

    public int applyAdjust(int r100) {
        if (r100 < 0) goto L5;
    L7:
        int r101 = this.deltaY;
        int r102 = (-r100) + r101;
        this.deltaY = r102;
        int r103 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r102, 0), expandLimit());
        this.deltaY = r103;
        int r104 = this.originHeight;
        int r105 = RangesKt.coerceAtLeast(r103 + r104, r104);
        adjustTarget(r105, this.deltaY);
        c r106 = this.expandController;
        if (r106 == null) goto L11;
        r106.c(r105);
    L11:
        if (r105 < (this.originHeight + expandLimit())) goto L16;
        c r107 = this.expandController;
        if (r107 == null) goto L16;
        r107.e();
    L16:
        return r101 - this.deltaY;
    L5:
        if (this.expandEnable == true) goto L7;
        return 0;
    }

    public void initOnce(View r100) {
        Intrinsics.checkNotNullParameter(r100, "coordinator");
        if (this.expandTarget != null) goto L6;
        this.expandTarget = r100.findViewWithTag("ecOverScrollExpandTarget");
    L6:
        if (this.originHeight > 0) goto L8;
        refreshTargetOriginHeight$default(this, null, 1, null);
    L8:
        this.couldAnimate = true;
    }

    public final void refreshTargetOriginHeight(Integer r100) {
        if (r100 == null) goto L4;
        int r101 = r100.intValue();
    L8:
        this.originHeight = r101;
        return;
    L4:
        View r102 = this.expandTarget;
        if (r102 == null) goto L7;
        r101 = r102.getMeasuredHeight();
        goto L8
    L7:
        r101 = 0;
        goto L8
    }

    public final void setDeltaY(int r100) {
        this.deltaY = r100;
    }

    public final void setExpandController(c r100) {
        this.expandController = r100;
    }

    public final void setExpandEnable(boolean r100) {
        this.expandEnable = r100;
    }

    public final void setLastHeight(int r100) {
        this.lastHeight = r100;
    }

    public final void setOriginHeight(int r100) {
        this.originHeight = r100;
    }

    public final void setSnapToHeadHeight(int r100) {
        this.snapToHeadHeight = r100;
    }

    public ECWindowOverScrollExpandBehavior(float r100, float r101) {
        super(r100, r101);
        this.expandTargetBounds = new Rect();
    }

    public static final /* synthetic */ void access$setFullyCollapsing$p(ECWindowOverScrollExpandBehavior r100, boolean r101) {
        r100.isFullyCollapsing = r101;
    }

    public void adjustTarget(int r100, int r101) {
        if (r100 != this.lastHeight) goto L5;
        return;
    L5:
        this.lastHeight = r100;
        View r102 = this.expandTarget;
        if (r102 == null) goto L9;
        r102.getLayoutParams().height = r100;
        r102.requestLayout();
        return;
    }

    public ECWindowOverScrollExpandBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.expandTargetBounds = new Rect();
    }

    public static /* synthetic */ void refreshTargetOriginHeight$default(ECWindowOverScrollExpandBehavior r100, Integer r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        r100.refreshTargetOriginHeight(r101);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshTargetOriginHeight");
    }

    @Override // com.bytedance.android.ec.window.base.widget.WindowControllableAppBarSnapBehavior, com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public void onStopNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, "abl");
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        recover();
        this.dyLast = 0;
        super.onStopNestedScroll(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.window.base.widget.WindowControllableAppBarSnapBehavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103) {
        onStopNestedScroll(r100, (AppBarLayout) r101, r102, r103);
    }

    public static /* synthetic */ void adjustTarget$default(ECWindowOverScrollExpandBehavior r100, int r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        r100.adjustTarget(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: adjustTarget");
    }

    public boolean onNestedPreFling(CoordinatorLayout r100, AppBarLayout r101, View r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        if (Intrinsics.areEqual(r101.getTag(), "no_fling") == false) goto L24;
        ViewGroup.LayoutParams r105 = r101.getLayoutParams();
        CoordinatorLayout.Behavior r106 = null;
        if ((r105 instanceof CoordinatorLayout.LayoutParams) == true) goto L7;
        r105 = null;
    L7:
        CoordinatorLayout.LayoutParams r107 = (CoordinatorLayout.LayoutParams) r105;
        if (r107 == null) goto L10;
        CoordinatorLayout.Behavior r108 = r107.getBehavior();
    L12:
        if ((r108 instanceof WindowControllableAppBarSnapBehavior) == false) goto L15;
        r106 = r108;
    L15:
        WindowControllableAppBarSnapBehavior r109 = (WindowControllableAppBarSnapBehavior) r106;
        if (r109 == null) goto L18;
        int r110 = r109.currentOffset();
    L20:
        if (Math.abs(r110) >= Math.abs(r101.getTotalScrollRange())) goto L24;
        return true;
    L18:
        r110 = 0;
        goto L20
    L10:
        r108 = null;
    L24:
        if (r104 <= 100) goto L27;
        this.couldAnimate = false;
    L27:
        return super.onNestedPreFling(r100, r101, r102, r103, r104);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onNestedPreFling(CoordinatorLayout r100, View r101, View r102, float r103, float r104) {
        return onNestedPreFling(r100, (AppBarLayout) r101, r102, r103, r104);
    }

    @Override // com.bytedance.android.ec.window.base.widget.WindowControllableAppBarSnapBehavior, com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public boolean onStartNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, View r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "directTargetChild");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        initOnce(r100);
        cancelRecover();
        boolean r106 = super.onStartNestedScroll(r100, r101, r102, r103, r104, r105);
        if (optEnable() == true) goto L7;
        if ((r103 instanceof ECWindowOverScrollExpandContainer) == true) goto L7;
    L11:
        return r106;
    L7:
        if (readyToExpand() == false) goto L9;
        return true;
    L9:
        if (readyToCollapse() == false) goto L11;
        return true;
    }

    @Override // com.bytedance.android.ec.window.base.widget.WindowControllableAppBarSnapBehavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r103, int r104, int r105) {
        return onStartNestedScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public void onNestedPreScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103, int r104, int[] r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r105, "consumed");
        boolean r107 = optEnable();
        if (r107 == true) goto L7;
        if ((r102 instanceof ECWindowOverScrollExpandContainer) == true) goto L7;
    L25:
        super.onNestedPreScroll(r100, r101, r102, r103, r104, r105, r106);
        return;
    L7:
        if (this.isFullyCollapsing == true) goto L25;
        if (r104 < 0) goto L10;
    L11:
        if (r104 <= 0) goto L25;
        if (readyToCollapse() == false) goto L25;
    L14:
        if (r107 == false) goto L23;
        boolean r108 = r102 instanceof ECWindowOverScrollExpandContainer;
        if (r108 == false) goto L18;
        int r109 = 0;
    L19:
        int r110 = r109 + r104;
        int r111 = applyAdjust(r110);
        if (r108 == false) goto L22;
        r104 = r111;
    L22:
        r105[1] = r104;
        this.dyLast = r110;
        return;
    L18:
        r109 = this.dyLast;
        goto L19
    L23:
        applyAdjust(r104);
        return;
    L10:
        if (readyToExpand() == true) goto L14;
        goto L11
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r106) {
        onNestedPreScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106);
    }
}
