package com.android.ttcjpaysdk.base.framework;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes28.dex */
public class BaseWrapper {
    private Context mContext;
    private View mRootView;

    public boolean onBackPressed() {
        return false;
    }

    public void hide() {
        this.mRootView.setVisibility(8);
    }

    public void show() {
        this.mRootView.setVisibility(0);
    }

    public Context getContext() {
        return this.mContext;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public BaseWrapper(View r100) {
        this.mRootView = r100;
        this.mContext = r100.getContext();
    }
}
