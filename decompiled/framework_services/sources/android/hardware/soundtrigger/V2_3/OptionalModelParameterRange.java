package android.hardware.soundtrigger.V2_3;

import android.hidl.safe_union.V1_0.Monostate;
import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class OptionalModelParameterRange {
    private byte hidl_d;
    private Object hidl_o;

    public static final class hidl_discriminator {
        public static final byte noinit = 0;
        public static final byte range = 1;

        public static final String getName(byte value) {
            switch(value) {
                case 0: goto L7;
                case 1: goto L5;
                default: goto L3;
            };
        L3:
            return "Unknown";
        L5:
            return "range";
        L7:
            return "noinit";
        }

        private hidl_discriminator() {
        }
    }

    public OptionalModelParameterRange() {
        this.hidl_d = 0;
        this.hidl_o = null;
        this.hidl_o = new Monostate();
    }

    public void noinit(Monostate noinit) {
        this.hidl_d = 0;
        this.hidl_o = noinit;
    }

    public Monostate noinit() {
        if (this.hidl_d == 0) goto L11;
        if (this.hidl_o == null) goto L7;
        String className = this.hidl_o.getClass().getName();
    L9:
        throw new IllegalStateException("Read access to inactive union components is disallowed. Discriminator value is " + this.hidl_d + " (corresponding to " + hidl_discriminator.getName(this.hidl_d) + "), and hidl_o is of type " + className + ".");
    L7:
        className = "null";
        goto L9
    L11:
        if (this.hidl_o == null) goto L18;
        if (Monostate.class.isInstance(this.hidl_o) == true) goto L18;
        throw new Error("Union is in a corrupted state.");
    L18:
        return (Monostate) this.hidl_o;
    }

    public void range(ModelParameterRange range) {
        this.hidl_d = 1;
        this.hidl_o = range;
    }

    public ModelParameterRange range() {
        if (this.hidl_d == 1) goto L11;
        if (this.hidl_o == null) goto L7;
        String className = this.hidl_o.getClass().getName();
    L9:
        throw new IllegalStateException("Read access to inactive union components is disallowed. Discriminator value is " + this.hidl_d + " (corresponding to " + hidl_discriminator.getName(this.hidl_d) + "), and hidl_o is of type " + className + ".");
    L7:
        className = "null";
        goto L9
    L11:
        if (this.hidl_o == null) goto L18;
        if (ModelParameterRange.class.isInstance(this.hidl_o) == true) goto L18;
        throw new Error("Union is in a corrupted state.");
    L18:
        return (ModelParameterRange) this.hidl_o;
    }

    public byte getDiscriminator() {
        return this.hidl_d;
    }

    public final boolean equals(Object otherObject) {
        if (this != otherObject) goto L6;
        return true;
    L6:
        if (otherObject != null) goto L9;
        return false;
    L9:
        if (otherObject.getClass() == OptionalModelParameterRange.class) goto L11;
        return false;
    L11:
        OptionalModelParameterRange other = (OptionalModelParameterRange) otherObject;
        if (this.hidl_d == other.hidl_d) goto L15;
        return false;
    L15:
        if (HidlSupport.deepEquals(this.hidl_o, other.hidl_o) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(HidlSupport.deepHashCode(this.hidl_o)), Integer.valueOf(Objects.hashCode(Byte.valueOf(this.hidl_d)))});
    }

    public final String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        switch(this.hidl_d) {
            case 0: goto L7;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        builder.append(".range = ");
        builder.append(range());
    L8:
        builder.append("}");
        return builder.toString();
    L7:
        builder.append(".noinit = ");
        builder.append(noinit());
        goto L8
    L5:
        throw new Error("Unknown union discriminator (value: " + this.hidl_d + ").");
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(12);
        readEmbeddedFromParcel(parcel, blob, 0);
    }

    public static final ArrayList<OptionalModelParameterRange> readVectorFromParcel(HwParcel parcel) {
        ArrayList<OptionalModelParameterRange> _hidl_vec = new ArrayList();
        HwBlob _hidl_blob = parcel.readBuffer(16);
        int _hidl_vec_size = _hidl_blob.getInt32(8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 12, _hidl_blob.handle(), 0, true);
        _hidl_vec.clear();
        int _hidl_index_0 = 0;
    L3:
        if (_hidl_index_0 >= _hidl_vec_size) goto L6;
        OptionalModelParameterRange _hidl_vec_element = new OptionalModelParameterRange();
        _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 12);
        _hidl_vec.add(_hidl_vec_element);
        _hidl_index_0 = _hidl_index_0 + 1;
        goto L3
    L6:
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.hidl_d = _hidl_blob.getInt8(0 + _hidl_offset);
        switch(this.hidl_d) {
            case 0: goto L7;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        this.hidl_o = new ModelParameterRange();
        ((ModelParameterRange) this.hidl_o).readEmbeddedFromParcel(parcel, _hidl_blob, 4 + _hidl_offset);
        return;
    L7:
        this.hidl_o = new Monostate();
        ((Monostate) this.hidl_o).readEmbeddedFromParcel(parcel, _hidl_blob, 4 + _hidl_offset);
        return;
    L5:
        throw new IllegalStateException("Unknown union discriminator (value: " + this.hidl_d + ").");
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(12);
        writeEmbeddedToBlob(_hidl_blob, 0);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<OptionalModelParameterRange> _hidl_vec) {
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
        _hidl_blob.putInt8(0 + _hidl_offset, this.hidl_d);
        switch(this.hidl_d) {
            case 0: goto L7;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        range().writeEmbeddedToBlob(_hidl_blob, 4 + _hidl_offset);
        return;
    L7:
        noinit().writeEmbeddedToBlob(_hidl_blob, 4 + _hidl_offset);
        return;
    L5:
        throw new Error("Unknown union discriminator (value: " + this.hidl_d + ").");
    }
}
