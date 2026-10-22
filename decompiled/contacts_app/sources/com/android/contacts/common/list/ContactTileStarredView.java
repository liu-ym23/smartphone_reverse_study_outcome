package com.android.contacts.common.list;

import android.content.Context;
import android.util.AttributeSet;
import com.android.contacts.common.ContactPhotoManager;

/* JADX INFO: loaded from: classes.dex */
public class ContactTileStarredView extends ContactTileView {
    private static final float DEFAULT_IMAGE_LETTER_SCALE = 0.8f;

    @Override // com.android.contacts.common.list.ContactTileView
    protected boolean isDarkTheme() {
        return false;
    }

    public ContactTileStarredView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // com.android.contacts.common.list.ContactTileView
    protected int getApproximateImageSize() {
        return this.mListener.getApproximateTileWidth();
    }

    @Override // com.android.contacts.common.list.ContactTileView
    protected ContactPhotoManager.DefaultImageRequest getDefaultImageRequest(String r8, String r9) {
        return new ContactPhotoManager.DefaultImageRequest(r8, r9, 1, 0.8f, 0.0f, true);
    }
}
