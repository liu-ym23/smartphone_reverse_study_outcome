package com.android.server.usb.descriptors;

/* JADX INFO: loaded from: classes3.dex */
public class UsbACMixerUnit extends UsbACInterface {
    private static final String TAG = "UsbACMixerUnit";
    protected byte[] mInputIDs;
    protected byte mNumInputs;
    protected byte mNumOutputs;
    protected byte mUnitID;

    public UsbACMixerUnit(int length, byte type, byte subtype, int subClass) {
        super(length, type, subtype, subClass);
    }

    public byte getUnitID() {
        return this.mUnitID;
    }

    public byte getNumInputs() {
        return this.mNumInputs;
    }

    public byte[] getInputIDs() {
        return this.mInputIDs;
    }

    public byte getNumOutputs() {
        return this.mNumOutputs;
    }

    protected static int calcControlArraySize(int numInputs, int numOutputs) {
        int totalChannels = numInputs * numOutputs;
        return (totalChannels + 7) / 8;
    }

    @Override // com.android.server.usb.descriptors.UsbDescriptor
    public int parseRawDescriptors(ByteStream stream) {
        this.mUnitID = stream.getByte();
        this.mNumInputs = stream.getByte();
        this.mInputIDs = new byte[this.mNumInputs];
        int input = 0;
    L4:
        if (input >= this.mNumInputs) goto L6;
        this.mInputIDs[input] = stream.getByte();
        input = input + 1;
        goto L4
    L6:
        this.mNumOutputs = stream.getByte();
        return this.mLength;
    }
}
