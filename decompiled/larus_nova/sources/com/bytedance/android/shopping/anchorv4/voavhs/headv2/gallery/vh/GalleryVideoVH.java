package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh;

import android.app.Activity;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.GestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.host.api.player.HeaderCtrLynxPendant;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.anchorv4.containers.GalleryViewerParams;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.base.VideoComponentScene;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdVideoView;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantLynx;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.GalleryFromType;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.GalleryViewModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.m;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.z0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.VideoProgressBar;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.n;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import j83.j;
import j83.k;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/vh/GalleryVideoVH;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/j0;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/vh/g;", "Lcom/bytedance/android/shopping/anchorv4/video/base/bridge/intf/callback/c;", "Lfj/e;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryVideoVH extends TransitionViewHolder implements j0, g, com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c, fj.e {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f169416s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x73.a f169417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f169418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f169419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f169420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f169421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f169422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ECDraweeView f169423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f169424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f169425i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f169426j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f169427k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j83.a f169428l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f169429m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f169430n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f169431o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f169432p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final l f169433q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function1<Integer, Unit> f169434r;

    public static final class a extends com.bytedance.android.shopping.anchorv4.video.d {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ GalleryVideoVH f169435i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f169436j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.video.f f169437k;

        @Override // com.bytedance.android.shopping.anchorv4.video.e
        public final boolean e() {
            return GalleryVideoVH.T3(this.f169435i).isMute();
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.e
        public final Object getPlayer() {
            return GalleryVideoVH.T3(this.f169435i).getPlayer();
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.e
        public final boolean isPlaying() {
            return GalleryVideoVH.T3(this.f169435i).isPlaying();
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
        public final boolean g(boolean r100) {
            if (r100 == GalleryVideoVH.T3(this.f169435i).isMute()) goto L7;
            GalleryVideoVH.T3(this.f169435i).f(r100, false);
            this.f169435i.f169428l.e();
            return true;
        L7:
            return true;
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
        public final Boolean j(Boolean r100, boolean r101) {
            if (Intrinsics.areEqual(this.f169436j, "head_video") == false) goto L11;
            l r102 = this.f169435i.f169433q;
            if (r102 == null) goto L9;
            i0 r103 = r102.f169330h;
            if (r103 == null) goto L9;
            return Boolean.valueOf(r103.m0(r100, r101));
        L9:
            return null;
        L11:
            l r104 = this.f169435i.f169433q;
            if (r104 == null) goto L19;
            GalleryViewModel r105 = r104.f169328f;
            if (r105 == null) goto L19;
            Boolean r106 = r105.getVideoManualMuteState();
            if (r106 == null) goto L19;
            r101 = r106.booleanValue();
        L19:
            return Boolean.valueOf(r101);
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.d
        public final void n(boolean r100, boolean r101) {
            super.n(r100, r101);
            if (r101 == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(this.f169436j, "head_video") == false) goto L13;
            l r102 = this.f169435i.f169433q;
            if (r102 == null) goto L14;
            i0 r103 = r102.f169330h;
            if (r103 == null) goto L15;
            r103.w0(r100);
            return;
        L15:
            return;
        L14:
            return;
        }

        public a(GalleryVideoVH r100, String r101, com.bytedance.android.shopping.anchorv4.video.f r110, String r111, com.bytedance.android.shopping.anchorv4.video.f r112) {
            this.f169435i = r100;
            this.f169436j = r101;
            this.f169437k = r110;
            super(r111, r112, null, true, true, 12);
        }
    }

    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryVideoVH f169438a;

        @Override // j83.k
        public final void a() {
            boolean r100 = !GalleryVideoVH.T3(this.f169438a).isMute();
            GalleryVideoVH.T3(this.f169438a).f(r100, false);
            l r101 = this.f169438a.f169433q;
            if (r101 == null) goto L7;
            GalleryViewModel r102 = r101.f169328f;
            if (r102 == null) goto L7;
            r102.setVideoManualMuteState(Boolean.valueOf(r100));
        L7:
            a r103 = this.f169438a.f169429m;
            if (r103 == null) goto L10;
            r103.n(r100, true);
        L10:
            GalleryVideoVH r104 = this.f169438a;
            l r105 = r104.f169433q;
            if (r105 == null) goto L16;
            m r106 = r105.f169329g;
            if (r106 == null) goto L17;
            r106.h(r104.getAdapterPosition(), r100);
            return;
        L17:
            return;
        }

        @Override // j83.k
        public final void b() {
            GalleryVideoVH r100 = this.f169438a;
            GalleryVideoVH.U3(r100, !GalleryVideoVH.T3(r100).isPlaying());
        }

        public b(GalleryVideoVH r100) {
            this.f169438a = r100;
        }
    }

    public static final class c implements k73.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryVideoVH f169439a;

        @Override // k73.d
        public final boolean isMuted() {
            return GalleryVideoVH.T3(this.f169439a).isMute();
        }

        @Override // k73.d
        public final boolean isPlaying() {
            return GalleryVideoVH.T3(this.f169439a).isPlaying();
        }

        public c(GalleryVideoVH r100) {
            this.f169439a = r100;
        }
    }

    @Override // fj.e
    public final void B0() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
    public final void P1(boolean r100) {
    }

    @Override // fj.e
    public final void R2() {
    }

    public final com.bytedance.android.shopping.anchorv4.video.f W3() {
        return (com.bytedance.android.shopping.anchorv4.video.f) this.f169431o.getValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c, fj.e
    public final void y(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
    public final void y3(String r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
    public final void E3() {
        j83.a r100 = this.f169428l;
        r100.h(null);
        r100.f497673a.d(0.0f);
        r100.f497674b.setVisibility(8);
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r101 = r100.f497679g;
        if (r101 == null) goto L5;
        r101.j0();
    L5:
        a r102 = this.f169429m;
        if (r102 == null) goto L10;
        com.bytedance.android.shopping.anchorv4.video.f r103 = r102.f167580d;
        if (r103 == null) goto L10;
        com.bytedance.android.shopping.anchorv4.video.f.a.a(r103, r102, false, true, 2);
    L10:
        l r104 = this.f169433q;
        if (r104 == null) goto L19;
        m r105 = r104.f169329g;
        if (r105 == null) goto L20;
        int r106 = getAdapterPosition();
        x73.a r107 = this.f169417a;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L17:
        r105.j(r106, r107.a(), true);
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
    public final void S() {
        j83.a r100 = this.f169428l;
        int r101 = j83.a.f497672u;
        r100.h(null);
        a r102 = this.f169429m;
        if (r102 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f r103 = r102.f167580d;
        if (r103 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f.a.b(r103, r102, true, 2);
    L7:
        com.bytedance.android.shopping.anchorv4.video.f r104 = W3();
        if (r104 == null) goto L10;
        r104.d(true);
    L10:
        l r105 = this.f169433q;
        if (r105 == null) goto L15;
        m r106 = r105.f169329g;
        if (r106 == null) goto L15;
        r106.i(getAdapterPosition(), true ^ this.f169427k);
    L15:
        this.f169423g.setVisibility(8);
    }

    public final boolean X3() {
        l r100 = this.f169433q;
        if (r100 == null) goto L9;
        GalleryViewModel r101 = r100.f169328f;
        if (r101 == null) goto L9;
        LiveData<Boolean> r102 = r101.isMoreVideoExpanded();
        if (r102 == null) goto L9;
        Boolean r103 = r102.getValue();
    L11:
        return Intrinsics.areEqual(r103, Boolean.TRUE);
    L9:
        r103 = null;
        goto L11
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void Y2() {
        if (this.f169426j == false) goto L9;
        x73.a r100 = this.f169417a;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L7:
        r100.startPlay();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void Z0() {
        x73.a r100 = this.f169417a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L6:
        if (r100.isPlaying() == false) goto L15;
        l r101 = this.f169433q;
        if (r101 == null) goto L15;
        m r102 = r101.f169329g;
        if (r102 == null) goto L15;
        int r103 = getAdapterPosition();
        x73.a r104 = this.f169417a;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L14:
        r102.j(r103, r104.a(), false);
    L15:
        x73.a r105 = this.f169417a;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L18:
        r105.release();
    }

    @Override // fj.e
    public final void Z2() {
        j83.a r100 = this.f169428l;
        int r101 = j83.a.f497672u;
        r100.h(null);
        a r102 = this.f169429m;
        if (r102 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f r103 = r102.f167580d;
        if (r103 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f.a.b(r103, r102, true, 2);
    L7:
        com.bytedance.android.shopping.anchorv4.video.f r104 = W3();
        if (r104 == null) goto L10;
        r104.d(true);
    L10:
        l r105 = this.f169433q;
        if (r105 == null) goto L15;
        m r106 = r105.f169329g;
        if (r106 == null) goto L15;
        r106.i(getAdapterPosition(), true ^ this.f169427k);
    L15:
        this.f169423g.setVisibility(8);
    }

    @Override // fj.e
    public final void e() {
        j83.a r100 = this.f169428l;
        r100.h(null);
        r100.f497673a.d(0.0f);
        r100.f497674b.setVisibility(8);
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r101 = r100.f497679g;
        if (r101 == null) goto L5;
        r101.j0();
    L5:
        a r102 = this.f169429m;
        if (r102 == null) goto L10;
        com.bytedance.android.shopping.anchorv4.video.f r103 = r102.f167580d;
        if (r103 == null) goto L10;
        com.bytedance.android.shopping.anchorv4.video.f.a.a(r103, r102, false, true, 2);
    L10:
        l r104 = this.f169433q;
        if (r104 == null) goto L19;
        m r105 = r104.f169329g;
        if (r105 == null) goto L20;
        int r106 = getAdapterPosition();
        x73.a r107 = this.f169417a;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L17:
        r105.j(r106, r107.a(), true);
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void onViewDetachedFromWindow() {
        Function1<Integer, Unit> r100 = this.f169434r;
        if (r100 == null) goto L5;
        Unit r101 = r100.invoke(this.f169430n);
    L5:
        pausePlay();
    }

    public final void pausePlay() {
        x73.a r100 = this.f169417a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L5:
        r100.pausePlay();
        this.f169428l.h(Boolean.FALSE);
    }

    public final void startPlay() {
        x73.a r100 = this.f169417a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L5:
        r100.startPlay();
        l r101 = this.f169433q;
        if (r101 == null) goto L10;
        GalleryViewModel r102 = r101.f169328f;
        if (r102 == null) goto L10;
        r102.setCurPlayingVideoPosition(getAdapterPosition());
    L10:
        this.f169428l.h(Boolean.TRUE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void t0() {
        x73.a r100 = this.f169417a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L5:
        this.f169426j = r100.isPlaying();
        l r101 = this.f169433q;
        boolean r102 = false;
        if (r101 == null) goto L35;
        Context r103 = r101.f169326d;
        if ((r103 instanceof Activity) == true) goto L10;
        r103 = null;
    L10:
        Activity r104 = (Activity) r103;
        if (r104 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 != true) goto L35;
        int r106 = getAdapterPosition();
        Integer r107 = this.f169433q.f169328f.getSelectedPosition().getValue();
        if (r107 == null) goto L35;
        if (r106 != r107.intValue()) goto L35;
        x73.a r108 = this.f169417a;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L26:
        if (r108.getSharePlayer() == null) goto L28;
        r102 = true;
        goto L35
    L28:
        z0 r109 = this.f169433q.f169323a;
        boolean r110 = this.f169426j;
        x73.a r111 = this.f169417a;
        if (r111 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L31:
        int r112 = r111.getCurrentPosition();
        x73.a r113 = this.f169417a;
        if (r113 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L34:
        r109.f169571b = new h(r110, r112, r113.isMute());
        goto L35
    L13:
        if (r104.isFinishing() != true) goto L15;
        r105 = true;
    L35:
        if (r102 == true) goto L38;
        pausePlay();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j0
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d S3() {
        return V3();
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d V3() {
        if (i.a() == true) goto L5;
    L9:
        boolean r100 = false;
    L10:
        if (r100 == false) goto L12;
        View r101 = this.f169420d;
    L14:
        return new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d(r101, true, false, false, 24);
    L12:
        r101 = this.f169419c;
        goto L14
    L5:
        if (this.f169420d.getChildCount() <= 0) goto L9;
        if (this.f169420d.isShown() == false) goto L9;
        r100 = true;
        goto L10
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j0
    public final void o0() {
        View r100 = V3().f169277a;
        if (r100 == null) goto L5;
        r100.setAlpha(1.0f);
    L5:
        View r101 = V3().f169277a;
        if (r101 == null) goto L9;
        r101.setVisibility(0);
        return;
    }

    @Override // fj.e
    public final void H() {
        Z2();
    }

    public static final /* synthetic */ x73.a T3(GalleryVideoVH r100) {
        x73.a r101 = r100.f169417a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L5:
        return r101;
    }

    @Override // fj.e
    public final void Q(float r100) {
        this.f169428l.c(r100);
    }

    public final void Y3(int r100) {
        if (getAdapterPosition() != r100) goto L14;
        l r101 = this.f169433q;
        if (r101 != null) goto L7;
    L13:
        startPlay();
        return;
    L7:
        if (r101.a() != true) goto L13;
        com.bytedance.android.shopping.anchorv4.video.f r102 = W3();
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.i() != true) goto L20;
        startPlay();
        return;
    L20:
        return;
    L14:
        Function1<Integer, Unit> r103 = this.f169434r;
        if (r103 == null) goto L17;
        Unit r104 = r103.invoke(this.f169430n);
    L17:
        pausePlay();
    }

    public final void Z3(boolean r100) {
        l r101 = this.f169433q;
        if (r101 == null) goto L14;
        float r102 = 0.0f;
        if (X3() == false) goto L10;
        Integer r103 = r101.f169328f.getMoreVideoHeight().getValue();
        if (r103 == null) goto L9;
        r102 = r103.intValue();
    L9:
        r102 = -r102;
    L10:
        if (r100 == false) goto L12;
        this.f169421e.animate().translationY(r102).setDuration(300).start();
        return;
    L12:
        this.f169421e.animate().cancel();
        this.f169421e.setTranslationY(r102);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
    public final void b(float r100) {
        this.f169428l.c(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c
    public final void i2(boolean r100) {
        if (r100 == false) goto L18;
        j83.a r101 = this.f169428l;
        int r102 = j83.a.f497672u;
        r101.h(null);
        a r103 = this.f169429m;
        if (r103 == null) goto L9;
        com.bytedance.android.shopping.anchorv4.video.f r104 = r103.f167580d;
        if (r104 == null) goto L9;
        com.bytedance.android.shopping.anchorv4.video.f.a.b(r104, r103, true, 2);
    L9:
        com.bytedance.android.shopping.anchorv4.video.f r105 = W3();
        if (r105 == null) goto L12;
        r105.d(true);
    L12:
        l r106 = this.f169433q;
        if (r106 == null) goto L17;
        m r107 = r106.f169329g;
        if (r107 == null) goto L17;
        r107.i(getAdapterPosition(), !this.f169427k);
    L17:
        this.f169423g.setVisibility(8);
        return;
    L18:
        j83.a r108 = this.f169428l;
        int r109 = j83.a.f497672u;
        r108.h(null);
        a r110 = this.f169429m;
        if (r110 == null) goto L23;
        com.bytedance.android.shopping.anchorv4.video.f r111 = r110.f167580d;
        if (r111 == null) goto L23;
        com.bytedance.android.shopping.anchorv4.video.f.a.a(r111, r110, false, true, 2);
    L23:
        l r112 = this.f169433q;
        if (r112 == null) goto L33;
        m r113 = r112.f169329g;
        if (r113 == null) goto L34;
        int r114 = getAdapterPosition();
        x73.a r115 = this.f169417a;
        if (r115 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L30:
        r113.j(r114, r115.a(), false);
        return;
    L34:
        return;
    }

    @Override // fj.e
    public final void m3(boolean r100) {
        j83.a r101 = this.f169428l;
        int r102 = j83.a.f497672u;
        r101.h(null);
        a r103 = this.f169429m;
        if (r103 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f r104 = r103.f167580d;
        if (r104 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f.a.a(r104, r103, false, true, 2);
    L7:
        l r105 = this.f169433q;
        if (r105 == null) goto L16;
        m r106 = r105.f169329g;
        if (r106 == null) goto L17;
        int r107 = getAdapterPosition();
        x73.a r108 = this.f169417a;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L14:
        r106.j(r107, r108.a(), false);
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void onPageSelected(int r100) {
        Y3(r100);
    }

    public static final void U3(GalleryVideoVH r100, boolean r101) {
        if (r101 == false) goto L5;
        r100.f169427k = true;
        r100.startPlay();
    L12:
        l r102 = r100.f169433q;
        if (r102 == null) goto L22;
        m r103 = r102.f169329g;
        if (r103 == null) goto L23;
        Map<String, Object> r104 = r103.b(r100.getAdapterPosition());
        if (r101 == false) goto L19;
        String r105 = "play";
    L20:
        r104.put("click_type", r105);
        Unit r106 = Unit.INSTANCE;
        m.d(r103, "pd_video_pause_click", r104, null, null, 60);
        return;
    L19:
        r105 = "pause";
        goto L20
    L23:
        return;
    L22:
        return;
    L5:
        r100.pausePlay();
        l r107 = r100.f169433q;
        if (r107 == null) goto L12;
        if (r107.a() != true) goto L12;
        com.bytedance.android.shopping.anchorv4.video.f r108 = r100.W3();
        if (r108 == null) goto L12;
        r108.d(false);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void I3(int r310, com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r311) {
        this.f169430n = Integer.valueOf(r310);
        Object r100 = null;
        if (r311 == null) goto L65;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r101 = r311.getPlayInfo();
        if (r101 == null) goto L65;
        x73.a r102 = this.f169417a;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L9:
        r102.i(r101, new com.bytedance.android.shopping.api.video.d(false, false, 0, 0, false, 511), r311.getSharePlayer());
        x73.a r103 = this.f169417a;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L12:
        a r104 = this.f169429m;
        if (r104 == null) goto L19;
        com.bytedance.android.shopping.anchorv4.video.f r105 = r104.f167580d;
        if (r105 == null) goto L19;
        if (r105.h(r104) != true) goto L19;
        boolean r106 = true;
    L20:
        r103.f(r106, false);
        l r107 = this.f169433q;
        if (r107 == null) goto L28;
        z0 r108 = r107.f169323a;
        if (r108 == null) goto L28;
        SparseBooleanArray r109 = r108.f169570a;
        if (r109 == null) goto L28;
        if (r109.get(r310) != true) goto L28;
    L48:
        j83.a r110 = this.f169428l;
        r110.f497681i = (int) (r101.a() / ((long) 1000));
        r110.f497684l = Integer.valueOf(r310);
        r110.e();
        r110.h(null);
        r110.g();
        r110.f();
        GenericDraweeHierarchy r111 = this.f169423g.getHierarchy();
        if (r111 == null) goto L51;
        r111.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    L51:
        y.d(this.f169423g, r101.f());
        x73.a r112 = this.f169417a;
        if (r112 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L55:
        if (r112.isPlaying() == true) goto L63;
        x73.a r113 = this.f169417a;
        if (r113 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L60:
        if (r113.getCurrentPosition() > 0) goto L63;
        this.f169423g.setVisibility(0);
    L63:
        this.f169423g.setVisibility(8);
    L28:
        l r114 = this.f169433q;
        if (r114 == null) goto L35;
        z0 r115 = r114.f169323a;
        if (r115 == null) goto L35;
        SparseBooleanArray r116 = r115.f169570a;
        if (r116 == null) goto L35;
        r116.put(r310, true);
    L35:
        x73.a r117 = this.f169417a;
        if (r117 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L39:
        if (r117.getSharePlayer() != null) goto L48;
        Integer r118 = r311.a();
        if (r118 == null) goto L48;
        int r119 = r118.intValue();
        if (r101.a() <= 0) goto L48;
        x73.a r120 = this.f169417a;
        if (r120 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L47:
        r120.seek(r119 / r101.a());
    L19:
        r106 = false;
    L65:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L73;
        x73.a r121 = this.f169417a;
        if (r121 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L69:
        r121.g(this);
        x73.a r122 = this.f169417a;
        if (r122 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L72:
        r122.c(this);
    L80:
        Z3(false);
        l r123 = this.f169433q;
        if (r123 == null) goto L92;
        GalleryViewModel r124 = r123.f169328f;
        if (r124 == null) goto L92;
        if (r124.isFirstBind() != true) goto L92;
        this.f169433q.f169328f.setFirstBind(false);
        GalleryViewerParams r125 = this.f169433q.f169332j;
        if (r125 == null) goto L92;
        if (r125.getGalleryIndex() != r310) goto L92;
        Y3(r310);
    L92:
        if (i.a() == false) goto L179;
        Integer r126 = this.f169430n;
        if (r126 == null) goto L107;
        int r127 = r126.intValue();
        l r128 = this.f169433q;
        if (r128 == null) goto L104;
        GalleryViewModel r129 = r128.f169328f;
        if (r129 == null) goto L104;
        LiveData<List<s>> r130 = r129.getFullThumbList();
        if (r130 == null) goto L104;
        List<s> r131 = r130.getValue();
        if (r131 == null) goto L104;
        s r132 = (s) CollectionsKt.getOrNull(r131, r127);
    L105:
        if (r132 == null) goto L107;
        boolean r133 = true;
    L108:
        String r134 = "1";
        if (r133 == false) goto L111;
        Object r135 = "1";
    L112:
        l r136 = this.f169433q;
        if (r136 == null) goto L119;
        GalleryViewModel r137 = r136.f169328f;
        if (r137 == null) goto L119;
        LiveData<Boolean> r138 = r137.isMoreVideoExpanded();
        if (r138 == null) goto L119;
        Boolean r139 = r138.getValue();
    L121:
        if (Intrinsics.areEqual(r139, Boolean.TRUE) == true) goto L124;
        r134 = "0";
    L124:
        j83.a r140 = this.f169428l;
        l r141 = this.f169433q;
        if (r141 == null) goto L129;
        i0 r142 = r141.f169330h;
        if (r142 == null) goto L129;
        String r143 = r142.getSessionId();
    L130:
        if (r311 == null) goto L134;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r144 = r311.getPlayInfo();
        if (r144 == null) goto L134;
        String r145 = r144.j();
    L136:
        if (r311 == null) goto L140;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r146 = r311.getPlayInfo();
        if (r146 == null) goto L140;
        fj.f r147 = r146.f164972d;
    L141:
        if (r147 == null) goto L167;
        HeaderCtrLynxPendant r148 = r147.b();
        if (r148 == null) goto L146;
        String r149 = r148.getLynxId();
    L147:
        HeaderCtrLynxPendant r150 = r147.b();
        if (r150 == null) goto L150;
        String r151 = r150.getLynxUrl();
    L151:
        HeaderCtrLynxPendant r152 = r147.b();
        if (r152 == null) goto L154;
        JsonObject r153 = r152.getLynxData();
    L155:
        HeaderPendantLynx r154 = new HeaderPendantLynx(r149, r151, r153, null, 8, null);
        HeaderCtrLynxPendant r155 = r147.a();
        if (r155 == null) goto L158;
        String r210 = r155.getLynxId();
    L159:
        HeaderCtrLynxPendant r156 = r147.a();
        if (r156 == null) goto L162;
        String r211 = r156.getLynxUrl();
    L163:
        HeaderCtrLynxPendant r157 = r147.a();
        if (r157 == null) goto L166;
        r100 = r157.getLynxData();
    L166:
        r100 = new n(r154, new HeaderPendantLynx(r210, r211, r100, null, 8, null));
        goto L167
    L162:
        r211 = null;
        goto L163
    L158:
        r210 = null;
        goto L159
    L154:
        r153 = null;
        goto L155
    L150:
        r151 = null;
        goto L151
    L146:
        r149 = null;
    L167:
        k73.b r158 = new k73.b(r143, r145, 0, r100, VideoComponentScene.HEAD_VIDEO_GALLERY.getScene(), MapsKt.mapOf(new Pair[]{TuplesKt.to("should_show_fold_icon", r135), TuplesKt.to("video_list_fold_status", r134), TuplesKt.to("video_list_height", BDLocationException.ERROR_RESTRICTED_MODE_ON)}), new c(this), false, 132);
        r140.getClass();
        Intrinsics.checkNotNullParameter(r158, "videoComponentInfo");
        dm.a.a("GalleryVideoVH").i("initVideoCtrlContainerComponent videoComponentInfo=" + r158);
        l r159 = r140.f497690r;
        if (r159 == null) goto L180;
        Context r160 = r159.getContext();
        if (r160 != null) goto L173;
        return;
    L173:
        if (r140.f497679g != null) goto L175;
        r140.f497679g = new com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b(r160, r140.f497691s, r158, new j83.c(r140));
    L175:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r161 = r140.f497679g;
        if (r161 == null) goto L181;
        r161.i0(r158);
        return;
    L181:
        return;
    L180:
        return;
    L140:
        r147 = null;
    L134:
        r145 = null;
    L129:
        r143 = null;
    L119:
        r139 = null;
        goto L121
    L111:
        r135 = "0";
    L104:
        r132 = null;
    L107:
        r133 = false;
        goto L108
    L179:
        return;
    L73:
        x73.a r162 = this.f169417a;
        if (r162 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L76:
        r162.j(this);
        x73.a r163 = this.f169417a;
        if (r163 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L79:
        r163.l(this);
        goto L80
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View, x73.a] */
    /* JADX WARN: Type inference failed for: r30v0, types: [kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit>] */
    public GalleryVideoVH(View r210, l r211, Function1<? super Integer, Unit> r310) {
        Intrinsics.checkNotNullParameter(r210, "itemView");
        super(r210);
        this.f169432p = r210;
        this.f169433q = r211;
        this.f169434r = r310;
        ?? r100 = (FrameLayout) r210.findViewById(R.id.video_container);
        this.f169418b = r100;
        View r110 = r210.findViewById(R.id.layout_video_cover);
        this.f169419c = r110;
        FrameLayout r111 = (FrameLayout) r210.findViewById(R.id.video_lynx_container);
        this.f169420d = r111;
        View r101 = r210.findViewById(R.id.layout_video_control);
        this.f169421e = r101;
        View r112 = r210.findViewById(R.id.btn_video_play_center);
        this.f169422f = r112;
        this.f169423g = (ECDraweeView) r210.findViewById(R.id.iv_video_cover);
        View r113 = r210.findViewById(R.id.layout_loading);
        this.f169424h = r113;
        View r114 = r210.findViewById(R.id.view_bg_gradient);
        this.f169425i = r114;
        this.f169431o = LazyKt.lazy(new GalleryVideoVH$pdpPlayStateManager$2(this));
        int r102 = 0;
        a r103 = null;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L8;
        if (r211 == null) goto L12;
        Context r104 = r211.getContext();
        if (r104 == null) goto L12;
        ?? r105 = new BasePdpVideoView(r104, false ? 1 : 0, 6, r102);
    L13:
        r100.addView(r105, -1, -1);
        if (r105 == 0) goto L16;
        this.f169417a = r105;
    L16:
        com.bytedance.android.shopping.anchorv4.video.f r115 = W3();
        if (r211 != null) goto L19;
    L21:
        String r106 = "gallery";
    L22:
        String r116 = r106;
        if (r115 != null) goto L25;
        int r107 = 1;
    L26:
        this.f169429m = r103;
        x73.a r108 = this.f169417a;
        if (r108 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L29:
        j83.a r109 = new j83.a(r101, r108, r112, r113, r114, r211, r111, new b(this));
        this.f169428l = r109;
        if (r211 == null) goto L35;
        Context r117 = r211.getContext();
        if (r117 == null) goto L35;
        r110.setOnTouchListener(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.a(new GestureDetector(r117, new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.b(this))));
    L35:
        r109.f497685m.setOnTouchListener(new j83.f(r109));
        r109.f497675c.setOnClickListener(new j83.i(r109));
        r109.f();
        l r118 = r109.f497690r;
        if (r118 == null) goto L38;
        r118.f169328f.isMoreVideoExpanded().observe(r118.f169327e, new j83.h(r109));
    L38:
        r109.g();
        l r119 = r109.f497690r;
        if (r119 == null) goto L43;
        m r120 = r119.f169329g;
        if (r120 == null) goto L43;
        Pair[] r121 = new Pair[r107];
        r121[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW, Integer.valueOf(r109.b() ? 1 : 0));
        m.d(r120, com.bytedance.android.ec.core.event.a.EVENT_PDP_MODULE_SHOW, MapsKt.hashMapOf(r121), "more_video_button_show", "a1.b34986.c503191.d90177", 4);
    L43:
        VideoProgressBar.a(r109.f497673a, new j(r109), true, Float.valueOf(q.a(4)), Integer.valueOf(com.bytedance.android.shopping.extensions.b.a(60)), 0, 0, 104);
        r109.f497676d.setOnClickListener(new j83.d(r109));
        r109.f497677e.setOnClickListener(new j83.e(r109));
        if (r109.d() == true) goto L52;
        r109.f497678f.a();
        l r122 = r109.f497690r;
        if (r122 == null) goto L50;
        Context r123 = r122.getContext();
        if (r123 == null) goto L50;
        GalleryFromType r124 = null;
        r109.f497678f.b(r123, null, null);
    L51:
        ViewExtensionsKt.g(r109.f497688p, 16.0f, 16.0f, 16.0f, 16.0f);
        r109.f497688p.setBackgroundColor((int) 3658881059L);
    L53:
        r109.f497689q.setBackground(new j83.g());
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L68;
        x73.a r125 = this.f169417a;
        if (r125 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L58:
        AVScene r126 = AVScene.CONTENT_PRODUCT_DETAIL_GALLERY;
        a83.a r127 = new a83.a();
        if (r211 == null) goto L64;
        i0 r128 = r211.f169330h;
        if (r128 == null) goto L64;
        r124 = r128.c();
    L64:
        if (r124 != GalleryFromType.MoreVideo) goto L66;
        PlayAbilityCacheScene r129 = PlayAbilityCacheScene.SCENE_MORE_VIDEO;
    L67:
        r125.k(r126, false, r127, r129);
    L72:
        if (r211 == null) goto L74;
        r211.f169328f.getMoreVideoHeight().observe(r211.f169327e, new d(this));
        r211.f169328f.isMoreVideoExpanded().observe(r211.f169327e, new e(this));
        r211.f169328f.getBottomBarHeight().observe(r211.f169327e, new f(this));
    L74:
        r210.addOnAttachStateChangeListener(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.c(this));
        return;
    L66:
        r129 = PlayAbilityCacheScene.SCENE_GALLERY_VIDEO;
        goto L67
    L68:
        x73.a r130 = this.f169417a;
        if (r130 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L71:
        r130.h(AVScene.CONTENT_PRODUCT_DETAIL_GALLERY, false);
    L50:
        r124 = null;
        goto L51
    L52:
        r124 = null;
        goto L53
    L25:
        r107 = 1;
        r103 = new a(this, r116, r115, r116, r115);
        goto L26
    L19:
        if (r211.a() != true) goto L21;
        r106 = "head_video";
    L12:
        r105 = 0;
        goto L13
    L8:
        if (r211 == null) goto L12;
        Context r131 = r211.getContext();
        if (r131 == null) goto L12;
        r105 = new BasePdVideoView(r131, null);
        goto L13
    }
}
