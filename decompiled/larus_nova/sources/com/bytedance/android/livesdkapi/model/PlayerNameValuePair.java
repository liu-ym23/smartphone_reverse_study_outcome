package com.bytedance.android.livesdkapi.model;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes12.dex */
public class PlayerNameValuePair implements Cloneable, Serializable {
    public static final int HASH_OFFSET = 37;
    public static final int HASH_SEED = 17;
    private static final long serialVersionUID = -6437800749411518984L;
    private final String name;
    private final String value;

    public int hashCode1(int r100, int r101) {
        return (r100 * 37) + r101;
    }

    public int hashCode() {
        return hashCode2(hashCode2(17, this.name), this.value);
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

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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
        if ((r100 instanceof PlayerNameValuePair) == false) goto L14;
        PlayerNameValuePair r101 = (PlayerNameValuePair) r100;
        if (this.name.equals(r101.name) == true) goto L10;
    L12:
        return false;
    L10:
        if (innerEquals(this.value, r101.value) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public PlayerNameValuePair(String r100, String r101) {
        if (r100 == null) goto L7;
        this.name = r100;
        this.value = r101;
        return;
    L7:
        throw new IllegalArgumentException("Name may not be null");
    }

    public int hashCode2(int r100, Object r101) {
        if (r101 == null) goto L4;
        int r102 = r101.hashCode();
    L6:
        return hashCode1(r100, r102);
    L4:
        r102 = 0;
        goto L6
    }

    public boolean innerEquals(Object r100, Object r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r100.equals(r101);
    }
}
