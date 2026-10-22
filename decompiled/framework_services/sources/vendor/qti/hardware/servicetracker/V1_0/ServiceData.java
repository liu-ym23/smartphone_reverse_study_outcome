package vendor.qti.hardware.servicetracker.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ServiceData {
    public double lastActivity;
    public String packageName;
    public int pid;
    public String processName;
    public boolean serviceB;

    public ServiceData() {
        this.packageName = new String();
        this.processName = new String();
        this.pid = 0;
        this.lastActivity = 0.0d;
        this.serviceB = false;
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == ServiceData.class) goto L11;
        return false;
    L11:
        ServiceData other = (ServiceData) otherObject;
        if (HidlSupport.deepEquals(this.packageName, other.packageName) == true) goto L15;
        return false;
    L15:
        if (HidlSupport.deepEquals(this.processName, other.processName) == true) goto L18;
        return false;
    L18:
        if (this.pid == other.pid) goto L21;
        return false;
    L21:
        if (this.lastActivity == other.lastActivity) goto L24;
        return false;
    L24:
        if (this.serviceB == other.serviceB) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.packageName)), Integer.valueOf(HidlSupport.deepHashCode(this.processName)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.pid))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.lastActivity))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.serviceB)))});
    }

    public final String toString() {
        return "{.packageName = " + this.packageName + ", .processName = " + this.processName + ", .pid = " + this.pid + ", .lastActivity = " + this.lastActivity + ", .serviceB = " + this.serviceB + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(56);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<ServiceData> readVectorFromParcel(HwParcel parcel) {
        ArrayList<ServiceData> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 56, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        ServiceData _hidl_vec_element = new ServiceData();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 56);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.packageName = _hidl_blob.getString(_hidl_offset + 0);
        parcel.readEmbeddedBuffer(this.packageName.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 0) + 0, false);
        this.processName = _hidl_blob.getString(_hidl_offset + 16);
        parcel.readEmbeddedBuffer(this.processName.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 16) + 0, false);
        this.pid = _hidl_blob.getInt32(_hidl_offset + 32);
        this.lastActivity = _hidl_blob.getDouble(_hidl_offset + 40);
        this.serviceB = _hidl_blob.getBool(_hidl_offset + 48);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(56);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<ServiceData> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 56);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 56);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putString(0 + _hidl_offset, this.packageName);
        _hidl_blob.putString(16 + _hidl_offset, this.processName);
        _hidl_blob.putInt32(32 + _hidl_offset, this.pid);
        _hidl_blob.putDouble(40 + _hidl_offset, this.lastActivity);
        _hidl_blob.putBool(48 + _hidl_offset, this.serviceB);
    }
}
