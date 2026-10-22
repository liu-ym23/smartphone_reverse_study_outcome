package m9;

import s9.AbstractC1921a;

/* renamed from: m9.T, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1701T extends AbstractC1729v {
    public static final /* synthetic */ int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public long f5319a;
    public boolean b;
    public D7.p c;

    public final void E(boolean z10) {
        long j5 = this.f5319a - (z10 ? 4294967296L : 1L);
        this.f5319a = j5;
        if (j5 <= 0 && this.b) {
            shutdown();
        }
    }

    public final void F(AbstractC1689G abstractC1689G) {
        D7.p pVar = this.c;
        if (pVar == null) {
            pVar = new D7.p();
            this.c = pVar;
        }
        pVar.addLast(abstractC1689G);
    }

    public abstract Thread G();

    public final void H(boolean z10) {
        this.f5319a = (z10 ? 4294967296L : 1L) + this.f5319a;
        if (z10) {
            return;
        }
        this.b = true;
    }

    public abstract long I();

    public final boolean J() {
        D7.p pVar = this.c;
        if (pVar == null) {
            return false;
        }
        AbstractC1689G abstractC1689G = (AbstractC1689G) (pVar.isEmpty() ? null : pVar.removeFirst());
        if (abstractC1689G == null) {
            return false;
        }
        abstractC1689G.run();
        return true;
    }

    public void K(long j5, AbstractRunnableC1698P abstractRunnableC1698P) {
        RunnableC1684B.h.P(j5, abstractRunnableC1698P);
    }

    @Override // m9.AbstractC1729v
    public final AbstractC1729v limitedParallelism(int i, String str) {
        AbstractC1921a.a(i);
        return str != null ? new s9.l(this, str) : this;
    }

    public abstract void shutdown();
}
