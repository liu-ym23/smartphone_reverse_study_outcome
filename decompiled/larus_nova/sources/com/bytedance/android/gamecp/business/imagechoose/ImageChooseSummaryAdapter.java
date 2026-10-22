package com.bytedance.android.gamecp.business.imagechoose;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.base.core.service.depend.w;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y;
import com.larus.nova.R;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/imagechoose/ImageChooseSummaryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ViewHolder", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageChooseSummaryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f56053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<w> f56054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super w, Unit> f56055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f56056d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/imagechoose/ImageChooseSummaryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HSImageView f56057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f56058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f56059c;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f56054b.size();
    }

    public ImageChooseSummaryAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f56056d = r100;
        this.f56054b = new LinkedList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        ViewHolder r102 = (ViewHolder) r100;
        w r103 = this.f56054b.get(r101);
        String r104 = r103.f51415e;
        if (TextUtils.equals(r102.f56059c, r104) == true) goto L5;
        r102.f56059c = r104;
        y.c(r102.f56057a, r104, UtilityKotlinExtentionsKt.c(26), UtilityKotlinExtentionsKt.c(26), 4);
    L5:
        View r105 = r102.f56058b;
        if (r105 == null) goto L9;
        r105.setOnClickListener(new h(this, r103));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f56053a = LayoutInflater.from(this.f56056d).inflate(R.layout.gamecp_game_promote_image_choose_summary_item, r100, false);
        View r102 = this.f56053a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L5:
        ViewHolder r103 = new ViewHolder(r102);
        View r104 = this.f56053a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L8:
        r103.f56057a = (HSImageView) r104.findViewById(R.id.media_view);
        View r105 = this.f56053a;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L11:
        r103.f56058b = r105.findViewById(R.id.iv_cancel);
        return r103;
    }
}
