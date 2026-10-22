package q4;

import java.util.LinkedHashMap;
import kotlinx.serialization.json.Json;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Json f4866a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f4867b = new LinkedHashMap();

    public i(Json json) {
        this.f4866a = json;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b9, code lost:
    
        if (io.ktor.utils.io.h0.t(r1, r0, r0.length, r6) != r7) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(q4.i r12, d6.b r13, kotlinx.serialization.KSerializer r14, java.nio.charset.Charset r15, io.ktor.utils.io.d0 r16, h5.c r17) {
        /*
            Method dump skipped, instructions count: 191
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.i.a(q4.i, d6.b, kotlinx.serialization.KSerializer, java.nio.charset.Charset, io.ktor.utils.io.d0, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.nio.charset.Charset r5, w4.a r6, io.ktor.utils.io.p r7, h5.c r8) throws o4.f {
        /*
            r4 = this;
            boolean r0 = r8 instanceof q4.e
            if (r0 == 0) goto L13
            r0 = r8
            q4.e r0 = (q4.e) r0
            int r1 = r0.f4850c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4850c = r1
            goto L18
        L13:
            q4.e r0 = new q4.e
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f4848a
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f4850c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            a.a.c0(r8)     // Catch: java.lang.Throwable -> L5f
            return r8
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            a.a.c0(r8)
            java.nio.charset.Charset r8 = x5.a.f6276a
            boolean r5 = kotlin.jvm.internal.p.a(r5, r8)
            r8 = 0
            if (r5 == 0) goto L78
            v5.c r5 = r6.f6200a
            java.lang.Class<w5.i> r2 = w5.i.class
            kotlin.jvm.internal.h r2 = kotlin.jvm.internal.z.a(r2)
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L4a
            goto L78
        L4a:
            kotlinx.serialization.json.Json r4 = r4.f4866a     // Catch: java.lang.Throwable -> L5f
            r0.f4850c = r3     // Catch: java.lang.Throwable -> L5f
            h6.e r5 = a6.r0.f210a     // Catch: java.lang.Throwable -> L5f
            h6.d r5 = h6.d.f3059c     // Catch: java.lang.Throwable -> L5f
            q4.b r2 = new q4.b     // Catch: java.lang.Throwable -> L5f
            r2.<init>(r7, r6, r4, r8)     // Catch: java.lang.Throwable -> L5f
            java.lang.Object r4 = a6.i0.A(r5, r2, r0)     // Catch: java.lang.Throwable -> L5f
            if (r4 != r1) goto L5e
            return r1
        L5e:
            return r4
        L5f:
            r4 = move-exception
            o4.f r5 = new o4.f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Illegal input: "
            r6.<init>(r7)
            java.lang.String r7 = r4.getMessage()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6, r4)
            throw r5
        L78:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.i.b(java.nio.charset.Charset, w4.a, io.ktor.utils.io.p, h5.c):java.lang.Object");
    }
}
