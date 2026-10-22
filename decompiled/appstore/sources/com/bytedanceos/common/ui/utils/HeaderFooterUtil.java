package com.bytedanceos.common.ui.utils;

import android.view.View;
import com.bytedanceos.common.toolbox.DeviceType;
import com.bytedanceos.common.view.RecyclerviewCompat;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class HeaderFooterUtil {
    private static final int STATE_DEFAULT = -1;
    private static final int STATE_LOADING = 1;
    private static final int STATE_PREPARE = 0;
    private static final int STATE_RETRY = 2;
    private boolean hasFooterAdded;
    private boolean hasHeaderAdded;
    private boolean hasLoadMoreAdded;
    private boolean hasSpaceViewAdded;
    private boolean isFooterEnable;
    private boolean isHeaderEnable;
    private boolean isLoadMoreEnable;
    private RecyclerViewEngine mEngine;
    private FooterUtil mFooterUtil;
    private HeaderUtil mHeaderUtil;
    private LoadListener mListener;
    private int mLoadState;
    private LoadUtil mLoadUtil;

    public interface LoadListener {
        void loadOrRetry(boolean r10);
    }

    private HeaderFooterUtil(RecyclerViewEngine r10, LoadUtil r11, FooterUtil r12, HeaderUtil r13) {
        boolean r14 = false;
        this.hasFooterAdded = false;
        this.hasHeaderAdded = false;
        this.hasLoadMoreAdded = false;
        this.hasSpaceViewAdded = false;
        this.mLoadState = -1;
        Objects.requireNonNull(r10, "TangramEngine must not be null");
        this.mEngine = r10;
        this.mLoadUtil = r11;
        this.mFooterUtil = r12;
        this.mHeaderUtil = r13;
        if (r12 == null) goto L5;
        boolean r15 = true;
    L6:
        this.isFooterEnable = r15;
        if (r13 == null) goto L9;
        r14 = true;
    L9:
        this.isHeaderEnable = r14;
        this.isLoadMoreEnable = r15;
        addHeader();
        return;
    L5:
        r15 = false;
        goto L6
    }

    private void addFooter() {
        if (this.isFooterEnable == true) goto L5;
        return;
    L5:
        if (this.hasFooterAdded == true) goto L9;
        this.mFooterUtil.addFooter();
        this.hasFooterAdded = true;
        return;
    }

    private void addHeader() {
        if (this.isHeaderEnable == true) goto L5;
        return;
    L5:
        if (this.hasHeaderAdded == true) goto L9;
        this.mHeaderUtil.addHeader();
        this.hasHeaderAdded = true;
        initHeader();
        return;
    }

    private View getHeaderView() {
        return this.mHeaderUtil.getHeaderBouncyView();
    }

    private void hideNoMore() {
        addFooter();
        if (this.isFooterEnable == true) goto L5;
        return;
    L5:
        if (this.hasFooterAdded == false) goto L11;
        FooterUtil r10 = this.mFooterUtil;
        if (r10 == null) goto L12;
        r10.hideTips();
        return;
    L12:
        return;
    }

    private boolean isFullFilled() {
        if (getLastVisiblePosition() != (this.mEngine.getAdapter().getItemCount() - 1)) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isLoadMoreVisible() {
        int r10 = this.mEngine.getLayoutManager().findLastVisibleItemPosition();
        if (r10 >= 0) goto L5;
        return false;
    L5:
        if (this.isLoadMoreEnable == true) goto L7;
        return false;
    L7:
        if (this.mEngine.getAdapter().getItemViewType(r10) != 104) goto L12;
        return true;
    L12:
        return false;
    }

    public static HeaderFooterUtil newFooterUtil(RecyclerViewEngine r10) {
        return new HeaderFooterUtil(r10, null, new FooterUtil(r10), null);
    }

    public static HeaderFooterUtil newHeaderFooterUtil(RecyclerViewEngine r10) {
        return new HeaderFooterUtil(r10, new LoadUtil(r10), new FooterUtil(r10), new HeaderUtil(r10));
    }

    public static HeaderFooterUtil newHeaderUtil(RecyclerViewEngine r10) {
        return new HeaderFooterUtil(r10, null, null, new HeaderUtil(r10));
    }

    private void onLoad() {
        if (this.mLoadState == 1) goto L5;
        this.mLoadState = 1;
    L5:
        showLoading();
        LoadListener r10 = this.mListener;
        if (r10 == null) goto L9;
        r10.loadOrRetry(true);
        return;
    }

    private void onRetry() {
        if (this.mLoadState == 1) goto L5;
        this.mLoadState = 1;
    L5:
        showLoading();
        LoadListener r10 = this.mListener;
        if (r10 == null) goto L9;
        r10.loadOrRetry(false);
        return;
    }

    private void removeFooter() {
        if (this.isFooterEnable == true) goto L5;
        return;
    L5:
        if (this.hasFooterAdded == false) goto L9;
        this.mFooterUtil.removeFooter();
        this.hasFooterAdded = false;
        return;
    }

    private void removeHeader() {
        if (this.isHeaderEnable == true) goto L5;
        return;
    L5:
        if (this.hasHeaderAdded == false) goto L9;
        this.mHeaderUtil.removeHeader();
        this.mEngine.getRecyclerView().scrollToPosition(0);
        this.hasHeaderAdded = false;
        return;
    }

    private void removeLoadMoreView() {
        if (this.isLoadMoreEnable == true) goto L5;
        return;
    L5:
        if (this.hasLoadMoreAdded == false) goto L9;
        this.mLoadUtil.removeLoadItem();
        this.hasLoadMoreAdded = false;
        return;
    }

    private void showLoadRetry() {
        removeFooter();
        if (this.isLoadMoreEnable == false) goto L8;
        LoadUtil r10 = this.mLoadUtil;
        if (r10 == null) goto L9;
        r10.showRetryView();
        this.hasLoadMoreAdded = true;
        return;
    L9:
        return;
    }

    private void showLoading() {
        removeFooter();
        if (this.isLoadMoreEnable == false) goto L8;
        LoadUtil r10 = this.mLoadUtil;
        if (r10 == null) goto L9;
        r10.showLoadingView();
        this.hasLoadMoreAdded = true;
        return;
    L9:
        return;
    }

    private void showNoMoreFooter() {
        addFooter();
        if (this.isFooterEnable == true) goto L5;
        return;
    L5:
        if (this.hasFooterAdded == false) goto L11;
        FooterUtil r10 = this.mFooterUtil;
        if (r10 == null) goto L12;
        r10.showTips();
        return;
    L12:
        return;
    }

    public void addSpaceViewIfNeeded() {
        if (this.hasSpaceViewAdded == false) goto L5;
        return;
    L5:
        if (isFullFilled() == false) goto L7;
        return;
    L7:
        if (getHeaderBottom() >= 0) goto L12;
        if (getFooterTop() >= 0) goto L12;
        return;
    L12:
        if (getFooterView() != null) goto L14;
        View r10 = getHeaderView();
    L15:
        int r11 = ((RecyclerviewCompat) r10.getParent()).getHeight();
        int r12 = 0;
        if (getFooterView() != null) goto L18;
        int r13 = 0;
    L20:
        if (getHeaderView() == null) goto L23;
        r12 = getHeaderView().getBottom();
    L23:
        int r14 = (r11 - r13) + r12;
        if (r14 <= 0) goto L26;
        this.hasSpaceViewAdded = true;
        new SpaceUtil(this.mEngine).addSpace(r14);
    L26:
        showBouncyFooter();
        return;
    L18:
        r13 = getFooterView().getTop();
        goto L20
    L14:
        r10 = getFooterView();
        goto L15
    }

    public void endLoad() {
        removeLoadMoreView();
        showBouncyFooter();
        this.mLoadState = -1;
    }

    public int getFirstVisiblePosition() {
        return this.mEngine.getLayoutManager().findFirstVisibleItemPosition();
    }

    public int getFooterTop() {
        if (this.isFooterEnable == true) goto L5;
    L7:
        return -1;
    L5:
        if (this.mFooterUtil.isCurrentLocateLast() == false) goto L7;
        return this.mFooterUtil.getTop();
    }

    public View getFooterView() {
        return this.mFooterUtil.getFooterView();
    }

    public int getHeaderBottom() {
        if (this.isHeaderEnable == true) goto L5;
    L7:
        return -1;
    L5:
        if (this.mHeaderUtil.isCurrentLocateFirst() == false) goto L7;
        return this.mHeaderUtil.getBottom();
    }

    public int getLastVisiblePosition() {
        return this.mEngine.getLayoutManager().findLastVisibleItemPosition();
    }

    public boolean initHeader() {
        if (this.isHeaderEnable == true) goto L5;
    L13:
        return true;
    L5:
        if (this.hasHeaderAdded == false) goto L13;
        if (this.hasSpaceViewAdded == true) goto L9;
        this.mEngine.getRecyclerView().scrollToPosition(1);
        goto L13
    L9:
        if (DeviceType.isOneOf(new DeviceType[]{DeviceType.TRIDENT}) == true) goto L11;
        this.mEngine.getRecyclerView().scrollToPosition(0);
    L11:
        this.mEngine.getRecyclerView().scrollBy(0, HeaderUtil.HEADER_HEIGHT);
        goto L13
    }

    public void loadFailed() {
        if (this.mLoadState == 2) goto L6;
        this.mLoadState = 2;
        showLoadRetry();
        return;
    }

    public void loadSuccess() {
        removeFooter();
        removeLoadMoreView();
        this.mLoadState = -1;
    }

    public void onScrollStateChanged(int r10) {
        if (r10 == 0) goto L4;
        return;
    L4:
        if (isLoadMoreVisible() == false) goto L8;
        reset();
        return;
    }

    public void prepare() {
        if (this.mLoadState == 0) goto L5;
        this.mLoadState = 0;
    L5:
        showLoading();
    }

    public void reset() {
        int r10 = this.mLoadState;
        if (r10 == 1) goto L10;
        if (r10 != 0) goto L7;
        onLoad();
        return;
    L7:
        if (r10 != 2) goto L12;
        onRetry();
        return;
    L12:
        return;
    }

    public void setLoadListener(LoadListener r10) {
        this.mListener = r10;
    }

    public void setLoadMoreEnable(boolean r10) {
        this.isLoadMoreEnable = r10;
    }

    public void showBouncyFooter() {
        hideNoMore();
    }

    public void showNoMore() {
        removeLoadMoreView();
        removeFooter();
        showNoMoreFooter();
    }
}
