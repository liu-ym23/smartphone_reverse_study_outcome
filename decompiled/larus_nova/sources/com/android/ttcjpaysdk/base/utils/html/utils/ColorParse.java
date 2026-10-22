package com.android.ttcjpaysdk.base.utils.html.utils;

import android.graphics.Color;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/html/utils/ColorParse;", "", "()V", "parseColor", "", "colorValue", "", "parseHexColor", "hexValue", "parseNamedColor", "colorName", "parseRgbColor", "rgbValue", "parseRgbaColor", "rgbaValue", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ColorParse {
    public static final ColorParse INSTANCE = null;

    static {
        INSTANCE = new ColorParse();
    }

    private ColorParse() {
    }

    private final int parseHexColor(String r110) {
        if (StringsKt.startsWith$default(r110, "#", false, 2, null) == false) goto L51;
        String r100 = r110.substring(1);
        int r101 = 0;
    L6:
        if (r101 >= r100.length()) goto L22;
        char r102 = r100.charAt(r101);
        if (Character.isDigit(r102) == true) goto L18;
        char r103 = Character.toLowerCase(r102);
        if ('a' <= r103) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == true) goto L18;
        boolean r105 = false;
    L19:
        if (r105 == false) goto L20;
        r101 = r101 + 1;
        goto L6
    L20:
        boolean r106 = false;
    L23:
        if (r106 == false) goto L49;
        int r107 = r100.length();
        if (r107 != 3) goto L27;
        char r108 = r100.charAt(0);
        char r109 = r100.charAt(1);
        char r111 = r100.charAt(2);
        return Color.parseColor("#" + r108 + r108 + r109 + r109 + r111 + r111);
    L45:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("ColorParse#parseHexColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "ColorParse#parseHexColor", e);
        throw new IllegalArgumentException("无效的RGB简写格式: '" + r110 + '\'', e);
    L27:
        if (r107 != 6) goto L29;
        return Color.parseColor(r110);
    L39:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("ColorParse#parseHexColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "ColorParse#parseHexColor", e);
        throw new IllegalArgumentException("无效的RRGGBB格式: '" + r110 + '\'', e);
    L29:
        if (r107 != 8) goto L36;
        return Color.parseColor(r110);
    L32:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("ColorParse#parseHexColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "ColorParse#parseHexColor", e);
        throw new IllegalArgumentException("无效的AARRGGBB格式: '" + r110 + '\'', e);
    L36:
        throw new IllegalArgumentException("十六进制颜色值长度无效，应为3、6或8位: '" + r110 + '\'');
    L49:
        throw new IllegalArgumentException("十六进制颜色值包含非法字符: '" + r110 + '\'');
    L12:
        if (r103 >= 'g') goto L14;
        r104 = true;
    L18:
        r105 = true;
        goto L19
    L22:
        r106 = true;
        goto L23
    L51:
        throw new IllegalArgumentException("十六进制颜色值必须以#开头: '" + r110 + '\'');
    }

    private final int parseNamedColor(String r100) {
        String r101 = r100.toLowerCase(Locale.ROOT);
        switch(r101.hashCode()) {
            case -1844766387: goto L108;
            case -1726194350: goto L105;
            case -1184235822: goto L102;
            case -1008851410: goto L99;
            case -976943172: goto L96;
            case -909707666: goto L93;
            case -902311155: goto L90;
            case -816343937: goto L87;
            case -734239628: goto L84;
            case -18179295: goto L81;
            case 112785: goto L78;
            case 3027034: goto L75;
            case 3068707: goto L72;
            case 3178592: goto L69;
            case 3181155: goto L66;
            case 3181279: goto L63;
            case 3321813: goto L60;
            case 3374006: goto L57;
            case 3441014: goto L54;
            case 3444116: goto L51;
            case 93818879: goto L48;
            case 94011702: goto L45;
            case 94848049: goto L42;
            case 98619139: goto L39;
            case 102011650: goto L36;
            case 105832923: goto L33;
            case 113101865: goto L30;
            case 686244985: goto L27;
            case 686245109: goto L24;
            case 828922025: goto L21;
            case 1032605407: goto L18;
            case 1441664347: goto L15;
            case 1741452496: goto L12;
            case 1741606617: goto L9;
            case 1741606741: goto L6;
            default: goto L112;
        };
    L6:
        if (r101.equals("darkgrey") == false) goto L112;
    L113:
        return ColorProtector.parseColor("#A9A9A9");
    L9:
        if (r101.equals("darkgray") == false) goto L112;
    L12:
        if (r101.equals("darkblue") == false) goto L112;
        return ColorProtector.parseColor("#00008B");
    L15:
        if (r101.equals("darkred") == false) goto L112;
        return ColorProtector.parseColor("#8B0000");
    L18:
        if (r101.equals("crimson") == false) goto L112;
        return ColorProtector.parseColor("#DC143C");
    L21:
        if (r101.equals("magenta") == false) goto L112;
        return FakePickerAvatarCreator.MAGENTA;
    L24:
        if (r101.equals("lightgrey") == false) goto L112;
    L118:
        return ColorProtector.parseColor("#D3D3D3");
    L27:
        if (r101.equals("lightgray") == false) goto L112;
    L30:
        if (r101.equals("white") == false) goto L112;
        return -1;
    L33:
        if (r101.equals("olive") == false) goto L112;
        return ColorProtector.parseColor("#808000");
    L36:
        if (r101.equals("khaki") == false) goto L112;
        return ColorProtector.parseColor("#F0E68C");
    L39:
        if (r101.equals("green") == false) goto L112;
        return FakePickerAvatarCreator.GREEN;
    L42:
        if (r101.equals("coral") == false) goto L112;
        return ColorProtector.parseColor("#FF7F50");
    L45:
        if (r101.equals("brown") == false) goto L112;
        return ColorProtector.parseColor("#A52A2A");
    L48:
        if (r101.equals("black") == false) goto L112;
        return -16777216;
    L51:
        if (r101.equals("plum") == false) goto L112;
        return ColorProtector.parseColor("#DDA0DD");
    L54:
        if (r101.equals("pink") == false) goto L112;
        return ColorProtector.parseColor("#FFC0CB");
    L57:
        if (r101.equals("navy") == false) goto L112;
        return ColorProtector.parseColor("#000080");
    L60:
        if (r101.equals("lime") == false) goto L112;
        return ColorProtector.parseColor("#00FF00");
    L63:
        if (r101.equals("grey") == false) goto L112;
    L67:
        return FakePickerAvatarCreator.GRAY;
    L66:
        if (r101.equals("gray") == false) goto L112;
    L69:
        if (r101.equals("gold") == false) goto L112;
        return ColorProtector.parseColor("#FFD700");
    L72:
        if (r101.equals("cyan") == false) goto L112;
        return FakePickerAvatarCreator.CYAN;
    L75:
        if (r101.equals("blue") == false) goto L112;
        return FakePickerAvatarCreator.BLUE;
    L78:
        if (r101.equals("red") == false) goto L112;
        return -65536;
    L81:
        if (r101.equals("turquoise") == false) goto L112;
        return ColorProtector.parseColor("#40E0D0");
    L84:
        if (r101.equals("yellow") == false) goto L112;
        return -256;
    L87:
        if (r101.equals("violet") == false) goto L112;
        return ColorProtector.parseColor("#EE82EE");
    L90:
        if (r101.equals("silver") == false) goto L112;
        return ColorProtector.parseColor("#C0C0C0");
    L93:
        if (r101.equals("salmon") == false) goto L112;
        return ColorProtector.parseColor("#FA8072");
    L96:
        if (r101.equals("purple") == false) goto L112;
        return ColorProtector.parseColor("#800080");
    L99:
        if (r101.equals("orange") == false) goto L112;
        return ColorProtector.parseColor("#FFA500");
    L102:
        if (r101.equals("indigo") == false) goto L112;
        return ColorProtector.parseColor("#4B0082");
    L105:
        if (r101.equals(ECPromotion.TRANSPARENT_BOTTON_ICON) == false) goto L112;
        return 0;
    L108:
        if (r101.equals("darkgreen") == false) goto L112;
        return ColorProtector.parseColor("#006400");
    L112:
        throw new IllegalArgumentException("不支持的颜色名称: '" + r100 + '\'');
    }

    private final int parseRgbColor(String r110) {
        boolean r100 = false;
        if (StringsKt.startsWith$default(r110, "rgb(", false, 2, null) == false) goto L37;
        if (StringsKt.endsWith$default(r110, ")", false, 2, null) == false) goto L37;
        List r101 = StringsKt.split$default(StringsKt.removeSuffix(StringsKt.removePrefix(r110, "rgb("), ")"), new String[]{","}, false, 0, 6, null);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        r102.add(StringsKt.trim((String) r103.next()).toString());
        goto L8
    L11:
        if (r102.size() != 3) goto L35;
        int r104 = CastIntegerProtector.parseInt((String) ListProtector.get(r102, 0));     // Catch: NumberFormatException -> L31
        int r105 = CastIntegerProtector.parseInt((String) ListProtector.get(r102, 1));     // Catch: NumberFormatException -> L31
        int r106 = CastIntegerProtector.parseInt((String) ListProtector.get(r102, 2));     // Catch: NumberFormatException -> L31
        if (r104 < 0) goto L16;
        if (r104 >= 256) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L30;
        if (r105 < 0) goto L21;
        if (r105 >= 256) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == false) goto L30;
        if (r106 < 0) goto L26;
        if (r106 >= 256) goto L26;
        r100 = true;
    L26:
        if (r100 == false) goto L30;
        return Color.rgb(r104, r105, r106);
    L21:
        r108 = false;
    L30:
        throw new IllegalArgumentException("RGB值必须在0-255范围内: r=" + r104 + ", g=" + r105 + ", b=" + r106);     // Catch: NumberFormatException -> L31
    L16:
        r107 = false;
    L31:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("ColorParse#parseRgbColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "ColorParse#parseRgbColor", e);
        throw new IllegalArgumentException("RGB参数格式错误: '" + r110 + '\'', e);
    L35:
        throw new IllegalArgumentException("RGB格式应包含3个参数: '" + r110 + '\'');
    L37:
        throw new IllegalArgumentException("RGB格式错误，应为rgb(r,g,b): '" + r110 + '\'');
    }

    private final int parseRgbaColor(String r110) {
        boolean r100 = false;
        if (StringsKt.startsWith$default(r110, "rgba(", false, 2, null) == false) goto L46;
        if (StringsKt.endsWith$default(r110, ")", false, 2, null) == false) goto L46;
        List r101 = StringsKt.split$default(StringsKt.removeSuffix(StringsKt.removePrefix(r110, "rgba("), ")"), new String[]{","}, false, 0, 6, null);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        r102.add(StringsKt.trim((String) r103.next()).toString());
        goto L8
    L11:
        if (r102.size() != 4) goto L44;
        int r104 = CastIntegerProtector.parseInt((String) ListProtector.get(r102, 0));     // Catch: NumberFormatException -> L40
        int r105 = CastIntegerProtector.parseInt((String) ListProtector.get(r102, 1));     // Catch: NumberFormatException -> L40
        int r106 = CastIntegerProtector.parseInt((String) ListProtector.get(r102, 2));     // Catch: NumberFormatException -> L40
        float r107 = CastFloatProtector.parseFloat((String) ListProtector.get(r102, 3));     // Catch: NumberFormatException -> L40
        if (r104 < 0) goto L16;
        if (r104 >= 256) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == false) goto L39;
        if (r105 < 0) goto L21;
        if (r105 >= 256) goto L21;
        boolean r109 = true;
    L22:
        if (r109 == false) goto L39;
        if (r106 < 0) goto L26;
        if (r106 >= 256) goto L26;
        boolean r111 = true;
    L27:
        if (r111 == false) goto L39;
        if (0.0f <= r107) goto L31;
    L33:
        if (r100 == false) goto L37;
        return Color.argb((int) (r107 * 255), r104, r105, r106);
    L37:
        throw new IllegalArgumentException("Alpha值必须在0.0-1.0范围内: alpha=" + r107);     // Catch: NumberFormatException -> L40
    L31:
        if (r107 > 1.0f) goto L33;
        r100 = true;
    L26:
        r111 = false;
    L21:
        r109 = false;
    L39:
        throw new IllegalArgumentException("RGB值必须在0-255范围内: r=" + r104 + ", g=" + r105 + ", b=" + r106);     // Catch: NumberFormatException -> L40
    L16:
        r108 = false;
    L40:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("ColorParse#parseRgbaColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "ColorParse#parseRgbaColor", e);
        throw new IllegalArgumentException("RGBA参数格式错误: '" + r110 + '\'', e);
    L44:
        throw new IllegalArgumentException("RGBA格式应包含4个参数: '" + r110 + '\'');
    L46:
        throw new IllegalArgumentException("RGBA格式错误，应为rgba(r,g,b,a): '" + r110 + '\'');
    }

    public final int parseColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "colorValue");
        if (StringsKt.isBlank(r100) == true) goto L16;
        String r101 = StringsKt.trim(r100).toString();
        if (StringsKt.startsWith$default(r101, "#", false, 2, null) == false) goto L8;
        return parseHexColor(r101);
    L8:
        if (StringsKt.startsWith$default(r101, "rgba(", false, 2, null) == false) goto L11;
        return parseRgbaColor(r101);
    L11:
        if (StringsKt.startsWith$default(r101, "rgb(", false, 2, null) == false) goto L14;
        return parseRgbColor(r101);
    L14:
        return parseNamedColor(r101);
    L16:
        throw new IllegalArgumentException("颜色值不能为空: '" + r100 + '\'');
    }
}
