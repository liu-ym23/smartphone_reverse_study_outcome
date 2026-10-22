package com.bytedance.android.shopping.anchorv4.video.base.abs;

import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.bytedance.android.shopping.api.video.d;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import x73.c;

/* JADX INFO: loaded from: classes12.dex */
public abstract class AbsPdpBasePlayerBridge implements y73.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f167546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f167547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f167548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gj.b f167549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f167550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Function1<Boolean, Unit>> f167551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c> f167552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BasePdpVideoView f167553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AVScene f167554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PlayAbilityCacheScene f167555j;

    public static final class a {
    }

    static {
    }

    public abstract gj.b m(b r100, d r101);

    @Override // y73.b
    public void setScaleType(ScaleType r100) {
        Intrinsics.checkNotNullParameter(r100, "scaleType");
    }

    @Override // y73.f
    public final int h() {
        b r100 = this.f167548c;
        if (r100 == null) goto L7;
        fj.d r101 = r100.f164970b;
        if (r101 == null) goto L7;
        return (int) r101.f477439f;
    L7:
        return 0;
    }

    @Override // y73.f
    public final boolean isMute() {
        gj.b r100 = this.f167549d;
        if (r100 == null) goto L6;
        return r100.isMute();
    L6:
        return this.f167547b;
    }

    @Override // y73.f
    public final boolean isPlaying() {
        gj.b r100 = this.f167549d;
        if (r100 == null) goto L6;
        return r100.isPlaying();
    L6:
        return this.f167546a;
    }

    @Override // y73.c
    public final void pausePlay() {
        gj.b r100 = this.f167549d;
        if (r100 == null) goto L6;
        r100.pause();
        this.f167546a = false;
        n(AbsPdpBasePlayerBridge$pausePlay$1$1.INSTANCE);
        return;
    }

    @Override // y73.c
    public final void startPlay() {
        gj.b r100 = this.f167549d;
        if (r100 != null) goto L5;
        return;
    L5:
        if (isPlaying() == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r100.getView().getParent(), this.f167553h) == false) goto L9;
        r100.play();
    L10:
        this.f167546a = true;
        return;
    L9:
        r100.C();
        goto L10
    }

    @Override // y73.e
    public final void c(com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (((ArrayList) this.f167552g).contains(r100) == true) goto L6;
        ((ArrayList) this.f167552g).add(r100);
        return;
    }

    @Override // y73.e
    public final void g(com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (((ArrayList) this.f167552g).contains(r100) == false) goto L6;
        ((ArrayList) this.f167552g).remove(r100);
        return;
    }

    @Override // y73.e
    public final void j(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) this.f167551f).contains(r100) == false) goto L6;
        ((ArrayList) this.f167551f).remove(r100);
        return;
    }

    @Override // y73.e
    public final void l(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) this.f167551f).contains(r100) == true) goto L6;
        ((ArrayList) this.f167551f).add(r100);
        return;
    }

    public final void n(Function1<? super com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Iterator r101 = ((ArrayList) this.f167552g).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        r100.invoke((com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c) r101.next());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        dm.a.b r102 = dm.a.f469202a;
        dm.a.a("PlayerBridge-").b("notifyVideoState error: " + e.getMessage(), null);
        goto L4
    }

    @Override // y73.c
    public final void seek(float r100) {
        gj.b r101 = this.f167549d;
        if (r101 == null) goto L6;
        r101.seek(r100);
        return;
    }

    @Override // y73.b
    public final void f(final boolean r100, boolean r101) {
        gj.b r102 = this.f167549d;
        if (r102 == null) goto L6;
        r102.a(r100);
        this.f167547b = r100;
        n(new AbsPdpBasePlayerBridge$setMuteState$$inlined$let$lambda$1(this, r100));
        return;
    }

    @Override // y73.b
    public final void i(b r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "playerOptions");
        this.f167548c = r100;
        this.f167549d = m(r100, r101);
    }

    public AbsPdpBasePlayerBridge(BasePdpVideoView r100, AVScene r101, PlayAbilityCacheScene r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "avScene");
        Intrinsics.checkNotNullParameter(r102, "abilityCacheScene");
        this.f167553h = r100;
        this.f167554i = r101;
        this.f167555j = r102;
        this.f167551f = new ArrayList();
        this.f167552g = new ArrayList();
    }
}
