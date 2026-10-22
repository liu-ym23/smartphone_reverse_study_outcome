package android.hardware.tv.mediaquality;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ParcelableHolder;

/* JADX INFO: loaded from: classes.dex */
public class ParameterRange implements Parcelable {
    public static final Parcelable.Creator<ParameterRange> CREATOR = null;
    public NumberRange numRange;
    public final ParcelableHolder vendorDefinedValues;

    public ParameterRange() {
        this.vendorDefinedValues = new ParcelableHolder(1);
    }

    public final int getStability() {
        return 1;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeTypedObject(this.numRange, _aidl_flag);
        _aidl_parcel.writeTypedObject(this.vendorDefinedValues, 0);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L35;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.numRange = (NumberRange) _aidl_parcel.readTypedObject(NumberRange.CREATOR);     // Catch: Throwable -> L26
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L23;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L21;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L21:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L23:
        if (_aidl_parcel.readInt() == 0) goto L29;
        this.vendorDefinedValues.readFromParcel(_aidl_parcel);     // Catch: Throwable -> L26
    L29:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L33;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L33:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L12;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L12:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L35:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L39;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L39:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        int _mask = 0 | describeContents(this.numRange);
        return _mask | describeContents(this.vendorDefinedValues);
    }

    private int describeContents(Object _v) {
        if (_v != null) goto L6;
        return 0;
    L6:
        if ((_v instanceof Parcelable) == true) goto L8;
        return 0;
    L8:
        return ((Parcelable) _v).describeContents();
    }
}
