package com.android.server.usb.descriptors;

import com.android.server.usb.descriptors.report.ReportCanvas;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbACMidi10Endpoint extends UsbACEndpoint {
    private static final String TAG = "UsbACMidi10Endpoint";
    private byte[] mJackIds;
    private byte mNumJacks;

    @Override // com.android.server.usb.descriptors.UsbACEndpoint
    public /* bridge */ /* synthetic */ int getSubclass() {
        return super.getSubclass();
    }

    @Override // com.android.server.usb.descriptors.UsbACEndpoint
    public /* bridge */ /* synthetic */ byte getSubtype() {
        return super.getSubtype();
    }

    public UsbACMidi10Endpoint(int length, byte type, int subclass, byte subtype) {
        super(length, type, subclass, subtype);
        this.mJackIds = new byte[0];
    }

    public byte getNumJacks() {
        return this.mNumJacks;
    }

    public byte[] getJackIds() {
        return this.mJackIds;
    }

    @Override // com.android.server.usb.descriptors.UsbACEndpoint, com.android.server.usb.descriptors.UsbDescriptor
    public int parseRawDescriptors(ByteStream stream) {
        super.parseRawDescriptors(stream);
        this.mNumJacks = stream.getByte();
        if (this.mNumJacks <= 0) goto L8;
        this.mJackIds = new byte[this.mNumJacks];
        int jack = 0;
    L6:
        if (jack >= this.mNumJacks) goto L8;
        this.mJackIds[jack] = stream.getByte();
        jack = jack + 1;
    L8:
        int jack2 = this.mLength;
        return jack2;
    }

    @Override // com.android.server.usb.descriptors.UsbDescriptor, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        super.report(canvas);
        canvas.writeHeader(3, "ACMidi10Endpoint: " + ReportCanvas.getHexString(getType()) + " Length: " + getLength());
        canvas.openList();
        canvas.writeListItem("" + getNumJacks() + " Jacks.");
        int i = 0;
    L4:
        if (i >= getNumJacks()) goto L6;
        canvas.writeListItem("Jack " + i + ": " + this.mJackIds[i]);
        i = i + 1;
        goto L4
    L6:
        canvas.closeList();
    }
}
