package j7;

import D7.q;
import D7.v;
import android.content.pm.Signature;
import j9.AbstractC1607a;
import java.security.MessageDigest;
import kotlin.jvm.internal.k;

/* renamed from: j7.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1601c {
    public static String a(Signature[] signatures) {
        k.f(signatures, "signatures");
        byte[] bytes = v.I0(q.D0(signatures, new C1600b()), "", null, null, new com.uxsense.parse.b(22), 30).getBytes(AbstractC1607a.f4778a);
        k.e(bytes, "getBytes(...)");
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(bytes);
        k.c(bArrDigest);
        char[] charArray = "0123456789ABCDEF".toCharArray();
        k.e(charArray, "toCharArray(...)");
        char[] cArr = new char[bArrDigest.length * 2];
        int length = bArrDigest.length;
        for (int i = 0; i < length; i++) {
            byte b = bArrDigest[i];
            int i6 = i * 2;
            cArr[i6] = charArray[(b & 255) >>> 4];
            cArr[i6 + 1] = charArray[b & 15];
        }
        return new String(cArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004e A[Catch: Exception -> 0x0075, TryCatch #0 {Exception -> 0x0075, blocks: (B:3:0x000b, B:5:0x0015, B:7:0x001b, B:9:0x0021, B:12:0x0025, B:15:0x002e, B:17:0x0034, B:19:0x003a, B:21:0x0040, B:29:0x005a, B:31:0x0060, B:37:0x006a, B:27:0x004e), top: B:40:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j7.C1599a b(android.app.Application r10) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            android.content.pm.PackageManager r0 = r10.getPackageManager()
            java.lang.String r2 = r10.getPackageName()
            r10 = 134217728(0x8000000, float:3.85186E-34)
            r9 = 0
            android.content.pm.PackageInfo r10 = r0.getPackageInfo(r2, r10)     // Catch: java.lang.Exception -> L75
            android.content.pm.ApplicationInfo r1 = r10.applicationInfo     // Catch: java.lang.Exception -> L75
            android.content.pm.SigningInfo r3 = r10.signingInfo     // Catch: java.lang.Exception -> L75
            if (r3 == 0) goto L1a
            android.content.pm.Signature[] r3 = r3.getApkContentsSigners()     // Catch: java.lang.Exception -> L75
            goto L1b
        L1a:
            r3 = r9
        L1b:
            long r5 = r10.getLongVersionCode()     // Catch: java.lang.Exception -> L75
            if (r3 == 0) goto L2a
            int r4 = r3.length     // Catch: java.lang.Exception -> L75
            if (r4 != 0) goto L25
            goto L2a
        L25:
            java.lang.String r3 = a(r3)     // Catch: java.lang.Exception -> L75
            goto L2c
        L2a:
            java.lang.String r3 = ""
        L2c:
            if (r1 == 0) goto L4e
            java.lang.CharSequence r0 = r1.loadLabel(r0)     // Catch: java.lang.Exception -> L75
            if (r0 == 0) goto L4e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L75
            if (r0 == 0) goto L4e
            boolean r4 = j9.m.s0(r0)     // Catch: java.lang.Exception -> L75
            if (r4 != 0) goto L49
            java.lang.String r4 = "null"
            boolean r4 = r0.equals(r4)     // Catch: java.lang.Exception -> L75
            if (r4 != 0) goto L49
            goto L4a
        L49:
            r0 = r9
        L4a:
            if (r0 == 0) goto L4e
        L4c:
            r7 = r0
            goto L58
        L4e:
            kotlin.jvm.internal.k.c(r2)     // Catch: java.lang.Exception -> L75
            r0 = 46
            java.lang.String r0 = j9.m.I0(r0, r2, r2)     // Catch: java.lang.Exception -> L75
            goto L4c
        L58:
            if (r1 == 0) goto L68
            int r0 = r1.flags     // Catch: java.lang.Exception -> L75
            r1 = r0 & 1
            if (r1 != 0) goto L68
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L65
            goto L68
        L65:
            r0 = 0
        L66:
            r8 = r0
            goto L6a
        L68:
            r0 = 1
            goto L66
        L6a:
            j7.a r1 = new j7.a     // Catch: java.lang.Exception -> L75
            kotlin.jvm.internal.k.c(r2)     // Catch: java.lang.Exception -> L75
            java.lang.String r4 = r10.versionName     // Catch: java.lang.Exception -> L75
            r1.<init>(r2, r3, r4, r5, r7, r8)     // Catch: java.lang.Exception -> L75
            return r1
        L75:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j7.C1601c.b(android.app.Application):j7.a");
    }
}
