package com.bytedance.android.live.liveinteract.interactivesong.panel;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVBaseInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/panel/InteractiveSongMvPreviewVH;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/IMvPreviewViewHolder;", "Lcom/bytedance/android/live/liveinteract/interactivesong/panel/i;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractiveSongMvPreviewVH extends IMvPreviewViewHolder<i> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f74075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f74076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HSImageView f74077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f74078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f74079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f74080h;

    public InteractiveSongMvPreviewVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f74075c = (ViewGroup) r100.findViewById(R.id.mv_preview_label_container);
        this.f74076d = (ViewGroup) r100.findViewById(R.id.mv_preview_label_bg);
        this.f74077e = (HSImageView) r100.findViewById(R.id.mv_preview_label_lock_icon);
        this.f74078f = (ViewGroup) r100.findViewById(R.id.mv_preview_play_container);
        this.f74079g = (TextView) r100.findViewById(R.id.mv_preview_play_text);
        this.f74080h = r100.findViewById(R.id.mv_preview_select_status);
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder
    public final void T3(final int r100, i r101) {
        final i r102 = r101;
        Intrinsics.checkNotNullParameter(r102, "mvPanel");
        if (r102.f74153b == false) goto L7;
        View r103 = this.f74080h;
        if (r103 == null) goto L10;
        r103.setVisibility(0);
    L10:
        HSImageView r104 = this.f142328b;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverBg");
    L13:
        IOrderSingMVInfo r105 = r102.f74152a;
        if (r105 == null) goto L18;
        IMVBaseInfo r106 = r105.getMvBaseInfo();
        if (r106 == null) goto L18;
        String r107 = r106.getCoverUrl();
    L19:
        r104.setImageURI(r107);
        this.itemView.setOnClickListener(new InteractiveSongMvPreviewVH$onBind$1(this, r100, r102));
        IOrderSingMVInfo r108 = r102.f74152a;
        if (r108 != null) goto L22;
    L34:
        ViewGroup r109 = this.f74075c;
        if (r109 == null) goto L37;
        r109.setVisibility(8);
    L37:
        int r110 = r102.f74154c;
        if (r110 != 1) goto L46;
        ViewGroup r111 = this.f74078f;
        if (r111 == null) goto L42;
        r111.setVisibility(0);
    L42:
        TextView r112 = this.f74079g;
        if (r112 == null) goto L57;
        r112.setText(s1.B(R.string.ttlive_interactive_song_mv_is_playing));
        return;
    L57:
        return;
    L46:
        if (r110 != 2) goto L53;
        ViewGroup r113 = this.f74078f;
        if (r113 == null) goto L50;
        r113.setVisibility(0);
    L50:
        TextView r114 = this.f74079g;
        if (r114 == null) goto L59;
        r114.setText(s1.B(R.string.ttlive_interactive_song_mv_is_later_play));
        return;
    L59:
        return;
    L53:
        ViewGroup r115 = this.f74078f;
        if (r115 == null) goto L61;
        r115.setVisibility(8);
        return;
    L61:
        return;
    L22:
        if (r108.isHighQuality() != true) goto L34;
        ViewGroup r116 = this.f74075c;
        if (r116 == null) goto L26;
        r116.setVisibility(0);
    L26:
        ViewGroup r117 = this.f74076d;
        if (r117 == null) goto L30;
        r117.setBackground(s1.m(R.drawable.ttlive_bg_mv_list_label));
    L30:
        if (r102.f74152a.isLocked() == false) goto L37;
        HSImageView r118 = this.f74077e;
        if (r118 == null) goto L37;
        r118.setVisibility(0);
    L18:
        r107 = null;
        goto L19
    L7:
        View r119 = this.f74080h;
        if (r119 == null) goto L10;
        r119.setVisibility(8);
        goto L10
    }
}
