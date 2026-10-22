package com.bytedance.android.live.liveinteract.bgComponent.theme;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.ui.t;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineSimpleCallback;
import com.ss.ttvideoengine.VideoInfoListener;
import com.ss.ttvideoengine.model.VideoModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/liveinteract/bgComponent/theme/VideoThemeView;", "Landroid/widget/FrameLayout;", "Landroid/view/SurfaceHolder$Callback;", "Lcom/bytedance/android/live/ui/o;", "Lcom/bytedance/android/live/ui/t;", SVGRenderEngine.RECT, "", "setDisplayWindowRect", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;", "showArea", "setShowArea", "", "getShowWidth", "getShowHeight", "getShowDirection", "", "alpha", "setThemeViewAlpha", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoThemeView extends FrameLayout implements SurfaceHolder.Callback, com.bytedance.android.live.ui.o {
    public final b A;
    public final f B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTVideoEngine f71686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f71687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IThemeShowArea f71688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Rect f71689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f71690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f71691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f71692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f71693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f71694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f71695j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f71696k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f71697l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f71698m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f71699n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Movie f71700o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f71701p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.bytedance.android.live.ui.n f71702q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Handler f71703r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final a f71704s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f71705t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Paint f71706u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f71707v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public SurfaceHolder f71708w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final SurfaceView f71709x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final e f71710y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final d f71711z;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoThemeView f71712a;

        public a(VideoThemeView r100) {
            this.f71712a = r100;
        }

        public final void a() {
            Movie r100 = this.f71712a.f71700o;
            if (r100 != null) goto L5;
            return;
        L5:
            Intrinsics.checkNotNull(r100);
            int r101 = r100.width();
            Movie r102 = this.f71712a.f71700o;
            Intrinsics.checkNotNull(r102);
            Bitmap r103 = Bitmap.createBitmap(r101, r102.height(), Bitmap.Config.ARGB_8888);
            Canvas r104 = new Canvas(r103);
            Movie r105 = this.f71712a.f71700o;
            Intrinsics.checkNotNull(r105);
            r105.draw(r104, 0.0f, 0.0f);
            Movie r106 = this.f71712a.f71700o;
            Intrinsics.checkNotNull(r106);
            if (r106.duration() == 0) goto L8;
            Movie r107 = this.f71712a.f71700o;
            Intrinsics.checkNotNull(r107);
            VideoThemeView r108 = this.f71712a;
            long r109 = r108.f71705t;
            Movie r110 = r108.f71700o;
            Intrinsics.checkNotNull(r110);
            r107.setTime((int) (r109 % ((long) r110.duration())));
        L9:
            r104.save();
            int r111 = r103.getWidth();
            int r112 = r103.getHeight();
            float r113 = this.f71712a.getWidth() / r111;
            float r114 = this.f71712a.getHeight() / r112;
            SurfaceView r115 = this.f71712a.f71709x;
            Intrinsics.checkNotNull(r115);
            int r116 = (r115.getWidth() - this.f71712a.getWidth()) / 2;
            SurfaceView r117 = this.f71712a.f71709x;
            Intrinsics.checkNotNull(r117);
            int r118 = (r117.getHeight() - this.f71712a.getHeight()) / 2;
            Rect r119 = new Rect(r116, r118, this.f71712a.getWidth() + r116, this.f71712a.getHeight() + r118);
            Matrix r120 = new Matrix();
            r120.postScale(r113, r114);
            Bitmap r121 = Bitmap.createBitmap(r103, 0, 0, r111, r112, r120, true);
            SurfaceHolder r122 = this.f71712a.f71708w;
            if (r122 == null) goto L12;
            Canvas r123 = r122.lockCanvas(r119);
        L13:
            if (r123 != null) goto L15;
            return;
        L15:
            r123.drawColor(0, PorterDuff.Mode.CLEAR);
            Paint r124 = this.f71712a.f71706u;
            Intrinsics.checkNotNull(r124);
            r123.drawBitmap(r121, null, r119, r124);
            SurfaceHolder r125 = this.f71712a.f71708w;
            if (r125 == null) goto L18;
            r125.unlockCanvasAndPost(r123);
        L18:
            VideoThemeView r126 = this.f71712a;
            r126.f71705t += 35;
            a r127 = r126.f71704s;
            if (r127 == null) goto L22;
            r126.f71703r.postDelayed(r127, 35);
            return;
        L22:
            return;
        L12:
            r123 = null;
            goto L13
        L8:
            Movie r128 = this.f71712a.f71700o;
            Intrinsics.checkNotNull(r128);
            r128.setTime(0);
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoThemeView f71713a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            VideoThemeView.a(this.f71713a);
            this.f71713a.getViewTreeObserver().removeOnGlobalLayoutListener(this.f71713a.A);
        }

        public b(VideoThemeView r100) {
            this.f71713a = r100;
        }
    }

    public static final class c {
    }

    public static final class d extends VideoEngineSimpleCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoThemeView f71714a;

        public d(VideoThemeView r100) {
            this.f71714a = r100;
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onPrepared(TTVideoEngine r100) {
            super.onPrepared(r100);
            if (r100 == null) goto L6;
            r100.start();
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onPlaybackStateChanged(TTVideoEngine r100, int r101) {
            super.onPlaybackStateChanged(r100, r101);
            ALogger.d("VideoThemeView" + hashCode(), "onPlaybackStateChanged: 视频播放状态 - 状态=" + r101);
            if (r101 != 1) goto L8;
            com.bytedance.android.live.ui.n r102 = this.f71714a.f71702q;
            if (r102 == null) goto L9;
            r102.b();
            return;
        L9:
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineSimpleCallback, com.ss.ttvideoengine.VideoEngineCallback
        public final void onVideoSizeChanged(TTVideoEngine r100, int r101, int r102) {
            super.onVideoSizeChanged(r100, r101, r102);
            ALogger.i("VideoThemeView" + hashCode(), "onVideoSizeChanged: 视频播放大小 - 宽度=" + r101 + ", 高度=" + r102);
            VideoThemeView r103 = this.f71714a;
            r103.f71691f = r101;
            r103.f71692g = r102;
        }
    }

    public static final class e implements com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoThemeView f71715a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f71716a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f71717b;

            public a(e r100, String r101) {
                this.f71716a = r100;
                this.f71717b = r101;
            }

            public final void a() {
                ALogger.d("VideoThemeView" + this.f71716a.hashCode(), "onDownloadCompleted: 下载完成，开始播放");
                VideoThemeView r100 = this.f71716a.f71715a;
                r100.d(this.f71717b, r100.f71701p, r100.f71702q);
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b
        public final void b() {
        }

        public e(VideoThemeView r100) {
            this.f71715a = r100;
        }

        @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            this.f71715a.post(new a(this, r100));
        }
    }

    public static final class f implements VideoInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoThemeView f71718a;

        public f(VideoThemeView r100) {
            this.f71718a = r100;
        }

        @Override // com.ss.ttvideoengine.VideoInfoListener
        public final boolean onFetchedVideoInfo(VideoModel r100) {
            VideoThemeView.a(this.f71718a);
            return false;
        }
    }

    static {
    }

    public VideoThemeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VideoThemeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return false;
    }

    @Override // com.bytedance.android.live.ui.o
    public final void show() {
        setVisibility(0);
    }

    @Override // com.bytedance.android.live.ui.o
    public final void b() {
        if (this.f71699n == false) goto L8;
        TTVideoEngine r100 = this.f71686a;
        if (r100 == null) goto L9;
        r100.pause();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.ui.o
    public final void c() {
        ALogger.d("VideoThemeView" + hashCode(), "tryStopPlay: 停止播放，isVideoPlaying " + this.f71699n + ", isGifPlaying " + this.f71698m);
        if (this.f71699n == false) goto L8;
        TTVideoEngine r100 = this.f71686a;
        if (r100 == null) goto L8;
        r100.stop();
    L8:
        if (this.f71698m == false) goto L13;
        a r101 = this.f71704s;
        if (r101 == null) goto L14;
        this.f71703r.removeCallbacks(r101);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.live.ui.o
    public final void hide() {
        setVisibility(8);
    }

    @Override // com.bytedance.android.live.ui.o
    public final boolean isPlaying() {
        TTVideoEngine r100 = this.f71686a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getPlaybackState() != 1) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.ui.o
    public final void tryResumePlay() {
        if (this.f71699n == false) goto L12;
        TTVideoEngine r100 = this.f71686a;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isPrepared() != true) goto L14;
        TTVideoEngine r101 = this.f71686a;
        if (r101 == null) goto L15;
        r101.play();
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.live.ui.o
    public final boolean isVisible() {
        if (getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ALogger.d("VideoThemeView" + hashCode(), "onDetachedFromWindow mPlayer?.release()");
        TTVideoEngine r100 = this.f71686a;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f71686a = null;
        a r101 = this.f71704s;
        if (r101 == null) goto L9;
        this.f71703r.removeCallbacks(r101);
        return;
    }

    public int getShowDirection() {
        return this.f71707v;
    }

    public int getShowHeight() {
        return this.f71694i;
    }

    public int getShowWidth() {
        return this.f71695j;
    }

    public static final void a(VideoThemeView r100) {
        if (r100.f71690e == true) goto L5;
        return;
    L5:
        if (r100.f71687b == null) goto L29;
        Rect r101 = r100.f71689d;
        if (r101 == null) goto L30;
        Intrinsics.checkNotNull(r101);
        int r102 = r101.width();
        int r103 = r101.height();
        ALogger.d("VideoThemeView" + r100.hashCode(), "notifyShowAreaChanged: 显示区域 - 宽=" + r102 + ", 高=" + r103 + ", 区域=" + r101);
        if (r100.f71699n == true) goto L12;
    L18:
        r100.f71695j = r102;
        r100.f71694i = r103;
        if (r100.f71691f <= r100.f71692g) goto L23;
        if ((r100.f71693h % 180) != 0) goto L23;
    L24:
        int r104 = 0;
    L26:
        r100.f71707v = r104;
        ALogger.d("VideoThemeView" + r100.hashCode(), "notifyShowAreaChanged: 更新显示宽高 - showWidth=" + r100.f71695j + ", showHeight=" + r100.f71694i);
        r100.f71690e = false;
        return;
    L23:
        if (r100.f71696k > r100.f71697l) goto L24;
        r104 = 1;
        goto L26
    L12:
        if (r100.f71691f <= 0) goto L18;
        if (r100.f71692g <= 0) goto L18;
        TTVideoEngine r105 = r100.f71686a;
        if (r105 == null) goto L18;
        r105.setIntOption(4, 2);
        goto L18
    L30:
        return;
    }

    public final void f(String r100) {
        MediaMetadataRetriever r101 = new MediaMetadataRetriever();
        r101.setDataSource(new PolarisFileInputStreamWrapper(r100).getFD());
        String r102 = e(r101, 18);
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = CastIntegerProtector.parseInt(r102);
    L6:
        this.f71691f = r104;
        String r105 = e(r101, 19);
        if (r105 == null) goto L9;
        int r106 = CastIntegerProtector.parseInt(r105);
    L10:
        this.f71692g = r106;
        String r107 = e(r101, 24);
        if (r107 == null) goto L13;
        r103 = CastIntegerProtector.parseInt(r107);
    L13:
        this.f71693h = r103;
        return;
    L9:
        r106 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public void setDisplayWindowRect(t r100) {
        if (r100 == null) goto L19;
        Rect r101 = new Rect();
        Float r102 = r100.f102101a;
        int r103 = 0;
        if (r102 == null) goto L6;
        int r104 = (int) r102.floatValue();
    L7:
        r101.left = r104;
        Float r105 = r100.f102102b;
        if (r105 == null) goto L10;
        int r106 = (int) r105.floatValue();
    L11:
        r101.top = r106;
        Float r107 = r100.f102103c;
        if (r107 == null) goto L14;
        int r108 = (int) r107.floatValue();
    L15:
        r101.right = r108;
        Float r109 = r100.f102104d;
        if (r109 == null) goto L18;
        r103 = (int) r109.floatValue();
    L18:
        r101.bottom = r103;
    L20:
        this.f71689d = r101;
        if (r100 == null) goto L36;
        SurfaceView r110 = this.f71709x;
        if (r110 == null) goto L25;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
    L26:
        if (r111 == null) goto L35;
        FrameLayout.LayoutParams r112 = (FrameLayout.LayoutParams) r111;
        r112.leftMargin = r101.left;
        r112.topMargin = r101.top;
        r112.width = r101.width();
        r112.height = r101.height();
        r112.gravity = 51;
        SurfaceView r113 = this.f71709x;
        if (r113 == null) goto L30;
        r113.setLayoutParams(r112);
    L30:
        SurfaceView r114 = this.f71709x;
        if (r114 == null) goto L33;
        r114.requestLayout();
    L33:
        this.f71690e = true;
        return;
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L25:
        r111 = null;
        goto L26
    L36:
        return;
    L14:
        r108 = 0;
        goto L15
    L10:
        r106 = 0;
        goto L11
    L6:
        r104 = 0;
        goto L7
    L19:
        r101 = new Rect();
        goto L20
    }

    @Override // com.bytedance.android.live.ui.o
    public void setShowArea(IThemeShowArea r100) {
        this.f71688c = r100;
    }

    @Override // com.bytedance.android.live.ui.o
    public void setThemeViewAlpha(float r100) {
        setAlpha(r100);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        ALogger.d("VideoThemeView" + hashCode(), "surfaceCreated: 开始播放");
        ALogger.d("VideoThemeView" + hashCode(), "mVideoUrl: " + this.f71687b);
        d(this.f71687b, this.f71701p, null);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        ALogger.d("VideoThemeView" + hashCode(), "surfaceDestroyed");
    }

    public static String e(MediaMetadataRetriever r110, int r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public VideoThemeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f71701p = "";
        this.f71703r = new Handler();
        this.f71707v = 1;
        this.f71710y = new e(this);
        this.f71711z = new d(this);
        this.B = new f(this);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_audio_custom_theme_video_view, this, true);
        SurfaceView r103 = (SurfaceView) findViewById(R.id.video_surface);
        this.f71709x = r103;
        if (r103 == null) goto L5;
        SurfaceHolder r104 = r103.getHolder();
    L6:
        this.f71708w = r104;
        if (r104 == null) goto L9;
        r104.addCallback(this);
    L9:
        Paint r105 = new Paint();
        this.f71706u = r105;
        Intrinsics.checkNotNull(r105);
        r105.setAntiAlias(true);
        this.f71704s = new a(this);
        this.A = new b(this);
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.ui.o
    public final void d(String r110, String r111, com.bytedance.android.live.ui.n r112) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L12;
        return;
    L12:
        if (this.f71708w != null) goto L18;
        SurfaceView r101 = this.f71709x;
        if (r101 == null) goto L16;
        SurfaceHolder r102 = r101.getHolder();
    L17:
        this.f71708w = r102;
        goto L18
    L16:
        r102 = null;
    L18:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r110);
        boolean r104 = r103.exists();
        boolean r105 = FileUtils.isGIF(r103);
        ALogger.d("VideoThemeView" + hashCode(), "startPlay: file=" + r103.getAbsolutePath() + ", islocal=" + r104 + ", isGIf=" + r105);
        if (r112 != null) goto L21;
        com.bytedance.android.live.ui.n r106 = this.f71702q;
    L22:
        this.f71702q = r106;
        this.f71700o = null;
        if (r104 == false) goto L28;
        if (r105 == false) goto L26;
        this.f71698m = true;
        this.f71699n = false;
        this.f71700o = Movie.decodeFile(r110);
    L27:
        this.f71687b = r110;
    L40:
        this.f71690e = true;
        String r113 = this.f71687b;
        if (r113 != null) goto L43;
    L46:
        boolean r114 = true;
    L47:
        if (r114 == false) goto L49;
    L53:
        Movie r115 = this.f71700o;
        if (r115 != null) goto L56;
    L58:
        getViewTreeObserver().addOnGlobalLayoutListener(this.A);
        a r116 = this.f71704s;
        if (r116 == null) goto L61;
        this.f71703r.removeCallbacks(r116);
    L61:
        ALogger.d("VideoThemeView" + hashCode(), "isVideoPlaying=" + this.f71699n + ", isGifPlaying=" + this.f71698m);
        if (this.f71699n == false) goto L93;
        a r117 = this.f71704s;
        if (r117 == null) goto L67;
        this.f71703r.removeCallbacks(r117);
    L67:
        if (this.f71686a != null) goto L69;
        TTVideoEngine r118 = new TTVideoEngine(getContext().getApplicationContext(), 0);
        r118.setVideoEngineCallback(this.f71711z);
        r118.setVideoInfoListener(this.B);
        Unit r119 = Unit.INSTANCE;
        this.f71686a = r118;
    L69:
        TTVideoEngine r120 = this.f71686a;
        if (r120 == null) goto L72;
        r120.setSurfaceHolder(this.f71708w);
    L72:
        TTVideoEngine r121 = this.f71686a;
        if (r121 == null) goto L75;
        r121.setLocalURL(this.f71687b);
    L75:
        TTVideoEngine r122 = this.f71686a;
        if (r122 == null) goto L78;
        r122.setIntOption(4, 1);
    L78:
        TTVideoEngine r123 = this.f71686a;
        if (r123 == null) goto L81;
        r123.prepare();
    L81:
        TTVideoEngine r124 = this.f71686a;
        if (r124 == null) goto L84;
        r124.setIsMute(true);
    L84:
        TTVideoEngine r125 = this.f71686a;
        if (r125 == null) goto L87;
        r125.setLooping(true);
    L87:
        TTVideoEngine r126 = this.f71686a;
        if (r126 == null) goto L90;
        r126.start();
    L90:
        if (r112 == null) goto L93;
        r112.a();
    L93:
        if (this.f71698m == false) goto L110;
        TTVideoEngine r127 = this.f71686a;
        if (r127 == null) goto L97;
        r127.release();
    L97:
        Movie r128 = this.f71700o;
        Intrinsics.checkNotNull(r128);
        this.f71700o = r128;
        this.f71705t = 0;
        a r129 = this.f71704s;
        if (r129 == null) goto L100;
        this.f71703r.post(r129);
    L100:
        ALogger.d("VideoThemeView" + hashCode(), "startGif: 启动GIF播放，isGifPlaying设为true");
        return;
    L110:
        return;
    L56:
        if (this.f71698m == false) goto L58;
        this.f71690e = true;
        Intrinsics.checkNotNull(r115);
        this.f71697l = r115.height();
        Movie r130 = this.f71700o;
        Intrinsics.checkNotNull(r130);
        this.f71696k = r130.width();
        ALogger.d("VideoThemeView" + hashCode(), "startPlay: GIF参数 - 宽=" + this.f71696k + ", 高=" + this.f71697l + ", needScale=" + this.f71690e);
        goto L58
    L49:
        if (this.f71699n == false) goto L53;
        ALogger.d("VideoThemeView" + hashCode(), "startPlay: 视频参数 - 视频地址=" + this.f71687b);     // Catch: Throwable -> L52
        f(this.f71687b);     // Catch: Throwable -> L52
        goto L58
    L43:
        if (StringsKt.isBlank(r113) == true) goto L46;
        r114 = false;
        goto L47
    L26:
        this.f71699n = true;
        this.f71698m = false;
        goto L27
    L28:
        this.f71699n = true;
        this.f71698m = false;
        if (r111 != null) goto L31;
    L34:
        boolean r107 = true;
    L35:
        if (r107 == false) goto L37;
        return;
    L37:
        this.f71701p = r111;
        if (VideoThemeDownloadManager.e(r111) == false) goto L102;
        this.f71687b = VideoThemeDownloadManager.d(r111);
        goto L40
    L102:
        Intrinsics.checkNotNullParameter(r111, "id");
        if (VideoThemeDownloadManager.f71683b.containsKey(r111) == false) goto L106;
        VideoThemeDownloadManager.f(r111, this.f71710y);
        return;
    L106:
        VideoThemeDownloadManager.b(r110, r111, this.f71710y);
        return;
    L31:
        if (r111.length() == 0) goto L34;
        r107 = false;
        goto L35
    L21:
        r106 = r112;
        goto L22
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L9
    }

    public /* synthetic */ VideoThemeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        ALogger.d("VideoThemeView" + hashCode(), "surfaceChanged width ; " + r102 + " height : " + r103);
    }
}
