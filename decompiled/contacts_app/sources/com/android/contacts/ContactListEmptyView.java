package com.android.contacts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes.dex */
public class ContactListEmptyView extends ScrollView {
    private static final String TAG = "ContactListEmptyView";

    public void hide() {
    }

    public void show(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7) {
    }

    public ContactListEmptyView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    private boolean isSyncActive() {
        Account[] r0 = AccountManager.get(getContext()).getAccounts();
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (r0.length <= 0) goto L13;
        int r2 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L13;
        if (ReflectUtils.isSyncActive(getContext(), r0[r3], "com.android.contacts") == true) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return true;
    }
}
