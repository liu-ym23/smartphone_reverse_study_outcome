package com.android.server.usb.descriptors;

import com.android.server.usb.descriptors.report.ReportCanvas;

/* JADX INFO: loaded from: classes3.dex */
public final class Usb10ACMixerUnit extends UsbACMixerUnit implements UsbAudioChannelCluster {
    private static final String TAG = "Usb10ACMixerUnit";
    private byte mChanNameID;
    private int mChannelConfig;
    private byte[] mControls;
    private byte mNameID;

    public Usb10ACMixerUnit(int length, byte type, byte subtype, int subClass) {
        super(length, type, subtype, subClass);
    }

    @Override // com.android.server.usb.descriptors.UsbAudioChannelCluster
    public byte getChannelCount() {
        return this.mNumOutputs;
    }

    @Override // com.android.server.usb.descriptors.UsbAudioChannelCluster
    public int getChannelConfig() {
        return this.mChannelConfig;
    }

    @Override // com.android.server.usb.descriptors.UsbAudioChannelCluster
    public byte getChannelNames() {
        return this.mChanNameID;
    }

    public byte[] getControls() {
        return this.mControls;
    }

    public byte getNameID() {
        return this.mNameID;
    }

    @Override // com.android.server.usb.descriptors.UsbACMixerUnit, com.android.server.usb.descriptors.UsbDescriptor
    public int parseRawDescriptors(ByteStream stream) {
        super.parseRawDescriptors(stream);
        this.mChannelConfig = stream.unpackUsbShort();
        this.mChanNameID = stream.getByte();
        int controlArraySize = UsbACMixerUnit.calcControlArraySize(this.mNumInputs, this.mNumOutputs);
        this.mControls = new byte[controlArraySize];
        int index = 0;
    L3:
        if (index >= controlArraySize) goto L5;
        this.mControls[index] = stream.getByte();
        index = index + 1;
        goto L3
    L5:
        this.mNameID = stream.getByte();
        return this.mLength;
    }

    @Override // com.android.server.usb.descriptors.UsbACInterface, com.android.server.usb.descriptors.UsbDescriptor, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        super.report(canvas);
        canvas.writeParagraph("Mixer Unit", false);
        canvas.openList();
        canvas.writeListItem("Unit ID: " + ReportCanvas.getHexString(getUnitID()));
        byte numInputs = getNumInputs();
        byte[] inputIDs = getInputIDs();
        canvas.openListItem();
        canvas.write("Num Inputs: " + numInputs + " [");
        int input = 0;
    L4:
        if (input >= numInputs) goto L9;
        canvas.write("" + ReportCanvas.getHexString(inputIDs[input]));
        if (input >= (numInputs - 1)) goto L8;
        canvas.write(" ");
    L8:
        input = input + 1;
        goto L4
    L9:
        canvas.write("]");
        canvas.closeListItem();
        canvas.writeListItem("Num Outputs: " + getNumOutputs());
        canvas.writeListItem("Channel Config: " + ReportCanvas.getHexString(getChannelConfig()));
        byte[] controls = getControls();
        canvas.openListItem();
        canvas.write("Controls: " + controls.length + " [");
        int ctrl = 0;
    L11:
        if (ctrl >= controls.length) goto L16;
        canvas.write("" + controls[ctrl]);
        if (ctrl >= (controls.length - 1)) goto L15;
        canvas.write(" ");
    L15:
        ctrl = ctrl + 1;
        goto L11
    L16:
        canvas.write("]");
        canvas.closeListItem();
        canvas.closeList();
    }
}
