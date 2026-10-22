package K0;

import android.graphics.Bitmap;
import z0.C1341g;
import z0.C1342h;
import z0.EnumC1337c;

/* loaded from: classes.dex */
public class c implements z0.j<Bitmap> {

    /* renamed from: b, reason: collision with root package name */
    public static final C1341g<Integer> f3510b = C1341g.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: c, reason: collision with root package name */
    public static final C1341g<Bitmap.CompressFormat> f3511c = C1341g.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: a, reason: collision with root package name */
    private final D0.b f3512a;

    public c(D0.b bVar) {
        this.f3512a = bVar;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, C1342h c1342h) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) c1342h.c(f3511c);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // z0.j
    public EnumC1337c a(C1342h c1342h) {
        return EnumC1337c.TRANSFORMED;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0073 A[Catch: all -> 0x00c3, TRY_LEAVE, TryCatch #2 {all -> 0x00c3, blocks: (B:3:0x0021, B:16:0x0052, B:29:0x006d, B:31:0x0073, B:35:0x00bf, B:36:0x00c2, B:26:0x0068), top: B:45:0x0021 }] */
    @Override // z0.InterfaceC1338d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(C0.v<android.graphics.Bitmap> r8, java.io.File r9, z0.C1342h r10) {
        /*
            r7 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r8 = r8.get()
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            android.graphics.Bitmap$CompressFormat r1 = r7.d(r8, r10)
            int r2 = r8.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r8.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            Y0.b.c(r4, r2, r3, r1)
            long r2 = X0.f.b()     // Catch: java.lang.Throwable -> Lc3
            z0.g<java.lang.Integer> r4 = K0.c.f3510b     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r4 = r10.c(r4)     // Catch: java.lang.Throwable -> Lc3
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Lc3
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Lc3
            r5 = 0
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            D0.b r9 = r7.f3512a     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            if (r9 == 0) goto L4b
            A0.c r9 = new A0.c     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            D0.b r7 = r7.f3512a     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            r9.<init>(r6, r7)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            r5 = r9
            goto L4c
        L44:
            r7 = move-exception
            r5 = r6
            goto Lbd
        L48:
            r7 = move-exception
            r5 = r6
            goto L5a
        L4b:
            r5 = r6
        L4c:
            r8.compress(r1, r4, r5)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r5.close()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r5.close()     // Catch: java.io.IOException -> L55 java.lang.Throwable -> Lc3
        L55:
            r7 = 1
            goto L6c
        L57:
            r7 = move-exception
            goto Lbd
        L59:
            r7 = move-exception
        L5a:
            r9 = 3
            boolean r9 = android.util.Log.isLoggable(r0, r9)     // Catch: java.lang.Throwable -> L57
            if (r9 == 0) goto L66
            java.lang.String r9 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r9, r7)     // Catch: java.lang.Throwable -> L57
        L66:
            if (r5 == 0) goto L6b
            r5.close()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> Lc3
        L6b:
            r7 = 0
        L6c:
            r9 = 2
            boolean r9 = android.util.Log.isLoggable(r0, r9)     // Catch: java.lang.Throwable -> Lc3
            if (r9 == 0) goto Lb9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            r9.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r4 = "Compressed with type: "
            r9.append(r4)     // Catch: java.lang.Throwable -> Lc3
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = " of size "
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc3
            int r1 = X0.k.h(r8)     // Catch: java.lang.Throwable -> Lc3
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = " in "
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc3
            double r1 = X0.f.a(r2)     // Catch: java.lang.Throwable -> Lc3
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = ", options format: "
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc3
            z0.g<android.graphics.Bitmap$CompressFormat> r1 = K0.c.f3511c     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r10 = r10.c(r1)     // Catch: java.lang.Throwable -> Lc3
            r9.append(r10)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r10 = ", hasAlpha: "
            r9.append(r10)     // Catch: java.lang.Throwable -> Lc3
            boolean r8 = r8.hasAlpha()     // Catch: java.lang.Throwable -> Lc3
            r9.append(r8)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r8 = r9.toString()     // Catch: java.lang.Throwable -> Lc3
            android.util.Log.v(r0, r8)     // Catch: java.lang.Throwable -> Lc3
        Lb9:
            Y0.b.d()
            return r7
        Lbd:
            if (r5 == 0) goto Lc2
            r5.close()     // Catch: java.io.IOException -> Lc2 java.lang.Throwable -> Lc3
        Lc2:
            throw r7     // Catch: java.lang.Throwable -> Lc3
        Lc3:
            r7 = move-exception
            Y0.b.d()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: K0.c.b(C0.v, java.io.File, z0.h):boolean");
    }
}
