package com.bytedance.android.live.livepkaudience.list;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/list/PkSimplePreApplyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkSimplePreApplyViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f82074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f82075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f82076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f82077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f82078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<dl0.c, View> f82079f;

    /* JADX WARN: Multi-variable type inference failed */
    public PkSimplePreApplyViewHolder(View r100, Map<dl0.c, ? extends View> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "badgeTypeMap");
        super(r100);
        this.f82079f = r101;
        this.f82074a = (TextView) this.itemView.findViewById(R.id.tv_num);
        this.f82075b = (HSImageView) this.itemView.findViewById(R.id.iv_head);
        this.f82076c = (TextView) this.itemView.findViewById(R.id.tv_name);
        this.f82077d = (TextView) this.itemView.findViewById(R.id.tv_desc);
        this.f82078e = (LinearLayout) this.itemView.findViewById(R.id.name_container);
    }
}
