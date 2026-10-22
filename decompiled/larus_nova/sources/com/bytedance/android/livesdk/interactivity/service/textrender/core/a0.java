package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.e5;
import com.bytedance.android.live.base.model.message.g5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.base.model.message.p3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f141003a = null;

    static {
        f141003a = com.bytedance.android.livesdk.interactivity.service.settings.i.f140997a.getValue();
    }

    public static PieceType b(int r100) {
        PieceType r101 = PieceType.HEART;
        if (r100 != r101.getPieceType()) goto L5;
        return r101;
    L5:
        PieceType r102 = PieceType.USER;
        if (r100 != r102.getPieceType()) goto L8;
        return r102;
    L8:
        PieceType r103 = PieceType.STRING;
        if (r100 != r103.getPieceType()) goto L11;
        return r103;
    L11:
        PieceType r104 = PieceType.GIFT;
        if (r100 != r104.getPieceType()) goto L14;
        return r104;
    L14:
        PieceType r105 = PieceType.PATTERN_REF;
        if (r100 != r105.getPieceType()) goto L17;
        return r105;
    L17:
        PieceType r106 = PieceType.IMAGE;
        if (r100 != r106.getPieceType()) goto L21;
        return r106;
    L21:
        return PieceType.UNKNOWN;
    }

    public static tb2.d a(a5 r110, yb2.a r210) {
        if (r110 == null) goto L4;
        if (r210 != null) goto L7;
        yb2.a r100 = w.a();
    L8:
        Map<String, ? extends c5> r101 = r100.f567073l;
        if (r101 != null) goto L11;
    L35:
        String r102 = "";
        if (CollectionUtils.isEmpty(r110.getPieces()) == false) goto L45;
        tb2.d r103 = new tb2.d();
        r103.f545244c = r110.getDefaultFormat();
        r103.f545243b = r100;
        ArrayList r104 = new ArrayList();
        tb2.c r105 = new tb2.c((c5) vh7.f.c(c5.class));
        if (TextUtils.isEmpty("") == false) goto L43;
        String r106 = r110.getDefaultPattern();
        if (r106 == null) goto L43;
        r102 = r106;
    L43:
        r105.setText(r102);
        r104.add(r105);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f545242a = r104;
        return r103;
    L45:
        ArrayList r107 = new ArrayList();
        HashMap r108 = new HashMap();
        if (TextUtils.isEmpty("") == false) goto L49;
        String r109 = r110.getDefaultPattern();
        if (r109 == null) goto L49;
    L50:
        List<c5> r111 = r110.getPieces();
        if (r111 == null) goto L241;
        if (r111.isEmpty() == true) goto L241;
        ArrayList r112 = new ArrayList();
        r112.add(r107);
        r112.add(r108);
        StringBuilder r113 = new StringBuilder();
        int r114 = r109.length();
        int r115 = 0;
        int r116 = 0;
        int r117 = -1;
        int r118 = -1;
        int r119 = -1;
    L56:
        if (r115 >= r114) goto L234;
        char r120 = r109.charAt(r115);
        if (r120 != ':') goto L60;
        List<c5> r121 = r111;
        r114 = r114;
        if (r116 == 0) goto L232;
        if (r116 != 1) goto L241;
        r119 = CastIntegerProtector.valueOf(r109.subSequence(r117, r115).toString()).intValue();
        r118 = r115 + 1;
        char r122 = '}';
        r117 = -1;
    L230:
        if (r120 == r122) goto L232;
        r113.append(r120);
    L232:
        r115 = r115 + 1;
        r114 = r114;
        r111 = r121;
        goto L56
    L60:
        if (r120 == '{') goto L214;
        if (r120 == '}') goto L65;
        r121 = r111;
        r114 = r114;
    L223:
        r122 = '}';
        goto L230
    L65:
        if (r118 == (-1)) goto L67;
        String r123 = r109.subSequence(r118, r115).toString();
    L68:
        int r124 = r119;
        if (r124 == (-1)) goto L241;
        if (r113.length() <= 0) goto L73;
        boolean r125 = true;
    L74:
        if (r125 == false) goto L77;
        r113.delete(0, r113.length());
    L77:
        if (r124 >= 0) goto L79;
    L98:
        r121 = r111;
    L99:
        c5 r126 = null;
    L100:
        if (r126 == null) goto L209;
        int r127 = c.f141014a;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(r100, "config");
        int r128 = r126.getType();
        if (r128 != PieceType.STRING.getPieceType()) goto L106;
        String r129 = r126.getStringValue();
    L104:
        String r130 = r129;
    L207:
        r107.add(r130);
        r108.put(Integer.valueOf(r107.size() - 1), r126);
    L213:
        r116 = r116 - 1;
        r122 = '}';
        r118 = -1;
        r119 = -1;
        goto L230
    L106:
        if (r128 != PieceType.USER.getPieceType()) goto L167;
        i5 r131 = r126.getUserValue();
        if (r131 != null) goto L110;
    L206:
        r130 = null;
        goto L207
    L110:
        if (r131.getUser() == null) goto L206;
        if (r131.isWithColon() == false) goto L115;
        String r132 = "：";
    L117:
        if (r100.f567071j == false) goto L126;
        String r133 = r100.f567068g;
        IBaseUser r134 = r131.getUser();
        if (r134 == null) goto L121;
        String r135 = r134.getIdString();
    L123:
        if (Intrinsics.areEqual(r133, r135) == false) goto L126;
        r129 = s1.B(R.string.ttlive_comment_self_pronoun) + r132;
        goto L104
    L121:
        r135 = null;
    L126:
        if (r100.f567072k == false) goto L145;
        IBaseUser r136 = r131.getUser();
        if (r136 == null) goto L130;
        String r137 = r136.getSafeNicName();
    L132:
        if (TextUtils.isEmpty(r137) == true) goto L145;
        StringBuilder r138 = new StringBuilder();
        String r139 = r131.getPrefixString();
        if (r139 != null) goto L136;
        r139 = "";
    L136:
        r138.append(r139);
        IBaseUser r140 = r131.getUser();
        if (r140 == null) goto L139;
        String r141 = r140.getSafeNicName();
    L140:
        r138.append(r141);
        String r142 = r131.getPostfixString();
        if (r142 != null) goto L143;
        r142 = "";
    L143:
        r138.append(r142);
        r138.append(r132);
        r129 = r138.toString();
        goto L104
    L139:
        r141 = null;
        goto L140
    L130:
        r137 = null;
    L145:
        if (r131.selfShowRealName() == false) goto L159;
        IBaseUser r143 = r131.getUser();
        if (r143 == null) goto L159;
        String r144 = r143.getWebcastUid();
        if (r144 == null) goto L159;
        if (r144.equals(r100.f567069h) != true) goto L159;
        StringBuilder r145 = new StringBuilder();
        String r146 = r131.getPrefixString();
        if (r146 != null) goto L155;
        r146 = "";
    L155:
        r145.append(r146);
        r145.append(r100.f567070i);
        String r147 = r131.getPostfixString();
        if (r147 != null) goto L158;
        r147 = "";
    L158:
        r145.append(r147);
        r145.append(r132);
        r129 = r145.toString();
    L159:
        StringBuilder r148 = new StringBuilder();
        String r149 = r131.getPrefixString();
        if (r149 != null) goto L162;
        r149 = "";
    L162:
        r148.append(r149);
        r148.append(gm2.q.b(r131.getUser()));
        String r150 = r131.getPostfixString();
        if (r150 != null) goto L165;
        r150 = "";
    L165:
        r148.append(r150);
        r148.append(r132);
        r129 = r148.toString();
        goto L104
    L115:
        r132 = "";
        goto L117
    L167:
        if (r128 != PieceType.GIFT.getPieceType()) goto L191;
        e5 r151 = r126.getGiftValue();
        if (r151 == null) goto L206;
        if (r151.getNameRef() == null) goto L189;
        p3 r152 = r151.getNameRef();
        if (r152 == null) goto L176;
        String r153 = r152.getKey();
    L177:
        if (r153 == null) goto L189;
        if (TextUtils.isEmpty("") == false) goto L184;
        p3 r154 = r151.getNameRef();
        if (r154 == null) goto L184;
        String r155 = r154.getDefaultPattern();
        if (r155 == null) goto L184;
    L186:
        if (TextUtils.isEmpty(r155) == false) goto L188;
        r155 = s1.B(R.string.ttlive_live_gift);
    L188:
        r129 = Intrinsics.stringPlus(r155, " . ");
    L184:
        r155 = "";
        goto L186
    L176:
        r153 = null;
    L189:
        r129 = s1.B(R.string.ttlive_live_gift) + " . ";
        goto L104
    L191:
        if (r126.getType() != PieceType.HEART.getPieceType()) goto L194;
        r130 = " ";
        goto L207
    L194:
        if (r128 != PieceType.PATTERN_REF.getPieceType()) goto L204;
        g5 r156 = r126.getPatternRefValue();
        if (r156 != null) goto L199;
    L202:
        r130 = "";
        goto L207
    L199:
        if (TextUtils.isEmpty(r156.getDefaultPattern()) == true) goto L202;
        r129 = r156.getDefaultPattern();
        if (r129 != null) goto L104;
    L204:
        if (r128 != PieceType.IMAGE.getPieceType()) goto L206;
        r130 = tb2.c.DEFAULT_TEXT;
        goto L207
    L209:
        if (com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.f141058b == false) goto L213;
        pm0.a r157 = om0.c.c();
        if (r157 == null) goto L213;
        r157.i("ttlive_render_engine", "piece result is null !! pattern " + r109 + "  index: " + r124 + "  tag " + r123);
        goto L213
    L79:
        if (r124 >= r111.size()) goto L98;
        if (TextUtils.isEmpty(r123) == true) goto L98;
        if (r111.isEmpty() == true) goto L98;
        r126 = (c5) ListProtector.get(r111, r124);
        r121 = r111;
        if (r100.f567067f != true) goto L95;
        if (r126.getType() != PieceType.IMAGE.getPieceType()) goto L95;
        c5 r158 = (c5) vh7.f.c(c5.class);
        r158.setFormat(r126.getFormat());
        r158.setType(r126.getType());
        r158.setGiftValue(r126.getGiftValue());
        r158.setHeartValue(r126.getHeartValue());
        r158.setPatternRefValue(r126.getPatternRefValue());
        r158.setStringValue(r126.getStringValue());
        r158.setUserValue(r126.getUserValue());
        ITextPieceImage r159 = r126.getImageValue();
        if (r159 == null) goto L92;
        ITextPieceImage r160 = r159.doClone();
    L93:
        r158.setImageValue(r160);
        r158.setSchemaKey(r126.getSchemaKey());
        r126 = r158;
        goto L95
    L92:
        r160 = null;
    L95:
        if (Intrinsics.areEqual(b(r126.getType()).getTag(), r123) == true) goto L100;
        Logger.e("I18N_MESSAGE", "TextPieceHelper: tag is false");
        goto L99
    L73:
        r125 = false;
        goto L74
    L67:
        r119 = CastIntegerProtector.valueOf(r109.subSequence(r117, r115).toString()).intValue();
        r123 = "string";
        goto L68
    L214:
        r121 = r111;
        r114 = r114;
        r116 = r116 + 1;
        if (r116 != 1) goto L241;
        r117 = r115 + 1;
        if (r113.length() <= 0) goto L220;
        boolean r161 = true;
    L221:
        if (r161 == false) goto L223;
        r107.add(r113.toString());
        c5 r162 = (c5) vh7.f.c(c5.class);
        r162.setNormalPiece(true);
        r108.put(Integer.valueOf(r107.size() - 1), r162);
        r113.delete(0, r113.length());
        goto L223
    L220:
        r161 = false;
        goto L221
    L234:
        if (r113.length() <= 0) goto L236;
        boolean r163 = true;
    L237:
        if (r163 == false) goto L241;
        r107.add(r113.toString());
        c5 r164 = (c5) vh7.f.c(c5.class);
        r164.setNormalPiece(true);
        r108.put(Integer.valueOf(r107.size() - 1), r164);
        r113.delete(0, r113.length());
        goto L241
    L236:
        r163 = false;
    L241:
        if (f141003a.booleanValue() == true) goto L244;
        r100 = w.a();
    L244:
        tb2.d r165 = new tb2.d();
        r165.f545243b = r100;
        LinkedList r166 = new LinkedList();
        Intrinsics.checkNotNullParameter(r166, "<set-?>");
        r165.f545242a = r166;
        r165.f545244c = r110.getDefaultFormat();
        int r167 = r107.size();
        int r168 = 0;
    L245:
        if (r168 >= r167) goto L262;
        String r169 = (String) ListProtector.get(r107, r168);
        c5 r170 = (c5) r108.get(Integer.valueOf(r168));
        if (r169 != null) goto L249;
        r169 = "";
    L249:
        tb2.c r171 = new tb2.c(r170, r169);
        Map<String, m6> r172 = r110.getSchemaInfos();
        if (r172 == null) goto L261;
        String r173 = r171.getSchemaKey();
        if (r173 == null) goto L261;
        if (r172.keySet().contains(r173) == false) goto L261;
        r171.setConvertedSchema(r172.get(r173));
        m6 r174 = r171.getConvertedSchema();
        if (r174 == null) goto L261;
        r174.f58893a = r173;
    L261:
        r166.add(r171);
        r168 = r168 + 1;
        goto L245
    L262:
        return r165;
    L49:
        r109 = "";
        goto L50
    L11:
        if (r101.isEmpty() == true) goto L35;
        Iterator<T> r175 = r110.getPieces().iterator();
    L15:
        if (r175.hasNext() == false) goto L35;
        c5 r176 = (c5) r175.next();
        c5 r177 = r101.get(r176.getRefKey());
        if (r177 == null) goto L15;
        int r178 = z.f141054a[b(r176.getType()).ordinal()];
        if (r178 != 1) goto L22;
        r176.setStringValue(r177.getStringValue());
        goto L15
    L22:
        if (r178 != 2) goto L24;
        r176.setUserValue(r177.getUserValue());
        goto L15
    L24:
        if (r178 != 3) goto L26;
        r176.setGiftValue(r177.getGiftValue());
        goto L15
    L26:
        if (r178 != 4) goto L28;
        r176.setPatternRefValue(r177.getPatternRefValue());
        goto L15
    L28:
        if (r178 != 5) goto L15;
        r176.setImageValue(r177.getImageValue());
        goto L15
    L7:
        r100 = r210;
        goto L8
    L4:
        return new tb2.d();
    }
}
