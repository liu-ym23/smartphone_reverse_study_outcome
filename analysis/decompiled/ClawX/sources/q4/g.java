package q4;

import io.ktor.utils.io.d0;
import java.nio.charset.Charset;
import kotlinx.serialization.KSerializer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g implements d6.c {

    /* renamed from: a, reason: collision with root package name */
    public int f4854a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0 f4855b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f4856c;
    public final /* synthetic */ i d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ KSerializer f4857e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Charset f4858f;

    public g(d0 d0Var, a aVar, i iVar, KSerializer kSerializer, Charset charset) {
        this.f4855b = d0Var;
        this.f4856c = aVar;
        this.d = iVar;
        this.f4857e = kSerializer;
        this.f4858f = charset;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
    
        if (((io.ktor.utils.io.m) r3).g(r0) != r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // d6.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r8, f5.c r9) throws java.nio.charset.CharacterCodingException {
        /*
            r7 = this;
            boolean r0 = r9 instanceof q4.f
            if (r0 == 0) goto L13
            r0 = r9
            q4.f r0 = (q4.f) r0
            int r1 = r0.f4852b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4852b = r1
            goto L18
        L13:
            q4.f r0 = new q4.f
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f4851a
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f4852b
            io.ktor.utils.io.d0 r3 = r7.f4855b
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L41
            if (r2 == r6) goto L3b
            if (r2 == r5) goto L37
            if (r2 != r4) goto L2f
            a.a.c0(r9)
            goto L88
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            a.a.c0(r9)
            goto L7d
        L3b:
            java.lang.Object r8 = r0.d
            a.a.c0(r9)
            goto L5e
        L41:
            a.a.c0(r9)
            int r9 = r7.f4854a
            int r2 = r9 + 1
            r7.f4854a = r2
            if (r9 < 0) goto L8b
            if (r9 <= 0) goto L5e
            q4.a r9 = r7.f4856c
            byte[] r9 = r9.f4844c
            r0.d = r8
            r0.f4852b = r6
            int r2 = r9.length
            java.lang.Object r9 = io.ktor.utils.io.h0.t(r3, r9, r2, r0)
            if (r9 != r1) goto L5e
            goto L87
        L5e:
            q4.i r9 = r7.d
            kotlinx.serialization.json.Json r9 = r9.f4866a
            kotlinx.serialization.KSerializer r2 = r7.f4857e
            kotlinx.serialization.SerializationStrategy r2 = (kotlinx.serialization.SerializationStrategy) r2
            java.lang.String r8 = r9.encodeToString(r2, r8)
            java.nio.charset.Charset r7 = r7.f4858f
            byte[] r7 = x.e.x0(r8, r7)
            r8 = 0
            r0.d = r8
            r0.f4852b = r5
            int r8 = r7.length
            java.lang.Object r7 = io.ktor.utils.io.h0.t(r3, r7, r8, r0)
            if (r7 != r1) goto L7d
            goto L87
        L7d:
            r0.f4852b = r4
            io.ktor.utils.io.m r3 = (io.ktor.utils.io.m) r3
            java.lang.Object r7 = r3.g(r0)
            if (r7 != r1) goto L88
        L87:
            return r1
        L88:
            b5.a0 r7 = b5.a0.f883a
            return r7
        L8b:
            java.lang.ArithmeticException r7 = new java.lang.ArithmeticException
            java.lang.String r8 = "Index overflow has happened"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.g.emit(java.lang.Object, f5.c):java.lang.Object");
    }
}
