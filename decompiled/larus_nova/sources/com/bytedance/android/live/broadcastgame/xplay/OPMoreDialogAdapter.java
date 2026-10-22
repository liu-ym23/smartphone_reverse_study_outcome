package com.bytedance.android.live.broadcastgame.xplay;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/OPMoreDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/broadcastgame/xplay/OPMoreDialogViewHolder;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OPMoreDialogAdapter extends RecyclerView.Adapter<OPMoreDialogViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommonStandardBottomDialog f61856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<i> f61857b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f61857b.size();
    }

    public OPMoreDialogAdapter(CommonStandardBottomDialog r100, List<i> r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Intrinsics.checkNotNullParameter(r101, "items");
        this.f61856a = r100;
        this.f61857b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        OPMoreDialogViewHolder r102 = (OPMoreDialogViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        i r103 = (i) ListProtector.get(this.f61857b, r101);
        r102.f61858a.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_DARK));
        r102.f61858a.setText(r103.f62173b);
        r102.f61859b.setImageResource(r103.f62174c);
        r102.itemView.setOnClickListener(new h(this, r103));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        return new OPMoreDialogViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_open_platfrom_more_dialog_item, r100, false));
    }
}
