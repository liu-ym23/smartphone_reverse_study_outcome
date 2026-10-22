package android.net;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class UidRangeParcel implements Parcelable {
    public static final Parcelable.Creator<UidRangeParcel> CREATOR = null;
    public final int start;
    public final int stop;

    public static final class Builder {
        private int start;
        private int stop;

        public Builder() {
            this.start = 0;
            this.stop = 0;
        }

        public Builder setStart(int start) {
            this.start = start;
            return this;
        }

        public Builder setStop(int stop) {
            this.stop = stop;
            return this;
        }

        public UidRangeParcel build() {
            return new UidRangeParcel(this.start, this.stop);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sminternalCreateFromParcel, reason: not valid java name */
    static /* bridge */ /* synthetic */ UidRangeParcel m31$$Nest$sminternalCreateFromParcel(Parcel r0) {
        return internalCreateFromParcel(r0);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeInt(this.start);
        _aidl_parcel.writeInt(this.stop);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public UidRangeParcel(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    private static UidRangeParcel internalCreateFromParcel(Parcel _aidl_parcel) {
        Builder _aidl_parcelable_builder = new Builder();
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L31;
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
        int _aidl_temp_start = _aidl_parcel.readInt();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setStart(_aidl_temp_start);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L24;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L23;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L23:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L24:
        int _aidl_temp_stop = _aidl_parcel.readInt();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setStop(_aidl_temp_stop);     // Catch: Throwable -> L13
        if (_aidl_start_pos <= (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L31:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L13
    L33:
        if (_aidl_start_pos <= (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    public String toString() {
        StringJoiner _aidl_sj = new StringJoiner(", ", "{", "}");
        _aidl_sj.add("start: " + this.start);
        _aidl_sj.add("stop: " + this.stop);
        return "UidRangeParcel" + _aidl_sj.toString();
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L9;
        return false;
    L9:
        if ((other instanceof UidRangeParcel) == true) goto L11;
        return false;
    L11:
        UidRangeParcel that = (UidRangeParcel) other;
        if (Objects.deepEquals(Integer.valueOf(this.start), Integer.valueOf(that.start)) == true) goto L15;
        return false;
    L15:
        if (Objects.deepEquals(Integer.valueOf(this.stop), Integer.valueOf(that.stop)) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return Arrays.deepHashCode(Arrays.asList(new Integer[]{Integer.valueOf(this.start), Integer.valueOf(this.stop)}).toArray());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
