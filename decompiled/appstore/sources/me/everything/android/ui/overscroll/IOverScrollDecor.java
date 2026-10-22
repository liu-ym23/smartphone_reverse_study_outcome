package me.everything.android.ui.overscroll;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public interface IOverScrollDecor {
    void detach();

    int getCurrentState();

    View getView();

    void setOverScrollStateListener(IOverScrollStateListener r10);

    void setOverScrollUpdateListener(IOverScrollUpdateListener r10);
}
