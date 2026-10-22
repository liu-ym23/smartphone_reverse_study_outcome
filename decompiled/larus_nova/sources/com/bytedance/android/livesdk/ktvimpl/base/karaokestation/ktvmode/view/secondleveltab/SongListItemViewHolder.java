package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.ordersong.view.KtvMusicTagsView;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.w;
import com.bytedance.android.livesdk.config.d50;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.TriggerType;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.PersonalSongInfo;
import com.bytedance.android.livesdk.message.model.RecommendRealTimeChorusInfo;
import com.bytedance.android.livesdk.message.model.RecommendRealTimeChorusShowUser;
import com.bytedance.android.livesdk.message.model.WantListenInfo;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/SongListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/f;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SongListItemViewHolder extends RecyclerView.ViewHolder implements f {
    public static final /* synthetic */ int B = 0;
    public final e A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MusicPanel f142902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f142903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f142904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f142905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f142906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f142907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f142908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f142909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f142910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f142911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f142912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f142913l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d50 f142914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f142915n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f142916o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f142917p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f142918q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f142919r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f142920s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f142921t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f142922u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f142923v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f142924w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f142925x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f142926y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final a f142927z;

    public final class a implements ic0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SongListItemViewHolder f142928a;

        public a(SongListItemViewHolder r100) {
            this.f142928a = r100;
        }

        @Override // ic0.a
        public final void a(boolean r100) {
            SongListItemViewHolder r101 = this.f142928a;
            int r102 = SongListItemViewHolder.B;
            r101.Y3(r100);
            if (r100 == false) goto L5;
            int r103 = R.string.ttlive_ktv_add_favorite_success;
        L6:
            f2.b(r103, 0);
            MusicPanel r104 = this.f142928a.f142902a;
            if (r104 == null) goto L11;
            KtvMusic r105 = r104.f153577a;
            if (r105 == null) goto L11;
            r105.setFavorite(r100);
        L11:
            if (r100 == false) goto L20;
            SongListItemViewHolder r106 = this.f142928a;
            MusicPanel r107 = r106.f142902a;
            if (r107 == null) goto L21;
            Rect r108 = new Rect();
            int[] r109 = new int[2];
            r106.itemView.getLocationInWindow(r109);
            View r110 = r106.T3();
            if (r110 == null) goto L17;
            r108.left = r109[0] + ((int) r110.getX());
            r108.top = r109[1] + ((int) r110.getY());
            r108.right = r108.left + r110.getWidth();
            r108.bottom = r108.top + r110.getHeight();
        L18:
            Intrinsics.checkNotNullParameter(r108, "<set-?>");
            r107.f153598v = r108;
            return;
        L17:
            r108.left = -1;
            r108.top = -1;
            r108.right = -1;
            r108.bottom = -1;
            goto L18
        L21:
            return;
        L20:
            return;
        L5:
            r103 = R.string.ttlive_ktv_del_favorite_success;
            goto L6
        }
    }

    public final View T3() {
        return (View) this.f142925x.getValue();
    }

    public final TextView U3() {
        return (TextView) this.f142918q.getValue();
    }

    public final TextView V3() {
        return (TextView) this.f142920s.getValue();
    }

    public final TextView W3() {
        return (TextView) this.f142926y.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f
    public final Rect J3() {
        Rect r100 = new Rect();
        int[] r101 = new int[2];
        this.itemView.getLocationInWindow(r101);
        TextView r102 = W3();
        if (r102 == null) goto L5;
        r100.left = r101[0] + ((int) r102.getX());
        r100.top = r101[1] + ((int) r102.getY());
        r100.right = r100.left + r102.getWidth();
        r100.bottom = r100.top + r102.getHeight();
    L6:
        return r100;
    L5:
        r100.left = -1;
        r100.top = -1;
        r100.right = -1;
        r100.bottom = -1;
        goto L6
    }

    public final void X3() {
        StringBuilder r100 = new StringBuilder("trySelectSong:");
        MusicPanel r101 = this.f142902a;
        if (r101 == null) goto L7;
        KtvMusic r102 = r101.f153577a;
        if (r102 == null) goto L7;
        String r103 = r102.getMTitle();
    L8:
        r100.append(r103);
        r100.append('-');
        MusicPanel r104 = this.f142902a;
        if (r104 == null) goto L13;
        KtvMusic r105 = r104.f153577a;
        if (r105 == null) goto L13;
        Object r106 = Long.valueOf(r105.getMId());
    L14:
        r100.append(r106);
        String r107 = r100.toString();
        ALogger.i(bb0.b.b(), r107 + ", invoke class :SongListItemViewHolder");
        if (this.A.d(this.f142902a) == false) goto L20;
        Context r108 = this.itemView.getContext();
        MusicPanel r109 = this.f142902a;
        if (r108 == null) goto L28;
        if (r109 == null) goto L29;
        this.A.h(r108, r109, this);
        return;
    L29:
        return;
    L28:
        return;
    L20:
        MusicPanel r110 = this.f142902a;
        if (r110 == null) goto L25;
        KtvMusic r111 = r110.f153577a;
        if (r111 == null) goto L25;
        long r112 = r111.getMId();
    L26:
        com.bytedance.android.live.ktv.common.util.i.a(r112, -1);
        return;
    L25:
        r112 = 0;
    L13:
        r106 = "null";
    L7:
        r103 = null;
        goto L8
    }

    public final void Y3(boolean r100) {
        KtvUtilsKt.L(T3(), r100);
        View r101 = T3();
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        int r102 = R.drawable.ttlive_ktv_selected_music_star_yellow;
    L7:
        r101.setBackgroundResource(r102);
        goto L8
    L6:
        r102 = KtvOrderSongThemeManager.a(103);
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

    public final void Z3(boolean r100) {
        if (r100 == false) goto L18;
        TextView r101 = W3();
        if (r101 == null) goto L6;
        r101.setClickable(false);
    L6:
        TextView r102 = W3();
        if (r102 == null) goto L9;
        KtvOrderSongThemeManager.c(r102, 102);
    L9:
        TextView r103 = W3();
        if (r103 == null) goto L12;
        r103.setText(s1.B(R.string.ttlive_ktv_tab_selected));
    L12:
        TextView r104 = W3();
        if (r104 == null) goto L15;
        r104.setTextColor(s1.h(R.color.ttlive_ktv_music_selected_font_color));
    L15:
        TextView r105 = W3();
        if (r105 == null) goto L35;
        KtvOrderSongThemeManager.d(r105, 106);
        return;
    L35:
        return;
    L18:
        TextView r106 = W3();
        if (r106 == null) goto L21;
        r106.setClickable(true);
    L21:
        TextView r107 = W3();
        if (r107 == null) goto L24;
        r107.setBackgroundResource(R.drawable.ttlive_bg_ktv_red_bt);
    L24:
        String r108 = this.A.g();
        TextView r109 = W3();
        if (r109 != null) goto L27;
    L31:
        TextView r110 = W3();
        if (r110 == null) goto L37;
        r110.setTextColor(s1.h(R.color.ttlive_ktv_music_select_font_color));
        return;
    L37:
        return;
    L27:
        if (TextUtils.isEmpty(r108) == false) goto L30;
        r108 = s1.B(R.string.ttlive_ktv_tab_select);
    L30:
        r109.setText(r108);
        goto L31
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f
    public final void v0(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        MusicPanel r101 = this.f142902a;
        if (r101 == null) goto L30;
        KtvMusic r102 = r101.f153577a;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.getMId() != r100.f153577a.getMId()) goto L35;
        int r103 = r100.f153578b;
        int r104 = r100.f153595s;
        if (r103 != 1) goto L12;
        Z3(false);
        return;
    L12:
        if (r103 != 2) goto L14;
        TextView r105 = W3();
        if (r105 == null) goto L22;
        KtvOrderSongThemeManager.c(r105, 102);
    L22:
        TextView r106 = W3();
        if (r106 == null) goto L25;
        r106.setTextColor(s1.h(R.color.ttlive_ktv_music_selected_font_color));
    L25:
        TextView r107 = W3();
        if (r107 == null) goto L33;
        r107.setText(s1.C(R.string.ttlive_ktv_download_progress, new Object[]{Integer.valueOf(r104)}));
        return;
    L33:
        return;
    L14:
        if (r103 != 4) goto L16;
    L18:
        Z3(true);
        return;
    L16:
        if (r103 == 5) goto L18;
        return;
    L35:
        return;
    }

    public SongListItemViewHolder(final View r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "songListViewCallback");
        super(r100);
        this.A = r101;
        View r102 = r100.findViewById(R.id.rt_chorus_info_container);
        this.f142903b = r102;
        this.f142904c = LazyKt.lazy(new SongListItemViewHolder$rtChorusLiveIv$2(r100));
        this.f142905d = LazyKt.lazy(new SongListItemViewHolder$rtChorusAvatarFl$2(r100));
        this.f142906e = LazyKt.lazy(new SongListItemViewHolder$rtChorusAvatar1Iv$2(r100));
        this.f142907f = LazyKt.lazy(new SongListItemViewHolder$rtChorusAvatar2Iv$2(r100));
        this.f142908g = LazyKt.lazy(new SongListItemViewHolder$rtChorusJoinTv$2(r100));
        this.f142909h = LazyKt.lazy(new SongListItemViewHolder$rtChorusArrowIv$2(r100));
        this.f142910i = LazyKt.lazy(new SongListItemViewHolder$musicInfoLl$2(r100));
        this.f142911j = r100.findViewById(R.id.want_listen_container);
        this.f142912k = LazyKt.lazy(new SongListItemViewHolder$wantListenIv$2(r100));
        this.f142913l = LazyKt.lazy(new SongListItemViewHolder$wantListenTv$2(r100));
        this.f142914m = d50.f120001a;
        this.f142915n = LazyKt.lazy(new SongListItemViewHolder$musicCover$2(r100));
        this.f142916o = LazyKt.lazy(new SongListItemViewHolder$musicAudition$2(r100));
        this.f142917p = LazyKt.lazy(new SongListItemViewHolder$musicDuration$2(r100));
        this.f142918q = LazyKt.lazy(new SongListItemViewHolder$musicName$2(r100));
        this.f142919r = LazyKt.lazy(new SongListItemViewHolder$musicScoreContainer$2(r100));
        this.f142920s = LazyKt.lazy(new SongListItemViewHolder$musicScore$2(r100));
        Lazy r103 = LazyKt.lazy(new SongListItemViewHolder$musicAuthor$2(r100));
        this.f142921t = r103;
        this.f142922u = LazyKt.lazy(new SongListItemViewHolder$musicTags$2(r100));
        Lazy r104 = LazyKt.lazy(new SongListItemViewHolder$footerView$2(r100));
        this.f142923v = r104;
        Lazy r105 = LazyKt.lazy(new SongListItemViewHolder$contentContainer$2(r100));
        this.f142924w = r105;
        this.f142925x = LazyKt.lazy(new SongListItemViewHolder$favoriteView$2(r100));
        this.f142926y = LazyKt.lazy(new SongListItemViewHolder$selectMusicBtn$2(r100));
        TextView r106 = U3();
        if (r106 == null) goto L5;
        KtvOrderSongThemeManager.d(r106, 10);
    L5:
        TextView r107 = (TextView) r103.getValue();
        if (r107 == null) goto L8;
        KtvOrderSongThemeManager.d(r107, 101);
    L8:
        TextView r108 = V3();
        if (r108 == null) goto L11;
        KtvOrderSongThemeManager.d(r108, 101);
    L11:
        TextView r109 = (TextView) r104.getValue();
        if (r109 == null) goto L14;
        KtvOrderSongThemeManager.d(r109, KtvOrderSongThemeManager.f70202k);
    L14:
        KtvUtilsKt.b(U3());
        KtvUtilsKt.b((TextView) r103.getValue());
        ConstraintLayout r110 = (ConstraintLayout) r105.getValue();
        if (r110 == null) goto L17;
        r110.setOnClickListener(new l(this));
    L17:
        View r111 = T3();
        if (r111 == null) goto L20;
        r111.setOnClickListener(x0.a(new SongListItemViewHolder$bindClickListener$2(this)));
    L20:
        TextView r112 = W3();
        if (r112 == null) goto L23;
        r112.setOnClickListener(x0.a(new SongListItemViewHolder$bindClickListener$3(this)));
    L23:
        if (r102 == null) goto L25;
        r102.setOnClickListener(x0.a(new SongListItemViewHolder$bindClickListener$4(this)));
    L25:
        this.f142927z = new a(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f
    public final void G1(MusicPanel r210, TriggerType r211) {
        Intrinsics.checkNotNullParameter(r211, "type");
        MusicPanel r100 = this.f142902a;
        if (r100 == null) goto L5;
        KtvMusic r101 = r100.f153577a;
    L6:
        if (r210 == null) goto L8;
        KtvMusic r102 = r210.f153577a;
    L9:
        boolean r103 = Intrinsics.areEqual(r101, r102);
        this.f142902a = r210;
        boolean r104 = false;
        String r105 = "";
        if (r103 == true) goto L149;
        if (r210 != null) goto L13;
    L23:
        TextView r106 = (TextView) this.f142923v.getValue();
        if (r106 == null) goto L26;
        r106.setVisibility(8);
    L26:
        ConstraintLayout r107 = (ConstraintLayout) this.f142924w.getValue();
        if (r107 == null) goto L29;
        r107.setVisibility(0);
    L29:
        float r108 = 0.0f;
        if (r210 == null) goto L36;
        KtvMusic r110 = r210.f153577a;
        if (r110 == null) goto L36;
        PersonalSongInfo r111 = r110.getPersonalSongInfo();
        if (r111 == null) goto L36;
        float r112 = (float) r111.getMidiScore();
    L38:
        if (r112 <= 0.0f) goto L80;
        TextView r113 = U3();
        if (r113 == null) goto L42;
        r113.setMaxWidth((int) s1.e(120.0f));
    L42:
        TextView r114 = V3();
        if (r114 == null) goto L46;
        StringBuilder r115 = new StringBuilder();
        DecimalFormat r116 = new DecimalFormat("0.#");
        r116.setRoundingMode(RoundingMode.FLOOR);
        r115.append(r116.format(Float.valueOf(r112)));
        r115.append(20998);
        r114.setText(r115.toString());
    L46:
        if (this.f142914m.getValue().booleanValue() == false) goto L65;
        if (r210 == null) goto L65;
        KtvMusic r117 = r210.f153577a;
        if (r117 == null) goto L65;
        PersonalSongInfo r118 = r117.getPersonalSongInfo();
        if (r118 == null) goto L65;
        if (r118.isHighScoreSong().booleanValue() != true) goto L65;
        TextView r119 = V3();
        if (r119 == null) goto L62;
        TextPaint r120 = r119.getPaint();
        if (r120 == null) goto L62;
        TextView r121 = V3();
        if (r121 == null) goto L61;
        r108 = r121.getWidth();
    L61:
        r120.setShader(new LinearGradient(0.0f, 0.0f, r108, 0.0f, ColorProtector.parseColor("#C956FF"), ColorProtector.parseColor("#6E56FF"), Shader.TileMode.CLAMP));
    L62:
        LinearLayout r109 = (LinearLayout) this.f142919r.getValue();
        if (r109 == null) goto L77;
        r109.setBackground(s1.m(R.drawable.ttlive_bg_ktv_high_score_song_label_container));
    L77:
        LinearLayout r122 = (LinearLayout) this.f142919r.getValue();
        if (r122 == null) goto L86;
        r122.setVisibility(0);
    L86:
        TextView r123 = U3();
        if (r123 == null) goto L97;
        if (r210 == null) goto L95;
        KtvMusic r124 = r210.f153577a;
        if (r124 == null) goto L95;
        String r125 = r124.getMTitle();
        if (r125 == null) goto L95;
        String r126 = StringsKt.trimStart(r125).toString();
        if (r126 == null) goto L95;
    L96:
        r3.c(U3(), r126, false);
        Unit r127 = Unit.INSTANCE;
        com.bytedance.android.live.ktv.common.util.a.f(r123, r126, this.A.b(), this.A.a());
    L95:
        r126 = "";
    L97:
        TextView r128 = (TextView) this.f142921t.getValue();
        if (r128 == null) goto L108;
        if (r210 == null) goto L106;
        KtvMusic r129 = r210.f153577a;
        if (r129 == null) goto L106;
        String r130 = r129.getMAuthor();
        if (r130 == null) goto L106;
        String r131 = StringsKt.trimStart(r130).toString();
        if (r131 == null) goto L106;
    L107:
        r3.c((TextView) this.f142921t.getValue(), r131, false);
        Unit r132 = Unit.INSTANCE;
        r128.setText(r131);
    L106:
        r131 = "";
    L108:
        TextView r133 = (TextView) this.f142921t.getValue();
        if (r133 == null) goto L111;
        r133.setVisibility(0);
    L111:
        HSImageView r134 = (HSImageView) this.f142915n.getValue();
        if (r210 == null) goto L116;
        KtvMusic r135 = r210.f153577a;
        if (r135 == null) goto L116;
        String r136 = r135.getCoverUrl();
    L117:
        ImageLoader.bindImage(r134, r136, s1.f(28.0f), s1.f(28.0f));
        List<String> r137 = com.bytedance.android.live.ktv.common.util.a.d(r210);
        if ((!r137.isEmpty()) == false) goto L125;
        KtvMusicTagsView r138 = (KtvMusicTagsView) this.f142922u.getValue();
        if (r138 == null) goto L122;
        r138.setVisibility(0);
    L122:
        KtvMusicTagsView r139 = (KtvMusicTagsView) this.f142922u.getValue();
        if (r139 == null) goto L128;
        int r140 = KtvMusicTagsView.f70220a;
        r139.a(r137, false);
    L128:
        if (r210 == null) goto L132;
        KtvMusic r141 = r210.f153577a;
        if (r141 == null) goto L132;
        long r142 = r141.getMDuration();
    L134:
        if (r142 <= 0) goto L146;
        TextView r143 = (TextView) this.f142917p.getValue();
        if (r143 == null) goto L138;
        r143.setVisibility(0);
    L138:
        KtvMusic.a r144 = KtvMusic.Companion;
        if (r210 == null) goto L141;
        KtvMusic r145 = r210.f153577a;
    L142:
        r144.getClass();
        long r146 = KtvMusic.a.a(r145);
        TextView r147 = (TextView) this.f142917p.getValue();
        if (r147 == null) goto L145;
        StringCompanionObject r148 = StringCompanionObject.INSTANCE;
        long r149 = 60;
        r147.setText(String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r146 / r149), Long.valueOf(r146 % r149)}, 2)));
    L145:
        KtvUtilsKt.M((TextView) this.f142917p.getValue(), r146);
        goto L149
    L141:
        r145 = null;
        goto L142
    L146:
        TextView r150 = (TextView) this.f142917p.getValue();
        if (r150 == null) goto L149;
        r150.setVisibility(8);
    L132:
        r142 = 0;
        goto L134
    L125:
        KtvMusicTagsView r151 = (KtvMusicTagsView) this.f142922u.getValue();
        if (r151 == null) goto L128;
        r151.setVisibility(8);
    L116:
        r136 = null;
    L65:
        TextView r152 = V3();
        if (r152 == null) goto L74;
        TextPaint r153 = r152.getPaint();
        if (r153 == null) goto L74;
        TextView r154 = V3();
        if (r154 == null) goto L72;
        float r155 = r154.getWidth();
    L73:
        r153.setShader(new LinearGradient(0.0f, 0.0f, r155, 0.0f, ColorProtector.parseColor("#161823"), ColorProtector.parseColor("#161823"), Shader.TileMode.CLAMP));
        goto L74
    L72:
        r155 = 0.0f;
    L74:
        LinearLayout r156 = (LinearLayout) this.f142919r.getValue();
        if (r156 == null) goto L77;
        r156.setBackground(s1.m(R.drawable.ttlive_bg_ktv_normal_score_song_label_container));
        goto L77
    L80:
        TextView r157 = U3();
        if (r157 == null) goto L83;
        r157.setMaxWidth((int) s1.e(150.0f));
    L83:
        LinearLayout r158 = (LinearLayout) this.f142919r.getValue();
        if (r158 == null) goto L86;
        r158.setVisibility(8);
    L36:
        r112 = 0.0f;
        goto L38
    L13:
        if (r210.f153597u != true) goto L23;
        if (this.A.e() == true) goto L19;
        TextView r159 = (TextView) this.f142923v.getValue();
        if (r159 == null) goto L19;
        r159.setVisibility(0);
    L19:
        ConstraintLayout r160 = (ConstraintLayout) this.f142924w.getValue();
        if (r160 == null) goto L292;
        r160.setVisibility(8);
        return;
    L292:
        return;
    L149:
        if (r210 == null) goto L155;
        KtvMusic r161 = r210.f153577a;
        if (r161 == null) goto L155;
        WantListenInfo r162 = r161.getWantListenInfo();
        if (r162 == null) goto L155;
        long r163 = r162.getWantListenCount().longValue();
    L157:
        if (r163 <= 0) goto L167;
        View r164 = this.f142911j;
        if (r164 == null) goto L161;
        UtilityKotlinExtentionsKt.w(r164);
    L161:
        KtvMusicTagsView r165 = (KtvMusicTagsView) this.f142922u.getValue();
        if (r165 == null) goto L164;
        UtilityKotlinExtentionsKt.t(r165);
    L164:
        TextView r166 = (TextView) this.f142913l.getValue();
        if (r166 == null) goto L170;
        r166.setText(w.a(r210));
    L170:
        if (r210 == null) goto L186;
        int r167 = r210.f153587k;
        if (r167 != 200) goto L174;
        HSImageView r168 = (HSImageView) this.f142916o.getValue();
        if (r168 == null) goto L185;
        r168.setVisibility(0);
    L185:
        ImageUtil.loadImage((HSImageView) this.f142916o.getValue(), Integer.valueOf(R.drawable.ttlive_ic_music_audition_playing), ImageView.ScaleType.CENTER_INSIDE);
        goto L186
    L174:
        if (r167 == 300) goto L178;
        HSImageView r169 = (HSImageView) this.f142916o.getValue();
        if (r169 == null) goto L186;
        r169.setVisibility(8);
        goto L186
    L178:
        HSImageView r170 = (HSImageView) this.f142916o.getValue();
        if (r170 == null) goto L181;
        r170.setVisibility(0);
    L181:
        ImageUtil.loadImage((HSImageView) this.f142916o.getValue(), Integer.valueOf(R.drawable.ttlive_ic_music_audition_pause), ImageView.ScaleType.CENTER_INSIDE);
    L186:
        View r171 = T3();
        if (r171 == null) goto L194;
        if (this.A.f() == false) goto L191;
        int r172 = 0;
    L192:
        r171.setVisibility(r172);
        goto L194
    L191:
        r172 = 8;
    L194:
        if (KtvSettingHelper.t() == false) goto L276;
        if (r210 == null) goto L199;
        KtvMusic r173 = r210.f153577a;
        if (r173 == null) goto L199;
        List<RecommendRealTimeChorusInfo> r174 = r173.getRecommendRealTimeChorusInfos();
    L201:
        if (Lists.notEmpty(r174) == false) goto L276;
        View r175 = this.f142903b;
        if (r175 == null) goto L205;
        UtilityKotlinExtentionsKt.w(r175);
    L205:
        String r176 = (String) KtvSettingHelper.f70626h0.getValue();
        if (r176 == null) goto L216;
        String r177 = com.bytedance.android.live.ktv.common.util.n.a(r176);
        if (r177 == null) goto L216;
        PipelineDraweeControllerBuilder r178 = Fresco.newDraweeControllerBuilder();
        HSImageView r179 = (HSImageView) this.f142904c.getValue();
        if (r179 == null) goto L212;
        DraweeController r180 = r179.getController();
    L213:
        AbstractDraweeController r181 = r178.setOldController(r180).setUri(UriProtector.parse(r177)).setAutoPlayAnimations(true).setControllerListener(new m()).build();
        HSImageView r182 = (HSImageView) this.f142904c.getValue();
        if (r182 == null) goto L216;
        r182.setController(r181);
        goto L216
    L212:
        r180 = null;
    L216:
        if (r210 == null) goto L222;
        KtvMusic r183 = r210.f153577a;
        if (r183 == null) goto L222;
        List<RecommendRealTimeChorusInfo> r184 = r183.getRecommendRealTimeChorusInfos();
        if (r184 == null) goto L222;
        RecommendRealTimeChorusInfo r185 = (RecommendRealTimeChorusInfo) CollectionsKt.getOrNull(r184, 0);
    L223:
        if (r185 == null) goto L259;
        List<RecommendRealTimeChorusShowUser> r186 = r185.getShowUsers();
        if (r186 == null) goto L259;
        HSImageView r187 = (HSImageView) this.f142906e.getValue();
        RecommendRealTimeChorusShowUser r188 = (RecommendRealTimeChorusShowUser) CollectionsKt.getOrNull(r186, 0);
        if (r188 == null) goto L229;
        py.k r189 = r188.getAvatarThumb();
    L230:
        if (r187 == null) goto L233;
        if (r189 == null) goto L233;
        ImageUtil.loadRoundImage(r187, r189);
    L233:
        HSImageView r190 = (HSImageView) this.f142907f.getValue();
        RecommendRealTimeChorusShowUser r191 = (RecommendRealTimeChorusShowUser) CollectionsKt.getOrNull(r186, 1);
        if (r191 == null) goto L236;
        py.k r192 = r191.getAvatarThumb();
    L237:
        if (r190 == null) goto L241;
        if (r192 == null) goto L241;
        ImageUtil.loadRoundImage(r190, r192);
    L241:
        if (r186.size() != 0) goto L243;
    L253:
        HSImageView r193 = (HSImageView) this.f142906e.getValue();
        if (r193 == null) goto L256;
        r193.setVisibility(0);
    L256:
        HSImageView r194 = (HSImageView) this.f142907f.getValue();
        if (r194 == null) goto L259;
        r194.setVisibility(8);
        goto L259
    L243:
        if (r186.size() == 1) goto L253;
        if (r186.size() != 2) goto L259;
        HSImageView r195 = (HSImageView) this.f142906e.getValue();
        if (r195 == null) goto L250;
        r195.setVisibility(0);
    L250:
        HSImageView r196 = (HSImageView) this.f142907f.getValue();
        if (r196 == null) goto L259;
        r196.setVisibility(0);
        goto L259
    L236:
        r192 = null;
        goto L237
    L229:
        r189 = null;
    L259:
        TextView r197 = (TextView) this.f142908g.getValue();
        if (r197 == null) goto L267;
        if (r185 == null) goto L265;
        String r198 = r185.getDesc();
        if (r198 == null) goto L265;
    L266:
        r197.setText(r198);
    L265:
        r198 = "";
    L267:
        View r199 = this.f142903b;
        if (r185 == null) goto L273;
        String r200 = r185.getDesc();
        if (r200 == null) goto L273;
        r105 = r200;
    L273:
        r3.c(r199, r105, true);
        LinearLayout r201 = (LinearLayout) this.f142910i.getValue();
        if (r201 == null) goto L282;
        r201.setDividerDrawable(s1.m(R.drawable.ttlive_bg_music_info_three_line_divider));
    L282:
        if (r210 == null) goto L288;
        KtvMusic r202 = r210.f153577a;
        if (r202 == null) goto L288;
        if (r202.isFavorite() != true) goto L288;
        r104 = true;
    L288:
        Y3(r104);
        if (r210 == null) goto L293;
        v0(r210);
        return;
    L293:
        return;
    L222:
        r185 = null;
    L199:
        r174 = null;
    L276:
        View r203 = this.f142903b;
        if (r203 == null) goto L279;
        UtilityKotlinExtentionsKt.t(r203);
    L279:
        LinearLayout r204 = (LinearLayout) this.f142910i.getValue();
        if (r204 == null) goto L282;
        r204.setDividerDrawable(s1.m(R.drawable.ttlive_bg_music_info_two_line_divider));
        goto L282
    L167:
        View r205 = this.f142911j;
        if (r205 == null) goto L170;
        UtilityKotlinExtentionsKt.t(r205);
    L155:
        r163 = 0;
        goto L157
    L8:
        r102 = null;
        goto L9
    L5:
        r101 = null;
        goto L6
    }
}
