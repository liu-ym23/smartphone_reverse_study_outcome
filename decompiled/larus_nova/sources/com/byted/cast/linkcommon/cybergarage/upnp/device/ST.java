package com.byted.cast.linkcommon.cybergarage.upnp.device;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes28.dex */
public class ST {
    public static final String ALL_DEVICE = "ssdp:all";
    public static final String AV_TRANSPORT = "urn:schemas-upnp-org:service:AVTransport:1";
    public static final String AV_TRANSPORT_NO_VERSION = "urn:schemas-upnp-org:service:AVTransport";
    public static final String DIAL_DEVICE = "urn:dial-multiscreen-org:service:dial:1";
    public static final String MEDIA_RENDERER = "urn:schemas-upnp-org:device:MediaRenderer:1";
    public static final String MEDIA_RENDERER_NO_VERSION = "urn:schemas-upnp-org:device:MediaRenderer";
    public static final String ROOT_DEVICE = "upnp:rootdevice";
    public static final String URN_DEVICE = "urn:schemas-upnp-org:device:";
    public static final String URN_SERVICE = "urn:schemas-upnp-org:service:";
    public static final String UUID_DEVICE = "uuid";

    public ST() {
    }

    public static final boolean hasAvtransportService(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return r100.contains("urn:schemas-upnp-org:service:AVTransport");
    }

    public static final boolean isAllDevice(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.equals(ALL_DEVICE) != true) goto L9;
        return true;
    L9:
        return r100.equals("\"ssdp:all\"");
    }

    public static final boolean isDIALDevice(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return r100.contains(DIAL_DEVICE);
    }

    public static final boolean isMediaRenderDevice(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return r100.contains(MEDIA_RENDERER_NO_VERSION);
    }

    public static final boolean isRootDevice(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.equals("upnp:rootdevice") != true) goto L9;
        return true;
    L9:
        return r100.equals("\"upnp:rootdevice\"");
    }

    public static final boolean isURNDevice(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.startsWith(URN_DEVICE) != true) goto L9;
        return true;
    L9:
        return r100.startsWith("\"urn:schemas-upnp-org:device:");
    }

    public static final boolean isURNService(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.startsWith(URN_SERVICE) != true) goto L9;
        return true;
    L9:
        return r100.startsWith("\"urn:schemas-upnp-org:service:");
    }

    public static final boolean isUUIDDevice(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.startsWith(UUID_DEVICE) != true) goto L9;
        return true;
    L9:
        return r100.startsWith("\"uuid");
    }
}
