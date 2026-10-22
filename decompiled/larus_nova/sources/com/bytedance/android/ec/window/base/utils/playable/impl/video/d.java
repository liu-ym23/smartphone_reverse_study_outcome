package com.bytedance.android.ec.window.base.utils.playable.impl.video;

import android.graphics.Rect;
import com.bytedance.android.ec.window.base.view.ECWindowRemoteVideoView;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends f<String> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f49752j = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f49753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f49754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public tp.b f49755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f49756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ECWindowRemoteVideoView f49757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.ec.window.base.utils.window.c<ECVideoPlayer> f49758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f49759i;

    @Override // tp.c
    public final void B() {
        e r100 = this.f49760a;
        if (r100 == null) goto L5;
        r100.onStopPlay();
    L5:
        ECVideoPlayer r101 = b();
        if (r101 == null) goto L12;
        r101.q();
        this.f49757g.getVideoView().b();
        com.bytedance.android.ec.window.base.utils.window.c<ECVideoPlayer> r102 = this.f49758h;
        if (r102 == null) goto L10;
        r102.b(r101);
    L10:
        r101.m(this.f49756f);
        return;
    }

    @Override // tp.c
    public final void R() {
        dm.a.a("测试播放范围").a("execStart:" + this.f49753c);
        String r100 = this.f49753c;
        if (r100 == null) goto L11;
        ECVideoPlayer r101 = a();
        r101.n(this.f49759i);
        r101.a(this.f49756f);
        r101.q();
        r101.p(r100);
        Function0<Boolean> r102 = this.f49761b;
        if (r102 == null) goto L9;
        Boolean r103 = r102.invoke();
        if (r103 == null) goto L9;
        r101.o(!r103.booleanValue());
    L9:
        r101.k();
        return;
    }

    public final ECVideoPlayer b() {
        return this.f49757g.getVideoView().getPlayer();
    }

    @Override // tp.c
    public final Rect r() {
        if (g.a(this.f49757g) == false) goto L5;
        return null;
    L5:
        Rect r100 = new Rect();
        if (this.f49757g.getGlobalVisibleRect(r100) == true) goto L8;
        return null;
    L8:
        return r100;
    }

    @Override // tp.c
    public final boolean D3() {
        ECVideoPlayer r100 = b();
        if (r100 != null) goto L5;
        Boolean r101 = null;
    L11:
        return k.i(r101);
    L5:
        if (r100.f187343g.f187406d != 4) goto L7;
        boolean r102 = true;
    L8:
        r101 = Boolean.valueOf(r102);
        goto L11
    L7:
        r102 = false;
        goto L8
    }

    public final ECVideoPlayer a() {
        ECVideoPlayer r100 = b();
        if (r100 != null) goto L13;
        ECVideoView r101 = this.f49757g.getVideoView();
        ECVideoPlayer r102 = b();
        if (r102 != null) goto L14;
        com.bytedance.android.ec.window.base.utils.window.c<ECVideoPlayer> r103 = this.f49758h;
        if (r103 == null) goto L11;
        r102 = r103.a(new ECWindowRemoteVideoPlayable$bindVideoViewWithPlayer$2(this));
        if (r102 == null) goto L11;
    L12:
        r101.setPlayer(r102);
    L11:
        r102 = new ECVideoPlayer(this.f49757g.getContext(), AVScene.WINDOW_INNER_FLOW);
        r102.n(this.f49759i);
    L14:
        return r102;
    L13:
        return r100;
    }

    @Override // tp.c
    public final boolean g0() {
        boolean r100 = D3();
        if (r100 == false) goto L7;
        ECVideoPlayer r101 = b();
        if (r101 == null) goto L7;
        r101.k();
    L7:
        return r100;
    }

    @Override // tp.c
    public final boolean isPlaying() {
        ECVideoPlayer r100 = b();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.e() == false) goto L8;
    L17:
        return true;
    L8:
        if (r100.f187343g.f187406d != 8) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == true) goto L17;
        if (r100.f187343g.f187406d != 7) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == true) goto L17;
        return false;
    L15:
        r102 = false;
        goto L16
    L10:
        r101 = false;
        goto L11
    }

    @Override // tp.c
    public final void v() {
        ECVideoPlayer r100 = b();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f187343g.f187406d != 4) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        r100.j();
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // tp.c
    public final tp.b m() {
        return this.f49755e;
    }

    @Override // tp.c
    public final List<tp.c> L(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "visibleArea");
        dm.a.a("测试播放范围").a("ECRemoteVideoPlayable:" + this.f49753c);
        if (tp.e.a(this.f49757g, r100) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return CollectionsKt.listOf(this);
    }

    @Override // tp.c
    public final void o2(tp.b r100) {
        this.f49755e = r100;
    }

    public d(ECWindowRemoteVideoView r100, com.bytedance.android.ec.window.base.utils.window.c r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "videoView");
        super(r102);
        this.f49757g = r100;
        this.f49758h = r101;
        this.f49759i = true;
        this.f49756f = new c(this);
    }
}
