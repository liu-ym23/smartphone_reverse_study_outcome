package com.android.server.usb.descriptors;

import com.android.server.usb.descriptors.report.ReportCanvas;

/* JADX INFO: loaded from: classes3.dex */
public final class Usb10ACHeader extends UsbACHeaderInterface {
    private static final String TAG = "Usb10ACHeader";
    private byte mControls;
    private byte[] mInterfaceNums;
    private byte mNumInterfaces;

    public Usb10ACHeader(int length, byte type, byte subtype, int subclass, int spec) {
        super(length, type, subtype, subclass, spec);
        this.mNumInterfaces = 0;
        this.mInterfaceNums = null;
    }

    public byte getNumInterfaces() {
        return this.mNumInterfaces;
    }

    public byte[] getInterfaceNums() {
        return this.mInterfaceNums;
    }

    public byte getControls() {
        return this.mControls;
    }

    @Override // com.android.server.usb.descriptors.UsbDescriptor
    public int parseRawDescriptors(ByteStream stream) {
        this.mTotalLength = stream.unpackUsbShort();
        if (this.mADCRelease < 512) goto L5;
        this.mControls = stream.getByte();
    L9:
        int index = this.mLength;
        return index;
    L5:
        this.mNumInterfaces = stream.getByte();
        this.mInterfaceNums = new byte[this.mNumInterfaces];
        int index2 = 0;
    L7:
        if (index2 >= this.mNumInterfaces) goto L9;
        this.mInterfaceNums[index2] = stream.getByte();
        index2 = index2 + 1;
        goto L7
    }

    @Override // com.android.server.usb.descriptors.UsbACHeaderInterface, com.android.server.usb.descriptors.UsbACInterface, com.android.server.usb.descriptors.UsbDescriptor, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        super.report(canvas);
        canvas.openList();
        int numInterfaces = getNumInterfaces();
        StringBuilder sb = new StringBuilder();
        sb.append("" + numInterfaces + " Interfaces");
        if (numInterfaces <= 0) goto L13;
        sb.append(" [");
        byte[] interfaceNums = getInterfaceNums();
        if (interfaceNums == null) goto L12;
        int index = 0;
    L7:
        if (index >= numInterfaces) goto L12;
        sb.append("" + interfaceNums[index]);
        if (index >= (numInterfaces - 1)) goto L11;
        sb.append(" ");
    L11:
        index = index + 1;
    L12:
        sb.append("]");
    L13:
        canvas.writeListItem(sb.toString());
        canvas.writeListItem("Controls: " + ReportCanvas.getHexString(getControls()));
        canvas.closeList();
    }
}
