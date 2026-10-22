package com.android.server.usb.descriptors;

import android.hardware.usb.UsbDevice;
import android.util.Log;
import com.android.server.usb.descriptors.report.Reporting;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbDescriptorParser {
    public static final boolean DEBUG = false;
    private static final int DESCRIPTORS_ALLOC_SIZE = 128;
    private static final float IN_HEADSET_TRIGGER = 0.75f;
    private static final int MS_MIDI_1_0 = 256;
    private static final int MS_MIDI_2_0 = 512;
    private static final float OUT_HEADSET_TRIGGER = 0.75f;
    private static final String TAG = "UsbDescriptorParser";
    private int mACInterfacesSpec;
    private UsbConfigDescriptor mCurConfigDescriptor;
    private UsbEndpointDescriptor mCurEndpointDescriptor;
    private UsbInterfaceDescriptor mCurInterfaceDescriptor;
    private final ArrayList<UsbDescriptor> mDescriptors;
    private final String mDeviceAddr;
    private UsbDeviceDescriptor mDeviceDescriptor;
    private int mVCInterfacesSpec;

    private class UsbDescriptorsStreamFormatException extends Exception {
        String mMessage;
        final /* synthetic */ UsbDescriptorParser this$0;

        UsbDescriptorsStreamFormatException(UsbDescriptorParser r1, String message) {
            this.this$0 = r1;
            this.mMessage = message;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "Descriptor Stream Format Exception: " + this.mMessage;
        }
    }

    private native String getDescriptorString_native(String r1, int r2);

    private native byte[] getRawDescriptors_native(String r1);

    public UsbDescriptorParser(String deviceAddr, ArrayList<UsbDescriptor> descriptors) {
        this.mACInterfacesSpec = 256;
        this.mVCInterfacesSpec = 256;
        this.mDeviceAddr = deviceAddr;
        this.mDescriptors = descriptors;
        this.mDeviceDescriptor = (UsbDeviceDescriptor) descriptors.get(0);
    }

    public UsbDescriptorParser(String deviceAddr, byte[] rawDescriptors) {
        this.mACInterfacesSpec = 256;
        this.mVCInterfacesSpec = 256;
        this.mDeviceAddr = deviceAddr;
        this.mDescriptors = new ArrayList(128);
        parseDescriptors(rawDescriptors);
    }

    public String getDeviceAddr() {
        return this.mDeviceAddr;
    }

    public int getUsbSpec() {
        if (this.mDeviceDescriptor == null) goto L7;
        return this.mDeviceDescriptor.getSpec();
    L7:
        throw new IllegalArgumentException();
    }

    public void setACInterfaceSpec(int spec) {
        this.mACInterfacesSpec = spec;
    }

    public int getACInterfaceSpec() {
        return this.mACInterfacesSpec;
    }

    public void setVCInterfaceSpec(int spec) {
        this.mVCInterfacesSpec = spec;
    }

    public int getVCInterfaceSpec() {
        return this.mVCInterfacesSpec;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private UsbDescriptor allocDescriptor(ByteStream r8) throws UsbDescriptorsStreamFormatException {
        r8.resetReadCount();
        int r0 = r8.getUnsignedByte();
        byte r1 = r8.getByte();
        UsbDescriptor.logDescriptorName(r1, r0);
        UsbDescriptor r2 = null;
        UsbDescriptor r3 = null;
        r3 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        switch(r1) {
            case 1: goto L45;
            case 2: goto L40;
            case 4: goto L35;
            case 5: goto L30;
            case 11: goto L29;
            case 33: goto L28;
            case 36: goto L19;
            case 37: goto L6;
            default: goto L46;
        };
    L28:
        r2 = new UsbHIDDescriptor(r0, r1);
        goto L46
    L29:
        r2 = new UsbInterfaceAssoc(r0, r1);
        goto L46
    L30:
        UsbEndpointDescriptor r4 = new UsbEndpointDescriptor(r0, r1);
        this.mCurEndpointDescriptor = r4;
        UsbEndpointDescriptor r5 = r4;
        if (this.mCurInterfaceDescriptor == null) goto L33;
        this.mCurInterfaceDescriptor.addEndpointDescriptor(r5);
        r2 = r5;
        goto L46
    L33:
        Log.e(TAG, "Endpoint Descriptor found with no associated Interface Descriptor!");
        throw new UsbDescriptorsStreamFormatException(this, "Endpoint Descriptor found with no associated Interface Descriptor!");
    L35:
        UsbInterfaceDescriptor r6 = new UsbInterfaceDescriptor(r0, r1);
        this.mCurInterfaceDescriptor = r6;
        r2 = r6;
        if (this.mCurConfigDescriptor == null) goto L38;
        this.mCurConfigDescriptor.addInterfaceDescriptor(this.mCurInterfaceDescriptor);
        goto L46
    L38:
        Log.e(TAG, "Interface Descriptor found with no associated Config Descriptor!");
        throw new UsbDescriptorsStreamFormatException(this, "Interface Descriptor found with no associated Config Descriptor!");
    L40:
        UsbConfigDescriptor r7 = new UsbConfigDescriptor(r0, r1);
        this.mCurConfigDescriptor = r7;
        r2 = r7;
        if (this.mDeviceDescriptor == null) goto L43;
        this.mDeviceDescriptor.addConfigDescriptor(this.mCurConfigDescriptor);
        goto L46
    L43:
        Log.e(TAG, "Config Descriptor found with no associated Device Descriptor!");
        throw new UsbDescriptorsStreamFormatException(this, "Config Descriptor found with no associated Device Descriptor!");
    L45:
        UsbDeviceDescriptor r9 = new UsbDeviceDescriptor(r0, r1);
        this.mDeviceDescriptor = r9;
        r2 = r9;
    L46:
        if (r2 == null) goto L48;
        return r2;
    L48:
        return new UsbUnknown(r0, r1);
    L6:
        if (this.mCurInterfaceDescriptor == null) goto L46;
        int r10 = this.mCurInterfaceDescriptor.getUsbClass();
        switch(r10) {
            case 1: goto L12;
            case 14: goto L11;
            case 16: goto L13;
            default: goto L9;
        };
    L9:
        Log.w(TAG, "  Unparsed Class-specific Endpoint:0x" + Integer.toHexString(r10));
        goto L13
    L11:
        r3 = UsbVCEndpoint.allocDescriptor(this, r0, r1, Byte.valueOf(r8.getByte()).byteValue());
        goto L13
    L12:
        r3 = UsbACEndpoint.allocDescriptor(this, r0, r1, Byte.valueOf(r8.getByte()).byteValue());
    L13:
        r2 = r3;
        r2 = r3;
        if (this.mCurEndpointDescriptor == null) goto L46;
        if (r3 == null) goto L46;
        this.mCurEndpointDescriptor.setClassSpecificEndpointDescriptor(r3);
        r2 = r3;
        goto L46
    L19:
        if (this.mCurInterfaceDescriptor == null) goto L46;
        switch(this.mCurInterfaceDescriptor.getUsbClass()) {
            case 1: goto L25;
            case 14: goto L24;
            case 16: goto L46;
            default: goto L22;
        };
    L22:
        Log.w(TAG, "  Unparsed Class-specific");
        goto L46
    L24:
        r2 = UsbVCInterface.allocDescriptor(this, r8, r0, r1);
        goto L46
    L25:
        UsbDescriptor r11 = UsbACInterface.allocDescriptor(this, r8, r0, r1);
        boolean r12 = r11 instanceof UsbMSMidiHeader;
        r2 = r11;
        if (r12 == false) goto L46;
        this.mCurInterfaceDescriptor.setMidiHeaderInterfaceDescriptor(r11);
        r2 = r11;
        goto L46
    }

    public UsbDeviceDescriptor getDeviceDescriptor() {
        return this.mDeviceDescriptor;
    }

    public UsbInterfaceDescriptor getCurInterface() {
        return this.mCurInterfaceDescriptor;
    }

    public void parseDescriptors(byte[] descriptors) {
        ByteStream stream = new ByteStream(descriptors);
    L4:
        if (stream.available() <= 0) goto L28;
        UsbDescriptor descriptor = null;
        descriptor = allocDescriptor(stream);     // Catch: Exception -> L8
    L10:
        if (descriptor == null) goto L4;
        descriptor.parseRawDescriptors(stream);     // Catch: Throwable -> L13 Exception -> L15
        descriptor.postParse(stream);     // Catch: Throwable -> L13 Exception -> L15
    L12:
        this.mDescriptors.add(descriptor);
        goto L4
    L15:
        ex = move-exception;
        descriptor.postParse(stream);     // Catch: Throwable -> L13
        Log.w(TAG, "Exception parsing USB descriptors. type:0x" + descriptor.getType() + " status:" + descriptor.getStatus());     // Catch: Throwable -> L13
        StackTraceElement[] stackElems = ex.getStackTrace();     // Catch: Throwable -> L13
        if (stackElems.length <= 0) goto L21;
        Log.i(TAG, "  class:" + stackElems[0].getClassName() + " @ " + stackElems[0].getLineNumber());     // Catch: Throwable -> L13
    L21:
        if (stackElems.length <= 1) goto L23;
        Log.i(TAG, "  class:" + stackElems[1].getClassName() + " @ " + stackElems[1].getLineNumber());     // Catch: Throwable -> L13
    L23:
        descriptor.setStatus(4);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.mDescriptors.add(descriptor);
        throw th;
    L8:
        ex = move-exception;
        Log.e(TAG, "Exception allocating USB descriptor.", ex);
        goto L10
    }

    public byte[] getRawDescriptors() {
        return getRawDescriptors_native(this.mDeviceAddr);
    }

    public String getDescriptorString(int stringId) {
        return getDescriptorString_native(this.mDeviceAddr, stringId);
    }

    public int getParsingSpec() {
        if (this.mDeviceDescriptor != null) goto L7;
        return 0;
    L7:
        return this.mDeviceDescriptor.getSpec();
    }

    public ArrayList<UsbDescriptor> getDescriptors() {
        return this.mDescriptors;
    }

    public UsbDevice.Builder toAndroidUsbDeviceBuilder() {
        if (this.mDeviceDescriptor != null) goto L6;
        Log.e(TAG, "toAndroidUsbDevice() ERROR - No Device Descriptor");
        return null;
    L6:
        UsbDevice.Builder builder = this.mDeviceDescriptor.toAndroid(this);
        if (builder != null) goto L9;
        Log.e(TAG, "toAndroidUsbDevice() ERROR Creating Device");
    L9:
        return builder;
    }

    public ArrayList<UsbDescriptor> getDescriptors(byte type) {
        ArrayList<UsbDescriptor> list = new ArrayList();
        Iterator<UsbDescriptor> r1 = this.mDescriptors.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        UsbDescriptor descriptor = r1.next();
        if (descriptor.getType() != type) goto L4;
        list.add(descriptor);
        goto L4
    L9:
        return list;
    }

    public ArrayList<UsbDescriptor> getInterfaceDescriptorsForClass(int usbClass) {
        ArrayList<UsbDescriptor> list = new ArrayList();
        Iterator<UsbDescriptor> r1 = this.mDescriptors.iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        UsbDescriptor descriptor = r1.next();
        if (descriptor.getType() != 4) goto L4;
        if ((descriptor instanceof UsbInterfaceDescriptor) == true) goto L9;
        Log.w(TAG, "Unrecognized Interface l: " + descriptor.getLength() + " t:0x" + Integer.toHexString(descriptor.getType()));
        goto L4
    L9:
        UsbInterfaceDescriptor intrDesc = (UsbInterfaceDescriptor) descriptor;
        if (intrDesc.getUsbClass() != usbClass) goto L4;
        list.add(descriptor);
        goto L4
    L15:
        return list;
    }

    public ArrayList<UsbDescriptor> getACInterfaceDescriptors(byte subtype, int subclass) {
        ArrayList<UsbDescriptor> list = new ArrayList();
        Iterator<UsbDescriptor> r1 = this.mDescriptors.iterator();
    L4:
        if (r1.hasNext() == false) goto L17;
        UsbDescriptor descriptor = r1.next();
        if (descriptor.getType() != 36) goto L4;
        if ((descriptor instanceof UsbACInterface) == true) goto L9;
        Log.w(TAG, "Unrecognized Audio Interface len: " + descriptor.getLength() + " type:0x" + Integer.toHexString(descriptor.getType()));
        goto L4
    L9:
        UsbACInterface acDescriptor = (UsbACInterface) descriptor;
        if (acDescriptor.getSubtype() != subtype) goto L4;
        if (acDescriptor.getSubclass() != subclass) goto L4;
        list.add(descriptor);
        goto L4
    L17:
        return list;
    }

    public boolean hasInput() {
        ArrayList<UsbDescriptor> acDescriptors = getACInterfaceDescriptors((byte) 2, 1);
        Iterator<UsbDescriptor> r2 = acDescriptors.iterator();
    L4:
        if (r2.hasNext() == false) goto L25;
        UsbDescriptor descriptor = r2.next();
        if ((descriptor instanceof UsbACTerminal) == true) goto L7;
        Log.w(TAG, "Undefined Audio Input terminal l: " + descriptor.getLength() + " t:0x" + Integer.toHexString(descriptor.getType()));
        goto L4
    L7:
        UsbACTerminal inDescr = (UsbACTerminal) descriptor;
        int type = inDescr.getTerminalType();
        int terminalCategory = type & (-256);
        if (terminalCategory == 256) goto L4;
        if (terminalCategory == 768) goto L4;
        return true;
    L25:
        return false;
    }

    public boolean hasOutput() {
        ArrayList<UsbDescriptor> acDescriptors = getACInterfaceDescriptors((byte) 3, 1);
        Iterator<UsbDescriptor> r2 = acDescriptors.iterator();
    L4:
        if (r2.hasNext() == false) goto L25;
        UsbDescriptor descriptor = r2.next();
        if ((descriptor instanceof UsbACTerminal) == true) goto L7;
        Log.w(TAG, "Undefined Audio Input terminal l: " + descriptor.getLength() + " t:0x" + Integer.toHexString(descriptor.getType()));
        goto L4
    L7:
        UsbACTerminal outDescr = (UsbACTerminal) descriptor;
        int type = outDescr.getTerminalType();
        int terminalCategory = type & (-256);
        if (terminalCategory == 256) goto L4;
        if (terminalCategory == 512) goto L4;
        return true;
    L25:
        return false;
    }

    public boolean hasMic() {
        ArrayList<UsbDescriptor> acDescriptors = getACInterfaceDescriptors((byte) 2, 1);
        Iterator<UsbDescriptor> r2 = acDescriptors.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        UsbDescriptor descriptor = r2.next();
        if ((descriptor instanceof UsbACTerminal) == true) goto L7;
        Log.w(TAG, "Undefined Audio Input terminal l: " + descriptor.getLength() + " t:0x" + Integer.toHexString(descriptor.getType()));
        goto L4
    L7:
        UsbACTerminal inDescr = (UsbACTerminal) descriptor;
        if (inDescr.isInputTerminal() == false) goto L4;
        return true;
    L13:
        return false;
    }

    public boolean hasSpeaker() {
        ArrayList<UsbDescriptor> acDescriptors = getACInterfaceDescriptors((byte) 3, 1);
        Iterator<UsbDescriptor> r2 = acDescriptors.iterator();
    L4:
        if (r2.hasNext() == false) goto L28;
        UsbDescriptor descriptor = r2.next();
        if ((descriptor instanceof UsbACTerminal) == true) goto L7;
        Log.w(TAG, "Undefined Audio Output terminal l: " + descriptor.getLength() + " t:0x" + Integer.toHexString(descriptor.getType()));
        goto L4
    L7:
        UsbACTerminal outDescr = (UsbACTerminal) descriptor;
        if (outDescr.getTerminalType() == 769) goto L15;
        if (outDescr.getTerminalType() == 770) goto L15;
        if (outDescr.getTerminalType() != 1026) goto L4;
    L15:
        return true;
    L28:
        return false;
    }

    public boolean hasAudioInterface() {
        ArrayList<UsbDescriptor> descriptors = getInterfaceDescriptorsForClass(1);
        return true ^ descriptors.isEmpty();
    }

    public boolean hasAudioTerminal(int subType, int terminalType) {
        Iterator<UsbDescriptor> r0 = this.mDescriptors.iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        UsbDescriptor descriptor = r0.next();
        if ((descriptor instanceof UsbACTerminal) == false) goto L4;
        if (((UsbACTerminal) descriptor).getSubclass() != 1) goto L4;
        if (((UsbACTerminal) descriptor).getSubtype() != subType) goto L4;
        if (((UsbACTerminal) descriptor).getTerminalType() != terminalType) goto L4;
        return true;
    L15:
        return false;
    }

    public boolean hasAudioTerminalExcludeType(int subType, int excludedTerminalType) {
        Iterator<UsbDescriptor> r0 = this.mDescriptors.iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        UsbDescriptor descriptor = r0.next();
        if ((descriptor instanceof UsbACTerminal) == false) goto L4;
        if (((UsbACTerminal) descriptor).getSubclass() != 1) goto L4;
        if (((UsbACTerminal) descriptor).getSubtype() != subType) goto L4;
        if (((UsbACTerminal) descriptor).getTerminalType() == excludedTerminalType) goto L4;
        return true;
    L15:
        return false;
    }

    public boolean hasAudioPlayback() {
        if (hasAudioTerminalExcludeType(3, 257) == true) goto L5;
    L7:
        return false;
    L5:
        if (hasAudioTerminal(2, 257) == false) goto L7;
        return true;
    }

    public boolean hasAudioCapture() {
        if (hasAudioTerminalExcludeType(2, 257) == true) goto L5;
    L7:
        return false;
    L5:
        if (hasAudioTerminal(3, 257) == false) goto L7;
        return true;
    }

    public boolean hasVideoCapture() {
        Iterator<UsbDescriptor> r0 = this.mDescriptors.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        UsbDescriptor descriptor = r0.next();
        if ((descriptor instanceof UsbVCInputTerminal) == false) goto L4;
        return true;
    L10:
        return false;
    }

    public boolean hasVideoPlayback() {
        Iterator<UsbDescriptor> r0 = this.mDescriptors.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        UsbDescriptor descriptor = r0.next();
        if ((descriptor instanceof UsbVCOutputTerminal) == false) goto L4;
        return true;
    L10:
        return false;
    }

    public boolean hasHIDInterface() {
        ArrayList<UsbDescriptor> descriptors = getInterfaceDescriptorsForClass(3);
        return !descriptors.isEmpty();
    }

    public boolean hasStorageInterface() {
        ArrayList<UsbDescriptor> descriptors = getInterfaceDescriptorsForClass(8);
        return !descriptors.isEmpty();
    }

    public boolean hasMIDIInterface() {
        ArrayList<UsbDescriptor> descriptors = getInterfaceDescriptorsForClass(1);
        Iterator<UsbDescriptor> r2 = descriptors.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        UsbDescriptor descriptor = r2.next();
        if ((descriptor instanceof UsbInterfaceDescriptor) == true) goto L7;
        Log.w(TAG, "Undefined Audio Class Interface l: " + descriptor.getLength() + " t:0x" + Integer.toHexString(descriptor.getType()));
        goto L4
    L7:
        UsbInterfaceDescriptor interfaceDescriptor = (UsbInterfaceDescriptor) descriptor;
        if (interfaceDescriptor.getUsbSubclass() != 3) goto L4;
        return true;
    L13:
        return false;
    }

    public boolean containsUniversalMidiDeviceEndpoint() {
        ArrayList<UsbInterfaceDescriptor> interfaceDescriptors = findUniversalMidiInterfaceDescriptors();
        return doesInterfaceContainEndpoint(interfaceDescriptors);
    }

    public boolean containsLegacyMidiDeviceEndpoint() {
        ArrayList<UsbInterfaceDescriptor> interfaceDescriptors = findLegacyMidiInterfaceDescriptors();
        return doesInterfaceContainEndpoint(interfaceDescriptors);
    }

    public boolean doesInterfaceContainEndpoint(ArrayList<UsbInterfaceDescriptor> interfaceDescriptors) {
        int outputCount = 0;
        int inputCount = 0;
        int interfaceIndex = 0;
    L4:
        if (interfaceIndex >= interfaceDescriptors.size()) goto L15;
        UsbInterfaceDescriptor interfaceDescriptor = interfaceDescriptors.get(interfaceIndex);
        int endpointIndex = 0;
    L7:
        if (endpointIndex >= interfaceDescriptor.getNumEndpoints()) goto L13;
        UsbEndpointDescriptor endpoint = interfaceDescriptor.getEndpointDescriptor(endpointIndex);
        if (endpoint.getDirection() != 0) goto L11;
        outputCount = outputCount + 1;
    L12:
        endpointIndex = endpointIndex + 1;
        goto L7
    L11:
        inputCount = inputCount + 1;
        goto L12
    L13:
        interfaceIndex = interfaceIndex + 1;
        goto L4
    L15:
        if (outputCount > 0) goto L19;
        if (inputCount > 0) goto L19;
        return false;
    L19:
        return true;
    }

    public ArrayList<UsbInterfaceDescriptor> findUniversalMidiInterfaceDescriptors() {
        return findMidiInterfaceDescriptors(512);
    }

    public ArrayList<UsbInterfaceDescriptor> findLegacyMidiInterfaceDescriptors() {
        return findMidiInterfaceDescriptors(256);
    }

    private ArrayList<UsbInterfaceDescriptor> findMidiInterfaceDescriptors(int type) {
        ArrayList<UsbDescriptor> descriptors = getInterfaceDescriptorsForClass(1);
        ArrayList<UsbInterfaceDescriptor> midiInterfaces = new ArrayList();
        Iterator<UsbDescriptor> r3 = descriptors.iterator();
    L4:
        if (r3.hasNext() == false) goto L19;
        UsbDescriptor descriptor = r3.next();
        if ((descriptor instanceof UsbInterfaceDescriptor) == true) goto L7;
        Log.w(TAG, "Undefined Audio Class Interface l: " + descriptor.getLength() + " t:0x" + Integer.toHexString(descriptor.getType()));
        goto L4
    L7:
        UsbInterfaceDescriptor interfaceDescriptor = (UsbInterfaceDescriptor) descriptor;
        if (interfaceDescriptor.getUsbSubclass() != 3) goto L4;
        UsbDescriptor midiHeaderDescriptor = interfaceDescriptor.getMidiHeaderInterfaceDescriptor();
        if (midiHeaderDescriptor == null) goto L4;
        if ((midiHeaderDescriptor instanceof UsbMSMidiHeader) == false) goto L4;
        UsbMSMidiHeader midiHeader = (UsbMSMidiHeader) midiHeaderDescriptor;
        if (midiHeader.getMidiStreamingClass() != type) goto L4;
        midiInterfaces.add(interfaceDescriptor);
        goto L4
    L19:
        return midiInterfaces;
    }

    public int calculateMidiInterfaceDescriptorsCount() {
        int count = 0;
        ArrayList<UsbDescriptor> descriptors = getInterfaceDescriptorsForClass(1);
        Iterator<UsbDescriptor> r2 = descriptors.iterator();
    L4:
        if (r2.hasNext() == false) goto L17;
        UsbDescriptor descriptor = r2.next();
        if ((descriptor instanceof UsbInterfaceDescriptor) == true) goto L7;
        Log.w(TAG, "Undefined Audio Class Interface l: " + descriptor.getLength() + " t:0x" + Integer.toHexString(descriptor.getType()));
        goto L4
    L7:
        UsbInterfaceDescriptor interfaceDescriptor = (UsbInterfaceDescriptor) descriptor;
        if (interfaceDescriptor.getUsbSubclass() != 3) goto L4;
        UsbDescriptor midiHeaderDescriptor = interfaceDescriptor.getMidiHeaderInterfaceDescriptor();
        if (midiHeaderDescriptor == null) goto L4;
        if ((midiHeaderDescriptor instanceof UsbMSMidiHeader) == false) goto L4;
        UsbMSMidiHeader r6 = (UsbMSMidiHeader) midiHeaderDescriptor;
        count = count + 1;
        goto L4
    L17:
        return count;
    }

    private int calculateNumLegacyMidiPorts(boolean isOutput) {
        UsbConfigDescriptor configDescriptor = null;
        Iterator<UsbDescriptor> r1 = this.mDescriptors.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        UsbDescriptor descriptor = r1.next();
        if (descriptor.getType() != 2) goto L4;
        if ((descriptor instanceof UsbConfigDescriptor) == true) goto L9;
        Log.w(TAG, "Unrecognized Config l: " + descriptor.getLength() + " t:0x" + Integer.toHexString(descriptor.getType()));
        goto L4
    L9:
        configDescriptor = (UsbConfigDescriptor) descriptor;
    L13:
        if (configDescriptor != null) goto L16;
        Log.w(TAG, "Config not found");
        return 0;
    L16:
        ArrayList<UsbInterfaceDescriptor> legacyMidiInterfaceDescriptors = new ArrayList();
        Iterator<UsbInterfaceDescriptor> r3 = configDescriptor.getInterfaceDescriptors().iterator();
    L18:
        if (r3.hasNext() == false) goto L31;
        UsbInterfaceDescriptor interfaceDescriptor = r3.next();
        if (interfaceDescriptor.getUsbClass() != 1) goto L18;
        if (interfaceDescriptor.getUsbSubclass() != 3) goto L18;
        UsbDescriptor midiHeaderDescriptor = interfaceDescriptor.getMidiHeaderInterfaceDescriptor();
        if (midiHeaderDescriptor == null) goto L18;
        if ((midiHeaderDescriptor instanceof UsbMSMidiHeader) == false) goto L18;
        UsbMSMidiHeader midiHeader = (UsbMSMidiHeader) midiHeaderDescriptor;
        if (midiHeader.getMidiStreamingClass() != 256) goto L18;
        legacyMidiInterfaceDescriptors.add(interfaceDescriptor);
        goto L18
    L31:
        int count = 0;
        Iterator<UsbInterfaceDescriptor> r4 = legacyMidiInterfaceDescriptors.iterator();
    L33:
        if (r4.hasNext() == false) goto L49;
        UsbInterfaceDescriptor interfaceDescriptor2 = r4.next();
        int i = 0;
    L36:
        if (i >= interfaceDescriptor2.getNumEndpoints()) goto L33;
        UsbEndpointDescriptor endpoint = interfaceDescriptor2.getEndpointDescriptor(i);
        if (endpoint.getDirection() != 0) goto L40;
        boolean r9 = true;
    L41:
        if (r9 != isOutput) goto L47;
        UsbDescriptor classSpecificEndpointDescriptor = endpoint.getClassSpecificEndpointDescriptor();
        if (classSpecificEndpointDescriptor == null) goto L47;
        if ((classSpecificEndpointDescriptor instanceof UsbACMidi10Endpoint) == false) goto L47;
        UsbACMidi10Endpoint midiEndpoint = (UsbACMidi10Endpoint) classSpecificEndpointDescriptor;
        count = count + midiEndpoint.getNumJacks();
    L47:
        i = i + 1;
        goto L36
    L40:
        r9 = false;
        goto L41
    L49:
        return count;
    }

    public int calculateNumLegacyMidiInputs() {
        return calculateNumLegacyMidiPorts(false);
    }

    public int calculateNumLegacyMidiOutputs() {
        return calculateNumLegacyMidiPorts(true);
    }

    public float getInputHeadsetProbability() {
        if (hasMIDIInterface() == false) goto L6;
        return 0.0f;
    L6:
        float probability = 0.0f;
        boolean hasSpeaker = hasSpeaker();
        if (hasMic() == false) goto L17;
        if (hasSpeaker == false) goto L11;
        probability = 0.0f + 0.75f;
    L11:
        if (hasHIDInterface() == false) goto L14;
        probability = probability + 0.25f;
    L14:
        if (getMaximumInputChannelCount() > 1) goto L16;
        return probability;
    L16:
        return probability - 0.25f;
    L17:
        return 0.0f;
    }

    public boolean isInputHeadset() {
        if (getInputHeadsetProbability() >= 0.75f) goto L5;
    L7:
        return false;
    L5:
        if (isOutputHeadset() == false) goto L7;
        return true;
    }

    private int getMaximumChannelCount() {
        int maxChannelCount = 0;
        Iterator<UsbDescriptor> r1 = this.mDescriptors.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Reporting r2 = (UsbDescriptor) r1.next();
        if ((r2 instanceof UsbAudioChannelCluster) == false) goto L4;
        maxChannelCount = Math.max(maxChannelCount, ((UsbAudioChannelCluster) r2).getChannelCount());
        goto L4
    L9:
        return maxChannelCount;
    }

    private int getMaximumInputChannelCount() {
        int maxChannelCount = 0;
        ArrayList<UsbDescriptor> acDescriptors = getACInterfaceDescriptors((byte) 2, 1);
        Iterator<UsbDescriptor> r3 = acDescriptors.iterator();
    L4:
        if (r3.hasNext() == false) goto L15;
        Reporting r4 = (UsbDescriptor) r3.next();
        if ((r4 instanceof UsbACTerminal) == false) goto L4;
        UsbACTerminal inDescr = (UsbACTerminal) r4;
        if (inDescr.isInputTerminal() == false) goto L4;
        maxChannelCount = Math.max(maxChannelCount, 1);
        if ((r4 instanceof UsbAudioChannelCluster) == false) goto L4;
        maxChannelCount = Math.max(maxChannelCount, ((UsbAudioChannelCluster) r4).getChannelCount());
        goto L4
    L15:
        return maxChannelCount;
    }

    public float getOutputHeadsetLikelihood() {
        if (hasMIDIInterface() == false) goto L6;
        return 0.0f;
    L6:
        float likelihood = 0.0f;
        boolean hasSpeaker = false;
        ArrayList<UsbDescriptor> acDescriptors = getACInterfaceDescriptors((byte) 3, 1);
        Iterator<UsbDescriptor> r3 = acDescriptors.iterator();
    L8:
        if (r3.hasNext() == false) goto L22;
        UsbDescriptor descriptor = r3.next();
        if ((descriptor instanceof UsbACTerminal) == true) goto L11;
        Log.w(TAG, "Undefined Audio Output terminal l: " + descriptor.getLength() + " t:0x" + Integer.toHexString(descriptor.getType()));
        goto L8
    L11:
        UsbACTerminal outDescr = (UsbACTerminal) descriptor;
        if (outDescr.getTerminalType() == 769) goto L19;
        if (outDescr.getTerminalType() == 770) goto L19;
        if (outDescr.getTerminalType() != 1026) goto L8;
    L19:
        hasSpeaker = true;
    L22:
        if (hasSpeaker == false) goto L24;
        likelihood = 0.0f + 0.75f;
    L24:
        if (hasSpeaker == true) goto L26;
    L30:
        return likelihood;
    L26:
        if (hasHIDInterface() == false) goto L30;
        return 0.25f + likelihood;
    }

    public boolean isOutputHeadset() {
        if (getOutputHeadsetLikelihood() < 0.75f) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDock() {
        if (hasMIDIInterface() == false) goto L5;
    L18:
        return false;
    L5:
        if (hasHIDInterface() == true) goto L18;
        ArrayList<UsbDescriptor> acDescriptors = getACInterfaceDescriptors((byte) 3, 1);
        if (acDescriptors.size() == 1) goto L11;
        return false;
    L11:
        if ((acDescriptors.get(0) instanceof UsbACTerminal) == false) goto L16;
        UsbACTerminal outDescr = (UsbACTerminal) acDescriptors.get(0);
        if (outDescr.getTerminalType() != 1538) goto L17;
        return true;
    L17:
        return false;
    L16:
        Log.w(TAG, "Undefined Audio Output terminal l: " + acDescriptors.get(0).getLength() + " t:0x" + Integer.toHexString(acDescriptors.get(0).getType()));
        goto L17
    }
}
