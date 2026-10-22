package com.bytedance.android.live.soloktv.karaokestation.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.ordersong.view.KtvMusicTagsView;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.config.d50;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/soloktv/karaokestation/view/SoloKtvSongListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvSongListItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f101301y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MusicPanel f101302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d50 f101303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f101304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f101305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f101306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f101307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f101308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f101309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f101310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f101311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f101312k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f101313l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f101314m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f101315n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f101316o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f101317p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f101318q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f101319r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f101320s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f101321t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f101322u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f101323v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f101324w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.bytedance.android.live.soloktv.karaokestation.view.a f101325x;

    public static final class a {
    }

    public static final class b implements ic0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoloKtvSongListItemViewHolder f101326a;

        public b(SoloKtvSongListItemViewHolder r100) {
            this.f101326a = r100;
        }

        @Override // ic0.a
        public final void a(boolean r100) {
            SoloKtvSongListItemViewHolder r101 = this.f101326a;
            int r102 = SoloKtvSongListItemViewHolder.f101301y;
            r101.X3(r100);
            if (r100 == false) goto L5;
            int r103 = R.string.ttlive_ktv_add_favorite_success;
        L6:
            f2.b(r103, 0);
            MusicPanel r104 = this.f101326a.f101302a;
            if (r104 == null) goto L12;
            KtvMusic r105 = r104.f153577a;
            if (r105 == null) goto L13;
            r105.setFavorite(r100);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r103 = R.string.ttlive_ktv_del_favorite_success;
            goto L6
        }
    }

    static {
    }

    public final View T3() {
        return (View) this.f101314m.getValue();
    }

    public final TextView U3() {
        return (TextView) this.f101308g.getValue();
    }

    public final LinearLayout V3() {
        return (LinearLayout) this.f101307f.getValue();
    }

    public final KtvMusicTagsView W3() {
        return (KtvMusicTagsView) this.f101310i.getValue();
    }

    public final void X3(boolean r100) {
        KtvUtilsKt.L(T3(), r100);
        View r101 = T3();
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        int r102 = R.drawable.ttlive_ktv_selected_music_star_yellow;
    L7:
        r101.setBackgroundResource(r102);
        goto L8
    L6:
        r102 = R.drawable.ttlive_ktv_selected_music_star_grey;
    L8:
        View r103 = T3();
        if (r103 == null) goto L15;
        if (r100 == false) goto L12;
        float r104 = 1.0f;
    L13:
        r103.setAlpha(r104);
        return;
    L12:
        r104 = 0.6f;
        goto L13
    }

    public SoloKtvSongListItemViewHolder(final View r100, com.bytedance.android.live.soloktv.karaokestation.view.a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "songListViewCallback");
        super(r100);
        this.f101325x = r101;
        this.f101303b = d50.f120001a;
        this.f101304c = LazyKt.lazy(new SoloKtvSongListItemViewHolder$musicCover$2(r100));
        this.f101305d = LazyKt.lazy(new SoloKtvSongListItemViewHolder$musicDuration$2(r100));
        Lazy r102 = LazyKt.lazy(new SoloKtvSongListItemViewHolder$musicName$2(r100));
        this.f101306e = r102;
        this.f101307f = LazyKt.lazy(new SoloKtvSongListItemViewHolder$musicScoreContainer$2(r100));
        this.f101308g = LazyKt.lazy(new SoloKtvSongListItemViewHolder$musicScore$2(r100));
        Lazy r103 = LazyKt.lazy(new SoloKtvSongListItemViewHolder$musicAuthor$2(r100));
        this.f101309h = r103;
        this.f101310i = LazyKt.lazy(new SoloKtvSongListItemViewHolder$musicTags$2(r100));
        Lazy r104 = LazyKt.lazy(new SoloKtvSongListItemViewHolder$footerView$2(r100));
        this.f101311j = r104;
        this.f101312k = LazyKt.lazy(new SoloKtvSongListItemViewHolder$musicContentContainer$2(r100));
        this.f101313l = LazyKt.lazy(new SoloKtvSongListItemViewHolder$contentContainer$2(r100));
        this.f101314m = LazyKt.lazy(new SoloKtvSongListItemViewHolder$favoriteView$2(r100));
        Lazy r105 = LazyKt.lazy(new SoloKtvSongListItemViewHolder$selectMusicBtn$2(r100));
        this.f101315n = r105;
        View r106 = r100.findViewById(R.id.rt_chorus_info_container);
        this.f101316o = r106;
        this.f101317p = LazyKt.lazy(new SoloKtvSongListItemViewHolder$rtChorusLiveIv$2(r100));
        this.f101318q = LazyKt.lazy(new SoloKtvSongListItemViewHolder$rtChorusAvatarFl$2(r100));
        this.f101319r = LazyKt.lazy(new SoloKtvSongListItemViewHolder$rtChorusAvatar1Iv$2(r100));
        this.f101320s = LazyKt.lazy(new SoloKtvSongListItemViewHolder$rtChorusAvatar2Iv$2(r100));
        this.f101321t = LazyKt.lazy(new SoloKtvSongListItemViewHolder$rtChorusJoinTv$2(r100));
        this.f101322u = LazyKt.lazy(new SoloKtvSongListItemViewHolder$rtChorusArrowIv$2(r100));
        this.f101323v = LazyKt.lazy(new SoloKtvSongListItemViewHolder$musicInfoLl$2(r100));
        TextView r107 = (TextView) r102.getValue();
        if (r107 == null) goto L5;
        KtvOrderSongThemeManager.d(r107, 10);
    L5:
        TextView r108 = (TextView) r103.getValue();
        if (r108 == null) goto L8;
        KtvOrderSongThemeManager.d(r108, 101);
    L8:
        TextView r109 = U3();
        if (r109 == null) goto L11;
        KtvOrderSongThemeManager.d(r109, 101);
    L11:
        TextView r110 = (TextView) r104.getValue();
        if (r110 == null) goto L14;
        KtvOrderSongThemeManager.d(r110, KtvOrderSongThemeManager.f70202k);
    L14:
        View r111 = T3();
        if (r111 == null) goto L17;
        r111.setOnClickListener(new r(this));
    L17:
        TextView r112 = (TextView) r105.getValue();
        if (r112 == null) goto L20;
        r112.setOnClickListener(x0.a(new SoloKtvSongListItemViewHolder$bindClickListener$2(this)));
    L20:
        if (r106 == null) goto L22;
        r106.setOnClickListener(x0.a(new SoloKtvSongListItemViewHolder$bindClickListener$3(this)));
    L22:
        this.f101324w = new b(this);
    }
}
