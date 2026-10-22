package com.bytedance.android.shopping.anchorv4.video.base.bridge;

import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.anchorv4.video.base.abs.AbsPdpBasePlayerBridge;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.d;
import com.bytedance.android.shopping.api.video.i;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import fj.e;
import gj.b;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import x73.c;
import z73.a;

/* JADX INFO: loaded from: classes12.dex */
public final class HeadVideoPlayerBridge extends AbsPdpBasePlayerBridge implements e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f167560m = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f167561k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0<Unit> f167562l;

    @Override // fj.e
    public final void R2() {
    }

    @Override // y73.f
    public final long a() {
        return 0;
    }

    @Override // y73.d
    public final void onPause() {
        this.f167561k = false;
    }

    @Override // y73.d
    public final void onResume() {
        this.f167561k = true;
        Function0<Unit> r100 = this.f167562l;
        if (r100 == null) goto L6;
        Unit r101 = r100.invoke();
        return;
    }

    @Override // fj.e
    public final void B0() {
        final String r100 = null;
        n(new HeadVideoPlayerBridge$onPlayFailed$1(r100));
    }

    @Override // fj.e
    public final void H() {
        n(HeadVideoPlayerBridge$onRenderFirstFrame$1.INSTANCE);
    }

    @Override // fj.e
    public final void Z2() {
        n(HeadVideoPlayerBridge$onResumePlay$1.INSTANCE);
    }

    @Override // fj.e
    public final void e() {
        n(HeadVideoPlayerBridge$onPlayCompleted$1.INSTANCE);
    }

    @Override // y73.f
    public final int getCurrentPosition() {
        b r100 = this.f167549d;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getCurrentPosition();
    }

    @Override // y73.g
    public final Object getPlayer() {
        b r100 = this.f167549d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPlayer();
    }

    @Override // y73.d
    public final void release() {
        ((ArrayList) this.f167552g).clear();
        b r100 = this.f167549d;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f167549d = null;
        a<String, b> r101 = PlayAbilityUtil.f164933a;
        PlayAbilityUtil.f164933a.f570646a.clear();
    }

    @Override // y73.g
    public final c getSharePlayer() {
        return this.f167550e;
    }

    @Override // y73.d
    public final void onDestroy() {
        release();
    }

    @Override // fj.e
    public final void Q(final float r100) {
        n(new HeadVideoPlayerBridge$onPlayProgressChange$1(r100));
    }

    @Override // y73.d
    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        if (Intrinsics.areEqual(this.f167549d, r100) == false) goto L6;
        this.f167549d = null;
        return;
    }

    @Override // y73.d
    public final void d(b r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        this.f167549d = r100;
    }

    @Override // y73.g
    public final void k(c r100) {
        if (this.f167550e != null) goto L17;
        b r101 = this.f167549d;
        if (r101 == null) goto L10;
        ECVideoPlayerView r102 = gj.c.a(r101);
        if (r102 == null) goto L10;
        i r103 = r102.f170618b;
    L11:
        if (r103 == null) goto L13;
    L14:
        this.f167550e = new HeadVideoPlayerBridge$createShareHandle$1(this, r103, this.f167549d);
        return;
    L13:
        if (this.f167549d != null) goto L14;
        return;
    L10:
        r103 = null;
        goto L11
    }

    @Override // fj.e
    public final void m3(boolean r100) {
        n(HeadVideoPlayerBridge$onPausePlay$1.INSTANCE);
    }

    @Override // fj.e
    public final void y(final boolean r100) {
        n(new HeadVideoPlayerBridge$onBuffering$1(r100));
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.abs.AbsPdpBasePlayerBridge
    public final b m(com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "playerOptions");
        a<String, b> r102 = PlayAbilityUtil.f164933a;
        b r103 = PlayAbilityUtil.d(r100, this.f167553h, r100.f164973e, this.f167554i, r101, this.f167555j);
        if (r103 == null) goto L5;
        r103.A(this);
        return r103;
    L5:
        return null;
    }

    public HeadVideoPlayerBridge(BasePdpVideoView r100, AVScene r101, PlayAbilityCacheScene r102) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "avScene");
        Intrinsics.checkNotNullParameter(r102, "abilityCacheScene");
        super(r100, r101, r102);
        this.f167561k = true;
    }
}
