package com.android.contacts.recyclebin;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.obric.oui.forms.OEditText;
import com.obric.oui.searchbar.v2.OSearchBar;
import obric.widget.SearchBar;

/* JADX INFO: loaded from: classes2.dex */
public class RecycleSearchBarPresenter implements IRecycleSearchBarPresenter, SearchBar.OnEditorClickListener, SearchBar.OnCancelClickListener, SearchBar.AnimationListenr {
    private Context mContext;
    private boolean mIsSearchMode;
    private OSearchBar mSearchBar;
    private OEditText mSearchEditor;
    private IRecycleSearchBarView mView;

    @Override // obric.widget.SearchBar.AnimationListenr
    public void onAnimationStart() {
    }

    public RecycleSearchBarPresenter() {
    }

    static /* synthetic */ IRecycleSearchBarView access$000(RecycleSearchBarPresenter r0) {
        return r0.mView;
    }

    static /* synthetic */ boolean access$100(RecycleSearchBarPresenter r0) {
        return r0.mIsSearchMode;
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarPresenter
    public void attachView(IRecycleSearchBarView r1, Context r2) {
        this.mView = r1;
        this.mContext = r2;
        this.mSearchBar = r1.getSearchBar();
        initViews();
    }

    private void initViews() {
        OEditText r0 = this.mSearchBar.getInputView();
        if (r0 == null) goto L6;
        this.mSearchEditor = r0;
        r0.setOnEditorActionListener(new AnonymousClass1(this));
        this.mSearchEditor.addTextChangedListener(new AnonymousClass2(this));
        return;
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarPresenter
    public void detachView() {
        this.mView = null;
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarPresenter
    public void cancelSearch() {
        if (this.mIsSearchMode == false) goto L6;
        this.mIsSearchMode = false;
        clearSearchText();
        this.mSearchEditor.clearFocus();
        this.mView.endContactAnimationIView();
        hideKeyboard();
        return;
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarPresenter
    public void clearSearchText() {
        OEditText r1 = this.mSearchEditor;
        if (r1 == null) goto L6;
        r1.setText("");
        return;
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarPresenter
    public void cancelSearchWithoutAnimation() {
        if (this.mIsSearchMode == false) goto L6;
        this.mIsSearchMode = false;
        hideKeyboard();
        clearSearchText();
        this.mSearchEditor.clearFocus();
        this.mView.endContactAnimationIView();
        return;
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarPresenter
    public boolean isInSearchMode() {
        return this.mIsSearchMode;
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarPresenter
    public void setSearchBarEnable(boolean r3) {
        OSearchBar r0 = this.mSearchBar;
        if (r0 == null) goto L5;
        r0.setEnabled(r3);
    L5:
        OEditText r1 = this.mSearchEditor;
        if (r1 == null) goto L17;
        r1.setEnabled(r3);
        OEditText r2 = this.mSearchEditor;
        if (r3 == true) goto L10;
    L12:
        boolean r4 = false;
    L13:
        r2.setCursorVisible(r4);
        if (r3 == true) goto L18;
        this.mSearchEditor.clearFocus();
        return;
    L18:
        return;
    L10:
        if (this.mIsSearchMode == false) goto L12;
        r4 = true;
        goto L13
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarPresenter
    public void setSearchBarVisible(boolean r1) {
        OSearchBar r0 = this.mSearchBar;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarPresenter
    public void setCursorVisible(boolean r1) {
        this.mSearchEditor.setCursorVisible(r1);
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarPresenter
    public void setLayerType(int r1, Paint r2) {
        this.mSearchBar.setLayerType(r1, r2);
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarPresenter
    public int getWidth() {
        return this.mSearchBar.getWidth();
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarPresenter
    public void setTranslationX(float r1) {
        this.mSearchBar.setTranslationX(r1);
    }

    @Override // com.android.contacts.recyclebin.IRecycleSearchBarPresenter
    public void startSearch() {
        this.mIsSearchMode = true;
        this.mSearchEditor.setCursorVisible(true);
        this.mSearchEditor.setFocusable(this.mIsSearchMode);
        this.mSearchEditor.requestFocus();
    }

    @Override // obric.widget.SearchBar.AnimationListenr
    public void onAnimationEnd() {
        IRecycleSearchBarView r0 = this.mView;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.mIsSearchMode == false) goto L8;
        r0.startContactAnimationIView();
        return;
    L8:
        r0.endContactAnimationIView();
    }

    @Override // obric.widget.SearchBar.OnEditorClickListener, obric.widget.SearchBar.OnCancelClickListener
    public void onClick(View r2) {
        switch(r2.getId()) {
            case 2131363477: goto L6;
            case 2131363478: goto L6;
            default: goto L10;
        };
    L10:
        return;
    L6:
        if (this.mIsSearchMode == true) goto L9;
        this.mSearchEditor.setCursorVisible(true);
        this.mSearchEditor.setFocusable(true);
        this.mSearchEditor.setFocusableInTouchMode(true);
        this.mSearchEditor.requestFocus();
        return;
    }

    public void hideKeyboard() {
        ((InputMethodManager) this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchEditor.getWindowToken(), 2);
    }
}
