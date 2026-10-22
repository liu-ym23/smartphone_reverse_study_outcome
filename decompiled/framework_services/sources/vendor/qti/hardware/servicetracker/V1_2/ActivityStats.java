package vendor.qti.hardware.servicetracker.V1_2;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityStats {
    public long createTime;
    public long lastLaunchTime;
    public long lastVisibleTime;
    public int launchCount;

    public ActivityStats() {
        this.createTime = 0;
        this.lastVisibleTime = 0;
        this.launchCount = 0;
        this.lastLaunchTime = 0;
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == ActivityStats.class) goto L11;
        return false;
    L11:
        ActivityStats other = (ActivityStats) otherObject;
        if (this.createTime == other.createTime) goto L15;
        return false;
    L15:
        if (this.lastVisibleTime == other.lastVisibleTime) goto L18;
        return false;
    L18:
        if (this.launchCount == other.launchCount) goto L21;
        return false;
    L21:
        if (this.lastLaunchTime == other.lastLaunchTime) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.createTime))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.lastVisibleTime))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.launchCount))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.lastLaunchTime)))});
    }

    public final String toString() {
        return "{.createTime = " + this.createTime + ", .lastVisibleTime = " + this.lastVisibleTime + ", .launchCount = " + this.launchCount + ", .lastLaunchTime = " + this.lastLaunchTime + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(32);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<ActivityStats> readVectorFromParcel(HwParcel parcel) {
        ArrayList<ActivityStats> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 32, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        ActivityStats _hidl_vec_element = new ActivityStats();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 32);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.createTime = _hidl_blob.getInt64(0 + _hidl_offset);
        this.lastVisibleTime = _hidl_blob.getInt64(8 + _hidl_offset);
        this.launchCount = _hidl_blob.getInt32(16 + _hidl_offset);
        this.lastLaunchTime = _hidl_blob.getInt64(24 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(32);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<ActivityStats> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 32);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 32);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt64(0 + _hidl_offset, this.createTime);
        _hidl_blob.putInt64(8 + _hidl_offset, this.lastVisibleTime);
        _hidl_blob.putInt32(16 + _hidl_offset, this.launchCount);
        _hidl_blob.putInt64(24 + _hidl_offset, this.lastLaunchTime);
    }
}
