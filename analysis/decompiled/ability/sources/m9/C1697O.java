package m9;

/* renamed from: m9.O, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1697O extends AbstractRunnableC1698P {
    public final Runnable c;

    public C1697O(Runnable runnable, long j5) {
        super(j5);
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.run();
    }

    @Override // m9.AbstractRunnableC1698P
    public final String toString() {
        return super.toString() + this.c;
    }
}
