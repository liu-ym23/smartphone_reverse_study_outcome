package com.stepos.openidsdk;

import android.text.TextUtils;

/* loaded from: classes.dex */
class SupportInfo {
    Boolean support;
    String version;

    SupportInfo() {
    }

    boolean isSameVersion(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.version, str);
    }

    void setVersionName(String str) {
        this.version = str;
    }

    boolean isCached() {
        return this.support != null;
    }

    boolean isSupport() {
        Boolean bool = this.support;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    void setSupport(boolean z) {
        this.support = Boolean.valueOf(z);
    }
}
