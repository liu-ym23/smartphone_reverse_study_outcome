package com.stepos.common.picker;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f6540a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements SoundPool.OnLoadCompleteListener {
        public a() {
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public final void onLoadComplete(SoundPool soundPool, int i10, int i11) {
            f.this.f6540a.f6547d = true;
        }
    }

    public f(h hVar) {
        this.f6540a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalArgumentException {
        SoundPool soundPool;
        SoundPool.Builder builder = new SoundPool.Builder();
        builder.setMaxStreams(1);
        AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
        builder2.setLegacyStreamType(5);
        builder.setAudioAttributes(builder2.build());
        this.f6540a.f6546c = builder.build();
        this.f6540a.f6546c.setOnLoadCompleteListener(new a());
        try {
            try {
                h hVar = this.f6540a;
                hVar.f6548e = hVar.f6546c.load(hVar.f6549f, R.raw.mc_picker_scrolled, 1);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(this.f6540a.f6549f, Uri.parse("android.resource://" + this.f6540a.f6549f.getPackageName() + "/2131820544"));
                mediaPlayer.setAudioStreamType(3);
                mediaPlayer.prepare();
                this.f6540a.h = mediaPlayer.getDuration() + 5;
                Log.i("SoundPoolHelper", "mVoidID:" + this.f6540a.f6548e + ",mDuration:" + this.f6540a.h);
                Looper.prepare();
                synchronized (this.f6540a) {
                    h hVar2 = this.f6540a;
                    if (hVar2.f6550g) {
                        soundPool = hVar2.f6546c;
                    } else {
                        hVar2.f6545b = Looper.myLooper();
                        this.f6540a.f6544a = new Handler(this.f6540a.f6545b);
                        Looper.loop();
                        soundPool = this.f6540a.f6546c;
                    }
                }
            } catch (Exception unused) {
                h hVar3 = this.f6540a;
                hVar3.f6547d = false;
                soundPool = hVar3.f6546c;
            }
            soundPool.release();
        } catch (Throwable th) {
            this.f6540a.f6546c.release();
            throw th;
        }
    }
}
