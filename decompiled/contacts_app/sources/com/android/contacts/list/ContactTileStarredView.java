package com.android.contacts.list;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes2.dex */
public class ContactTileStarredView extends ContactTileView {
    private static final String TAG = "ContactTileStarredView";

    @Override // com.android.contacts.list.ContactTileView
    protected boolean isDefaultIconHires() {
        return true;
    }

    public ContactTileStarredView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
