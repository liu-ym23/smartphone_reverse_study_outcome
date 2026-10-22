package com.bytedance.android.shopping.widget.ecvideoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.utils.Error;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001'B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\n¢\u0006\u0004\b%\u0010&J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rR*\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/b;", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;", "ecVideoPlayer", "", "setPlayer", "getPlayer", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getCoverView", "", "resourceId", "setCoverResourceId", "", "imgUrl", "setCoverUrl", "value", "d", "I", "getScaleType", "()I", "setScaleType", "(I)V", "scaleType", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/e;", "f", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/e;", "getOnVideoViewListener", "()Lcom/bytedance/android/shopping/widget/ecvideoplayer/e;", "setOnVideoViewListener", "(Lcom/bytedance/android/shopping/widget/ecvideoplayer/e;)V", "onVideoViewListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECVideoView extends FrameLayout implements b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f187372h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextureRender f187373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECVideoPlayer f187374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<g> f187375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f187376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f187377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f187378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f187379g;

    public static final class a {
    }

    static {
    }

    public ECVideoView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECVideoView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void E() {
        e r100 = this.f187378f;
        if (r100 == null) goto L5;
        r100.E();
    L5:
        Iterator<T> r101 = this.f187375c.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((g) r101.next()).E();
        goto L7
    }

    public final void a() {
        this.f187377e.setVisibility(8);
        this.f187379g.setVisibility(8);
        e r100 = this.f187378f;
        if (r100 == null) goto L5;
        r100.T(8);
    L5:
        Iterator<T> r101 = this.f187375c.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((g) r101.next()).T(8);
        goto L7
    }

    public final void b() {
        if (this.f187374b != null) goto L5;
        return;
    L5:
        int r100 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        StringBuilder r101 = new StringBuilder("Remove PlayerTaskExecutor");
        ECVideoPlayer r102 = this.f187374b;
        if (r102 == null) goto L8;
        k r103 = r102.f187338b;
    L9:
        if (r103 == null) goto L11;
        int r104 = r103.hashCode();
    L12:
        r101.append(r104);
        r101.append(" ECVideoView");
        r101.append(hashCode());
        r101.append(" playerStatus=");
        int r105 = ECVideoPlayer.f187336r;
        ECVideoPlayer r106 = this.f187374b;
        Intrinsics.checkNotNull(r106);
        r101.append(ECVideoPlayer.a.a(r106.f187343g.f187406d));
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a(r101.toString());
        TextureRender r107 = this.f187373a;
        ECVideoPlayer r108 = r107.f187388b;
        if (r108 == null) goto L15;
        r108.i();
    L15:
        r107.f187388b = null;
        ECVideoPlayer r109 = this.f187374b;
        if (r109 == null) goto L18;
        r109.m(this);
    L18:
        ECVideoPlayer r110 = this.f187374b;
        if (r110 == null) goto L27;
        e r111 = this.f187378f;
        if (r111 == null) goto L23;
        r111.m0(r110);
    L23:
        Iterator<T> r112 = this.f187375c.iterator();
    L25:
        if (r112.hasNext() == false) goto L27;
        ((g) r112.next()).m0(r110);
    L27:
        this.f187374b = null;
        int r113 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("ShowMaskAndCover ECVideoView" + hashCode() + " due to removePlayer");
        c();
        return;
    L11:
        r104 = 0;
        goto L12
    L8:
        r103 = null;
        goto L9
    }

    public final void c() {
        this.f187379g.setVisibility(0);
        this.f187377e.setVisibility(0);
        e r100 = this.f187378f;
        if (r100 == null) goto L5;
        r100.T(0);
    L5:
        Iterator<T> r101 = this.f187375c.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((g) r101.next()).T(0);
        goto L7
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void g() {
        e r100 = this.f187378f;
        if (r100 == null) goto L5;
        r100.g();
    L5:
        Iterator<T> r101 = this.f187375c.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((g) r101.next()).g();
        goto L7
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onIdle() {
        int r100 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("ShowMaskAndCover ECVideoView" + hashCode() + " due to onIdle");
        c();
        e r101 = this.f187378f;
        if (r101 == null) goto L5;
        r101.onIdle();
    L5:
        Iterator<T> r102 = this.f187375c.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((g) r102.next()).onIdle();
        goto L7
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onPaused() {
        e r100 = this.f187378f;
        if (r100 == null) goto L5;
        r100.onPaused();
    L5:
        Iterator<T> r101 = this.f187375c.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((g) r101.next()).onPaused();
        goto L7
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onPlaying() {
        e r100 = this.f187378f;
        if (r100 == null) goto L5;
        r100.onPlaying();
    L5:
        Iterator<T> r101 = this.f187375c.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((g) r101.next()).onPlaying();
        goto L7
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onRenderStart() {
        int r100 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("HideMaskAndCover ECVideoView" + hashCode() + " due to onRenderStart");
        a();
        e r101 = this.f187378f;
        if (r101 == null) goto L6;
        r101.onRenderStart();
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void w() {
        e r100 = this.f187378f;
        if (r100 == null) goto L5;
        r100.w();
    L5:
        Iterator<T> r101 = this.f187375c.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((g) r101.next()).w();
        goto L7
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onRelease() {
        b();
        e r100 = this.f187378f;
        if (r100 == null) goto L5;
        r100.onRelease();
    L5:
        Iterator<T> r101 = this.f187375c.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((g) r101.next()).onRelease();
        goto L7
    }

    public final SimpleDraweeView getCoverView() {
        return this.f187377e;
    }

    public final e getOnVideoViewListener() {
        return this.f187378f;
    }

    public final ECVideoPlayer getPlayer() {
        return this.f187374b;
    }

    public final int getScaleType() {
        return this.f187376d;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onError(Error r100) {
        e r101 = this.f187378f;
        if (r101 == null) goto L5;
        r101.onError(r100);
    L5:
        Iterator<T> r102 = this.f187375c.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((g) r102.next()).onError(r100);
        goto L7
    }

    public final void setCoverResourceId(int r100) {
        this.f187377e.setVisibility(0);
        this.f187377e.setActualImageResource(r100);
    }

    public final void setCoverUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "imgUrl");
        this.f187377e.setVisibility(0);
        this.f187377e.setImageURI(r100);
    }

    public final void setOnVideoViewListener(e r100) {
        this.f187378f = r100;
    }

    public final void setPlayer(ECVideoPlayer r100) {
        Intrinsics.checkNotNullParameter(r100, "ecVideoPlayer");
        if (this.f187374b != null) goto L46;
        int r101 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        StringBuilder r102 = new StringBuilder("SetPlayer PlayerTaskExecutor");
        r102.append(r100.f187338b.hashCode());
        r102.append(" ECVideoView");
        r102.append(hashCode());
        r102.append(" playerStatus=");
        int r103 = ECVideoPlayer.f187336r;
        r102.append(ECVideoPlayer.a.a(r100.f187343g.f187406d));
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a(r102.toString());
        this.f187374b = r100;
        this.f187373a.setPlayer(r100);
        ECVideoPlayer r104 = this.f187374b;
        if (r104 == null) goto L7;
        r104.a(this);
    L7:
        boolean r105 = true;
        if (r100.e() == false) goto L10;
    L14:
        k r106 = r100.f187338b;
        Object r107 = r106.f187414f;
        monitor-enter(r107);
        j r108 = r106.f187415g;     // Catch: Throwable -> L42
        if (r108 != null) goto L19;
    L22:
        Iterator<T> r109 = r106.f187412d.iterator();     // Catch: Throwable -> L42
    L24:
        if (r109.hasNext() == false) goto L29;
        if (((j) r109.next()).getType() != 2) goto L24;
        monitor-exit(r107);
    L32:
        if (r105 == true) goto L34;
        int r110 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
        com.bytedance.android.shopping.widget.ecvideoplayer.a.a("HideMaskAndCover ECVideoView" + hashCode() + " due to setPlayer");
        a();
    L34:
        e r111 = this.f187378f;
        if (r111 == null) goto L37;
        r111.U2(r100);
    L37:
        Iterator<T> r112 = this.f187375c.iterator();
    L39:
        if (r112.hasNext() == false) goto L41;
        ((g) r112.next()).U2(r100);
        goto L39
    L41:
        return;
    L29:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(r107);
        r105 = false;
        goto L32
    L19:
        if (r108.getType() != 2) goto L22;
        monitor-exit(r107);
    L42:
        th = move-exception;
        throw th;
    L10:
        if (r100.f187343g.f187406d != 4) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == false) goto L34;
    L12:
        r114 = false;
        goto L13
    L46:
        throw new IllegalStateException("ECVideoView already has player");
    }

    public final void setScaleType(int r100) {
        if (this.f187376d == r100) goto L12;
        if (r100 != 0) goto L6;
        this.f187377e.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    L10:
        this.f187373a.setScaleType(r100);
        this.f187376d = r100;
        return;
    L6:
        if (r100 != 1) goto L10;
        this.f187377e.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        goto L10
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void h(int r100, int r101) {
        e r102 = this.f187378f;
        if (r102 == null) goto L5;
        r102.h(r100, r101);
    L5:
        Iterator<T> r103 = this.f187375c.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        ((g) r103.next()).h(r100, r101);
        goto L7
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onVideoSizeChanged(int r100, int r101) {
        l r102 = this.f187373a.f187392f;
        if (r102.f187419b == r101) goto L5;
    L6:
        r102.f187419b = r101;
        r102.f187418a = r100;
        r102.f187420c.requestLayout();
        return;
    L5:
        if (r102.f187418a != r100) goto L6;
    }

    public ECVideoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        AttributeSet r103 = null;
        TextureRender r104 = new TextureRender(r100, r103, 6, 0);
        this.f187373a = r104;
        this.f187375c = new LinkedList();
        this.f187376d = 1;
        SimpleDraweeView r105 = new SimpleDraweeView(r100);
        this.f187377e = r105;
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-1, -1);
        r106.gravity = 17;
        Unit r107 = Unit.INSTANCE;
        r104.setLayoutParams(r106);
        addView(r104);
        setScaleType(1);
        View r108 = new View(r100);
        this.f187379g = r108;
        addView(r108, -1, -1);
        r108.setBackgroundColor(-16777216);
        addView(r105, -1, -1);
    }

    public /* synthetic */ ECVideoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
