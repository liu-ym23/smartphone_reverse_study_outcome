package com.stepos.common.picker;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3593a;
    public final /* synthetic */ k b;

    public /* synthetic */ j(k kVar, int i) {
        this.f3593a = i;
        this.b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalArgumentException {
        k kVar;
        SoundPool soundPool;
        switch (this.f3593a) {
            case 0:
                SoundPool.Builder builder = new SoundPool.Builder();
                builder.setMaxStreams(1);
                AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
                builder2.setLegacyStreamType(5);
                builder.setAudioAttributes(builder2.build());
                this.b.c = builder.build();
                this.b.c.setOnLoadCompleteListener(new i(this, 0));
                try {
                    try {
                        k kVar2 = this.b;
                        kVar2.e = kVar2.c.load(kVar2.f, R.raw.mc_picker_scrolled, 1);
                        MediaPlayer mediaPlayer = new MediaPlayer();
                        mediaPlayer.setDataSource(this.b.f, Uri.parse("android.resource://" + this.b.f.getPackageName() + "/2131886081"));
                        mediaPlayer.setAudioStreamType(3);
                        mediaPlayer.prepare();
                        this.b.h = mediaPlayer.getDuration() + 5;
                        Log.i("SoundPoolHelper", "mVoidID:" + this.b.e + ",mDuration:" + this.b.h);
                        Looper.prepare();
                    } catch (Exception unused) {
                        kVar = this.b;
                        kVar.d = false;
                    }
                    synchronized (this.b) {
                        kVar = this.b;
                        if (kVar.g) {
                            soundPool = kVar.c;
                        } else {
                            kVar.b = Looper.myLooper();
                            this.b.f3594a = new Handler(this.b.b);
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
                k kVar3 = this.b;
                if (kVar3.d) {
                    if (SystemClock.uptimeMillis() - kVar3.i <= kVar3.h) {
                        Log.w("SoundPoolHelper", "play so fast, has filter this time.");
                        return;
                    }
                    kVar3.i = SystemClock.uptimeMillis();
                    Log.i("SoundPoolHelper", "play sound pool result:" + kVar3.c.play(kVar3.e, 1.0f, 1.0f, 0, 0, 1.0f));
                    return;
                }
                return;
        }
    }
}
