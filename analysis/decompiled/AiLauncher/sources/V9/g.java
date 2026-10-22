package V9;

import C9.o;
import F9.g;
import Z8.F;
import Z9.InterfaceC1178a;
import java.util.Iterator;
import kotlin.sequences.SequencesKt___SequencesKt;
import xa.InterfaceC5864g;

/* loaded from: classes5.dex */
public final class g implements F9.g {

    /* renamed from: a, reason: collision with root package name */
    public final k f6532a;

    /* renamed from: b, reason: collision with root package name */
    public final Z9.d f6533b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6534c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5864g<InterfaceC1178a, F9.c> f6535d;

    public g(k c10, Z9.d annotationOwner, boolean z10) {
        kotlin.jvm.internal.p.i(c10, "c");
        kotlin.jvm.internal.p.i(annotationOwner, "annotationOwner");
        this.f6532a = c10;
        this.f6533b = annotationOwner;
        this.f6534c = z10;
        this.f6535d = c10.a().u().f(new f(this));
    }

    public static final F9.c c(g gVar, InterfaceC1178a annotation) {
        kotlin.jvm.internal.p.i(annotation, "annotation");
        return T9.d.f5891a.e(annotation, gVar.f6532a, gVar.f6534c);
    }

    @Override // F9.g
    public /* bridge */ boolean E(ga.c cVar) {
        return g.b.b(this, cVar);
    }

    @Override // F9.g
    public F9.c d(ga.c fqName) {
        F9.c cVarInvoke;
        kotlin.jvm.internal.p.i(fqName, "fqName");
        InterfaceC1178a interfaceC1178aD = this.f6533b.d(fqName);
        return (interfaceC1178aD == null || (cVarInvoke = this.f6535d.invoke(interfaceC1178aD)) == null) ? T9.d.f5891a.a(fqName, this.f6533b, this.f6532a) : cVarInvoke;
    }

    @Override // F9.g
    public boolean isEmpty() {
        return this.f6533b.getAnnotations().isEmpty() && !this.f6533b.A();
    }

    @Override // java.lang.Iterable
    public Iterator<F9.c> iterator() {
        return SequencesKt___SequencesKt.H(SequencesKt___SequencesKt.X(SequencesKt___SequencesKt.R(F.d0(this.f6533b.getAnnotations()), this.f6535d), T9.d.f5891a.a(o.a.f1942y, this.f6533b, this.f6532a))).iterator();
    }

    public /* synthetic */ g(k kVar, Z9.d dVar, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(kVar, dVar, (i10 & 4) != 0 ? false : z10);
    }
}
