package i5;

import ia.b0;
import java.io.Serializable;
import p.w0;
import p.y0;

/* loaded from: classes.dex */
public final class s extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4708f = 0;

    /* renamed from: g, reason: collision with root package name */
    public long f4709g;

    /* renamed from: h, reason: collision with root package name */
    public int f4710h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f4711i;

    /* renamed from: j, reason: collision with root package name */
    public Object f4712j;

    /* renamed from: k, reason: collision with root package name */
    public Serializable f4713k;

    /* renamed from: l, reason: collision with root package name */
    public Object f4714l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f4715m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f4716n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(u uVar, c5.b bVar, String str, long j2, g7.d dVar) {
        super(2, dVar);
        this.f4715m = uVar;
        this.f4716n = bVar;
        this.f4713k = str;
        this.f4711i = j2;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f4708f) {
            case 0:
                return new s((u) this.f4715m, (c5.b) this.f4716n, (String) this.f4713k, this.f4711i, dVar);
            default:
                s sVar = new s((y0) this.f4715m, (q7.u) this.f4716n, this.f4711i, dVar);
                sVar.f4714l = obj;
                return sVar;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f4708f) {
            case 0:
                return ((s) create((b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            default:
                return ((s) create((w0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x01a9 -> B:51:0x01ad). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0260 -> B:67:0x0263). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.s.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(y0 y0Var, q7.u uVar, long j2, g7.d dVar) {
        super(2, dVar);
        this.f4715m = y0Var;
        this.f4716n = uVar;
        this.f4711i = j2;
    }
}
