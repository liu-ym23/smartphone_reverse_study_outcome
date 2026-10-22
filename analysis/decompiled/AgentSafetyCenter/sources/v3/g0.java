package v3;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 implements a {

    /* renamed from: a, reason: collision with root package name */
    public File f14637a;

    /* renamed from: b, reason: collision with root package name */
    public p0 f14638b;

    /* renamed from: c, reason: collision with root package name */
    public ad.l f14639c;

    /* renamed from: d, reason: collision with root package name */
    public AtomicBoolean f14640d;

    /* renamed from: e, reason: collision with root package name */
    public sc.c f14641e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [v3.m] */
    /* JADX WARN: Type inference failed for: r9v7, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(v3.m r8, pb.c r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof v3.e0
            if (r0 == 0) goto L13
            r0 = r9
            v3.e0 r0 = (v3.e0) r0
            int r1 = r0.f14626j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f14626j = r1
            goto L18
        L13:
            v3.e0 r0 = new v3.e0
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f14625h
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f14626j
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L34
            boolean r7 = r0.f14624g
            v3.b0 r8 = r0.f14623f
            v3.g0 r0 = r0.f14622c
            id.c.I(r9)     // Catch: java.lang.Throwable -> L2e
            goto L6a
        L2e:
            r9 = move-exception
            r6 = r9
            r9 = r7
            r7 = r0
            r0 = r6
            goto L82
        L34:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r7)
        L39:
            r7 = 0
            return r7
        L3b:
            id.c.I(r9)
            java.util.concurrent.atomic.AtomicBoolean r9 = r7.f14640d
            boolean r9 = r9.get()
            if (r9 != 0) goto L94
            sc.c r9 = r7.f14641e
            boolean r9 = r9.f()
            v3.b0 r2 = new v3.b0     // Catch: java.lang.Throwable -> L8b
            java.io.File r5 = r7.f14637a     // Catch: java.lang.Throwable -> L8b
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L8b
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r9)     // Catch: java.lang.Throwable -> L7f
            r0.f14622c = r7     // Catch: java.lang.Throwable -> L7f
            r0.f14623f = r2     // Catch: java.lang.Throwable -> L7f
            r0.f14624g = r9     // Catch: java.lang.Throwable -> L7f
            r0.f14626j = r3     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r8 = r8.invoke(r2, r5, r0)     // Catch: java.lang.Throwable -> L7f
            if (r8 != r1) goto L66
            return r1
        L66:
            r0 = r7
            r7 = r9
            r9 = r8
            r8 = r2
        L6a:
            r8.close()     // Catch: java.lang.Throwable -> L6f
            r8 = r4
            goto L70
        L6f:
            r8 = move-exception
        L70:
            if (r8 != 0) goto L7a
            if (r7 == 0) goto L79
            sc.c r7 = r0.f14641e
            r7.e(r4)
        L79:
            return r9
        L7a:
            throw r8     // Catch: java.lang.Throwable -> L7b
        L7b:
            r8 = move-exception
            r9 = r7
            r7 = r0
            goto L8c
        L7f:
            r8 = move-exception
            r0 = r8
            r8 = r2
        L82:
            r8.close()     // Catch: java.lang.Throwable -> L86
            goto L8a
        L86:
            r8 = move-exception
            com.stepos.statsrpk.h.b(r0, r8)     // Catch: java.lang.Throwable -> L8b
        L8a:
            throw r0     // Catch: java.lang.Throwable -> L8b
        L8b:
            r8 = move-exception
        L8c:
            if (r9 == 0) goto L93
            sc.c r7 = r7.f14641e
            r7.e(r4)
        L93:
            throw r8
        L94:
            java.lang.String r7 = "StorageConnection has already been disposed."
            od.f.e(r7)
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.g0.a(v3.m, pb.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c9 A[Catch: all -> 0x0107, IOException -> 0x0109, TRY_ENTER, TryCatch #0 {IOException -> 0x0109, blocks: (B:42:0x00c9, B:44:0x00cf, B:48:0x00e6, B:49:0x0106, B:56:0x0113, B:63:0x0121, B:62:0x011e), top: B:75:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0113 A[Catch: all -> 0x0107, IOException -> 0x0109, TRY_ENTER, TRY_LEAVE, TryCatch #0 {IOException -> 0x0109, blocks: (B:42:0x00c9, B:44:0x00cf, B:48:0x00e6, B:49:0x0106, B:56:0x0113, B:63:0x0121, B:62:0x011e), top: B:75:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [sc.a] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v25, types: [sc.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(m8.e0 r10, pb.c r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.g0.b(m8.e0, pb.c):java.lang.Object");
    }

    @Override // v3.a
    public final void close() {
        this.f14640d.set(true);
        this.f14639c.invoke();
    }
}
