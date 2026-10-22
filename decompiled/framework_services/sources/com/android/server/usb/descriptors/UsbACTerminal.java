package com.android.server.usb.descriptors;

import com.android.server.usb.descriptors.report.ReportCanvas;
import com.android.server.usb.descriptors.report.UsbStrings;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UsbACTerminal extends UsbACInterface {
    private static final String TAG = "UsbACTerminal";
    protected byte mAssocTerminal;
    protected byte mTerminalID;
    protected int mTerminalType;

    public UsbACTerminal(int length, byte type, byte subtype, int subclass) {
        super(length, type, subtype, subclass);
    }

    public byte getTerminalID() {
        return this.mTerminalID;
    }

    public int getTerminalType() {
        return this.mTerminalType;
    }

    public byte getAssocTerminal() {
        return this.mAssocTerminal;
    }

    public boolean isInputTerminal() {
        if (this.mTerminalType != 513) goto L5;
    L12:
        return true;
    L5:
        if (this.mTerminalType == 1026) goto L12;
        if (this.mTerminalType == 1024) goto L12;
        if (this.mTerminalType == 1539) goto L12;
        return false;
    }

    @Override // com.android.server.usb.descriptors.UsbDescriptor
    public int parseRawDescriptors(ByteStream stream) {
        this.mTerminalID = stream.getByte();
        this.mTerminalType = stream.unpackUsbShort();
        this.mAssocTerminal = stream.getByte();
        return this.mLength;
    }

    @Override // com.android.server.usb.descriptors.UsbACInterface, com.android.server.usb.descriptors.UsbDescriptor, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        super.report(canvas);
        canvas.openList();
        int terminalType = getTerminalType();
        canvas.writeListItem("Type: " + ReportCanvas.getHexString(terminalType) + ": " + UsbStrings.getTerminalName(terminalType));
        StringBuilder r1 = new StringBuilder();
        r1.append("ID: ");
        r1.append(ReportCanvas.getHexString(getTerminalID()));
        canvas.writeListItem(r1.toString());
        canvas.writeListItem("Associated terminal: " + ReportCanvas.getHexString(getAssocTerminal()));
        canvas.closeList();
    }
}
