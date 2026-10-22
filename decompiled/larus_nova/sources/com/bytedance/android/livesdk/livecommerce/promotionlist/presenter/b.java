package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.rotation.BaseRotationAdapter;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.livecommerce.iron.ui.ECCustomizedElementView;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.ECLiveDegradeHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends BaseRotationAdapter<com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f151010w = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f151011m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Animator f151012n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f151013o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f151014p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a> f151015q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f151016r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f151017s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final gi2.a f151018t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f151019u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RoomContextController f151020v;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b$b, reason: collision with other inner class name */
    public static final class C2325b<T> implements Comparator<T> {
        public C2325b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r100).f151008a.getPriority()), Integer.valueOf(((com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r101).f151008a.getPriority()));
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r100).f151008a.getPriority()), Integer.valueOf(((com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r101).f151008a.getPriority()));
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f151021a;

        public d(b r100) {
            this.f151021a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f151021a.f45698l.setVisibility(8);
            com.bytedance.android.ec.core.utils.rotation.e.h(this.f151021a.f45698l);
            b r101 = this.f151021a;
            r101.f151013o = true;
            r101.k(true);
            if ((true ^ r101.f45708a.isEmpty()) == false) goto L6;
            r101.f45709b = 0;
            r101.j();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final long e() {
        if (this.f45708a.size() <= 1) goto L5;
        return 3000;
    L5:
        return 5000;
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final void g() {
        ViewGroup r100 = this.f45698l;
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r101.setDuration(400);
        r101.addUpdateListener(new e(r100));
        r101.addListener(new d(this));
        if (this.f151014p == true) goto L5;
        ValueAnimator r102 = r101;
    L6:
        if (r102 == null) goto L8;
        r101.start();
    L8:
        Unit r103 = Unit.INSTANCE;
        this.f151012n = r101;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final void j() {
        this.f45698l.setVisibility(0);
        this.f151013o = false;
        super.j();
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final void a() {
        super.a();
        Animator r100 = this.f151012n;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final Animator b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        ECLiveDegradeHelper.f153042c.getClass();
        int r101 = ECLiveDegradeHelper.a("promotion_list_interaction_msg_degrade", ECLiveDegradeHelper.b().getEnablePromotionListInteractionMsgDegrade());
        if (r101 != 3) goto L5;
        long r102 = 0;
    L6:
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r103.setDuration(r102);
        r103.addUpdateListener(new com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.c(this, r100, r101));
        return r103;
    L5:
        r102 = 400;
        goto L6
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final Animator c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        ECLiveDegradeHelper.f153042c.getClass();
        int r101 = ECLiveDegradeHelper.a("promotion_list_interaction_msg_degrade", ECLiveDegradeHelper.b().getEnablePromotionListInteractionMsgDegrade());
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r101 != 3) goto L5;
        long r103 = 0;
    L6:
        r102.setDuration(r103);
        r102.addUpdateListener(new com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.d(this, r101, r100));
        return r102;
    L5:
        r103 = 400;
        goto L6
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final int d(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a r101 = null;
    L7:
        int r102 = 0;
        if (this.f45708a.isEmpty() == false) goto L10;
        int r103 = 0;
    L12:
        if ((!((ArrayList) this.f151015q).isEmpty()) == false) goto L14;
        k(true);
    L19:
        r103 = 0;
    L21:
        if (r103 >= 0) goto L23;
    L40:
        return -1;
    L23:
        if (this.f45708a.isEmpty() == true) goto L40;
        if (this.f45698l.getVisibility() != 0) goto L27;
        boolean r104 = true;
    L28:
        if (r104 == false) goto L40;
        if (this.f151014p == true) goto L40;
    L33:
        if (Intrinsics.areEqual((com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) ListProtector.get(this.f45708a, r103), r101) == false) goto L39;
        r102 = r102 + 1;
        if (r102 >= this.f45708a.size()) goto L36;
        r103 = (r103 + 1) % this.f45708a.size();
        goto L33
    L36:
        ArrayList r105 = new ArrayList();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f45708a = r105;
        return -1;
    L39:
        return r103;
    L27:
        r104 = false;
        goto L28
    L14:
        if (r103 != 0) goto L16;
        boolean r106 = true;
    L17:
        k(r106);
        if (r103 < this.f45708a.size()) goto L21;
    L16:
        r106 = false;
        goto L17
    L10:
        r103 = (r100 + 1) % this.f45708a.size();
        goto L12
    L4:
        if (r100 >= this.f45708a.size()) goto L6;
        r101 = (com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) ListProtector.get(this.f45708a, r100);
        goto L7
    }

    public final void k(boolean r100) {
        if (this.f151016r == false) goto L18;
        Iterator r101 = ((ArrayList) this.f151015q).iterator();
    L6:
        if (r101.hasNext() == false) goto L17;
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a r102 = (com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r101.next();
        Iterator r103 = this.f45708a.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r104).f151008a, r102.f151008a) == false) goto L9;
    L14:
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a r105 = (com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r104;
        if (r105 == null) goto L6;
        r102.f151009b = r105.f151009b;
        goto L6
    L13:
        r104 = null;
        goto L14
    L17:
        ArrayList r106 = new ArrayList();
        r106.addAll(this.f151015q);
        Unit r107 = Unit.INSTANCE;
        List<? extends T> r108 = CollectionsKt.sortedWith(r106, new C2325b());
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        this.f45708a = r108;
        this.f151016r = false;
        ((ArrayList) this.f151015q).clear();
        return;
    L18:
        if (r100 == false) goto L46;
        ArrayList r109 = new ArrayList();
        r109.addAll(this.f151015q);
        r109.addAll(this.f45708a);
        Unit r110 = Unit.INSTANCE;
        ArrayList r111 = new ArrayList();
        Iterator r112 = r109.iterator();
    L21:
        if (r112.hasNext() == false) goto L30;
        Object r113 = r112.next();
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a r114 = (com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r113;
        int r115 = r114.f151009b;
        int r116 = r114.f151008a.getLoopCount();
        if (r116 > 0) goto L25;
        r116 = 3;
    L25:
        if (r115 >= r116) goto L27;
        boolean r117 = true;
    L28:
        if (r117 == false) goto L21;
        r111.add(r113);
        goto L21
    L27:
        r117 = false;
        goto L28
    L30:
        List<? extends T> r118 = CollectionsKt.sortedWith(r111, new c());
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        this.f45708a = r118;
        ((ArrayList) this.f151015q).clear();
        return;
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final void i(int r210, Object r211) {
        final com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a r100 = (com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r211;
        Intrinsics.checkNotNullParameter(r100, "data");
        r100.f151009b++;
        if (r210 != 0) goto L5;
        final View r101 = (View) this.f45696j.getValue();
    L6:
        Intrinsics.checkNotNullParameter(r101, "itemView");
        Intrinsics.checkNotNullParameter(r100, "data");
        View r102 = r101.findViewById(R.id.top_interaction_root);
        List<com.bytedance.android.ec.model.live.o> r103 = r100.f151008a.getRows();
        int r104 = 0;
        if (r103 != null) goto L9;
    L12:
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        r102.setVisibility(8);
        return;
    L16:
        r102.setVisibility(0);
        List<com.bytedance.android.ec.model.live.o> r106 = r100.f151008a.getRows();
        if (r106 == null) goto L19;
        int r107 = r106.size();
    L20:
        GradientDrawable r110 = new GradientDrawable();
        r110.setShape(0);
        List<String> r111 = r100.f151008a.getBgColors();
        if (r111 == null) goto L37;
        ArrayList r112 = new ArrayList(3);
        Iterator<String> r113 = r111.iterator();     // Catch: Exception -> L28
    L25:
        if (r113.hasNext() == false) goto L29;
        r112.add(Integer.valueOf(Color.parseColor(r113.next())));     // Catch: Exception -> L28
    L29:
        int[] r114 = CollectionsKt.toIntArray(r112);
        if (r114.length <= 1) goto L33;
        r110.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        r110.setGradientType(0);
        r110.setColors(r114);
        goto L37
    L33:
        if (ArraysKt.getLastIndex(r114) < 0) goto L35;
        int r108 = r114[0];
    L36:
        r110.setColor(r108);
        goto L37
    L35:
        r108 = ColorProtector.parseColor("#A6000000");
    L28:
        r112.clear();
        r112.add(Integer.valueOf(ColorProtector.parseColor("#A6000000")));
    L37:
        ViewGroup.LayoutParams r109 = r102.getLayoutParams();
        if (r109 == null) goto L121;
        ConstraintLayout.LayoutParams r115 = (ConstraintLayout.LayoutParams) r109;
        r115.matchConstraintPercentWidth = this.f151011m;
        r102.setLayoutParams(r115);
        if (r107 <= 1) goto L47;
        r110.setCornerRadius(UtilityKotlinExtentionsKt.c(8));
        r102.setPadding(UtilityKotlinExtentionsKt.d(2), UtilityKotlinExtentionsKt.d(2), UtilityKotlinExtentionsKt.d(6), UtilityKotlinExtentionsKt.d(2));
        View r116 = r102.findViewById(R.id.top_interaction_fl_index);
        r116.getLayoutParams().width = UtilityKotlinExtentionsKt.d(Double.valueOf(15.6d));
        r116.getLayoutParams().height = UtilityKotlinExtentionsKt.d(Double.valueOf(13.2d));
        View r117 = r102.findViewById(R.id.top_interaction_layout_cover);
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if ((r118 instanceof ViewGroup.MarginLayoutParams) == true) goto L44;
        r118 = null;
    L44:
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r118;
        if (r119 == null) goto L53;
        r119.rightMargin = UtilityKotlinExtentionsKt.d(6);
        r117.setLayoutParams(r119);
    L53:
        r102.setBackground(r110);
        com.bytedance.android.ec.model.live.n r120 = r100.f151008a.getProduct();
        if (r120 == null) goto L80;
        ECDraweeView r121 = (ECDraweeView) r102.findViewById(R.id.top_interaction_cover);
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
        if (r122 == null) goto L66;
        ECUrlModel r123 = r120.a();
        if (r123 == null) goto L60;
        int r124 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r123.getWidth()));
    L61:
        r122.width = r124;
        ECUrlModel r125 = r120.a();
        if (r125 == null) goto L64;
        int r126 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r125.getHeight()));
    L65:
        r122.height = r126;
        goto L66
    L64:
        r126 = 0;
        goto L65
    L60:
        r124 = 0;
    L66:
        ECUrlModel r127 = r120.a();
        if (r127 == null) goto L69;
        List<String> r128 = r127.getUrlList();
    L70:
        h0.f(r121, r128, new com.bytedance.android.ec.core.imagex.r("ec_live", "promotion_list_top_vibe"), null, null, 120);
        if (r120.c() == false) goto L79;
        r102.findViewById(R.id.top_interaction_fl_index).setVisibility(0);
        TextView r129 = (TextView) r102.findViewById(R.id.top_interaction_tv_index);
        String r130 = String.valueOf(r120.b());
        r129.setText(r130);
        if (r130.length() <= 1) goto L78;
        if (r107 <= 1) goto L76;
        float r131 = 7.0f;
    L77:
        r129.setTextSize(1, r131);
        goto L80
    L76:
        r131 = 5.0f;
        goto L77
    L78:
        r129.setTextSize(1, 9.0f);
        goto L80
    L79:
        r102.findViewById(R.id.top_interaction_fl_index).setVisibility(8);
        goto L80
    L69:
        r128 = null;
    L80:
        View r132 = (View) CollectionsKt.getOrNull(com.bytedance.commerce.base.view.b.a(r102), 0);
        if (r132 == null) goto L83;
        r102.measure(View.MeasureSpec.makeMeasureSpec(this.f45698l.getWidth(), 1073741824), 0);
        r132.measure(0, 0);
        float r133 = ((((r102.getMeasuredWidth() * this.f151011m) - UtilityKotlinExtentionsKt.c(Integer.valueOf(r102.getPaddingLeft()))) - UtilityKotlinExtentionsKt.c(Integer.valueOf(r102.getPaddingRight()))) - r132.getMeasuredWidth()) - o0.b(r132);
    L84:
        List<View> r134 = com.bytedance.commerce.base.view.b.a(r102.findViewById(R.id.top_interaction_line));
        List<com.bytedance.android.ec.model.live.o> r135 = r100.f151008a.getRows();
        if (r135 == null) goto L108;
        Iterator<T> r136 = r135.iterator();
        int r137 = 0;
    L88:
        if (r136.hasNext() == false) goto L108;
        Object r138 = r136.next();
        int r139 = r137 + 1;
        if (r137 >= 0) goto L92;
        CollectionsKt.throwIndexOverflow();
    L92:
        List<com.bytedance.android.ec.model.live.b> r140 = ((com.bytedance.android.ec.model.live.o) r138).a();
        if (r140 == null) goto L106;
        View r141 = (View) CollectionsKt.getOrNull(r134, r137);
        if (r141 == null) goto L100;
        r141.setVisibility(0);
        if (r133 <= 0.0f) goto L99;
        ((ECCustomizedElementView) r141).d(r140, (int) r133);
        goto L106
    L99:
        int r142 = ECCustomizedElementView.f148866k;
        ((ECCustomizedElementView) r141).b(r140, false);
        goto L106
    L100:
        ECCustomizedElementView r143 = new ECCustomizedElementView(r102.getContext(), null, 6, r104);
        if (r133 <= 0) goto L103;
        r143.d(r140, (int) r133);
    L104:
        ((LinearLayout) r102.findViewById(R.id.top_interaction_line)).addView(r143);
        Unit r144 = Unit.INSTANCE;
        goto L106
    L103:
        r143.b(r140, false);
    L106:
        r137 = r139;
    L108:
        if (r134.size() <= r107) goto L115;
        int r145 = r134.size();
    L110:
        if (r107 >= r145) goto L115;
        View r146 = (View) CollectionsKt.getOrNull(r134, r107);
        if (r146 == null) goto L114;
        r146.setVisibility(8);
    L114:
        r107 = r107 + 1;
    L115:
        final Map<String, String> r147 = r100.f151008a.getTrackParams();
        if (this.f151019u == false) goto L118;
        oh.a.c("livesdk_show_shop_popup", new f(this, r147));
    L118:
        r101.findViewById(R.id.top_interaction_root).setOnClickListener(new InteractionRotationAdapter$onBindView$clickListener$1(this, r147, r101, r100));
        return;
    L83:
        r133 = -1.0f;
        goto L84
    L47:
        r110.setCornerRadius(UtilityKotlinExtentionsKt.c(27));
        r102.setPadding(UtilityKotlinExtentionsKt.d(6), UtilityKotlinExtentionsKt.d(4), UtilityKotlinExtentionsKt.d(6), UtilityKotlinExtentionsKt.d(4));
        View r148 = r102.findViewById(R.id.top_interaction_fl_index);
        r148.getLayoutParams().width = UtilityKotlinExtentionsKt.d(Double.valueOf(11.5d));
        r148.getLayoutParams().height = UtilityKotlinExtentionsKt.d(Double.valueOf(9.6d));
        View r149 = r102.findViewById(R.id.top_interaction_layout_cover);
        ViewGroup.LayoutParams r150 = r149.getLayoutParams();
        if ((r150 instanceof ViewGroup.MarginLayoutParams) == true) goto L50;
        r150 = null;
    L50:
        ViewGroup.MarginLayoutParams r151 = (ViewGroup.MarginLayoutParams) r150;
        if (r151 == null) goto L53;
        r151.rightMargin = UtilityKotlinExtentionsKt.d(4);
        r149.setLayoutParams(r151);
        goto L53
    L121:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L19:
        r107 = 0;
        goto L20
    L9:
        if (r103.isEmpty() == true) goto L12;
        r105 = false;
        goto L14
    L5:
        r101 = (View) this.f45697k.getValue();
        goto L6
    }

    public b(FrameLayout r100, gi2.a r101, RoomContextController r102) {
        Intrinsics.checkNotNullParameter(r100, "rootLayout");
        super(r100);
        this.f151018t = r101;
        this.f151019u = true;
        this.f151020v = r102;
        this.f45709b = 1000;
        this.f45710c = 3000;
        this.f45711d = false;
        this.f151011m = 0.64f;
        this.f151015q = new ArrayList();
        this.f151017s = true;
    }
}
