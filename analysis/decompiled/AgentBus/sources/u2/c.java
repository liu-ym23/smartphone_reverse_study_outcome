package u2;

import ob.o;
import ob.z;

/* loaded from: classes.dex */
public class c implements s2.a {

    /* renamed from: a, reason: collision with root package name */
    public final o f9965a;

    /* renamed from: b, reason: collision with root package name */
    public final z f9966b;

    /* renamed from: c, reason: collision with root package name */
    public final a f9967c;

    public c(o oVar, z zVar) {
        q7.k.e(oVar, "fileSystem");
        q7.k.e(zVar, "path");
        this.f9965a = oVar;
        this.f9966b = zVar;
        this.f9967c = new a();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0083 A[Catch: FileNotFoundException -> 0x0087, TRY_ENTER, TryCatch #3 {FileNotFoundException -> 0x0087, blocks: (B:42:0x0083, B:45:0x008b, B:20:0x0043), top: B:59:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008b A[Catch: FileNotFoundException -> 0x0087, TRY_LEAVE, TryCatch #3 {FileNotFoundException -> 0x0087, blocks: (B:42:0x0083, B:45:0x008b, B:20:0x0043), top: B:59:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object a(u2.c r6, i7.c r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof u2.b
            if (r0 == 0) goto L13
            r0 = r7
            u2.b r0 = (u2.b) r0
            int r1 = r0.f9964j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9964j = r1
            goto L18
        L13:
            u2.b r0 = new u2.b
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f9962h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f9964j
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            ob.e0 r6 = r0.f9961g
            u2.c r0 = r0.f9960f
            w7.e0.N(r7)     // Catch: java.lang.Throwable -> L2c
            goto L62
        L2c:
            r7 = move-exception
            goto L70
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            w7.e0.N(r7)
            u2.a r7 = r6.f9967c
            java.util.concurrent.atomic.AtomicBoolean r7 = r7.f9959a
            boolean r7 = r7.get()
            if (r7 != 0) goto L9d
            ob.o r7 = r6.f9965a     // Catch: java.io.FileNotFoundException -> L87
            ob.z r2 = r6.f9966b     // Catch: java.io.FileNotFoundException -> L87
            ob.k0 r7 = r7.h(r2)     // Catch: java.io.FileNotFoundException -> L87
            ob.e0 r7 = ob.b.c(r7)     // Catch: java.io.FileNotFoundException -> L87
            w2.g r2 = w2.g.f10656a     // Catch: java.lang.Throwable -> L6b
            r0.f9960f = r6     // Catch: java.lang.Throwable -> L6b
            r0.f9961g = r7     // Catch: java.lang.Throwable -> L6b
            r0.f9964j = r3     // Catch: java.lang.Throwable -> L6b
            w2.b r0 = r2.a(r7)     // Catch: java.lang.Throwable -> L6b
            if (r0 != r1) goto L5e
            return r1
        L5e:
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L62:
            if (r6 == 0) goto L69
            r6.close()     // Catch: java.lang.Throwable -> L68
            goto L69
        L68:
            r4 = move-exception
        L69:
            r6 = r0
            goto L81
        L6b:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L70:
            if (r6 == 0) goto L7d
            r6.close()     // Catch: java.lang.Throwable -> L76
            goto L7d
        L76:
            r6 = move-exception
            ib.k.e(r7, r6)     // Catch: java.io.FileNotFoundException -> L7b
            goto L7d
        L7b:
            r6 = move-exception
            goto L8c
        L7d:
            r6 = r4
            r4 = r7
            r7 = r6
            goto L69
        L81:
            if (r4 != 0) goto L8b
            q7.k.b(r7)     // Catch: java.io.FileNotFoundException -> L87
            goto L9b
        L87:
            r7 = move-exception
            r0 = r6
            r6 = r7
            goto L8c
        L8b:
            throw r4     // Catch: java.io.FileNotFoundException -> L87
        L8c:
            ob.o r7 = r0.f9965a
            ob.z r0 = r0.f9966b
            boolean r7 = r7.d(r0)
            if (r7 != 0) goto L9c
            w2.b r7 = new w2.b
            r7.<init>(r3)
        L9b:
            return r7
        L9c:
            throw r6
        L9d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "This scope has already been closed."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.c.a(u2.c, i7.c):java.lang.Object");
    }

    @Override // s2.a
    public final void close() {
        this.f9967c.f9959a.set(true);
    }
}
