package com.bytedanceos.common.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.jzvd.JzvdStd;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.eventbus.GameSubListEvent;
import com.bytedanceos.common.eventbus.LoginEvent;
import com.bytedanceos.common.eventbus.OnSubEvent;
import com.bytedanceos.common.eventbus.VideoStatusEvent;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.networkv2.data.GameSubListDataModel;
import com.bytedanceos.common.networkv2.entity.SubAppEntity;
import com.bytedanceos.common.toolbox.c;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.ui.GameSubDetailActivity;
import com.bytedanceos.common.ui.listener.KObserverManager;
import com.bytedanceos.common.ui.recycler.adapter.GameSubListAdapter;
import com.bytedanceos.common.ui.recycler.entity.AppItem;
import com.bytedanceos.common.ui.recycler.entity.BaseSubAppItem;
import com.bytedanceos.common.ui.recycler.entity.SubAppItem;
import com.bytedanceos.common.ui.recycler.entity.SubGroupAppItem;
import com.bytedanceos.common.ui.recycler.entity.SubVideoItem;
import com.bytedanceos.common.ui.recycler.listener.MultiViewWindowListener;
import com.bytedanceos.common.ui.utils.JzvdUtil;
import com.bytedanceos.common.ui.widget.SubButton;
import com.bytedanceos.common.ui.widget.TryCatchLinearLayoutManager;
import com.bytedanceos.common.ui.widget.oui.OUIAppStatusView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes2.dex */
public class GameSubListFragment extends BasicFragment implements View.OnClickListener, MultiViewWindowListener, OnItemClickListener, OnItemChildClickListener {
    private static final int MSG_SHOW_GUIDE_VIEW = 1;
    private GameSubListAdapter mAdapter;
    private KObserverManager<OUIAppStatusView> mAppObserverManager;
    private GameSubListDataModel mGameSubModel;
    private final Handler mHandler;
    private RecyclerView mRecyclerView;
    private View.OnClickListener mRetryListener;
    private View mRootView;
    private String mSourcePage;
    private JzvdStd mVideo;

    public GameSubListFragment() {
        this.mSourcePage = "tab_gamesubcribe";
        this.mHandler = new AnonymousClass1(this);
    }

    public static /* synthetic */ RecyclerView access$000(GameSubListFragment r10) {
        return r10.mRecyclerView;
    }

    public static /* synthetic */ void access$100(GameSubListFragment r10) {
        r10.requestGameSubList();
    }

    public static /* synthetic */ void i(OUIAppStatusView r10) {
        lambda$initListeners$0(r10);
    }

    private boolean isDataEmpty() {
        return c.a(this.mAdapter.getData());
    }

    private static /* synthetic */ void lambda$initListeners$0(OUIAppStatusView r10) {
        if (r10 == null) goto L7;
        Object r11 = r10.getTag();
        if ((r11 instanceof AppInfo) == false) goto L8;
        r10.updateDownloadStatus((AppInfo) r11);
        return;
    L8:
        return;
    }

    public static GameSubListFragment newInstance(String r10) {
        GameSubListFragment r11 = new GameSubListFragment();
        Bundle r12 = new Bundle();
        r12.putString("original_from", r10);
        r11.setArguments(r12);
        return r11;
    }

    private void onSubcribe(SubButton r10, SubAppEntity r11) {
        r10.setTrackInfo(r11);
        r10.setSubscriberManager(this);
        r10.setOnSubListener(new AnonymousClass3(this));
        r10.onSubClick();
    }

    private void requestGameSubList() {
        this.mGameSubModel.doQueryData();
        this.mIsRefresh = false;
    }

    private void showData(List r10, boolean r11) {
        hideStateView();
        this.mAdapter.setNewData(r10);
        HashMap r12 = new HashMap();
        r12.put("source", this.mSourcePage);
        d9.a.e().x("9025", r12);
        if (r11 == false) goto L6;
        showGuideView();
        return;
    }

    private void showGuideView() {
        this.mHandler.sendEmptyMessageDelayed(1, 300);
    }

    private void showLoadEmpty() {
        StateView.showEmptyView(this.mStateView, getString(R$string.subcribe_empty_msg), getString(R$string.subcribe_empty_desc), new int[]{R$drawable.subcribe_empty});
    }

