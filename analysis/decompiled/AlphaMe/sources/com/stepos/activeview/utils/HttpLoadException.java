package com.stepos.activeview.utils;

/* loaded from: classes.dex */
public class HttpLoadException extends Exception {
    private boolean mHasResponseCode;
    private int mResponseCode;

    public HttpLoadException(int i4, String str) {
        super(str);
        this.mResponseCode = i4;
        this.mHasResponseCode = true;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public boolean hasHttpResponseCode() {
        return this.mHasResponseCode;
    }

    public HttpLoadException(String str) {
        super(str);
        this.mHasResponseCode = false;
    }
}
