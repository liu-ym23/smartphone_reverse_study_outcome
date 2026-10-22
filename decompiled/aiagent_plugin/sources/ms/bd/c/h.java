package ms.bd.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f39502a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f39503b = null;

    static {
        f39502a = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "842398", new byte[]{8, 20, 98, 99, 35, 9, 28, 61, 74, 73, 2, 26, 108, 105, 41, 31, 10, 39, 80, 87, 28, 0, 118, 127, 63, 21, 58, 23, 96, 103, 44, 48, 70, 79, 15, 37, 48, 25, 110, 109, 38, 38, 80, 85, 21, 59, 46, 3, 116, 123, 48, 44, 17, 22, 84, 124, 111, 64, 53, 52, 113, 111, 10, 8}), String.class, "com.obric.aiagent.plugin");
        f39503b = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d90652", new byte[]{40}), String.class, "com.obric.aiagent.plugin");
    }

    public static String a(String r10) {
        if (r10 != null) goto L4;
        return r10;
    L4:
        if (r10.length() > 0) goto L7;
        return r10;
    L7:
        return r10.replaceAll((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6f2f6d", new byte[]{27, 47}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "27c51e", new byte[]{110}), String.class, "com.obric.aiagent.plugin")).replaceAll((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1fa1b0", new byte[]{111}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "383ace", new byte[]{29}), String.class, "com.obric.aiagent.plugin")).replaceAll(f39503b, "");
    }

    public static String a(byte[] r10) {
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L15
        int r2 = r10.length % 3;     // Catch: Throwable -> L15
        if (r2 <= 0) goto L8;
        r10 = Arrays.copyOf(r10, (r10.length + 3) - r2);     // Catch: Throwable -> L15
        String r4 = "";
    L6:
        if (r2 >= 3) goto L9;
        r4 = r4 + f39503b;     // Catch: Throwable -> L15
        r2 = r2 + 1;     // Catch: Throwable -> L15
    L9:
        int r3 = 0;
    L11:
        if (r3 >= r10.length) goto L13;
        byte r5 = r10[r3];     // Catch: Throwable -> L15
        byte r6 = r10[r3 + 1];     // Catch: Throwable -> L15
        byte r7 = r10[r3 + 2];     // Catch: Throwable -> L15
        int r8 = (r5 >> 2) & 63;     // Catch: Throwable -> L15
        int r9 = ((r5 << 4) | (r6 >> 4)) & 63;     // Catch: Throwable -> L15
        String r11 = f39502a;     // Catch: Throwable -> L15
        r1.append(r11.charAt(r8));     // Catch: Throwable -> L15
        r1.append(r11.charAt(r9));     // Catch: Throwable -> L15
        r1.append(r11.charAt(((r6 << 2) | (r7 >> 6)) & 63));     // Catch: Throwable -> L15
        r1.append(r11.charAt(r7 & 63));     // Catch: Throwable -> L15
        r3 = r3 + 3;     // Catch: Throwable -> L15
        goto L11
    L13:
        String r12 = r1.toString();     // Catch: Throwable -> L15
        return r12.substring(0, r12.length() - r4.length()) + r4;
    L8:
        r4 = "";
    L15:
        return "";
    }

    public static String b(String r18) {
        if (r18 != null) goto L5;
        return r18;
    L5:
        if (r18.length() <= 0) goto L17;
        int r1 = 4 - (r18.length() % 4);
        if (r1 != 1) goto L10;
        String r2 = f39503b;
    L15:
        return r18.replaceAll((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2216fb", new byte[]{110}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6d2014", new byte[]{108}), String.class, "com.obric.aiagent.plugin")).replaceAll((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "12941b", new byte[]{31}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "972a9c", new byte[]{103}), String.class, "com.obric.aiagent.plugin")) + r2;
    L10:
        if (r1 == 2) goto L12;
        r2 = "";
        goto L15
    L12:
        r2 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ce5325", new byte[]{47, 58}), String.class, "com.obric.aiagent.plugin");
        goto L15
    L17:
        return r18;
    }

    public static byte[] c(String r12) {
        int r1 = (r12.length() * 3) / 4;     // Catch: Throwable -> L16
        byte[] r2 = new byte[r1];     // Catch: Throwable -> L16
        int r3 = r12.length();     // Catch: Throwable -> L16
        String r4 = "";
        int r5 = 0;
    L5:
        if (r5 >= 2) goto L10;
        if (r12.charAt((r3 - 1) - r5) != f39503b.charAt(0)) goto L9;
        r4 = r4 + f39502a.charAt(0);     // Catch: Throwable -> L16
    L9:
        r5 = r5 + 1;     // Catch: Throwable -> L16
        goto L5
    L10:
        String r13 = r12.substring(0, r3 - r4.length()) + r4;     // Catch: Throwable -> L16
        int r6 = 0;
        int r7 = 0;
    L12:
        if (r6 >= r13.length()) goto L14;
        String r8 = f39502a;     // Catch: Throwable -> L16
        int r9 = r8.indexOf(r13.charAt(r6));     // Catch: Throwable -> L16
        int r10 = r8.indexOf(r13.charAt(r6 + 1));     // Catch: Throwable -> L16
        int r11 = r8.indexOf(r13.charAt(r6 + 2));     // Catch: Throwable -> L16
        int r14 = r8.indexOf(r13.charAt(r6 + 3));     // Catch: Throwable -> L16
        int r15 = ((r9 << 2) | (r10 >> 4)) & 255;     // Catch: Throwable -> L16
        r2[r7] = (byte) r15;     // Catch: Throwable -> L16
        r2[r7 + 1] = (byte) (((r10 << 4) | (r11 >> 2)) & 255);     // Catch: Throwable -> L16
        r2[r7 + 2] = (byte) ((r14 | (r11 << 6)) & 255);     // Catch: Throwable -> L16
        r6 = r6 + 4;     // Catch: Throwable -> L16
        r7 = r7 + 3;     // Catch: Throwable -> L16
        goto L12
    L14:
        return Arrays.copyOfRange(r2, 0, r1 - r4.length());
    L17:
        return new byte[0];
    }
}
