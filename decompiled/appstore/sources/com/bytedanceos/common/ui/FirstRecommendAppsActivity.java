package com.bytedanceos.common.ui;

import android.content.Intent;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.core.ui.presenter.IView;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.networkv2.data.FirstReCommendListModel;
import com.bytedanceos.common.networkv2.entity.EmptyEntity;
import com.bytedanceos.common.networkv2.entity.FirstRecommendBannerEntity;
import com.bytedanceos.common.networkv2.entity.FirstRecommendDescEntity;
import com.bytedanceos.common.toolbox.SizeConverter;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.toolbox.s;
import com.bytedanceos.common.ui.fragment.StateView;
import com.bytedanceos.common.ui.recycler.binder.FirstRecommendAppsBinder;
import com.bytedanceos.common.ui.recycler.binder.FirstRecommendDescBinder;
import com.bytedanceos.common.ui.recycler.binder.FirstRecommendDividerBinder;
import com.bytedanceos.common.ui.recycler.binder.FirstRecommendHeaderBinder;
import com.drakeet.multitype.MultiTypeAdapter;
import com.obric.oui.actionbar.OBottomActionBar;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FirstRecommendAppsActivity extends BaseActivity implements IView<List, String> {
    public static final int APP_SPAN_COUNT_FULL = 4;
    public static final int APP_SPAN_COUNT_ONE = 1;
    private static final int CHECK_TYPE_CHECKED = 1;
    private static final int CHECK_TYPE_UNCHECKED = 0;
    private static final int INSTALL_STATE_NETWORK = 0;
    private static final int INSTALL_STATE_SELECT = 1;
    private static final int INSTALL_TYPE_MOBILE = 1;
    private static final int INSTALL_TYPE_WIFI = 0;
    protected static final int MSG_STATUS_DOWNLOADING = 16;
    protected static final int MSG_STATUS_FAILED = 18;
    protected static final int MSG_STATUS_SUCCESS = 17;
    private static final int VIEW_STATE_DEFAULT = 0;
    private static final int VIEW_STATE_DONE = 1;
    private static final int VIEW_STATE_ERROR = 2;
    private MultiTypeAdapter mAdapter;
    private List<AppInfo> mAppInfoList;
    private OBottomActionBar mBtnInstall;
    private OCheckBox mCheckboxAutoUpdate;
    private ViewGroup mContentView;
    private FirstReCommendListModel mListModel;
    private RecyclerView mRecyclerView;
    private ViewGroup mStateView;

    public FirstRecommendAppsActivity() {
    }

    public static /* synthetic */ MultiTypeAdapter access$000(FirstRecommendAppsActivity r10) {
        return r10.mAdapter;
    }

    public static /* synthetic */ void access$100(FirstRecommendAppsActivity r10, int r11) {
        r10.uiChangeByInstallStateType(r11);
    }

    private void downloadApps() {
        NetworkInfo r10 = com.bytedanceos.common.toolbox.e.t();
        if (r10 != null) goto L5;
    L7:
        if (r10 != null) goto L9;
    L14:
        e0.e(R$string.retry_connection);
        return;
    L9:
        if (r10.getType() != 0) goto L14;
        String r11 = SizeConverter.BTrim.convert(getDownloadedAppsSize(this.mAppInfoList));
        View r12 = LayoutInflater.from(this).inflate(R$layout.dialog_mobile_tip, null);
        ((TextView) r12.findViewById(R$id.total_flow)).setText(getString(R$string.alert_dataflow_message, new Object[]{r11}));
        CheckBox r13 = (CheckBox) r12.findViewById(R$id.check_record);
        jumpToMainActivity(true);
        if (r13.isChecked() == false) goto L13;
        executeUpdateAll(false, 2);
        return;
    L13:
        executeUpdateAll(false, 1);
        return;
    L5:
        if (r10.getType() != 1) goto L7;
        jumpToMainActivity(true);
        executeUpdateAll(false, 0);
    }

    private void executeUpdateAll(final boolean r10, final int r11) {
        new Thread(new g(this, r10, r11)).start();
        com.bytedanceos.common.toolbox.j.e("finish welcomeActivity.");
        finish();
    }

    @NonNull
    private GridLayoutManager getGridLayoutManager() {
        GridLayoutManager r10 = new GridLayoutManager(this, 4);
        r10.R(new AnonymousClass2(this));
        return r10;
    }

    private void install() {
        openAutoUpdateInWiFI();
        if (this.mAppInfoList.isEmpty() == false) goto L5;
        return;
    L5:
        s.w(this);
        downloadApps();
    }

    private /* synthetic */ void lambda$addContentView$0() {
        uiChangeByInstallStateType(1);
    }

    private /* synthetic */ void lambda$addContentView$1(View r10, int r11) {
        install();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$executeUpdateAll$2(boolean r10, int r11) {
        if (r10 == false) goto L4;
    L6:
        boolean r12 = 0;
    L7:
        JSONArray r13 = new JSONArray();
        JSONArray r14 = new JSONArray();
        Iterator<AppInfo> r15 = this.mAppInfoList.iterator();
    L9:
        if (r15.hasNext() == false) goto L15;
        AppInfo r16 = r15.next();
        downloadApp(r16, r12, r10);
        r13.put(r16.itemPosition);     // Catch: Exception -> L13
        r14.put(r16.appPackageName);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L15:
        boolean r17 = this.mCheckboxAutoUpdate.isChecked();
        d9.a.e().s(r13, r14, !r12, r17 ? 1 : 0);
        setLastDay(r11, r12);
        return;
    L4:
        if (com.bytedanceos.common.toolbox.e.I0() == true) goto L6;
        r12 = 1;
        goto L7
    }

    private void openAutoUpdateInWiFI() {
        Intent r10 = new Intent("com.bytedance.appstore.autoupdate.switch");
        r10.putExtra("isChecked", this.mCheckboxAutoUpdate.isChecked());
        r10.setPackage(getPackageName());
        BaseApplication.c().startService(r10);
    }

    private void refreshView(int r10) {
        switch(r10) {
            case 16: goto L6;
            case 17: goto L5;
            case 18: goto L4;
            default: goto L10;
        };
    L4:
        StateView.showRefreshView(this.mStateView, this);
        return;
    L5:
        this.mStateView.setVisibility(8);
        setViewState(1);
        return;
    L6:
        StateView.showLoadingView(this.mStateView);
        return;
    }

    public static /* synthetic */ void s(FirstRecommendAppsActivity r10, boolean r11, int r12) {
        r10.lambda$executeUpdateAll$2(r11, r12);
    }

    private void setViewState(int r10) {
        if (r10 != 0) goto L5;
        this.mRecyclerView.setVisibility(4);
        this.mBtnInstall.setEnabled(true);
        this.mBtnInstall.setVisibility(0);
        return;
    L5:
        if (r10 != 1) goto L8;
        this.mRecyclerView.setVisibility(0);
        this.mBtnInstall.setEnabled(true);
        this.mBtnInstall.setVisibility(0);
        return;
    L8:
        if (r10 != 2) goto L13;
        this.mRecyclerView.setVisibility(4);
        this.mBtnInstall.setEnabled(false);
        return;
    }

    public static /* synthetic */ void t(FirstRecommendAppsActivity r10) {
        r10.lambda$addContentView$0();
    }

    public static /* synthetic */ void u(FirstRecommendAppsActivity r10, View r11, int r12) {
        r10.lambda$addContentView$1(r11, r12);
    }

    private void uiChangeByInstallStateType(int r10) {
        if (r10 != 1) goto L5;
        uiChangeBySelect();
    L5:
        NetworkInfo r11 = com.bytedanceos.common.toolbox.e.t();
        OButton r12 = this.mBtnInstall.c(0);
        if (r12 != null) goto L9;
        return;
    L9:
        if (r11 != null) goto L11;
    L13:
        r12.setText(getString(R$string.welcome_wifi_install) + "（" + this.mAppInfoList.size() + "）");
        return;
    L11:
        if (r11.getType() != 1) goto L13;
        r12.setText(getString(R$string.install) + "（" + this.mAppInfoList.size() + "）");
    }

    private void uiChangeBySelect() {
        if (this.mAppInfoList.size() != 0) goto L5;
        this.mBtnInstall.setEnabled(false);
        return;
    L5:
        this.mBtnInstall.setEnabled(true);
        this.mBtnInstall.setVisibility(0);
    }

    @Override // com.bytedanceos.common.ui.BaseActivity
    public void addContentView(RelativeLayout r10) {
        this.mContentView = (ViewGroup) View.inflate(this, R$layout.welcome, r10);
        this.mRecyclerView = (RecyclerView) findViewById(R$id.recyclerView);
        this.mBtnInstall = (OBottomActionBar) findViewById(R$id.btn_install);
        this.mCheckboxAutoUpdate = (OCheckBox) findViewById(R$id.checkbox_auto_update);
        GridLayoutManager r11 = getGridLayoutManager();
        this.mRecyclerView.setLayoutManager(r11);
        this.mRecyclerView.addItemDecoration(new AnonymousClass1(this));
        this.mAppInfoList = new ArrayList();
        this.mAdapter = new MultiTypeAdapter();
        FirstRecommendAppsBinder r12 = new FirstRecommendAppsBinder(this.mAppInfoList);
        r12.setItemClickListener(new h(this));
        this.mAdapter.e(FirstRecommendBannerEntity.class, new FirstRecommendHeaderBinder());
        this.mAdapter.e(FirstRecommendDescEntity.class, new FirstRecommendDescBinder());
        this.mAdapter.e(AppInfo.class, r12);
        this.mAdapter.e(EmptyEntity.class, new FirstRecommendDividerBinder());
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mBtnInstall.setBottomButtonClickListener(new i(this));
    }

    public abstract void createNetworkPromptDialog();

    public abstract void downloadApp(AppInfo r10, boolean r11, boolean r12);

    public void fetchReCommendListData() {
        refreshView(16);
        this.mListModel.getFirstReCommendList();
        d9.a.e().P("9000");
    }

    public String getAppInfoTag(AppInfo r10) {
        StringBuilder r11 = new StringBuilder();
        if (r10 == null) goto L6;
        r11.append("pkg_name");
        r11.append(",");
        r11.append(r10.appPackageName);
        r11.append(";");
        r11.append("source_page");
        r11.append(",");
        r11.append("9000");
        r11.append(";");
        r11.append(DownloadInfoColumns.APP_SOURCE);
        r11.append(",");
        r11.append(AdReportParam.ClickPosType.SKIP);
        r11.append(";");
        r11.append("download_sign");
        r11.append(",");
        r11.append(AdReportParam.ClickPosType.SKIP);
        r11.append(";");
        r11.append("source_position");
        r11.append(",");
        r11.append(r10.itemPosition);
    L6:
        return r11.toString();
    }

    public abstract long getDownloadedAppsSize(List<AppInfo> r10);

    public abstract Class getMainActivityClass();

    public void jumpToMainActivity(boolean r10) {
        Intent r11 = new Intent(this, getMainActivityClass());
        Intent r12 = getIntent();
        if (r12 == null) goto L16;
        Bundle r13 = r12.getBundleExtra("original_extra");
        if (r13 == null) goto L15;
        String r14 = r13.getString("original_action");
        if (TextUtils.isEmpty(r14) == true) goto L9;
        r11.setAction(r14);
    L9:
        String r15 = r13.getString("original_type");
        if (TextUtils.isEmpty(r14) == true) goto L12;
        r11.setType(r15);
    L12:
        String r16 = r13.getString("original_data");
        if (TextUtils.isEmpty(r16) == true) goto L15;
        r11.setData(Uri.parse(r16));
    L15:
        r11.putExtras(r12);
    L16:
        startActivity(r11);
        if (r10 == false) goto L19;
        overridePendingTransition(R$anim.slide_in_from_right, R$anim.slide_out_to_left);
        return;
    L19:
        overridePendingTransition(R$anim.pop_up_in, R$anim.fake_anim);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.CommonConfirmDialog.DialogOnClickListener
    public void onButtonClick(int r10, int r11, boolean r12, Bundle r13) {
        if (r11 != (-2)) goto L5;
    L8:
        finish();
        return;
    L5:
        if (r11 == 4) goto L8;
        s.u(this);
        fetchReCommendListData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        int r11 = r10.getId();
        if (r11 != R$id.oui_id_cancel) goto L6;
        openAutoUpdateInWiFI();
        s.w(this);
        jumpToMainActivity(true);
        d9.a.e().n("0021");
        d9.a.e().r(this.mCheckboxAutoUpdate.isChecked() ? 1 : 0);
        finish();
        return;
    L6:
        if (r11 != R$id.refresh_btn) goto L8;
        fetchReCommendListData();
        return;
    L8:
        com.bytedanceos.common.toolbox.j.a("unknown view:" + r10);
    }

    @Override // com.bytedanceos.common.ui.BaseActivity, com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        this.mStateView = StateView.getStateView(this.mContentView);
        setViewState(0);
        setOnNetworkChangedListener(new AnonymousClass3(this));
        this.mListModel = new FirstReCommendListModel(this, this.mAppInfoList);
        if (s.d(this) == true) goto L5;
        createNetworkPromptDialog();
        return;
    L5:
        fetchReCommendListData();
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d9.a.e().c();
        FirstReCommendListModel r10 = this.mListModel;
        if (r10 == null) goto L6;
        r10.onDestroy();
        return;
    }

    @Override // com.bytedanceos.common.core.ui.presenter.IView
    public void onRequestError(Throwable r10) {
        if (isDestroyed() == false) goto L6;
        com.bytedanceos.common.toolbox.j.a("activity has destroyed");
        return;
    L6:
        e0.g(com.bytedanceos.common.utils.k.d(this, r10));
        setViewState(2);
        refreshView(18);
    }

    @Override // com.bytedanceos.common.core.ui.presenter.IView
    public /* bridge */ /* synthetic */ void onUpdateView(int r10, List r11, String r12) {
        onUpdateView2(r10, r11, r12);
    }

    public abstract void setLastDay(int r10, boolean r11);

    @Override // com.bytedanceos.common.ui.BaseActivity
    public void updateHeaderView() {
        this.mTitleBar.setTitleText(getText(R$string.title_recommended_apps).toString());
        this.mCancelBtn.setText(R$string.btn_jump);
    }

    /* JADX INFO: renamed from: onUpdateView, reason: avoid collision after fix types in other method */
    public void onUpdateView2(int r10, List r11, String r12) {
        refreshView(17);
        uiChangeByInstallStateType(1);
        this.mAdapter.h(r11);
        this.mAdapter.notifyDataSetChanged();
        com.bytedanceos.common.toolbox.j.a("onUpdateView");
    }
}
