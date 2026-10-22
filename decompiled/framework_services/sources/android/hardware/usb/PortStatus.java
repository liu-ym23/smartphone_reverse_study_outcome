package android.hardware.usb;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class PortStatus implements Parcelable {
    public static final Parcelable.Creator<PortStatus> CREATOR = null;
    public boolean canChangeDataRole;
    public boolean canChangeMode;
    public boolean canChangePowerRole;
    public int[] complianceWarnings;
    public byte contaminantDetectionStatus;
    public byte contaminantProtectionStatus;
    public byte currentDataRole;
    public byte currentMode;
    public byte currentPowerRole;
    public int plugOrientation;
    public String portName;
    public byte powerBrickStatus;
    public boolean powerTransferLimited;
    public AltModeData[] supportedAltModes;
    public byte[] supportedContaminantProtectionModes;
    public byte[] supportedModes;
    public boolean supportsComplianceWarnings;
    public boolean supportsEnableContaminantPresenceDetection;
    public boolean supportsEnableContaminantPresenceProtection;
    public byte[] usbDataStatus;

    public PortStatus() {
        this.currentDataRole = 0;
        this.currentPowerRole = 0;
        this.currentMode = 0;
        this.canChangeMode = false;
        this.canChangeDataRole = false;
        this.canChangePowerRole = false;
        this.supportsEnableContaminantPresenceProtection = false;
        this.contaminantProtectionStatus = 0;
        this.supportsEnableContaminantPresenceDetection = false;
        this.contaminantDetectionStatus = 0;
        this.powerTransferLimited = false;
        this.supportsComplianceWarnings = false;
        this.complianceWarnings = new int[0];
        this.plugOrientation = 0;
        this.supportedAltModes = new AltModeData[0];
    }

    public final int getStability() {
        return 1;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeString(this.portName);
        _aidl_parcel.writeByte(this.currentDataRole);
        _aidl_parcel.writeByte(this.currentPowerRole);
        _aidl_parcel.writeByte(this.currentMode);
        _aidl_parcel.writeBoolean(this.canChangeMode);
        _aidl_parcel.writeBoolean(this.canChangeDataRole);
        _aidl_parcel.writeBoolean(this.canChangePowerRole);
        _aidl_parcel.writeByteArray(this.supportedModes);
        _aidl_parcel.writeByteArray(this.supportedContaminantProtectionModes);
        _aidl_parcel.writeBoolean(this.supportsEnableContaminantPresenceProtection);
        _aidl_parcel.writeByte(this.contaminantProtectionStatus);
        _aidl_parcel.writeBoolean(this.supportsEnableContaminantPresenceDetection);
        _aidl_parcel.writeByte(this.contaminantDetectionStatus);
        _aidl_parcel.writeByteArray(this.usbDataStatus);
        _aidl_parcel.writeBoolean(this.powerTransferLimited);
        _aidl_parcel.writeByte(this.powerBrickStatus);
        _aidl_parcel.writeBoolean(this.supportsComplianceWarnings);
        _aidl_parcel.writeIntArray(this.complianceWarnings);
        _aidl_parcel.writeInt(this.plugOrientation);
        _aidl_parcel.writeTypedArray(this.supportedAltModes, _aidl_flag);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L194;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.portName = _aidl_parcel.readString();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.currentDataRole = _aidl_parcel.readByte();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
        this.currentPowerRole = _aidl_parcel.readByte();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
        this.currentMode = _aidl_parcel.readByte();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
        this.canChangeMode = _aidl_parcel.readBoolean();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L53;
        this.canChangeDataRole = _aidl_parcel.readBoolean();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L62;
        this.canChangePowerRole = _aidl_parcel.readBoolean();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L71;
        this.supportedModes = _aidl_parcel.createByteArray();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L80;
        this.supportedContaminantProtectionModes = _aidl_parcel.createByteArray();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L89;
        this.supportsEnableContaminantPresenceProtection = _aidl_parcel.readBoolean();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L98;
        this.contaminantProtectionStatus = _aidl_parcel.readByte();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L107;
        this.supportsEnableContaminantPresenceDetection = _aidl_parcel.readBoolean();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L116;
        this.contaminantDetectionStatus = _aidl_parcel.readByte();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L125;
        this.usbDataStatus = _aidl_parcel.createByteArray();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L134;
        this.powerTransferLimited = _aidl_parcel.readBoolean();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L143;
        this.powerBrickStatus = _aidl_parcel.readByte();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L152;
        this.supportsComplianceWarnings = _aidl_parcel.readBoolean();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L161;
        this.complianceWarnings = _aidl_parcel.createIntArray();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L170;
        this.plugOrientation = _aidl_parcel.readInt();     // Catch: Throwable -> L191
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L179;
        this.supportedAltModes = (AltModeData[]) _aidl_parcel.createTypedArray(AltModeData.CREATOR);     // Catch: Throwable -> L191
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L190;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L190:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L179:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L183;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L183:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L170:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L174;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L174:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L161:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L165;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L165:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L152:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L156;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L156:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L143:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L147;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L147:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L134:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L138;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L138:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L125:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L129;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L129:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L116:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L120;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L120:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L107:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L111;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L111:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L98:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L102;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L102:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L89:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L93;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L93:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L80:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L84;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L84:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L71:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L75;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L75:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L62:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L66;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L66:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L53:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L57;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L57:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L44:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L48;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L48:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L35:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L39;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L39:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L26:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L30;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L30:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L17:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L21;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L21:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L12;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L12:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L194:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L191
    L191:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L198;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L198:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        int _mask = 0 | describeContents(this.supportedAltModes);
        return _mask;
    }

    private int describeContents(Object _v) {
        int r0 = 0;
        if (_v != null) goto L6;
        return 0;
    L6:
        if ((_v instanceof Object[]) == false) goto L12;
        int _mask = 0;
        Object[] r2 = (Object[]) _v;
        int r3 = r2.length;
    L8:
        if (r0 >= r3) goto L10;
        Object o = r2[r0];
        _mask = _mask | describeContents(o);
        r0 = r0 + 1;
        goto L8
    L10:
        return _mask;
    L12:
        if ((_v instanceof Parcelable) == true) goto L14;
        return 0;
    L14:
        return ((Parcelable) _v).describeContents();
    }
}
