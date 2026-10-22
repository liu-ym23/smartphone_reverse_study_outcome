package com.bytedanceos.common.ui.utils;

import android.content.Context;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bytedanceos.common.ui.adapter.TopicListAdapter;
import com.bytedanceos.common.view.RecyclerviewCompat;

/* JADX INFO: loaded from: classes2.dex */
public class RecyclerViewEngine {
    private TopicListAdapter mAdapter;
    private Context mContext;
    private VirtualLayoutManager mLayoutManager;
    private RecyclerviewCompat mRecyclerviewCompat;

    public RecyclerViewEngine(TopicListAdapter r10, VirtualLayoutManager r11, Context r12) {
        this.mAdapter = r10;
        this.mLayoutManager = r11;
        this.mContext = r12;
    }

    public void appendData(TopicListAdapter.TopicItem r10) {
        this.mAdapter.appendData(r10);
    }

    public void bindView(RecyclerviewCompat r10) {
        this.mRecyclerviewCompat = r10;
    }

    public TopicListAdapter getAdapter() {
        return this.mAdapter;
    }

    public Context getContext() {
        return this.mContext;
    }

    public VirtualLayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    public RecyclerviewCompat getRecyclerView() {
        return this.mRecyclerviewCompat;
    }

    public void appendData(int r10, TopicListAdapter.TopicItem r11) {
        this.mAdapter.appendData(r10, r11);
    }
}
