package com.obric.oui.orecyclerview.widget;

/* JADX INFO: compiled from: AdapterListUpdateCallback.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RecyclerView.a f35705a;

    public b(RecyclerView.a r1) {
        this.f35705a = r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.q
    public void a(int r1, int r2) {
        this.f35705a.c(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.q
    public void b(int r1, int r2) {
        this.f35705a.d(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.q
    public void c(int r1, int r2) {
        this.f35705a.b(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.q
    public void a(int r1, int r2, Object r3) {
        this.f35705a.a(r1, r2, r3);
    }
}
