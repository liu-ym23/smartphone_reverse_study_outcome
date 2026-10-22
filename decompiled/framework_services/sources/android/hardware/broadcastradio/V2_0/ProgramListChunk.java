package android.hardware.broadcastradio.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ProgramListChunk {
    public boolean complete;
    public ArrayList<ProgramInfo> modified;
    public boolean purge;
    public ArrayList<ProgramIdentifier> removed;

    public ProgramListChunk() {
        this.purge = false;
        this.complete = false;
        this.modified = new ArrayList();
        this.removed = new ArrayList();
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == ProgramListChunk.class) goto L11;
        return false;
    L11:
        ProgramListChunk other = (ProgramListChunk) otherObject;
        if (this.purge == other.purge) goto L15;
        return false;
    L15:
        if (this.complete == other.complete) goto L18;
        return false;
    L18:
        if (HidlSupport.deepEquals(this.modified, other.modified) == true) goto L21;
        return false;
    L21:
        if (HidlSupport.deepEquals(this.removed, other.removed) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.purge))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.complete))), Integer.valueOf(HidlSupport.deepHashCode(this.modified)), Integer.valueOf(HidlSupport.deepHashCode(this.removed))});
    }

    public final String toString() {
        return "{.purge = " + this.purge + ", .complete = " + this.complete + ", .modified = " + this.modified + ", .removed = " + this.removed + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(40);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<ProgramListChunk> readVectorFromParcel(HwParcel parcel) {
        ArrayList<ProgramListChunk> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 40, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        ProgramListChunk _hidl_vec_element = new ProgramListChunk();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 40);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.purge = _hidl_blob.getBool(_hidl_offset + 0);
        this.complete = _hidl_blob.getBool(_hidl_offset + 1);
        int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 8) + 8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 120, _hidl_blob.handle(), (_hidl_offset + 8) + 0, true);
        this.modified.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        ProgramInfo _hidl_vec_element = new ProgramInfo();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 120);
        this.modified.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        int _hidl_vec_size2 = _hidl_blob.getInt32((_hidl_offset + 24) + 8);
        HwBlob childBlob2 = parcel.readEmbeddedBuffer(_hidl_vec_size2 * 16, _hidl_blob.handle(), (_hidl_offset + 24) + 0, true);
        this.removed.clear();
        int _hidl_index_1 = 0;
    L6:
        if (_hidl_index_1 >= _hidl_vec_size2) goto L9;
        ProgramIdentifier _hidl_vec_element2 = new ProgramIdentifier();
        _hidl_vec_element2.readEmbeddedFromParcel(parcel, childBlob2, _hidl_index_1 * 16);
        this.removed.add(_hidl_vec_element2);
        _hidl_index_1 = _hidl_index_1 + 1;
        goto L6
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(40);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<ProgramListChunk> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 40);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 40);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putBool(_hidl_offset + 0, this.purge);
        _hidl_blob.putBool(1 + _hidl_offset, this.complete);
        int _hidl_vec_size = this.modified.size();
        _hidl_blob.putInt32((_hidl_offset + 8) + 8, _hidl_vec_size);
        _hidl_blob.putBool((_hidl_offset + 8) + 12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 120);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        this.modified.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 120);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob((_hidl_offset + 8) + 0, childBlob);
        int _hidl_vec_size2 = this.removed.size();
        _hidl_blob.putInt32((_hidl_offset + 24) + 8, _hidl_vec_size2);
        _hidl_blob.putBool((_hidl_offset + 24) + 12, false);
        HwBlob childBlob2 = new HwBlob(_hidl_vec_size2 * 16);
        int _hidl_index_1 = 0;
    L6:
        if (_hidl_index_1 >= _hidl_vec_size2) goto L8;
        this.removed.get(_hidl_index_1).writeEmbeddedToBlob(childBlob2, _hidl_index_1 * 16);
        _hidl_index_1 = _hidl_index_1 + 1;
        goto L6
    L8:
        _hidl_blob.putBlob((24 + _hidl_offset) + 0, childBlob2);
    }
}
