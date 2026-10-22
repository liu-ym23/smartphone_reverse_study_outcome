package j1;

/* loaded from: classes.dex */
public final /* synthetic */ class p implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5294f;

    public /* synthetic */ p(int i2) {
        this.f5294f = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5294f) {
            case 0:
                k.z zVar = y.L0;
                synchronized (zVar) {
                    Object[] objArr = zVar.f5556a;
                    int i2 = zVar.f5557b;
                    for (int i10 = 0; i10 < i2; i10++) {
                        y.k(((y) objArr[i10]).getRoot());
                    }
                }
                return;
            case 1:
                u5.g.a();
                return;
            default:
                u5.g.a();
                return;
        }
    }
}
