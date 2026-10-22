package h2;

import A6.l;
import D7.N;
import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import com.stepos.agentframework.adapter.bff.BffConstant;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: h2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1483a {

    /* renamed from: a, reason: collision with root package name */
    public B0.f f4543a;
    public final Context b;
    public volatile boolean c;
    public JSONObject f;
    public JSONObject g;
    public JSONArray l;
    public JSONObject m;
    public JSONArray p;

    /* renamed from: q, reason: collision with root package name */
    public JSONArray f4545q;

    /* renamed from: r, reason: collision with root package name */
    public JSONObject f4546r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4547s;
    public volatile boolean u;
    public long d = -1;
    public boolean e = true;
    public String h = EnvironmentCompat.MEDIA_UNKNOWN;
    public String i = EnvironmentCompat.MEDIA_UNKNOWN;

    /* renamed from: j, reason: collision with root package name */
    public String f4544j = EnvironmentCompat.MEDIA_UNKNOWN;
    public String k = "npth_inner_default";
    public int n = 0;
    public long o = -1;

    /* renamed from: t, reason: collision with root package name */
    public final Object f4548t = new Object();

    /* renamed from: v, reason: collision with root package name */
    public long f4549v = -1;

    /* renamed from: w, reason: collision with root package name */
    public long f4550w = 0;

    /* renamed from: x, reason: collision with root package name */
    public final l f4551x = new l(this, 29);
    public int y = 0;

    /* renamed from: z, reason: collision with root package name */
    public LinkedList f4552z = null;

    /* renamed from: A, reason: collision with root package name */
    public Pattern f4541A = null;

    /* renamed from: B, reason: collision with root package name */
    public File f4542B = null;

    public C1483a(Context context) {
        this.b = context;
    }

    public static String a(float f) {
        return f <= 0.0f ? "0%" : f <= 0.1f ? "0% - 10%" : f <= 0.3f ? "10% - 30%" : f <= 0.6f ? "30% - 60%" : f <= 0.9f ? "60% - 90%" : "90% - 100%";
    }

    public static void d(HashMap map, JSONObject jSONObject, String str) throws JSONException {
        String strConcat = "npth_anr_".concat(str);
        if (map.isEmpty()) {
            jSONObject.put(strConcat + "_total", "not found");
            return;
        }
        float fFloatValue = 0.0f;
        float fFloatValue2 = 0.0f;
        float fFloatValue3 = 0.0f;
        float fFloatValue4 = 0.0f;
        float fFloatValue5 = 0.0f;
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            if (str2.endsWith(BffConstant.Role.User)) {
                fFloatValue += ((Float) entry.getValue()).floatValue();
            } else if (str2.endsWith("kernel")) {
                fFloatValue2 += ((Float) entry.getValue()).floatValue();
            } else if (str2.endsWith("iowait")) {
                fFloatValue3 += ((Float) entry.getValue()).floatValue();
            } else if (str2.endsWith("irq")) {
                fFloatValue4 += ((Float) entry.getValue()).floatValue();
            } else if (str2.endsWith("softirq")) {
                fFloatValue5 += ((Float) entry.getValue()).floatValue();
            }
        }
        float f = fFloatValue + fFloatValue2 + fFloatValue3 + fFloatValue4 + fFloatValue5;
        jSONObject.put(androidx.appfunctions.metadata.a.l(strConcat, "_total"), a(f / 100.0f));
        String strA = "0%";
        jSONObject.put(strConcat + "_kernel_user_ratio", f > 0.0f ? a(fFloatValue2 / f) : fFloatValue2 > 0.0f ? "100%" : "0%");
        String str3 = strConcat + "_iowait_user_ratio";
        if (f > 0.0f) {
            strA = a(fFloatValue3 / f);
        } else if (fFloatValue3 > 0.0f) {
            strA = "100%";
        }
        jSONObject.put(str3, strA);
    }

    public final JSONObject b(String str, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayE = N.e(jSONArray);
        if (jSONArrayE.length() != jSONArray.length()) {
            this.n++;
        }
        try {
            jSONObject.put("thread_name", str);
            jSONObject.put("thread_stack", jSONArrayE);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f5, code lost:
    
        r11 = r11 / y2.AbstractC2128a.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01fe, code lost:
    
        r3.put(r9, java.lang.Float.valueOf(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0206, code lost:
    
        r23 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0208, code lost:
    
        r3.put(r8 + "total", r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x021a, code lost:
    
        r11 = r23 + 3;
        r23 = r12;
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0224, code lost:
    
        r12 = "softirq";
        r28 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0228, code lost:
    
        if (r9 != 0) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x022b, code lost:
    
        if (r9 != 1) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x022e, code lost:
    
        if (r9 != 2) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0231, code lost:
    
        if (r9 != 3) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0234, code lost:
    
        if (r9 != 4) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0236, code lost:
    
        r29 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0239, code lost:
    
        if (r9 != 5) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x023d, code lost:
    
        r29 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0240, code lost:
    
        r29 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0243, code lost:
    
        r29 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0246, code lost:
    
        r29 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0249, code lost:
    
        r29 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0253, code lost:
    
        if (com.stepos.agentframework.adapter.bff.BffConstant.Role.User.equalsIgnoreCase(r28[r11]) != false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0255, code lost:
    
        r12 = com.stepos.agentframework.adapter.bff.BffConstant.Role.User;
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0260, code lost:
    
        if ("kernel".equalsIgnoreCase(r28[r11]) != false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0262, code lost:
    
        r12 = "kernel";
        r9 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x026d, code lost:
    
        if ("iowait".equalsIgnoreCase(r28[r11]) == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x026f, code lost:
    
        r12 = "iowait";
        r9 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x027a, code lost:
    
        if ("irq".equalsIgnoreCase(r28[r11]) == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x027c, code lost:
    
        r12 = "irq";
        r9 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0285, code lost:
    
        if ("softirq".equalsIgnoreCase(r28[r11]) == false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0287, code lost:
    
        r9 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x028f, code lost:
    
        if ("softirq".equalsIgnoreCase(r28[r11]) != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0291, code lost:
    
        r9 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0293, code lost:
    
        r9 = r29;
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0296, code lost:
    
        if (r12 != null) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x029a, code lost:
    
        r27 = java.lang.Float.valueOf(r28[r11 - 1].replace(r6, "")).floatValue();
        r1 = r8 + r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02b9, code lost:
    
        if (r3 == r4) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02bb, code lost:
    
        r29 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02be, code lost:
    
        r29 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02c0, code lost:
    
        r27 = r27 / y2.AbstractC2128a.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02c9, code lost:
    
        r3.put(r1, java.lang.Float.valueOf(r27));
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02d2, code lost:
    
        r29 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02d4, code lost:
    
        r3.put(r8 + r12, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02e7, code lost:
    
        r29 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02ea, code lost:
    
        if (r9 < 6) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02ee, code lost:
    
        r11 = r11 + 3;
        r1 = r28;
        r6 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d3, code lost:
    
        r11 = java.lang.Float.valueOf(r1[r9].replace("%", "")).floatValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01e1, code lost:
    
        r23 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01e3, code lost:
    
        r9 = r8 + "total";
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01f2, code lost:
    
        if (r3 != r4) goto L100;
     */
    /* JADX WARN: Removed duplicated region for block: B:133:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0272 A[PHI: r29
      0x0272: PHI (r29v3 char) = (r29v2 char), (r29v17 char) binds: [B:132:0x026d, B:122:0x0240] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x027f A[PHI: r29
      0x027f: PHI (r29v4 char) = (r29v3 char), (r29v18 char) binds: [B:135:0x027a, B:121:0x023d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0289 A[PHI: r29
      0x0289: PHI (r29v14 char) = (r29v4 char), (r29v19 char) binds: [B:138:0x0285, B:119:0x0239] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02ee A[LOOP:2: B:106:0x0221->B:158:0x02ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0405 A[EDGE_INSN: B:233:0x0405->B:206:0x0405 BREAK  A[LOOP:0: B:3:0x0045->B:207:0x040a], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x040a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0091 A[EDGE_INSN: B:237:0x0091->B:21:0x0091 BREAK  A[LOOP:2: B:106:0x0221->B:158:0x02ee], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.lang.String r31, org.json.JSONObject r32) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1174
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.C1483a.c(java.lang.String, org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0158 A[Catch: all -> 0x017d, TRY_LEAVE, TryCatch #7 {all -> 0x017d, blocks: (B:83:0x014a, B:85:0x0158), top: B:126:0x014a }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x017d A[PHI: r0
      0x017d: PHI (r0v10 java.lang.String) = (r0v9 java.lang.String), (r0v12 java.lang.String) binds: [B:119:0x017d, B:84:0x0156] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(org.json.JSONArray r18) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.C1483a.e(org.json.JSONArray):void");
    }

    public final boolean f(String str) {
        if (this.f4552z == null) {
            JSONArray jSONArrayF = N.f(z2.b.b(), "custom_event_settings", "npth_simple_setting", "max_utm_thread_ignore");
            if (jSONArrayF != null) {
                this.f4552z = new LinkedList();
                this.k = jSONArrayF.optString(0);
                for (int i = 1; i < jSONArrayF.length(); i++) {
                    try {
                        this.f4552z.add(Pattern.compile(jSONArrayF.optString(i)));
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.f4552z == null) {
                LinkedList linkedList = new LinkedList();
                this.f4552z = linkedList;
                linkedList.add(Pattern.compile("^main$"));
                this.f4552z.add(Pattern.compile("^default_npth_thread$"));
                this.f4552z.add(Pattern.compile("^RenderThread$"));
                this.f4552z.add(Pattern.compile("^Jit thread pool worker thread.*$"));
            }
        }
        Iterator it = this.f4552z.iterator();
        while (it.hasNext()) {
            if (((Pattern) it.next()).matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0400 A[Catch: all -> 0x0417, TRY_LEAVE, TryCatch #4 {all -> 0x0417, blocks: (B:90:0x027a, B:94:0x0289, B:116:0x02f1, B:120:0x03a7, B:124:0x03cd, B:126:0x0400, B:130:0x040e, B:127:0x0409), top: B:167:0x027a, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instructions count: 1246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.C1483a.g():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(long r20) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.C1483a.h(long):void");
    }

    public final int[] i(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i);
            int iIndexOf = (strOptString == null || strOptString.isEmpty()) ? -1 : strOptString.indexOf("utm=");
            if (iIndexOf > 0) {
                if (this.f4541A == null) {
                    this.f4541A = Pattern.compile("[^0-9]+");
                }
                String[] strArrSplit = this.f4541A.split(strOptString.substring(iIndexOf));
                if (strArrSplit == null || strArrSplit.length < 2) {
                    return null;
                }
                int iIntValue = Integer.decode(strArrSplit[1]).intValue();
                int iIntValue2 = Integer.decode(strArrSplit[2]).intValue();
                return new int[]{iIntValue, iIntValue2, iIntValue + iIntValue2};
            }
        }
        return null;
    }

    public final JSONObject j(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayE = N.e(jSONArray);
        if (jSONArrayE.length() != jSONArray.length()) {
            this.n++;
        }
        try {
            jSONObject.put("thread_number", 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jSONArrayE.length(); i++) {
                sb.append(jSONArrayE.getString(i));
                sb.append('\n');
            }
            jSONObject.put("mainStackFromTrace", sb.toString());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final File k() {
        if (this.f4542B == null) {
            this.f4542B = new File(this.b.getFilesDir(), "has_anr_signal_" + com.stepos.statsrpk.d.o().replaceAll(":", "_"));
        }
        return this.f4542B;
    }
}
