package com.bytedance.android.gamecp.business.gamedetail.view.comment;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/comment/GameCommentScoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameCommentScoreViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f55756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f55757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f55758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProgressBar f55759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProgressBar f55760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProgressBar f55761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProgressBar f55762g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ProgressBar f55763h;

    public GameCommentScoreViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "mItemView");
        super(r100);
        this.f55756a = (TextView) r100.findViewById(R.id.tv_average_score);
        this.f55757b = (TextView) r100.findViewById(R.id.comment_total_count);
        this.f55758c = (TextView) r100.findViewById(R.id.current_version_score);
        this.f55759d = (ProgressBar) r100.findViewById(R.id.progressbar_score_distribution_five);
        this.f55760e = (ProgressBar) r100.findViewById(R.id.progressbar_score_distribution_four);
        this.f55761f = (ProgressBar) r100.findViewById(R.id.progressbar_score_distribution_three);
        this.f55762g = (ProgressBar) r100.findViewById(R.id.progressbar_score_distribution_two);
        this.f55763h = (ProgressBar) r100.findViewById(R.id.progressbar_score_distribution_one);
    }
}
