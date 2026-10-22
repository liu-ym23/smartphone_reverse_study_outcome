package com.android.contacts.recyclebin;

import android.content.Context;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes2.dex */
public interface IRecycleSearchBarPresenter {
    void attachView(IRecycleSearchBarView r1, Context r2);

    void cancelSearch();

    void cancelSearchWithoutAnimation();

    void clearSearchText();

    void detachView();

    int getWidth();

    boolean isInSearchMode();

    void setCursorVisible(boolean r1);

    void setLayerType(int r1, Paint r2);

    void setSearchBarEnable(boolean r1);

    void setSearchBarVisible(boolean r1);

    void setTranslationX(float r1);

    void startSearch();
}
