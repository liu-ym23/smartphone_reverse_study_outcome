package com.bytedanceos.common.ui.utils;

import android.view.View;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.ui.adapter.TopicListAdapter;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class HeaderUtil {
    public static final int HEADER_HEIGHT = 0;
    public static final int HEADER_POSITION = 0;
    protected View mBouncyView;
    protected RecyclerViewEngine mEngine;
    protected TopicListAdapter.TopicItem mItem;

    static {
        HEADER_HEIGHT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.bouncy_view_height);
    }

    public HeaderUtil(RecyclerViewEngine r10) {
        Objects.requireNonNull(r10);
        this.mEngine = r10;
    }

    private int getFirstItemPosition(VirtualLayoutManager r10) {
        return r10.findFirstVisibleItemPosition();
    }

    public void addHeader() {
        TopicListAdapter.TopicItem r10 = new TopicListAdapter.TopicItem(108);
        this.mItem = r10;
        this.mEngine.appendData(0, r10);
    }

    public int getBottom() {
        View r10 = getHeaderBouncyView();
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.getBottom();
    }

    public View getHeaderBouncyView() {
        if (this.mBouncyView != null) goto L6;
        this.mBouncyView = this.mEngine.getAdapter().getHeaderBouncyView();
    L6:
        return this.mBouncyView;
    }

    public boolean isCurrentLocateFirst() {
        int r10 = getFirstItemPosition(this.mEngine.getLayoutManager());
        if (r10 >= 0) goto L5;
        return false;
    L5:
        if (this.mEngine.getAdapter().getItemViewType(r10) != 108) goto L9;
        return true;
    L9:
        return false;
    }

    public void removeHeader() {
        this.mEngine.getAdapter().removeData(this.mItem);
    }
}
