package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes.dex */
public class GroupMembershipDataItem extends DataItem {
    GroupMembershipDataItem(ContentValues r1) {
        super(r1);
    }

    public Long getGroupRowId() {
        return getContentValues().getAsLong("data1");
    }

    public String getGroupSourceId() {
        return getContentValues().getAsString("group_sourceid");
    }
}
