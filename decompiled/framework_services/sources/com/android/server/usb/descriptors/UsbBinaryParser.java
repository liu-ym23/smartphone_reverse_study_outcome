package com.android.server.usb.descriptors;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.hardware.usb.UsbDeviceConnection;
import com.android.server.usb.descriptors.report.UsbStrings;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbBinaryParser {
    private static final boolean LOGGING = false;
    private static final String TAG = "UsbBinaryParser";

    public UsbBinaryParser() {
    }

    private void dumpDescriptor(ByteStream stream, int length, byte type, StringBuilder builder) {
        builder.append("<p>");
        builder.append("<b> l: " + length + " t:0x" + Integer.toHexString(type) + " " + UsbStrings.getDescriptorName(type) + "</b><br>");
        int index = 2;
    L3:
        if (index >= length) goto L5;
        builder.append("0x" + Integer.toHexString(stream.getByte() & CecDeviceType.INACTIVE) + " ");
        index = index + 1;
        goto L3
    L5:
        builder.append("</p>");
    }

    public void parseDescriptors(UsbDeviceConnection connection, byte[] descriptors, StringBuilder builder) {
        builder.append("<tt>");
        ByteStream stream = new ByteStream(descriptors);
    L4:
        if (stream.available() <= 0) goto L6;
        int length = stream.getByte() & CecDeviceType.INACTIVE;
        byte type = stream.getByte();
        dumpDescriptor(stream, length, type, builder);
        goto L4
    L6:
        builder.append("</tt>");
    }
}
