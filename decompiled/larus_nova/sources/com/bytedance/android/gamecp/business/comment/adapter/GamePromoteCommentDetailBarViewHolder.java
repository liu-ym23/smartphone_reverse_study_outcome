package com.bytedance.android.gamecp.business.comment.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.business.comment.data.GamePromoteCommentViewModel;
import com.bytedance.android.gamecp.business.view.GamePromoteCommonRatingBar;
import com.bytedance.live.datacontext.DataContext;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/adapter/GamePromoteCommentDetailBarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GamePromoteCommentDetailBarViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f51932h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f51933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f51934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GamePromoteCommonRatingBar f51935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f51936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GamePromoteCommentViewModel f51937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f51938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function2<String, String, Unit> f51939g;

    public final void T3() {
        this.itemView.setVisibility(8);
        ViewGroup.LayoutParams r100 = this.itemView.getLayoutParams();
        if (r100 == null) goto L7;
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100;
        ((ViewGroup.MarginLayoutParams) r101).height = 0;
        ((ViewGroup.MarginLayoutParams) r101).width = 0;
        this.itemView.setLayoutParams(r101);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    public final void U3() {
        this.itemView.setVisibility(0);
        ViewGroup.LayoutParams r100 = this.itemView.getLayoutParams();
        if (r100 == null) goto L7;
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100;
        ((ViewGroup.MarginLayoutParams) r101).height = -2;
        ((ViewGroup.MarginLayoutParams) r101).width = -1;
        this.itemView.setLayoutParams(r101);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    public final void V3() {
        int r100 = com.bytedance.android.gamecp.business.comment.edit.help.a.f52128a;
        GamePromoteCommentViewModel r101 = this.f51937e;
        TextView r102 = this.f51933a;
        GamePromoteCommonRatingBar r103 = this.f51935c;
        int r104 = 0;
        if (r101 == null) goto L25;
        com.bytedance.live.datacontext.m<Double> r105 = r101.getScoreOnly();
        if (r105 == null) goto L25;
        if (r105.getValue().doubleValue() != AudioStats.AUDIO_AMPLITUDE_NONE) goto L25;
        if (r103 == null) goto L10;
        r103.setProgress(0);
    L10:
        if (r102 == null) goto L12;
        r102.setText(R.string.ttlive_game_promote_click_to_rate);
    L12:
        com.bytedance.live.datacontext.m<String> r106 = r101.getScoreGuidePrompt();
        if (r106 == null) goto L36;
        String r107 = r106.getValue();
        if (r107 != null) goto L17;
        return;
    L17:
        if (r107.length() <= 0) goto L19;
        r104 = 1;
    L19:
        if (r104 != 0) goto L22;
        r107 = null;
    L22:
        if (r107 == null) goto L38;
        if (r102 == null) goto L39;
        r102.setText(r107);
        return;
    L39:
        return;
    L38:
        return;
    L36:
        return;
    L25:
        if (r103 == null) goto L33;
        if (r101 == null) goto L32;
        com.bytedance.live.datacontext.m<Double> r108 = r101.getScoreOnly();
        if (r108 == null) goto L32;
        Double r109 = r108.getValue();
        if (r109 == null) goto L32;
        r104 = (int) (r109.doubleValue() * ((double) 10));
    L32:
        r103.setProgress(r104);
    L33:
        if (r102 == null) goto L41;
        r102.setText(R.string.ttlive_game_promote_my_score_comment);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GamePromoteCommentDetailBarViewHolder(View r100, Function2<? super String, ? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f51939g = r101;
        this.f51933a = (TextView) r100.findViewById(R.id.tv_title);
        this.f51934b = (TextView) r100.findViewById(R.id.tv_input_button);
        this.f51935c = (GamePromoteCommonRatingBar) r100.findViewById(R.id.rating_bar);
        this.f51936d = r100.findViewById(R.id.v_bottom_line);
        DataContext r102 = com.bytedance.live.datacontext.d.d(GamePromoteCommentViewModel.class);
        if ((r102 instanceof GamePromoteCommentViewModel) == true) goto L5;
        r102 = null;
    L5:
        this.f51937e = (GamePromoteCommentViewModel) r102;
    }
}
