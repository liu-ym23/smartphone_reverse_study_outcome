package v4;

import java.util.List;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends f {

    /* renamed from: b, reason: collision with root package name */
    public final List f5963b;

    /* renamed from: c, reason: collision with root package name */
    public final f5.h f5964c;
    public Object d;

    /* renamed from: e, reason: collision with root package name */
    public int f5965e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Object context, List interceptors, Object subject, f5.h hVar) {
        super(context);
        p.e(context, "context");
        p.e(interceptors, "interceptors");
        p.e(subject, "subject");
        this.f5963b = interceptors;
        this.f5964c = hVar;
        this.d = subject;
    }

    @Override // v4.f
    public final Object a(Object obj, h5.c cVar) {
        this.f5965e = 0;
        p.e(obj, "<set-?>");
        this.d = obj;
        return d(cVar);
    }

    @Override // a6.f0
    public final f5.h b() {
        return this.f5964c;
    }

    @Override // v4.f
    public final Object c() {
        return this.d;
    }

    @Override // v4.f
    public final Object d(f5.c cVar) {
        int i8 = this.f5965e;
        if (i8 < 0) {
            return this.d;
        }
        if (i8 < this.f5963b.size()) {
            return f(cVar);
        }
        this.f5965e = -1;
        return this.d;
    }

    @Override // v4.f
    public final Object e(f5.c cVar, Object obj) {
        p.e(obj, "<set-?>");
        this.d = obj;
        return d(cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(f5.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof v4.a
            if (r0 == 0) goto L13
            r0 = r7
            v4.a r0 = (v4.a) r0
            int r1 = r0.f5962c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5962c = r1
            goto L18
        L13:
            v4.a r0 = new v4.a
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f5960a
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f5962c
            r3 = 1
            if (r2 == 0) goto L2c
            if (r2 != r3) goto L24
            goto L2c
        L24:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2c:
            a.a.c0(r7)
        L2f:
            int r7 = r6.f5965e
            r2 = -1
            if (r7 != r2) goto L35
            goto L3f
        L35:
            java.util.List r4 = r6.f5963b
            int r5 = r4.size()
            if (r7 < r5) goto L42
            r6.f5965e = r2
        L3f:
            java.lang.Object r6 = r6.d
            return r6
        L42:
            java.lang.Object r2 = r4.get(r7)
            p5.q r2 = (p5.q) r2
            int r7 = r7 + 1
            r6.f5965e = r7
            java.lang.Object r7 = r6.d
            r0.f5962c = r3
            java.lang.Object r7 = r2.invoke(r6, r7, r0)
            if (r7 != r1) goto L2f
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.b.f(f5.c):java.lang.Object");
    }
}
