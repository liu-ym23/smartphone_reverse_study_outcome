package com.bytedanceos.common.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c9.a;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$integer;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.IAppExtra;
import com.bytedanceos.common.model.ImagesInfo;
import com.bytedanceos.common.model.RelatedAppInfo;
import com.bytedanceos.common.model.RelatedAppInfos;
import com.bytedanceos.common.model.TopAdAppInfo;
import com.bytedanceos.common.model.TopAdAppInfos;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.SizeConverter;
import com.bytedanceos.common.toolbox.c;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.glide.b;
import com.bytedanceos.common.toolbox.q;
import com.bytedanceos.common.ui.listener.IRelatedClickListener;
import com.bytedanceos.common.ui.widget.AppStatusView;
import com.bytedanceos.common.ui.widget.FlowLayout;
import com.bytedanceos.common.ui.widget.MyAppSwipeItemView;
import com.bytedanceos.common.ui.widget.PinnedHeaderListView;
import com.bytedanceos.common.ui.widget.SearchChipsView;
import com.bytedanceos.common.ui.widget.oui.OUIAppStatusView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SectionListAdapter extends AppListAdapter implements ListAdapter, PinnedHeaderListView.PinnedHeaderAdapter, AbsListView.OnScrollListener {
    private IRelatedClickListener iRelatedClickListener;
    private TextView mHeaderView;
    private NoneHolder mNoneHolder;
    private final View.OnClickListener mOnBtnClickListener;
    private View.OnClickListener mOnItemClickListener;
    private AbsListView.OnScrollListener mOnScrollListener;

    public class BaseViewHolder implements AppListAdapter.BaseHolder {
        final /* synthetic */ SectionListAdapter this$0;

        public BaseViewHolder(SectionListAdapter r10) {
            this.this$0 = r10;
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public int getConvertViewRid() {
            return 0;
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void initConvertView(View r10) {
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void invalidateConvertView(int r10, View r11) {
            AppInfo r12 = this.this$0.mDataList.get(r10);
            r11.setTag(R$id.appinfo, r12);
            r11.setTag(R$id.app_row_index, Integer.valueOf(r10));
        }
    }

    public class NoneHolder extends BaseViewHolder {
        final /* synthetic */ SectionListAdapter this$0;

        public NoneHolder(SectionListAdapter r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // com.bytedanceos.common.ui.adapter.SectionListAdapter.BaseViewHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public int getConvertViewRid() {
            return 0;
        }

        @Override // com.bytedanceos.common.ui.adapter.SectionListAdapter.BaseViewHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void initConvertView(View r10) {
            r10.setVisibility(8);
        }

        @Override // com.bytedanceos.common.ui.adapter.SectionListAdapter.BaseViewHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void invalidateConvertView(int r10, View r11) {
            r11.setVisibility(8);
        }
    }

    public class NormalWithImagesHolder extends AppListAdapter.NormalHolder {
        private ImageView mAppListSpace;
        private ImageView mImageView1;
        private ImageView mImageView2;
        private ImageView mImageView3;
        int mRadius;
        final /* synthetic */ SectionListAdapter this$0;

        public NormalWithImagesHolder(SectionListAdapter r10) {
            this.this$0 = r10;
            this.mRadius = BaseApplication.c().getResources().getInteger(R$integer.app_list_item_image_corner_radius);
        }

        private void loadImageView(List<String> r10, int r11, ImageView r12) {
            if (r11 >= r10.size()) goto L6;
            b.k(this.this$0.mContext, R$drawable.app_list_item_place_holder, r10.get(r11), r12, this.mRadius);
            return;
        }

        private void setUpImageSize(int r10, int r11, ImageView r12) {
            RelativeLayout.LayoutParams r13 = (RelativeLayout.LayoutParams) r12.getLayoutParams();
            if (r13 == null) goto L6;
            r13.width = r10;
            r13.height = r11;
            r12.setLayoutParams(r13);
            return;
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.NormalHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public int getConvertViewRid() {
            if (this.this$0.mIsBigFont == false) goto L7;
            return R$layout.app_list_item_1x4_with_images;
        L7:
            return R$layout.app_list_item_with_images;
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.NormalHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void initConvertView(View r10) {
            this.appLabelFirst = (TextView) r10.findViewById(R$id.label_0);
            this.appLabelSecond = (TextView) r10.findViewById(R$id.label_1);
            this.appSource = (TextView) r10.findViewById(R$id.appSource);
            ImageView r11 = (ImageView) r10.findViewById(R$id.app_list_space);
            this.mAppListSpace = r11;
            r11.setVisibility(8);
            r10.findViewById(R$id.app_list_item_content).setBackground(null);
            r10.setBackground(this.this$0.mContext.getDrawable(R$drawable.app_list_selector));
            this.mImageView1 = (ImageView) r10.findViewById(R$id.iv_first);
            this.mImageView2 = (ImageView) r10.findViewById(R$id.iv_second);
            this.mImageView3 = (ImageView) r10.findViewById(R$id.iv_third);
            int r12 = ((q.h(this.this$0.mContext) - (this.this$0.mContext.getResources().getDimensionPixelSize(R$dimen.app_list_item_images_horizontal_interval) * 2)) - (this.this$0.mContext.getResources().getDimensionPixelSize(R$dimen.checkbox_margin) * 2)) / 3;
            setUpImageSize(r12, r12, this.mImageView1);
            setUpImageSize(r12, r12, this.mImageView2);
            setUpImageSize(r12, r12, this.mImageView3);
            super.initConvertView(r10);
        }

        @Override // com.bytedanceos.common.ui.adapter.AppListAdapter.NormalHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void invalidateConvertView(int r10, View r11) {
            AppInfo r12 = this.this$0.mDataList.get(r10);
            OUIAppStatusView r13 = this.appStatusContainer;
            if (r13 == null) goto L5;
            r13.setAppSize(SizeConverter.BTrim.convert(r12.appBytes));
            this.appStatusContainer.setTag(R$id.app_do_not_show_suppose_info, Boolean.TRUE);
        L5:
            showOrGoneLabels(r12);
            showOrGoneAppSourceView(r10, r12);
            r11.setTag(R$id.appinfo, r12);
            r11.setTag(R$id.app_row_index, Integer.valueOf(r10));
            IAppExtra r14 = r12.getAppExtraInfo();
            if (r14 != null) goto L8;
        L10:
            AppListAdapter.updateCommonItemDataByInner(r10, r11, this, r12, this.mSwipeItemType);
            AdsReportManager.h().k(r12);
            return;
        L8:
            if ((r14 instanceof ImagesInfo) == false) goto L10;
            List<String> r15 = ((ImagesInfo) r14).getImageUrlList();
            loadImageView(r15, 0, this.mImageView1);
            loadImageView(r15, 1, this.mImageView2);
            loadImageView(r15, 2, this.mImageView3);
            goto L10
        }
    }

    public class RelatedAppHolder extends BaseViewHolder {
        private FlowLayout flowLayout;
        private List<RelatedAppInfo> relatedAppList;
        final /* synthetic */ SectionListAdapter this$0;

        public RelatedAppHolder(SectionListAdapter r10) {
            this.this$0 = r10;
            super(r10);
        }

        private void updateRelatedApps(List<RelatedAppInfo> r10) {
            if (c.a(r10) == false) goto L5;
            return;
        L5:
            this.flowLayout.removeAllViews();
            ViewGroup.MarginLayoutParams r11 = new ViewGroup.MarginLayoutParams(-2, -2);
            int r12 = 0;
        L7:
            if (r12 >= r10.size()) goto L19;
            final RelatedAppInfo r13 = r10.get(r12);
            SearchChipsView r14 = new SearchChipsView(this.flowLayout.getContext());
            if (TextUtils.isEmpty(r13.getName()) == true) goto L18;
            r14.setText(r13.getName());
            if (r12 != 0) goto L14;
            r14.setType(SearchChipsView.WHITE_SEARCH_ICON);
        L17:
            final int r15 = r12 + 1;
            r14.setOnClickListener(new AnonymousClass1(this, r13, r15));
            this.flowLayout.addView(r14, r11);
            goto L18
        L14:
            if (r13.getType() == 2) goto L16;
            r14.setType(SearchChipsView.BLUE);
            goto L17
        L16:
            r14.setType(8);
        L18:
            r12 = r12 + 1;
            goto L7
        }

        @Override // com.bytedanceos.common.ui.adapter.SectionListAdapter.BaseViewHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public int getConvertViewRid() {
            return R$layout.related_app_item;
        }

        @Override // com.bytedanceos.common.ui.adapter.SectionListAdapter.BaseViewHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void initConvertView(View r10) {
            super.initConvertView(r10);
            this.flowLayout = (FlowLayout) r10.findViewById(R$id.flow_pop_layout);
            if (this.relatedAppList != null) goto L6;
            this.relatedAppList = new ArrayList();
            return;
        }

        @Override // com.bytedanceos.common.ui.adapter.SectionListAdapter.BaseViewHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void invalidateConvertView(int r10, View r11) {
            super.invalidateConvertView(r10, r11);
            IAppExtra r12 = this.this$0.mDataList.get(r10).getAppExtraInfo();
            if (r12 != null) goto L5;
            return;
        L5:
            if (r12.getItemType() == 4) goto L7;
            return;
        L7:
            if ((r12 instanceof RelatedAppInfos) == false) goto L21;
            this.relatedAppList.clear();
            RelatedAppInfos r13 = (RelatedAppInfos) r12;
            if (r13.isAvailable() == false) goto L17;
            r11.setVisibility(0);
            List<RelatedAppInfo> r14 = r13.getTotalAppsList();
            String r15 = r13.getCategory();
            if (r14.size() < 3) goto L14;
            this.relatedAppList.addAll(r14.subList(0, 3));
        L14:
            if (TextUtils.isEmpty(r15) == true) goto L16;
            RelatedAppInfo r16 = new RelatedAppInfo(r15);
            r16.setName(r15);
            this.relatedAppList.add(r16);
        L16:
            updateRelatedApps(this.relatedAppList);
            return;
        L17:
            r11.setVisibility(8);
            return;
        }
    }

    public class SplitHolder extends BaseViewHolder {
        TextView splitText;
        final /* synthetic */ SectionListAdapter this$0;

        public SplitHolder(SectionListAdapter r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // com.bytedanceos.common.ui.adapter.SectionListAdapter.BaseViewHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public int getConvertViewRid() {
            return R$layout.app_list_split_item;
        }

        @Override // com.bytedanceos.common.ui.adapter.SectionListAdapter.BaseViewHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void initConvertView(View r10) {
            super.initConvertView(r10);
            this.splitText = (TextView) r10.findViewById(R$id.ext_split_item);
        }

        @Override // com.bytedanceos.common.ui.adapter.SectionListAdapter.BaseViewHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void invalidateConvertView(int r10, View r11) {
            super.invalidateConvertView(r10, r11);
            this.splitText.setText(r11.getContext().getText(R$string.split_item_desc));
        }
    }

    public class TopAdAppHolder extends BaseViewHolder {
        TextView adCategory;
        TextView appCategory;
        NetworkImageView appIcon;
        TextView appName;
        AppStatusView appStatusContainer;
        int mRadius;
        final /* synthetic */ SectionListAdapter this$0;

        public TopAdAppHolder(SectionListAdapter r10) {
            this.this$0 = r10;
            super(r10);
            this.mRadius = BaseApplication.c().getResources().getInteger(R$integer.app_list_item_top_ad_icon_corner_radius);
        }

        private int getLabelWidth(Context r10) {
            int r11 = r10.getResources().getDimensionPixelSize(R$dimen.max_category_width);
            int r12 = r10.getResources().getDimensionPixelSize(R$dimen.label_interval);
            TextView r13 = this.adCategory;
            if (r13 != null) goto L5;
            return r11;
        L5:
            if (r13.getVisibility() != 0) goto L11;
            String r14 = this.adCategory.getText().toString();
            if (TextUtils.isEmpty(r14) == false) goto L9;
            return r11;
        L9:
            return (int) ((((double) r11) - (((double) this.adCategory.getPaint().measureText(r14)) + 0.5d)) - ((double) r12));
        L11:
            return r11;
        }

        @Override // com.bytedanceos.common.ui.adapter.SectionListAdapter.BaseViewHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public int getConvertViewRid() {
            return R$layout.top_ad_app_item;
        }

        @Override // com.bytedanceos.common.ui.adapter.SectionListAdapter.BaseViewHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void initConvertView(View r10) {
            super.initConvertView(r10);
            this.appIcon = (NetworkImageView) r10.findViewById(R$id.appIcon);
            this.appName = (TextView) r10.findViewById(R$id.appName);
            this.appCategory = (TextView) r10.findViewById(R$id.appCategory);
            this.adCategory = (TextView) r10.findViewById(R$id.adCategory);
            AppStatusView r11 = (AppStatusView) r10.findViewById(R$id.appStatusLay);
            this.appStatusContainer = r11;
            r11.showAppSize();
            if (SectionListAdapter.access$000(this.this$0) == null) goto L6;
            this.appStatusContainer.setOnClickListener(SectionListAdapter.access$000(this.this$0));
        L6:
            if (SectionListAdapter.access$100(this.this$0) == null) goto L9;
            r10.setOnClickListener(SectionListAdapter.access$100(this.this$0));
            return;
        }

        @Override // com.bytedanceos.common.ui.adapter.SectionListAdapter.BaseViewHolder, com.bytedanceos.common.ui.adapter.AppListAdapter.BaseHolder
        public void invalidateConvertView(int r10, View r11) {
            super.invalidateConvertView(r10, r11);
            IAppExtra r12 = this.this$0.mDataList.get(r10).getAppExtraInfo();
            if (r12 != null) goto L5;
            return;
        L5:
            if (r12.getItemType() == 3) goto L7;
            return;
        L7:
            if ((r12 instanceof TopAdAppInfos) == false) goto L19;
            List<TopAdAppInfo> r13 = ((TopAdAppInfos) r12).getTopAdAppInfos();
            if (c.a(r13) == false) goto L11;
            r11.setVisibility(8);
            return;
        L11:
            r11.setVisibility(0);
            TopAdAppInfo r14 = r13.get(0);
            this.appIcon.setTag(r14);
            NetworkImageView r15 = this.appIcon;
            int r16 = R$drawable.oui_default_app_icon;
            r15.setErrorImageResId(r16);
            this.appIcon.setDefaultImageResId(r16);
            this.appIcon.f(r14.getLogo(), this.mRadius, true);
            this.appName.setText(r14.getName());
            this.appCategory.setMaxWidth(getLabelWidth(r11.getContext()));
            if (TextUtils.isEmpty(r14.getCategory()) == false) goto L14;
            this.appCategory.setVisibility(8);
        L15:
            e.A1(this.adCategory, 1);
            this.appStatusContainer.setAppSize(SizeConverter.BTrim.convert(r14.getFilesize()));
            AppInfo r17 = a.a(r14, "&position=1");
            this.appStatusContainer.updateDownloadStatus(r17);
            this.appStatusContainer.setTag(r17);
            this.appStatusContainer.setTag(R$id.page_button_pos, Integer.valueOf(r10));
            AppStatusView r18 = this.appStatusContainer;
            int r19 = R$id.appinfo;
            r18.setTag(r19, r17);
            this.appStatusContainer.setTag(R$id.app_row_index, Integer.valueOf(r10));
            r11.setTag(r19, r17);
            AdsReportManager.h().k(r17);
            return;
        L14:
            this.appCategory.setText(r14.getCategory());
            this.appCategory.setVisibility(0);
            goto L15
        }
    }

    public SectionListAdapter(Context r10, ListView r11, View.OnClickListener r12, View.OnClickListener r13, MyAppSwipeItemView.OnSwipeItemActionListener r14) {
        super(r10, r11, r12, r13, r14);
        this.mOnBtnClickListener = r12;
        this.mOnItemClickListener = r13;
    }

    public static /* synthetic */ View.OnClickListener access$000(SectionListAdapter r10) {
        return r10.mOnBtnClickListener;
    }

    public static /* synthetic */ View.OnClickListener access$100(SectionListAdapter r10) {
        return r10.mOnItemClickListener;
    }

    public static /* synthetic */ IRelatedClickListener access$200(SectionListAdapter r10) {
        return r10.iRelatedClickListener;
    }

    @Override // com.bytedanceos.common.ui.adapter.AppListAdapter
    public synchronized void addDataList(List<AppInfo> r10) {
        monitor-enter(this);
        super.addDataList(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedanceos.common.ui.widget.PinnedHeaderListView.PinnedHeaderAdapter
    public void configurePinnedHeader(View r10, int r11, int r12) {
        if (r12 == 0) goto L5;
        TextView r13 = (TextView) r10.findViewById(R$id.ext_split_item);
        this.mHeaderView = r13;
        r13.setText(r10.getContext().getString(R$string.split_item_desc));
        return;
    }

    @Override // com.bytedanceos.common.ui.adapter.AppListAdapter
    public View getConvertView(int r10, AppListAdapter.BaseHolder r11) {
        return this.mInflater.inflate(r11.getConvertViewRid(), null);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r10) {
        IAppExtra r11 = this.mDataList.get(r10).getAppExtraInfo();
        if (r11 != null) goto L7;
        return 1;
    L7:
        return r11.getItemType();
    }

    public AbsListView.OnScrollListener getOnScrollListener() {
        return this.mOnScrollListener;
    }

    @Override // com.bytedanceos.common.ui.widget.PinnedHeaderListView.PinnedHeaderAdapter
    public synchronized int getPinnedHeaderState(AbsListView r10, int r11) {
        monitor-enter(this);
        List<AppInfo> r12 = this.mDataList;     // Catch: Throwable -> L25
        if (r12 != null) goto L6;
    L53:
        monitor-exit(this);
        return 0;
    L6:
        if (r12.isEmpty() == true) goto L53;
        int r13 = r10.getFirstVisiblePosition();     // Catch: Throwable -> L25
        if (r13 >= 0) goto L11;
    L51:
        monitor-exit(this);
        return 1;
    L11:
        if (r13 >= this.mDataList.size()) goto L51;
        int r14 = r10.getFirstVisiblePosition();     // Catch: Throwable -> L25
        String r15 = this.mDataList.get(r13).appSource;     // Catch: Throwable -> L25
        String r16 = this.mDataList.get(r14).appSource;     // Catch: Throwable -> L25
        List<AppInfo> r17 = this.mDataList;     // Catch: Throwable -> L25
        if (r14 <= 0) goto L16;
        int r18 = r14 - 1;     // Catch: Throwable -> L25
    L17:
        String r19 = r17.get(r18).appSource;     // Catch: Throwable -> L25
        if (r14 >= r13) goto L40;
        if (TextUtils.equals(AppInfo.SEARCH_SOURCE_SPLIT, r16) == false) goto L28;
        if (TextUtils.equals(AppInfo.SEARCH_SOURCE_EXTENAL, r15) == false) goto L28;
        monitor-exit(this);
        return 0;
    L28:
        if (TextUtils.equals(AppInfo.SEARCH_SOURCE_EXTENAL, r16) == false) goto L32;
        if (TextUtils.equals(AppInfo.SEARCH_SOURCE_SPLIT, r19) == false) goto L32;
    L35:
        monitor-exit(this);
        return 1;
    L32:
        if (TextUtils.equals(AppInfo.SEARCH_SOURCE_EXTENAL, r16) == true) goto L34;
    L37:
        monitor-exit(this);
        return 0;
    L34:
        if (TextUtils.equals(AppInfo.SEARCH_SOURCE_EXTENAL, r15) == false) goto L37;
    L40:
        if (TextUtils.equals(AppInfo.SEARCH_SOURCE_EXTENAL, r16) == false) goto L49;
        int r20 = r14 + 1;     // Catch: Throwable -> L25
        if (this.mDataList.size() > r20) goto L44;
    L47:
        monitor-exit(this);
        return 1;
    L44:
        if (TextUtils.equals(this.mDataList.get(r20).appSource, "local") == false) goto L47;
        monitor-exit(this);
        return 0;
    L49:
        monitor-exit(this);
        return 0;
    L16:
        r18 = 0;
    L25:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v17, types: [com.bytedanceos.common.ui.adapter.AppListAdapter$BaseHolder] */
    /* JADX WARN: Type inference failed for: r11v18, types: [com.bytedanceos.common.ui.adapter.AppListAdapter$BaseHolder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.bytedanceos.common.ui.adapter.AppListAdapter, com.bytedanceos.common.ui.adapter.SectionListAdapter] */
    @Override // com.bytedanceos.common.ui.adapter.AppListAdapter, android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        if (r11 != null) goto L9;
        ?? r13 = getViewHolder(r10);
        ?? r14 = r11;
        ?? r15 = r13;
        if (r13 == 0) goto L31;
        ?? r16 = getConvertView(r10, r13);
        if ((r13 instanceof AppListAdapter.NormalHolder) == false) goto L8;
        ((AppListAdapter.NormalHolder) r13).initData(this.mShowItemType, this.mSwipeItemType, this.mOnBtnClickListener, this.mOnItemClickListener, this.mOnLongClickListener, this.mSupposeListener);
    L8:
        r13.initConvertView(r16);
        r16.setTag(r13);
        r14 = r16;
        r15 = r13;
    L31:
        if (r15 != 0) goto L33;
    L36:
        return r14;
    L33:
        if ((r15 instanceof AppListAdapter.NormalHolder) == false) goto L35;
        ((AppListAdapter.NormalHolder) r15).bindData(this.mHeaderViewCount, this.mDataList, this.mAppNoMap, this.mIsEditMode, this.mSelectedApps, this.mOffset);
    L35:
        r15.invalidateConvertView(r10, r14);
        goto L36
    L9:
        int r17 = getItemViewType(r10);
        if (r17 != 1) goto L12;
        AppListAdapter.NormalHolder r18 = (AppListAdapter.NormalHolder) r11.getTag();
        r14 = r11;
        r15 = r18;
        goto L31
    L12:
        if (r17 != 2) goto L14;
        SplitHolder r19 = (SplitHolder) r11.getTag();
        r14 = r11;
        r15 = r19;
        goto L31
    L14:
        if (r17 != 3) goto L16;
        TopAdAppHolder r110 = (TopAdAppHolder) r11.getTag();
        r14 = r11;
        r15 = r110;
        goto L31
    L16:
        if (r17 != 4) goto L18;
        RelatedAppHolder r111 = (RelatedAppHolder) r11.getTag();
        r14 = r11;
        r15 = r111;
        goto L31
    L18:
        if (r17 != 6) goto L20;
        AppListAdapter.ReservationHolder r112 = (AppListAdapter.ReservationHolder) r11.getTag();
        r14 = r11;
        r15 = r112;
        goto L31
    L20:
        if (r17 != 7) goto L22;
        NormalWithImagesHolder r113 = (NormalWithImagesHolder) r11.getTag();
        r14 = r11;
        r15 = r113;
        goto L31
    L22:
        if (this.mNoneHolder != null) goto L24;
        this.mNoneHolder = new NoneHolder(this);
    L24:
        r14 = r11;
        r15 = this.mNoneHolder;
        goto L31
    }

    @Override // com.bytedanceos.common.ui.adapter.AppListAdapter
    public AppListAdapter.BaseHolder getViewHolder(int r10) {
        int r11 = getItemViewType(r10);
        if (r11 == 1) goto L25;
        if (r11 != 2) goto L7;
        AppListAdapter.BaseHolder r12 = new SplitHolder(this);
    L27:
        return r12;
    L7:
        if (r11 != 3) goto L9;
        r12 = new TopAdAppHolder(this);
        goto L27
    L9:
        if (r11 != 4) goto L11;
        r12 = new RelatedAppHolder(this);
        goto L27
    L11:
        if (r11 != 6) goto L13;
        r12 = new AppListAdapter.ReservationHolder(this);
        goto L27
    L13:
        if (r11 != 7) goto L15;
        r12 = new NormalWithImagesHolder(this);
        goto L27
    L15:
        if (this.mNoneHolder != null) goto L26;
        this.mNoneHolder = new NoneHolder(this);
    L26:
        return this.mNoneHolder;
    L25:
        return new AppListAdapter.NormalHolder();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 8;
    }

    public IRelatedClickListener getiRelatedClickListener() {
        return this.iRelatedClickListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r10, int r11, int r12, int r13) {
        if ((r10 instanceof PinnedHeaderListView) == false) goto L11;
        TextView r14 = this.mHeaderView;
        if (r14 == null) goto L7;
        int r15 = r14.getHeight();
        int r16 = r10.pointToPosition(this.mHeaderView.getWidth() / 2, r15 / 2);
    L9:
        if (r16 == (-1)) goto L11;
        ((PinnedHeaderListView) r10).configureHeaderView(r16);
        goto L11
    L7:
        r16 = r11;
    L11:
        AbsListView.OnScrollListener r17 = this.mOnScrollListener;
        if (r17 == null) goto L15;
        r17.onScroll(r10, r11, r12, r13);
        return;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r10, int r11) {
        AbsListView.OnScrollListener r12 = this.mOnScrollListener;
        if (r12 == null) goto L6;
        r12.onScrollStateChanged(r10, r11);
        return;
    }

    @Override // com.bytedanceos.common.ui.adapter.AppListAdapter
    public synchronized void setDataList(List<AppInfo> r10) {
        monitor-enter(this);
        super.setDataList(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setOnScrollListener(AbsListView.OnScrollListener r10) {
        this.mOnScrollListener = r10;
    }

    public void setiRelatedClickListener(IRelatedClickListener r10) {
        this.iRelatedClickListener = r10;
    }

    public SectionListAdapter(Context r10, ListView r11, View.OnClickListener r12, View.OnClickListener r13, MyAppSwipeItemView.OnSwipeItemActionListener r14, View.OnLongClickListener r15) {
        super(r10, r11, r12, r13, r14, r15);
        this.mOnBtnClickListener = r12;
        this.mOnItemClickListener = r13;
    }
}
