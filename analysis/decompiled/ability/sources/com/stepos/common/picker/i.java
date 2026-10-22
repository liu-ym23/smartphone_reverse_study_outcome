package com.stepos.common.picker;

import android.media.SoundPool;
import com.stepos.common.widget.K;

/* loaded from: classes3.dex */
public final class i implements SoundPool.OnLoadCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3592a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ i(Runnable runnable, int i) {
        this.f3592a = i;
        this.b = runnable;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public final void onLoadComplete(SoundPool soundPool, int i, int i6) {
        switch (this.f3592a) {
            case 0:
                ((j) this.b).b.d = true;
                break;
            default:
                ((K) this.b).b.d = true;
                break;
        }
    }
}
