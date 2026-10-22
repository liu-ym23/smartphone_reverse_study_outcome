package l4;

import a6.r;
import b5.a0;
import io.ktor.utils.io.n0;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i extends h5.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public n0 f3816a;

    /* renamed from: b, reason: collision with root package name */
    public io.ktor.utils.io.m f3817b;

    /* renamed from: c, reason: collision with root package name */
    public r f3818c;
    public d d;

    /* renamed from: e, reason: collision with root package name */
    public long f3819e;

    /* renamed from: f, reason: collision with root package name */
    public int f3820f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f3821g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ io.ktor.utils.io.p f3822h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k6.a f3823j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Long f3824k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(io.ktor.utils.io.p pVar, k6.a aVar, Long l3, f5.c cVar) {
        super(2, cVar);
        this.f3822h = pVar;
        this.f3823j = aVar;
        this.f3824k = l3;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        i iVar = new i(this.f3822h, this.f3823j, this.f3824k, cVar);
        iVar.f3821g = obj;
        return iVar;
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        return ((i) create((c6.p) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x02b0, code lost:
    
        if (((c6.o) r0).d.d(r19, r2) != r7) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02e5, code lost:
    
        if (((c6.o) r0).d.d(r19, r1) == r7) goto L121;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:39:0x0132, B:42:0x014d], limit reached: 126 */
    /* JADX WARN: Path cross not found for [B:42:0x014d, B:39:0x0132], limit reached: 126 */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003e A[PHI: r0 r2 r3
      0x003e: PHI (r0v17 long) = (r0v15 long), (r0v20 long) binds: [B:98:0x0268, B:9:0x0033] A[DONT_GENERATE, DONT_INLINE]
      0x003e: PHI (r2v6 io.ktor.utils.io.n0) = (r2v4 io.ktor.utils.io.n0), (r2v8 io.ktor.utils.io.n0) binds: [B:98:0x0268, B:9:0x0033] A[DONT_GENERATE, DONT_INLINE]
      0x003e: PHI (r3v31 c6.p) = (r3v28 c6.p), (r3v34 c6.p) binds: [B:98:0x0268, B:9:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0203 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0081 A[PHI: r1 r3 r4 r5 r12 r13
      0x0081: PHI (r1v13 long) = (r1v10 long), (r1v17 long) binds: [B:19:0x007f, B:57:0x01c4] A[DONT_GENERATE, DONT_INLINE]
      0x0081: PHI (r3v13 io.ktor.utils.io.n0) = (r3v10 io.ktor.utils.io.n0), (r3v21 io.ktor.utils.io.n0) binds: [B:19:0x007f, B:57:0x01c4] A[DONT_GENERATE, DONT_INLINE]
      0x0081: PHI (r4v18 a6.r) = (r4v12 a6.r), (r4v26 a6.r) binds: [B:19:0x007f, B:57:0x01c4] A[DONT_GENERATE, DONT_INLINE]
      0x0081: PHI (r5v21 io.ktor.utils.io.m) = (r5v16 io.ktor.utils.io.m), (r5v25 io.ktor.utils.io.m) binds: [B:19:0x007f, B:57:0x01c4] A[DONT_GENERATE, DONT_INLINE]
      0x0081: PHI (r12v15 c6.p) = (r12v13 c6.p), (r12v17 c6.p) binds: [B:19:0x007f, B:57:0x01c4] A[DONT_GENERATE, DONT_INLINE]
      0x0081: PHI (r13v3 java.lang.Object) = (r13v2 java.lang.Object), (r13v7 java.lang.Object) binds: [B:19:0x007f, B:57:0x01c4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d3 A[Catch: all -> 0x0218, TRY_LEAVE, TryCatch #3 {all -> 0x0218, blocks: (B:60:0x01ca, B:62:0x01d3), top: B:130:0x01ca }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0207 A[Catch: all -> 0x0210, TRY_LEAVE, TryCatch #0 {all -> 0x0210, blocks: (B:68:0x01f6, B:69:0x01fd, B:71:0x0203, B:72:0x0207), top: B:124:0x01f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x023b A[PHI: r1 r3 r4
      0x023b: PHI (r1v11 long) = (r1v19 long), (r1v20 long) binds: [B:48:0x0171, B:43:0x0151] A[DONT_GENERATE, DONT_INLINE]
      0x023b: PHI (r3v11 io.ktor.utils.io.n0) = (r3v23 io.ktor.utils.io.n0), (r3v24 io.ktor.utils.io.n0) binds: [B:48:0x0171, B:43:0x0151] A[DONT_GENERATE, DONT_INLINE]
      0x023b: PHI (r4v13 c6.p) = (r4v30 c6.p), (r4v31 c6.p) binds: [B:48:0x0171, B:43:0x0151] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r11v0, types: [f5.c] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x01f2 -> B:124:0x01f6). Please report as a decompilation issue!!! */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 780
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.i.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
