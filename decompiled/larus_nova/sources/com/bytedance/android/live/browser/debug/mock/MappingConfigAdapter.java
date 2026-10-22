package com.bytedance.android.live.browser.debug.mock;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q20.i;
import r20.b;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/MappingConfigAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/browser/debug/mock/MappingConfigAdapter$ViewHolder;", "ViewHolder", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MappingConfigAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f62620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentActivity f62621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f62622c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/MappingConfigAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f62623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f62624b;

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public final String toString() {
            return super.toString() + " '" + this.f62624b.getText() + "'";
        }

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f62623a = (TextView) r100.findViewById(R.id.item_number);
            this.f62624b = (TextView) r100.findViewById(R.id.content);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f62620a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        b r103 = (b) ListProtector.get(this.f62620a, r101);
        r102.f62623a.setText(String.valueOf(r101 + 1));
        r102.f62624b.setText(r103.f535712a);
        r102.f62624b.setOnClickListener(new i(this, r103));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.fragment_mapping_config, r100, false));
    }

    public MappingConfigAdapter(List<b> r100, FragmentActivity r101, Uri r102) {
        Intrinsics.checkNotNullParameter(r100, "values");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "originUri");
        this.f62620a = r100;
        this.f62621b = r101;
        this.f62622c = r102;
    }
}
