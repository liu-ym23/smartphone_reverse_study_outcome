package org.libpag;

/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f19226a;

    c(d dVar) {
        this.f19226a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f19226a.f19228b.quitSafely();
    }
}
