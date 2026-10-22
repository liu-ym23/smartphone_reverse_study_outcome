package com.bytedance.android.gamecp.business.gallery.transfer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u000b\u001d\u001eB\u001b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/gamecp/business/gallery/transfer/BounceBackViewPager;", "Landroidx/viewpager/widget/ViewPager;", "", "mOverscrollTranslation", "", "setOverscrollTranslation", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "listener", "setOnPageChangeListener", "", "<set-?>", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getOverscrollTranslation", "()F", "overscrollTranslation", "d", "I", "getOverscrollAnimationDuration", "()I", "setOverscrollAnimationDuration", "(I)V", "overscrollAnimationDuration", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "OverscrollEffect", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BounceBackViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f53211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Camera f53212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OverscrollEffect f53213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f53214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f53215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f53216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f53217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewPager.OnPageChangeListener f53218h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f53219i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f53220j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f53221k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0083\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tJ\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\tH\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/gamecp/business/gallery/transfer/BounceBackViewPager$OverscrollEffect;", "", "(Lcom/bytedance/android/gamecp/business/gallery/transfer/BounceBackViewPager;)V", "isOverscrolling", "", "()Z", "mAnimator", "Landroid/animation/Animator;", "mOverscroll", "", "getMOverscroll", "()F", "setMOverscroll", "(F)V", "onRelease", "", "setPull", "deltaDistance", "startAnimation", PickerReporterConstants.KEY.TARGET, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class OverscrollEffect {
        private Animator mAnimator;
        private float mOverscroll;
        final /* synthetic */ BounceBackViewPager this$0;

        public static final class a implements Animator.AnimatorListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ OverscrollEffect f53222a;

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            }

            public a(OverscrollEffect r100) {
                this.f53222a = r100;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                OverscrollEffect.access$startAnimation(this.f53222a, 0.0f);
            }
        }

        public final boolean isOverscrolling() {
            BounceBackViewPager r100 = this.this$0;
            if (r100.f53220j == 0) goto L5;
        L7:
            PagerAdapter r101 = r100.getAdapter();
            Intrinsics.checkNotNull(r101);
            if ((r101.getCount() - 1) != this.this$0.f53220j) goto L10;
            boolean r102 = true;
        L11:
            if (r102 == true) goto L13;
            return false;
        L13:
            if (this.mOverscroll <= 0) goto L17;
            return true;
        L17:
            return false;
        L10:
            r102 = false;
            goto L11
        L5:
            if (this.mOverscroll >= 0) goto L7;
            return true;
        }

        public final void onRelease() {
            Animator r100 = this.mAnimator;
            if (r100 == null) goto L7;
            Intrinsics.checkNotNull(r100);
            if (r100.isRunning() == false) goto L7;
            Animator r101 = this.mAnimator;
            Intrinsics.checkNotNull(r101);
            r101.addListener(new a(this));
            Animator r102 = this.mAnimator;
            Intrinsics.checkNotNull(r102);
            r102.cancel();
            return;
        L7:
            startAnimation(0.0f);
        }

        public final float getMOverscroll() {
            return this.mOverscroll;
        }

        public OverscrollEffect(BounceBackViewPager r100) {
            this.this$0 = r100;
        }

        private final void startAnimation(float r100) {
            ObjectAnimator r101 = ObjectAnimator.ofFloat(this, "pull", new float[]{this.mOverscroll, r100});
            this.mAnimator = r101;
            if (r101 == null) goto L5;
            r101.setInterpolator(new DecelerateInterpolator());
        L5:
            float r102 = Math.abs(r100 - this.mOverscroll);
            Animator r103 = this.mAnimator;
            if (r103 == null) goto L8;
            r103.setDuration((long) (this.this$0.getOverscrollAnimationDuration() * r102));
        L8:
            Animator r104 = this.mAnimator;
            if (r104 == null) goto L12;
            r104.start();
            return;
        }

        public final void setMOverscroll(float r100) {
            this.mOverscroll = r100;
        }

        public final void setPull(float r100) {
            this.mOverscroll = r100;
            BounceBackViewPager r101 = this.this$0;
            int r102 = r101.f53221k;
            int r103 = r101.getChildCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L5;
            r101.getChildAt(r104).invalidate();
            r104 = r104 + 1;
            goto L3
        }

        public static final /* synthetic */ void access$startAnimation(OverscrollEffect r100, float r101) {
            r100.startAnimation(r101);
        }
    }

    public static final class a {
    }

    public final class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BounceBackViewPager f53223a;

        public b(BounceBackViewPager r100) {
            this.f53223a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            ViewPager.OnPageChangeListener r101 = this.f53223a.f53218h;
            if (r101 == null) goto L5;
            Intrinsics.checkNotNull(r101);
            r101.onPageScrollStateChanged(r100);
        L5:
            if (r100 != 0) goto L8;
            this.f53223a.f53219i = 0.0f;
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            ViewPager.OnPageChangeListener r101 = this.f53223a.f53218h;
            if (r101 == null) goto L6;
            Intrinsics.checkNotNull(r101);
            r101.onPageSelected(r100);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            ViewPager.OnPageChangeListener r103 = this.f53223a.f53218h;
            if (r103 == null) goto L5;
            Intrinsics.checkNotNull(r103);
            r103.onPageScrolled(r100, r101, r102);
        L5:
            BounceBackViewPager r104 = this.f53223a;
            r104.f53220j = r100;
            r104.f53219i = r101;
            r104.f53221k = r100;
            int r105 = r104.getChildCount();
            int r106 = 0;
        L6:
            if (r106 >= r105) goto L8;
            r104.getChildAt(r106).invalidate();
            r106 = r106 + 1;
            goto L6
        }
    }

    static {
    }

    public final int getOverscrollAnimationDuration() {
        return this.f53214d;
    }

    public final float getOverscrollTranslation() {
        return this.f53211a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return super.dispatchTouchEvent(r100);
    L8:
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction() & 255;     // Catch: Throwable -> L12
        if (r101 != 0) goto L6;
        this.f53215e = r100.getX();     // Catch: Throwable -> L12
        this.f53217g = MotionEventCompat.getPointerId(r100, 0);     // Catch: Throwable -> L12
    L10:
        return super.onInterceptTouchEvent(r100);
    L6:
        if (r101 != 5) goto L10;
        int r102 = MotionEventCompat.getActionIndex(r100);     // Catch: Throwable -> L12
        this.f53215e = MotionEventCompat.getX(r100, r102);     // Catch: Throwable -> L12
        this.f53217g = MotionEventCompat.getPointerId(r100, r102);     // Catch: Throwable -> L12
    L15:
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        int r100 = r110.getAction();
        int r101 = 0;
        if (r100 != 0) goto L5;
        this.f53215e = r110.getX();
        this.f53217g = MotionEventCompat.getPointerId(r110, 0);
    L37:
        r101 = 1;
    L39:
        if (this.f53213c.isOverscrolling() == false) goto L43;
        if (r101 != 0) goto L43;
        return true;
    L43:
        return super.onTouchEvent(r110);
    L5:
        if (r100 != 1) goto L7;
    L35:
        this.f53217g = -1;
        this.f53213c.onRelease();
        goto L37
    L7:
        if (r100 != 2) goto L9;
        int r102 = this.f53217g;
        if (r102 == (-1)) goto L34;
        float r103 = MotionEventCompat.getX(r110, MotionEventCompat.findPointerIndex(r110, r102));
        float r104 = this.f53215e - r103;
        getScrollX();
        int r105 = getWidth();
        int r106 = getPageMargin() + r105;
        PagerAdapter r107 = getAdapter();
        Intrinsics.checkNotNull(r107);
        int r108 = r107.getCount() - 1;
        int r109 = getCurrentItem();
        float r111 = Math.max(0, (r109 - 1) * r106);
        float r112 = Math.min(r109 + 1, r108) * r106;
        if (this.f53219i != 0.0f) goto L33;
        if (r109 == 0) goto L27;
        if (r108 != r109) goto L39;
        if (r112 != (r108 * r106)) goto L39;
        this.f53213c.setPull((r104 - this.f53216f) / r105);
        goto L39
    L27:
        if (r111 != 0.0f) goto L39;
        this.f53213c.setPull((r104 + this.f53216f) / r105);
        goto L39
    L33:
        this.f53215e = r103;
        goto L39
    L34:
        this.f53213c.onRelease();
        goto L39
    L9:
        if (r100 == 3) goto L35;
        if (r100 != 5) goto L13;
        int r113 = MotionEventCompat.getActionIndex(r110);
        this.f53215e = MotionEventCompat.getX(r110, r113);
        this.f53217g = MotionEventCompat.getPointerId(r110, r113);
        goto L37
    L13:
        if (r100 != 6) goto L39;
        int r114 = (r110.getAction() & 65280) >> 8;
        if (MotionEventCompat.getPointerId(r110, r114) != this.f53217g) goto L39;
        if (r114 != 0) goto L19;
        r101 = 1;
    L19:
        this.f53215e = r110.getX(r101);
        this.f53217g = MotionEventCompat.getPointerId(r110, r101);
        goto L37
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f53218h = r100;
    }

    public final void setOverscrollAnimationDuration(int r100) {
        this.f53214d = r100;
    }

    public final void setOverscrollTranslation(int r100) {
        this.f53211a = r100;
    }

    public BounceBackViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNull(r100);
        super(r100, r101);
        this.f53212b = new Camera();
        this.f53213c = new OverscrollEffect(this);
        setStaticTransformationsEnabled(true);
        this.f53216f = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(r100));
        super.setOnPageChangeListener(new b(this));
        this.f53211a = 400.0f;
        this.f53214d = 400;
    }

    @Override // android.view.ViewGroup
    public final boolean getChildStaticTransformation(View r100, Transformation r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, "t");
        if (r100.getWidth() != 0) goto L5;
        return false;
    L5:
        int r102 = this.f53220j;
        if (r102 == 0) goto L11;
        PagerAdapter r103 = getAdapter();
        Intrinsics.checkNotNull(r103);
        if (r102 == (r103.getCount() - 1)) goto L11;
        boolean r104 = false;
    L13:
        if (this.f53213c.isOverscrolling() == false) goto L24;
        if (r104 == false) goto L24;
        float r105 = getWidth() / 2;
        int r106 = getHeight() / 2;
        r101.getMatrix().reset();
        float r107 = this.f53211a;
        if (this.f53213c.getMOverscroll() <= 0) goto L18;
        float r108 = Math.min(this.f53213c.getMOverscroll(), 1.0f);
    L19:
        this.f53212b.save();
        this.f53212b.translate(-(r107 * r108), 0.0f, 0.0f);
        this.f53212b.getMatrix(r101.getMatrix());
        this.f53212b.restore();
        float r109 = r106;
        r101.getMatrix().preTranslate(-r105, -r109);
        r101.getMatrix().postTranslate(r105, r109);
        if (getChildCount() != 1) goto L22;
        invalidate();
    L23:
        return true;
    L22:
        r100.invalidate();
        goto L23
    L18:
        r108 = Math.max(this.f53213c.getMOverscroll(), -1.0f);
    L24:
        return false;
    L11:
        r104 = true;
        goto L13
    }
}
