package com.bytedance.android.gamecp.business.comment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import com.bytedance.android.gamecp.common.track.filter.GPViewFilter;
import com.bytedance.android.gamecp.common.track.model.GPViewTrackData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/adapter/CommentEditorLabelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ViewHolder", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentEditorLabelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.gamecp.business.comment.data.n> f51887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super com.bytedance.android.gamecp.business.comment.data.n, Unit> f51888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f51889c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/adapter/CommentEditorLabelAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f51890a;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public static final class a extends TrackRegisterStrategy {
        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final int getAutoReportStrategy() {
            return 1;
        }

        public a() {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f51887a).size();
    }

    public CommentEditorLabelAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f51889c = r100;
        this.f51887a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r110) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        super.onViewAttachedToWindow(r110);
        int r100 = r110.getAdapterPosition();
        if (r100 == (-1)) goto L13;
        com.bytedance.android.gamecp.business.comment.data.n r101 = (com.bytedance.android.gamecp.business.comment.data.n) ListProtector.get(this.f51887a, r100);
        HashMap<String, String> r102 = GamecpTracker.f56755a;
        GamecpTracker.r(r110.itemView, "write_comment_keyword", MapsKt.mapOf(new Pair[]{TuplesKt.to("keyword", r101.f52055c), TuplesKt.to("keyword_rank", String.valueOf(r100))}), new a(), false, 112);
        if (r101.f52054b != null) goto L14;
        com.bytedance.android.gamecp.common.track.filter.d r103 = GamecpTracker.h(GPViewTrackData.class);
        if ((r103 instanceof GPViewFilter) == true) goto L9;
        r103 = null;
    L9:
        GPViewFilter r104 = (GPViewFilter) r103;
        if (r104 == null) goto L15;
        HashMap<String, String> r105 = new HashMap();
        r104.b(r110.itemView, r105, MapsKt.mapOf(TuplesKt.to("action", "unclick")), true, "write_comment_keyword");
        ((com.bytedance.android.gamecp.business.comment.data.n) ListProtector.get(this.f51887a, r100)).f52054b = r105;
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        ViewHolder r102 = (ViewHolder) r100;
        com.bytedance.android.gamecp.business.comment.data.n r103 = (com.bytedance.android.gamecp.business.comment.data.n) ListProtector.get(this.f51887a, r101);
        if (r103.f52056d == false) goto L5;
        int r104 = R.drawable.gamecp_shape_game_promote_comment_detail_label_item_select;
        int r105 = R.color.gamecp_game_FE2C55;
    L6:
        r102.itemView.setBackground(ResourcesCompat.getDrawable(this.f51889c.getResources(), r104, null));
        TextView r106 = r102.f51890a;
        if (r106 == null) goto L9;
        r106.setTextColor(ResourcesCompat.getColor(this.f51889c.getResources(), r105, null));
    L9:
        TextView r107 = r102.f51890a;
        if (r107 == null) goto L12;
        r107.setText(r103.f52055c);
    L12:
        r102.itemView.setOnClickListener(new com.bytedance.android.gamecp.business.comment.adapter.a(this, r101));
        return;
    L5:
        r104 = R.drawable.gamecp_shape_game_promote_comment_detail_label_item_unselect;
        r105 = R.color.gamecp_game_99161823;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(this.f51889c).inflate(R.layout.gamecp_game_promote_detail_edit_comment_label_item, r100, false);
        ViewHolder r103 = new ViewHolder(r102);
        r103.f51890a = (TextView) r102.findViewById(R.id.label_text);
        return r103;
    }
}
