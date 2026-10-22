package com.stepos.ailauncher.chat.input.controller;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.media.MusicVolumeDucker;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0006*\u0001\u0017\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/input/controller/L;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_UMID, "c", "e", "Landroid/media/AudioManager;", "audioManager", "Landroid/media/AudioManager;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "", "watching", "Z", "volumeHeld", "playbackCallbackRegistered", "com/stepos/ailauncher/chat/input/controller/L$b", "playbackCallback", "Lcom/stepos/ailauncher/chat/input/controller/L$b;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class L {
    private static final String TAG = "RecordingMediaCtrl";
    private final AudioManager audioManager;
    private final Handler mainHandler;
    private final b playbackCallback;
    private boolean playbackCallbackRegistered;
    private boolean volumeHeld;
    private boolean watching;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/input/controller/L$b", "Landroid/media/AudioManager$AudioPlaybackCallback;", "", "Landroid/media/AudioPlaybackConfiguration;", "configs", "LY8/t;", "onPlaybackConfigChanged", "(Ljava/util/List;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AudioManager.AudioPlaybackCallback {
        public b() {
        }

        @Override // android.media.AudioManager.AudioPlaybackCallback
        public void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> configs) {
            kotlin.jvm.internal.p.i(configs, "configs");
            if (L.this.watching) {
                MusicVolumeDucker.INSTANCE.A();
            }
        }
    }

    public L(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Object systemService = context.getApplicationContext().getSystemService("audio");
        this.audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.playbackCallback = new b();
    }

    public final void b() {
        if (this.watching) {
            return;
        }
        this.watching = true;
        c();
        if (!this.volumeHeld) {
            MusicVolumeDucker.INSTANCE.q(MusicVolumeDucker.Reason.VOICE);
            this.volumeHeld = true;
        }
        C4148a.k(TAG, "acquire: duck music volume", false, 4, null);
    }

    public final void c() {
        Object objB;
        AudioManager audioManager = this.audioManager;
        if (audioManager == null || this.playbackCallbackRegistered) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            audioManager.registerAudioPlaybackCallback(this.playbackCallback, this.mainHandler);
            this.playbackCallbackRegistered = true;
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "registerAudioPlaybackCallback failed", thE, false, 8, null);
        }
    }

    public final void d() {
        boolean z10 = this.watching;
        this.watching = false;
        e();
        if (this.volumeHeld) {
            this.volumeHeld = false;
            MusicVolumeDucker.INSTANCE.D(MusicVolumeDucker.Reason.VOICE);
            C4148a.k(TAG, "release: restore music volume", false, 4, null);
        } else if (z10) {
            C4148a.k(TAG, "release: volume not held", false, 4, null);
        }
    }

    public final void e() {
        AudioManager audioManager = this.audioManager;
        if (audioManager != null && this.playbackCallbackRegistered) {
            this.playbackCallbackRegistered = false;
            try {
                Result.Companion companion = Result.INSTANCE;
                audioManager.unregisterAudioPlaybackCallback(this.playbackCallback);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }
}
