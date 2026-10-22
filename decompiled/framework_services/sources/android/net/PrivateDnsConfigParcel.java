package android.net;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class PrivateDnsConfigParcel implements Parcelable {
    public static final Parcelable.Creator<PrivateDnsConfigParcel> CREATOR = null;
    public boolean ddrEnabled;
    public String[] dohIps;
    public String dohName;
    public String dohPath;
    public int dohPort;
    public String hostname;
    public String[] ips;
    public int privateDnsMode;

    public PrivateDnsConfigParcel() {
        this.privateDnsMode = -1;
        this.dohName = "";
        this.dohIps = new String[0];
        this.dohPath = "";
        this.dohPort = -1;
        this.ddrEnabled = false;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeString(this.hostname);
        _aidl_parcel.writeStringArray(this.ips);
        _aidl_parcel.writeInt(this.privateDnsMode);
        _aidl_parcel.writeString(this.dohName);
        _aidl_parcel.writeStringArray(this.dohIps);
        _aidl_parcel.writeString(this.dohPath);
        _aidl_parcel.writeInt(this.dohPort);
        _aidl_parcel.writeBoolean(this.ddrEnabled);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L86;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.hostname = _aidl_parcel.readString();     // Catch: Throwable -> L83
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.ips = _aidl_parcel.createStringArray();     // Catch: Throwable -> L83
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
        this.privateDnsMode = _aidl_parcel.readInt();     // Catch: Throwable -> L83
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
        this.dohName = _aidl_parcel.readString();     // Catch: Throwable -> L83
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
        this.dohIps = _aidl_parcel.createStringArray();     // Catch: Throwable -> L83
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L53;
        this.dohPath = _aidl_parcel.readString();     // Catch: Throwable -> L83
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L62;
        this.dohPort = _aidl_parcel.readInt();     // Catch: Throwable -> L83
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L71;
        this.ddrEnabled = _aidl_parcel.readBoolean();     // Catch: Throwable -> L83
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L82;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L82:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L71:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L75;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L75:
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
    L86:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L90;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L90:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    public String toString() {
        StringJoiner _aidl_sj = new StringJoiner(", ", "{", "}");
        _aidl_sj.add("hostname: " + Objects.toString(this.hostname));
        _aidl_sj.add("ips: " + Arrays.toString(this.ips));
        _aidl_sj.add("privateDnsMode: " + this.privateDnsMode);
        _aidl_sj.add("dohName: " + Objects.toString(this.dohName));
        _aidl_sj.add("dohIps: " + Arrays.toString(this.dohIps));
        _aidl_sj.add("dohPath: " + Objects.toString(this.dohPath));
        _aidl_sj.add("dohPort: " + this.dohPort);
        _aidl_sj.add("ddrEnabled: " + this.ddrEnabled);
        return "PrivateDnsConfigParcel" + _aidl_sj.toString();
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L9;
        return false;
    L9:
        if ((other instanceof PrivateDnsConfigParcel) == true) goto L11;
        return false;
    L11:
        PrivateDnsConfigParcel that = (PrivateDnsConfigParcel) other;
        if (Objects.deepEquals(this.hostname, that.hostname) == true) goto L15;
        return false;
    L15:
        if (Objects.deepEquals(this.ips, that.ips) == true) goto L18;
        return false;
    L18:
        if (Objects.deepEquals(Integer.valueOf(this.privateDnsMode), Integer.valueOf(that.privateDnsMode)) == true) goto L21;
        return false;
    L21:
        if (Objects.deepEquals(this.dohName, that.dohName) == true) goto L24;
        return false;
    L24:
        if (Objects.deepEquals(this.dohIps, that.dohIps) == true) goto L27;
        return false;
    L27:
        if (Objects.deepEquals(this.dohPath, that.dohPath) == true) goto L30;
        return false;
    L30:
        if (Objects.deepEquals(Integer.valueOf(this.dohPort), Integer.valueOf(that.dohPort)) == true) goto L33;
        return false;
    L33:
        if (Objects.deepEquals(Boolean.valueOf(this.ddrEnabled), Boolean.valueOf(that.ddrEnabled)) == true) goto L35;
        return false;
    L35:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        return Arrays.deepHashCode(Arrays.asList(new Serializable[]{this.hostname, this.ips, Integer.valueOf(this.privateDnsMode), this.dohName, this.dohIps, this.dohPath, Integer.valueOf(this.dohPort), Boolean.valueOf(this.ddrEnabled)}).toArray());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
