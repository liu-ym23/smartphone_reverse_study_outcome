package com.stepos.openidsdk;

/* loaded from: classes.dex */
class ValueData {
    public int code;
    public long expired = System.currentTimeMillis() + com.stepos.pps.data.util.Constants.CLEAN_CHECK_INTERVAL;
    public String value;

    public ValueData(String str, int i) {
        this.value = str;
        this.code = i;
    }

    public String toString() {
        return "ValueData{value='" + this.value + "', code=" + this.code + ", expired=" + this.expired + '}';
    }
}
