package com.bytedance.android.shopping.anchorv4.voavhs.head.indicator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import c63.d;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.bytedance.android.shopping.extensions.j;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import f83.i;
import f83.l;
import f83.m;
import f83.n;
import f83.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/indicator/AnchorV4FoldableTabIndicator;", "Landroid/widget/FrameLayout;", "Lf83/l;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "getFindSameElement", "Lf83/p;", "m", "Lf83/p;", "getTabLogicInterceptor", "()Lf83/p;", "tabLogicInterceptor", "Lc63/d;", OfficeSDKRequestTag.KEY_NEW_USER, "Lc63/d;", "getLogAction", "()Lc63/d;", "logAction", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4FoldableTabIndicator extends FrameLayout implements l {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f168733p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f168734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f168735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f168736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f168737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<n> f168738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f168739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f168740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f168741h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f168742i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f168743j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f168744k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f168745l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p f168746m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f168747n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final m f168748o;

    public static final class a {
        public a() {
        }

        public static TextView a(Context r100, String r101) {
            int r102 = AnchorV4FoldableTabIndicator.f168733p;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "textValue");
            TextView r103 = new TextView(r100);
            int r104 = (int) UIUtils.dip2Px(r103.getContext(), 8.0f);
            int r105 = (int) UIUtils.dip2Px(r103.getContext(), 2.0f);
            r103.setTextSize(10.0f);
            r103.setTypeface(Typeface.DEFAULT_BOLD);
            r103.setTextColor(-1);
            r103.setPadding(r104, r105, r104, r105);
            r103.setText(r101);
            r103.setGravity(17);
            return r103;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4FoldableTabIndicator f168749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f168750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f168751c;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f168752a;

            public a(b r100) {
                this.f168752a = r100;
            }

            public final void a() {
                View r100 = this.f168752a.f168749a.f168736c;
                ViewGroup.LayoutParams r101 = r100.getLayoutParams();
                r101.width = this.f168752a.f168750b.getWidth();
                r101.height = this.f168752a.f168750b.getHeight();
                Unit r102 = Unit.INSTANCE;
                r100.setLayoutParams(r101);
                b r103 = this.f168752a;
                if (r103.f168751c <= 0) goto L11;
                View r104 = r103.f168749a.f168736c;
                ViewGroup.LayoutParams r105 = r104.getLayoutParams();
                if ((r105 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
                r105 = null;
            L7:
                ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
                if (r106 == null) goto L12;
                r106.leftMargin = this.f168752a.f168750b.getLeft();
                r104.setLayoutParams(r106);
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

        public b(AnchorV4FoldableTabIndicator r100, View r101, int r102) {
            this.f168749a = r100;
            this.f168750b = r101;
            this.f168751c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f168749a.f168736c.post(new a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4FoldableTabIndicator f168753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f168754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f168755c;

        public c(AnchorV4FoldableTabIndicator r100, View r101, View r102) {
            this.f168753a = r100;
            this.f168754b = r101;
            this.f168755c = r102;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L13;
            float r102 = ((Float) r101).floatValue();
            View r103 = this.f168753a.f168736c;
            ViewGroup.LayoutParams r104 = r103.getLayoutParams();
            if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
            r104 = null;
        L7:
            ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
            if (r105 == null) goto L10;
            r105.leftMargin = (int) (this.f168754b.getLeft() + ((this.f168755c.getLeft() - this.f168754b.getLeft()) * r102));
            r103.setLayoutParams(r105);
        L10:
            View r106 = this.f168753a.f168736c;
            ViewGroup.LayoutParams r107 = r106.getLayoutParams();
            r107.width = (int) (this.f168754b.getWidth() + ((this.f168755c.getWidth() - this.f168754b.getWidth()) * r102));
            r107.height = com.bytedance.android.shopping.extensions.b.b(20);
            Unit r108 = Unit.INSTANCE;
            r106.setLayoutParams(r107);
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
        new a();
    }

    public AnchorV4FoldableTabIndicator(Context r110) {
        this(r110, null, 0, null, null, false, null, 254);
    }

    public AnchorV4FoldableTabIndicator(Context r110, AttributeSet r111) {
        this(r110, r111, 0, null, null, false, null, 252);
    }

    public AnchorV4FoldableTabIndicator(Context r110, AttributeSet r111, int r112) {
        this(r110, r111, r112, null, null, false, null, 248);
    }

    @Override // f83.l
    public final void a(boolean r100) {
    }

    @Override // f83.l
    public final void c(List<String> r100, List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "titleTags");
        Intrinsics.checkNotNullParameter(r101, "originTags");
        Intrinsics.checkNotNullParameter(r102, "tabTypes");
    }

    @Override // f83.l
    public CommonFindSameElement getFindSameElement() {
        return null;
    }

    public final d getLogAction() {
        return this.f168747n;
    }

    public final p getTabLogicInterceptor() {
        return this.f168746m;
    }

    @Override // f83.l
    public final void h(boolean r100) {
        wg.a.h(this, r100);
    }

    public final void d(int r110, String r111, boolean r112) {
        n r100 = (n) CollectionsKt.getOrNull(this.f168738e, r110);
        View r101 = null;
        if (r100 == null) goto L8;
        boolean r102 = r100.f475857a;
        boolean r103 = r100.f475858b;
        m r104 = this.f168748o;
        if (r104 == null) goto L7;
        r104.b(r110, r102, r103, r111, r112, r100.f475861e);
    L7:
        r100.f475857a = false;
    L9:
        Iterator<T> r113 = this.f168738e.iterator();
    L11:
        if (r113.hasNext() == false) goto L15;
        Object r105 = r113.next();
        if (((n) r105).f475859c.isSelected() == false) goto L11;
    L16:
        n r106 = (n) r105;
        if (r106 == null) goto L19;
        r101 = r106.f475859c;
    L19:
        n r114 = (n) CollectionsKt.getOrNull(this.f168738e, r110);
        if (r114 == null) goto L32;
        View r115 = r114.f475859c;
        if (r115 == null) goto L37;
        if (r112 == false) goto L26;
        r115.post(new b(this, r115, r110));
    L28:
        Iterator<T> r116 = this.f168738e.iterator();
    L30:
        if (r116.hasNext() == false) goto L38;
        n r117 = (n) r116.next();
        r117.f475859c.setSelected(Intrinsics.areEqual(r100, r117));
        goto L30
    L38:
        return;
    L26:
        if (r101 == null) goto L28;
        ValueAnimator r118 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(250);
        r118.addUpdateListener(new c(this, r101, r115));
        r118.start();
        goto L28
    L37:
        return;
    L32:
        return;
    L15:
        r105 = null;
        goto L16
    L8:
        r100 = null;
        goto L9
    }

    @Override // f83.l
    public final void b(Integer r110, int r111, String r112, boolean r113) {
        int r100 = -1;
        if (r110 == null) goto L8;
        d(r110.intValue(), r112, r113);
        if (this.f168744k == r110.intValue()) goto L7;
        r100 = this.f168744k;
    L7:
        this.f168744k = r110.intValue();
    L8:
        this.f168745l = r112;
        List<String> r114 = this.f168742i;
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r114.iterator();
    L10:
        if (r116.hasNext() == false) goto L14;
        Object r117 = r116.next();
        if (Intrinsics.areEqual((String) r117, (String) ListProtector.get(this.f168742i, r111)) == false) goto L10;
        r115.add(r117);
        goto L10
    L14:
        int r118 = r115.size();
        boolean r119 = true;
        if (r118 <= 1) goto L17;
        boolean r101 = true;
    L18:
        String r102 = "";
        if (this.f168743j == false) goto L21;
        String r103 = "";
    L22:
        int r104 = ((ArrayList) this.f168742i).indexOf(r103);
        if (r104 >= 0) goto L25;
        r104 = 0;
    L25:
        int r105 = r111 - r104;
        TextView r106 = this.f168739f;
        if (r101 == false) goto L28;
        String r107 = j.e(R.string.shopping_tip_indicator_num, Integer.valueOf(r105 + 1), Integer.valueOf(r118));
    L29:
        r106.setText(Intrinsics.stringPlus(r103, r107));
        if (r111 > ((ArrayList) this.f168742i).lastIndexOf(this.f168741h)) goto L32;
        this.f168740g.setText(this.f168741h + j.e(R.string.shopping_tip_indicator_num, Integer.valueOf(r111 + 1), Integer.valueOf(r118)));
    L32:
        Object r120 = CollectionsKt.getOrNull(com.bytedance.commerce.base.view.b.a(this.f168735b), r100);
        Object r108 = null;
        if ((r120 instanceof TextView) == true) goto L35;
        r120 = null;
    L35:
        TextView r121 = (TextView) r120;
        if (r121 == null) goto L42;
        n r109 = (n) CollectionsKt.getOrNull(this.f168738e, r100);
        if (r109 == null) goto L40;
        String r122 = r109.f475860d;
    L41:
        r121.setText(r122);
        goto L42
    L40:
        r122 = null;
    L42:
        Object r123 = CollectionsKt.getOrNull(com.bytedance.commerce.base.view.b.a(this.f168735b), this.f168744k);
        if ((r123 instanceof TextView) == false) goto L46;
        r108 = r123;
    L46:
        TextView r124 = (TextView) r108;
        if (r124 == null) goto L51;
        if (r101 == false) goto L50;
        r102 = j.e(R.string.shopping_tip_indicator_num, Integer.valueOf(r105 + 1), Integer.valueOf(r118));
    L50:
        r124.setText(Intrinsics.stringPlus(r103, r102));
    L51:
        CharSequence r125 = this.f168739f.getText();
        if (r125 != null) goto L54;
    L57:
        if (r119 == false) goto L59;
        this.f168739f.setVisibility(8);
        return;
    L59:
        this.f168739f.setVisibility(0);
        return;
    L54:
        if (r125.length() == 0) goto L57;
        r119 = false;
        goto L57
    L28:
        r107 = "";
        goto L29
    L21:
        r103 = (String) ListProtector.get(this.f168742i, r111);
        goto L22
    L17:
        r101 = false;
        goto L18
    }

    public AnchorV4FoldableTabIndicator(Context r100, AttributeSet r101, int r102, p r103, d r104, boolean r105, i r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r111 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r111 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r111 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r111 & 64) == 0) goto L18;
        r105 = false;
    L18:
        if ((r111 & 128) == 0) goto L20;
        r110 = null;
    L20:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f168746m = r103;
        this.f168747n = r104;
        this.f168748o = r110;
        this.f168738e = new ArrayList();
        this.f168739f = new TextView(r100);
        this.f168740g = new TextView(r100);
        this.f168741h = "";
        this.f168742i = new ArrayList();
        this.f168744k = -1;
        this.f168745l = "";
        new ArrayList();
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.shopping_anchor_v4_indicator_layout, this, true);
        LinearLayout r106 = (LinearLayout) findViewById(R.id.head_indicator_fold);
        this.f168734a = r106;
        LinearLayout r107 = (LinearLayout) findViewById(R.id.head_indicator_expand);
        this.f168735b = r107;
        View r108 = findViewById(R.id.head_tab_root_view);
        this.f168737d = r108;
        r107.setVisibility(8);
        r106.setVisibility(0);
        View r109 = findViewById(R.id.head_indicator_selected_background);
        this.f168736c = r109;
        ViewGroup.LayoutParams r112 = r108.getLayoutParams();
        r112.height = com.bytedance.android.shopping.extensions.b.b(20);
        Unit r113 = Unit.INSTANCE;
        r108.setLayoutParams(r112);
        r108.setBackgroundDrawable(ag4.a.c(R.drawable.commerce_bg_foldable_indicator_container_v4));
        ViewGroup.LayoutParams r114 = r109.getLayoutParams();
        r114.height = com.bytedance.android.shopping.extensions.b.b(20);
        r109.setLayoutParams(r114);
        r109.setBackgroundDrawable(ag4.a.c(R.drawable.anchor_v4_head_foldable_indicator_anim_bg));
        if (r105 == false) goto L23;
        r106.setVisibility(8);
        r107.setVisibility(0);
    L23:
        addOnAttachStateChangeListener(new f83.c(this));
    }
}
