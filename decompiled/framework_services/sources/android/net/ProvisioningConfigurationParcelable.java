package android.net;

import android.net.apf.ApfCapabilities;
import android.net.networkstack.aidl.dhcp.DhcpOption;
import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class ProvisioningConfigurationParcelable implements Parcelable {
    public static final Parcelable.Creator<ProvisioningConfigurationParcelable> CREATOR = null;
    public ApfCapabilities apfCapabilities;
    public int creatorUid;
    public String displayName;

    @Deprecated
    public boolean enableIPv4;

    @Deprecated
    public boolean enableIPv6;
    public boolean enablePreconnection;
    public int hostnameSetting;
    public InitialConfigurationParcelable initialConfig;
    public int ipv4ProvisioningMode;
    public int ipv6AddrGenMode;
    public int ipv6ProvisioningMode;
    public Layer2InformationParcelable layer2Info;
    public Network network;
    public List<DhcpOption> options;
    public int provisioningTimeoutMs;
    public int requestedPreDhcpActionMs;
    public ScanResultInfoParcelable scanResultInfo;
    public StaticIpConfiguration staticIpConfig;
    public boolean uniqueEui64AddressesOnly;
    public boolean usingIpReachabilityMonitor;
    public boolean usingMultinetworkPolicyTracker;

    static class _Parcel {
        /* JADX INFO: renamed from: -$$Nest$smwriteTypedList, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m30$$Nest$smwriteTypedList(Parcel r0, List r1, int r2) {
            writeTypedList(r0, r1, r2);
        }

        _Parcel() {
        }

        private static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> value, int parcelableFlags) {
            if (value != null) goto L4;
            parcel.writeInt(-1);
            return;
        L4:
            int N = value.size();
            int i = 0;
            parcel.writeInt(N);
        L5:
            if (i >= N) goto L9;
            parcel.writeTypedObject(value.get(i), parcelableFlags);
            i = i + 1;
            goto L5
        }
    }

    public ProvisioningConfigurationParcelable() {
        this.enableIPv4 = false;
        this.enableIPv6 = false;
        this.usingMultinetworkPolicyTracker = false;
        this.usingIpReachabilityMonitor = false;
        this.requestedPreDhcpActionMs = 0;
        this.provisioningTimeoutMs = 0;
        this.ipv6AddrGenMode = 0;
        this.enablePreconnection = false;
        this.ipv4ProvisioningMode = 0;
        this.ipv6ProvisioningMode = 0;
        this.uniqueEui64AddressesOnly = false;
        this.creatorUid = 0;
        this.hostnameSetting = 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeBoolean(this.enableIPv4);
        _aidl_parcel.writeBoolean(this.enableIPv6);
        _aidl_parcel.writeBoolean(this.usingMultinetworkPolicyTracker);
        _aidl_parcel.writeBoolean(this.usingIpReachabilityMonitor);
        _aidl_parcel.writeInt(this.requestedPreDhcpActionMs);
        _aidl_parcel.writeTypedObject(this.initialConfig, _aidl_flag);
        _aidl_parcel.writeTypedObject(this.staticIpConfig, _aidl_flag);
        _aidl_parcel.writeTypedObject(this.apfCapabilities, _aidl_flag);
        _aidl_parcel.writeInt(this.provisioningTimeoutMs);
        _aidl_parcel.writeInt(this.ipv6AddrGenMode);
        _aidl_parcel.writeTypedObject(this.network, _aidl_flag);
        _aidl_parcel.writeString(this.displayName);
        _aidl_parcel.writeBoolean(this.enablePreconnection);
        _aidl_parcel.writeTypedObject(this.scanResultInfo, _aidl_flag);
        _aidl_parcel.writeTypedObject(this.layer2Info, _aidl_flag);
        _Parcel.m30$$Nest$smwriteTypedList(_aidl_parcel, this.options, _aidl_flag);
        _aidl_parcel.writeInt(this.ipv4ProvisioningMode);
        _aidl_parcel.writeInt(this.ipv6ProvisioningMode);
        _aidl_parcel.writeBoolean(this.uniqueEui64AddressesOnly);
        _aidl_parcel.writeInt(this.creatorUid);
        _aidl_parcel.writeInt(this.hostnameSetting);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L203;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.enableIPv4 = _aidl_parcel.readBoolean();     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.enableIPv6 = _aidl_parcel.readBoolean();     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
        this.usingMultinetworkPolicyTracker = _aidl_parcel.readBoolean();     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
        this.usingIpReachabilityMonitor = _aidl_parcel.readBoolean();     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
        this.requestedPreDhcpActionMs = _aidl_parcel.readInt();     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L53;
        this.initialConfig = (InitialConfigurationParcelable) _aidl_parcel.readTypedObject(InitialConfigurationParcelable.CREATOR);     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L62;
        this.staticIpConfig = (StaticIpConfiguration) _aidl_parcel.readTypedObject(StaticIpConfiguration.CREATOR);     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L71;
        this.apfCapabilities = (ApfCapabilities) _aidl_parcel.readTypedObject(ApfCapabilities.CREATOR);     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L80;
        this.provisioningTimeoutMs = _aidl_parcel.readInt();     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L89;
        this.ipv6AddrGenMode = _aidl_parcel.readInt();     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L98;
        this.network = (Network) _aidl_parcel.readTypedObject(Network.CREATOR);     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L107;
        this.displayName = _aidl_parcel.readString();     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L116;
        this.enablePreconnection = _aidl_parcel.readBoolean();     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L125;
        this.scanResultInfo = (ScanResultInfoParcelable) _aidl_parcel.readTypedObject(ScanResultInfoParcelable.CREATOR);     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L134;
        this.layer2Info = (Layer2InformationParcelable) _aidl_parcel.readTypedObject(Layer2InformationParcelable.CREATOR);     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L143;
        this.options = _aidl_parcel.createTypedArrayList(DhcpOption.CREATOR);     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L152;
        this.ipv4ProvisioningMode = _aidl_parcel.readInt();     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L161;
        this.ipv6ProvisioningMode = _aidl_parcel.readInt();     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L170;
        this.uniqueEui64AddressesOnly = _aidl_parcel.readBoolean();     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L179;
        this.creatorUid = _aidl_parcel.readInt();     // Catch: Throwable -> L200
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L188;
        this.hostnameSetting = _aidl_parcel.readInt();     // Catch: Throwable -> L200
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L199;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L199:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L188:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L192;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L192:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L179:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L183;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L183:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L170:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L174;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L174:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L161:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L165;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L165:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L152:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L156;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L156:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L143:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L147;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L147:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L134:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L138;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L138:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L125:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L129;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L129:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L116:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L120;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L120:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L107:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L111;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L111:
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
    L203:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L200
    L200:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L207;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L207:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    public String toString() {
        StringJoiner _aidl_sj = new StringJoiner(", ", "{", "}");
        _aidl_sj.add("enableIPv4: " + this.enableIPv4);
        _aidl_sj.add("enableIPv6: " + this.enableIPv6);
        _aidl_sj.add("usingMultinetworkPolicyTracker: " + this.usingMultinetworkPolicyTracker);
        _aidl_sj.add("usingIpReachabilityMonitor: " + this.usingIpReachabilityMonitor);
        _aidl_sj.add("requestedPreDhcpActionMs: " + this.requestedPreDhcpActionMs);
        _aidl_sj.add("initialConfig: " + Objects.toString(this.initialConfig));
        _aidl_sj.add("staticIpConfig: " + Objects.toString(this.staticIpConfig));
        _aidl_sj.add("apfCapabilities: " + Objects.toString(this.apfCapabilities));
        _aidl_sj.add("provisioningTimeoutMs: " + this.provisioningTimeoutMs);
        _aidl_sj.add("ipv6AddrGenMode: " + this.ipv6AddrGenMode);
        _aidl_sj.add("network: " + Objects.toString(this.network));
        _aidl_sj.add("displayName: " + Objects.toString(this.displayName));
        _aidl_sj.add("enablePreconnection: " + this.enablePreconnection);
        _aidl_sj.add("scanResultInfo: " + Objects.toString(this.scanResultInfo));
        _aidl_sj.add("layer2Info: " + Objects.toString(this.layer2Info));
        _aidl_sj.add("options: " + Objects.toString(this.options));
        _aidl_sj.add("ipv4ProvisioningMode: " + this.ipv4ProvisioningMode);
        _aidl_sj.add("ipv6ProvisioningMode: " + this.ipv6ProvisioningMode);
        _aidl_sj.add("uniqueEui64AddressesOnly: " + this.uniqueEui64AddressesOnly);
        _aidl_sj.add("creatorUid: " + this.creatorUid);
        _aidl_sj.add("hostnameSetting: " + this.hostnameSetting);
        return "ProvisioningConfigurationParcelable" + _aidl_sj.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        int _mask = 0 | describeContents(this.initialConfig);
        return (((((_mask | describeContents(this.staticIpConfig)) | describeContents(this.apfCapabilities)) | describeContents(this.network)) | describeContents(this.scanResultInfo)) | describeContents(this.layer2Info)) | describeContents(this.options);
    }

    private int describeContents(Object _v) {
        if (_v != null) goto L6;
        return 0;
    L6:
        if ((_v instanceof Collection) == false) goto L13;
        int _mask = 0;
        Iterator r1 = ((Collection) _v).iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        Object o = r1.next();
        _mask = _mask | describeContents(o);
        goto L9
    L11:
        return _mask;
    L13:
        if ((_v instanceof Parcelable) == true) goto L15;
        return 0;
    L15:
        return ((Parcelable) _v).describeContents();
    }
}
