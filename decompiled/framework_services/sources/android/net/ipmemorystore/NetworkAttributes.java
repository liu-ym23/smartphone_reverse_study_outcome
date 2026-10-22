package android.net.ipmemorystore;

import android.net.networkstack.aidl.quirks.IPv6ProvisioningLossQuirk;
import android.net.networkstack.aidl.quirks.IPv6ProvisioningLossQuirkParcelable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class NetworkAttributes {
    private static final boolean DBG = true;
    private static final float NULL_MATCH_WEIGHT = 0.25f;
    public static final float TOTAL_WEIGHT = 850.0f;
    private static final float TOTAL_WEIGHT_CUTOFF = 520.0f;
    private static final float WEIGHT_ASSIGNEDV4ADDR = 300.0f;
    private static final float WEIGHT_ASSIGNEDV4ADDREXPIRY = 0.0f;
    private static final float WEIGHT_CLUSTER = 300.0f;
    private static final float WEIGHT_DNSADDRESSES = 200.0f;
    private static final float WEIGHT_MTU = 50.0f;
    private static final float WEIGHT_V6PROVLOSSQUIRK = 0.0f;
    public final Inet4Address assignedV4Address;
    public final Long assignedV4AddressExpiry;
    public final String cluster;
    public final List<InetAddress> dnsAddresses;
    public final IPv6ProvisioningLossQuirk ipv6ProvisioningLossQuirk;
    public final Integer mtu;

    public static class Builder {
        private Inet4Address mAssignedAddress;
        private Long mAssignedAddressExpiry;
        private String mCluster;
        private List<InetAddress> mDnsAddresses;
        private IPv6ProvisioningLossQuirk mIpv6ProvLossQuirk;
        private Integer mMtu;

        public Builder() {
        }

        public Builder(NetworkAttributes attributes) {
            this.mAssignedAddress = attributes.assignedV4Address;
            this.mAssignedAddressExpiry = attributes.assignedV4AddressExpiry;
            this.mCluster = attributes.cluster;
            this.mDnsAddresses = new ArrayList(attributes.dnsAddresses);
            this.mMtu = attributes.mtu;
            this.mIpv6ProvLossQuirk = attributes.ipv6ProvisioningLossQuirk;
        }

        public Builder setAssignedV4Address(Inet4Address assignedV4Address) {
            this.mAssignedAddress = assignedV4Address;
            return this;
        }

        public Builder setAssignedV4AddressExpiry(Long assignedV4AddressExpiry) {
            if (assignedV4AddressExpiry != null) goto L4;
        L8:
            this.mAssignedAddressExpiry = assignedV4AddressExpiry;
            return this;
        L4:
            if (assignedV4AddressExpiry.longValue() > 0) goto L8;
            throw new IllegalArgumentException("lease expiry can't be negative or zero");
        }

        public Builder setCluster(String cluster) {
            this.mCluster = cluster;
            return this;
        }

        public Builder setDnsAddresses(List<InetAddress> dnsAddresses) {
            if (dnsAddresses == null) goto L11;
            Iterator<InetAddress> r0 = dnsAddresses.iterator();
        L5:
            if (r0.hasNext() == false) goto L11;
            InetAddress address = r0.next();
            if (address != null) goto L5;
            throw new IllegalArgumentException("Null DNS address");
        L11:
            this.mDnsAddresses = dnsAddresses;
            return this;
        }

        public Builder setMtu(Integer mtu) {
            if (mtu != null) goto L4;
        L8:
            this.mMtu = mtu;
            return this;
        L4:
            if (mtu.intValue() >= 0) goto L8;
            throw new IllegalArgumentException("MTU can't be negative");
        }

        public Builder setIpv6ProvLossQuirk(IPv6ProvisioningLossQuirk quirk) {
            this.mIpv6ProvLossQuirk = quirk;
            return this;
        }

        public NetworkAttributes build() {
            return new NetworkAttributes(this.mAssignedAddress, this.mAssignedAddressExpiry, this.mCluster, this.mDnsAddresses, this.mMtu, this.mIpv6ProvLossQuirk);
        }
    }

    public NetworkAttributes(Inet4Address assignedV4Address, Long assignedV4AddressExpiry, String cluster, List<InetAddress> dnsAddresses, Integer mtu, IPv6ProvisioningLossQuirk ipv6ProvisioningLossQuirk) {
        if (mtu != null) goto L5;
    L9:
        if (assignedV4AddressExpiry != null) goto L11;
    L15:
        this.assignedV4Address = assignedV4Address;
        this.assignedV4AddressExpiry = assignedV4AddressExpiry;
        this.cluster = cluster;
        if (dnsAddresses != null) goto L18;
        List<InetAddress> r0 = null;
    L19:
        this.dnsAddresses = r0;
        this.mtu = mtu;
        this.ipv6ProvisioningLossQuirk = ipv6ProvisioningLossQuirk;
        return;
    L18:
        r0 = Collections.unmodifiableList(new ArrayList(dnsAddresses));
        goto L19
    L11:
        if (assignedV4AddressExpiry.longValue() > 0) goto L15;
        throw new IllegalArgumentException("lease expiry can't be negative or zero");
    L5:
        if (mtu.intValue() >= 0) goto L9;
        throw new IllegalArgumentException("MTU can't be negative");
    }

    public NetworkAttributes(NetworkAttributesParcelable parcelable) {
        Inet4Address r2 = (Inet4Address) getByAddressOrNull(parcelable.assignedV4Address);
        Integer r1 = null;
        if (parcelable.assignedV4AddressExpiry <= 0) goto L5;
        Long r3 = Long.valueOf(parcelable.assignedV4AddressExpiry);
    L6:
        String r4 = parcelable.cluster;
        List<InetAddress> r5 = blobArrayToInetAddressList(parcelable.dnsAddresses);
        if (parcelable.mtu < 0) goto L9;
        r1 = Integer.valueOf(parcelable.mtu);
    L9:
        this(r2, r3, r4, r5, r1, IPv6ProvisioningLossQuirk.fromStableParcelable(parcelable.ipv6ProvisioningLossQuirk));
        return;
    L5:
        r3 = null;
        goto L6
    }

    private static InetAddress getByAddressOrNull(byte[] address) {
        if (address != null) goto L9;
        return null;
    L9:
        return InetAddress.getByAddress(address);
    L8:
        return null;
    }

    private static List<InetAddress> blobArrayToInetAddressList(Blob[] blobs) {
        if (blobs != null) goto L5;
        return null;
    L5:
        ArrayList<InetAddress> list = new ArrayList(blobs.length);
        int r1 = blobs.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        Blob b = blobs[r2];
        InetAddress addr = getByAddressOrNull(b.data);
        if (addr == null) goto L10;
        list.add(addr);
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        return list;
    }

    private static Blob[] inetAddressListToBlobArray(List<InetAddress> addresses) {
        if (addresses != null) goto L5;
        return null;
    L5:
        ArrayList<Blob> blobs = new ArrayList();
        int i = 0;
    L7:
        if (i >= addresses.size()) goto L14;
        InetAddress addr = addresses.get(i);
        if (addr == null) goto L12;
        Blob b = new Blob();
        b.data = addr.getAddress();
        blobs.add(b);
    L12:
        i = i + 1;
        goto L7
    L14:
        return (Blob[]) blobs.toArray(new Blob[0]);
    }

    public NetworkAttributesParcelable toParcelable() {
        NetworkAttributesParcelable parcelable = new NetworkAttributesParcelable();
        IPv6ProvisioningLossQuirkParcelable r2 = null;
        if (this.assignedV4Address != null) goto L5;
        byte[] r1 = null;
    L6:
        parcelable.assignedV4Address = r1;
        if (this.assignedV4AddressExpiry != null) goto L9;
        long r3 = 0;
    L10:
        parcelable.assignedV4AddressExpiry = r3;
        parcelable.cluster = this.cluster;
        parcelable.dnsAddresses = inetAddressListToBlobArray(this.dnsAddresses);
        if (this.mtu != null) goto L13;
        int r4 = -1;
    L14:
        parcelable.mtu = r4;
        if (this.ipv6ProvisioningLossQuirk == null) goto L18;
        r2 = this.ipv6ProvisioningLossQuirk.toStableParcelable();
    L18:
        parcelable.ipv6ProvisioningLossQuirk = r2;
        return parcelable;
    L13:
        r4 = this.mtu.intValue();
        goto L14
    L9:
        r3 = this.assignedV4AddressExpiry.longValue();
        goto L10
    L5:
        r1 = this.assignedV4Address.getAddress();
        goto L6
    }

    private float samenessContribution(float weight, Object o1, Object o2) {
        if (o1 != null) goto L8;
        if (o2 == null) goto L6;
        return WEIGHT_ASSIGNEDV4ADDREXPIRY;
    L6:
        return NULL_MATCH_WEIGHT * weight;
    L8:
        if (Objects.equals(o1, o2) == true) goto L10;
        return WEIGHT_ASSIGNEDV4ADDREXPIRY;
    L10:
        return weight;
    }

    public float getNetworkGroupSamenessConfidence(NetworkAttributes o) {
        float samenessScore = ((((samenessContribution(300.0f, this.assignedV4Address, o.assignedV4Address) + samenessContribution(WEIGHT_ASSIGNEDV4ADDREXPIRY, this.assignedV4AddressExpiry, o.assignedV4AddressExpiry)) + samenessContribution(300.0f, this.cluster, o.cluster)) + samenessContribution(WEIGHT_DNSADDRESSES, this.dnsAddresses, o.dnsAddresses)) + samenessContribution(WEIGHT_MTU, this.mtu, o.mtu)) + samenessContribution(WEIGHT_ASSIGNEDV4ADDREXPIRY, this.ipv6ProvisioningLossQuirk, o.ipv6ProvisioningLossQuirk);
        if (samenessScore >= TOTAL_WEIGHT_CUTOFF) goto L7;
        return samenessScore / 1040.0f;
    L7:
        return (((samenessScore - TOTAL_WEIGHT_CUTOFF) / 330.0f) / 2.0f) + 0.5f;
    }

    public boolean isEmpty() {
        if (this.assignedV4Address == null) goto L5;
    L15:
        return false;
    L5:
        if (this.assignedV4AddressExpiry != null) goto L15;
        if (this.cluster != null) goto L15;
        if (this.dnsAddresses != null) goto L15;
        if (this.mtu != null) goto L15;
        if (this.ipv6ProvisioningLossQuirk != null) goto L15;
        return true;
    }

    public boolean equals(Object o) {
        if ((o instanceof NetworkAttributes) == true) goto L5;
        return false;
    L5:
        NetworkAttributes other = (NetworkAttributes) o;
        if (Objects.equals(this.assignedV4Address, other.assignedV4Address) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(this.assignedV4AddressExpiry, other.assignedV4AddressExpiry) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(this.cluster, other.cluster) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(this.dnsAddresses, other.dnsAddresses) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(this.mtu, other.mtu) == true) goto L16;
        return false;
    L16:
        if (Objects.equals(this.ipv6ProvisioningLossQuirk, other.ipv6ProvisioningLossQuirk) == false) goto L25;
        return true;
    L25:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.assignedV4Address, this.assignedV4AddressExpiry, this.cluster, this.dnsAddresses, this.mtu, this.ipv6ProvisioningLossQuirk});
    }

    public String toString() {
        StringJoiner resultJoiner = new StringJoiner(" ", "{", "}");
        ArrayList<String> nullFields = new ArrayList();
        if (this.assignedV4Address == null) goto L5;
        resultJoiner.add("assignedV4Addr :");
        resultJoiner.add(this.assignedV4Address.toString());
    L7:
        if (this.assignedV4AddressExpiry == null) goto L9;
        resultJoiner.add("assignedV4AddressExpiry :");
        resultJoiner.add(this.assignedV4AddressExpiry.toString());
    L11:
        if (this.cluster == null) goto L13;
        resultJoiner.add("cluster :");
        resultJoiner.add(this.cluster);
    L15:
        if (this.dnsAddresses == null) goto L21;
        resultJoiner.add("dnsAddr : [");
        Iterator<InetAddress> r2 = this.dnsAddresses.iterator();
    L18:
        if (r2.hasNext() == false) goto L20;
        InetAddress addr = r2.next();
        resultJoiner.add(addr.getHostAddress());
        goto L18
    L20:
        resultJoiner.add("]");
    L23:
        if (this.mtu == null) goto L25;
        resultJoiner.add("mtu :");
        resultJoiner.add(this.mtu.toString());
    L27:
        if (this.ipv6ProvisioningLossQuirk == null) goto L29;
        resultJoiner.add("ipv6ProvisioningLossQuirk : [");
        resultJoiner.add(this.ipv6ProvisioningLossQuirk.toString());
        resultJoiner.add("]");
    L31:
        if (nullFields.isEmpty() == true) goto L38;
        resultJoiner.add("; Null fields : [");
        Iterator<String> r3 = nullFields.iterator();
    L34:
        if (r3.hasNext() == false) goto L36;
        String field = r3.next();
        resultJoiner.add(field);
        goto L34
    L36:
        resultJoiner.add("]");
    L38:
        return resultJoiner.toString();
    L29:
        nullFields.add("ipv6ProvisioningLossQuirk");
        goto L31
    L25:
        nullFields.add("mtu");
        goto L27
    L21:
        nullFields.add("dnsAddr");
        goto L23
    L13:
        nullFields.add("cluster");
        goto L15
    L9:
        nullFields.add("assignedV4AddressExpiry");
        goto L11
    L5:
        nullFields.add("assignedV4Addr");
        goto L7
    }
}
