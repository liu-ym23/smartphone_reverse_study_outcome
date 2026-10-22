package androidx.recyclerview.widget;

/* JADX INFO: compiled from: AdapterListUpdateCallback.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RecyclerView.a f2451a;

    public b(RecyclerView.a r1) {
        this.f2451a = r1;
    }

    @Override // androidx.recyclerview.widget.r
    public void a(int r1, int r2) {
        this.f2451a.c(r1, r2);
    }

    @Override // androidx.recyclerview.widget.r
    public void b(int r1, int r2) {
        this.f2451a.d(r1, r2);
    }

    @Override // androidx.recyclerview.widget.r
    public void c(int r1, int r2) {
        this.f2451a.b(r1, r2);
    }

    @Override // androidx.recyclerview.widget.r
    public void a(int r1, int r2, Object r3) {
        this.f2451a.a(r1, r2, r3);
    }
}
