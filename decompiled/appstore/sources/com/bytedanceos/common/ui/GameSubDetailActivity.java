package com.bytedanceos.common.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.eventbus.GameSubDetailEvent;
import com.bytedanceos.common.eventbus.LoginEvent;
import com.bytedanceos.common.networkv2.data.GameSubDetailDataModel;
import com.bytedanceos.common.networkv2.entity.Head;
import com.bytedanceos.common.networkv2.entity.SubAppEntity;
import com.bytedanceos.common.ui.dialog.ReserveGameDialog;
import com.bytedanceos.common.ui.fragment.StateView;
import com.bytedanceos.common.ui.listener.KObserverManager;
import com.bytedanceos.common.ui.recycler.adapter.GameSubDetailAdapter;
import com.bytedanceos.common.ui.recycler.listener.MultiViewWindowListener;
import com.bytedanceos.common.ui.utils.JzvdUtil;
import com.bytedanceos.common.ui.widget.AppGroupView;
import com.bytedanceos.common.ui.widget.SubButton;
import com.bytedanceos.common.ui.widget.TryCatchLinearLayoutManager;
import com.bytedanceos.common.utils.u;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes2.dex */
public class GameSubDetailActivity extends StatusBarActivity implements View.OnClickListener, MultiViewWindowListener, SubButton.OnSubListener {
    private static boolean mLock = false;
    private GameSubDetailAdapter mAdapter;
    private KObserverManager<AppGroupView> mAppGroupObserverManager;
    private RecyclerView mRecyclerView;
    private View.OnClickListener mRetryListener;
    private ViewGroup mStateView;
    private SubAppEntity mSubAppEntity;
    private SubButton mSubBtn;
    private GameSubDetailDataModel mSubInfoModel;
    private OButton mToolbarBack;
    private OButton mToolbarSraech;
    private JzvdStd mVideo;
    private Jzvd.ListenerAdapter mVideoListener;

    static {
    }

    public GameSubDetailActivity() {
    }

    public static /* synthetic */ void access$000(GameSubDetailActivity r10) {
        r10.requestGameSubInfo();
    }

    public static /* synthetic */ RecyclerView access$100(GameSubDetailActivity r10) {
        return r10.mRecyclerView;
    }

    private void hideStateView() {
        if (isStateViewVisible() == false) goto L6;
        this.mStateView.setVisibility(8);
        return;
    }

    private void initContentView() {
        ViewGroup r10 = StateView.getStateView((ViewGroup) findViewById(R$id.layout_content));
        this.mStateView = r10;
        StateView.showLoadingView(r10);
        this.mAdapter = new GameSubDetailAdapter(this, Collections.synchronizedList(new ArrayList()));
        RecyclerView r11 = (RecyclerView) findViewById(R$id.recycler);
        this.mRecyclerView = r11;
        r11.setLayoutManager(new TryCatchLinearLayoutManager(this));
        this.mRecyclerView.setAdapter(this.mAdapter);
        SubButton r12 = (SubButton) findViewById(R$id.btn_sub);
        this.mSubBtn = r12;
        int r13 = R$string.subcribe_now;
        r12.setText(r13);
        this.mSubBtn.setSubText(getString(r13), null);
        this.mSubBtn.setId(this.mSubAppEntity.getId());
    }

