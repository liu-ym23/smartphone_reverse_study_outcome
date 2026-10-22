package android.net.dhcp;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class DhcpServingParamsParcel implements Parcelable {
    public static final Parcelable.Creator<DhcpServingParamsParcel> CREATOR = null;
    public boolean changePrefixOnDecline;
    public int[] defaultRouters;
    public long dhcpLeaseTimeSecs;
    public int[] dnsServers;
    public int[] excludedAddrs;
    public int leasesSubnetPrefixLength;
    public int linkMtu;
    public boolean metered;
    public int serverAddr;
    public int serverAddrPrefixLength;
    public int singleClientAddr;

    public DhcpServingParamsParcel() {
        this.serverAddr = 0;
        this.serverAddrPrefixLength = 0;
        this.dhcpLeaseTimeSecs = 0;
        this.linkMtu = 0;
        this.metered = false;
        this.singleClientAddr = 0;
        this.changePrefixOnDecline = false;
        this.leasesSubnetPrefixLength = 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeInt(this.serverAddr);
        _aidl_parcel.writeInt(this.serverAddrPrefixLength);
        _aidl_parcel.writeIntArray(this.defaultRouters);
        _aidl_parcel.writeIntArray(this.dnsServers);
        _aidl_parcel.writeIntArray(this.excludedAddrs);
        _aidl_parcel.writeLong(this.dhcpLeaseTimeSecs);
        _aidl_parcel.writeInt(this.linkMtu);
        _aidl_parcel.writeBoolean(this.metered);
        _aidl_parcel.writeInt(this.singleClientAddr);
        _aidl_parcel.writeBoolean(this.changePrefixOnDecline);
        _aidl_parcel.writeInt(this.leasesSubnetPrefixLength);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L113;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.serverAddr = _aidl_parcel.readInt();     // Catch: Throwable -> L110
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.serverAddrPrefixLength = _aidl_parcel.readInt();     // Catch: Throwable -> L110
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
        this.defaultRouters = _aidl_parcel.createIntArray();     // Catch: Throwable -> L110
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
        this.dnsServers = _aidl_parcel.createIntArray();     // Catch: Throwable -> L110
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
        this.excludedAddrs = _aidl_parcel.createIntArray();     // Catch: Throwable -> L110
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L53;
        this.dhcpLeaseTimeSecs = _aidl_parcel.readLong();     // Catch: Throwable -> L110
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L62;
        this.linkMtu = _aidl_parcel.readInt();     // Catch: Throwable -> L110
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L71;
        this.metered = _aidl_parcel.readBoolean();     // Catch: Throwable -> L110
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L80;
        this.singleClientAddr = _aidl_parcel.readInt();     // Catch: Throwable -> L110
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L89;
        this.changePrefixOnDecline = _aidl_parcel.readBoolean();     // Catch: Throwable -> L110
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L98;
        this.leasesSubnetPrefixLength = _aidl_parcel.readInt();     // Catch: Throwable -> L110
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L109;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L109:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L98:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L102;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L102:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L89:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L93;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L93:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L80:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L84;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L84:
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
    L113:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L117;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L117:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    public String toString() {
        StringJoiner _aidl_sj = new StringJoiner(", ", "{", "}");
        _aidl_sj.add("serverAddr: " + this.serverAddr);
        _aidl_sj.add("serverAddrPrefixLength: " + this.serverAddrPrefixLength);
        _aidl_sj.add("defaultRouters: " + Arrays.toString(this.defaultRouters));
        _aidl_sj.add("dnsServers: " + Arrays.toString(this.dnsServers));
        _aidl_sj.add("excludedAddrs: " + Arrays.toString(this.excludedAddrs));
        _aidl_sj.add("dhcpLeaseTimeSecs: " + this.dhcpLeaseTimeSecs);
        _aidl_sj.add("linkMtu: " + this.linkMtu);
        _aidl_sj.add("metered: " + this.metered);
        _aidl_sj.add("singleClientAddr: " + this.singleClientAddr);
        _aidl_sj.add("changePrefixOnDecline: " + this.changePrefixOnDecline);
        _aidl_sj.add("leasesSubnetPrefixLength: " + this.leasesSubnetPrefixLength);
        return "DhcpServingParamsParcel" + _aidl_sj.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
