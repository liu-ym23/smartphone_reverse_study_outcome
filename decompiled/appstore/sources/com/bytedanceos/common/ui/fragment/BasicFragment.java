package com.bytedanceos.common.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.networkv2.subscriber.ISubscriberManager;
import com.bytedanceos.common.networkv2.subscriber.NSubscriber;
import com.bytedanceos.common.ui.dialog.AddCommentDialog;
import com.bytedanceos.common.utils.u;
import java.util.ArrayList;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasicFragment extends Fragment implements View.OnClickListener, ISubscriberManager {
    public AddCommentDialog mAddCommentDialog;
    protected Context mContext;
    public int mCurrTabIndex;
    public boolean mIsAnimating;
    protected boolean mIsRefresh;
    private ArrayList<NSubscriber> mNSubscriberList;
    protected ViewGroup mStateView;

    public BasicFragment() {
        this.mIsRefresh = false;
        this.mCurrTabIndex = 0;
        this.mIsAnimating = false;
        this.mAddCommentDialog = null;
    }

    @Override // com.bytedanceos.common.networkv2.subscriber.ISubscriberManager
    public NSubscriber addNSubscriber(NSubscriber r10) {
        ArrayList<NSubscriber> r11 = this.mNSubscriberList;
        if (r11 == null) goto L5;
        r11.add(r10);
    L5:
        return r10;
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        return getActivity();
    }

    public abstract String getCurrentTag();

    public String getPageSource() {
        return AdReportParam.ClickPosType.SKIP;
    }

    public String getSourcePageName() {
        return "";
    }

    public int getState() {
        return 0;
    }

    public ViewGroup getStateVisibleView(ViewGroup r10) {
        if (r10 == null) goto L7;
        if (r10.getVisibility() != 0) goto L7;
        return r10;
    L7:
        return this.mStateView;
    }

    public void hideStateView() {
        if (isStateViewVisible() == false) goto L6;
        this.mStateView.setVisibility(8);
        return;
    }

    public void initData() {
        this.mNSubscriberList = new ArrayList();
    }

    public void initListeners() {
    }

    public void initViews() {
    }

    public boolean isStateViewVisible() {
        ViewGroup r10 = this.mStateView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getVisibility() != 0) goto L7;
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle r10) {
        super.onActivityCreated(r10);
        if (userEventBus() == false) goto L5;
        EventBus.getDefault().register(this);
    L5:
        this.mContext = getActivity();
        if (r10 != null) goto L8;
        updateTitleBar();
    L8:
        initData();
        initViews();
        initListeners();
    }

    public boolean onBackPressed(boolean... r10) {
        return false;
    }

    public void onButtonClick(int r10, int r11, boolean r12, Bundle r13) {
    }

    public void onClick(View r10) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle r10) {
        super.onCreate(r10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (userEventBus() == false) goto L5;
        EventBus.getDefault().unregister(this);
    L5:
        ArrayList<NSubscriber> r10 = this.mNSubscriberList;
        if (r10 == null) goto L20;
        Iterator<NSubscriber> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L13;
        NSubscriber r12 = r11.next();
        if (r12 == null) goto L9;
        r12.unsubscribe();
        goto L9
    L13:
        this.mNSubscriberList.clear();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r10) {
        super.onHiddenChanged(r10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(Bundle r10) {
        super.setArguments(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void showLoadingView() {
        StateView.showLoadingView(this.mStateView);
    }

    public void showLoginView() {
    }

    public void showNoLoginAlertDialog(int r10, boolean r11) {
    }

    public void showRefreshView() {
        StateView.showRefreshView(this.mStateView, this);
    }

    public boolean updateTitleBar() {
        return u.g(getActivity());
    }

    public boolean userEventBus() {
        return false;
    }

    public void showNoLoginAlertDialog(int r10) {
        showNoLoginAlertDialog(r10, true);
    }
}
