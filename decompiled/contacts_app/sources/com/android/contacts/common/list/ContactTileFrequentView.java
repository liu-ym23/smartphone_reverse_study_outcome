package com.android.contacts.common.list;

import android.content.Context;
import android.util.AttributeSet;
import com.android.contacts.common.util.ViewUtil;

/* JADX INFO: loaded from: classes.dex */
public class ContactTileFrequentView extends ContactTileView {
    @Override // com.android.contacts.common.list.ContactTileView
    protected boolean isDarkTheme() {
        return false;
    }

    public ContactTileFrequentView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // com.android.contacts.common.list.ContactTileView
    protected int getApproximateImageSize() {
        return ViewUtil.getConstantPreLayoutWidth(getPhotoView());
    }
}
