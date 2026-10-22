package com.bytedanceos.common.ui;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.jzvd.Jzvd;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.CommonCache;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.R$style;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppList;
import com.bytedanceos.common.model.Category;
import com.bytedanceos.common.model.PageDataBean;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.toolbox.SizeConverter;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.toolbox.q;
import com.bytedanceos.common.ui.adapter.AppListAdapter;
import com.bytedanceos.common.ui.adapter.TopicListAdapter;
import com.bytedanceos.common.ui.fragment.StateView;
import com.bytedanceos.common.ui.utils.RecyclerViewUtil;
import com.bytedanceos.common.ui.utils.TopicItemParser;
import com.bytedanceos.common.ui.widget.AppListView;
import com.bytedanceos.common.ui.widget.BannerViewPager;
import com.bytedanceos.common.ui.widget.ParentView;
import com.bytedanceos.common.ui.widget.RefreshLoadListView;
import com.bytedanceos.common.utils.r;
import com.bytedanceos.common.utils.u;
import com.bytedanceos.common.view.RecyclerviewCompat;
import com.bytedanceos.ui.OUIChip;
import com.obric.oui.chip.OChipGroup;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes2.dex */
public class TopicActivity extends StatusBarActivity implements FetchDataCallBack, Observer, View.OnClickListener, StatusBarActivity.OnNetworkChangedListener {
    private static final Category EMPTY_CATEGORY = null;
    private int mCurrentPosition;
    private boolean mIsFromNavigation;
    private boolean mIsToDestroy;
    private View.OnClickListener mListItemClickListener;
    public RecyclerviewCompat mListView;
    private boolean mManualSelect;
    private final OUIChip.OnCheckedListener mOnCheckedChangeListener;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private ParentView mParentView;
    private RecyclerViewUtil mRecyclerViewUtil;
    private int mRequestType;
    private OChipGroup mSecondGroup;
    private ViewGroup mStateView;
    private String mTabSource;
    private TextView mToolbarTitle;
    private Topic mTopic;
    private TopicListAdapter mTopicListAdapter;

    static {
        EMPTY_CATEGORY = new Category();
    }

    public TopicActivity() {
        this.mRequestType = 2;
        this.mIsToDestroy = false;
        this.mIsFromNavigation = false;
        this.mOnCheckedChangeListener = new AnonymousClass1(this);
        this.mManualSelect = false;
        this.mCurrentPosition = -1;
        this.mTabSource = "topic";
        this.mListItemClickListener = new AnonymousClass2(this);
    }

    public static /* synthetic */ OChipGroup access$000(TopicActivity r10) {
        return r10.mSecondGroup;
    }

