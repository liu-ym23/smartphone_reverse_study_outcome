package m9;

/* renamed from: m9.N, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1696N extends AbstractRunnableC1698P {
    public final C1718k c;
    public final /* synthetic */ AbstractC1700S d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1696N(AbstractC1700S abstractC1700S, long j5, C1718k c1718k) {
        super(j5);
        this.d = abstractC1700S;
        this.c = c1718k;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.G(this.d);
    }

    @Override // m9.AbstractRunnableC1698P
    public final String toString() {
        return super.toString() + this.c;
    }
}
