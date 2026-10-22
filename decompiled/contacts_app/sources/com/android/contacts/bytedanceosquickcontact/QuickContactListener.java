package com.android.contacts.bytedanceosquickcontact;

/* JADX INFO: loaded from: classes.dex */
public interface QuickContactListener {
    long getQuickContactCacheId();

    QuickContactHelper getQuickContactHelperCache();

    boolean hasAddedTime();

    void hideQuickContact();

    void hideQuickContactWithoutAnimation(boolean r1);

    boolean isShowQuickContact();

    void setHasAddedTime(boolean r1);

    void setIsShowQuickContact(boolean r1);

    void setQuickContactCacheId(long r1);

    void setQuickContactClickedView(QuickContactClickedView r1);

    void setQuickContactHelperCache(QuickContactHelper r1);

    void setQuickContactView(QuickContactChildLayout r1);
}
