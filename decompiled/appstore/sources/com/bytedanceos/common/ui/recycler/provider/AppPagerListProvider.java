package com.bytedanceos.common.ui.recycler.provider;

import android.view.View;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.c;
import com.bytedanceos.common.ui.recycler.adapter.BaseMultiItemAdapter;
import com.bytedanceos.common.ui.recycler.entity.AppPagerListItem;
import com.bytedanceos.common.ui.recycler.listener.OnPagerClickListener;
import com.bytedanceos.common.ui.widget.AppGroupView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public class AppPagerListProvider<T> extends BaseItemProvider<AppPagerListItem> {
    private BaseMultiItemAdapter mAdapter;
    protected View.OnClickListener mBtnClickListener;
    protected View.OnClickListener mItemClickListener;
    private OnPagerClickListener mOnPagerClickListener;

    public AppPagerListProvider(BaseMultiItemAdapter r10) {
        this.mItemClickListener = new AnonymousClass1(this);
        this.mBtnClickListener = new AnonymousClass2(this);
        this.mAdapter = r10;
    }

    public static /* synthetic */ OnPagerClickListener access$000(AppPagerListProvider r10) {
        return r10.mOnPagerClickListener;
    }

    private List<AppInfo> addPositionForAppLists(List<AppInfo> r10, int r11) {
        if (c.a(r10) == false) goto L7;
        return null;
    L7:
        return r10;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(@NotNull BaseViewHolder r10, AppPagerListItem r11) {
        convert2(r10, r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return 10;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R$layout.item_app_pager_list;
    }

    public void setPagerClickListener(OnPagerClickListener r10) {
        this.mOnPagerClickListener = r10;
    }

    /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
    public void convert2(@NotNull BaseViewHolder r10, AppPagerListItem r11) {
        if (r11.isAvailable() == true) goto L6;
        r10.itemView.setVisibility(8);
        return;
    L6:
        AppGroupView r12 = (AppGroupView) r10.getView(R$id.group_view);
        r12.setType(2);
        r12.setDataList(addPositionForAppLists(r11.getAppInfos(), r10.getAdapterPosition()));
        r12.setOnClickListener(this.mBtnClickListener, this.mItemClickListener);
    }
}
