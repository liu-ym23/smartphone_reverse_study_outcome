package com.bytedance.android.live.revenue.platform.stream.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.revenue.common.t0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.scope.o;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.ttvideoengine.model.SubInfo;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.SingleSubject;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class StreamCaptureServiceImpl implements o, d01.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f91662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yz0.g f91663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f91664c;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap.CompressFormat f91665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f91666b;

        public b(Bitmap.CompressFormat r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
            this.f91665a = r100;
            this.f91666b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Surface f91667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f91668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f91669c;

        public c(Surface r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            this.f91667a = r100;
            this.f91668b = r101;
            this.f91669c = r102;
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StreamCaptureServiceImpl f91671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d01.c.a f91672b;

        public d(StreamCaptureServiceImpl r100, d01.c.a r101) {
            this.f91671a = r100;
            this.f91672b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
            d01.c.a r102 = this.f91672b;
            b r103 = new b(r102.f466182a, r102.f466183b);
            StreamCaptureServiceImpl r104 = this.f91671a;
            r104.getClass();
            return Single.create(new g(r104, r103, r101)).subscribeOn(Schedulers.io());
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f91673a = null;

        static {
            f91673a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            File r101 = (File) r100;
            Intrinsics.checkNotNullParameter(r101, "file");
            return new d01.c.b(r101);
        }
    }

    public static final class f<T1, T2> implements ttc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f91674a;

        public f(u0 r100) {
            this.f91674a = r100;
        }

        @Override // ttc.a
        public final void accept(Object r100, Object r101) {
            d01.c.b r102 = (d01.c.b) r100;
            Throwable r103 = (Throwable) r101;
            u0 r104 = u0.f90999f;
            long r105 = t0.b().b(this.f91674a).f91006a;
            if (r102 == null) goto L5;
            jy0.b.a("StreamCaptureService", "captureVideoFrame finished in " + r105 + "ms: " + r102.f466184a);
            return;
        L5:
            StringBuilder r106 = new StringBuilder("captureVideoFrame failed in ");
            r106.append(r105);
            r106.append("ms: ");
            if (r103 == null) goto L8;
            String r107 = r103.getMessage();
        L9:
            r106.append(r107);
            jy0.b.a("StreamCaptureService", r106.toString());
            return;
        L8:
            r107 = null;
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    private final Context getContext() {
        return this.f91663b.getContext();
    }

    public final PolarisFileWrapper c() {
        return new PolarisFileWrapper(getContext().getCacheDir(), "live/stream_capture/pid");
    }

    public final c d() {
        ILivePlayerClient r100 = LivePlatformPlayerManager.c(IRoomKtKt.getId(this.f91663b.getRoom()), false).player();
        Surface r101 = null;
        if (r100 == null) goto L5;
        IRenderView r102 = r100.getRenderView();
    L6:
        if (r102 == null) goto L15;
        SurfaceHolder r103 = r102.getSurfaceHolder();
        if (r103 == null) goto L10;
        r101 = r103.getSurface();
    L10:
        if (r101 == null) goto L14;
        return new c(r101, r102.getWidth(), r102.getHeight());
    L14:
        throw new IllegalStateException("player surface is not present");
    L15:
        com.bytedance.android.livesdk.revenue.pushstream.a r104 = this.f91664c.getRoomContext().getLiveStream().getValue();
        if (r104 == null) goto L24;
        View r105 = r104.getSurfaceView();
        if ((r105 instanceof SurfaceView) == false) goto L22;
        SurfaceView r106 = (SurfaceView) r105;
        return new c(r106.getHolder().getSurface(), r106.getWidth(), r106.getHeight());
    L22:
        throw new IllegalStateException("surfaceView type check fail: " + r105);
    L24:
        throw new IllegalStateException("liveStream is null");
    L5:
        r102 = null;
        goto L6
    }

    @Override // d01.c
    public final Single<d01.c.b> a(d01.c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        u0 r101 = u0.f90999f;
        u0 r102 = t0.b();
        if (this.f91663b.isAnchor() == true) goto L22;
        final ILivePlayerClient r103 = LivePlatformPlayerManager.c(IRoomKtKt.getId(this.f91663b.getRoom()), false).player();
        if (r103 == null) goto L7;
        Single r104 = Single.create(new StreamCaptureServiceImpl$captureVideoFrame$bitmap$1(r103));
    L21:
        return r104.flatMap(new d(this, r100)).map(e.f91673a).doOnEvent(new f(r102));
    L7:
        return Single.error(new IllegalStateException("LivePlayerClient is null"));
    L22:
        c r105 = d();     // Catch: Throwable -> L18
        Bitmap r106 = Bitmap.createBitmap(r105.f91668b, r105.f91669c, Bitmap.Config.ARGB_8888);
        Surface r107 = r105.f91667a;
        if (Build.VERSION.SDK_INT >= 24) goto L24;
        Single r108 = Single.error(new IllegalStateException("PixelCopy is not supported on this device"));
    L17:
        r104 = r108.flatMap(new com.bytedance.android.live.revenue.platform.stream.impl.d(r106));
        goto L21
    L24:
        Handler r109 = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L15
        SingleSubject r110 = SingleSubject.create();     // Catch: Throwable -> L15
        PixelCopy.request(r107, r106, new com.bytedance.android.live.revenue.platform.stream.impl.f(r110), r109);     // Catch: Throwable -> L15
        r108 = r110;
    L15:
        th = move-exception;
        r108 = Single.error(th);
    L18:
        th = move-exception;
        r104 = Single.error(th);
        goto L21
    }

    public StreamCaptureServiceImpl(yz0.g r100, com.bytedance.android.livesdk.revenue.service.room.c r101) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "revRoomService");
        this.f91663b = r100;
        this.f91664c = r101;
    }
}
