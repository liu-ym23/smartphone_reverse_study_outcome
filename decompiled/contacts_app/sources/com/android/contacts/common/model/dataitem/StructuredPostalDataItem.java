package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public class StructuredPostalDataItem extends DataItem {
    StructuredPostalDataItem(ContentValues r1) {
        super(r1);
    }

    public String getFormattedAddress() {
        return getContentValues().getAsString("data1");
    }

    public String getLabel() {
        return getContentValues().getAsString(DBHelper.COL_DATA3);
    }

    public String getStreet() {
        return getContentValues().getAsString("data4");
    }

    public String getPOBox() {
        return getContentValues().getAsString("data5");
    }

    public String getNeighborhood() {
        return getContentValues().getAsString("data6");
    }

    public String getCity() {
        return getContentValues().getAsString("data7");
    }

    public String getRegion() {
        return getContentValues().getAsString("data8");
    }

    public String getPostcode() {
        return getContentValues().getAsString("data9");
    }

    public String getCountry() {
        return getContentValues().getAsString("data10");
    }
}
