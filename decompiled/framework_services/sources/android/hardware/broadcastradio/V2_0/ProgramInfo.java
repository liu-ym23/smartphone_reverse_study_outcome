package android.hardware.broadcastradio.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ProgramInfo {
    public int infoFlags;
    public ProgramIdentifier logicallyTunedTo;
    public ArrayList<Metadata> metadata;
    public ProgramIdentifier physicallyTunedTo;
    public ArrayList<ProgramIdentifier> relatedContent;
    public ProgramSelector selector;
    public int signalQuality;
    public ArrayList<VendorKeyValue> vendorInfo;

    public ProgramInfo() {
        this.selector = new ProgramSelector();
        this.logicallyTunedTo = new ProgramIdentifier();
        this.physicallyTunedTo = new ProgramIdentifier();
        this.relatedContent = new ArrayList();
        this.signalQuality = 0;
        this.metadata = new ArrayList();
        this.vendorInfo = new ArrayList();
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == ProgramInfo.class) goto L11;
        return false;
    L11:
        ProgramInfo other = (ProgramInfo) otherObject;
        if (HidlSupport.deepEquals(this.selector, other.selector) == true) goto L15;
        return false;
    L15:
        if (HidlSupport.deepEquals(this.logicallyTunedTo, other.logicallyTunedTo) == true) goto L18;
        return false;
    L18:
        if (HidlSupport.deepEquals(this.physicallyTunedTo, other.physicallyTunedTo) == true) goto L21;
        return false;
    L21:
        if (HidlSupport.deepEquals(this.relatedContent, other.relatedContent) == true) goto L24;
        return false;
    L24:
        if (HidlSupport.deepEquals(Integer.valueOf(this.infoFlags), Integer.valueOf(other.infoFlags)) == true) goto L27;
        return false;
    L27:
        if (this.signalQuality == other.signalQuality) goto L30;
        return false;
    L30:
        if (HidlSupport.deepEquals(this.metadata, other.metadata) == true) goto L33;
        return false;
    L33:
        if (HidlSupport.deepEquals(this.vendorInfo, other.vendorInfo) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.selector)), Integer.valueOf(HidlSupport.deepHashCode(this.logicallyTunedTo)), Integer.valueOf(HidlSupport.deepHashCode(this.physicallyTunedTo)), Integer.valueOf(HidlSupport.deepHashCode(this.relatedContent)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.infoFlags))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.signalQuality))), Integer.valueOf(HidlSupport.deepHashCode(this.metadata)), Integer.valueOf(HidlSupport.deepHashCode(this.vendorInfo))});
    }

    public final String toString() {
        return "{.selector = " + this.selector + ", .logicallyTunedTo = " + this.logicallyTunedTo + ", .physicallyTunedTo = " + this.physicallyTunedTo + ", .relatedContent = " + this.relatedContent + ", .infoFlags = " + ProgramInfoFlags.dumpBitfield(this.infoFlags) + ", .signalQuality = " + this.signalQuality + ", .metadata = " + this.metadata + ", .vendorInfo = " + this.vendorInfo + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(120);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<ProgramInfo> readVectorFromParcel(HwParcel parcel) {
        ArrayList<ProgramInfo> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 120, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        ProgramInfo _hidl_vec_element = new ProgramInfo();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 120);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.selector.readEmbeddedFromParcel(parcel, _hidl_blob, _hidl_offset + 0);
        this.logicallyTunedTo.readEmbeddedFromParcel(parcel, _hidl_blob, _hidl_offset + 32);
        this.physicallyTunedTo.readEmbeddedFromParcel(parcel, _hidl_blob, _hidl_offset + 48);
        int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 64) + 8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 16, _hidl_blob.handle(), (_hidl_offset + 64) + 0, true);
        this.relatedContent.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        ProgramIdentifier _hidl_vec_element = new ProgramIdentifier();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 16);
        this.relatedContent.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        this.infoFlags = _hidl_blob.getInt32(_hidl_offset + 80);
        this.signalQuality = _hidl_blob.getInt32(_hidl_offset + 84);
        int _hidl_vec_size2 = _hidl_blob.getInt32((_hidl_offset + 88) + 8);
        HwBlob childBlob2 = parcel.readEmbeddedBuffer(_hidl_vec_size2 * 32, _hidl_blob.handle(), (_hidl_offset + 88) + 0, true);
        this.metadata.clear();
        int _hidl_index_1 = 0;
    L6:
        if (_hidl_index_1 >= _hidl_vec_size2) goto L8;
        Metadata _hidl_vec_element2 = new Metadata();
        _hidl_vec_element2.readEmbeddedFromParcel(parcel, childBlob2, _hidl_index_1 * 32);
        this.metadata.add(_hidl_vec_element2);
        _hidl_index_1 = _hidl_index_1 + 1;
        goto L6
    L8:
        int _hidl_vec_size3 = _hidl_blob.getInt32((_hidl_offset + 104) + 8);
        HwBlob childBlob3 = parcel.readEmbeddedBuffer(_hidl_vec_size3 * 32, _hidl_blob.handle(), (_hidl_offset + 104) + 0, true);
        this.vendorInfo.clear();
        int _hidl_index_2 = 0;
    L9:
        if (_hidl_index_2 >= _hidl_vec_size3) goto L12;
        VendorKeyValue _hidl_vec_element3 = new VendorKeyValue();
        _hidl_vec_element3.readEmbeddedFromParcel(parcel, childBlob3, _hidl_index_2 * 32);
        this.vendorInfo.add(_hidl_vec_element3);
        _hidl_index_2 = _hidl_index_2 + 1;
        goto L9
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(120);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<ProgramInfo> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 120);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 120);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        long r3 = 0;
        this.selector.writeEmbeddedToBlob(_hidl_blob, _hidl_offset + 0);
        this.logicallyTunedTo.writeEmbeddedToBlob(_hidl_blob, _hidl_offset + 32);
        this.physicallyTunedTo.writeEmbeddedToBlob(_hidl_blob, _hidl_offset + 48);
        int _hidl_vec_size = this.relatedContent.size();
        _hidl_blob.putInt32((_hidl_offset + 64) + 8, _hidl_vec_size);
        _hidl_blob.putBool((_hidl_offset + 64) + 12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 16);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        this.relatedContent.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 16);
        _hidl_index_0 = _hidl_index_0 + 1;
        r3 = r3;
        goto L3
    L5:
        long r16 = r3;
        _hidl_blob.putBlob((_hidl_offset + 64) + r16, childBlob);
        _hidl_blob.putInt32(_hidl_offset + 80, this.infoFlags);
        _hidl_blob.putInt32(_hidl_offset + 84, this.signalQuality);
        int _hidl_vec_size2 = this.metadata.size();
        _hidl_blob.putInt32((_hidl_offset + 88) + 8, _hidl_vec_size2);
        _hidl_blob.putBool((_hidl_offset + 88) + 12, false);
        HwBlob childBlob2 = new HwBlob(_hidl_vec_size2 * 32);
        int _hidl_index_1 = 0;
    L6:
        if (_hidl_index_1 >= _hidl_vec_size2) goto L8;
        this.metadata.get(_hidl_index_1).writeEmbeddedToBlob(childBlob2, _hidl_index_1 * 32);
        _hidl_index_1 = _hidl_index_1 + 1;
        goto L6
    L8:
        _hidl_blob.putBlob((_hidl_offset + 88) + r16, childBlob2);
        int _hidl_vec_size3 = this.vendorInfo.size();
        _hidl_blob.putInt32((_hidl_offset + 104) + 8, _hidl_vec_size3);
        _hidl_blob.putBool((_hidl_offset + 104) + 12, false);
        HwBlob childBlob3 = new HwBlob(_hidl_vec_size3 * 32);
        int _hidl_index_2 = 0;
    L9:
        if (_hidl_index_2 >= _hidl_vec_size3) goto L11;
        this.vendorInfo.get(_hidl_index_2).writeEmbeddedToBlob(childBlob3, _hidl_index_2 * 32);
        _hidl_index_2 = _hidl_index_2 + 1;
        goto L9
    L11:
        _hidl_blob.putBlob((_hidl_offset + 104) + r16, childBlob3);
    }
}
