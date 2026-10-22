package androidx.compose.ui.text.font;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJF\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0080\b¢\u0006\u0002\b\u0013J+\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\u0016J+\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0014\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/font/FontMatcher;", "", "<init>", "()V", "matchFont", "", "Landroidx/compose/ui/text/font/Font;", "fontList", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "matchFont-RetOiIg", "(Ljava/util/List;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "filterByClosestWeight", "preferBelow", "", "minSearchRange", "maxSearchRange", "filterByClosestWeight$ui_text", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "Landroidx/compose/ui/text/font/FontListFontFamily;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FontMatcher {
    public static final int $stable = 0;

    public FontMatcher() {
    }

    /* JADX INFO: renamed from: matchFont-RetOiIg, reason: not valid java name */
    public final List<Font> m7108matchFontRetOiIg(List<? extends Font> r110, FontWeight r111, int r112) {
        ArrayList r100 = new ArrayList(r110.size());
        List<? extends Font> r101 = r110;
        int r102 = r101.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        boolean r105 = true;
        if (r104 >= r102) goto L15;
        Object r106 = ListProtector.get(r110, r104);
        Font r107 = (Font) r106;
        if (Intrinsics.areEqual(r107.getWeight(), r111) == true) goto L8;
    L10:
        r105 = false;
    L11:
        if (r105 == false) goto L13;
        r100.add(r106);
    L13:
        r104 = r104 + 1;
        goto L3
    L8:
        if (FontStyle.m7112equalsimpl0(r107.mo7064getStyle_LCdwA(), r112) == false) goto L10;
    L15:
        if ((!r100.isEmpty()) == false) goto L17;
        return r100;
    L17:
        ArrayList r108 = new ArrayList(r110.size());
        int r109 = r101.size();
        int r113 = 0;
    L18:
        if (r113 >= r109) goto L24;
        Object r114 = ListProtector.get(r110, r113);
        if (FontStyle.m7112equalsimpl0(((Font) r114).mo7064getStyle_LCdwA(), r112) == false) goto L22;
        r108.add(r114);
    L22:
        r113 = r113 + 1;
        goto L18
    L24:
        if (r108.isEmpty() == true) goto L27;
        r110 = r108;
    L27:
        List<? extends Font> r115 = r110;
        FontWeight.Companion r116 = FontWeight.Companion;
        FontWeight r117 = null;
        if (r111.compareTo2(r116.getW400()) >= 0) goto L55;
        int r118 = r115.size();
        FontWeight r119 = null;
        int r120 = 0;
    L30:
        if (r120 >= r118) goto L45;
        FontWeight r121 = ((Font) ListProtector.get(r115, r120)).getWeight();
        if (r121.compareTo2(r111) >= 0) goto L38;
        if (r117 != null) goto L35;
    L36:
        r117 = r121;
    L43:
        r120 = r120 + 1;
        goto L30
    L35:
        if (r121.compareTo2(r117) <= 0) goto L43;
    L38:
        if (r121.compareTo2(r111) <= 0) goto L44;
        if (r119 != null) goto L41;
    L42:
        r119 = r121;
        goto L43
    L41:
        if (r121.compareTo2(r119) >= 0) goto L43;
    L44:
        r119 = r121;
        r117 = r119;
    L45:
        if (r117 == null) goto L48;
        r119 = r117;
    L48:
        ArrayList r122 = new ArrayList(r115.size());
        int r123 = r115.size();
    L49:
        if (r103 >= r123) goto L188;
        Object r124 = ListProtector.get(r115, r103);
        if (Intrinsics.areEqual(((Font) r124).getWeight(), r119) == false) goto L53;
        r122.add(r124);
    L53:
        r103 = r103 + 1;
        goto L49
    L188:
        return r122;
    L55:
        if (r111.compareTo2(r116.getW500()) <= 0) goto L80;
        int r125 = r115.size();
        FontWeight r126 = null;
        int r127 = 0;
    L57:
        if (r127 >= r125) goto L72;
        FontWeight r128 = ((Font) ListProtector.get(r115, r127)).getWeight();
        if (r128.compareTo2(r111) >= 0) goto L65;
        if (r117 != null) goto L62;
    L63:
        r117 = r128;
    L70:
        r127 = r127 + 1;
        goto L57
    L62:
        if (r128.compareTo2(r117) <= 0) goto L70;
    L65:
        if (r128.compareTo2(r111) <= 0) goto L71;
        if (r126 != null) goto L68;
    L69:
        r126 = r128;
        goto L70
    L68:
        if (r128.compareTo2(r126) >= 0) goto L70;
    L71:
        r126 = r128;
        r117 = r126;
    L72:
        if (r126 != null) goto L74;
        r126 = r117;
    L74:
        ArrayList r129 = new ArrayList(r115.size());
        int r130 = r115.size();
    L75:
        if (r103 >= r130) goto L189;
        Object r131 = ListProtector.get(r115, r103);
        if (Intrinsics.areEqual(((Font) r131).getWeight(), r126) == false) goto L79;
        r129.add(r131);
    L79:
        r103 = r103 + 1;
        goto L75
    L189:
        return r129;
    L80:
        FontWeight r132 = r116.getW500();
        int r133 = r115.size();
        FontWeight r134 = null;
        FontWeight r135 = null;
        int r136 = 0;
    L81:
        if (r136 >= r133) goto L101;
        FontWeight r137 = ((Font) ListProtector.get(r115, r136)).getWeight();
        if (r132 == null) goto L88;
        if (r137.compareTo2(r132) <= 0) goto L88;
    L99:
        r136 = r136 + 1;
    L88:
        if (r137.compareTo2(r111) >= 0) goto L94;
        if (r134 != null) goto L91;
    L92:
        r134 = r137;
        goto L99
    L91:
        if (r137.compareTo2(r134) <= 0) goto L99;
    L94:
        if (r137.compareTo2(r111) <= 0) goto L100;
        if (r135 != null) goto L97;
    L98:
        r135 = r137;
        goto L99
    L97:
        if (r137.compareTo2(r135) >= 0) goto L99;
    L100:
        r134 = r137;
        r135 = r134;
    L101:
        if (r135 == null) goto L104;
        r134 = r135;
    L104:
        ArrayList r138 = new ArrayList(r115.size());
        List<? extends Font> r139 = r115;
        int r140 = r139.size();
        int r141 = 0;
    L105:
        if (r141 >= r140) goto L111;
        Object r142 = ListProtector.get(r115, r141);
        if (Intrinsics.areEqual(((Font) r142).getWeight(), r134) == false) goto L109;
        r138.add(r142);
    L109:
        r141 = r141 + 1;
        goto L105
    L111:
        if (r138.isEmpty() == false) goto L143;
        FontWeight r143 = FontWeight.Companion.getW500();
        int r144 = r139.size();
        FontWeight r145 = null;
        int r146 = 0;
    L113:
        if (r146 >= r144) goto L133;
        FontWeight r147 = ((Font) ListProtector.get(r115, r146)).getWeight();
        if (r143 == null) goto L120;
        if (r147.compareTo2(r143) >= 0) goto L120;
    L131:
        r146 = r146 + 1;
    L120:
        if (r147.compareTo2(r111) >= 0) goto L126;
        if (r117 != null) goto L123;
    L124:
        r117 = r147;
        goto L131
    L123:
        if (r147.compareTo2(r117) <= 0) goto L131;
    L126:
        if (r147.compareTo2(r111) <= 0) goto L132;
        if (r145 != null) goto L129;
    L130:
        r145 = r147;
        goto L131
    L129:
        if (r147.compareTo2(r145) >= 0) goto L131;
    L132:
        r117 = r147;
        r145 = r117;
    L133:
        if (r145 == null) goto L136;
        r117 = r145;
    L136:
        ArrayList r148 = new ArrayList(r115.size());
        int r149 = r139.size();
    L137:
        if (r103 >= r149) goto L190;
        Object r150 = ListProtector.get(r115, r103);
        if (Intrinsics.areEqual(((Font) r150).getWeight(), r117) == false) goto L141;
        r148.add(r150);
    L141:
        r103 = r103 + 1;
        goto L137
    L190:
        return r148;
    L143:
        return r138;
    }

    /* JADX INFO: renamed from: matchFont-RetOiIg, reason: not valid java name */
    public final List<Font> m7106matchFontRetOiIg(FontFamily r100, FontWeight r101, int r102) {
        if ((r100 instanceof FontListFontFamily) == false) goto L7;
        return m7107matchFontRetOiIg((FontListFontFamily) r100, r101, r102);
    L7:
        throw new IllegalArgumentException("Only FontFamily instances that presents a list of Fonts can be used");
    }

    /* JADX INFO: renamed from: matchFont-RetOiIg, reason: not valid java name */
    public final List<Font> m7107matchFontRetOiIg(FontListFontFamily r100, FontWeight r101, int r102) {
        return m7108matchFontRetOiIg(r100.getFonts(), r101, r102);
    }

    public final List<Font> filterByClosestWeight$ui_text(List<? extends Font> r100, FontWeight r101, boolean r110, FontWeight r111, FontWeight r112) {
        int r102 = r100.size();
        FontWeight r103 = null;
        int r104 = 0;
        FontWeight r105 = null;
        int r106 = 0;
    L3:
        if (r106 >= r102) goto L27;
        FontWeight r107 = ((Font) ListProtector.get(r100, r106)).getWeight();
        if (r111 != null) goto L7;
    L9:
        if (r112 == null) goto L14;
        if (r107.compareTo2(r112) <= 0) goto L14;
    L25:
        r106 = r106 + 1;
    L14:
        if (r107.compareTo2(r101) >= 0) goto L20;
        if (r103 != null) goto L17;
    L18:
        r103 = r107;
        goto L25
    L17:
        if (r107.compareTo2(r103) <= 0) goto L25;
    L20:
        if (r107.compareTo2(r101) <= 0) goto L26;
        if (r105 != null) goto L23;
    L24:
        r105 = r107;
        goto L25
    L23:
        if (r107.compareTo2(r105) >= 0) goto L25;
    L26:
        r103 = r107;
        r105 = r103;
        goto L27
    L7:
        if (r107.compareTo2(r111) >= 0) goto L9;
    L27:
        if (r110 == false) goto L30;
        if (r103 == null) goto L32;
    L33:
        ArrayList r108 = new ArrayList(r100.size());
        int r113 = r100.size();
    L34:
        if (r104 >= r113) goto L39;
        Object r114 = ListProtector.get(r100, r104);
        if (Intrinsics.areEqual(((Font) r114).getWeight(), r103) == false) goto L38;
        r108.add(r114);
    L38:
        r104 = r104 + 1;
        goto L34
    L39:
        return r108;
    L32:
        r103 = r105;
        goto L33
    L30:
        if (r105 != null) goto L32;
        goto L32
    }

    public static /* synthetic */ List filterByClosestWeight$ui_text$default(FontMatcher r100, List r101, FontWeight r102, boolean r103, FontWeight r104, FontWeight r105, int r110, Object r111) {
        FontWeight r112 = null;
        if ((r110 & 4) == 0) goto L6;
        r104 = null;
    L6:
        if ((r110 & 8) == 0) goto L8;
        r105 = null;
    L8:
        int r106 = r101.size();
        int r113 = 0;
        FontWeight r107 = null;
        int r108 = 0;
    L9:
        if (r108 >= r106) goto L33;
        FontWeight r109 = ((Font) ListProtector.get(r101, r108)).getWeight();
        if (r104 != null) goto L13;
    L15:
        if (r105 == null) goto L20;
        if (r109.compareTo2(r105) <= 0) goto L20;
    L31:
        r108 = r108 + 1;
    L20:
        if (r109.compareTo2(r102) >= 0) goto L26;
        if (r112 != null) goto L23;
    L24:
        r112 = r109;
        goto L31
    L23:
        if (r109.compareTo2(r112) <= 0) goto L31;
    L26:
        if (r109.compareTo2(r102) <= 0) goto L32;
        if (r107 != null) goto L29;
    L30:
        r107 = r109;
        goto L31
    L29:
        if (r109.compareTo2(r107) >= 0) goto L31;
    L32:
        r112 = r109;
        r107 = r112;
        goto L33
    L13:
        if (r109.compareTo2(r104) >= 0) goto L15;
    L33:
        if (r103 == false) goto L36;
        if (r112 == null) goto L38;
    L39:
        ArrayList r114 = new ArrayList(r101.size());
        int r115 = r101.size();
    L40:
        if (r113 >= r115) goto L45;
        Object r116 = ListProtector.get(r101, r113);
        if (Intrinsics.areEqual(((Font) r116).getWeight(), r112) == false) goto L44;
        r114.add(r116);
    L44:
        r113 = r113 + 1;
        goto L40
    L45:
        return r114;
    L38:
        r112 = r107;
        goto L39
    L36:
        if (r107 != null) goto L38;
        goto L38
    }
}
