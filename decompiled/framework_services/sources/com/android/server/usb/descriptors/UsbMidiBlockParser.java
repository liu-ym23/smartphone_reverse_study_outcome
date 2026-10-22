package com.android.server.usb.descriptors;

import android.hardware.usb.UsbDeviceConnection;
import android.util.Log;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.server.devicepolicy.IZswDevicePolicyData;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class UsbMidiBlockParser {
    public static final int CS_GR_TRM_BLOCK = 38;
    public static final int DEFAULT_MIDI_TYPE = 1;
    public static final int GR_TRM_BLOCK_HEADER = 1;
    public static final int MIDI_BLOCK_HEADER_SIZE = 5;
    public static final int MIDI_BLOCK_SIZE = 13;
    public static final int REQ_GET_DESCRIPTOR = 6;
    public static final int REQ_TIMEOUT_MS = 2000;
    private static final String TAG = "UsbMidiBlockParser";
    private ArrayList<GroupTerminalBlock> mGroupTerminalBlocks;
    protected int mHeaderDescriptorSubtype;
    protected int mHeaderDescriptorType;
    protected int mHeaderLength;
    protected int mTotalLength;

    static class GroupTerminalBlock {
        protected int mBlockItem;
        protected int mDescriptorSubtype;
        protected int mDescriptorType;
        protected int mGroupBlockId;
        protected int mGroupTerminal;
        protected int mGroupTerminalBlockType;
        protected int mLength;
        protected int mMaxInputBandwidth;
        protected int mMaxOutputBandwidth;
        protected int mMidiProtocol;
        protected int mNumGroupTerminals;

        GroupTerminalBlock() {
        }

        public int parseRawDescriptors(ByteStream stream) {
            this.mLength = stream.getUnsignedByte();
            this.mDescriptorType = stream.getUnsignedByte();
            this.mDescriptorSubtype = stream.getUnsignedByte();
            this.mGroupBlockId = stream.getUnsignedByte();
            this.mGroupTerminalBlockType = stream.getUnsignedByte();
            this.mGroupTerminal = stream.getUnsignedByte();
            this.mNumGroupTerminals = stream.getUnsignedByte();
            this.mBlockItem = stream.getUnsignedByte();
            this.mMidiProtocol = stream.getUnsignedByte();
            this.mMaxInputBandwidth = stream.unpackUsbShort();
            this.mMaxOutputBandwidth = stream.unpackUsbShort();
            return this.mLength;
        }

        public void dump(DualDumpOutputStream dump, String idName, long id) {
            long token = dump.start(idName, id);
            dump.write(IZswDevicePolicyData.ATTR_LENGTH, 1120986464257L, this.mLength);
            dump.write("descriptor_type", 1120986464258L, this.mDescriptorType);
            dump.write("descriptor_subtype", 1120986464259L, this.mDescriptorSubtype);
            dump.write("group_block_id", 1120986464260L, this.mGroupBlockId);
            dump.write("group_terminal_block_type", 1120986464261L, this.mGroupTerminalBlockType);
            dump.write("group_terminal", 1120986464262L, this.mGroupTerminal);
            dump.write("num_group_terminals", 1120986464263L, this.mNumGroupTerminals);
            dump.write("block_item", 1120986464264L, this.mBlockItem);
            dump.write("midi_protocol", 1120986464265L, this.mMidiProtocol);
            dump.write("max_input_bandwidth", 1120986464266L, this.mMaxInputBandwidth);
            dump.write("max_output_bandwidth", 1120986464267L, this.mMaxOutputBandwidth);
            dump.end(token);
        }
    }

    public UsbMidiBlockParser() {
        this.mGroupTerminalBlocks = new ArrayList();
    }

    public int parseRawDescriptors(ByteStream stream) {
        this.mHeaderLength = stream.getUnsignedByte();
        this.mHeaderDescriptorType = stream.getUnsignedByte();
        this.mHeaderDescriptorSubtype = stream.getUnsignedByte();
        this.mTotalLength = stream.unpackUsbShort();
    L4:
        if (stream.available() < 13) goto L7;
        GroupTerminalBlock block = new GroupTerminalBlock();
        block.parseRawDescriptors(stream);
        this.mGroupTerminalBlocks.add(block);
        goto L4
    L7:
        return this.mTotalLength;
    }

    public int calculateMidiType(UsbDeviceConnection connection, int interfaceNumber, int alternateInterfaceNumber) {
        byte[] byteArray = new byte[5];
        int rdo = connection.controlTransfer(129, 6, alternateInterfaceNumber + 9728, interfaceNumber, byteArray, 5, 2000);     // Catch: Exception -> L9
        if (rdo > 0) goto L6;
        Log.e(TAG, "first transfer failed: " + rdo);     // Catch: Exception -> L9
    L36:
        return 1;
    L6:
        if (byteArray[1] == 38) goto L12;
        Log.e(TAG, "Incorrect descriptor type: " + byteArray[1]);     // Catch: Exception -> L9
        return 1;
    L12:
        if (byteArray[2] == 1) goto L15;
        Log.e(TAG, "Incorrect descriptor subtype: " + byteArray[2]);     // Catch: Exception -> L9
        return 1;
    L15:
        int newSize = (byteArray[3] & 255) + ((byteArray[4] & 255) << 8);     // Catch: Exception -> L9
        if (newSize > 0) goto L19;
        Log.e(TAG, "Parsed a non-positive block terminal size: " + newSize);     // Catch: Exception -> L9
        return 1;
    L19:
        byte[] byteArray2 = new byte[newSize];     // Catch: Exception -> L9
        int rdo2 = connection.controlTransfer(129, 6, alternateInterfaceNumber + 9728, interfaceNumber, byteArray2, newSize, 2000);     // Catch: Exception -> L31
        if (rdo2 <= 0) goto L30;
        ByteStream stream = new ByteStream(byteArray2);     // Catch: Exception -> L9
        parseRawDescriptors(stream);     // Catch: Exception -> L9
        if (this.mGroupTerminalBlocks.isEmpty() == false) goto L28;
        Log.e(TAG, "Group Terminal Blocks failed parsing: 1");     // Catch: Exception -> L9
        return 1;
    L28:
        Log.d(TAG, "MIDI protocol: " + this.mGroupTerminalBlocks.get(0).mMidiProtocol);     // Catch: Exception -> L9
        return this.mGroupTerminalBlocks.get(0).mMidiProtocol;
    L30:
        Log.e(TAG, "second transfer failed: " + rdo2);     // Catch: Exception -> L9
    L31:
        e = e;
    L35:
        Log.e(TAG, "Can not communicate with USB device", e);
    L9:
        e = e;
        goto L35
    }

    public void dump(DualDumpOutputStream dump, String idName, long id) {
        long token = dump.start(idName, id);
        dump.write(IZswDevicePolicyData.ATTR_LENGTH, 1120986464257L, this.mHeaderLength);
        dump.write("descriptor_type", 1120986464258L, this.mHeaderDescriptorType);
        dump.write("descriptor_subtype", 1120986464259L, this.mHeaderDescriptorSubtype);
        dump.write("total_length", 1120986464260L, this.mTotalLength);
        Iterator<GroupTerminalBlock> r2 = this.mGroupTerminalBlocks.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        GroupTerminalBlock groupTerminalBlock = r2.next();
        groupTerminalBlock.dump(dump, "block", 2246267895813L);
        goto L4
    L6:
        dump.end(token);
    }
}
