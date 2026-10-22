package com.android.contacts.list;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes2.dex */
public interface IContactSearchBarPresenter {
    void attachView(IContactSearchBarView r1, Context r2, Activity r3);

    void cancelSearch();

    void cancelSearchWithoutAnimation();

    void clearSearchText();

    void detachView();

    void freezeSearchView(boolean r1);

    int getWidth();

    boolean isInSearchMode();

    boolean isPlayingSearchAnimation();

    boolean isPopupWindowShowing();

    void requestSeachViewFocus();

    void returnToSortByName();

    void setCursorVisible(boolean r1);

    void setLayerType(int r1, Paint r2);

    void setListener(SearchBar.Listener r1);

    void setSearchEnable(boolean r1);

    void setSortByBusinessCardSupported(boolean r1);

    void setSortMode(int r1);

    void setTranslationX(float r1);

    void startSearch();

    void switchSortMode(int r1);
}
