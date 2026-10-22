package com.bytedanceos.common.ui.utils;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bytedanceos.common.ui.adapter.TopicListAdapter;
import com.bytedanceos.common.ui.widget.FooterView;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class FooterUtil {
    protected RecyclerViewEngine mEngine;
    protected FooterView mFooterView;
    protected TopicListAdapter.TopicItem mItem;

    public FooterUtil(RecyclerViewEngine r10) {
        Objects.requireNonNull(r10);
        this.mEngine = r10;
    }

    private int getLastItemPosition(VirtualLayoutManager r10) {
        return r10.findLastVisibleItemPosition();
    }

    public void addFooter() {
        TopicListAdapter.TopicItem r10 = new TopicListAdapter.TopicItem(103);
        this.mItem = r10;
        this.mEngine.appendData(r10);
    }

    public FooterView getFooterView() {
        if (this.mFooterView != null) goto L6;
        this.mFooterView = this.mEngine.getAdapter().getFooterView();
    L6:
        return this.mFooterView;
    }

    public int getTop() {
        FooterView r10 = getFooterView();
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.getTop();
    }

    public void hideTips() {
        if (getFooterView() == null) goto L6;
        getFooterView().hideTips();
        return;
    }

    public boolean isCurrentLocateLast() {
        int r10 = getLastItemPosition(this.mEngine.getLayoutManager());
        if (r10 >= 0) goto L5;
        return false;
    L5:
        if (this.mEngine.getAdapter().getItemViewType(r10) != 103) goto L9;
        return true;
    L9:
        return false;
    }

    public void removeFooter() {
        this.mEngine.getAdapter().removeData(this.mItem);
    }

    public void showTips() {
        if (getFooterView() == null) goto L6;
        getFooterView().showTips();
        return;
    }
}
