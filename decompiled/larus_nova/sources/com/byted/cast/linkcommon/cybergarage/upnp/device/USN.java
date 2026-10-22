package com.byted.cast.linkcommon.cybergarage.upnp.device;

/* JADX INFO: loaded from: classes28.dex */
public class USN {
    public static final String ROOTDEVICE = "upnp:rootdevice";

    public USN() {
    }

    public static final String getUDN(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        int r101 = r100.indexOf("::");
        if (r101 >= 0) goto L10;
        return r100.trim();
    L10:
        return new String(r100.getBytes(), 0, r101).trim();
    }

    public static final boolean isRootDevice(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.endsWith("upnp:rootdevice");
    }
}
