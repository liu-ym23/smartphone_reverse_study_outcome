package com.android.contacts.bytedanceosquickcontact;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface QuickContactListAdapterListener {
    Activity getActivity();

    Context getContext();

    QuickContactListener getQuickContactListener();

    void setQuickContactListener(QuickContactListener r1);
}
