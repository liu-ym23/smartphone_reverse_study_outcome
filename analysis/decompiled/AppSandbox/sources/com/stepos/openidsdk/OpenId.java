package com.stepos.openidsdk;

/* loaded from: classes.dex */
class OpenId {
    int code;
    long expiredTime;
    String type;
    String value;

    OpenId(String str) {
        this.type = str;
    }

    void updateValue(String str) {
        this.value = str;
    }

    void updateExpiredTime(long j) {
        this.expiredTime = j;
    }

    void updateCode(int i) {
        this.code = i;
    }

    boolean isValid() {
        return this.expiredTime > System.currentTimeMillis();
    }

    void setDataExpired() {
        this.expiredTime = 0L;
    }
}
