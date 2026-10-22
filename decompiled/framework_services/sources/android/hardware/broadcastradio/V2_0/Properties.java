package android.hardware.broadcastradio.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Properties {
    public String maker;
    public String product;
    public String serial;
    public ArrayList<Integer> supportedIdentifierTypes;
    public ArrayList<VendorKeyValue> vendorInfo;
    public String version;

    public Properties() {
        this.maker = new String();
        this.product = new String();
        this.version = new String();
        this.serial = new String();
        this.supportedIdentifierTypes = new ArrayList();
        this.vendorInfo = new ArrayList();
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == Properties.class) goto L11;
        return false;
    L11:
        Properties other = (Properties) otherObject;
        if (HidlSupport.deepEquals(this.maker, other.maker) == true) goto L15;
        return false;
    L15:
        if (HidlSupport.deepEquals(this.product, other.product) == true) goto L18;
        return false;
    L18:
        if (HidlSupport.deepEquals(this.version, other.version) == true) goto L21;
        return false;
    L21:
        if (HidlSupport.deepEquals(this.serial, other.serial) == true) goto L24;
        return false;
    L24:
        if (HidlSupport.deepEquals(this.supportedIdentifierTypes, other.supportedIdentifierTypes) == true) goto L27;
        return false;
    L27:
        if (HidlSupport.deepEquals(this.vendorInfo, other.vendorInfo) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.maker)), Integer.valueOf(HidlSupport.deepHashCode(this.product)), Integer.valueOf(HidlSupport.deepHashCode(this.version)), Integer.valueOf(HidlSupport.deepHashCode(this.serial)), Integer.valueOf(HidlSupport.deepHashCode(this.supportedIdentifierTypes)), Integer.valueOf(HidlSupport.deepHashCode(this.vendorInfo))});
    }

    public final String toString() {
        return "{.maker = " + this.maker + ", .product = " + this.product + ", .version = " + this.version + ", .serial = " + this.serial + ", .supportedIdentifierTypes = " + this.supportedIdentifierTypes + ", .vendorInfo = " + this.vendorInfo + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(96);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<Properties> readVectorFromParcel(HwParcel parcel) {
        ArrayList<Properties> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 96, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        Properties _hidl_vec_element = new Properties();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 96);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.maker = _hidl_blob.getString(_hidl_offset + 0);
        parcel.readEmbeddedBuffer(this.maker.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 0) + 0, false);
        this.product = _hidl_blob.getString(_hidl_offset + 16);
        parcel.readEmbeddedBuffer(this.product.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 16) + 0, false);
        this.version = _hidl_blob.getString(_hidl_offset + 32);
        parcel.readEmbeddedBuffer(this.version.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 32) + 0, false);
        this.serial = _hidl_blob.getString(_hidl_offset + 48);
        parcel.readEmbeddedBuffer(this.serial.getBytes().length + 1, _hidl_blob.handle(), (_hidl_offset + 48) + 0, false);
        int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 64) + 8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 4, _hidl_blob.handle(), (_hidl_offset + 64) + 0, true);
        this.supportedIdentifierTypes.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        this.supportedIdentifierTypes.add(Integer.valueOf(childBlob.getInt32(_hidl_index_0 * 4)));
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        int _hidl_vec_size2 = _hidl_blob.getInt32((_hidl_offset + 80) + 8);
        HwBlob childBlob2 = parcel.readEmbeddedBuffer(_hidl_vec_size2 * 32, _hidl_blob.handle(), (_hidl_offset + 80) + 0, true);
        this.vendorInfo.clear();
        int _hidl_index_1 = 0;
    L6:
        if (_hidl_index_1 >= _hidl_vec_size2) goto L9;
        VendorKeyValue _hidl_vec_element = new VendorKeyValue();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob2, _hidl_index_1 * 32);
        this.vendorInfo.add(_hidl_vec_element);
        _hidl_index_1 = _hidl_index_1 + 1;
        goto L6
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(96);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<Properties> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 96);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 96);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        long r2 = 0;
        _hidl_blob.putString(_hidl_offset + 0, this.maker);
        _hidl_blob.putString(_hidl_offset + 16, this.product);
        _hidl_blob.putString(_hidl_offset + 32, this.version);
        _hidl_blob.putString(_hidl_offset + 48, this.serial);
        int _hidl_vec_size = this.supportedIdentifierTypes.size();
        _hidl_blob.putInt32((_hidl_offset + 64) + 8, _hidl_vec_size);
        _hidl_blob.putBool((_hidl_offset + 64) + 12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 4);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        childBlob.putInt32(_hidl_index_0 * 4, this.supportedIdentifierTypes.get(_hidl_index_0).intValue());
        _hidl_index_0 = _hidl_index_0 + 1;
        r2 = r2;
        goto L3
    L5:
        long r16 = r2;
        _hidl_blob.putBlob((_hidl_offset + 64) + r16, childBlob);
        int _hidl_vec_size2 = this.vendorInfo.size();
        _hidl_blob.putInt32((_hidl_offset + 80) + 8, _hidl_vec_size2);
        _hidl_blob.putBool((_hidl_offset + 80) + 12, false);
        HwBlob childBlob2 = new HwBlob(_hidl_vec_size2 * 32);
        int _hidl_index_1 = 0;
    L6:
        if (_hidl_index_1 >= _hidl_vec_size2) goto L8;
        this.vendorInfo.get(_hidl_index_1).writeEmbeddedToBlob(childBlob2, _hidl_index_1 * 32);
        _hidl_index_1 = _hidl_index_1 + 1;
        goto L6
    L8:
        _hidl_blob.putBlob((_hidl_offset + 80) + r16, childBlob2);
    }
}
