package android.net.shared;

import android.net.InformationElementParcelable;
import android.net.InitialConfigurationParcelable;
import android.net.Layer2InformationParcelable;
import android.net.Network;
import android.net.ProvisioningConfigurationParcelable;
import android.net.ScanResultInfoParcelable;
import android.net.StaticIpConfiguration;
import android.net.apf.ApfCapabilities;
import android.net.networkstack.aidl.dhcp.DhcpOption;
import android.util.Log;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class ProvisioningConfiguration {
    private static final int DEFAULT_TIMEOUT_MS = 18000;
    public static final int IPV6_ADDR_GEN_MODE_EUI64 = 0;
    public static final int IPV6_ADDR_GEN_MODE_STABLE_PRIVACY = 2;
    private static final String TAG = "ProvisioningConfiguration";
    public static final int VERSION_ADDED_PROVISIONING_ENUM = 12;
    public ApfCapabilities mApfCapabilities;
    public int mCreatorUid;
    public List<DhcpOption> mDhcpOptions;
    public String mDisplayName;
    public boolean mEnablePreconnection;
    public int mHostnameSetting;
    public int mIPv4ProvisioningMode;
    public int mIPv6AddrGenMode;
    public int mIPv6ProvisioningMode;
    public InitialConfiguration mInitialConfig;
    public Layer2Information mLayer2Info;
    public Network mNetwork;
    public int mProvisioningTimeoutMs;
    public int mRequestedPreDhcpActionMs;
    public ScanResultInfo mScanResultInfo;
    public StaticIpConfiguration mStaticIpConfig;
    public boolean mUniqueEui64AddressesOnly;
    public boolean mUsingIpReachabilityMonitor;
    public boolean mUsingMultinetworkPolicyTracker;

    public static class Builder {
        protected ProvisioningConfiguration mConfig;

        public Builder() {
            this.mConfig = new ProvisioningConfiguration();
        }

        public Builder withoutIPv4() {
            this.mConfig.mIPv4ProvisioningMode = 0;
            return this;
        }

        public Builder withoutIPv6() {
            this.mConfig.mIPv6ProvisioningMode = 0;
            return this;
        }

        public Builder withoutMultinetworkPolicyTracker() {
            this.mConfig.mUsingMultinetworkPolicyTracker = false;
            return this;
        }

        public Builder withoutIpReachabilityMonitor() {
            this.mConfig.mUsingIpReachabilityMonitor = false;
            return this;
        }

        public Builder withPreDhcpAction() {
            this.mConfig.mRequestedPreDhcpActionMs = ProvisioningConfiguration.DEFAULT_TIMEOUT_MS;
            return this;
        }

        public Builder withPreDhcpAction(int dhcpActionTimeoutMs) {
            this.mConfig.mRequestedPreDhcpActionMs = dhcpActionTimeoutMs;
            return this;
        }

        public Builder withPreconnection() {
            this.mConfig.mEnablePreconnection = true;
            return this;
        }

        public Builder withInitialConfiguration(InitialConfiguration initialConfig) {
            this.mConfig.mInitialConfig = initialConfig;
            return this;
        }

        public Builder withStaticConfiguration(StaticIpConfiguration staticConfig) {
            this.mConfig.mIPv4ProvisioningMode = 1;
            this.mConfig.mStaticIpConfig = staticConfig;
            return this;
        }

        public Builder withApfCapabilities(ApfCapabilities apfCapabilities) {
            this.mConfig.mApfCapabilities = apfCapabilities;
            return this;
        }

        public Builder withProvisioningTimeoutMs(int timeoutMs) {
            this.mConfig.mProvisioningTimeoutMs = timeoutMs;
            return this;
        }

        public Builder withRandomMacAddress() {
            this.mConfig.mIPv6AddrGenMode = 0;
            return this;
        }

        public Builder withStableMacAddress() {
            this.mConfig.mIPv6AddrGenMode = 2;
            return this;
        }

        public Builder withNetwork(Network network) {
            this.mConfig.mNetwork = network;
            return this;
        }

        public Builder withDisplayName(String displayName) {
            this.mConfig.mDisplayName = displayName;
            return this;
        }

        public Builder withCreatorUid(int creatoruid) {
            this.mConfig.mCreatorUid = creatoruid;
            return this;
        }

        public Builder withScanResultInfo(ScanResultInfo scanResultInfo) {
            this.mConfig.mScanResultInfo = scanResultInfo;
            return this;
        }

        public Builder withLayer2Information(Layer2Information layer2Info) {
            this.mConfig.mLayer2Info = layer2Info;
            return this;
        }

        public Builder withDhcpOptions(List<DhcpOption> options) {
            this.mConfig.mDhcpOptions = options;
            return this;
        }

        public Builder withIpv6LinkLocalOnly() {
            this.mConfig.mIPv6ProvisioningMode = 2;
            return this;
        }

        public Builder withUniqueEui64AddressesOnly() {
            this.mConfig.mUniqueEui64AddressesOnly = true;
            return this;
        }

        public Builder withHostnameSetting(int setting) {
            this.mConfig.mHostnameSetting = setting;
            return this;
        }

        public ProvisioningConfiguration build() {
            if (this.mConfig.mIPv6ProvisioningMode != 2) goto L10;
            if (this.mConfig.mIPv4ProvisioningMode == 0) goto L10;
            throw new IllegalArgumentException("IPv4 must be disabled in IPv6 link-localonly mode.");
        L10:
            return new ProvisioningConfiguration(this.mConfig);
        }
    }

    public static class ScanResultInfo {
        private final String mBssid;
        private final List<InformationElement> mInformationElements;
        private final String mSsid;

        public static class InformationElement {
            private final int mId;
            private final byte[] mPayload;

            public InformationElement(int id, ByteBuffer payload) {
                this.mId = id;
                this.mPayload = ScanResultInfo.m42$$Nest$smconvertToByteArray(payload.asReadOnlyBuffer());
            }

            public int getId() {
                return this.mId;
            }

            public ByteBuffer getPayload() {
                return ByteBuffer.wrap(this.mPayload).asReadOnlyBuffer();
            }

            public boolean equals(Object o) {
                if (o != this) goto L6;
                return true;
            L6:
                if ((o instanceof InformationElement) == true) goto L8;
                return false;
            L8:
                InformationElement other = (InformationElement) o;
                if (this.mId != other.mId) goto L14;
                if (Arrays.equals(this.mPayload, other.mPayload) == false) goto L14;
                return true;
            L14:
                return false;
            }

            public int hashCode() {
                return Objects.hash(new Object[]{Integer.valueOf(this.mId), Integer.valueOf(Arrays.hashCode(this.mPayload))});
            }

            public String toString() {
                return "ID: " + this.mId + ", " + Arrays.toString(this.mPayload);
            }

            public InformationElementParcelable toStableParcelable() {
                InformationElementParcelable p = new InformationElementParcelable();
                p.id = this.mId;
                if (this.mPayload == null) goto L5;
                byte[] r1 = (byte[]) this.mPayload.clone();
            L6:
                p.payload = r1;
                return p;
            L5:
                r1 = null;
                goto L6
            }

            public static InformationElement fromStableParcelable(InformationElementParcelable p) {
                if (p != null) goto L6;
                return null;
            L6:
                return new InformationElement(p.id, ByteBuffer.wrap((byte[]) p.payload.clone()).asReadOnlyBuffer());
            }
        }

        /* JADX INFO: renamed from: -$$Nest$smconvertToByteArray, reason: not valid java name */
        static /* bridge */ /* synthetic */ byte[] m42$$Nest$smconvertToByteArray(ByteBuffer r0) {
            return convertToByteArray(r0);
        }

        public ScanResultInfo(String ssid, String bssid, List<InformationElement> informationElements) {
            ssid.getClass();
            bssid.getClass();
            this.mSsid = ssid;
            this.mBssid = bssid;
            this.mInformationElements = Collections.unmodifiableList(new ArrayList(informationElements));
        }

        public String getSsid() {
            return this.mSsid;
        }

        public String getBssid() {
            return this.mBssid;
        }

        public List<InformationElement> getInformationElements() {
            return this.mInformationElements;
        }

        public String toString() {
            StringBuffer str = new StringBuffer();
            str.append("SSID: ");
            str.append(this.mSsid);
            str.append(", BSSID: ");
            str.append(this.mBssid);
            str.append(", Information Elements: {");
            Iterator<InformationElement> r1 = this.mInformationElements.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            InformationElement ie = r1.next();
            str.append("[");
            str.append(ie.toString());
            str.append("]");
            goto L4
        L6:
            str.append("}");
            return str.toString();
        }

        public boolean equals(Object o) {
            if (o != this) goto L6;
            return true;
        L6:
            if ((o instanceof ScanResultInfo) == true) goto L8;
            return false;
        L8:
            ScanResultInfo other = (ScanResultInfo) o;
            if (Objects.equals(this.mSsid, other.mSsid) == false) goto L16;
            if (Objects.equals(this.mBssid, other.mBssid) == false) goto L16;
            if (this.mInformationElements.equals(other.mInformationElements) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mSsid, this.mBssid, this.mInformationElements});
        }

        public ScanResultInfoParcelable toStableParcelable() {
            ScanResultInfoParcelable p = new ScanResultInfoParcelable();
            p.ssid = this.mSsid;
            p.bssid = this.mBssid;
            p.informationElements = (InformationElementParcelable[]) ParcelableUtil.toParcelableArray(this.mInformationElements, new ProvisioningConfiguration$ScanResultInfo$$ExternalSyntheticLambda1(), InformationElementParcelable.class);
            return p;
        }

        public static ScanResultInfo fromStableParcelable(ScanResultInfoParcelable p) {
            if (p != null) goto L5;
            return null;
        L5:
            List<InformationElement> ies = new ArrayList();
            ies.addAll(ParcelableUtil.fromParcelableArray(p.informationElements, new ProvisioningConfiguration$ScanResultInfo$$ExternalSyntheticLambda0()));
            return new ScanResultInfo(p.ssid, p.bssid, ies);
        }

        private static byte[] convertToByteArray(ByteBuffer buffer) {
            byte[] bytes = new byte[buffer.limit()];
            ByteBuffer copy = buffer.asReadOnlyBuffer();
            copy.position(0);     // Catch: Throwable -> L5 BufferUnderflowException -> L7
            copy.get(bytes);     // Catch: Throwable -> L5 BufferUnderflowException -> L7
            return bytes;
        L8:
            Log.wtf(ProvisioningConfiguration.TAG, "Buffer under flow exception should never happen.");     // Catch: Throwable -> L5
        L9:
            return bytes;
        }
    }

    public ProvisioningConfiguration() {
        this.mUniqueEui64AddressesOnly = false;
        this.mEnablePreconnection = false;
        this.mUsingMultinetworkPolicyTracker = true;
        this.mUsingIpReachabilityMonitor = true;
        this.mProvisioningTimeoutMs = DEFAULT_TIMEOUT_MS;
        this.mIPv6AddrGenMode = 2;
        this.mNetwork = null;
        this.mDisplayName = null;
        this.mIPv4ProvisioningMode = 2;
        this.mIPv6ProvisioningMode = 1;
        this.mHostnameSetting = 0;
    }

    public ProvisioningConfiguration(ProvisioningConfiguration other) {
        this.mUniqueEui64AddressesOnly = false;
        this.mEnablePreconnection = false;
        this.mUsingMultinetworkPolicyTracker = true;
        this.mUsingIpReachabilityMonitor = true;
        this.mProvisioningTimeoutMs = DEFAULT_TIMEOUT_MS;
        this.mIPv6AddrGenMode = 2;
        StaticIpConfiguration r3 = null;
        this.mNetwork = null;
        this.mDisplayName = null;
        this.mIPv4ProvisioningMode = 2;
        this.mIPv6ProvisioningMode = 1;
        this.mHostnameSetting = 0;
        this.mUniqueEui64AddressesOnly = other.mUniqueEui64AddressesOnly;
        this.mEnablePreconnection = other.mEnablePreconnection;
        this.mUsingMultinetworkPolicyTracker = other.mUsingMultinetworkPolicyTracker;
        this.mUsingIpReachabilityMonitor = other.mUsingIpReachabilityMonitor;
        this.mRequestedPreDhcpActionMs = other.mRequestedPreDhcpActionMs;
        this.mInitialConfig = InitialConfiguration.copy(other.mInitialConfig);
        if (other.mStaticIpConfig == null) goto L6;
        r3 = new StaticIpConfiguration(other.mStaticIpConfig);
    L6:
        this.mStaticIpConfig = r3;
        this.mApfCapabilities = other.mApfCapabilities;
        this.mProvisioningTimeoutMs = other.mProvisioningTimeoutMs;
        this.mIPv6AddrGenMode = other.mIPv6AddrGenMode;
        this.mNetwork = other.mNetwork;
        this.mDisplayName = other.mDisplayName;
        this.mCreatorUid = other.mCreatorUid;
        this.mScanResultInfo = other.mScanResultInfo;
        this.mLayer2Info = other.mLayer2Info;
        this.mDhcpOptions = other.mDhcpOptions;
        this.mIPv4ProvisioningMode = other.mIPv4ProvisioningMode;
        this.mIPv6ProvisioningMode = other.mIPv6ProvisioningMode;
        this.mHostnameSetting = other.mHostnameSetting;
    }

    public ProvisioningConfigurationParcelable toStableParcelable() {
        ProvisioningConfigurationParcelable p = new ProvisioningConfigurationParcelable();
        boolean r2 = false;
        if (this.mIPv4ProvisioningMode == 0) goto L5;
        boolean r1 = true;
    L6:
        p.enableIPv4 = r1;
        p.ipv4ProvisioningMode = this.mIPv4ProvisioningMode;
        if (this.mIPv6ProvisioningMode == 0) goto L9;
        r2 = true;
    L9:
        p.enableIPv6 = r2;
        p.ipv6ProvisioningMode = this.mIPv6ProvisioningMode;
        p.uniqueEui64AddressesOnly = this.mUniqueEui64AddressesOnly;
        p.enablePreconnection = this.mEnablePreconnection;
        p.usingMultinetworkPolicyTracker = this.mUsingMultinetworkPolicyTracker;
        p.usingIpReachabilityMonitor = this.mUsingIpReachabilityMonitor;
        p.requestedPreDhcpActionMs = this.mRequestedPreDhcpActionMs;
        ArrayList r3 = null;
        if (this.mInitialConfig != null) goto L12;
        InitialConfigurationParcelable r4 = null;
    L13:
        p.initialConfig = r4;
        if (this.mStaticIpConfig != null) goto L16;
        StaticIpConfiguration r5 = null;
    L17:
        p.staticIpConfig = r5;
        p.apfCapabilities = this.mApfCapabilities;
        p.provisioningTimeoutMs = this.mProvisioningTimeoutMs;
        p.ipv6AddrGenMode = this.mIPv6AddrGenMode;
        p.network = this.mNetwork;
        p.displayName = this.mDisplayName;
        p.creatorUid = this.mCreatorUid;
        if (this.mScanResultInfo != null) goto L20;
        ScanResultInfoParcelable r6 = null;
    L21:
        p.scanResultInfo = r6;
        if (this.mLayer2Info != null) goto L24;
        Layer2InformationParcelable r7 = null;
    L25:
        p.layer2Info = r7;
        if (this.mDhcpOptions == null) goto L29;
        r3 = new ArrayList(this.mDhcpOptions);
    L29:
        p.options = r3;
        p.hostnameSetting = this.mHostnameSetting;
        return p;
    L24:
        r7 = this.mLayer2Info.toStableParcelable();
        goto L25
    L20:
        r6 = this.mScanResultInfo.toStableParcelable();
        goto L21
    L16:
        r5 = new StaticIpConfiguration(this.mStaticIpConfig);
        goto L17
    L12:
        r4 = this.mInitialConfig.toStableParcelable();
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    public static ProvisioningConfiguration fromStableParcelable(ProvisioningConfigurationParcelable r4, int r5) {
        ArrayList r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        ProvisioningConfiguration r1 = new ProvisioningConfiguration();
        r1.mUniqueEui64AddressesOnly = r4.uniqueEui64AddressesOnly;
        r1.mEnablePreconnection = r4.enablePreconnection;
        r1.mUsingMultinetworkPolicyTracker = r4.usingMultinetworkPolicyTracker;
        r1.mUsingIpReachabilityMonitor = r4.usingIpReachabilityMonitor;
        r1.mRequestedPreDhcpActionMs = r4.requestedPreDhcpActionMs;
        r1.mInitialConfig = InitialConfiguration.fromStableParcelable(r4.initialConfig);
        if (r4.staticIpConfig != null) goto L8;
        StaticIpConfiguration r2 = null;
    L9:
        r1.mStaticIpConfig = r2;
        r1.mApfCapabilities = r4.apfCapabilities;
        r1.mProvisioningTimeoutMs = r4.provisioningTimeoutMs;
        r1.mIPv6AddrGenMode = r4.ipv6AddrGenMode;
        r1.mNetwork = r4.network;
        r1.mDisplayName = r4.displayName;
        r1.mCreatorUid = r4.creatorUid;
        r1.mScanResultInfo = ScanResultInfo.fromStableParcelable(r4.scanResultInfo);
        r1.mLayer2Info = Layer2Information.fromStableParcelable(r4.layer2Info);
        if (r4.options == null) goto L13;
        r0 = new ArrayList(r4.options);
    L13:
        r1.mDhcpOptions = r0;
        if (r5 < 12) goto L16;
        r1.mIPv4ProvisioningMode = r4.ipv4ProvisioningMode;
        r1.mIPv6ProvisioningMode = r4.ipv6ProvisioningMode;
    L21:
        r1.mHostnameSetting = r4.hostnameSetting;
        return r1;
    L16:
        if (r4.enableIPv4 == false) goto L18;
        int r3 = 2;
    L19:
        r1.mIPv4ProvisioningMode = r3;
        r1.mIPv6ProvisioningMode = r4.enableIPv6 ? 1 : 0;
        goto L21
    L18:
        r3 = 0;
        goto L19
    L8:
        r2 = new StaticIpConfiguration(r4.staticIpConfig);
        goto L9
    }

    static String ipv4ProvisioningModeToString(int mode) {
        switch(mode) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return "unknown";
    L5:
        return "dhcp";
    L7:
        return "static";
    L9:
        return ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
    }

    static String ipv6ProvisioningModeToString(int mode) {
        switch(mode) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return "unknown";
    L5:
        return "link-local";
    L7:
        return "slaac";
    L9:
        return ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
    }

    public String toString() {
        String ipv4ProvisioningMode = ipv4ProvisioningModeToString(this.mIPv4ProvisioningMode);
        String ipv6ProvisioningMode = ipv6ProvisioningModeToString(this.mIPv6ProvisioningMode);
        return new StringJoiner(", ", getClass().getSimpleName() + "{", "}").add("mUniqueEui64AddressesOnly: " + this.mUniqueEui64AddressesOnly).add("mEnablePreconnection: " + this.mEnablePreconnection).add("mUsingMultinetworkPolicyTracker: " + this.mUsingMultinetworkPolicyTracker).add("mUsingIpReachabilityMonitor: " + this.mUsingIpReachabilityMonitor).add("mRequestedPreDhcpActionMs: " + this.mRequestedPreDhcpActionMs).add("mInitialConfig: " + this.mInitialConfig).add("mStaticIpConfig: " + this.mStaticIpConfig).add("mApfCapabilities: " + this.mApfCapabilities).add("mProvisioningTimeoutMs: " + this.mProvisioningTimeoutMs).add("mIPv6AddrGenMode: " + this.mIPv6AddrGenMode).add("mNetwork: " + this.mNetwork).add("mDisplayName: " + this.mDisplayName).add("mCreatorUid:" + this.mCreatorUid).add("mScanResultInfo: " + this.mScanResultInfo).add("mLayer2Info: " + this.mLayer2Info).add("mDhcpOptions: " + this.mDhcpOptions).add("mIPv4ProvisioningMode: " + ipv4ProvisioningMode).add("mIPv6ProvisioningMode: " + ipv6ProvisioningMode).add("mHostnameSetting: " + this.mHostnameSetting).toString();
    }

    private static boolean dhcpOptionEquals(DhcpOption obj1, DhcpOption obj2) {
        if (obj1 != obj2) goto L6;
        return true;
    L6:
        if (obj1 == null) goto L16;
        if (obj2 == null) goto L16;
        if (obj1.type != obj2.type) goto L15;
        if (Arrays.equals(obj1.value, obj2.value) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    private static boolean dhcpOptionListEquals(List<DhcpOption> l1, List<DhcpOption> l2) {
        if (l1 != l2) goto L6;
        return true;
    L6:
        if (l1 == null) goto L21;
        if (l2 == null) goto L21;
        if (l1.size() == l2.size()) goto L12;
        return false;
    L12:
        int i = 0;
    L14:
        if (i >= l1.size()) goto L20;
        if (dhcpOptionEquals(l1.get(i), l2.get(i)) == false) goto L17;
        i = i + 1;
        goto L14
    L17:
        return false;
    L20:
        return true;
    L21:
        return false;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ProvisioningConfiguration) == true) goto L5;
        return false;
    L5:
        ProvisioningConfiguration other = (ProvisioningConfiguration) obj;
        if (this.mUniqueEui64AddressesOnly == other.mUniqueEui64AddressesOnly) goto L8;
        return false;
    L8:
        if (this.mEnablePreconnection == other.mEnablePreconnection) goto L10;
        return false;
    L10:
        if (this.mUsingMultinetworkPolicyTracker == other.mUsingMultinetworkPolicyTracker) goto L12;
        return false;
    L12:
        if (this.mUsingIpReachabilityMonitor == other.mUsingIpReachabilityMonitor) goto L14;
        return false;
    L14:
        if (this.mRequestedPreDhcpActionMs == other.mRequestedPreDhcpActionMs) goto L16;
        return false;
    L16:
        if (Objects.equals(this.mInitialConfig, other.mInitialConfig) == true) goto L18;
        return false;
    L18:
        if (Objects.equals(this.mStaticIpConfig, other.mStaticIpConfig) == true) goto L20;
        return false;
    L20:
        if (Objects.equals(this.mApfCapabilities, other.mApfCapabilities) == true) goto L22;
        return false;
    L22:
        if (this.mProvisioningTimeoutMs == other.mProvisioningTimeoutMs) goto L24;
        return false;
    L24:
        if (this.mIPv6AddrGenMode == other.mIPv6AddrGenMode) goto L26;
        return false;
    L26:
        if (Objects.equals(this.mNetwork, other.mNetwork) == true) goto L28;
        return false;
    L28:
        if (Objects.equals(this.mDisplayName, other.mDisplayName) == true) goto L30;
        return false;
    L30:
        if (Objects.equals(this.mScanResultInfo, other.mScanResultInfo) == true) goto L32;
        return false;
    L32:
        if (Objects.equals(this.mLayer2Info, other.mLayer2Info) == true) goto L34;
        return false;
    L34:
        if (dhcpOptionListEquals(this.mDhcpOptions, other.mDhcpOptions) == true) goto L36;
        return false;
    L36:
        if (this.mIPv4ProvisioningMode == other.mIPv4ProvisioningMode) goto L38;
        return false;
    L38:
        if (this.mIPv6ProvisioningMode == other.mIPv6ProvisioningMode) goto L40;
        return false;
    L40:
        if (this.mCreatorUid == other.mCreatorUid) goto L42;
        return false;
    L42:
        if (this.mHostnameSetting != other.mHostnameSetting) goto L64;
        return true;
    L64:
        return false;
    }

    public boolean isValid() {
        if (this.mInitialConfig != null) goto L5;
    L8:
        return true;
    L5:
        if (this.mInitialConfig.isValid() == true) goto L8;
        return false;
    }
}
