package bf6;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Comparable<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f18823d;

    public final String toString() {
        return "priority:" + this.f18822c + " taskClassName:" + this.f18823d.getClass().getSimpleName() + " mustRunInMainThread:" + this.f18821b;
    }

    @Override // java.lang.Comparable
    public final int compareTo(e r100) {
        e r101 = r100;
        if (r101 == null) goto L13;
        b r102 = this.f18823d;
        if (r102 == null) goto L13;
        int r103 = this.f18822c;
        int r104 = r101.f18822c;
        if (r103 <= r104) goto L10;
        return -1;
    L10:
        if (r103 >= r104) goto L17;
        return 1;
    L17:
        return r102.getClass().getSimpleName().compareTo(r101.f18823d.getClass().getSimpleName());
    L13:
        return 0;
    }

    public e(String r100, boolean r101, b r102) {
        this.f18820a = r100;
        this.f18821b = r101;
        this.f18822c = 10;
        this.f18823d = r102;
    }
}
