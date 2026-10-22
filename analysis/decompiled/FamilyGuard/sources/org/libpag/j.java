package org.libpag;

/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PAGImageView f19234a;

    j(PAGImageView pAGImageView) {
        this.f19234a = pAGImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f19234a.f19175s != null) {
            this.f19234a.f19175s.a();
        }
    }
}
