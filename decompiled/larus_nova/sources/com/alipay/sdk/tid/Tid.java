package com.alipay.sdk.tid;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes28.dex */
public class Tid {
    public final String key;
    public final String tid;
    public final long time;

    public String getTid() {
        return this.tid;
    }

    public String getTidSeed() {
        return this.key;
    }

    public long getTimestamp() {
        return this.time;
    }

    public static boolean isEmpty(Tid r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (TextUtils.isEmpty(r100.tid) == true) goto L7;
        return false;
    }

    public Tid(String r100, String r101, long r102) {
        this.tid = r100;
        this.key = r101;
        this.time = r102;
    }
}