    private boolean initData() {
        if (getIntent() != null) goto L14;
        return false;
    L14:
        this.mSubAppEntity = (SubAppEntity) getIntent().getParcelableExtra("original_data");     // Catch: Exception -> L7
    L10:
        if (this.mSubAppEntity != null) goto L12;
        return false;
    L12:
        GameSubDetailDataModel r10 = new GameSubDetailDataModel(this);
        this.mSubInfoModel = r10;
        r10.setId(this.mSubAppEntity.getId());
        this.mSubInfoModel.setPageSource("1");
        this.mAppGroupObserverManager = new KObserverManager(this, new AnonymousClass1(this));
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    private void initListener() {
        this.mRetryListener = new AnonymousClass2(this);
        this.mAdapter.setOnViewWindowListener(this);
        this.mAdapter.setPagerClickListener(new AnonymousClass3(this));
        this.mSubBtn.setOnSubListener(this);
        this.mVideoListener = new AnonymousClass4(this);
    }

    private void initView() {
        setContentView(R$layout.activity_game_sub_detail);
        initContentView();
    }

    private boolean isDataEmpty() {
        return com.bytedanceos.common.toolbox.c.a(this.mAdapter.getData());
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

    private void requestGameSubInfo() {
        this.mSubInfoModel.doQueryData();
        this.mIsRefresh = false;
    }

    private void showData(SubAppEntity r10, List<MultiItemEntity> r11, boolean r12) {
        hideStateView();
        if (r12 == false) goto L5;
        this.mAdapter.setNewData(r11);
    L6:
        if (r10 == null) goto L9;
        this.mSubAppEntity = r10;
        this.mSubBtn.setSubcirbe(r10.isSubcribed());
        this.mSubBtn.setTrackInfo(this.mSubAppEntity);
        return;
    L9:
        return;
    L5:
        this.mAdapter.addData(r11);
        goto L6
    }

    private void showLoadEmpty() {
        StateView.showEmptyView(this.mStateView, getString(R$string.subcribe_empty_msg), getString(R$string.subcribe_empty_desc), new int[]{R$drawable.subcribe_empty});
    }

    private void showLoadError() {
        StateView.showRefreshView(this.mStateView, this.mRetryListener);
    }

    public static void start(Activity r10, String r11) {
        SubAppEntity r12 = new SubAppEntity();
        r12.setId(r11);
        start(r10, r12);
    }

    @Override // com.bytedanceos.common.ui.BasicActivity
    public String getSourcePage() {
        return AdReportParam.ClickPosType.SKIP;
    }

    @Override // com.bytedanceos.common.ui.BasicActivity
    public String getSourcePageName() {
        return getResources().getString(R$string.game_sub_detail_page);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public View initHeaderView() {
        OFloatingTitleBar r10 = (OFloatingTitleBar) findViewById(R$id.toolbar);
        u.d(r10);
        r10.k(R$drawable.oui_title_bar_back, -1, new AnonymousClass5(this));
        r10.k(R$drawable.oui_title_bar_search, -1, new AnonymousClass6(this));
        return r10;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (Jzvd.backPress() == true) goto L6;
        super.onBackPressed();
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        int r11 = r10.getId();
        if (r11 != R$id.toolbar_search) goto L6;
        com.bytedanceos.common.toolbox.e.n1(this, null, 0, "page_game_subcribe_detail", 2);
        return;
    L6:
        if (r11 != R$id.left_action_back) goto L10;
        onBackPressed();
        return;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (initData() == true) goto L6;
        StateView.showEmptyView(this.mStateView, getString(R$string.topic_empty_msg), "", new int[]{R$drawable.buy_empty});
        return;
    L6:
        initView();
        initListener();
        requestGameSubInfo();
        mLock = false;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        mLock = false;
        JzvdUtil.onDestroy(this.mVideo);
        this.mVideo = null;
        this.mAppGroupObserverManager.clear();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(GameSubDetailEvent r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.errorType != 1) goto L11;
        if (isDataEmpty() == false) goto L18;
        showLoadError();
        return;
    L18:
        return;
    L11:
        if (com.bytedanceos.common.toolbox.c.a(r10.getDataList()) == true) goto L13;
        showData(r10.getSubAppEntity(), r10.getDataList(), r10.isFirstRefresh());
        return;
    L13:
        if (isDataEmpty() == false) goto L19;
        showLoadEmpty();
        return;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        JzvdUtil.onPause(this.mVideo);
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mIsRefresh == false) goto L5;
        requestGameSubInfo();
    L5:
        JzvdUtil.onResume(this.mVideo);
    }

    @Override // com.bytedanceos.common.ui.widget.SubButton.OnSubListener
    public boolean onSubClick(SubButton r10, boolean r11) {
        if (r11 == false) goto L5;
        return true;
    L5:
        new ReserveGameDialog(this).showAbandonDialog(r10);
        return false;
    }

    @Override // com.bytedanceos.common.ui.widget.SubButton.OnSubListener
    public void onSubFail(SubButton r10, Head r11) {
    }

    @Override // com.bytedanceos.common.ui.widget.SubButton.OnSubListener
    public void onSubSuccess(SubButton r10, boolean r11) {
        if (r11 == false) goto L5;
        new ReserveGameDialog(this).showReserveDialog();
        return;
    }

    @Override // com.bytedanceos.common.ui.recycler.listener.MultiViewWindowListener
    public void onViewAttachedToWindow(BaseViewHolder r10) {
        int r11 = r10.getItemViewType();
        if (r11 != 3) goto L5;
        JzvdStd r12 = (JzvdStd) r10.getView(R$id.video);
        this.mVideo = r12;
        JzvdUtil.onResume(r12);
        this.mVideo.setListener(this.mVideoListener);
        return;
    L5:
        if (r11 != 10) goto L11;
        this.mAppGroupObserverManager.add((AppGroupView) r10.getView(R$id.group_view));
        return;
    }

    @Override // com.bytedanceos.common.ui.recycler.listener.MultiViewWindowListener
    public void onViewDetachedFromWindow(BaseViewHolder r10) {
        int r11 = r10.getItemViewType();
        if (r11 != 3) goto L5;
        JzvdStd r12 = (JzvdStd) r10.getView(R$id.video);
        this.mVideo = r12;
        JzvdUtil.onPause(r12);
        this.mVideo.setListener(null);
        return;
    L5:
        if (r11 != 10) goto L11;
        this.mAppGroupObserverManager.remove((AppGroupView) r10.getView(R$id.group_view));
        return;
    }

    @Override // com.bytedanceos.common.ui.BasicActivity
    public boolean userEventBus() {
        return true;
    }

    public static void start(Activity r10, SubAppEntity r11) {
        start(r10, r11, null, null);
    }

    public static void start(Activity r10, SubAppEntity r11, String r12, String r13) {
        if (mLock == false) goto L5;
        return;
    L5:
        mLock = true;
        Intent r14 = new Intent(r10, GameSubDetailActivity.class);
        r14.putExtra("original_data", r11);
        if (TextUtils.isEmpty(r12) == true) goto L9;
        r14.putExtra("original_from", r12);
    L9:
        if (TextUtils.isEmpty(r13) == true) goto L11;
        r14.putExtra("original_back_info", r13);
    L11:
        r10.startActivity(r14);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(LoginEvent r10) {
        this.mIsRefresh = true;
    }
}
