package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public class StructuredNameDataItem extends DataItem {
    public StructuredNameDataItem() {
        super(new ContentValues());
        getContentValues().put("mimetype", "vnd.android.cursor.item/name");
    }

    StructuredNameDataItem(ContentValues r1) {
        super(r1);
    }

    public String getDisplayName() {
        return getContentValues().getAsString("data1");
    }

    public void setDisplayName(String r2) {
        getContentValues().put("data1", r2);
    }

    public String getGivenName() {
        return getContentValues().getAsString(DBHelper.COL_DATA2);
    }

    public String getFamilyName() {
        return getContentValues().getAsString(DBHelper.COL_DATA3);
    }

    public String getPrefix() {
        return getContentValues().getAsString("data4");
    }

    public String getMiddleName() {
        return getContentValues().getAsString("data5");
    }

    public String getSuffix() {
        return getContentValues().getAsString("data6");
    }

    public String getPhoneticGivenName() {
        return getContentValues().getAsString("data7");
    }

    public String getPhoneticMiddleName() {
        return getContentValues().getAsString("data8");
    }

    public String getPhoneticFamilyName() {
        return getContentValues().getAsString("data9");
    }

    public String getFullNameStyle() {
        return getContentValues().getAsString("data10");
    }

    public void setPhoneticFamilyName(String r2) {
        getContentValues().put("data9", r2);
    }

    public void setPhoneticMiddleName(String r2) {
        getContentValues().put("data8", r2);
    }

    public void setPhoneticGivenName(String r2) {
        getContentValues().put("data7", r2);
    }

    @Override // com.android.contacts.common.model.dataitem.DataItem
    public boolean isSuperPrimary() {
        ContentValues r2 = getContentValues();
        if (r2 != null) goto L5;
    L8:
        return false;
    L5:
        if (r2.containsKey("is_super_primary") == false) goto L8;
        return r2.getAsBoolean("is_super_primary").booleanValue();
    }
}
