package com.android.server.usb.hal.port;

import android.hardware.usb.DisplayPortAltModeInfo;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class RawPortInfo implements Parcelable {
    public static final Parcelable.Creator<RawPortInfo> CREATOR = null;
    public boolean canChangeDataRole;
    public boolean canChangeMode;
    public boolean canChangePowerRole;
    public int[] complianceWarnings;
    public int contaminantDetectionStatus;
    public int contaminantProtectionStatus;
    public int currentDataRole;
    public int currentMode;
    public int currentPowerRole;
    public DisplayPortAltModeInfo displayPortAltModeInfo;
    public int plugState;
    public final String portId;
    public int powerBrickConnectionStatus;
    public boolean powerTransferLimited;
    public int supportedAltModes;
    public final int supportedContaminantProtectionModes;
    public final int supportedModes;
    public final boolean supportsComplianceWarnings;
    public boolean supportsEnableContaminantPresenceDetection;
    public boolean supportsEnableContaminantPresenceProtection;
    public int usbDataStatus;

    public RawPortInfo(String portId, int supportedModes) {
        this.portId = portId;
        this.supportedModes = supportedModes;
        this.supportedContaminantProtectionModes = 0;
        this.supportsEnableContaminantPresenceProtection = false;
        this.contaminantProtectionStatus = 0;
        this.supportsEnableContaminantPresenceDetection = false;
        this.contaminantDetectionStatus = 0;
        this.usbDataStatus = 0;
        this.powerTransferLimited = false;
        this.powerBrickConnectionStatus = 0;
        this.supportsComplianceWarnings = false;
        this.complianceWarnings = new int[0];
        this.plugState = 0;
        this.supportedAltModes = 0;
        this.displayPortAltModeInfo = null;
    }

    public RawPortInfo(String portId, int supportedModes, int supportedContaminantProtectionModes, int currentMode, boolean canChangeMode, int currentPowerRole, boolean canChangePowerRole, int currentDataRole, boolean canChangeDataRole, boolean supportsEnableContaminantPresenceProtection, int contaminantProtectionStatus, boolean supportsEnableContaminantPresenceDetection, int contaminantDetectionStatus, int usbDataStatus, boolean powerTransferLimited, int powerBrickConnectionStatus) {
        this(portId, supportedModes, supportedContaminantProtectionModes, currentMode, canChangeMode, currentPowerRole, canChangePowerRole, currentDataRole, canChangeDataRole, supportsEnableContaminantPresenceProtection, contaminantProtectionStatus, supportsEnableContaminantPresenceDetection, contaminantDetectionStatus, usbDataStatus, powerTransferLimited, powerBrickConnectionStatus, false, new int[0], 0, 0, null);
    }

    public RawPortInfo(String portId, int supportedModes, int supportedContaminantProtectionModes, int currentMode, boolean canChangeMode, int currentPowerRole, boolean canChangePowerRole, int currentDataRole, boolean canChangeDataRole, boolean supportsEnableContaminantPresenceProtection, int contaminantProtectionStatus, boolean supportsEnableContaminantPresenceDetection, int contaminantDetectionStatus, int usbDataStatus, boolean powerTransferLimited, int powerBrickConnectionStatus, boolean supportsComplianceWarnings, int[] complianceWarnings, int plugState, int supportedAltModes, DisplayPortAltModeInfo displayPortAltModeInfo) {
        this.portId = portId;
        this.supportedModes = supportedModes;
        this.supportedContaminantProtectionModes = supportedContaminantProtectionModes;
        this.currentMode = currentMode;
        this.canChangeMode = canChangeMode;
        this.currentPowerRole = currentPowerRole;
        this.canChangePowerRole = canChangePowerRole;
        this.currentDataRole = currentDataRole;
        this.canChangeDataRole = canChangeDataRole;
        this.supportsEnableContaminantPresenceProtection = supportsEnableContaminantPresenceProtection;
        this.contaminantProtectionStatus = contaminantProtectionStatus;
        this.supportsEnableContaminantPresenceDetection = supportsEnableContaminantPresenceDetection;
        this.contaminantDetectionStatus = contaminantDetectionStatus;
        this.usbDataStatus = usbDataStatus;
        this.powerTransferLimited = powerTransferLimited;
        this.powerBrickConnectionStatus = powerBrickConnectionStatus;
        this.supportsComplianceWarnings = supportsComplianceWarnings;
        this.complianceWarnings = complianceWarnings;
        this.plugState = plugState;
        this.supportedAltModes = supportedAltModes;
        this.displayPortAltModeInfo = displayPortAltModeInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.portId);
        r3.writeInt(this.supportedModes);
        r3.writeInt(this.supportedContaminantProtectionModes);
        r3.writeInt(this.currentMode);
        r3.writeByte(this.canChangeMode ? 1 : 0);
        r3.writeInt(this.currentPowerRole);
        r3.writeByte(this.canChangePowerRole ? 1 : 0);
        r3.writeInt(this.currentDataRole);
        r3.writeByte(this.canChangeDataRole ? 1 : 0);
        r3.writeBoolean(this.supportsEnableContaminantPresenceProtection);
        r3.writeInt(this.contaminantProtectionStatus);
        r3.writeBoolean(this.supportsEnableContaminantPresenceDetection);
        r3.writeInt(this.contaminantDetectionStatus);
        r3.writeInt(this.usbDataStatus);
        r3.writeBoolean(this.powerTransferLimited);
        r3.writeInt(this.powerBrickConnectionStatus);
        r3.writeBoolean(this.supportsComplianceWarnings);
        r3.writeIntArray(this.complianceWarnings);
        r3.writeInt(this.plugState);
        r3.writeInt(this.supportedAltModes);
        if ((this.supportedAltModes & 1) == 0) goto L6;
        this.displayPortAltModeInfo.writeToParcel(r3, 0);
        return;
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
