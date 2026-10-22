package b8;

import h8.InterfaceC1501I;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature;

/* renamed from: b8.n, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0853n extends M0.i {
    public final InterfaceC1501I k;
    public final ProtoBuf$Property l;
    public final JvmProtoBuf$JvmPropertySignature m;
    public final D8.f n;
    public final D8.j o;
    public final String p;

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0853n(h8.InterfaceC1501I r3, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r4, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r5, D8.f r6, D8.j r7) {
        /*
            r2 = this;
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.k.f(r4, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.k.f(r6, r0)
            java.lang.String r0 = "typeTable"
            kotlin.jvm.internal.k.f(r7, r0)
            r2.<init>()
            r2.k = r3
            r2.l = r4
            r2.m = r5
            r2.n = r6
            r2.o = r7
            int r0 = r5.b
            r1 = 4
            r0 = r0 & r1
            if (r0 != r1) goto L38
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r3 = r5.e
            int r3 = r3.c
            java.lang.String r3 = r6.getString(r3)
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = r5.e
            int r4 = r4.d
            java.lang.String r4 = r6.getString(r4)
            java.lang.String r3 = r3.concat(r4)
            goto Le1
        L38:
            r5 = 1
            F8.d r4 = F8.i.b(r4, r6, r7, r5)
            if (r4 == 0) goto Le4
            java.lang.String r5 = r4.f591q
            java.lang.String r4 = r4.f592r
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r5 = q8.AbstractC1847t.a(r5)
            r7.append(r5)
            h8.j r5 = r3.d()
            java.lang.String r0 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.k.e(r5, r0)
            h8.n r0 = r3.getVisibility()
            h8.n r1 = h8.AbstractC1532o.d
            boolean r0 = kotlin.jvm.internal.k.b(r0, r1)
            java.lang.String r1 = "$"
            if (r0 == 0) goto L95
            boolean r0 = r5 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b
            if (r0 == 0) goto L95
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b r5 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b) r5
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r3 = r5.e
            H8.l r5 = E8.c.i
            java.lang.String r0 = "classModuleName"
            kotlin.jvm.internal.k.e(r5, r0)
            java.lang.Object r3 = D8.h.a(r3, r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L86
            int r3 = r3.intValue()
            java.lang.String r3 = r6.getString(r3)
            goto L88
        L86:
            java.lang.String r3 = "main"
        L88:
            kotlin.text.Regex r5 = G8.g.f691a
            java.lang.String r6 = "_"
            java.lang.String r3 = r5.f(r3, r6)
            java.lang.String r3 = r1.concat(r3)
            goto Ldb
        L95:
            h8.n r6 = r3.getVisibility()
            h8.n r0 = h8.AbstractC1532o.f4583a
            boolean r6 = kotlin.jvm.internal.k.b(r6, r0)
            if (r6 == 0) goto Ld9
            boolean r5 = r5 instanceof h8.InterfaceC1494B
            if (r5 == 0) goto Ld9
            V8.r r3 = (V8.r) r3
            V8.j r3 = r3.E
            boolean r5 = r3 instanceof z8.C2197i
            if (r5 == 0) goto Ld9
            z8.i r3 = (z8.C2197i) r3
            O8.b r5 = r3.b
            if (r5 == 0) goto Ld9
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r1)
            O8.b r3 = r3.f6985a
            java.lang.String r3 = r3.d()
            java.lang.String r6 = "getInternalName(...)"
            kotlin.jvm.internal.k.e(r3, r6)
            r6 = 47
            java.lang.String r3 = j9.m.I0(r6, r3, r3)
            G8.f r3 = G8.f.e(r3)
            java.lang.String r3 = r3.b()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            goto Ldb
        Ld9:
            java.lang.String r3 = ""
        Ldb:
            java.lang.String r5 = "()"
            java.lang.String r3 = androidx.constraintlayout.core.dsl.a.j(r7, r3, r5, r4)
        Le1:
            r2.p = r3
            return
        Le4:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r2 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "No field signature for property: "
            r4.<init>(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.C0853n.<init>(h8.I, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature, D8.f, D8.j):void");
    }

    @Override // M0.i
    public final String l() {
        return this.p;
    }
}
