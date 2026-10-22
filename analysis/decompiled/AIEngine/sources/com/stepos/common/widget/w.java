package com.stepos.common.widget;

import android.media.SoundPool;
import com.stepos.common.widget.ScrollTextView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollTextView.l f7201a;

    public w(ScrollTextView.l lVar) {
        this.f7201a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f7201a) {
            ScrollTextView.l lVar = this.f7201a;
            if (lVar.f7021e && !lVar.f7023g) {
                SoundPool soundPool = lVar.f7020d;
                int i10 = lVar.f7022f;
                if (soundPool != null) {
                    soundPool.play(i10, 0.5f, 0.5f, 0, 0, 1.0f);
                }
            }
        }
    }
}
