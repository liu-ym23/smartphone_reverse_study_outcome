package com.stepos.account.oauth.data;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes.dex */
public class AccountInfo {
    private final byte[] iconBytes;
    private final String nickName;
    private final String phone;

    public AccountInfo(String str, String str2, String str3) {
        this.nickName = str;
        this.phone = str2;
        if (TextUtils.isEmpty(str3)) {
            this.iconBytes = null;
        } else {
            this.iconBytes = str3.getBytes(StandardCharsets.ISO_8859_1);
        }
    }

    public byte[] getIconBytes() {
        return this.iconBytes;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPhone() {
        return this.phone;
    }

    public String toString() {
        return "AccountInfo{nickName='" + this.nickName + "', phone='" + this.phone + "', iconBytes=" + Arrays.toString(this.iconBytes) + '}';
    }
}
