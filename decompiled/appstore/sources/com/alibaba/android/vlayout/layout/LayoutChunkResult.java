package com.alibaba.android.vlayout.layout;

/* JADX INFO: loaded from: classes.dex */
public class LayoutChunkResult {
    public int mConsumed;
    public boolean mFinished;
    public boolean mFocusable;
    public boolean mIgnoreConsumed;

    public LayoutChunkResult() {
    }

    public void resetInternal() {
        this.mConsumed = 0;
        this.mFinished = false;
        this.mIgnoreConsumed = false;
        this.mFocusable = false;
    }
}
