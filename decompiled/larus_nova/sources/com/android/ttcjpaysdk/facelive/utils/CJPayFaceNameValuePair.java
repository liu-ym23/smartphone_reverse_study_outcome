package com.android.ttcjpaysdk.facelive.utils;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayFaceNameValuePair implements Cloneable, Serializable {
    private static final long serialVersionUID = -6437800749411518984L;
    private final String name;
    private final String value;

    public int hashCode() {
        return CJPayFaceLangUtils.hashCode(CJPayFaceLangUtils.hashCode(17, this.name), this.value);
    }

    public String toString() {
        if (this.value == null) goto L5;
        StringBuilder r100 = new StringBuilder((this.name.length() + 1) + this.value.length());
        r100.append(this.name);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(this.value);
        return r100.toString();
    L5:
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayFaceNameValuePair) == false) goto L14;
        CJPayFaceNameValuePair r101 = (CJPayFaceNameValuePair) r100;
        if (this.name.equals(r101.name) == true) goto L10;
    L12:
        return false;
    L10:
        if (CJPayFaceLangUtils.equals(this.value, r101.value) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public CJPayFaceNameValuePair(String r100, String r101) {
        if (r100 == null) goto L7;
        this.name = r100;
        this.value = r101;
        return;
    L7:
        throw new IllegalArgumentException("Name may not be null");
    }
}
