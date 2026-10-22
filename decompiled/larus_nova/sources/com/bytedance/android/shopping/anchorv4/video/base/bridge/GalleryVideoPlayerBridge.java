package com.bytedance.android.shopping.anchorv4.video.base.bridge;

import android.view.View;
import android.view.ViewParent;
import androidx.camera.video.AudioStats;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.g;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.i;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.anchorv4.video.base.abs.AbsPdpBasePlayerBridge;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import fj.e;
import gj.b;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import x73.c;
import x73.d;

/* JADX INFO: loaded from: classes12.dex */
public final class GalleryVideoPlayerBridge extends AbsPdpBasePlayerBridge implements e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f167556k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<e> f167557l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f167558m;

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryVideoPlayerBridge f167559a;

        public a(GalleryVideoPlayerBridge r100) {
            this.f167559a = r100;
        }

        @Override // x73.d
        public final void a(c r100) {
            Intrinsics.checkNotNullParameter(r100, "handle");
            if (Intrinsics.areEqual(r100, this.f167559a.f167550e) == false) goto L6;
            this.f167559a.o(null);
            return;
        }
    }

    @Override // fj.e
    public final void R2() {
    }

    @Override // y73.d
    public final void onPause() {
    }

    @Override // y73.d
    public final void onResume() {
    }

    @Override // fj.e
    public final void B0() {
        final String r100 = null;
        n(new GalleryVideoPlayerBridge$onPlayFailed$1(r100));
    }

    @Override // y73.f
    public final long a() {
        long r100 = this.f167556k;
        this.f167556k = 0;
        if (r100 > 0) goto L6;
        return 0;
    L6:
        return System.currentTimeMillis() - r100;
    }

    @Override // fj.e
    public final void e() {
        n(GalleryVideoPlayerBridge$onPlayCompleted$1.INSTANCE);
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
    public final void onDestroy() {
        this.f167557l.clear();
        release();
    }

    public final void p() {
        b r100 = this.f167549d;
        if (r100 == null) goto L7;
        View r101 = r100.getView();
        if (r101 == null) goto L7;
        ViewParent r102 = r101.getParent();
    L9:
        if (Intrinsics.areEqual(r102, this.f167553h) == false) goto L14;
        b r103 = this.f167549d;
        if (r103 == null) goto L15;
        r103.r();
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r102 = null;
        goto L9
    }

    @Override // y73.d
    public final void release() {
        if (this.f167550e == null) goto L6;
        o(null);
    L11:
        z73.a<String, b> r100 = PlayAbilityUtil.f164933a;
        PlayAbilityUtil.f164933a.f570646a.clear();
        return;
    L6:
        if (this.f167549d == null) goto L11;
        p();
        b r101 = this.f167549d;
        if (r101 == null) goto L10;
        r101.release();
    L10:
        this.f167549d = null;
        goto L11
    }

    @Override // fj.e
    public final void H() {
        this.f167556k = System.currentTimeMillis();
        n(GalleryVideoPlayerBridge$onRenderFirstFrame$1.INSTANCE);
    }

    @Override // fj.e
    public final void Z2() {
        this.f167556k = System.currentTimeMillis();
        n(GalleryVideoPlayerBridge$onResumePlay$1.INSTANCE);
    }

    @Override // y73.g
    public final c getSharePlayer() {
        return this.f167550e;
    }

    @Override // fj.e
    public final void Q(final float r100) {
        n(new GalleryVideoPlayerBridge$onPlayProgressChange$1(r100));
    }

    @Override // y73.d
    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        Iterator<T> r101 = this.f167557l.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100.Z((e) r101.next());
        goto L4
    L7:
        if (Intrinsics.areEqual(this.f167549d, r100) == false) goto L11;
        this.f167549d = null;
        return;
    }

    @Override // y73.d
    public final void d(b r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        Iterator<T> r101 = this.f167557l.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100.A((e) r101.next());
        goto L4
    L7:
        if (this.f167549d != null) goto L11;
        this.f167549d = r100;
        return;
    }

    @Override // y73.g
    public final void k(c r100) {
        if (Intrinsics.areEqual(r100, this.f167550e) == false) goto L5;
        return;
    L5:
        b r101 = null;
        o(null);
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.f562820e == null) goto L15;
        b r102 = r100.i(this.f167558m);
        if (r102 == null) goto L29;
        r102.V(this.f167553h, false);
        this.f167549d = r102;
        this.f167550e = r100;
        return;
    L29:
        return;
    L15:
        if (r100.f562819d != null) goto L17;
        return;
    L17:
        if ((this.f167549d instanceof i) == false) goto L31;
        com.bytedance.android.shopping.api.video.i r103 = r100.j(this.f167558m);
        if (r103 == null) goto L32;
        o(null);
        b r104 = this.f167549d;
        if ((r104 instanceof g) == false) goto L24;
        r101 = r104;
    L24:
        g r105 = (g) r101;
        if (r105 == null) goto L27;
        r105.H(r103);
    L27:
        this.f167550e = r100;
        return;
    L32:
        return;
    }

    @Override // fj.e
    public final void m3(boolean r100) {
        n(GalleryVideoPlayerBridge$onPausePlay$1.INSTANCE);
    }

    public final void o(Boolean r100) {
        c r101 = this.f167550e;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        b r102 = r101.f562820e;
    L8:
        if (r102 == null) goto L16;
        if (r101 == null) goto L15;
        a r103 = this.f167558m;
        if (r100 == null) goto L13;
        boolean r104 = r100.booleanValue();
    L14:
        r101.g(r103, Boolean.valueOf(r104));
        goto L15
    L13:
        r104 = isPlaying();
    L15:
        this.f167550e = null;
        p();
        this.f167549d = null;
        return;
    L16:
        b r105 = this.f167549d;
        if ((r105 instanceof g) == true) goto L19;
        r105 = null;
    L19:
        g r106 = (g) r105;
        if (r106 == null) goto L22;
        r106.d0();
    L22:
        c r107 = this.f167550e;
        if (r107 == null) goto L29;
        a r108 = this.f167558m;
        if (r100 == null) goto L27;
        boolean r109 = r100.booleanValue();
    L28:
        r107.h(r108, Boolean.valueOf(r109));
        goto L29
    L27:
        r109 = isPlaying();
    L29:
        this.f167550e = null;
        return;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.abs.AbsPdpBasePlayerBridge, y73.b
    public final void setScaleType(ScaleType r210) {
        Intrinsics.checkNotNullParameter(r210, "scaleType");
        ScaleType r100 = ScaleType.FIT_CENTER;
        Integer r101 = null;
        b r102 = null;
        b r103 = null;
        double r104 = 1.0d;
        Double r110 = Double.valueOf(1.0d);
        double r105 = AudioStats.AUDIO_AMPLITUDE_NONE;
        Double r111 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (r210 != r100) goto L15;
        b r106 = this.f167549d;
        if ((r106 instanceof i) == true) goto L7;
        if (r106 == null) goto L49;
        r106.e(0, r111, r110, r111, r110);
        return;
    L49:
        return;
    L7:
        if ((r106 instanceof i) == false) goto L10;
        r102 = r106;
    L10:
        i r107 = (i) r102;
        if (r107 == null) goto L47;
        r107.j0(r100);
        return;
    L47:
        return;
    L15:
        ScaleType r108 = ScaleType.CENTER_CROP;
        if (r210 != r108) goto L51;
        b r109 = this.f167549d;
        if ((r109 instanceof i) == true) goto L20;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r112 = this.f167548c;
        if (r112 == null) goto L29;
        Integer r113 = r112.l();
    L30:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r114 = this.f167548c;
        if (r114 == null) goto L33;
        r101 = r114.c();
    L33:
        if (r113 == null) goto L54;
        if (r101 != null) goto L36;
        return;
    L36:
        if (r113.intValue() > 0) goto L38;
        return;
    L38:
        if (r101.intValue() > 0) goto L40;
        return;
    L40:
        if (r113.intValue() <= r101.intValue()) goto L42;
        double r115 = (((double) r101.intValue()) / ((double) r113.intValue())) / ((double) 2);
        r105 = 0.5d - r115;
        double r116 = 0.0d;
        double r117 = 1.0d;
        r104 = r115 + 0.5d;
    L43:
        b r118 = this.f167549d;
        if (r118 == null) goto L58;
        r118.e(2, Double.valueOf(r105), Double.valueOf(r104), Double.valueOf(r116), Double.valueOf(r117));
        return;
    L58:
        return;
    L42:
        double r119 = (((double) r113.intValue()) / ((double) r101.intValue())) / ((double) 2);
        r116 = 0.5d - r119;
        r117 = r119 + 0.5d;
        goto L43
    L54:
        return;
    L29:
        r113 = null;
        goto L30
    L20:
        if ((r109 instanceof i) == false) goto L23;
        r103 = r109;
    L23:
        i r120 = (i) r103;
        if (r120 == null) goto L52;
        r120.j0(r108);
        return;
    L52:
        return;
    }

    @Override // fj.e
    public final void y(final boolean r100) {
        n(new GalleryVideoPlayerBridge$onBuffering$1(r100));
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.abs.AbsPdpBasePlayerBridge
    public final b m(com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r100, com.bytedance.android.shopping.api.video.d r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "playerOptions");
        z73.a<String, b> r102 = PlayAbilityUtil.f164933a;
        b r103 = PlayAbilityUtil.d(r100, this.f167553h, r100.f164973e, this.f167554i, r101, this.f167555j);
        if (r103 == null) goto L5;
        r103.A(this);
        return r103;
    L5:
        return null;
    }

    public GalleryVideoPlayerBridge(BasePdpVideoView r100, AVScene r101, PlayAbilityCacheScene r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "avScene");
        Intrinsics.checkNotNullParameter(r102, "abilityCacheScene");
        super(r100, r101, r102);
        LinkedHashSet r103 = new LinkedHashSet();
        r103.add(this);
        Unit r104 = Unit.INSTANCE;
        this.f167557l = r103;
        this.f167558m = new a(this);
    }
}
