package com.bytedanceos.common.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.ui.widget.SwipeItemView;
import com.bytedanceos.common.ui.widget.oui.OUIAppStatusView;
import com.obric.oui.paneltitlebar.OPanelTitleBar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public class MyAppsAdapter extends RecyclerView.Adapter {
    public static final String CATEGORY_SECTION_HEADER = "section_header";
    public static final String SECTION_HEADER_DOWNLOAD_QUEUE = "section_header_download_queue";
    public static final String SECTION_HEADER_LOCAL_APP = "section_header_local_app";
    private static final String SECTION_HEADER_VERSION_NAME = "section_header_version_name";
    private final int VT_DOWNLOAD_QUEUE;
    private final int VT_HEADER;
    private final int VT_LOCAL_APP;
    private final int VT_SECTION_HEADER;
    private View.OnClickListener mBtnListener;
    private Context mContext;
    protected List<AppInfo> mDatas;
    public AppInfo mHeaderDownloadQueue;
    public AppInfo mHeaderLocalApp;
    private View mHeaderView;
    private boolean mIsBigFont;
    private View.OnClickListener mItemListener;
    private View.OnLongClickListener mLongClickListener;
    private SwipeItemView.OnSwipeItemListener mSwipItemListener;
    private int mSwipeItemType;

    public class DownloadAppQueueViewHolder extends RecyclerView.ViewHolder {
        private TextView appBriefIntro;
        private TextView appCategory;
        private NetworkImageView appIcon;
        private TextView appName;
        private ImageView appRate;
        private OUIAppStatusView appStatusContainer;
        private TextView appVersionName;
        private View contentView;
        private boolean isSwipe;
        final /* synthetic */ MyAppsAdapter this$0;

        public DownloadAppQueueViewHolder(MyAppsAdapter r10, View r11) {
            this.this$0 = r10;
            super(r11);
            this.contentView = r11;
            this.appIcon = (NetworkImageView) r11.findViewById(R$id.appIcon);
            this.appName = (TextView) r11.findViewById(R$id.appName);
            this.appCategory = (TextView) r11.findViewById(R$id.appCategory);
            this.appBriefIntro = (TextView) r11.findViewById(R$id.appBrief);
            this.appVersionName = (TextView) r11.findViewById(R$id.appVersionName);
            this.appRate = (ImageView) r11.findViewById(R$id.appRate);
            OUIAppStatusView r12 = (OUIAppStatusView) r11.findViewById(R$id.appStatusLay);
            this.appStatusContainer = r12;
            r12.setOnClickListener(MyAppsAdapter.access$000(r10));
            this.appStatusContainer.showAppSize();
        }

        public void invalidateConvertView(int r10) {
            if (r10 >= 0) goto L4;
            return;
        L4:
            if (r10 > (this.this$0.mDatas.size() - 1)) goto L26;
            AppInfo r11 = this.this$0.mDatas.get(r10);
            if (r11 == null) goto L27;
            NetworkImageView r12 = this.appIcon;
            int r13 = R$drawable.oui_default_app_icon;
            r12.setErrorImageResId(r13);
            this.appIcon.setDefaultImageResId(r13);
            this.appIcon.e(r11.appIcon, f.i(20));
            this.contentView.setTag(r11);
            View r14 = this.contentView;
            int r15 = R$id.appinfo;
            r14.setId(r15);
            this.contentView.setTag(r15, r11);
            this.appIcon.setTag(R$id.appIcon, r11);
            this.appName.setText(r11.appName);
            this.appCategory.setVisibility(8);
            float r16 = r11.appScores;
            if (r16 > 0.0f) goto L11;
            r16 = 1.0f;
        L11:
            this.appRate.setImageResource(e.b0(BaseApplication.c(), r16, false));
            this.appBriefIntro.setVisibility(0);
            if (TextUtils.isEmpty(r11.recmd_brief) == false) goto L14;
            this.appBriefIntro.setText(r11.appCategoryName);
        L15:
            TextView r17 = this.appVersionName;
            if (r17 == null) goto L18;
            r17.setVisibility(8);
        L18:
            this.appStatusContainer.showAppSize();
            this.appStatusContainer.updateDownloadStatus(r11);
            this.appStatusContainer.setTag(r11);
            this.appStatusContainer.setTag(R$id.app_row_index, Integer.valueOf(r10));
            this.appStatusContainer.setOnClickListener(MyAppsAdapter.access$000(this.this$0));
            View r18 = this.contentView;
            if ((r18 instanceof SwipeItemView) == false) goto L28;
            SwipeItemView r19 = (SwipeItemView) r18;
            if (this.isSwipe == false) goto L23;
            r19.setItemSwipeType(MyAppsAdapter.access$100(this.this$0));
            r19.setSwipeItemListener(MyAppsAdapter.access$200(this.this$0));
            return;
        L23:
            r18.setOnClickListener(MyAppsAdapter.access$300(this.this$0));
            return;
        L28:
            return;
        L14:
            this.appBriefIntro.setText(r11.recmd_brief);
            goto L15
        L27:
            return;
        }

        public void setSwipe(boolean r10) {
            this.isSwipe = r10;
        }
    }

    public class HeadViewHolder extends RecyclerView.ViewHolder {
        View convertView;
        final /* synthetic */ MyAppsAdapter this$0;

        public HeadViewHolder(MyAppsAdapter r10, View r11) {
            this.this$0 = r10;
            super(r11);
            this.convertView = r11;
        }
    }

    public class LocalAppViewHolder extends DownloadAppQueueViewHolder {
        final /* synthetic */ MyAppsAdapter this$0;

        public LocalAppViewHolder(MyAppsAdapter r10, View r11) {
            this.this$0 = r10;
            super(r10, r11);
        }
    }

    public class SectionHeaderViewHolder extends RecyclerView.ViewHolder {
        OPanelTitleBar header;
        final /* synthetic */ MyAppsAdapter this$0;

        public SectionHeaderViewHolder(MyAppsAdapter r10, View r11) {
            this.this$0 = r10;
            super(r11);
            this.header = (OPanelTitleBar) r11.findViewById(R$id.tv_header);
        }

        public void invalidateConvertView(int r10) {
            this.header.setTitle(this.this$0.mDatas.get(r10).appName);
        }
    }

    public MyAppsAdapter(Context r10, View.OnClickListener r11, View.OnClickListener r12, SwipeItemView.OnSwipeItemListener r13, View.OnLongClickListener r14) {
        this.VT_DOWNLOAD_QUEUE = 0;
        this.VT_LOCAL_APP = 1;
        this.VT_SECTION_HEADER = 2;
        this.VT_HEADER = 3;
        this.mDatas = new CopyOnWriteArrayList();
        this.mSwipeItemType = 4;
        this.mContext = r10;
        this.mBtnListener = r11;
        this.mItemListener = r12;
        this.mSwipItemListener = r13;
        this.mLongClickListener = r14;
        this.mHeaderLocalApp = newHeader("section_header_local_app", r10.getString(R$string.myapp_installed_apps));
        this.mHeaderDownloadQueue = newHeader("section_header_download_queue", r10.getString(R$string.downloading));
        this.mIsBigFont = e.n0();
    }

    public static /* synthetic */ View.OnClickListener access$000(MyAppsAdapter r10) {
        return r10.mBtnListener;
    }

    public static /* synthetic */ int access$100(MyAppsAdapter r10) {
        return r10.mSwipeItemType;
    }

    public static /* synthetic */ SwipeItemView.OnSwipeItemListener access$200(MyAppsAdapter r10) {
        return r10.mSwipItemListener;
    }

    public static /* synthetic */ View.OnClickListener access$300(MyAppsAdapter r10) {
        return r10.mItemListener;
    }

    private void appendData(List<AppInfo> r10) {
        int r11 = getItemCount() - 1;
        this.mDatas.addAll(r10);
        if (r11 >= 0) goto L5;
        notifyItemRangeChanged(0, r10.size() + 1);
        return;
    L5:
        notifyItemRangeChanged(r11, r10.size() + 1);
    }

    private static AppInfo newHeader(String r10, String r11) {
        AppInfo r12 = new AppInfo();
        r12.appCategoryName = "section_header";
        r12.appPackageName = r10;
        r12.appName = r11;
        r12.appVersionName = SECTION_HEADER_VERSION_NAME;
        return r12;
    }

    public int getAppInfoIndex(AppInfo r10) {
        if (r10 != null) goto L5;
        return -1;
    L5:
        List<AppInfo> r11 = this.mDatas;
        if (r11 != null) goto L8;
    L17:
        return -1;
    L8:
        if (r11.size() == 0) goto L17;
        int r12 = this.mDatas.size();
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L17;
        if (this.mDatas.get(r13).appPackageName.equals(r10.appPackageName) == true) goto L15;
        r13 = r13 + 1;
        goto L11
    L15:
        return r13 + 1;
    }

    public List<AppInfo> getDataList() {
        return this.mDatas;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDatas.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r10) {
        int r11 = this.mDatas.indexOf(this.mHeaderDownloadQueue);
        int r12 = this.mDatas.indexOf(this.mHeaderLocalApp);
        if (r10 == r11) goto L14;
        if (r10 != r12) goto L7;
        return 2;
    L7:
        if (r12 != (-1)) goto L9;
        r12 = this.mDatas.size();
    L9:
        if (r10 < r12) goto L12;
        return 1;
    L12:
        return 0;
    L14:
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        int r12 = getItemViewType(r11);
        if (r12 == 0) goto L10;
        if (r12 != 1) goto L6;
        LocalAppViewHolder r13 = (LocalAppViewHolder) r10;
        r13.setSwipe(false);
        r13.invalidateConvertView(r11);
        return;
    L6:
        if (r12 != 2) goto L14;
        ((SectionHeaderViewHolder) r10).invalidateConvertView(r11);
        return;
    L14:
        return;
    L10:
        DownloadAppQueueViewHolder r14 = (DownloadAppQueueViewHolder) r10;
        r14.setSwipe(true);
        r14.invalidateConvertView(r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @Nullable
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        if (r11 == 0) goto L18;
        if (r11 == 1) goto L16;
        if (r11 == 2) goto L14;
        if (r11 == 3) goto L12;
        return null;
    L12:
        return new HeadViewHolder(this, this.mHeaderView);
    L14:
        return new SectionHeaderViewHolder(this, LayoutInflater.from(this.mContext).inflate(R$layout.myapplist_section_header, r10, false));
    L16:
        return new LocalAppViewHolder(this, LayoutInflater.from(this.mContext).inflate(R$layout.app_swipe_list_item, null));
    L18:
        return new DownloadAppQueueViewHolder(this, LayoutInflater.from(this.mContext).inflate(R$layout.app_swipe_list_item, null));
    }

    public void setDataList(List<AppInfo> r10) {
        this.mDatas.clear();
        appendData(r10);
    }
}
