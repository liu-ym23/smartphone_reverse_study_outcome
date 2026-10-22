package com.bytedance.android.ecom.arch.expr.parser;

import bq.b;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ecom.arch.expr.error.SlcExprException;
import com.bytedance.android.ecom.arch.expr.lexer.SlcTokenType;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import zp.d;
import zp.e;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcExprParser {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0083\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ecom/arch/expr/parser/SlcExprParser$Precedence;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "slice-expr_release"}, k = 1, mv = {1, 4, 0})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Precedence {
        public static final int ARRAY = 180;
        public static final int BIT_AND = 80;
        public static final int BIT_OR = 60;
        public static final int BIT_XOR = 70;
        public static final int CALL = 180;
        public static final int COMPARISON = 100;
        public static final a Companion = null;
        public static final int EQUALITY = 90;
        public static final int FACTOR = 130;
        public static final int GROUP = 190;
        public static final int INDEX = 180;
        public static final int LOGIC_AND = 50;
        public static final int LOGIC_OR = 40;
        public static final int NONE = 0;
        public static final int POWER = 140;
        public static final int TERM = 120;
        public static final int UNARY = 150;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f49947a = null;

            public a() {
            }

            static {
                f49947a = new a();
            }
        }

        static {
            Companion = a.f49947a;
        }
    }

    public static final class a {
    }

    static {
    }

    public SlcExprParser() {
    }

    @Precedence
    public static int b(@SlcTokenType int r100) {
        switch(r100) {
            case 3: goto L15;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L12;
            case 11: goto L12;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L11;
            case 15: goto L3;
            case 16: goto L10;
            case 17: goto L9;
            case 18: goto L3;
            case 19: goto L8;
            case 20: goto L7;
            case 21: goto L6;
            case 22: goto L5;
            case 23: goto L3;
            case 24: goto L4;
            case 25: goto L3;
            case 26: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L4:
        return 190;
    L5:
        return 180;
    L6:
        return 70;
    L7:
        return 60;
    L8:
        return 80;
    L9:
        return 40;
    L10:
        return 50;
    L11:
        return 90;
    L12:
        return 100;
    L13:
        return 140;
    L14:
        return 130;
    L15:
        return 120;
    }

    public static dq.a a(String r100, d r101) {
        com.bytedance.android.ecom.arch.expr.parser.a r102 = new com.bytedance.android.ecom.arch.expr.parser.a(new bq.a(r100), r101);
        r102.a();
        c(r102, 0);
        if (r102.f49949b.f20009a != 32) goto L7;
        return new dq.a(r102.f49950c, r102.f49951d);
    L7:
        throw new SlcExprException("parser_needless_token", "invalid token: " + r102.f49949b);
    }

    public static void c(com.bytedance.android.ecom.arch.expr.parser.a r110, @Precedence int r111) {
        r110.a();
        b r100 = r110.f49948a;
        int r101 = r100.f20009a;
        if (r101 != 32) goto L6;
        return;
    L6:
        if (r101 == 0) goto L56;
        if (r101 != 1) goto L9;
        r110.d((byte) 0, (byte) 1, r100.f20010b);
    L162:
        if (r111 >= b(r110.f49949b.f20009a)) goto L204;
        r110.a();
        b r102 = r110.f49948a;
        int r103 = r102.f20009a;
        switch(r103) {
            case 3: goto L177;
            case 4: goto L177;
            case 5: goto L177;
            case 6: goto L177;
            case 7: goto L177;
            case 8: goto L177;
            case 9: goto L177;
            case 10: goto L177;
            case 11: goto L177;
            case 12: goto L177;
            case 13: goto L177;
            case 14: goto L177;
            case 15: goto L203;
            case 16: goto L175;
            case 17: goto L173;
            case 18: goto L203;
            case 19: goto L177;
            case 20: goto L177;
            case 21: goto L177;
            case 22: goto L167;
            case 23: goto L203;
            case 24: goto L203;
            case 25: goto L203;
            case 26: goto L166;
            default: goto L203;
        };
    L177:
        int r104 = b(r103);
        if (r103 != 8) goto L180;
        boolean r105 = true;
    L181:
        if (r105 == false) goto L208;
        r104 = r104 - 1;
    L208:
        c(r110, r104);     // Catch: Throwable -> L205
        switch(r103) {
            case 3: goto L201;
            case 4: goto L200;
            case 5: goto L199;
            case 6: goto L198;
            case 7: goto L197;
            case 8: goto L196;
            case 9: goto L195;
            case 10: goto L194;
            case 11: goto L193;
            case 12: goto L192;
            case 13: goto L191;
            case 14: goto L190;
            case 15: goto L189;
            case 16: goto L162;
            case 17: goto L162;
            case 18: goto L162;
            case 19: goto L188;
            case 20: goto L187;
            case 21: goto L186;
            default: goto L162;
        };
    L189:
        r110.f49950c.a((byte) 75);
        goto L162
    L190:
        r110.f49950c.a((byte) 82);
        goto L162
    L191:
        r110.f49950c.a((byte) 81);
        goto L162
    L192:
        r110.f49950c.a((byte) 84);
        goto L162
    L193:
        r110.f49950c.a((byte) 83);
        goto L162
    L194:
        r110.f49950c.a((byte) 86);
        goto L162
    L195:
        r110.f49950c.a((byte) 85);
        goto L162
    L196:
        r110.f49950c.a((byte) 67);
        goto L162
    L197:
        r110.f49950c.a((byte) 66);
        goto L162
    L198:
        r110.f49950c.a((byte) 65);
        goto L162
    L199:
        r110.f49950c.a((byte) 64);
        goto L162
    L200:
        r110.f49950c.a((byte) 62);
        goto L162
    L201:
        r110.f49950c.a((byte) 63);
        goto L162
    L186:
        r110.f49950c.a((byte) 74);
        goto L162
    L187:
        r110.f49950c.a((byte) 73);
        goto L162
    L188:
        r110.f49950c.a((byte) 72);
    L205:
        th = move-exception;
        throw th;
    L180:
        r105 = false;
        goto L181
    L203:
        throw new SlcExprException("parser_internal_error", r102 + ": no infix fn");
    L166:
        c(r110, 0);
        r110.b(27, "Expect ']' after index");
        r110.f49950c.a((byte) 92);
        goto L162
    L167:
        r110.b(0, "Expect property name after '.'");
        if (r110.e(24) == true) goto L172;
        r110.d((byte) 25, (byte) 26, r110.f49948a.f20010b);
        goto L162
    L172:
        throw new SlcExprException("parser_syntax_error", "不支持成员方法:" + r110.f49948a.f20010b);
    L173:
        int r106 = r110.c((byte) 96);
        r110.f49950c.a((byte) 99);
        c(r110, 40);
        r110.f(r106);
        goto L162
    L175:
        int r107 = r110.c((byte) 97);
        r110.f49950c.a((byte) 99);
        c(r110, 50);
        r110.f(r107);
        goto L162
    L204:
        return;
    L9:
        if (r101 != 2) goto L11;
        r110.d((byte) 0, (byte) 1, Double.valueOf(CastDoubleProtector.parseDouble(r100.f20010b)));
        goto L162
    L11:
        if (r101 != 3) goto L13;
    L46:
        c(r110, 150);
        if (r101 == 3) goto L53;
        if (r101 == 15) goto L52;
        if (r101 != 18) goto L162;
        r110.f49950c.a((byte) 71);
        goto L162
    L52:
        r110.f49950c.a((byte) 75);
        goto L162
    L53:
        r110.f49950c.a(Base64.padSymbol);
        goto L162
    L13:
        if (r101 == 4) goto L46;
        if (r101 == 15) goto L46;
        if (r101 == 18) goto L46;
        if (r101 == 24) goto L45;
        if (r101 == 26) goto L32;
        switch(r101) {
            case 28: goto L25;
            case 29: goto L25;
            case 30: goto L25;
            case 31: goto L22;
            default: goto L20;
        };
    L25:
        switch(r101) {
            case 28: goto L29;
            case 29: goto L28;
            case 30: goto L27;
            default: goto L31;
        };
    L27:
        r110.f49950c.a((byte) 4);
        goto L162
    L28:
        r110.f49950c.a((byte) 3);
        goto L162
    L29:
        r110.f49950c.a((byte) 2);
        goto L162
    L31:
        throw new SlcExprException("parser_internal_error", "invalid literal:" + r110.f49948a);
    L20:
        throw new SlcExprException("parser_internal_error", r100 + ": no prefix fn");
    L22:
        if ("0".equals(r100.f20010b) == false) goto L24;
        r110.f49950c.a((byte) 5);
        goto L162
    L24:
        r110.d((byte) 0, (byte) 1, Long.valueOf(CastLongProtector.parseLong(r110.f49948a.f20010b)));
        goto L162
    L32:
        int r108 = 0;
    L33:
        int r109 = r110.f49949b.f20009a;
        if (r109 == 23) goto L44;
        if (r109 == 27) goto L38;
        c(r110, 0);
        r108 = r108 + 1;
        if (r110.e(23) == true) goto L33;
    L38:
        r110.b(27, "array:Expect ']' after array arguments.");
        r110.f49950c.a((byte) 91);
        if (r108 > 127) goto L42;
        r110.f49950c.a((byte) r108);
        goto L162
    L42:
        throw new SlcExprException("parser_invalid_array", "array的最大长度为127: " + r108);
    L44:
        throw new SlcExprException("parser_syntax_error", "array: Unexpected token ','");
    L45:
        c(r110, 0);
        r110.b(25, "Expect ')' after expression");
        goto L162
    L56:
        String r112 = r100.f20010b;
        if (r110.e(24) == true) goto L59;
        int r113 = r112.hashCode();
        if (r113 == 3076010) goto L158;
        if (r113 == 3242771) goto L155;
    L160:
        r110.d((byte) 11, (byte) 12, r112);
        goto L162
    L155:
        if (r112.equals(MapController.ITEM_LAYER_TAG) == false) goto L160;
        r110.f49950c.a((byte) 14);
        goto L162
    L158:
        if (r112.equals("data") == false) goto L160;
        r110.f49950c.a(HTTP.CR);
        goto L162
    L59:
        if (Intrinsics.areEqual(r112, "option") == false) goto L85;
        int r114 = r110.f49949b.f20009a;
        if (r114 == 23) goto L84;
        if (r114 == 25) goto L82;
        c(r110, 0);
        r110.f49950c.a((byte) 29);
        int r115 = r110.c((byte) 97);
        r110.f49950c.a((byte) 99);
        if (r110.e(23) == false) goto L80;
        if (r110.e(25) == true) goto L80;
        c(r110, 0);
        int r116 = r110.c((byte) 98);
        r110.f(r115);
        r110.f49950c.a((byte) 99);
        if (r110.e(23) == false) goto L78;
        if (r110.e(25) == true) goto L78;
        c(r110, 0);
        r110.e(23);
        if (r110.e(25) == false) goto L76;
        r110.f(r116);
        goto L162
    L76:
        throw new SlcExprException("parser_error_param_count", "option函数只能有三个参数:>3");
    L78:
        throw new SlcExprException("parser_error_param_count", "option函数必须有三个参数:2");
    L80:
        throw new SlcExprException("parser_error_param_count", "option函数必须有三个参数:1");
    L82:
        throw new SlcExprException("parser_error_param_count", "option函数必须有三个参数:0");
    L84:
        throw new SlcExprException("parser_error_param_count", "option函数必须有三个参数:0");
    L85:
        int r117 = 0;
    L86:
        int r118 = r110.f49949b.f20009a;
        if (r118 == 23) goto L148;
        if (r118 == 25) goto L92;
        c(r110, 0);
        r117 = r117 + 1;
        if (r110.e(23) == true) goto L86;
    L92:
        r110.b(25, "argumentList:Expect ')' after arguments.");
        switch(r112.hashCode()) {
            case -1411068134: goto L135;
            case -1289044198: goto L132;
            case -1214085344: goto L129;
            case -891992059: goto L126;
            case -501711356: goto L123;
            case 96370: goto L120;
            case 102230: goto L117;
            case 107029: goto L114;
            case 3049733: goto L111;
            case 97526796: goto L108;
            case 108704142: goto L105;
            case 110640556: goto L102;
            case 832583822: goto L99;
            case 1076958445: goto L96;
            default: goto L137;
        };
    L137:
        d r119 = r110.f49953f;
        if (r119 == null) goto L144;
        Map<String, zp.b> r120 = r119.f573174a;
        if (r120 == null) goto L144;
        Object r121 = (zp.b) r120.get(r112);
        if (r121 == null) goto L144;
    L145:
        r110.d((byte) 27, (byte) 28, r121);
    L146:
        r110.f49950c.a((byte) r117);
    L144:
        r121 = new e(r112);
        goto L145
    L96:
        if (r112.equals("versionCompare") == false) goto L137;
        r110.f49950c.a((byte) 35);
        goto L146
    L99:
        if (r112.equals("makeMap") == false) goto L137;
        r110.f49950c.a((byte) 33);
        goto L146
    L102:
        if (r112.equals("trunc") == false) goto L137;
        r110.f49950c.a((byte) 39);
        goto L146
    L105:
        if (r112.equals("round") == false) goto L137;
        r110.f49950c.a((byte) 38);
        goto L146
    L108:
        if (r112.equals("floor") == false) goto L137;
        r110.f49950c.a((byte) 37);
        goto L146
    L111:
        if (r112.equals("ceil") == false) goto L137;
        r110.f49950c.a((byte) 36);
        goto L146
    L114:
        if (r112.equals("len") == false) goto L137;
        r110.f49950c.a((byte) 30);
        goto L146
    L117:
        if (r112.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L137;
        r110.f49950c.a((byte) 31);
        goto L146
    L120:
        if (r112.equals("abs") == false) goto L137;
        r110.f49950c.a((byte) 40);
        goto L146
    L123:
        if (r112.equals("mergeMap") == false) goto L137;
        r110.f49950c.a((byte) 34);
        goto L146
    L126:
        if (r112.equals("strcat") == false) goto L137;
        r110.f49950c.a((byte) 32);
        goto L146
    L129:
        if (r112.equals("cssColor") == false) goto L137;
        r110.f49950c.a((byte) 41);
        goto L146
    L132:
        if (r112.equals(GXTemplateKey.GAIAX_EXTEND) == false) goto L137;
        r110.f49950c.a((byte) 43);
        goto L146
    L135:
        if (r112.equals("append") == false) goto L137;
        r110.f49950c.a((byte) 42);
        goto L146
    L148:
        throw new SlcExprException("parser_syntax_error", "argumentList: Unexpected token ','");
    }
}
