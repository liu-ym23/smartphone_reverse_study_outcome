package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public class OrganizationDataItem extends DataItem {
    OrganizationDataItem(ContentValues r1) {
        super(r1);
    }

    public String getCompany() {
        return getContentValues().getAsString("data1");
    }

    public String getLabel() {
        return getContentValues().getAsString(DBHelper.COL_DATA3);
    }

    public String getTitle() {
        return getContentValues().getAsString("data4");
    }

    public String getDepartment() {
        return getContentValues().getAsString("data5");
    }

    public String getJobDescription() {
        return getContentValues().getAsString("data6");
    }

    public String getSymbol() {
        return getContentValues().getAsString("data7");
    }

    public String getPhoneticName() {
        return getContentValues().getAsString("data8");
    }

    public String getOfficeLocation() {
        return getContentValues().getAsString("data9");
    }
}
