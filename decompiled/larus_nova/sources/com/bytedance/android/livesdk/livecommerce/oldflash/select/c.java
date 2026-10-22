package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends RecyclerView.Adapter<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f149725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.OnClickListener f149726b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f149725a.size();
    }

    public c(List r100, LiveFlashSelectDialogFragment.c r101) {
        Intrinsics.checkNotNullParameter(r100, "dataList");
        Intrinsics.checkNotNullParameter(r101, "onItemClickListener");
        this.f149725a = r100;
        this.f149726b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        d r102 = (d) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        b r103 = (b) ListProtector.get(this.f149725a, r101);
        TextView r104 = r102.f149727a;
        r104.setText(r103.f149723a);
        Context r105 = r104.getContext();
        if (r103.f149724b == false) goto L5;
        int r106 = R.color.ec_color_FE2C55;
    L6:
        r104.setTextColor(th.a.a(r105, r106));
        ImageView r107 = r102.f149728b;
        if (r103.f149724b == false) goto L9;
        int r108 = 0;
    L10:
        r107.setVisibility(r108);
        r102.itemView.setOnClickListener(this.f149726b);
        return;
    L9:
        r108 = 8;
        goto L10
    L5:
        r106 = R.color.ec_color_black_161823;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new d(th.a.c(r100.getContext(), R.layout.ec_flash_item_select, r100, false));
    }
}
