package l0;

/* loaded from: classes.dex */
public abstract class w implements v {

    /* renamed from: f, reason: collision with root package name */
    public final j0.a f5812f = new j0.a(0);

    public final boolean c(int i2) {
        return (this.f5812f.get() & i2) != 0;
    }

    public final void d(int i2) {
        j0.a aVar;
        int i10;
        do {
            aVar = this.f5812f;
            i10 = aVar.get();
            if ((i10 & i2) != 0) {
                return;
            }
        } while (!aVar.compareAndSet(i10, i10 | i2));
    }
}
