package com.android.contacts.list;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class ContactTileSecondaryTargetView extends ContactTileStarredView {
    private static final String TAG = "ContactTileSecondaryTargetView";
    private ImageButton mSecondaryButton;

    @Override // com.android.contacts.list.ContactTileView
    protected boolean isDarkTheme() {
        return true;
    }

    public ContactTileSecondaryTargetView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // com.android.contacts.list.ContactTileView, com.android.contacts.bytedanceosquickcontact.QuickContactChildLayout, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ImageButton r0 = (ImageButton) findViewById(R.id.contact_tile_secondary_button);
        this.mSecondaryButton = r0;
        r0.setOnClickListener(new AnonymousClass1(this));
    }
}
