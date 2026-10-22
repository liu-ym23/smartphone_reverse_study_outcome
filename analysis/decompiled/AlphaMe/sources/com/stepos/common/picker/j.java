package com.stepos.common.picker;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f11378a;

    public j(k kVar) {
        this.f11378a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalArgumentException {
        SoundPool soundPool;
        SoundPool.Builder builder = new SoundPool.Builder();
        builder.setMaxStreams(1);
        AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
        builder2.setLegacyStreamType(5);
        builder.setAudioAttributes(builder2.build());
        this.f11378a.f11381c = builder.build();
        this.f11378a.f11381c.setOnLoadCompleteListener(new i(this, 0));
        try {
            try {
                k kVar = this.f11378a;
                kVar.f11383e = kVar.f11381c.load(kVar.f11384f, R.raw.mc_picker_scrolled, 1);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(this.f11378a.f11384f, Uri.parse("android.resource://" + this.f11378a.f11384f.getPackageName() + "/2131755008"));
                mediaPlayer.setAudioStreamType(3);
                mediaPlayer.prepare();
                this.f11378a.f11386h = mediaPlayer.getDuration() + 5;
                Log.i("SoundPoolHelper", "mVoidID:" + this.f11378a.f11383e + ",mDuration:" + this.f11378a.f11386h);
                Looper.prepare();
            } catch (Exception unused) {
                k kVar2 = this.f11378a;
                kVar2.f11382d = false;
                soundPool = kVar2.f11381c;
            }
            synchronized (this.f11378a) {
                k kVar3 = this.f11378a;
                if (kVar3.f11385g) {
                    kVar3.f11381c.release();
                    return;
                }
                kVar3.f11380b = Looper.myLooper();
                this.f11378a.f11379a = new Handler(this.f11378a.f11380b);
                Looper.loop();
                soundPool = this.f11378a.f11381c;
                soundPool.release();
            }
        } catch (Throwable th) {
            this.f11378a.f11381c.release();
            throw th;
        }
    }
}
