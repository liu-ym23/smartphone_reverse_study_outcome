package com.android.server.usb.descriptors;

import com.android.server.usb.descriptors.report.ReportCanvas;

/* JADX INFO: loaded from: classes3.dex */
public final class Usb10ASFormatI extends UsbASFormat {
    private static final String TAG = "Usb10ASFormatI";
    private byte mBitResolution;
    private byte mNumChannels;
    private byte mSampleFreqType;
    private int[] mSampleRates;
    private byte mSubframeSize;

    public Usb10ASFormatI(int length, byte type, byte subtype, byte formatType, int subclass) {
        super(length, type, subtype, formatType, subclass);
    }

    public byte getNumChannels() {
        return this.mNumChannels;
    }

    public byte getSubframeSize() {
        return this.mSubframeSize;
    }

    public byte getBitResolution() {
        return this.mBitResolution;
    }

    public byte getSampleFreqType() {
        return this.mSampleFreqType;
    }

    @Override // com.android.server.usb.descriptors.UsbASFormat
    public int[] getSampleRates() {
        return this.mSampleRates;
    }

    @Override // com.android.server.usb.descriptors.UsbASFormat
    public int[] getBitDepths() {
        int[] depths = {this.mBitResolution};
        return depths;
    }

    @Override // com.android.server.usb.descriptors.UsbASFormat
    public int[] getChannelCounts() {
        int[] counts = {this.mNumChannels};
        return counts;
    }

    @Override // com.android.server.usb.descriptors.UsbDescriptor
    public int parseRawDescriptors(ByteStream stream) {
        this.mNumChannels = stream.getByte();
        this.mSubframeSize = stream.getByte();
        this.mBitResolution = stream.getByte();
        this.mSampleFreqType = stream.getByte();
        if (this.mSampleFreqType != 0) goto L5;
        this.mSampleRates = new int[2];
        this.mSampleRates[0] = stream.unpackUsbTriple();
        this.mSampleRates[1] = stream.unpackUsbTriple();
    L9:
        int index = this.mLength;
        return index;
    L5:
        this.mSampleRates = new int[this.mSampleFreqType];
        int index2 = 0;
    L7:
        if (index2 >= this.mSampleFreqType) goto L9;
        this.mSampleRates[index2] = stream.unpackUsbTriple();
        index2 = index2 + 1;
        goto L7
    }

    @Override // com.android.server.usb.descriptors.UsbASFormat, com.android.server.usb.descriptors.UsbACInterface, com.android.server.usb.descriptors.UsbDescriptor, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        super.report(canvas);
        canvas.openList();
        canvas.writeListItem("" + getNumChannels() + " Channels.");
        StringBuilder r0 = new StringBuilder();
        r0.append("Subframe Size: ");
        r0.append(getSubframeSize());
        canvas.writeListItem(r0.toString());
        canvas.writeListItem("Bit Resolution: " + getBitResolution());
        byte sampleFreqType = getSampleFreqType();
        int[] sampleRates = getSampleRates();
        canvas.writeListItem("Sample Freq Type: " + sampleFreqType);
        canvas.openList();
        if (sampleFreqType != 0) goto L5;
        canvas.writeListItem("min: " + sampleRates[0]);
        canvas.writeListItem("max: " + sampleRates[1]);
    L8:
        canvas.closeList();
        canvas.closeList();
        return;
    L5:
        int index = 0;
    L6:
        if (index >= sampleFreqType) goto L8;
        canvas.writeListItem("" + sampleRates[index]);
        index = index + 1;
        goto L6
    }
}
