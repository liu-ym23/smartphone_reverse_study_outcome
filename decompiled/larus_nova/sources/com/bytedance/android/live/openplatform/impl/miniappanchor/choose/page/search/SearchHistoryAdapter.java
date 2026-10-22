package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/SearchHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/SearchHistoryAdapter$ViewHolder;", "ViewHolder", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchHistoryAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f84266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Integer, String, Unit> f84267b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/SearchHistoryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f84268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f84269b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function2<Integer, String, Unit> f84270c;

        public ViewHolder(View r100, Function2 r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "clickCallback");
            super(r100);
            this.f84270c = r101;
            this.f84268a = (TextView) r100.findViewById(R.id.history_name);
            this.f84269b = (ImageView) r100.findViewById(R.id.history_delete);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f84266a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchHistoryAdapter(List<String> r100, Function2<? super Integer, ? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "historyList");
        Intrinsics.checkNotNullParameter(r101, "clickCallback");
        this.f84266a = r100;
        this.f84267b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        String r103 = (String) ListProtector.get(this.f84266a, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "text");
        r102.f84268a.setText(r103);
        View r104 = r102.itemView;
        Object r105 = n80.a.f518238a;
        n80.b r106 = new n80.b(r104);
        TimeUnit r107 = TimeUnit.MILLISECONDS;
        r106.throttleFirst(500, r107).subscribe(new n(r102, r103));
        new n80.b(r102.f84269b).throttleFirst(500, r107).subscribe(new o(r102, r103));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_mini_app_choose_search_history_item, r100, false), this.f84267b);
    }
}
