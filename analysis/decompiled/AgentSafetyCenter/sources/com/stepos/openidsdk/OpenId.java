package com.stepos.openidsdk;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class OpenId {
    int code;
    long expiredTime;
    String type;
    String value;

    public OpenId(String str) {
        this.type = str;
    }

    public boolean isValid() {
        return this.expiredTime > System.currentTimeMillis();
    }

    public void setDataExpired() {
        this.expiredTime = 0L;
    }

    public void updateCode(int i) {
        this.code = i;
    }

    public void updateExpiredTime(long j10) {
        this.expiredTime = j10;
    }

    public void updateValue(String str) {
        this.value = str;
    }
}
