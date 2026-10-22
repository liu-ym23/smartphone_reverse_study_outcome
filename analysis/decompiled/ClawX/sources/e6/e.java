package e6;

import java.util.ArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e implements g {

    /* renamed from: a, reason: collision with root package name */
    public final f5.h f2380a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2381b;

    /* renamed from: c, reason: collision with root package name */
    public final c6.a f2382c;
    public final d6.b d;

    public e(d6.b bVar, f5.h hVar, int i8, c6.a aVar) {
        this.f2380a = hVar;
        this.f2381b = i8;
        this.f2382c = aVar;
        this.d = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    @Override // e6.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d6.b a(f5.h r5, int r6, c6.a r7) {
        /*
            r4 = this;
            f5.h r0 = r4.f2380a
            f5.h r5 = r5.t(r0)
            c6.a r1 = c6.a.f1102a
            c6.a r2 = r4.f2382c
            int r3 = r4.f2381b
            if (r7 == r1) goto Lf
            goto L26
        Lf:
            r7 = -3
            if (r3 != r7) goto L13
            goto L25
        L13:
            if (r6 != r7) goto L17
        L15:
            r6 = r3
            goto L25
        L17:
            r7 = -2
            if (r3 != r7) goto L1b
            goto L25
        L1b:
            if (r6 != r7) goto L1e
            goto L15
        L1e:
            int r6 = r6 + r3
            if (r6 < 0) goto L22
            goto L25
        L22:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L25:
            r7 = r2
        L26:
            boolean r0 = kotlin.jvm.internal.p.a(r5, r0)
            if (r0 == 0) goto L31
            if (r6 != r3) goto L31
            if (r7 != r2) goto L31
            return r4
        L31:
            e6.e r0 = new e6.e
            d6.b r4 = r4.d
            r0.<init>(r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.e.a(f5.h, int, c6.a):d6.b");
    }

    public final String b() {
        ArrayList arrayList = new ArrayList(4);
        f5.i iVar = f5.i.f2626a;
        f5.h hVar = this.f2380a;
        if (hVar != iVar) {
            arrayList.add("context=" + hVar);
        }
        int i8 = this.f2381b;
        if (i8 != -3) {
            arrayList.add("capacity=" + i8);
        }
        c6.a aVar = c6.a.f1102a;
        c6.a aVar2 = this.f2382c;
        if (aVar2 != aVar) {
            arrayList.add("onBufferOverflow=" + aVar2);
        }
        return getClass().getSimpleName() + AbstractJsonLexerKt.BEGIN_LIST + c5.m.A0(arrayList, ", ", null, null, null, 62) + AbstractJsonLexerKt.END_LIST;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    @Override // d6.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(d6.c r7, f5.c r8) throws java.lang.Throwable {
        /*
            r6 = this;
            int r0 = r6.f2381b
            r1 = -3
            r2 = 0
            b5.a0 r3 = b5.a0.f883a
            if (r0 != r1) goto L72
            f5.h r0 = r8.getContext()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            a6.y r4 = new a6.y
            r5 = 0
            r4.<init>(r5)
            f5.h r5 = r6.f2380a
            java.lang.Object r1 = r5.z(r1, r4)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L27
            f5.h r1 = r0.t(r5)
            goto L2c
        L27:
            r1 = 0
            f5.h r1 = a6.i0.i(r0, r5, r1)
        L2c:
            boolean r4 = kotlin.jvm.internal.p.a(r1, r0)
            if (r4 == 0) goto L41
            d6.b r6 = r6.d
            java.lang.Object r6 = r6.collect(r7, r8)
            g5.a r7 = g5.a.f2984a
            if (r6 != r7) goto L3d
            goto L3e
        L3d:
            r6 = r3
        L3e:
            if (r6 != r7) goto L8f
            return r6
        L41:
            f5.d r4 = f5.d.f2625a
            f5.f r5 = r1.o(r4)
            f5.f r0 = r0.o(r4)
            boolean r0 = kotlin.jvm.internal.p.a(r5, r0)
            if (r0 == 0) goto L72
            f5.h r0 = r8.getContext()
            boolean r4 = r7 instanceof e6.m
            if (r4 != 0) goto L5f
            d6.m r4 = new d6.m
            r4.<init>(r7, r0)
            r7 = r4
        L5f:
            e6.d r0 = new e6.d
            r4 = 1
            r0.<init>(r6, r2, r4)
            java.lang.Object r6 = f6.a.m(r1)
            java.lang.Object r6 = e6.i.a(r1, r7, r6, r0, r8)
            g5.a r7 = g5.a.f2984a
            if (r6 != r7) goto L8f
            return r6
        L72:
            e6.c r0 = new e6.c
            r1 = 0
            r0.<init>(r7, r6, r2, r1)
            f6.p r6 = new f6.p
            f5.h r7 = r8.getContext()
            r6.<init>(r8, r7)
            r7 = 1
            java.lang.Object r6 = b8.h.M(r6, r7, r6, r0)
            g5.a r7 = g5.a.f2984a
            if (r6 != r7) goto L8b
            goto L8c
        L8b:
            r6 = r3
        L8c:
            if (r6 != r7) goto L8f
            return r6
        L8f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.e.collect(d6.c, f5.c):java.lang.Object");
    }

    public final String toString() {
        return this.d + " -> " + b();
    }
}
