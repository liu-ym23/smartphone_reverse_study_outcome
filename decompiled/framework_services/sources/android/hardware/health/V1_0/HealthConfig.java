package android.hardware.health.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class HealthConfig {
    public String batteryCapacityPath;
    public String batteryChargeCounterPath;
    public String batteryCurrentAvgPath;
    public String batteryCurrentNowPath;
    public String batteryCycleCountPath;
    public String batteryFullChargePath;
    public String batteryHealthPath;
    public String batteryPresentPath;
    public String batteryStatusPath;
    public String batteryTechnologyPath;
    public String batteryTemperaturePath;
    public String batteryVoltagePath;
    public int periodicChoresIntervalFast;
    public int periodicChoresIntervalSlow;

    public HealthConfig() {
        this.periodicChoresIntervalFast = 0;
        this.periodicChoresIntervalSlow = 0;
        this.batteryStatusPath = new String();
        this.batteryHealthPath = new String();
        this.batteryPresentPath = new String();
        this.batteryCapacityPath = new String();
        this.batteryVoltagePath = new String();
        this.batteryTemperaturePath = new String();
        this.batteryTechnologyPath = new String();
        this.batteryCurrentNowPath = new String();
        this.batteryCurrentAvgPath = new String();
        this.batteryChargeCounterPath = new String();
        this.batteryFullChargePath = new String();
        this.batteryCycleCountPath = new String();
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == HealthConfig.class) goto L11;
        return false;
    L11:
        HealthConfig other = (HealthConfig) otherObject;
        if (this.periodicChoresIntervalFast == other.periodicChoresIntervalFast) goto L15;
        return false;
    L15:
        if (this.periodicChoresIntervalSlow == other.periodicChoresIntervalSlow) goto L18;
        return false;
    L18:
        if (HidlSupport.deepEquals(this.batteryStatusPath, other.batteryStatusPath) == true) goto L21;
        return false;
    L21:
        if (HidlSupport.deepEquals(this.batteryHealthPath, other.batteryHealthPath) == true) goto L24;
        return false;
    L24:
        if (HidlSupport.deepEquals(this.batteryPresentPath, other.batteryPresentPath) == true) goto L27;
        return false;
    L27:
        if (HidlSupport.deepEquals(this.batteryCapacityPath, other.batteryCapacityPath) == true) goto L30;
        return false;
    L30:
        if (HidlSupport.deepEquals(this.batteryVoltagePath, other.batteryVoltagePath) == true) goto L33;
        return false;
    L33:
        if (HidlSupport.deepEquals(this.batteryTemperaturePath, other.batteryTemperaturePath) == true) goto L36;
        return false;
    L36:
        if (HidlSupport.deepEquals(this.batteryTechnologyPath, other.batteryTechnologyPath) == true) goto L39;
        return false;
    L39:
        if (HidlSupport.deepEquals(this.batteryCurrentNowPath, other.batteryCurrentNowPath) == true) goto L42;
        return false;
    L42:
        if (HidlSupport.deepEquals(this.batteryCurrentAvgPath, other.batteryCurrentAvgPath) == true) goto L45;
        return false;
    L45:
        if (HidlSupport.deepEquals(this.batteryChargeCounterPath, other.batteryChargeCounterPath) == true) goto L48;
        return false;
    L48:
        if (HidlSupport.deepEquals(this.batteryFullChargePath, other.batteryFullChargePath) == true) goto L51;
        return false;
    L51:
        if (HidlSupport.deepEquals(this.batteryCycleCountPath, other.batteryCycleCountPath) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.periodicChoresIntervalFast))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.periodicChoresIntervalSlow))), Integer.valueOf(HidlSupport.deepHashCode(this.batteryStatusPath)), Integer.valueOf(HidlSupport.deepHashCode(this.batteryHealthPath)), Integer.valueOf(HidlSupport.deepHashCode(this.batteryPresentPath)), Integer.valueOf(HidlSupport.deepHashCode(this.batteryCapacityPath)), Integer.valueOf(HidlSupport.deepHashCode(this.batteryVoltagePath)), Integer.valueOf(HidlSupport.deepHashCode(this.batteryTemperaturePath)), Integer.valueOf(HidlSupport.deepHashCode(this.batteryTechnologyPath)), Integer.valueOf(HidlSupport.deepHashCode(this.batteryCurrentNowPath)), Integer.valueOf(HidlSupport.deepHashCode(this.batteryCurrentAvgPath)), Integer.valueOf(HidlSupport.deepHashCode(this.batteryChargeCounterPath)), Integer.valueOf(HidlSupport.deepHashCode(this.batteryFullChargePath)), Integer.valueOf(HidlSupport.deepHashCode(this.batteryCycleCountPath))});
    }

    public final String toString() {
        return "{.periodicChoresIntervalFast = " + this.periodicChoresIntervalFast + ", .periodicChoresIntervalSlow = " + this.periodicChoresIntervalSlow + ", .batteryStatusPath = " + this.batteryStatusPath + ", .batteryHealthPath = " + this.batteryHealthPath + ", .batteryPresentPath = " + this.batteryPresentPath + ", .batteryCapacityPath = " + this.batteryCapacityPath + ", .batteryVoltagePath = " + this.batteryVoltagePath + ", .batteryTemperaturePath = " + this.batteryTemperaturePath + ", .batteryTechnologyPath = " + this.batteryTechnologyPath + ", .batteryCurrentNowPath = " + this.batteryCurrentNowPath + ", .batteryCurrentAvgPath = " + this.batteryCurrentAvgPath + ", .batteryChargeCounterPath = " + this.batteryChargeCounterPath + ", .batteryFullChargePath = " + this.batteryFullChargePath + ", .batteryCycleCountPath = " + this.batteryCycleCountPath + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(200);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<HealthConfig> readVectorFromParcel(HwParcel parcel) {
        ArrayList<HealthConfig> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 200, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        HealthConfig _hidl_vec_element = new HealthConfig();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 200);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.periodicChoresIntervalFast = _hidl_blob.getInt32(_hidl_offset + 0);
        this.periodicChoresIntervalSlow = _hidl_blob.getInt32(_hidl_offset + 4);
        this.batteryStatusPath = _hidl_blob.getString(_hidl_offset + 8);
        parcel.readEmbeddedBuffer(this.batteryStatusPath.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 8) + 0, false);
        this.batteryHealthPath = _hidl_blob.getString(_hidl_offset + 24);
        parcel.readEmbeddedBuffer(this.batteryHealthPath.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 24) + 0, false);
        this.batteryPresentPath = _hidl_blob.getString(_hidl_offset + 40);
        parcel.readEmbeddedBuffer(this.batteryPresentPath.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 40) + 0, false);
        this.batteryCapacityPath = _hidl_blob.getString(_hidl_offset + 56);
        parcel.readEmbeddedBuffer(this.batteryCapacityPath.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 56) + 0, false);
        this.batteryVoltagePath = _hidl_blob.getString(_hidl_offset + 72);
        parcel.readEmbeddedBuffer(this.batteryVoltagePath.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 72) + 0, false);
        this.batteryTemperaturePath = _hidl_blob.getString(_hidl_offset + 88);
        parcel.readEmbeddedBuffer(this.batteryTemperaturePath.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 88) + 0, false);
        this.batteryTechnologyPath = _hidl_blob.getString(_hidl_offset + 104);
        parcel.readEmbeddedBuffer(this.batteryTechnologyPath.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 104) + 0, false);
        this.batteryCurrentNowPath = _hidl_blob.getString(_hidl_offset + 120);
        parcel.readEmbeddedBuffer(this.batteryCurrentNowPath.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 120) + 0, false);
        this.batteryCurrentAvgPath = _hidl_blob.getString(_hidl_offset + 136);
        parcel.readEmbeddedBuffer(this.batteryCurrentAvgPath.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 136) + 0, false);
        this.batteryChargeCounterPath = _hidl_blob.getString(_hidl_offset + 152);
        parcel.readEmbeddedBuffer(this.batteryChargeCounterPath.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 152) + 0, false);
        this.batteryFullChargePath = _hidl_blob.getString(_hidl_offset + 168);
        parcel.readEmbeddedBuffer(this.batteryFullChargePath.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 168) + 0, false);
        this.batteryCycleCountPath = _hidl_blob.getString(_hidl_offset + 184);
        parcel.readEmbeddedBuffer(this.batteryCycleCountPath.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 184) + 0, false);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(200);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<HealthConfig> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 200);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 200);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt32(0 + _hidl_offset, this.periodicChoresIntervalFast);
        _hidl_blob.putInt32(4 + _hidl_offset, this.periodicChoresIntervalSlow);
        _hidl_blob.putString(8 + _hidl_offset, this.batteryStatusPath);
        _hidl_blob.putString(24 + _hidl_offset, this.batteryHealthPath);
        _hidl_blob.putString(40 + _hidl_offset, this.batteryPresentPath);
        _hidl_blob.putString(56 + _hidl_offset, this.batteryCapacityPath);
        _hidl_blob.putString(72 + _hidl_offset, this.batteryVoltagePath);
        _hidl_blob.putString(88 + _hidl_offset, this.batteryTemperaturePath);
        _hidl_blob.putString(104 + _hidl_offset, this.batteryTechnologyPath);
        _hidl_blob.putString(120 + _hidl_offset, this.batteryCurrentNowPath);
        _hidl_blob.putString(136 + _hidl_offset, this.batteryCurrentAvgPath);
        _hidl_blob.putString(152 + _hidl_offset, this.batteryChargeCounterPath);
        _hidl_blob.putString(168 + _hidl_offset, this.batteryFullChargePath);
        _hidl_blob.putString(184 + _hidl_offset, this.batteryCycleCountPath);
    }
}
