package com.obric.oui.material;

import android.content.res.ColorStateList;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.oui.blur.BlurConfig;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.fluid.FluidConfig;
import com.obric.oui.res.BlendConfigStateList;
import com.obric.oui.res.StrokeStateList;
import com.obric.oui.shadow.ShadowConfig;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialConfigFormatBuilders.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001b\u0010\b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0007¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J3\u0010\u0010\u001a\u00020\u0011*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0014\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00150\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u00020\u0011*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u001a\u001a\u00020\u0011*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010\u001d\u001a\u00020\u0011*\u00060\u0012j\u0002`\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010 \u001a\u00020\u0011*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010#\u001a\u00020\u0011*\u00060\u0012j\u0002`\u00132\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010&\u001a\u00020\u0011*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J+\u0010'\u001a\u00020\u0011*\u00060\u0012j\u0002`\u00132\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010*J(\u0010+\u001a\u00020\u0011*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010.\u001a\u00020\u0011*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020/2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/oui/material/MaterialXmlBuilder;", "", "()V", "INDENT", "", "build", "config", "Lcom/obric/oui/material/MaterialConfig;", "buildArray", Constants.KEY_CONFIG, "", "([Lcom/obric/oui/material/MaterialConfig;)Ljava/lang/String;", "buildToken", "tokenName", "isLight", "", "appendBlendArray", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "tagName", "Lcom/obric/oui/color/BlendConfig;", "level", "", "(Ljava/lang/StringBuilder;Ljava/lang/String;[Lcom/obric/oui/color/BlendConfig;I)V", "appendBlendItem", "appendBlendStateList", "stateList", "Lcom/obric/oui/res/BlendConfigStateList;", "appendBlurConfig", "blur", "Lcom/obric/oui/blur/BlurConfig;", "appendColorStateList", "colors", "Landroid/content/res/ColorStateList;", "appendFluidConfig", MaterialConfigFormatNames.FLUID, "Lcom/obric/oui/fluid/FluidConfig;", "appendMaterialConfig", "appendShadowArray", MaterialConfigFormatNames.SHADOWS, "Lcom/obric/oui/shadow/ShadowConfig;", "(Ljava/lang/StringBuilder;[Lcom/obric/oui/shadow/ShadowConfig;I)V", "appendStroke", MaterialConfigFormatNames.STROKE, "Lcom/obric/oui/color/StrokeConfig;", "appendStrokeStateList", "Lcom/obric/oui/res/StrokeStateList;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialXmlBuilder {
    private static final String INDENT = "    ";
    public static final MaterialXmlBuilder INSTANCE = null;

    static {
        INSTANCE = new MaterialXmlBuilder();
    }

    @JvmStatic
    public static final String buildToken(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tokenName");
        return buildToken$default(r3, false, 2, null);
    }

    private MaterialXmlBuilder() {
    }

    @JvmStatic
    public static final String build(MaterialConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        StringBuilder r0 = new StringBuilder();
        INSTANCE.appendMaterialConfig(r0, r3, 0);
        String r4 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "StringBuilder().apply(builderAction).toString()");
        return r4;
    }

    @JvmStatic
    public static final String buildArray(MaterialConfig[] r7) {
        Intrinsics.checkNotNullParameter(r7, Constants.KEY_CONFIG);
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = r0.append("<material_configs");
        Intrinsics.checkNotNullExpressionValue(r1, "append('<').append(Mater…es.ROOT_MATERIAL_CONFIGS)");
        StringBuilder r2 = r1.append('>');
        Intrinsics.checkNotNullExpressionValue(r2, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r2.append('\n'), "append('\\n')");
        int r3 = r7.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        MaterialConfig r5 = r7[r4];
        INSTANCE.appendMaterialConfig(r0, r5, 1);
        r4 = r4 + 1;
        goto L3
    L5:
        r0.append("</").append(MaterialConfigFormatNames.ROOT_MATERIAL_CONFIGS).append('>');
        String r8 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r8, "StringBuilder().apply(builderAction).toString()");
        return r8;
    }

    public static /* synthetic */ String buildToken$default(String r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = true;
    L6:
        return buildToken(r0, r1);
    }

    @JvmStatic
    public static final String buildToken(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "tokenName");
        MaterialConfig[] r3 = MaterialToken.INSTANCE.resolveTokenForBuilder$OUI_standardRelease(r1, r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        if (r3.length != 1) goto L10;
        return build(r3[0]);
    L10:
        return buildArray(r3);
    }

    private final void appendMaterialConfig(StringBuilder r9, MaterialConfig r10, int r11) {
        Unit r0 = null;
        if (r10.getBlurConfig() != null) goto L5;
        Float r8 = r10.getBlurRadius();
    L6:
        r9.append(MaterialConfigFormatBuildersKt.access$indent(r11)).append('<').append(MaterialConfigFormatNames.ROOT_MATERIAL_CONFIG);
        if (r8 == null) goto L10;
        r9.append(' ').append(MaterialConfigFormatNames.BLUR_RADIUS).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r8.floatValue())).append("\"");
    L10:
        StringBuilder r12 = r9.append(">");
        Intrinsics.checkNotNullExpressionValue(r12, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r12.append('\n'), "append('\\n')");
        ColorStateList r13 = r10.getFallbackBgColor();
        if (r13 == null) goto L14;
        INSTANCE.appendColorStateList(r9, MaterialConfigFormatNames.FALLBACK_BG_COLOR, r13, r11 + 1);
    L14:
        BlendConfigStateList r14 = r10.getBlendConfigStateList();
        if (r14 != null) goto L17;
        Unit r15 = null;
    L18:
        if (r15 != null) goto L23;
        BlendConfig[] r16 = r10.getBlendConfig();
        if (r16 == null) goto L23;
        INSTANCE.appendBlendArray(r9, MaterialConfigFormatNames.BLEND_CONFIG, r16, r11 + 1);
    L23:
        BlendConfigStateList r17 = r10.getOverlayBlendConfigStateList();
        if (r17 == null) goto L27;
        INSTANCE.appendBlendStateList(r9, MaterialConfigFormatNames.OVERLAY_BLEND_CONFIGS, r17, r11 + 1);
    L27:
        StrokeStateList r18 = r10.getStrokeStateList();
        if (r18 == null) goto L31;
        INSTANCE.appendStrokeStateList(r9, MaterialConfigFormatNames.STROKE_STATE_LIST, r18, r11 + 1);
        r0 = Unit.INSTANCE;
    L31:
        if (r0 != null) goto L36;
        StrokeConfig r19 = r10.getStroke();
        if (r19 == null) goto L36;
        INSTANCE.appendStroke(r9, MaterialConfigFormatNames.STROKE, r19, r11 + 1);
    L36:
        BlurConfig r20 = r10.getBlurConfig();
        if (r20 == null) goto L40;
        INSTANCE.appendBlurConfig(r9, r20, r11 + 1);
    L40:
        ShadowConfig[] r21 = r10.getShadow();
        if (r21 == null) goto L44;
        INSTANCE.appendShadowArray(r9, r21, r11 + 1);
    L44:
        FluidConfig r22 = r10.getFluid();
        if (r22 == null) goto L48;
        INSTANCE.appendFluidConfig(r9, r22, r11 + 1);
    L48:
        StringBuilder r23 = r9.append(MaterialConfigFormatBuildersKt.access$indent(r11)).append("</").append(MaterialConfigFormatNames.ROOT_MATERIAL_CONFIG);
        Intrinsics.checkNotNullExpressionValue(r23, "append(indent(level)).ap…mes.ROOT_MATERIAL_CONFIG)");
        StringBuilder r24 = r23.append('>');
        Intrinsics.checkNotNullExpressionValue(r24, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r24.append('\n'), "append('\\n')");
        return;
    L17:
        INSTANCE.appendBlendStateList(r9, MaterialConfigFormatNames.BLEND_CONFIGS, r14, r11 + 1);
        r15 = Unit.INSTANCE;
        goto L18
    L5:
        r8 = null;
        goto L6
    }

    private final void appendColorStateList(StringBuilder r9, String r10, ColorStateList r11, int r12) {
        StringBuilder r8 = r9.append(MaterialConfigFormatBuildersKt.access$indent(r12)).append('<').append(r10);
        Intrinsics.checkNotNullExpressionValue(r8, "append(indent(level)).append('<').append(tagName)");
        StringBuilder r13 = r8.append('>');
        Intrinsics.checkNotNullExpressionValue(r13, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r13.append('\n'), "append('\\n')");
        Iterator r14 = MaterialConfigFormatBuildersKt.access$getMATERIAL_STATES$p().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        MaterialOutputState r5 = (MaterialOutputState) r14.next();
        StringBuilder r6 = r9.append(MaterialConfigFormatBuildersKt.access$indent(r12 + 1)).append('<').append(r5.getXmlName()).append(' ').append("color").append("=\"").append(MaterialConfigFormatBuildersKt.access$formatColor(r11.getColorForState(r5.getStateSet(), r11.getDefaultColor()))).append("\" />");
        Intrinsics.checkNotNullExpressionValue(r6, "append(indent(level + 1)…tColor))).append(\"\\\" />\")");
        Intrinsics.checkNotNullExpressionValue(r6.append('\n'), "append('\\n')");
        goto L4
    L6:
        StringBuilder r15 = r9.append(MaterialConfigFormatBuildersKt.access$indent(r12)).append("</").append(r10);
        Intrinsics.checkNotNullExpressionValue(r15, "append(indent(level)).append(\"</\").append(tagName)");
        StringBuilder r16 = r15.append('>');
        Intrinsics.checkNotNullExpressionValue(r16, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r16.append('\n'), "append('\\n')");
    }

    private final void appendBlendStateList(StringBuilder r17, String r18, BlendConfigStateList r19, int r20) {
        char r3 = '<';
        StringBuilder r2 = r17.append(MaterialConfigFormatBuildersKt.access$indent(r20)).append('<').append(r18);
        Intrinsics.checkNotNullExpressionValue(r2, "append(indent(level)).append('<').append(tagName)");
        StringBuilder r4 = r2.append('>');
        Intrinsics.checkNotNullExpressionValue(r4, "append(value)");
        char r6 = '\n';
        Intrinsics.checkNotNullExpressionValue(r4.append('\n'), "append('\\n')");
        Iterator r5 = MaterialConfigFormatBuildersKt.access$getMATERIAL_STATES$p().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        MaterialOutputState r8 = (MaterialOutputState) r5.next();
        int r10 = r20 + 1;
        StringBuilder r11 = r17.append(MaterialConfigFormatBuildersKt.access$indent(r10)).append(r3).append(r8.getXmlName());
        Intrinsics.checkNotNullExpressionValue(r11, "append(indent(level + 1)…<').append(state.xmlName)");
        StringBuilder r12 = r11.append('>');
        Intrinsics.checkNotNullExpressionValue(r12, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r12.append(r6), "append('\\n')");
        BlendConfig[] r13 = BlendConfigStateList.getConfigForState$default(r19, r8.getStateSet(), null, 2, null);
        int r14 = r13.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L8;
        BlendConfig r16 = r13[r15];
        INSTANCE.appendBlendItem(r17, r16, r20 + 2);
        r15 = r15 + 1;
        goto L6
    L8:
        StringBuilder r7 = r17.append(MaterialConfigFormatBuildersKt.access$indent(r10)).append("</").append(r8.getXmlName());
        Intrinsics.checkNotNullExpressionValue(r7, "append(indent(level + 1)…/\").append(state.xmlName)");
        StringBuilder r9 = r7.append('>');
        Intrinsics.checkNotNullExpressionValue(r9, "append(value)");
        r6 = '\n';
        Intrinsics.checkNotNullExpressionValue(r9.append('\n'), "append('\\n')");
        r3 = '<';
        goto L4
    L9:
        StringBuilder r0 = r17.append(MaterialConfigFormatBuildersKt.access$indent(r20)).append("</").append(r18);
        Intrinsics.checkNotNullExpressionValue(r0, "append(indent(level)).append(\"</\").append(tagName)");
        StringBuilder r1 = r0.append('>');
        Intrinsics.checkNotNullExpressionValue(r1, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r1.append(r6), "append('\\n')");
    }

    private final void appendBlendArray(StringBuilder r9, String r10, BlendConfig[] r11, int r12) {
        StringBuilder r8 = r9.append(MaterialConfigFormatBuildersKt.access$indent(r12)).append('<').append(r10);
        Intrinsics.checkNotNullExpressionValue(r8, "append(indent(level)).append('<').append(tagName)");
        StringBuilder r13 = r8.append('>');
        Intrinsics.checkNotNullExpressionValue(r13, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r13.append('\n'), "append('\\n')");
        int r14 = r11.length;
        int r4 = 0;
    L3:
        if (r4 >= r14) goto L5;
        BlendConfig r5 = r11[r4];
        INSTANCE.appendBlendItem(r9, r5, r12 + 1);
        r4 = r4 + 1;
        goto L3
    L5:
        StringBuilder r15 = r9.append(MaterialConfigFormatBuildersKt.access$indent(r12)).append("</").append(r10);
        Intrinsics.checkNotNullExpressionValue(r15, "append(indent(level)).append(\"</\").append(tagName)");
        StringBuilder r16 = r15.append('>');
        Intrinsics.checkNotNullExpressionValue(r16, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r16.append('\n'), "append('\\n')");
    }

    private final void appendBlendItem(StringBuilder r1, BlendConfig r2, int r3) {
        StringBuilder r0 = r1.append(MaterialConfigFormatBuildersKt.access$indent(r3)).append('<').append(MaterialConfigFormatNames.BLEND_CONFIG).append(' ').append("color").append("=\"").append(MaterialConfigFormatBuildersKt.access$formatColor(r2.getColor())).append("\" ").append(MaterialConfigFormatNames.BLEND_MODE).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatBlendMode(r2.getBlendMode()));
        Intrinsics.checkNotNullExpressionValue(r0, "append(indent(level))\n  …ndMode(config.blendMode))");
        StringBuilder r4 = r0.append("\" />");
        Intrinsics.checkNotNullExpressionValue(r4, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r4.append('\n'), "append('\\n')");
    }

    private final void appendStrokeStateList(StringBuilder r17, String r18, StrokeStateList r19, int r20) {
        StringBuilder r2 = r17.append(MaterialConfigFormatBuildersKt.access$indent(r20)).append('<').append(r18);
        Intrinsics.checkNotNullExpressionValue(r2, "append(indent(level)).append('<').append(tagName)");
        StringBuilder r3 = r2.append('>');
        Intrinsics.checkNotNullExpressionValue(r3, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r3.append('\n'), "append('\\n')");
        Iterator r4 = MaterialConfigFormatBuildersKt.access$getMATERIAL_STATES$p().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        MaterialOutputState r8 = (MaterialOutputState) r4.next();
        int r10 = r20 + 1;
        StringBuilder r11 = r17.append(MaterialConfigFormatBuildersKt.access$indent(r10)).append('<').append(r8.getXmlName());
        Intrinsics.checkNotNullExpressionValue(r11, "append(indent(level + 1)…<').append(state.xmlName)");
        StringBuilder r12 = r11.append('>');
        Intrinsics.checkNotNullExpressionValue(r12, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r12.append('\n'), "append('\\n')");
        StrokeConfig r13 = StrokeStateList.getConfigForState$default(r19, r8.getStateSet(), null, 2, null);
        if (r13 == null) goto L9;
        INSTANCE.appendStroke(r17, MaterialConfigFormatNames.STROKE, r13, r20 + 2);
    L9:
        StringBuilder r9 = r17.append(MaterialConfigFormatBuildersKt.access$indent(r10)).append("</").append(r8.getXmlName());
        Intrinsics.checkNotNullExpressionValue(r9, "append(indent(level + 1)…/\").append(state.xmlName)");
        StringBuilder r14 = r9.append('>');
        Intrinsics.checkNotNullExpressionValue(r14, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r14.append('\n'), "append('\\n')");
        goto L4
    L10:
        StringBuilder r0 = r17.append(MaterialConfigFormatBuildersKt.access$indent(r20)).append("</").append(r18);
        Intrinsics.checkNotNullExpressionValue(r0, "append(indent(level)).append(\"</\").append(tagName)");
        StringBuilder r1 = r0.append('>');
        Intrinsics.checkNotNullExpressionValue(r1, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r1.append('\n'), "append('\\n')");
    }

    private final void appendStroke(StringBuilder r1, String r2, StrokeConfig r3, int r4) {
        StringBuilder r0 = r1.append(MaterialConfigFormatBuildersKt.access$indent(r4)).append('<').append(r2).append(' ').append(MaterialConfigFormatNames.WIDTH).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r3.getWidth())).append("\" ").append("color").append("=\"").append(MaterialConfigFormatBuildersKt.access$formatColor(r3.getColor())).append("\" ").append(MaterialConfigFormatNames.BLEND_MODE).append("=\"").append(r3.getBlendMode().name());
        Intrinsics.checkNotNullExpressionValue(r0, "append(indent(level))\n  …nd(stroke.blendMode.name)");
        StringBuilder r5 = r0.append("\" />");
        Intrinsics.checkNotNullExpressionValue(r5, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r5.append('\n'), "append('\\n')");
    }

    private final void appendBlurConfig(StringBuilder r2, BlurConfig r3, int r4) {
        StringBuilder r1 = r2.append(MaterialConfigFormatBuildersKt.access$indent(r4)).append('<').append(MaterialConfigFormatNames.BLUR_CONFIG).append(' ').append(MaterialConfigFormatNames.BLUR_RADIUS).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r3.getBlurRadius())).append("\" ").append(MaterialConfigFormatNames.DIRECTION).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatBlurDirection(r3.getDirection())).append("\" ").append("alpha").append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r3.getAlpha())).append("\" ").append(MaterialConfigFormatNames.CURVE_TYPE).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatCurveType(r3.getCurveType())).append("\" ").append(MaterialConfigFormatNames.END_POINT).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r3.getEndPoint()));
        Intrinsics.checkNotNullExpressionValue(r1, "append(indent(level))\n  …rmatFloat(blur.endPoint))");
        StringBuilder r5 = r1.append("\" />");
        Intrinsics.checkNotNullExpressionValue(r5, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r5.append('\n'), "append('\\n')");
    }

    private final void appendShadowArray(StringBuilder r17, ShadowConfig[] r18, int r19) {
        StringBuilder r2 = r17.append(MaterialConfigFormatBuildersKt.access$indent(r19)).append('<').append(MaterialConfigFormatNames.SHADOWS);
        Intrinsics.checkNotNullExpressionValue(r2, "append(indent(level)).ap…onfigFormatNames.SHADOWS)");
        StringBuilder r3 = r2.append('>');
        Intrinsics.checkNotNullExpressionValue(r3, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r3.append('\n'), "append('\\n')");
        int r4 = r18.length;
        int r10 = 0;
    L3:
        if (r10 >= r4) goto L5;
        ShadowConfig r11 = r18[r10];
        StringBuilder r12 = r17.append(MaterialConfigFormatBuildersKt.access$indent(r19 + 1)).append('<').append(MaterialConfigFormatNames.SHADOW).append(' ').append(MaterialConfigFormatNames.X).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r11.getX())).append("\" ").append(MaterialConfigFormatNames.Y).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r11.getY())).append("\" ").append(MaterialConfigFormatNames.BLUR_RADIUS).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r11.getBlurRadius())).append("\" ").append("color").append("=\"").append(MaterialConfigFormatBuildersKt.access$formatColor(r11.getColor())).append("\" ").append(MaterialConfigFormatNames.SPREAD).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r11.getSpread())).append("\" ").append(MaterialConfigFormatNames.BLEND_MODE).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatBlendMode(r11.getBlendMode()));
        Intrinsics.checkNotNullExpressionValue(r12, "append(indent(level + 1)…ndMode(shadow.blendMode))");
        StringBuilder r13 = r12.append("\" />");
        Intrinsics.checkNotNullExpressionValue(r13, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r13.append('\n'), "append('\\n')");
        r10 = r10 + 1;
        goto L3
    L5:
        StringBuilder r0 = r17.append(MaterialConfigFormatBuildersKt.access$indent(r19)).append("</").append(MaterialConfigFormatNames.SHADOWS);
        Intrinsics.checkNotNullExpressionValue(r0, "append(indent(level)).ap…onfigFormatNames.SHADOWS)");
        StringBuilder r1 = r0.append('>');
        Intrinsics.checkNotNullExpressionValue(r1, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r1.append('\n'), "append('\\n')");
    }

    private final void appendFluidConfig(StringBuilder r4, FluidConfig r5, int r6) {
        float[] r3 = r5.getGlassParams();
        if (r3 != null) goto L5;
        return;
    L5:
        r4.append(MaterialConfigFormatBuildersKt.access$indent(r6)).append('<').append(MaterialConfigFormatNames.FLUID).append(' ').append(MaterialConfigFormatNames.REFRACTION_HEIGHT).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r3[0])).append("\" ").append(MaterialConfigFormatNames.REFRACTION_STRENGTH).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r3[1])).append("\" ").append(MaterialConfigFormatNames.HIGHLIGHT_ANGLE).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r3[2])).append("\" ").append(MaterialConfigFormatNames.HIGHLIGHT_FALLOFF).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r3[3])).append("\" ").append(MaterialConfigFormatNames.HIGHLIGHT_WIDTH).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r3[4])).append("\" ").append(MaterialConfigFormatNames.HIGHLIGHT_ALPHA).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r3[5])).append("\" ").append(MaterialConfigFormatNames.HIGHLIGHT_INSET).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r3[6])).append("\" ").append(MaterialConfigFormatNames.HIGHLIGHT_STRENGTH).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r3[7]));
        if (r3.length < 13) goto L8;
        r4.append("\" ").append(MaterialConfigFormatNames.FIRST_LAYER_HIGHLIGHT_COLOR).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatColor(Float.floatToRawIntBits(r3[8]))).append("\" ").append(MaterialConfigFormatNames.FIRST_LAYER_HIGHLIGHT_BLEND_MODE).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatBlendMode((int) r3[9])).append("\" ").append(MaterialConfigFormatNames.SECOND_LAYER_HIGHLIGHT_COLOR).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatColor(Float.floatToRawIntBits(r3[10]))).append("\" ").append(MaterialConfigFormatNames.SECOND_LAYER_HIGHLIGHT_BLEND_MODE).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatBlendMode((int) r3[11])).append("\" ").append(MaterialConfigFormatNames.CHROMATIC_ABERRATION).append("=\"").append(MaterialConfigFormatBuildersKt.access$formatFloat(r3[12]));
    L8:
        StringBuilder r7 = r4.append("\" />");
        Intrinsics.checkNotNullExpressionValue(r7, "append(value)");
        Intrinsics.checkNotNullExpressionValue(r7.append('\n'), "append('\\n')");
    }
}
