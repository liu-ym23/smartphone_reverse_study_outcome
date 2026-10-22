package k4;

import android.content.Context;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4798a;
    public volatile c b;

    public d(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        this.f4798a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k4.c a(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "AppIdentityResolver"
            r1 = 0
            android.content.Context r10 = r10.f4798a     // Catch: java.lang.Exception -> L18 android.content.pm.PackageManager.NameNotFoundException -> Lc4
            android.content.pm.PackageManager r10 = r10.getPackageManager()     // Catch: java.lang.Exception -> L18 android.content.pm.PackageManager.NameNotFoundException -> Lc4
            r2 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r10 = r10.getPackageInfo(r11, r2)     // Catch: java.lang.Exception -> L18 android.content.pm.PackageManager.NameNotFoundException -> Lc4
            android.content.pm.SigningInfo r10 = r10.signingInfo     // Catch: java.lang.Exception -> L18 android.content.pm.PackageManager.NameNotFoundException -> Lc4
            if (r10 == 0) goto L1b
            android.content.pm.Signature[] r10 = r10.getApkContentsSigners()     // Catch: java.lang.Exception -> L18 android.content.pm.PackageManager.NameNotFoundException -> Lc4
            goto L1c
        L18:
            r10 = move-exception
            goto La4
        L1b:
            r10 = r1
        L1c:
            if (r10 == 0) goto L25
            java.lang.Object r2 = D7.q.n0(r10)
            android.content.pm.Signature r2 = (android.content.pm.Signature) r2
            goto L26
        L25:
            r2 = r1
        L26:
            if (r2 != 0) goto L34
            java.lang.String r10 = "no signing certificate on "
            java.lang.String r10 = r10.concat(r11)
            android.util.Log.e(r0, r10)
        L31:
            r10 = r1
            goto Lcf
        L34:
            int r3 = r10.length
            r4 = 1
            if (r3 <= r4) goto L55
            int r10 = r10.length
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r11)
            java.lang.String r5 = " has "
            r3.append(r5)
            r3.append(r10)
            java.lang.String r10 = " signers, using the first one"
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            android.util.Log.w(r0, r10)
        L55:
            byte[] r10 = r2.toByteArray()
            java.lang.String r2 = "toByteArray(...)"
            kotlin.jvm.internal.k.e(r10, r2)
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)
            byte[] r10 = r2.digest(r10)
            java.lang.String r2 = "digest(...)"
            kotlin.jvm.internal.k.e(r10, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ""
            r2.append(r3)
            int r5 = r10.length
            r6 = 0
            r7 = r6
        L7a:
            if (r6 >= r5) goto L9c
            r8 = r10[r6]
            int r7 = r7 + r4
            if (r7 <= r4) goto L84
            r2.append(r3)
        L84:
            java.lang.Byte r8 = java.lang.Byte.valueOf(r8)
            java.lang.Object[] r8 = new java.lang.Object[]{r8}
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r4)
            java.lang.String r9 = "%02x"
            java.lang.String r8 = java.lang.String.format(r9, r8)
            r2.append(r8)
            int r6 = r6 + 1
            goto L7a
        L9c:
            r2.append(r3)
            java.lang.String r10 = r2.toString()
            goto Lcf
        La4:
            java.lang.Class r2 = r10.getClass()
            java.lang.String r2 = r2.getSimpleName()
            java.lang.String r10 = r10.getMessage()
            java.lang.String r3 = "cannot read signature of "
            java.lang.String r4 = ": "
            java.lang.StringBuilder r2 = B7.a.w(r3, r11, r4, r2, r4)
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            android.util.Log.e(r0, r10)
            goto L31
        Lc4:
            java.lang.String r10 = "package not installed: "
            java.lang.String r10 = r10.concat(r11)
            android.util.Log.w(r0, r10)
            goto L31
        Lcf:
            if (r10 != 0) goto Ld2
            return r1
        Ld2:
            k4.c r1 = new k4.c
            r1.<init>(r11, r10)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "caller identity: package="
            r2.<init>(r3)
            r2.append(r11)
            java.lang.String r11 = " md5="
            r2.append(r11)
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            android.util.Log.i(r0, r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.d.a(java.lang.String):k4.c");
    }
}
