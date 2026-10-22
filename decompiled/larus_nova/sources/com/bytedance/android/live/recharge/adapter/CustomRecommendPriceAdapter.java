package com.bytedance.android.live.recharge.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.viewholder.CustomRecommendPriceViewHolder;
import com.bytedance.android.live.revenue.common.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/recharge/adapter/CustomRecommendPriceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/recharge/viewholder/CustomRecommendPriceViewHolder;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomRecommendPriceAdapter extends RecyclerView.Adapter<CustomRecommendPriceViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Long> f89623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f89624b;

    public interface a {
        void Yq(long r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<Long> r100 = this.f89623a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public CustomRecommendPriceAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        CustomRecommendPriceViewHolder r101 = (CustomRecommendPriceViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        List<Long> r102 = this.f89623a;
        if (r102 == null) goto L15;
        Long r111 = (Long) ListProtector.get(r102, r110);
        if (r111 == null) goto L16;
        long r103 = r111.longValue();
        TextView r112 = r101.f90564a;
        int r104 = (int) (r103 / 100.0f);
        float r105 = r104;
        if (r105 >= 10000.0f) goto L9;
        String r106 = s1.C(R.string.ttlive_recharge_dialog_real_price, new Object[]{Integer.valueOf(r104)});
    L13:
        r112.setText(r106);
        r101.itemView.setOnClickListener(new xv0.a(r103, this));
        return;
    L9:
        float r107 = r105 / 10000.0f;
        if ((r104 % ((int) 10000.0f)) != 0) goto L12;
        r106 = s1.C(R.string.ttlive_recharge_dialog_real_price_ten_thousand, new Object[]{Integer.valueOf((int) r107)});
        goto L13
    L12:
        r106 = s1.C(R.string.ttlive_recharge_dialog_real_price_ten_thousand, new Object[]{l.a("%.1f", new Object[]{Float.valueOf(r107)})});
        goto L13
    L16:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new CustomRecommendPriceViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_custom_recharge_dialog_deal_tip, r100, false));
    }
}
