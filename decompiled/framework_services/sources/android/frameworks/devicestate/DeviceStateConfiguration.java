package android.frameworks.devicestate;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class DeviceStateConfiguration implements Parcelable {
    public static final Parcelable.Creator<DeviceStateConfiguration> CREATOR = null;
    public long deviceProperties;

    public @interface DeviceStatePropertyValue {
        public static final long FEATURE_DUAL_DISPLAY = 64;
        public static final long FEATURE_REAR_DISPLAY = 32;
        public static final long FOLDABLE_DISPLAY_CONFIGURATION_INNER_PRIMARY = 16;
        public static final long FOLDABLE_DISPLAY_CONFIGURATION_OUTER_PRIMARY = 8;
        public static final long FOLDABLE_HARDWARE_CONFIGURATION_FOLD_IN_CLOSED = 1;
        public static final long FOLDABLE_HARDWARE_CONFIGURATION_FOLD_IN_HALF_OPEN = 2;
        public static final long FOLDABLE_HARDWARE_CONFIGURATION_FOLD_IN_OPEN = 4;
    }

    public DeviceStateConfiguration() {
        this.deviceProperties = 0;
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
        _aidl_parcel.writeLong(this.deviceProperties);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L23;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.deviceProperties = _aidl_parcel.readLong();     // Catch: Throwable -> L20
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L19;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L19:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L12;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L12:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L23:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L27;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L27:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
