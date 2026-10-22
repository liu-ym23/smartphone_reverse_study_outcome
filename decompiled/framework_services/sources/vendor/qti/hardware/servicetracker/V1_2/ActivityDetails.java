package vendor.qti.hardware.servicetracker.V1_2;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityDetails {
    public String className;
    public String intent;
    public int launchedFromPid;
    public int launchedFromUid;
    public String packageName;
    public String processName;
    public int versioncode;

    public ActivityDetails() {
        this.launchedFromPid = 0;
        this.launchedFromUid = 0;
        this.packageName = new String();
        this.processName = new String();
        this.intent = new String();
        this.className = new String();
        this.versioncode = 0;
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == ActivityDetails.class) goto L11;
        return false;
    L11:
        ActivityDetails other = (ActivityDetails) otherObject;
        if (this.launchedFromPid == other.launchedFromPid) goto L15;
        return false;
    L15:
        if (this.launchedFromUid == other.launchedFromUid) goto L18;
        return false;
    L18:
        if (HidlSupport.deepEquals(this.packageName, other.packageName) == true) goto L21;
        return false;
    L21:
        if (HidlSupport.deepEquals(this.processName, other.processName) == true) goto L24;
        return false;
    L24:
        if (HidlSupport.deepEquals(this.intent, other.intent) == true) goto L27;
        return false;
    L27:
        if (HidlSupport.deepEquals(this.className, other.className) == true) goto L30;
        return false;
    L30:
        if (this.versioncode == other.versioncode) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.launchedFromPid))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.launchedFromUid))), Integer.valueOf(HidlSupport.deepHashCode(this.packageName)), Integer.valueOf(HidlSupport.deepHashCode(this.processName)), Integer.valueOf(HidlSupport.deepHashCode(this.intent)), Integer.valueOf(HidlSupport.deepHashCode(this.className)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.versioncode)))});
    }

    public final String toString() {
        return "{.launchedFromPid = " + this.launchedFromPid + ", .launchedFromUid = " + this.launchedFromUid + ", .packageName = " + this.packageName + ", .processName = " + this.processName + ", .intent = " + this.intent + ", .className = " + this.className + ", .versioncode = " + this.versioncode + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(80);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<ActivityDetails> readVectorFromParcel(HwParcel parcel) {
        ArrayList<ActivityDetails> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 80, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        ActivityDetails _hidl_vec_element = new ActivityDetails();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 80);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.launchedFromPid = _hidl_blob.getInt32(_hidl_offset + 0);
        this.launchedFromUid = _hidl_blob.getInt32(_hidl_offset + 4);
        this.packageName = _hidl_blob.getString(_hidl_offset + 8);
        parcel.readEmbeddedBuffer(this.packageName.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 8) + 0, false);
        this.processName = _hidl_blob.getString(_hidl_offset + 24);
        parcel.readEmbeddedBuffer(this.processName.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 24) + 0, false);
        this.intent = _hidl_blob.getString(_hidl_offset + 40);
        parcel.readEmbeddedBuffer(this.intent.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 40) + 0, false);
        this.className = _hidl_blob.getString(_hidl_offset + 56);
        parcel.readEmbeddedBuffer(this.className.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 56) + 0, false);
        this.versioncode = _hidl_blob.getInt32(_hidl_offset + 72);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(80);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<ActivityDetails> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 80);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 80);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt32(0 + _hidl_offset, this.launchedFromPid);
        _hidl_blob.putInt32(4 + _hidl_offset, this.launchedFromUid);
        _hidl_blob.putString(8 + _hidl_offset, this.packageName);
        _hidl_blob.putString(24 + _hidl_offset, this.processName);
        _hidl_blob.putString(40 + _hidl_offset, this.intent);
        _hidl_blob.putString(56 + _hidl_offset, this.className);
        _hidl_blob.putInt32(72 + _hidl_offset, this.versioncode);
    }
}
