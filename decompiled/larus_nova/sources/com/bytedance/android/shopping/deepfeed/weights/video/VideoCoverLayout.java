package com.bytedance.android.shopping.deepfeed.weights.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.infeed.data.idl.HeaderBannerItemType;
import com.bytedance.android.shopping.inflow.cardui.product.header.indicator.ProductCardProgressIndicator;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001!B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/video/VideoCoverLayout;", "Landroid/widget/FrameLayout;", "", "isMute", "", "setAudioState", "isPlaying", "setPlayState", "", "duration", "setTotalDuration", "Lfd3/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lfd3/b;", "getCallback", "()Lfd3/b;", "setCallback", "(Lfd3/b;)V", "callback", "Lcom/bytedance/android/shopping/inflow/cardui/product/header/indicator/ProductCardProgressIndicator;", ce.f26391f, "Lcom/bytedance/android/shopping/inflow/cardui/product/header/indicator/ProductCardProgressIndicator;", "getProgressIndicator", "()Lcom/bytedance/android/shopping/inflow/cardui/product/header/indicator/ProductCardProgressIndicator;", "progressIndicator", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoCoverLayout extends FrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f174247m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f174248n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fd3.b f174249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f174250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f174251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f174252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f174253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final VideoProgressTextLayout f174254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProductCardProgressIndicator f174255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HeaderBannerItemType f174256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HeaderBannerItemType f174257i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f174258j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final VideoProgressBar f174259k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f174260l;

    public static final class a implements fd3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoCoverLayout f174261a;

        @Override // fd3.a
        public final void onDragEnd() {
            VideoCoverLayout r100 = this.f174261a;
            int r101 = VideoCoverLayout.f174247m;
            if (r100.a() == false) goto L5;
            r100.f174255g.setVisibility(0);
            r100.f174259k.setVisibility(4);
        L5:
            fd3.b r102 = r100.f174249a;
            if (r102 == null) goto L9;
            r102.b();
            return;
        }

        @Override // fd3.a
        public final void onDragStart() {
            VideoCoverLayout r100 = this.f174261a;
            int r101 = VideoCoverLayout.f174247m;
            if (r100.a() == false) goto L5;
            r100.f174255g.setVisibility(4);
            r100.f174259k.setVisibility(0);
        L5:
            fd3.b r102 = r100.f174249a;
            if (r102 == null) goto L8;
            r102.c();
        L8:
            float r103 = r100.f174259k.getDragProgress();
            VideoProgressTextLayout r104 = r100.f174254f;
            int r105 = r100.f174253e;
            r104.f174281a.setText(VideoProgressTextLayout.a((int) (r103 * r105)));
            r104.f174282b.setText(VideoProgressTextLayout.a(r105));
        }

        public a(VideoCoverLayout r100) {
            this.f174261a = r100;
        }

        @Override // fd3.a
        public final void a(float r100) {
            fd3.b r101 = this.f174261a.getCallback();
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }

        @Override // fd3.a
        public final void b(float r100) {
            VideoCoverLayout r101 = this.f174261a;
            int r102 = VideoCoverLayout.f174247m;
            VideoProgressTextLayout r103 = r101.f174254f;
            int r104 = r101.f174253e;
            r103.f174281a.setText(VideoProgressTextLayout.a((int) (r100 * r104)));
            r103.f174282b.setText(VideoProgressTextLayout.a(r104));
        }

        @Override // fd3.a
        public final void c(float r100) {
            VideoCoverLayout r101 = this.f174261a;
            r101.f174252d = r100;
            r101.f174254f.setAlpha(r100);
            this.f174261a.invalidate();
        }
    }

    public static final class b {
    }

    public VideoCoverLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VideoCoverLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setAudioState(boolean r100) {
    }

    public final void setPlayState(boolean r100) {
    }

    static {
        f174247m = com.bytedance.android.shopping.extensions.b.a(60);
        f174248n = com.bytedance.android.shopping.extensions.b.a(110);
    }

    public final boolean a() {
        if (this.f174256h != HeaderBannerItemType.VideoAndImage) goto L5;
        return true;
    L5:
        return false;
    }

    public final fd3.b getCallback() {
        return this.f174249a;
    }

    public final ProductCardProgressIndicator getProgressIndicator() {
        return this.f174255g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        int r100 = f174248n;
        int r101 = f174247m;
        float r102 = ((r100 - r101) * this.f174252d) + r101;
        int r103 = c.f47296a;
        float r104 = r102 + c.d(12);
        if (this.f174251c.height() == r104) goto L5;
    L8:
        float r105 = getHeight() + c.d(12);
        this.f174251c.set(0.0f, r105 - r104, getWidth(), r105);
        Paint r106 = this.f174250b;
        RectF r107 = this.f174251c;
        r106.setShader(new LinearGradient(0.0f, r107.top, 0.0f, r107.bottom, 0, 520093696, Shader.TileMode.CLAMP));
    L9:
        r110.drawRect(this.f174251c, this.f174250b);
        super.dispatchDraw(r110);
        return;
    L5:
        if (this.f174251c.width() != getWidth()) goto L8;
        if (this.f174251c.bottom == getBottom()) goto L9;
        goto L8
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f174258j == false) goto L12;
        if (a() == false) goto L12;
        if (this.f174257i != HeaderBannerItemType.CoverVideo) goto L12;
        if (this.f174259k.a(r100) == false) goto L12;
        return true;
    L12:
        if (this.f174259k.getVisibility() != 0) goto L14;
        boolean r101 = true;
    L15:
        if (r101 == false) goto L20;
        if (this.f174259k.a(r100) == false) goto L20;
        return true;
    L20:
        return super.onTouchEvent(r100);
    L14:
        r101 = false;
        goto L15
    }

    public final void setCallback(fd3.b r100) {
        this.f174249a = r100;
    }

    public final void setTotalDuration(long r100) {
        this.f174253e = (int) (r100 / ((long) 1000));
    }

    public final void b(float r100, boolean r101) {
        if (a() == true) goto L5;
        VideoProgressBar r102 = this.f174259k;
        r102.getClass();
        r102.f174268c = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r100, 1.0f), 0.0f);
        r102.invalidate();
        return;
    L5:
        if (r101 == false) goto L7;
        this.f174255g.setFillCurrent(false);
    L7:
        this.f174255g.b(0, r100);
    }

    public final void c(HeaderBannerItemType r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f174256h = r100;
        if (r100 != HeaderBannerItemType.VideoAndImage) goto L6;
        this.f174255g.setup(r101);
        this.f174255g.b(0, 0.0f);
    L6:
        if (this.f174256h != HeaderBannerItemType.CoverVideo) goto L8;
        this.f174259k.setVisibility(0);
        this.f174255g.setVisibility(4);
        return;
    L8:
        this.f174259k.setVisibility(4);
        this.f174255g.setVisibility(0);
    }

    public VideoCoverLayout(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        Paint r102 = new Paint(1);
        r102.setStyle(Paint.Style.FILL);
        Unit r111 = Unit.INSTANCE;
        this.f174250b = r102;
        this.f174251c = new RectF();
        VideoProgressTextLayout r103 = new VideoProgressTextLayout(r100, null, 6, 0);
        r103.setAlpha(0.0f);
        this.f174254f = r103;
        ProductCardProgressIndicator r104 = new ProductCardProgressIndicator(r100, null, 6, 0);
        this.f174255g = r104;
        HeaderBannerItemType r105 = HeaderBannerItemType.CoverVideo;
        this.f174256h = r105;
        this.f174257i = r105;
        VideoProgressBar r106 = new VideoProgressBar(r100, null, 4, 0);
        a r107 = new a(this);
        Intrinsics.checkNotNullParameter(r107, "callback");
        r106.f174275j = r107;
        r106.f174276k = false;
        r106.f174277l = null;
        this.f174259k = r106;
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-2, -2);
        r108.leftMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r108.rightMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r108.gravity = 80;
        addView(r106, r108);
        int r109 = c.f47296a;
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-2, c.d(2));
        r112.leftMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r112.rightMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r112.gravity = 80;
        addView(r104, r112);
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(-2, -2);
        r113.gravity = 81;
        r113.bottomMargin = c.d(70);
        addView(r103, r113);
        setClipChildren(false);
        ExtensionsKt.gone(r106);
        r106.c(0.0f);
        ExtensionsKt.gone(r103);
        setPlayState(false);
    }

    public /* synthetic */ VideoCoverLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
