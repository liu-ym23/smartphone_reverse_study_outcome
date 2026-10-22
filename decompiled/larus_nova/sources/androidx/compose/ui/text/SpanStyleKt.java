package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\n\u001a\u0002H\u00112\u0006\u0010\u000b\u001a\u0002H\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0000¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\r\u001a&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\rH\u0002\u001a\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u0000\u001a½\u0001\u0010\u001c\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u00010\u00192\b\u00109\u001a\u0004\u0018\u00010:H\u0000¢\u0006\u0004\b;\u0010<\u001a\u0018\u0010=\u001a\u0004\u0018\u00010\u0019*\u00020\u00152\b\u0010>\u001a\u0004\u0018\u00010\u0019H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "J", "DefaultLetterSpacing", "DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "DefaultColor", "DefaultColorForegroundStyle", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "lerpTextUnitInheritable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "t", "", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "lerpDiscrete", ExifInterface.GPS_DIRECTION_TRUE, "fraction", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "resolveSpanStyleDefaults", "style", "fastMerge", "color", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "fontSize", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "Landroidx/compose/ui/graphics/Shadow;", "platformStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "fastMerge-dSHsh3o", "(Landroidx/compose/ui/text/SpanStyle;JLandroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "mergePlatformStyle", "other", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SpanStyleKt {
    private static final long DefaultBackgroundColor = 0;
    private static final long DefaultColor = 0;
    private static final TextForegroundStyle DefaultColorForegroundStyle = null;
    private static final long DefaultFontSize = 0;
    private static final long DefaultLetterSpacing = 0;

    public static /* synthetic */ TextForegroundStyle a() {
        return resolveSpanStyleDefaults$lambda$0();
    }

    public static final <T> T lerpDiscrete(T r100, T r101, float r102) {
        if (r102 >= 0.5d) goto L6;
        return r100;
    L6:
        return r101;
    }

    static {
        DefaultFontSize = TextUnitKt.getSp(14);
        DefaultLetterSpacing = TextUnitKt.getSp(0);
        Color.Companion r100 = Color.Companion;
        DefaultBackgroundColor = r100.m4862getTransparent0d7_KjU();
        long r101 = r100.m4853getBlack0d7_KjU();
        DefaultColor = r101;
        DefaultColorForegroundStyle = TextForegroundStyle.Companion.m7439from8_81llA(r101);
    }

    private static final TextForegroundStyle resolveSpanStyleDefaults$lambda$0() {
        return DefaultColorForegroundStyle;
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle r210) {
        TextForegroundStyle r100 = r210.getTextForegroundStyle$ui_text().takeOrElse(new k1());
        boolean r101 = true;
        if (TextUnit.m7740getRawTypeimpl(r210.m6940getFontSizeXSAIIZE()) != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        long r103 = DefaultFontSize;
    L9:
        FontWeight r104 = r210.getFontWeight();
        if (r104 != null) goto L12;
        r104 = FontWeight.Companion.getNormal();
    L12:
        FontStyle r105 = r210.m6941getFontStyle4Lr2A7w();
        if (r105 == null) goto L15;
        int r106 = r105.m7115unboximpl();
    L16:
        FontStyle r107 = FontStyle.m7109boximpl(r106);
        FontSynthesis r108 = r210.m6942getFontSynthesisZQGJjVo();
        if (r108 == null) goto L19;
        int r109 = r108.m7128unboximpl();
    L20:
        FontSynthesis r110 = FontSynthesis.m7120boximpl(r109);
        FontFamily r111 = r210.getFontFamily();
        if (r111 != null) goto L23;
        r111 = FontFamily.Companion.getDefault();
    L23:
        String r112 = r210.getFontFeatureSettings();
        if (r112 != null) goto L27;
        r112 = "";
    L27:
        if (TextUnit.m7740getRawTypeimpl(r210.m6943getLetterSpacingXSAIIZE()) != 0) goto L29;
        boolean r113 = true;
    L30:
        if (r113 == false) goto L32;
        long r114 = DefaultLetterSpacing;
    L33:
        long r115 = r114;
        BaselineShift r116 = r210.m6938getBaselineShift5SSeXJ0();
        if (r116 == null) goto L36;
        float r117 = r116.m7296unboximpl();
    L37:
        BaselineShift r118 = BaselineShift.m7290boximpl(r117);
        TextGeometricTransform r119 = r210.getTextGeometricTransform();
        if (r119 != null) goto L40;
        r119 = TextGeometricTransform.Companion.getNone$ui_text();
    L40:
        TextGeometricTransform r120 = r119;
        LocaleList r121 = r210.getLocaleList();
        if (r121 != null) goto L43;
        r121 = LocaleList.Companion.getCurrent();
    L43:
        LocaleList r122 = r121;
        long r123 = r210.m6937getBackground0d7_KjU();
        if (r123 != 16) goto L47;
        r101 = false;
    L47:
        if (r101 == false) goto L49;
        long r124 = r123;
    L50:
        TextDecoration r125 = r210.getTextDecoration();
        if (r125 != null) goto L53;
        r125 = TextDecoration.Companion.getNone();
    L53:
        TextDecoration r126 = r125;
        Shadow r127 = r210.getShadow();
        if (r127 != null) goto L56;
        r127 = Shadow.Companion.getNone();
    L56:
        Shadow r211 = r127;
        PlatformSpanStyle r212 = r210.getPlatformStyle();
        DrawStyle r128 = r210.getDrawStyle();
        if (r128 != null) goto L59;
        r128 = Fill.INSTANCE;
    L59:
        long r129 = r103;
        FontWeight r130 = r104;
        FontFamily r131 = r111;
        String r132 = r112;
        long r133 = r124;
        return new SpanStyle(r100, r129, r130, r107, r110, r131, r132, r115, r118, r120, r122, r133, r126, r211, r212, r128, null);
    L49:
        r124 = DefaultBackgroundColor;
        goto L50
    L36:
        r117 = BaselineShift.Companion.m7300getNoney9eOQZs();
        goto L37
    L32:
        r114 = r210.m6943getLetterSpacingXSAIIZE();
        goto L33
    L29:
        r113 = false;
        goto L30
    L19:
        r109 = FontSynthesis.Companion.m7129getAllGVVA2EU();
        goto L20
    L15:
        r106 = FontStyle.Companion.m7119getNormal_LCdwA();
        goto L16
    L8:
        r103 = r210.m6940getFontSizeXSAIIZE();
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle r100, PlatformSpanStyle r101) {
        if (r100.getPlatformStyle() != null) goto L5;
        return r101;
    L5:
        if (r101 != null) goto L9;
        return r100.getPlatformStyle();
    L9:
        return r100.getPlatformStyle().merge(r101);
    }

    public static final SpanStyle lerp(SpanStyle r210, SpanStyle r211, float r310) {
        TextForegroundStyle r100 = TextDrawStyleKt.lerp(r210.getTextForegroundStyle$ui_text(), r211.getTextForegroundStyle$ui_text(), r310);
        FontFamily r110 = (FontFamily) lerpDiscrete(r210.getFontFamily(), r211.getFontFamily(), r310);
        long r101 = m6945lerpTextUnitInheritableC3pnCVY(r210.m6940getFontSizeXSAIIZE(), r211.m6940getFontSizeXSAIIZE(), r310);
        FontWeight r102 = r210.getFontWeight();
        if (r102 != null) goto L5;
        r102 = FontWeight.Companion.getNormal();
    L5:
        FontWeight r103 = r211.getFontWeight();
        if (r103 != null) goto L8;
        r103 = FontWeight.Companion.getNormal();
    L8:
        FontWeight r104 = FontWeightKt.lerp(r102, r103, r310);
        FontStyle r105 = (FontStyle) lerpDiscrete(r210.m6941getFontStyle4Lr2A7w(), r211.m6941getFontStyle4Lr2A7w(), r310);
        FontSynthesis r106 = (FontSynthesis) lerpDiscrete(r210.m6942getFontSynthesisZQGJjVo(), r211.m6942getFontSynthesisZQGJjVo(), r310);
        String r111 = (String) lerpDiscrete(r210.getFontFeatureSettings(), r211.getFontFeatureSettings(), r310);
        long r112 = m6945lerpTextUnitInheritableC3pnCVY(r210.m6943getLetterSpacingXSAIIZE(), r211.m6943getLetterSpacingXSAIIZE(), r310);
        BaselineShift r107 = r210.m6938getBaselineShift5SSeXJ0();
        if (r107 == null) goto L11;
        float r108 = r107.m7296unboximpl();
    L12:
        BaselineShift r109 = r211.m6938getBaselineShift5SSeXJ0();
        if (r109 == null) goto L15;
        float r113 = r109.m7296unboximpl();
    L16:
        float r114 = BaselineShiftKt.m7303lerpjWV1Mfo(r108, r113, r310);
        TextGeometricTransform r115 = r210.getTextGeometricTransform();
        if (r115 != null) goto L19;
        r115 = TextGeometricTransform.Companion.getNone$ui_text();
    L19:
        TextGeometricTransform r116 = r211.getTextGeometricTransform();
        if (r116 != null) goto L22;
        r116 = TextGeometricTransform.Companion.getNone$ui_text();
    L22:
        TextGeometricTransform r117 = TextGeometricTransformKt.lerp(r115, r116, r310);
        LocaleList r118 = (LocaleList) lerpDiscrete(r210.getLocaleList(), r211.getLocaleList(), r310);
        long r119 = ColorKt.m4878lerpjxsXWHM(r210.m6937getBackground0d7_KjU(), r211.m6937getBackground0d7_KjU(), r310);
        TextDecoration r120 = (TextDecoration) lerpDiscrete(r210.getTextDecoration(), r211.getTextDecoration(), r310);
        Shadow r121 = r210.getShadow();
        if (r121 != null) goto L25;
        r121 = new Shadow(0, 0, 0.0f, 7, null);
    L25:
        Shadow r122 = r211.getShadow();
        if (r122 != null) goto L28;
        r122 = new Shadow(0, 0, 0.0f, 7, null);
    L28:
        Shadow r212 = ShadowKt.lerp(r121, r122, r310);
        PlatformSpanStyle r213 = lerpPlatformStyle(r210.getPlatformStyle(), r211.getPlatformStyle(), r310);
        DrawStyle r214 = (DrawStyle) lerpDiscrete(r210.getDrawStyle(), r211.getDrawStyle(), r310);
        return new SpanStyle(r100, r101, r104, r105, r106, r110, r111, r112, BaselineShift.m7290boximpl(r114), r117, r118, r119, r120, r212, r213, r214, null);
    L15:
        r113 = BaselineShift.m7291constructorimpl(0.0f);
        goto L16
    L11:
        r108 = BaselineShift.m7291constructorimpl(0.0f);
        goto L12
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle r100, PlatformSpanStyle r101, float r102) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100 != null) goto L8;
        r100 = PlatformSpanStyle.Companion.getDefault();
    L8:
        if (r101 != null) goto L11;
        r101 = PlatformSpanStyle.Companion.getDefault();
    L11:
        return AndroidTextStyle_androidKt.lerp(r100, r101, r102);
    }

    /* JADX INFO: renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m6945lerpTextUnitInheritableC3pnCVY(long r100, long r101, float r110) {
        boolean r102 = true;
        if (TextUnit.m7740getRawTypeimpl(r100) != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L16;
        if (TextUnit.m7740getRawTypeimpl(r101) == 0) goto L11;
        r102 = false;
    L11:
        if (r102 == true) goto L16;
        return TextUnitKt.m7762lerpC3pnCVY(r100, r101, r110);
    L16:
        return ((TextUnit) lerpDiscrete(TextUnit.m7732boximpl(r100), TextUnit.m7732boximpl(r101), r110)).m7751unboximpl();
    L5:
        r103 = false;
        goto L6
    }

    /* JADX INFO: renamed from: fastMerge-dSHsh3o, reason: not valid java name */
    public static final SpanStyle m6944fastMergedSHsh3o(SpanStyle r210, long r211, Brush r212, float r213, long r214, FontWeight r310, FontStyle r311, FontSynthesis r312, FontFamily r313, String r314, long r315, BaselineShift r316, TextGeometricTransform r317, LocaleList r410, long r411, TextDecoration r412, Shadow r413, PlatformSpanStyle r414, DrawStyle r415) {
        FontWeight r100 = r310;
        FontStyle r101 = r311;
        FontSynthesis r102 = r312;
        String r103 = r314;
        BaselineShift r110 = r316;
        boolean r111 = false;
        if (TextUnit.m7740getRawTypeimpl(r214) != 0) goto L5;
        boolean r112 = true;
    L7:
        if ((!r112) == false) goto L16;
        if (TextUnit.m7739equalsimpl0(r214, r210.m6940getFontSizeXSAIIZE()) == true) goto L16;
    L11:
        TextGeometricTransform r113 = r317;
    L12:
        long r114 = r411;
    L13:
        PlatformSpanStyle r115 = r414;
    L14:
        DrawStyle r116 = r415;
    L91:
        boolean r104 = true;
    L92:
        if (r104 == true) goto L96;
        return r210;
    L96:
        if (r212 == null) goto L98;
        TextForegroundStyle r105 = TextForegroundStyle.Companion.from(r212, r213);
    L99:
        TextForegroundStyle r106 = r210.getTextForegroundStyle$ui_text().merge(r105);
        if (r313 != null) goto L102;
        FontFamily r107 = r210.getFontFamily();
    L104:
        if (TextUnit.m7740getRawTypeimpl(r214) != 0) goto L106;
        boolean r108 = true;
    L107:
        if (r108 == true) goto L109;
        long r109 = r214;
    L110:
        if (r100 != null) goto L112;
        r100 = r210.getFontWeight();
    L112:
        if (r101 != null) goto L114;
        r101 = r210.m6941getFontStyle4Lr2A7w();
    L114:
        if (r102 != null) goto L116;
        r102 = r210.m6942getFontSynthesisZQGJjVo();
    L116:
        if (r103 != null) goto L119;
        r103 = r210.getFontFeatureSettings();
    L119:
        if (TextUnit.m7740getRawTypeimpl(r315) != 0) goto L121;
        boolean r117 = true;
    L122:
        if (r117 == true) goto L124;
        long r118 = r315;
    L125:
        if (r110 != null) goto L127;
        r110 = r210.m6938getBaselineShift5SSeXJ0();
    L127:
        if (r113 != null) goto L129;
        r113 = r210.getTextGeometricTransform();
    L129:
        if (r410 != null) goto L131;
        LocaleList r119 = r210.getLocaleList();
    L133:
        if (r114 == 16) goto L135;
        r111 = true;
    L135:
        if (r111 == true) goto L138;
        r114 = r210.m6937getBackground0d7_KjU();
    L138:
        if (r412 != null) goto L140;
        TextDecoration r120 = r210.getTextDecoration();
    L141:
        if (r413 != null) goto L143;
        Shadow r121 = r210.getShadow();
    L144:
        PlatformSpanStyle r122 = mergePlatformStyle(r210, r115);
        if (r116 != null) goto L148;
        r116 = r210.getDrawStyle();
    L148:
        return new SpanStyle(r106, r109, r100, r101, r102, r107, r103, r118, r110, r113, r119, r114, r120, r121, r122, r116, null);
    L143:
        r121 = r413;
        goto L144
    L140:
        r120 = r412;
        goto L141
    L131:
        r119 = r410;
        goto L133
    L124:
        r118 = r210.m6943getLetterSpacingXSAIIZE();
        goto L125
    L121:
        r117 = false;
        goto L122
    L109:
        r109 = r210.m6940getFontSizeXSAIIZE();
        goto L110
    L106:
        r108 = false;
        goto L107
    L102:
        r107 = r313;
        goto L104
    L98:
        r105 = TextForegroundStyle.Companion.m7439from8_81llA(r211);
    L16:
        if (r212 == null) goto L18;
    L24:
        if (r101 != null) goto L26;
    L27:
        if (r100 != null) goto L29;
    L30:
        if (r313 == null) goto L34;
        if (r313 != r210.getFontFamily()) goto L11;
    L34:
        if (TextUnit.m7740getRawTypeimpl(r315) != 0) goto L36;
        boolean r123 = true;
    L38:
        if ((!r123) == false) goto L43;
        if (TextUnit.m7739equalsimpl0(r315, r210.m6943getLetterSpacingXSAIIZE()) == false) goto L11;
    L43:
        if (r412 == null) goto L47;
        if (Intrinsics.areEqual(r412, r210.getTextDecoration()) == false) goto L11;
    L47:
        if (Intrinsics.areEqual(r212, r210.getTextForegroundStyle$ui_text().getBrush()) == false) goto L11;
        if (r212 != null) goto L50;
    L54:
        if (r102 != null) goto L56;
    L57:
        if (r103 != null) goto L59;
    L60:
        if (r110 != null) goto L62;
    L63:
        r113 = r317;
        if (r113 == null) goto L68;
        if (Intrinsics.areEqual(r113, r210.getTextGeometricTransform()) == false) goto L12;
    L68:
        if (r410 != null) goto L70;
    L71:
        r114 = r411;
        if (r114 == 16) goto L74;
        boolean r124 = true;
    L75:
        if (r124 == true) goto L77;
    L78:
        if (r413 != null) goto L80;
    L81:
        r115 = r414;
        if (r115 != null) goto L84;
    L85:
        r116 = r415;
        if (r116 != null) goto L88;
    L90:
        r104 = false;
        goto L92
    L88:
        if (Intrinsics.areEqual(r116, r210.getDrawStyle()) == true) goto L90;
    L84:
        if (Intrinsics.areEqual(r115, r210.getPlatformStyle()) == false) goto L14;
    L80:
        if (Intrinsics.areEqual(r413, r210.getShadow()) == false) goto L13;
    L77:
        if (Color.m4828equalsimpl0(r114, r210.m6937getBackground0d7_KjU()) == false) goto L13;
    L74:
        r124 = false;
        goto L75
    L70:
        if (Intrinsics.areEqual(r410, r210.getLocaleList()) == false) goto L12;
    L62:
        if (Intrinsics.areEqual(r110, r210.m6938getBaselineShift5SSeXJ0()) == false) goto L11;
    L59:
        if (Intrinsics.areEqual(r103, r210.getFontFeatureSettings()) == false) goto L11;
    L56:
        if (Intrinsics.areEqual(r102, r210.m6942getFontSynthesisZQGJjVo()) == false) goto L11;
    L50:
        if (r213 != r210.getTextForegroundStyle$ui_text().getAlpha()) goto L52;
        boolean r125 = true;
    L53:
        if (r125 == false) goto L11;
    L52:
        r125 = false;
        goto L53
    L36:
        r123 = false;
        goto L38
    L29:
        if (Intrinsics.areEqual(r100, r210.getFontWeight()) == false) goto L11;
    L26:
        if (Intrinsics.areEqual(r101, r210.m6941getFontStyle4Lr2A7w()) == false) goto L11;
    L18:
        if (r211 == 16) goto L20;
        boolean r126 = true;
    L21:
        if (r126 == false) goto L24;
        if (Color.m4828equalsimpl0(r211, r210.getTextForegroundStyle$ui_text().mo7304getColor0d7_KjU()) == false) goto L11;
    L20:
        r126 = false;
        goto L21
    L5:
        r112 = false;
        goto L7
    }
}
