package android.net;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class Layer2PacketParcelable implements Parcelable {
    public static final Parcelable.Creator<Layer2PacketParcelable> CREATOR = null;
    public MacAddress dstMacAddress;
    public byte[] payload;

    public Layer2PacketParcelable() {
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeTypedObject(this.dstMacAddress, _aidl_flag);
        _aidl_parcel.writeByteArray(this.payload);
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
        this.dstMacAddress = (MacAddress) _aidl_parcel.readTypedObject(MacAddress.CREATOR);     // Catch: Throwable -> L29
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.payload = _aidl_parcel.createByteArray();     // Catch: Throwable -> L29
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

    public String toString() {
        StringJoiner _aidl_sj = new StringJoiner(", ", "{", "}");
        _aidl_sj.add("dstMacAddress: " + Objects.toString(this.dstMacAddress));
        _aidl_sj.add("payload: " + Arrays.toString(this.payload));
        return "Layer2PacketParcelable" + _aidl_sj.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        int _mask = 0 | describeContents(this.dstMacAddress);
        return _mask;
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
