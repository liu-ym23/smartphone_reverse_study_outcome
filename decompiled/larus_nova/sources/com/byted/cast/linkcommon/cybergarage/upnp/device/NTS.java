package com.byted.cast.linkcommon.cybergarage.upnp.device;

/* JADX INFO: loaded from: classes28.dex */
public class NTS {
    public static final String ALIVE = "ssdp:alive";
    public static final String BYEBYE = "ssdp:byebye";
    public static final String PROPCHANGE = "upnp:propchange";

    public NTS() {
    }

    public static final boolean isAlive(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.startsWith(ALIVE);
    }

    public static final boolean isByeBye(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.startsWith(BYEBYE);
    }
}
