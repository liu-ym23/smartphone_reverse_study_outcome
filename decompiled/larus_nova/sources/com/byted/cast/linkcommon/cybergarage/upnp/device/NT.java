package com.byted.cast.linkcommon.cybergarage.upnp.device;

/* JADX INFO: loaded from: classes28.dex */
public class NT {
    public static final String EVENT = "upnp:event";
    public static final String ROOTDEVICE = "upnp:rootdevice";

    public NT() {
    }

    public static final boolean isRootDevice(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.startsWith("upnp:rootdevice");
    }
}
