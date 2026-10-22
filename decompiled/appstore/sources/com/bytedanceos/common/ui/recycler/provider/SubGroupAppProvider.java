package com.bytedanceos.common.ui.recycler.provider;

import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.toolbox.glide.b;
import com.bytedanceos.common.toolbox.p;
import com.bytedanceos.common.ui.recycler.adapter.BaseMultiItemAdapter;
import com.bytedanceos.common.ui.recycler.entity.SubGroupAppItem;
import com.bytedanceos.common.ui.widget.SubButton;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public class SubGroupAppProvider<T> extends BaseItemProvider<SubGroupAppItem> {
    private BaseMultiItemAdapter mAdapter;

    public SubGroupAppProvider(BaseMultiItemAdapter r10) {
        this.mAdapter = r10;
    }

    public static /* synthetic */ BaseMultiItemAdapter access$000(SubGroupAppProvider r10) {
        return r10.mAdapter;
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
    public /* bridge */ /* synthetic */ void convert(@NotNull BaseViewHolder r10, SubGroupAppItem r11) {
        convert2(r10, r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return 5;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R$layout.item_sub_group_app;
    }

    /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
    public void convert2(@NotNull final BaseViewHolder r10, SubGroupAppItem r11) {
        if (r11.isAvailable() == true) goto L6;
        r10.itemView.setVisibility(8);
        return;
    L6:
        ImageView r12 = (ImageView) r10.getView(R$id.iv_icon);
        b.g(r12.getContext(), R$drawable.default_app_icon_banner, r11.getSubAppEntity().getBanner(), r12);
        setText(r10, R$id.tv_name, r11.getSubAppEntity().getName());
        setText(r10, R$id.tv_category, r11.getSubAppEntity().getCategory());
        setText(r10, R$id.tv_desc, r11.getOnlineTime());
        final SubButton r13 = (SubButton) r10.getView(R$id.btn_sub);
        r13.setId(r11.getSubAppEntity().getId());
        r13.setSubcirbe(r11.getSubAppEntity().isSubcribed());
        p.b(r13, new AnonymousClass1(this, r13, r10));
        r10.setGone(R$id.div_line, !r11.isShowDiv());
    }
}
