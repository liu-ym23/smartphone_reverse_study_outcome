package com.android.contacts.list;

import android.view.View;
import android.widget.ListView;
import com.android.contacts.widget.TextHighlightingAnimation;

/* JADX INFO: loaded from: classes2.dex */
public class ContactNameHighlightingAnimation extends TextHighlightingAnimation {
    private final ListView mListView;
    private boolean mSavedScrollingCacheEnabledFlag;

    public ContactNameHighlightingAnimation(ListView r1, int r2) {
        super(r2);
        this.mListView = r1;
    }

    @Override // com.android.contacts.widget.TextHighlightingAnimation
    protected void invalidate() {
        int r0 = this.mListView.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = this.mListView.getChildAt(r1);
        if ((r2 instanceof ContactListItemView) == false) goto L7;
        ((ContactListItemView) r2).getNameTextView().invalidate();
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.android.contacts.widget.TextHighlightingAnimation
    protected void onAnimationStarted() {
        this.mSavedScrollingCacheEnabledFlag = this.mListView.isScrollingCacheEnabled();
        this.mListView.setScrollingCacheEnabled(false);
    }

    @Override // com.android.contacts.widget.TextHighlightingAnimation
    protected void onAnimationEnded() {
        this.mListView.setScrollingCacheEnabled(this.mSavedScrollingCacheEnabledFlag);
    }
}
