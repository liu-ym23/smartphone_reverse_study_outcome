package cn.com.chinatelecom.account;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class f extends s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f24395c = "f";

    public f(Context r100) {
        super(r100);
    }

    @Override // cn.com.chinatelecom.account.m
    public x a(String r100, String r101, int r102, w r103, boolean r104) {
        if (a(r100) == false) goto L7;
        return b(r100, r101, r102, r103, r104);
    L7:
        return c(r100, r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x054b: IF  (r15 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:275:?, block:B:245:0x054b */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x0542: IF  (r17 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:245:0x054b, block:B:241:0x0542 */
    /* JADX WARN: Type inference failed for: r15v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r15v29 */
    /* JADX WARN: Type inference failed for: r15v30 */
    /* JADX WARN: Type inference failed for: r15v31 */
    /* JADX WARN: Type inference failed for: r15v32 */
    /* JADX WARN: Type inference failed for: r15v33 */
    /* JADX WARN: Type inference failed for: r15v42, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r15v48 */
    /* JADX WARN: Type inference failed for: r15v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r15v51 */
    /* JADX WARN: Type inference failed for: r15v54 */
    /* JADX WARN: Type inference failed for: r15v57 */
    /* JADX WARN: Type inference failed for: r15v60 */
    /* JADX WARN: Type inference failed for: r15v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r15v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r17v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r17v25 */
    /* JADX WARN: Type inference failed for: r17v26 */
    /* JADX WARN: Type inference failed for: r17v27 */
    /* JADX WARN: Type inference failed for: r17v28 */
    /* JADX WARN: Type inference failed for: r17v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r17v51 */
    /* JADX WARN: Type inference failed for: r17v54 */
    /* JADX WARN: Type inference failed for: r17v57 */
    /* JADX WARN: Type inference failed for: r17v60 */
    /* JADX WARN: Type inference failed for: r17v7, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r17v9, types: [java.io.BufferedReader] */
    public x b(String r110, String r210, int r211, w r212, boolean r213) {
        String r100 = "1";
        x r111 = new x();
        boolean r101 = r.l(this.f24450a);     // Catch: Throwable -> L173 IOException -> L186 UnknownHostException -> L199 SocketTimeoutException -> L226
        boolean r102 = a(r212.f24460h, r212.f24461i);     // Catch: Throwable -> L173 IOException -> L186 UnknownHostException -> L199 SocketTimeoutException -> L226
        if (r102 == true) goto L252;
        String r112 = r110;
    L270:
    L170:
        e = e;
        boolean r103 = false;
        InputStream r113 = null;
    L172:
        SocketTimeoutException r104 = e;
        r102 = r102;
        Object r114 = r113;
        Object r115 = r113;
    L228:
        r102 = r102;
        ?? r116 = r114;
        ?? r117 = r115;
    L230:
        if (r212.f24459g == true) goto L233;
        if (r102 == false) goto L233;
        r111.f24478d = r103;     // Catch: Throwable -> L239
    L233:
        r111.f24476b = y.a(80005, h0.a(y.f24485f) + "-" + r212.f24457e + "-" + r104.getMessage());     // Catch: Throwable -> L239
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L239
        r105.append("SocketTimeoutException : ");     // Catch: Throwable -> L239
        r105.append(r104.getMessage());     // Catch: Throwable -> L239
        q.a(r212.f24458f, r111.f24476b, r105.toString());     // Catch: Throwable -> L239
        CtAuth.warn(f24395c, "STE_" + r212.f24457e + "_" + r104.getMessage(), r104);     // Catch: Throwable -> L239
        if (r117 == 0) goto L236;
        r117.close();     // Catch: IOException -> L220
    L236:
        if (r116 == 0) goto L238;
        r116.close();     // Catch: IOException -> L220
    L238:
        return r111;
    L167:
        e = e;
        r103 = false;
        r113 = null;
    L169:
        UnknownHostException r106 = e;
        r102 = r102;
        Object r118 = r113;
        Object r119 = r113;
    L201:
        r102 = r102;
        ?? r120 = r118;
        ?? r121 = r119;
    L202:
        if (r213 == true) goto L209;
        if (r212.f24459g == true) goto L207;
        if (r102 == false) goto L207;
        r111.f24478d = r103;     // Catch: Throwable -> L239
    L207:
        r111.f24476b = y.a(80006, h0.a(y.f24486g) + "-" + r212.f24457e + "-" + r106.getMessage());     // Catch: Throwable -> L239
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L239
        r107.append("UnknownHostException : ");     // Catch: Throwable -> L239
        r107.append(r106.getMessage());     // Catch: Throwable -> L239
        q.a(r212.f24458f, r111.f24476b, r107.toString());     // Catch: Throwable -> L239
        CtAuth.warn(f24395c, "UnknownHostException-" + r212.f24457e + "-" + r106.getMessage(), r106);     // Catch: Throwable -> L239
    L209:
        if (r112.contains(h0.a(e.f24390g)) == true) goto L212;
        r100 = "2";
    L212:
        r111.f24479e = r100;     // Catch: Throwable -> L239
        r111.f24478d = true;     // Catch: Throwable -> L239
        if (r121 != 0) goto L258;
    L216:
        if (r120 == 0) goto L218;
        r120.close();     // Catch: Throwable -> L215
    L218:
        if (r121 == 0) goto L222;
        r121.close();     // Catch: IOException -> L220
    L222:
        if (r120 == 0) goto L238;
        r120.close();     // Catch: IOException -> L220
        goto L238
    L258:
        r121.close();     // Catch: Throwable -> L215
    L164:
        e = e;
        r103 = false;
        r113 = null;
    L166:
        IOException r108 = e;
        r102 = r102;
        Object r122 = r113;
        Object r123 = r113;
    L188:
        r102 = r102;
        ?? r124 = r122;
        ?? r125 = r123;
    L190:
        if (r212.f24459g == true) goto L193;
        if (r102 == false) goto L193;
        r111.f24478d = r103;     // Catch: Throwable -> L239
    L193:
        r111.f24476b = y.a(80007, h0.a(y.f24487h) + "-" + r212.f24457e + "-" + r108.getMessage());     // Catch: Throwable -> L239
        StringBuilder r109 = new StringBuilder();     // Catch: Throwable -> L239
        r109.append("IOException : ");     // Catch: Throwable -> L239
        r109.append(r108.getMessage());     // Catch: Throwable -> L239
        q.a(r212.f24458f, r111.f24476b, r109.toString());     // Catch: Throwable -> L239
        CtAuth.warn(f24395c, "IOException-" + r212.f24457e + "-" + r108.getMessage(), r108);     // Catch: Throwable -> L239
        if (r125 == 0) goto L196;
        r125.close();     // Catch: IOException -> L220
    L196:
        if (r124 == 0) goto L238;
        r124.close();     // Catch: IOException -> L220
    L161:
        th = th;
        r103 = false;
        r113 = null;
    L163:
        Throwable r126 = th;
        r102 = r102;
        Object r127 = r113;
        Object r128 = r113;
    L175:
        r102 = r102;
        ?? r129 = r127;
        ?? r130 = r128;
    L177:
        if (r212.f24459g == true) goto L180;
        if (r102 == false) goto L180;
        r111.f24478d = r103;     // Catch: Throwable -> L239
    L180:
        r111.f24476b = y.a(80001, h0.a(y.f24481b) + "-" + r212.f24457e + "-" + r126.getMessage());     // Catch: Throwable -> L239
        StringBuilder r131 = new StringBuilder();     // Catch: Throwable -> L239
        r131.append("Throwable : ");     // Catch: Throwable -> L239
        r131.append(r126.getMessage());     // Catch: Throwable -> L239
        q.a(r212.f24458f, r111.f24476b, r131.toString());     // Catch: Throwable -> L239
        CtAuth.warn(f24395c, "Throwable-" + r212.f24457e + "-" + r126.getMessage(), r126);     // Catch: Throwable -> L239
        if (r130 == 0) goto L183;
        r130.close();     // Catch: IOException -> L220
    L183:
        if (r129 == 0) goto L238;
        r129.close();     // Catch: IOException -> L220
        goto L238
    L24:
        if (r212.f24456d <= 0) goto L33;
        if (r101 == true) goto L33;
        if (b() == true) goto L33;
        s.a(this.f24450a, r112);     // Catch: Throwable -> L9 IOException -> L12 SocketTimeoutException -> L19 UnknownHostException -> L30
    L30:
        e = e;
    L17:
        r106 = e;
        r103 = false;
        InputStream r132 = null;
    L18:
        r119 = null;
        r118 = r132;
    L19:
        e = move-exception;
        r104 = e;
        r103 = false;
        InputStream r133 = null;
    L21:
        r115 = null;
        r114 = r133;
    L12:
        e = move-exception;
        r108 = e;
        r103 = false;
        InputStream r134 = null;
    L14:
        r123 = null;
        r122 = r134;
    L9:
        th = move-exception;
        r126 = th;
        r103 = false;
        InputStream r135 = null;
    L11:
        r128 = null;
        r127 = r135;
    L33:
        HttpsURLConnection r136 = b(r112, r210, r211, r212);     // Catch: Throwable -> L161 IOException -> L164 UnknownHostException -> L167 SocketTimeoutException -> L170
        int r137 = r136.getResponseCode();     // Catch: Throwable -> L161 IOException -> L164 UnknownHostException -> L167 SocketTimeoutException -> L170
    L35:
        if (r137 == 200) goto L268;
        Object r138 = null;
        if (r137 == 302) goto L262;
        r113 = null;
        r103 = false;
        if (r213 == true) goto L143;
        r.a(this.f24450a, 0);     // Catch: Throwable -> L153 IOException -> L155 UnknownHostException -> L157 SocketTimeoutException -> L159
        r111.f24476b = y.a(80002, h0.a(y.f24482c) + "-" + r212.f24457e + "-code : " + r137);     // Catch: Throwable -> L153 IOException -> L155 UnknownHostException -> L157 SocketTimeoutException -> L159
        StringBuilder r139 = new StringBuilder("response code ：");     // Catch: Throwable -> L153 IOException -> L155 UnknownHostException -> L157 SocketTimeoutException -> L159
        r139.append(r137);     // Catch: Throwable -> L153 IOException -> L155 UnknownHostException -> L157 SocketTimeoutException -> L159
        String r140 = r139.toString();     // Catch: Throwable -> L153 IOException -> L155 UnknownHostException -> L157 SocketTimeoutException -> L159
        q.a(r212.f24458f, r111.f24476b, r140);     // Catch: Throwable -> L153 IOException -> L155 UnknownHostException -> L157 SocketTimeoutException -> L159
        CtAuth.info(f24395c, r140);     // Catch: Throwable -> L153 IOException -> L155 UnknownHostException -> L157 SocketTimeoutException -> L159
        return r111;
    L143:
        if (r112.contains(h0.a(e.f24390g)) == false) goto L145;
        String r141 = "1";
    L146:
        r111.f24479e = r141;     // Catch: Throwable -> L153 IOException -> L155 UnknownHostException -> L157 SocketTimeoutException -> L159
        r111.f24478d = true;     // Catch: Throwable -> L153 IOException -> L155 UnknownHostException -> L157 SocketTimeoutException -> L159
        InputStream r142 = r113;
    L147:
        InputStream r143 = r142;
        ?? r144 = r143;
        InputStream r145 = r143;
    L148:
        if (r144 == 0) goto L150;
        r144.close();     // Catch: IOException -> L220
    L150:
        if (r145 == null) goto L238;
        r145.close();     // Catch: IOException -> L220
        goto L238
    L145:
        r141 = "2";
    L159:
        e = e;
    L157:
        e = e;
    L155:
        e = e;
    L153:
        th = th;
        goto L163
    L262:
        int r146 = r212.f24456d;     // Catch: Throwable -> L126 IOException -> L129 UnknownHostException -> L132 SocketTimeoutException -> L135
        if (r146 >= 10) goto L116;
        r212.f24456d = r146 + 1;     // Catch: Throwable -> L126 IOException -> L129 UnknownHostException -> L132 SocketTimeoutException -> L135
        r212.f24460h = false;     // Catch: Throwable -> L126 IOException -> L129 UnknownHostException -> L132 SocketTimeoutException -> L135
        String r147 = r136.getHeaderField("Location");     // Catch: Throwable -> L126 IOException -> L129 UnknownHostException -> L132 SocketTimeoutException -> L135
        k r148 = a.a(r136);     // Catch: Throwable -> L126 IOException -> L129 UnknownHostException -> L132 SocketTimeoutException -> L135
        q.b(r212.f24458f).f(r148.f24409c).e(r.c(this.f24450a));     // Catch: Throwable -> L126 IOException -> L129 UnknownHostException -> L132 SocketTimeoutException -> L135
        if (TextUtils.isEmpty(r148.f24410d) == false) goto L260;
    L111:
        int r149 = 0;
    L112:
        CtAuth.info(f24395c, "method : " + r149);     // Catch: Throwable -> L126 IOException -> L129 UnknownHostException -> L132 SocketTimeoutException -> L135
    L115:
        return a(r147, null, r149, r212, false);
    L260:
        if (r148.f24410d.equals("0") == true) goto L111;
        r149 = 1;
        goto L112
    L109:
        e = e;
    L91:
        r104 = e;
        Object r150 = r138;
        Object r151 = r150;
        Object r152 = r150;
    L92:
        r103 = false;
        r114 = r152;
        r115 = r151;
    L107:
        e = e;
    L87:
        r106 = e;
        Object r153 = r138;
        Object r154 = r153;
        Object r155 = r153;
    L88:
        r103 = false;
        r118 = r155;
        r119 = r154;
    L105:
        e = e;
    L83:
        r108 = e;
        Object r156 = r138;
        Object r157 = r156;
        Object r158 = r156;
    L84:
        r103 = false;
        r122 = r158;
        r123 = r157;
    L103:
        th = th;
    L79:
        r126 = th;
        Object r159 = r138;
        Object r160 = r159;
        Object r161 = r159;
    L80:
        r103 = false;
        r127 = r161;
        r128 = r160;
        goto L175
    L116:
        r142 = null;
        JSONObject r162 = y.a(80001, h0.a(y.f24481b) + "-Redirect more than 10 times");     // Catch: Throwable -> L118 IOException -> L120 UnknownHostException -> L122 SocketTimeoutException -> L124
        r111.f24476b = r162;     // Catch: Throwable -> L118 IOException -> L120 UnknownHostException -> L122 SocketTimeoutException -> L124
        q.a(r212.f24458f, r162, "Redirect more than 10 times");     // Catch: Throwable -> L118 IOException -> L120 UnknownHostException -> L122 SocketTimeoutException -> L124
    L124:
        e = e;
    L137:
        r104 = e;
        r152 = null;
    L122:
        e = e;
    L134:
        r106 = e;
        r155 = null;
    L120:
        e = e;
    L131:
        r108 = e;
        r158 = null;
    L118:
        th = th;
    L128:
        r126 = th;
        r161 = null;
    L135:
        e = e;
        r151 = null;
    L132:
        e = e;
        r154 = null;
    L129:
        e = e;
        r157 = null;
    L126:
        th = th;
        r160 = null;
        goto L128
    L268:
        InputStream r163 = r136.getInputStream();     // Catch: Throwable -> L77 IOException -> L81 UnknownHostException -> L85 SocketTimeoutException -> L89
        StringBuilder r164 = new StringBuilder();     // Catch: Throwable -> L69 IOException -> L71 UnknownHostException -> L73 SocketTimeoutException -> L75
        BufferedReader r165 = new BufferedReader(new InputStreamReader(r163));     // Catch: Throwable -> L69 IOException -> L71 UnknownHostException -> L73 SocketTimeoutException -> L75
    L273:
        String r166 = r165.readLine();     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
        if (r166 == null) goto L41;
        r164.append(r166);     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
        r164.append("\n");     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
        goto L273
    L41:
        r111.f24475a = 0;     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
        String r167 = r164.toString();     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
        if (TextUtils.isEmpty(r167) == true) goto L44;
        JSONObject r168 = new JSONObject(r167);     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
        r111.f24476b = r168;     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
        q.a(r212.f24458f, r168, null);     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
    L44:
        k r169 = a.a(this.f24450a, r136, true);     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
        if (r169 == null) goto L48;
        r111.f24477c = r169.f24407a;     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
        q.b(r212.f24458f).f(r169.f24409c);     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
    L48:
        if (r169.f24411e == false) goto L55;
        if (r213 == false) goto L55;
        if (r112.contains(h0.a(e.f24390g)) == false) goto L53;
        String r170 = "1";
    L54:
        r111.f24479e = r170;     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
        r111.f24478d = true;     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
        goto L55
    L53:
        r170 = "2";
    L55:
        if (r213 == false) goto L57;
    L60:
        r144 = r165;
        r145 = r163;
        goto L148
    L57:
        if (r112.contains(h0.a(e.f24389f)) == false) goto L59;
        r.a(this.f24450a, 0);     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
        goto L60
    L59:
        r.a(this.f24450a, "2");     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
        r.a(this.f24450a, System.currentTimeMillis());     // Catch: Throwable -> L61 IOException -> L63 UnknownHostException -> L65 SocketTimeoutException -> L67
    L67:
        e = move-exception;
        r104 = e;
        r116 = r163;
        r117 = r165;
        r103 = false;
    L65:
        e = move-exception;
        r106 = e;
        r120 = r163;
        r121 = r165;
        r103 = false;
    L63:
        e = move-exception;
        r108 = e;
        r124 = r163;
        r125 = r165;
        r103 = false;
    L61:
        th = move-exception;
        r126 = th;
        r129 = r163;
        r130 = r165;
        r103 = false;
    L75:
        e = move-exception;
        r104 = e;
        r133 = r163;
        r103 = false;
    L73:
        e = move-exception;
        r106 = e;
        r132 = r163;
        r103 = false;
    L71:
        e = move-exception;
        r108 = e;
        r134 = r163;
        r103 = false;
    L69:
        th = move-exception;
        r126 = th;
        r135 = r163;
        r103 = false;
        goto L11
    L89:
        e = e;
        r138 = null;
    L85:
        e = e;
        r138 = null;
    L81:
        e = e;
        r138 = null;
    L77:
        th = th;
        r138 = null;
        goto L79
    L252:
        r112 = r110;
        r112 = r112.replace(r212.f24462j, r212.f24461i);     // Catch: Throwable -> L9 IOException -> L12 SocketTimeoutException -> L19 UnknownHostException -> L30
    L15:
        e = e;
        r112 = r110;
        goto L17
    L239:
        th = move-exception;
        if (r17 != null) goto L250;
    L245:
        if (r15 == null) goto L275;
        r15.close();     // Catch: IOException -> L243
        throw th;
    L243:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L275:
        throw th;
    L250:
        r17.close();     // Catch: IOException -> L243
    L226:
        e = move-exception;
        r103 = false;
        r115 = null;
        r104 = e;
        r114 = null;
        r102 = false;
    L199:
        e = move-exception;
        r112 = r110;
        r103 = false;
        r119 = null;
        r106 = e;
        r118 = null;
        r102 = false;
    L186:
        e = move-exception;
        r103 = false;
        r123 = null;
        r108 = e;
        r122 = null;
        r102 = false;
    L173:
        th = move-exception;
        r103 = false;
        r128 = null;
        r126 = th;
        r127 = null;
        r102 = false;
    L220:
        e = move-exception;
        e.printStackTrace();
        goto L238
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.InputStream] */
    public x c(String r110, String r111, int r112, w r113) {
        ?? r100 = " method : ";
        x r114 = new x();
        BufferedReader r115 = null;
        HttpURLConnection r101 = a(r110, r111, r112, r113);     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        int r102 = r101.getResponseCode();     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        if (r102 != 200) goto L34;
        InputStream r103 = r101.getInputStream();     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L25 IOException -> L27 UnknownHostException -> L29 SocketTimeoutException -> L31
        BufferedReader r105 = new BufferedReader(new InputStreamReader(r103));     // Catch: Throwable -> L25 IOException -> L27 UnknownHostException -> L29 SocketTimeoutException -> L31
    L106:
        String r106 = r105.readLine();     // Catch: Throwable -> L17 IOException -> L19 UnknownHostException -> L21 SocketTimeoutException -> L23
        if (r106 == null) goto L10;
        r104.append(r106);     // Catch: Throwable -> L17 IOException -> L19 UnknownHostException -> L21 SocketTimeoutException -> L23
        r104.append("\n");     // Catch: Throwable -> L17 IOException -> L19 UnknownHostException -> L21 SocketTimeoutException -> L23
        goto L106
    L10:
        r114.f24475a = 0;     // Catch: Throwable -> L17 IOException -> L19 UnknownHostException -> L21 SocketTimeoutException -> L23
        String r107 = r104.toString();     // Catch: Throwable -> L17 IOException -> L19 UnknownHostException -> L21 SocketTimeoutException -> L23
        if (TextUtils.isEmpty(r107) == true) goto L13;
        JSONObject r108 = new JSONObject(r107);     // Catch: Throwable -> L17 IOException -> L19 UnknownHostException -> L21 SocketTimeoutException -> L23
        r114.f24476b = r108;     // Catch: Throwable -> L17 IOException -> L19 UnknownHostException -> L21 SocketTimeoutException -> L23
        q.a(r113.f24458f, r108, null);     // Catch: Throwable -> L17 IOException -> L19 UnknownHostException -> L21 SocketTimeoutException -> L23
    L13:
        q.a(r113.f24458f, r114.f24476b, null);     // Catch: Throwable -> L17 IOException -> L19 UnknownHostException -> L21 SocketTimeoutException -> L23
        k r109 = a.a(this.f24450a, r101, true);     // Catch: Throwable -> L17 IOException -> L19 UnknownHostException -> L21 SocketTimeoutException -> L23
        if (r109 == null) goto L16;
        r114.f24477c = r109.f24407a;     // Catch: Throwable -> L17 IOException -> L19 UnknownHostException -> L21 SocketTimeoutException -> L23
        r114.f24478d = r109.f24411e;     // Catch: Throwable -> L17 IOException -> L19 UnknownHostException -> L21 SocketTimeoutException -> L23
        q.b(r113.f24458f).f(r109.f24409c).e(r.c(this.f24450a));     // Catch: Throwable -> L17 IOException -> L19 UnknownHostException -> L21 SocketTimeoutException -> L23
    L16:
        r115 = r105;
        InputStream r116 = r103;
    L49:
        if (r115 == null) goto L53;
        r115.close();     // Catch: IOException -> L51
    L53:
        if (r116 == null) goto L88;
        r116.close();     // Catch: IOException -> L51
    L88:
        return r114;
    L23:
        e = move-exception;
        SocketTimeoutException r117 = e;
        r115 = r105;
        r100 = r103;
    L83:
        r114.f24476b = y.a(80005, h0.a(y.f24485f) + "-" + r113.f24457e + "-" + r117.getMessage());     // Catch: Throwable -> L89
        CtAuth.warn(f24395c, "SocketTimeoutException-" + r113.f24457e + "-" + r117.getMessage(), r117);     // Catch: Throwable -> L89
        StringBuilder r118 = new StringBuilder();     // Catch: Throwable -> L89
        r118.append("SocketTimeoutException ：");     // Catch: Throwable -> L89
        r118.append(r117.getMessage());     // Catch: Throwable -> L89
        q.a(r113.f24458f, r114.f24476b, r118.toString());     // Catch: Throwable -> L89
        if (r115 == null) goto L86;
        r115.close();     // Catch: IOException -> L51
    L86:
        if (r100 == 0) goto L102;
        r100.close();     // Catch: IOException -> L51
    L102:
    L21:
        e = move-exception;
        UnknownHostException r119 = e;
        r115 = r105;
        r100 = r103;
    L75:
        r114.f24476b = y.a(80006, h0.a(y.f24486g) + "-" + r113.f24457e + "-" + r119.getMessage());     // Catch: Throwable -> L89
        CtAuth.warn(f24395c, "UnknownHostException-" + r113.f24457e + "-" + r119.getMessage(), r119);     // Catch: Throwable -> L89
        StringBuilder r120 = new StringBuilder();     // Catch: Throwable -> L89
        r120.append("UnknownHostException ：");     // Catch: Throwable -> L89
        r120.append(r119.getMessage());     // Catch: Throwable -> L89
        q.a(r113.f24458f, r114.f24476b, r120.toString());     // Catch: Throwable -> L89
        if (r115 == null) goto L78;
        r115.close();     // Catch: IOException -> L51
    L78:
        if (r100 == 0) goto L102;
        r100.close();     // Catch: IOException -> L51
    L19:
        e = move-exception;
        IOException r121 = e;
        r115 = r105;
        r100 = r103;
    L67:
        r114.f24476b = y.a(80007, h0.a(y.f24487h) + "-" + r113.f24457e + "-" + r121.getMessage());     // Catch: Throwable -> L89
        CtAuth.warn(f24395c, "IOException-" + r113.f24457e + "-" + r121.getMessage(), r121);     // Catch: Throwable -> L89
        StringBuilder r122 = new StringBuilder();     // Catch: Throwable -> L89
        r122.append("IOException ：");     // Catch: Throwable -> L89
        r122.append(r121.getMessage());     // Catch: Throwable -> L89
        q.a(r113.f24458f, r114.f24476b, r122.toString());     // Catch: Throwable -> L89
        if (r115 == null) goto L70;
        r115.close();     // Catch: IOException -> L51
    L70:
        if (r100 == 0) goto L102;
        r100.close();     // Catch: IOException -> L51
    L17:
        th = move-exception;
        Throwable r123 = th;
        r115 = r105;
        r100 = r103;
    L59:
        r114.f24476b = y.a(80001, h0.a(y.f24481b) + "-" + r113.f24457e + "-" + r123.getMessage());     // Catch: Throwable -> L89
        CtAuth.warn(f24395c, "Throwable-" + r113.f24457e + "-" + r123.getMessage(), r123);     // Catch: Throwable -> L89
        StringBuilder r124 = new StringBuilder();     // Catch: Throwable -> L89
        r124.append("Throwable ：");     // Catch: Throwable -> L89
        r124.append(r123.getMessage());     // Catch: Throwable -> L89
        q.a(r113.f24458f, r114.f24476b, r124.toString());     // Catch: Throwable -> L89
        if (r115 == null) goto L62;
        r115.close();     // Catch: IOException -> L51
    L62:
        if (r100 == 0) goto L102;
        r100.close();     // Catch: IOException -> L51
        goto L102
    L31:
        e = move-exception;
        r117 = e;
        r100 = r103;
    L29:
        e = move-exception;
        r119 = e;
        r100 = r103;
    L27:
        e = move-exception;
        r121 = e;
        r100 = r103;
    L25:
        th = move-exception;
        r123 = th;
        r100 = r103;
        goto L59
    L34:
        if (r102 != 302) goto L47;
        int r125 = r113.f24456d;     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        if (r125 >= 10) goto L46;
        r113.f24456d = r125 + 1;     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        r113.f24460h = false;     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        String r126 = r101.getHeaderField("Location");     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        k r127 = a.a(r101);     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        q.b(r113.f24458f).f(r127.f24409c).e(r.c(this.f24450a));     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        if (TextUtils.isEmpty(r127.f24410d) == false) goto L40;
    L43:
        int r128 = 0;
    L44:
        CtAuth.info(f24395c, " method : " + r128);     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        return a(r126, null, r128, r113, false);
    L40:
        if (r127.f24410d.equals("0") == true) goto L43;
        r128 = 1;
        goto L44
    L46:
        JSONObject r129 = y.a(80001, h0.a(y.f24481b) + "-Redirect more than 10 times");     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        r114.f24476b = r129;     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        q.a(r113.f24458f, r129, "Redirect more than 10 times");     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
    L48:
        r116 = null;
        goto L49
    L47:
        r114.f24476b = y.a(80002, h0.a(y.f24482c) + "-" + r113.f24457e + "-code : " + r102);     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        StringBuilder r130 = new StringBuilder(" Http response code :");     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        r130.append(r102);     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        String r131 = r130.toString();     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        q.a(r113.f24458f, r114.f24476b, r131);     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
        CtAuth.info(f24395c, r131);     // Catch: Throwable -> L57 IOException -> L65 UnknownHostException -> L73 SocketTimeoutException -> L81
    L89:
        th = move-exception;
        if (r115 != null) goto L100;
    L95:
        if (r100 == 0) goto L111;
        r100.close();     // Catch: IOException -> L93
        throw th;
    L93:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L111:
        throw th;
    L100:
        r115.close();     // Catch: IOException -> L93
    L81:
        e = move-exception;
        r117 = e;
        r100 = 0;
    L73:
        e = move-exception;
        r119 = e;
        r100 = 0;
    L65:
        e = move-exception;
        r121 = e;
        r100 = 0;
    L57:
        th = move-exception;
        r123 = th;
        r100 = 0;
    L51:
        e = move-exception;
        e.printStackTrace();
        goto L88
    }
}
