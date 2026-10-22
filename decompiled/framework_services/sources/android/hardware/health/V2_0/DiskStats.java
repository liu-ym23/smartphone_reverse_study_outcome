package android.hardware.health.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class DiskStats {
    public StorageAttribute attr;
    public long ioInFlight;
    public long ioInQueue;
    public long ioTicks;
    public long readMerges;
    public long readSectors;
    public long readTicks;
    public long reads;
    public long writeMerges;
    public long writeSectors;
    public long writeTicks;
    public long writes;

    public DiskStats() {
        this.reads = 0;
        this.readMerges = 0;
        this.readSectors = 0;
        this.readTicks = 0;
        this.writes = 0;
        this.writeMerges = 0;
        this.writeSectors = 0;
        this.writeTicks = 0;
        this.ioInFlight = 0;
        this.ioTicks = 0;
        this.ioInQueue = 0;
        this.attr = new StorageAttribute();
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == DiskStats.class) goto L11;
        return false;
    L11:
        DiskStats other = (DiskStats) otherObject;
        if (this.reads == other.reads) goto L15;
        return false;
    L15:
        if (this.readMerges == other.readMerges) goto L18;
        return false;
    L18:
        if (this.readSectors == other.readSectors) goto L21;
        return false;
    L21:
        if (this.readTicks == other.readTicks) goto L24;
        return false;
    L24:
        if (this.writes == other.writes) goto L27;
        return false;
    L27:
        if (this.writeMerges == other.writeMerges) goto L30;
        return false;
    L30:
        if (this.writeSectors == other.writeSectors) goto L33;
        return false;
    L33:
        if (this.writeTicks == other.writeTicks) goto L36;
        return false;
    L36:
        if (this.ioInFlight == other.ioInFlight) goto L39;
        return false;
    L39:
        if (this.ioTicks == other.ioTicks) goto L42;
        return false;
    L42:
        if (this.ioInQueue == other.ioInQueue) goto L45;
        return false;
    L45:
        if (HidlSupport.deepEquals(this.attr, other.attr) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.reads))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.readMerges))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.readSectors))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.readTicks))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.writes))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.writeMerges))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.writeSectors))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.writeTicks))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.ioInFlight))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.ioTicks))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.ioInQueue))), Integer.valueOf(HidlSupport.deepHashCode(this.attr))});
    }

    public final String toString() {
        return "{.reads = " + this.reads + ", .readMerges = " + this.readMerges + ", .readSectors = " + this.readSectors + ", .readTicks = " + this.readTicks + ", .writes = " + this.writes + ", .writeMerges = " + this.writeMerges + ", .writeSectors = " + this.writeSectors + ", .writeTicks = " + this.writeTicks + ", .ioInFlight = " + this.ioInFlight + ", .ioTicks = " + this.ioTicks + ", .ioInQueue = " + this.ioInQueue + ", .attr = " + this.attr + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(112);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<DiskStats> readVectorFromParcel(HwParcel parcel) {
        ArrayList<DiskStats> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 112, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        DiskStats _hidl_vec_element = new DiskStats();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 112);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.reads = _hidl_blob.getInt64(0 + _hidl_offset);
        this.readMerges = _hidl_blob.getInt64(8 + _hidl_offset);
        this.readSectors = _hidl_blob.getInt64(16 + _hidl_offset);
        this.readTicks = _hidl_blob.getInt64(24 + _hidl_offset);
        this.writes = _hidl_blob.getInt64(32 + _hidl_offset);
        this.writeMerges = _hidl_blob.getInt64(40 + _hidl_offset);
        this.writeSectors = _hidl_blob.getInt64(48 + _hidl_offset);
        this.writeTicks = _hidl_blob.getInt64(56 + _hidl_offset);
        this.ioInFlight = _hidl_blob.getInt64(64 + _hidl_offset);
        this.ioTicks = _hidl_blob.getInt64(72 + _hidl_offset);
        this.ioInQueue = _hidl_blob.getInt64(80 + _hidl_offset);
        this.attr.readEmbeddedFromParcel(parcel, _hidl_blob, 88 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(112);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<DiskStats> _hidl_vec) {
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
        _hidl_blob.putInt64(0 + _hidl_offset, this.reads);
        _hidl_blob.putInt64(8 + _hidl_offset, this.readMerges);
        _hidl_blob.putInt64(16 + _hidl_offset, this.readSectors);
        _hidl_blob.putInt64(24 + _hidl_offset, this.readTicks);
        _hidl_blob.putInt64(32 + _hidl_offset, this.writes);
        _hidl_blob.putInt64(40 + _hidl_offset, this.writeMerges);
        _hidl_blob.putInt64(48 + _hidl_offset, this.writeSectors);
        _hidl_blob.putInt64(56 + _hidl_offset, this.writeTicks);
        _hidl_blob.putInt64(64 + _hidl_offset, this.ioInFlight);
        _hidl_blob.putInt64(72 + _hidl_offset, this.ioTicks);
        _hidl_blob.putInt64(80 + _hidl_offset, this.ioInQueue);
        this.attr.writeEmbeddedToBlob(_hidl_blob, 88 + _hidl_offset);
    }
}
