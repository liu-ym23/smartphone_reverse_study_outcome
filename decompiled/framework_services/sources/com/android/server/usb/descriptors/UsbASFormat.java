package com.android.server.usb.descriptors;

import com.android.server.usb.descriptors.report.ReportCanvas;
import com.android.server.usb.descriptors.report.UsbStrings;

/* JADX INFO: loaded from: classes3.dex */
public class UsbASFormat extends UsbACInterface {
    public static final byte EXT_FORMAT_TYPE_I = -127;
    public static final byte EXT_FORMAT_TYPE_II = -126;
    public static final byte EXT_FORMAT_TYPE_III = -125;
    public static final byte FORMAT_TYPE_I = 1;
    public static final byte FORMAT_TYPE_II = 2;
    public static final byte FORMAT_TYPE_III = 3;
    public static final byte FORMAT_TYPE_IV = 4;
    private static final String TAG = "UsbASFormat";
    private final byte mFormatType;

    public UsbASFormat(int length, byte type, byte subtype, byte formatType, int mSubclass) {
        super(length, type, subtype, mSubclass);
        this.mFormatType = formatType;
    }

    public byte getFormatType() {
        return this.mFormatType;
    }

    public int[] getSampleRates() {
        return null;
    }

    public int[] getBitDepths() {
        return null;
    }

    public int[] getChannelCounts() {
        return null;
    }

    public static UsbDescriptor allocDescriptor(UsbDescriptorParser parser, ByteStream stream, int length, byte type, byte subtype, int subclass) {
        byte formatType = stream.getByte();
        int acInterfaceSpec = parser.getACInterfaceSpec();
        switch(formatType) {
            case 1: goto L15;
            case 2: goto L9;
            case 3: goto L7;
            default: goto L5;
        };
    L5:
        return new UsbASFormat(length, type, subtype, formatType, subclass);
    L7:
        return new Usb20ASFormatIII(length, type, subtype, formatType, subclass);
    L9:
        if (acInterfaceSpec != 512) goto L13;
        return new Usb20ASFormatII(length, type, subtype, formatType, subclass);
    L13:
        return new Usb10ASFormatII(length, type, subtype, formatType, subclass);
    L15:
        if (acInterfaceSpec != 512) goto L19;
        return new Usb20ASFormatI(length, type, subtype, formatType, subclass);
    L19:
        return new Usb10ASFormatI(length, type, subtype, formatType, subclass);
    }

    @Override // com.android.server.usb.descriptors.UsbACInterface, com.android.server.usb.descriptors.UsbDescriptor, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        super.report(canvas);
        canvas.writeParagraph(UsbStrings.getFormatName(getFormatType()), false);
    }
}