    public static /* synthetic */ int access$102(TopicActivity r10, int r11) {
        r10.mCurrentPosition = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$200(TopicActivity r10) {
        return r10.mManualSelect;
    }

    public static /* synthetic */ boolean access$202(TopicActivity r10, boolean r11) {
        r10.mManualSelect = r11;
        return r11;
    }

    public static /* synthetic */ void access$300(TopicActivity r10, int r11) {
        r10.scrollRecyclerViewToPosition(r11);
    }

    public static /* synthetic */ void access$400(TopicActivity r10) {
        r10.hideStateView();
    }

    public static /* synthetic */ RecyclerViewUtil access$500(TopicActivity r10) {
        return r10.mRecyclerViewUtil;
    }

    public static /* synthetic */ CommonCache access$600(TopicActivity r10) {
        return r10.getCache();
    }

    public static /* synthetic */ void access$700(TopicActivity r10, AppInfo r11, boolean r12) {
        r10.mobileDownload(r11, r12);
    }

    public static /* synthetic */ void access$800(TopicActivity r10, AppInfo r11, boolean r12, int r13) {
        r10.wifiDownload(r11, r12, r13);
    }

    public static /* synthetic */ int access$900(TopicActivity r10) {
        return r10.getCurrentItem();
    }

    private void attachTrackInfoToApp(AppInfo r10) {
        String r11 = getAppinfoTag(r10);
        if (TextUtils.isEmpty(r10.mPageTitle) == false) goto L5;
        String r12 = getTopicTitle();
    L6:
        r10.trackerInfo = addTrackerTail(r11, "Page-Title", r12);
        return;
    L5:
        r12 = r10.mPageTitle;
        goto L6
    }

    private void batchDownloadApps(List<AppInfo> r10) {
        Iterator<AppInfo> r11 = r10.iterator();
        long r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L20;
        AppInfo r13 = r11.next();
        if (r13.isSystemApp() == true) goto L7;
        if (com.bytedanceos.common.toolbox.e.h(r13.appDownloadUrl) == true) goto L10;
        r10.remove(r13);
        goto L4
    L10:
        r13.tabSource = getTabSource();
        if (TextUtils.isEmpty(r13.appPackageName) == true) goto L12;
        r12 = r12 + r13.appBytes;
        attachTrackInfoToApp(r13);
        int r14 = r13.downloadStatus;
        if (r14 == 64) goto L17;
        if (r14 != 32) goto L4;
    L17:
        d9.a.e().Q("0003", r13.trackerInfo);
        goto L4
    L12:
        com.bytedanceos.common.toolbox.j.a("packageName is Empty");
        r10.remove(r13);
        goto L4
    L7:
        com.bytedanceos.common.utils.j.j(BaseApplication.c(), r13);
        r10.remove(r13);
        goto L4
    L20:
        if (com.bytedanceos.common.download.d.a(this, r12) == true) goto L22;
        return;
    L22:
        int r15 = com.bytedanceos.common.toolbox.e.A();
        if (r15 != 0) goto L26;
        e0.e(R$string.retry_connection);
        return;
    L26:
        if (r15 != 2) goto L32;
        Iterator<AppInfo> r16 = r10.iterator();
    L29:
        if (r16.hasNext() == false) goto L92;
        downloadApp(r16.next(), false);
        goto L29
    L92:
        return;
    L32:
        if (r15 == 1) goto L34;
        return;
    L34:
        if (com.bytedanceos.common.toolbox.e.G(0) == false) goto L50;
        int r17 = r10.size();
        if (r17 <= 1) goto L38;
        boolean r18 = true;
    L39:
        int r19 = 0;
    L40:
        if (r19 >= r17) goto L49;
        AppInfo r20 = r10.get(r19);
        if (com.bytedanceos.common.toolbox.e.G(1) == true) goto L44;
        mobileDownload(r20, true);
    L48:
        r19 = r19 + 1;
        goto L40
    L44:
        if (getCache().f9566h.f9576a.containsKey(r20.appPackageName) == false) goto L46;
        mobileDownload(r20, false);
        goto L48
    L46:
        wifiDownload(r20, r18, r19);
        goto L48
    L49:
        return;
    L38:
        r18 = false;
        goto L39
    L50:
        Iterator<AppInfo> r21 = r10.iterator();
    L52:
        if (r21.hasNext() == false) goto L61;
        AppInfo r22 = r21.next();
        if (getCache().c0(r22.appPackageName) == false) goto L52;
        AppInfo r23 = getCache().s(r22.appPackageName);
        if (r23 != null) goto L59;
        r23 = new AppInfo();
    L59:
        if (r23.downloadTotalBytes <= 0) goto L52;
        r12 = r12 - r23.downloadCurrentBytes;
        goto L52
    L61:
        showDialog(r10, r12);
    }

    private void download(AppInfo r10, int r11) {
        if (com.bytedanceos.common.download.d.b(this, r10) == true) goto L6;
        return;
    L6:
        if (r10.isSystemApp() == false) goto L9;
        com.bytedanceos.common.utils.j.j(BaseApplication.c(), r10);
        return;
    L9:
        if (com.bytedanceos.common.toolbox.e.h(r10.appDownloadUrl) == false) goto L19;
        r10.tabSource = getTabSource();
        if (TextUtils.isEmpty(r10.appPackageName) == false) goto L14;
        com.bytedanceos.common.toolbox.j.b("Packagename is empty");
        return;
    L14:
        attachTrackInfoToApp(r10);
        performAddDownloadTask(r10);
        if (r11 != 64) goto L17;
    L18:
        d9.a.e().Q("0003", r10.trackerInfo);
        return;
    L17:
        if (r11 == 32) goto L18;
        return;
    L19:
        e0.e(R$string.download_error_url);
    }

    private void fetchPageData(int r10) {
        CommonAPIHelper.K(this.mRequestType, this.mTopic.getId(), r10, this);
    }

    private List<AppInfo> filterBatchDownloadApps(List<AppInfo> r10) {
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        Iterator<AppInfo> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L30;
        AppInfo r14 = r13.next();
        if (r14 == null) goto L7;
        int r15 = getCache().B(r14.appPackageName);
        if (r15 == 4) goto L28;
        if (r15 == 16) goto L28;
        if (r15 == 32) goto L26;
        if (r15 == 64) goto L26;
        if (r15 != 128) goto L19;
        if (r.b(r14.appPackageName) == true) goto L4;
        r14.downloadStatus = r15;
        r11.add(r14);
        goto L4
    L19:
        if (r15 != 512) goto L4;
        r12.add(r14);
    L26:
        if (r.c(r14.appPackageName) == false) goto L4;
    L28:
        r14.downloadStatus = r15;
        r11.add(r14);
        goto L4
    L7:
        com.bytedanceos.common.toolbox.j.b("AppInfo is null");
        goto L4
    L30:
        if (r12.isEmpty() == true) goto L43;
        Iterator r16 = r12.iterator();
        int r17 = 0;
    L33:
        if (r16.hasNext() == false) goto L36;
        r17 = (int) (((long) r17) + ((AppInfo) r16.next()).appBytes);
        goto L33
    L36:
        if (com.bytedanceos.common.download.d.a(this, r17) == false) goto L41;
        Iterator r18 = r12.iterator();
    L39:
        if (r18.hasNext() == false) goto L43;
        BaseApplication.c().g().installApp(this, (AppInfo) r18.next());
        goto L39
    L41:
        return null;
    L43:
        return r11;
    }

    private CommonCache getCache() {
        return BaseApplication.c().b();
    }

    private int getCurrentItem() {
        int r10 = this.mCurrentPosition;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        VirtualLayoutManager r11 = (VirtualLayoutManager) this.mListView.getLayoutManager();
        int r12 = r11.findFirstCompletelyVisibleItemPosition();
        TopicListAdapter r13 = (TopicListAdapter) this.mListView.getAdapter();
        if (r13 != null) goto L8;
        return r12;
    L8:
        int r14 = r11.findLastVisibleItemPosition();
        int r15 = r11.findFirstVisibleItemPosition();
    L9:
        if (r14 < 0) goto L13;
        if (isDivideView(r13.getItemViewType(r14)) == false) goto L13;
        r14 = r14 - 1;
    L13:
        if (r12 != (-1)) goto L15;
        return r14;
    L15:
        int r16 = r12;
    L16:
        if (r16 >= r14) goto L21;
        if (isDivideView(r13.getItemViewType(r16)) == false) goto L21;
        r16 = r16 + 1;
    L21:
        if (isDivideView(r13.getItemViewType(r16)) == false) goto L37;
    L22:
        if (r12 <= r15) goto L27;
        if (isDivideView(r13.getItemViewType(r12)) == false) goto L27;
        r12 = r12 - 1;
    L27:
        if (isDivideView(r13.getItemViewType(r12)) == false) goto L30;
        return -1;
    L30:
        return r12;
    L37:
        return r16;
    }

    private RefreshLoadListView getListView() {
        final RefreshLoadListView r10 = AppListView.createRefreshLoadListView(this.mParentView, this.mListItemClickListener, this, this.mTopic.getId());
        if (r10.getXListViewListener() != null) goto L5;
        r10.setXListViewListener(new AnonymousClass3(this, r10));
    L5:
        r10.setVisibility(8);
        return r10;
    }

    private String getTopicTitle() {
        TextView r10 = this.mToolbarTitle;
        if (r10 != null) goto L5;
        return "";
    L5:
        return r10.getText().toString();
    }

    private void hideStateView() {
        StateView.hideStateView(this.mStateView);
    }

    private void initCategoryView() {
        ViewStub r10 = (ViewStub) findViewById(R$id.second_category_container_stub);
        if (r10 == null) goto L5;
        this.mSecondGroup = (OChipGroup) r10.inflate();
    L5:
        this.mSecondGroup.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.mListView.getLayoutParams()).addRule(3, R$id.second_category_container);
        RecyclerView.OnScrollListener r11 = new AnonymousClass13(this);
        this.mOnScrollListener = r11;
        this.mListView.addOnScrollListener(r11);
    }

