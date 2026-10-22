package com.bytedance.android.gamecp.business.comment.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.business.comment.CommentExpandableTextView;
import com.bytedance.android.gamecp.business.comment.CommentImageSummaryAdapter;
import com.bytedance.android.gamecp.business.imagechoose.GridSpacingItemDecoration;
import com.bytedance.android.gamecp.business.view.GamePromoteCommonRatingBar;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.common.ui.UserAvatarImageView;
import com.bytedance.android.gamecp.common.ui.t;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.model.ImageModel;
import com.bytedance.android.gamecp.host_api.model.ImageModelLive;
import com.bytedance.android.gamecp.host_api.model.user.User;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/adapter/GamePromoteCommentDetailViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GamePromoteCommentDetailViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int O = 0;
    public final TextView A;
    public int B;
    public int C;
    public Drawable D;
    public Drawable E;
    public final Drawable F;
    public final Drawable G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f51941J;
    public com.bytedance.android.gamecp.common.track.monitor.a K;
    public com.bytedance.android.gamecp.common.track.monitor.a L;
    public final GridSpacingItemDecoration M;
    public int N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UserAvatarImageView f51942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f51943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f51944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommentExpandableTextView f51945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f51946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f51947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f51948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f51949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f51950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f51951j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageView f51952k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConstraintLayout f51953l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f51954m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ConstraintLayout f51955n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ConstraintLayout f51956o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextView f51957p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConstraintLayout f51958q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final GamePromoteCommonRatingBar f51959r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ConstraintLayout f51960s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RecyclerView f51961t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HSImageView f51962u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ImageView f51963v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final View f51964w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ImageView f51965x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f51966y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CommentImageSummaryAdapter f51967z;

    public static final class a {
    }

    static {
    }

    public GamePromoteCommentDetailViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f51942a = (UserAvatarImageView) r100.findViewById(R.id.iv_comment_detail_item_avatar);
        this.f51943b = (TextView) r100.findViewById(R.id.tv_comment_detail_item_nickname);
        this.f51944c = (TextView) r100.findViewById(R.id.tv_comment_detail_item_time);
        this.f51945d = (CommentExpandableTextView) r100.findViewById(R.id.tv_comment_detail_item_content);
        this.f51946e = (TextView) r100.findViewById(R.id.tv_comment_detail_item_like_count);
        this.f51947f = (TextView) r100.findViewById(R.id.tv_comment_detail_item_dislike_count);
        this.f51948g = (TextView) r100.findViewById(R.id.tv_comment_detail_item_come_from_phone_model);
        this.f51949h = (TextView) r100.findViewById(R.id.tv_comment_detail_item_phone_model);
        this.f51950i = (ImageView) r100.findViewById(R.id.iv_comment_detail_item_like);
        this.f51951j = (ImageView) r100.findViewById(R.id.iv_comment_detail_item_dislike);
        this.f51952k = (ImageView) r100.findViewById(R.id.iv_selected_comment);
        this.f51953l = (ConstraintLayout) r100.findViewById(R.id.cl_comment_detail_item_secondary_reply_container);
        this.f51954m = (TextView) r100.findViewById(R.id.tv_comment_detail_item_secondary_reply);
        this.f51955n = (ConstraintLayout) r100.findViewById(R.id.cl_comment_detail_item_like_container);
        this.f51956o = (ConstraintLayout) r100.findViewById(R.id.cl_comment_detail_item_dislike_container);
        this.f51957p = (TextView) r100.findViewById(R.id.tv_comment_detail_item_reply_count);
        ImageView r101 = (ImageView) r100.findViewById(R.id.iv_comment_detail_item_reply);
        this.f51958q = (ConstraintLayout) r100.findViewById(R.id.cl_comment_detail_item_reply_container);
        this.f51959r = (GamePromoteCommonRatingBar) r100.findViewById(R.id.ratingbar_comment_detail_item);
        this.f51960s = (ConstraintLayout) r100.findViewById(R.id.cl_comment_detail_item_image_container);
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.rv_game_comment_images);
        this.f51961t = r102;
        this.f51962u = (HSImageView) r100.findViewById(R.id.iv_single_image);
        this.f51963v = (ImageView) r100.findViewById(R.id.iv_image_failed);
        this.f51964w = r100.findViewById(R.id.v_bottom_line);
        this.f51965x = (ImageView) r100.findViewById(R.id.iv_comment_detail_item_option);
        CommentImageSummaryAdapter r103 = new CommentImageSummaryAdapter(r100.getContext());
        this.f51967z = r103;
        this.A = (TextView) r100.findViewById(R.id.tv_comment_user_title);
        this.B = y0.c(R.color.gamecp_douyin_light_Link);
        this.C = y0.c(R.color.gamecp_game_80161823);
        this.D = y0.e(R.drawable.gamecp_ic_game_promote_comment_liked_v2);
        this.E = y0.e(R.drawable.gamecp_ic_game_promote_comment_like_v2);
        this.F = y0.e(R.drawable.gamecp_ic_game_promote_comment_disliked);
        this.G = y0.e(R.drawable.gamecp_ic_game_promote_comment_dislike);
        this.f51941J = true;
        r102.setAdapter(r103);
        int r104 = UtilityKotlinExtentionsKt.c(4);
        this.N = 3;
        GridSpacingItemDecoration r105 = new GridSpacingItemDecoration(3, r104);
        this.M = r105;
        r102.setLayoutManager(new GridLayoutManager(null, 3));
        r102.addItemDecoration(r105);
    }

    public final void T3(com.bytedance.android.gamecp.business.comment.data.b r110) {
        RecyclerView.LayoutManager r100 = null;
        ImageModel r101 = null;
        RecyclerView.LayoutManager r102 = null;
        if (r110 == null) goto L5;
        User r103 = r110.a();
    L6:
        if (r103 == null) goto L8;
        String r104 = r103.getIdStr();
    L9:
        bw.p r105 = com.bytedance.android.gamecp.host_api.a.b().getUserService();
        if (r105 == null) goto L14;
        hw.b r106 = r105.user();
        if (r106 == null) goto L14;
        String r107 = r106.getCurrentUserId();
    L16:
        if (TextUtils.equals(r104, r107.toString()) == true) goto L18;
    L20:
        UtilityKotlinExtentionsKt.h(this.f51965x);
    L21:
        if (r110 == null) goto L23;
        com.bytedance.android.gamecp.business.comment.data.o r108 = r110.evaluationInfo;
    L24:
        this.itemView.setTag(r110);
        TextView r109 = this.f51943b;
        if (r103 == null) goto L27;
        String r111 = r103.getNickName();
    L28:
        r109.setText(r111);
        TextView r112 = this.f51944c;
        int r113 = yt.d.f569003a;
        if (r108 == null) goto L31;
        long r114 = r108.submitTime * ((long) 1000);
    L32:
        r112.setText(yt.d.a(r114));
        ImageView r115 = this.f51952k;
        if (r108 != null) goto L35;
    L37:
        int r116 = 8;
    L38:
        r115.setVisibility(r116);
        if (r108 == null) goto L48;
        String r117 = r108.deviceSeries;
        if (r117 == null) goto L48;
        if (r117.length() <= 0) goto L45;
        boolean r118 = true;
    L46:
        if (r118 != true) goto L48;
        this.f51948g.setVisibility(0);
        this.f51949h.setVisibility(0);
        this.f51949h.setText(r108.deviceSeries);
    L50:
        if (r110 == null) goto L77;
        com.bytedance.android.gamecp.business.comment.data.m r119 = r110.userExtra;
        if (r119 == null) goto L77;
        String r120 = r119.title;
        if (r120 == null) goto L77;
        if (r120.length() <= 0) goto L58;
        boolean r121 = true;
    L59:
        if (r121 != true) goto L77;
        this.A.setVisibility(0);
        TextView r122 = this.A;
        com.bytedance.android.gamecp.business.comment.data.m r123 = r110.userExtra;
        if (r123 == null) goto L63;
        String r124 = r123.title;
    L64:
        r122.setText(r124);
        ViewGroup.LayoutParams r125 = this.f51943b.getLayoutParams();
        if (r125 == null) goto L76;
        ConstraintLayout.LayoutParams r126 = (ConstraintLayout.LayoutParams) r125;
        CharSequence r127 = this.f51943b.getText();
        if (r127 == null) goto L69;
        int r128 = r127.length();
    L71:
        if (r128 > 15) goto L73;
        r126.endToStart = R.id.iv_selected_comment;
    L74:
        this.f51943b.setLayoutParams(r126);
    L80:
        if (r110 == null) goto L82;
        List<com.bytedance.android.gamecp.business.comment.data.s> r129 = r110.outsideReplyInfo;
    L83:
        Y3(r129);
        if (r108 == null) goto L86;
        String r130 = r108.content;
    L87:
        if (r110 == null) goto L89;
        List<com.bytedance.android.gamecp.business.comment.data.h> r131 = r110.commentHighlightIndex;
    L90:
        U3(r130, r131);
        if (r108 == null) goto L93;
        Long r132 = Long.valueOf(r108.likeCount);
    L94:
        X3(r132);
        if (r108 == null) goto L97;
        Long r133 = Long.valueOf(r108.dislikeCount);
    L98:
        V3(r133);
        if (r108 == null) goto L101;
        Long r134 = Long.valueOf(r108.commentCount);
    L102:
        Z3(r134);
        if (r108 == null) goto L105;
        Double r135 = Double.valueOf(r108.score);
    L106:
        if (r135 != null) goto L108;
    L111:
        this.f51959r.setProgress(0);
        this.f51959r.setVisibility(8);
    L112:
        if (r108 == null) goto L114;
        Long r136 = Long.valueOf(r108.relationTypeFlag);
    L115:
        W3(r136);
        Context r137 = this.itemView.getContext();
        if (r103 == null) goto L118;
        ImageModel r138 = r103.mo8159getAvatarMedium();
    L119:
        UserAvatarImageView r139 = this.f51942a;
        if (r110 == null) goto L124;
        User r140 = r110.a();
        if (r140 == null) goto L124;
        String r141 = r140.getIdStr();
    L125:
        r139.getClass();
        fu.j.b(r139, r138);
        r139.setOnClickListener(new com.bytedance.android.gamecp.common.ui.s(r139, r137, r141));
        t r142 = new t();
        Intrinsics.checkNotNullParameter(PullConfiguration.PROCESS_NAME_MAIN, "<set-?>");
        r142.f57152a = PullConfiguration.PROCESS_NAME_MAIN;
        String r143 = "";
        if (r110 == null) goto L131;
        com.bytedance.android.gamecp.business.comment.data.o r144 = r110.evaluationInfo;
        if (r144 == null) goto L131;
        String r145 = r144.evalId;
        if (r145 == null) goto L131;
    L132:
        Intrinsics.checkNotNullParameter(r145, "<set-?>");
        r142.f57153b = r145;
        if (r110 == null) goto L138;
        com.bytedance.android.gamecp.business.comment.data.o r146 = r110.evaluationInfo;
        if (r146 == null) goto L138;
        String r147 = r146.gameId;
        if (r147 == null) goto L138;
    L139:
        Intrinsics.checkNotNullParameter(r147, "<set-?>");
        r142.f57155d = r147;
        HashMap<String, String> r148 = GamecpTracker.f56755a;
        com.bytedance.android.gamecp.common.track.filter.d r149 = GamecpTracker.h(zu.a.class);
        if ((r149 instanceof com.bytedance.android.gamecp.common.track.filter.b) == true) goto L142;
        r149 = null;
    L142:
        com.bytedance.android.gamecp.common.track.filter.b r150 = (com.bytedance.android.gamecp.common.track.filter.b) r149;
        if (r150 == null) goto L145;
        r143 = r150.f();
    L145:
        Intrinsics.checkNotNullParameter(r143, "<set-?>");
        r142.f57156e = r143;
        this.f51942a.setTrackData(r142);
        if (r108 == null) goto L148;
        List<ImageModelLive> r151 = r108.imageList;
    L149:
        if (r151 == null) goto L151;
        int r152 = r151.size();
    L152:
        if (r152 != 0) goto L154;
        this.f51967z.setData(null);
        UtilityKotlinExtentionsKt.h(this.f51960s);
        return;
    L154:
        if (r152 != 1) goto L220;
        this.f51967z.setData(null);
        UtilityKotlinExtentionsKt.h(this.f51960s);
        UtilityKotlinExtentionsKt.h(this.f51961t);
        UtilityKotlinExtentionsKt.h(this.f51962u);
        UtilityKotlinExtentionsKt.h(this.f51963v);
        if (r151 == null) goto L158;
        r101 = (ImageModel) ListProtector.get(r151, 0);
    L158:
        if (r101 == null) goto L160;
        final int r153 = r101.getWidth();
    L161:
        if (r101 == null) goto L163;
        final int r154 = r101.getHeight();
    L164:
        if (r153 == 0) goto L167;
        if (r154 == 0) goto L167;
        boolean r155 = true;
    L168:
        if (r155 == false) goto L251;
        HSImageView r156 = this.f51962u;
        if (r153 <= r154) goto L173;
        int r157 = UtilityKotlinExtentionsKt.c(233);
        int r158 = (r154 * r157) / r153;
    L174:
        if (r156 == null) goto L183;
        ViewGroup.LayoutParams r159 = r156.getLayoutParams();
        if (r159 == null) goto L183;
        if (r159.width == r157) goto L181;
        r159.width = r157;
    L181:
        if (r159.height == r158) goto L183;
        r159.height = r158;
    L183:
        if (r153 <= r154) goto L188;
        int r160 = r153;
        int r161 = 1;
    L186:
        if (r160 <= 466) goto L192;
        r160 = r160 / 2;
        r161 = r161 * 2;
    L192:
        final int r162 = r161;
        final ImageModel r163 = r101;
        Function1<y.a, Unit> r164 = new GamePromoteCommentDetailViewHolder$renderImage$loadImageAction$1(this, r163, r153, r162, r154);
        r164.invoke(new q(this));
        UtilityKotlinExtentionsKt.j(this.f51960s);
        UtilityKotlinExtentionsKt.j(this.f51962u);
        ArrayList r165 = new ArrayList();
        if (r101 == null) goto L197;
        List<String> r166 = r101.getUrls();
        if (r166 == null) goto L197;
        int r167 = r166.size();
    L198:
        String r168 = "empty url";
        if (r167 == 0) goto L217;
        if (r167 == 1) goto L209;
        if (r101 == null) goto L208;
        List<String> r169 = r101.getUrls();
        if (r169 == null) goto L208;
        String r170 = (String) ListProtector.get(r169, 1);
        if (r170 == null) goto L208;
        r168 = r170;
    L208:
        r165.add(r168);
    L218:
        this.f51962u.setOnClickListener(new r(this, r165, r155, r164));
        return;
    L209:
        if (r101 == null) goto L216;
        List<String> r171 = r101.getUrls();
        if (r171 == null) goto L216;
        String r172 = (String) ListProtector.get(r171, 0);
        if (r172 == null) goto L216;
        r168 = r172;
    L216:
        r165.add(r168);
        goto L218
    L217:
        r165.add("empty url");
    L197:
        r167 = 0;
        goto L198
    L188:
        int r173 = r154;
        r161 = 1;
    L190:
        if (r173 <= 320) goto L192;
        r173 = r173 / 2;
        r161 = r161 * 2;
        goto L190
    L173:
        r158 = UtilityKotlinExtentionsKt.c(160);
        r157 = (r153 * r158) / r154;
        goto L174
    L251:
        return;
    L167:
        r155 = false;
        goto L168
    L163:
        r154 = 0;
        goto L164
    L160:
        r153 = 0;
        goto L161
    L220:
        if (r152 != 4) goto L233;
        if (this.N == 2) goto L243;
        this.N = 2;
        ConstraintSet r174 = new ConstraintSet();
        r174.clone(this.f51960s);
        r174.clear(R.id.rv_game_comment_images, 7);
        r174.connect(R.id.rv_game_comment_images, 7, R.id.gl_help_image_locate, 6);
        r174.applyTo(this.f51960s);
        RecyclerView.LayoutManager r175 = this.f51961t.getLayoutManager();
        if ((r175 instanceof GridLayoutManager) == false) goto L228;
        r102 = r175;
    L228:
        GridLayoutManager r176 = (GridLayoutManager) r102;
        if (r176 == null) goto L231;
        r176.setSpanCount(2);
    L231:
        this.M.f56004a = 2;
    L243:
        this.f51967z.setData(r151);
        UtilityKotlinExtentionsKt.j(this.f51960s);
        UtilityKotlinExtentionsKt.h(this.f51963v);
        UtilityKotlinExtentionsKt.h(this.f51962u);
        UtilityKotlinExtentionsKt.j(this.f51961t);
        return;
    L233:
        if (this.N == 3) goto L243;
        this.N = 3;
        ConstraintSet r177 = new ConstraintSet();
        r177.clone(this.f51960s);
        r177.clear(R.id.rv_game_comment_images, 7);
        r177.connect(R.id.rv_game_comment_images, 7, R.id.cl_comment_detail_item_image_container, 7);
        r177.applyTo(this.f51960s);
        RecyclerView.LayoutManager r178 = this.f51961t.getLayoutManager();
        if ((r178 instanceof GridLayoutManager) == false) goto L239;
        r100 = r178;
    L239:
        GridLayoutManager r179 = (GridLayoutManager) r100;
        if (r179 == null) goto L242;
        r179.setSpanCount(3);
    L242:
        this.M.f56004a = 3;
        goto L243
    L151:
        r152 = 0;
        goto L152
    L148:
        r151 = null;
    L138:
        r147 = "";
    L131:
        r145 = "";
    L124:
        r141 = null;
        goto L125
    L118:
        r138 = null;
        goto L119
    L114:
        r136 = null;
        goto L115
    L108:
        if (Intrinsics.areEqual(r135, AudioStats.AUDIO_AMPLITUDE_NONE) == true) goto L111;
        this.f51959r.setVisibility(0);
        this.f51959r.setProgress((int) (r135.doubleValue() * ((double) 10)));
        goto L112
    L105:
        r135 = null;
        goto L106
    L101:
        r134 = null;
        goto L102
    L97:
        r133 = null;
        goto L98
    L93:
        r132 = null;
        goto L94
    L89:
        r131 = null;
        goto L90
    L86:
        r130 = null;
        goto L87
    L82:
        r129 = null;
        goto L83
    L73:
        r126.endToStart = R.id.tv_comment_user_title;
        goto L74
    L69:
        r128 = 0;
        goto L71
    L76:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L63:
        r124 = null;
        goto L64
    L58:
        r121 = false;
    L77:
        this.A.setVisibility(8);
        ViewGroup.LayoutParams r180 = this.f51943b.getLayoutParams();
        if (r180 == null) goto L246;
        ConstraintLayout.LayoutParams r181 = (ConstraintLayout.LayoutParams) r180;
        r181.endToStart = R.id.tv_comment_user_title;
        this.f51943b.setLayoutParams(r181);
        goto L80
    L246:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L45:
        r118 = false;
    L48:
        this.f51948g.setVisibility(8);
        this.f51949h.setVisibility(8);
        goto L50
    L35:
        if (r108.isSelected != true) goto L37;
        r116 = 0;
        goto L38
    L31:
        r114 = 0;
        goto L32
    L27:
        r111 = null;
        goto L28
    L23:
        r108 = null;
        goto L24
    L18:
        if (this.f51966y == false) goto L20;
        UtilityKotlinExtentionsKt.j(this.f51965x);
    L14:
        r107 = null;
        goto L16
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public final void V3(Long r100) {
        if (r100 == null) goto L4;
        int r101 = (int) r100.longValue();
    L5:
        if (r101 > 0) goto L9;
        TextView r102 = this.f51947f;
        if (r102 == null) goto L16;
        r102.setText(y0.i(R.string.ttlive_game_promote_comment_dislike_desc));
        return;
    L16:
        return;
    L9:
        TextView r103 = this.f51947f;
        if (r103 == null) goto L18;
        String r104 = yt.m.a(r100, true);
        if (r104 == null) goto L15;
        r103.setText(StringsKt.trim(r104).toString());
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L18:
        return;
    L4:
        r101 = 0;
        goto L5
    }

    public final void W3(Long r100) {
        if (r100 != null) goto L4;
    L6:
        this.f51946e.setTextColor(this.C);
        this.f51950i.setImageDrawable(this.E);
    L7:
        if (r100 != null) goto L9;
    L16:
        TextView r101 = this.f51947f;
        if (r101 == null) goto L19;
        r101.setTextColor(this.C);
    L19:
        ImageView r102 = this.f51951j;
        if (r102 == null) goto L25;
        r102.setImageDrawable(this.G);
        return;
    L25:
        return;
    L9:
        if ((r100.longValue() & 2) != 2) goto L16;
        TextView r103 = this.f51947f;
        if (r103 == null) goto L13;
        r103.setTextColor(this.B);
    L13:
        ImageView r104 = this.f51951j;
        if (r104 == null) goto L23;
        r104.setImageDrawable(this.F);
        return;
    L23:
        return;
    L4:
        if ((r100.longValue() & 1) != 1) goto L6;
        this.f51946e.setTextColor(this.B);
        this.f51950i.setImageDrawable(this.D);
        goto L7
    }

    public final void X3(Long r100) {
        if (r100 == null) goto L4;
        int r101 = (int) r100.longValue();
    L5:
        if (r101 > 0) goto L7;
        this.f51946e.setText(y0.i(R.string.ttlive_game_promote_comment_like_desc));
        return;
    L7:
        TextView r102 = this.f51946e;
        String r103 = yt.m.a(r100, true);
        if (r103 == null) goto L12;
        r102.setText(StringsKt.trim(r103).toString());
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L4:
        r101 = 0;
        goto L5
    }

    public final void Y3(List r100) {
        if (r100 != null) goto L4;
    L25:
        this.f51953l.setVisibility(8);
        return;
    L4:
        if (r100.size() == 0) goto L25;
        if (this.f51941J == false) goto L25;
        this.f51953l.setVisibility(0);
        String r101 = "";
        this.f51954m.setText("");
        com.bytedance.android.gamecp.business.comment.data.s r102 = (com.bytedance.android.gamecp.business.comment.data.s) ListProtector.get(r100, 0);
        com.bytedance.android.gamecp.business.comment.data.m r103 = r102.userExtra;
        if (r103 == null) goto L11;
        Boolean r104 = r103.isOfficer;
    L12:
        User r105 = r102.user;
        if (r105 == null) goto L16;
        String r106 = r105.getNickName();
        if (r106 == null) goto L16;
    L17:
        String r107 = r102.content;
        if (r107 == null) goto L23;
        String r108 = StringsKt.trim(r107).toString();
        if (r108 == null) goto L23;
        r101 = r108;
    L23:
        this.f51954m.post(new s(this, r104, r106, r101));
        return;
    L16:
        r106 = "";
        goto L17
    L11:
        r104 = null;
        goto L12
    }

    public final void Z3(Long r100) {
        if (r100 == null) goto L4;
        int r101 = (int) r100.longValue();
    L5:
        if (r101 != 0) goto L7;
        this.f51957p.setText(y0.i(R.string.ttlive_game_promote_comment_reply_desc));
        return;
    L7:
        TextView r102 = this.f51957p;
        String r103 = yt.m.a(r100, true);
        if (r103 == null) goto L12;
        r102.setText(StringsKt.trim(r103).toString());
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L4:
        r101 = 0;
        goto L5
    }

    public final void a4(final Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        this.L = new com.bytedance.android.gamecp.common.track.monitor.a(0, false, 0.0f, false, null, 63);
        com.bytedance.android.gamecp.common.track.monitor.a r100 = this.L;
        if (r100 == null) goto L6;
        r100.attachViewAppearObserver(this.itemView, new GamePromoteCommentDetailViewHolder$setItemViewObserver$1(r110));
        return;
    }

    public final void U3(String r100, List<com.bytedance.android.gamecp.business.comment.data.h> r110) {
        if (r100 == null) goto L30;
        String r101 = StringsKt.trim(r100).toString();
        if (r101.length() != 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        this.f51945d.A(y0.i(R.string.ttlive_game_promote_comment_no_content), false, this.H);
        return;
    L9:
        LinkedHashMap r103 = null;
        if (this.I == false) goto L25;
        if (r110 == null) goto L25;
        List<com.bytedance.android.gamecp.business.comment.data.h> r111 = r110;
        LinkedHashMap r104 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r111, 10)), 16));
        Iterator<T> r112 = r111.iterator();
    L14:
        if (r112.hasNext() == false) goto L24;
        com.bytedance.android.gamecp.business.comment.data.h r105 = (com.bytedance.android.gamecp.business.comment.data.h) r112.next();
        Long r106 = r105.begin;
        if (r106 == null) goto L18;
        Integer r107 = Integer.valueOf((int) r106.longValue());
    L19:
        Long r108 = r105.end;
        if (r108 == null) goto L22;
        Integer r109 = Integer.valueOf((int) r108.longValue());
    L23:
        Pair r113 = new Pair(r107, r109);
        r104.put(r113.getFirst(), r113.getSecond());
        goto L14
    L22:
        r109 = null;
        goto L23
    L18:
        r107 = null;
        goto L19
    L24:
        r103 = r104;
    L25:
        this.f51945d.setHighLightArray(r103);
        this.f51945d.A(r101, false, this.H);
        return;
    L6:
        r102 = false;
        goto L7
    }

    public final void b4(ConstraintLayout r110, final Function0 r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "action");
        this.K = new com.bytedance.android.gamecp.common.track.monitor.a(0, false, 0.0f, false, null, 63);
        com.bytedance.android.gamecp.common.track.monitor.a r100 = this.K;
        if (r100 == null) goto L6;
        r100.attachViewAppearObserver(r110, new GamePromoteCommentDetailViewHolder$setViewObserver$1(r111));
        return;
    }
}
