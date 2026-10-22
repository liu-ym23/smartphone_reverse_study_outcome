package com.stepos.ailauncher.chat.tts;

import Y8.t;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker;
import com.stepos.ailauncher.chat.trace.g;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0003J\u0015\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u000bJ\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\u0003R\u0014\u0010\u001c\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010*\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010 R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010,¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/chat/tts/f;", "", "<init>", "()V", "", "q", "()Z", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;)V", "r", "(Landroid/content/Context;)Z", "Lkotlin/Function0;", g.ACTION_STOP, "o", "(Landroid/content/Context;Lp9/a;)V", "s", "e", "", "from", "m", "(Ljava/lang/String;)V", "l", "k", Const.INTENT_KEY_BACKGROUND_COMMAND, "f", "TAG", "Ljava/lang/String;", "", "STOP_CONFIRM_MS", "J", "HOST_RESUME_SETTLE_MS", "KEEP_TTS_AFTER_RESUME_MS", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "pendingStop", "Ljava/lang/Runnable;", "pendingResume", "lastResumeElapsed", "pausedForScreenshot", "Z", "suppressCoverPause", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f {
    private static final long HOST_RESUME_SETTLE_MS = 400;
    private static final long KEEP_TTS_AFTER_RESUME_MS = 3000;
    private static final long STOP_CONFIRM_MS = 700;
    private static final String TAG = "ScreenshotTtsHold";
    private static volatile long lastResumeElapsed;
    private static volatile boolean pausedForScreenshot;
    private static volatile Runnable pendingResume;
    private static volatile Runnable pendingStop;
    private static volatile boolean suppressCoverPause;
    public static final f INSTANCE = new f();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static final t i() {
        if (!suppressCoverPause) {
            INSTANCE.k("cover-signal");
        }
        return t.f7040a;
    }

    public static final t j() {
        INSTANCE.l("dismiss-signal");
        return t.f7040a;
    }

    public static final void n(String str) {
        pendingResume = null;
        if (pausedForScreenshot) {
            INSTANCE.l(str);
        }
    }

    public static final void p(Context context, InterfaceC5063a interfaceC5063a) {
        pendingStop = null;
        if (INSTANCE.r(context)) {
            return;
        }
        C4148a.k(TAG, "no screenshot overlay after 700ms → stop TTS", false, 4, null);
        suppressCoverPause = true;
        ScreenshotOverlayTracker.INSTANCE.q();
        interfaceC5063a.invoke();
    }

    public final void e(Context context) {
        p.i(context, "context");
        if (pausedForScreenshot) {
            ScreenshotOverlayTracker screenshotOverlayTracker = ScreenshotOverlayTracker.INSTANCE;
            if (screenshotOverlayTracker.w(context)) {
                return;
            }
            pausedForScreenshot = false;
            screenshotOverlayTracker.n("host-stop");
            C4148a.k(TAG, "host left while not under screenshot → drop pause hold", false, 4, null);
        }
    }

    public final void f() {
        Runnable runnable = pendingResume;
        if (runnable != null) {
            mainHandler.removeCallbacks(runnable);
        }
        pendingResume = null;
    }

    public final void g() {
        Runnable runnable = pendingStop;
        if (runnable != null) {
            mainHandler.removeCallbacks(runnable);
        }
        pendingStop = null;
    }

    public final void h(Context context) {
        p.i(context, "context");
        ScreenshotOverlayTracker screenshotOverlayTracker = ScreenshotOverlayTracker.INSTANCE;
        screenshotOverlayTracker.s(context);
        screenshotOverlayTracker.D(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.tts.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return f.i();
            }
        });
        screenshotOverlayTracker.E(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.tts.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return f.j();
            }
        });
    }

    public final void k(String from) {
        g();
        f();
        if (!pausedForScreenshot) {
            pausedForScreenshot = true;
            C4148a.k(TAG, "screenshot overlay → pauseSpeak from=" + from + " (keep stream)", false, 4, null);
        }
        a.INSTANCE.q();
    }

    public final void l(String from) {
        g();
        f();
        if (pausedForScreenshot) {
            pausedForScreenshot = false;
            lastResumeElapsed = SystemClock.elapsedRealtime();
            ScreenshotOverlayTracker.INSTANCE.n(from);
            C4148a.k(TAG, "back from screenshot → resumeSpeak from=" + from, false, 4, null);
            a.INSTANCE.w();
        }
    }

    public final void m(final String from) {
        f();
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.tts.b
            @Override // java.lang.Runnable
            public final void run() {
                f.n(from);
            }
        };
        pendingResume = runnable;
        mainHandler.postDelayed(runnable, 400L);
        C4148a.k(TAG, "schedule resume from=" + from + " in 400ms", false, 4, null);
    }

    public final void o(final Context context, final InterfaceC5063a<t> stop) {
        p.i(context, "context");
        p.i(stop, "stop");
        h(context);
        suppressCoverPause = false;
        if (r(context)) {
            return;
        }
        if (q()) {
            C4148a.k(TAG, "skip stop, screenshot pause/resume in progress", false, 4, null);
            return;
        }
        g();
        ScreenshotOverlayTracker.INSTANCE.C("pause-check");
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.tts.c
            @Override // java.lang.Runnable
            public final void run() {
                f.p(context, stop);
            }
        };
        pendingStop = runnable;
        mainHandler.postDelayed(runnable, STOP_CONFIRM_MS);
    }

    public final boolean q() {
        if (pausedForScreenshot) {
            return true;
        }
        return lastResumeElapsed != 0 && SystemClock.elapsedRealtime() - lastResumeElapsed < 3000;
    }

    public final boolean r(Context context) {
        p.i(context, "context");
        h(context);
        if (!ScreenshotOverlayTracker.INSTANCE.w(context)) {
            return false;
        }
        g();
        k("host-pause");
        return true;
    }

    public final void s() {
        suppressCoverPause = false;
        g();
        if (pausedForScreenshot) {
            m("host-resume");
        }
    }
}
