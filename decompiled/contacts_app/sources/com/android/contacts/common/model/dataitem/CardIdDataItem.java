package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;
import android.content.res.Resources;
import com.android.contacts.common.R;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public class CardIdDataItem extends DataItem {
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/card_id";
    public static final int TYPE_BANK = 2;
    public static final int TYPE_DRIVE = 3;
    public static final int TYPE_IDENTITY = 1;

    CardIdDataItem(ContentValues r1) {
        super(r1);
    }

    public static final CharSequence getTypeLabel(Resources r0, int r1, CharSequence r2) {
        return r0.getText(getTypeLabelResource(r1));
    }

    public static final int getTypeLabelResource(int r1) {
        if (r1 == 1) goto L9;
        if (r1 == 3) goto L11;
        return R.string.cardIdBank;
    L11:
        return R.string.cardIdDrive;
    L9:
        return R.string.cardIdIdentity;
    }

    public String getData() {
        return getContentValues().getAsString("data1");
    }

    public String getLabel() {
        return getContentValues().getAsString(DBHelper.COL_DATA3);
    }

    public int getCardType() {
        if (getContentValues().getAsInteger(DBHelper.COL_DATA2) != null) goto L5;
        return -1;
    L5:
        return getContentValues().getAsInteger(DBHelper.COL_DATA2).intValue();
    }

    public long getRefId() {
        if (getContentValues().getAsLong(DBHelper.COL_DATA3) != null) goto L5;
        return -1;
    L5:
        return getContentValues().getAsLong(DBHelper.COL_DATA3).longValue();
    }
}
