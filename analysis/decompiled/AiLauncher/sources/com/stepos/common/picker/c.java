package com.stepos.common.picker;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.common.R$raw;

/* loaded from: classes3.dex */
public class c {
    private static final String TAG = "SoundPoolHelper";
    public Context mContext;
    private int mDuration;
    public boolean mIsFinishedLoad;
    public boolean mIsRelease;
    public SoundPool mSoundPool;
    public int mVoiceID;
    private Thread mSoundPoolThread = null;
    private Handler mSoundHandler = null;
    private Looper mSoundLooper = null;
    private long mLastPlayTime = 0;

    public class a implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        /* renamed from: com.stepos.common.picker.c$a$a, reason: collision with other inner class name */
        public class C0349a implements SoundPool.OnLoadCompleteListener {
            public C0349a() {
            }

            @Override // android.media.SoundPool.OnLoadCompleteListener
            public void onLoadComplete(SoundPool soundPool, int i10, int i11) {
                c.this.mIsFinishedLoad = true;
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalArgumentException {
            SoundPool soundPool;
            SoundPool.Builder builder = new SoundPool.Builder();
            builder.setMaxStreams(1);
            AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
            builder2.setLegacyStreamType(5);
            builder.setAudioAttributes(builder2.build());
            c.this.mSoundPool = builder.build();
            c.this.mSoundPool.setOnLoadCompleteListener(new C0349a());
            try {
                try {
                    c cVar = c.this;
                    SoundPool soundPool2 = cVar.mSoundPool;
                    Context context = cVar.mContext;
                    int i10 = R$raw.mc_picker_scrolled;
                    cVar.mVoiceID = soundPool2.load(context, i10, 1);
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(c.this.mContext, Uri.parse("android.resource://" + c.this.mContext.getPackageName() + "/" + i10));
                    mediaPlayer.setAudioStreamType(3);
                    mediaPlayer.prepare();
                    c.this.mDuration = mediaPlayer.getDuration() + 5;
                    Log.i(c.TAG, "mVoidID:" + c.this.mVoiceID + ",mDuration:" + c.this.mDuration);
                    Looper.prepare();
                    synchronized (c.this) {
                        c cVar2 = c.this;
                        if (cVar2.mIsRelease) {
                            soundPool = cVar2.mSoundPool;
                        } else {
                            cVar2.mSoundLooper = Looper.myLooper();
                            c.this.mSoundHandler = new Handler(c.this.mSoundLooper);
                            Looper.loop();
                            soundPool = c.this.mSoundPool;
                        }
                    }
                } catch (Exception unused) {
                    c cVar3 = c.this;
                    cVar3.mIsFinishedLoad = false;
                    soundPool = cVar3.mSoundPool;
                }
                soundPool.release();
            } catch (Throwable th) {
                c.this.mSoundPool.release();
                throw th;
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mIsFinishedLoad) {
                if (SystemClock.uptimeMillis() - c.this.mLastPlayTime <= c.this.mDuration) {
                    Log.w(c.TAG, "play so fast, has filter this time.");
                    return;
                }
                c.this.mLastPlayTime = SystemClock.uptimeMillis();
                c cVar = c.this;
                Log.i(c.TAG, "play sound pool result:" + cVar.mSoundPool.play(cVar.mVoiceID, 1.0f, 1.0f, 0, 0, 1.0f));
            }
        }
    }

    public void h(Context context) {
        this.mContext = context.getApplicationContext();
        this.mIsFinishedLoad = false;
        Thread thread = new Thread(new a());
        this.mSoundPoolThread = thread;
        thread.start();
    }

    public void i(Context context) {
        if (this.mIsFinishedLoad) {
            return;
        }
        h(context);
    }

    public void j() {
        Handler handler = this.mSoundHandler;
        if (handler != null) {
            handler.post(new b());
        }
    }

    public void k() {
        synchronized (this) {
            try {
                this.mIsRelease = true;
                Handler handler = this.mSoundHandler;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    if (this.mIsFinishedLoad) {
                        this.mSoundPool.unload(this.mVoiceID);
                    }
                    this.mSoundPool.release();
                    this.mSoundLooper.quit();
                    this.mSoundPoolThread = null;
                    this.mIsFinishedLoad = false;
                    this.mContext = null;
                    this.mSoundHandler = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
