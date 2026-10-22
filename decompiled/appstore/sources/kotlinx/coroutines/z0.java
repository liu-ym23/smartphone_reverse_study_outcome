package kotlinx.coroutines;

/* JADX INFO: loaded from: classes4.dex */
public final class z0 implements Incomplete {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p1 f21773a;

    public z0(p1 r10) {
        this.f21773a = r10;
    }

    @Override // kotlinx.coroutines.Incomplete
    public p1 getList() {
        return this.f21773a;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return false;
    }

    public String toString() {
        return super.toString();
    }
}
