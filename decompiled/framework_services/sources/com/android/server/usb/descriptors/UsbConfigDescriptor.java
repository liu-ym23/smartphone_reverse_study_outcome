package com.android.server.usb.descriptors;

import android.hardware.usb.UsbConfiguration;
import android.hardware.usb.UsbInterface;
import com.android.server.usb.descriptors.report.ReportCanvas;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbConfigDescriptor extends UsbDescriptor {
    private static final String TAG = "UsbConfigDescriptor";
    private int mAttribs;
    private boolean mBlockAudio;
    private byte mConfigIndex;
    private int mConfigValue;
    private ArrayList<UsbInterfaceDescriptor> mInterfaceDescriptors;
    private int mMaxPower;
    private byte mNumInterfaces;
    private int mTotalLength;

    UsbConfigDescriptor(int length, byte type) {
        super(length, type);
        this.mInterfaceDescriptors = new ArrayList();
        this.mHierarchyLevel = 2;
    }

    public int getTotalLength() {
        return this.mTotalLength;
    }

    public byte getNumInterfaces() {
        return this.mNumInterfaces;
    }

    public int getConfigValue() {
        return this.mConfigValue;
    }

    public byte getConfigIndex() {
        return this.mConfigIndex;
    }

    public int getAttribs() {
        return this.mAttribs;
    }

    public int getMaxPower() {
        return this.mMaxPower;
    }

    void addInterfaceDescriptor(UsbInterfaceDescriptor interfaceDesc) {
        this.mInterfaceDescriptors.add(interfaceDesc);
    }

    ArrayList<UsbInterfaceDescriptor> getInterfaceDescriptors() {
        return this.mInterfaceDescriptors;
    }

    private boolean isAudioInterface(UsbInterfaceDescriptor descriptor) {
        if (descriptor.getUsbClass() == 1) goto L5;
    L7:
        return false;
    L5:
        if (descriptor.getUsbSubclass() != 2) goto L7;
        return true;
    }

    UsbConfiguration toAndroid(UsbDescriptorParser parser) {
        String name = parser.getDescriptorString(this.mConfigIndex);
        UsbConfiguration config = new UsbConfiguration(this.mConfigValue, name, this.mAttribs, this.mMaxPower);
        ArrayList<UsbInterface> filteredInterfaces = new ArrayList();
        Iterator<UsbInterfaceDescriptor> r3 = this.mInterfaceDescriptors.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        UsbInterfaceDescriptor descriptor = r3.next();
        if (this.mBlockAudio == false) goto L9;
        if (isAudioInterface(descriptor) == true) goto L4;
    L9:
        filteredInterfaces.add(descriptor.toAndroid(parser));
        goto L4
    L11:
        UsbInterface[] interfaceArray = new UsbInterface[0];
        UsbInterface[] interfaceArray2 = (UsbInterface[]) filteredInterfaces.toArray(interfaceArray);
        config.setInterfaces(interfaceArray2);
        return config;
    }

    @Override // com.android.server.usb.descriptors.UsbDescriptor
    public int parseRawDescriptors(ByteStream stream) {
        this.mTotalLength = stream.unpackUsbShort();
        this.mNumInterfaces = stream.getByte();
        this.mConfigValue = stream.getUnsignedByte();
        this.mConfigIndex = stream.getByte();
        this.mAttribs = stream.getUnsignedByte();
        this.mMaxPower = stream.getUnsignedByte();
        return this.mLength;
    }

    @Override // com.android.server.usb.descriptors.UsbDescriptor, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        super.report(canvas);
        canvas.openList();
        canvas.writeListItem("Config # " + getConfigValue());
        canvas.writeListItem(getNumInterfaces() + " Interfaces.");
        canvas.writeListItem("Attributes: " + ReportCanvas.getHexString(getAttribs()));
        canvas.closeList();
    }
}
