package com.byted.cast.linkcommon.cybergarage.upnp.device;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes28.dex */
public class MAN {
    public static final String DISCOVER = "ssdp:discover";

    public MAN() {
    }

    public static final boolean isDiscover(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        if (r100.equals(DISCOVER) != true) goto L10;
        return true;
    L10:
        return r100.equals("\"ssdp:discover\"");
    }
}
