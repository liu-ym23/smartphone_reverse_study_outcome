package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f174143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECVideoPlayerView f174144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f174145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f174146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f174147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function3<? super Long, ? super Long, ? super Long, Unit> f174148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f174149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f174150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f174151i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f174152j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f174153k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f174154l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.ec.core.imagex.r f174155m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f174156n;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ECVideoPlayerView r100 = this.f174144b;
        if (r100 == null) goto L5;
        r100.x();
    L5:
        this.f174147e.setVisibility(8);
    }

    public final SimpleDraweeView getBlurView() {
        return this.f174145c;
    }

    public final Integer getCardIndex() {
        return this.f174156n;
    }

    public final SimpleDraweeView getCoverView() {
        return this.f174146d;
    }

    public final com.bytedance.android.ec.core.imagex.r getImageCallerContext() {
        return this.f174155m;
    }

    public final ViewGroup getVideoContainer() {
        return this.f174143a;
    }

    public final ImageView getVideoPauseIcon() {
        return this.f174147e;
    }

    public final ECVideoPlayerView getVideoPlayerView() {
        return this.f174144b;
    }

    public final void a(int r100) {
        ViewGroup.LayoutParams r101 = this.f174146d.getLayoutParams();
        ViewGroup.LayoutParams r102 = null;
        if ((r101 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r101 = null;
    L5:
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r101;
        if (r103 == null) goto L8;
        r103.topMargin = r100;
        this.f174146d.setLayoutParams(r103);
    L8:
        ViewGroup.LayoutParams r104 = this.f174143a.getLayoutParams();
        if ((r104 instanceof FrameLayout.LayoutParams) == false) goto L12;
        r102 = r104;
    L12:
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r102;
        if (r105 == null) goto L16;
        r105.topMargin = r100;
        this.f174143a.setLayoutParams(r105);
        return;
    }

    public final void setCloseTop(boolean r100) {
        if (r100 == false) goto L4;
        a(-com.bytedance.android.shopping.extensions.b.b(8));
        return;
    L4:
        a(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(this.f174154l)));
    }

    public final void setPlayCompleteListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f174149g = r100;
    }

    public final void setPlayListener(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f174150h = r100;
    }

    public final void setPlayProgressListener(Function3<? super Long, ? super Long, ? super Long, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f174148f = r100;
    }

    public final void setVideoPlayerView(ECVideoPlayerView r100) {
        this.f174144b = r100;
    }

    public c(Context r100, com.bytedance.android.ec.core.imagex.r r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f174155m = r101;
        this.f174156n = r102;
        this.f174154l = 150;
        FrameLayout.inflate(r100, R.layout.shopping_deepfeed_product_banner_video, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f174145c = (SimpleDraweeView) findViewById(R.id.blur_iv);
        this.f174146d = (SimpleDraweeView) findViewById(R.id.content_iv);
        this.f174143a = (ViewGroup) findViewById(R.id.video_container);
        ImageView r103 = new ImageView(r100);
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(80), com.bytedance.android.shopping.extensions.b.b(80));
        r104.gravity = 17;
        Unit r105 = Unit.INSTANCE;
        r103.setLayoutParams(r104);
        r103.setVisibility(8);
        r103.setImageResource(R.drawable.shopping_deepfeed_video_pause_icon);
        this.f174147e = r103;
    }
}
