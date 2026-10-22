package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public class NicknameDataItem extends DataItem {
    public NicknameDataItem(ContentValues r1) {
        super(r1);
    }

    public String getName() {
        return getContentValues().getAsString("data1");
    }

    public String getLabel() {
        return getContentValues().getAsString(DBHelper.COL_DATA3);
    }
}
