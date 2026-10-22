package m8;

import android.content.res.Resources;
import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8336c = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f8337f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f8338g;

    /* renamed from: h, reason: collision with root package name */
    public Object f8339h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Serializable f8340j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f8341k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f8342l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(String str, boolean z10, String str2, k0 k0Var, Resources resources, nb.c cVar) {
        super(2, cVar);
        this.i = str;
        this.f8338g = z10;
        this.f8340j = str2;
        this.f8341k = k0Var;
        this.f8342l = resources;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f8336c) {
            case 0:
                return new e0((String) this.i, this.f8338g, (String) this.f8340j, (k0) this.f8341k, (Resources) this.f8342l, cVar);
            default:
                e0 e0Var = new e0((yb.s) this.f8340j, (v3.z) this.f8341k, this.f8342l, this.f8338g, cVar);
                e0Var.i = obj;
                return e0Var;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f8336c) {
            case 0:
                return ((e0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            default:
                return ((e0) create((v3.i0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006d, code lost:
    
        if (r2.b(r0, r48) == r8) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01aa, code lost:
    
        if (m8.k0.f(r0, r48) == r9) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01f6, code lost:
    
        if (m8.k0.e(r1, r0, r2, r3, r4, r48) != r9) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02bc, code lost:
    
        if (m8.k0.f(r0, r48) != r9) goto L63;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v52, types: [xb.l] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v23, types: [xb.l] */
    /* JADX WARN: Type inference failed for: r1v3, types: [xb.l] */
    /* JADX WARN: Type inference failed for: r1v8, types: [xb.l] */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r49) {
        /*
            Method dump skipped, instructions count: 718
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.e0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(yb.s sVar, v3.z zVar, Object obj, boolean z10, nb.c cVar) {
        super(2, cVar);
        this.f8340j = sVar;
        this.f8341k = zVar;
        this.f8342l = obj;
        this.f8338g = z10;
    }
}
