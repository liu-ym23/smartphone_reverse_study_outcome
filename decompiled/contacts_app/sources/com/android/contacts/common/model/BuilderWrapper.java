package com.android.contacts.common.model;

import android.content.ContentProviderOperation;

/* JADX INFO: loaded from: classes.dex */
public class BuilderWrapper {
    private ContentProviderOperation.Builder mBuilder;
    private int mType;

    public BuilderWrapper(ContentProviderOperation.Builder r1, int r2) {
        this.mBuilder = r1;
        this.mType = r2;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int r1) {
        this.mType = r1;
    }

    public ContentProviderOperation.Builder getBuilder() {
        return this.mBuilder;
    }

    public void setBuilder(ContentProviderOperation.Builder r1) {
        this.mBuilder = r1;
    }
}
