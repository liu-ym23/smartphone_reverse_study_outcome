package com.bytedance.apm.entity;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class LocalVersionInfo {
    public String appVersion;
    public long id;
    public String manifestVersionCode;
    public String updateVersionCode;
    public String versionCode;
    public String versionName;

    public LocalVersionInfo(long r1, String r3, String r4, String r5, String r6, String r7) {
        this.id = r1;
        this.versionCode = r3;
        this.versionName = r4;
        this.manifestVersionCode = r5;
        this.updateVersionCode = r6;
        this.appVersion = r7;
    }

    public LocalVersionInfo(String r1, String r2, String r3, String r4, String r5) {
        this.versionCode = r1;
        this.versionName = r2;
        this.manifestVersionCode = r3;
        this.updateVersionCode = r4;
        this.appVersion = r5;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        LocalVersionInfo r6 = (LocalVersionInfo) r5;
        if (TextUtils.equals(this.versionCode, r6.versionCode) == false) goto L23;
        if (TextUtils.equals(this.versionName, r6.versionName) == false) goto L23;
        if (TextUtils.equals(this.manifestVersionCode, r6.manifestVersionCode) == false) goto L23;
        if (TextUtils.equals(this.updateVersionCode, r6.updateVersionCode) == false) goto L23;
        if (TextUtils.equals(this.appVersion, r6.appVersion) == false) goto L23;
        return true;
    L23:
        return false;
    }

    public int hashCode() {
        return (((hashCode(this.versionCode) + hashCode(this.versionName)) + hashCode(this.manifestVersionCode)) + hashCode(this.updateVersionCode)) + hashCode(this.appVersion);
    }

    private static int hashCode(Object r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }
}
