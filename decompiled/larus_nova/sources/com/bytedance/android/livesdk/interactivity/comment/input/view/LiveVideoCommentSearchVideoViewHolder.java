package com.bytedance.android.livesdk.interactivity.comment.input.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.model.j;
import com.bytedance.android.livesdk.chatroom.model.l;
import com.bytedance.lighten.loader.SmartCircleImageView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w62.g;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/view/LiveVideoCommentSearchVideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveVideoCommentSearchVideoViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f135188s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SmartCircleImageView f135189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f135190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f135191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f135192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f135193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f135194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f135195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f135196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f135197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HSImageView f135198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public l f135199k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f135200l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f135201m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView f135202n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final g f135203o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f135204p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f135205q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f135206r;

    public static final class a {
    }

    static {
    }

    public final void T3(boolean r100) {
        FrameLayout r101 = this.f135193e;
        View r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.getChildCount());
    L6:
        int r104 = r103.intValue();
        if (this.f135202n == null) goto L20;
        if (r104 <= 0) goto L20;
        g r105 = this.f135203o;
        l r106 = this.f135199k;
        if (r106 == null) goto L16;
        j r107 = r106.f106959a;
        if (r107 == null) goto L16;
        Long r108 = r107.e();
        if (r108 == null) goto L16;
        long r109 = r108.longValue();
    L18:
        if (r105.RH(r109) == false) goto L20;
        boolean r110 = true;
    L21:
        if (r110 == false) goto L28;
        if (r100 == true) goto L28;
        IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView r111 = this.f135202n;
        if (r111 == null) goto L50;
        r111.resumeVideoPlayer();
        return;
    L50:
        return;
    L28:
        if (this.f135202n != null) goto L30;
        w62.a r112 = w62.a.f558400b;
        this.f135202n = w62.a.C8074a.a().f558401a;
    L30:
        this.f135193e.removeAllViews();
        IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView r113 = this.f135202n;
        if (r113 == null) goto L33;
        r102 = r113.asView();
    L33:
        if (r102 != null) goto L35;
    L42:
        this.f135203o.Px();
        l r114 = this.f135199k;
        if (r114 == null) goto L51;
        Object r115 = r114.f106961c;
        if (r115 == null) goto L52;
        IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView r116 = this.f135202n;
        if (r116 == null) goto L53;
        r116.startVideoPlayer(r115, this.f135200l, this.f135201m, 0);
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L35:
        if (r102.getParent() == null) goto L41;
        ViewParent r117 = r102.getParent();
        if (r117 == null) goto L40;
        ((ViewGroup) r117).removeView(r102);
        goto L41
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L41:
        this.f135193e.addView(r102);
    L16:
        r109 = 0;
    L20:
        r110 = false;
        goto L21
    L5:
        r103 = null;
        goto L6
    }

    public LiveVideoCommentSearchVideoViewHolder(View r100, g r101, int r102, int r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f135203o = r101;
        this.f135204p = r102;
        this.f135205q = r103;
        this.f135206r = r104;
        this.f135189a = (SmartCircleImageView) r100.findViewById(R.id.video_item_avatar);
        this.f135190b = (TextView) r100.findViewById(R.id.video_item_nickName);
        this.f135191c = (TextView) r100.findViewById(R.id.video_item_date);
        this.f135192d = (TextView) r100.findViewById(R.id.video_item_desc);
        this.f135193e = (FrameLayout) r100.findViewById(R.id.video_container);
        this.f135194f = (ViewGroup) r100.findViewById(R.id.video_item_pin_check);
        this.f135195g = (ImageView) r100.findViewById(R.id.video_pin_select);
        this.f135196h = (ViewGroup) r100.findViewById(R.id.video_item_pin_send);
        this.f135197i = (ViewGroup) r100.findViewById(R.id.video_info_container);
        this.f135198j = (HSImageView) r100.findViewById(R.id.video_item_cover);
    }
}
