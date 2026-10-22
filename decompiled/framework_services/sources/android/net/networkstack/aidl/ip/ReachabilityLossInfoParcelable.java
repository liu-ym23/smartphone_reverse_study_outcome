package android.net.networkstack.aidl.ip;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class ReachabilityLossInfoParcelable implements Parcelable {
    public static final Parcelable.Creator<ReachabilityLossInfoParcelable> CREATOR = null;
    public final String message;
    public final int reason;

    public static final class Builder {
        private String message;
        private int reason;

        public Builder() {
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setReason(int reason) {
            this.reason = reason;
            return this;
        }

        public ReachabilityLossInfoParcelable build() {
            return new ReachabilityLossInfoParcelable(this.message, this.reason);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sminternalCreateFromParcel, reason: not valid java name */
    static /* bridge */ /* synthetic */ ReachabilityLossInfoParcelable m38$$Nest$sminternalCreateFromParcel(Parcel r0) {
        return internalCreateFromParcel(r0);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeString(this.message);
        _aidl_parcel.writeInt(this.reason);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public ReachabilityLossInfoParcelable(String message, int reason) {
        this.message = message;
        this.reason = reason;
    }

    private static ReachabilityLossInfoParcelable internalCreateFromParcel(Parcel _aidl_parcel) {
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
        String _aidl_temp_message = _aidl_parcel.readString();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setMessage(_aidl_temp_message);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L24;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L23;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L23:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L24:
        int _aidl_temp_reason = _aidl_parcel.readInt();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setReason(_aidl_temp_reason);     // Catch: Throwable -> L13
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
        _aidl_sj.add("message: " + Objects.toString(this.message));
        _aidl_sj.add("reason: " + this.reason);
        return "ReachabilityLossInfoParcelable" + _aidl_sj.toString();
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L9;
        return false;
    L9:
        if ((other instanceof ReachabilityLossInfoParcelable) == true) goto L11;
        return false;
    L11:
        ReachabilityLossInfoParcelable that = (ReachabilityLossInfoParcelable) other;
        if (Objects.deepEquals(this.message, that.message) == true) goto L15;
        return false;
    L15:
        if (Objects.deepEquals(Integer.valueOf(this.reason), Integer.valueOf(that.reason)) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return Arrays.deepHashCode(Arrays.asList(new Serializable[]{this.message, Integer.valueOf(this.reason)}).toArray());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
