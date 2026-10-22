package com.bytedance.android.shopping.commentgallery.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import cc3.b;
import cc3.d;
import cc3.e;
import cc3.f;
import cc3.g;
import cc3.k;
import cc3.l;
import cc3.m;
import cc3.n;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.ec.model.response.ECCommentVideo;
import com.bytedance.android.ec.sdk.helper.c;
import com.bytedance.android.shopping.anchorv3.comment.widget.j;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/commentgallery/view/CommentGalleryVideoVHNew;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "Lcc3/m;", "Lcc3/l;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentGalleryVideoVHNew extends TransitionViewHolder implements m, l {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f172532p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f172533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f172534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECVideoPlayerView f172535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f172536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f172537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f172538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SeekBar f172539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f172540h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f172541i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f172542j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f172543k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f172544l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public n f172545m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f f172546n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f172547o;

    @Override // cc3.m
    public final void J() {
        this.f172535c.x();
        this.f172535c.s();
    }

    @Override // cc3.m
    public final void Q3() {
        if (this.f172544l == true) goto L5;
    L7:
        this.f172544l = false;
        return;
    L5:
        if (this.f172542j == false) goto L7;
        play();
        goto L7
    }

    public final void T3() {
        if (this.f172535c.g() == true) goto L6;
        this.f172535c.m();
        this.f172540h.setVisibility(0);
        return;
    }

    @Override // cc3.m
    public final void k0() {
        if (this.f172544l == false) goto L5;
        return;
    L5:
        this.f172544l = true;
        this.f172542j = true ^ this.f172535c.g();
        T3();
    }

    public final void play() {
        this.f172535c.n();
        this.f172540h.setVisibility(8);
    }

    @Override // cc3.m
    public final void u0() {
        T3();
    }

    @Override // cc3.m
    public final void z3() {
        play();
    }

    public CommentGalleryVideoVHNew(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f172547o = true;
        this.f172533a = "DJJ, CommentGalleryVideoVHNew[" + hashCode() + ']';
        this.f172535c = (ECVideoPlayerView) r100.findViewById(R.id.ec_gallery_video_player_view);
        TextView r101 = (TextView) r100.findViewById(R.id.gallery_tv_media_progress);
        this.f172536d = r101;
        TextView r102 = (TextView) r100.findViewById(R.id.gallery_tv_media_duration);
        this.f172537e = r102;
        TextView r103 = (TextView) r100.findViewById(R.id.ec_duration_divider);
        this.f172538f = r103;
        SeekBar r104 = (SeekBar) r100.findViewById(R.id.gallery_pb_media_progress);
        this.f172539g = r104;
        this.f172540h = (ImageView) r100.findViewById(R.id.gallery_ec_play_iv);
        View r105 = r100.findViewById(R.id.gallery_root_container);
        this.f172541i = r105;
        ECStatusView r106 = (ECStatusView) r100.findViewById(R.id.gallery_loading_status_view);
        com.bytedance.android.shopping.extensions.f.e(r101, 600);
        com.bytedance.android.shopping.extensions.f.e(r102, 600);
        if (r103 == null) goto L5;
        com.bytedance.android.shopping.extensions.f.e(r103, 100);
    L5:
        this.f172546n = new f(r100);
        g r107 = new g(this);
        r106.b(r100.getContext(), null, null);
        r104.setOnTouchListener(d.f23231a);
        r104.setOnSeekBarChangeListener(r107);
        r105.setOnClickListener(new e(this));
        getTransitionLayout().setSingleTagDismissEnabled(false);
        getTransitionLayout().setDragTransitionEnabled(false);
    }

    @Override // cc3.m
    public final void B2(b r210) {
        Intrinsics.checkNotNullParameter(r210, "galleryMediaModel");
        if ((r210 instanceof ee3.b) == true) goto L5;
        b r100 = null;
    L6:
        ee3.b r101 = (ee3.b) r100;
        if (r101 == null) goto L9;
        ECCommentVideo r102 = r101.f472277q;
    L10:
        k r103 = r210.f23227o;
        if (r103 == null) goto L13;
        String r104 = r103.f23244f;
    L14:
        if (r102 == null) goto L16;
        String r105 = r102.getVideoId();
    L17:
        if (r104 == null) goto L28;
        if (r105 == null) goto L28;
        if (this.f172535c.f170618b != null) goto L28;
        int r106 = j.f164717a;
        Intrinsics.checkNotNullParameter(r104, "commentId");
        Intrinsics.checkNotNullParameter(r105, "id");
        c r107 = c.f48117a;
        r107.b("CommentVideoPlayerHelper", "getExternalPlayer, " + r104 + ", null, " + r105 + ", null");
        if (Intrinsics.areEqual(r104, null) == false) goto L26;
        Intrinsics.areEqual(null, r105);
    L26:
        this.f172535c.c();
        r107.b(this.f172533a, "ensureUseSharedPlayer, init player");
    L28:
        if (this.f172543k == true) goto L30;
        this.f172535c.r(this.f172546n);
        this.f172543k = true;
    L30:
        this.f172534b = r210;
        Integer r108 = r210.f47878g;
        int r109 = 0;
        if (r108 == null) goto L33;
        int r110 = r108.intValue();
    L34:
        Integer r111 = r210.f47879h;
        if (r111 == null) goto L37;
        r109 = r111.intValue();
    L37:
        if (r110 <= r109) goto L39;
        this.f172535c.w(ScaleType.FIT_CENTER);
    L40:
        com.bytedance.android.shopping.api.video.d r112 = new com.bytedance.android.shopping.api.video.d(false, !this.f172547o, 0, 0, false, 509);
        if (r102 == null) goto L43;
        com.bytedance.android.shopping.api.video.e r113 = com.bytedance.android.shopping.api.video.m.b(r102, r112);
    L71:
        this.f172535c.b(r113);
        return;
    L43:
        com.bytedance.android.shopping.api.video.k r114 = new com.bytedance.android.shopping.api.video.k();
        String r115 = r210.f47876e;
        if (r115 != null) goto L46;
        r115 = "";
    L46:
        Intrinsics.checkNotNullParameter(r115, "videoKey");
        r114.f170664a = r115;
        String r116 = r210.f47876e;
        if (r116 != null) goto L49;
        r116 = "";
    L49:
        Intrinsics.checkNotNullParameter(r116, "key");
        r114.f170665b = r116;
        String r117 = r210.f47873b;
        if (r117 != null) goto L52;
        r117 = "";
    L52:
        r114.a(r117);
        String r118 = r210.f47875d;
        if (r118 != null) goto L55;
        r118 = "";
    L55:
        r114.a(r118);
        com.bytedance.android.shopping.api.video.b r119 = r114.b();
        if (r119 != null) goto L58;
        return;
    L58:
        Intrinsics.checkNotNullParameter(r119, "playItem");
        ArrayList r120 = new ArrayList();
        r120.add(r119);
        Integer r121 = r210.f47879h;
        if (r121 == null) goto L61;
        int r122 = r121.intValue();
    L62:
        Integer r123 = r210.f47878g;
        if (r123 == null) goto L65;
        int r124 = r123.intValue();
    L66:
        String r125 = r210.f47876e;
        if (r125 != null) goto L69;
        String r126 = "";
    L70:
        Intrinsics.checkNotNullParameter(r126, "newVid");
        Intrinsics.checkNotNullParameter(r112, "options");
        r113 = new com.bytedance.android.shopping.api.video.e(r126, 0, null, r120, null, r112, -1, 0.0f, null, r122, r124, null, null);
        goto L71
    L69:
        r126 = r125;
        goto L70
    L65:
        r124 = -1;
        goto L66
    L61:
        r122 = -1;
        goto L62
    L39:
        this.f172535c.w(ScaleType.CENTER_CROP);
        goto L40
    L33:
        r110 = 0;
        goto L34
    L16:
        r105 = null;
        goto L17
    L13:
        r104 = null;
        goto L14
    L9:
        r102 = null;
        goto L10
    L5:
        r100 = r210;
        goto L6
    }

    @Override // cc3.m
    public final void V2(n r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f172545m = r100;
    }

    @Override // cc3.l
    public final void onPageSelected(int r100) {
        b r101 = this.f172534b;
        if (r101 == null) goto L11;
        k r102 = r101.f23227o;
        if (r102 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r102.f23243e, "pic") == false) goto L9;
        r102.f23246h = r100;
    L9:
        t53.b r103 = t53.b.f544622a;
        Context r104 = this.itemView.getContext();
        r103.getClass();
        t53.b.d(r104, r102);
        return;
    }
}
