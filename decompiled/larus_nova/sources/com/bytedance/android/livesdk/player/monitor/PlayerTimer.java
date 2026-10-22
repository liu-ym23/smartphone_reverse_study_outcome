package com.bytedance.android.livesdk.player.monitor;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.android.livesdkapi.player.ILivePlayerTimerListener;
import com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class PlayerTimer extends LivePlayerEventListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<ILivePlayerTimerListener> f155765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f155766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f155767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f155768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ILivePlayerClient f155769e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerTimer f155770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ILivePlayerTimerListener f155771b;

        public a(PlayerTimer r100, ILivePlayerTimerListener r101) {
            this.f155770a = r100;
            this.f155771b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f155770a.f155765a.add(this.f155771b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerTimer f155772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ILivePlayerTimerListener f155773b;

        public b(PlayerTimer r100, ILivePlayerTimerListener r101) {
            this.f155772a = r100;
            this.f155773b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f155772a.f155765a.remove(this.f155773b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final Handler b() {
        return (Handler) this.f155766b.getValue();
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onStartPul() {
        this.f155767c = 0;
        SystemClock.elapsedRealtime();
        b().postDelayed((Runnable) this.f155768d.getValue(), 1000);
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onPlaying() {
        SystemClock.elapsedRealtime();
        SystemClock.elapsedRealtime();
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onRelease() {
        SystemClock.elapsedRealtime();
        b().removeCallbacks((Runnable) this.f155768d.getValue());
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onStop() {
        SystemClock.elapsedRealtime();
        b().removeCallbacks((Runnable) this.f155768d.getValue());
    }

    public PlayerTimer(ILivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        this.f155769e = r100;
        this.f155765a = new HashSet();
        this.f155766b = LazyKt.lazy(PlayerTimer$timeNotifyHandler$2.INSTANCE);
        this.f155768d = LazyKt.lazy(new PlayerTimer$secondNotifier$2(this));
    }

    public final void a(ILivePlayerTimerListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        b().post(new a(this, r100));
    }

    public final void c(ILivePlayerTimerListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        b().post(new b(this, r100));
    }
}
