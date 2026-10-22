package com.byted.cast.linkcommon.cybergarage.upnp.event;

import com.byted.cast.linkcommon.cybergarage.upnp.UPnP;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: classes28.dex */
public class Subscription {
    public static final String INFINITE_STRING = "infinite";
    public static final int INFINITE_VALUE = -1;
    public static final String SUBSCRIBE_METHOD = "SUBSCRIBE";
    public static final String TIMEOUT_HEADER = "Second-";
    public static final String UNSUBSCRIBE_METHOD = "UNSUBSCRIBE";
    public static final String UUID = "uuid:";
    public static final String XMLNS = "urn:schemas-upnp-org:event-1-0";

    public Subscription() {
    }

    public static final String createSID() {
        return UPnP.createUUID();
    }

    public static final String getSID(String r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r100.startsWith(UUID) == true) goto L9;
        return r100;
    L9:
        return r100.substring(5, r100.length());
    }

    public static final long getTimeout(String r100) {
        int r101 = r100.indexOf(45) + 1;
        return CastLongProtector.parseLong(r100.substring(r101, r100.length()));
    L5:
        return -1;
    }

    public static final String toSIDHeaderString(String r100) {
        return UUID + r100;
    }

    public static final String toTimeoutHeaderString(long r100) {
        if (r100 != (-1)) goto L7;
        return INFINITE_STRING;
    L7:
        return TIMEOUT_HEADER + Long.toString(r100);
    }
}
