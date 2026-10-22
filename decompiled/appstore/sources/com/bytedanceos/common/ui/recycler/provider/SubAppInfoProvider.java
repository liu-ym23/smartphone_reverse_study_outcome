package com.bytedanceos.common.ui.recycler.provider;

import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.toolbox.glide.b;
import com.bytedanceos.common.ui.recycler.adapter.BaseMultiItemAdapter;
import com.bytedanceos.common.ui.recycler.entity.SubAppInfoItem;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public class SubAppInfoProvider<T> extends BaseItemProvider<SubAppInfoItem> {
    private BaseMultiItemAdapter mAdapter;
    private ImageView mIvIcon;

    public SubAppInfoProvider(BaseMultiItemAdapter r10) {
        this.mAdapter = r10;
    }

    private void setText(BaseViewHolder r10, int r11, String r12) {
        if (TextUtils.isEmpty(r12) == false) goto L5;
        r10.setGone(r11, true);
        return;
    L5:
        r10.setGone(r11, false);
        r10.setText(r11, r12);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(@NotNull BaseViewHolder r10, SubAppInfoItem r11) {
        convert2(r10, r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return 6;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R$layout.item_sub_app_info;
    }

    /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
    public void convert2(@NotNull BaseViewHolder r10, SubAppInfoItem r11) {
        if (r11.isAvailable() == true) goto L6;
        r10.itemView.setVisibility(8);
        return;
    L6:
        BaseMultiItemAdapter r12 = this.mAdapter;
        r12.setPage(r12.getPage());
        this.mIvIcon = (ImageView) r10.getView(R$id.iv_icon);
        b.k(this.context, R$drawable.default_app_icon_normal, r11.getSubAppEntity().getLogo(), this.mIvIcon, this.context.getResources().getDimensionPixelOffset(R$dimen.sub_app_info_icon_radius));
        setText(r10, R$id.tv_name, r11.getSubAppEntity().getName());
        setText(r10, R$id.tv_category, r11.getSubAppEntity().getCategory());
        setText(r10, R$id.tv_desc, r11.getOnlineTime());
        r10.setGone(R$id.div_line, !r11.isShowDiv());
    }
}
