package com.bytedanceos.common.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.Category;
import com.bytedanceos.common.model.PageDataBean;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.model.VideoInfo;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.utils.JzvdUtil;
import com.bytedanceos.common.ui.widget.AppGroupItemView;
import com.bytedanceos.common.ui.widget.AppGroupView;
import com.bytedanceos.common.ui.widget.AppItemViewImp;
import com.bytedanceos.common.ui.widget.BannerScrollView;
import com.bytedanceos.common.ui.widget.BannerViewPager;
import com.bytedanceos.common.ui.widget.BaseBannerView;
import com.bytedanceos.common.ui.widget.BaseLoadView;
import com.bytedanceos.common.ui.widget.FooterView;
import com.bytedanceos.common.ui.widget.ScrollGridView;
import com.bytedanceos.common.ui.widget.oui.OUIAppStatusView;
import com.bytedanceos.common.utils.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public class TopicListAdapter extends QuickAdapter<TopicItem> {
    private Context mContext;
    private JzvdStd mCurVideo;
    private FooterView mFooterView;
    private View mHeaderBouncyView;
    private BaseLoadView mLoadView;
    private HashMap<Object, List<AppInfo>> mMustsDataMap;
    private View.OnClickListener mOnBtnClickListener;
    private View.OnClickListener mOnItemClickListener;
    private Jzvd.ListenerAdapter mTopVideoListener;
    private Topic mTopic;
    protected HashMap<Integer, View> mUpdateViews;

    public static class TopicItem {
        public Object mData;
        public boolean mHiddenDivideLine;
        public int mType;

        public TopicItem(int r10, Object r11) {
            this.mType = r10;
            this.mData = r11;
        }

        public TopicItem(int r10) {
            this(r10, null);
        }
    }

    public TopicListAdapter(List<TopicItem> r10) {
        super(r10);
        this.mUpdateViews = new HashMap();
        this.mMustsDataMap = new HashMap();
        this.mTopVideoListener = new AnonymousClass1(this);
    }

    public static /* synthetic */ Topic access$000(TopicListAdapter r10) {
        return r10.mTopic;
    }

    public static /* synthetic */ View.OnClickListener access$100(TopicListAdapter r10) {
        return r10.mOnItemClickListener;
    }

    public static /* synthetic */ Context access$200(TopicListAdapter r10) {
        return r10.mContext;
    }

    private void convertAppGroupView(QuickAdapter.VH r10, TopicItem r11, int r12, int r13) {
        PageDataBean r14 = (PageDataBean) r11.mData;
        AppGroupView r15 = (AppGroupView) r10.getView(r13);
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15.getLayoutParams();
        r16.setMargins(r16.leftMargin, f.i(12), r16.rightMargin, r16.bottomMargin);
        r15.setLayoutParams(r16);
        r15.setType(2);
        r15.setGroupTitle(r14.name);
        if (TextUtils.isEmpty(r14.cid) == false) goto L12;
        if (TextUtils.isEmpty(r14.groupId) == false) goto L12;
        Category r17 = r14.category;
        if (r17 != null) goto L9;
    L17:
        View.OnClickListener r18 = this.mOnBtnClickListener;
        if (r18 == null) goto L22;
        View.OnClickListener r19 = this.mOnItemClickListener;
        if (r19 == null) goto L22;
        r15.setOnClickListener(r18, r19);
    L22:
        List<AppInfo> r20 = r14.apps;
        if (r20 == null) goto L25;
        r15.setDataList(r20);
    L25:
        r15.refreshWholeGroupView();
        HashMap<Integer, View> r21 = this.mUpdateViews;
        monitor-enter(r21);
        this.mUpdateViews.put(Integer.valueOf(r12), r15);     // Catch: Throwable -> L30
        monitor-exit(r21);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L9:
        if (TextUtils.isEmpty(r17.getId()) == true) goto L17;
        r15.setGroupId(r14.category.getId(), 10);
    L12:
        if (TextUtils.isEmpty(r14.cid) == true) goto L15;
        r15.setGroupId(r14.cid, 10);
        goto L17
    L15:
        if (TextUtils.isEmpty(r14.groupId) == true) goto L17;
        r15.setGroupId(r14.groupId, 11);
        goto L17
    }

    private void convertFooterBouncyView(QuickAdapter.VH r10) {
        this.mFooterView = (FooterView) r10.getView(R$id.footer_view);
    }

    private void convertHeaderBouncyView(QuickAdapter.VH r10) {
        this.mHeaderBouncyView = r10.getView(R$id.bouncy_view);
    }

    private void convertImageBanner(QuickAdapter.VH r10, TopicItem r11) {
        String r12 = String.valueOf(r11.mData);
        BaseBannerView r13 = (BaseBannerView) r10.getView(R$id.topic_banner_layout);
        Topic r14 = new Topic();
        r14.setImageResUrl(r12);
        r13.bindData(r14);
    }

    private void convertImageBannerWithIntroduce(QuickAdapter.VH r10, TopicItem r11) {
        String r12 = String.valueOf(r11.mData);
        ((TextView) r10.getView(R$id.topic_introduce_textview)).setText(r12);
    }

    private void convertLoadView(QuickAdapter.VH r10, TopicItem r11) {
        this.mLoadView = (BaseLoadView) r10.getView(R$id.load_view);
        int r12 = ((Integer) r11.mData).intValue();
        this.mLoadView.setLoadType(r12);
    }

    private void convertLoopBanner(QuickAdapter.VH r10, TopicItem r11) {
        if (r11 == null) goto L7;
        Object r12 = r11.mData;
        if (r12 == null) goto L8;
        BannerViewPager r13 = (BannerViewPager) r10.getView(R$id.topic_loop_banner);
        r13.setBannerUrls((List) r12);
        return;
    L8:
        return;
    }

    private void convertMusts(QuickAdapter.VH r15, TopicItem r16, int r17, boolean r18) {
        if (r18 == false) goto L4;
        convertMusts(r15, r16, r17, R$id.gv_pages_must_apps, R$id.btn_install_all_apps, true);
        return;
    L4:
        convertMusts(r15, r16, r17, R$id.gv_pages_must_games, R$id.btn_install_all_games, false);
    }

    private void convertPager(QuickAdapter.VH r10, TopicItem r11, int r12) {
        Object r13 = r11.mData;
        if ((r13 instanceof List) == false) goto L13;
        List<AppInfo> r14 = (List) r13;
        if (r14.isEmpty() == true) goto L14;
        AppGroupView r15 = (AppGroupView) r10.getView(R$id.topic_app_group);
        r15.setType(1);
        View.OnClickListener r16 = this.mOnBtnClickListener;
        if (r16 == null) goto L11;
        View.OnClickListener r17 = this.mOnItemClickListener;
        if (r17 == null) goto L11;
        r15.setOnClickListener(r16, r17);
    L11:
        r15.setDataList(r14);
        r15.refreshWholeGroupView();
        this.mUpdateViews.put(Integer.valueOf(r12), r15);
        return;
    L14:
        return;
    }

    private void convertRecommendVideo(QuickAdapter.VH r10, TopicItem r11, int r12) {
        if (r11 == null) goto L7;
        Object r13 = r11.mData;
        if ((r13 instanceof AppInfo) == false) goto L8;
        AppInfo r14 = (AppInfo) r13;
        JzvdStd r15 = (JzvdStd) r10.getView(R$id.topic_recommend_video);
        r15.setVideoRatio(0, 0);
        r15.setBannerUrl(r14.mAppVideoImage);
        r15.setVideoUrl(r14.mAppVideoUrl);
        r15.setTag(Integer.valueOf(r12));
        r15.setListener(this.mTopVideoListener);
        AppItemViewImp r16 = (AppItemViewImp) r10.getView(R$id.topic_recommend_app_item);
        r16.showLine(false);
        r16.setOnClickListener(this.mOnBtnClickListener, this.mOnItemClickListener);
        r16.bindData(r14);
        onAppInfoReport(r14);
        this.mUpdateViews.put(Integer.valueOf(r12), r16);
        return;
    L8:
        return;
    }

    private void convertSlideMultiBanner(QuickAdapter.VH r10, TopicItem r11) {
        if (r11 == null) goto L10;
        Object r12 = r11.mData;
        if (r12 == null) goto L11;
        List<Topic> r13 = (List) r12;
        BannerScrollView r14 = (BannerScrollView) r10.getView(R$id.topic_slide_multi_banner);
        View.OnClickListener r15 = this.mOnBtnClickListener;
        if (r15 == null) goto L8;
        r14.setOnClickListener(r15);
    L8:
        r14.setData(r13);
        return;
    L11:
        return;
    }

    private void convertSlimnessBanner(QuickAdapter.VH r10, TopicItem r11) {
        if (r11 == null) goto L9;
        Object r12 = r11.mData;
        if ((r12 instanceof Topic) == false) goto L10;
        Topic r13 = (Topic) r12;
        loadTopicBanner((NetworkImageView) r10.getView(R$id.topic_banner), r13.getImageResUrl());
        if (this.mOnBtnClickListener == null) goto L11;
        r10.mConvertView.setTag(r13);
        r10.mConvertView.setOnClickListener(this.mOnBtnClickListener);
        return;
    L11:
        return;
    L10:
        return;
    }

    private void convertSpaceView(QuickAdapter.VH r10, TopicItem r11) {
        ViewGroup.LayoutParams r12 = r10.mConvertView.getLayoutParams();
        r12.height = ((Integer) r11.mData).intValue();
    }

    private void convertVideoBanner(QuickAdapter.VH r10, TopicItem r11) {
        Object r12 = r11.mData;
        if ((r12 instanceof VideoInfo) == false) goto L5;
        BaseBannerView r13 = (BaseBannerView) r10.getView(R$id.topic_banner_layout);
        Topic r14 = new Topic();
        r14.setImageResUrl(((VideoInfo) r12).mImgUrl);
        r13.bindData(r14);
    L5:
        View.OnClickListener r15 = this.mOnBtnClickListener;
        if (r15 == null) goto L9;
        r10.mConvertView.setOnClickListener(r15);
        return;
    }

    private void initMusts(QuickAdapter.VH r10, boolean r11) {
        if (r11 == false) goto L4;
        int r12 = R$id.gv_pages_must_apps;
    L5:
        ScrollGridView r13 = (ScrollGridView) r10.getView(r12);
        r13.setNumColumns(4);
        r13.setAdapter(MustAppInfoAdapter.newInstance());
        r13.setOnItemClickListener(new AnonymousClass2(this));
        if (r11 == false) goto L8;
        int r14 = R$id.btn_install_all_apps;
    L9:
        r10.getView(r14).setOnClickListener(new AnonymousClass3(this));
        return;
    L8:
        r14 = R$id.btn_install_all_games;
        goto L9
    L4:
        r12 = R$id.gv_pages_must_games;
        goto L5
    }

    private boolean isAppInstallable(AppInfo r10) {
        int r11 = BaseApplication.c().b().B(r10.appPackageName);
        if (r11 != 1) goto L5;
        return false;
    L5:
        if (r11 != 2) goto L7;
        return false;
    L7:
        if (r11 != 8) goto L9;
        return false;
    L9:
        if (r11 == 32) goto L20;
        if (r11 == 64) goto L20;
        if (r11 == 128) goto L18;
        if (r11 == 512) goto L25;
        return true;
    L25:
        return false;
    L18:
        return !r.b(r10.appPackageName);
    L20:
        return r.c(r10.appPackageName);
    }

    private void onAppInfoReport(AppInfo r10) {
        if (r10 == null) goto L9;
        AdsReportManager.h().k(r10);
        Topic r11 = this.mTopic;
        if (r11 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r11.getTabSource()) == true) goto L11;
        r10.tabSource = this.mTopic.getTabSource();
        return;
    L11:
        return;
    }

    private void submitGridView(View r10) {
        if ((r10 instanceof GridView) == false) goto L8;
        Iterator<AppInfo> r11 = this.mMustsDataMap.get(r10.getTag()).iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        onAppInfoReport(r11.next());
        goto L6
    L10:
        return;
    }

    private void updateInstallAllBtn(List<AppInfo> r10, View r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L20;
        Iterator<AppInfo> r12 = r10.iterator();
        boolean r13 = false;
    L8:
        if (r12.hasNext() == false) goto L11;
        r13 = isAppInstallable(r12.next());
        if (r13 == false) goto L8;
    L11:
        if (r13 == false) goto L13;
        r11.setEnabled(true);
        r11.setAlpha(1.0f);
        return;
    L13:
        r11.setEnabled(false);
        r11.setAlpha(0.3f);
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void appendData(TopicItem r10) {
        this.mDatas.add((T) r10);
        notifyDataSetChanged();
    }

    @Override // com.bytedanceos.common.ui.adapter.QuickAdapter
    public /* bridge */ /* synthetic */ void convert(QuickAdapter.VH r10, TopicItem r11, int r12) {
        convert(r10, r11, r12);
    }

    public void convertListViewItem(QuickAdapter.VH r10, TopicItem r11, int r12) {
        Object r13 = r11.mData;
        if ((r13 instanceof AppInfo) == true) goto L5;
        return;
    L5:
        AppInfo r14 = (AppInfo) r13;
        AppItemViewImp r15 = (AppItemViewImp) r10.getView(R$id.topic_app_item_view);
        r15.setOnClickListener(this.mOnBtnClickListener, this.mOnItemClickListener);
        r15.showLine(!r11.mHiddenDivideLine);
        r15.bindData(r14);
        onAppInfoReport(r14);
        HashMap<Integer, View> r16 = this.mUpdateViews;
        monitor-enter(r16);
        this.mUpdateViews.put(Integer.valueOf(r12), r15.getAppStatusView());     // Catch: Throwable -> L10
        monitor-exit(r16);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public FooterView getFooterView() {
        return this.mFooterView;
    }

    public View getHeaderBouncyView() {
        return this.mHeaderBouncyView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r10) {
        if (r10 < getItemCount()) goto L5;
        return 0;
    L5:
        return ((TopicItem) this.mDatas.get(r10)).mType;
    }

    @Override // com.bytedanceos.common.ui.adapter.QuickAdapter
    public int getLayoutId(int r10) {
        if (r10 == 1) goto L55;
        if (r10 == 2) goto L53;
        if (r10 == 3) goto L51;
        if (r10 == 6) goto L49;
        if (r10 == 7) goto L47;
        if (r10 == 117) goto L45;
        switch(r10) {
            case 10: goto L47;
            case 11: goto L43;
            case 12: goto L41;
            case 13: goto L47;
            case 14: goto L39;
            case 15: goto L37;
            default: goto L15;
        };
    L15:
        switch(r10) {
            case 101: goto L35;
            case 102: goto L33;
            case 103: goto L31;
            case 104: goto L29;
            case 105: goto L27;
            case 106: goto L25;
            case 107: goto L23;
            case 108: goto L21;
            case 109: goto L19;
            default: goto L17;
        };
    L17:
        return R$layout.item_empty;
    L19:
        return R$layout.bouncy_view;
    L21:
        return R$layout.bouncy_view;
    L23:
        return R$layout.topic_view_pager_two_line;
    L25:
        return R$layout.topic_view_pager_one_line;
    L27:
        return R$layout.topic_banner;
    L29:
        return R$layout.load_view;
    L31:
        return R$layout.footer_view;
    L33:
        return R$layout.div_line_thin;
    L35:
        return R$layout.item_empty;
    L37:
        return R$layout.topic_video_banner;
    L39:
        return R$layout.topic_recommend_video;
    L41:
        return R$layout.pages_must_games_layout;
    L43:
        return R$layout.pages_must_apps_layout;
    L45:
        return R$layout.topic_banner_introduce;
    L47:
        return R$layout.topic_view_pager;
    L49:
        return R$layout.topic_app_item_view;
    L51:
        return R$layout.topic_slide_multi_banner;
    L53:
        return R$layout.topic_loop_banner;
    L55:
        return R$layout.topic_slimness_banner;
    }

    public BaseLoadView getLoadMoreView() {
        return this.mLoadView;
    }

    @Override // com.bytedanceos.common.ui.adapter.QuickAdapter
    public void initView(int r10, QuickAdapter.VH r11) {
        if (r10 != 11) goto L5;
        initMusts(r11, true);
        return;
    L5:
        if (r10 != 12) goto L11;
        initMusts(r11, false);
        return;
    }

    public void loadTopicBanner(NetworkImageView r10, String r11) {
        r10.setDefaultImageResId(R$drawable.topic_banner_default_bg);
        r10.setImageUrl(r11);
    }

    public void onDestroy() {
        JzvdUtil.onDestroy(this.mCurVideo);
    }

    public void onPause() {
        JzvdUtil.onPause(this.mCurVideo);
    }

    public void onResume() {
        JzvdUtil.onResume(this.mCurVideo);
    }

    public void onScrolled(VirtualLayoutManager r10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r10) {
        onViewAttachedToWindow((QuickAdapter.VH) r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder r10) {
        onViewDetachedFromWindow((QuickAdapter.VH) r10);
    }

    public void removeData(TopicItem r10) {
        this.mDatas.remove(r10);
        notifyDataSetChanged();
    }

    public void removeDataAtLocation(int r10) {
        this.mDatas.remove(r10);
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener r10) {
        this.mOnItemClickListener = r10;
    }

    public void updateDownloadStatus() {
        Iterator<View> r10 = this.mUpdateViews.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L24;
        View r11 = r10.next();
        if ((r11 instanceof AppGroupView) == true) goto L7;
        if ((r11 instanceof OUIAppStatusView) == true) goto L11;
        if ((r11 instanceof GridView) == true) goto L15;
        if ((r11 instanceof AppGroupItemView) == true) goto L20;
        if ((r11 instanceof AppItemViewImp) == false) goto L4;
        ((AppItemViewImp) r11).updateAppStatus((AppInfo) r11.getTag(R$id.appinfo));
        goto L4
    L20:
        ((AppGroupItemView) r11).updateAppStatus((AppInfo) r11.getTag(R$id.appinfo));
        goto L4
    L15:
        ((BaseAdapter) ((GridView) r11).getAdapter()).notifyDataSetChanged();
        Object r12 = r11.getTag();
        if ((r12 instanceof View) == false) goto L4;
        updateInstallAllBtn(this.mMustsDataMap.get(r12), (View) r12);
        goto L4
    L11:
        if ((r11.getTag() instanceof AppInfo) == false) goto L4;
        ((OUIAppStatusView) r11).updateDownloadStatus((AppInfo) r11.getTag());
        goto L4
    L7:
        ((AppGroupView) r11).refreshWholeGroupView();
        goto L4
    }

    /* JADX WARN: Can't rename method to resolve collision */
    public void convert(QuickAdapter.VH r10, TopicItem r11, int r12) {
        int r13 = r11.mType;
        if (r13 != 1) goto L5;
        convertSlimnessBanner(r10, r11);
        return;
    L5:
        if (r13 != 2) goto L7;
        convertLoopBanner(r10, r11);
        return;
    L7:
        if (r13 != 3) goto L9;
        convertSlideMultiBanner(r10, r11);
        return;
    L9:
        if (r13 != 6) goto L11;
        convertListViewItem(r10, r11, r12);
        return;
    L11:
        if (r13 != 7) goto L13;
        convertPager(r10, r11, r12);
        return;
    L13:
        if (r13 == 117) goto L29;
        switch(r13) {
            case 10: goto L28;
            case 11: goto L27;
            case 12: goto L26;
            case 13: goto L28;
            case 14: goto L25;
            case 15: goto L24;
            default: goto L15;
        };
    L15:
        switch(r13) {
            case 103: goto L23;
            case 104: goto L22;
            case 105: goto L21;
            case 106: goto L20;
            case 107: goto L19;
            case 108: goto L18;
            case 109: goto L17;
            default: goto L53;
        };
    L17:
        convertSpaceView(r10, r11);
        return;
    L18:
        convertHeaderBouncyView(r10);
        return;
    L19:
        convertAppGroupView(r10, r11, r12, R$id.app_group_view_two_line);
        return;
    L20:
        convertAppGroupView(r10, r11, r12, R$id.app_group_view_one_line);
        return;
    L21:
        convertImageBanner(r10, r11);
        return;
    L22:
        convertLoadView(r10, r11);
        return;
    L23:
        convertFooterBouncyView(r10);
        return;
    L53:
        return;
    L24:
        convertVideoBanner(r10, r11);
        return;
    L25:
        convertRecommendVideo(r10, r11, r12);
        return;
    L26:
        convertMusts(r10, r11, r12, false);
        return;
    L27:
        convertMusts(r10, r11, r12, true);
        return;
    L28:
        convertAppGroupView(r10, r11, r12, R$id.topic_app_group);
        return;
    L29:
        convertImageBannerWithIntroduce(r10, r11);
    }

    public void onViewAttachedToWindow(QuickAdapter.VH r10) {
        super.onViewAttachedToWindow(r10);
        if (r10.getItemViewType() != 14) goto L7;
        JzvdStd r11 = (JzvdStd) r10.getView(R$id.topic_recommend_video);
        this.mCurVideo = r11;
        JzvdUtil.onResume(r11);
        return;
    }

    public void onViewDetachedFromWindow(QuickAdapter.VH r10) {
        super.onViewDetachedFromWindow(r10);
        if (r10.getItemViewType() != 14) goto L7;
        JzvdStd r11 = (JzvdStd) r10.getView(R$id.topic_recommend_video);
        this.mCurVideo = r11;
        JzvdUtil.onPause(r11);
        return;
    }

    private void convertMusts(QuickAdapter.VH r10, TopicItem r11, int r12, int r13, int r14, boolean r15) {
        PageDataBean r16 = (PageDataBean) r11.mData;
        ScrollGridView r17 = (ScrollGridView) r10.getView(r13);
        List<AppInfo> r18 = r16.apps.subList(0, (r16.apps.size() / 4) * 4);
        if (r17.getAdapter() == null) goto L5;
        ((MustAppInfoAdapter) r17.getAdapter()).syncData(r18, this.mOnBtnClickListener);
    L5:
        View r19 = r10.getView(r14);
        r19.setTag(R$id.must_app_list_tag, r18);
        int r20 = R$id.must_is_app_tag;
        if (r15 == false) goto L8;
        String r21 = AdReportParam.ClickPosType.SKIP;
    L9:
        r19.setTag(r20, r21);
        r17.setTag(r19);
        this.mMustsDataMap.put(r19, r18);
        updateInstallAllBtn(r18, r19);
        j.a("convertMusts name = " + r16.name);
        Iterator<AppInfo> r22 = r18.iterator();
    L11:
        if (r22.hasNext() == false) goto L13;
        onAppInfoReport(r22.next());
        goto L11
    L13:
        this.mUpdateViews.put(Integer.valueOf(r12), r17);
        return;
    L8:
        r21 = "1";
        goto L9
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void appendData(List<TopicItem> r10) {
        this.mDatas.addAll(r10);
        notifyDataSetChanged();
    }

    public TopicListAdapter(Context r10, List<TopicItem> r11, View.OnClickListener r12, View.OnClickListener r13) {
        this(r10, r11, null, r12, r13);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void appendData(int r10, TopicItem r11) {
        this.mDatas.add(r10, (T) r11);
        notifyDataSetChanged();
    }

    public TopicListAdapter(Context r10, List<TopicItem> r11, Topic r12, View.OnClickListener r13, View.OnClickListener r14) {
        this(r11);
        this.mContext = r10;
        this.mTopic = r12;
        this.mOnItemClickListener = r13;
        this.mOnBtnClickListener = r14;
    }
}
