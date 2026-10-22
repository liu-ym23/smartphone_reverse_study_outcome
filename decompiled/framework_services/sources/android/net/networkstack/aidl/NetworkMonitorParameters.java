package android.net.networkstack.aidl;

import android.net.LinkProperties;
import android.net.NetworkAgentConfig;
import android.net.NetworkCapabilities;
import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class NetworkMonitorParameters implements Parcelable {
    public static final Parcelable.Creator<NetworkMonitorParameters> CREATOR = null;
    public LinkProperties linkProperties;
    public NetworkAgentConfig networkAgentConfig;
    public NetworkCapabilities networkCapabilities;

    public NetworkMonitorParameters() {
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeTypedObject(this.networkAgentConfig, _aidl_flag);
        _aidl_parcel.writeTypedObject(this.networkCapabilities, _aidl_flag);
        _aidl_parcel.writeTypedObject(this.linkProperties, _aidl_flag);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L41;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.networkAgentConfig = (NetworkAgentConfig) _aidl_parcel.readTypedObject(NetworkAgentConfig.CREATOR);     // Catch: Throwable -> L38
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.networkCapabilities = (NetworkCapabilities) _aidl_parcel.readTypedObject(NetworkCapabilities.CREATOR);     // Catch: Throwable -> L38
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
        this.linkProperties = (LinkProperties) _aidl_parcel.readTypedObject(LinkProperties.CREATOR);     // Catch: Throwable -> L38
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L37;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L37:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L26:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L30;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L30:
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
    L41:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L45;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L45:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    public String toString() {
        StringJoiner _aidl_sj = new StringJoiner(", ", "{", "}");
        _aidl_sj.add("networkAgentConfig: " + Objects.toString(this.networkAgentConfig));
        _aidl_sj.add("networkCapabilities: " + Objects.toString(this.networkCapabilities));
        _aidl_sj.add("linkProperties: " + Objects.toString(this.linkProperties));
        return "NetworkMonitorParameters" + _aidl_sj.toString();
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L9;
        return false;
    L9:
        if ((other instanceof NetworkMonitorParameters) == true) goto L11;
        return false;
    L11:
        NetworkMonitorParameters that = (NetworkMonitorParameters) other;
        if (Objects.deepEquals(this.networkAgentConfig, that.networkAgentConfig) == true) goto L15;
        return false;
    L15:
        if (Objects.deepEquals(this.networkCapabilities, that.networkCapabilities) == true) goto L18;
        return false;
    L18:
        if (Objects.deepEquals(this.linkProperties, that.linkProperties) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return Arrays.deepHashCode(Arrays.asList(new Parcelable[]{this.networkAgentConfig, this.networkCapabilities, this.linkProperties}).toArray());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        int _mask = 0 | describeContents(this.networkAgentConfig);
        return (_mask | describeContents(this.networkCapabilities)) | describeContents(this.linkProperties);
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
