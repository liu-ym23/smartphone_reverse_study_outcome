package com.bytedance.android.livesdk.log;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class l0 {
    public static String a(String r100, com.bytedance.android.livesdk.log.filter.o r101) {
        if (r101 != null) goto L5;
        return "";
    L5:
        String r102 = r101.getMap().get(r100);
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    }
}
