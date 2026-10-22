package b86;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements d<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18186b;

    @Override // b86.d
    public final int getItemsCount() {
        return (this.f18186b - this.f18185a) + 1;
    }

    @Override // b86.d
    public final Integer getItem(int r100) {
        if (r100 < 0) goto L7;
        if (r100 >= getItemsCount()) goto L7;
        return Integer.valueOf((this.f18185a + r100) % 24);
    L7:
        return 0;
    }

    public c(int r100, int r101) {
        this.f18185a = r100;
        if (r101 <= r100) goto L5;
        this.f18186b = r101;
        return;
    L5:
        this.f18186b = r101 + 24;
    }
}
