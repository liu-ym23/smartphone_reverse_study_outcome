package kotlinx.coroutines;

/* JADX INFO: loaded from: classes4.dex */
public final class p0 implements Incomplete {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21656a;

    public p0(boolean r10) {
        this.f21656a = r10;
    }

    @Override // kotlinx.coroutines.Incomplete
    public p1 getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return this.f21656a;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Empty{");
        if (isActive() == false) goto L5;
        String r11 = "Active";
    L6:
        r10.append(r11);
        r10.append('}');
        return r10.toString();
    L5:
        r11 = "New";
        goto L6
    }
}
