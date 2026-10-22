package z8;

import T8.C0252d;
import T8.InterfaceC0249a;
import X8.w;
import h8.InterfaceC1503K;
import java.util.List;
import k8.z;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import u1.C2031a;

/* renamed from: z8.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2193e extends kotlin.reflect.jvm.internal.impl.load.kotlin.a implements InterfaceC0249a {
    public final W8.e b;
    public final z c;
    public final u1.d d;
    public final C0252d e;
    public F8.f f;

    public C2193e(z zVar, u1.d dVar, W8.i iVar, C2031a c2031a) {
        super(c2031a);
        this.b = iVar.c(new J4.b(this, 29));
        this.c = zVar;
        this.d = dVar;
        this.e = new C0252d(zVar, dVar);
        this.f = F8.f.g;
    }

    public static final L8.g h(C2193e c2193e, G8.f fVar, Object obj) {
        L8.g gVarB = L8.h.b(obj, c2193e.c);
        if (gVarB != null) {
            return gVarB;
        }
        String message = "Unsupported annotation argument: " + fVar;
        kotlin.jvm.internal.k.f(message, "message");
        return new L8.j(message);
    }

    @Override // T8.InterfaceC0249a
    public final Object W(J5.b bVar, ProtoBuf$Property proto, w wVar) {
        kotlin.jvm.internal.k.f(proto, "proto");
        return i(bVar, proto, AnnotatedCallableKind.c, wVar, C2189a.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a
    public final F1.b e(G8.b bVar, InterfaceC1503K interfaceC1503K, List result) {
        kotlin.jvm.internal.k.f(result, "result");
        return new F1.b(this, kotlin.reflect.jvm.internal.impl.descriptors.a.c(this.c, bVar, this.d), bVar, result, interfaceC1503K);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(J5.b r10, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r11, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r12, X8.w r13, S7.n r14) {
        /*
            r9 = this;
            D8.b r0 = D8.e.f410B
            int r1 = r11.d
            java.lang.Boolean r5 = r0.c(r1)
            boolean r6 = F8.i.d(r11)
            u1.a r7 = r9.f5008a
            F8.f r8 = r9.f
            r3 = 1
            r4 = 1
            r2 = r10
            m8.b r10 = z8.AbstractC2190b.a(r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            if (r10 != 0) goto L33
            boolean r10 = r2 instanceof T8.w
            if (r10 == 0) goto L32
            r10 = r2
            T8.w r10 = (T8.w) r10
            java.lang.Object r10 = r10.d
            h8.K r10 = (h8.InterfaceC1503K) r10
            boolean r1 = r10 instanceof z8.q
            if (r1 == 0) goto L2c
            z8.q r10 = (z8.q) r10
            goto L2d
        L2c:
            r10 = r0
        L2d:
            if (r10 == 0) goto L32
            m8.b r10 = r10.f6987a
            goto L33
        L32:
            r10 = r0
        L33:
            if (r10 != 0) goto L36
            goto L68
        L36:
            A8.a r1 = r10.b
            java.lang.Object r1 = r1.d
            F8.f r1 = (F8.f) r1
            F8.f r3 = z8.C2195g.e
            java.lang.String r4 = "version"
            kotlin.jvm.internal.k.f(r3, r4)
            int r4 = r3.b
            int r5 = r3.c
            int r3 = r3.d
            boolean r1 = r1.a(r4, r5, r3)
            java.lang.Object r3 = r2.b
            D8.f r3 = (D8.f) r3
            java.lang.Object r2 = r2.c
            D8.j r2 = (D8.j) r2
            z8.r r11 = kotlin.reflect.jvm.internal.impl.load.kotlin.a.c(r11, r3, r2, r12, r1)
            if (r11 != 0) goto L5c
            goto L68
        L5c:
            W8.e r9 = r9.b
            java.lang.Object r9 = r9.invoke(r10)
            java.lang.Object r9 = r14.invoke(r9, r11)
            if (r9 != 0) goto L69
        L68:
            return r0
        L69:
            boolean r10 = e8.q.a(r13)
            if (r10 == 0) goto Lc1
            L8.g r9 = (L8.g) r9
            boolean r10 = r9 instanceof L8.d
            if (r10 == 0) goto L85
            L8.y r10 = new L8.y
            L8.d r9 = (L8.d) r9
            java.lang.Object r9 = r9.f939a
            java.lang.Number r9 = (java.lang.Number) r9
            byte r9 = r9.byteValue()
            r10.<init>(r9)
            return r10
        L85:
            boolean r10 = r9 instanceof L8.v
            if (r10 == 0) goto L99
            L8.y r10 = new L8.y
            L8.v r9 = (L8.v) r9
            java.lang.Object r9 = r9.f939a
            java.lang.Number r9 = (java.lang.Number) r9
            short r9 = r9.shortValue()
            r10.<init>(r9)
            return r10
        L99:
            boolean r10 = r9 instanceof L8.k
            if (r10 == 0) goto Lad
            L8.y r10 = new L8.y
            L8.k r9 = (L8.k) r9
            java.lang.Object r9 = r9.f939a
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            r10.<init>(r9)
            return r10
        Lad:
            boolean r10 = r9 instanceof L8.t
            if (r10 == 0) goto Lc1
            L8.y r10 = new L8.y
            L8.t r9 = (L8.t) r9
            java.lang.Object r9 = r9.f939a
            java.lang.Number r9 = (java.lang.Number) r9
            long r11 = r9.longValue()
            r10.<init>(r11)
            return r10
        Lc1:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.C2193e.i(J5.b, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind, X8.w, S7.n):java.lang.Object");
    }

    @Override // T8.InterfaceC0249a
    public final Object n0(J5.b bVar, ProtoBuf$Property proto, w wVar) {
        kotlin.jvm.internal.k.f(proto, "proto");
        return i(bVar, proto, AnnotatedCallableKind.b, wVar, C2189a.c);
    }
}
