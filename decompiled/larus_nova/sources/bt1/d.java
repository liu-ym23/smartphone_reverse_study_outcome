package bt1;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements ct1.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f20524a;

    @Override // ct1.f
    public final void onFinish() {
        this.f20524a.e();
    }

    public d(b r100) {
        this.f20524a = r100;
    }

    @Override // ct1.f
    public final void onTick(long r100) {
        a r101 = this.f20524a.f20506j;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
