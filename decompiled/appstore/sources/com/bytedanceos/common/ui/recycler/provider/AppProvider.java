package com.bytedanceos.common.ui.recycler.provider;

import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.p;
import com.bytedanceos.common.ui.recycler.adapter.BaseMultiItemAdapter;
import com.bytedanceos.common.ui.recycler.entity.AppItem;
import com.bytedanceos.common.ui.widget.oui.OUIAppStatusView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import org.jetbrains.annotations.NotNull;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public class AppProvider<T> extends BaseItemProvider<AppItem> {
    private BaseMultiItemAdapter mAdapter;

    public AppProvider(BaseMultiItemAdapter r10) {
        this.mAdapter = r10;
    }

    public static /* synthetic */ BaseMultiItemAdapter access$000(AppProvider r10) {
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
    public /* bridge */ /* synthetic */ void convert(@NotNull BaseViewHolder r10, AppItem r11) {
        convert2(r10, r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R$layout.item_app;
    }

    /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
    public void convert2(@NotNull final BaseViewHolder r10, AppItem r11) {
        if (r11.isAvailable() == true) goto L6;
        r10.itemView.setVisibility(8);
        return;
    L6:
        ((NetworkImageView) r10.getView(R$id.appIcon)).e(r11.getAppEntity().getLogo(), f.i(20));
        setText(r10, R$id.appName, r11.getAppEntity().getName());
        setText(r10, R$id.appCategory, r11.getAppEntity().getCategory());
        int r12 = R$id.appBrief;
        setText(r10, r12, r11.getAppEntity().getCategory());
        int r13 = R$id.appRate;
        ImageView r14 = (ImageView) r10.getView(r13);
        if (TextUtils.isEmpty(r11.getAppEntity().getRecmd_brief()) == true) goto L9;
        r10.setGone(r13, true);
        r10.setGone(r12, false);
        setText(r10, r12, r11.getAppEntity().getRecmd_brief());
    L13:
        AppInfo r15 = r11.getAppInfo();
        if (r15 == null) goto L16;
        r15.tabSource = this.mAdapter.getSource();
        final OUIAppStatusView r16 = (OUIAppStatusView) r10.getView(R$id.appStatusLay);
        r16.updateDownloadStatus(r15);
        r16.showAppSize();
        r16.setTag(r15);
        p.b(r16, new AnonymousClass1(this, r16, r10));
        AdsReportManager.h().k(r15);
    L16:
        r10.setGone(R$id.app_list_space, !r11.isShowDiv());
        return;
    L9:
        if (r11.getAppEntity().getScores() <= 0.0f) goto L11;
        r14.setImageResource(e.b0(r14.getContext(), r11.getAppEntity().getScores(), false));
        r10.setGone(r13, false);
        r10.setGone(r12, true);
        goto L13
    L11:
        r10.setGone(r13, true);
        r10.setGone(r12, false);
        setText(r10, r12, this.context.getString(R$string.no_comment));
        goto L13
    }
}
