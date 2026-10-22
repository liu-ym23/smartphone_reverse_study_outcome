package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;
import android.content.res.Resources;
import com.android.contacts.common.R;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes.dex */
public class GenderDataItem extends DataItem {
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/gender";
    public static final int TYPE_FEMALE = 2;
    public static final int TYPE_MALE = 1;
    public static final int TYPE_NOT_SET = 0;

    GenderDataItem(ContentValues r1) {
        super(r1);
    }

    public static CharSequence getTypeLabel(Resources r0, int r1, CharSequence r2) {
        return r0.getText(getTypeLabelResource(r1));
    }

    public static int getTypeLabelResource(int r1) {
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L11;
        return R.string.unknown;
    L11:
        return R.string.genderFemale;
    L9:
        return R.string.genderMale;
    }

    public String getData() {
        return getContentValues().getAsString("data1");
    }

    public String getLabel() {
        return getContentValues().getAsString(DBHelper.COL_DATA3);
    }
}
