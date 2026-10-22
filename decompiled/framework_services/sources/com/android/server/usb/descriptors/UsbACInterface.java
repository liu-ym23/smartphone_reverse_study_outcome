package com.android.server.usb.descriptors;

import android.util.Log;
import com.android.server.usb.descriptors.report.ReportCanvas;
import com.android.server.usb.descriptors.report.UsbStrings;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UsbACInterface extends UsbDescriptor {
    public static final byte ACI_CLOCK_MULTIPLIER = 12;
    public static final byte ACI_CLOCK_SELECTOR = 11;
    public static final byte ACI_CLOCK_SOURCE = 10;
    public static final byte ACI_EXTENSION_UNIT = 8;
    public static final byte ACI_FEATURE_UNIT = 6;
    public static final byte ACI_HEADER = 1;
    public static final byte ACI_INPUT_TERMINAL = 2;
    public static final byte ACI_MIXER_UNIT = 4;
    public static final byte ACI_OUTPUT_TERMINAL = 3;
    public static final byte ACI_PROCESSING_UNIT = 7;
    public static final byte ACI_SAMPLE_RATE_CONVERTER = 13;
    public static final byte ACI_SELECTOR_UNIT = 5;
    public static final byte ACI_UNDEFINED = 0;
    public static final byte ASI_FORMAT_SPECIFIC = 3;
    public static final byte ASI_FORMAT_TYPE = 2;
    public static final byte ASI_GENERAL = 1;
    public static final byte ASI_UNDEFINED = 0;
    public static final int FORMAT_III_IEC1937AC3 = 8193;
    public static final int FORMAT_III_IEC1937_MPEG1_Layer1 = 8194;
    public static final int FORMAT_III_IEC1937_MPEG1_Layer2 = 8195;
    public static final int FORMAT_III_IEC1937_MPEG2_EXT = 8196;
    public static final int FORMAT_III_IEC1937_MPEG2_Layer1LS = 8197;
    public static final int FORMAT_III_UNDEFINED = 8192;
    public static final int FORMAT_II_AC3 = 4098;
    public static final int FORMAT_II_MPEG = 4097;
    public static final int FORMAT_II_UNDEFINED = 4096;
    public static final int FORMAT_I_ALAW = 4;
    public static final int FORMAT_I_IEEE_FLOAT = 3;
    public static final int FORMAT_I_MULAW = 5;
    public static final int FORMAT_I_PCM = 1;
    public static final int FORMAT_I_PCM8 = 2;
    public static final int FORMAT_I_UNDEFINED = 0;
    public static final byte MSI_ELEMENT = 4;
    public static final byte MSI_HEADER = 1;
    public static final byte MSI_IN_JACK = 2;
    public static final byte MSI_OUT_JACK = 3;
    public static final byte MSI_UNDEFINED = 0;
    private static final String TAG = "UsbACInterface";
    protected final int mSubclass;
    protected final byte mSubtype;

    public UsbACInterface(int length, byte type, byte subtype, int subclass) {
        super(length, type);
        this.mSubtype = subtype;
        this.mSubclass = subclass;
    }

    public byte getSubtype() {
        return this.mSubtype;
    }

    public int getSubclass() {
        return this.mSubclass;
    }

    private static UsbDescriptor allocAudioControlDescriptor(UsbDescriptorParser parser, ByteStream stream, int length, byte type, byte subtype, int subClass) {
        switch(subtype) {
            case 1: goto L28;
            case 2: goto L23;
            case 3: goto L17;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L4;
        };
    L4:
        Log.w(TAG, "Unknown Audio Class Interface subtype:0x" + Integer.toHexString(subtype));
        return new UsbACInterfaceUnparsed(length, type, subtype, subClass);
    L28:
        int acInterfaceSpec = stream.unpackUsbShort();
        parser.setACInterfaceSpec(acInterfaceSpec);
        if (acInterfaceSpec != 512) goto L33;
        return new Usb20ACHeader(length, type, subtype, subClass, acInterfaceSpec);
    L33:
        return new Usb10ACHeader(length, type, subtype, subClass, acInterfaceSpec);
    L7:
        return new UsbACFeatureUnit(length, type, subtype, subClass);
    L9:
        return new UsbACSelectorUnit(length, type, subtype, subClass);
    L11:
        if (parser.getACInterfaceSpec() != 512) goto L15;
        return new Usb20ACMixerUnit(length, type, subtype, subClass);
    L15:
        return new Usb10ACMixerUnit(length, type, subtype, subClass);
    L17:
        if (parser.getACInterfaceSpec() != 512) goto L21;
        return new Usb20ACOutputTerminal(length, type, subtype, subClass);
    L21:
        return new Usb10ACOutputTerminal(length, type, subtype, subClass);
    L23:
        if (parser.getACInterfaceSpec() != 512) goto L27;
        return new Usb20ACInputTerminal(length, type, subtype, subClass);
    L27:
        return new Usb10ACInputTerminal(length, type, subtype, subClass);
    }

    private static UsbDescriptor allocAudioStreamingDescriptor(UsbDescriptorParser parser, ByteStream stream, int length, byte type, byte subtype, int subClass) {
        int acInterfaceSpec = parser.getACInterfaceSpec();
        switch(subtype) {
            case 1: goto L9;
            case 2: goto L7;
            default: goto L4;
        };
    L4:
        Log.w(TAG, "Unknown Audio Streaming Interface subtype:0x" + Integer.toHexString(subtype));
        return null;
    L7:
        return UsbASFormat.allocDescriptor(parser, stream, length, type, subtype, subClass);
    L9:
        if (acInterfaceSpec != 512) goto L13;
        return new Usb20ASGeneral(length, type, subtype, subClass);
    L13:
        return new Usb10ASGeneral(length, type, subtype, subClass);
    }

    private static UsbDescriptor allocMidiStreamingDescriptor(int length, byte type, byte subtype, int subClass) {
        switch(subtype) {
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L3;
        };
    L3:
        Log.w(TAG, "Unknown MIDI Streaming Interface subtype:0x" + Integer.toHexString(subtype));
        return null;
    L6:
        return new UsbMSMidiOutputJack(length, type, subtype, subClass);
    L8:
        return new UsbMSMidiInputJack(length, type, subtype, subClass);
    L10:
        return new UsbMSMidiHeader(length, type, subtype, subClass);
    }

    public static UsbDescriptor allocDescriptor(UsbDescriptorParser parser, ByteStream stream, int length, byte type) {
        byte subtype = stream.getByte();
        UsbInterfaceDescriptor interfaceDesc = parser.getCurInterface();
        int subClass = interfaceDesc.getUsbSubclass();
        switch(subClass) {
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            default: goto L4;
        };
    L4:
        Log.w(TAG, "Unknown Audio Class Interface Subclass: 0x" + Integer.toHexString(subClass));
        return null;
    L7:
        return allocMidiStreamingDescriptor(length, type, subtype, subClass);
    L9:
        return allocAudioStreamingDescriptor(parser, stream, length, type, subtype, subClass);
    L11:
        return allocAudioControlDescriptor(parser, stream, length, type, subtype, subClass);
    }

    @Override // com.android.server.usb.descriptors.UsbDescriptor, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        super.report(canvas);
        int subClass = getSubclass();
        String subClassName = UsbStrings.getACInterfaceSubclassName(subClass);
        byte subtype = getSubtype();
        String subTypeName = UsbStrings.getACControlInterfaceName(subtype);
        canvas.openList();
        canvas.writeListItem("Subclass: " + ReportCanvas.getHexString(subClass) + " " + subClassName);
        canvas.writeListItem("Subtype: " + ReportCanvas.getHexString(subtype) + " " + subTypeName);
        canvas.closeList();
    }
}
