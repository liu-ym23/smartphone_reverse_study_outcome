package com.bytedanceos.common.ui.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.CommonCache;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.ui.widget.AppStatusView;
import com.bytedanceos.common.ui.widget.SwipeItemView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class UninstallAppListAdapter extends QuickAdapter<AppInfo> {
    private final float APPSTATUS_OFFSET_X;
    protected List<AppInfo> mDataList;
    private boolean mIsBigFont;
    protected boolean mIsEditMode;
    private float mOffset;
    private View.OnClickListener mOnBtnClickListener;
    private HashMap<String, AppInfo> mSelectedApps;
    private SwipeItemView.OnSwipeItemListener mSwipeItemListener;
    private int mSwipeItemType;
    private HashMap<Integer, View> mUpdateViews;

    public UninstallAppListAdapter(View.OnClickListener r10, SwipeItemView.OnSwipeItemListener r11) {
        super(null);
        this.mSwipeItemListener = null;
        this.mSwipeItemType = 4;
        this.mDataList = new CopyOnWriteArrayList();
        this.mUpdateViews = new HashMap();
        this.mSelectedApps = new HashMap();
        this.mIsEditMode = false;
        this.APPSTATUS_OFFSET_X = 1050.0f;
        this.mOnBtnClickListener = r10;
        this.mSwipeItemListener = r11;
        this.mIsBigFont = e.n0();
        this.mOffset = BaseApplication.c().getResources().getDimension(R$dimen.swipe_item_checkbox_width);
    }

    private void convertListViewSlideItem(QuickAdapter.VH r10, AppInfo r11, int r12) {
        CheckBox r13 = (CheckBox) r10.getView(R$id.checkBox);
        if (this.mIsEditMode == false) goto L5;
        r13.setChecked(this.mSelectedApps.containsKey(r11.appPackageName));
    L6:
        int r14 = R$id.appIcon;
        NetworkImageView r15 = (NetworkImageView) r10.getView(r14);
        int r16 = R$drawable.oui_default_app_icon;
        r15.setErrorImageResId(r16);
        r15.setDefaultImageResId(r16);
        r15.e(r11.appIcon, 12.0f);
        r10.getView(r14).setTag(r11);
        ((TextView) r10.getView(R$id.appName)).setText(r11.appName);
        ((TextView) r10.getView(R$id.appCategory)).setText(r11.appCategoryName);
        if (TextUtils.isEmpty(r11.recmd_brief) == true) goto L9;
        r10.getView(R$id.appRate).setVisibility(8);
        int r17 = R$id.appVersionName;
        if (r10.getView(r17) == null) goto L26;
        r10.getView(r17).setVisibility(8);
    L26:
        int r18 = R$id.appBrief;
        if (r10.getView(r18) == null) goto L29;
        ((TextView) r10.getView(r18)).setText(r11.recmd_brief);
        r10.getView(r18).setVisibility(0);
    L29:
        AppStatusView r19 = (AppStatusView) r10.getView(R$id.appStatusLay);
        if ((r10.mConvertView instanceof SwipeItemView) == true) goto L32;
    L35:
        r19.showAppSize();
        r19.updateDownloadStatus(r11);
        r19.setTag(r11);
        int r20 = R$id.app_row_index;
        r19.setTag(r20, Integer.valueOf(r12));
        r19.setOnClickListener(this.mOnBtnClickListener);
        r10.mConvertView.setTag(R$id.appinfo, r11);
        r10.mConvertView.setTag(r20, Integer.valueOf(r12));
        View r21 = r10.mConvertView;
        if ((r21 instanceof SwipeItemView) == false) goto L38;
        SwipeItemView r22 = (SwipeItemView) r21;
        r22.setSwipeItemListener(this.mSwipeItemListener);
        r22.setItemSwipeType(this.mSwipeItemType);
    L39:
        this.mUpdateViews.put(Integer.valueOf(r12), r19);
        return;
    L38:
        r21.setOnClickListener(this.mOnBtnClickListener);
        goto L39
    L32:
        if (this.mIsEditMode == false) goto L34;
        r10.getView(R$id.checkBoxFrame).setX(0.0f);
        ((SwipeItemView) r10.mConvertView).getForgroundLayout().setX(this.mOffset);
        r19.setX(1050.0f);
        goto L35
    L34:
        r10.getView(R$id.checkBoxFrame).setX(-this.mOffset);
        ((SwipeItemView) r10.mConvertView).getForgroundLayout().setX(0.0f);
        r19.setX(r19.getLeft());
        goto L35
    L9:
        if (r11.appScores <= 0.0f) goto L17;
        int r23 = e.b0(BaseApplication.c(), r11.appScores, false);
        int r24 = R$id.appRate;
        ((ImageView) r10.getView(r24)).setImageResource(r23);
        int r25 = R$id.appBrief;
        if (r10.getView(r25) == null) goto L13;
        r10.getView(r25).setVisibility(8);
    L13:
        int r26 = R$id.appVersionName;
        if (r10.getView(r26) == null) goto L16;
        r10.getView(r26).setVisibility(8);
    L16:
        r10.getView(r24).setVisibility(0);
        goto L29
    L17:
        r10.getView(R$id.appRate).setVisibility(8);
        int r27 = R$id.appVersionName;
        if (r10.getView(r27) == null) goto L20;
        r10.getView(r27).setVisibility(8);
    L20:
        int r28 = R$id.appBrief;
        if (r10.getView(r28) == null) goto L29;
        ((TextView) r10.getView(r28)).setText(R$string.no_comment);
        r10.getView(r28).setVisibility(0);
        goto L29
    L5:
        r13.setChecked(false);
        goto L6
    }

    private CommonCache getStoreCache() {
        return BaseApplication.c().b();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void appendData(List<AppInfo> r10) {
        int r11 = getItemCount() - 1;
        this.mDatas.addAll(r10);
        if (r11 >= 0) goto L5;
        notifyItemRangeChanged(0, r10.size());
        return;
    L5:
        notifyItemRangeChanged(r11, r10.size());
    }

    @Override // com.bytedanceos.common.ui.adapter.QuickAdapter
    public /* bridge */ /* synthetic */ void convert(QuickAdapter.VH r10, AppInfo r11, int r12) {
        convert2(r10, r11, r12);
    }

    public int findAppInfoPositionByPkg(AppInfo r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mDatas.size()) goto L9;
        if (TextUtils.equals(((AppInfo) this.mDatas.get(r11)).appPackageName, r10.appPackageName) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r11;
    L9:
        return -1;
    }

    public List<AppInfo> getDatas() {
        return this.mDatas;
    }

    @Override // com.bytedanceos.common.ui.adapter.QuickAdapter
    public int getLayoutId(int r10) {
        return R$layout.app_swipe_list_item;
    }

    public ArrayList<AppInfo> getSelectedAppsForDelete() {
        ArrayList<AppInfo> r10 = new ArrayList();
        Iterator<AppInfo> r11 = this.mSelectedApps.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        AppInfo r12 = r11.next();
        if (getStoreCache().b0(r12.appPackageName) == true) goto L4;
        r10.add(r12);
        goto L4
    L9:
        return r10;
    }

    public ArrayList<AppInfo> getSelectedAppsForInstall() {
        ArrayList<AppInfo> r10 = new ArrayList();
        Iterator<AppInfo> r11 = this.mSelectedApps.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        AppInfo r12 = r11.next();
        if (getStoreCache().X(r12.appPackageName) == true) goto L4;
        if (getStoreCache().b0(r12.appPackageName) == true) goto L4;
        r10.add(r12);
        goto L4
    L11:
        return r10;
    }

    public int getSelectedCount() {
        return this.mSelectedApps.size();
    }

    @Override // com.bytedanceos.common.ui.adapter.QuickAdapter
    public void initView(int r10, QuickAdapter.VH r11) {
    }

    public boolean isChecked(int r10) {
        if (r10 > (this.mDatas.size() - 1)) goto L5;
        AppInfo r11 = (AppInfo) this.mDatas.get(r10);
    L6:
        if (r11 != null) goto L10;
        return false;
    L10:
        return this.mSelectedApps.containsKey(r11.appPackageName);
    L5:
        r11 = null;
        goto L6
    }

    public boolean isEditMode() {
        return this.mIsEditMode;
    }

    public void removeDataAtLocation(int r10) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        if (r10 > (this.mDatas.size() - 1)) goto L16;
        this.mDatas.remove(r10);
        notifyItemRemoved(r10);
        notifyItemRangeChanged(r10, getItemCount() - r10);
        HashMap<Integer, View> r11 = this.mUpdateViews;
        monitor-enter(r11);
        this.mUpdateViews.remove(Integer.valueOf(r10));     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void removeItems(ArrayList<AppInfo> r10) {
        monitor-enter(this);
        if (r10 != null) goto L30;
    L28:
        monitor-exit(this);
        return;
    L30:
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r10.size() == 0) goto L28;
        if (r10.size() != 1) goto L17;
        AppInfo r11 = r10.get(0);     // Catch: Throwable -> L13
        removeDataAtLocation(findAppInfoPositionByPkg(r11));     // Catch: Throwable -> L13
        if (this.mSelectedApps.get(r11.appPackageName) == null) goto L15;
        this.mSelectedApps.remove(r11.appPackageName);     // Catch: Throwable -> L13
    L15:
        monitor-exit(this);
        return;
    L17:
        Iterator<AppInfo> r12 = r10.iterator();     // Catch: Throwable -> L13
    L19:
        if (r12.hasNext() == false) goto L24;
        AppInfo r13 = r12.next();     // Catch: Throwable -> L13
        removeDataAtLocation(findAppInfoPositionByPkg(r13));     // Catch: Throwable -> L13
        if (this.mSelectedApps.get(r13.appPackageName) == null) goto L19;
        this.mSelectedApps.remove(r13.appPackageName);     // Catch: Throwable -> L13
        goto L19
    L24:
        monitor-exit(this);
    }

    public boolean setChecked(int r10, boolean r11) {
        if (r10 > (this.mDatas.size() - 1)) goto L5;
        AppInfo r12 = (AppInfo) this.mDatas.get(r10);
    L6:
        if (r12 != null) goto L9;
        return false;
    L9:
        if (r11 == false) goto L11;
        this.mSelectedApps.put(r12.appPackageName, r12);
    L12:
        return true;
    L11:
        this.mSelectedApps.remove(r12.appPackageName);
        goto L12
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.bytedanceos.common.ui.adapter.QuickAdapter
    public void setData(List<AppInfo> r10) {
        this.mDatas.clear();
        appendData(r10);
    }

    public void setDataList(List<AppInfo> r10) {
        this.mDatas.clear();
        appendData(r10);
        if (isEditMode() == false) goto L15;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.size() > 0) goto L8;
        return;
    L8:
        if (getSelectedCount() <= 0) goto L23;
        Iterator r11 = ((HashMap) this.mSelectedApps.clone()).values().iterator();
    L11:
        if (r11.hasNext() == false) goto L24;
        AppInfo r12 = (AppInfo) r11.next();
        if (r10.contains(r12) == true) goto L11;
        this.mSelectedApps.remove(r12.appPackageName);
        goto L11
    L24:
        return;
    L23:
        return;
    }

    public void setIsEditMode(boolean r10) {
        this.mIsEditMode = r10;
    }

    public void setSelectedAll(boolean r10) {
        this.mIsEditMode = true;
        this.mSelectedApps.clear();
        if (r10 == false) goto L8;
        Iterator r11 = this.mDatas.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        AppInfo r12 = (AppInfo) r11.next();
        this.mSelectedApps.put(r12.appPackageName, r12);
        goto L6
    L10:
        return;
    }

    /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
    public void convert2(QuickAdapter.VH r10, AppInfo r11, int r12) {
        convertListViewSlideItem(r10, r11, r12);
    }
}
