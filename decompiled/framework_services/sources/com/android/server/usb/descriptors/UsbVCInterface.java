package com.android.server.usb.descriptors;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UsbVCInterface extends UsbDescriptor {
    private static final String TAG = "UsbVCInterface";
    public static final byte VCI_EXTENSION_UNIT = 6;
    public static final byte VCI_INPUT_TERMINAL = 2;
    public static final byte VCI_OUTPUT_TERMINAL = 3;
    public static final byte VCI_PROCESSING_UNIT = 5;
    public static final byte VCI_SELECTOR_UNIT = 4;
    public static final byte VCI_UNDEFINED = 0;
    public static final byte VCI_VEADER = 1;
    protected final byte mSubtype;

    public UsbVCInterface(int length, byte type, byte subtype) {
        super(length, type);
        this.mSubtype = subtype;
    }

    public static UsbDescriptor allocDescriptor(UsbDescriptorParser parser, ByteStream stream, int length, byte type) {
        byte subtype = stream.getByte();
        parser.getCurInterface();
        switch(subtype) {
            case 0: goto L18;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L18;
            default: goto L4;
        };
    L4:
        Log.w(TAG, "Unknown Video Class Interface subtype: 0x" + Integer.toHexString(subtype));
        return null;
    L15:
        int vcInterfaceSpec = stream.unpackUsbShort();
        parser.setVCInterfaceSpec(vcInterfaceSpec);
        return new UsbVCHeader(length, type, subtype, vcInterfaceSpec);
    L18:
        return null;
    L8:
        return new UsbVCProcessingUnit(length, type, subtype);
    L10:
        return new UsbVCSelectorUnit(length, type, subtype);
    L12:
        return new UsbVCOutputTerminal(length, type, subtype);
    L14:
        return new UsbVCInputTerminal(length, type, subtype);
    }
}
