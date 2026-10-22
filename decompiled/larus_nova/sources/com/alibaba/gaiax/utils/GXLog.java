package com.alibaba.gaiax.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u000b"}, d2 = {"Lcom/alibaba/gaiax/utils/GXLog;", "", "()V", "e", "", "msg", "", "tag", "isLog", "", "longE", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXLog {
    public static final GXLog INSTANCE = null;

    static {
        INSTANCE = new GXLog();
    }

    private GXLog() {
    }

    public final boolean isLog() {
        return GXPropUtils.INSTANCE.isLog();
    }

    public final void e(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        longE("[GaiaX]", r100);
    }

    private final void longE(String r100, String r101) {
        int r102 = r101.length() / 1000;
        if (r102 < 0) goto L11;
        int r103 = 0;
    L5:
        int r104 = r103 * 1000;
        int r105 = r103 + 1;
        int r106 = r105 * 1000;
        if (r106 <= r101.length()) goto L8;
        r106 = r101.length();
    L8:
        r101.substring(r104, r106);
        if (r103 == r102) goto L13;
        r103 = r105;
        goto L5
    L13:
        return;
    }

    public final void e(String r100, String r101) {
        if (r100 != null) goto L4;
        r100 = "[GaiaX]";
    L4:
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        longE(r100, r101);
    }
}