    private void showLoadError() {
        StateView.showRefreshView(this.mStateView, this.mRetryListener);
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public String getCurrentTag() {
        return GameSubListFragment.class.getSimpleName();
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public String getPageSource() {
        return AdReportParam.ClickPosType.SKIP;
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public String getSourcePageName() {
        return getResources().getString(R$string.game_subcribe);
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public void initData() {
        Bundle r10 = getArguments();
        if (r10 == null) goto L5;
        this.mSourcePage = r10.getString("original_from", "tab_gamesubcribe");
    L5:
        this.mGameSubModel = new GameSubListDataModel(this);
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public void initListeners() {
        this.mAdapter.setOnViewWindowListener(this);
        this.mAdapter.setOnItemClickListener(this);
        this.mAdapter.setOnItemChildClickListener(this);
        this.mRetryListener = new AnonymousClass2(this);
        this.mAppObserverManager = new KObserverManager(getActivity(), new a());
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public void initViews() {
        this.mStateView = StateView.getStateView((LinearLayout) this.mRootView.findViewById(R$id.parent_view));
        showLoadingView();
        GameSubListAdapter r10 = new GameSubListAdapter(getContext(), Collections.synchronizedList(new ArrayList()));
        this.mAdapter = r10;
        r10.setSource(this.mSourcePage);
        RecyclerView r11 = (RecyclerView) this.mRootView.findViewById(R$id.recycler);
        this.mRecyclerView = r11;
        r11.setLayoutManager(new TryCatchLinearLayoutManager(getContext()));
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle r10) {
        super.onActivityCreated(r10);
        requestGameSubList();
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public boolean onBackPressed(boolean... r10) {
        d9.a.e().t(null, null, "back");
        return true;
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment, android.view.View.OnClickListener
    public void onClick(View r10) {
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        View r13 = r10.inflate(R$layout.fragment_game_subcribe, r11, false);
        this.mRootView = r13;
        return r13;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        JzvdUtil.onDestroy(this.mVideo, true);
        this.mVideo = null;
        this.mAppObserverManager.clear();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(OnSubEvent r10) {
        this.mIsRefresh = true;
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r10) {
        super.onHiddenChanged(r10);
        if (r10 == false) goto L6;
        JzvdUtil.onPause(this.mVideo);
        this.mHandler.removeMessages(1);
        return;
    L6:
        if (this.mIsRefresh == false) goto L8;
        requestGameSubList();
    L8:
        JzvdUtil.onResume(this.mVideo);
    }

    @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
    public void onItemChildClick(BaseQuickAdapter r10, View r11, int r12) {
        Object r13 = r10.getItem(r12);
        if ((r13 instanceof SubAppItem) == true) goto L13;
        if ((r13 instanceof SubGroupAppItem) == true) goto L13;
        if ((r13 instanceof AppItem) == true) goto L10;
        return;
    L10:
        if (r11.getId() != R$id.appStatusLay) goto L21;
        AppInfo r14 = ((AppItem) r13).getAppInfo();
        l8.a.a(getActivity(), r11, r14, this.mSourcePage);
        return;
    L21:
        return;
    L13:
        if (r11.getId() != R$id.btn_sub) goto L23;
        BaseSubAppItem r15 = (BaseSubAppItem) r13;
        SubButton r16 = (SubButton) r11;
        onSubcribe(r16, r15.getSubAppEntity());
        d9.a r17 = d9.a.e();
        SubAppEntity r18 = r15.getSubAppEntity();
        if (r16.isSubed() == false) goto L17;
        String r19 = "btn_reserved";
    L18:
        r17.t(r18, r15, r19);
        return;
    L17:
        r19 = "btn_reserve";
        goto L18
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(BaseQuickAdapter r10, View r11, int r12) {
        int r13 = R$string.game_subcribe;
        String r14 = getString(r13);
        Object r15 = r10.getItem(r12);
        if ((r15 instanceof SubVideoItem) == false) goto L6;
        SubVideoItem r16 = (SubVideoItem) r15;
        GameSubDetailActivity.start(getActivity(), r16.getSubVideoEntity(), null, r14);
        d9.a.e().t(r16.getSubVideoEntity(), r16, "top_video");
        return;
    L6:
        if ((r15 instanceof SubAppItem) == false) goto L9;
        SubAppItem r17 = (SubAppItem) r15;
        GameSubDetailActivity.start(getActivity(), r17.getSubAppEntity(), null, r14);
        d9.a.e().t(r17.getSubAppEntity(), r17, "game_info");
        return;
    L9:
        if ((r15 instanceof SubGroupAppItem) == false) goto L12;
        SubGroupAppItem r18 = (SubGroupAppItem) r15;
        GameSubDetailActivity.start(getActivity(), r18.getSubAppEntity(), null, r14);
        d9.a.e().t(r18.getSubAppEntity(), r18, "game_info");
        return;
    L12:
        if ((r15 instanceof AppItem) == false) goto L18;
        e.e1(getActivity(), ((AppItem) r15).getAppInfo(), 0, getString(r13));
        return;
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        JzvdUtil.onPause(this.mVideo);
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mIsRefresh == false) goto L6;
        requestGameSubList();
    L6:
        if (isVisible() == false) goto L9;
        JzvdUtil.onResume(this.mVideo);
        return;
    }

    @Override // com.bytedanceos.common.ui.recycler.listener.MultiViewWindowListener
    public void onViewAttachedToWindow(BaseViewHolder r10) {
        int r11 = r10.getItemViewType();
        if (r11 != 1) goto L5;
        this.mAppObserverManager.add((OUIAppStatusView) r10.getView(R$id.appStatusLay));
        return;
    L5:
        if (r11 != 3) goto L11;
        JzvdStd r12 = (JzvdStd) r10.getView(R$id.video);
        this.mVideo = r12;
        JzvdUtil.onResume(r12);
        return;
    }

    @Override // com.bytedanceos.common.ui.recycler.listener.MultiViewWindowListener
    public void onViewDetachedFromWindow(BaseViewHolder r10) {
        int r11 = r10.getItemViewType();
        if (r11 != 1) goto L5;
        this.mAppObserverManager.remove((OUIAppStatusView) r10.getView(R$id.appStatusLay));
        return;
    L5:
        if (r11 != 3) goto L11;
        JzvdStd r12 = (JzvdStd) r10.getView(R$id.video);
        this.mVideo = r12;
        JzvdUtil.onPause(r12);
        return;
    }

    @Override // com.bytedanceos.common.ui.fragment.BasicFragment
    public boolean userEventBus() {
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(LoginEvent r10) {
        this.mIsRefresh = true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(GameSubListEvent r10) {
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
        if (c.a(r10.getDataList()) == true) goto L13;
        showData(r10.getDataList(), r10.isHasSubscribe());
        return;
    L13:
        if (isDataEmpty() == false) goto L19;
        showLoadEmpty();
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(VideoStatusEvent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getVideoStatus() != 2) goto L8;
        JzvdUtil.onPause(this.mVideo);
        return;
    }
}
