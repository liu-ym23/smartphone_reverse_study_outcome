package com.android.ttcjpaysdk.std.asset.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.std.asset.bean.StdAssetItemBean;
import com.android.ttcjpaysdk.std.asset.view.base.IAssetGroupView;
import com.android.ttcjpaysdk.std.asset.view.base.IAssetItemView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002$%B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u00152\n\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u001c\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001aH\u0016J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/std/asset/view/StdAssetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/android/ttcjpaysdk/std/asset/view/StdAssetAdapter$ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "parentGroupView", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetGroupView;", "data", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetItemBean;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetGroupView;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "getData", "()Ljava/util/ArrayList;", "mClickListener", "Lcom/android/ttcjpaysdk/std/asset/view/StdAssetAdapter$ClickListener;", "getParentGroupView", "()Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetGroupView;", "dataChangedNotify", "", "list", "genItem", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetItemView;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnClickListener", "l", "ClickListener", "ViewHolder", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class StdAssetAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context context;
    private final ArrayList<StdAssetItemBean> data;
    private ClickListener mClickListener;
    private final IAssetGroupView parentGroupView;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/std/asset/view/StdAssetAdapter$ClickListener;", "", SendEventContainerMethodParamModel.EventKinds.onClick, "", "view", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetItemView;", "data", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetItemBean;", "onCollapseOrNot", "collapse", "", "subGroupType", "", "onOptionVoucherChanged", "checked", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ClickListener {
        void onClick(IAssetItemView r100, StdAssetItemBean r101);

        void onCollapseOrNot(boolean r100, String r101);

        void onOptionVoucherChanged(boolean r100, IAssetItemView r101, StdAssetItemBean r102);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/std/asset/view/StdAssetAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "assetItemView", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetItemView;", "(Lcom/android/ttcjpaysdk/std/asset/view/StdAssetAdapter;Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetItemView;)V", "getAssetItemView", "()Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetItemView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "bindData", "", "info", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetItemBean;", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final IAssetItemView assetItemView;
        private final Context context;
        final /* synthetic */ StdAssetAdapter this$0;

        public final IAssetItemView getAssetItemView() {
            return this.assetItemView;
        }

        public final Context getContext() {
            return this.context;
        }

        public final void bindData(StdAssetItemBean r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            this.assetItemView.updateData(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ViewHolder(StdAssetAdapter r100, IAssetItemView r101) {
            Intrinsics.checkNotNullParameter(r101, "assetItemView");
            this.this$0 = r100;
            super((View) r101);
            this.assetItemView = r101;
            this.context = this.itemView.getContext();
        }
    }

    public IAssetItemView genItem() {
        return new StdAssetItemView(this.context, this.parentGroupView, null, 4, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final Context getContext() {
        return this.context;
    }

    public final ArrayList<StdAssetItemBean> getData() {
        return this.data;
    }

    public final IAssetGroupView getParentGroupView() {
        return this.parentGroupView;
    }

    public static final /* synthetic */ ClickListener access$getMClickListener$p(StdAssetAdapter r100) {
        return r100.mClickListener;
    }

    public final void dataChangedNotify(ArrayList<StdAssetItemBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.data.clear();
        this.data.addAll(r100);
        notifyDataSetChanged();
    }

    public final void setOnClickListener(ClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
        this.mClickListener = r100;
    }

    public void onBindViewHolder(final ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        final StdAssetItemBean r102 = (StdAssetItemBean) ListProtector.get(this.data, r101);
        r100.bindData(r102);
        r100.getAssetItemView().setOnClickListener(new AnonymousClass1(this, r100, r102));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(this, genItem());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        onBindViewHolder((ViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return onCreateViewHolder(r100, r101);
    }

    public StdAssetAdapter(Context r100, IAssetGroupView r101, ArrayList<StdAssetItemBean> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parentGroupView");
        Intrinsics.checkNotNullParameter(r102, "data");
        this.context = r100;
        this.parentGroupView = r101;
        this.data = r102;
    }
}
