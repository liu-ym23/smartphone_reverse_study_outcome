package com.alipay.android.app.helper;

/* JADX INFO: loaded from: classes28.dex */
public class Tid extends com.alipay.sdk.tid.Tid {
    public static Tid fromRealTidModel(com.alipay.sdk.tid.Tid r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new Tid(r100.getTid(), r100.getTidSeed(), r100.getTimestamp());
    }

    public Tid(String r100, String r101, long r102) {
        super(r100, r101, r102);
    }
}
