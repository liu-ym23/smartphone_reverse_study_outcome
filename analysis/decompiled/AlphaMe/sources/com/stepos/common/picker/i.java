package com.stepos.common.picker;

import android.media.SoundPool;
import com.stepos.common.widget.E;

/* loaded from: classes.dex */
public final class i implements SoundPool.OnLoadCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11376a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f11377b;

    public /* synthetic */ i(Runnable runnable, int i4) {
        this.f11376a = i4;
        this.f11377b = runnable;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public final void onLoadComplete(SoundPool soundPool, int i4, int i5) {
        int i6 = this.f11376a;
        Runnable runnable = this.f11377b;
        switch (i6) {
            case 0:
                ((j) runnable).f11378a.f11382d = true;
                break;
            default:
                ((E) runnable).f11605a.f11623d = true;
                break;
        }
    }
}
