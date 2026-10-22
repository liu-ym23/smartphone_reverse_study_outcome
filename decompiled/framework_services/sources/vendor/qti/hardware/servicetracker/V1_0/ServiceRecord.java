package vendor.qti.hardware.servicetracker.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ServiceRecord {
    public ArrayList<ServiceConnection> conn;
    public double lastActivity;
    public String packageName;
    public int pid;
    public String processName;
    public boolean serviceB;

    public ServiceRecord() {
        this.packageName = new String();
        this.processName = new String();
        this.pid = 0;
        this.serviceB = false;
        this.lastActivity = 0.0d;
        this.conn = new ArrayList();
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == ServiceRecord.class) goto L11;
        return false;
    L11:
        ServiceRecord other = (ServiceRecord) otherObject;
        if (HidlSupport.deepEquals(this.packageName, other.packageName) == true) goto L15;
        return false;
    L15:
        if (HidlSupport.deepEquals(this.processName, other.processName) == true) goto L18;
        return false;
    L18:
        if (this.pid == other.pid) goto L21;
        return false;
    L21:
        if (this.serviceB == other.serviceB) goto L24;
        return false;
    L24:
        if (this.lastActivity == other.lastActivity) goto L27;
        return false;
    L27:
        if (HidlSupport.deepEquals(this.conn, other.conn) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.packageName)), Integer.valueOf(HidlSupport.deepHashCode(this.processName)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.pid))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.serviceB))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.lastActivity))), Integer.valueOf(HidlSupport.deepHashCode(this.conn))});
    }

    public final String toString() {
        return "{.packageName = " + this.packageName + ", .processName = " + this.processName + ", .pid = " + this.pid + ", .serviceB = " + this.serviceB + ", .lastActivity = " + this.lastActivity + ", .conn = " + this.conn + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(64);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<ServiceRecord> readVectorFromParcel(HwParcel parcel) {
        ArrayList<ServiceRecord> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 64, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        ServiceRecord _hidl_vec_element = new ServiceRecord();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 64);
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
        this.serviceB = _hidl_blob.getBool(_hidl_offset + 36);
        this.lastActivity = _hidl_blob.getDouble(_hidl_offset + 40);
        int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 48) + 8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 24, _hidl_blob.handle(), (_hidl_offset + 48) + 0, true);
        this.conn.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        ServiceConnection _hidl_vec_element = new ServiceConnection();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 24);
        this.conn.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(64);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<ServiceRecord> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 64);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 64);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putString(_hidl_offset + 0, this.packageName);
        _hidl_blob.putString(16 + _hidl_offset, this.processName);
        _hidl_blob.putInt32(32 + _hidl_offset, this.pid);
        _hidl_blob.putBool(36 + _hidl_offset, this.serviceB);
        _hidl_blob.putDouble(40 + _hidl_offset, this.lastActivity);
        int _hidl_vec_size = this.conn.size();
        _hidl_blob.putInt32((_hidl_offset + 48) + 8, _hidl_vec_size);
        _hidl_blob.putBool((_hidl_offset + 48) + 12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 24);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        this.conn.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 24);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob((48 + _hidl_offset) + 0, childBlob);
    }
}
