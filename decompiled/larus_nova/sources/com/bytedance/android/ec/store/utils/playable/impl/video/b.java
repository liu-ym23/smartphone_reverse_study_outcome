package com.bytedance.android.ec.store.utils.playable.impl.video;

import android.graphics.Rect;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.store.view.ECRemoteVideoView;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import nn.e;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends d<String> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f48679i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f48680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ln.b f48681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f48682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ECRemoteVideoView f48683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final qn.a<ECVideoPlayer> f48684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f48685h;

    @Override // ln.c
    public final void B() {
        c r100 = this.f48686a;
        if (r100 == null) goto L5;
        r100.onStopPlay();
    L5:
        ECVideoPlayer r101 = b();
        if (r101 == null) goto L12;
        r101.q();
        this.f48683f.getVideoView().b();
        qn.a<ECVideoPlayer> r102 = this.f48684g;
        if (r102 == null) goto L10;
        r102.b(r101);
    L10:
        r101.m(this.f48682e);
        return;
    }

    @Override // ln.c
    public final void R() {
        dm.a.a("测试播放范围").a("execStart:" + this.f48680c);
        String r100 = this.f48680c;
        if (r100 == null) goto L11;
        ECVideoPlayer r101 = a();
        r101.n(this.f48685h);
        r101.a(this.f48682e);
        r101.q();
        r101.p(r100);
        Function0<Boolean> r102 = this.f48687b;
        if (r102 == null) goto L9;
        Boolean r103 = r102.invoke();
        if (r103 == null) goto L9;
        r101.o(!r103.booleanValue());
    L9:
        r101.k();
        return;
    }

    public final ECVideoPlayer b() {
        return this.f48683f.getVideoView().getPlayer();
    }

    @Override // ln.c
    public final Rect r() {
        ECRemoteVideoView r100 = this.f48683f;
        Intrinsics.checkNotNullParameter(r100, "$this$isDetachedFromRecyclerView");
        ViewParent r101 = r100.getParent();
    L3:
        boolean r102 = true;
        if (r101 == null) goto L13;
        if ((r101 instanceof RecyclerView) == true) goto L7;
        ViewParent r103 = r101.getParent();
        if (Intrinsics.areEqual(r101, r103) == true) goto L13;
        r101 = r103;
        goto L3
    L7:
        r102 = false;
    L13:
        if (r102 == false) goto L15;
        return null;
    L15:
        Rect r104 = new Rect();
        if (this.f48683f.getGlobalVisibleRect(r104) == true) goto L18;
        return null;
    L18:
        return r104;
    }

    public final ECVideoPlayer a() {
        ECVideoPlayer r100 = b();
        if (r100 != null) goto L13;
        ECVideoView r101 = this.f48683f.getVideoView();
        ECVideoPlayer r102 = b();
        if (r102 != null) goto L14;
        qn.a<ECVideoPlayer> r103 = this.f48684g;
        if (r103 == null) goto L11;
        r102 = r103.a(new ECRemoteVideoPlayable$bindVideoViewWithPlayer$2(this));
        if (r102 == null) goto L11;
    L12:
        r101.setPlayer(r102);
    L11:
        r102 = new ECVideoPlayer(this.f48683f.getContext(), AVScene.WINDOW_INNER_FLOW);
        r102.n(this.f48685h);
    L14:
        return r102;
    L13:
        return r100;
    }

    @Override // ln.c
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

    @Override // ln.c
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

    @Override // ln.c
    public final ln.b m() {
        return this.f48681d;
    }

    @Override // ln.c
    public final List<ln.c> L(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "visibleArea");
        dm.a.a("测试播放范围").a("ECRemoteVideoPlayable:" + this.f48680c);
        ECRemoteVideoView r101 = this.f48683f;
        Intrinsics.checkNotNullParameter(r101, "$this$isVisibleInArea");
        Intrinsics.checkNotNullParameter(r100, "recyclerViewRectCache");
        Rect r102 = new Rect();
        r101.getGlobalVisibleRect(r102);
        if (r102.intersect(r100) == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L12;
        return CollectionsKt.emptyList();
    L12:
        return CollectionsKt.listOf(this);
    L5:
        if (RangesKt.coerceAtMost(r101.getHeight(), r100.height()) != (RangesKt.coerceAtMost(r102.bottom, r100.bottom) - RangesKt.coerceAtLeast(r102.top, r100.top))) goto L7;
        r103 = true;
        goto L8
    }

    @Override // ln.c
    public final void k1(e.a r100) {
        this.f48681d = r100;
    }

    public b(ECRemoteVideoView r100, qn.a r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "videoView");
        super(r102);
        this.f48683f = r100;
        this.f48684g = r101;
        this.f48685h = true;
        this.f48682e = new a(this);
    }
}
