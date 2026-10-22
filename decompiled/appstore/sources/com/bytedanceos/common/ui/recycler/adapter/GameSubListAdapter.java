package com.bytedanceos.common.ui.recycler.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.ui.recycler.listener.MultiViewWindowListener;
import com.bytedanceos.common.ui.recycler.provider.AppProvider;
import com.bytedanceos.common.ui.recycler.provider.GroupTitleProvider;
import com.bytedanceos.common.ui.recycler.provider.SubAppProvider;
import com.bytedanceos.common.ui.recycler.provider.SubGroupAppProvider;
import com.bytedanceos.common.ui.recycler.provider.SubVideoProvider;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public class GameSubListAdapter extends BaseMultiItemAdapter<MultiItemEntity> {
    public GameSubListAdapter(Context r10, List<MultiItemEntity> r11) {
        super(r10, r11);
    }

    public void addItemProviders() {
        addItemProvider(new SubVideoProvider(this));
        addItemProvider(new SubAppProvider(this));
        addItemProvider(new GroupTitleProvider(this));
        addItemProvider(new SubGroupAppProvider(this));
        addItemProvider(new AppProvider(this));
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(@NotNull List<? extends MultiItemEntity> r10, int r11) {
        return r10.get(r11).getItemType();
    }

    @Override // com.bytedanceos.common.ui.recycler.adapter.BaseMultiItemAdapter
    public void init() {
        addItemProviders();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder r10) {
        onViewAttachedToWindow((BaseViewHolder) r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder r10) {
        onViewDetachedFromWindow((BaseViewHolder) r10);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void onViewAttachedToWindow(@NotNull BaseViewHolder r10) {
        super.onViewAttachedToWindow(r10);
        MultiViewWindowListener r11 = this.mOnViewWindowListener;
        if (r11 == null) goto L6;
        r11.onViewAttachedToWindow(r10);
        return;
    }

    public void onViewDetachedFromWindow(@NonNull BaseViewHolder r10) {
        super.onViewDetachedFromWindow(r10);
        super.onViewDetachedFromWindow(r10);
        MultiViewWindowListener r11 = this.mOnViewWindowListener;
        if (r11 == null) goto L6;
        r11.onViewDetachedFromWindow(r10);
        return;
    }
}
