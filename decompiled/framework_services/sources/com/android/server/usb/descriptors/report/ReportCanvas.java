package com.android.server.usb.descriptors.report;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import com.android.server.usb.descriptors.UsbDescriptorParser;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReportCanvas {
    private static final String TAG = "ReportCanvas";
    private final UsbDescriptorParser mParser;

    public abstract void closeHeader(int r1);

    public abstract void closeList();

    public abstract void closeListItem();

    public abstract void closeParagraph();

    public abstract void openHeader(int r1);

    public abstract void openList();

    public abstract void openListItem();

    public abstract void openParagraph(boolean r1);

    public abstract void write(String r1);

    public abstract void writeParagraph(String r1, boolean r2);

    public ReportCanvas(UsbDescriptorParser parser) {
        this.mParser = parser;
    }

    public UsbDescriptorParser getParser() {
        return this.mParser;
    }

    public void writeHeader(int level, String text) {
        openHeader(level);
        write(text);
        closeHeader(level);
    }

    public void writeListItem(String text) {
        openListItem();
        write(text);
        closeListItem();
    }

    public static String getHexString(byte value) {
        return "0x" + Integer.toHexString(value & CecDeviceType.INACTIVE).toUpperCase();
    }

    public static String getBCDString(int valueBCD) {
        int major = (valueBCD >> 8) & 15;
        int minor = (valueBCD >> 4) & 15;
        int subminor = valueBCD & 15;
        return "" + major + "." + minor + subminor;
    }

    public static String getHexString(int value) {
        int intValue = 65535 & value;
        return "0x" + Integer.toHexString(intValue).toUpperCase();
    }

    public void dumpHexArray(byte[] rawData, StringBuilder builder) {
        if (rawData == null) goto L10;
        openParagraph(false);
        int index = 0;
    L5:
        if (index >= rawData.length) goto L7;
        builder.append(getHexString(rawData[index]) + " ");
        index = index + 1;
        goto L5
    L7:
        closeParagraph();
        return;
    }
}
