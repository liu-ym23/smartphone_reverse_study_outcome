package android.hardware.health.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class HealthInfo {
    public int batteryCurrentAverage;
    public ArrayList<DiskStats> diskStats;
    public android.hardware.health.V1_0.HealthInfo legacy;
    public ArrayList<StorageInfo> storageInfos;

    public HealthInfo() {
        this.legacy = new android.hardware.health.V1_0.HealthInfo();
        this.batteryCurrentAverage = 0;
        this.diskStats = new ArrayList();
        this.storageInfos = new ArrayList();
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
        if (this.batteryCurrentAverage == other.batteryCurrentAverage) goto L18;
        return false;
    L18:
        if (HidlSupport.deepEquals(this.diskStats, other.diskStats) == true) goto L21;
        return false;
    L21:
        if (HidlSupport.deepEquals(this.storageInfos, other.storageInfos) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.legacy)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.batteryCurrentAverage))), Integer.valueOf(HidlSupport.deepHashCode(this.diskStats)), Integer.valueOf(HidlSupport.deepHashCode(this.storageInfos))});
    }

    public final String toString() {
        return "{.legacy = " + this.legacy + ", .batteryCurrentAverage = " + this.batteryCurrentAverage + ", .diskStats = " + this.diskStats + ", .storageInfos = " + this.storageInfos + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(112);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<HealthInfo> readVectorFromParcel(HwParcel parcel) {
        ArrayList<HealthInfo> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 112, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        HealthInfo _hidl_vec_element = new HealthInfo();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 112);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.legacy.readEmbeddedFromParcel(parcel, _hidl_blob, _hidl_offset + 0);
        this.batteryCurrentAverage = _hidl_blob.getInt32(_hidl_offset + 72);
        int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 80) + 8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 112, _hidl_blob.handle(), (_hidl_offset + 80) + 0, true);
        this.diskStats.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        DiskStats _hidl_vec_element = new DiskStats();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 112);
        this.diskStats.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        int _hidl_vec_size2 = _hidl_blob.getInt32((_hidl_offset + 96) + 8);
        HwBlob childBlob2 = parcel.readEmbeddedBuffer(_hidl_vec_size2 * 48, _hidl_blob.handle(), (_hidl_offset + 96) + 0, true);
        this.storageInfos.clear();
        int _hidl_index_1 = 0;
    L6:
        if (_hidl_index_1 >= _hidl_vec_size2) goto L9;
        StorageInfo _hidl_vec_element2 = new StorageInfo();
        _hidl_vec_element2.readEmbeddedFromParcel(parcel, childBlob2, _hidl_index_1 * 48);
        this.storageInfos.add(_hidl_vec_element2);
        _hidl_index_1 = _hidl_index_1 + 1;
        goto L6
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(112);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<HealthInfo> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 112);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 112);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        long r3 = 0;
        this.legacy.writeEmbeddedToBlob(_hidl_blob, _hidl_offset + 0);
        _hidl_blob.putInt32(_hidl_offset + 72, this.batteryCurrentAverage);
        int _hidl_vec_size = this.diskStats.size();
        _hidl_blob.putInt32((_hidl_offset + 80) + 8, _hidl_vec_size);
        _hidl_blob.putBool((_hidl_offset + 80) + 12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 112);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        this.diskStats.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 112);
        _hidl_index_0 = _hidl_index_0 + 1;
        r3 = r3;
        goto L3
    L5:
        long r16 = r3;
        _hidl_blob.putBlob((_hidl_offset + 80) + r16, childBlob);
        int _hidl_vec_size2 = this.storageInfos.size();
        _hidl_blob.putInt32((_hidl_offset + 96) + 8, _hidl_vec_size2);
        _hidl_blob.putBool((_hidl_offset + 96) + 12, false);
        HwBlob childBlob2 = new HwBlob(_hidl_vec_size2 * 48);
        int _hidl_index_1 = 0;
    L6:
        if (_hidl_index_1 >= _hidl_vec_size2) goto L8;
        this.storageInfos.get(_hidl_index_1).writeEmbeddedToBlob(childBlob2, _hidl_index_1 * 48);
        _hidl_index_1 = _hidl_index_1 + 1;
        goto L6
    L8:
        _hidl_blob.putBlob((_hidl_offset + 96) + r16, childBlob2);
    }
}
