package kotlinx.coroutines;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class bt implements bu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cn f39170a;

    @Override // kotlinx.coroutines.bu
    public boolean n_() {
        return false;
    }

    public bt(cn r1) {
        this.f39170a = r1;
    }

    @Override // kotlinx.coroutines.bu
    public cn o_() {
        return this.f39170a;
    }

    public String toString() {
        if (aq.b() == false) goto L6;
        return o_().a("New");
    L6:
        return super.toString();
    }
}
