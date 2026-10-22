package com.stepos.common.widget;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public final class K implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3719a;
    public final /* synthetic */ L b;

    public /* synthetic */ K(L l, int i) {
        this.f3719a = i;
        this.b = l;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalArgumentException {
        L l;
        SoundPool soundPool;
        switch (this.f3719a) {
            case 0:
                SoundPool.Builder builder = new SoundPool.Builder();
                builder.setMaxStreams(1);
                AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
                builder2.setLegacyStreamType(1);
                builder.setAudioAttributes(builder2.build());
                this.b.c = builder.build();
                this.b.c.setOnLoadCompleteListener(new com.stepos.common.picker.i(this, 1));
                try {
                    try {
                        L l5 = this.b;
                        l5.e = l5.c.load(l5.f, R.raw.mc_picker_scrolled, 1);
                        Looper.prepare();
                    } catch (Exception unused) {
                        l = this.b;
                        l.d = false;
                    }
                    synchronized (this.b) {
                        l = this.b;
                        if (l.g) {
                            soundPool = l.c;
                        } else {
                            l.b = Looper.myLooper();
                            this.b.f3720a = new Handler(this.b.b);
                            Looper.loop();
                            soundPool = this.b.c;
                        }
                    }
                    soundPool.release();
                    return;
                } catch (Throwable th) {
                    this.b.c.release();
                    throw th;
                }
            default:
                L l9 = this.b;
                if (l9.d) {
                    l9.c.play(l9.e, 0.5f, 0.5f, 0, 0, 1.0f);
                    return;
                }
                return;
        }
    }
}
