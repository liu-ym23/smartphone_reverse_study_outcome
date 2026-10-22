package com.bytedanceos.common.ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
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
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.toolbox.SizeConverter;
import com.bytedanceos.common.toolbox.d0;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.ui.adapter.AppListAdapter;
import com.bytedanceos.common.ui.fragment.StateView;
import com.bytedanceos.common.ui.widget.AppListView;
import com.bytedanceos.common.ui.widget.ParentView;
import com.bytedanceos.common.ui.widget.RefreshLoadListView;
import com.bytedanceos.common.utils.r;
import com.bytedanceos.common.utils.u;
import com.obric.appstore.network.entity.template.ElementTextEntity;
import com.obric.oui.divider.ODivider;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes2.dex */
public class CategoryListActivity extends StatusBarActivity implements View.OnClickListener, FetchDataCallBack, Observer {
    private int mAppGroupViewMoreType;
    private RefreshLoadListView mAppListView;
    private Category mCurrCategory;
    private ODivider mDivider;
    private boolean mIsFromNavigation;
    private boolean mIsToDestroy;
    private View.OnClickListener mListItemClickListener;
    private String mParentCategoryId;
    private ParentView mParentView;
    private ViewGroup mStateView;
    private TextView mToolbarTitle;

    public CategoryListActivity() {
        this.mIsToDestroy = false;
        this.mIsFromNavigation = false;
    }

    private boolean acceptCookie(Object r10) {
        return true;
    }

    private boolean acceptFetchData(Object r10) {
        if (this.mIsToDestroy == false) goto L7;
        return false;
    L7:
        return acceptCookie(r10);
    }

    public static /* synthetic */ void access$000(CategoryListActivity r10, int r11, String r12, String r13) {
        r10.refreshViewWithServerData(r11, r12, r13);
    }

    public static /* synthetic */ void access$100(CategoryListActivity r10) {
        r10.updateVisibleView();
    }

    public static /* synthetic */ void access$1000(CategoryListActivity r10, AppInfo r11, boolean r12) {
        r10.mobileDownload(r11, r12);
    }

    public static /* synthetic */ void access$1100(CategoryListActivity r10, AppInfo r11) {
        r10.wifiDownload(r11);
    }

    public static /* synthetic */ AppInfo access$200(CategoryListActivity r10, View r11) {
        return r10.getAppInfoBeforeListItemClick(r11);
    }

    public static /* synthetic */ Category access$300(CategoryListActivity r10) {
        return r10.mCurrCategory;
    }

    public static /* synthetic */ RefreshLoadListView access$400(CategoryListActivity r10) {
        return r10.mAppListView;
    }

    public static /* synthetic */ boolean access$500(CategoryListActivity r10, RefreshLoadListView r11) {
        return r10.isLoadMore(r11);
    }

    public static /* synthetic */ int access$600(CategoryListActivity r10) {
        return r10.mAppGroupViewMoreType;
    }

    public static /* synthetic */ String access$700(CategoryListActivity r10) {
        return r10.mParentCategoryId;
    }

    public static /* synthetic */ void access$800(CategoryListActivity r10) {
        r10.updateAppListView();
    }

    public static /* synthetic */ CommonCache access$900(CategoryListActivity r10) {
        return r10.getCache();
    }

    private String addTrackerTail(String r10, String r11, String r12) {
        return d9.a.a(r10, r11, r12);
    }

    private void download(AppInfo r10, int r11) {
        if (com.bytedanceos.common.download.d.b(this, r10) == true) goto L6;
        return;
    L6:
        if (r10.isSystemApp() == false) goto L9;
        com.bytedanceos.common.utils.j.j(BaseApplication.c(), r10);
        return;
    L9:
        if (com.bytedanceos.common.toolbox.e.h(r10.appDownloadUrl) == false) goto L23;
        r10.tabSource = getTabSource();
        if (TextUtils.isEmpty(r10.appPackageName) == false) goto L14;
        com.bytedanceos.common.toolbox.j.b("Packagename is empty");
        return;
    L14:
        String r12 = getAppinfoTag(r10);
        if (TextUtils.isEmpty(r10.mPageTitle) == false) goto L17;
        String r13 = getTopicTitle();
    L18:
        r10.trackerInfo = addTrackerTail(r12, "Page-Title", r13);
        performAddDownloadTask(r10);
        if (r11 != 64) goto L21;
    L22:
        d9.a.e().Q("0003", r10.trackerInfo);
        return;
    L21:
        if (r11 == 32) goto L22;
        return;
    L17:
        r13 = r10.mPageTitle;
        goto L18
    L23:
        e0.e(R$string.download_error_url);
    }

