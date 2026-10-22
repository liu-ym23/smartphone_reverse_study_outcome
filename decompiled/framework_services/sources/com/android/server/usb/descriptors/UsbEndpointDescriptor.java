package com.android.server.usb.descriptors;

import android.hardware.usb.UsbEndpoint;
import com.android.server.usb.descriptors.report.ReportCanvas;

/* JADX INFO: loaded from: classes3.dex */
public class UsbEndpointDescriptor extends UsbDescriptor {
    public static final int DIRECTION_INPUT = 128;
    public static final int DIRECTION_OUTPUT = 0;
    public static final byte MASK_ATTRIBS_SYNCTYPE = 12;
    public static final int MASK_ATTRIBS_TRANSTYPE = 3;
    public static final int MASK_ATTRIBS_USEAGE = 48;
    public static final int MASK_ENDPOINT_ADDRESS = 15;
    public static final int MASK_ENDPOINT_DIRECTION = -128;
    public static final byte SYNCTYPE_ADAPTSYNC = 8;
    public static final byte SYNCTYPE_ASYNC = 4;
    public static final byte SYNCTYPE_NONE = 0;
    public static final byte SYNCTYPE_RESERVED = 12;
    private static final String TAG = "UsbEndpointDescriptor";
    public static final int TRANSTYPE_BULK = 2;
    public static final int TRANSTYPE_CONTROL = 0;
    public static final int TRANSTYPE_INTERRUPT = 3;
    public static final int TRANSTYPE_ISO = 1;
    public static final int USEAGE_DATA = 0;
    public static final int USEAGE_EXPLICIT = 32;
    public static final int USEAGE_FEEDBACK = 16;
    public static final int USEAGE_RESERVED = 48;
    private int mAttributes;
    private UsbDescriptor mClassSpecificEndpointDescriptor;
    private int mEndpointAddress;
    private int mInterval;
    private int mPacketSize;
    private byte mRefresh;
    private byte mSyncAddress;

    public UsbEndpointDescriptor(int length, byte type) {
        super(length, type);
        this.mHierarchyLevel = 4;
    }

    public int getEndpointAddress() {
        return this.mEndpointAddress & 15;
    }

    public int getAttributes() {
        return this.mAttributes;
    }

    public int getPacketSize() {
        return this.mPacketSize;
    }

    public int getInterval() {
        return this.mInterval;
    }

    public byte getRefresh() {
        return this.mRefresh;
    }

    public byte getSyncAddress() {
        return this.mSyncAddress;
    }

    public int getDirection() {
        return this.mEndpointAddress & MASK_ENDPOINT_DIRECTION;
    }

    void setClassSpecificEndpointDescriptor(UsbDescriptor descriptor) {
        this.mClassSpecificEndpointDescriptor = descriptor;
    }

    public UsbDescriptor getClassSpecificEndpointDescriptor() {
        return this.mClassSpecificEndpointDescriptor;
    }

    public UsbEndpoint toAndroid(UsbDescriptorParser parser) {
        return new UsbEndpoint(this.mEndpointAddress, this.mAttributes, this.mPacketSize, this.mInterval);
    }

    @Override // com.android.server.usb.descriptors.UsbDescriptor
    public int parseRawDescriptors(ByteStream stream) {
        this.mEndpointAddress = stream.getUnsignedByte();
        this.mAttributes = stream.getUnsignedByte();
        this.mPacketSize = stream.unpackUsbShort();
        this.mInterval = stream.getUnsignedByte();
        if (this.mLength != 9) goto L6;
        this.mRefresh = stream.getByte();
        this.mSyncAddress = stream.getByte();
    L6:
        return this.mLength;
    }

    @Override // com.android.server.usb.descriptors.UsbDescriptor, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        super.report(canvas);
        canvas.openList();
        StringBuilder r0 = new StringBuilder();
        r0.append("Address: ");
        r0.append(ReportCanvas.getHexString(getEndpointAddress()));
        if (getDirection() != 0) goto L5;
        String r1 = " [out]";
    L6:
        r0.append(r1);
        canvas.writeListItem(r0.toString());
        int attributes = getAttributes();
        canvas.openListItem();
        canvas.write("Attributes: " + ReportCanvas.getHexString(attributes) + " ");
        switch((attributes & 3)) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            default: goto L13;
        };
    L9:
        canvas.write("Interrupt");
        goto L13
    L10:
        canvas.write("Bulk");
        goto L13
    L11:
        canvas.write("Iso");
        goto L13
    L12:
        canvas.write("Control");
    L13:
        canvas.closeListItem();
        if ((attributes & 3) != 1) goto L29;
        canvas.openListItem();
        canvas.write("Aync: ");
        switch((attributes & 12)) {
            case 0: goto L20;
            case 4: goto L19;
            case 8: goto L18;
            default: goto L21;
        };
    L18:
        canvas.write("ADAPTIVE ASYNC");
        goto L21
    L19:
        canvas.write("ASYNC");
        goto L21
    L20:
        canvas.write("NONE");
    L21:
        canvas.closeListItem();
        canvas.openListItem();
        canvas.write("Useage: ");
        switch((attributes & 48)) {
            case 0: goto L27;
            case 16: goto L26;
            case 32: goto L25;
            case 48: goto L24;
            default: goto L28;
        };
    L24:
        canvas.write("RESERVED");
        goto L28
    L25:
        canvas.write("EXPLICIT FEEDBACK");
        goto L28
    L26:
        canvas.write("FEEDBACK");
        goto L28
    L27:
        canvas.write("DATA");
    L28:
        canvas.closeListItem();
    L29:
        canvas.writeListItem("Package Size: " + getPacketSize());
        canvas.writeListItem("Interval: " + getInterval());
        canvas.closeList();
        return;
    L5:
        r1 = " [in]";
        goto L6
    }
}
