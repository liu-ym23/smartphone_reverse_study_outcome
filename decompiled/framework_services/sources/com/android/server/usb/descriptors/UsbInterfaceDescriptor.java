package com.android.server.usb.descriptors;

import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import com.android.server.usb.descriptors.report.ReportCanvas;
import com.android.server.usb.descriptors.report.UsbStrings;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class UsbInterfaceDescriptor extends UsbDescriptor {
    private static final String TAG = "UsbInterfaceDescriptor";
    protected byte mAlternateSetting;
    protected byte mDescrIndex;
    private ArrayList<UsbEndpointDescriptor> mEndpointDescriptors;
    protected int mInterfaceNumber;
    private UsbDescriptor mMidiHeaderInterfaceDescriptor;
    protected byte mNumEndpoints;
    protected int mProtocol;
    protected int mUsbClass;
    protected int mUsbSubclass;

    UsbInterfaceDescriptor(int length, byte type) {
        super(length, type);
        this.mEndpointDescriptors = new ArrayList();
        this.mHierarchyLevel = 3;
    }

    @Override // com.android.server.usb.descriptors.UsbDescriptor
    public int parseRawDescriptors(ByteStream stream) {
        this.mInterfaceNumber = stream.getUnsignedByte();
        this.mAlternateSetting = stream.getByte();
        this.mNumEndpoints = stream.getByte();
        this.mUsbClass = stream.getUnsignedByte();
        this.mUsbSubclass = stream.getUnsignedByte();
        this.mProtocol = stream.getUnsignedByte();
        this.mDescrIndex = stream.getByte();
        return this.mLength;
    }

    public int getInterfaceNumber() {
        return this.mInterfaceNumber;
    }

    public byte getAlternateSetting() {
        return this.mAlternateSetting;
    }

    public byte getNumEndpoints() {
        return this.mNumEndpoints;
    }

    public UsbEndpointDescriptor getEndpointDescriptor(int index) {
        if (index >= 0) goto L4;
        return null;
    L4:
        if (index < this.mEndpointDescriptors.size()) goto L7;
        return null;
    L7:
        return this.mEndpointDescriptors.get(index);
    }

    public int getUsbClass() {
        return this.mUsbClass;
    }

    public int getUsbSubclass() {
        return this.mUsbSubclass;
    }

    public int getProtocol() {
        return this.mProtocol;
    }

    public byte getDescrIndex() {
        return this.mDescrIndex;
    }

    void addEndpointDescriptor(UsbEndpointDescriptor endpoint) {
        this.mEndpointDescriptors.add(endpoint);
    }

    public void setMidiHeaderInterfaceDescriptor(UsbDescriptor descriptor) {
        this.mMidiHeaderInterfaceDescriptor = descriptor;
    }

    public UsbDescriptor getMidiHeaderInterfaceDescriptor() {
        return this.mMidiHeaderInterfaceDescriptor;
    }

    public UsbInterface toAndroid(UsbDescriptorParser parser) {
        String name = parser.getDescriptorString(this.mDescrIndex);
        UsbInterface ntrface = new UsbInterface(this.mInterfaceNumber, this.mAlternateSetting, name, this.mUsbClass, this.mUsbSubclass, this.mProtocol);
        UsbEndpoint[] endpoints = new UsbEndpoint[this.mEndpointDescriptors.size()];
        int index = 0;
    L4:
        if (index >= this.mEndpointDescriptors.size()) goto L6;
        endpoints[index] = this.mEndpointDescriptors.get(index).toAndroid(parser);
        index = index + 1;
        goto L4
    L6:
        ntrface.setEndpoints(endpoints);
        return ntrface;
    }

    @Override // com.android.server.usb.descriptors.UsbDescriptor, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        super.report(canvas);
        int usbClass = getUsbClass();
        int usbSubclass = getUsbSubclass();
        int protocol = getProtocol();
        String className = UsbStrings.getClassName(usbClass);
        String subclassName = "";
        if (usbClass != 1) goto L5;
        subclassName = UsbStrings.getAudioSubclassName(usbSubclass);
    L5:
        canvas.openList();
        canvas.writeListItem("Interface #" + getInterfaceNumber());
        canvas.writeListItem("Class: " + ReportCanvas.getHexString(usbClass) + ": " + className);
        canvas.writeListItem("Subclass: " + ReportCanvas.getHexString(usbSubclass) + ": " + subclassName);
        canvas.writeListItem("Protocol: " + protocol + ": " + ReportCanvas.getHexString(protocol));
        StringBuilder r5 = new StringBuilder();
        r5.append("Endpoints: ");
        r5.append(getNumEndpoints());
        canvas.writeListItem(r5.toString());
        canvas.closeList();
    }
}
