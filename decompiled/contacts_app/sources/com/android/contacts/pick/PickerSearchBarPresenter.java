package com.android.contacts.pick;

import android.content.Context;
import android.text.method.TextKeyListener;
import android.view.inputmethod.InputMethodManager;
import com.obric.oui.forms.OEditText;
import com.obric.oui.searchbar.v2.OSearchBar;

/* JADX INFO: loaded from: classes2.dex */
public class PickerSearchBarPresenter implements IPickerSearchBarPresenter {
    private Context mContext;
    private boolean mIsSearchMode;
    private OSearchBar mOSearchBar;
    private OEditText mSearchEditor;
    private IPickerSearchBarView mView;

    public PickerSearchBarPresenter() {
        this.mIsSearchMode = false;
    }

    static /* synthetic */ IPickerSearchBarView access$000(PickerSearchBarPresenter r0) {
        return r0.mView;
    }

    static /* synthetic */ boolean access$100(PickerSearchBarPresenter r0) {
        return r0.mIsSearchMode;
    }

    static /* synthetic */ boolean access$102(PickerSearchBarPresenter r0, boolean r1) {
        r0.mIsSearchMode = r1;
        return r1;
    }

    static /* synthetic */ OEditText access$200(PickerSearchBarPresenter r0) {
        return r0.mSearchEditor;
    }

    @Override // com.android.contacts.pick.IPickerSearchBarPresenter
    public void attachView(IPickerSearchBarView r1, Context r2) {
        this.mView = r1;
        this.mContext = r2;
        this.mOSearchBar = r1.getSearchBar();
        initViews();
    }

    @Override // com.android.contacts.pick.IPickerSearchBarPresenter
    public void detachView() {
        this.mView = null;
    }

    private void initViews() {
        OEditText r0 = this.mOSearchBar.getInputView();
        if (r0 == null) goto L6;
        this.mSearchEditor = r0;
        r0.setOnEditorActionListener(new AnonymousClass1(this));
        this.mSearchEditor.addTextChangedListener(new AnonymousClass2(this));
        this.mSearchEditor.setOnClickListener(new AnonymousClass3(this));
        return;
    }

    @Override // com.android.contacts.pick.IPickerSearchBarPresenter
    public void setCursorVisible(boolean r1) {
        OEditText r0 = this.mSearchEditor;
        if (r0 == null) goto L6;
        r0.setCursorVisible(r1);
        return;
    }

    @Override // com.android.contacts.pick.IPickerSearchBarPresenter
    public void cancelSearch() {
        this.mIsSearchMode = false;
        clearSearchText();
        hideKeyboard();
        this.mSearchEditor.clearFocus();
        this.mView.endContactAnimationIView();
    }

    @Override // com.android.contacts.pick.IPickerSearchBarPresenter
    public void cancelSearchWithoutAnimation() {
        this.mIsSearchMode = false;
        hideKeyboard();
        clearSearchText();
    }

    @Override // com.android.contacts.pick.IPickerSearchBarPresenter
    public void startSearch() {
        this.mIsSearchMode = true;
        showKeyboard();
        updateSearchMode();
    }

    private void updateSearchMode() {
        this.mSearchEditor.setCursorVisible(this.mIsSearchMode);
        this.mSearchEditor.setFocusableInTouchMode(this.mIsSearchMode);
        if (this.mIsSearchMode == false) goto L5;
        this.mSearchEditor.requestFocus();
        return;
    L5:
        this.mSearchEditor.clearFocus();
        TextKeyListener.clear(this.mSearchEditor.getText());
    }

    public void hideKeyboard() {
        ((InputMethodManager) this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchEditor.getWindowToken(), 2);
    }

    public void showKeyboard() {
        ((InputMethodManager) this.mContext.getSystemService("input_method")).showSoftInput(this.mSearchEditor, 0);
    }

    public void clearSearchText() {
        OEditText r1 = this.mSearchEditor;
        if (r1 == null) goto L6;
        r1.setText("");
        return;
    }
}
