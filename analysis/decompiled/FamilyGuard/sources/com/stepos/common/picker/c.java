package com.stepos.common.picker;

import H1.j;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

/* loaded from: classes.dex */
class c {

    /* renamed from: d, reason: collision with root package name */
    public SoundPool f13675d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13676e;

    /* renamed from: f, reason: collision with root package name */
    public int f13677f;

    /* renamed from: g, reason: collision with root package name */
    public Context f13678g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f13679h;

    /* renamed from: i, reason: collision with root package name */
    private int f13680i;

    /* renamed from: a, reason: collision with root package name */
    private Thread f13672a = null;

    /* renamed from: b, reason: collision with root package name */
    private Handler f13673b = null;

    /* renamed from: c, reason: collision with root package name */
    private Looper f13674c = null;

    /* renamed from: j, reason: collision with root package name */
    private long f13681j = 0;

    class a implements Runnable {

        /* renamed from: com.stepos.common.picker.c$a$a, reason: collision with other inner class name */
        class C0174a implements SoundPool.OnLoadCompleteListener {
            C0174a() {
            }

            @Override // android.media.SoundPool.OnLoadCompleteListener
            public void onLoadComplete(SoundPool soundPool, int i5, int i6) {
                c.this.f13676e = true;
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalArgumentException {
            SoundPool soundPool;
            SoundPool.Builder builder = new SoundPool.Builder();
            builder.setMaxStreams(1);
            AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
            builder2.setLegacyStreamType(5);
            builder.setAudioAttributes(builder2.build());
            c.this.f13675d = builder.build();
            c.this.f13675d.setOnLoadCompleteListener(new C0174a());
            try {
                try {
                    c cVar = c.this;
                    SoundPool soundPool2 = cVar.f13675d;
                    Context context = cVar.f13678g;
                    int i5 = j.f2336a;
                    cVar.f13677f = soundPool2.load(context, i5, 1);
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(c.this.f13678g, Uri.parse("android.resource://" + c.this.f13678g.getPackageName() + "/" + i5));
                    mediaPlayer.setAudioStreamType(3);
                    mediaPlayer.prepare();
                    c.this.f13680i = mediaPlayer.getDuration() + 5;
                    Log.i("SoundPoolHelper", "mVoidID:" + c.this.f13677f + ",mDuration:" + c.this.f13680i);
                    Looper.prepare();
                    synchronized (c.this) {
                        c cVar2 = c.this;
                        if (cVar2.f13679h) {
                            soundPool = cVar2.f13675d;
                        } else {
                            cVar2.f13674c = Looper.myLooper();
                            c.this.f13673b = new Handler(c.this.f13674c);
                            Looper.loop();
                            soundPool = c.this.f13675d;
                        }
                    }
                } catch (Exception unused) {
                    c cVar3 = c.this;
                    cVar3.f13676e = false;
                    soundPool = cVar3.f13675d;
                }
                soundPool.release();
            } catch (Throwable th) {
                c.this.f13675d.release();
                throw th;
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f13676e) {
                if (SystemClock.uptimeMillis() - c.this.f13681j <= c.this.f13680i) {
                    Log.w("SoundPoolHelper", "play so fast, has filter this time.");
                    return;
                }
                c.this.f13681j = SystemClock.uptimeMillis();
                c cVar = c.this;
                Log.i("SoundPoolHelper", "play sound pool result:" + cVar.f13675d.play(cVar.f13677f, 1.0f, 1.0f, 0, 0, 1.0f));
            }
        }
    }

    c() {
    }

    public void h(Context context) {
        this.f13678g = context.getApplicationContext();
        this.f13676e = false;
        Thread thread = new Thread(new a());
        this.f13672a = thread;
        thread.start();
    }

    public void i(Context context) {
        if (this.f13676e) {
            return;
        }
        h(context);
    }

    public void j() {
        Handler handler = this.f13673b;
        if (handler != null) {
            handler.post(new b());
        }
    }

    public void k() {
        synchronized (this) {
            try {
                this.f13679h = true;
                Handler handler = this.f13673b;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    if (this.f13676e) {
                        this.f13675d.unload(this.f13677f);
                    }
                    this.f13675d.release();
                    this.f13674c.quit();
                    this.f13672a = null;
                    this.f13676e = false;
                    this.f13678g = null;
                    this.f13673b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
