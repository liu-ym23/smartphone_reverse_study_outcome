package android.hardware.broadcastradio.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ProgramFilter {
    public boolean excludeModifications;
    public ArrayList<Integer> identifierTypes;
    public ArrayList<ProgramIdentifier> identifiers;
    public boolean includeCategories;

    public ProgramFilter() {
        this.identifierTypes = new ArrayList();
        this.identifiers = new ArrayList();
        this.includeCategories = false;
        this.excludeModifications = false;
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == ProgramFilter.class) goto L11;
        return false;
    L11:
        ProgramFilter other = (ProgramFilter) otherObject;
        if (HidlSupport.deepEquals(this.identifierTypes, other.identifierTypes) == true) goto L15;
        return false;
    L15:
        if (HidlSupport.deepEquals(this.identifiers, other.identifiers) == true) goto L18;
        return false;
    L18:
        if (this.includeCategories == other.includeCategories) goto L21;
        return false;
    L21:
        if (this.excludeModifications == other.excludeModifications) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.identifierTypes)), Integer.valueOf(HidlSupport.deepHashCode(this.identifiers)), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.includeCategories))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.excludeModifications)))});
    }

    public final String toString() {
        return "{.identifierTypes = " + this.identifierTypes + ", .identifiers = " + this.identifiers + ", .includeCategories = " + this.includeCategories + ", .excludeModifications = " + this.excludeModifications + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(40);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<ProgramFilter> readVectorFromParcel(HwParcel parcel) {
        ArrayList<ProgramFilter> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 40, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        ProgramFilter _hidl_vec_element = new ProgramFilter();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 40);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 0) + 8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 4, _hidl_blob.handle(), (_hidl_offset + 0) + 0, true);
        this.identifierTypes.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        this.identifierTypes.add(Integer.valueOf(childBlob.getInt32(_hidl_index_0 * 4)));
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        int _hidl_vec_size2 = _hidl_blob.getInt32((_hidl_offset + 16) + 8);
        HwBlob childBlob2 = parcel.readEmbeddedBuffer(_hidl_vec_size2 * 16, _hidl_blob.handle(), (_hidl_offset + 16) + 0, true);
        this.identifiers.clear();
        int _hidl_index_1 = 0;
    L6:
        if (_hidl_index_1 >= _hidl_vec_size2) goto L8;
        ProgramIdentifier _hidl_vec_element = new ProgramIdentifier();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob2, _hidl_index_1 * 16);
        this.identifiers.add(_hidl_vec_element);
        _hidl_index_1 = _hidl_index_1 + 1;
        goto L6
    L8:
        this.includeCategories = _hidl_blob.getBool(_hidl_offset + 32);
        this.excludeModifications = _hidl_blob.getBool(_hidl_offset + 33);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(40);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<ProgramFilter> _hidl_vec) {
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
        int _hidl_vec_size = this.identifierTypes.size();
        _hidl_blob.putInt32((_hidl_offset + 0) + 8, _hidl_vec_size);
        _hidl_blob.putBool((_hidl_offset + 0) + 12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 4);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        childBlob.putInt32(_hidl_index_0 * 4, this.identifierTypes.get(_hidl_index_0).intValue());
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob((_hidl_offset + 0) + 0, childBlob);
        int _hidl_vec_size2 = this.identifiers.size();
        _hidl_blob.putInt32((_hidl_offset + 16) + 8, _hidl_vec_size2);
        _hidl_blob.putBool((_hidl_offset + 16) + 12, false);
        HwBlob childBlob2 = new HwBlob(_hidl_vec_size2 * 16);
        int _hidl_index_1 = 0;
    L6:
        if (_hidl_index_1 >= _hidl_vec_size2) goto L8;
        this.identifiers.get(_hidl_index_1).writeEmbeddedToBlob(childBlob2, _hidl_index_1 * 16);
        _hidl_index_1 = _hidl_index_1 + 1;
        goto L6
    L8:
        _hidl_blob.putBlob((16 + _hidl_offset) + 0, childBlob2);
        _hidl_blob.putBool(32 + _hidl_offset, this.includeCategories);
        _hidl_blob.putBool(33 + _hidl_offset, this.excludeModifications);
    }
}
