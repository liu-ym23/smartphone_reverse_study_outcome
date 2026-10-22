package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Handler;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.utils.z5;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f114494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile z5 f114495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Handler f114496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f114497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f114498e;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f114499a;

        public b(i r100, ByteBuffer r101, long r102, long r103) {
            this.f114499a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f114499a.getClass();     // Catch: Throwable -> L9
            ILiveWrappedLivePusher.Companion.getClass();     // Catch: Exception -> L7 Throwable -> L9
            ILiveWrappedLivePusher r100 = ILiveWrappedLivePusher.a.b();     // Catch: Exception -> L7 Throwable -> L9
            if (r100 == null) goto L12;
            r100.getZlibCompressUtils();     // Catch: Exception -> L7 Throwable -> L9
        L19:
            return;
        L12:
            return;
        L7:
            ALogger.e("CARNIVAL_MESSAGE", "parse binary data error");     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    static {
    }

    public final void b() {
        ALogger.e("CarnivalBinarySeiHandler", "reset. state=" + this.f114494a.get());
        if (this.f114494a.get() == 0) goto L12;
        this.f114494a.set(0);
        z5 r100 = this.f114495b;
        if (r100 == null) goto L7;
        r100.quit();
    L7:
        this.f114495b = null;
        this.f114496c = null;
        Disposable r101 = this.f114497d;
        if (r101 == null) goto L10;
        r101.dispose();
    L10:
        this.f114497d = null;
        return;
    }

    public i(com.bytedance.android.livesdk.interactivity.api.barrage.data.g r100) {
        Intrinsics.checkNotNullParameter(r100, "contourInfo");
        this.f114494a = new AtomicInteger();
    }

    public final void a(ByteBuffer r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (r110.remaining() <= 0) goto L35;
        int r100 = this.f114494a.get();
        if (r100 != 0) goto L9;
        this.f114494a.set(1);
        long r101 = System.currentTimeMillis();
        this.f114495b = new z5("CarnivalBinarySeiHandler", r52.s.f536253a.getValue().threadPriority, new j(this, r101));
        z5 r111 = this.f114495b;
        if (r111 == null) goto L17;
        ThreadMethodProxy.start(r111);
    L17:
        Disposable r112 = this.f114497d;
        if (r112 == null) goto L20;
        r112.dispose();
    L20:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r113 = com.bytedance.android.livesdk.interactivity.api.q.b();
        if (r113 == null) goto L29;
        com.bytedance.live.datacontext.m<Boolean> r114 = r113.isCarnivalStarted();
        if (r114 == null) goto L29;
        Observable<Boolean> r115 = r114.a();
        if (r115 == null) goto L29;
        Observable<Boolean> r116 = r115.observeOn(AndroidSchedulers.mainThread());
        if (r116 == null) goto L29;
        Disposable r117 = r116.subscribe(new k(this));
    L30:
        this.f114497d = r117;
        return;
    L29:
        r117 = null;
        goto L30
    L9:
        if (r100 != 2) goto L36;
        long r102 = this.f114498e;
        long r103 = System.currentTimeMillis();
        this.f114498e = r103;
        Handler r104 = this.f114496c;
        if (r104 == null) goto L33;
        r104.post(new b(this, r110, r102, r103));
        return;
    L33:
        return;
    L36:
        return;
    }
}
