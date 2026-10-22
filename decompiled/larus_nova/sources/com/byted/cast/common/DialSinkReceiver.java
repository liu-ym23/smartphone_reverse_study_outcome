package com.byted.cast.common;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes39.dex */
public class DialSinkReceiver {
    public static String sourceAddress = "";

    public DialSinkReceiver() {
    }

    public static void post() {
        if (TextUtils.isEmpty(sourceAddress) == false) goto L5;
        return;
    L5:
        String[] r100 = sourceAddress.split(":");
        if (r100.length != 2) goto L26;
        DatagramSocket r101 = new DatagramSocket();     // Catch: Exception -> L18
        String r102 = r100[0];     // Catch: Throwable -> L12
        int r103 = CastIntegerProtector.parseInt(r100[1]);     // Catch: Throwable -> L12
        byte[] r104 = "dial link success".getBytes();     // Catch: Throwable -> L12
        r101.send(new DatagramPacket(r104, r104.length, InetAddress.getByName(r102), r103));     // Catch: Throwable -> L12
        r101.close();     // Catch: Exception -> L18
        return;
    L12:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: Exception -> L18
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.getMessage();
        e.printStackTrace();
        return;
    }

    public void parseDialIntent(Bundle r100) {
        if (r100 == null) goto L6;
        sourceAddress = r100.getString("com.amazon.extra.DIAL_PARAM");
        return;
    }
}
