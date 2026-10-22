package ms.bd.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public abstract class s0 extends u0.a {
    public s0() {
    }

    @Override // ms.bd.c.u0.a
    public final Object a(int r10, int r11, long r12, String r14, Object r15) {
        if (f1.a(new String[]{(String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "467a64", new byte[]{36, 58, 64, 7, 6, 42, 51, 89, 118, 52, 55, 57, 77, 6, 26, 42, 56, 25, 40, 24, 11, 0, 97, 39, 39, 6, 3}), String.class, "com.obric.aiagent.plugin")}) == true) goto L6;
        return null;
    L6:
        switch(r10) {
            case 196609: goto L13;
            case 196610: goto L11;
            case 196611: goto L9;
            default: goto L8;
        };
    L9:
        Object[] r13 = (Object[]) ZeusTransformUtils.preCheckCast(r15, Object[].class, "com.obric.aiagent.plugin");
        return b(r14, (String) ZeusTransformUtils.preCheckCast(r13[0], String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r13[1], String.class, "com.obric.aiagent.plugin"));
    L11:
        Object[] r16 = (Object[]) ZeusTransformUtils.preCheckCast(r15, Object[].class, "com.obric.aiagent.plugin");
        return a(r14, (String) ZeusTransformUtils.preCheckCast(r16[0], String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r16[1], String.class, "com.obric.aiagent.plugin"));
    L13:
        Object[] r17 = (Object[]) ZeusTransformUtils.preCheckCast(r15, Object[].class, "com.obric.aiagent.plugin");
        return a(r14, (byte[]) ZeusTransformUtils.preCheckCast(r17[0], byte[].class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r17[1], String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r17[2], String.class, "com.obric.aiagent.plugin"));
    L8:
        return super.a(r10, r11, r12, r14, r15);
    }

    public abstract Object[] a(String r1, String r2, String r3);

    public abstract Object[] a(String r1, byte[] r2, String r3, String r4);

    public abstract Object[] b(String r1, String r2, String r3);
}
