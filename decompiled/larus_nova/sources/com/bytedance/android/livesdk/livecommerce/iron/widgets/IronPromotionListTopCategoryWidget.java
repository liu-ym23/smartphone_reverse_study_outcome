package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.flow.CategoryTagFlowLayout;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.j;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u001c\u0010\r\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/IronPromotionListTopCategoryWidget;", "Landroid/widget/FrameLayout;", "", ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, "", "setExpandViewStatus", "enable", "setExpandViewEnable", "isAnchor", "setIsAnchor", "Lkotlin/Function1;", "Landroid/view/View;", "clickListener", "setDisableClickListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IronPromotionListTopCategoryWidget extends FrameLayout {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f149134o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<TopCategoryView> f149135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f149136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TopCategoryView f149137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ei2.a f149138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f149139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f149140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f149141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnimatorSet f149142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f149143i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f149144j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f149145k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f149146l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f149147m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function1<? super View, Unit> f149148n;

    public static final class a extends CategoryTagFlowLayout {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ IronPromotionListTopCategoryWidget f149149k;

        @Override // com.bytedance.android.livesdk.livecommerce.iron.widgets.flow.CategoryTagFlowLayout
        public ei2.a getExpandView() {
            IronPromotionListTopCategoryWidget r100 = this.f149149k;
            if (r100.f149138d != null) goto L5;
            IronPromotionListTopCategoryWidget$createExpandView$view$1 r101 = new IronPromotionListTopCategoryWidget$createExpandView$view$1(r100, r100.getContext());
            int r102 = r100.f149139e;
            ViewGroup.MarginLayoutParams r103 = new ViewGroup.MarginLayoutParams(r102, r102);
            r103.leftMargin = UtilityKotlinExtentionsKt.d(8);
            Unit r104 = Unit.INSTANCE;
            r101.setLayoutParams(r103);
            r101.setBackgroundResource(R.drawable.shopping_bg_top_category_unselected_view);
            r101.setContentDescription("更多分类按钮");
            View r105 = new View(r100.getContext());
            FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.d(6), UtilityKotlinExtentionsKt.d(3));
            r106.gravity = 17;
            r105.setLayoutParams(r106);
            r105.setBackgroundResource(R.drawable.ec_promotion_list_category_expand_down);
            r101.addView(r105);
            r101.setType(1);
            int r107 = -UtilityKotlinExtentionsKt.d(6);
            int r108 = UtilityKotlinExtentionsKt.d(8);
            Handler r109 = k.f153092a;
            r101.post(new j(r101, r107, r108));
            r101.setOnClickListener(new com.bytedance.android.livesdk.livecommerce.iron.widgets.g(r100, r101));
            r100.f149138d = r101;
        L5:
            ei2.a r110 = this.f149149k.f149138d;
            Intrinsics.checkNotNull(r110);
            return r110;
        }

        public a(IronPromotionListTopCategoryWidget r100, Context r101) {
            this.f149149k = r100;
            super(r101);
        }
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f149150a = null;

        static {
            f149150a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return true;
        }
    }

    public static final class c {
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IronPromotionListTopCategoryWidget f149154a;

        public d(IronPromotionListTopCategoryWidget r100) {
            this.f149154a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            this.f149154a.invalidate();
        }
    }

    public static final class e implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IronPromotionListTopCategoryWidget f149155a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public e(IronPromotionListTopCategoryWidget r100) {
            this.f149155a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f149155a.f149144j = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f149155a.f149144j = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            IronPromotionListTopCategoryWidget r101 = this.f149155a;
            r101.f149144j = true;
            r101.getClass();
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IronPromotionListTopCategoryWidget f149156a;

        public f(IronPromotionListTopCategoryWidget r100) {
            this.f149156a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            this.f149156a.invalidate();
        }
    }

    public static final class g implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IronPromotionListTopCategoryWidget f149157a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public g(IronPromotionListTopCategoryWidget r100) {
            this.f149157a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f149157a.f149144j = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            IronPromotionListTopCategoryWidget r101 = this.f149157a;
            r101.f149146l = false;
            r101.f149144j = false;
            r101.getClass();
            this.f149157a.requestLayout();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f149157a.f149144j = true;
        }
    }

    static {
    }

    public IronPromotionListTopCategoryWidget(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IronPromotionListTopCategoryWidget(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (this.f149144j == false) goto L5;
        return;
    L5:
        if (this.f149146l == false) goto L7;
        return;
    L7:
        if (getVisibility() != 0) goto L9;
        boolean r100 = true;
    L10:
        if (r100 == false) goto L63;
        AnimatorSet r101 = this.f149142h;
        if (r101 == null) goto L15;
        r101.cancel();
    L15:
        AnimatorSet r102 = new AnimatorSet();
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r103.setDuration(200);
        r103.addUpdateListener(new d(this));
        Unit r104 = Unit.INSTANCE;
        this.f149143i = r103;
        AnimatorSet.Builder r105 = r102.play(r103);
        List<View> r106 = com.bytedance.commerce.base.view.b.a(this.f149136b);
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L17:
        if (r108.hasNext() == false) goto L21;
        Object r109 = r108.next();
        if ((r109 instanceof ei2.a) == false) goto L17;
        r107.add(r109);
        goto L17
    L21:
        ArrayList r110 = new ArrayList();
        Iterator r111 = r107.iterator();
    L22:
        View r112 = null;
        if (r111.hasNext() == false) goto L40;
        Object r113 = r111.next();
        View r114 = ((ei2.a) r113).getTagView();
        if ((r114 instanceof TopCategoryView) == false) goto L28;
        r112 = r114;
    L28:
        TopCategoryView r115 = (TopCategoryView) r112;
        if (r115 == null) goto L33;
        PromotionCategory r116 = r115.getCurrentCategory();
        if (r116 == null) goto L33;
        int r117 = r116.getTabRow();
    L34:
        if (r117 == 1) goto L36;
        boolean r118 = true;
    L37:
        if (r118 == false) goto L22;
        r110.add(r113);
        goto L22
    L36:
        r118 = false;
    L33:
        r117 = 1;
        goto L34
    L40:
        if ((!r110.isEmpty()) == true) goto L43;
        r110 = null;
    L43:
        if (r110 == null) goto L48;
        Iterator r119 = r110.iterator();
    L46:
        if (r119.hasNext() == false) goto L48;
        r105.after(ObjectAnimator.ofFloat((ei2.a) r119.next(), "alpha", new float[]{0.0f, 1.0f}).setDuration(160));
    L48:
        r102.addListener(new e(this));
        this.f149146l = true;
        this.f149145k = true;
        requestLayout();
        r102.setInterpolator(new DecelerateInterpolator());
        setExpandViewStatus(false);
        r102.start();
        Unit r120 = Unit.INSTANCE;
        this.f149142h = r102;
        return;
    L63:
        return;
    L9:
        r100 = false;
        goto L10
    }

    public final void b() {
        if (this.f149144j == false) goto L5;
        return;
    L5:
        if (this.f149146l == true) goto L7;
        return;
    L7:
        if (getVisibility() != 0) goto L9;
        boolean r100 = true;
    L10:
        if (r100 == false) goto L63;
        AnimatorSet r101 = this.f149142h;
        if (r101 == null) goto L15;
        r101.cancel();
    L15:
        AnimatorSet r102 = new AnimatorSet();
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r103.setDuration(200);
        r103.addUpdateListener(new f(this));
        Unit r104 = Unit.INSTANCE;
        this.f149143i = r103;
        AnimatorSet.Builder r105 = r102.play(r103);
        List<View> r106 = com.bytedance.commerce.base.view.b.a(this.f149136b);
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L17:
        if (r108.hasNext() == false) goto L21;
        Object r109 = r108.next();
        if ((r109 instanceof ei2.a) == false) goto L17;
        r107.add(r109);
        goto L17
    L21:
        ArrayList r110 = new ArrayList();
        Iterator r111 = r107.iterator();
    L22:
        View r112 = null;
        if (r111.hasNext() == false) goto L40;
        Object r113 = r111.next();
        View r114 = ((ei2.a) r113).getTagView();
        if ((r114 instanceof TopCategoryView) == false) goto L28;
        r112 = r114;
    L28:
        TopCategoryView r115 = (TopCategoryView) r112;
        if (r115 == null) goto L33;
        PromotionCategory r116 = r115.getCurrentCategory();
        if (r116 == null) goto L33;
        int r117 = r116.getTabRow();
    L34:
        if (r117 == 1) goto L36;
        boolean r118 = true;
    L37:
        if (r118 == false) goto L22;
        r110.add(r113);
        goto L22
    L36:
        r118 = false;
    L33:
        r117 = 1;
        goto L34
    L40:
        if ((!r110.isEmpty()) == true) goto L43;
        r110 = null;
    L43:
        if (r110 == null) goto L48;
        Iterator r119 = r110.iterator();
    L46:
        if (r119.hasNext() == false) goto L48;
        r105.with(ObjectAnimator.ofFloat((ei2.a) r119.next(), "alpha", new float[]{1.0f, 0.0f}).setDuration(160));
    L48:
        r102.addListener(new g(this));
        this.f149146l = true;
        this.f149145k = false;
        r102.setInterpolator(new DecelerateInterpolator());
        setExpandViewStatus(true);
        r102.start();
        Unit r120 = Unit.INSTANCE;
        this.f149142h = r102;
        return;
    L63:
        return;
    L9:
        r100 = false;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((ArrayList) this.f149135a).clear();
    }

    private final void setExpandViewEnable(boolean r100) {
        ei2.a r101 = this.f149138d;
        if (r101 != null) goto L5;
    L15:
        if (r100 == false) goto L17;
        int r102 = R.drawable.shopping_bg_top_category_unselected_view;
    L18:
        ei2.a r103 = this.f149138d;
        if (r103 == null) goto L22;
        r103.setBackgroundResource(r102);
        return;
    L22:
        return;
    L17:
        r102 = R.drawable.shopping_bg_top_category_disabled_view;
        goto L18
    L5:
        if (getChildCount() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L15;
        View r105 = r101.getChildAt(0);
        if (r105 == null) goto L15;
        r105.setEnabled(r100);
        goto L15
    L7:
        r104 = false;
        goto L8
    }

    private final void setExpandViewStatus(boolean r100) {
        ei2.a r101 = this.f149138d;
        if (r101 != null) goto L5;
        return;
    L5:
        if (getChildCount() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L20;
        View r103 = r101.getChildAt(0);
        if (r103 == null) goto L21;
        if (r100 == false) goto L16;
        int r104 = R.drawable.ec_promotion_list_category_expand_down;
    L17:
        r103.setBackgroundResource(r104);
        return;
    L16:
        r104 = R.drawable.ec_promotion_list_category_expand_up;
        goto L17
    L21:
        return;
    L20:
        return;
    L7:
        r102 = false;
        goto L8
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.save();
        if (this.f149144j == false) goto L13;
        ValueAnimator r101 = this.f149143i;
        if (r101 == null) goto L7;
        float r102 = r101.getAnimatedFraction();
    L9:
        if (this.f149145k == false) goto L11;
        r100.clipRect(0.0f, 0.0f, getWidth(), this.f149141g + (r102 * (getHeight() - this.f149141g)));
    L17:
        super.draw(r100);
        r100.restore();
        return;
    L11:
        r100.clipRect(0.0f, 0.0f, getWidth(), getHeight() - (r102 * (getHeight() - this.f149141g)));
        goto L17
    L7:
        r102 = 0.0f;
        goto L9
    L13:
        if (this.f149146l == false) goto L15;
        float r103 = getHeight();
    L16:
        r100.clipRect(0.0f, 0.0f, getWidth(), r103);
        goto L17
    L15:
        r103 = this.f149141g;
        goto L16
    }

    public final void setDisableClickListener(Function1<? super View, Unit> r100) {
        this.f149148n = r100;
    }

    public final void setIsAnchor(boolean r100) {
        this.f149147m = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f149146l == true) goto L5;
        int r102 = (this.f149139e + getPaddingTop()) + getPaddingBottom();
        this.f149140f = r102;
        this.f149141g = r102 - (getPaddingBottom() / 2);
        setMeasuredDimension(getMeasuredWidth(), this.f149140f);
        return;
    L5:
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + UtilityKotlinExtentionsKt.d(8));
    }

    public IronPromotionListTopCategoryWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f149135a = new ArrayList();
        this.f149139e = UtilityKotlinExtentionsKt.d(26) + 2;
        a r103 = new a(this, r100);
        this.f149136b = r103;
        addView(r103);
        setOnTouchListener(b.f149150a);
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r105 >= 15) goto L6;
        List<TopCategoryView> r106 = this.f149135a;
        ArrayList r107 = (ArrayList) r106;
        r107.add(new TopCategoryView(r100, null, 6, r104));
        r105 = r105 + 1;
        goto L4
    }

    public /* synthetic */ IronPromotionListTopCategoryWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
