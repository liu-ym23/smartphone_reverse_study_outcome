package com.stepos.common.widget;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class E implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ F f11605a;

    public E(F f4) {
        this.f11605a = f4;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalArgumentException {
        SoundPool soundPool;
        SoundPool.Builder builder = new SoundPool.Builder();
        builder.setMaxStreams(1);
        AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
        builder2.setLegacyStreamType(1);
        builder.setAudioAttributes(builder2.build());
        this.f11605a.f11622c = builder.build();
        this.f11605a.f11622c.setOnLoadCompleteListener(new com.stepos.common.picker.i(this, 1));
        try {
            try {
                F f4 = this.f11605a;
                f4.f11624e = f4.f11622c.load(f4.f11625f, R.raw.mc_picker_scrolled, 1);
                Looper.prepare();
            } catch (Exception unused) {
                F f5 = this.f11605a;
                f5.f11623d = false;
                soundPool = f5.f11622c;
            }
            synchronized (this.f11605a) {
                F f6 = this.f11605a;
                if (f6.f11626g) {
                    f6.f11622c.release();
                    return;
                }
                f6.f11621b = Looper.myLooper();
                this.f11605a.f11620a = new Handler(this.f11605a.f11621b);
                Looper.loop();
                soundPool = this.f11605a.f11622c;
                soundPool.release();
            }
        } catch (Throwable th) {
            this.f11605a.f11622c.release();
            throw th;
        }
    }
}
