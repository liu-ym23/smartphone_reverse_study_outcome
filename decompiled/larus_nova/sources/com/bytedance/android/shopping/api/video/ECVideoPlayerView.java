package com.bytedance.android.shopping.api.video;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010-\u001a\u0004\u0018\u00010&8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001d\u00103\u001a\u0004\u0018\u00010.8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/api/video/ECVideoPlayerView;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/shopping/api/video/i;", "", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "setTextureVGravity", "", "speed", "setSpeed", "", "getDuration", "getCurPosition", "getWatchedDuration", "Landroid/view/TextureView;", "getTextureView", "Landroid/view/Surface;", "getSurface", "getVideoHeight", "getVideoWidth", "", "getCurrentSimInfo", "b", "Lcom/bytedance/android/shopping/api/video/i;", "getPlayer", "()Lcom/bytedance/android/shopping/api/video/i;", "setPlayer", "(Lcom/bytedance/android/shopping/api/video/i;)V", "player", "Lcom/bytedance/android/shopping/api/video/c;", ce.f26391f, "Lcom/bytedance/android/shopping/api/video/c;", "getPlayHost", "()Lcom/bytedance/android/shopping/api/video/c;", "setPlayHost", "(Lcom/bytedance/android/shopping/api/video/c;)V", "playHost", "Lcom/bytedance/android/shopping/api/video/e;", "h", "Lcom/bytedance/android/shopping/api/video/e;", "getVideoModel", "()Lcom/bytedance/android/shopping/api/video/e;", "setVideoModel", "(Lcom/bytedance/android/shopping/api/video/e;)V", "videoModel", "Lcom/bytedance/android/shopping/api/video/j;", ce.f26395j, "Lkotlin/Lazy;", "getVideoViewHelper", "()Lcom/bytedance/android/shopping/api/video/j;", "videoViewHelper", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECVideoPlayerView extends FrameLayout implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s83.f f170617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f170618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScaleType f170619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f170620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f170621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f170622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f170623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f170624h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l f170625i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f170626j;

    public static final class a implements h {
        public a(WeakReference<ECVideoPlayerView> r100) {
            Intrinsics.checkNotNullParameter(r100, "viewWeakRef");
        }
    }

    public static final class b implements h {
        public b() {
        }
    }

    public ECVideoPlayerView(Context r100) {
        this(r100, null, 0, null, 14);
    }

    public ECVideoPlayerView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, null, 12);
    }

    public ECVideoPlayerView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, null, 8);
    }

    public final j getVideoViewHelper() {
        return (j) this.f170626j.getValue();
    }

    public final void c() {
        if (this.f170618b == null) goto L5;
        return;
    L5:
        s83.f r100 = this.f170617a;
        if (r100 == null) goto L11;
        l r101 = this.f170625i;
        if (r101 != null) goto L10;
        r101 = new l(null, false, false, false, null, false, false, 255);
    L10:
        r100.d(r101);
    L11:
        this.f170618b = null;
    }

    public final boolean d() {
        i r100 = this.f170618b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return ((ECVideoPlayerView) r100).d();
    }

    public final boolean e() {
        i r100 = this.f170618b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return ((ECVideoPlayerView) r100).e();
    }

    public final boolean f() {
        i r100 = this.f170618b;
        if (r100 != null) goto L7;
        return true;
    L7:
        return ((ECVideoPlayerView) r100).f();
    }

    public final boolean g() {
        i r100 = this.f170618b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return ((ECVideoPlayerView) r100).g();
    }

    @Override // com.bytedance.android.shopping.api.video.i
    public long getCurPosition() {
        i r100 = this.f170618b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getCurPosition();
    }

    @Override // com.bytedance.android.shopping.api.video.i
    public String getCurrentSimInfo() {
        i r100 = this.f170618b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentSimInfo();
    }

    @Override // com.bytedance.android.shopping.api.video.i
    public long getDuration() {
        i r100 = this.f170618b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getDuration();
    }

    @Override // com.bytedance.android.shopping.api.video.i
    public int getVideoHeight() {
        i r100 = this.f170618b;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getVideoHeight();
    }

    @Override // com.bytedance.android.shopping.api.video.i
    public int getVideoWidth() {
        i r100 = this.f170618b;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getVideoWidth();
    }

    @Override // com.bytedance.android.shopping.api.video.i
    public long getWatchedDuration() {
        i r100 = this.f170618b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getWatchedDuration();
    }

    public final boolean h() {
        i r100 = this.f170618b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return ((ECVideoPlayerView) r100).h();
    }

    public final boolean i() {
        i r100 = this.f170618b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return ((ECVideoPlayerView) r100).i();
    }

    public final void m() {
        i r100 = this.f170618b;
        if (r100 == null) goto L6;
        ((ECVideoPlayerView) r100).m();
        return;
    }

    public final void p() {
        i r100 = this.f170618b;
        if (r100 == null) goto L6;
        ((ECVideoPlayerView) r100).p();
        return;
    }

    public final void q() {
        i r100 = this.f170618b;
        if (r100 == null) goto L6;
        ((ECVideoPlayerView) r100).q();
        return;
    }

    public final void s() {
        i r100 = this.f170618b;
        if (r100 == null) goto L5;
        ((ECVideoPlayerView) r100).s();
    L5:
        this.f170618b = null;
    }

    public final void u() {
        i r100 = this.f170618b;
        if (r100 == null) goto L6;
        ((ECVideoPlayerView) r100).u();
        return;
    }

    public final void x() {
        i r100 = this.f170618b;
        if (r100 == null) goto L6;
        ((ECVideoPlayerView) r100).x();
        return;
    }

    public Surface getSurface() {
        j r100 = getVideoViewHelper();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSurface();
    }

    public TextureView getTextureView() {
        j r100 = getVideoViewHelper();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    public final boolean n() {
        c();
        i r100 = this.f170618b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return ((ECVideoPlayerView) r100).n();
    }

    public final c getPlayHost() {
        return this.f170623g;
    }

    public final i getPlayer() {
        return this.f170618b;
    }

    public final e getVideoModel() {
        return this.f170624h;
    }

    public final void a(i r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        this.f170618b = r100;
        c r101 = this.f170623g;
        if (r101 == null) goto L8;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNullParameter(r101, "host");
        Intrinsics.checkNotNullParameter(r101, "host");
    L6:
        l(r100.getVideoHeight(), r100.getVideoWidth());
        return;
    }

    public final void b(e r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        c();
        i r101 = this.f170618b;
        if (r101 == null) goto L5;
        ((ECVideoPlayerView) r101).b(r100);
    L5:
        l(r100.f170659j, r100.f170660k);
        this.f170624h = r100;
    }

    public final void j(boolean r100) {
        i r101 = this.f170618b;
        if (r101 == null) goto L6;
        ((ECVideoPlayerView) r101).j(r100);
        return;
    }

    public final void k(boolean r100) {
        i r101 = this.f170618b;
        if (r101 == null) goto L5;
        ((ECVideoPlayerView) r101).k(r100);
    L5:
        e r102 = this.f170624h;
        if (r102 == null) goto L11;
        d r103 = r102.f170655f;
        if (r103 == null) goto L12;
        r103.f170641a = r100;
        return;
    L12:
        return;
    }

    public final void o(int r100) {
        i r101 = this.f170618b;
        if (r101 == null) goto L6;
        ((ECVideoPlayerView) r101).o(r100);
        return;
    }

    public final void r(h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        c();
        i r101 = this.f170618b;
        if (r101 == null) goto L6;
        ((ECVideoPlayerView) r101).r(r100);
        return;
    }

    public final void setPlayHost(c r100) {
        this.f170623g = r100;
    }

    public final void setPlayer(i r100) {
        this.f170618b = r100;
    }

    @Override // com.bytedance.android.shopping.api.video.i
    public void setSpeed(float r100) {
        i r101 = this.f170618b;
        if (r101 == null) goto L6;
        r101.setSpeed(r100);
        return;
    }

    public void setTextureVGravity(int r100) {
        if (r100 <= 0) goto L5;
        this.f170620d = r100;
        requestLayout();
        return;
    }

    public final void setVideoModel(e r100) {
        this.f170624h = r100;
    }

    public final void t(h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        i r101 = this.f170618b;
        if (r101 == null) goto L6;
        ((ECVideoPlayerView) r101).t(r100);
        return;
    }

    public final void v(float r100) {
        i r101 = this.f170618b;
        if (r101 == null) goto L6;
        ((ECVideoPlayerView) r101).v(r100);
        return;
    }

    public final void w(ScaleType r100) {
        Intrinsics.checkNotNullParameter(r100, "scaleType");
        if (this.f170619c == r100) goto L9;
        this.f170619c = r100;
        j r101 = getVideoViewHelper();
        if (r101 == null) goto L7;
        r101.f();
    L7:
        requestLayout();
        return;
    }

    public final void l(int r100, int r101) {
        if (r100 <= 0) goto L14;
        if (r101 > 0) goto L6;
        return;
    L6:
        if (this.f170622f == r101) goto L8;
    L9:
        this.f170621e = r100;
        this.f170622f = r101;
        j r102 = getVideoViewHelper();
        if (r102 == null) goto L12;
        r102.e();
    L12:
        requestLayout();
        return;
    L8:
        if (this.f170621e != r100) goto L9;
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        j r102 = getVideoViewHelper();
        if (r102 == null) goto L12;
        getMeasuredWidth();
        getMeasuredHeight();
        Pair r103 = r102.d();
        if (r103 == null) goto L13;
        int r104 = View.MeasureSpec.makeMeasureSpec(((Number) r103.getFirst()).intValue(), 1073741824);
        int r105 = View.MeasureSpec.makeMeasureSpec(((Number) r103.getSecond()).intValue(), 1073741824);
        View r106 = getChildAt(0);
        if (r106 != null) goto L10;
        return;
    L10:
        measureChild(r106, r104 + 0, r105 + 0);
        return;
    L13:
        return;
    }

    public ECVideoPlayerView(Context r110, AttributeSet r111, int r112, l r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        boolean r114 = ECServiceManager.f42805a;
        this.f170617a = ((s83.g) ECServiceManager.c(s83.g.class)).p();
        this.f170619c = ScaleType.CENTER_CROP;
        this.f170620d = 17;
        this.f170621e = -1;
        this.f170622f = -1;
        this.f170626j = LazyKt.lazy(new ECVideoPlayerView$videoViewHelper$2(this));
        s83.a r115 = ((s83.g) ECServiceManager.c(s83.g.class)).q();
        if (r115 != null) goto L5;
    L7:
        new b();
    L8:
        if (r111 == null) goto L39;
        TypedArray r116 = r110.obtainStyledAttributes(r111, new int[]{R.attr.adaptVideoSizeChange, R.attr.delayInitPlayer, R.attr.enablePlayerPool, R.attr.enableStopReleaseHelper, R.attr.keepScreenOnPlaying, R.attr.playerSceneName, R.attr.videoBitrateSelectStrategy});
        int r117 = l.f170671i;
        if (r116 != null) goto L12;
        l r118 = new l(null, false, false, false, null, false, false, 255);
    L35:
        this.f170625i = r118;
        boolean r119 = r118.f170673b;
        this.f170623g = new c(this);
        if (r119 == true) goto L38;
        c();
    L38:
        r116.recycle();
    L44:
        j r120 = getVideoViewHelper();
        if (r120 == null) goto L52;
        SelectBitrateResolutionStrategy r121 = SelectBitrateResolutionStrategy.DEFAULT;
        r120.c();
        return;
    L52:
        return;
    L12:
        String r122 = r116.getString(5);
        AVScene.Companion.getClass();
        if (r122 != null) goto L15;
        AVScene r123 = AVScene.CONTENT_DEFAULT;
    L30:
        AVScene r100 = r123;
    L31:
        boolean r101 = r116.getBoolean(2, false);
        boolean r102 = r116.getBoolean(1, false);
        boolean r103 = r116.getBoolean(3, false);
        int r124 = r116.getInteger(6, 0);
        SelectBitrateResolutionStrategy.Companion.getClass();
        SelectBitrateResolutionStrategy r125 = (SelectBitrateResolutionStrategy) SelectBitrateResolutionStrategy.access$getMap$cp().get(Integer.valueOf(r124));
        if (r125 != null) goto L34;
        r125 = SelectBitrateResolutionStrategy.DEFAULT;
    L34:
        r118 = new l(r100, r102, r101, r103, r125, r116.getBoolean(4, false), r116.getBoolean(0, false), 8);
        goto L35
    L15:
        List r126 = StringsKt.split$default(r122, new char[]{'#'}, false, 0, 6, null);
        String r104 = (String) CollectionsKt.firstOrNull(r126);
        if (r104 != null) goto L18;
        r123 = AVScene.CONTENT_DEFAULT;
        goto L30
    L18:
        String r127 = (String) CollectionsKt.getOrNull(r126, 1);
        if (r127 != null) goto L21;
        r123 = AVScene.CONTENT_DEFAULT;
        goto L30
    L21:
        AVScene[] r105 = AVScene.values();
        int r106 = r105.length;
        int r107 = 0;
    L22:
        if (r107 >= r106) goto L29;
        AVScene r108 = r105[r107];
        if (Intrinsics.areEqual(r108.getTag(), r104) == false) goto L28;
        if (Intrinsics.areEqual(r108.getSubTag(), r127) == false) goto L28;
        r100 = r108;
    L28:
        r107 = r107 + 1;
        goto L22
    L29:
        int r128 = ye.a.f567357a;
        ye.a.a("AVScene#stringConvert2AVScene fail, can't parse AVScene from XML: ".concat(r122));
        r123 = AVScene.CONTENT_DEFAULT;
        goto L30
    L39:
        if (r113 != null) goto L41;
        r113 = new l(null, false, false, false, null, false, false, 255);
    L41:
        this.f170625i = r113;
        boolean r129 = r113.f170673b;
        this.f170623g = new c(this);
        if (r129 == true) goto L44;
        c();
        goto L44
    L5:
        if (r115.f() != true) goto L7;
        new a(new WeakReference(this));
        goto L8
    }

    public /* synthetic */ ECVideoPlayerView(Context r100, AttributeSet r101, int r102, l r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this(r100, r101, r102, r103);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        View r105 = getChildAt(0);
        if (r105 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof FrameLayout.LayoutParams) == true) goto L8;
        r106 = null;
    L8:
        FrameLayout.LayoutParams r107 = (FrameLayout.LayoutParams) r106;
        if (r107 == null) goto L11;
        r107.gravity = this.f170620d;
    L11:
        super.onLayout(r100, r101, r102, r103, r104);
        j r108 = getVideoViewHelper();
        if (r108 == null) goto L15;
        r108.b();
        return;
    }
}
