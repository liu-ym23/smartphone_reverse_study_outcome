package com.bytedanceos.common.ui.utils;

import com.bytedanceos.common.ui.adapter.TopicListAdapter;
import com.bytedanceos.common.ui.widget.BaseLoadView;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class LoadUtil {
    private RecyclerViewEngine mEngine;
    private boolean mIsAdded;
    private TopicListAdapter.TopicItem mItem;
    private BaseLoadView mLoadView;

    public LoadUtil(RecyclerViewEngine r10) {
        this.mIsAdded = false;
        Objects.requireNonNull(r10);
        this.mEngine = r10;
        this.mItem = new TopicListAdapter.TopicItem(104, 1);
    }

    private void setLoadType(int r10) {
        BaseLoadView r11 = this.mEngine.getAdapter().getLoadMoreView();
        this.mLoadView = r11;
        if (r11 == null) goto L6;
        r11.setLoadType(r10);
        return;
    }

    public void addLoadItem() {
        if (this.mIsAdded == true) goto L6;
        this.mEngine.appendData(this.mItem);
        this.mIsAdded = true;
        return;
    }

    public TopicListAdapter.TopicItem getItem() {
        return this.mItem;
    }

    public void removeLoadItem() {
        if (this.mIsAdded == false) goto L6;
        this.mEngine.getAdapter().removeData(this.mItem);
        this.mIsAdded = false;
        return;
    }

    public void removeLoadView() {
        removeLoadItem();
    }

    public void showLoadingView() {
        addLoadItem();
        setLoadType(1);
    }

    public void showRetryView() {
        addLoadItem();
        setLoadType(0);
    }
}
