package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public class EmailDataItem extends DataItem {
    EmailDataItem(ContentValues r1) {
        super(r1);
    }

    public String getAddress() {
        return getContentValues().getAsString("data1");
    }

    public String getDisplayName() {
        return getContentValues().getAsString("data4");
    }

    public String getData() {
        return getContentValues().getAsString("data1");
    }

    public String getLabel() {
        return getContentValues().getAsString(DBHelper.COL_DATA3);
    }
}
