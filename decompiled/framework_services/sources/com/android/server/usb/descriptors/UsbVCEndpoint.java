package com.android.server.usb.descriptors;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
abstract class UsbVCEndpoint extends UsbDescriptor {
    private static final String TAG = "UsbVCEndpoint";
    public static final byte VCEP_ENDPOINT = 2;
    public static final byte VCEP_GENERAL = 1;
    public static final byte VCEP_INTERRUPT = 3;
    public static final byte VCEP_UNDEFINED = 0;

    UsbVCEndpoint(int length, byte type) {
        super(length, type);
    }

    public static UsbDescriptor allocDescriptor(UsbDescriptorParser parser, int length, byte type, byte subtype) {
        parser.getCurInterface();
        switch(subtype) {
            case 0: goto L9;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        Log.w(TAG, "Unknown Video Class Endpoint id:0x" + Integer.toHexString(subtype));
        return null;
    L6:
        return null;
    L7:
        return null;
    L8:
        return null;
    L9:
        return null;
    }
}
