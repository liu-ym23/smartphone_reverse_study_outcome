package org.libpag;

/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PAGImageView f19233a;

    i(PAGImageView pAGImageView) {
        this.f19233a = pAGImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        PAGImageView pAGImageView = this.f19233a;
        pAGImageView.f19182z = pAGImageView.f19160d.getCurrentPlayTime();
        this.f19233a.f19160d.cancel();
    }
}
