package j0;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j0 implements a {

    /* renamed from: a, reason: collision with root package name */
    public final File f3378a;

    /* renamed from: b, reason: collision with root package name */
    public final u0 f3379b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.lifecycle.e0 f3380c;
    public final AtomicBoolean d;

    /* renamed from: e, reason: collision with root package name */
    public final i6.c f3381e;

    public j0(File file, u0 coordinator, androidx.lifecycle.e0 e0Var) {
        kotlin.jvm.internal.p.e(coordinator, "coordinator");
        this.f3378a = file;
        this.f3379b = coordinator;
        this.f3380c = e0Var;
        this.d = new AtomicBoolean(false);
        this.f3381e = new i6.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(j0.n r8, h5.c r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof j0.h0
            if (r0 == 0) goto L13
            r0 = r9
            j0.h0 r0 = (j0.h0) r0
            int r1 = r0.f3360f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3360f = r1
            goto L18
        L13:
            j0.h0 r0 = new j0.h0
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.d
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3360f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            boolean r7 = r0.f3358c
            j0.e0 r8 = r0.f3357b
            j0.j0 r0 = r0.f3356a
            a.a.c0(r9)     // Catch: java.lang.Throwable -> L2e
            goto L6b
        L2e:
            r9 = move-exception
            r6 = r9
            r9 = r7
            r7 = r0
            r0 = r6
            goto L83
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            a.a.c0(r9)
            java.util.concurrent.atomic.AtomicBoolean r9 = r7.d
            boolean r9 = r9.get()
            if (r9 != 0) goto L95
            i6.c r9 = r7.f3381e
            boolean r9 = r9.d()
            j0.e0 r2 = new j0.e0     // Catch: java.lang.Throwable -> L8c
            java.io.File r5 = r7.f3378a     // Catch: java.lang.Throwable -> L8c
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L8c
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r9)     // Catch: java.lang.Throwable -> L80
            r0.f3356a = r7     // Catch: java.lang.Throwable -> L80
            r0.f3357b = r2     // Catch: java.lang.Throwable -> L80
            r0.f3358c = r9     // Catch: java.lang.Throwable -> L80
            r0.f3360f = r3     // Catch: java.lang.Throwable -> L80
            java.lang.Object r8 = r8.invoke(r2, r5, r0)     // Catch: java.lang.Throwable -> L80
            if (r8 != r1) goto L67
            return r1
        L67:
            r0 = r7
            r7 = r9
            r9 = r8
            r8 = r2
        L6b:
            r8.close()     // Catch: java.lang.Throwable -> L70
            r8 = r4
            goto L71
        L70:
            r8 = move-exception
        L71:
            if (r8 != 0) goto L7b
            if (r7 == 0) goto L7a
            i6.c r7 = r0.f3381e
            r7.e(r4)
        L7a:
            return r9
        L7b:
            throw r8     // Catch: java.lang.Throwable -> L7c
        L7c:
            r8 = move-exception
            r9 = r7
            r7 = r0
            goto L8d
        L80:
            r8 = move-exception
            r0 = r8
            r8 = r2
        L83:
            r8.close()     // Catch: java.lang.Throwable -> L87
            goto L8b
        L87:
            r8 = move-exception
            a.a.a(r0, r8)     // Catch: java.lang.Throwable -> L8c
        L8b:
            throw r0     // Catch: java.lang.Throwable -> L8c
        L8c:
            r8 = move-exception
        L8d:
            if (r9 == 0) goto L94
            i6.c r7 = r7.f3381e
            r7.e(r4)
        L94:
            throw r8
        L95:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "StorageConnection has already been disposed."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.j0.a(j0.n, h5.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9 A[Catch: all -> 0x011b, IOException -> 0x011d, TRY_ENTER, TryCatch #7 {all -> 0x011b, blocks: (B:42:0x00d9, B:44:0x00df, B:46:0x00e2, B:52:0x00fa, B:53:0x011a, B:60:0x0129, B:67:0x0137, B:66:0x0134), top: B:93:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0129 A[Catch: all -> 0x011b, IOException -> 0x011d, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x011b, blocks: (B:42:0x00d9, B:44:0x00df, B:46:0x00e2, B:52:0x00fa, B:53:0x011a, B:60:0x0129, B:67:0x0137, B:66:0x0134), top: B:93:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(j0.b0 r10, h5.c r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.j0.b(j0.b0, h5.c):java.lang.Object");
    }

    @Override // j0.a
    public final void close() {
        this.d.set(true);
        this.f3380c.invoke();
    }
}
