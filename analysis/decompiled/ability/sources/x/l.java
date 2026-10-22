package x;

import android.content.Context;
import android.os.IBinder;
import ca.fa.ca.a;
import fa.C1449a;

/* loaded from: classes2.dex */
public final class l implements o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f6866a;
    public final /* synthetic */ C1449a b;

    public l(C1449a c1449a, Context context) {
        this.b = c1449a;
        this.f6866a = context;
    }

    @Override // x.o
    public final Object a(IBinder iBinder) {
        return a.AbstractBinderC0140a.a(iBinder);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006d  */
    @Override // x.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.Object r10) throws java.security.NoSuchAlgorithmException {
        /*
            r9 = this;
            android.content.Context r0 = r9.f6866a
            ca.fa.ca.a r10 = (ca.fa.ca.a) r10
            r1 = 0
            if (r10 != 0) goto L9
            goto La6
        L9:
            fa.a r9 = r9.b
            r9.getClass()
            java.lang.String r9 = r0.getPackageName()     // Catch: java.lang.Exception -> L1d
            r2 = 64
            android.content.pm.PackageInfo r9 = D2.c.b(r0, r9, r2)     // Catch: java.lang.Exception -> L1d
            if (r9 == 0) goto L1f
            android.content.pm.Signature[] r9 = r9.signatures     // Catch: java.lang.Exception -> L1d
            goto L25
        L1d:
            r9 = move-exception
            goto L21
        L1f:
            r9 = r1
            goto L25
        L21:
            r9.printStackTrace()
            goto L1f
        L25:
            r2 = 0
            r3 = 1
            if (r9 == 0) goto L66
            int r4 = r9.length
            if (r4 <= 0) goto L66
            r9 = r9[r2]
            byte[] r9 = r9.toByteArray()
            java.lang.String r4 = "SHA1"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch: java.lang.Exception -> L5c
            if (r4 == 0) goto L66
            byte[] r9 = r4.digest(r9)     // Catch: java.lang.Exception -> L5c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5c
            r4.<init>()     // Catch: java.lang.Exception -> L5c
            int r5 = r9.length     // Catch: java.lang.Exception -> L5c
            r6 = r2
        L45:
            if (r6 >= r5) goto L5e
            r7 = r9[r6]     // Catch: java.lang.Exception -> L5c
            r7 = r7 & 255(0xff, float:3.57E-43)
            r7 = r7 | 256(0x100, float:3.59E-43)
            java.lang.String r7 = java.lang.Integer.toHexString(r7)     // Catch: java.lang.Exception -> L5c
            r8 = 3
            java.lang.String r7 = r7.substring(r3, r8)     // Catch: java.lang.Exception -> L5c
            r4.append(r7)     // Catch: java.lang.Exception -> L5c
            int r6 = r6 + 1
            goto L45
        L5c:
            r9 = move-exception
            goto L63
        L5e:
            java.lang.String r9 = r4.toString()     // Catch: java.lang.Exception -> L5c
            goto L67
        L63:
            r9.printStackTrace()
        L66:
            r9 = r1
        L67:
            boolean r4 = android.text.TextUtils.isEmpty(r9)
            if (r4 != 0) goto La6
            java.lang.String r0 = r0.getPackageName()
            java.lang.String r1 = "OUID"
            ca.fa.ca.a$a$a r10 = (ca.fa.ca.a.AbstractBinderC0140a.C0141a) r10
            android.os.Parcel r4 = android.os.Parcel.obtain()
            android.os.Parcel r5 = android.os.Parcel.obtain()
            java.lang.String r6 = "com.heytap.openid.IOpenID"
            r4.writeInterfaceToken(r6)     // Catch: java.lang.Throwable -> L9e
            r4.writeString(r0)     // Catch: java.lang.Throwable -> L9e
            r4.writeString(r9)     // Catch: java.lang.Throwable -> L9e
            r4.writeString(r1)     // Catch: java.lang.Throwable -> L9e
            android.os.IBinder r9 = r10.f2128a     // Catch: java.lang.Throwable -> L9e
            r9.transact(r3, r4, r5, r2)     // Catch: java.lang.Throwable -> L9e
            r5.readException()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r1 = r5.readString()     // Catch: java.lang.Throwable -> L9e
            r5.recycle()
            r4.recycle()
            goto La6
        L9e:
            r9 = move-exception
            r5.recycle()
            r4.recycle()
            throw r9
        La6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: x.l.b(java.lang.Object):java.lang.Object");
    }
}
