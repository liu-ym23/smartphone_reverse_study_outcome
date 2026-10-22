package com.android.server.hdmi;

import java.io.UnsupportedEncodingException;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes2.dex */
public class HdmiCecMessageBuilder {
    private static final int OSD_NAME_MAX_LENGTH = 14;

    private HdmiCecMessageBuilder() {
    }

    static HdmiCecMessage buildFeatureAbortCommand(int src, int dest, int originalOpcode, int reason) {
        byte[] params = {(byte) (originalOpcode & 255), (byte) (reason & 255)};
        return HdmiCecMessage.build(src, dest, 0, params);
    }

    static HdmiCecMessage buildGivePhysicalAddress(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 131);
    }

    static HdmiCecMessage buildGiveOsdNameCommand(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 70);
    }

    static HdmiCecMessage buildGiveDeviceVendorIdCommand(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 140);
    }

    static HdmiCecMessage buildSetMenuLanguageCommand(int src, String language) {
        if (language.length() == 3) goto L6;
        return null;
    L6:
        String normalized = language.toLowerCase();
        byte[] params = {(byte) (normalized.charAt(0) & 255), (byte) (normalized.charAt(1) & 255), (byte) (normalized.charAt(2) & 255)};
        return HdmiCecMessage.build(src, 15, 50, params);
    }

    static HdmiCecMessage buildSetOsdNameCommand(int src, int dest, String name) {
        int length = Math.min(name.length(), 14);
        byte[] params = name.substring(0, length).getBytes(CharsetNames.US_ASCII);     // Catch: UnsupportedEncodingException -> L6
        return HdmiCecMessage.build(src, dest, 71, params);
    L7:
        return null;
    }

    static HdmiCecMessage buildReportPhysicalAddressCommand(int src, int address, int deviceType) {
        byte[] params = {(byte) ((address >> 8) & 255), (byte) (address & 255), (byte) (deviceType & 255)};
        return HdmiCecMessage.build(src, 15, 132, params);
    }

    static HdmiCecMessage buildDeviceVendorIdCommand(int src, int vendorId) {
        byte[] params = {(byte) ((vendorId >> 16) & 255), (byte) ((vendorId >> 8) & 255), (byte) (vendorId & 255)};
        return HdmiCecMessage.build(src, 15, 135, params);
    }

    static HdmiCecMessage buildCecVersion(int src, int dest, int version) {
        byte[] params = {(byte) (version & 255)};
        return HdmiCecMessage.build(src, dest, 158, params);
    }

    static HdmiCecMessage buildRequestArcInitiation(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 195);
    }

    static HdmiCecMessage buildInitiateArc(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 192);
    }

    static HdmiCecMessage buildTerminateArc(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 197);
    }

    static HdmiCecMessage buildRequestArcTermination(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 196);
    }

    static HdmiCecMessage buildReportArcInitiated(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 193);
    }

    static HdmiCecMessage buildReportArcTerminated(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 194);
    }

    static HdmiCecMessage buildRequestShortAudioDescriptor(int src, int dest, int[] audioFormats) {
        byte[] params = new byte[Math.min(audioFormats.length, 4)];
        int i = 0;
    L4:
        if (i >= params.length) goto L7;
        params[i] = (byte) (audioFormats[i] & 255);
        i = i + 1;
        goto L4
    L7:
        return HdmiCecMessage.build(src, dest, 164, params);
    }

    static HdmiCecMessage buildTextViewOn(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 13);
    }

    static HdmiCecMessage buildImageViewOn(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 4);
    }

    static HdmiCecMessage buildRequestActiveSource(int src) {
        return HdmiCecMessage.build(src, 15, 133);
    }

    static HdmiCecMessage buildActiveSource(int src, int physicalAddress) {
        return HdmiCecMessage.build(src, 15, 130, physicalAddressToParam(physicalAddress));
    }

    static HdmiCecMessage buildInactiveSource(int src, int physicalAddress) {
        return HdmiCecMessage.build(src, 0, 157, physicalAddressToParam(physicalAddress));
    }

    static HdmiCecMessage buildSetStreamPath(int src, int streamPath) {
        return HdmiCecMessage.build(src, 15, 134, physicalAddressToParam(streamPath));
    }

    static HdmiCecMessage buildRoutingChange(int src, int oldPath, int newPath) {
        byte[] param = {(byte) ((oldPath >> 8) & 255), (byte) (oldPath & 255), (byte) ((newPath >> 8) & 255), (byte) (newPath & 255)};
        return HdmiCecMessage.build(src, 15, 128, param);
    }

    static HdmiCecMessage buildRoutingInformation(int src, int physicalAddress) {
        return HdmiCecMessage.build(src, 15, 129, physicalAddressToParam(physicalAddress));
    }

    static HdmiCecMessage buildGiveDevicePowerStatus(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 143);
    }

    static HdmiCecMessage buildReportPowerStatus(int src, int dest, int powerStatus) {
        byte[] param = {(byte) (powerStatus & 255)};
        return HdmiCecMessage.build(src, dest, 144, param);
    }

    static HdmiCecMessage buildReportMenuStatus(int src, int dest, int menuStatus) {
        byte[] param = {(byte) (menuStatus & 255)};
        return HdmiCecMessage.build(src, dest, 142, param);
    }

    static HdmiCecMessage buildSystemAudioModeRequest(int src, int avr, int avrPhysicalAddress, boolean enableSystemAudio) {
        if (enableSystemAudio == false) goto L7;
        return HdmiCecMessage.build(src, avr, 112, physicalAddressToParam(avrPhysicalAddress));
    L7:
        return HdmiCecMessage.build(src, avr, 112);
    }

    static HdmiCecMessage buildSetSystemAudioMode(int src, int des, boolean systemAudioStatus) {
        return buildCommandWithBooleanParam(src, des, 114, systemAudioStatus);
    }

    static HdmiCecMessage buildReportSystemAudioMode(int src, int des, boolean systemAudioStatus) {
        return buildCommandWithBooleanParam(src, des, 126, systemAudioStatus);
    }

    static HdmiCecMessage buildReportShortAudioDescriptor(int src, int des, byte[] sadBytes) {
        return HdmiCecMessage.build(src, des, 163, sadBytes);
    }

    static HdmiCecMessage buildGiveAudioStatus(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 113);
    }

    static HdmiCecMessage buildReportAudioStatus(int src, int dest, int volume, boolean mute) {
        if (mute == false) goto L5;
        int r1 = 128;
    L6:
        byte status = (byte) (((byte) r1) | (((byte) volume) & 127));
        byte[] params = {status};
        return HdmiCecMessage.build(src, dest, 122, params);
    L5:
        r1 = 0;
        goto L6
    }

    static HdmiCecMessage buildUserControlPressed(int src, int dest, int uiCommand) {
        return buildUserControlPressed(src, dest, new byte[]{(byte) (uiCommand & 255)});
    }

    static HdmiCecMessage buildUserControlPressed(int src, int dest, byte[] commandParam) {
        return HdmiCecMessage.build(src, dest, 68, commandParam);
    }

    static HdmiCecMessage buildUserControlReleased(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 69);
    }

    static HdmiCecMessage buildGiveSystemAudioModeStatus(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 125);
    }

    public static HdmiCecMessage buildStandby(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 54);
    }

    static HdmiCecMessage buildVendorCommand(int src, int dest, byte[] params) {
        return HdmiCecMessage.build(src, dest, 137, params);
    }

    static HdmiCecMessage buildVendorCommandWithId(int src, int dest, int vendorId, byte[] operands) {
        byte[] params = new byte[operands.length + 3];
        params[0] = (byte) ((vendorId >> 16) & 255);
        params[1] = (byte) ((vendorId >> 8) & 255);
        params[2] = (byte) (vendorId & 255);
        System.arraycopy(operands, 0, params, 3, operands.length);
        return HdmiCecMessage.build(src, dest, 160, params);
    }

    static HdmiCecMessage buildRecordOn(int src, int dest, byte[] params) {
        return HdmiCecMessage.build(src, dest, 9, params);
    }

    static HdmiCecMessage buildRecordOff(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 11);
    }

    static HdmiCecMessage buildSetDigitalTimer(int src, int dest, byte[] params) {
        return HdmiCecMessage.build(src, dest, 151, params);
    }

    static HdmiCecMessage buildSetAnalogueTimer(int src, int dest, byte[] params) {
        return HdmiCecMessage.build(src, dest, 52, params);
    }

    static HdmiCecMessage buildSetExternalTimer(int src, int dest, byte[] params) {
        return HdmiCecMessage.build(src, dest, 162, params);
    }

    static HdmiCecMessage buildClearDigitalTimer(int src, int dest, byte[] params) {
        return HdmiCecMessage.build(src, dest, 153, params);
    }

    static HdmiCecMessage buildClearAnalogueTimer(int src, int dest, byte[] params) {
        return HdmiCecMessage.build(src, dest, 51, params);
    }

    static HdmiCecMessage buildClearExternalTimer(int src, int dest, byte[] params) {
        return HdmiCecMessage.build(src, dest, 161, params);
    }

    static HdmiCecMessage buildGiveFeatures(int src, int dest) {
        return HdmiCecMessage.build(src, dest, 165);
    }

    private static HdmiCecMessage buildCommandWithBooleanParam(int r2, int r3, int r4, boolean r5) {
        return HdmiCecMessage.build(r2, r3, r4, new byte[]{r5 ? 1 : 0});
    }

    private static byte[] physicalAddressToParam(int physicalAddress) {
        return new byte[]{(byte) ((physicalAddress >> 8) & 255), (byte) (physicalAddress & 255)};
    }
}
