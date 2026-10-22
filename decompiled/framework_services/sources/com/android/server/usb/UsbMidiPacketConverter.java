package com.android.server.usb;

import android.util.Log;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class UsbMidiPacketConverter {
    private static final int[] CODE_INDEX_NUMBER_FROM_SYSTEM_TYPE = null;
    private static final byte CODE_INDEX_NUMBER_SINGLE_BYTE = 15;
    private static final byte CODE_INDEX_NUMBER_SYSEX_END_SINGLE_BYTE = 5;
    private static final byte CODE_INDEX_NUMBER_SYSEX_STARTS_OR_CONTINUES = 4;
    private static final byte FIRST_SYSTEM_MESSAGE_VALUE = -16;
    private static final int[] PAYLOAD_SIZE = null;
    private static final byte SYSEX_END_EXCLUSIVE = -9;
    private static final byte SYSEX_START_EXCLUSIVE = -16;
    private static final String TAG = "UsbMidiPacketConverter";
    private ByteArrayOutputStream mEncoderOutputStream;
    private UsbMidiDecoder mUsbMidiDecoder;
    private UsbMidiEncoder[] mUsbMidiEncoders;

    private class UsbMidiDecoder {
        ByteArrayOutputStream[] mDecodedByteArrays;
        int mNumJacks;

        UsbMidiDecoder(UsbMidiPacketConverter r3, int numJacks) {
            this.mNumJacks = numJacks;
            this.mDecodedByteArrays = new ByteArrayOutputStream[numJacks];
            int i = 0;
        L3:
            if (i >= numJacks) goto L6;
            this.mDecodedByteArrays[i] = new ByteArrayOutputStream();
            i = i + 1;
            goto L3
        }

        public void decode(byte[] usbMidiBytes, int size) {
            new ByteArrayOutputStream();
            if ((size % 4) == 0) goto L5;
            Log.w(UsbMidiPacketConverter.TAG, "size " + size + " not multiple of 4");
        L5:
            int i = 0;
        L7:
            if ((i + 3) >= size) goto L17;
            int cableNumber = (usbMidiBytes[i] >> 4) & 15;
            int codeIndex = usbMidiBytes[i] & 15;
            int numPayloadBytes = UsbMidiPacketConverter.m9186$$Nest$sfgetPAYLOAD_SIZE()[codeIndex];
            if (numPayloadBytes < 0) goto L15;
            if (cableNumber < this.mNumJacks) goto L14;
            Log.w(UsbMidiPacketConverter.TAG, "cableNumber " + cableNumber + " invalid");
            cableNumber = 0;
        L14:
            this.mDecodedByteArrays[cableNumber].write(usbMidiBytes, i + 1, numPayloadBytes);
        L15:
            i = i + 4;
            goto L7
        }

        public byte[] pullBytes(int cableNumber) {
            if (cableNumber < this.mNumJacks) goto L5;
            Log.w(UsbMidiPacketConverter.TAG, "cableNumber " + cableNumber + " invalid");
            cableNumber = 0;
        L5:
            byte[] output = this.mDecodedByteArrays[cableNumber].toByteArray();
            this.mDecodedByteArrays[cableNumber].reset();
            return output;
        }
    }

    private class UsbMidiEncoder {
        private byte[] mEmptyBytes;
        private boolean mHasSystemExclusiveStarted;
        private int mNumStoredSystemExclusiveBytes;
        private byte mShiftedCableNumber;
        private byte[] mStoredSystemExclusiveBytes;

        UsbMidiEncoder(UsbMidiPacketConverter r2, int cableNumber) {
            this.mStoredSystemExclusiveBytes = new byte[3];
            this.mNumStoredSystemExclusiveBytes = 0;
            this.mHasSystemExclusiveStarted = false;
            this.mEmptyBytes = new byte[3];
            this.mShiftedCableNumber = (byte) (cableNumber << 4);
        }

        public byte[] encode(byte[] midiBytes, int size) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int curLocation = 0;
        L3:
            if (curLocation >= size) goto L46;
            if (midiBytes[curLocation] >= 0) goto L7;
            if (midiBytes[curLocation] != (-9)) goto L16;
        L22:
            int index = midiBytes[curLocation];
            if (index < (-16)) goto L24;
            if (midiBytes[curLocation] == (-16)) goto L32;
            if (midiBytes[curLocation] == (-9)) goto L35;
            int systemType = midiBytes[curLocation] & 15;
            int codeIndexNumber = UsbMidiPacketConverter.m9185$$Nest$sfgetCODE_INDEX_NUMBER_FROM_SYSTEM_TYPE()[systemType];
            if (codeIndexNumber < 0) goto L38;
            int systemMessageSize = UsbMidiPacketConverter.m9186$$Nest$sfgetPAYLOAD_SIZE()[codeIndexNumber];
            if ((curLocation + systemMessageSize) <= size) goto L41;
        L42:
            if (curLocation >= size) goto L3;
            writeSingleByte(outputStream, midiBytes[curLocation]);
            curLocation = curLocation + 1;
            goto L42
        L41:
            outputStream.write(this.mShiftedCableNumber | codeIndexNumber);
            outputStream.write(midiBytes, curLocation, systemMessageSize);
            outputStream.write(this.mEmptyBytes, 0, 3 - systemMessageSize);
            curLocation = curLocation + systemMessageSize;
            goto L3
        L38:
            writeSingleByte(outputStream, midiBytes[curLocation]);
            curLocation = curLocation + 1;
            goto L3
        L35:
            outputStream.write((this.mNumStoredSystemExclusiveBytes + 5) | this.mShiftedCableNumber);
            this.mStoredSystemExclusiveBytes[this.mNumStoredSystemExclusiveBytes] = midiBytes[curLocation];
            this.mNumStoredSystemExclusiveBytes++;
            outputStream.write(this.mStoredSystemExclusiveBytes, 0, this.mNumStoredSystemExclusiveBytes);
            outputStream.write(this.mEmptyBytes, 0, 3 - this.mNumStoredSystemExclusiveBytes);
            this.mHasSystemExclusiveStarted = false;
            this.mNumStoredSystemExclusiveBytes = 0;
            curLocation = curLocation + 1;
            goto L3
        L32:
            this.mHasSystemExclusiveStarted = true;
            this.mStoredSystemExclusiveBytes[0] = midiBytes[curLocation];
            this.mNumStoredSystemExclusiveBytes = 1;
            curLocation = curLocation + 1;
            goto L3
        L24:
            byte codeIndexNumber2 = (byte) ((midiBytes[curLocation] >> 4) & 15);
            int channelMessageSize = UsbMidiPacketConverter.m9186$$Nest$sfgetPAYLOAD_SIZE()[codeIndexNumber2];
            if ((curLocation + channelMessageSize) <= size) goto L26;
        L27:
            if (curLocation >= size) goto L3;
            writeSingleByte(outputStream, midiBytes[curLocation]);
            curLocation = curLocation + 1;
            goto L27
        L26:
            outputStream.write(this.mShiftedCableNumber | codeIndexNumber2);
            outputStream.write(midiBytes, curLocation, channelMessageSize);
            outputStream.write(this.mEmptyBytes, 0, 3 - channelMessageSize);
            curLocation = curLocation + channelMessageSize;
            goto L3
        L16:
            if (this.mHasSystemExclusiveStarted == false) goto L22;
            int index2 = 0;
        L19:
            if (index2 >= this.mNumStoredSystemExclusiveBytes) goto L21;
            writeSingleByte(outputStream, this.mStoredSystemExclusiveBytes[index2]);
            index2 = index2 + 1;
            goto L19
        L21:
            this.mNumStoredSystemExclusiveBytes = 0;
            this.mHasSystemExclusiveStarted = false;
            goto L22
        L7:
            if (this.mHasSystemExclusiveStarted == false) goto L11;
            this.mStoredSystemExclusiveBytes[this.mNumStoredSystemExclusiveBytes] = midiBytes[curLocation];
            this.mNumStoredSystemExclusiveBytes++;
            if (this.mNumStoredSystemExclusiveBytes != 3) goto L12;
            outputStream.write(this.mShiftedCableNumber | 4);
            outputStream.write(this.mStoredSystemExclusiveBytes, 0, 3);
            this.mNumStoredSystemExclusiveBytes = 0;
        L12:
            curLocation = curLocation + 1;
            goto L3
        L11:
            writeSingleByte(outputStream, midiBytes[curLocation]);
            goto L12
        L46:
            return outputStream.toByteArray();
        }

        private void writeSingleByte(ByteArrayOutputStream outputStream, byte byteToWrite) {
            outputStream.write(this.mShiftedCableNumber | 15);
            outputStream.write(byteToWrite);
            outputStream.write(0);
            outputStream.write(0);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetCODE_INDEX_NUMBER_FROM_SYSTEM_TYPE, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m9185$$Nest$sfgetCODE_INDEX_NUMBER_FROM_SYSTEM_TYPE() {
        return CODE_INDEX_NUMBER_FROM_SYSTEM_TYPE;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPAYLOAD_SIZE, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m9186$$Nest$sfgetPAYLOAD_SIZE() {
        return PAYLOAD_SIZE;
    }

    public UsbMidiPacketConverter() {
        this.mEncoderOutputStream = new ByteArrayOutputStream();
    }

    static {
        PAYLOAD_SIZE = new int[]{-1, -1, 2, 3, 3, 1, 2, 3, 3, 3, 3, 3, 2, 2, 3, 1};
        CODE_INDEX_NUMBER_FROM_SYSTEM_TYPE = new int[]{-1, 2, 3, 2, -1, -1, 5, -1, 5, -1, 5, 5, 5, -1, 5, 5};
    }

    public void createEncoders(int size) {
        this.mUsbMidiEncoders = new UsbMidiEncoder[size];
        int i = 0;
    L3:
        if (i >= size) goto L6;
        this.mUsbMidiEncoders[i] = new UsbMidiEncoder(this, i);
        i = i + 1;
        goto L3
    }

    public void encodeMidiPackets(byte[] midiBytes, int size, int encoderId) {
        if (encoderId < this.mUsbMidiEncoders.length) goto L5;
        Log.w(TAG, "encoderId " + encoderId + " invalid");
        encoderId = 0;
    L5:
        byte[] encodedPacket = this.mUsbMidiEncoders[encoderId].encode(midiBytes, size);
        this.mEncoderOutputStream.write(encodedPacket, 0, encodedPacket.length);
    }

    public byte[] pullEncodedMidiPackets() {
        byte[] output = this.mEncoderOutputStream.toByteArray();
        this.mEncoderOutputStream.reset();
        return output;
    }

    public void createDecoders(int size) {
        this.mUsbMidiDecoder = new UsbMidiDecoder(this, size);
    }

    public void decodeMidiPackets(byte[] usbMidiBytes, int size) {
        this.mUsbMidiDecoder.decode(usbMidiBytes, size);
    }

    public byte[] pullDecodedMidiPackets(int cableNumber) {
        return this.mUsbMidiDecoder.pullBytes(cableNumber);
    }
}
