package android.hardware.usb.V1_2;

import android.hardware.usb.V1_1.PortStatus_1_1;
import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class PortStatus {
    public int contaminantDetectionStatus;
    public int contaminantProtectionStatus;
    public PortStatus_1_1 status_1_1;
    public int supportedContaminantProtectionModes;
    public boolean supportsEnableContaminantPresenceDetection;
    public boolean supportsEnableContaminantPresenceProtection;

    public PortStatus() {
        this.status_1_1 = new PortStatus_1_1();
        this.supportsEnableContaminantPresenceProtection = false;
        this.contaminantProtectionStatus = 0;
        this.supportsEnableContaminantPresenceDetection = false;
        this.contaminantDetectionStatus = 0;
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == PortStatus.class) goto L11;
        return false;
    L11:
        PortStatus other = (PortStatus) otherObject;
        if (HidlSupport.deepEquals(this.status_1_1, other.status_1_1) == true) goto L15;
        return false;
    L15:
        if (HidlSupport.deepEquals(Integer.valueOf(this.supportedContaminantProtectionModes), Integer.valueOf(other.supportedContaminantProtectionModes)) == true) goto L18;
        return false;
    L18:
        if (this.supportsEnableContaminantPresenceProtection == other.supportsEnableContaminantPresenceProtection) goto L21;
        return false;
    L21:
        if (this.contaminantProtectionStatus == other.contaminantProtectionStatus) goto L24;
        return false;
    L24:
        if (this.supportsEnableContaminantPresenceDetection == other.supportsEnableContaminantPresenceDetection) goto L27;
        return false;
    L27:
        if (this.contaminantDetectionStatus == other.contaminantDetectionStatus) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.status_1_1)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.supportedContaminantProtectionModes))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.supportsEnableContaminantPresenceProtection))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.contaminantProtectionStatus))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.supportsEnableContaminantPresenceDetection))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.contaminantDetectionStatus)))});
    }

    public final String toString() {
        return "{.status_1_1 = " + this.status_1_1 + ", .supportedContaminantProtectionModes = " + ContaminantProtectionMode.dumpBitfield(this.supportedContaminantProtectionModes) + ", .supportsEnableContaminantPresenceProtection = " + this.supportsEnableContaminantPresenceProtection + ", .contaminantProtectionStatus = " + ContaminantProtectionStatus.toString(this.contaminantProtectionStatus) + ", .supportsEnableContaminantPresenceDetection = " + this.supportsEnableContaminantPresenceDetection + ", .contaminantDetectionStatus = " + ContaminantDetectionStatus.toString(this.contaminantDetectionStatus) + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(72);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<PortStatus> readVectorFromParcel(HwParcel parcel) {
        ArrayList<PortStatus> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 72, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        PortStatus _hidl_vec_element = new PortStatus();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 72);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.status_1_1.readEmbeddedFromParcel(parcel, _hidl_blob, 0 + _hidl_offset);
        this.supportedContaminantProtectionModes = _hidl_blob.getInt32(48 + _hidl_offset);
        this.supportsEnableContaminantPresenceProtection = _hidl_blob.getBool(52 + _hidl_offset);
        this.contaminantProtectionStatus = _hidl_blob.getInt32(56 + _hidl_offset);
        this.supportsEnableContaminantPresenceDetection = _hidl_blob.getBool(60 + _hidl_offset);
        this.contaminantDetectionStatus = _hidl_blob.getInt32(64 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(72);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<PortStatus> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8, _hidl_vec_size);
        _hidl_blob.putBool(12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 72);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 72);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob(0, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        this.status_1_1.writeEmbeddedToBlob(_hidl_blob, 0 + _hidl_offset);
        _hidl_blob.putInt32(48 + _hidl_offset, this.supportedContaminantProtectionModes);
        _hidl_blob.putBool(52 + _hidl_offset, this.supportsEnableContaminantPresenceProtection);
        _hidl_blob.putInt32(56 + _hidl_offset, this.contaminantProtectionStatus);
        _hidl_blob.putBool(60 + _hidl_offset, this.supportsEnableContaminantPresenceDetection);
        _hidl_blob.putInt32(64 + _hidl_offset, this.contaminantDetectionStatus);
    }
}
