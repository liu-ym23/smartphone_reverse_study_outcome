package b86;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements d<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18184b;

    @Override // b86.d
    public final int getItemsCount() {
        return (this.f18184b - this.f18183a) + 1;
    }

    @Override // b86.d
    public final Integer getItem(int r100) {
        if (r100 < 0) goto L7;
        if (r100 >= getItemsCount()) goto L7;
        return Integer.valueOf(this.f18183a + r100);
    L7:
        return 0;
    }

    public b(int r100, int r101) {
        this.f18183a = r100;
        this.f18184b = r101;
    }
}
