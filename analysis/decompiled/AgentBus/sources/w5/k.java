package w5;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class k extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f10726f;

    /* renamed from: g, reason: collision with root package name */
    public Iterator f10727g;

    /* renamed from: h, reason: collision with root package name */
    public List f10728h;

    /* renamed from: i, reason: collision with root package name */
    public int f10729i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f10730j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ List f10731k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(List list, g7.d dVar, int i2) {
        super(2, dVar);
        this.f10726f = i2;
        this.f10731k = list;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f10726f) {
            case 0:
                k kVar = new k(this.f10731k, dVar, 0);
                kVar.f10730j = obj;
                return kVar;
            case 1:
                k kVar2 = new k(this.f10731k, dVar, 1);
                kVar2.f10730j = obj;
                return kVar2;
            default:
                k kVar3 = new k(this.f10731k, dVar, 2);
                kVar3.f10730j = obj;
                return kVar3;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f10726f) {
        }
        return ((k) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f1 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0167 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0077 -> B:17:0x0078). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ec -> B:32:0x00ed). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0162 -> B:47:0x0163). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.k.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
