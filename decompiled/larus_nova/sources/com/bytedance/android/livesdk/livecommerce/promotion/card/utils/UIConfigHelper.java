package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.ECRoundedLinearLayout;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class UIConfigHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f150297a = 0;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f150298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f150299b;

        public a(float r100, View r101) {
            this.f150298a = r100;
            this.f150299b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            ImageView.ScaleType r109 = ((ImageView) this.f150299b).getScaleType();
            ImageView.ScaleType r110 = ImageView.ScaleType.MATRIX;
            if (r109 == r110) goto L5;
            ((ImageView) this.f150299b).setScaleType(r110);
        L5:
            Matrix r111 = new Matrix();
            float r112 = this.f150298a;
            r111.setScale(r112, r112);
            float r113 = ((ImageView) this.f150299b).getWidth();
            Drawable r114 = ((ImageView) this.f150299b).getDrawable();
            int r115 = 0;
            if (r114 == null) goto L8;
            int r116 = r114.getIntrinsicWidth();
        L9:
            float r117 = r113 - (r116 * this.f150298a);
            float r118 = 2;
            float r119 = r117 / r118;
            float r120 = ((ImageView) this.f150299b).getHeight();
            Drawable r121 = ((ImageView) this.f150299b).getDrawable();
            if (r121 == null) goto L12;
            r115 = r121.getIntrinsicHeight();
        L12:
            r111.postTranslate(r119, (r120 - (r115 * this.f150298a)) / r118);
            ((ImageView) this.f150299b).setImageMatrix(r111);
            return;
        L8:
            r116 = 0;
            goto L9
        }
    }

    static {
    }

    public static int b(int r100) {
        if (r100 != (-1)) goto L6;
        return -1;
    L6:
        if (r100 != (-2)) goto L8;
        return -2;
    L8:
        if (r100 > 0) goto L12;
        return 0;
    L12:
        return UtilityKotlinExtentionsKt.d(Integer.valueOf(r100));
    }

    public static void c(View r100, IPromotionUIConfig.b r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, "design");
        float[] r101 = r110.i();
        boolean r102 = true;
        Float r103 = null;
        int r104 = 0;
        if (r101 == null) goto L21;
        if (r101.length != 4) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L21;
        float r106 = r101[0];
        float r107 = r101[1];
        float r108 = r101[2];
        float r109 = r101[3];
        if ((r100 instanceof ECRoundedLinearLayout) == true) goto L15;
        View r111 = null;
    L16:
        ECRoundedLinearLayout r112 = (ECRoundedLinearLayout) r111;
        if (r112 == null) goto L19;
        r112.setRadius(UtilityKotlinExtentionsKt.c(Float.valueOf(r106)));
    L28:
        String r113 = r110.b();
        if (r113 == null) goto L33;
        Integer r114 = com.bytedance.android.ec.core.utils.s.b(r113);
        if (r114 == null) goto L33;
        r100.setBackgroundColor(r114.intValue());
    L35:
        if ((r100 instanceof TextView) == false) goto L74;
        Float r115 = Float.valueOf(r110.e());
        float r116 = 0;
        if (r115.floatValue() <= r116) goto L39;
        boolean r117 = true;
    L40:
        if (r117 == true) goto L43;
        r115 = null;
    L43:
        if (r115 == null) goto L48;
        float r118 = r115.floatValue();
        if (r110.f() == false) goto L47;
        ((TextView) r100).setTextSize(2, r118);
        goto L48
    L47:
        ((TextView) r100).setTextSize(1, r118);
    L48:
        Integer r119 = Integer.valueOf(r110.g());
        int r120 = r119.intValue();
        if (r120 > 0) goto L51;
    L53:
        boolean r121 = false;
    L54:
        if (r121 == true) goto L57;
        r119 = null;
    L57:
        if (r119 == null) goto L59;
        int r122 = r119.intValue();
        int r123 = c0.f45558a;
        c0.b((TextView) r100, r122);
    L59:
        String r124 = r110.d();
        if (r124 == null) goto L64;
        Integer r125 = com.bytedance.android.ec.core.utils.s.b(r124);
        if (r125 == null) goto L64;
        ((TextView) r100).setTextColor(r125.intValue());
    L64:
        Float r126 = Float.valueOf(r110.h());
        if (r126.floatValue() <= r116) goto L67;
        boolean r127 = true;
    L68:
        if (r127 == true) goto L71;
        r126 = null;
    L71:
        if (r126 == null) goto L74;
        ((TextView) r100).setLineSpacing(UtilityKotlinExtentionsKt.c(Float.valueOf(r126.floatValue())), 1.0f);
        goto L74
    L67:
        r127 = false;
        goto L68
    L51:
        if ((r120 % 100) != 0) goto L53;
        r121 = true;
        goto L54
    L39:
        r117 = false;
    L74:
        if ((r100 instanceof ImageView) == false) goto L101;
        Float r128 = Float.valueOf(r110.c());
        float r129 = r128.floatValue();
        if (r129 >= 0) goto L78;
    L80:
        r102 = false;
    L81:
        if (r102 == false) goto L83;
        r103 = r128;
    L83:
        if (r103 == null) goto L102;
        float r130 = r103.floatValue();
        if (ViewCompat.isLaidOut(r100) == true) goto L87;
    L99:
        r100.addOnLayoutChangeListener(new a(r130, r100));
        return;
    L87:
        if (r100.isLayoutRequested() == true) goto L99;
        ImageView r131 = (ImageView) r100;
        ImageView.ScaleType r132 = r131.getScaleType();
        ImageView.ScaleType r133 = ImageView.ScaleType.MATRIX;
        if (r132 == r133) goto L91;
        r131.setScaleType(r133);
    L91:
        Matrix r134 = new Matrix();
        r134.setScale(r130, r130);
        float r135 = r131.getWidth();
        Drawable r136 = r131.getDrawable();
        if (r136 == null) goto L94;
        int r137 = r136.getIntrinsicWidth();
    L95:
        float r138 = 2;
        float r139 = (r135 - (r137 * r130)) / r138;
        float r140 = r131.getHeight();
        Drawable r141 = r131.getDrawable();
        if (r141 == null) goto L98;
        r104 = r141.getIntrinsicHeight();
    L98:
        r134.postTranslate(r139, (r140 - (r104 * r130)) / r138);
        r131.setImageMatrix(r134);
        return;
    L94:
        r137 = 0;
        goto L95
    L102:
        return;
    L78:
        if (r129 == 1.0f) goto L80;
    L101:
        return;
    L33:
        r100.setBackgroundColor(th.a.a(r100.getContext(), R.color.transparent));
        Unit r142 = Unit.INSTANCE;
        goto L35
    L19:
        ViewExtensionsKt.g(r100, r106, r107, r108, r109);
        Unit r143 = Unit.INSTANCE;
        goto L28
    L15:
        r111 = r100;
        goto L16
    L7:
        r105 = false;
    L21:
        if ((r100 instanceof ECRoundedLinearLayout) == true) goto L23;
        View r144 = null;
    L24:
        ECRoundedLinearLayout r145 = (ECRoundedLinearLayout) r144;
        if (r145 == null) goto L27;
        r145.setRadius(0.0f);
        goto L28
    L27:
        ViewExtensionsKt.g(r100, 0.0f, 0.0f, 0.0f, 0.0f);
        Unit r146 = Unit.INSTANCE;
        goto L28
    L23:
        r144 = r100;
        goto L24
    }

    public static void d(View r100, IPromotionUIConfig.d r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "style");
        Integer r102 = Integer.valueOf(r101.c());
        int r103 = r102.intValue();
        int r104 = 0;
        boolean r105 = true;
        if (r103 == 0) goto L7;
        if (r103 == 1) goto L7;
        r105 = false;
    L7:
        if (r105 == true) goto L10;
        r102 = null;
    L10:
        if (r102 != null) goto L12;
    L15:
        IPromotionUIConfig.c r106 = r101.b();
        if (r106 == null) goto L49;
        ViewGroup.LayoutParams r107 = r100.getLayoutParams();
        r107.width = b(r106.r());
        r107.height = b(r106.c());
        r100.setLayoutParams(r107);
        Integer r108 = r106.k();
        if (r108 == null) goto L20;
        int r109 = UtilityKotlinExtentionsKt.d(r108);
    L21:
        Integer r110 = r106.m();
        if (r110 == null) goto L24;
        int r111 = UtilityKotlinExtentionsKt.d(r110);
    L25:
        Integer r112 = r106.l();
        if (r112 == null) goto L28;
        int r113 = UtilityKotlinExtentionsKt.d(r112);
    L29:
        Integer r114 = r106.j();
        if (r114 == null) goto L32;
        int r115 = UtilityKotlinExtentionsKt.d(r114);
    L33:
        r100.setPadding(r109, r111, r113, r115);
        Integer r116 = r106.g();
        if (r116 == null) goto L36;
        int r117 = UtilityKotlinExtentionsKt.d(r116);
    L37:
        Integer r118 = r106.i();
        if (r118 == null) goto L40;
        int r119 = UtilityKotlinExtentionsKt.d(r118);
    L41:
        Integer r120 = r106.h();
        if (r120 == null) goto L44;
        int r121 = UtilityKotlinExtentionsKt.d(r120);
    L45:
        Integer r122 = r106.f();
        if (r122 == null) goto L48;
        r104 = UtilityKotlinExtentionsKt.d(r122);
    L48:
        wg.a.f(r100, r117, r119, r121, r104);
        goto L49
    L44:
        r121 = 0;
        goto L45
    L40:
        r119 = 0;
        goto L41
    L36:
        r117 = 0;
        goto L37
    L32:
        r115 = 0;
        goto L33
    L28:
        r113 = 0;
        goto L29
    L24:
        r111 = 0;
        goto L25
    L20:
        r109 = 0;
    L49:
        IPromotionUIConfig.b r123 = r101.a();
        if (r123 == null) goto L53;
        c(r100, r123);
        return;
    L53:
        return;
    L12:
        if (r102.intValue() != 0) goto L14;
        r100.setVisibility(0);
        goto L15
    L14:
        r100.setVisibility(8);
        goto L15
    }

    @JvmStatic
    public static final void a(View r100, View r101, Runnable r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        r101.setVisibility(8);
        r100.setVisibility(0);
        r100.setAlpha(1.0f);
        r100.animate().alpha(0.0f).setDuration(300).setListener(new a0(r100, r101, r102)).start();
    }

    public static void e(ConstraintLayout r110, Map r111, com.bytedance.android.livesdk.livecommerce.promotion.card.k r112) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, "moduleIdMap");
        Intrinsics.checkNotNullParameter(r112, "config");
        ConstraintSet r100 = new ConstraintSet();
        r100.clone(r110);
        Iterator<Map.Entry<? extends PromotionCardModuleName, ? extends IPromotionUIConfig.d>> r101 = r112.iterator();
    L4:
        if (r101.hasNext() == false) goto L136;
        Map.Entry<? extends PromotionCardModuleName, ? extends IPromotionUIConfig.d> r102 = r101.next();
        PromotionCardModuleName r103 = r102.getKey();
        IPromotionUIConfig.d r104 = r102.getValue();
        PromotionCardModuleName r105 = PromotionCardModuleName.Parent;
        if (r103 == r105) goto L4;
        Integer r106 = (Integer) r111.get(r103);
        if (r106 == null) goto L4;
        int r107 = r106.intValue();
        Integer r108 = Integer.valueOf(r104.c());
        int r109 = r108.intValue();
        if (r109 == 0) goto L15;
        if (r109 == 1) goto L15;
        boolean r113 = false;
    L16:
        if (r113 == true) goto L19;
        r108 = null;
    L19:
        if (r108 == null) goto L26;
        int r114 = r108.intValue();
        if (r103 == r105) goto L26;
        if (r114 != 0) goto L24;
        int r115 = 0;
    L25:
        r100.setVisibility(r107, r115);
        goto L26
    L24:
        r115 = 8;
    L26:
        IPromotionUIConfig.c r116 = r104.b();
        if (r116 != null) goto L29;
    L31:
        IPromotionUIConfig.c r117 = r104.b();
        if (r117 == null) goto L38;
        PromotionCardModuleName r118 = r117.d();
        if (r118 == null) goto L38;
        Integer r119 = (Integer) r111.get(r118);
        if (r119 == null) goto L38;
        r100.connect(r107, 6, r119.intValue(), 6);
    L45:
        IPromotionUIConfig.c r120 = r104.b();
        if (r120 == null) goto L52;
        PromotionCardModuleName r121 = r120.n();
        if (r121 == null) goto L52;
        Integer r122 = (Integer) r111.get(r121);
        if (r122 == null) goto L52;
        r100.connect(r107, 7, r122.intValue(), 6);
    L59:
        IPromotionUIConfig.c r123 = r104.b();
        if (r123 == null) goto L66;
        PromotionCardModuleName r124 = r123.q();
        if (r124 == null) goto L66;
        Integer r125 = (Integer) r111.get(r124);
        if (r125 == null) goto L66;
        r100.connect(r107, 3, r125.intValue(), 3);
    L73:
        IPromotionUIConfig.c r126 = r104.b();
        if (r126 == null) goto L80;
        PromotionCardModuleName r127 = r126.b();
        if (r127 == null) goto L80;
        Integer r128 = (Integer) r111.get(r127);
        if (r128 == null) goto L80;
        r100.connect(r107, 4, r128.intValue(), 3);
    L87:
        IPromotionUIConfig.c r129 = r104.b();
        if (r129 == null) goto L4;
        r100.constrainWidth(r107, b(r129.r()));
        r100.constrainHeight(r107, b(r129.c()));
        if (r107 != 0) goto L92;
        View r130 = r110;
    L93:
        if (r130 == null) goto L111;
        Integer r131 = r129.k();
        if (r131 == null) goto L97;
        int r132 = UtilityKotlinExtentionsKt.d(r131);
    L98:
        Integer r133 = r129.m();
        if (r133 == null) goto L101;
        int r134 = UtilityKotlinExtentionsKt.d(r133);
    L102:
        Integer r135 = r129.l();
        if (r135 == null) goto L105;
        int r136 = UtilityKotlinExtentionsKt.d(r135);
    L106:
        Integer r137 = r129.j();
        if (r137 == null) goto L109;
        int r138 = UtilityKotlinExtentionsKt.d(r137);
    L110:
        r130.setPadding(r132, r134, r136, r138);
        goto L111
    L109:
        r138 = 0;
        goto L110
    L105:
        r136 = 0;
        goto L106
    L101:
        r134 = 0;
        goto L102
    L97:
        r132 = 0;
    L111:
        Integer r139 = r129.i();
        if (r139 == null) goto L114;
        int r140 = UtilityKotlinExtentionsKt.d(r139);
    L115:
        r100.setMargin(r107, 3, r140);
        Integer r141 = r129.h();
        if (r141 == null) goto L118;
        int r142 = UtilityKotlinExtentionsKt.d(r141);
    L119:
        r100.setMargin(r107, 7, r142);
        Integer r143 = r129.h();
        if (r143 == null) goto L122;
        int r144 = UtilityKotlinExtentionsKt.d(r143);
    L123:
        r100.setMargin(r107, 2, r144);
        Integer r145 = r129.f();
        if (r145 == null) goto L126;
        int r146 = UtilityKotlinExtentionsKt.d(r145);
    L127:
        r100.setMargin(r107, 4, r146);
        Integer r147 = r129.g();
        if (r147 == null) goto L130;
        int r148 = UtilityKotlinExtentionsKt.d(r147);
    L131:
        r100.setMargin(r107, 6, r148);
        Integer r149 = r129.g();
        if (r149 == null) goto L134;
        int r150 = UtilityKotlinExtentionsKt.d(r149);
    L135:
        r100.setMargin(r107, 1, r150);
        goto L4
    L134:
        r150 = 0;
        goto L135
    L130:
        r148 = 0;
        goto L131
    L126:
        r146 = 0;
        goto L127
    L122:
        r144 = 0;
        goto L123
    L118:
        r142 = 0;
        goto L119
    L114:
        r140 = 0;
        goto L115
    L92:
        r130 = r110.findViewById(r107);
    L80:
        IPromotionUIConfig.c r151 = r104.b();
        if (r151 == null) goto L87;
        PromotionCardModuleName r152 = r151.a();
        if (r152 == null) goto L87;
        Integer r153 = (Integer) r111.get(r152);
        if (r153 == null) goto L87;
        r100.connect(r107, 4, r153.intValue(), 4);
    L66:
        IPromotionUIConfig.c r154 = r104.b();
        if (r154 == null) goto L73;
        PromotionCardModuleName r155 = r154.p();
        if (r155 == null) goto L73;
        Integer r156 = (Integer) r111.get(r155);
        if (r156 == null) goto L73;
        r100.connect(r107, 3, r156.intValue(), 4);
    L52:
        IPromotionUIConfig.c r157 = r104.b();
        if (r157 == null) goto L59;
        PromotionCardModuleName r158 = r157.o();
        if (r158 == null) goto L59;
        Integer r159 = (Integer) r111.get(r158);
        if (r159 == null) goto L59;
        r100.connect(r107, 7, r159.intValue(), 7);
    L38:
        IPromotionUIConfig.c r160 = r104.b();
        if (r160 == null) goto L45;
        PromotionCardModuleName r161 = r160.e();
        if (r161 == null) goto L45;
        Integer r162 = (Integer) r111.get(r161);
        if (r162 == null) goto L45;
        r100.connect(r107, 6, r162.intValue(), 7);
        goto L45
    L29:
        if (r116.s(r111) != true) goto L31;
        r100.clear(r107, 3);
        r100.clear(r107, 4);
        r100.clear(r107, 6);
        r100.clear(r107, 7);
    L15:
        r113 = true;
        goto L16
    L136:
        r100.applyTo(r110);
        com.bytedance.android.ec.sdk.helper.l.a(new UIConfigHelper$updateUIByLayout$2(r111, r100));
    }
}
