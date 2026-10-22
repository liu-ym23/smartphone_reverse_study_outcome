package z4;

import a6.c0;
import a6.e0;
import a6.h1;
import a6.j1;
import f5.h;
import io.ktor.utils.io.i0;
import io.ktor.utils.io.j0;
import io.ktor.utils.io.p;
import java.io.IOException;
import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements p {

    /* renamed from: b, reason: collision with root package name */
    public final j6.b f6534b;

    /* renamed from: c, reason: collision with root package name */
    public j0 f6535c;
    public final j6.a d;

    /* renamed from: e, reason: collision with root package name */
    public final j1 f6536e;

    /* renamed from: f, reason: collision with root package name */
    public final h f6537f;

    public c(j6.b bVar, h parent) {
        kotlin.jvm.internal.p.e(parent, "parent");
        this.f6534b = bVar;
        this.d = new j6.a();
        j1 j1Var = new j1((h1) parent.o(c0.f143b));
        this.f6536e = j1Var;
        this.f6537f = parent.t(j1Var).t(new e0("RawSourceChannel"));
    }

    @Override // io.ktor.utils.io.p
    public final Throwable a() {
        j0 j0Var = this.f6535c;
        if (j0Var != null) {
            return j0Var.a(i0.f3206a);
        }
        return null;
    }

    @Override // io.ktor.utils.io.p
    public final j6.a b() {
        return this.d;
    }

    @Override // io.ktor.utils.io.p
    public final void c(Throwable th) throws IOException {
        if (this.f6535c != null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "Channel was cancelled";
        }
        CancellationException cancellationException = new CancellationException(message);
        cancellationException.initCause(th);
        this.f6536e.e(cancellationException);
        this.f6534b.close();
        String message2 = th.getMessage();
        this.f6535c = new j0(new IOException(message2 != null ? message2 : "Channel was cancelled", th));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.utils.io.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(int r5, h5.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof z4.b
            if (r0 == 0) goto L13
            r0 = r6
            z4.b r0 = (z4.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            z4.b r0 = new z4.b
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f6532b
            g5.a r1 = g5.a.f2984a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            int r5 = r0.f6531a
            a.a.c0(r6)
            goto L4e
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            a.a.c0(r6)
            io.ktor.utils.io.j0 r6 = r4.f6535c
            if (r6 == 0) goto L3b
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            return r4
        L3b:
            z4.a r6 = new z4.a
            r2 = 0
            r6.<init>(r4, r5, r2)
            r0.f6531a = r5
            r0.d = r3
            f5.h r2 = r4.f6537f
            java.lang.Object r6 = a6.i0.A(r2, r6, r0)
            if (r6 != r1) goto L4e
            return r1
        L4e:
            j6.a r4 = r4.d
            long r0 = x.f.W(r4)
            long r4 = (long) r5
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 < 0) goto L5a
            goto L5b
        L5a:
            r3 = 0
        L5b:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.c.d(int, h5.c):java.lang.Object");
    }

    @Override // io.ktor.utils.io.p
    public final boolean e() {
        return this.f6535c != null && this.d.q();
    }
}
