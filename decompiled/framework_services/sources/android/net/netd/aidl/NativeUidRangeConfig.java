package android.net.netd.aidl;

import android.net.UidRangeParcel;
import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class NativeUidRangeConfig implements Parcelable {
    public static final Parcelable.Creator<NativeUidRangeConfig> CREATOR = null;
    public final int netId;
    public final int subPriority;
    public final UidRangeParcel[] uidRanges;

    public static final class Builder {
        private int netId;
        private int subPriority;
        private UidRangeParcel[] uidRanges;

        public Builder() {
            this.netId = 0;
            this.subPriority = 0;
        }

        public Builder setNetId(int netId) {
            this.netId = netId;
            return this;
        }

        public Builder setUidRanges(UidRangeParcel[] uidRanges) {
            this.uidRanges = uidRanges;
            return this;
        }

        public Builder setSubPriority(int subPriority) {
            this.subPriority = subPriority;
            return this;
        }

        public NativeUidRangeConfig build() {
            return new NativeUidRangeConfig(this.netId, this.uidRanges, this.subPriority);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sminternalCreateFromParcel, reason: not valid java name */
    static /* bridge */ /* synthetic */ NativeUidRangeConfig m34$$Nest$sminternalCreateFromParcel(Parcel r0) {
        return internalCreateFromParcel(r0);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeInt(this.netId);
        _aidl_parcel.writeTypedArray(this.uidRanges, _aidl_flag);
        _aidl_parcel.writeInt(this.subPriority);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public NativeUidRangeConfig(int netId, UidRangeParcel[] uidRanges, int subPriority) {
        this.netId = netId;
        this.uidRanges = uidRanges;
        this.subPriority = subPriority;
    }

    private static NativeUidRangeConfig internalCreateFromParcel(Parcel _aidl_parcel) {
        Builder _aidl_parcelable_builder = new Builder();
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L40;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L15;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L12;
    L9:
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L12:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L15:
        int _aidl_temp_netId = _aidl_parcel.readInt();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setNetId(_aidl_temp_netId);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L24;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L23;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L23:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L24:
        UidRangeParcel[] _aidl_temp_uidRanges = (UidRangeParcel[]) _aidl_parcel.createTypedArray(UidRangeParcel.CREATOR);     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setUidRanges(_aidl_temp_uidRanges);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L33;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L32;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L32:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L33:
        int _aidl_temp_subPriority = _aidl_parcel.readInt();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setSubPriority(_aidl_temp_subPriority);     // Catch: Throwable -> L13
        if (_aidl_start_pos <= (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L40:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L13
    L42:
        if (_aidl_start_pos <= (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    public String toString() {
        StringJoiner _aidl_sj = new StringJoiner(", ", "{", "}");
        _aidl_sj.add("netId: " + this.netId);
        _aidl_sj.add("uidRanges: " + Arrays.toString(this.uidRanges));
        _aidl_sj.add("subPriority: " + this.subPriority);
        return "NativeUidRangeConfig" + _aidl_sj.toString();
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L9;
        return false;
    L9:
        if ((other instanceof NativeUidRangeConfig) == true) goto L11;
        return false;
    L11:
        NativeUidRangeConfig that = (NativeUidRangeConfig) other;
        if (Objects.deepEquals(Integer.valueOf(this.netId), Integer.valueOf(that.netId)) == true) goto L15;
        return false;
    L15:
        if (Objects.deepEquals(this.uidRanges, that.uidRanges) == true) goto L18;
        return false;
    L18:
        if (Objects.deepEquals(Integer.valueOf(this.subPriority), Integer.valueOf(that.subPriority)) == true) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        return Arrays.deepHashCode(Arrays.asList(new Serializable[]{Integer.valueOf(this.netId), this.uidRanges, Integer.valueOf(this.subPriority)}).toArray());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        int _mask = 0 | describeContents(this.uidRanges);
        return _mask;
    }

    private int describeContents(Object _v) {
        int r0 = 0;
        if (_v != null) goto L6;
        return 0;
    L6:
        if ((_v instanceof Object[]) == false) goto L12;
        int _mask = 0;
        Object[] r2 = (Object[]) _v;
        int r3 = r2.length;
    L8:
        if (r0 >= r3) goto L10;
        Object o = r2[r0];
        _mask = _mask | describeContents(o);
        r0 = r0 + 1;
        goto L8
    L10:
        return _mask;
    L12:
        if ((_v instanceof Parcelable) == true) goto L14;
        return 0;
    L14:
        return ((Parcelable) _v).describeContents();
    }
}
