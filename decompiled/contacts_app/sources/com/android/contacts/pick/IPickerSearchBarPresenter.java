package com.android.contacts.pick;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public interface IPickerSearchBarPresenter {
    void attachView(IPickerSearchBarView r1, Context r2);

    void cancelSearch();

    void cancelSearchWithoutAnimation();

    void detachView();

    void setCursorVisible(boolean r1);

    void startSearch();
}
