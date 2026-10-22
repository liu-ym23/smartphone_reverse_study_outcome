package com.stepos.openidsdk;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class ValueData {
    public int code;
    public long expired = System.currentTimeMillis() + 86400000;
    public String value;

    public ValueData(String str, int i) {
        this.value = str;
        this.code = i;
    }

    public String toString() {
        return "ValueData{value='" + this.value + "', code=" + this.code + ", expired=" + this.expired + '}';
    }
}
