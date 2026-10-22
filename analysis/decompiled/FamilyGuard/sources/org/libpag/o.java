package org.libpag;

/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PAGView f19253a;

    o(PAGView pAGView) {
        this.f19253a = pAGView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zIsOpaque = this.f19253a.isOpaque();
        this.f19253a.setOpaque(!zIsOpaque);
        this.f19253a.setOpaque(zIsOpaque);
    }
}
