package com.bytedance.android.livesdk.livecommerce.largemode;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.j;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class LargeModeConfigHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f149249a = 0;

    static {
    }

    public static Integer c(LayoutSizeLargeModeConfig r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getType();
    L6:
        if (r101 == null) goto L25;
        int r102 = r101.hashCode();
        if (r102 == (-1019779949)) goto L15;
        if (r102 != (-921832806)) goto L25;
        r101.equals(LayoutSizeLargeModeConfig.TYPE_PERCENTAGE);
        goto L25
    L15:
        if (r101.equals("offset") == false) goto L25;
        Float r103 = Float.valueOf(r100.getValue());
        boolean r104 = false;
        if (r103.floatValue() < 0) goto L19;
        r104 = true;
    L19:
        if (r104 == true) goto L22;
        r103 = null;
    L22:
        if (r103 == null) goto L25;
        return Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(r103.floatValue())));
    L25:
        return null;
    L5:
        r101 = null;
        goto L6
    }

    public static void a(ComponentLargeModeConfig r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$applyConfigToView");
        if (r101 == null) goto L116;
        hi2.a r102 = r100.getTextConfig();
        int r103 = 0;
        ViewGroup.LayoutParams r104 = null;
        if (r102 != null) goto L7;
    L45:
        LayoutLargeModeConfig r105 = r100.getLayoutConfig();
        if (r105 == null) goto L117;
        Integer r106 = c(r105.getWidthConfig());
        Integer r107 = c(r105.getHeightConfig());
        ViewGroup.LayoutParams r108 = r101.getLayoutParams();
        if (r106 == null) goto L50;
        r108.width = r106.intValue();
    L50:
        if (r107 == null) goto L52;
        r108.height = r107.intValue();
    L52:
        r101.setLayoutParams(r108);
        if (r105.getLeftPadding() == null) goto L55;
    L60:
        Integer r109 = r105.getLeftPadding();
        if (r109 == null) goto L63;
        int r110 = UtilityKotlinExtentionsKt.d(r109);
    L64:
        Integer r111 = r105.getTopPadding();
        if (r111 == null) goto L67;
        int r112 = UtilityKotlinExtentionsKt.d(r111);
    L68:
        Integer r113 = r105.getRightPadding();
        if (r113 == null) goto L71;
        int r114 = UtilityKotlinExtentionsKt.d(r113);
    L72:
        Integer r115 = r105.getBottomPadding();
        if (r115 == null) goto L75;
        int r116 = UtilityKotlinExtentionsKt.d(r115);
    L76:
        r101.setPadding(r110, r112, r114, r116);
    L78:
        if (r105.getLeftMargin() == null) goto L80;
    L85:
        Integer r117 = r105.getLeftMargin();
        if (r117 == null) goto L88;
        int r118 = UtilityKotlinExtentionsKt.d(r117);
    L89:
        Integer r119 = r105.getTopMargin();
        if (r119 == null) goto L92;
        int r120 = UtilityKotlinExtentionsKt.d(r119);
    L99:
        Integer r121 = r105.getRightPadding();
        if (r121 == null) goto L102;
        int r122 = UtilityKotlinExtentionsKt.d(r121);
    L103:
        Integer r123 = r105.getBottomMargin();
        if (r123 == null) goto L106;
        int r124 = UtilityKotlinExtentionsKt.d(r123);
    L114:
        wg.a.f(r101, r118, r120, r122, r124);
        return;
    L106:
        Intrinsics.checkNotNullParameter(r101, "$this$layoutMarginBottom");
        ViewGroup.LayoutParams r125 = r101.getLayoutParams();
        if ((r125 instanceof ViewGroup.MarginLayoutParams) == false) goto L110;
        r104 = r125;
    L110:
        ViewGroup.MarginLayoutParams r126 = (ViewGroup.MarginLayoutParams) r104;
        if (r126 == null) goto L113;
        r103 = r126.bottomMargin;
    L113:
        r124 = r103;
        goto L114
    L102:
        r122 = o0.b(r101);
        goto L103
    L92:
        Intrinsics.checkNotNullParameter(r101, "$this$layoutMarginTop");
        ViewGroup.LayoutParams r127 = r101.getLayoutParams();
        if ((r127 instanceof ViewGroup.MarginLayoutParams) == true) goto L95;
        r127 = null;
    L95:
        ViewGroup.MarginLayoutParams r128 = (ViewGroup.MarginLayoutParams) r127;
        if (r128 == null) goto L98;
        r120 = r128.topMargin;
        goto L99
    L98:
        r120 = 0;
        goto L99
    L88:
        r118 = o0.a(r101);
        goto L89
    L80:
        if (r105.getRightMargin() != null) goto L85;
        if (r105.getTopMargin() != null) goto L85;
        if (r105.getBottomMargin() != null) goto L85;
        return;
    L75:
        r116 = r101.getPaddingBottom();
        goto L76
    L71:
        r114 = r101.getPaddingRight();
        goto L72
    L67:
        r112 = r101.getPaddingTop();
        goto L68
    L63:
        r110 = r101.getPaddingLeft();
        goto L64
    L55:
        if (r105.getRightPadding() != null) goto L60;
        if (r105.getTopPadding() != null) goto L60;
        if (r105.getBottomPadding() == null) goto L78;
    L117:
        return;
    L7:
        if ((r101 instanceof TextView) == true) goto L9;
        View r129 = null;
    L10:
        TextView r130 = (TextView) r129;
        if (r130 == null) goto L45;
        Integer r131 = r102.a();
        boolean r132 = true;
        if (r131 == null) goto L23;
        Float r133 = Float.valueOf(r131.intValue());
        if (r133.floatValue() <= 0.0f) goto L17;
        boolean r134 = true;
    L18:
        if (r134 == true) goto L21;
        r133 = null;
    L21:
        if (r133 == null) goto L23;
        r130.setTextSize(1, r133.floatValue());
        goto L23
    L17:
        r134 = false;
    L23:
        Integer r135 = r102.b();
        if (r135 != null) goto L26;
    L34:
        Float r136 = r102.c();
        if (r136 == null) goto L45;
        if (r136.floatValue() > 0) goto L40;
        r132 = false;
    L40:
        if (r132 == true) goto L43;
        r136 = null;
    L43:
        if (r136 == null) goto L45;
        r130.setLineSpacing(UtilityKotlinExtentionsKt.c(Float.valueOf(r136.floatValue())), 1.0f);
        goto L45
    L26:
        if (r135.intValue() <= 0) goto L28;
        boolean r137 = true;
    L29:
        if (r137 == true) goto L32;
        r135 = null;
    L32:
        if (r135 == null) goto L34;
        c0.b(r130, r135.intValue());
        goto L34
    L28:
        r137 = false;
        goto L29
    L9:
        r129 = r101;
        goto L10
    }

    public static void b(ComponentLargeModeConfig r100, j r101, PromotionCardModuleName r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$applyToFactory");
        Intrinsics.checkNotNullParameter(r101, "factory");
        Intrinsics.checkNotNullParameter(r102, TextureRenderKeys.KEY_MODULE_NAME);
        final LayoutLargeModeConfig r103 = r100.getLayoutConfig();
        if (r103 == null) goto L5;
        r101.a(r102, new LargeModeConfigHelper$applyToFactory$1$1(r103));
    L5:
        final hi2.a r104 = r100.getTextConfig();
        if (r104 == null) goto L8;
        r101.a(r102, new LargeModeConfigHelper$applyToFactory$2$1(r104));
    L8:
        LayoutLargeModeConfig r105 = r100.getLayoutConfig();
        boolean r106 = true;
        Float r107 = null;
        if (r105 == null) goto L21;
        Integer r108 = r105.getRadius();
        if (r108 == null) goto L21;
        if (r108.intValue() < 0) goto L15;
        boolean r109 = true;
    L16:
        if (r109 == true) goto L19;
        r108 = null;
    L19:
        if (r108 == null) goto L21;
        final int r110 = r108.intValue();
        r101.a(r102, new LargeModeConfigHelper$applyToFactory$4$1(r110));
        goto L21
    L15:
        r109 = false;
    L21:
        LayoutLargeModeConfig r111 = r100.getLayoutConfig();
        if (r111 == null) goto L36;
        Float r112 = r111.getDrawableScale();
        if (r112 == null) goto L37;
        float r113 = r112.floatValue();
        if (r113 > 0) goto L28;
    L30:
        r106 = false;
    L31:
        if (r106 == false) goto L33;
        r107 = r112;
    L33:
        if (r107 == null) goto L38;
        final float r114 = r107.floatValue();
        r101.a(r102, new LargeModeConfigHelper$applyToFactory$6$1(r114));
        return;
    L38:
        return;
    L28:
        if (r113 == 1.0f) goto L30;
    L37:
        return;
    }
}
