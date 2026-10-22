package android.hardware.health.V2_1;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class HealthInfo {
    public int batteryCapacityLevel;
    public long batteryChargeTimeToFullNowSeconds;
    public int batteryFullChargeDesignCapacityUah;
    public android.hardware.health.V2_0.HealthInfo legacy;

    public HealthInfo() {
        this.legacy = new android.hardware.health.V2_0.HealthInfo();
        this.batteryCapacityLevel = 0;
        this.batteryChargeTimeToFullNowSeconds = 0;
        this.batteryFullChargeDesignCapacityUah = 0;
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
        if (HidlSupport.deepEquals(this.legacy, other.legacy) == true) goto L15;
        return false;
    L15:
        if (this.batteryCapacityLevel == other.batteryCapacityLevel) goto L18;
        return false;
    L18:
        if (this.batteryChargeTimeToFullNowSeconds == other.batteryChargeTimeToFullNowSeconds) goto L21;
        return false;
    L21:
        if (this.batteryFullChargeDesignCapacityUah == other.batteryFullChargeDesignCapacityUah) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.legacy)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.batteryCapacityLevel))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.batteryChargeTimeToFullNowSeconds))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.batteryFullChargeDesignCapacityUah)))});
    }

    public final String toString() {
        return "{.legacy = " + this.legacy + ", .batteryCapacityLevel = " + BatteryCapacityLevel.toString(this.batteryCapacityLevel) + ", .batteryChargeTimeToFullNowSeconds = " + this.batteryChargeTimeToFullNowSeconds + ", .batteryFullChargeDesignCapacityUah = " + this.batteryFullChargeDesignCapacityUah + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(136);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<HealthInfo> readVectorFromParcel(HwParcel parcel) {
        ArrayList<HealthInfo> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 136, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        HealthInfo _hidl_vec_element = new HealthInfo();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 136);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.legacy.readEmbeddedFromParcel(parcel, _hidl_blob, 0 + _hidl_offset);
        this.batteryCapacityLevel = _hidl_blob.getInt32(112 + _hidl_offset);
        this.batteryChargeTimeToFullNowSeconds = _hidl_blob.getInt64(120 + _hidl_offset);
        this.batteryFullChargeDesignCapacityUah = _hidl_blob.getInt32(128 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(136);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<HealthInfo> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 136);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 136);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        this.legacy.writeEmbeddedToBlob(_hidl_blob, 0 + _hidl_offset);
        _hidl_blob.putInt32(112 + _hidl_offset, this.batteryCapacityLevel);
        _hidl_blob.putInt64(120 + _hidl_offset, this.batteryChargeTimeToFullNowSeconds);
        _hidl_blob.putInt32(128 + _hidl_offset, this.batteryFullChargeDesignCapacityUah);
    }
}
