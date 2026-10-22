package org.libpag;

import android.util.Log;

/* loaded from: classes.dex */
class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PAGView f19255a;

    q(PAGView pAGView) {
        this.f19255a = pAGView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f19255a.f19204m) {
            this.f19255a.f19200i.start();
        } else {
            Log.e("PAGView", "AnimatorStartRunnable: PAGView is not attached to window");
        }
    }
}
