package com.android.ttcjpaysdk.base.paymentbasis.common;

/* JADX INFO: loaded from: classes28.dex */
public class CJPairObject implements Cloneable {
    private final String name;
    private final String value;

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public CJPairObject(String r100, String r101) {
        if (r100 == null) goto L7;
        this.name = r100;
        this.value = r101;
        return;
    L7:
        throw new IllegalArgumentException("Name may not be null");
    }
}
