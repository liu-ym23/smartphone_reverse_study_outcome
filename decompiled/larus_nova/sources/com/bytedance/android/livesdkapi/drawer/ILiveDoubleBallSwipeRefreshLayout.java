package com.bytedance.android.livesdkapi.drawer;

import android.view.ViewGroup;
import com.alipay.sdk.m.x.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/drawer/ILiveDoubleBallSwipeRefreshLayout;", "", "getView", "Landroid/view/ViewGroup;", "isRefreshing", "", "setEnabledPull", "", "enable", "setOnRefreshListener", "listener", "Lcom/bytedance/android/livesdkapi/drawer/ILiveDoubleBallSwipeRefreshLayout$OnRefreshListener;", "setRefreshing", "refreshing", "OnRefreshListener", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveDoubleBallSwipeRefreshLayout {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/drawer/ILiveDoubleBallSwipeRefreshLayout$OnRefreshListener;", "", d.f25926p, "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnRefreshListener {
        void onRefresh();
    }

    ViewGroup getView();

    boolean isRefreshing();

    void setEnabledPull(boolean r100);

    void setOnRefreshListener(OnRefreshListener r100);

    void setRefreshing(boolean r100);
}
