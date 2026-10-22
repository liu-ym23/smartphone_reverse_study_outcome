package com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    public static final String a(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r100 != null) goto L15;
    L17:
        return "";
    L15:
        if (r100.intValue() != 2) goto L17;
        return "official";
    L10:
        if (r100.intValue() != 1) goto L12;
        return "video";
    L5:
        if (r100.intValue() != 0) goto L7;
        return "live";
    }
}
