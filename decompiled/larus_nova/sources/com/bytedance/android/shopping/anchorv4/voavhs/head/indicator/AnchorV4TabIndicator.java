package com.bytedance.android.shopping.anchorv4.voavhs.head.indicator;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.anchorv4.experiment.d;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import f83.m;
import f83.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/indicator/AnchorV4TabIndicator;", "Landroid/widget/FrameLayout;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4TabIndicator extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n> f168768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f168769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f168770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f168771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f168772e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4TabIndicator f168773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f168774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f168775c;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4TabIndicator$a$a, reason: collision with other inner class name */
        public static final class RunnableC2548a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f168776a;

            public RunnableC2548a(a r100) {
                this.f168776a = r100;
            }

            public final void a() {
                View r100 = this.f168776a.f168773a.f168770c;
                ViewGroup.LayoutParams r101 = r100.getLayoutParams();
                r101.width = this.f168776a.f168774b.getWidth();
                r101.height = this.f168776a.f168774b.getHeight();
                Unit r102 = Unit.INSTANCE;
                r100.setLayoutParams(r101);
                a r103 = this.f168776a;
                if (r103.f168775c <= 0) goto L11;
                int r104 = r103.f168774b.getLeft();
                View r105 = this.f168776a.f168773a.f168770c;
                ViewGroup.LayoutParams r106 = r105.getLayoutParams();
                if ((r106 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
                r106 = null;
            L7:
                ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
                if (r107 == null) goto L12;
                r107.leftMargin = r104;
                r105.setLayoutParams(r107);
                return;
            L12:
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

        public a(AnchorV4TabIndicator r100, View r101, int r102) {
            this.f168773a = r100;
            this.f168774b = r101;
            this.f168775c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f168773a.f168770c.post(new RunnableC2548a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4TabIndicator f168777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f168778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f168779c;

        public b(AnchorV4TabIndicator r100, View r101, View r102) {
            this.f168777a = r100;
            this.f168778b = r101;
            this.f168779c = r102;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L13;
            float r102 = ((Float) r101).floatValue();
            View r103 = this.f168777a.f168770c;
            ViewGroup.LayoutParams r104 = r103.getLayoutParams();
            if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
            r104 = null;
        L7:
            ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
            if (r105 == null) goto L10;
            r105.leftMargin = (int) (this.f168778b.getLeft() + ((this.f168779c.getLeft() - this.f168778b.getLeft()) * r102));
            r103.setLayoutParams(r105);
        L10:
            View r106 = this.f168777a.f168770c;
            ViewGroup.LayoutParams r107 = r106.getLayoutParams();
            r107.width = (int) (this.f168778b.getWidth() + ((this.f168779c.getWidth() - this.f168778b.getWidth()) * r102));
            r107.height = com.bytedance.android.shopping.extensions.b.b(24);
            Unit r108 = Unit.INSTANCE;
            r106.setLayoutParams(r107);
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f168780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f168781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AnchorV4TabIndicator f168782c;

        public c(n r100, int r101, AnchorV4TabIndicator r102) {
            this.f168780a = r100;
            this.f168781b = r101;
            this.f168782c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f168780a.f475857a = true;
            m r101 = this.f168782c.f168772e;
            if (r101 == null) goto L6;
            r101.a(this.f168781b);
            return;
        }
    }

    public AnchorV4TabIndicator(Context r100) {
        this(r100, null, 0, null, 30);
    }

    public AnchorV4TabIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 0, null, 28);
    }

    public AnchorV4TabIndicator(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, null, 24);
    }

    public final void b(List<String> r110, List<String> r111) {
        Intrinsics.checkNotNullParameter(r110, "indicatorTags");
        Intrinsics.checkNotNullParameter(r111, "tabTypes");
        this.f168769b.removeAllViews();
        ((ArrayList) this.f168768a).clear();
        Iterator<T> r112 = r110.iterator();
        int r100 = 0;
    L4:
        if (r112.hasNext() == false) goto L13;
        Object r101 = r112.next();
        int r102 = r100 + 1;
        if (r100 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r103 = (String) r101;
        TextView r104 = new TextView(getContext());
        ColorStateList r105 = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{-16777216, -1});
        float r106 = 10.0f;
        int r107 = (int) UIUtils.dip2Px(r104.getContext(), 10.0f);
        int r108 = (int) UIUtils.dip2Px(r104.getContext(), 2.5f);
        if (d.a() == true) goto L12;
        r106 = 12.0f;
    L12:
        r104.setTextSize(r106);
        r104.setTypeface(Typeface.DEFAULT_BOLD);
        r104.setTextColor(r105);
        r104.setPadding(r107, r108, r107, r108);
        r104.setText(r103);
        r104.setGravity(17);
        n r109 = new n(r104, r103, null);
        r104.setOnClickListener(new c(r109, r100, this));
        this.f168769b.addView(r104, new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(24)));
        ((ArrayList) this.f168768a).add(r109);
        r100 = r102;
        goto L4
    L13:
        a(0, (String) CollectionsKt.getOrNull(r111, 0), true);
    }

    public final void a(int r110, String r111, boolean r112) {
        n r100 = (n) CollectionsKt.getOrNull(this.f168768a, r110);
        View r101 = null;
        if (r100 == null) goto L8;
        boolean r102 = r100.f475857a;
        boolean r103 = r100.f475858b;
        m r104 = this.f168772e;
        if (r104 == null) goto L7;
        r104.b(r110, r102, r103, r111, r112, null);
    L7:
        r100.f475857a = false;
    L9:
        Iterator<T> r113 = this.f168768a.iterator();
    L11:
        if (r113.hasNext() == false) goto L15;
        Object r105 = r113.next();
        if (((n) r105).f475859c.isSelected() == false) goto L11;
    L16:
        n r106 = (n) r105;
        if (r106 == null) goto L19;
        r101 = r106.f475859c;
    L19:
        n r114 = (n) CollectionsKt.getOrNull(this.f168768a, r110);
        if (r114 == null) goto L35;
        View r115 = r114.f475859c;
        if (r115 != null) goto L25;
        return;
    L25:
        if (Intrinsics.areEqual(r101, r115) == false) goto L27;
        return;
    L27:
        if (r112 == false) goto L29;
        r115.post(new a(this, r115, r110));
    L31:
        Iterator<T> r116 = this.f168768a.iterator();
    L33:
        if (r116.hasNext() == false) goto L41;
        n r117 = (n) r116.next();
        r117.f475859c.setSelected(Intrinsics.areEqual(r100, r117));
        goto L33
    L41:
        return;
    L29:
        if (r101 == null) goto L31;
        ValueAnimator r118 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(250);
        r118.addUpdateListener(new b(this, r101, r115));
        r118.start();
        goto L31
    L35:
        return;
    L15:
        r105 = null;
        goto L16
    L8:
        r100 = null;
        goto L9
    }

    public AnchorV4TabIndicator(Context r100, AttributeSet r101, int r102, m r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f168772e = r103;
        this.f168768a = new ArrayList();
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(com.larus.nova.R.layout.shopping_anchor_v4_indicator_layout, this, true);
        View r105 = findViewById(com.larus.nova.R.id.head_tab_root_view);
        this.f168771d = r105;
        LinearLayout r106 = (LinearLayout) findViewById(com.larus.nova.R.id.head_indicator_expand);
        this.f168769b = r106;
        View r107 = findViewById(com.larus.nova.R.id.head_indicator_selected_background);
        this.f168770c = r107;
        if (d.a() == false) goto L15;
        ViewGroup.LayoutParams r108 = r106.getLayoutParams();
        r108.height = com.bytedance.android.shopping.extensions.b.b(20);
        Unit r109 = Unit.INSTANCE;
        r106.setLayoutParams(r108);
        ViewGroup.LayoutParams r110 = r105.getLayoutParams();
        r110.height = com.bytedance.android.shopping.extensions.b.b(20);
        r105.setLayoutParams(r110);
        r105.setBackgroundDrawable(ag4.a.c(com.larus.nova.R.drawable.commerce_bg_foldable_indicator_container_v4));
        ViewGroup.LayoutParams r111 = r107.getLayoutParams();
        r111.height = com.bytedance.android.shopping.extensions.b.b(24);
        r107.setLayoutParams(r111);
        r107.setBackgroundDrawable(ag4.a.c(com.larus.nova.R.drawable.anchor_v4_head_foldable_indicator_anim_bg));
        return;
    }
}
