package android.net;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class DhcpResultsParcelable implements Parcelable {
    public static final Parcelable.Creator<DhcpResultsParcelable> CREATOR = null;
    public StaticIpConfiguration baseConfiguration;
    public String captivePortalApiUrl;
    public int leaseDuration;
    public int mtu;
    public String serverAddress;
    public String serverHostName;
    public String vendorInfo;

    public DhcpResultsParcelable() {
        this.leaseDuration = 0;
        this.mtu = 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeTypedObject(this.baseConfiguration, _aidl_flag);
        _aidl_parcel.writeInt(this.leaseDuration);
        _aidl_parcel.writeInt(this.mtu);
        _aidl_parcel.writeString(this.serverAddress);
        _aidl_parcel.writeString(this.vendorInfo);
        _aidl_parcel.writeString(this.serverHostName);
        _aidl_parcel.writeString(this.captivePortalApiUrl);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L77;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.baseConfiguration = (StaticIpConfiguration) _aidl_parcel.readTypedObject(StaticIpConfiguration.CREATOR);     // Catch: Throwable -> L74
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.leaseDuration = _aidl_parcel.readInt();     // Catch: Throwable -> L74
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
        this.mtu = _aidl_parcel.readInt();     // Catch: Throwable -> L74
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
        this.serverAddress = _aidl_parcel.readString();     // Catch: Throwable -> L74
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
        this.vendorInfo = _aidl_parcel.readString();     // Catch: Throwable -> L74
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L53;
        this.serverHostName = _aidl_parcel.readString();     // Catch: Throwable -> L74
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L62;
        this.captivePortalApiUrl = _aidl_parcel.readString();     // Catch: Throwable -> L74
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L73;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L73:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L62:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L66;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L66:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L53:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L57;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L57:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L44:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L48;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L48:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L35:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L39;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L39:
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
    L77:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L81;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L81:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    public String toString() {
        StringJoiner _aidl_sj = new StringJoiner(", ", "{", "}");
        _aidl_sj.add("baseConfiguration: " + Objects.toString(this.baseConfiguration));
        _aidl_sj.add("leaseDuration: " + this.leaseDuration);
        _aidl_sj.add("mtu: " + this.mtu);
        _aidl_sj.add("serverAddress: " + Objects.toString(this.serverAddress));
        _aidl_sj.add("vendorInfo: " + Objects.toString(this.vendorInfo));
        _aidl_sj.add("serverHostName: " + Objects.toString(this.serverHostName));
        _aidl_sj.add("captivePortalApiUrl: " + Objects.toString(this.captivePortalApiUrl));
        return "DhcpResultsParcelable" + _aidl_sj.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        int _mask = 0 | describeContents(this.baseConfiguration);
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
