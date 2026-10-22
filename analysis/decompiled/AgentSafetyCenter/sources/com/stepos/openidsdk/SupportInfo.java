package com.stepos.openidsdk;

import android.text.TextUtils;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class SupportInfo {
    Boolean support;
    String version;

    public boolean isCached() {
        return this.support != null;
    }

    public boolean isSameVersion(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.version, str);
    }

    public boolean isSupport() {
        Boolean bool = this.support;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public void setSupport(boolean z10) {
        this.support = Boolean.valueOf(z10);
    }

    public void setVersionName(String str) {
        this.version = str;
    }
}
