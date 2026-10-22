package com.android.server.hdmi;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes2.dex */
public class HdmiCecAtomWriter {
    private static final int ERROR_CODE_UNKNOWN = -1;
    protected static final int FEATURE_ABORT_OPCODE_UNKNOWN = 256;
    protected static final int PHYSICAL_ADDRESS_INVALID = 65535;

    private class MessageReportedGenericArgs {
        final int mDestinationLogicalAddress;
        final int mDirection;
        final int mInitiatorLogicalAddress;
        final int mOpcode;
        final int mSendMessageResult;
        final int mUid;

        MessageReportedGenericArgs(HdmiCecAtomWriter r1, int uid, int direction, int initiatorLogicalAddress, int destinationLogicalAddress, int opcode, int sendMessageResult) {
            this.mUid = uid;
            this.mDirection = direction;
            this.mInitiatorLogicalAddress = initiatorLogicalAddress;
            this.mDestinationLogicalAddress = destinationLogicalAddress;
            this.mOpcode = opcode;
            this.mSendMessageResult = sendMessageResult;
        }
    }

    private class MessageReportedSpecialArgs {
        int mFeatureAbortOpcode;
        int mFeatureAbortReason;
        int mPhysicalAddress;
        int mUserControlPressedCommand;

        /* synthetic */ MessageReportedSpecialArgs(HdmiCecAtomWriter r1, HdmiCecAtomWriterIA r2) {
            this(r1);
        }

        private MessageReportedSpecialArgs(HdmiCecAtomWriter r2) {
            this.mUserControlPressedCommand = 0;
            this.mFeatureAbortOpcode = 256;
            this.mFeatureAbortReason = 0;
            this.mPhysicalAddress = 65535;
        }
    }

    public HdmiCecAtomWriter() {
    }

    public void messageReported(HdmiCecMessage message, int direction, int callingUid, int errorCode) {
        MessageReportedGenericArgs genericArgs = createMessageReportedGenericArgs(message, direction, errorCode, callingUid);
        MessageReportedSpecialArgs specialArgs = createMessageReportedSpecialArgs(message);
        messageReportedBase(genericArgs, specialArgs);
    }

    public void messageReported(HdmiCecMessage message, int direction, int callingUid) {
        messageReported(message, direction, callingUid, -1);
    }

    private MessageReportedGenericArgs createMessageReportedGenericArgs(HdmiCecMessage message, int direction, int errorCode, int callingUid) {
        if (errorCode != (-1)) goto L5;
        int r0 = 0;
    L6:
        int sendMessageResult = r0;
        return new MessageReportedGenericArgs(this, callingUid, direction, message.getSource(), message.getDestination(), message.getOpcode(), sendMessageResult);
    L5:
        r0 = errorCode + 10;
        goto L6
    }

    private MessageReportedSpecialArgs createMessageReportedSpecialArgs(HdmiCecMessage message) {
        HdmiCecAtomWriterIA r1 = null;
        switch(message.getOpcode()) {
            case 0: goto L11;
            case 68: goto L9;
            case 132: goto L7;
            default: goto L5;
        };
    L5:
        return new MessageReportedSpecialArgs(this, r1);
    L7:
        return new MessageReportedSpecialArgs(this, r1);
    L9:
        return createUserControlPressedSpecialArgs(message);
    L11:
        return createFeatureAbortSpecialArgs(message);
    }

    private MessageReportedSpecialArgs createUserControlPressedSpecialArgs(HdmiCecMessage message) {
        MessageReportedSpecialArgs specialArgs = new MessageReportedSpecialArgs(this, null);
        if (message.getParams().length <= 0) goto L10;
        int keycode = message.getParams()[0];
        if (keycode >= 30) goto L7;
    L9:
        specialArgs.mUserControlPressedCommand = keycode + 256;
        goto L10
    L7:
        if (keycode > 41) goto L9;
        specialArgs.mUserControlPressedCommand = 2;
    L10:
        return specialArgs;
    }

    private MessageReportedSpecialArgs createFeatureAbortSpecialArgs(HdmiCecMessage message) {
        MessageReportedSpecialArgs specialArgs = new MessageReportedSpecialArgs(this, null);
        if (message.getParams().length <= 0) goto L7;
        specialArgs.mFeatureAbortOpcode = message.getParams()[0] & CecDeviceType.INACTIVE;
        if (message.getParams().length <= 1) goto L7;
        specialArgs.mFeatureAbortReason = message.getParams()[1] + 10;
    L7:
        return specialArgs;
    }

    private MessageReportedSpecialArgs createReportPhysicalAddressSpecialArgs(HdmiCecMessage message) {
        MessageReportedSpecialArgs specialArgs = new MessageReportedSpecialArgs(this, null);
        if (message.getParams().length <= 1) goto L5;
        int physicalAddress = (message.getParams()[0] << 8) | message.getParams()[1];
        specialArgs.mPhysicalAddress = physicalAddress;
    L5:
        return specialArgs;
    }

    private void messageReportedBase(MessageReportedGenericArgs genericArgs, MessageReportedSpecialArgs specialArgs) {
        writeHdmiCecMessageReportedAtom(genericArgs.mUid, genericArgs.mDirection, genericArgs.mInitiatorLogicalAddress, genericArgs.mDestinationLogicalAddress, genericArgs.mOpcode, genericArgs.mSendMessageResult, specialArgs.mUserControlPressedCommand, specialArgs.mFeatureAbortOpcode, specialArgs.mFeatureAbortReason, specialArgs.mPhysicalAddress);
    }

    protected void writeHdmiCecMessageReportedAtom(int uid, int direction, int initiatorLogicalAddress, int destinationLogicalAddress, int opcode, int sendMessageResult, int userControlPressedCommand, int featureAbortOpcode, int featureAbortReason, int physicalAddress) {
        FrameworkStatsLog.write(310, uid, direction, initiatorLogicalAddress, destinationLogicalAddress, opcode, sendMessageResult, userControlPressedCommand, featureAbortOpcode, featureAbortReason, physicalAddress);
    }

    public void activeSourceChanged(int logicalAddress, int physicalAddress, int relationshipToActiveSource) {
        FrameworkStatsLog.write(309, logicalAddress, physicalAddress, relationshipToActiveSource);
    }

    public void earcStatusChanged(boolean isSupported, boolean isEnabled, int oldConnectionState, int newConnectionState, int enumLogReason) {
        int enumOldConnectionState = earcStateToEnum(oldConnectionState);
        int enumNewConnectionState = earcStateToEnum(newConnectionState);
        FrameworkStatsLog.write(701, isSupported, isEnabled, enumOldConnectionState, enumNewConnectionState, enumLogReason);
    }

    public void dsmStatusChanged(boolean isSupported, boolean isEnabled, int enumLogReason) {
        FrameworkStatsLog.write(FrameworkStatsLog.HDMI_SOUNDBAR_MODE_STATUS_REPORTED, isSupported, isEnabled, enumLogReason);
    }

    public void powerStateChangeOnActiveSourceLostChanged(boolean isEnabled, int enumLogReason, String manufacturerPnpId, int manufacturerYear, int manufacturerWeek) {
        FrameworkStatsLog.write(FrameworkStatsLog.HDMI_POWER_STATE_CHANGE_ON_ACTIVE_SOURCE_LOST_TOGGLED, isEnabled, enumLogReason, manufacturerPnpId, manufacturerYear, manufacturerWeek);
    }

    private int earcStateToEnum(int earcState) {
        switch(earcState) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 4;
    L7:
        return 3;
    L9:
        return 2;
    L11:
        return 1;
    }
}
