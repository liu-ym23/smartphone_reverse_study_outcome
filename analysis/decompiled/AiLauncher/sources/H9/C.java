package H9;

import java.util.List;
import java.util.Set;

/* loaded from: classes5.dex */
public final class C implements B {

    /* renamed from: a, reason: collision with root package name */
    public final List<F> f2994a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<F> f2995b;

    /* renamed from: c, reason: collision with root package name */
    public final List<F> f2996c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<F> f2997d;

    public C(List<F> allDependencies, Set<F> modulesWhoseInternalsAreVisible, List<F> directExpectedByDependencies, Set<F> allExpectedByDependencies) {
        kotlin.jvm.internal.p.i(allDependencies, "allDependencies");
        kotlin.jvm.internal.p.i(modulesWhoseInternalsAreVisible, "modulesWhoseInternalsAreVisible");
        kotlin.jvm.internal.p.i(directExpectedByDependencies, "directExpectedByDependencies");
        kotlin.jvm.internal.p.i(allExpectedByDependencies, "allExpectedByDependencies");
        this.f2994a = allDependencies;
        this.f2995b = modulesWhoseInternalsAreVisible;
        this.f2996c = directExpectedByDependencies;
        this.f2997d = allExpectedByDependencies;
    }

    @Override // H9.B
    public List<F> a() {
        return this.f2994a;
    }

    @Override // H9.B
    public List<F> b() {
        return this.f2996c;
    }

    @Override // H9.B
    public Set<F> c() {
        return this.f2995b;
    }
}
