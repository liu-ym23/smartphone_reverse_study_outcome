package android.hardware.power.stats;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class State implements Parcelable {
    public static final Parcelable.Creator<State> CREATOR = null;
    public int id;
    public String name;

    public State() {
        this.id = 0;
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
        _aidl_parcel.writeInt(this.id);
        _aidl_parcel.writeString(this.name);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L32;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.id = _aidl_parcel.readInt();     // Catch: Throwable -> L29
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.name = _aidl_parcel.readString();     // Catch: Throwable -> L29
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L28;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L28:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L17:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L21;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L21:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L12;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L12:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L32:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L36;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L36:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
