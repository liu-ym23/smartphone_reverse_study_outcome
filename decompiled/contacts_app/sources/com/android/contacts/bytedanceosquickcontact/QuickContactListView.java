package com.android.contacts.bytedanceosquickcontact;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.android.contacts.ContactsUtils;
import com.android.contacts.list.HorizontalScrollListView;
import com.android.contacts.list.SamContact;
import com.obric.oui.button.OButton;
import com.obric.oui.indexscrollbar.OIndexScrollbar;

/* JADX INFO: loaded from: classes.dex */
public class QuickContactListView extends HorizontalScrollListView implements QuickContactListener, AbsListView.OnScrollListener {
    private static final String TAG = "QuickContactListView";
    private OButton mCacheQuickButton;
    private View mCacheView;
    private boolean mCompareHasAddedTime;
    private int mFirstPosition;
    private boolean mHasAddedTime;
    private int mIndex;
    private boolean mIsShowQuickContact;
    private boolean mIsTouchOther;
    private OnQuickContactListViewScrollListener mOnQuickContactListViewOnScrollListener;
    public AbsListView.OnScrollListener mOnScrollListener;
    protected OIndexScrollbar mQuickBar;
    private QuickContactClickedView mQuickContactClickedView;
    private QuickContactHelper mQuickContactHelperCache;
    private QuickContactChildLayout mQuickContactView;
    private long mQuickDataCacheId;

    public interface OnQuickContactListViewScrollListener {
        void onQuickContactListViewScroll(AbsListView r1, int r2, int r3, int r4);

        void onQuickContactListViewScrollStateChanged(AbsListView r1, int r2);
    }

    public interface RightModeViewListener {
        void setRightModeViewVisiblity(boolean r1);
    }

    public QuickContactListView(Context r3) {
        super(r3);
        this.mIsShowQuickContact = false;
        this.mIsTouchOther = true;
        this.mIndex = -1;
        this.mQuickDataCacheId = -1;
        this.mHasAddedTime = false;
        this.mCompareHasAddedTime = false;
        super.setOnScrollListener(this);
        setOverScrollMode(0);
    }

