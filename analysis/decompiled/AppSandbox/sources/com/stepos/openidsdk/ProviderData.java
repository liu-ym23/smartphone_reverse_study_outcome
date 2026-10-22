package com.stepos.openidsdk;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class ProviderData {
    private String authorities;
    private boolean isValid;
    private String openIdChangePermission;
    private String packageName;
    private String url;

    public ProviderData(String str, boolean z) {
        this.packageName = str;
        boolean zIsEmpty = TextUtils.isEmpty(str);
        this.isValid = !zIsEmpty;
        if (zIsEmpty) {
            return;
        }
        if (z) {
            this.openIdChangePermission = "com.stepos.openid.permission.SECURESERVICE_OPEN_ID_CHANGE";
            this.authorities = "com.stepos.secureservice.openidsdk";
            this.url = "content://com.stepos.secureservice.openidsdk/";
        } else {
            this.openIdChangePermission = "com.stepos.openid.permission.OPEN_ID_CHANGE";
            this.authorities = "com.stepos.openidsdk";
            this.url = "content://com.stepos.openidsdk/";
        }
    }

    public boolean isValid() {
        return this.isValid;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getOpenIdChangePermission() {
        return this.openIdChangePermission;
    }

    public String getAuthorities() {
        return this.authorities;
    }

    public String getUrl() {
        return this.url;
    }
}
