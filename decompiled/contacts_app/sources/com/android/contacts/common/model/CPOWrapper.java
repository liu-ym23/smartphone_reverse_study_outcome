package com.android.contacts.common.model;

import android.content.ContentProviderOperation;

/* JADX INFO: loaded from: classes.dex */
public class CPOWrapper {
    private ContentProviderOperation mOperation;
    private int mType;

    public CPOWrapper(ContentProviderOperation r1, int r2) {
        this.mOperation = r1;
        this.mType = r2;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int r1) {
        this.mType = r1;
    }

    public ContentProviderOperation getOperation() {
        return this.mOperation;
    }

    public void setOperation(ContentProviderOperation r1) {
        this.mOperation = r1;
    }
}
