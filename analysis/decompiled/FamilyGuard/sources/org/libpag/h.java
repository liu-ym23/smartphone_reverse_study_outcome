package org.libpag;

import android.util.Log;

/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PAGImageView f19232a;

    h(PAGImageView pAGImageView) {
        this.f19232a = pAGImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f19232a.f19155I) {
            this.f19232a.f19160d.start();
        } else {
            Log.e("PAGImageView", "AnimatorStartRunnable: PAGView is not attached to window");
        }
    }
}
