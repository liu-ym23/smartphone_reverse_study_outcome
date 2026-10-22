package android.hardware.health.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class HealthInfo {
    public int batteryChargeCounter;
    public int batteryCurrent;
    public int batteryCycleCount;
    public int batteryFullCharge;
    public int batteryHealth;
    public int batteryLevel;
    public boolean batteryPresent;
    public int batteryStatus;
    public String batteryTechnology;
    public int batteryTemperature;
    public int batteryVoltage;
    public boolean chargerAcOnline;
    public boolean chargerUsbOnline;
    public boolean chargerWirelessOnline;
    public int maxChargingCurrent;
    public int maxChargingVoltage;

    public HealthInfo() {
        this.chargerAcOnline = false;
        this.chargerUsbOnline = false;
        this.chargerWirelessOnline = false;
        this.maxChargingCurrent = 0;
        this.maxChargingVoltage = 0;
        this.batteryStatus = 0;
        this.batteryHealth = 0;
        this.batteryPresent = false;
        this.batteryLevel = 0;
        this.batteryVoltage = 0;
        this.batteryTemperature = 0;
        this.batteryCurrent = 0;
        this.batteryCycleCount = 0;
        this.batteryFullCharge = 0;
        this.batteryChargeCounter = 0;
        this.batteryTechnology = new String();
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == HealthInfo.class) goto L11;
        return false;
    L11:
        HealthInfo other = (HealthInfo) otherObject;
        if (this.chargerAcOnline == other.chargerAcOnline) goto L15;
        return false;
    L15:
        if (this.chargerUsbOnline == other.chargerUsbOnline) goto L18;
        return false;
    L18:
        if (this.chargerWirelessOnline == other.chargerWirelessOnline) goto L21;
        return false;
    L21:
        if (this.maxChargingCurrent == other.maxChargingCurrent) goto L24;
        return false;
    L24:
        if (this.maxChargingVoltage == other.maxChargingVoltage) goto L27;
        return false;
    L27:
        if (this.batteryStatus == other.batteryStatus) goto L30;
        return false;
    L30:
        if (this.batteryHealth == other.batteryHealth) goto L33;
        return false;
    L33:
        if (this.batteryPresent == other.batteryPresent) goto L36;
        return false;
    L36:
        if (this.batteryLevel == other.batteryLevel) goto L39;
        return false;
    L39:
        if (this.batteryVoltage == other.batteryVoltage) goto L42;
        return false;
    L42:
        if (this.batteryTemperature == other.batteryTemperature) goto L45;
        return false;
    L45:
        if (this.batteryCurrent == other.batteryCurrent) goto L48;
        return false;
    L48:
        if (this.batteryCycleCount == other.batteryCycleCount) goto L51;
        return false;
    L51:
        if (this.batteryFullCharge == other.batteryFullCharge) goto L54;
        return false;
    L54:
        if (this.batteryChargeCounter == other.batteryChargeCounter) goto L57;
        return false;
    L57:
        if (HidlSupport.deepEquals(this.batteryTechnology, other.batteryTechnology) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.chargerAcOnline))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.chargerUsbOnline))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.chargerWirelessOnline))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.maxChargingCurrent))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.maxChargingVoltage))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.batteryStatus))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.batteryHealth))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.batteryPresent))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.batteryLevel))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.batteryVoltage))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.batteryTemperature))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.batteryCurrent))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.batteryCycleCount))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.batteryFullCharge))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.batteryChargeCounter))), Integer.valueOf(HidlSupport.deepHashCode(this.batteryTechnology))});
    }

    public final String toString() {
        return "{.chargerAcOnline = " + this.chargerAcOnline + ", .chargerUsbOnline = " + this.chargerUsbOnline + ", .chargerWirelessOnline = " + this.chargerWirelessOnline + ", .maxChargingCurrent = " + this.maxChargingCurrent + ", .maxChargingVoltage = " + this.maxChargingVoltage + ", .batteryStatus = " + BatteryStatus.toString(this.batteryStatus) + ", .batteryHealth = " + BatteryHealth.toString(this.batteryHealth) + ", .batteryPresent = " + this.batteryPresent + ", .batteryLevel = " + this.batteryLevel + ", .batteryVoltage = " + this.batteryVoltage + ", .batteryTemperature = " + this.batteryTemperature + ", .batteryCurrent = " + this.batteryCurrent + ", .batteryCycleCount = " + this.batteryCycleCount + ", .batteryFullCharge = " + this.batteryFullCharge + ", .batteryChargeCounter = " + this.batteryChargeCounter + ", .batteryTechnology = " + this.batteryTechnology + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(72);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<HealthInfo> readVectorFromParcel(HwParcel parcel) {
        ArrayList<HealthInfo> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 72, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        HealthInfo _hidl_vec_element = new HealthInfo();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 72);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.chargerAcOnline = _hidl_blob.getBool(_hidl_offset + 0);
        this.chargerUsbOnline = _hidl_blob.getBool(_hidl_offset + 1);
        this.chargerWirelessOnline = _hidl_blob.getBool(_hidl_offset + 2);
        this.maxChargingCurrent = _hidl_blob.getInt32(_hidl_offset + 4);
        this.maxChargingVoltage = _hidl_blob.getInt32(_hidl_offset + 8);
        this.batteryStatus = _hidl_blob.getInt32(_hidl_offset + 12);
        this.batteryHealth = _hidl_blob.getInt32(_hidl_offset + 16);
        this.batteryPresent = _hidl_blob.getBool(_hidl_offset + 20);
        this.batteryLevel = _hidl_blob.getInt32(_hidl_offset + 24);
        this.batteryVoltage = _hidl_blob.getInt32(_hidl_offset + 28);
        this.batteryTemperature = _hidl_blob.getInt32(_hidl_offset + 32);
        this.batteryCurrent = _hidl_blob.getInt32(_hidl_offset + 36);
        this.batteryCycleCount = _hidl_blob.getInt32(_hidl_offset + 40);
        this.batteryFullCharge = _hidl_blob.getInt32(_hidl_offset + 44);
        this.batteryChargeCounter = _hidl_blob.getInt32(_hidl_offset + 48);
        this.batteryTechnology = _hidl_blob.getString(_hidl_offset + 56);
        parcel.readEmbeddedBuffer(this.batteryTechnology.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 56) + 0, false);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(72);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<HealthInfo> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 72);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 72);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putBool(0 + _hidl_offset, this.chargerAcOnline);
        _hidl_blob.putBool(1 + _hidl_offset, this.chargerUsbOnline);
        _hidl_blob.putBool(2 + _hidl_offset, this.chargerWirelessOnline);
        _hidl_blob.putInt32(4 + _hidl_offset, this.maxChargingCurrent);
        _hidl_blob.putInt32(8 + _hidl_offset, this.maxChargingVoltage);
        _hidl_blob.putInt32(12 + _hidl_offset, this.batteryStatus);
        _hidl_blob.putInt32(16 + _hidl_offset, this.batteryHealth);
        _hidl_blob.putBool(20 + _hidl_offset, this.batteryPresent);
        _hidl_blob.putInt32(24 + _hidl_offset, this.batteryLevel);
        _hidl_blob.putInt32(28 + _hidl_offset, this.batteryVoltage);
        _hidl_blob.putInt32(32 + _hidl_offset, this.batteryTemperature);
        _hidl_blob.putInt32(36 + _hidl_offset, this.batteryCurrent);
        _hidl_blob.putInt32(40 + _hidl_offset, this.batteryCycleCount);
        _hidl_blob.putInt32(44 + _hidl_offset, this.batteryFullCharge);
        _hidl_blob.putInt32(48 + _hidl_offset, this.batteryChargeCounter);
        _hidl_blob.putString(56 + _hidl_offset, this.batteryTechnology);
    }
}
