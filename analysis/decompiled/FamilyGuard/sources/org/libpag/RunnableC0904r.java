package org.libpag;

/* renamed from: org.libpag.r, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0904r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PAGView f19256a;

    RunnableC0904r(PAGView pAGView) {
        this.f19256a = pAGView;
    }

    @Override // java.lang.Runnable
    public void run() {
        PAGView pAGView = this.f19256a;
        pAGView.f19214w = pAGView.f19200i.getCurrentPlayTime();
        this.f19256a.f19200i.cancel();
    }
}
