package android.hardware.tv.cec.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class HdmiPortInfo {
    public boolean arcSupported;
    public boolean cecSupported;
    public short physicalAddress;
    public int portId;
    public int type;

    public HdmiPortInfo() {
        this.type = 0;
        this.portId = 0;
        this.cecSupported = false;
        this.arcSupported = false;
        this.physicalAddress = 0;
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == HdmiPortInfo.class) goto L11;
        return false;
    L11:
        HdmiPortInfo other = (HdmiPortInfo) otherObject;
        if (this.type == other.type) goto L15;
        return false;
    L15:
        if (this.portId == other.portId) goto L18;
        return false;
    L18:
        if (this.cecSupported == other.cecSupported) goto L21;
        return false;
    L21:
        if (this.arcSupported == other.arcSupported) goto L24;
        return false;
    L24:
        if (this.physicalAddress == other.physicalAddress) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.type))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.portId))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.cecSupported))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.arcSupported))), Integer.valueOf(HidlSupport.deepHashCode(Short.valueOf(this.physicalAddress)))});
    }

    public final String toString() {
        return "{.type = " + HdmiPortType.toString(this.type) + ", .portId = " + this.portId + ", .cecSupported = " + this.cecSupported + ", .arcSupported = " + this.arcSupported + ", .physicalAddress = " + this.physicalAddress + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(12);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<HdmiPortInfo> readVectorFromParcel(HwParcel parcel) {
        ArrayList<HdmiPortInfo> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 12, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        HdmiPortInfo _hidl_vec_element = new HdmiPortInfo();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 12);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.type = _hidl_blob.getInt32(0 + _hidl_offset);
        this.portId = _hidl_blob.getInt32(4 + _hidl_offset);
        this.cecSupported = _hidl_blob.getBool(8 + _hidl_offset);
        this.arcSupported = _hidl_blob.getBool(9 + _hidl_offset);
        this.physicalAddress = _hidl_blob.getInt16(10 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(12);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<HdmiPortInfo> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 12);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 12);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt32(0 + _hidl_offset, this.type);
        _hidl_blob.putInt32(4 + _hidl_offset, this.portId);
        _hidl_blob.putBool(8 + _hidl_offset, this.cecSupported);
        _hidl_blob.putBool(9 + _hidl_offset, this.arcSupported);
        _hidl_blob.putInt16(10 + _hidl_offset, this.physicalAddress);
    }
}
