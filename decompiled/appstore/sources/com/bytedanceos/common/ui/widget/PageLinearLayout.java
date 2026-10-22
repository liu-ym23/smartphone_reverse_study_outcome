package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedanceos.common.toolbox.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PageLinearLayout<E> extends LinearLayout {
    private static final String TAG = "PageLinearLayout";
    public static final int TYPE_HORIZONTAL_BASE = 1024;
    public static final int TYPE_IDLE = -1;
    public static final int TYPE_VERTICAL_BASE = 2048;
    private List<E> mCacheItems;
    private int mType;

    static {
    }

    public PageLinearLayout(Context r10) {
        super(r10);
        this.mType = 1024;
        this.mCacheItems = new ArrayList();
    }

    public static String getTypeString(int r10) {
        if (r10 <= 2048) goto L5;
        int r11 = 2048;
    L6:
        int r12 = r10 - r11;
        StringBuilder r13 = new StringBuilder();
        r13.append("[view type=");
        r13.append(r10);
        r13.append(", orientation=");
        if (r11 != 2048) goto L9;
        String r14 = "VERTICAL";
    L10:
        r13.append(r14);
        r13.append(", lines=");
        r13.append(r12);
        r13.append(']');
        return r13.toString();
    L9:
        r14 = "HORIZONTAL";
        goto L10
    L5:
        r11 = 1024;
        goto L6
    }

    public void addCacheItem(E r10) {
        this.mCacheItems.add(r10);
    }

    public void clearItems() {
        this.mCacheItems.clear();
    }

    public boolean equals(Object r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.hashCode() == hashCode()) goto L8;
        return false;
    L8:
        if ((r10 instanceof PageLinearLayout) == true) goto L10;
        return false;
    L10:
        if (((PageLinearLayout) r10).getType() != getType()) goto L15;
        return true;
    L15:
        return false;
    }

    public E getCacheItem(int r10) {
        if (r10 >= 0) goto L4;
        return null;
    L4:
        if (r10 < this.mCacheItems.size()) goto L7;
        return null;
    L7:
        return this.mCacheItems.get(r10);
    }

    public int getType() {
        return this.mType;
    }

    public int hashCode() {
        return super.hashCode() * this.mType;
    }

    public boolean isCacheItemEmpty() {
        List<E> r10 = this.mCacheItems;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.isEmpty() == true) goto L8;
        return false;
    }

    public void setType(int r10, int r11) {
        if (r10 != 0) goto L5;
        this.mType = r11 + 1024;
        return;
    L5:
        if (r10 != 1) goto L9;
        this.mType = r11 + 2048;
        return;
    L9:
        throw new IllegalArgumentException("Unknown orientation type, might cause conflict in the ViewPagerRecycledPool and make a failure of caching.");
    }

    public static int getType(int r10, int r11) {
        if (r10 != 0) goto L6;
        return r11 + 1024;
    L6:
        if (r10 == 1) goto L8;
        i.b(TAG, "Unknown orientation type, return a idle one.");
        return -1;
    L8:
        return r11 + 2048;
    }

    public PageLinearLayout(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mType = 1024;
        this.mCacheItems = new ArrayList();
    }

    public PageLinearLayout(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mType = 1024;
        this.mCacheItems = new ArrayList();
    }
}
