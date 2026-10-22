package ms.bd.c;

import com.bytedance.mobsec.matrix.utils.m.TN;
import com.bytedance.retrofit2.ak;
import com.google.protobuf.DescriptorProtos;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class z1 extends s0 {
    public z1() {
    }

    private static int a(com.bytedance.retrofit2.e r3, ak r4) {
        com.bytedance.retrofit2.e r5 = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L16;
        if (r4 != null) goto L7;
        return -1;
    L7:
        if (ZeusTransformUtils.instanceOf(r5, com.bytedance.retrofit2.q.class) == false) goto L17;
        ((com.bytedance.retrofit2.q) ZeusTransformUtils.preCheckCast(r5, com.bytedance.retrofit2.q.class, "com.obric.aiagent.plugin")).f();
        com.bytedance.retrofit2.b.d r6 = r4.b();
        if (r6 == null) goto L18;
        Object r7 = r6.f();
        if (ZeusTransformUtils.instanceOf(r7, com.bytedance.ttnet.d.b.class) == false) goto L19;
        com.bytedance.ttnet.d.b r8 = (com.bytedance.ttnet.d.b) ZeusTransformUtils.preCheckCast(r7, com.bytedance.ttnet.d.b.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L15;
        return -1;
    L15:
        return a(r8.f8134J);
    L19:
        return -1;
    L18:
        return -1;
    L17:
        return -1;
    L16:
        return -1;
    }

    private static int a(String r17) {
        if (r17 != null) goto L5;
        return -1;
    L5:
        if ("" == r17) goto L13;
        return new JSONObject(r17).getJSONObject((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "93917e", new byte[]{58, 52, 89, 85, 7, 124, 41, 23}), String.class, "com.obric.aiagent.plugin")).getInt((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d0626e", new byte[]{118, 61, 65, 67}), String.class, "com.obric.aiagent.plugin"));
    L14:
        return -1;
    L13:
        return -1;
    }

    private static String a(List r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L5;
    L17:
        return null;
    L5:
        if (r11.size() <= 0) goto L17;
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L17;
        com.bytedance.retrofit2.b.b r2 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r12.next(), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "edc181", new byte[]{108, 43, 4, 81, 74, 42, 105, 66, 59, 101}), String.class, "com.obric.aiagent.plugin")).equalsIgnoreCase(r2.a()) == false) goto L9;
        return r2.b();
    }

    private static Object[] a(String r37, byte[] r38, String r39, String r40, String r41, boolean r42) {
        r0.a r4 = new r0.a();
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L48
        r15.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "3a775a", new byte[]{1, 108, 75, 72, 3, 115}), String.class, "com.obric.aiagent.plugin"), ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "bebaeb", new byte[]{96, 98, 2, 6, 83, 122, 111, 77, 55, 108}), String.class, "com.obric.aiagent.plugin")) + r39));     // Catch: Throwable -> L48
        r15.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "134d8d", new byte[]{1, 50, 68, 21, 23, 103}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2b6d05", new byte[]{105, 47, 15}), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L48
        r15.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "db2dde", new byte[]{64, 115, 68, 2, 22, 83, 96, 70, 109, 32}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c005c7", new byte[]{80, 43, 87, 68, 120, 33, 110, 18, 100, 40, 95, 1, 112, 101, 119}), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L48
        r15.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ae63cf", new byte[]{83, 104, 75, 83, 89, 127, 118, 9, 83, 122, 96, 98}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1dc3c1", new byte[]{33, 118, 0, 75, 85, 37, 51, 81, 59, 108, 46, 41, 31, 68, 72, 35, 38, 8, 33, 119, 50, 99, 17, 74}), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L48
        if (r40 != null) goto L6;
    L8:
        TN r1 = (TN) ZeusTransformUtils.preCheckCast(com.bytedance.ttnet.utils.d.b(r37).a(TN.class), TN.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        if (r42 == false) goto L11;
        com.bytedance.retrofit2.e<com.bytedance.retrofit2.e.i> r2 = r1.p1(r37, r15, new com.bytedance.retrofit2.e.g((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "9d4575", new byte[]{41, 118, 87, 77, 1, 33, 59, 81, 108, 106, 38, 41, 72, 66, 28, 39, 46, 8, 118, 113, 58, 99, 70, 76}), String.class, "com.obric.aiagent.plugin"), r38, new String[0]));     // Catch: Throwable -> L48
    L117:
        r4.a(r37);     // Catch: Throwable -> L46
        ak<com.bytedance.retrofit2.e.i> r5 = r2.a();     // Catch: Throwable -> L46
        int r6 = r5.c();     // Catch: Throwable -> L44
        r4.a(a(r5.d()), r6);     // Catch: Throwable -> L42
        if (r41 == null) goto L17;
        OutputStream r0 = new FileOutputStream(r41);     // Catch: Throwable -> L42
    L18:
        OutputStream r3 = r0;
        InputStream r7 = ((com.bytedance.retrofit2.e.i) ZeusTransformUtils.preCheckCast(r5.f(), com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin")).e_();     // Catch: Throwable -> L40
        byte[] r8 = new byte[1024];     // Catch: Throwable -> L38
    L22:
        int r9 = r7.read(r8, 0, 1024);     // Catch: Throwable -> L38
        if (r9 <= 0) goto L25;
        r3.write(r8, 0, r9);     // Catch: Throwable -> L38
        goto L22
    L25:
        r3.flush();     // Catch: Throwable -> L38
        if (ZeusTransformUtils.instanceOf(r3, ByteArrayOutputStream.class) == false) goto L29;
        byte[] r16 = ((ByteArrayOutputStream) ZeusTransformUtils.preCheckCast(r3, ByteArrayOutputStream.class, "com.obric.aiagent.plugin")).toByteArray();     // Catch: Throwable -> L38
    L31:
        if (r6 == 200) goto L33;
        int r10 = b(r2, r5);
    L35:
        if (r6 != (-1)) goto L37;
        r6 = a(r2, r5);
    L37:
        com.bytedance.frameworks.baselib.network.http.f.f.a(r7);
        com.bytedance.frameworks.baselib.network.http.f.f.a(r3);
        r2.b();
        byte[] r11 = r16;
    L104:
        return new Object[]{String.valueOf(r6), r11, Integer.valueOf(r10)};
    L33:
        r10 = 0;
        goto L35
    L29:
        r16 = null;
    L38:
        th = th;
    L53:
        int r12 = DescriptorProtos.Edition.EDITION_99999_TEST_ONLY_VALUE;
    L105:
        th = move-exception;
        if (r6 == 200) goto L111;
        if (r12 != 0) goto L111;
        b(r2, r5);
    L111:
        if (r6 != (-1)) goto L113;
        a(r2, r5);
    L113:
        com.bytedance.frameworks.baselib.network.http.f.f.a(r7);
        com.bytedance.frameworks.baselib.network.http.f.f.a(r3);
        if (r2 == null) goto L116;
        r2.b();
    L116:
        throw th;
    L55:
        if (ZeusTransformUtils.instanceOf(th, UnsupportedOperationException.class) == false) goto L58;
        r12 = 90000;
    L58:
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.frameworks.baselib.network.http.c.a.class) == false) goto L61;
        r12 = 90001;
    L61:
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.frameworks.baselib.network.http.c.b.class) == false) goto L64;
        r12 = 90002;
    L64:
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.frameworks.baselib.network.http.c.d.class) == false) goto L67;
        r12 = 90003;
    L67:
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.frameworks.baselib.network.http.c.e.class) == false) goto L70;
        r12 = 90004;
    L70:
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.frameworks.baselib.network.http.c.f.class) == false) goto L73;
        r12 = 90005;
    L73:
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.frameworks.baselib.network.http.c.g.class) == false) goto L76;
        r12 = 90006;
    L76:
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.frameworks.baselib.network.http.c.h.class) == false) goto L79;
        r12 = 90007;
    L79:
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == false) goto L86;
        com.bytedance.frameworks.baselib.network.http.cronet.b.c r13 = (com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(th, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L105
        r12 = b(r13.b());     // Catch: Throwable -> L105
        if (r12 < 80000) goto L84;
        r12 = 90009;
    L84:
        if (r6 != (-1)) goto L86;
        r6 = a(r13.b());     // Catch: Throwable -> L105
    L86:
        String r14 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "09e918", new byte[]{53, 51, 21, 114, 6, 62}), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L105
        if (r5 == null) goto L89;
        String r17 = a(r5.d());     // Catch: Throwable -> L105
    L90:
        r4.b(r17, r6);     // Catch: Throwable -> L105
        if (r6 == 200) goto L95;
        if (r12 != 0) goto L95;
        r10 = b(r2, r5);
    L97:
        if (r6 != (-1)) goto L99;
        r6 = a(r2, r5);
    L99:
        com.bytedance.frameworks.baselib.network.http.f.f.a(r7);
        com.bytedance.frameworks.baselib.network.http.f.f.a(r3);
        if (r2 == null) goto L102;
        r2.b();
    L102:
        r11 = null;
    L95:
        r10 = r12;
        goto L97
    L89:
        r17 = null;
    L40:
        th = th;
    L52:
        r7 = null;
        goto L53
    L17:
        r0 = new ByteArrayOutputStream();     // Catch: Throwable -> L42
    L42:
        th = th;
        r3 = null;
    L44:
        th = th;
        r3 = null;
    L51:
        r6 = -1;
    L46:
        th = th;
    L50:
        r3 = null;
        r5 = null;
        goto L51
    L11:
        r2 = r1.p2(r37, r15);     // Catch: Throwable -> L48
        goto L117
    L6:
        if (r40.trim().length() <= 0) goto L8;
        r15.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "3baadf", new byte[]{58, 45, 6, 1, 22, 99, 53, 82, 37, 52, 49, 116, 95, 1, 90, 118}), String.class, "com.obric.aiagent.plugin"), r40));     // Catch: Throwable -> L48
    L48:
        th = th;
        r2 = null;
        goto L50
    }

    private static int b(com.bytedance.retrofit2.e r2, ak r3) {
        com.bytedance.retrofit2.e r4 = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L20;
        if (r3 != null) goto L7;
        return 80004;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.retrofit2.q.class) == false) goto L18;
        ((com.bytedance.retrofit2.q) ZeusTransformUtils.preCheckCast(r4, com.bytedance.retrofit2.q.class, "com.obric.aiagent.plugin")).f();
        com.bytedance.retrofit2.b.d r5 = r3.b();
        if (r5 == null) goto L17;
        Object r6 = r5.f();
        if (ZeusTransformUtils.instanceOf(r6, com.bytedance.ttnet.d.b.class) == false) goto L16;
        com.bytedance.ttnet.d.b r7 = (com.bytedance.ttnet.d.b) ZeusTransformUtils.preCheckCast(r6, com.bytedance.ttnet.d.b.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L22;
        return 80008;
    L22:
        return b(r7.f8134J);
    L16:
        return 80007;
    L17:
        return 80006;
    L18:
        return 80005;
    L20:
        return 80004;
    }

    private static int b(String r23) {
        if (r23 != null) goto L5;
        return 80000;
    L5:
        if ("" == r23) goto L27;
        JSONObject r2 = new JSONObject(r23).getJSONObject((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "506498", new byte[]{38, 51, 86, 69}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
        if (r2 == null) goto L24;
        String r3 = r2.getString((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ee89d8", new byte[]{103, 115, 74, 89, 78, 60}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
        if (r3 != null) goto L13;
    L17:
        return 80002;
    L13:
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ad33a0", new byte[]{67, 83, 99, 100, 123, 20, 81}), String.class, "com.obric.aiagent.plugin")) == r3) goto L17;
        return r2.getInt((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2a3fd6", new byte[]{45, 102, 84, 45, 94, 51, 35, 79, 112}), String.class, "com.obric.aiagent.plugin"));
    L24:
        return 80001;
    L18:
        return 80003;
    L27:
        return 80000;
    }

    @Override // ms.bd.c.s0
    public final Object[] a(String r7, String r8, String r9) {
        return a(r7, null, r8, r9, null, false);
    }

    @Override // ms.bd.c.s0
    public final Object[] a(String r7, byte[] r8, String r9, String r10) {
        return a(r7, r8, r9, r10, null, true);
    }

    @Override // ms.bd.c.s0
    public final Object[] b(String r7, String r8, String r9) {
        return a(r7, null, null, r9, r8, false);
    }
}
