package com.android.contacts.list;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextWatcher;
import android.text.method.TextKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class SearchBarInPicker extends RelativeLayout implements View.OnClickListener {
    private TextView mBtnCancelSearch;
    private TextView mBtnClearSearch;
    private Context mContext;
    private int mDuration;
    private AlphaAnimation mGoneAnimation;
    private boolean mIsPlaySearchModeAnimation;
    private boolean mIsSearchMode;
    private Listener mListener;
    private RelativeLayout mSearchBar;
    private RelativeLayout mSearchBarView;
    private EditText mSearchEdit;
    private LinearLayout mSearchView;
    private TextView mSearchViewLeft;
    private TextView mSearchViewRight;
    private TextWatcher mSearchWatcher;
    private AlphaAnimation mVisibleAnimation;

    public interface Listener {
        void endContactAnimation();

        void endContactAnimationWithoutAnimation();

        void onModeChange(int r1);

        void onQueryTextChange(String r1);

        void setSoftKeyboardHide();

        void startContactAnimation();
    }

    static /* synthetic */ Listener access$000(SearchBarInPicker r0) {
        return r0.mListener;
    }

    static /* synthetic */ boolean access$100(SearchBarInPicker r0) {
        return r0.mIsSearchMode;
    }

    static /* synthetic */ TextView access$200(SearchBarInPicker r0) {
        return r0.mBtnClearSearch;
    }

    static /* synthetic */ boolean access$302(SearchBarInPicker r0, boolean r1) {
        r0.mIsPlaySearchModeAnimation = r1;
        return r1;
    }

    static /* synthetic */ Context access$400(SearchBarInPicker r0) {
        return r0.mContext;
    }

    static /* synthetic */ EditText access$500(SearchBarInPicker r0) {
        return r0.mSearchEdit;
    }

    public SearchBarInPicker(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mIsSearchMode = false;
        this.mIsPlaySearchModeAnimation = false;
        this.mSearchBar = null;
        this.mDuration = 200;
        this.mSearchWatcher = new AnonymousClass2(this);
        this.mContext = r1;
        this.mSearchBarView = (RelativeLayout) ((LayoutInflater) r1.getSystemService("layout_inflater")).inflate(R.layout.searchbarinpicker, this);
        setViews();
        setSearchModeAS();
    }

    private void setViews() {
        this.mSearchBar = (RelativeLayout) this.mSearchBarView.findViewById(R.id.searchbarframe);
        LinearLayout r0 = (LinearLayout) this.mSearchBarView.findViewById(R.id.search_view);
        this.mSearchView = r0;
        r0.setOnClickListener(this);
        TextView r1 = (TextView) this.mSearchBarView.findViewById(R.id.searchbarright);
        this.mSearchViewRight = r1;
        r1.setOnClickListener(this);
        TextView r2 = (TextView) this.mSearchBarView.findViewById(R.id.searchbarleft);
        this.mSearchViewLeft = r2;
        r2.setOnClickListener(this);
        TextView r3 = (TextView) this.mSearchBarView.findViewById(R.id.btn_cancel);
        this.mBtnCancelSearch = r3;
        r3.setOnClickListener(this);
        TextView r4 = (TextView) this.mSearchBar.findViewById(R.id.btn_clear_search);
        this.mBtnClearSearch = r4;
        r4.setOnClickListener(this);
        EditText r5 = (EditText) this.mSearchBar.findViewById(R.id.search_edit_text);
        this.mSearchEdit = r5;
        r5.setOnClickListener(this);
        this.mSearchEdit.addTextChangedListener(this.mSearchWatcher);
        this.mSearchEdit.setOnEditorActionListener(new AnonymousClass1(this));
    }

    public void setListener(Listener r1) {
        this.mListener = r1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        switch(r2.getId()) {
            case 2131362107: goto L14;
            case 2131362110: goto L13;
            case 2131363492: goto L9;
            case 2131363526: goto L6;
            case 2131363527: goto L6;
            default: goto L20;
        };
    L13:
        this.mSearchEdit.setText("");
        return;
    L14:
        cancelSearch();
        return;
    L20:
        return;
    L6:
        if (this.mIsSearchMode == false) goto L9;
        return;
    L9:
        if (this.mIsPlaySearchModeAnimation == false) goto L11;
        return;
    L11:
        if (this.mIsSearchMode == true) goto L17;
        this.mSearchEdit.setCursorVisible(true);
        this.mSearchEdit.setFocusable(true);
        this.mSearchEdit.setFocusableInTouchMode(true);
        this.mSearchEdit.requestFocus();
        this.mListener.startContactAnimation();
        setBtnCancelVisibleAM(this.mBtnCancelSearch);
        return;
    }

    private void setBtnCancelVisibleAM(final View r6) {
        this.mVisibleAnimation.setAnimationListener(new AnonymousClass3(this, r6));
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.mSearchViewRight, "translationX", new float[]{0.0f, -r6.getWidth()});
        r0.setDuration(this.mDuration / 2);
        r0.start();
        r6.startAnimation(this.mVisibleAnimation);
        int r7 = r6.getWidth();
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) this.mSearchView.getLayoutParams();
        r1.rightMargin = r7;
        this.mSearchView.setLayoutParams(r1);
        this.mIsSearchMode = true;
    }

    private void setBtnCancelGoneAM(final View r6) {
        this.mGoneAnimation.setAnimationListener(new AnonymousClass4(this, r6));
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.mSearchViewRight, "translationX", new float[]{-r6.getWidth(), 0.0f});
        r0.setDuration(this.mDuration);
        r0.start();
        r6.startAnimation(this.mGoneAnimation);
        this.mIsSearchMode = false;
        TextKeyListener.clear(this.mSearchEdit.getText());
        this.mListener.setSoftKeyboardHide();
        this.mSearchEdit.setFocusable(false);
        this.mSearchEdit.setFocusableInTouchMode(false);
    }

    public void cancelSearch() {
        if (this.mIsPlaySearchModeAnimation == false) goto L5;
        return;
    L5:
        if (this.mIsSearchMode == false) goto L9;
        this.mListener.endContactAnimation();
        setBtnCancelGoneAM(this.mBtnCancelSearch);
        return;
    }

    public void cancelSearchWithoutAnimation() {
        if (this.mIsSearchMode == false) goto L8;
        Listener r0 = this.mListener;
        if (r0 == null) goto L9;
        r0.endContactAnimationWithoutAnimation();
        this.mBtnCancelSearch.setVisibility(4);
        this.mSearchViewRight.setTranslationX(0.0f);
        this.mIsSearchMode = false;
        TextKeyListener.clear(this.mSearchEdit.getText());
        this.mListener.setSoftKeyboardHide();
        this.mSearchEdit.setFocusable(false);
        this.mSearchEdit.setFocusableInTouchMode(false);
        return;
    L9:
        return;
    }

    public void setCursorVisible(boolean r1) {
        this.mSearchEdit.setCursorVisible(r1);
    }

    private void setSearchModeAS() {
        AlphaAnimation r0 = new AlphaAnimation(0.0f, 1.0f);
        this.mVisibleAnimation = r0;
        r0.setDuration(this.mDuration / 2);
        this.mVisibleAnimation.setStartOffset(this.mDuration / 2);
        AlphaAnimation r1 = new AlphaAnimation(1.0f, 0.0f);
        this.mGoneAnimation = r1;
        r1.setDuration(this.mDuration / 3);
    }
}
