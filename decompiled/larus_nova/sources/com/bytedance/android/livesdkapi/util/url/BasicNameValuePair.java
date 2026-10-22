package com.bytedance.android.livesdkapi.util.url;

import com.bytedance.android.livesdkapi.util.LangUtils;
import com.huawei.hms.framework.common.ContainerUtils;

/* JADX INFO: loaded from: classes12.dex */
public class BasicNameValuePair implements NameValuePair, Cloneable {
    private final String name;
    private final String value;

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
    }

    public String toString() {
        int r100 = this.name.length();
        String r101 = this.value;
        if (r101 == null) goto L5;
        r100 = r100 + (r101.length() + 1);
    L5:
        CharArrayBuffer r102 = new CharArrayBuffer(r100);
        r102.append(this.name);
        if (this.value == null) goto L9;
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(this.value);
    L9:
        return r102.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // com.bytedance.android.livesdkapi.util.url.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.android.livesdkapi.util.url.NameValuePair
    public String getValue() {
        return this.value;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((r100 instanceof NameValuePair) == false) goto L16;
        BasicNameValuePair r101 = (BasicNameValuePair) r100;
        if (this.name.equals(r101.name) == true) goto L13;
        return false;
    L13:
        if (LangUtils.equals(this.value, r101.value) == false) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    }

    public BasicNameValuePair(String r100, String r101) {
        if (r100 == null) goto L7;
        this.name = r100;
        this.value = r101;
        return;
    L7:
        throw new IllegalArgumentException("Name may not be null");
    }
}
