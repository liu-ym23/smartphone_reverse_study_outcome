package com.android.server.usb.descriptors;

import com.android.server.usb.descriptors.report.ReportCanvas;

/* JADX INFO: loaded from: classes3.dex */
public final class Usb10ASFormatII extends UsbASFormat {
    private static final String TAG = "Usb10ASFormatII";
    private int mMaxBitRate;
    private byte mSamFreqType;
    private int[] mSampleRates;
    private int mSamplesPerFrame;

    public Usb10ASFormatII(int length, byte type, byte subtype, byte formatType, int subclass) {
        super(length, type, subtype, formatType, subclass);
    }

    public int getMaxBitRate() {
        return this.mMaxBitRate;
    }

    public int getSamplesPerFrame() {
        return this.mSamplesPerFrame;
    }

    public byte getSamFreqType() {
        return this.mSamFreqType;
    }

    @Override // com.android.server.usb.descriptors.UsbASFormat
    public int[] getSampleRates() {
        return this.mSampleRates;
    }

    @Override // com.android.server.usb.descriptors.UsbDescriptor
    public int parseRawDescriptors(ByteStream stream) {
        this.mMaxBitRate = stream.unpackUsbShort();
        this.mSamplesPerFrame = stream.unpackUsbShort();
        this.mSamFreqType = stream.getByte();
        if (this.mSamFreqType != 0) goto L5;
        int numFreqs = 2;
    L6:
        this.mSampleRates = new int[numFreqs];
        int index = 0;
    L7:
        if (index >= numFreqs) goto L9;
        this.mSampleRates[index] = stream.unpackUsbTriple();
        index = index + 1;
        goto L7
    L9:
        int index2 = this.mLength;
        return index2;
    L5:
        numFreqs = this.mSamFreqType;
        goto L6
    }

    @Override // com.android.server.usb.descriptors.UsbASFormat, com.android.server.usb.descriptors.UsbACInterface, com.android.server.usb.descriptors.UsbDescriptor, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        super.report(canvas);
        canvas.openList();
        canvas.writeListItem("Max Bit Rate: " + getMaxBitRate());
        canvas.writeListItem("Samples Per Frame: " + getMaxBitRate());
        byte sampleFreqType = getSamFreqType();
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