    private void initContentViewByData(int r10, String r11, String r12, AppList r13) {
        if (r10 != 200003) goto L5;
    L7:
        refreshSecondBarAppsLView(r13, r12);
        return;
    L5:
        if (r10 == 700011) goto L7;
    }

    private void initData() {
        this.mIsFromNavigation = getIntent().getBooleanExtra("original_from", false);     // Catch: Exception -> L6
        if (initDataInternal() == false) goto L11;
        fetchData(1);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    private void initPageApps(List<TopicListAdapter.TopicItem> r10, boolean r11) {
        updateHeadView();
        initListView();
        if (com.bytedanceos.common.toolbox.c.a(r10) == true) goto L5;
    L7:
        this.mListView.setVisibility(0);
        b9.b.a(this.mListView, true);
        if (this.mListView.getAdapter() != null) goto L10;
        TopicListAdapter r12 = new TopicListAdapter(this, r10, this.mTopic, this.mListItemClickListener, this);
        this.mTopicListAdapter = r12;
        this.mListView.setAdapter(r12);
    L12:
        if (this.mRecyclerViewUtil != null) goto L14;
        RecyclerViewUtil r13 = new RecyclerViewUtil(this.mListView);
        this.mRecyclerViewUtil = r13;
        r13.registerLoadCallback(new AnonymousClass6(this));
    L14:
        this.mRecyclerViewUtil.loadSuccess();
        if (r11 == false) goto L17;
        this.mRecyclerViewUtil.prepareLoad();
        return;
    L17:
        this.mRecyclerViewUtil.endLoad();
        return;
    L10:
        ((TopicListAdapter) this.mListView.getAdapter()).appendData(r10);
        goto L12
    L5:
        if (b9.b.c(this.mListView) != 1) goto L7;
        this.mListView.setVisibility(8);
        showAppListEmptyView();
    }

    private void initSecondCategoryContainer(List<TopicListAdapter.TopicItem> r10) {
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<TopicListAdapter.TopicItem> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r13 = r12.next().mData;
        if ((r13 instanceof PageDataBean) == true) goto L7;
        r11.add(EMPTY_CATEGORY);
        goto L4
    L7:
        r11.add(((PageDataBean) r13).category);
        goto L4
    L9:
        updateSecondCategoryContainer(r11);
    }

    private void initTopicApps(AppList r10) {
        RecyclerviewCompat r11 = this.mListView;
        boolean r12 = true;
        if (r11 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        List<TopicListAdapter.TopicItem> r14 = TopicItemParser.getAutoGroupTopicItems(r10, r13);
        if (r10 != null) goto L12;
    L14:
        r12 = false;
    L15:
        initPageApps(r14, r12);
        return;
    L12:
        if (r10.hasMore() == false) goto L14;
    L5:
        if (b9.b.e(r11) == true) goto L8;
        r13 = false;
        goto L9
    }

    private boolean isActivityAlive() {
        if (isFinishing() == false) goto L5;
    L9:
        return false;
    L5:
        if (this.mIsToDestroy == true) goto L9;
        if (isDestroyed() == true) goto L9;
        return true;
    }

    private boolean isDeveloperType() {
        Topic r10 = this.mTopic;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getType().equals("4") == false) goto L7;
        return true;
    }

    private boolean isDivideView(int r10) {
        if (r10 != 101) goto L5;
    L12:
        return true;
    L5:
        if (r10 == 102) goto L12;
        if (r10 == 103) goto L12;
        if (r10 == 109) goto L12;
        return false;
    }

    private boolean isOneStepTopic() {
        Topic r10 = this.mTopic;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if ("4".equals(r10.getPageId()) == false) goto L7;
        return true;
    }

    private boolean isStateViewVisible() {
        ViewGroup r10 = this.mStateView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getVisibility() != 0) goto L7;
        return true;
    }

