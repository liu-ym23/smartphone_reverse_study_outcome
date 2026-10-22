package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;
import com.android.contacts.util.BytedanceContactContract;

/* JADX INFO: loaded from: classes.dex */
public class PhotoDataItem extends DataItem {
    PhotoDataItem(ContentValues r1) {
        super(r1);
    }

    public Long getPhotoFileId() {
        return getContentValues().getAsLong("data14");
    }

    public byte[] getPhoto() {
        return getContentValues().getAsByteArray(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG);
    }
}
