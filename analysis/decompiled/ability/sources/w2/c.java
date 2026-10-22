package w2;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6832a;
    public final /* synthetic */ f b;

    public /* synthetic */ c(f fVar, int i) {
        this.f6832a = i;
        this.b = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f6832a;
        f fVar = this.b;
        switch (i) {
            case 0:
                fVar.i();
                break;
            default:
                fVar.h();
                break;
        }
    }
}
