package com.bytedance.android.live.broadcastgame.xplay.screendetect;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceView;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.config.ik1;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.LivePlayerPixelCopy;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class XplayAudienceScreenDetector extends com.bytedance.android.live.broadcastgame.xplay.screendetect.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f62353f = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f62354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f62355e;

    public static final class a {
    }

    public static final class b extends PthreadHandlerThreadV2 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ XplayAudienceScreenDetector f62356c;

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            XplayAudienceScreenDetector r100 = this.f62356c;
            Looper r101 = getLooper();
            r100.getClass();
            r100.f62355e = new g(r100, r101);
            Handler r102 = this.f62356c.f62355e;
            if (r102 == null) goto L6;
            r102.sendEmptyMessage(2);
            return;
        }

        public b(XplayAudienceScreenDetector r100) {
            this.f62356c = r100;
            super("xplay_black_screen_detect");
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.screendetect.a
    public final void f() {
        b("stop black screen detect");
        Handler r100 = this.f62355e;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
    L5:
        this.f62355e = null;
        b r101 = this.f62354d;
        if (r101 == null) goto L8;
        r101.quit();
    L8:
        this.f62354d = null;
        e.f62375f.getClass();
        Bitmap r102 = e.f62372c;
        if (r102 == null) goto L11;
        r102.recycle();
    L11:
        e.f62372c = null;
        e.f62373d = null;
        e.f62374e = null;
    }

    public final ik1.b i() {
        return this.f62358a.b();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.screendetect.a
    public final void e() {
        if (i().c() == true) goto L5;
        return;
    L5:
        b("start black screen detect");
        b r100 = new b(this);
        this.f62354d = r100;
        ThreadMethodProxy.start(r100);
        e r101 = e.f62375f;
        XplayAudienceScreenDetector$onStart$2 r102 = new XplayAudienceScreenDetector$onStart$2(this);
        r101.getClass();
        e.f62374e = r102;
    }

    public XplayAudienceScreenDetector(c r100) {
        super(r100);
    }

    public static final void h(final XplayAudienceScreenDetector r100, Handler r101) {
        r100.getClass();
        ILivePlayerClient r102 = LivePlatformPlayerManager.f();
        if (r102 == null) goto L5;
        Object r103 = r102.getRenderView();
    L7:
        if ((r103 instanceof SurfaceView) == true) goto L9;
        r100.b("not surface view");
        return;
    L9:
        r100.b("start detect");
        final long r104 = System.currentTimeMillis();
        e r105 = e.f62375f;
        SurfaceView r106 = (SurfaceView) r103;
        float r107 = r100.i().b();
        boolean r108 = r100.i().f();
        Function1<Bitmap, Unit> r109 = new XplayAudienceScreenDetector$startDetectBlackScreen$1(r100, r104);
        Bitmap.Config r110 = e.f62371b;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "surfaceView");
        Intrinsics.checkNotNullParameter(r110, "bitmapConfig");
        Intrinsics.checkNotNullParameter(r101, "handler");
        Intrinsics.checkNotNullParameter(r109, "callback");
        boolean r111 = e.f62370a;
        if (r111 == false) goto L36;
        int r112 = (int) (r106.getWidth() * r107);
        int r113 = (int) (r106.getHeight() * r107);
        Bitmap r114 = e.f62372c;
        if (r114 == null) goto L28;
        if (r108 == true) goto L15;
    L23:
        boolean r115 = false;
    L24:
        if (r115 == true) goto L27;
        r114 = null;
    L27:
        if (r114 == null) goto L28;
    L33:
        if (e.d(r106) == false) goto L35;
        LivePlayerPixelCopy.Companion.request(r106, r114, new d(r109, r114), r101);
        return;
    L35:
        r109.invoke(null);
        return;
    L15:
        if (r114.getWidth() != r112) goto L23;
        if (r114.getHeight() != r113) goto L23;
        if (r114.getConfig() != r110) goto L23;
        if (r114.isRecycled() == true) goto L23;
        r115 = true;
    L28:
        Bitmap r116 = e.f62372c;
        if (r116 == null) goto L31;
        r116.recycle();
    L31:
        r114 = Bitmap.createBitmap(r112, r113, r110);
        e.f62372c = r114;
        goto L33
    L36:
        Function1<? super String, Unit> r117 = e.f62374e;
        if (r117 == null) goto L39;
        Unit r118 = r117.invoke("capture failed, sdkEnable: " + r111 + ", surfaceValid: " + e.d(r106));
    L39:
        r109.invoke(null);
        return;
    L5:
        r103 = null;
        goto L7
    }
}
