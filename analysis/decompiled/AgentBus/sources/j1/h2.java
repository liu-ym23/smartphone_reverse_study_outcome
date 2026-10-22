package j1;

import android.content.Context;
import android.view.View;
import java.util.List;
import o4.t2;

/* loaded from: classes.dex */
public final class h2 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5190f;

    /* renamed from: g, reason: collision with root package name */
    public Object f5191g;

    /* renamed from: h, reason: collision with root package name */
    public int f5192h;

    /* renamed from: i, reason: collision with root package name */
    public Object f5193i;

    /* renamed from: j, reason: collision with root package name */
    public Object f5194j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f5195k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f5196l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5197m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h2(Object obj, Object obj2, Object obj3, g7.d dVar, int i2) {
        super(2, dVar);
        this.f5190f = i2;
        this.f5195k = obj;
        this.f5196l = obj2;
        this.f5197m = obj3;
    }

    /* JADX WARN: Type inference failed for: r10v3, types: [i7.i, p7.k] */
    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f5190f) {
            case 0:
                h2 h2Var = new h2((q7.v) this.f5193i, (b0.j2) this.f5194j, (androidx.lifecycle.v) this.f5195k, (i2) this.f5196l, (View) this.f5197m, dVar, 0);
                h2Var.f5191g = obj;
                return h2Var;
            case 1:
                h2 h2Var2 = new h2((n.i0) this.f5196l, (i7.i) this.f5197m, dVar);
                h2Var2.f5195k = obj;
                return h2Var2;
            case 2:
                return new h2((ra.j) this.f5195k, (t2) this.f5196l, (o4.g) this.f5197m, dVar, 2);
            case 3:
                h2 h2Var3 = new h2((c6.l) this.f5193i, (d5.m) this.f5194j, (v4.p) this.f5195k, (d5.d0) this.f5196l, (String) this.f5197m, dVar, 3);
                h2Var3.f5191g = obj;
                return h2Var3;
            default:
                h2 h2Var4 = new h2((Context) this.f5195k, (v4.k) this.f5196l, (List) this.f5197m, dVar, 4);
                h2Var4.f5191g = obj;
                return h2Var4;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f5190f) {
        }
        return ((h2) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x017a  */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v7, types: [p7.k] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0092 -> B:17:0x0094). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 840
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.h2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h2(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, g7.d dVar, int i2) {
        super(2, dVar);
        this.f5190f = i2;
        this.f5193i = obj;
        this.f5194j = obj2;
        this.f5195k = obj3;
        this.f5196l = obj4;
        this.f5197m = obj5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h2(n.i0 i0Var, p7.k kVar, g7.d dVar) {
        super(2, dVar);
        this.f5190f = 1;
        this.f5196l = i0Var;
        this.f5197m = (i7.i) kVar;
    }
}
