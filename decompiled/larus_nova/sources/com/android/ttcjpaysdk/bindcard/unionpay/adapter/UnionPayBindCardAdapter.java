package com.android.ttcjpaysdk.bindcard.unionpay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.bindcard.unionpay.bean.UnionPayBankBean;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/adapter/UnionPayBindCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapterListener", "Lcom/android/ttcjpaysdk/bindcard/unionpay/adapter/UnionPayBindCardAdapter$OnUnionPayBindCardAdapterListener;", "getAdapterListener", "()Lcom/android/ttcjpaysdk/bindcard/unionpay/adapter/UnionPayBindCardAdapter$OnUnionPayBindCardAdapterListener;", "setAdapterListener", "(Lcom/android/ttcjpaysdk/bindcard/unionpay/adapter/UnionPayBindCardAdapter$OnUnionPayBindCardAdapterListener;)V", "getContext", "()Landroid/content/Context;", "data", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayBankBean;", "Lkotlin/collections/ArrayList;", "dataChangedNotify", "", "list", "getItemCount", "", "getItemId", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnUnionPayBindCardAdapterListener", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayBindCardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private OnUnionPayBindCardAdapterListener adapterListener;
    private final Context context;
    private ArrayList<UnionPayBankBean> data;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/adapter/UnionPayBindCardAdapter$OnUnionPayBindCardAdapterListener;", "", "onSelectBankCard", "", MapController.ITEM_LAYER_TAG, "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayBankBean;", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnUnionPayBindCardAdapterListener {
        void onSelectBankCard(UnionPayBankBean r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r100) {
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final OnUnionPayBindCardAdapterListener getAdapterListener() {
        return this.adapterListener;
    }

    public final Context getContext() {
        return this.context;
    }

    public UnionPayBindCardAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.data = new ArrayList();
    }

    public final void dataChangedNotify(ArrayList<UnionPayBankBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.data.clear();
        this.data.addAll(r100);
        notifyDataSetChanged();
    }

    public final void setAdapterListener(OnUnionPayBindCardAdapterListener r100) {
        this.adapterListener = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof UnionPayBindCardViewHolder) == false) goto L6;
        UnionPayBindCardViewHolder r102 = (UnionPayBindCardViewHolder) r100;
        r102.bindData((UnionPayBankBean) ListProtector.get(this.data, r101));
        r102.setAdapterListener(this.adapterListener);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new UnionPayBindCardViewHolder(LayoutInflater.from(this.context).inflate(R.layout.cj_pay_item_bind_card_with_checkbox, r100, false));
    }
}