    private void downloadApp(AppInfo r10, boolean r11) {
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

    private void fetchAppListData(long r10) {
        if (this.mIsToDestroy == false) goto L7;
        com.bytedanceos.common.toolbox.j.a("params error");
        return;
    L7:
        if (this.mCurrCategory == null) goto L13;
        showLoadingView();
        AppListView.setState(this.mAppListView, 1);
        if (this.mAppGroupViewMoreType != 10) goto L11;
        CommonAPIHelper.w(Long.valueOf(r10), this.mParentCategoryId, 1, this);
        return;
    L11:
        CommonAPIHelper.v(r10, 1, this);
        return;
    }

    private void fetchData() {
        loadRankingListPage();
    }

    private AppInfo getAppInfoBeforeListItemClick(View r10) {
        int r11 = R$id.appinfo;
        if (r10.getTag(r11) != null) goto L7;
        return null;
    L7:
        return (AppInfo) r10.getTag(r11);
    }

    private String getAppinfoTag(AppInfo r10) {
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

    private CommonCache getCache() {
        return BaseApplication.c().b();
    }

    private String getTabSource() {
        return "topic";
    }

    private String getTopicTitle() {
        TextView r10 = this.mToolbarTitle;
        if (r10 != null) goto L5;
        return "";
    L5:
        return r10.getText().toString();
    }

    private void hideStateView() {
        if (isStateViewVisible() == false) goto L6;
        this.mStateView.setVisibility(8);
        return;
    }

    private void initBaseView() {
        this.mParentView = (ParentView) findViewById(R$id.topic_parent_view);
        this.mDivider = (ODivider) findViewById(R$id.line);
        this.mStateView = StateView.getStateView(this.mParentView);
        showLoadingView();
    }

    private void initData() {
        Intent r10 = getIntent();
        this.mIsFromNavigation = r10.getBooleanExtra("original_from", false);     // Catch: Exception -> L5
        String r11 = r10.getStringExtra(ElementTextEntity.Key.CATEGORY_ID);     // Catch: Exception -> L5
        String r12 = r10.getStringExtra(ElementTextEntity.Key.CATEGORY_NAME);     // Catch: Exception -> L5
        this.mParentCategoryId = r10.getStringExtra("parent_category_id");     // Catch: Exception -> L5
        this.mAppGroupViewMoreType = r10.getIntExtra("app_group_more_view_type", 10);     // Catch: Exception -> L5
        Category r13 = new Category();     // Catch: Exception -> L5
        this.mCurrCategory = r13;     // Catch: Exception -> L5
        r13.setId(r11);     // Catch: Exception -> L5
        this.mCurrCategory.setName(r12);     // Catch: Exception -> L5
    L7:
        this.mListItemClickListener = new AnonymousClass3(this);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private boolean isActivityCanUpdate() {
        if (isFinishing() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsToDestroy == true) goto L7;
        return true;
    }

    private boolean isLoadMore(RefreshLoadListView r10) {
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

    private boolean isStateViewVisible() {
        ViewGroup r10 = this.mStateView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getVisibility() != 0) goto L7;
        return true;
    }

    private /* synthetic */ void lambda$loadRankingListPage$0(View r10, int r11, int r12, int r13, int r14) {
        int r15 = 0;
        View r16 = this.mAppListView.getChildAt(0);
        if (this.mAppListView.getFirstVisiblePosition() != 0) goto L8;
        if (r16 != null) goto L6;
    L7:
        boolean r17 = true;
    L9:
        ODivider r18 = this.mDivider;
        if (r17 == false) goto L12;
        r15 = 8;
    L12:
        r18.setVisibility(r15);
        return;
    L6:
        if (r16.getTop() == this.mAppListView.getPaddingTop()) goto L7;
    L8:
        r17 = false;
        goto L9
    }

    private void loadRankingListPage() {
        long r10 = d0.b(this.mCurrCategory.getId());
        Long r11 = Long.valueOf(r10);
        RefreshLoadListView r12 = AppListView.createRefreshLoadListView(this.mParentView, this.mAppListView, this.mListItemClickListener, this, r11, null, null, null, 1);
        this.mAppListView = r12;
        r12.setOnScrollChangeListener(new a(this));
        this.mAppListView.setClipToPadding(false);
        this.mAppListView.setPadding(0, tc.f.i(8), 0, 0);
        if (this.mAppListView.getXListViewListener() != null) goto L5;
        this.mAppListView.setXListViewListener(new AnonymousClass4(this));
    L5:
        fetchAppListData(r10);
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
        new Handler().postDelayed(new AnonymousClass6(this), 1000);
    L6:
        if (com.bytedanceos.common.toolbox.e.K0(this, r10.appPackageName) == false) goto L8;
        return;
    L8:
        if (r10.isSystemApp() == false) goto L12;
        e0.g(getString(R$string.system_app_no_main_activiy));
        return;
    }

    private void operateApp(AppInfo r10) {
        if (r10 != null) goto L5;
        com.bytedanceos.common.toolbox.j.b("AppInfo is null");
        return;
    L5:
        int r11 = getCache().B(r10.appPackageName);
        if (r11 != 1) goto L8;
    L31:
        pause(r10);
        return;
    L8:
        if (r11 == 2) goto L31;
        if (r11 != 4) goto L12;
    L30:
        download(r10, r11);
        return;
    L12:
        if (r11 == 16) goto L30;
        if (r11 == 32) goto L28;
        if (r11 == 64) goto L28;
        if (r11 == 128) goto L24;
        if (r11 != 512) goto L38;
        BaseApplication.c().g().installApp(this, r10);
        return;
    L38:
        return;
    L24:
        if (r.b(r10.appPackageName) == false) goto L26;
        open(r10);
        return;
    L26:
        download(r10, r11);
        return;
    L28:
        if (r.c(r10.appPackageName) == true) goto L30;
        open(r10);
    }

    private void pause(AppInfo r10) {
        com.bytedanceos.common.utils.j.d(BaseApplication.c(), r10);
    }

    private void performAddDownloadTask(final AppInfo r10) {
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
        View r15 = LayoutInflater.from(this).inflate(R$layout.dialog_mobile_tip, null);
        ((TextView) r15.findViewById(R$id.total_flow)).setText(getString(R$string.alert_dataflow_message, new Object[]{SizeConverter.BTrim.convert(r12)}));
        final CheckBox r16 = (CheckBox) r15.findViewById(R$id.check_record);
        new AlertDialog.Builder(new ContextThemeWrapper(this, R$style.AppStoreDialogTheme)).setTitle(R$string.alert_dataflow_title).setView(r15).setNegativeButton(R$string.alert_wifi_continue, new AnonymousClass9(this, r16, r10)).setPositiveButton(R$string.alert_dataflow_continue, new AnonymousClass8(this, r16, r10)).setOnCancelListener(new AnonymousClass7(this)).create().show();
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
        wifiDownload(r10);
    }

    private void refreshAppListView(AppList r10) {
        refreshAppListView(this.mAppListView, r10);
        showAppListView();
    }

    private void refreshViewWithServerData(int r10, String r11, String r12) {
        if (r10 != 400003) goto L5;
    L7:
        refreshAppListView(c9.a.B(r11, r12));
        return;
    L5:
        if (r10 == 2000003) goto L7;
    }

    public static /* synthetic */ void s(CategoryListActivity r10, View r11, int r12, int r13, int r14, int r15) {
        r10.lambda$loadRankingListPage$0(r11, r12, r13, r14, r15);
    }

    private void showAppListEmptyView() {
        StateView.showEmptyView(this.mStateView, getString(R$string.cat_empty_msg), getString(R$string.cat_empty_desc), new int[]{R$drawable.categories_empty});
    }

    private void showAppListStateView(final ListView r10, final boolean r11) {
        int r12 = AppListView.getState(r10);
        if (r12 != 1) goto L5;
        r10.setVisibility(8);
        showLoadingView();
        return;
    L5:
        if (r12 == 6) goto L14;
        if (r12 != 3) goto L9;
        r10.setVisibility(8);
        showAppListEmptyView();
        return;
    L9:
        if (r12 != 4) goto L25;
        r10.setVisibility(8);
        showRefreshView();
        return;
    L25:
        return;
    L14:
        if (isStateViewVisible() == false) goto L16;
        hideStateView();
    L16:
        r10.post(new AnonymousClass5(this, r10, r11));
        if (r11 == false) goto L23;
        updateListView(r10);
        return;
    }

    private void showAppListView() {
        showAppListStateView(this.mAppListView, true);
    }

    private void showLoadingView() {
        StateView.showLoadingView(this.mStateView);
    }

    private void showRefreshView() {
        StateView.showRefreshView(this.mStateView, this);
    }

    private void updateAppListView() {
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

    private void updateListView(ListView r10) {
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

    private void updateVisibleView() {
        updateAppListView();
    }

    private void wifiDownload(AppInfo r10) {
        AppInfo r11 = getCache().t(r10.appPackageName);
        if (r11 == null) goto L8;
        long r12 = r11.pauseCode;
        if (r12 != 3) goto L7;
    L9:
        e0.e(R$string.wifi_auto_download);
        return;
    L7:
        if (r12 == 2) goto L9;
    L8:
        getCache().h(r10);
        updateVisibleView();
        goto L9
    }

    @Override // com.bytedanceos.common.ui.BasicActivity
    public String getSourcePageName() {
        return getTopicTitle();
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public View initHeaderView() {
        OFloatingTitleBar r10 = (OFloatingTitleBar) findViewById(R$id.toolbar);
        Category r11 = this.mCurrCategory;
        if (r11 == null) goto L5;
        String r12 = r11.getName();
    L6:
        this.mToolbarTitle = u.f(r10, r12);
        u.a(r10, this);
        u.c(r10, this);
        return r10;
    L5:
        r12 = "";
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        int r11 = r10.getId();
        if (r11 == R$id.appStatusLay) goto L17;
        if (r11 == R$id.search_hot_apps_status_view) goto L17;
        if (r11 != R$id.left_action_back) goto L11;
        onBackPressed();
        return;
    L11:
        if (r11 == R$id.toolbar_search) goto L13;
        return;
    L13:
        if (this.mIsFromNavigation == false) goto L15;
        com.bytedanceos.common.toolbox.e.n1(this, null, 0, "page_topic_navigation", 2);
        return;
    L15:
        com.bytedanceos.common.toolbox.e.n1(this, null, 0, "page_topic", 2);
        return;
    L17:
        if (com.bytedanceos.common.toolbox.e.g(this) == false) goto L20;
        return;
    L20:
        if (com.bytedanceos.common.toolbox.e.p0() == false) goto L27;
        operateApp((AppInfo) r10.getTag());
        return;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        getCache().addObserver(this);
        initData();
        setContentView(R$layout.category_list_activity);
        initBaseView();
        fetchData();
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mIsToDestroy = true;
        getCache().deleteObserver(this);
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
        showRefreshView();
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataSuccess(final int r10, int r11, final String r12, Object r13, final String r14) {
        if (acceptFetchData(r13) == true) goto L5;
        return;
    L5:
        runOnUiThread(new AnonymousClass1(this, r10, r12, r14));
    }

    @Override // java.util.Observer
    public void update(Observable r10, Object r11) {
        if (isActivityCanUpdate() == true) goto L5;
        return;
    L5:
        runOnUiThread(new AnonymousClass2(this));
    }

    private void refreshAppListView(RefreshLoadListView r10, AppList r11) {
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
        AppListView.updateListView(r10, r11);
        return;
    L12:
        if (r11.isEmpty() == false) goto L16;
        if (r12 != 1) goto L16;
        AppListView.setState(r10, 3);
    }
}
