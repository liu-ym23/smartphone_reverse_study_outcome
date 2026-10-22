package p4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.Json;
import q4.i;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Json f4755a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f4756b;

    public h(Json json) {
        this.f4755a = json;
        List list = a.f4729a;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((q4.d) it.next()).getClass();
            arrayList.add(new i(json));
        }
        this.f4756b = arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.nio.charset.Charset r14, w4.a r15, io.ktor.utils.io.p r16, h5.c r17) throws o4.f {
        /*
            r13 = this;
            r0 = r17
            boolean r1 = r0 instanceof p4.c
            if (r1 == 0) goto L16
            r1 = r0
            p4.c r1 = (p4.c) r1
            int r2 = r1.f4737f
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.f4737f = r2
        L14:
            r6 = r1
            goto L1c
        L16:
            p4.c r1 = new p4.c
            r1.<init>(r13, r0)
            goto L14
        L1c:
            java.lang.Object r0 = r6.d
            g5.a r7 = g5.a.f2984a
            int r1 = r6.f4737f
            java.util.ArrayList r8 = r13.f4756b
            r9 = 1
            kotlinx.serialization.json.Json r13 = r13.f4755a
            r10 = 0
            r11 = 2
            if (r1 == 0) goto L50
            if (r1 == r9) goto L42
            if (r1 != r11) goto L3a
            java.lang.Object r14 = r6.f4734b
            kotlinx.serialization.KSerializer r14 = (kotlinx.serialization.KSerializer) r14
            java.nio.charset.Charset r1 = r6.f4733a
            a.a.c0(r0)
            goto La3
        L3a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L42:
            io.ktor.utils.io.p r14 = r6.f4735c
            java.lang.Object r1 = r6.f4734b
            w4.a r1 = (w4.a) r1
            java.nio.charset.Charset r2 = r6.f4733a
            a.a.c0(r0)
            r4 = r14
            r14 = r2
            goto L79
        L50:
            a.a.c0(r0)
            d6.e r1 = new d6.e
            r0 = 0
            r1.<init>(r0, r8)
            o4.c r0 = new o4.c
            r5 = 1
            r2 = r14
            r3 = r15
            r4 = r16
            r0.<init>(r1, r2, r3, r4, r5)
            o4.e r1 = new o4.e
            r3 = 1
            r1.<init>(r4, r3, r10)
            r6.f4733a = r14
            r6.f4734b = r15
            r6.f4735c = r4
            r6.f4737f = r9
            java.lang.Object r0 = d6.z.e(r0, r1, r6)
            if (r0 != r7) goto L78
            goto L9e
        L78:
            r1 = r15
        L79:
            boolean r2 = r8.isEmpty()
            if (r2 != 0) goto L88
            if (r0 != 0) goto L87
            boolean r2 = r4.e()
            if (r2 == 0) goto L88
        L87:
            return r0
        L88:
            kotlinx.serialization.modules.SerializersModule r0 = r13.getSerializersModule()
            kotlinx.serialization.KSerializer r0 = k4.v.j0(r0, r1)
            r6.f4733a = r14
            r6.f4734b = r0
            r6.f4735c = r10
            r6.f4737f = r11
            java.lang.Object r1 = io.ktor.utils.io.h0.m(r4, r6)
            if (r1 != r7) goto L9f
        L9e:
            return r7
        L9f:
            r12 = r1
            r1 = r14
            r14 = r0
            r0 = r12
        La3:
            j6.j r0 = (j6.j) r0
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r0 = x.e.g0(r0, r1)     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r13 = r13.decodeFromString(r14, r0)     // Catch: java.lang.Throwable -> Lb0
            return r13
        Lb0:
            r0 = move-exception
            r13 = r0
            o4.f r14 = new o4.f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Illegal input: "
            r0.<init>(r1)
            java.lang.String r1 = r13.getMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0, r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.h.a(java.nio.charset.Charset, w4.a, io.ktor.utils.io.p, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(k4.g r13, java.nio.charset.Charset r14, w4.a r15, java.lang.Object r16, h5.c r17) {
        /*
            r12 = this;
            r0 = r17
            kotlinx.serialization.json.Json r1 = r12.f4755a
            boolean r2 = r0 instanceof p4.g
            if (r2 == 0) goto L17
            r2 = r0
            p4.g r2 = (p4.g) r2
            int r3 = r2.f4754g
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.f4754g = r3
            goto L1c
        L17:
            p4.g r2 = new p4.g
            r2.<init>(r12, r0)
        L1c:
            java.lang.Object r0 = r2.f4752e
            g5.a r3 = g5.a.f2984a
            int r4 = r2.f4754g
            r5 = 1
            if (r4 == 0) goto L3d
            if (r4 != r5) goto L35
            java.lang.Object r12 = r2.d
            w4.a r13 = r2.f4751c
            java.nio.charset.Charset r14 = r2.f4750b
            k4.g r2 = r2.f4749a
            a.a.c0(r0)
            r10 = r13
            r13 = r2
            goto L6d
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3d:
            a.a.c0(r0)
            d6.e r7 = new d6.e
            r0 = 0
            java.util.ArrayList r12 = r12.f4756b
            r7.<init>(r0, r12)
            p4.f r6 = new p4.f
            r8 = r13
            r9 = r14
            r10 = r15
            r11 = r16
            r6.<init>(r7, r8, r9, r10, r11)
            j0.m r12 = new j0.m
            r0 = 2
            r4 = 1
            r7 = 0
            r12.<init>(r0, r7, r4)
            r2.f4749a = r13
            r2.f4750b = r14
            r2.f4751c = r15
            r2.d = r11
            r2.f4754g = r5
            java.lang.Object r0 = d6.z.e(r6, r12, r2)
            if (r0 != r3) goto L6b
            return r3
        L6b:
            r10 = r15
            r12 = r11
        L6d:
            n4.e r0 = (n4.e) r0
            if (r0 == 0) goto L72
            return r0
        L72:
            kotlinx.serialization.modules.SerializersModule r0 = r1.getSerializersModule()     // Catch: kotlinx.serialization.SerializationException -> L7b
            kotlinx.serialization.KSerializer r0 = k4.v.j0(r0, r10)     // Catch: kotlinx.serialization.SerializationException -> L7b
            goto L83
        L7b:
            kotlinx.serialization.modules.SerializersModule r0 = r1.getSerializersModule()
            kotlinx.serialization.KSerializer r0 = k4.v.S(r12, r0)
        L83:
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>"
            kotlin.jvm.internal.p.c(r0, r2)
            kotlinx.serialization.SerializationStrategy r0 = (kotlinx.serialization.SerializationStrategy) r0
            java.lang.String r12 = r1.encodeToString(r0, r12)
            n4.j r0 = new n4.j
            k4.g r13 = a.a.g0(r13, r14)
            r0.<init>(r12, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.h.b(k4.g, java.nio.charset.Charset, w4.a, java.lang.Object, h5.c):java.lang.Object");
    }
}
