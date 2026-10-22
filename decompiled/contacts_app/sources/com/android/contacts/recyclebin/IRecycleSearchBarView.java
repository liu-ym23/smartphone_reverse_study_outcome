package com.android.contacts.recyclebin;

import com.obric.oui.searchbar.v2.OSearchBar;

/* JADX INFO: loaded from: classes2.dex */
public interface IRecycleSearchBarView {
    void endContactAnimationIView();

    OSearchBar getSearchBar();

    void onQueryTextChangeIView(String r1);

    void setSoftKeyboardHideIView();

    void startContactAnimationIView();
}
