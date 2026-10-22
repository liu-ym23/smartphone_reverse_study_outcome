package android.hardware.soundtrigger.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class PhraseRecognitionExtra {
    public int confidenceLevel;
    public int id;
    public ArrayList<ConfidenceLevel> levels;
    public int recognitionModes;

    public PhraseRecognitionExtra() {
        this.id = 0;
        this.recognitionModes = 0;
        this.confidenceLevel = 0;
        this.levels = new ArrayList();
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == PhraseRecognitionExtra.class) goto L11;
        return false;
    L11:
        PhraseRecognitionExtra other = (PhraseRecognitionExtra) otherObject;
        if (this.id == other.id) goto L15;
        return false;
    L15:
        if (this.recognitionModes == other.recognitionModes) goto L18;
        return false;
    L18:
        if (this.confidenceLevel == other.confidenceLevel) goto L21;
        return false;
    L21:
        if (HidlSupport.deepEquals(this.levels, other.levels) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.id))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.recognitionModes))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.confidenceLevel))), Integer.valueOf(HidlSupport.deepHashCode(this.levels))});
    }

    public final String toString() {
        return "{.id = " + this.id + ", .recognitionModes = " + this.recognitionModes + ", .confidenceLevel = " + this.confidenceLevel + ", .levels = " + this.levels + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(32);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<PhraseRecognitionExtra> readVectorFromParcel(HwParcel parcel) {
        ArrayList<PhraseRecognitionExtra> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 32, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        PhraseRecognitionExtra _hidl_vec_element = new PhraseRecognitionExtra();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 32);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.id = _hidl_blob.getInt32(_hidl_offset + 0);
        this.recognitionModes = _hidl_blob.getInt32(_hidl_offset + 4);
        this.confidenceLevel = _hidl_blob.getInt32(_hidl_offset + 8);
        int _hidl_vec_size = _hidl_blob.getInt32((_hidl_offset + 16) + 8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 8, _hidl_blob.handle(), (_hidl_offset + 16) + 0, true);
        this.levels.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        ConfidenceLevel _hidl_vec_element = new ConfidenceLevel();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 8);
        this.levels.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(32);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<PhraseRecognitionExtra> _hidl_vec) {
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
        _hidl_blob.putInt32(_hidl_offset + 0, this.id);
        _hidl_blob.putInt32(4 + _hidl_offset, this.recognitionModes);
        _hidl_blob.putInt32(_hidl_offset + 8, this.confidenceLevel);
        int _hidl_vec_size = this.levels.size();
        _hidl_blob.putInt32((_hidl_offset + 16) + 8, _hidl_vec_size);
        _hidl_blob.putBool((_hidl_offset + 16) + 12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 8);
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L5;
        this.levels.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 8);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L5:
        _hidl_blob.putBlob((16 + _hidl_offset) + 0, childBlob);
    }
}
