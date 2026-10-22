package com.android.server.hdmi;

import android.hardware.hdmi.DeviceFeatures;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ReportFeaturesMessage extends HdmiCecMessage {
    private final int mCecVersion;
    private final DeviceFeatures mDeviceFeatures;

    /* JADX INFO: renamed from: $r8$lambda$EnZaG7E-UCHXFjP_nSsOC6uaXt4, reason: not valid java name */
    public static /* synthetic */ HdmiCecMessage m4425$r8$lambda$EnZaG7EUCHXFjP_nSsOC6uaXt4(int r0, int r1, byte[] r2, Integer r3) {
        return lambda$build$0(r0, r1, r2, r3);
    }

    private ReportFeaturesMessage(int source, int destination, byte[] params, int cecVersion, DeviceFeatures deviceFeatures) {
        super(source, destination, 166, params, 0);
        this.mCecVersion = cecVersion;
        this.mDeviceFeatures = deviceFeatures;
    }

    public static HdmiCecMessage build(int source, int cecVersion, List<Integer> allDeviceTypes, int rcProfile, List<Integer> rcFeatures, DeviceFeatures deviceFeatures) {
        byte cecVersionByte = (byte) (cecVersion & 255);
        Iterator<Integer> r4 = allDeviceTypes.iterator();
        byte deviceTypes = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        Integer deviceType = r4.next();
        deviceTypes = (byte) (((byte) (1 << hdmiDeviceInfoDeviceTypeToShiftValue(deviceType.intValue()))) | deviceTypes);
        goto L4
    L6:
        byte rcProfileByte = (byte) (((byte) (rcProfile << 6)) | 0);
        if (rcProfile != 1) goto L13;
        Iterator<Integer> r5 = rcFeatures.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        Integer rcFeature = r5.next();
        rcProfileByte = (byte) (((byte) (1 << rcFeature.intValue())) | rcProfileByte);
        goto L10
    L12:
        byte rcProfileByte2 = rcProfileByte;
    L14:
        byte[] fixedOperands = {cecVersionByte, deviceTypes, rcProfileByte2};
        byte[] deviceFeaturesBytes = deviceFeatures.toOperand();
        byte[] params = Arrays.copyOf(fixedOperands, fixedOperands.length + deviceFeaturesBytes.length);
        System.arraycopy(deviceFeaturesBytes, 0, params, fixedOperands.length, deviceFeaturesBytes.length);
        int addressValidationResult = validateAddress(source, 15);
        if (addressValidationResult == 0) goto L19;
        return new HdmiCecMessage(source, 15, 166, params, addressValidationResult);
    L19:
        return new ReportFeaturesMessage(source, 15, params, cecVersion, deviceFeatures);
    L13:
        byte rcProfileTv = (byte) (rcFeatures.get(0).intValue() & 65535);
        rcProfileByte2 = (byte) (rcProfileByte | rcProfileTv);
        goto L14
    }

    private static int hdmiDeviceInfoDeviceTypeToShiftValue(int deviceType) {
        switch(deviceType) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L4;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L4;
        };
    L5:
        return 2;
    L7:
        return 3;
    L9:
        return 4;
    L11:
        return 5;
    L13:
        return 6;
    L15:
        return 7;
    L4:
        throw new IllegalArgumentException("Unhandled device type: " + deviceType);
    }

    static HdmiCecMessage build(final int source, final int destination, final byte[] params) {
        Function<Integer, HdmiCecMessage> invalidMessage = new ReportFeaturesMessage$$ExternalSyntheticLambda0(source, destination, params);
        int addressValidationResult = validateAddress(source, destination);
        if (addressValidationResult == 0) goto L7;
        return invalidMessage.apply(Integer.valueOf(addressValidationResult));
    L7:
        if (params.length < 4) goto L9;
        int cecVersion = Byte.toUnsignedInt(params[0]);
        int rcProfileEnd = HdmiUtils.getEndOfSequence(params, 2);
        if (rcProfileEnd == (-1)) goto L13;
        int deviceFeaturesEnd = HdmiUtils.getEndOfSequence(params, rcProfileEnd + 1);
        if (deviceFeaturesEnd == (-1)) goto L17;
        int deviceFeaturesStart = HdmiUtils.getEndOfSequence(params, 2) + 1;
        byte[] deviceFeaturesBytes = Arrays.copyOfRange(params, deviceFeaturesStart, params.length);
        DeviceFeatures deviceFeatures = DeviceFeatures.fromOperand(deviceFeaturesBytes);
        return new ReportFeaturesMessage(source, destination, params, cecVersion, deviceFeatures);
    L17:
        return invalidMessage.apply(4);
    L13:
        return invalidMessage.apply(4);
    L9:
        return invalidMessage.apply(4);
    }

    private static /* synthetic */ HdmiCecMessage lambda$build$0(int source, int destination, byte[] params, Integer validationResult) {
        return new HdmiCecMessage(source, destination, 166, params, validationResult.intValue());
    }

    public static int validateAddress(int source, int destination) {
        return HdmiCecMessageValidator.validateAddress(source, destination, 32767, 32768);
    }

    public int getCecVersion() {
        return this.mCecVersion;
    }

    public DeviceFeatures getDeviceFeatures() {
        return this.mDeviceFeatures;
    }
}
