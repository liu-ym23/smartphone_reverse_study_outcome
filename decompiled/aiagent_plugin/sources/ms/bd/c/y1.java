package ms.bd.c;

import com.bytedance.retrofit2.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class y1 {
    static {
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d45706", new byte[]{65, 2, 104, 70, 27, 3, 104, 17, 125, 74, 122, 50, 79, 69, 6, 36, 117}), String.class, "com.obric.aiagent.plugin");
    }

    private static ac a(com.bytedance.retrofit2.b.c r11) {
        com.bytedance.retrofit2.e.j r12 = r11.d();
        if (r12 != null) goto L9;
    L6:
        return null;
    L9:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Exception -> L8
        r12.a(r0);     // Catch: Exception -> L8
        return ac.a(okhttp3.x.c(r12.b()), new String(r0.toByteArray(), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4828a1", new byte[]{16, 14, 103, 1, 6}), String.class, "com.obric.aiagent.plugin")));
    }

    private static ac a(ac r18, HashMap r19) {
        String r0 = "";
        e.e r1 = new e.e();     // Catch: Exception -> L7
        ac r2 = r18;
        r2.a(r1);     // Catch: Exception -> L25
        String r3 = r1.u();     // Catch: Exception -> L25
    L28:
        Iterator r4 = r19.keySet().iterator();     // Catch: Exception -> L22
        okhttp3.s.a r5 = new okhttp3.s.a();     // Catch: Exception -> L22
    L12:
        if (r4.hasNext() == false) goto L14;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22
        r5.a(r6, ((String) ZeusTransformUtils.preCheckCast(r19.get(r6), String.class, "com.obric.aiagent.plugin")).replaceAll((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f5657c", new byte[]{44}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5a1530", new byte[]{97, 48, 96}), String.class, "com.obric.aiagent.plugin")));     // Catch: Exception -> L22
        goto L12
    L14:
        okhttp3.s r7 = r5.a();     // Catch: Exception -> L22
        StringBuilder r8 = new StringBuilder(r3);     // Catch: Exception -> L22
        if (r3.length() <= 0) goto L26;
        r8.append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "51f9e1", new byte[]{98}), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L22
    L26:
        e.e r9 = new e.e();     // Catch: Exception -> L24
        if (r7 == null) goto L20;
        r7.a(r9);     // Catch: Exception -> L24
        r0 = r9.u();     // Catch: Exception -> L24
    L20:
        r8.append(r0);     // Catch: Exception -> L22
        return ac.a(r18.a(), r8.toString());
    L23:
        return r2;
    L8:
        r3 = "";
    L7:
        r2 = r18;
        goto L8
    }

    public static com.bytedance.retrofit2.b.c a(com.bytedance.retrofit2.b.c r20, HashMap r21) {
        if (r21.size() <= 0) goto L32;
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ee9979", new byte[]{100, 104, 89, 89}), String.class, "com.obric.aiagent.plugin")).equalsIgnoreCase(r20.a()) == false) goto L32;
        if (r20.e() != null) goto L10;
        ac r3 = a(r20);     // Catch: Exception -> L35
    L11:
        String r4 = r3.a().b();     // Catch: Exception -> L35
        long r5 = r20.d().c();     // Catch: Exception -> L35
        if (r4.contains((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5fb552", new byte[]{46, 119, 30, 79}), String.class, "com.obric.aiagent.plugin")) == false) goto L23;
        String r2 = "";
        e.e r6 = new e.e();     // Catch: Exception -> L33
        r3.a(r6);     // Catch: Exception -> L33
        r2 = r6.u();     // Catch: Exception -> L33
    L38:
        JSONObject r7 = new JSONObject(r2);     // Catch: Exception -> L34
        Iterator r8 = r21.keySet().iterator();     // Catch: Exception -> L34
    L17:
        if (r8.hasNext() == false) goto L19;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L34
        r7.put(r9, (String) ZeusTransformUtils.preCheckCast(r21.get(r9), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L34
        goto L17
    L19:
        r3 = ac.a(r3.a(), r7.toString());     // Catch: Exception -> L34
    L20:
        ac r10 = r3;
    L26:
        if (r10 == null) goto L32;
        if (r10.b() < r5) goto L32;
        return r20.m().a(an.a(r10)).b();
    L23:
        if (r4.contains((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4f5c5a", new byte[]{35, 107, 84, 26, 71, 99, 37, 75, 97, 61, 38, 107, 66, 18, 14}), String.class, "com.obric.aiagent.plugin")) == false) goto L25;
        r10 = a(r3, r21);     // Catch: Exception -> L35
        goto L26
    L25:
        r10 = null;
        goto L26
    L10:
        r3 = r20.e();     // Catch: Exception -> L35
    L32:
        return r20;
    }
}
