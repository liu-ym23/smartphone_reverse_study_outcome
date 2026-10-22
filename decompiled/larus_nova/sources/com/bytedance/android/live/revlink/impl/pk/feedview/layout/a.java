package com.bytedance.android.live.revlink.impl.pk.feedview.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.Guideline;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.revlink.impl.pk.ui.IMProgressBarLayout;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f96503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Guideline f96504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f96505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f96506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HSImageView f96507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f96508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMProgressBarLayout f96509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f96510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f96511i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f96512j;

    public final Context getContext() {
        return this.f96503a;
    }

    public a(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f96512j = r100;
        Context r101 = r100.getContext();
        if (r101 != null) goto L5;
        r101 = s1.getContext();
    L5:
        this.f96503a = r101;
        LayoutInflater.from(r101).inflate(R.layout.ttlive_feed_preview_pk, r100, true);
        this.f96504b = (Guideline) r100.findViewById(R.id.gl_content);
        this.f96505c = r100.findViewById(R.id.content_layout);
        this.f96506d = (HSImageView) r100.findViewById(R.id.iv_pk_top_bg);
        this.f96507e = (HSImageView) r100.findViewById(R.id.iv_pk_bottom_bg);
        this.f96508f = (FrameLayout) r100.findViewById(R.id.pk_lynx_egg_container);
        this.f96511i = (FrameLayout) r100.findViewById(R.id.pk_lynx_container);
        this.f96509g = (IMProgressBarLayout) r100.findViewById(R.id.im_bar_container);
        this.f96510h = (FrameLayout) r100.findViewById(R.id.break_through_lynx_info_container);
        LivePlayerView r102 = (LivePlayerView) r100.findViewById(R.id.game_player_view);
    }
}
