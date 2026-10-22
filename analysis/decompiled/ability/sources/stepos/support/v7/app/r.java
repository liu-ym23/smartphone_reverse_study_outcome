package stepos.support.v7.app;

import androidx.appcompat.app.AppCompatDelegate;

/* loaded from: classes4.dex */
public final class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC1975y f6337a;

    public r(AbstractC1975y abstractC1975y) {
        this.f6337a = abstractC1975y;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC1975y abstractC1975y = this.f6337a;
        if ((abstractC1975y.f6354N & 1) != 0) {
            AbstractC1975y.o(abstractC1975y, 0);
        }
        if ((abstractC1975y.f6354N & 4096) != 0) {
            AbstractC1975y.o(abstractC1975y, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
        }
        abstractC1975y.f6353M = false;
        abstractC1975y.f6354N = 0;
    }
}
