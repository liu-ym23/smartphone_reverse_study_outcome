package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public class EventDataItem extends DataItem {
    @Override // com.android.contacts.common.model.dataitem.DataItem, com.android.contacts.common.Collapser.Collapsible
    public /* bridge */ /* synthetic */ boolean shouldCollapseWith(DataItem r1, Context r2) {
        return shouldCollapseWith(r1, r2);
    }

    EventDataItem(ContentValues r1) {
        super(r1);
    }

    public String getStartDate() {
        return getContentValues().getAsString("data1");
    }

    public String getLabel() {
        return getContentValues().getAsString(DBHelper.COL_DATA3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.contacts.common.model.dataitem.DataItem
    public boolean shouldCollapseWith(DataItem r4, Context r5) {
        if ((r4 instanceof EventDataItem) == true) goto L5;
        return false;
    L5:
        if (this.mKind != null) goto L7;
        return false;
    L7:
        if (r4.getDataKind() == null) goto L33;
        EventDataItem r6 = (EventDataItem) r4;
        if (TextUtils.equals(getStartDate(), r6.getStartDate()) == true) goto L13;
        return false;
    L13:
        if (hasKindTypeColumn(this.mKind) == false) goto L27;
        if (r6.hasKindTypeColumn(r6.getDataKind()) == false) goto L27;
        if (getKindTypeColumn(this.mKind) == r6.getKindTypeColumn(r6.getDataKind())) goto L21;
        return false;
    L21:
        if (getKindTypeColumn(this.mKind) == 0) goto L23;
    L25:
        return true;
    L23:
        if (TextUtils.equals(getLabel(), r6.getLabel()) == true) goto L25;
        return false;
    L27:
        if (hasKindTypeColumn(this.mKind) == r6.hasKindTypeColumn(r6.getDataKind())) goto L29;
        return false;
    L29:
        return true;
    L33:
        return false;
    }
}
