package com.bytedance.services.apm.api;

import android.content.Context;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public interface IDeviceInfoBridge {
    Enumeration<NetworkInterface> NetworkInterface_getNetworkInterfaces() throws SocketException;

    int TelephonyManager_getNetworkType(Context r1);
}
