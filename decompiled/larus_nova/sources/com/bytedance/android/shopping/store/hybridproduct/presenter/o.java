package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.hybridproduct.dto.Position;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f185394e;

    public o(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "rootViewGroup");
        this.f185394e = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r110) {
        QModel r100 = r110;
        if ((r100 instanceof ej3.d) == true) goto L5;
        r100 = null;
    L5:
        ej3.d r101 = (ej3.d) r100;
        if (r101 != null) goto L8;
        return;
    L8:
        ViewGroup r102 = this.f185394e;
        dj3.h r103 = r101.f472855k;
        if (r103 == null) goto L13;
        Integer r104 = r103.b();
        if (r104 == null) goto L13;
        int r105 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        Integer r106 = Integer.valueOf(com.bytedance.android.ec.hybrid.list.util.c.d(r104));
    L14:
        int r107 = com.bytedance.android.shopping.extensions.k.f(r106);
        dj3.h r108 = r101.f472855k;
        if (r108 == null) goto L19;
        Integer r109 = r108.d();
        if (r109 == null) goto L19;
        int r111 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        Integer r112 = Integer.valueOf(com.bytedance.android.ec.hybrid.list.util.c.d(r109));
    L20:
        int r113 = com.bytedance.android.shopping.extensions.k.f(r112);
        dj3.h r114 = r101.f472855k;
        if (r114 == null) goto L25;
        Integer r115 = r114.c();
        if (r115 == null) goto L25;
        int r116 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        Integer r117 = Integer.valueOf(com.bytedance.android.ec.hybrid.list.util.c.d(r115));
    L26:
        int r118 = com.bytedance.android.shopping.extensions.k.f(r117);
        dj3.h r119 = r101.f472855k;
        if (r119 == null) goto L31;
        Integer r120 = r119.a();
        if (r120 == null) goto L31;
        int r121 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        Integer r122 = Integer.valueOf(com.bytedance.android.ec.hybrid.list.util.c.d(r120));
    L32:
        r102.setPadding(r107, r113, r118, com.bytedance.android.shopping.extensions.k.f(r122));
        TextView r123 = (TextView) this.f185394e.findViewById(R.id.no_product_text);
        SimpleDraweeView r124 = (SimpleDraweeView) this.f185394e.findViewById(R.id.no_product_image);
        String r125 = r101.f472846b;
        boolean r126 = true;
        if (r125 != null) goto L35;
    L38:
        boolean r127 = true;
    L39:
        int r128 = 8;
        if (r127 == false) goto L42;
        int r129 = 8;
    L43:
        r123.setVisibility(r129);
        ECUrlModel r130 = r101.f472849e;
        if (r130 == null) goto L46;
        List<String> r131 = r130.getUrlList();
    L47:
        List<String> r132 = r131;
        if (r132 != null) goto L50;
    L53:
        boolean r133 = true;
    L54:
        if (r133 == true) goto L57;
        r128 = 0;
    L57:
        r124.setVisibility(r128);
        r123.setText(r101.f472846b);
        Integer r134 = r101.f472848d;
        if (r134 == null) goto L60;
        float r135 = r134.intValue();
    L61:
        r123.setTextSize(r135);
        int r136 = com.bytedance.android.ec.core.utils.s.f45717a;
        r123.setTextColor(com.bytedance.android.ec.core.utils.s.a(r101.f472847c, -16777216));
        com.bytedance.android.ec.core.imagex.h0.d(r124, r101.f472849e, null, null, null, null, null, 120);
        ViewGroup.LayoutParams r137 = r124.getLayoutParams();
        ECUrlModel r138 = r101.f472849e;
        if (r138 == null) goto L64;
        Integer r139 = Integer.valueOf(r138.getHeight());
        int r140 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r141 = com.bytedance.android.ec.hybrid.list.util.c.d(r139);
    L65:
        r137.height = r141;
        ViewGroup.LayoutParams r142 = r124.getLayoutParams();
        ECUrlModel r143 = r101.f472849e;
        if (r143 == null) goto L68;
        Integer r144 = Integer.valueOf(r143.getWidth());
        int r145 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r146 = com.bytedance.android.ec.hybrid.list.util.c.d(r144);
    L69:
        r142.width = r146;
        ViewGroup r147 = this.f185394e;
        Double r148 = r101.f472845a;
        if (r148 == null) goto L72;
        int r149 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        Integer r150 = Integer.valueOf(com.bytedance.android.ec.hybrid.list.util.c.d(r148));
    L73:
        int r151 = com.bytedance.android.shopping.extensions.k.f(r150);
        dj3.h r152 = r101.f472855k;
        if (r152 == null) goto L78;
        Integer r153 = r152.d();
        if (r153 == null) goto L78;
        int r154 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        Integer r155 = Integer.valueOf(com.bytedance.android.ec.hybrid.list.util.c.d(r153));
    L79:
        int r156 = r151 + com.bytedance.android.shopping.extensions.k.f(r155);
        dj3.h r157 = r101.f472855k;
        if (r157 == null) goto L84;
        Integer r158 = r157.a();
        if (r158 == null) goto L84;
        int r159 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        Integer r160 = Integer.valueOf(com.bytedance.android.ec.hybrid.list.util.c.d(r158));
    L85:
        wg.a.d(r147, r156 + com.bytedance.android.shopping.extensions.k.f(r160));
        ConstraintSet r161 = new ConstraintSet();
        ViewGroup r162 = this.f185394e;
        if (r162 == null) goto L150;
        r161.clone((ConstraintLayout) r162);
        Position r163 = r101.f472850f;
        if (r163 != Position.LEFT) goto L95;
        r161.connect(R.id.no_product_text, 6, 0, 6);
        r161.connect(R.id.no_product_text, 7, R.id.no_product_image, 6);
        r161.connect(R.id.no_product_image, 6, R.id.no_product_text, 7);
        r161.connect(R.id.no_product_image, 7, 0, 7);
        r161.setHorizontalChainStyle(R.id.no_product_text, 2);
        r161.centerVertically(R.id.no_product_text, 0);
        r161.centerVertically(R.id.no_product_image, 0);
        Double r164 = r101.f472851g;
        if (r164 == null) goto L92;
        int r165 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r166 = com.bytedance.android.ec.hybrid.list.util.c.d(r164);
    L93:
        r161.setMargin(R.id.no_product_image, 6, r166);
    L115:
        r161.applyTo((ConstraintLayout) this.f185394e);
        String r167 = r101.f472852h;
        if (r167 != null) goto L118;
    L147:
        this.f185394e.requestLayout();
        return;
    L118:
        if (r167.length() <= 0) goto L120;
        boolean r168 = true;
    L121:
        if (r168 != true) goto L147;
        if (r101.f472850f != Position.BOTTOM) goto L147;
        TextView r169 = (TextView) this.f185394e.findViewById(R.id.no_product_sub_text);
        r169.setText(r101.f472852h);
        ExtensionsKt.visible(r169);
        dj3.l r170 = r101.f472854j;
        if (r170 == null) goto L131;
        String r171 = r170.b();
        if (r171 == null) goto L131;
        Integer r172 = com.bytedance.android.ec.core.utils.s.b(r171);
        if (r172 == null) goto L131;
        r169.setTextColor(r172.intValue());
    L131:
        dj3.l r173 = r101.f472854j;
        if (r173 == null) goto L136;
        Integer r174 = r173.a();
        if (r174 == null) goto L136;
        r169.setTextSize(r174.intValue());
    L136:
        Integer r175 = r101.f472853i;
        if (r175 == null) goto L147;
        if (r175.intValue() > 0) goto L142;
        r126 = false;
    L142:
        if (r126 == false) goto L144;
        Integer r176 = r175;
    L145:
        if (r176 == null) goto L147;
        int r177 = r176.intValue();
        int r178 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        d2.f(r169, com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r177)));
        goto L147
    L144:
        r176 = null;
        goto L145
    L120:
        r168 = false;
        goto L121
    L92:
        r166 = 0;
        goto L93
    L95:
        if (r163 != Position.RIGHT) goto L102;
        r161.connect(R.id.no_product_image, 6, 0, 6);
        r161.connect(R.id.no_product_image, 7, R.id.no_product_text, 6);
        r161.connect(R.id.no_product_text, 6, R.id.no_product_image, 7);
        r161.connect(R.id.no_product_text, 7, 0, 7);
        r161.setHorizontalChainStyle(R.id.no_product_image, 2);
        r161.centerVertically(R.id.no_product_text, 0);
        r161.centerVertically(R.id.no_product_image, 0);
        Double r179 = r101.f472851g;
        if (r179 == null) goto L99;
        int r180 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r181 = com.bytedance.android.ec.hybrid.list.util.c.d(r179);
    L100:
        r161.setMargin(R.id.no_product_text, 6, r181);
        goto L115
    L99:
        r181 = 0;
        goto L100
    L102:
        if (r163 != Position.TOP) goto L109;
        r161.connect(R.id.no_product_text, 3, 0, 3);
        r161.connect(R.id.no_product_text, 4, R.id.no_product_image, 3);
        r161.connect(R.id.no_product_image, 3, R.id.no_product_text, 4);
        r161.connect(R.id.no_product_image, 4, 0, 4);
        r161.setVerticalChainStyle(R.id.no_product_text, 2);
        r161.centerHorizontally(R.id.no_product_text, 0);
        r161.centerHorizontally(R.id.no_product_image, 0);
        Double r182 = r101.f472851g;
        if (r182 == null) goto L106;
        int r183 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r184 = com.bytedance.android.ec.hybrid.list.util.c.d(r182);
    L107:
        r161.setMargin(R.id.no_product_image, 3, r184);
        goto L115
    L106:
        r184 = 0;
        goto L107
    L109:
        if (r163 != Position.BOTTOM) goto L115;
        r161.connect(R.id.no_product_image, 3, 0, 3);
        r161.connect(R.id.no_product_text, 3, R.id.no_product_image, 4);
        r161.centerHorizontally(R.id.no_product_text, 0);
        r161.centerHorizontally(R.id.no_product_image, 0);
        Double r185 = r101.f472851g;
        if (r185 == null) goto L113;
        int r186 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r187 = com.bytedance.android.ec.hybrid.list.util.c.d(r185);
    L114:
        r161.setMargin(R.id.no_product_text, 3, r187);
        goto L115
    L113:
        r187 = 0;
        goto L114
    L150:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L84:
        r160 = null;
    L78:
        r155 = null;
        goto L79
    L72:
        r150 = null;
        goto L73
    L68:
        r146 = 0;
        goto L69
    L64:
        r141 = 0;
        goto L65
    L60:
        r135 = 0.0f;
        goto L61
    L50:
        if (r132.isEmpty() == true) goto L53;
        r133 = false;
        goto L54
    L46:
        r131 = null;
        goto L47
    L42:
        r129 = 0;
        goto L43
    L35:
        if (r125.length() == 0) goto L38;
        r127 = false;
    L31:
        r122 = null;
    L25:
        r117 = null;
    L19:
        r112 = null;
    L13:
        r106 = null;
        goto L14
    }
}
