package com.byted.cast.linkcommon.cybergarage.upnp.device;

import com.byted.cast.linkcommon.cybergarage.cast.CastSSDPPacket;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPPacket;

/* JADX INFO: loaded from: classes28.dex */
public interface SearchListener {

    /* JADX INFO: renamed from: com.byted.cast.linkcommon.cybergarage.upnp.device.SearchListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$bdlinkDeviceSearchReceived(SearchListener r100, CastSSDPPacket r101) {
        }

        public static void $default$deviceSearchReceived(SearchListener r100, SSDPPacket r101) {
        }
    }

    void bdlinkDeviceSearchReceived(CastSSDPPacket r100);

    void deviceSearchReceived(SSDPPacket r100);
}
