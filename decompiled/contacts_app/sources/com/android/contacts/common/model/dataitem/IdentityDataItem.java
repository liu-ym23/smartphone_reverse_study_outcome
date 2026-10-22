package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public class IdentityDataItem extends DataItem {
    IdentityDataItem(ContentValues r1) {
        super(r1);
    }

    public String getIdentity() {
        return getContentValues().getAsString("data1");
    }

    public String getNamespace() {
        return getContentValues().getAsString(DBHelper.COL_DATA2);
    }
}
