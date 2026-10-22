package n3;

import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m0 extends pb.h implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f8733f;

    /* renamed from: g, reason: collision with root package name */
    public int f8734g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f8735h;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m0(Object obj, nb.c cVar, int i) {
        super(cVar);
        this.f8733f = i;
        this.i = obj;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f8733f) {
            case 0:
                m0 m0Var = new m0((View) this.i, cVar, 0);
                m0Var.f8735h = obj;
                return m0Var;
            default:
                m0 m0Var2 = new m0((t.f) this.i, cVar, 1);
                m0Var2.f8735h = obj;
                return m0Var2;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f8733f) {
            case 0:
                return ((m0) create((gc.l) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            default:
                return ((m0) create((o1.h0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
    
        if (r14 == r7) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
    
        if (r14 != r7) goto L18;
     */
    /* JADX WARN: Type inference failed for: r14v14, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0066 -> B:18:0x006b). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.m0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
