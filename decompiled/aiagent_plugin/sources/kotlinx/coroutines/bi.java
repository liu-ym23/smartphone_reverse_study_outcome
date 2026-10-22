package kotlinx.coroutines;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
final class bi implements bu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f39151a;

    @Override // kotlinx.coroutines.bu
    public cn o_() {
        return null;
    }

    public bi(boolean r1) {
        this.f39151a = r1;
    }

    @Override // kotlinx.coroutines.bu
    public boolean n_() {
        return this.f39151a;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("Empty{");
        if (n_() == false) goto L5;
        String r2 = "Active";
    L7:
        return r0.append(r2).append('}').toString();
    L5:
        r2 = "New";
        goto L7
    }
}
