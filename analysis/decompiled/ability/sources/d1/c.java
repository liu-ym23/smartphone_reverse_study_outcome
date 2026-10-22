package d1;

import s1.AbstractRunnableC1911a;

/* loaded from: classes2.dex */
public final class c extends AbstractRunnableC1911a {
    public final /* synthetic */ c1.b d;
    public final /* synthetic */ d e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, long j5, c1.b bVar) {
        super(j5, 0L);
        this.e = dVar;
        this.d = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.I0("cool down task run, is back?: " + this.e.c);
        c1.b bVar = this.d;
        synchronized (bVar) {
            bVar.a(bVar.l);
        }
    }
}