    private boolean isVendorZone() {
        Topic r10 = this.mTopic;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(Topic.PAGE_ID_VENDOR_ZONE, r10.getPageId()) == false) goto L7;
        return true;
    }

    private void mobileDownload(AppInfo r10, boolean r11) {
        if (getCache().Y(r10.appPackageName) == false) goto L5;
        com.bytedanceos.common.utils.j.c(BaseApplication.c(), r10, true);
    L13:
        if (r11 == false) goto L16;
        getCache().t0(r10);
        return;
    L16:
        return;
    L5:
        if (com.bytedanceos.common.toolbox.e.h(r10.appDownloadUrl) == true) goto L7;
        e0.e(R$string.download_error_url);
        goto L13
    L7:
        if (getCache().U(r10.appPackageName) == false) goto L9;
        r10.appState = 64;
    L10:
        com.bytedanceos.common.utils.j.a(this, r10, true);
        goto L13
    L9:
        r10.appState = 32;
        goto L10
    }

    private void open(AppInfo r10) {
        if (getCache().U(r10.appPackageName) == false) goto L6;
        new Handler().postDelayed(new AnonymousClass8(this), 1000);
    L6:
        if (com.bytedanceos.common.toolbox.e.K0(this, r10.appPackageName) == false) goto L8;
        return;
    L8:
        if (r10.isSystemApp() == false) goto L12;
        e0.g(getString(R$string.system_app_no_main_activiy));
        return;
    }

    private void pause(AppInfo r10) {
        com.bytedanceos.common.utils.j.d(BaseApplication.c(), r10);
    }

    private void playOneStepVideo() {
        ComponentName r10 = new ComponentName("com.bytedanceos.manual", "com.bytedanceos.manual.activity.StartVideoActivity");     // Catch: Exception -> L4
        Intent r11 = new Intent();     // Catch: Exception -> L4
        r11.setComponent(r10);     // Catch: Exception -> L4
        r11.putExtra("video_name", "onestep_video");     // Catch: Exception -> L4
        startActivity(r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedanceos.common.toolbox.j.b(e.getMessage());
    }

    private void reAdjustPosition() {
        this.mListView.post(new AnonymousClass14(this));
    }

    private void refreshSecondBarAppsLView(AppList r10, String r11) {
        if (r10 != null) goto L4;
    L19:
        showNotFoundAppInfoView();
        return;
    L4:
        if (r10.isEmpty() == true) goto L19;
        RefreshLoadListView r12 = (RefreshLoadListView) this.mParentView.findViewById(R$id.applist_lv);
        if (r12 != null) goto L9;
        r12 = getListView();
        this.mParentView.addView(r12, 0);
    L9:
        List<String> r13 = r10.getBannerUrl();
        if (AppListView.getPage(r12) != 1) goto L17;
        if (r13 == null) goto L17;
        if (r13.size() <= 0) goto L17;
        BannerViewPager r14 = new BannerViewPager(this);
        r14.setBannerUrls(r13);
        if (r12.getHeaderViewsCount() > 1) goto L17;
        r12.addHeaderView(r14);
    L17:
        refreshAppListView(r12, r10);
        showAppListStateView(r12, true);
    }

    private void scrollRecyclerViewToPosition(int r10) {
        if (r10 != (-1)) goto L5;
        return;
    L5:
        VirtualLayoutManager r11 = (VirtualLayoutManager) this.mListView.getLayoutManager();
        if (this.mListView.getAdapter() == null) goto L8;
        int r12 = this.mListView.getAdapter().getItemCount() - 1;
    L9:
        int r13 = r12 - 2;
        int r14 = r11.findLastVisibleItemPosition();
        if (r10 <= r11.findFirstVisibleItemPosition()) goto L21;
        if (r10 > r14) goto L21;
        if (r14 < r13) goto L21;
        View r15 = r11.findViewByPosition(r10);
        View r16 = r11.findViewByPosition(r14);
        if (r15 == null) goto L27;
        if (r16 == null) goto L28;
        int[] r17 = new int[2];
        r16.getLocationOnScreen(r17);
        int r18 = r17[1];
        r15.getLocationOnScreen(r17);
        int r19 = r17[1];
        this.mListView.getLocationOnScreen(r17);
        int r20 = r17[1];
        int r21 = (r18 + r16.getHeight()) - q.g(this);
        int r22 = r19 - r20;
        if (r21 <= 0) goto L29;
        if (r22 <= 0) goto L30;
        this.mListView.removeOnScrollListener(this.mOnScrollListener);
        this.mListView.smoothScrollBy(0, Math.min(r21, r22));
        this.mListView.addOnScrollListener(this.mOnScrollListener);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L21:
        this.mListView.removeOnScrollListener(this.mOnScrollListener);
        if (r10 < r13) goto L24;
        r11.scrollToPosition(r13);
    L25:
        this.mListView.addOnScrollListener(this.mOnScrollListener);
        reAdjustPosition();
        return;
    L24:
        r11.scrollToPositionWithOffset(r10, 0);
        goto L25
    L8:
        r12 = 0;
        goto L9
    }

    private void showAppListEmptyView() {
        StateView.showEmptyView(this.mStateView, getString(R$string.topic_empty_msg), "", new int[]{R$drawable.topics_empty});
    }

    private void showDialog(final List<AppInfo> r10, long r11) {
        View r12 = LayoutInflater.from(this).inflate(R$layout.dialog_mobile_tip, null);
        ((TextView) r12.findViewById(R$id.total_flow)).setText(getString(R$string.alert_dataflow_message, new Object[]{SizeConverter.BTrim.convert(r11)}));
        final CheckBox r13 = (CheckBox) r12.findViewById(R$id.check_record);
        new AlertDialog.Builder(new ContextThemeWrapper(this, R$style.AppStoreDialogTheme)).setTitle(R$string.alert_dataflow_title).setView(r12).setNegativeButton(R$string.alert_wifi_continue, new AnonymousClass10(this, r13, r10)).setPositiveButton(R$string.alert_dataflow_continue, new AnonymousClass9(this, r13, r10)).create().show();
    }

    private void showLoadingView() {
        StateView.showLoadingView(this.mStateView);
    }

    private void showNotFoundAppInfoView() {
        String r10 = getString(R$string.app_no_offer_msg);
        StateView.showEmptyView(this.mStateView, r10, "", new int[]{R$drawable.app_no_offer});
    }

    private void updateHeadView() {
        Topic r10 = this.mTopic;
        if (r10 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10.getTitle()) == true) goto L9;
        this.mToolbarTitle.setText(getTitleText());
        return;
    }

    private void updateSecondCategoryContainer(List<Category> r12) {
        if (r12 != null) goto L4;
    L31:
        this.mSecondGroup.setVisibility(8);
        return;
    L4:
        if (r12.size() == 0) goto L31;
        this.mSecondGroup.setVisibility(0);
        this.mSecondGroup.removeAllViews();
        ViewGroup.LayoutParams r10 = new ViewGroup.LayoutParams(-2, -2);
        int r11 = r12.size();
        String r13 = getIntent().getStringExtra("sub_category_id");
        OUIChip r14 = null;
        int r15 = 0;
        final int r16 = 0;
    L7:
        if (r15 >= r11) goto L21;
        if (r12.get(r15).equals(EMPTY_CATEGORY) == true) goto L19;
        OUIChip r17 = new OUIChip(this);
        Category r18 = r12.get(r15);
        r17.setId(Integer.parseInt(r18.getId()));
        String r19 = r18.getName();
        if (TextUtils.isEmpty(r19) == false) goto L14;
        r19 = getTitleText();
    L14:
        r17.setText(r19);
        r17.setTag(Integer.valueOf(r15));
        r17.setOnCheckedListener(this.mOnCheckedChangeListener);
        this.mSecondGroup.addView(r17, r10);
        if (r13 == null) goto L19;
        if (r13.equals(r18.getId()) == false) goto L19;
        r16 = r15;
        r14 = r17;
    L19:
        r15 = r15 + 1;
        goto L7
    L21:
        if (r14 == null) goto L24;
        r14.setChecked(true);
    L28:
        if (r16 == 0) goto L38;
        this.mListView.post(new AnonymousClass12(this, r16));
        return;
    L38:
        return;
    L24:
        if (this.mSecondGroup.getChildCount() <= 0) goto L28;
        View r20 = this.mSecondGroup.getChildAt(0);
        if ((r20 instanceof OUIChip) == false) goto L28;
        ((OUIChip) r20).setChecked(true);
        goto L28
    }

    private void wifiDownload(AppInfo r10, boolean r11, int r12) {
        AppInfo r13 = getCache().t(r10.appPackageName);
        if (r13 == null) goto L8;
        long r14 = r13.pauseCode;
        if (r14 != 3) goto L7;
    L9:
        if (r11 == false) goto L12;
        if (r12 != 0) goto L14;
        e0.e(R$string.wifi_auto_batch_download);
        return;
    L14:
        return;
    L12:
        e0.e(R$string.wifi_auto_download);
        return;
    L7:
        if (r14 == 2) goto L9;
    L8:
        getCache().h(r10);
        updateVisibleView();
        goto L9
    }

    public boolean acceptCookie(Object r10) {
        return true;
    }

    public boolean acceptFetchData(Object r10) {
        if (this.mIsToDestroy == false) goto L7;
        return false;
    L7:
        return acceptCookie(r10);
    }

    public String addTrackerTail(String r10, String r11, String r12) {
        return d9.a.a(r10, r11, r12);
    }

    public void doBatchDownloadAppsWorkflow(List<AppInfo> r10) {
        List<AppInfo> r11 = filterBatchDownloadApps(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L9;
        batchDownloadApps(r11);
        return;
    }

    public void downloadApp(AppInfo r10, boolean r11) {
        if (getCache().X(r10.appPackageName) == false) goto L6;
        com.bytedanceos.common.toolbox.j.a("downloading:" + r10.appPackageName);
        return;
    L6:
        if (getCache().c0(r10.appPackageName) == false) goto L9;
        com.bytedanceos.common.utils.j.c(BaseApplication.c(), r10, r11);
        return;
    L9:
        if (com.bytedanceos.common.toolbox.e.h(r10.appDownloadUrl) == false) goto L11;
        com.bytedanceos.common.utils.j.a(this, r10, false);
        return;
    L11:
        e0.e(R$string.download_error_url);
    }

    public void fetchData(int r10) {
        String r11 = this.mTopic.getType();
        r11.hashCode();
        if (r11.equals("4") == false) goto L5;
        CommonAPIHelper.z(this.mRequestType, this.mTopic.getTitle(), this.mTopic.getId(), r10, this);
        return;
    L5:
        if (r11.equals("5") == true) goto L8;
        CommonAPIHelper.Q(this.mRequestType, this.mTopic.getId(), r10, this);
        return;
    L8:
        if (TextUtils.isEmpty(this.mTopic.getPageId()) == false) goto L10;
        CommonAPIHelper.O(this.mRequestType, this.mTopic.getId(), r10, this);
        return;
    L10:
        fetchPageData(Integer.parseInt(this.mTopic.getPageId()));
    }

    public AppInfo getAppInfoBeforeListItemClick(View r10) {
        int r11 = R$id.appinfo;
        if (r10.getTag(r11) != null) goto L7;
        return null;
    L7:
        return (AppInfo) r10.getTag(r11);
    }

    public String getAppinfoTag(AppInfo r10) {
        if (r10 == null) goto L34;
        String r11 = addTrackerTail(addTrackerTail(addTrackerTail("", "pkg_name", r10.appPackageName), "source_page", "9013"), "source_page_name", getSourcePageName());
        AppInfo.From r12 = r10.appFrom;
        if (r12 == null) goto L33;
        if (r12.mark == null) goto L33;
        if (TextUtils.equals(r12.operative_type, "2") == false) goto L11;
        String r13 = addTrackerTail(r11, "download_sign", "1");
    L12:
        String r14 = r10.appFrom.mark;
        if ("local".equals(r14) == false) goto L16;
        int r15 = 0;
    L28:
        if (r15 <= 0) goto L31;
        String r16 = addTrackerTail(r13, DownloadInfoColumns.APP_SOURCE, "" + r15);
    L35:
        return r16;
    L31:
        r16 = addTrackerTail(r13, DownloadInfoColumns.APP_SOURCE, AdReportParam.ClickPosType.SKIP);
        goto L35
    L16:
        if ("wdj".equals(r14) == false) goto L19;
        r15 = 1;
        goto L28
    L19:
        if ("yyb".equals(r14) == false) goto L22;
        r15 = 2;
        goto L28
    L22:
        if ("dev".equals(r14) == false) goto L25;
        r15 = 3;
        goto L28
    L25:
        if ("9game".equals(r14) == false) goto L27;
        r15 = 4;
        goto L28
    L27:
        r15 = -1;
        goto L28
    L11:
        r13 = addTrackerTail(r11, "download_sign", AdReportParam.ClickPosType.SKIP);
    L33:
        return addTrackerTail(addTrackerTail(r11, DownloadInfoColumns.APP_SOURCE, AdReportParam.ClickPosType.SKIP), "download_sign", AdReportParam.ClickPosType.SKIP);
    L34:
        return "";
    }

    public String getBackBtnText() {
        return getString(R$string.back);
    }

    public Object getExtendedInfo() {
        return null;
    }

    @Override // com.bytedanceos.common.ui.BasicActivity
    public String getSourcePage() {
        if (isDeveloperType() == false) goto L5;
        return "9021";
    L5:
        return "9013";
    }

    @Override // com.bytedanceos.common.ui.BasicActivity
    public String getSourcePageName() {
        if (isDeveloperType() == false) goto L6;
        return getResources().getString(R$string.developer_list_page);
    L6:
        return getTopicTitle();
    }

    public String getTabSource() {
        return this.mTabSource;
    }

    public String getTitleText() {
        Topic r10 = this.mTopic;
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10.getTitle();
    }

    public boolean hasGroupTopicView() {
        return isVendorZone();
    }

    public void initBaseView(boolean r10) {
        ParentView r11 = (ParentView) findViewById(R$id.topic_parent_view);
        this.mParentView = r11;
        this.mStateView = StateView.getStateView(r11);
        Topic r12 = this.mTopic;
        if (r12 != null) goto L5;
    L8:
        if (r10 == false) goto L10;
        StateView.showEmptyView(this.mStateView, getString(R$string.topic_empty_msg), "", new int[]{R$drawable.topics_empty});
        return;
    L10:
        showLoadingView();
        return;
    L5:
        if (r12.isAvaliable() == false) goto L8;
        showLoadingView();
    }

    public boolean initDataInternal() {
        if (getIntent() == null) goto L11;
        Serializable r10 = getIntent().getSerializableExtra("topic_page");
        if ((r10 instanceof Topic) == false) goto L14;
        Topic r11 = (Topic) r10;
        this.mTopic = r11;
        if (TextUtils.isEmpty(r11.getTabSource()) == true) goto L13;
        this.mTabSource = this.mTopic.getTabSource();
        return true;
    L13:
        return true;
    L14:
        return false;
    L11:
        return false;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public View initHeaderView() {
        OFloatingTitleBar r10 = (OFloatingTitleBar) findViewById(R$id.toolbar);
        this.mToolbarTitle = u.f(r10, getTitleText());
        u.a(r10, this);
        u.c(r10, this);
        return r10;
    }

    public void initListView() {
        if (this.mListView != null) goto L8;
        this.mListView = new RecyclerviewCompat(this);
        RelativeLayout.LayoutParams r10 = new RelativeLayout.LayoutParams(-1, -1);
        this.mListView.setOverScrollMode(2);
        this.mListView.setClipChildren(false);
        VirtualLayoutManager r11 = new VirtualLayoutManager(this, 1, false);
        this.mListView.setLayoutManager(r11);
        RecyclerView.RecycledViewPool r12 = new RecyclerView.RecycledViewPool();
        this.mListView.setRecycledViewPool(r12);
        b9.b.g(this.mListView, 1);
        this.mParentView.addView(this.mListView, r10);
        if (hasGroupTopicView() == false) goto L9;
        initCategoryView();
        return;
    L9:
        return;
    }

    public boolean isLoadMore(RefreshLoadListView r10) {
        if (AppListView.getState(r10) == 6) goto L5;
        return false;
    L5:
        if (com.bytedanceos.common.toolbox.e.A() != 0) goto L7;
        e0.e(R$string.SOCKET_TIME_OUT);
        AppListView.onLoad(r10);
        return false;
    L7:
        AppListView.setState(r10, 2);
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (Jzvd.backPress() == false) goto L5;
        return;
    L5:
        super.onBackPressed();
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity.OnNetworkChangedListener
    public void onChanged(boolean r10) {
        if (this.mTopicListAdapter != null) goto L5;
        return;
    L5:
        if (isActivityAlive() == false) goto L11;
        if (r10 == false) goto L8;
        this.mTopicListAdapter.onResume();
        return;
    L8:
        this.mTopicListAdapter.onPause();
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r11) {
        int r10 = r11.getId();
        if (r10 != R$id.refresh_btn) goto L6;
        fetchData(1);
        return;
    L6:
        if (r10 != R$id.left_action_back) goto L8;
        onBackPressed();
        return;
    L8:
        String r12 = null;
        if (r10 != R$id.toolbar_search) goto L15;
        if (this.mIsFromNavigation == false) goto L13;
        com.bytedanceos.common.toolbox.e.n1(this, null, 0, "page_topic_navigation", 2);
        return;
    L13:
        com.bytedanceos.common.toolbox.e.n1(this, null, 0, "page_topic", 2);
        return;
    L15:
        if (r10 == R$id.appStatusLay) goto L38;
        if (r10 == R$id.search_hot_apps_status_view) goto L38;
        if (r10 != R$id.topic_video_banner) goto L25;
        if (isOneStepTopic() == false) goto L48;
        playOneStepVideo();
        d9.a.e().n("0098");
        return;
    L48:
        return;
    L25:
        if (r10 != R$id.topic_banner_layout) goto L30;
        if ((r11.getTag() instanceof Topic) == false) goto L50;
        Topic r13 = (Topic) r11.getTag();
        r13.setType("2");
        com.bytedanceos.common.toolbox.e.x1(this, r13);
        return;
    L50:
        return;
    L30:
        if (r10 != R$id.app_group_more) goto L52;
        String r14 = (String) r11.getTag();
        int r15 = ((Integer) r11.getTag(R$id.app_group_more_view_type)).intValue();
        com.bytedanceos.common.toolbox.j.a(" groupId = " + r14 + ", type = " + r15);
        String r16 = (String) r11.getTag(R$id.app_group_name);
        Object r17 = getExtendedInfo();
        if (r17 != null) goto L34;
    L36:
        com.bytedanceos.common.toolbox.e.s1(this, r14, r15, r16, getTitleText(), r12);
        d9.a.e().q("0081", getTopicTitle());
        return;
    L34:
        if ((r17 instanceof Category) == false) goto L36;
        r12 = ((Category) r17).getId();
        goto L36
    L52:
        return;
    L38:
        if (com.bytedanceos.common.toolbox.e.g(this) == false) goto L41;
        return;
    L41:
        if (com.bytedanceos.common.toolbox.e.p0() == false) goto L54;
        operateApp((AppInfo) r11.getTag(), false);
        return;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (BaseApplication.c().o() == true) goto L5;
        this.mRequestType = 3;
    L5:
        getCache().addObserver(this);
        setOnNetworkChangedListener(this);
        initData();
        setContentView(R$layout.topic_activity);
        initBaseView(true);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mIsToDestroy = true;
        getCache().deleteObserver(this);
        TopicListAdapter r10 = this.mTopicListAdapter;
        if (r10 == null) goto L6;
        r10.onDestroy();
        return;
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataFailed(final int r10, Throwable r11, String r12, Object r13) {
        if (acceptFetchData(r13) == true) goto L5;
        return;
    L5:
        runOnUiThread(new AnonymousClass5(this, r10));
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataSuccess(final int r10, int r11, final String r12, Object r13, final String r14) {
        if (acceptFetchData(r13) == true) goto L5;
        return;
    L5:
        runOnUiThread(new AnonymousClass4(this, r10, r12, r14));
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TopicListAdapter r10 = this.mTopicListAdapter;
        if (r10 == null) goto L6;
        r10.onPause();
        return;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TopicListAdapter r10 = this.mTopicListAdapter;
        if (r10 == null) goto L6;
        r10.onResume();
        return;
    }

    public void operateApp(AppInfo r10, boolean r11) {
        if (r10 != null) goto L5;
        com.bytedanceos.common.toolbox.j.b("AppInfo is null");
        return;
    L5:
        int r12 = getCache().B(r10.appPackageName);
        if (r12 != 1) goto L8;
    L33:
        if (r11 == true) goto L43;
        pause(r10);
        return;
    L43:
        return;
    L8:
        if (r12 == 2) goto L33;
        if (r12 != 4) goto L12;
    L32:
        download(r10, r12);
        return;
    L12:
        if (r12 == 16) goto L32;
        if (r12 == 32) goto L29;
        if (r12 == 64) goto L29;
        if (r12 == 128) goto L24;
        if (r12 != 512) goto L44;
        BaseApplication.c().g().installApp(this, r10);
        return;
    L44:
        return;
    L24:
        if (r.b(r10.appPackageName) == false) goto L27;
        if (r11 == true) goto L37;
        open(r10);
        return;
    L37:
        return;
    L27:
        download(r10, r12);
        return;
    L29:
        if (r.c(r10.appPackageName) == true) goto L32;
        if (r11 == true) goto L40;
        open(r10);
        return;
    }

    public void performAddDownloadTask(AppInfo r10) {
        int r11 = com.bytedanceos.common.toolbox.e.A();
        if (r11 != 0) goto L6;
        e0.e(R$string.retry_connection);
        return;
    L6:
        if (r11 != 2) goto L9;
        downloadApp(r10, false);
        return;
    L9:
        if (r11 == 1) goto L11;
        return;
    L11:
        if (com.bytedanceos.common.toolbox.e.G(0) == true) goto L13;
        long r12 = r10.appBytes;
        if (getCache().c0(r10.appPackageName) == false) goto L29;
        AppInfo r13 = getCache().s(r10.appPackageName);
        if (r13 != null) goto L25;
        r13 = new AppInfo();
    L25:
        long r14 = r13.downloadTotalBytes;
        if (r14 > 0) goto L28;
        r12 = r10.appBytes;
        goto L29
    L28:
        r12 = r14 - r13.downloadCurrentBytes;
    L29:
        ArrayList r15 = new ArrayList(1);
        r15.add(r10);
        showDialog(r15, r12);
        return;
    L13:
        if (com.bytedanceos.common.toolbox.e.G(1) == true) goto L15;
        mobileDownload(r10, true);
        return;
    L15:
        if (getCache().f9566h.f9576a.containsKey(r10.appPackageName) == false) goto L17;
        mobileDownload(r10, false);
        return;
    L17:
        wifiDownload(r10, false, 0);
    }

    public void refreshAppListView(RefreshLoadListView r10, AppList r11) {
        if (r10 != null) goto L5;
        com.bytedanceos.common.toolbox.j.a("listView is null");
        return;
    L5:
        int r12 = AppListView.getPage(r10);
        if (r11 != null) goto L10;
        if (r12 != 1) goto L10;
        AppListView.setState(r10, 4);
        return;
    L10:
        if (r11 != null) goto L12;
    L16:
        AppListView.onLoad(r10);
        if (r11 != null) goto L19;
    L21:
        r10.setPullLoadEnable(false);
        com.bytedanceos.common.toolbox.j.a("appList is null:" + r11);
        return;
    L19:
        if (r11.isEmpty() == true) goto L21;
        AppListView.updateListView(r10, r11, "4".equals(this.mTopic.getType()));
        return;
    L12:
        if (r11.isEmpty() == false) goto L16;
        if (r12 != 1) goto L16;
        AppListView.setState(r10, 3);
    }

    public void refreshViewWithServerData(int r10, String r11, String r12) {
        switch(r10) {
            case 200001: goto L12;
            case 200003: goto L11;
            case 700011: goto L10;
            case 2000001: goto L5;
            case 2000002: goto L4;
            default: goto L20;
        };
    L4:
        List<TopicListAdapter.TopicItem> r13 = c9.a.w(r11, r12, getTitleText());
        initPageApps(r13, false);
        initSecondCategoryContainer(r13);
        return;
    L5:
        List<TopicListAdapter.TopicItem> r14 = c9.a.z(r11, r12, getTitleText());
        if (r14 == null) goto L15;
        initPageApps(r14);
        if (hasGroupTopicView() == false) goto L16;
        initSecondCategoryContainer(r14);
        return;
    L16:
        return;
    L15:
        return;
    L10:
        initContentViewByData(r10, r11, r12, c9.a.r(r11, r12));
        return;
    L11:
        initContentViewByData(r10, r11, r12, c9.a.B(r11, r12));
        return;
    L12:
        initTopicApps(c9.a.r(r11, r12), r11);
        return;
    }

    public void showAppListStateView(final ListView r10, final boolean r11) {
        int r12 = AppListView.getState(r10);
        if (r12 != 1) goto L5;
        r10.setVisibility(8);
        showLoadingView();
        return;
    L5:
        if (r12 != 3) goto L7;
        r10.setVisibility(8);
        showAppListEmptyView();
        return;
    L7:
        if (r12 != 4) goto L9;
        r10.setVisibility(8);
        showRefreshView();
        return;
    L9:
        if (r12 != 5) goto L11;
        r10.setVisibility(8);
        showLoginView();
        return;
    L11:
        if (r12 != 6) goto L26;
        hideStateView();
        r10.post(new AnonymousClass7(this, r10, r11));
        if (r11 == false) goto L21;
        updateListView(r10);
        return;
    L21:
        return;
    }

    public void showLoginView() {
        String r10 = getString(R$string.gift_login);
        StateView.showLoginView(this.mStateView, r10, this, R$drawable.collection_empty);
    }

    public void showRefreshView() {
        StateView.showRefreshView(this.mStateView, this);
    }

    @Override // java.util.Observer
    public void update(Observable r10, final Object r11) {
        if (isActivityAlive() == true) goto L6;
        com.bytedanceos.common.toolbox.j.a("can not update." + getTabSource());
        return;
    L6:
        runOnUiThread(new AnonymousClass11(this, r11));
    }

    public void updateAppListView() {
        int r10 = 0;
    L4:
        if (r10 >= this.mParentView.getChildCount()) goto L9;
        View r11 = this.mParentView.getChildAt(r10);
        if ((r11 instanceof ListView) == false) goto L8;
        updateListView((ListView) r11);
    L8:
        r10 = r10 + 1;
        goto L4
    }

    public void updateInternal() {
        Topic r10 = this.mTopic;
        if (r10 != null) goto L5;
    L11:
        Topic r11 = this.mTopic;
        if (r11 != null) goto L14;
    L25:
        Topic r12 = this.mTopic;
        if (r12 != null) goto L28;
        return;
    L28:
        if (TextUtils.equals(r12.getType(), "4") == false) goto L40;
        updateVisibleView();
        return;
    L40:
        return;
    L14:
        if (TextUtils.equals(r11.getType(), "5") == false) goto L25;
        if (TextUtils.isEmpty(this.mTopic.getPageId()) == true) goto L22;
        RecyclerviewCompat r13 = this.mListView;
        if (r13 != null) goto L20;
        return;
    L20:
        if (r13.getAdapter() == null) goto L35;
        ((TopicListAdapter) this.mListView.getAdapter()).updateDownloadStatus();
        return;
    L35:
        return;
    L22:
        RefreshLoadListView r14 = (RefreshLoadListView) this.mParentView.findViewById(R$id.applist_lv);
        if (r14 == null) goto L37;
        updateListView(r14);
        return;
    L37:
        return;
    L5:
        if (TextUtils.equals(r10.getType(), "2") == false) goto L11;
        RecyclerviewCompat r15 = this.mListView;
        if (r15 != null) goto L9;
        return;
    L9:
        if (r15.getAdapter() == null) goto L32;
        ((TopicListAdapter) this.mListView.getAdapter()).updateDownloadStatus();
        return;
    }

    public void updateListView(ListView r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getAdapter() != null) goto L7;
        return;
    L7:
        if ((r10.getAdapter() instanceof HeaderViewListAdapter) == false) goto L9;
        AppListAdapter r11 = (AppListAdapter) ((HeaderViewListAdapter) r10.getAdapter()).getWrappedAdapter();
    L10:
        if (r11 == null) goto L14;
        r11.onUpdate();
        return;
    L14:
        return;
    L9:
        r11 = (AppListAdapter) r10.getAdapter();
        goto L10
    }

    public void updateVisibleView() {
        updateAppListView();
    }

    private void initTopicApps(AppList r10, String r11) {
        Topic r12 = c9.a.N(r11);
        this.mTopic = r12;
        ArrayList r13 = new ArrayList();
        r13.add(r12.getImageResUrl());
        r10.setBannerUrls(r13);
        if (TextUtils.isEmpty(r12.getIntroduce()) == true) goto L5;
        r10.setIntroduce(r12.getIntroduce());
    L5:
        initTopicApps(r10);
    }

    private void initPageApps(List<TopicListAdapter.TopicItem> r10) {
        initPageApps(r10, false);
    }
}
