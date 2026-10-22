package com.bytedanceos.common.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.TitleInfo;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.ui.widget.AppGroupView;
import com.bytedanceos.common.ui.widget.SwipeItemView;
import com.bytedanceos.common.ui.widget.oui.OUIAppStatusView;
import com.obric.oui.paneltitlebar.OPanelTitleBar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public class AppManagerListAdapter extends TopicListAdapter {
    boolean mIsBigFont;
    private boolean mIsEditMode;
    private float mOffset;
    protected View.OnClickListener mOnBtnClickListener;
    private View.OnLongClickListener mOnLongClickListener;
    private HashMap<String, AppInfo> mSelectedApps;
    private SwipeItemView.OnSwipeItemListener mSwipeItemListener;
    private int mSwipeItemType;
    private int mTitleType;

    public AppManagerListAdapter(Context r10, View.OnClickListener r11, SwipeItemView.OnSwipeItemListener r12, View.OnLongClickListener r13) {
        super(r10, null, r11, r11);
        this.mIsBigFont = false;
        this.mIsEditMode = false;
        this.mOffset = 0.0f;
        this.mSelectedApps = new HashMap();
        this.mSwipeItemType = 0;
        this.mOnLongClickListener = null;
        this.mSwipeItemListener = null;
        this.mTitleType = -1;
        this.mIsBigFont = e.n0();
        this.mOnBtnClickListener = r11;
        this.mSwipeItemListener = r12;
        this.mOffset = r10.getResources().getDimension(R$dimen.swipe_item_checkbox_width);
    }

    private void convertCollectionItem(QuickAdapter.VH r10, AppInfo r11, int r12) {
        TextView r13 = (TextView) r10.getView(R$id.subTitle);
        ImageView r14 = (ImageView) r10.getView(R$id.appRate);
        if (r13 == null) goto L13;
        if (r14 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r11.recmd_brief) == true) goto L9;
        r13.setText(r11.recmd_brief);
        r13.setVisibility(0);
        r14.setVisibility(8);
        return;
    L9:
        if (r11.appScores <= 0.0f) goto L11;
        r13.setVisibility(8);
        r14.setImageResource(e.b0(BaseApplication.c(), r11.appScores, false));
        r14.setVisibility(0);
        return;
    L11:
        r13.setVisibility(8);
        r14.setVisibility(8);
        return;
    }

    private void convertDiskFull(QuickAdapter.VH r10, TopicListAdapter.TopicItem r11, int r12) {
        r10.getView(R$id.clear_cache_btn).setOnClickListener(this.mOnBtnClickListener);
    }

    private void convertIgnoreUpdateTitle(QuickAdapter.VH r10, TopicListAdapter.TopicItem r11, int r12) {
        Object r13 = r11.mData;
        if ((r13 instanceof TitleInfo) == true) goto L5;
        return;
    L5:
        TitleInfo r14 = (TitleInfo) r13;
        TextView r15 = (TextView) r10.getView(R$id.total_hidden_numbers);
        if (TextUtils.equals(r15.getText(), r14.mTitleMessage) == true) goto L8;
        r15.setText(r14.mTitleMessage);
    L8:
        r10.mConvertView.setTag(R$id.app_row_index, Integer.valueOf(r12));
        r10.mConvertView.setOnClickListener(this.mOnBtnClickListener);
    }

    private void convertListViewSlideItem(QuickAdapter.VH r10, TopicListAdapter.TopicItem r11, int r12) {
        Object r13 = r11.mData;
        if ((r13 instanceof AppInfo) == true) goto L5;
        return;
    L5:
        AppInfo r14 = (AppInfo) r13;
        NetworkImageView r15 = (NetworkImageView) r10.getView(R$id.appIcon);
        int r16 = R$drawable.oui_default_app_icon;
        r15.setErrorImageResId(r16);
        r15.setDefaultImageResId(r16);
        r15.e(r14.appIcon, f.i(20));
        ((TextView) r10.getView(R$id.appName)).setText(r14.appName);
        ((TextView) r10.getView(R$id.appCategory)).setText(r14.appCategoryName);
        int r17 = this.mSwipeItemType;
        if (r17 != 2) goto L8;
    L16:
        convertUpdateItem(r10, r14, r12);
    L17:
        OUIAppStatusView r18 = (OUIAppStatusView) r10.getView(R$id.appStatusLay);
        r18.showAppSize();
        r18.updateDownloadStatus(r14);
        r18.setTag(r14);
        int r19 = R$id.app_row_index;
        r18.setTag(r19, Integer.valueOf(r12));
        r18.setOnClickListener(this.mOnBtnClickListener);
        r10.mConvertView.setTag(R$id.appinfo, r14);
        r10.mConvertView.setTag(r19, Integer.valueOf(r12));
        View r20 = r10.mConvertView;
        if ((r20 instanceof SwipeItemView) == false) goto L20;
        SwipeItemView r21 = (SwipeItemView) r20;
        r21.setSwipeItemListener(this.mSwipeItemListener);
        r21.setItemSwipeType(this.mSwipeItemType);
    L21:
        HashMap<Integer, View> r22 = this.mUpdateViews;
        monitor-enter(r22);
        this.mUpdateViews.put(Integer.valueOf(r12), r18);     // Catch: Throwable -> L26
        monitor-exit(r22);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    L20:
        r20.setOnClickListener(this.mOnBtnClickListener);
        goto L21
    L8:
        if (r17 == 3) goto L16;
        if (r17 != 0) goto L12;
    L15:
        convertCollectionItem(r10, r14, r12);
        goto L17
    L12:
        if (r17 == 1) goto L15;
        convertOtherItem(r10, r14, r12);
        goto L17
    }

    private void convertOtherItem(QuickAdapter.VH r10, AppInfo r11, int r12) {
        TextView r13 = (TextView) r10.getView(R$id.subTitle);
        ImageView r14 = (ImageView) r10.getView(R$id.appRate);
        ((ImageView) r10.getView(R$id.delete_btn)).setTag(r11);
        if (this.mSwipeItemType == 0) goto L15;
        FrameLayout r15 = (FrameLayout) r10.getView(R$id.checkBoxFrame);
        CheckBox r16 = (CheckBox) r10.getView(R$id.checkBox);
        RelativeLayout r17 = (RelativeLayout) r10.getView(R$id.forground_layout);
        if (this.mSwipeItemType != 4) goto L14;
        r15.setVisibility(0);
        OUIAppStatusView r18 = (OUIAppStatusView) r10.getView(R$id.appStatusLay);
        if (this.mIsEditMode == false) goto L11;
        r16.setChecked(this.mSelectedApps.containsKey(r11.appPackageName));
        r15.setTranslationX(0.0f);
        r17.setTranslationX(this.mOffset);
        if (r18 == null) goto L15;
        r18.setTranslationX(r18.getWidth());
        r18.updateBtnEnable(false);
        goto L15
    L11:
        r16.setChecked(false);
        r15.setTranslationX(-this.mOffset);
        r17.setTranslationX(0.0f);
        if (r18 == null) goto L15;
        r18.setTranslationX(0.0f);
        r18.updateBtnEnable(true);
        goto L15
    L14:
        r15.setVisibility(8);
    L15:
        int r19 = this.mSwipeItemType;
        if (r19 != 2) goto L18;
    L34:
        if (r14 == null) goto L36;
        r14.setVisibility(8);
    L36:
        r13.setText(r11.appVersionName);
        return;
    L18:
        if (r19 == 3) goto L34;
        if (TextUtils.isEmpty(r11.recmd_brief) == true) goto L23;
        r14.setVisibility(8);
        if (r13 == null) goto L41;
        r13.setVisibility(8);
        return;
    L41:
        return;
    L23:
        if (r11.appScores <= 0.0f) goto L28;
        r14.setImageResource(e.b0(BaseApplication.c(), r11.appScores, false));
        if (r13 == null) goto L27;
        r13.setVisibility(8);
    L27:
        r14.setVisibility(0);
        return;
    L28:
        r14.setVisibility(8);
        if (r13 == null) goto L39;
        r13.setVisibility(8);
        return;
    }

    private void convertSingleTitle(QuickAdapter.VH r10, TopicListAdapter.TopicItem r11, int r12) {
        Object r13 = r11.mData;
        if ((r13 instanceof TitleInfo) == true) goto L5;
        return;
    L5:
        TitleInfo r14 = (TitleInfo) r13;
        OPanelTitleBar r15 = (OPanelTitleBar) r10.getView(R$id.tv_header);
        if (TextUtils.isEmpty(r14.mTitle) == true) goto L9;
        r15.setTitle(r14.mTitle);
        return;
    }

    private void convertSubTitle(QuickAdapter.VH r10, TopicListAdapter.TopicItem r11, int r12) {
        Object r13 = r11.mData;
        if ((r13 instanceof TitleInfo) == true) goto L5;
        return;
    L5:
        TitleInfo r14 = (TitleInfo) r13;
        ImageView r15 = (ImageView) r10.getView(R$id.title_icon);
        if (r14.mLeftIconRes <= 0) goto L8;
        r15.setVisibility(0);
        r15.setImageResource(r14.mLeftIconRes);
    L9:
        TextView r16 = (TextView) r10.getView(R$id.title);
        if (TextUtils.isEmpty(r14.mTitle) == false) goto L12;
        r16.setVisibility(8);
    L13:
        TextView r17 = (TextView) r10.getView(R$id.sub_title);
        if (TextUtils.isEmpty(r14.mTitleMessage) == false) goto L16;
        r17.setVisibility(8);
        return;
    L16:
        r17.setVisibility(0);
        r17.setText(r14.mTitleMessage);
        return;
    L12:
        r16.setVisibility(0);
        r16.setText(r14.mTitle);
        goto L13
    L8:
        r15.setVisibility(8);
        goto L9
    }

    private void convertTitle(QuickAdapter.VH r10, TopicListAdapter.TopicItem r11, int r12) {
        Object r13 = r11.mData;
        if ((r13 instanceof TitleInfo) == true) goto L5;
        return;
    L5:
        TitleInfo r14 = (TitleInfo) r13;
        ImageView r15 = (ImageView) r10.getView(R$id.title_icon);
        if (r14.mLeftIconRes <= 0) goto L8;
        r15.setVisibility(0);
        r15.setImageResource(r14.mLeftIconRes);
    L9:
        TextView r16 = (TextView) r10.getView(R$id.title);
        if (TextUtils.isEmpty(r14.mTitle) == false) goto L12;
        r16.setVisibility(8);
    L14:
        if (r14.mType != 4) goto L16;
        r10.mConvertView.setOnClickListener(this.mOnBtnClickListener);
        return;
    L16:
        r10.mConvertView.setClickable(false);
        return;
    L12:
        r16.setVisibility(0);
        r16.setText(r14.mTitle);
        goto L14
    L8:
        r15.setVisibility(8);
        goto L9
    }

    private void convertUpdateHeaderView(QuickAdapter.VH r10, TopicListAdapter.TopicItem r11, int r12) {
        Object r13 = r11.mData;
        if ((r13 instanceof TitleInfo) == true) goto L5;
        return;
    L5:
        View r14 = r10.mConvertView;
        updateView(r14, (TitleInfo) r13);
        r10.mConvertView.setTag(R$id.app_row_index, Integer.valueOf(r12));
        HashMap<Integer, View> r15 = this.mUpdateViews;
        monitor-enter(r15);
        this.mUpdateViews.put(Integer.valueOf(r12), r10.mConvertView);     // Catch: Throwable -> L10
        monitor-exit(r15);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void convertUpdateItem(QuickAdapter.VH r10, AppInfo r11, int r12) {
        ((TextView) r10.getView(R$id.subTitle)).setText(BaseApplication.c().getResources().getString(R$string.app_new_version, new Object[]{r11.appVersionName}));
    }

    private void updateOrRemoveListItem(OUIAppStatusView r10, AppInfo r11, boolean r12) {
        if (r12 == false) goto L4;
        removeDataAtLocation(findAppInfoPositionByPkg(116, r11));
        return;
    L4:
        r10.updateDownloadStatus(r11);
    }

    private void updateView(View r10, TitleInfo r11) {
        TextView r12 = (TextView) r10.findViewById(R$id.update_prompt);
        if (TextUtils.equals(r12.getText(), r11.mTitleMessage) == true) goto L5;
        r12.setText(r11.mTitleMessage);
    L5:
        TextView r13 = (TextView) r10.findViewById(R$id.update_all_btn);
        int r14 = R$id.update_all_btn_type;
        Object r15 = r13.getTag(r14);
        if (r15 != null) goto L8;
    L11:
        r13.setTag(r14, Integer.valueOf(r11.mType));
        View r16 = r10.findViewById(R$id.update_all_tips);
        int r17 = r11.mType;
        this.mTitleType = r17;
        if (r17 != 0) goto L14;
        r13.setEnabled(false);
        r13.setAlpha(0.5f);
        r13.setText(R$string.update_all);
        r16.setVisibility(8);
        return;
    L14:
        if (r17 != 1) goto L16;
        r13.setEnabled(true);
        r13.setAlpha(1.0f);
        r13.setText(R$string.update_all);
        r13.setOnClickListener(this.mOnBtnClickListener);
        r16.setVisibility(0);
        return;
    L16:
        if (r17 != 2) goto L18;
        r13.setEnabled(true);
        r13.setAlpha(1.0f);
        r13.setText(R$string.pause_all);
        r13.setOnClickListener(this.mOnBtnClickListener);
        r16.setVisibility(8);
        return;
    L18:
        if (r17 != 3) goto L20;
        r13.setEnabled(false);
        r13.setAlpha(0.5f);
        r13.setText(R$string.pause_all);
        r16.setVisibility(8);
        return;
    L20:
        if (r17 != 4) goto L33;
        r13.setEnabled(true);
        r13.setAlpha(1.0f);
        r13.setText(R$string.update_all);
        r13.setOnClickListener(this.mOnBtnClickListener);
        r16.setVisibility(0);
        return;
    L33:
        return;
    L8:
        if ((r15 instanceof Integer) == false) goto L11;
        if (((Integer) r15).intValue() != r11.mType) goto L11;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedanceos.common.ui.adapter.TopicListAdapter
    public void appendData(List<TopicListAdapter.TopicItem> r10) {
        int r11 = getItemCount() - 1;
        this.mDatas.addAll(r10);
        if (r11 >= 0) goto L5;
        notifyDataSetChanged();
        return;
    L5:
        notifyItemRangeChanged(r11, r10.size());
    }

    @Override // com.bytedanceos.common.ui.adapter.TopicListAdapter, com.bytedanceos.common.ui.adapter.QuickAdapter
    public /* bridge */ /* synthetic */ void convert(QuickAdapter.VH r10, TopicListAdapter.TopicItem r11, int r12) {
        convert(r10, r11, r12);
    }

    @Override // com.bytedanceos.common.ui.adapter.TopicListAdapter
    public void convertListViewItem(QuickAdapter.VH r10, TopicListAdapter.TopicItem r11, int r12) {
        super.convertListViewItem(r10, r11, r12);
        HashMap<Integer, View> r13 = this.mUpdateViews;
        monitor-enter(r13);
        View r14 = this.mUpdateViews.get(Integer.valueOf(r12));     // Catch: Throwable -> L7
        if (r14 == null) goto L9;
        r14.setTag(R$id.app_row_index, Integer.valueOf(r12));     // Catch: Throwable -> L7
    L9:
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int findAppInfoPositionByPkg(int r10, AppInfo r11) {
        int r12 = 0;
    L4:
        if (r12 >= this.mDatas.size()) goto L14;
        TopicListAdapter.TopicItem r13 = (TopicListAdapter.TopicItem) this.mDatas.get(r12);
        if (r13.mType != r10) goto L13;
        Object r14 = r13.mData;
        if ((r14 instanceof AppInfo) == false) goto L13;
        if (TextUtils.equals(((AppInfo) r14).appPackageName, r11.appPackageName) == false) goto L13;
        return r12;
    L13:
        r12 = r12 + 1;
        goto L4
    L14:
        return -1;
    }

    public int findLastViewPositionByViewType(int r10) {
        int r11 = getItemCount() - 1;
    L3:
        if (r11 < 0) goto L8;
        if (((TopicListAdapter.TopicItem) this.mDatas.get(r11)).mType == r10) goto L6;
        r11 = r11 - 1;
        goto L3
    L6:
        return r11;
    L8:
        return -1;
    }

    @Override // com.bytedanceos.common.ui.adapter.TopicListAdapter, com.bytedanceos.common.ui.adapter.QuickAdapter
    public int getLayoutId(int r10) {
        switch(r10) {
            case 110: goto L20;
            case 111: goto L18;
            case 112: goto L16;
            case 113: goto L14;
            case 114: goto L12;
            case 115: goto L10;
            case 116: goto L8;
            case 117: goto L4;
            case 118: goto L6;
            default: goto L4;
        };
    L4:
        return super.getLayoutId(r10);
    L6:
        return R$layout.title_no_update;
    L8:
        return R$layout.swipe_list_item;
    L10:
        return R$layout.title_update_disk_full;
    L12:
        return R$layout.title_ignore;
    L14:
        return R$layout.title_update_header;
    L16:
        return R$layout.title_sub_title;
    L18:
        return R$layout.myapplist_section_header;
    L20:
        return R$layout.title_default;
    }

    public int getTitleType() {
        return this.mTitleType;
    }

    public void hideLastViewLine() {
        int r10 = getItemCount() - 1;
        if (r10 < 0) goto L6;
        TopicListAdapter.TopicItem r11 = (TopicListAdapter.TopicItem) this.mDatas.get(r10);
        r11.mHiddenDivideLine = true;
        updateDataAtLocation(r10, r11);
        return;
    }

    @Override // com.bytedanceos.common.ui.adapter.TopicListAdapter
    public void removeDataAtLocation(int r10) {
        if (r10 < 0) goto L11;
        this.mDatas.remove(r10);
        notifyItemRemoved(r10);
        notifyItemRangeChanged(r10, (getItemCount() - 1) - r10);
        HashMap<Integer, View> r11 = this.mUpdateViews;
        monitor-enter(r11);
        this.mUpdateViews.remove(Integer.valueOf(r10));     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedanceos.common.ui.adapter.QuickAdapter
    public void setData(List<TopicListAdapter.TopicItem> r10) {
        this.mDatas.clear();
        appendData(r10);
    }

    public void setIsEditMode(boolean r10) {
        this.mIsEditMode = r10;
        if (r10 == true) goto L6;
        this.mSelectedApps.clear();
        return;
    }

    public void setItemSwipeType(int r10) {
        this.mSwipeItemType = r10;
    }

    public void setTitleType(int r10) {
        this.mTitleType = r10;
    }

    public boolean updateCachedHeaderView(int r10, String r11, int r12) {
        View r13 = this.mUpdateViews.get(Integer.valueOf(r10));
        if (r13 != null) goto L6;
        return false;
    L6:
        if (r13.getId() != R$id.title_update_header) goto L9;
        TitleInfo r14 = (TitleInfo) ((TopicListAdapter.TopicItem) this.mDatas.get(r10)).mData;
        r14.mTitleMessage = r11;
        r14.mType = r12;
        updateView(r13, r14);
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void updateDataAtLocation(int r10, TopicListAdapter.TopicItem r11) {
        if (r10 < 0) goto L4;
        this.mDatas.set(r10, (T) r11);
        notifyItemChanged(r10);
        return;
    L4:
        this.mDatas.add((T) r11);
        notifyItemChanged(getItemCount() - 1);
    }

    @Override // com.bytedanceos.common.ui.adapter.TopicListAdapter
    public void updateDownloadStatus() {
        HashMap<Integer, View> r10 = this.mUpdateViews;
        monitor-enter(r10);
        HashSet r11 = new HashSet(this.mUpdateViews.values());     // Catch: Throwable -> L45
        monitor-exit(r10);     // Catch: Throwable -> L45
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L44;
        View r13 = (View) r12.next();
        if ((r13 instanceof OUIAppStatusView) == true) goto L11;
        if ((r13 instanceof AppGroupView) == false) goto L8;
        ((AppGroupView) r13).refreshWholeGroupView();
        goto L8
    L11:
        Object r14 = r13.getTag();
        if (r14 == null) goto L40;
        if ((r14 instanceof AppInfo) == false) goto L69;
        OUIAppStatusView r15 = (OUIAppStatusView) r13;
        AppInfo r16 = (AppInfo) r14;
        int r17 = this.mSwipeItemType;
        if (r17 == 0) goto L39;
        boolean r18 = true;
        if (r17 == 1) goto L39;
        if (r17 != 2) goto L23;
        AppInfo r19 = BaseApplication.c().b().G(r16.appPackageName);
        if (r19 != null) goto L35;
    L38:
        updateOrRemoveListItem(r15, r16, r18);
        goto L8
    L35:
        if (r19.appVersionCode == r19.hideVersionCode) goto L38;
        r18 = false;
        goto L38
    L23:
        if (r17 != 3) goto L8;
        AppInfo r20 = BaseApplication.c().b().G(r16.appPackageName);
        if (r20 != null) goto L28;
    L31:
        updateOrRemoveListItem(r15, r16, r18);
        goto L8
    L28:
        if (r20.appVersionCode != r20.hideVersionCode) goto L31;
        r18 = false;
    L39:
        r15.updateDownloadStatus(r16);
        goto L8
    L69:
        return;
    L40:
        return;
    L44:
        return;
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedanceos.common.ui.adapter.TopicListAdapter
    public void convert(QuickAdapter.VH r10, TopicListAdapter.TopicItem r11, int r12) {
        View r13 = r10.getView(R$id.divider_line);
        if (r13 == null) goto L10;
        if (r11.mHiddenDivideLine == false) goto L7;
        int r14 = 8;
    L8:
        r13.setVisibility(r14);
        goto L10
    L7:
        r14 = 0;
    L10:
        switch(r11.mType) {
            case 110: goto L18;
            case 111: goto L17;
            case 112: goto L16;
            case 113: goto L15;
            case 114: goto L14;
            case 115: goto L13;
            case 116: goto L12;
            case 117: goto L11;
            case 118: goto L18;
            default: goto L11;
        };
    L11:
        super.convert(r10, r11, r12);
        return;
    L12:
        convertListViewSlideItem(r10, r11, r12);
        return;
    L13:
        convertDiskFull(r10, r11, r12);
        return;
    L14:
        convertIgnoreUpdateTitle(r10, r11, r12);
        return;
    L15:
        convertUpdateHeaderView(r10, r11, r12);
        return;
    L16:
        convertSubTitle(r10, r11, r12);
        return;
    L17:
        convertSingleTitle(r10, r11, r12);
        return;
    L18:
        convertTitle(r10, r11, r12);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedanceos.common.ui.adapter.TopicListAdapter
    public void appendData(int r10, TopicListAdapter.TopicItem r11) {
        this.mDatas.add(r10, (T) r11);
        notifyItemInserted(r10);
        notifyItemRangeChanged(r10, getItemCount() - r10);
    }
}
