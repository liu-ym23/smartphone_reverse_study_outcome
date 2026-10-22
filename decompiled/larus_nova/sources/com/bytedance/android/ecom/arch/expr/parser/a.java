package com.bytedance.android.ecom.arch.expr.parser;

import bq.b;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ecom.arch.expr.error.SlcExprException;
import com.bytedance.android.ecom.arch.expr.lexer.SlcTokenType;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import kotlin.TypeCastException;
import kotlin.text.CharsKt;
import kotlin.text.Typography;
import org.slf4j.Marker;
import zp.d;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f49948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f49949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cq.a f49950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Object> f49951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bq.a f49952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f49953f;

    public final void a() {
        this.f49948a = this.f49949b;
        bq.a r100 = this.f49952e;
    L3:
        char r101 = r100.d();
        if (r101 == 65535) goto L8;
        if (CharsKt.isWhitespace(r101) == false) goto L8;
        r100.a();
    L8:
        int r102 = r100.f20007b;
        r100.f20006a = r102;
        boolean r103 = false;
        if (r102 < r100.f20008c.length()) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        b r105 = new b(32, "");
    L175:
        this.f49949b = r105;
        return;
    L14:
        char r106 = r100.a();
        if ('a' > r106) goto L17;
        if ('z' < r106) goto L17;
    L20:
        boolean r110 = true;
    L23:
        if (r110 == false) goto L63;
    L24:
        char r107 = r100.d();
        if ('a' > r107) goto L27;
        if ('z' < r107) goto L27;
    L30:
        boolean r108 = true;
    L32:
        if (r108 == true) goto L62;
        if ('0' > r107) goto L37;
        if ('9' < r107) goto L37;
        boolean r109 = true;
    L38:
        if (r109 == true) goto L62;
        String r111 = r100.f20008c;
        int r112 = r100.f20006a;
        int r113 = r100.f20007b;
        if (r111 == null) goto L61;
        String r114 = r111.substring(r112, r113);
        int r115 = r114.hashCode();
        if (r115 == 3392903) goto L56;
        if (r115 == 3569038) goto L53;
        if (r115 == 97196323) goto L50;
    L58:
        b r116 = new b(0, r114);
    L59:
        r105 = r116;
        goto L175
    L50:
        if (r114.equals("false") == false) goto L58;
        r105 = new b(29, "false");
        goto L175
    L53:
        if (r114.equals("true") == false) goto L58;
        r105 = new b(28, "true");
        goto L175
    L56:
        if (r114.equals("null") == false) goto L58;
        r105 = new b(30, "null");
        goto L175
    L61:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L37:
        r109 = false;
    L62:
        r100.a();
    L27:
        if ('A' > r107) goto L29;
        if ('Z' >= r107) goto L30;
    L29:
        if (r107 == '_') goto L30;
        r108 = false;
        goto L32
    L63:
        if ('0' > r106) goto L67;
        if ('9' < r106) goto L67;
        boolean r117 = true;
    L68:
        if (r117 == false) goto L71;
        r105 = r100.c(false);
        goto L175
    L71:
        if (r106 == '!') goto L172;
        if (r106 != '\"') goto L75;
    L132:
        StringBuilder r118 = new StringBuilder();
        char r119 = r100.d();
    L133:
        if (r119 == r106) goto L162;
        if (r119 == 65535) goto L161;
        if (r119 != '\\') goto L157;
        if (r103 == true) goto L140;
        r118.append(r100.f20008c, r100.f20006a + 1, r100.f20007b);
        r103 = true;
    L140:
        r100.a();
        char r120 = r100.d();
        if (r120 == 65535) goto L156;
        if (r120 != 'b') goto L145;
        r118.append('\b');
    L159:
        r100.a();
        r119 = r100.d();
        goto L133
    L145:
        if (r120 != 'n') goto L147;
        r118.append('\n');
        goto L159
    L147:
        if (r120 != 'r') goto L149;
        r118.append('\r');
        goto L159
    L149:
        if (r120 == 't') goto L151;
        r118.append(r120);
        goto L159
    L151:
        r118.append('\t');
        goto L159
    L156:
        throw new SlcExprException("lexer_invalid_string", "unexpected eof after \\");
    L157:
        if (r103 == false) goto L159;
        r118.append(r119);
        goto L159
    L161:
        throw new SlcExprException("lexer_invalid_string", "unexpected eof");
    L162:
        r100.a();
        if (r103 == false) goto L165;
        String r121 = r118.toString();
    L168:
        r116 = new b(1, r121);
        goto L59
    L165:
        String r122 = r100.f20008c;
        int r123 = r100.f20006a + 1;
        int r124 = r100.f20007b - 1;
        if (r122 == null) goto L170;
        r121 = r122.substring(r123, r124);
        goto L168
    L170:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L75:
        if (r106 != '[') goto L77;
        r105 = new b(26, "[");
        goto L175
    L77:
        if (r106 == '|') goto L128;
        if (r106 != '~') goto L81;
        r105 = new b(18, Constants.WAVE_SEPARATOR);
        goto L175
    L81:
        if (r106 != ']') goto L83;
        r105 = new b(27, "]");
        goto L175
    L83:
        if (r106 == '^') goto L124;
        switch(r106) {
            case 37: goto L110;
            case 38: goto L107;
            case 39: goto L132;
            case 40: goto L105;
            case 41: goto L104;
            case 42: goto L101;
            case 43: goto L99;
            case 44: goto L98;
            case 45: goto L97;
            case 46: goto L89;
            case 47: goto L88;
            default: goto L85;
        };
    L85:
        switch(r106) {
            case 60: goto L121;
            case 61: goto L116;
            case 62: goto L112;
            default: goto L87;
        };
    L87:
        throw new SlcExprException("lexer_invalid_token", "invalid token: " + r106);
    L112:
        if (r100.b(com.alipay.sdk.m.n.a.f25612h) == false) goto L114;
        r105 = new b(12, ">=");
        goto L175
    L114:
        r105 = new b(11, ">");
        goto L175
    L116:
        if (r100.b(com.alipay.sdk.m.n.a.f25612h) == false) goto L119;
        r105 = new b(13, "==");
        goto L175
    L119:
        throw new SlcExprException("lexer_invalid_operator", "invalid operator:=");
    L121:
        if (r100.b(com.alipay.sdk.m.n.a.f25612h) == false) goto L123;
        r105 = new b(10, "<=");
        goto L175
    L123:
        r105 = new b(9, "<");
        goto L175
    L88:
        r105 = new b(6, HTTP.URL_DEFAULT);
        goto L175
    L89:
        char r125 = r100.d();
        if ('0' > r125) goto L94;
        if ('9' < r125) goto L94;
        r103 = true;
    L94:
        if (r103 == false) goto L96;
        r105 = r100.c(true);
        goto L175
    L96:
        r105 = new b(22, ".");
        goto L175
    L97:
        r105 = new b(3, "-");
        goto L175
    L98:
        r105 = new b(23, ",");
        goto L175
    L99:
        r105 = new b(4, Marker.ANY_NON_NULL_MARKER);
        goto L175
    L104:
        r105 = new b(25, ")");
        goto L175
    L105:
        r105 = new b(24, "(");
        goto L175
    L110:
        r105 = new b(7, GXTemplateKey.GAIAX_PE);
        goto L175
    L101:
        if (r100.b('*') == false) goto L103;
        r105 = new b(8, "**");
        goto L175
    L103:
        r105 = new b(5, "*");
        goto L175
    L107:
        if (r100.b(Typography.amp) == false) goto L109;
        r105 = new b(16, "&&");
        goto L175
    L109:
        r105 = new b(19, "&");
        goto L175
    L124:
        r105 = new b(21, "^");
        goto L175
    L128:
        if (r100.b('|') == false) goto L130;
        r105 = new b(17, "||");
        goto L175
    L130:
        r105 = new b(20, HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        goto L175
    L172:
        if (r100.b(com.alipay.sdk.m.n.a.f25612h) == false) goto L174;
        r105 = new b(14, "!=");
        goto L175
    L174:
        r105 = new b(15, "!");
    L67:
        r117 = false;
    L17:
        if ('A' > r106) goto L19;
        if ('Z' >= r106) goto L20;
    L19:
        if (r106 == '_') goto L20;
        r110 = false;
        goto L23
    L11:
        r104 = false;
        goto L12
    }

    public final int c(byte r100) {
        this.f49950c.a(r100);
        byte r101 = (byte) 0;
        this.f49950c.a(r101);
        this.f49950c.a(r101);
        return this.f49950c.f464758b - 2;
    }

    public final boolean e(@SlcTokenType int r100) {
        if (this.f49949b.f20009a != r100) goto L6;
        a();
        return true;
    L6:
        return false;
    }

    public final void f(int r100) {
        cq.a r101 = this.f49950c;
        int r102 = r101.f464758b;
        int r103 = (r102 - r100) - 2;
        byte r104 = (byte) (r103 >>> 8);
        if (r100 >= r102) goto L11;
        byte[] r105 = r101.f464757a;
        r105[r100] = r104;
        int r106 = r100 + 1;
        byte r107 = (byte) (r103 & 255);
        if (r106 >= r102) goto L9;
        r105[r106] = r107;
        return;
    L9:
        throw new IndexOutOfBoundsException(r101.c("set", r106));
    L11:
        throw new IndexOutOfBoundsException(r101.c("set", r100));
    }

    public a(bq.a r100, d r101) {
        this.f49952e = r100;
        this.f49953f = r101;
        this.f49948a = new b(32, "");
        this.f49949b = new b(32, "");
        this.f49950c = new cq.a();
        this.f49951d = new ArrayList();
    }

    public final void b(@SlcTokenType int r100, String r101) {
        if (this.f49949b.f20009a != r100) goto L7;
        a();
        return;
    L7:
        throw new SlcExprException("parser_syntax_error", r100 + ':' + this.f49949b.f20010b + ',' + r101);
    }

    public final void d(byte r100, byte r101, Object r102) {
        this.f49951d.add(r102);
        int r103 = this.f49951d.size() - 1;
        if (r103 > 127) goto L5;
        this.f49950c.a(r100);
        this.f49950c.a((byte) r103);
        return;
    L5:
        this.f49950c.a(r101);
        this.f49950c.a((byte) (r103 >>> 8));
        this.f49950c.a((byte) (r103 & 255));
    }
}
