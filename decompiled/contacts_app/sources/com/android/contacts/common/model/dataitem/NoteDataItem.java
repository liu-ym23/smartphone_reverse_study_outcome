package com.android.contacts.common.model.dataitem;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes.dex */
public class NoteDataItem extends DataItem {
    NoteDataItem(ContentValues r1) {
        super(r1);
    }

    public String getNote() {
        return getContentValues().getAsString("data1");
    }
}
