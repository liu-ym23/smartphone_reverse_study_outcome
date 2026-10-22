package com.bytedanceos.common.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.ui.widget.MyAppSwipeItemView;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PromoteListAdapt extends AppListAdapter {
    private AbsListView.LayoutParams mBottomSpaceParams;
    private AbsListView.LayoutParams mNormalParams;
    private View.OnClickListener mOnItemClickListener;

    public static class SpecialHolder implements AppListAdapter.BaseHolder {
        public NetworkImageView mBannerView;
        private List<AppInfo> mDataList;
        public TextView mGroupTitle;
        private View.OnClickListener mOnItemClickListener;

        public SpecialHolder() {
        }

        public void bindData(List<AppInfo> r10, View.OnClickListener r11) {
            this.mDataList = r10;
            this.mOnItemClickListener = r11;
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public int getConvertViewRid() {
            return 0;
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void initConvertView(View r10) {
            this.mBannerView = (NetworkImageView) r10.findViewById(R$id.app_item_banner);
            this.mGroupTitle = (TextView) r10.findViewById(R$id.app_item_group_title);
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void invalidateConvertView(int r10, View r11) {
            AppInfo r12 = this.mDataList.get(r10);
            PromoteListAdapt.updateSpecialItem(r11, r10, this, r12, this.mDataList, this.mOnItemClickListener);
            AdsReportManager.h().k(r12);
        }
    }

    public PromoteListAdapt(Context r10, ListView r11, View.OnClickListener r12, View.OnClickListener r13, MyAppSwipeItemView.OnSwipeItemActionListener r14, View.OnLongClickListener r15, int r16) {
        super(r10, r11, r12, r13, r14, r15);
        this.mOnItemClickListener = r13;
        int r17 = r10.getResources().getDimensionPixelOffset(R$dimen.list_item_normal_height);
        int r18 = r10.getResources().getDimensionPixelSize(R$dimen.list_item_space_height);
        this.mNormalParams = new AbsListView.LayoutParams(-1, r17);
        this.mBottomSpaceParams = new AbsListView.LayoutParams(-1, r18);
        this.mHeaderViewCount = r16;
    }

    private boolean isAddBottomSpace(int r10) {
        if (r10 == 0) goto L18;
        int r11 = r10 + 1;
        if (r11 == getCount()) goto L18;
        AppInfo r12 = this.mDataList.get(r11);
        if (r12.mItemShowType != 4) goto L10;
        return true;
    L10:
        int r13 = this.mDataList.get(r10).mItemShowType;
        int r14 = r12.mItemShowType;
        if (r13 != r14) goto L13;
        return false;
    L13:
        if (r13 == 1) goto L17;
        if (r14 == 1) goto L17;
        return false;
    L17:
        return true;
    L18:
        return false;
    }

    public static void updateSpecialItem(View r10, int r11, SpecialHolder r12, AppInfo r13, List<AppInfo> r14, View.OnClickListener r15) {
        int r16 = r14.get(r11).mItemShowType;
        if (r16 != 2) goto L5;
        NetworkImageView r17 = r12.mBannerView;
        if (r17 != null) goto L11;
        return;
    L11:
        if (r15 == null) goto L13;
        r17.setOnClickListener(r15);
        r12.mBannerView.setTag(R$id.appinfo, r13);
    L13:
        r12.mBannerView.e(r13.appIcon, 12.0f);
        r12.mBannerView.setVisibility(0);
        r12.mGroupTitle.setVisibility(8);
        return;
    L5:
        if (r16 != 4) goto L16;
        r12.mGroupTitle.setText(r13.appName);
        r12.mGroupTitle.setVisibility(0);
        r12.mBannerView.setVisibility(8);
        return;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r10) {
        int r11 = this.mDataList.get(r10).mItemShowType;
        if (r11 != 2) goto L5;
        return 1;
    L5:
        if (r11 == 4) goto L10;
        return 0;
    L10:
        return 1;
    }

    public View getSpecialView(int r10) {
        return this.mInflater.inflate(R$layout.app_item_list, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.bytedanceos.common.ui.adapter.AppListAdapter$BaseHolder] */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.bytedanceos.common.ui.adapter.AppListAdapter$BaseHolder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v8, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // com.bytedanceos.common.ui.adapter.AppListAdapter, android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        int r13 = getItemViewType(r10);
        if (r13 != 0) goto L5;
        View r14 = super.getView(r10, r11, r12);
        View r15 = r14.findViewById(R$id.app_list_space);
        if (r15 != null) goto L17;
    L19:
        if (r15 == null) goto L24;
        r14.setLayoutParams(this.mNormalParams);
        r15.setBackgroundResource(R$drawable.line);
        return r14;
    L24:
        return r14;
    L17:
        if (isAddBottomSpace(r10) == false) goto L19;
        r14.setLayoutParams(this.mBottomSpaceParams);
        r15.setBackgroundResource(R$drawable.app_list_space);
        return r14;
    L5:
        if (r13 != 1) goto L25;
        if (r11 != null) goto L9;
        ?? r16 = getViewHolder(r10);
        ?? r17 = getSpecialView(r10);
        r16.initConvertView(r17);
        r17.setTag(r16);
        ?? r18 = r16;
        ?? r19 = r17;
    L11:
        if ((r18 instanceof SpecialHolder) == false) goto L13;
        ((SpecialHolder) r18).bindData(this.mDataList, this.mOnItemClickListener);
    L13:
        r18.invalidateConvertView(r10, r19);
        return r19;
    L9:
        AppListAdapter.BaseHolder r20 = (AppListAdapter.BaseHolder) r11.getTag();
        r19 = r11;
        r18 = r20;
        goto L11
    L25:
        return r11;
    }

    @Override // com.bytedanceos.common.ui.adapter.AppListAdapter
    public AppListAdapter.BaseHolder getViewHolder(int r10) {
        if (getItemViewType(r10) != 1) goto L7;
        return new SpecialHolder();
    L7:
        return super.getViewHolder(r10);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
