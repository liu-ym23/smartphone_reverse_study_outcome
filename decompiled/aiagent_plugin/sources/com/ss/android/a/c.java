package com.ss.android.a;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: compiled from: TTMd5.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static final String TAG = "TTMd5";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f37041a = null;

    /* JADX INFO: renamed from: com.ss.android.a.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: TTMd5.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: TTMd5.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f37042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f37043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f37044c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f37045d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f37046e;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ int a(a r0) {
            return r0.f37042a;
        }

        static /* synthetic */ int a(a r0, int r1) {
            r0.f37042a = r1;
            return r1;
        }

        static /* synthetic */ long a(a r0, long r1) {
            r0.f37045d = r1;
            return r1;
        }

        static /* synthetic */ String a(a r0, String r1) {
            r0.f37046e = r1;
            return r1;
        }

        static /* synthetic */ int b(a r0) {
            return r0.f37044c;
        }

        static /* synthetic */ int b(a r0, int r1) {
            r0.f37043b = r1;
            return r1;
        }

        static /* synthetic */ int c(a r0, int r1) {
            r0.f37044c = r1;
            return r1;
        }

        static /* synthetic */ long c(a r2) {
            return r2.f37045d;
        }

        static /* synthetic */ int d(a r0) {
            return r0.f37043b;
        }

        static /* synthetic */ String e(a r0) {
            return r0.f37046e;
        }
    }

    static {
        f37041a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static int a(String r1, File r2) {
        return a(r1, r2, null);
    }

    public static int a(String r6, File r7, b r8) {
        b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r8, b.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        return 2;
    L5:
        if (r6.length() != 0) goto L71;
        return 2;
    L71:
        if (r9 != null) goto L11;
        if (r7 != null) goto L16;
    L66:
        return 5;
    L16:
        if (r7.exists() == false) goto L66;
    L18:
        int r0 = -1;
        long r1 = -1;
        a r3 = a(r6);     // Catch: Throwable -> L62
        if (r3 != null) goto L23;
    L27:
        a r5 = null;
        if (r9 == null) goto L30;
        String r10 = a(r9, r0, r1);     // Catch: Throwable -> L32
    L74:
    L34:
        if (r10 != null) goto L36;
        return 6;
    L36:
        if (r10.length() != 0) goto L39;
        return 6;
    L39:
        if (r3 == null) goto L57;
        if (a.a(r3) != 1) goto L46;
        if (a.d(r3) == 1) goto L57;
    L46:
        if (a.e(r3) != null) goto L77;
    L59:
        return 1;
    L77:
        r5 = a(r10);     // Catch: Throwable -> L69
    L48:
        if (r5 == null) goto L59;
        if (a.b(r3) != a.b(r5)) goto L59;
        if (a.c(r3) != a.c(r5)) goto L59;
        if (a.e(r3).equals(a.e(r5)) == false) goto L59;
        return 0;
    L57:
        if (r10.equals(r6) == false) goto L59;
        return 0;
    L30:
        r10 = a(r7, r0, r1);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L64
        r10 = null;
        goto L34
    L23:
        if (a.a(r3) <= 1) goto L26;
        return 3;
    L26:
        r0 = a.b(r3);     // Catch: Throwable -> L64
        r1 = a.c(r3);     // Catch: Throwable -> L64
    L62:
        return 4;
    L11:
        if (r9.length() > 0) goto L18;
        r9.close();     // Catch: Throwable -> L70
    L13:
        return 5;
    L64:
        return 99;
    }

    private static String a(File r1, int r2, long r3) {
        return a(new com.ss.android.a.a(r1), r2, r3);
    }

    private static String a(b r22, int r23, long r24) {
        int r0 = r23;
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r22, b.class, "com.obric.aiagent.plugin");
        MessageDigest r9 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);
        if (r9 != null) goto L41;
        return "";
    L41:
        long r10 = r1.length();     // Catch: Throwable -> L31
        if (r0 > 0) goto L9;
    L14:
        long r13 = r10;
        r0 = 1;
    L15:
        byte[] r15 = new byte[8192];     // Catch: Throwable -> L31
        long r16 = 0;
        a(r1, r9, r15, 0, r13);     // Catch: Throwable -> L31
        if (r0 <= 2) goto L20;
        int r7 = r0 - 1;     // Catch: Throwable -> L31
        long r18 = (r10 - (((long) r0) * r13)) / ((long) r7);     // Catch: Throwable -> L31
        int r8 = 1;
    L18:
        if (r8 >= r7) goto L20;
        r16 = r16 + (r13 + r18);     // Catch: Throwable -> L31
        a(r1, r9, r15, r16, r13);     // Catch: Throwable -> L31
        r8 = r8 + 1;     // Catch: Throwable -> L31
        r7 = r7;
    L20:
        if (r0 <= 1) goto L22;
        a(r1, r9, r15, r10 - r13, r13);     // Catch: Throwable -> L31
    L22:
        String r2 = a(r9.digest());     // Catch: Throwable -> L31
        if (r0 == 1) goto L25;
    L28:
        String r3 = a(r0, r13) + ";" + r2;     // Catch: Throwable -> L31
        r1.close();     // Catch: Throwable -> L35
    L30:
        return r3;
    L25:
        if (r13 != r10) goto L28;
        r1.close();     // Catch: Throwable -> L34
    L27:
        return r2;
    L9:
        if (r24 <= 0) goto L14;
        if ((((long) r0) * r24) > ((8 * r10) / 10)) goto L14;
        r13 = r24;
    L31:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L36
    L33:
        throw th;
    }

    private static void a(b r4, MessageDigest r5, byte[] r6, long r7, long r9) {
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        r8.seek(r7, r9);
        long r10 = 0;
    L4:
        if (r10 >= r9) goto L10;
        int r0 = r8.read(r6, 0, (int) Math.min(r9 - r10, r6.length));
        if (r0 <= 0) goto L9;
        r5.update(r6, 0, r0);
        r10 = r10 + ((long) r0);
        goto L4
    L9:
        throw new IOException("updateSample unexpected readCount <= 0, readCount = " + r0 + ", readTotalCount = " + r10 + ", sampleSize = " + r9);
    }

    private static String a(byte[] r10) {
        Objects.requireNonNull(r10, "bytes is null");
        int r0 = r10.length;
        int r1 = r0 * 2;
        char[] r2 = new char[r1];
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r0) goto L6;
        int r6 = r10[r4 + 0] & 255;
        int r7 = r5 + 1;
        char[] r8 = f37041a;
        r2[r5] = r8[r6 >> 4];
        r5 = r7 + 1;
        r2[r7] = r8[r6 & 15];
        r4 = r4 + 1;
        goto L3
    L6:
        return new String(r2, 0, r1);
    }

    private static String a(int r3, long r4) {
        return "ttmd5:1:1:" + a(r3) + "g" + a(r4);
    }

    private static a a(String r6) {
        AnonymousClass1 r1 = null;
        if (r6.startsWith("ttmd5:") == true) goto L5;
        return null;
    L5:
        String[] r7 = r6.split(";");
        String[] r2 = r7[0].split(":");
        a r3 = new a(r1);
        a.a(r3, Integer.parseInt(r2[1]));
        if (a.a(r3) <= 1) goto L8;
        return r3;
    L8:
        a.b(r3, Integer.parseInt(r2[2]));
        String[] r4 = r2[3].split("g");
        a.c(r3, (int) b(r4[0]));
        a.a(r3, b(r4[1]));
        a.a(r3, r7[1]);
        return r3;
    }

    private static String a(long r2) {
        return Long.toHexString((r2 << 4) + 31);
    }

    private static long b(String r4) {
        return (Long.parseLong(r4, 16) - 31) >> 4;
    L7:
        throw new RuntimeException("ttmd5 decryptNum error, num = " + r4);
    }
}
