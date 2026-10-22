package com.android.ttcjpaysdk.integrated.counter.game.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.integrated.counter.adapter.ConfirmAdapterProxy;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import com.android.ttcjpaysdk.integrated.counter.game.viewholder.GroupTypeGameViewHolder;
import com.android.ttcjpaysdk.integrated.counter.game.viewholder.SingleTypeGameViewHolder;
import com.android.ttcjpaysdk.integrated.counter.viewholder.BaseViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/game/adapter/ConfirmGameAdapter;", "Lcom/android/ttcjpaysdk/integrated/counter/adapter/ConfirmAdapterProxy;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "integrated-counter-game_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConfirmGameAdapter extends ConfirmAdapterProxy {
    @Override // com.android.ttcjpaysdk.integrated.counter.adapter.ConfirmAdapterProxy
    public int getItemCount() {
        return getData().size();
    }

    public ConfirmGameAdapter(Context r100) {
        super(r100);
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.adapter.ConfirmAdapterProxy
    public int getItemViewType(int r100) {
        String r101 = ((PaymentMethodInfo) ListProtector.get(getData(), r100)).paymentType;
        if (Intrinsics.areEqual(r101, "quickpay") == false) goto L6;
        return 0;
    L6:
        if (Intrinsics.areEqual(r101, "addcard") == true) goto L11;
        return 1;
    L11:
        return 0;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.adapter.ConfirmAdapterProxy
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        PaymentMethodInfo r102 = (PaymentMethodInfo) ListProtector.get(getData(), r101);
        if ((r100 instanceof BaseViewHolder) == false) goto L6;
        ((BaseViewHolder) r100).bindData(r102);
        return;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.adapter.ConfirmAdapterProxy
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 0) goto L9;
        if (r101 == 1) goto L11;
        return new SingleTypeGameViewHolder(getInflate().inflate(R.layout.cj_pay_item_confirm_single_type_layout, r100, false));
    L11:
        return new SingleTypeGameViewHolder(getInflate().inflate(R.layout.cj_pay_item_confirm_single_type_layout, r100, false));
    L9:
        return new GroupTypeGameViewHolder(getInflate().inflate(R.layout.cj_pay_item_confirm_group_type_layout, r100, false));
    }
}
