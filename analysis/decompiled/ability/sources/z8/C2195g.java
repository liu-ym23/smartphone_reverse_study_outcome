package z8;

import D7.N;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import m8.C1682b;
import n8.AbstractC1744c;

/* renamed from: z8.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2195g {
    public static final Set b = N.Q(KotlinClassHeader$Kind.e);
    public static final Set c = D7.q.K0(new KotlinClassHeader$Kind[]{KotlinClassHeader$Kind.f, KotlinClassHeader$Kind.i});
    public static final F8.f d;
    public static final F8.f e;

    /* renamed from: a, reason: collision with root package name */
    public T8.k f6984a;

    static {
        new F8.f(false, new int[]{1, 1, 2});
        d = new F8.f(false, new int[]{1, 1, 11});
        e = new F8.f(false, new int[]{1, 1, 13});
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V8.q a(h8.InterfaceC1494B r17, m8.C1682b r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = r18
            java.lang.String r3 = "Could not read data from "
            java.lang.String r0 = "kotlinClass"
            kotlin.jvm.internal.k.f(r2, r0)
            A8.a r0 = r2.b
            java.lang.Object r4 = r0.e
            java.lang.String[] r4 = (java.lang.String[]) r4
            if (r4 != 0) goto L17
            java.lang.Object r4 = r0.f
            java.lang.String[] r4 = (java.lang.String[]) r4
        L17:
            r5 = 0
            if (r4 == 0) goto L27
            java.lang.Object r6 = r0.c
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r6 = (kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind) r6
            java.util.Set r7 = z8.C2195g.c
            boolean r6 = r7.contains(r6)
            if (r6 == 0) goto L27
            goto L28
        L27:
            r4 = r5
        L28:
            if (r4 != 0) goto L2b
            goto L74
        L2b:
            java.lang.Object r6 = r0.d
            r11 = r6
            F8.f r11 = (F8.f) r11
            java.lang.Object r0 = r0.g
            java.lang.String[] r0 = (java.lang.String[]) r0
            if (r0 != 0) goto L37
            goto L74
        L37:
            kotlin.Pair r0 = F8.i.h(r4, r0)     // Catch: java.lang.Throwable -> L3c kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L3e
            goto L72
        L3c:
            r0 = move-exception
            goto L55
        L3e:
            r0 = move-exception
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L3c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = r2.a()     // Catch: java.lang.Throwable -> L3c
            r6.append(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L3c
            r4.<init>(r3, r0)     // Catch: java.lang.Throwable -> L3c
            throw r4     // Catch: java.lang.Throwable -> L3c
        L55:
            T8.k r3 = r1.c()
            T8.l r3 = r3.c
            r3.getClass()
            T8.k r3 = r1.c()
            T8.l r3 = r3.c
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.k.f(r3, r4)
            F8.f r3 = F8.f.g
            boolean r3 = r11.b(r3)
            if (r3 != 0) goto Lb2
            r0 = r5
        L72:
            if (r0 != 0) goto L75
        L74:
            return r5
        L75:
            java.lang.Object r3 = r0.f4886a
            r10 = r3
            F8.g r10 = (F8.g) r10
            java.lang.Object r0 = r0.b
            r9 = r0
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r9 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package) r9
            z8.i r12 = new z8.i
            r1.d(r2)
            r1.e(r2)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability r0 = r1.b(r2)
            r12.<init>(r2, r9, r10, r0)
            V8.q r7 = new V8.q
            T8.k r13 = r1.c()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "scope for "
            r0.<init>(r1)
            r0.append(r12)
            java.lang.String r1 = " in "
            r0.append(r1)
            r8 = r17
            r0.append(r8)
            java.lang.String r14 = r0.toString()
            z8.f r15 = z8.C2194f.f6983a
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
            return r7
        Lb2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.C2195g.a(h8.B, m8.b):V8.q");
    }

    public final DeserializedContainerAbiStability b(C1682b c1682b) {
        c().c.getClass();
        int i = c1682b.b.b;
        return ((i & 16) == 0 || (i & 32) != 0) ? DeserializedContainerAbiStability.f5128a : DeserializedContainerAbiStability.b;
    }

    public final T8.k c() {
        T8.k kVar = this.f6984a;
        if (kVar != null) {
            return kVar;
        }
        kotlin.jvm.internal.k.n("components");
        throw null;
    }

    public final T8.q d(C1682b c1682b) {
        c().c.getClass();
        F8.f fVar = (F8.f) c1682b.b.d;
        kotlin.jvm.internal.k.f(c().c, "<this>");
        F8.f fVar2 = F8.f.g;
        if (fVar.b(fVar2)) {
            return null;
        }
        F8.f fVar3 = (F8.f) c1682b.b.d;
        kotlin.jvm.internal.k.f(c().c, "<this>");
        kotlin.jvm.internal.k.f(c().c, "<this>");
        boolean z10 = fVar3.f;
        fVar2.getClass();
        F8.f fVar4 = z10 ? fVar2 : F8.f.h;
        int i = fVar4.b;
        int i6 = fVar2.b;
        return new T8.q(fVar3, fVar2, fVar2, (i <= i6 && (i < i6 || fVar4.c <= fVar2.c)) ? fVar2 : fVar4, c1682b.a(), AbstractC1744c.a(c1682b.f5307a));
    }

    public final boolean e(C1682b c1682b) {
        c().c.getClass();
        c().c.getClass();
        A8.a aVar = c1682b.b;
        return (aVar.b & 2) != 0 && ((F8.f) aVar.d).equals(d);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T8.f f(m8.C1682b r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Could not read data from "
            A8.a r1 = r7.b
            java.lang.Object r2 = r1.e
            java.lang.String[] r2 = (java.lang.String[]) r2
            if (r2 != 0) goto Le
            java.lang.Object r2 = r1.f
            java.lang.String[] r2 = (java.lang.String[]) r2
        Le:
            r3 = 0
            if (r2 == 0) goto L1e
            java.lang.Object r4 = r1.c
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r4 = (kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind) r4
            java.util.Set r5 = z8.C2195g.b
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L1e
            goto L1f
        L1e:
            r2 = r3
        L1f:
            if (r2 != 0) goto L22
            goto L6a
        L22:
            java.lang.Object r4 = r1.d
            F8.f r4 = (F8.f) r4
            java.lang.Object r1 = r1.g
            java.lang.String[] r1 = (java.lang.String[]) r1
            if (r1 != 0) goto L2d
            goto L6a
        L2d:
            kotlin.Pair r0 = F8.i.f(r2, r1)     // Catch: java.lang.Throwable -> L32 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L34
            goto L68
        L32:
            r0 = move-exception
            goto L4b
        L34:
            r1 = move-exception
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L32
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L32
            java.lang.String r0 = r7.a()     // Catch: java.lang.Throwable -> L32
            r5.append(r0)     // Catch: java.lang.Throwable -> L32
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L32
            r2.<init>(r0, r1)     // Catch: java.lang.Throwable -> L32
            throw r2     // Catch: java.lang.Throwable -> L32
        L4b:
            T8.k r1 = r6.c()
            T8.l r1 = r1.c
            r1.getClass()
            T8.k r1 = r6.c()
            T8.l r1 = r1.c
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.k.f(r1, r2)
            F8.f r1 = F8.f.g
            boolean r1 = r4.b(r1)
            if (r1 != 0) goto L88
            r0 = r3
        L68:
            if (r0 != 0) goto L6b
        L6a:
            return r3
        L6b:
            java.lang.Object r1 = r0.f4886a
            F8.g r1 = (F8.g) r1
            java.lang.Object r0 = r0.b
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class) r0
            z8.q r2 = new z8.q
            r6.d(r7)
            r6.e(r7)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability r6 = r6.b(r7)
            r2.<init>(r7, r6)
            T8.f r6 = new T8.f
            r6.<init>(r1, r0, r4, r2)
            return r6
        L88:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.C2195g.f(m8.b):T8.f");
    }
}
