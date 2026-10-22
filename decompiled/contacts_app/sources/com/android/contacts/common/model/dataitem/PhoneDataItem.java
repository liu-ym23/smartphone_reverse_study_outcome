package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;
import android.content.Context;
import com.android.contacts.common.compat.PhoneNumberUtilsCompat;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public class PhoneDataItem extends DataItem {
    public static final String KEY_FORMATTED_PHONE_NUMBER = "formattedPhoneNumber";

    PhoneDataItem(ContentValues r1) {
        super(r1);
    }

    public String getNumber() {
        return getContentValues().getAsString("data1");
    }

    public String getNormalizedNumber() {
        return getContentValues().getAsString("data4");
    }

    public String getFormattedPhoneNumber() {
        return getContentValues().getAsString(KEY_FORMATTED_PHONE_NUMBER);
    }

    public String getLabel() {
        return getContentValues().getAsString(DBHelper.COL_DATA3);
    }

    public void computeFormattedPhoneNumber(String r3) {
        String r0 = getNumber();
        if (r0 == null) goto L6;
        String r4 = PhoneNumberUtilsCompat.formatNumber(r0, getNormalizedNumber(), r3);
        getContentValues().put(KEY_FORMATTED_PHONE_NUMBER, r4);
        return;
    }

    @Override // com.android.contacts.common.model.dataitem.DataItem
    public String buildDataStringForDisplay(Context r1, DataKind r2) {
        String r3 = getFormattedPhoneNumber();
        if (r3 == null) goto L6;
        return r3;
    L6:
        return getNumber();
    }
}
