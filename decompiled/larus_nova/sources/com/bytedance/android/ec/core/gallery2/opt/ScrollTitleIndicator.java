package com.bytedance.android.ec.core.gallery2.opt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0004\u001a\u00020\u0003R:\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/opt/ScrollTitleIndicator;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/IIndicatorView;", "", "update", "", "", "value", ce.f26396k, "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "data", "", "l", "I", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "currentPos", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScrollTitleIndicator extends RelativeLayout implements IIndicatorView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f44074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HorizontalScrollView f44075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f44076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f44077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<GalleryTitleItemView> f44078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f44079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f44080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f44081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f44082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f44083j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<String> f44084k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f44085l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f44086m;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f44087a = null;

        static {
            f44087a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return true;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryTitleItemView f44088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ScrollTitleIndicator f44089b;

        public b(GalleryTitleItemView r100, ScrollTitleIndicator r101) {
            this.f44088a = r100;
            this.f44089b = r101;
        }

        public final void a() {
            ScrollTitleIndicator r100 = this.f44089b;
            r100.b(r100.getCurrentPos(), 0.0f, 0);
            if (this.f44089b.getCurrentPos() <= 0) goto L6;
            ViewGroup.LayoutParams r101 = this.f44089b.f44076c.getLayoutParams();
            r101.width = this.f44089b.a(this.f44088a.getWidth(), this.f44089b.getCurrentPos());
            ScrollTitleIndicator r102 = this.f44089b;
            r101.height = this.f44088a.getHeight() + (r102.f44082i * 2);
            this.f44089b.f44076c.setLayoutParams(r101);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ScrollTitleIndicator(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ScrollTitleIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onDataChanged(TransitionPagerAdapter<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionChanged(int r100, float r101) {
    }

    public final void update() {
        if (this.f44086m == false) goto L8;
        GalleryTitleItemView r100 = (GalleryTitleItemView) CollectionsKt.getOrNull(this.f44078e, this.f44085l);
        if (r100 == null) goto L7;
        post(new b(r100, this));
    L7:
        this.f44086m = false;
    L8:
        this.f44076c.setVisibility(0);
        if (this.f44085l != 0) goto L11;
        this.f44076c.setBackgroundResource(R.drawable.ec_sku_default_check_title_bg);
        this.f44077d.setVisibility(8);
    L12:
        Iterator<T> r101 = this.f44078e.iterator();
    L14:
        if (r101.hasNext() == false) goto L16;
        ((GalleryTitleItemView) r101.next()).setCheckPos(this.f44085l);
        goto L14
    L16:
        return;
    L11:
        this.f44076c.setBackgroundResource(R.drawable.ec_sku_check_title_bg);
        this.f44077d.setVisibility(0);
        goto L12
    }

    public final int getCurrentPos() {
        return this.f44085l;
    }

    public final List<String> getData() {
        return this.f44084k;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onPageSelected(int r100) {
        setCurrentPos(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionBegin(int r100) {
        if (r100 != 0) goto L4;
    L7:
        setVisibility(8);
        return;
    L4:
        if (r100 == 3) goto L7;
        if (r100 == 2) goto L7;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionEnd(int r100) {
        boolean r101 = true;
        if (r100 == 0) goto L5;
        if (r100 == 1) goto L5;
        return;
    L5:
        List<String> r102 = this.f44084k;
        if (r102 != null) goto L8;
    L11:
        if (r101 == true) goto L15;
        setVisibility(0);
        return;
    L15:
        return;
    L8:
        if (r102.isEmpty() == true) goto L11;
        r101 = false;
        goto L11
    }

    public final void setCurrentPos(int r100) {
        this.f44085l = r100;
        update();
    }

    public final void setData(List<String> r100) {
        this.f44084k = r100;
        this.f44083j = UIUtils.getScreenWidth(getContext());
        List<String> r101 = this.f44084k;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        setVisibility(8);
        return;
    L11:
        setVisibility(0);
        this.f44074a.removeAllViews();
        LinearLayout r103 = this.f44074a;
        FrameLayout r104 = new FrameLayout(getContext());
        r104.setLayoutParams(new RelativeLayout.LayoutParams(this.f44083j / 2, 0));
        Unit r105 = Unit.INSTANCE;
        r103.addView(r104);
        List<String> r106 = this.f44084k;
        if (r106 == null) goto L27;
        Iterator<T> r107 = r106.iterator();
        int r108 = 0;
    L15:
        if (r107.hasNext() == false) goto L27;
        Object r109 = r107.next();
        int r110 = r108 + 1;
        if (r108 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        String r111 = (String) r109;
        ViewGroup.LayoutParams r112 = null;
        GalleryTitleItemView r113 = new GalleryTitleItemView(getContext(), null, 6, 0);
        Intrinsics.checkNotNullParameter(r111, "title");
        r113.f44065a = r108;
        r113.setText(r111);
        r113.getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.android.ec.core.gallery2.opt.a(r113));
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if ((r114 instanceof ViewGroup.MarginLayoutParams) == false) goto L23;
        r112 = r114;
    L23:
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r112;
        if (r115 == null) goto L26;
        r115.leftMargin = vf4.a.b(Integer.valueOf(this.f44079f));
        r113.setLayoutParams(r115);
    L26:
        this.f44074a.addView(r113);
        ((ArrayList) this.f44078e).add(r113);
        r108 = r110;
    L27:
        LinearLayout r116 = this.f44074a;
        FrameLayout r117 = new FrameLayout(getContext());
        r117.setLayoutParams(new RelativeLayout.LayoutParams(this.f44083j / 2, 0));
        Unit r118 = Unit.INSTANCE;
        r116.addView(r117);
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final int a(int r100, int r101) {
        if (r101 != 0) goto L4;
        int r102 = this.f44081h * 2;
    L6:
        return r100 + r102;
    L4:
        r100 = r100 + this.f44080g;
        r102 = this.f44081h;
        goto L6
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onAttach(int r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
        IIndicatorView.DefaultImpls.onAttach(this, r100, r101);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public final void onDetach(int r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
        IIndicatorView.DefaultImpls.onDetach(this, r100, r101);
    }

    public ScrollTitleIndicator(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        this.f44078e = new ArrayList();
        this.f44079f = vf4.a.b(40);
        this.f44080g = vf4.a.b(40);
        int r111 = vf4.a.b(16);
        this.f44081h = r111;
        this.f44082i = vf4.a.b(10);
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-1, -2);
        r102.bottomMargin = vf4.a.b(34);
        r102.gravity = 80;
        Unit r103 = Unit.INSTANCE;
        setLayoutParams(r102);
        setMinimumHeight(vf4.a.b(120));
        LinearLayout r104 = new LinearLayout(r100);
        RelativeLayout.LayoutParams r105 = new RelativeLayout.LayoutParams(-2, -2);
        r105.addRule(13);
        r104.setLayoutParams(r105);
        r104.setPadding(r111, 0, r111, 0);
        r104.setBackgroundResource(R.drawable.ec_sku_check_title_bg);
        r104.setOrientation(0);
        ImageView r112 = new ImageView(r100);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(vf4.a.b(16), vf4.a.b(16));
        r106.gravity = 8388627;
        r112.setLayoutParams(r106);
        r112.setBackgroundResource(R.drawable.ec_sku_gallery_check_ic);
        this.f44077d = r112;
        r104.addView(r112);
        r104.setVisibility(8);
        this.f44076c = r104;
        addView(r104);
        HorizontalScrollView r107 = new HorizontalScrollView(r100);
        RelativeLayout.LayoutParams r108 = new RelativeLayout.LayoutParams(-1, -2);
        r108.addRule(13);
        r107.setLayoutParams(r108);
        r107.setHorizontalScrollBarEnabled(false);
        r107.setPadding(0, vf4.a.b(8), 0, vf4.a.b(8));
        this.f44075b = r107;
        LinearLayout r113 = new LinearLayout(r100);
        ViewGroup.MarginLayoutParams r109 = new ViewGroup.MarginLayoutParams(-1, -2);
        r113.setGravity(17);
        r113.setLayoutParams(r109);
        this.f44074a = r113;
        r113.setOrientation(0);
        r107.addView(r113);
        r107.setOnTouchListener(a.f44087a);
        addView(r107);
        this.f44086m = true;
    }

    public final void b(int r110, float r111, int r112) {
        int r100 = this.f44083j;
        if (r100 <= 0) goto L5;
        float r101 = r111 / r100;
    L6:
        int r102 = this.f44079f;
        int r103 = this.f44081h;
        float r104 = r103;
        float r105 = (r102 + r103) - (r104 * r101);
        int r106 = this.f44080g;
        float r107 = (r102 + r106) - ((r106 - r103) * r101);
        float r108 = r102;
        if (r110 == 1) goto L10;
        r104 = r106;
    L10:
        float r109 = r108 + (r104 * r101);
        int r113 = this.f44074a.getPaddingLeft();
        int r114 = this.f44074a.getPaddingLeft();
        int r115 = Math.min(((ArrayList) this.f44078e).size(), r110 + 2);
        int r116 = 0;
    L11:
        GalleryTitleItemView r117 = null;
        ViewGroup.LayoutParams r118 = null;
        if (r116 >= r115) goto L41;
        GalleryTitleItemView r119 = (GalleryTitleItemView) CollectionsKt.getOrNull(this.f44078e, r116);
        if (r119 == null) goto L40;
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
        if ((r120 instanceof ViewGroup.MarginLayoutParams) == true) goto L18;
        r120 = null;
    L18:
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
        if (r121 == null) goto L39;
        int r122 = r110 - 1;
        if (r116 != r122) goto L24;
        if (r116 == 0) goto L30;
        r121.leftMargin = (int) r109;
    L30:
        if (r116 >= r110) goto L36;
        int r123 = r119.getWidth();
        int r124 = r121.leftMargin;
        r113 = r113 + (r123 + r124);
        if (r116 == r122) goto L35;
        r124 = r119.getWidth() + r121.leftMargin;
    L35:
        r114 = r114 + r124;
    L38:
        Unit r125 = Unit.INSTANCE;
        r118 = r121;
        goto L39
    L36:
        if (r116 != r110) goto L38;
        r113 = r113 + r121.leftMargin;
        goto L38
    L24:
        if (r116 != r110) goto L27;
        r121.leftMargin = (int) r107;
        goto L30
    L27:
        if (r116 != (r110 + 1)) goto L29;
        r121.leftMargin = (int) r105;
        goto L30
    L29:
        r121.leftMargin = this.f44079f;
    L39:
        r119.setLayoutParams(r118);
    L40:
        r116 = r116 + 1;
        goto L11
    L41:
        GalleryTitleItemView r126 = (GalleryTitleItemView) CollectionsKt.getOrNull(this.f44078e, r110);
        if (r110 <= 0) goto L44;
        r117 = (GalleryTitleItemView) CollectionsKt.getOrNull(this.f44078e, r110 - 1);
    L44:
        if (r126 != null) goto L47;
        return;
    L47:
        if (r110 <= 0) goto L49;
        int r127 = ((this.f44075b.getWidth() / 2) + vf4.a.b(12)) + (-(r113 + (r126.getWidth() / 2)));
    L50:
        if (r110 <= 1) goto L53;
        if (r117 == null) goto L56;
        int r128 = (this.f44075b.getWidth() / 2) + vf4.a.b(12);
        int r129 = r117.getWidth() / 2;
    L55:
        int r130 = r128 - (r114 + r129);
    L57:
        this.f44075b.smoothScrollTo((int) ((this.f44083j / 2) - (r127 + ((r130 - r127) * r101))), 0);
        int r131 = r110 - 1;
        GalleryTitleItemView r132 = (GalleryTitleItemView) CollectionsKt.getOrNull(this.f44078e, r131);
        GalleryTitleItemView r133 = (GalleryTitleItemView) CollectionsKt.getOrNull(this.f44078e, r110);
        if (r133 == null) goto L75;
        float r134 = 0.0f;
        if (r101 != 0.0f) goto L63;
        r134 = a(r133.getWidth(), r110);
        float r135 = r133.getHeight() + (this.f44082i * 2);
    L70:
        ViewGroup.LayoutParams r136 = this.f44076c.getLayoutParams();
        r136.width = (int) r134;
        r136.height = (int) r135;
        this.f44076c.setLayoutParams(r136);
        return;
    L63:
        if (r112 <= 0) goto L66;
        if (r132 == null) goto L66;
        float r137 = 1 - r101;
        r134 = a(r132.getWidth(), r131) + ((a(r133.getWidth(), r110) - a(r132.getWidth(), r131)) * r137);
        r135 = (r132.getHeight() + (this.f44082i * 2)) + (((r133.getHeight() + (this.f44082i * 2)) - (r132.getHeight() + (this.f44082i * 2))) * r137);
    L66:
        if (r112 >= 0) goto L69;
        if (r132 == null) goto L69;
        r134 = a(r133.getWidth(), r110) + ((a(r132.getWidth(), r131) - a(r133.getWidth(), r110)) * r101);
        r135 = (r133.getHeight() + (this.f44082i * 2)) + (((r132.getHeight() + (this.f44082i * 2)) - (r133.getHeight() + (this.f44082i * 2))) * r101);
    L69:
        r135 = 0.0f;
        goto L70
    L75:
        return;
    L56:
        r130 = r127;
        goto L57
    L53:
        if (r117 == null) goto L56;
        r128 = this.f44075b.getWidth() / 2;
        r129 = r117.getWidth() / 2;
        goto L55
    L49:
        r127 = (this.f44075b.getWidth() / 2) - (r113 + (r126.getWidth() / 2));
        goto L50
    L5:
        r101 = 1.0f;
        goto L6
    }

    public /* synthetic */ ScrollTitleIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
