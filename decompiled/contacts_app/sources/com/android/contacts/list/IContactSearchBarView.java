package com.android.contacts.list;

import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.searchbar.v2.OSearchBar;

/* JADX INFO: loaded from: classes2.dex */
public interface IContactSearchBarView {
    void cancelSearchWithoutAnimation();

    void endContactAnimationIView();

    OSearchBar getSearchBar();

    OIconButtonFloating getSearchRightButton();

    void hideQuickContactViewIView();

    boolean onModeChangeIView(int r1);

    void onModeWillChangeIView();

    void onPopupDismissIView();

    void onQueryTextChangeIView(String r1);

    void onSearchAnimationStartIView();

    void recoverQuickBarIView();

    void setSoftKeyboardHideIView();

    void startContactAnimationIView();
}
