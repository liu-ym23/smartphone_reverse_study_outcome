package com.bytedanceos.common.networkv2.data;

import com.bytedanceos.common.toolbox.i;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class ListPageInfo<T> {
    public static final String TAG = "ListPageInfo";
    private List<T> mDataList;
    private List<T> mDataPageList;
    private boolean mHasMore;
    private boolean mIsBusy;
    private int mLastStart;
    private int mNumPerPage;
    private AtomicInteger mPage;
    private int mStart;

    public ListPageInfo(int r10) {
        this.mNumPerPage = 0;
        this.mStart = 0;
        this.mLastStart = 0;
        this.mHasMore = true;
        this.mIsBusy = false;
        this.mPage = new AtomicInteger(0);
        this.mNumPerPage = r10;
    }

    private void addMore(List<T> r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mStart != 0) goto L7;
    L8:
        this.mDataList = new ArrayList();
    L9:
        this.mDataList.addAll(r10);
        return;
    L7:
        if (this.mDataList != null) goto L9;
        goto L8
    }

    private void setDataPageList(List<T> r10) {
        if (this.mDataPageList != null) goto L5;
        this.mDataPageList = new ArrayList();
    L5:
        this.mDataPageList.clear();
        if (r10 == null) goto L9;
        this.mDataPageList.addAll(r10);
        return;
    }

    public void addData(T r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mStart != 0) goto L7;
    L8:
        this.mDataList = new ArrayList();
    L9:
        this.mDataList.add(r10);
        return;
    L7:
        if (this.mDataList != null) goto L9;
        goto L8
    }

    public void destroy() {
        List<T> r10 = this.mDataList;
        if (r10 == null) goto L5;
        r10.clear();
        this.mDataList = null;
    L5:
        this.mStart = 0;
        this.mPage = null;
        this.mIsBusy = false;
    }

    public T firstItem() {
        List<T> r10 = this.mDataList;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.size() != 0) goto L8;
        return null;
    L8:
        return this.mDataList.get(0);
    }

    public List<T> getDataList() {
        return this.mDataList;
    }

    public List<T> getDataPageList() {
        return this.mDataPageList;
    }

    public T getItem(int r10) {
        List<T> r11 = this.mDataList;
        if (r11 == null) goto L10;
        if (r10 >= 0) goto L6;
        return null;
    L6:
        if (r10 <= r11.size()) goto L9;
        return null;
    L9:
        return this.mDataList.get(r10);
    L10:
        return null;
    }

    public int getListLength() {
        List<T> r10 = this.mDataList;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.size();
    }

    public int getNumPerPage() {
        return this.mNumPerPage;
    }

    public int getPage() {
        return this.mPage.intValue();
    }

    public int getStart() {
        return this.mStart;
    }

    public void goToHead() {
        this.mStart = 0;
        this.mPage.set(0);
        this.mHasMore = true;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean isEmpty() {
        List<T> r10 = this.mDataList;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.size() == 0) goto L8;
        return false;
    }

    public T lastItem() {
        List<T> r10 = this.mDataList;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.size() == 0) goto L11;
        List<T> r11 = this.mDataList;
        return r11.get(r11.size() - 1);
    L11:
        return null;
    }

    public boolean prepareForNextPage() {
        if (hasMore() == false) goto L6;
        int r10 = this.mStart;
        this.mLastStart = r10;
        this.mStart = r10 + this.mNumPerPage;
        this.mPage.incrementAndGet();
        return true;
    L6:
        i.e(TAG, "no more data");
        return false;
    }

    public void releaseLock() {
        this.mIsBusy = false;
    }

    public void rollbackOnFail() {
        this.mStart = this.mLastStart;
        AtomicInteger r10 = this.mPage;
        if (r10 != null) goto L5;
        this.mPage = new AtomicInteger(0);
        return;
    L5:
        r10.decrementAndGet();
    }

    public void setHasMore(boolean r10) {
        this.mHasMore = r10;
    }

    public boolean tryEnterLock() {
        if (this.mIsBusy == false) goto L6;
        i.e(TAG, "request not finish,please try after");
        return false;
    L6:
        this.mIsBusy = true;
        return true;
    }

    public void updateListInfo(List<T> r10, int r11) {
        addMore(r10);
        setDataPageList(r10);
        if (this.mDataList.size() >= r11) goto L5;
        boolean r12 = true;
    L6:
        this.mHasMore = r12;
        this.mIsBusy = false;
        return;
    L5:
        r12 = false;
        goto L6
    }

    public void updateListInfo(List<T> r10, boolean r11) {
        addMore(r10);
        setDataPageList(r10);
        this.mHasMore = r11;
        this.mIsBusy = false;
    }
}
