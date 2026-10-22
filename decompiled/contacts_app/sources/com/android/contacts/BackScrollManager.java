package com.android.contacts;

import android.widget.AbsListView;
import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public class BackScrollManager {
    private final ScrollableHeader mHeader;
    private final ListView mListView;
    private final AbsListView.OnScrollListener mScrollListener;

    public interface ScrollableHeader {
        int getMaximumScrollableHeaderOffset();

        void setOffset(int r1);
    }

    static /* synthetic */ ScrollableHeader access$000(BackScrollManager r0) {
        return r0.mHeader;
    }

    public static void bind(ScrollableHeader r1, ListView r2) {
        new BackScrollManager(r1, r2).bind();
    }

    private BackScrollManager(ScrollableHeader r2, ListView r3) {
        this.mScrollListener = new AnonymousClass1(this);
        this.mHeader = r2;
        this.mListView = r3;
    }

    private void bind() {
        this.mListView.setOnScrollListener(this.mScrollListener);
        this.mListView.setVerticalScrollBarEnabled(false);
    }
}
