package ms.bd.c;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes4.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f39665a = null;

    static {
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6e28b5", new byte[]{28, 59, 0, 18, 96}), String.class, "com.obric.aiagent.plugin");
        f39665a = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "06e990", new byte[]{44, 49, 24, 73}), String.class, "com.obric.aiagent.plugin");
    }

    public static synchronized String a(Context r30) {
        monitor-enter(v.class);
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r30, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        StringBuilder r5 = new StringBuilder().append(r0.getFilesDir().getAbsolutePath()).append((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "bf3846", new byte[]{60}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L24
        String r6 = f39665a;     // Catch: Throwable -> L24
        String r7 = r5.append(r6).toString();     // Catch: Throwable -> L24
        if (new File(r7).exists() == false) goto L14;
        String r8 = a(r7);     // Catch: Throwable -> L24
        if (r8 == null) goto L14;
        if (r8.length() <= 0) goto L14;
        monitor-exit(v.class);
        return r8;
    L14:
        InputStream r1 = ZeusTransformUtils.getResources(r0, "com.obric.aiagent.plugin").getAssets().open(r6);     // Catch: Throwable -> L24
        ByteArrayOutputStream r9 = new ByteArrayOutputStream();     // Catch: Throwable -> L24
        byte[] r10 = new byte[4096];     // Catch: Throwable -> L24
    L15:
        int r15 = r1.read(r10, 0, 4096);     // Catch: Throwable -> L24
        if (r15 == (-1)) goto L18;
        r9.write(r10, 0, r15);     // Catch: Throwable -> L24
        goto L15
    L18:
        FileOutputStream r2 = new FileOutputStream(r7);     // Catch: Throwable -> L24
        r2.write(r9.toByteArray());     // Catch: Throwable -> L24
        r2.close();     // Catch: Throwable -> L24
        a(((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "26e591", new byte[]{32, 60, 27, 78, 2, 102, 102, 64, 99, 37}), String.class, "com.obric.aiagent.plugin")) + r7);     // Catch: Throwable -> L24
        String r3 = a(r7);     // Catch: Throwable -> L24
        if (r3 != null) goto L21;
    L22:
        RandomAccessFile r4 = new RandomAccessFile(r7, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "40629c", new byte[]{55, 37}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L24
        r4.seek(16);     // Catch: Throwable -> L24
        r4.write(new byte[]{2});     // Catch: Throwable -> L24
        r4.close();     // Catch: Throwable -> L24
        r3 = a(r7);     // Catch: Throwable -> L24
    L26:
        if (r3 != null) goto L28;
    L29:
        r3 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "46bf10", new byte[]{117, 15, 77, 83, 80, 26, 18, 37, 1, 25, 23, 15, 77, 83, 80, 26}), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
    L30:
        monitor-exit(v.class);
        return r3;
    L28:
        if (r3.length() != 0) goto L30;
        goto L25
    L21:
        if (r3.length() != 0) goto L26;
    L25:
        r3 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f6e922", new byte[]{39, 15, 74, 12, 83, 24, 64, 47, 23, 76, 71, 0, 63, 98, 35, 30, 57, 86, 106, 84}), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    private static String a(BufferedInputStream r9) {
        byte[] r1 = new byte[4096];
        StringBuilder r2 = new StringBuilder();
    L11:
        int r3 = r9.read(r1);     // Catch: Exception -> L8
        if (r3 <= 0) goto L6;
        r2.append(new String(r1, 0, r3));     // Catch: Exception -> L8
    L6:
        if (r3 >= 4096) goto L11;
    L10:
        return r2.toString();
    L8:
        String r10 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "29b6f2", new byte[]{38, 50, 18}), String.class, "com.obric.aiagent.plugin");
        goto L10
    }

    private static String a(String r15) {
        BufferedOutputStream r4 = null;
        BufferedInputStream r5 = null;
        r4 = null;
        String r6 = null;
        r6 = null;
        Process r7 = Runtime.getRuntime().exec((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "88ebfe", new byte[]{58, 50}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21 Exception -> L23
    L75:
        BufferedOutputStream r8 = new BufferedOutputStream(r7.getOutputStream());     // Catch: Throwable -> L19 Exception -> L54
        BufferedInputStream r9 = new BufferedInputStream(r7.getInputStream());     // Catch: Throwable -> L16 Exception -> L18
        r8.write(r15.getBytes());     // Catch: Throwable -> L14 Exception -> L53
        r8.write(10);     // Catch: Throwable -> L14 Exception -> L53
        r8.flush();     // Catch: Throwable -> L14 Exception -> L53
        r8.close();     // Catch: Throwable -> L14 Exception -> L53
        r7.waitFor();     // Catch: Throwable -> L14 Exception -> L53
        String r16 = a(r9);     // Catch: Throwable -> L14 Exception -> L53
        r8.close();     // Catch: IOException -> L9
    L55:
        r9.close();     // Catch: IOException -> L12
    L13:
        r6 = r16;
    L36:
        r7.destroy();
    L37:
        return r6;
    L12:
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6b4af0", new byte[]{34, 105, 68, 42, 92}), String.class, "com.obric.aiagent.plugin");
    L9:
        String r1 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1bbf4d", new byte[]{37, 105, 18, 45, 14}), String.class, "com.obric.aiagent.plugin");
        goto L55
    L14:
        th = th;
    L41:
        r5 = r9;
    L42:
        if (r8 != null) goto L59;
    L46:
        if (r5 != null) goto L63;
    L50:
        if (r7 == null) goto L77;
        r7.destroy();
        throw th;
    L77:
        throw th;
    L63:
        r5.close();     // Catch: IOException -> L49
    L49:
        String r2 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "079956", new byte[]{36, 60, 73, 114, 15}), String.class, "com.obric.aiagent.plugin");
        goto L50
    L59:
        r8.close();     // Catch: IOException -> L45
    L45:
        String r3 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c33bea", new byte[]{119, 56, 67, 41, 95}), String.class, "com.obric.aiagent.plugin");
    L61:
        String r17 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4ca4af", new byte[]{32, 104, 17, 127, 91}), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        if (r8 != null) goto L65;
    L31:
        if (r9 != null) goto L57;
    L35:
        if (r7 == null) goto L37;
    L57:
        r9.close();     // Catch: IOException -> L34
    L34:
        String r18 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5054c0", new byte[]{33, 59, 69, 127, 89}), String.class, "com.obric.aiagent.plugin");
        goto L35
    L65:
        r8.close();     // Catch: IOException -> L30
    L30:
        String r19 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "63ea04", new byte[]{34, 56, 21, 42, 10}), String.class, "com.obric.aiagent.plugin");
    L38:
        th = th;
        r4 = r8;
    L40:
        r8 = r4;
        goto L41
    L18:
        r9 = null;
    L16:
        th = th;
        goto L42
    L19:
        th = th;
        r9 = null;
    L24:
        r8 = null;
        r9 = null;
    L23:
        r7 = null;
    L21:
        th = th;
        r7 = null;
        r9 = null;
        goto L40
    }
}
