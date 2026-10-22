package com.android.contacts.common.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.android.contacts.common.util.ViewUtil;

/* JADX INFO: loaded from: classes.dex */
public class ContactTilePhoneFrequentView extends ContactTileView {
    private String mPhoneNumberString;

    @Override // com.android.contacts.common.list.ContactTileView
    protected boolean isDarkTheme() {
        return true;
    }

    static /* synthetic */ String access$000(ContactTilePhoneFrequentView r0) {
        return r0.mPhoneNumberString;
    }

    public ContactTilePhoneFrequentView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // com.android.contacts.common.list.ContactTileView
    protected int getApproximateImageSize() {
        return ViewUtil.getConstantPreLayoutWidth(getQuickContact());
    }

    @Override // com.android.contacts.common.list.ContactTileView
    public void loadFromContact(ContactEntry r2) {
        super.loadFromContact(r2);
        this.mPhoneNumberString = null;
        if (r2 == null) goto L6;
        this.mPhoneNumberString = r2.phoneNumber;
        return;
    }

    @Override // com.android.contacts.common.list.ContactTileView
    protected View.OnClickListener createClickListener() {
        return new AnonymousClass1(this);
    }
}
