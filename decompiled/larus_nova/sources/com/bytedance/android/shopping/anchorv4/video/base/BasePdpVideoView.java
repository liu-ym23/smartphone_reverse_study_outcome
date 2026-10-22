package com.bytedance.android.shopping.anchorv4.video.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.bytedance.android.shopping.api.video.d;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import fj.e;
import gj.b;
import gj.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import x73.a;
import x73.c;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0006\u0010\f\u001a\u00020\nJ\n\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/video/base/BasePdpVideoView;", "Landroid/widget/FrameLayout;", "Lfj/e;", "Lgj/i;", "", "Lx73/a;", "Lcom/bytedance/android/shopping/api/video/ScaleType;", "scaleType", "", "setScaleType", "", "getCurrentPosition", "getVideoDuration", "getPlayer", "Lx73/c;", "getSharePlayer", "Landroid/view/ViewParent;", "getParentView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BasePdpVideoView extends FrameLayout implements e, i, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AVScene f167543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f167544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y73.a f167545c;

    public BasePdpVideoView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BasePdpVideoView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // fj.e
    public final void B0() {
    }

    @Override // fj.e
    public final void H() {
    }

    @Override // fj.e
    public final void Q(float r100) {
    }

    @Override // fj.e
    public final void R2() {
    }

    @Override // fj.e
    public final void Z2() {
    }

    @Override // fj.e
    public final void e() {
    }

    @Override // x73.a
    public final void h(AVScene r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "avScene");
    }

    @Override // x73.a
    public final void j(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // x73.a
    public final void l(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // fj.e
    public final void m3(boolean r100) {
    }

    @Override // fj.e
    public final void y(boolean r100) {
    }

    @Override // x73.a
    public final long a() {
        y73.a r100 = this.f167545c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.a();
    }

    @Override // x73.a
    public int getCurrentPosition() {
        y73.a r100 = this.f167545c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getCurrentPosition();
    }

    @Override // x73.a
    public Object getPlayer() {
        y73.a r100 = this.f167545c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPlayer();
    }

    @Override // x73.a
    public c getSharePlayer() {
        y73.a r100 = this.f167545c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSharePlayer();
    }

    public final int getVideoDuration() {
        y73.a r100 = this.f167545c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.h();
    }

    @Override // x73.a
    public final boolean isMute() {
        y73.a r100 = this.f167545c;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isMute();
    }

    @Override // x73.a
    public final boolean isPlaying() {
        y73.a r100 = this.f167545c;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isPlaying() != true) goto L7;
        return true;
    }

    @Override // x73.a
    public final void onDestroy() {
        y73.a r100 = this.f167545c;
        if (r100 == null) goto L6;
        r100.onDestroy();
        return;
    }

    @Override // x73.a
    public final void onPause() {
        y73.a r100 = this.f167545c;
        if (r100 == null) goto L6;
        r100.onPause();
        return;
    }

    @Override // x73.a
    public final void onResume() {
        y73.a r100 = this.f167545c;
        if (r100 == null) goto L6;
        r100.onResume();
        return;
    }

    @Override // x73.a
    public final void pausePlay() {
        y73.a r100 = this.f167545c;
        if (r100 == null) goto L6;
        r100.pausePlay();
        return;
    }

    @Override // x73.a
    public final void release() {
        y73.a r100 = this.f167545c;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    @Override // x73.a
    public final void startPlay() {
        y73.a r100 = this.f167545c;
        if (r100 == null) goto L6;
        r100.startPlay();
        return;
    }

    @Override // x73.a
    public ViewParent getParentView() {
        return getParent();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f167544b == false) goto L6;
        release();
        return;
    }

    @Override // gj.i
    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        y73.a r101 = this.f167545c;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // x73.a
    public final void c(com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        y73.a r101 = this.f167545c;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // gj.i
    public final void d(b r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        y73.a r101 = this.f167545c;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // x73.a
    public final void g(com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        y73.a r101 = this.f167545c;
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    }

    @Override // x73.a
    public final void seek(float r100) {
        y73.a r101 = this.f167545c;
        if (r101 == null) goto L6;
        r101.seek(r100);
        return;
    }

    @Override // x73.a
    public void setScaleType(ScaleType r100) {
        Intrinsics.checkNotNullParameter(r100, "scaleType");
        y73.a r101 = this.f167545c;
        if (r101 == null) goto L6;
        r101.setScaleType(r100);
        return;
    }

    @Override // x73.a
    public final void f(boolean r100, boolean r101) {
        y73.a r102 = this.f167545c;
        if (r102 == null) goto L6;
        r102.f(r100, r101);
        return;
    }

    public BasePdpVideoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    @Override // x73.a
    public final void i(com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r100, d r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "playerOptions");
        if (this.f167543a == null) goto L12;
        y73.a r103 = this.f167545c;
        if (r103 == null) goto L7;
        r103.i(r100, r101);
    L7:
        y73.a r104 = this.f167545c;
        if (r104 == null) goto L13;
        r104.k(r102);
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("call configVideo first");
    }

    public /* synthetic */ BasePdpVideoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // x73.a
    public final void k(AVScene r100, boolean r101, a83.c r102, PlayAbilityCacheScene r103) {
        Intrinsics.checkNotNullParameter(r100, "avScene");
        Intrinsics.checkNotNullParameter(r102, "playerBridgeFactory");
        Intrinsics.checkNotNullParameter(r103, "abilityCacheScene");
        this.f167543a = r100;
        this.f167544b = r101;
        this.f167545c = r102.a(this, r100, r103);
    }
}
