package com.bytedance.android.gamecp.business.comment.adapter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.business.comment.data.GamePromoteCommentViewModel;
import com.bytedance.android.gamecp.business.gamedetail.view.comment.GamePromoteCommentDetailAdapterV2;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import com.bytedance.android.gamecp.common.track.model.GPTrackAction;
import com.bytedance.android.gamecp.common.ui.DouyinBallLoadingAnimationView;
import com.bytedance.android.gamecp.common.ui.UserAvatarImageView;
import com.bytedance.android.gamecp.common.ui.actionsheet.ActionSheetBuilder;
import com.bytedance.android.gamecp.common.ui.t;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.model.ImageModel;
import com.bytedance.android.gamecp.host_api.model.user.User;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wu.z2;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/adapter/CommentReplyListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "CommentChildReplyBottomViewHolder", "CommentChildReplyViewHolder", "CommentReplyViewHolder", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentReplyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f51891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<com.bytedance.android.gamecp.business.comment.data.k> f51892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GamePromoteCommentViewModel f51893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function8<? super Integer, ? super String, ? super Integer, ? super Integer, ? super String, ? super Long, ? super String, ? super String, Unit> f51894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super Integer, Unit> f51895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f51896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super Long, Unit> f51897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function3<? super Integer, ? super String, ? super Boolean, Unit> f51898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f51899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f51900j;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/adapter/CommentReplyListAdapter$CommentChildReplyBottomViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CommentChildReplyBottomViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f51901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f51902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DouyinBallLoadingAnimationView f51903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f51904d;

        public CommentChildReplyBottomViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f51901a = (TextView) r100.findViewById(R.id.tv_comment_detail_reply_list_load_more);
            this.f51902b = (ImageView) r100.findViewById(R.id.iv_comment_detail_reply_list_load_more);
            this.f51903c = (DouyinBallLoadingAnimationView) r100.findViewById(R.id.iv_comment_detail_reply_list_loading);
            this.f51904d = r100.findViewById(R.id.view_comment_detail_reply_list_line);
        }

        public final void T3(boolean r100) {
            if (r100 == false) goto L4;
            UtilityKotlinExtentionsKt.j(this.f51901a);
            UtilityKotlinExtentionsKt.j(this.f51902b);
            UtilityKotlinExtentionsKt.j(this.f51904d);
            return;
        L4:
            UtilityKotlinExtentionsKt.h(this.f51901a);
            UtilityKotlinExtentionsKt.h(this.f51902b);
            UtilityKotlinExtentionsKt.h(this.f51904d);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/adapter/CommentReplyListAdapter$CommentChildReplyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CommentChildReplyViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UserAvatarImageView f51905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f51906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f51907c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f51908d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f51909e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f51910f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f51911g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ImageView f51912h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ImageView f51913i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ConstraintLayout f51914j;

        public CommentChildReplyViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f51905a = (UserAvatarImageView) r100.findViewById(R.id.iv_comment_detail_child_reply_item_avatar);
            this.f51906b = (TextView) r100.findViewById(R.id.tv_comment_detail_child_reply_item_nickname);
            this.f51907c = (TextView) r100.findViewById(R.id.tv_comment_detail_child_reply_to_user_name);
            this.f51908d = (ImageView) r100.findViewById(R.id.iv_comment_detail_child_reply_item_icon);
            this.f51909e = (TextView) r100.findViewById(R.id.tv_comment_detail_child_reply_item_time);
            this.f51910f = (TextView) r100.findViewById(R.id.tv_comment_detail_child_reply_item_content);
            this.f51911g = (TextView) r100.findViewById(R.id.tv_comment_detail_child_reply_item_like_count);
            this.f51912h = (ImageView) r100.findViewById(R.id.iv_comment_detail_child_reply_item_like);
            this.f51913i = (ImageView) r100.findViewById(R.id.iv_comment_detail_child_reply_item_option);
            this.f51914j = (ConstraintLayout) r100.findViewById(R.id.cl_comment_detail_child_reply_item_like_container);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/adapter/CommentReplyListAdapter$CommentReplyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CommentReplyViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UserAvatarImageView f51915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f51916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f51917c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f51918d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f51919e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ImageView f51920f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ImageView f51921g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ConstraintLayout f51922h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final TextView f51923i;

        public CommentReplyViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f51915a = (UserAvatarImageView) r100.findViewById(R.id.iv_comment_detail_reply_item_avatar);
            this.f51916b = (TextView) r100.findViewById(R.id.tv_comment_detail_reply_item_nickname);
            this.f51917c = (TextView) r100.findViewById(R.id.tv_comment_detail_reply_item_time);
            this.f51918d = (TextView) r100.findViewById(R.id.tv_comment_detail_reply_item_content);
            this.f51919e = (TextView) r100.findViewById(R.id.tv_comment_detail_reply_item_like_count);
            this.f51920f = (ImageView) r100.findViewById(R.id.iv_comment_detail_reply_item_like);
            this.f51921g = (ImageView) r100.findViewById(R.id.iv_comment_option);
            this.f51922h = (ConstraintLayout) r100.findViewById(R.id.cl_comment_detail_reply_item_like_container);
            this.f51923i = (TextView) r100.findViewById(R.id.tv_comment_official_title);
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentReplyListAdapter f51924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommentReplyViewHolder f51925b;

        public a(CommentReplyListAdapter r100, CommentReplyViewHolder r101) {
            this.f51924a = r100;
            this.f51925b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f51924a.f51895e.invoke(Integer.valueOf(this.f51925b.getAdapterPosition()));
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentReplyListAdapter f51926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommentReplyViewHolder f51927b;

        public b(CommentReplyListAdapter r100, CommentReplyViewHolder r101) {
            this.f51926a = r100;
            this.f51927b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f51926a.C2(this.f51927b.getAdapterPosition(), Boolean.FALSE);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentReplyListAdapter f51928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommentReplyViewHolder f51929b;

        public c(CommentReplyListAdapter r100, CommentReplyViewHolder r101) {
            this.f51928a = r100;
            this.f51929b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CommentReplyListAdapter.y2(this.f51928a, this.f51929b.getAdapterPosition());
        }
    }

    public static final class d extends TrackRegisterStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentReplyListAdapter f51930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f51931b;

        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final int getAutoReportStrategy() {
            return 4;
        }

        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final Map<String, String> getClickTempExtraAttrs() {
            HashMap r100 = new HashMap();
            ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r101 = this.f51930a.f51892b;
            boolean r102 = false;
            if (r101 == null) goto L5;
            int r103 = r101.size();
        L6:
            int r104 = this.f51931b;
            if (r103 > r104) goto L9;
            return r100;
        L9:
            ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r105 = this.f51930a.f51892b;
            if (r105 == null) goto L14;
            com.bytedance.android.gamecp.business.comment.data.k r106 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r105, r104);
            if (r106 == null) goto L14;
            com.bytedance.android.gamecp.business.comment.data.s r107 = r106.replyInfo;
        L15:
            if (r107 != null) goto L17;
        L19:
            if (r102 == false) goto L21;
            String r108 = "unlike";
        L22:
            r100.put("action", r108);
            return r100;
        L21:
            r108 = IStrategyStateSupplier.KEY_INFO_LIKE;
            goto L22
        L17:
            if ((r107.relationTypeFlag & 1) != 1) goto L19;
            r102 = true;
        L14:
            r107 = null;
            goto L15
        L5:
            r103 = 0;
            goto L6
        }

        public d(CommentReplyListAdapter r100, int r101) {
            this.f51930a = r100;
            this.f51931b = r101;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r100 = this.f51892b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public CommentReplyListAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f51900j = r100;
        this.f51892b = new ArrayList();
        this.f51894d = CommentReplyListAdapter$listener$1.INSTANCE;
        this.f51895e = CommentReplyListAdapter$showReplyInput$1.INSTANCE;
        this.f51896f = true;
        this.f51897g = CommentReplyListAdapter$onDeleteReplySucc$1.INSTANCE;
        this.f51898h = CommentReplyListAdapter$loadMoreChildReply$1.INSTANCE;
        this.f51899i = -1;
    }

    public final com.bytedance.android.gamecp.business.comment.data.k B2(int r110) {
        if (r110 < 0) goto L72;
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r100 = this.f51892b;
        if (r100 == null) goto L6;
        int r101 = r100.size();
    L7:
        if (r110 >= r101) goto L72;
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r102 = this.f51892b;
        if (r102 == null) goto L70;
        com.bytedance.android.gamecp.business.comment.data.k r111 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r102, r110);
        if (r111 == null) goto L70;
        com.bytedance.android.gamecp.business.comment.data.k r103 = new com.bytedance.android.gamecp.business.comment.data.k();
        r103.f52043a = r111.f52043a;
        r103.f52048f = r111.f52048f;
        r103.f52047e = r111.f52047e;
        r103.f52046d = r111.f52046d;
        r103.f52045c = r111.f52045c;
        r103.f52050h = r111.f52050h;
        r103.f52049g = r111.f52049g;
        r103.f52052j = r111.f52052j;
        r103.f52051i = r111.f52051i;
        com.bytedance.android.gamecp.business.comment.data.b r104 = r111.f52044b;
        if (r104 == null) goto L65;
        com.bytedance.android.gamecp.business.comment.data.b r105 = new com.bytedance.android.gamecp.business.comment.data.b();
        com.bytedance.android.gamecp.business.comment.data.o r106 = new com.bytedance.android.gamecp.business.comment.data.o();
        r105.evaluationInfo = r106;
        r105.f52036b = r104.f52036b;
        r105.f52037c = r104.f52037c;
        r105.f52035a = r104.f52035a;
        com.bytedance.android.gamecp.business.comment.data.o r107 = r104.evaluationInfo;
        long r108 = 0;
        if (r107 == null) goto L19;
        long r109 = r107.likeCount;
    L20:
        r106.likeCount = r109;
        com.bytedance.android.gamecp.business.comment.data.o r112 = r104.evaluationInfo;
        if (r112 == null) goto L23;
        long r113 = r112.dislikeCount;
    L24:
        r106.dislikeCount = r113;
        com.bytedance.android.gamecp.business.comment.data.o r114 = r104.evaluationInfo;
        if (r114 == null) goto L27;
        long r115 = r114.relationTypeFlag;
    L28:
        r106.relationTypeFlag = r115;
        com.bytedance.android.gamecp.business.comment.data.o r116 = r104.evaluationInfo;
        String r117 = "";
        if (r116 == null) goto L32;
        String r118 = r116.content;
        if (r118 == null) goto L32;
    L33:
        r106.content = r118;
        com.bytedance.android.gamecp.business.comment.data.o r119 = r104.evaluationInfo;
        if (r119 == null) goto L36;
        long r120 = r119.evaluationId;
    L37:
        r106.evaluationId = r120;
        com.bytedance.android.gamecp.business.comment.data.o r121 = r104.evaluationInfo;
        if (r121 == null) goto L40;
        long r122 = r121.evaluationType;
    L41:
        r106.evaluationType = r122;
        com.bytedance.android.gamecp.business.comment.data.o r123 = r104.evaluationInfo;
        if (r123 == null) goto L47;
        String r124 = r123.gameId;
        if (r124 == null) goto L47;
        r117 = r124;
    L47:
        r106.gameId = r117;
        com.bytedance.android.gamecp.business.comment.data.o r125 = r104.evaluationInfo;
        if (r125 == null) goto L50;
        Boolean r126 = r125.isOwnEvaluation;
    L51:
        r106.isOwnEvaluation = r126;
        com.bytedance.android.gamecp.business.comment.data.o r127 = r104.evaluationInfo;
        if (r127 == null) goto L54;
        double r128 = r127.score;
    L55:
        r106.score = r128;
        com.bytedance.android.gamecp.business.comment.data.o r129 = r104.evaluationInfo;
        if (r129 == null) goto L58;
        long r130 = r129.submitTime;
    L59:
        r106.submitTime = r130;
        r105.b(r104.a());
        r103.f52044b = r105;
        com.bytedance.android.gamecp.business.comment.data.o r131 = r105.evaluationInfo;
        if (r131 == null) goto L65;
        com.bytedance.android.gamecp.business.comment.data.o r132 = r104.evaluationInfo;
        if (r132 == null) goto L64;
        r108 = r132.relationTypeFlag;
    L64:
        r131.relationTypeFlag = r108;
        goto L65
    L58:
        r130 = 0;
        goto L59
    L54:
        r128 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L55
    L50:
        r126 = null;
        goto L51
    L40:
        r122 = 0;
        goto L41
    L36:
        r120 = 0;
    L32:
        r118 = "";
        goto L33
    L27:
        r115 = 0;
        goto L28
    L23:
        r113 = 0;
        goto L24
    L19:
        r109 = 0;
    L65:
        com.bytedance.android.gamecp.business.comment.data.s r133 = r111.replyInfo;
        if (r133 == null) goto L68;
        com.bytedance.android.gamecp.business.comment.data.s r134 = new com.bytedance.android.gamecp.business.comment.data.s();
        r134.replyId = r133.replyId;
        r134.commentId = r133.commentId;
        r134.gameId = r133.gameId;
        r134.layer = r133.layer;
        r134.user = r133.user;
        r134.parentReplyId = r133.parentReplyId;
        r134.replyUser = r133.replyUser;
        r134.replyToReplyId = r133.replyToReplyId;
        r134.content = r133.content;
        r134.createTime = r133.createTime;
        r134.likeCount = r133.likeCount;
        r134.childReplyCount = r133.childReplyCount;
        r134.relationTypeFlag = r133.relationTypeFlag;
        r134.isOwnReply = r133.isOwnReply;
        r103.replyInfo = r134;
        r134.relationTypeFlag = r133.relationTypeFlag;
    L68:
        return r103;
    L70:
        return new com.bytedance.android.gamecp.business.comment.data.k();
    L6:
        r101 = 0;
    L72:
        return new com.bytedance.android.gamecp.business.comment.data.k();
    }

    public final CommentReplyViewHolder D2(ViewGroup r100) {
        CommentReplyViewHolder r101 = new CommentReplyViewHolder(LayoutInflater.from(this.f51900j).inflate(R.layout.gamecp_item_comment_detail_reply, r100, false));
        r101.itemView.setOnClickListener(new a(this, r101));
        r101.f51922h.setOnClickListener(new b(this, r101));
        r101.f51921g.setOnClickListener(new c(this, r101));
        return r101;
    }

    public final void F2(List<com.bytedance.android.gamecp.business.comment.data.k> r100) {
        Intrinsics.checkNotNullParameter(r100, "newList");
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (((com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r100, r102)).f52043a == 1) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        this.f51899i = r102;
    L8:
        DiffUtil.calculateDiff(new ReplyListDiffCallback(this.f51892b, r100)).dispatchUpdatesTo(this);
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r103 = this.f51892b;
        if (r103 == null) goto L11;
        r103.clear();
    L11:
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r104 = this.f51892b;
        if (r104 == null) goto L17;
        r104.addAll(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r101 = this.f51892b;
        if (r101 == null) goto L7;
        com.bytedance.android.gamecp.business.comment.data.k r102 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r101, r100);
        if (r102 == null) goto L7;
        return r102.f52043a;
    L7:
        return 1;
    }

    public static void H2(CommentChildReplyBottomViewHolder r100, boolean r101) {
        r100.T3(true);
        r100.f51903c.b();
        UtilityKotlinExtentionsKt.h(r100.f51903c);
        if (r101 == false) goto L5;
        r100.f51901a.setText(y0.i(R.string.ttlive_game_promote_comment_detail_list_more));
        r100.f51902b.setImageDrawable(y0.e(R.drawable.gamecp_ic_comment_detail_reply_list_more));
        return;
    L5:
        r100.f51901a.setText(y0.i(R.string.ttlive_game_promote_comment_detail_list_no_more));
        r100.f51902b.setImageDrawable(y0.e(R.drawable.gamecp_ic_comment_detail_reply_list_no_more));
    }

    public static void I2(String r100, TextView r101) {
        if (r100 == null) goto L11;
        String r102 = StringsKt.trim(r100).toString();
        if (r102.length() != 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        r101.setText(y0.i(R.string.ttlive_game_promote_comment_no_content));
        return;
    L9:
        r101.setText(r102);
        return;
    L6:
        r103 = false;
        goto L7
    }

    public static final void y2(final CommentReplyListAdapter r110, final int r111) {
        r110.getClass();
        final ArrayList r100 = new ArrayList();
        r100.add(new com.bytedance.android.gamecp.common.ui.actionsheet.a(y0.i(R.string.gamecp_game_promote_comment_detail_more_delete)));
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r101 = r110.f51892b;
        String r102 = null;
        if (r101 == null) goto L9;
        com.bytedance.android.gamecp.business.comment.data.k r103 = (com.bytedance.android.gamecp.business.comment.data.k) CollectionsKt.getOrNull(r101, r111);
        if (r103 == null) goto L9;
        com.bytedance.android.gamecp.business.comment.data.s r104 = r103.replyInfo;
        if (r104 == null) goto L9;
        String r105 = r104.replyId;
    L10:
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r106 = r110.f51892b;
        if (r106 == null) goto L17;
        com.bytedance.android.gamecp.business.comment.data.k r107 = (com.bytedance.android.gamecp.business.comment.data.k) CollectionsKt.getOrNull(r106, r111);
        if (r107 == null) goto L17;
        com.bytedance.android.gamecp.business.comment.data.s r108 = r107.replyInfo;
        if (r108 == null) goto L17;
        r102 = r108.commentId;
    L17:
        final String r109 = r102;
        if (r105 == null) goto L21;
        ActionSheetBuilder r112 = new ActionSheetBuilder();
        Context r113 = r110.f51900j;
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        r112.f56959a = r113;
        Intrinsics.checkNotNullParameter(r100, "items");
        r112.f56962d = r100;
        final String r114 = r105;
        Function2<Dialog, View, Unit> r115 = new CommentReplyListAdapter$optionsClick$$inlined$apply$lambda$1(r110, r100, r109, r114, r111);
        Intrinsics.checkNotNullParameter(r115, "block");
        r112.f56963e = r115;
        j r116 = new j(r110, r100, r109, r114, r111);
        Intrinsics.checkNotNullParameter(r116, "listener");
        r112.f56960b = r116;
        k r117 = new k(r110, r100, r109, r105);
        Intrinsics.checkNotNullParameter(r117, "listener");
        r112.f56961c = r117;
        r112.a().b();
        return;
    L21:
        return;
    L9:
        r105 = null;
        goto L10
    }

    public final void C2(int r310, Boolean r311) {
        int r100 = 2;
        Long r110 = null;
        if (Intrinsics.areEqual(r311, Boolean.TRUE) == false) goto L66;
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r101 = this.f51892b;
        if (r101 == null) goto L11;
        com.bytedance.android.gamecp.business.comment.data.k r102 = (com.bytedance.android.gamecp.business.comment.data.k) CollectionsKt.getOrNull(r101, r310);
        if (r102 == null) goto L11;
        com.bytedance.android.gamecp.business.comment.data.b r103 = r102.f52044b;
        if (r103 == null) goto L11;
        com.bytedance.android.gamecp.business.comment.data.o r104 = r103.evaluationInfo;
    L12:
        if (r104 != null) goto L14;
    L16:
        boolean r111 = false;
    L17:
        if (r111 == true) goto L20;
        r100 = 1;
    L20:
        Function8<? super Integer, ? super String, ? super Integer, ? super Integer, ? super String, ? super Long, ? super String, ? super String, Unit> r105 = this.f51894d;
        Integer r106 = Integer.valueOf(r310);
        if (r104 == null) goto L23;
        Long r107 = Long.valueOf(r104.evaluationId);
    L24:
        String r108 = String.valueOf(r107);
        Integer r109 = Integer.valueOf(r100);
        if (r104 == null) goto L27;
        String r112 = r104.content;
    L28:
        long r113 = 0;
        r105.invoke(r106, r108, 1, r109, r112, 0L, "", "");
        int r114 = com.bytedance.android.gamecp.business.comment.data.i.f52041a;
        if (r104 == null) goto L34;
        String r115 = r104.gameId;
        if (r115 == null) goto L34;
        String r116 = r115;
    L35:
        String r117 = this.f51891a;
        if (r117 != null) goto L38;
        String r210 = "";
    L39:
        if (r104 == null) goto L41;
        r110 = Long.valueOf(r104.evaluationId);
    L41:
        String r211 = String.valueOf(r110);
        boolean r212 = !r111;
        GamePromoteCommentViewModel r118 = this.f51893c;
        if (r118 == null) goto L44;
        int r213 = r118.getPromoteScene();
    L45:
        GamePromoteCommentViewModel r119 = this.f51893c;
        if (r119 == null) goto L48;
        boolean r214 = r119.isPromoter();
    L49:
        GamePromoteCommentViewModel r120 = this.f51893c;
        if (r120 == null) goto L57;
        com.bytedance.android.gamecp.business.comment.data.j r121 = r120.getSelectedCommentTag();
        if (r121 == null) goto L57;
        String r122 = r121.tagName;
        if (r122 == null) goto L57;
        String r215 = r122;
    L58:
        GamePromoteCommentViewModel r123 = this.f51893c;
        if (r123 == null) goto L65;
        com.bytedance.android.gamecp.business.comment.data.j r124 = r123.getSelectedCommentTag();
        if (r124 == null) goto L65;
        Long r125 = r124.commentCount;
        if (r125 == null) goto L65;
        r113 = r125.longValue();
    L65:
        com.bytedance.android.gamecp.business.comment.data.i.b(r116, r210, r211, r212, "comment_page_detail", r213, r214, r215, r113);
        return;
    L57:
        r215 = "";
        goto L58
    L48:
        r214 = false;
        goto L49
    L44:
        r213 = 0;
        goto L45
    L38:
        r210 = r117;
    L34:
        r116 = "";
        goto L35
    L27:
        r112 = null;
        goto L28
    L23:
        r107 = null;
        goto L24
    L14:
        if ((r104.relationTypeFlag & 1) != 1) goto L16;
        r111 = true;
    L11:
        r104 = null;
        goto L12
    L66:
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r126 = this.f51892b;
        if (r126 == null) goto L71;
        com.bytedance.android.gamecp.business.comment.data.k r127 = (com.bytedance.android.gamecp.business.comment.data.k) CollectionsKt.getOrNull(r126, r310);
        if (r127 == null) goto L71;
        com.bytedance.android.gamecp.business.comment.data.s r128 = r127.replyInfo;
    L72:
        if (r128 != null) goto L74;
    L76:
        boolean r129 = false;
    L77:
        if (r129 == true) goto L80;
        r100 = 1;
    L80:
        if (r128 == null) goto L82;
        int r130 = (int) r128.layer;
    L83:
        if (r130 != 1) goto L88;
        if (r128 == null) goto L86;
        String r131 = r128.commentId;
    L87:
        String r132 = String.valueOf(r131);
    L90:
        String r133 = r132;
    L92:
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r134 = this.f51892b;
        if (r134 == null) goto L97;
        com.bytedance.android.gamecp.business.comment.data.k r135 = (com.bytedance.android.gamecp.business.comment.data.k) CollectionsKt.getOrNull(r134, r310);
        if (r135 == null) goto L97;
        int r136 = r135.f52043a;
    L98:
        if (r136 != 1) goto L131;
        int r137 = com.bytedance.android.gamecp.business.comment.data.i.f52041a;
        if (r128 == null) goto L105;
        String r138 = r128.gameId;
        if (r138 == null) goto L105;
        String r139 = r138;
    L106:
        String r140 = this.f51891a;
        if (r140 != null) goto L109;
        String r141 = "";
    L110:
        if (r128 == null) goto L115;
        String r142 = r128.commentId;
        if (r142 == null) goto L115;
        String r143 = r142;
    L116:
        if (r128 == null) goto L121;
        String r144 = r128.replyId;
        if (r144 == null) goto L121;
        String r145 = r144;
    L122:
        boolean r216 = !r129;
        GamePromoteCommentViewModel r146 = this.f51893c;
        if (r146 == null) goto L125;
        int r217 = r146.getPromoteScene();
    L126:
        GamePromoteCommentViewModel r147 = this.f51893c;
        if (r147 == null) goto L129;
        boolean r218 = r147.isPromoter();
    L130:
        com.bytedance.android.gamecp.business.comment.data.i.d(r139, r141, r143, r145, r216, "level1", r217, r218);
    L163:
        Function8<? super Integer, ? super String, ? super Integer, ? super Integer, ? super String, ? super Long, ? super String, ? super String, Unit> r148 = this.f51894d;
        Integer r149 = Integer.valueOf(r310);
        if (r128 == null) goto L166;
        String r150 = r128.commentId;
    L167:
        Integer r151 = Integer.valueOf(r100);
        if (r128 == null) goto L170;
        String r152 = r128.content;
    L171:
        if (r128 == null) goto L173;
        Long r153 = Long.valueOf(r128.layer);
    L174:
        if (r128 == null) goto L176;
        String r154 = r128.replyId;
    L177:
        r148.invoke(r149, r150, 1, r151, r152, r153, r154, r133);
        return;
    L176:
        r154 = null;
        goto L177
    L173:
        r153 = null;
        goto L174
    L170:
        r152 = null;
        goto L171
    L166:
        r150 = null;
        goto L167
    L129:
        r218 = false;
        goto L130
    L125:
        r217 = 0;
    L121:
        r145 = "";
    L115:
        r143 = "";
        goto L116
    L109:
        r141 = r140;
    L105:
        r139 = "";
        goto L106
    L131:
        int r155 = com.bytedance.android.gamecp.business.comment.data.i.f52041a;
        if (r128 == null) goto L137;
        String r156 = r128.gameId;
        if (r156 == null) goto L137;
        String r157 = r156;
    L138:
        String r158 = this.f51891a;
        if (r158 != null) goto L141;
        String r159 = "";
    L142:
        if (r128 == null) goto L147;
        String r160 = r128.commentId;
        if (r160 == null) goto L147;
        String r161 = r160;
    L148:
        if (r128 == null) goto L153;
        String r162 = r128.replyId;
        if (r162 == null) goto L153;
        String r163 = r162;
    L154:
        boolean r219 = !r129;
        GamePromoteCommentViewModel r164 = this.f51893c;
        if (r164 == null) goto L157;
        int r220 = r164.getPromoteScene();
    L158:
        GamePromoteCommentViewModel r165 = this.f51893c;
        if (r165 == null) goto L161;
        boolean r221 = r165.isPromoter();
    L162:
        com.bytedance.android.gamecp.business.comment.data.i.d(r157, r159, r161, r163, r219, "level2", r220, r221);
        goto L163
    L161:
        r221 = false;
        goto L162
    L157:
        r220 = 0;
    L153:
        r163 = "";
    L147:
        r161 = "";
        goto L148
    L141:
        r159 = r158;
    L137:
        r157 = "";
    L97:
        r136 = 1;
        goto L98
    L86:
        r131 = null;
        goto L87
    L88:
        if (r128 == null) goto L91;
        r132 = r128.parentReplyId;
        goto L90
    L91:
        r133 = null;
        goto L92
    L82:
        r130 = 1;
        goto L83
    L74:
        if ((r128.relationTypeFlag & 1) != 1) goto L76;
        r129 = true;
    L71:
        r128 = null;
        goto L72
    }

    public final void J2(GamePromoteCommentDetailAdapterV2.GamePromoteCommentDetailBottomViewHolderV2 r100, boolean r101) {
        r100.f55788a.a();
        if (r101 == false) goto L5;
        r100.f55788a.c();
        return;
    L5:
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r102 = this.f51892b;
        int r103 = 0;
        if (r102 == null) goto L8;
        int r104 = r102.size();
    L10:
        if (3 <= r104) goto L13;
    L15:
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r105 = this.f51892b;
        if (r105 == null) goto L18;
        r103 = r105.size();
    L18:
        if (r103 >= 3) goto L20;
        r100.f55788a.setMessage(y0.i(R.string.ttlive_game_promote_comment_detail_no_more_v2));
    L21:
        r100.f55788a.b();
        return;
    L20:
        r100.f55788a.setMessage(y0.i(R.string.ttlive_game_promote_comment_detail_no_more));
        goto L21
    L13:
        if (13 < r104) goto L15;
        r100.f55788a.a();
        return;
    L8:
        r104 = 0;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r100 = this.f51892b;
        Long r101 = null;
        if (r100 == null) goto L5;
        com.bytedance.android.gamecp.business.comment.data.k r102 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r100, r111);
    L7:
        if ((r110 instanceof GamePromoteCommentDetailViewHolder) == false) goto L22;
        GamePromoteCommentDetailViewHolder r112 = (GamePromoteCommentDetailViewHolder) r110;
        if (r102 == null) goto L11;
        com.bytedance.android.gamecp.business.comment.data.b r103 = r102.f52044b;
    L12:
        r112.T3(r103);
        if (r102 == null) goto L15;
        com.bytedance.android.gamecp.business.comment.data.b r104 = r102.f52044b;
    L16:
        HashMap<String, String> r105 = GamecpTracker.f56755a;
        ConstraintLayout r106 = r112.f51955n;
        if (r104 == null) goto L21;
        com.bytedance.android.gamecp.business.comment.data.o r113 = r104.evaluationInfo;
        if (r113 == null) goto L21;
        r101 = Long.valueOf(r113.evaluationId);
    L21:
        GamecpTracker.r(r106, "comment_like", MapsKt.mapOf(TuplesKt.to("comment_id", String.valueOf(r101))), new h(this, r111), false, 112);
        return;
    L15:
        r104 = null;
        goto L16
    L11:
        r103 = null;
        goto L12
    L22:
        boolean r107 = false;
        if ((r110 instanceof GamePromoteCommentDetailAdapterV2.GamePromoteCommentDetailTitleViewHolderV2) == false) goto L28;
        TextView r114 = ((GamePromoteCommentDetailAdapterV2.GamePromoteCommentDetailTitleViewHolderV2) r110).f55793a;
        Object[] r108 = new Object[1];
        if (r102 == null) goto L27;
        r101 = Long.valueOf(r102.f52045c);
    L27:
        r108[0] = r101;
        r114.setText(y0.j(R.string.ttlive_game_promote_comment_reply_total, r108));
        r110.itemView.setPadding(y0.b(0.0f), y0.b(15.0f), y0.b(0.0f), y0.b(12.0f));
        return;
    L28:
        long r109 = 0;
        if ((r110 instanceof CommentReplyViewHolder) == false) goto L102;
        ViewGroup.LayoutParams r115 = r110.itemView.getLayoutParams();
        if (r115 == null) goto L100;
        RecyclerView.LayoutParams r116 = (RecyclerView.LayoutParams) r115;
        if (r111 != this.f51899i) goto L35;
        ((ViewGroup.MarginLayoutParams) r116).topMargin = y0.b(8.0f);
    L36:
        r110.itemView.setLayoutParams(r116);
        CommentReplyViewHolder r117 = (CommentReplyViewHolder) r110;
        r117.f51923i.setVisibility(4);
        if (r102 == null) goto L43;
        com.bytedance.android.gamecp.business.comment.data.s r118 = r102.replyInfo;
        if (r118 == null) goto L43;
        com.bytedance.android.gamecp.business.comment.data.m r119 = r118.userExtra;
        if (r119 == null) goto L43;
        Boolean r120 = r119.isOfficer;
    L44:
        Boolean r121 = Boolean.TRUE;
        if (Intrinsics.areEqual(r120, r121) == false) goto L47;
        r117.f51923i.setVisibility(0);
        r117.f51923i.setText(y0.i(R.string.ttlive_game_promote_officer));
    L47:
        if (r102 == null) goto L51;
        com.bytedance.android.gamecp.business.comment.data.s r122 = r102.replyInfo;
        if (r122 == null) goto L51;
        String r123 = r122.content;
    L52:
        I2(r123, r117.f51918d);
        UserAvatarImageView r124 = r117.f51915a;
        Context r125 = r117.itemView.getContext();
        if (r102 == null) goto L59;
        com.bytedance.android.gamecp.business.comment.data.s r126 = r102.replyInfo;
        if (r126 == null) goto L59;
        User r127 = r126.user;
        if (r127 == null) goto L59;
        ImageModel r128 = r127.mo8159getAvatarMedium();
    L60:
        if (r102 == null) goto L62;
        com.bytedance.android.gamecp.business.comment.data.s r129 = r102.replyInfo;
    L63:
        G2(r124, r125, r128, r129);
        TextView r130 = r117.f51916b;
        if (r102 == null) goto L70;
        com.bytedance.android.gamecp.business.comment.data.s r131 = r102.replyInfo;
        if (r131 == null) goto L70;
        User r132 = r131.user;
        if (r132 == null) goto L70;
        String r133 = r132.getNickName();
    L71:
        r130.setText(r133);
        TextView r134 = r117.f51917c;
        int r135 = yt.d.f569003a;
        if (r102 == null) goto L76;
        com.bytedance.android.gamecp.business.comment.data.s r136 = r102.replyInfo;
        if (r136 == null) goto L76;
        long r137 = r136.createTime * ((long) 1000);
    L77:
        r134.setText(yt.d.a(r137));
        if (r102 == null) goto L82;
        com.bytedance.android.gamecp.business.comment.data.s r138 = r102.replyInfo;
        if (r138 == null) goto L82;
        r109 = r138.relationTypeFlag;
    L82:
        L2(r109, r117.f51920f, r117.f51919e);
        if (r102 == null) goto L87;
        com.bytedance.android.gamecp.business.comment.data.s r139 = r102.replyInfo;
        if (r139 == null) goto L87;
        Boolean r140 = r139.isOwnReply;
    L89:
        if (Intrinsics.areEqual(r140, r121) == true) goto L91;
    L93:
        UtilityKotlinExtentionsKt.h(r117.f51921g);
    L94:
        if (r102 == null) goto L98;
        com.bytedance.android.gamecp.business.comment.data.s r141 = r102.replyInfo;
        if (r141 == null) goto L98;
        r101 = Long.valueOf(r141.likeCount);
    L98:
        K2(r101, r117.f51919e, false);
        E2(r117.f51922h, r111, "level1");
        return;
    L91:
        if (this.f51896f == false) goto L93;
        UtilityKotlinExtentionsKt.j(r117.f51921g);
    L87:
        r140 = null;
    L76:
        r137 = 0;
    L70:
        r133 = null;
        goto L71
    L62:
        r129 = null;
    L59:
        r128 = null;
    L51:
        r123 = null;
    L43:
        r120 = null;
        goto L44
    L35:
        ((ViewGroup.MarginLayoutParams) r116).topMargin = y0.b(24.0f);
        goto L36
    L100:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L102:
        if ((r110 instanceof CommentChildReplyViewHolder) == false) goto L177;
        CommentChildReplyViewHolder r142 = (CommentChildReplyViewHolder) r110;
        if (r102 == null) goto L108;
        com.bytedance.android.gamecp.business.comment.data.s r143 = r102.replyInfo;
        if (r143 == null) goto L108;
        String r144 = r143.content;
    L109:
        I2(r144, r142.f51910f);
        UserAvatarImageView r145 = r142.f51905a;
        Context r146 = r142.itemView.getContext();
        if (r102 == null) goto L116;
        com.bytedance.android.gamecp.business.comment.data.s r147 = r102.replyInfo;
        if (r147 == null) goto L116;
        User r148 = r147.user;
        if (r148 == null) goto L116;
        ImageModel r149 = r148.mo8159getAvatarMedium();
    L117:
        if (r102 == null) goto L119;
        com.bytedance.android.gamecp.business.comment.data.s r150 = r102.replyInfo;
    L120:
        G2(r145, r146, r149, r150);
        TextView r151 = r142.f51906b;
        if (r102 == null) goto L127;
        com.bytedance.android.gamecp.business.comment.data.s r152 = r102.replyInfo;
        if (r152 == null) goto L127;
        User r153 = r152.user;
        if (r153 == null) goto L127;
        String r154 = r153.getNickName();
    L128:
        r151.setText(r154);
        if (r102 == null) goto L135;
        com.bytedance.android.gamecp.business.comment.data.s r155 = r102.replyInfo;
        if (r155 == null) goto L135;
        User r156 = r155.replyUser;
        if (r156 == null) goto L135;
        String r157 = r156.getNickName();
    L137:
        if (TextUtils.isEmpty(r157) == true) goto L147;
        TextView r158 = r142.f51907c;
        if (r102 == null) goto L145;
        com.bytedance.android.gamecp.business.comment.data.s r159 = r102.replyInfo;
        if (r159 == null) goto L145;
        User r160 = r159.replyUser;
        if (r160 == null) goto L145;
        String r161 = r160.getNickName();
    L146:
        r158.setText(r161);
        UtilityKotlinExtentionsKt.j(r142.f51907c);
        UtilityKotlinExtentionsKt.j(r142.f51908d);
        r142.f51906b.setMaxWidth(UtilityKotlinExtentionsKt.c(150));
    L148:
        TextView r162 = r142.f51909e;
        int r163 = yt.d.f569003a;
        if (r102 == null) goto L153;
        com.bytedance.android.gamecp.business.comment.data.s r164 = r102.replyInfo;
        if (r164 == null) goto L153;
        long r165 = r164.createTime * ((long) 1000);
    L154:
        r162.setText(yt.d.a(r165));
        if (r102 == null) goto L159;
        com.bytedance.android.gamecp.business.comment.data.s r166 = r102.replyInfo;
        if (r166 == null) goto L159;
        r109 = r166.relationTypeFlag;
    L159:
        L2(r109, r142.f51912h, r142.f51911g);
        if (r102 == null) goto L164;
        com.bytedance.android.gamecp.business.comment.data.s r167 = r102.replyInfo;
        if (r167 == null) goto L164;
        Boolean r168 = r167.isOwnReply;
    L166:
        if (Intrinsics.areEqual(r168, Boolean.TRUE) == true) goto L168;
    L170:
        UtilityKotlinExtentionsKt.h(r142.f51913i);
    L171:
        if (r102 == null) goto L175;
        com.bytedance.android.gamecp.business.comment.data.s r169 = r102.replyInfo;
        if (r169 == null) goto L175;
        r101 = Long.valueOf(r169.likeCount);
    L175:
        K2(r101, r142.f51911g, false);
        E2(r142.f51914j, r111, "level2");
        return;
    L168:
        if (this.f51896f == false) goto L170;
        UtilityKotlinExtentionsKt.j(r142.f51913i);
    L164:
        r168 = null;
    L153:
        r165 = 0;
    L145:
        r161 = null;
        goto L146
    L147:
        UtilityKotlinExtentionsKt.h(r142.f51907c);
        UtilityKotlinExtentionsKt.h(r142.f51908d);
        r142.f51906b.setMaxWidth(UtilityKotlinExtentionsKt.c(300));
    L135:
        r157 = null;
    L127:
        r154 = null;
        goto L128
    L119:
        r150 = null;
    L116:
        r149 = null;
    L108:
        r144 = null;
        goto L109
    L177:
        if ((r110 instanceof CommentChildReplyBottomViewHolder) == false) goto L183;
        CommentChildReplyBottomViewHolder r170 = (CommentChildReplyBottomViewHolder) r110;
        if (r102 == null) goto L181;
        r107 = r102.f52047e;
    L181:
        H2(r170, r107);
        return;
    L183:
        if ((r110 instanceof GamePromoteCommentDetailAdapterV2.GamePromoteCommentDetailBottomViewHolderV2) == false) goto L194;
        GamePromoteCommentDetailAdapterV2.GamePromoteCommentDetailBottomViewHolderV2 r171 = (GamePromoteCommentDetailAdapterV2.GamePromoteCommentDetailBottomViewHolderV2) r110;
        if (r102 == null) goto L187;
        r107 = r102.f52046d;
    L187:
        J2(r171, r107);
        return;
    L194:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 0) goto L19;
        if (r101 == 1) goto L46;
        if (r101 != 2) goto L8;
        CommentChildReplyViewHolder r102 = new CommentChildReplyViewHolder(LayoutInflater.from(this.f51900j).inflate(R.layout.gamecp_item_comment_detail_child_reply, r100, false));
        r102.itemView.setOnClickListener(new com.bytedance.android.gamecp.business.comment.adapter.b(this, r102));
        r102.f51914j.setOnClickListener(new com.bytedance.android.gamecp.business.comment.adapter.c(this, r102));
        r102.f51913i.setOnClickListener(new com.bytedance.android.gamecp.business.comment.adapter.d(this, r102));
        RecyclerView.ViewHolder r103 = r102;
    L42:
        return r103;
    L8:
        if (r101 != 3) goto L10;
        GamePromoteCommentDetailAdapterV2.GamePromoteCommentDetailTitleViewHolderV2 r104 = new GamePromoteCommentDetailAdapterV2.GamePromoteCommentDetailTitleViewHolderV2(LayoutInflater.from(this.f51900j).inflate(R.layout.gamecp_title_game_promote_comment_detail_list_v2, r100, false));
        UtilityKotlinExtentionsKt.h(r104.f55794b);
        r103 = r104;
        goto L42
    L10:
        if (r101 != 4) goto L12;
        CommentChildReplyBottomViewHolder r105 = new CommentChildReplyBottomViewHolder(LayoutInflater.from(this.f51900j).inflate(R.layout.gamecp_item_comment_detail_reply_list_bottom, r100, false));
        r105.itemView.setOnClickListener(new g(this, r105));
        r103 = r105;
        goto L42
    L12:
        if (r101 != 5) goto L45;
        r103 = new GamePromoteCommentDetailAdapterV2.GamePromoteCommentDetailBottomViewHolderV2(LayoutInflater.from(this.f51900j).inflate(R.layout.gamecp_bottom_game_promote_comment_detail_list, r100, false));
        goto L42
    L45:
        return D2(r100);
    L46:
        return D2(r100);
    L19:
        GamePromoteCommentDetailViewHolder r106 = new GamePromoteCommentDetailViewHolder(LayoutInflater.from(this.f51900j).inflate(R.layout.gamecp_game_comment_detail_item, r100, false));
        ViewGroup.LayoutParams r107 = r106.itemView.getLayoutParams();
        if (r107 == null) goto L44;
        RecyclerView.LayoutParams r108 = (RecyclerView.LayoutParams) r107;
        ((ViewGroup.MarginLayoutParams) r108).bottomMargin = y0.b(0.0f);
        r106.itemView.setLayoutParams(r108);
        r106.itemView.setPadding(y0.b(16.0f), y0.b(12.0f), y0.b(16.0f), 0);
        UtilityKotlinExtentionsKt.h(r106.f51958q);
        UtilityKotlinExtentionsKt.h(r106.f51965x);
        if (this.f51896f == true) goto L24;
    L31:
        ConstraintLayout r109 = r106.f51956o;
        if (r109 == null) goto L34;
        UtilityKotlinExtentionsKt.h(r109);
    L34:
        UtilityKotlinExtentionsKt.j(r106.f51964w);
        ViewGroup.LayoutParams r110 = r106.f51955n.getLayoutParams();
        if ((r110 instanceof ConstraintLayout.LayoutParams) == true) goto L37;
        r110 = null;
    L37:
        ConstraintLayout.LayoutParams r111 = (ConstraintLayout.LayoutParams) r110;
        if (r111 == null) goto L40;
        ((ViewGroup.MarginLayoutParams) r111).rightMargin = y0.b(0.0f);
        r106.f51955n.setLayoutParams(r111);
    L40:
        r106.f51955n.setOnClickListener(new f(this, r106));
        r106.H = true;
        r106.I = false;
        r106.f51941J = false;
        r103 = r106;
        goto L42
    L24:
        if (z2.f561427a.getValue().booleanValue() == false) goto L31;
        ConstraintLayout r112 = r106.f51956o;
        if (r112 == null) goto L28;
        UtilityKotlinExtentionsKt.j(r112);
    L28:
        ConstraintLayout r113 = r106.f51956o;
        if (r113 == null) goto L34;
        r113.setOnClickListener(new e(this, r106));
        goto L34
    L44:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    public static void K2(Long r100, TextView r101, boolean r102) {
        if (r100 == null) goto L5;
        int r103 = (int) r100.longValue();
    L6:
        if (r103 > 0) goto L10;
        if (r102 == false) goto L9;
        r101.setText(y0.i(R.string.ttlive_game_promote_comment_like_desc));
        return;
    L9:
        r101.setVisibility(8);
        return;
    L10:
        r101.setVisibility(0);
        String r104 = yt.m.a(r100, true);
        if (r104 == null) goto L15;
        r101.setText(StringsKt.trim(r104).toString());
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L5:
        r103 = 0;
        goto L6
    }

    public static void L2(long r100, ImageView r101, TextView r102) {
        if ((r100 & 1) != 1) goto L5;
        r102.setTextColor(y0.c(R.color.gamecp_douyin_light_Link));
        r101.setImageDrawable(y0.e(R.drawable.gamecp_ic_game_promote_comment_liked_v2));
        return;
    L5:
        r102.setTextColor(y0.c(R.color.gamecp_game_80161823));
        r101.setImageDrawable(y0.e(R.drawable.gamecp_ic_game_promote_comment_like_v2));
    }

    public final void E2(ConstraintLayout r100, int r110, String r111) {
        ArrayList<com.bytedance.android.gamecp.business.comment.data.k> r101 = this.f51892b;
        if (r101 == null) goto L7;
        com.bytedance.android.gamecp.business.comment.data.k r102 = (com.bytedance.android.gamecp.business.comment.data.k) CollectionsKt.getOrNull(r101, r110);
        if (r102 == null) goto L7;
        com.bytedance.android.gamecp.business.comment.data.s r103 = r102.replyInfo;
    L8:
        HashMap<String, String> r104 = GamecpTracker.f56755a;
        Pair[] r105 = new Pair[3];
        String r106 = "";
        if (r103 == null) goto L12;
        String r107 = r103.commentId;
        if (r107 == null) goto L12;
    L13:
        r105[0] = TuplesKt.to("comment_id", r107);
        if (r103 == null) goto L19;
        String r108 = r103.replyId;
        if (r108 == null) goto L19;
        r106 = r108;
    L19:
        r105[1] = TuplesKt.to(NoticeInfo.KEY_REPLY_ID, r106);
        r105[2] = TuplesKt.to("reply_level", r111);
        GamecpTracker.r(r100, "comment_reply_like", MapsKt.mapOf(r105), new d(this, r110), false, 112);
        return;
    L12:
        r107 = "";
    L7:
        r103 = null;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110, List<Object> r111) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r111, "payloads");
        if (r111.isEmpty() == false) goto L6;
        onBindViewHolder(r100, r110);
        return;
    L6:
        Object r112 = ListProtector.get(r111, 0);
        if ((r112 instanceof Bundle) == true) goto L9;
        r112 = null;
    L9:
        Bundle r113 = (Bundle) r112;
        if (r113 != null) goto L12;
        return;
    L12:
        Iterator<String> r101 = r113.keySet().iterator();
    L14:
        if (r101.hasNext() == false) goto L87;
        String r102 = r101.next();
        switch(r102.hashCode()) {
            case -1389498438: goto L83;
            case -905513795: goto L78;
            case -520917099: goto L61;
            case -480030919: goto L53;
            case -100242502: goto L35;
            case 593314685: goto L30;
            case 1921522759: goto L19;
            default: goto L14;
        };
    L19:
        if (r102.equals("comment_like_count") == false) goto L14;
        long r103 = r113.getLong("comment_like_count");
        if ((r100 instanceof CommentChildReplyViewHolder) == true) goto L22;
        if ((r100 instanceof GamePromoteCommentDetailViewHolder) == true) goto L25;
        if ((r100 instanceof CommentReplyViewHolder) == false) goto L14;
        K2(Long.valueOf(r103), ((CommentReplyViewHolder) r100).f51919e, false);
        goto L14
    L25:
        K2(Long.valueOf(r103), ((GamePromoteCommentDetailViewHolder) r100).f51946e, true);
        goto L14
    L22:
        K2(Long.valueOf(r103), ((CommentChildReplyViewHolder) r100).f51911g, false);
        goto L14
    L30:
        if (r102.equals("comment_child_has_more") == false) goto L14;
        if ((r100 instanceof CommentChildReplyBottomViewHolder) == false) goto L14;
        H2((CommentChildReplyBottomViewHolder) r100, r113.getBoolean("comment_child_has_more"));
        goto L14
    L35:
        if (r102.equals("comment_like_status") == false) goto L14;
        long r104 = r113.getLong("comment_like_status");
        if ((r100 instanceof CommentChildReplyViewHolder) == true) goto L38;
        if ((r100 instanceof GamePromoteCommentDetailViewHolder) == true) goto L41;
        if ((r100 instanceof CommentReplyViewHolder) == false) goto L14;
        CommentReplyViewHolder r105 = (CommentReplyViewHolder) r100;
        L2(r104, r105.f51920f, r105.f51919e);
        goto L14
    L41:
        GamePromoteCommentDetailViewHolder r106 = (GamePromoteCommentDetailViewHolder) r100;
        L2(r104, r106.f51950i, r106.f51946e);
        ImageView r107 = r106.f51951j;
        if (r107 == null) goto L14;
        TextView r108 = r106.f51947f;
        if (r108 == null) goto L14;
        if ((r104 & 2) == 2) goto L47;
        r108.setTextColor(y0.c(R.color.gamecp_game_80161823));
        r107.setImageDrawable(y0.e(R.drawable.gamecp_ic_game_promote_comment_dislike));
        goto L14
    L47:
        r108.setTextColor(y0.c(R.color.gamecp_douyin_light_Link));
        r107.setImageDrawable(y0.e(R.drawable.gamecp_ic_game_promote_comment_disliked));
        goto L14
    L38:
        CommentChildReplyViewHolder r109 = (CommentChildReplyViewHolder) r100;
        L2(r104, r109.f51912h, r109.f51911g);
        goto L14
    L53:
        if (r102.equals("comment_child_loading") == false) goto L14;
        if ((r100 instanceof CommentChildReplyBottomViewHolder) == false) goto L14;
        CommentChildReplyBottomViewHolder r114 = (CommentChildReplyBottomViewHolder) r100;
        if (r113.getBoolean("comment_child_loading") == true) goto L58;
        r114.T3(true);
        r114.f51903c.b();
        UtilityKotlinExtentionsKt.h(r114.f51903c);
        goto L14
    L58:
        UtilityKotlinExtentionsKt.j(r114.f51903c);
        r114.f51903c.a();
        r114.T3(false);
        goto L14
    L61:
        if (r102.equals("comment_dislike_count") == false) goto L14;
        long r115 = r113.getLong("comment_dislike_count");
        if ((r100 instanceof GamePromoteCommentDetailViewHolder) == false) goto L14;
        TextView r116 = ((GamePromoteCommentDetailViewHolder) r100).f51947f;
        if (r116 == null) goto L14;
        Long r117 = Long.valueOf(r115);
        if (r117 == null) goto L69;
        int r118 = (int) r117.longValue();
    L70:
        if (r118 <= 0) goto L71;
        String r119 = yt.m.a(r117, true);
        if (r119 == null) goto L76;
        r116.setText(StringsKt.trim(r119).toString());
        goto L14
    L76:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L71:
        r116.setText(y0.i(R.string.ttlive_game_promote_comment_dislike_desc));
        goto L14
    L69:
        r118 = 0;
        goto L70
    L78:
        if (r102.equals("comment_title_total") == false) goto L14;
        if ((r100 instanceof GamePromoteCommentDetailAdapterV2.GamePromoteCommentDetailTitleViewHolderV2) == false) goto L14;
        long r120 = r113.getLong("comment_title_total");
        ((GamePromoteCommentDetailAdapterV2.GamePromoteCommentDetailTitleViewHolderV2) r100).f55793a.setText(y0.j(R.string.ttlive_game_promote_comment_reply_total, new Object[]{Long.valueOf(r120)}));
        goto L14
    L83:
        if (r102.equals("comment_has_more") == false) goto L14;
        if ((r100 instanceof GamePromoteCommentDetailAdapterV2.GamePromoteCommentDetailBottomViewHolderV2) == false) goto L14;
        J2((GamePromoteCommentDetailAdapterV2.GamePromoteCommentDetailBottomViewHolderV2) r100, r113.getBoolean("comment_has_more"));
        goto L14
    }

    public static final void A2(CommentReplyListAdapter r100, View r101, String r102, String r103) {
        r100.getClass();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        HashMap<String, String> r104 = GamecpTracker.f56755a;
        GamecpTracker.n(r101, GPTrackAction.CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to("evaluation_id", r102), TuplesKt.to(NoticeInfo.KEY_REPLY_ID, r103)}), null, 0.0f, 56);
    }

    public static void G2(UserAvatarImageView r100, Context r101, ImageModel r102, com.bytedance.android.gamecp.business.comment.data.s r103) {
        String r104 = null;
        if (r103 == null) goto L7;
        User r105 = r103.user;
        if (r105 == null) goto L7;
        String r106 = r105.getIdStr();
    L8:
        r100.getClass();
        fu.j.b(r100, r102);
        r100.setOnClickListener(new com.bytedance.android.gamecp.common.ui.s(r100, r101, r106));
        t r107 = new t();
        Intrinsics.checkNotNullParameter("reply", "<set-?>");
        r107.f57152a = "reply";
        String r108 = "";
        if (r103 == null) goto L12;
        String r109 = r103.commentId;
        if (r109 == null) goto L12;
    L13:
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r107.f57153b = r109;
        if (r103 == null) goto L17;
        String r110 = r103.gameId;
        if (r110 == null) goto L17;
    L18:
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r107.f57155d = r110;
        HashMap<String, String> r111 = GamecpTracker.f56755a;
        com.bytedance.android.gamecp.common.track.filter.d r112 = GamecpTracker.h(zu.a.class);
        if ((r112 instanceof com.bytedance.android.gamecp.common.track.filter.b) == true) goto L21;
        r112 = null;
    L21:
        com.bytedance.android.gamecp.common.track.filter.b r113 = (com.bytedance.android.gamecp.common.track.filter.b) r112;
        if (r113 == null) goto L24;
        r108 = r113.f();
    L24:
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r107.f57156e = r108;
        if (Intrinsics.areEqual("reply", "reply") == false) goto L29;
        if (r103 == null) goto L28;
        r104 = r103.replyId;
    L28:
        r107.f57154c = r104;
    L29:
        r100.setTrackData(r107);
        return;
    L17:
        r110 = "";
    L12:
        r109 = "";
    L7:
        r106 = null;
        goto L8
    }

    public static final void z2(CommentReplyListAdapter r110, View r111, String r112, String r113, String r114) {
        r110.getClass();
        HashMap<String, String> r100 = GamecpTracker.f56755a;
        GamecpTracker.r(r111, "comment_reply_delete", MapsKt.emptyMap(), new l(), false, 112);
        GamecpTracker.n(r111, GPTrackAction.CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to("button", r112), TuplesKt.to("evaluation_id", r113), TuplesKt.to(NoticeInfo.KEY_REPLY_ID, r114)}), null, 0.0f, 56);
    }
}
