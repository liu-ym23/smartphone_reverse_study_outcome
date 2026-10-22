package com.byted.cast.linkcommon.cybergarage.upnp;

import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class DeviceList extends Vector {
    public static final String ELEM_NAME = "deviceList";

    public DeviceList() {
    }

    public Device getDevice(int r100) {
        return (Device) get(r100);
    }
}
