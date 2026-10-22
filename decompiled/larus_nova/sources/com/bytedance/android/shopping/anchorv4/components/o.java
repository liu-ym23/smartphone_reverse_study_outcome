package com.bytedance.android.shopping.anchorv4.components;

import android.graphics.Rect;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.anchorv3.PdpTaskManager;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.dto.business.HeadMoreVideo;
import com.bytedance.android.shopping.anchorv4.dto.business.VideoHolderItem;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class o extends b73.a implements a73.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f166112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w f166113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AnchorV4VM f166114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f166115f;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.ec.core.anchorv3.q {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ o f166116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ HeadMoreVideo f166117f;

        @Override // com.bytedance.android.ec.core.anchorv3.q
        public final void c() {
            o r100 = this.f166116e;
            HeadMoreVideo r101 = this.f166117f;
            if (r100.f166112c == true) goto L102;
            if (r101 == null) goto L104;
            r100.f166112c = true;
            VideoModel r102 = r101.getAnchorVideo();
            if (r102 != null) goto L14;
            List<VideoHolderItem> r103 = r101.getVideoHolderList();
            if (r103 == null) goto L13;
            VideoHolderItem r104 = (VideoHolderItem) CollectionsKt.getOrNull(r103, r101.getAnchorIndex());
            if (r104 == null) goto L13;
            r102 = r104.getVideo();
        L13:
            r102 = null;
        L14:
            if (r102 == null) goto L103;
            z73.a<String, gj.b> r105 = PlayAbilityUtil.f164933a;
            com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r106 = PlayAbilityUtil.a(r102, null, PlayerViewScene.SCENE_HEAD_MORE_VIDEO);
            FrameLayout r107 = r100.f166115f;
            if (r107 == null) goto L40;
            DragRelativeLayout r108 = new DragRelativeLayout(r100.f166115f.getContext());
            r108.setDockMode(3);
            w r109 = new w(r108.getContext());
            r100.f166113d = r109;
            Unit r110 = Unit.INSTANCE;
            RelativeLayout.LayoutParams r111 = new RelativeLayout.LayoutParams(-2, -2);
            r111.addRule(11, -1);
            r111.rightMargin = com.bytedance.android.shopping.extensions.b.a(12);
            r108.addView(r109, r111);
            r108.b();
            w r112 = r100.f166113d;
            if (r112 != null) goto L21;
        L38:
            r107.addView(r108);
            goto L40
        L21:
            if (ViewCompat.isLaidOut(r112) == true) goto L23;
        L37:
            r112.addOnLayoutChangeListener(new s(r108, r100));
            goto L38
        L23:
            if (r112.isLayoutRequested() == true) goto L37;
            ViewGroup.LayoutParams r113 = r112.getLayoutParams();
            if ((r113 instanceof ViewGroup.MarginLayoutParams) == true) goto L27;
            r113 = null;
        L27:
            ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
            if (r114 != null) goto L30;
            r114 = new ViewGroup.MarginLayoutParams(-2, -2);
        L30:
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v r115 = r100.f166114e.getHeadViewAbilityV2New();
            if (r115 == null) goto L35;
            Rect r116 = r115.m9();
            if (r116 == null) goto L35;
            int r117 = r116.top;
            int r118 = (r117 + ((r116.bottom - r117) / 2)) - (r112.getHeight() / 2);
        L36:
            r114.topMargin = r118;
            r112.setLayoutParams(r114);
            r108.post(new r(r112, r108));
        L35:
            r118 = com.bytedance.android.shopping.extensions.b.a(152);
        L40:
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L46;
            w r119 = r100.f166113d;
            if (r119 == null) goto L51;
            x73.a r120 = r119.f166164c;
            if (r120 == null) goto L51;
            r120.k(AVScene.CONTENT_PD_MORE_VIDEO_WINDOW, true, new a83.a(), PlayAbilityCacheScene.SCENE_MORE_VIDEO);
            r120.i(r106, new com.bytedance.android.shopping.api.video.d(true, true, 0, 0, false, 508), null);
            r120.f(true, false);
            r120.setScaleType(ScaleType.CENTER_CROP);
        L51:
            w r121 = r100.f166113d;
            if (r121 != null) goto L54;
        L57:
            w r122 = r100.f166113d;
            if (r122 == null) goto L62;
            TextView r123 = r122.f166162a;
            if (r123 == null) goto L62;
            r123.setText("更多视频");
        L62:
            w r124 = r100.f166113d;
            if (r124 == null) goto L73;
            ECDraweeView r125 = r124.f166163b;
            if (r125 == null) goto L73;
            GenericDraweeHierarchy r126 = r125.getHierarchy();
            if (r126 == null) goto L69;
            r126.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        L69:
            String r127 = r106.f();
            if (r127 == null) goto L72;
            com.bytedance.android.ec.core.utils.y.d(r125, r127);
            goto L73
        L72:
            r125.setVisibility(8);
            Unit r128 = Unit.INSTANCE;
        L73:
            w r129 = r100.f166113d;
            if (r129 == null) goto L76;
            r129.setOnClickListener(new p(r100, r101));
        L76:
            r100.f166114e.getPlayerStateManager().c(new q(r100, r100.f166114e.getPlayerStateManager()));
            w r130 = r100.f166113d;
            if (r130 == null) goto L83;
            x73.a r131 = r130.f166164c;
            if (r131 == null) goto L83;
            if (r131.isPlaying() != true) goto L83;
        L86:
            w r132 = r100.f166113d;
            if (r132 == null) goto L89;
            r132.setAlpha(0.0f);
        L89:
            w r133 = r100.f166113d;
            if (r133 != null) goto L92;
        L100:
            int r134 = com.bytedance.android.shopping.anchorv4.tracker.a.f167502a;
            com.bytedance.android.shopping.anchorv4.tracker.a.a(r100.f166114e, com.bytedance.android.ec.core.event.a.EVENT_PDP_MODULE_SHOW, r101.getTrack(), false, false, null, "a1.b8094.c05258.d150175", null, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_QUERY);
            return;
        L92:
            if (ViewCompat.isLaidOut(r133) == true) goto L94;
        L99:
            r133.addOnLayoutChangeListener(new u(r100));
            goto L100
        L94:
            if (r133.isLayoutRequested() == true) goto L99;
            w r135 = r100.f166113d;
            if (r135 == null) goto L98;
            r135.setAlpha(1.0f);
        L98:
            r133.setTranslationX(r133.getWidth() + com.bytedance.android.shopping.extensions.b.a(12));
            r133.animate().translationX(0.0f).setDuration(1000).start();
        L83:
            w r136 = r100.f166113d;
            if (r136 == null) goto L86;
            r136.postDelayed(new v(r100), 800);
            goto L86
        L54:
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L56;
            r121.f166164c.g(r121);
            r121.f166164c.c(r121);
            goto L57
        L56:
            r121.f166164c.j(r121);
            r121.f166164c.l(r121);
            goto L57
        L46:
            w r137 = r100.f166113d;
            if (r137 == null) goto L51;
            x73.a r138 = r137.f166164c;
            if (r138 == null) goto L51;
            r138.h(AVScene.CONTENT_PD_MORE_VIDEO_WINDOW, true);
            r138.i(r106, new com.bytedance.android.shopping.api.video.d(true, true, 0, 0, false, 508), null);
            r138.f(true, false);
            r138.setScaleType(ScaleType.CENTER_CROP);
            goto L51
        L103:
            return;
        L104:
            return;
        }

        public b(o r100, HeadMoreVideo r101) {
            this.f166116e = r100;
            this.f166117f = r101;
            super(3);
        }
    }

    static {
    }

    @Override // a73.e
    public final boolean d() {
        if (this.f166113d == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // b73.a, b73.d
    public final void onDestroy() {
        clearDisposable();
        w r100 = this.f166113d;
        if (r100 == null) goto L8;
        x73.a r101 = r100.f166164c;
        if (r101 == null) goto L9;
        r101.release();
        return;
    L9:
        return;
    }

    @Override // a73.e
    public final void B(HeadMoreVideo r100) {
        PdpTaskManager r101 = this.f166114e.getPdpTaskManager();
        b r102 = new b(this, r100);
        Handler r103 = PdpTaskManager.f43777k;
        r101.i(r102, false);
    }

    @Override // a73.e
    public final void g(boolean r100) {
        if (r100 == false) goto L6;
        w r101 = this.f166113d;
        if (r101 == null) goto L10;
        r101.setVisibility(0);
        return;
    L10:
        return;
    L6:
        w r102 = this.f166113d;
        if (r102 == null) goto L12;
        r102.setVisibility(8);
        return;
    }

    @Override // a73.e
    public final void h(float r100) {
        FrameLayout r101 = this.f166115f;
        if (r101 != null) goto L5;
        return;
    L5:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v r102 = this.f166114e.getHeadViewAbilityV2New();
        boolean r103 = false;
        if (r102 == null) goto L8;
        boolean r104 = r102.s();
    L10:
        if (r101.getVisibility() != 0) goto L12;
        r103 = true;
    L12:
        if (r103 == false) goto L24;
        if (r104 == true) goto L15;
        return;
    L15:
        if (r100 == 1.0f) goto L17;
    L19:
        if (r100 < 1.0f) goto L21;
        return;
    L21:
        if (r101.getAlpha() == 0.0f) goto L28;
        r101.setAlpha(0.0f);
        return;
    L28:
        return;
    L17:
        if (r101.getAlpha() == 1.0f) goto L19;
        r101.setAlpha(1.0f);
        return;
    L24:
        return;
    L8:
        r104 = false;
        goto L10
    }

    public o(AnchorV4VM r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorV4VM");
        this.f166114e = r100;
        this.f166115f = r101;
    }
}
