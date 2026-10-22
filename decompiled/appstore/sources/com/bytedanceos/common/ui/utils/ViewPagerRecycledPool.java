package com.bytedanceos.common.ui.utils;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.bytedanceos.common.toolbox.i;
import com.bytedanceos.common.ui.widget.PageLinearLayout;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class ViewPagerRecycledPool {
    private static boolean DEBUG = false;
    private static final int DEFAULT_MAX_VIEW_SIZE = 20;
    private static String TAG = "ViewPagerRecycledPool";
    private static volatile ViewPagerRecycledPool sInstance;
    private int mAddCount;
    private SparseIntArray mMaxSizes;
    private SparseArray<LinkedList<View>> mRecycledViews;
    private int mReuseCount;

    static {
    }

    private ViewPagerRecycledPool() {
        this.mRecycledViews = new SparseArray();
        this.mMaxSizes = new SparseIntArray();
    }

    public static ViewPagerRecycledPool getInstance() {
        if (sInstance != null) goto L16;
        monitor-enter(ViewPagerRecycledPool.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new ViewPagerRecycledPool();     // Catch: Throwable -> L9
    L11:
        monitor-exit(ViewPagerRecycledPool.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    private String getTypeString(int r10) {
        if (isEmptyInternal(r10) == true) goto L9;
        if ((this.mRecycledViews.get(r10).getFirst() instanceof PageLinearLayout) == false) goto L9;
        return PageLinearLayout.getTypeString(r10);
    L9:
        return String.valueOf(r10);
    }

    private boolean isEmptyInternal(int r10) {
        if (this.mRecycledViews.size() != 0) goto L5;
    L10:
        return true;
    L5:
        if (this.mRecycledViews.get(r10) == null) goto L10;
        if (this.mRecycledViews.get(r10).isEmpty() == true) goto L10;
        return false;
    }

    private View removeFirstInternal(int r10) {
        if (this.mRecycledViews.get(r10) != null) goto L7;
        return null;
    L7:
        return this.mRecycledViews.get(r10).removeFirst();
    }

    public void addLast(int r10, View r11) {
        if (this.mRecycledViews.get(r10) != null) goto L6;
        this.mRecycledViews.put(r10, new LinkedList());
    L6:
        if (getSize(r10) < Math.max(20, getMaxRecycledViewSize(r10))) goto L8;
        i.a(TAG, "More than the max pool size, remove a view: viewType=" + getTypeString(r10));
        removeFirstInternal(r10);
        goto L6
    L8:
        i.a(TAG, "Recycle a view: " + toString());
        this.mRecycledViews.get(r10).addLast(r11);
    }

    public void clear() {
        if (DEBUG == false) goto L5;
        i.b(TAG, "clear: " + toString());
    L5:
        this.mAddCount = 0;
        this.mReuseCount = 0;
        this.mRecycledViews.clear();
    }

    public int getMaxRecycledViewSize(int r10) {
        return this.mMaxSizes.get(r10, 20);
    }

    public int getSize() {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= this.mRecycledViews.size()) goto L6;
        r11 = r11 + getSize(this.mRecycledViews.keyAt(r10));
        r10 = r10 + 1;
        goto L4
    L6:
        return r11;
    }

    public boolean isEmpty(int r10) {
        boolean r11 = isEmptyInternal(r10);
        if (DEBUG == false) goto L6;
        if (r11 == false) goto L6;
        String r12 = TAG;
        StringBuilder r13 = new StringBuilder();
        r13.append("Add a new view, count=");
        int r14 = this.mAddCount + 1;
        this.mAddCount = r14;
        r13.append(r14);
        i.b(r12, r13.toString());
    L6:
        return r11;
    }

    public View removeFirst(int r10) {
        View r11 = removeFirstInternal(r10);
        if (r11 != null) goto L5;
    L7:
        return r11;
    L5:
        if (DEBUG == false) goto L7;
        String r12 = TAG;
        StringBuilder r13 = new StringBuilder();
        r13.append("REUSE count=");
        int r14 = this.mReuseCount + 1;
        this.mReuseCount = r14;
        r13.append(r14);
        i.a(r12, r13.toString());
        goto L7
    }

    public void setMaxRecycledViewSize(int r10, int r11) {
        this.mMaxSizes.put(r10, r11);
    }

    public String toShortString() {
        return "ViewPagerRecycledPool [total type size=" + this.mRecycledViews.size() + ", total view size=" + getSize() + "]";
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(toShortString());
        int r11 = 0;
    L4:
        if (r11 >= this.mRecycledViews.size()) goto L7;
        int r12 = this.mRecycledViews.keyAt(r11);
        r10.append("\n[");
        r10.append("type=");
        r10.append(getTypeString(r12));
        r10.append(", view size=");
        r10.append(getSize(r12));
        r10.append(']');
        r11 = r11 + 1;
        goto L4
    L7:
        return r10.toString();
    }

    public int getSize(int r10) {
        if (this.mRecycledViews.get(r10) != null) goto L6;
        return 0;
    L6:
        return this.mRecycledViews.get(r10).size();
    }

    public boolean isEmpty() {
        if (getSize() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
