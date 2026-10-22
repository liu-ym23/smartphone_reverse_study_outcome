package com.android.server.usb.descriptors;

import com.android.server.usb.descriptors.report.ReportCanvas;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbACMidi20Endpoint extends UsbACEndpoint {
    private static final String TAG = "UsbACMidi20Endpoint";
    private byte[] mBlockIds;
    private byte mNumGroupTerminals;

    @Override // com.android.server.usb.descriptors.UsbACEndpoint
    public /* bridge */ /* synthetic */ int getSubclass() {
        return super.getSubclass();
    }

    @Override // com.android.server.usb.descriptors.UsbACEndpoint
    public /* bridge */ /* synthetic */ byte getSubtype() {
        return super.getSubtype();
    }

    public UsbACMidi20Endpoint(int length, byte type, int subclass, byte subtype) {
        super(length, type, subclass, subtype);
        this.mBlockIds = new byte[0];
    }

    public byte getNumGroupTerminals() {
        return this.mNumGroupTerminals;
    }

    public byte[] getBlockIds() {
        return this.mBlockIds;
    }

    @Override // com.android.server.usb.descriptors.UsbACEndpoint, com.android.server.usb.descriptors.UsbDescriptor
    public int parseRawDescriptors(ByteStream stream) {
        super.parseRawDescriptors(stream);
        this.mNumGroupTerminals = stream.getByte();
        if (this.mNumGroupTerminals <= 0) goto L8;
        this.mBlockIds = new byte[this.mNumGroupTerminals];
        int block = 0;
    L6:
        if (block >= this.mNumGroupTerminals) goto L8;
        this.mBlockIds[block] = stream.getByte();
        block = block + 1;
    L8:
        int block2 = this.mLength;
        return block2;
    }

    @Override // com.android.server.usb.descriptors.UsbDescriptor, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        super.report(canvas);
        canvas.writeHeader(3, "AC Midi20 Endpoint: " + ReportCanvas.getHexString(getType()) + " Length: " + getLength());
        canvas.openList();
        canvas.writeListItem("" + getNumGroupTerminals() + " Group Terminals.");
        int i = 0;
    L4:
        if (i >= getNumGroupTerminals()) goto L6;
        canvas.writeListItem("Group Terminal " + i + ": " + this.mBlockIds[i]);
        i = i + 1;
        goto L4
    L6:
        canvas.closeList();
    }
}
