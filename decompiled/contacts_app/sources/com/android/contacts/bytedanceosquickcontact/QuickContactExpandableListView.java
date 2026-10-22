package com.android.contacts.bytedanceosquickcontact;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ExpandableListAdapter;
import com.android.contacts.ContactsUtils;
import com.android.contacts.list.ExpandListView;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes.dex */
public class QuickContactExpandableListView extends ExpandListView implements QuickContactListener {
    private OButton mCacheQuickButton;
    private int mIndex;
    private boolean mIsShowQuickContact;
    private boolean mIsTouchOther;
    private QuickContactClickedView mQuickContactClickedView;
    private long mQuickContactDataIdCache;
    private QuickContactHelper mQuickContactHelperCache;
    private QuickContactChildLayout mQuickContactView;

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public boolean hasAddedTime() {
        return false;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public void setHasAddedTime(boolean r1) {
    }

    public QuickContactExpandableListView(Context r3) {
        super(r3);
        this.mIsShowQuickContact = false;
        this.mIsTouchOther = true;
        this.mIndex = -1;
        this.mQuickContactDataIdCache = -1;
        setOverScrollMode(0);
    }

    public QuickContactExpandableListView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mIsShowQuickContact = false;
        this.mIsTouchOther = true;
        this.mIndex = -1;
        this.mQuickContactDataIdCache = -1;
        setOverScrollMode(0);
    }

    public QuickContactExpandableListView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mIsShowQuickContact = false;
        this.mIsTouchOther = true;
        this.mIndex = -1;
        this.mQuickContactDataIdCache = -1;
        setOverScrollMode(0);
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
        this.mQuickContactDataIdCache = r1;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public long getQuickContactCacheId() {
        return this.mQuickContactDataIdCache;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public void setQuickContactView(QuickContactChildLayout r1) {
        this.mQuickContactView = r1;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public void setIsShowQuickContact(boolean r2) {
        if (r2 == true) goto L4;
        this.mQuickContactView = null;
    L4:
        this.mIsShowQuickContact = r2;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public void hideQuickContact() {
        restoreScrollState(false);
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public boolean isShowQuickContact() {
        return this.mIsShowQuickContact;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public void setQuickContactClickedView(QuickContactClickedView r1) {
        this.mQuickContactClickedView = r1;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public void setQuickContactHelperCache(QuickContactHelper r1) {
        this.mQuickContactHelperCache = r1;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListener
    public QuickContactHelper getQuickContactHelperCache() {
        return this.mQuickContactHelperCache;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        super.onLayout(r6, r7, r8, r9, r10);
        if (getAdapter() != null) goto L5;
        return;
    L5:
        if (this.mQuickContactDataIdCache == (-1)) goto L32;
        ExpandableListAdapter r11 = getExpandableListAdapter();
        int r12 = 0;
        boolean r0 = false;
        int r1 = 0;
    L8:
        if (r12 >= r11.getGroupCount()) goto L22;
        r1 = r1 + 1;
        if (isGroupExpanded(r12) == false) goto L21;
        int r3 = 0;
    L13:
        if (r3 >= r11.getChildrenCount(r12)) goto L21;
        r1 = r1 + 1;
        if (r1 > getLastVisiblePosition()) goto L21;
        if (hasCache(r11, r1, r12, r3) == true) goto L19;
        r3 = r3 + 1;
        goto L13
    L19:
        r0 = true;
    L21:
        r12 = r12 + 1;
        goto L8
    L22:
        if (r0 == true) goto L33;
        this.mQuickContactDataIdCache = -1;
        this.mQuickContactHelperCache = null;
        return;
    L33:
        return;
    }

    public boolean hasCache(ExpandableListAdapter r5, int r6, int r7, int r8) {
        if (r6 >= getFirstVisiblePosition()) goto L5;
    L8:
        return false;
    L5:
        if (this.mQuickContactDataIdCache != r5.getChildId(r7, r8)) goto L8;
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        if (r3 != 4) goto L5;
    L6:
        this.mQuickContactDataIdCache = -1;
        this.mQuickContactHelperCache = null;
        return;
    L5:
        if (r3 == 8) goto L6;
    }

    @Override // com.android.contacts.list.ExpandListView, com.android.contacts.list.HorizontalScrollExpandableListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.mIsShowQuickContact == false) goto L11;
        if (r2.getAction() != 0) goto L7;
        return true;
    L7:
        return super.onInterceptTouchEvent(r2);
    L11:
        return super.onInterceptTouchEvent(r2);
    }

    @Override // com.android.contacts.list.ExpandListView, com.android.contacts.list.HorizontalScrollExpandableListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r11) {
        if (this.mIsShowQuickContact == false) goto L41;
        QuickContactChildLayout r0 = this.mQuickContactView;
        if (r0 != null) goto L8;
        return true;
    L8:
        if (r0.isAnimationing() == false) goto L10;
        return true;
    L10:
        int r1 = r11.getAction();
        Rect r2 = new Rect();
        this.mQuickContactView.getGlobalVisibleRect(r2);
        int r3 = (int) r11.getRawX();
        int r4 = (int) r11.getRawY();
        if (r1 == 0) goto L25;
        if (r1 == 1) goto L18;
        if (r1 == 3) goto L16;
        super.onTouchEvent(r11);
    L39:
        return true;
    L16:
        this.mIsTouchOther = true;
        super.onTouchEvent(r11);
        goto L39
    L18:
        if (this.mIsTouchOther == true) goto L20;
        this.mIsTouchOther = true;
        Rect r12 = new Rect();
        this.mCacheQuickButton.getGlobalVisibleRect(r12);
        if (r12.contains(r3, r4) == false) goto L39;
        this.mCacheQuickButton.performClick();
        this.mQuickContactClickedView.setClicked(this.mIndex, r12.left, r12.top);
        goto L39
    L20:
        return super.onTouchEvent(r11);
    L25:
        if (r2.contains(r3, r4) == true) goto L27;
        QuickContactChildLayout r10 = this.mQuickContactView;
        r10.hideChild(-1, r10.exitAnimationEndRunnable());
        goto L39
    L27:
        int r5 = 0;
    L29:
        if (r5 >= this.mQuickContactView.getButtonCount()) goto L37;
        Rect r6 = new Rect();
        OButton r7 = this.mQuickContactView.getButtonAt(r5);
        r7.getGlobalVisibleRect(r6);
        if (r3 < (r6.left + ContactsUtils.dipTopx(getContext(), 7.0d))) goto L35;
        if (r3 > (r6.right - ContactsUtils.dipTopx(getContext(), 7.0d))) goto L35;
        this.mIndex = r5;
        this.mCacheQuickButton = r7;
        this.mIsTouchOther = false;
    L35:
        r5 = r5 + 1;
    L37:
        if (this.mIsTouchOther == false) goto L39;
        QuickContactChildLayout r13 = this.mQuickContactView;
        r13.hideChild(-1, r13.exitAnimationEndRunnable());
        goto L39
    L41:
        return super.onTouchEvent(r11);
    }
}
