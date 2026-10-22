package com.bytedanceos.common.ui.recycler.provider;

import android.text.TextUtils;
import android.view.ViewGroup;
import cn.jzvd.JzvdStd;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.toolbox.q;
import com.bytedanceos.common.ui.recycler.adapter.BaseMultiItemAdapter;
import com.bytedanceos.common.ui.recycler.entity.SubVideoItem;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public class SubVideoProvider<T> extends BaseItemProvider<SubVideoItem> {
    private BaseMultiItemAdapter mAdapter;
    private JzvdStd mVideo;

    public SubVideoProvider(BaseMultiItemAdapter r10) {
        this.mAdapter = r10;
    }

    public static /* synthetic */ BaseMultiItemAdapter access$000(SubVideoProvider r10) {
        return r10.mAdapter;
    }

    private void initListener(BaseViewHolder r10, final int r11) {
        this.mVideo.setOnClickListener(new AnonymousClass1(this, r11));
    }

    private void updateView(BaseViewHolder r10, SubVideoItem r11) {
        if (r11.isAvailable() == true) goto L6;
        r10.itemView.setVisibility(8);
        return;
    L6:
        this.mVideo = (JzvdStd) r10.getView(R$id.video);
        String r12 = r11.getSubVideoEntity().getVideo().getUrl();
        if (TextUtils.isEmpty(r12) == false) goto L10;
        this.mVideo.setVisibility(8);
        return;
    L10:
        ViewGroup.LayoutParams r13 = this.mVideo.getLayoutParams();
        if (r13.width != (-1)) goto L13;
        r13.height = (q.h(this.mVideo.getContext()) * 202) / 360;
    L13:
        this.mVideo.setBannerUrl(r11.getSubVideoEntity().getVideo().getImg());
        this.mVideo.setVideoUrl(r12);
        this.mVideo.setControlVisable(r11.isControlVisable());
        this.mVideo.setFullScreenEnable(r11.isControlVisable());
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(@NotNull BaseViewHolder r10, SubVideoItem r11) {
        convert2(r10, r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return 3;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R$layout.item_sub_video;
    }

    /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
    public void convert2(@NotNull BaseViewHolder r10, SubVideoItem r11) {
        updateView(r10, r11);
        initListener(r10, r10.getAdapterPosition());
    }
}
