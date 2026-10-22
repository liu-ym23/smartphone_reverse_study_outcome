package android.net;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class IpSecMigrateInfoParcel implements Parcelable {
    public static final Parcelable.Creator<IpSecMigrateInfoParcel> CREATOR = null;
    public final int direction;
    public final int interfaceId;
    public final String newDestinationAddress;
    public final String newSourceAddress;
    public final String oldDestinationAddress;
    public final String oldSourceAddress;
    public final int requestId;
    public final int selAddrFamily;

    public static final class Builder {
        private int direction;
        private int interfaceId;
        private String newDestinationAddress;
        private String newSourceAddress;
        private String oldDestinationAddress;
        private String oldSourceAddress;
        private int requestId;
        private int selAddrFamily;

        public Builder() {
            this.requestId = 0;
            this.selAddrFamily = 0;
            this.direction = 0;
            this.interfaceId = 0;
        }

        public Builder setRequestId(int requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder setSelAddrFamily(int selAddrFamily) {
            this.selAddrFamily = selAddrFamily;
            return this;
        }

        public Builder setDirection(int direction) {
            this.direction = direction;
            return this;
        }

        public Builder setOldSourceAddress(String oldSourceAddress) {
            this.oldSourceAddress = oldSourceAddress;
            return this;
        }

        public Builder setOldDestinationAddress(String oldDestinationAddress) {
            this.oldDestinationAddress = oldDestinationAddress;
            return this;
        }

        public Builder setNewSourceAddress(String newSourceAddress) {
            this.newSourceAddress = newSourceAddress;
            return this;
        }

        public Builder setNewDestinationAddress(String newDestinationAddress) {
            this.newDestinationAddress = newDestinationAddress;
            return this;
        }

        public Builder setInterfaceId(int interfaceId) {
            this.interfaceId = interfaceId;
            return this;
        }

        public IpSecMigrateInfoParcel build() {
            return new IpSecMigrateInfoParcel(this.requestId, this.selAddrFamily, this.direction, this.oldSourceAddress, this.oldDestinationAddress, this.newSourceAddress, this.newDestinationAddress, this.interfaceId);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sminternalCreateFromParcel, reason: not valid java name */
    static /* bridge */ /* synthetic */ IpSecMigrateInfoParcel m22$$Nest$sminternalCreateFromParcel(Parcel r0) {
        return internalCreateFromParcel(r0);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeInt(this.requestId);
        _aidl_parcel.writeInt(this.selAddrFamily);
        _aidl_parcel.writeInt(this.direction);
        _aidl_parcel.writeString(this.oldSourceAddress);
        _aidl_parcel.writeString(this.oldDestinationAddress);
        _aidl_parcel.writeString(this.newSourceAddress);
        _aidl_parcel.writeString(this.newDestinationAddress);
        _aidl_parcel.writeInt(this.interfaceId);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public IpSecMigrateInfoParcel(int requestId, int selAddrFamily, int direction, String oldSourceAddress, String oldDestinationAddress, String newSourceAddress, String newDestinationAddress, int interfaceId) {
        this.requestId = requestId;
        this.selAddrFamily = selAddrFamily;
        this.direction = direction;
        this.oldSourceAddress = oldSourceAddress;
        this.oldDestinationAddress = oldDestinationAddress;
        this.newSourceAddress = newSourceAddress;
        this.newDestinationAddress = newDestinationAddress;
        this.interfaceId = interfaceId;
    }

    private static IpSecMigrateInfoParcel internalCreateFromParcel(Parcel _aidl_parcel) {
        Builder _aidl_parcelable_builder = new Builder();
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L85;
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
        int _aidl_temp_requestId = _aidl_parcel.readInt();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setRequestId(_aidl_temp_requestId);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L24;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L23;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L23:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L24:
        int _aidl_temp_selAddrFamily = _aidl_parcel.readInt();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setSelAddrFamily(_aidl_temp_selAddrFamily);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L33;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L32;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L32:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L33:
        int _aidl_temp_direction = _aidl_parcel.readInt();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setDirection(_aidl_temp_direction);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L42;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L41;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L41:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L42:
        String _aidl_temp_oldSourceAddress = _aidl_parcel.readString();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setOldSourceAddress(_aidl_temp_oldSourceAddress);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L51;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L50;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L50:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L51:
        String _aidl_temp_oldDestinationAddress = _aidl_parcel.readString();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setOldDestinationAddress(_aidl_temp_oldDestinationAddress);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L60;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L59;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L59:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L60:
        String _aidl_temp_newSourceAddress = _aidl_parcel.readString();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setNewSourceAddress(_aidl_temp_newSourceAddress);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L69;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L68;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L68:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L69:
        String _aidl_temp_newDestinationAddress = _aidl_parcel.readString();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setNewDestinationAddress(_aidl_temp_newDestinationAddress);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L78;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L77;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L77:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L78:
        int _aidl_temp_interfaceId = _aidl_parcel.readInt();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setInterfaceId(_aidl_temp_interfaceId);     // Catch: Throwable -> L13
        if (_aidl_start_pos <= (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L85:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L13
    L87:
        if (_aidl_start_pos <= (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