    public QuickContactListView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mIsShowQuickContact = false;
        this.mIsTouchOther = true;
        this.mIndex = -1;
        this.mQuickDataCacheId = -1;
        this.mHasAddedTime = false;
        this.mCompareHasAddedTime = false;
        super.setOnScrollListener(this);
        setOverScrollMode(0);
    }

    public QuickContactListView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mIsShowQuickContact = false;
        this.mIsTouchOther = true;
        this.mIndex = -1;
        this.mQuickDataCacheId = -1;
        this.mHasAddedTime = false;
        this.mCompareHasAddedTime = false;
        super.setOnScrollListener(this);
        setOverScrollMode(0);
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public void setQuickContactView(QuickContactChildLayout r1) {
        this.mQuickContactView = r1;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public void setIsShowQuickContact(boolean r2) {
        if (r2 == false) goto L6;
        OIndexScrollbar r0 = this.mQuickBar;
        if (r0 == null) goto L6;
        r0.hideLetterGrid();
    L6:
        if (r2 == true) goto L8;
        this.mQuickContactView = null;
    L8:
        this.mIsShowQuickContact = r2;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public boolean isShowQuickContact() {
        return this.mIsShowQuickContact;
    }

    public void setOnQuickContactListViewOnScrollListener(OnQuickContactListViewScrollListener r1) {
        this.mOnQuickContactListViewOnScrollListener = r1;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener r1) {
        this.mOnScrollListener = r1;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public void hideQuickContact() {
        restoreScrollState(false);
    }

    public void cancelRightMode(boolean r2) {
        ListAdapter r1 = getAdapter();
        if ((r1 instanceof RightModeViewListener) == false) goto L6;
        ((RightModeViewListener) r1).setRightModeViewVisiblity(r2);
        return;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public void hideQuickContactWithoutAnimation(boolean r2) {
        if (this.mIsShowQuickContact == false) goto L8;
        QuickContactChildLayout r1 = this.mQuickContactView;
        if (r1 == null) goto L9;
        r1.setQuickContactViewExit(r2);
        return;
    L9:
        return;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public void setQuickContactCacheId(long r1) {
        this.mQuickDataCacheId = r1;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public long getQuickContactCacheId() {
        return this.mQuickDataCacheId;
    }

    public void setQuickBar(OIndexScrollbar r1) {
        this.mQuickBar = r1;
    }

    public boolean hasQuickBar() {
        if (this.mQuickBar == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void hideQuickBar() {
        if (hasQuickBar() == false) goto L6;
        this.mQuickBar.hideLetterGrid();
        return;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public void setQuickContactClickedView(QuickContactClickedView r1) {
        this.mQuickContactClickedView = r1;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public QuickContactHelper getQuickContactHelperCache() {
        return this.mQuickContactHelperCache;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public void setQuickContactHelperCache(QuickContactHelper r1) {
        this.mQuickContactHelperCache = r1;
    }

    public void setCompareHasAddedTime(boolean r1) {
        this.mCompareHasAddedTime = r1;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        super.onLayout(r3, r4, r5, r6, r7);
        int r8 = getFirstVisiblePosition();
    L4:
        if (r8 > getLastVisiblePosition()) goto L13;
        if (this.mQuickDataCacheId != getAdapter().getItemId(r8)) goto L12;
        boolean r9 = true;
        if (this.mCompareHasAddedTime == false) goto L14;
        if (((SamContact) getAdapter().getItem(r8)).hasAddedTime != this.mHasAddedTime) goto L12;
    L14:
        if (r9 == true) goto L22;
        this.mQuickDataCacheId = -1;
        this.mQuickContactHelperCache = null;
        this.mHasAddedTime = false;
        return;
    L22:
        return;
    L12:
        r8 = r8 + 1;
        goto L4
    L13:
        r9 = false;
        goto L14
    }

    @Override // com.android.contacts.list.HorizontalScrollListView, com.obric.oui.bouncelayout.OListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.mIsShowQuickContact == false) goto L11;
        if (r2.getAction() != 0) goto L7;
        return true;
    L7:
        return super.onInterceptTouchEvent(r2);
    L11:
        return super.onInterceptTouchEvent(r2);
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        if (r3 != 4) goto L5;
    L6:
        this.mQuickDataCacheId = -1;
        this.mQuickContactHelperCache = null;
        this.mHasAddedTime = false;
        return;
    L5:
        if (r3 == 8) goto L6;
    }

    @Override // com.android.contacts.list.HorizontalScrollListView, com.obric.oui.bouncelayout.OListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r11) {
        int r0 = r11.getAction();
        OIndexScrollbar r1 = this.mQuickBar;
        if (r1 == null) goto L6;
        r1.hideLetterGrid();
    L6:
        if (this.mIsShowQuickContact == false) goto L43;
        QuickContactChildLayout r2 = this.mQuickContactView;
        if (r2 != null) goto L11;
        return true;
    L11:
        if (r2.isAnimationing() == false) goto L13;
        return true;
    L13:
        Rect r3 = new Rect();
        this.mQuickContactView.getGlobalVisibleRect(r3);
        int r4 = (int) r11.getRawX();
        int r5 = (int) r11.getRawY();
        if (r0 == 0) goto L28;
        if (r0 == 1) goto L21;
        if (r0 == 3) goto L19;
        super.onTouchEvent(r11);
    L42:
        return true;
    L19:
        this.mIsTouchOther = true;
        super.onTouchEvent(r11);
        goto L42
    L21:
        if (this.mIsTouchOther == true) goto L23;
        this.mIsTouchOther = true;
        Rect r12 = new Rect();
        this.mCacheQuickButton.getGlobalVisibleRect(r12);
        if (r12.contains(r4, r5) == false) goto L42;
        this.mCacheQuickButton.performClick();
        this.mQuickContactClickedView.setClicked(this.mIndex, r12.left, r12.top);
        goto L42
    L23:
        return super.onTouchEvent(r11);
    L28:
        if (r3.contains(r4, r5) == true) goto L30;
        QuickContactChildLayout r10 = this.mQuickContactView;
        r10.hideChild(-1, r10.exitAnimationEndRunnable());
        goto L42
    L30:
        int r6 = 0;
    L32:
        if (r6 >= this.mQuickContactView.getButtonCount()) goto L40;
        Rect r7 = new Rect();
        OButton r8 = this.mQuickContactView.getButtonAt(r6);
        r8.getGlobalVisibleRect(r7);
        if (r4 < (r7.left + ContactsUtils.dipTopx(getContext(), 7.0d))) goto L38;
        if (r4 > (r7.right - ContactsUtils.dipTopx(getContext(), 7.0d))) goto L38;
        this.mIndex = r6;
        this.mCacheQuickButton = r8;
        this.mIsTouchOther = false;
    L38:
        r6 = r6 + 1;
    L40:
        if (this.mIsTouchOther == false) goto L42;
        QuickContactChildLayout r13 = this.mQuickContactView;
        r13.hideChild(-1, r13.exitAnimationEndRunnable());
        goto L42
    L43:
        if (r0 == 0) goto L47;
        if (r0 != 1) goto L49;
        this.mCacheView = null;
    L49:
        return super.onTouchEvent(r11);
    L47:
        int r9 = pointToPosition((int) r11.getX(), (int) r11.getY()) - getFirstVisiblePosition();
        this.mFirstPosition = r9;
        this.mCacheView = getChildAt(r9);
        goto L49
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r2, int r3, int r4, int r5) {
        AbsListView.OnScrollListener r0 = this.mOnScrollListener;
        if (r0 == null) goto L5;
        r0.onScroll(r2, r3, r4, r5);
    L5:
        OnQuickContactListViewScrollListener r1 = this.mOnQuickContactListViewOnScrollListener;
        if (r1 == null) goto L9;
        r1.onQuickContactListViewScroll(r2, r3, r4, r5);
        return;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r2, int r3) {
        AbsListView.OnScrollListener r0 = this.mOnScrollListener;
        if (r0 == null) goto L5;
        r0.onScrollStateChanged(r2, r3);
    L5:
        OnQuickContactListViewScrollListener r1 = this.mOnQuickContactListViewOnScrollListener;
        if (r1 == null) goto L9;
        r1.onQuickContactListViewScrollStateChanged(r2, r3);
    L9:
        if (r3 != 1) goto L14;
        View r4 = this.mCacheView;
        if (r4 == null) goto L15;
        r4.setPressed(false);
        this.mCacheView = null;
        return;
    L15:
        return;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public void setHasAddedTime(boolean r1) {
        this.mHasAddedTime = r1;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public boolean hasAddedTime() {
        return this.mHasAddedTime;
    }
}
