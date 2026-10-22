package android.net;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class NativeNetworkConfig implements Parcelable {
    public static final Parcelable.Creator<NativeNetworkConfig> CREATOR = null;
    public final boolean excludeLocalRoutes;
    public final int netId;
    public final int networkType;
    public final int permission;
    public final boolean secure;
    public final int vpnType;

    public static final class Builder {
        private boolean excludeLocalRoutes;
        private int netId;
        private int networkType;
        private int permission;
        private boolean secure;
        private int vpnType;

        public Builder() {
            this.netId = 0;
            this.networkType = 0;
            this.permission = 0;
            this.secure = false;
            this.vpnType = 2;
            this.excludeLocalRoutes = false;
        }

        public Builder setNetId(int netId) {
            this.netId = netId;
            return this;
        }

        public Builder setNetworkType(int networkType) {
            this.networkType = networkType;
            return this;
        }

        public Builder setPermission(int permission) {
            this.permission = permission;
            return this;
        }

        public Builder setSecure(boolean secure) {
            this.secure = secure;
            return this;
        }

        public Builder setVpnType(int vpnType) {
            this.vpnType = vpnType;
            return this;
        }

        public Builder setExcludeLocalRoutes(boolean excludeLocalRoutes) {
            this.excludeLocalRoutes = excludeLocalRoutes;
            return this;
        }

        public NativeNetworkConfig build() {
            return new NativeNetworkConfig(this.netId, this.networkType, this.permission, this.secure, this.vpnType, this.excludeLocalRoutes);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sminternalCreateFromParcel, reason: not valid java name */
    static /* bridge */ /* synthetic */ NativeNetworkConfig m23$$Nest$sminternalCreateFromParcel(Parcel r0) {
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
        _aidl_parcel.writeInt(this.networkType);
        _aidl_parcel.writeInt(this.permission);
        _aidl_parcel.writeBoolean(this.secure);
        _aidl_parcel.writeInt(this.vpnType);
        _aidl_parcel.writeBoolean(this.excludeLocalRoutes);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public NativeNetworkConfig(int netId, int networkType, int permission, boolean secure, int vpnType, boolean excludeLocalRoutes) {
        this.netId = netId;
        this.networkType = networkType;
        this.permission = permission;
        this.secure = secure;
        this.vpnType = vpnType;
        this.excludeLocalRoutes = excludeLocalRoutes;
    }

    private static NativeNetworkConfig internalCreateFromParcel(Parcel _aidl_parcel) {
        Builder _aidl_parcelable_builder = new Builder();
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L67;
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
        int _aidl_temp_networkType = _aidl_parcel.readInt();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setNetworkType(_aidl_temp_networkType);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L33;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L32;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L32:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L33:
        int _aidl_temp_permission = _aidl_parcel.readInt();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setPermission(_aidl_temp_permission);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L42;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L41;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L41:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L42:
        boolean _aidl_temp_secure = _aidl_parcel.readBoolean();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setSecure(_aidl_temp_secure);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L51;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L50;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L50:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L51:
        int _aidl_temp_vpnType = _aidl_parcel.readInt();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setVpnType(_aidl_temp_vpnType);     // Catch: Throwable -> L13
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) < _aidl_parcelable_size) goto L60;
        _aidl_parcelable_builder.build();     // Catch: Throwable -> L13
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L59;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return _aidl_parcelable_builder.build();
    L59:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L60:
        boolean _aidl_temp_excludeLocalRoutes = _aidl_parcel.readBoolean();     // Catch: Throwable -> L13
        _aidl_parcelable_builder.setExcludeLocalRoutes(_aidl_temp_excludeLocalRoutes);     // Catch: Throwable -> L13
        if (_aidl_start_pos <= (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L67:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L13
    L69:
        if (_aidl_start_pos <= (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    public String toString() {
        StringJoiner _aidl_sj = new StringJoiner(", ", "{", "}");
        _aidl_sj.add("netId: " + this.netId);
        _aidl_sj.add("networkType: " + this.networkType);
        _aidl_sj.add("permission: " + this.permission);
        _aidl_sj.add("secure: " + this.secure);
        _aidl_sj.add("vpnType: " + this.vpnType);
        _aidl_sj.add("excludeLocalRoutes: " + this.excludeLocalRoutes);
        return "NativeNetworkConfig" + _aidl_sj.toString();
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L9;
        return false;
    L9:
        if ((other instanceof NativeNetworkConfig) == true) goto L11;
        return false;
    L11:
        NativeNetworkConfig that = (NativeNetworkConfig) other;
        if (Objects.deepEquals(Integer.valueOf(this.netId), Integer.valueOf(that.netId)) == true) goto L15;
        return false;
    L15:
        if (Objects.deepEquals(Integer.valueOf(this.networkType), Integer.valueOf(that.networkType)) == true) goto L18;
        return false;
    L18:
        if (Objects.deepEquals(Integer.valueOf(this.permission), Integer.valueOf(that.permission)) == true) goto L21;
        return false;
    L21:
        if (Objects.deepEquals(Boolean.valueOf(this.secure), Boolean.valueOf(that.secure)) == true) goto L24;
        return false;
    L24:
        if (Objects.deepEquals(Integer.valueOf(this.vpnType), Integer.valueOf(that.vpnType)) == true) goto L27;
        return false;
    L27:
        if (Objects.deepEquals(Boolean.valueOf(this.excludeLocalRoutes), Boolean.valueOf(that.excludeLocalRoutes)) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return Arrays.deepHashCode(Arrays.asList(new Serializable[]{Integer.valueOf(this.netId), Integer.valueOf(this.networkType), Integer.valueOf(this.permission), Boolean.valueOf(this.secure), Integer.valueOf(this.vpnType), Boolean.valueOf(this.excludeLocalRoutes)}).toArray());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
