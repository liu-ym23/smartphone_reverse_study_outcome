package s8;

import f8.o0;
import java.util.List;

/* loaded from: classes.dex */
public final class h extends v9.b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9556c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final u9.i f9557d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i8.b f9558e;

    /* JADX WARN: Illegal instructions before constructor call */
    public h(j jVar) {
        this.f9558e = jVar;
        a3.b bVar = jVar.f9562o;
        super(((r8.a) bVar.f162f).f9002a);
        u9.n nVar = ((r8.a) bVar.f162f).f9002a;
        g gVar = new g(jVar, 0);
        u9.k kVar = (u9.k) nVar;
        kVar.getClass();
        this.f9557d = new u9.i(kVar, gVar);
    }

    @Override // v9.m0
    public final boolean a() {
        switch (this.f9556c) {
        }
        return true;
    }

    @Override // v9.b, v9.m0
    public final f8.g c() {
        switch (this.f9556c) {
            case 0:
                return (j) this.f9558e;
            default:
                return (t9.i) this.f9558e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01fe  */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.Collection] */
    @Override // v9.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Collection e() {
        /*
            Method dump skipped, instructions count: 944
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.h.e():java.util.Collection");
    }

    @Override // v9.f
    public final o0 g() {
        switch (this.f9556c) {
            case 0:
                return ((r8.a) ((j) this.f9558e).f9562o.f162f).f9014m;
            default:
                return o0.f3504h;
        }
    }

    @Override // v9.m0
    public final List getParameters() {
        switch (this.f9556c) {
        }
        return (List) this.f9557d.c();
    }

    @Override // v9.b
    /* renamed from: l */
    public final f8.e c() {
        switch (this.f9556c) {
            case 0:
                return (j) this.f9558e;
            default:
                return (t9.i) this.f9558e;
        }
    }

    public final String toString() {
        switch (this.f9556c) {
            case 0:
                String strB = ((j) this.f9558e).getName().b();
                q7.k.d(strB, "name.asString()");
                return strB;
            default:
                String str = ((t9.i) this.f9558e).getName().f3197f;
                q7.k.d(str, "name.toString()");
                return str;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public h(t9.i iVar) {
        this.f9558e = iVar;
        r9.k kVar = iVar.f9809q;
        super(((r9.i) kVar.f9070f).f9047a);
        u9.k kVar2 = ((r9.i) kVar.f9070f).f9047a;
        t9.g gVar = new t9.g(iVar, 0);
        kVar2.getClass();
        this.f9557d = new u9.i(kVar2, gVar);
    }
}
