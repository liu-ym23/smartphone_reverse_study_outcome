package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.VideoCtrlContainerComponent;
import com.bytedance.android.shopping.events.ImagePosition;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class VideoCoverLayout extends FrameLayout {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f169729t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f169730u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f169731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f169732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f169733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f169734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f169735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f169736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f169737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f169738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f169739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f169740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b f169741k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final VideoProgressTextLayout f169742l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.e f169743m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f169744n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final VideoProgressBar f169745o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f169746p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f169747q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f169748r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f f169749s;

    public static final class a implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoCoverLayout f169750a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
        public final void onDragEnd() {
            VideoCoverLayout r100 = this.f169750a;
            r100.f169749s.b();
            if (r100.f169737g == false) goto L5;
        L6:
            ViewExtensionsKt.i(r100.f169743m);
            return;
        L5:
            if (HeadVideoAutoPlayController.f169727f == true) goto L6;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
        public final void onDragStart() {
            VideoCoverLayout r100 = this.f169750a;
            r100.f169749s.c();
            r100.f169744n.run();
            float r101 = r100.f169745o.getDragProgress();
            VideoProgressTextLayout r102 = r100.f169742l;
            int r103 = r100.f169736f;
            r102.f169778a.setText(VideoProgressTextLayout.a((int) (r101 * r103)));
            r102.f169779b.setText(VideoProgressTextLayout.a(r103));
        }

        public a(VideoCoverLayout r100) {
            this.f169750a = r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
        public final void a(float r100) {
            this.f169750a.f169749s.a(r100);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
        public final void b(float r100) {
            VideoCoverLayout r101 = this.f169750a;
            VideoProgressTextLayout r102 = r101.f169742l;
            int r103 = r101.f169736f;
            r102.f169778a.setText(VideoProgressTextLayout.a((int) (r100 * r103)));
            r102.f169779b.setText(VideoProgressTextLayout.a(r103));
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b
        public final void c(float r100) {
            VideoCoverLayout r101 = this.f169750a;
            r101.f169735e = r100;
            r101.f169742l.setAlpha(r100);
            this.f169750a.invalidate();
        }
    }

    public static final class b {
    }

    public static final class c extends z53.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ List f169751f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Function0 f169752g;

        public c(List r100, Function0 r101, List r102, String r110, Function0 r111) {
            this.f169751f = r100;
            this.f169752g = r101;
            super(r102, r110, r111, false, 8);
        }
    }

    public static final class d implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoCoverLayout f169753a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.a
        public final void a() {
            if (this.f169753a.f169743m.getVisibility() != 0) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L9;
            VideoCoverLayout r101 = this.f169753a;
            r101.f169749s.h(!r101.f169737g);
            return;
        L9:
            return;
        L5:
            r100 = false;
            goto L6
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.a
        public final void b() {
            if (this.f169753a.f169743m.getVisibility() != 0) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L9;
            VideoCoverLayout r101 = this.f169753a;
            r101.f169749s.k(!r101.f169738h);
            return;
        L9:
            return;
        L5:
            r100 = false;
            goto L6
        }

        public final boolean c() {
            return this.f169753a.f169749s.j();
        }

        public d(VideoCoverLayout r100) {
            this.f169753a = r100;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoCoverLayout f169754a;

        @Override // java.lang.Runnable
        public final void run() {
            ViewExtensionsKt.c(this.f169754a.f169743m, true, 1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(VideoCoverLayout r100) {
            this.f169754a = r100;
        }
    }

    private static /* synthetic */ void getHideButtonAction$annotations() {
    }

    private final ECDraweeView getMCoverImageView() {
        return (ECDraweeView) this.f169748r.getValue();
    }

    private final ECStatusView getMLoadingView() {
        return (ECStatusView) this.f169746p.getValue();
    }

    private final ImageView getMPlayButtonView() {
        return (ImageView) this.f169747q.getValue();
    }

    static {
        f169729t = com.bytedance.android.shopping.extensions.b.a(60);
        f169730u = com.bytedance.android.shopping.extensions.b.a(110);
    }

    public final void g() {
        removeCallbacks(this.f169744n);
        boolean r100 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.f169207a;
        if (com.bytedance.android.ec.core.abtest.d.w() == true) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == true) goto L11;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.e r102 = this.f169743m;
        r102.setVisibility(0);
        r102.setAlpha(1.0f);
        this.f169745o.setVisibility(0);
        this.f169742l.setVisibility(0);
        ExtensionsKt.gone(getMPlayButtonView());
        getMCoverImageView().setVisibility(4);
    L15:
        setPlayState(true);
        if (this.f169739i == true) goto L19;
        this.f169739i = true;
        this.f169749s.g(this.f169738h);
        this.f169749s.e(this.f169737g);
        return;
    L19:
        return;
    L11:
        if (this.f169731a == true) goto L13;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.e r103 = this.f169743m;
        r103.setVisibility(0);
        r103.setAlpha(1.0f);
        this.f169745o.setVisibility(0);
        this.f169742l.setVisibility(0);
        ExtensionsKt.gone(getMPlayButtonView());
        getMCoverImageView().setVisibility(4);
        goto L15
    L13:
        ExtensionsKt.gone(this.f169743m);
        ExtensionsKt.gone(this.f169745o);
        ExtensionsKt.gone(this.f169742l);
        ExtensionsKt.gone(getMPlayButtonView());
        ExtensionsKt.gone(getMCoverImageView());
        goto L15
    L5:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L7;
        r101 = true;
        goto L9
    }

    public final void d() {
        ExtensionsKt.gone(getMPlayButtonView());
    }

    public final void e() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L5;
    L12:
        setPlayState(false);
        return;
    L5:
        if (ViewCompat.isAttachedToWindow(this) == false) goto L10;
        if (HeadVideoAutoPlayController.f169727f == true) goto L12;
        postDelayed(this.f169744n, 200);
        goto L12
    L10:
        if (HeadVideoAutoPlayController.f169727f == true) goto L12;
        this.f169744n.run();
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f169740j == false) goto L5;
        return;
    L5:
        if (this.f169749s.i() == false) goto L9;
        this.f169740j = true;
        Lazy r100 = UIUtils.f45548a;
        UIUtils.f(this, AnonymousClass1.INSTANCE);
        return;
    }

    public static final void a(VideoCoverLayout r100) {
        r100.f169743m.setVisibility(0);
        r100.f169745o.setVisibility(0);
        r100.getMPlayButtonView().setVisibility(0);
    }

    public static final void b(VideoCoverLayout r100) {
        ExtensionsKt.gone(r100.f169743m);
        ExtensionsKt.gone(r100.f169745o);
        ExtensionsKt.gone(r100.f169742l);
        ExtensionsKt.gone(r100.getMPlayButtonView());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        int r100 = f169730u;
        int r101 = f169729t;
        float r102 = ((r100 - r101) * this.f169735e) + r101;
        int r103 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        float r104 = r102 + com.bytedance.android.ec.hybrid.list.util.c.d(12);
        if (this.f169734d.height() == r104) goto L5;
    L8:
        float r105 = getHeight() + com.bytedance.android.ec.hybrid.list.util.c.d(12);
        this.f169734d.set(0.0f, r105 - r104, getWidth(), r105);
        Paint r106 = this.f169733c;
        RectF r107 = this.f169734d;
        r106.setShader(new LinearGradient(0.0f, r107.top, 0.0f, r107.bottom, 0, 520093696, Shader.TileMode.CLAMP));
    L9:
        r110.drawRect(this.f169734d, this.f169733c);
        super.dispatchDraw(r110);
        return;
    L5:
        if (this.f169734d.width() != getWidth()) goto L8;
        if (this.f169734d.bottom == getBottom()) goto L9;
        goto L8
    }

    public final void f(boolean r100) {
        if (HeadVideoAutoPlayController.f169727f == false) goto L5;
        if (r100 == true) goto L5;
    L6:
        ExtensionsKt.gone(this.f169745o);
        this.f169745o.d(0.0f);
        ExtensionsKt.gone(this.f169742l);
        getMCoverImageView().setVisibility(0);
        setPlayState(false);
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r101 = this.f169741k;
        if (r101 == null) goto L10;
        r101.j0();
        return;
    L10:
        return;
    L5:
        ExtensionsKt.gone(this.f169743m);
        goto L6
    }

    public final void i(boolean r100) {
        if (r100 == false) goto L4;
        getMLoadingView().c();
        return;
    L4:
        getMLoadingView().a();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f169745o.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L11;
        if (this.f169745o.b(r100) == false) goto L11;
        return true;
    L11:
        return super.onTouchEvent(r100);
    L5:
        r101 = false;
        goto L6
    }

    public final void setAudioState(boolean r100) {
        this.f169743m.setAudioState(r100);
        this.f169738h = r100;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r101 = this.f169741k;
        if (r101 == null) goto L8;
        VideoCtrlContainerComponent r102 = r101.f166804c;
        if (r102 == null) goto L9;
        int r103 = VideoCtrlContainerComponent.f166794g;
        r102.c(0);
        return;
    L9:
        return;
    }

    public final void setPlayState(boolean r100) {
        this.f169743m.setPlayState(r100);
        this.f169737g = r100;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r101 = this.f169741k;
        if (r101 == null) goto L8;
        VideoCtrlContainerComponent r102 = r101.f166804c;
        if (r102 == null) goto L9;
        int r103 = VideoCtrlContainerComponent.f166794g;
        r102.c(0);
        return;
    L9:
        return;
    }

    public final void setProgress(float r100) {
        VideoProgressBar r101 = this.f169745o;
        r101.getClass();
        r101.f169761c = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r100, 1.0f), 0.0f);
        r101.invalidate();
        if (this.f169737g == false) goto L5;
    L7:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r102 = this.f169741k;
        if (r102 == null) goto L11;
        r102.m0(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r100, 1.0f), 0.0f), this.f169736f * 1000.0f);
        return;
    L11:
        return;
    L5:
        if (this.f169749s.isPlaying() == false) goto L7;
        g();
        goto L7
    }

    public final void setTotalDuration(int r100) {
        this.f169736f = r100 / 1000;
    }

    public VideoCoverLayout(final Context r110, f r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "callback");
        super(r110);
        this.f169749s = r111;
        this.f169732b = R.drawable.ec_shopping_anchor_v4_play_icon;
        Paint r100 = new Paint(1);
        r100.setStyle(Paint.Style.FILL);
        Unit r101 = Unit.INSTANCE;
        this.f169733c = r100;
        this.f169734d = new RectF();
        this.f169738h = true;
        VideoProgressTextLayout r102 = new VideoProgressTextLayout(r110, null);
        r102.setAlpha(0.0f);
        this.f169742l = r102;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.e r103 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.e(r110, new d(this));
        this.f169743m = r103;
        this.f169744n = new e(this);
        VideoProgressBar r104 = new VideoProgressBar(r110, null);
        int r105 = (int) 3858759679L;
        if (r111.j() == false) goto L5;
        int r112 = (int) 3439329279L;
        int r113 = 1291845631;
    L6:
        VideoProgressBar.a(r104, new a(this), false, null, null, r113, r112, 30);
        this.f169745o = r104;
        this.f169746p = LazyKt.lazy(new VideoCoverLayout$mLoadingView$2(r110));
        this.f169747q = LazyKt.lazy(new VideoCoverLayout$mPlayButtonView$2(this, r110));
        this.f169748r = LazyKt.lazy(new VideoCoverLayout$mCoverImageView$2(this, r110));
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L9;
        addView(getMCoverImageView());
        addView(getMPlayButtonView());
        addView(getMLoadingView());
    L9:
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(-2, -2);
        r114.leftMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r114.bottomMargin = com.bytedance.android.shopping.extensions.b.a(8);
        r114.rightMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r114.gravity = 80;
        addView(r104, r114);
        FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(-2, -2);
        r115.gravity = 81;
        r115.bottomMargin = com.bytedance.android.shopping.extensions.b.a(36);
        addView(r102, r115);
        FrameLayout.LayoutParams r116 = new FrameLayout.LayoutParams(-2, -2);
        if (r111.j() == false) goto L12;
        int r117 = 0;
    L13:
        r116.leftMargin = r117;
        r116.bottomMargin = com.bytedance.android.shopping.extensions.b.a(16);
        r116.gravity = 80;
        addView(r103, r116);
        setClipChildren(false);
        f(true);
        return;
    L12:
        r117 = com.bytedance.android.shopping.extensions.b.a(3);
        goto L13
    L5:
        r112 = r105;
        r113 = 1308622847;
        goto L6
    }

    public static void h(VideoCoverLayout r100, Integer r101) {
        Integer r102 = Integer.valueOf(R.drawable.ec_shopping_anchor_v4_play_icon);
        if (r102 == null) goto L5;
        r100.f169732b = r102.intValue();
        r100.getMPlayButtonView().setBackgroundResource(r100.f169732b);
    L5:
        if (r101 == null) goto L8;
        int r103 = r101.intValue();
        ImageView r104 = r100.getMPlayButtonView();
        ViewGroup.LayoutParams r105 = r100.getMPlayButtonView().getLayoutParams();
        r105.width = r103;
        r105.height = r103;
        Unit r106 = Unit.INSTANCE;
        r104.setLayoutParams(r105);
        return;
    }

    public final void c(ECUrlModel r210, final Function0<Unit> r211) {
        List<String> r100 = null;
        if (r210 == null) goto L5;
        List<String> r101 = r210.getUrlList();
    L6:
        if (r101 != null) goto L8;
    L10:
        ECDraweeView r102 = getMCoverImageView();
        if (r210 == null) goto L13;
        r100 = r210.getUrlList();
    L13:
        y.c(r102, r210, -1, -1, new z53.a(r100, ImagePosition.GOODS_HEADER.getValue(), new VideoCoverLayout$bindVideoCoverModel$4(this, r211), false, 24));
        return;
    L8:
        if ((!r101.isEmpty()) != true) goto L10;
        List<String> r103 = r101;
        ImageExtensionsKt.x(getMCoverImageView(), r103, null, null, null, null, null, null, new c(r101, r211, r101, ImagePosition.GOODS_HEADER.getValue(), new VideoCoverLayout$bindVideoCoverModel$2(this, r211)), false, null, VideoCoverLayout$bindVideoCoverModel$3.INSTANCE, null, 7038);
        return;
    L5:
        r101 = null;
        goto L6
    }
}
