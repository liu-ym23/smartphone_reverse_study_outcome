package ms.bd.c;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public final class u0 {

    public static abstract class a {
        public a() {
        }

        public Object a(int r1, int r2, long r3, String r5, Object r6) {
            return b(r3);
        }

        public Object b(long r1) {
            return null;
        }
    }

    public static Object a(int r6) {
        return com.bytedance.mobsec.matrix.a.a(33554445, r6, 0, null, null);
    }

    public static Object a(int r0, int r1, long r2, String r4, Object r5) {
        return b(r0, r1, r2, r4, r5);
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    private static Object b(int r6, int r7, long r8, String r10, Object r11) {
        String r0 = "null";
        boolean r2 = true;
        if (r6 > 268435456) goto L5;
    L7:
        boolean r4 = false;
    L9:
        if (r4 == true) goto L11;
        int r1 = v0.f39666a;
        if (r6 <= 65536) goto L79;
        if (r6 >= 65545) goto L79;
    L87:
        boolean r3 = true;
    L89:
        if (r3 == true) goto L91;
        int r5 = com.bytedance.mobsec.metasec.a.d.f8857b;
        if (r6 <= 16777216) goto L98;
        if (r6 >= 16777279) goto L98;
    L103:
        if (r2 == true) goto L105;
        return null;
    L105:
        return com.bytedance.mobsec.metasec.a.d.a(r6, r7, r8, r10, r11);
    L98:
        if (r6 > 33554432) goto L100;
    L102:
        r2 = false;
        goto L103
    L100:
        if (r6 >= 33554435) goto L102;
    L91:
        return v0.a(r6, r7, r8, r10, r11);
    L79:
        if (r6 <= 196608) goto L84;
        if (r6 < 196612) goto L87;
    L84:
        if (r6 > 131072) goto L86;
    L88:
        r3 = false;
        goto L89
    L86:
        if (r6 >= 131075) goto L88;
    L11:
        switch(r6) {
            case 268435457: goto L72;
            case 268435458: goto L70;
            case 268435459: goto L70;
            case 268435460: goto L123;
            case 268435461: goto L122;
            case 268435462: goto L121;
            case 268435463: goto L59;
            case 268435464: goto L108;
            case 268435465: goto L117;
            case 268435466: goto L125;
            case 268435467: goto L17;
            case 268435468: goto L115;
            case 268435469: goto L114;
            case 268435470: goto L113;
            case 268435471: goto L112;
            default: goto L125;
        };
    L17:
        c1.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return null;
    L59:
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        JSONArray r12 = new JSONArray();
        if (r9 == null) goto L119;
        if (f1.a() == false) goto L66;
        return r12.toString();
    L66:
        return "[]";
    L119:
        return r12.toString();
    L70:
        return "np";
    L108:
        f1.a();     // Catch: Throwable -> L38
        String r13 = w1.a(null);
        String r14 = w1.a(null);
        String r15 = w1.a(null);
        StringBuilder r16 = new StringBuilder();
        if (r14 != null) goto L23;
    L26:
        String r17 = "null";
    L27:
        StringBuilder r18 = r16.append(r17).append("[<!>]");
        if (r13 != null) goto L30;
    L33:
        StringBuilder r19 = r18.append(r0).append("[<!>]");
        if (r15 != null) goto L36;
    L57:
        String r20 = "0";
    L118:
        return r19.append(r20).append("[<!>]").toString().trim();
    L36:
        if (r15.length() <= 0) goto L57;
    L56:
        r20 = r15.trim();
        goto L118
    L30:
        if (r13.length() <= 0) goto L33;
        r0 = r13.trim();
        goto L33
    L23:
        if (r14.length() <= 0) goto L26;
        r17 = r14.trim();
    L38:
        String r21 = w1.a(null);
        String r22 = w1.a(null);
        r15 = w1.a(null);
        StringBuilder r23 = new StringBuilder();
        if (r22 != null) goto L41;
    L44:
        String r24 = "null";
    L45:
        StringBuilder r25 = r23.append(r24).append("[<!>]");
        if (r21 != null) goto L48;
    L51:
        r19 = r25.append(r0).append("[<!>]");
        if (r15 == null) goto L57;
        if (r15.length() > 0) goto L56;
    L48:
        if (r21.length() <= 0) goto L51;
        r0 = r21.trim();
        goto L51
    L41:
        if (r22.length() <= 0) goto L44;
        r24 = r22.trim();
        goto L45
    L125:
        return null;
    L112:
        return Long.valueOf(com.bytedance.mobsec.metasec.ml.a.b());
    L113:
        return Long.valueOf(com.bytedance.mobsec.metasec.ml.a.a());
    L114:
        return l1.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L115:
        return c1.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a();
    L117:
        return l1.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L121:
        return k.a();
    L122:
        return w1.a(null);
    L123:
        return w1.a("");
    L72:
        return k1.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L5:
        if (r6 >= 268435472) goto L7;
        r4 = true;
        goto L9
    }
}
