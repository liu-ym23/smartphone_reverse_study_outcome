package android.net.shared;

import android.net.InetAddresses;
import android.net.InitialConfigurationParcelable;
import android.net.IpPrefix;
import android.net.LinkAddress;
import android.net.RouteInfo;
import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class InitialConfiguration {
    public static final InetAddress INET6_ANY = null;
    private static final int RFC6177_MIN_PREFIX_LENGTH = 48;
    private static final int RFC7421_PREFIX_LENGTH = 64;
    public final Set<IpPrefix> directlyConnectedRoutes;
    public final Set<InetAddress> dnsServers;
    public final Set<LinkAddress> ipAddresses;

    /* JADX INFO: renamed from: $r8$lambda$-X6K-ILFjKgXxX_05B2mmIHvhrU, reason: not valid java name */
    public static /* synthetic */ boolean m39$r8$lambda$X6KILFjKgXxX_05B2mmIHvhrU(Predicate r0, Object r1) {
        return lambda$not$4(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$2qMxQrPX0dtHbvHuDV489De1Fgc(IpPrefix r0) {
        return isIPv6DefaultRoute(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$5lGZQwr6G8-juwLej8cPw15pvTI, reason: not valid java name */
    public static /* synthetic */ boolean m40$r8$lambda$5lGZQwr6G8juwLej8cPw15pvTI(IpPrefix r0, RouteInfo r1) {
        return lambda$isProvisionedBy$3(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$JLWMq8eblO7IxI5SOmNQMRBOH7g(IpPrefix r0) {
        return isPrefixLengthCompliant(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$KVrbl46Ey9msvoRUX4iyAAYZh5s(LinkAddress r0) {
        return isIPv6GUA(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$LrgLnWopeQsqj9tKhvCHfzT_ECg(LinkAddress r0, IpPrefix r1) {
        return lambda$isValid$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$YRvNq_1LvE5TxUPwVnWBxpL-sFE, reason: not valid java name */
    public static /* synthetic */ boolean m41$r8$lambda$YRvNq_1LvE5TxUPwVnWBxpLsFE(LinkAddress r0) {
        return isIPv4(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$aMpq1yL99NDjdK12Fmmvc_TUcBQ(LinkAddress r0) {
        return isPrefixLengthCompliant(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$hXTWt6UzxsyVBxaxeD9FOBlh3MI(LinkAddress r0, LinkAddress r1) {
        return lambda$isProvisionedBy$2(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$ywVtbC09SwFWcOHhEoJjbnmuAY8(InetAddress r0, IpPrefix r1) {
        return lambda$isValid$1(r0, r1);
    }

    public InitialConfiguration() {
        this.ipAddresses = new HashSet();
        this.directlyConnectedRoutes = new HashSet();
        this.dnsServers = new HashSet();
    }

    static {
        INET6_ANY = InetAddresses.parseNumericAddress("::");
    }

    public static InitialConfiguration copy(InitialConfiguration config) {
        if (config != null) goto L5;
        return null;
    L5:
        InitialConfiguration configCopy = new InitialConfiguration();
        configCopy.ipAddresses.addAll(config.ipAddresses);
        configCopy.directlyConnectedRoutes.addAll(config.directlyConnectedRoutes);
        configCopy.dnsServers.addAll(config.dnsServers);
        return configCopy;
    }

    public String toString() {
        return String.format("InitialConfiguration(IPs: {%s}, prefixes: {%s}, DNS: {%s})", new Object[]{TextUtils.join(", ", this.ipAddresses), TextUtils.join(", ", this.directlyConnectedRoutes), TextUtils.join(", ", this.dnsServers)});
    }

    public boolean isValid() {
        if (this.ipAddresses.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<LinkAddress> r0 = this.ipAddresses.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        final LinkAddress addr = r0.next();
        if (any(this.directlyConnectedRoutes, new InitialConfiguration$$ExternalSyntheticLambda0(addr)) == true) goto L7;
        return false;
    L12:
        Iterator<InetAddress> r1 = this.dnsServers.iterator();
    L14:
        if (r1.hasNext() == false) goto L20;
        final InetAddress addr2 = r1.next();
        if (any(this.directlyConnectedRoutes, new InitialConfiguration$$ExternalSyntheticLambda1(addr2)) == true) goto L14;
        return false;
    L20:
        if (any(this.ipAddresses, not(new InitialConfiguration$$ExternalSyntheticLambda2())) == false) goto L23;
        return false;
    L23:
        if (any(this.directlyConnectedRoutes, new InitialConfiguration$$ExternalSyntheticLambda3()) == false) goto L28;
        if (all(this.ipAddresses, not(new InitialConfiguration$$ExternalSyntheticLambda4())) == false) goto L28;
        return false;
    L28:
        if (any(this.directlyConnectedRoutes, not(new InitialConfiguration$$ExternalSyntheticLambda5())) == false) goto L31;
        return false;
    L31:
        if (this.ipAddresses.stream().filter(new InitialConfiguration$$ExternalSyntheticLambda6()).count() <= 1) goto L33;
        return false;
    L33:
        return true;
    }

    private static /* synthetic */ boolean lambda$isValid$0(LinkAddress addr, IpPrefix p) {
        return p.contains(addr.getAddress());
    }

    private static /* synthetic */ boolean lambda$isValid$1(InetAddress addr, IpPrefix p) {
        return p.contains(addr);
    }

    public boolean isProvisionedBy(List<LinkAddress> addresses, List<RouteInfo> routes) {
        if (this.ipAddresses.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<LinkAddress> r0 = this.ipAddresses.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        final LinkAddress addr = r0.next();
        if (any(addresses, new InitialConfiguration$$ExternalSyntheticLambda9(addr)) == true) goto L7;
        return false;
    L12:
        if (routes == null) goto L20;
        Iterator<IpPrefix> r1 = this.directlyConnectedRoutes.iterator();
    L15:
        if (r1.hasNext() == false) goto L28;
        final IpPrefix prefix = r1.next();
        if (any(routes, new InitialConfiguration$$ExternalSyntheticLambda10(prefix)) == true) goto L15;
        return false;
    L28:
        return true;
    L20:
        return true;
    }

    private static /* synthetic */ boolean lambda$isProvisionedBy$2(LinkAddress addr, LinkAddress addrSeen) {
        return addr.isSameAddressAs(addrSeen);
    }

    private static /* synthetic */ boolean lambda$isProvisionedBy$3(IpPrefix prefix, RouteInfo routeSeen) {
        return isDirectlyConnectedRoute(routeSeen, prefix);
    }

    public InitialConfigurationParcelable toStableParcelable() {
        InitialConfigurationParcelable p = new InitialConfigurationParcelable();
        p.ipAddresses = (LinkAddress[]) this.ipAddresses.toArray(new LinkAddress[0]);
        p.directlyConnectedRoutes = (IpPrefix[]) this.directlyConnectedRoutes.toArray(new IpPrefix[0]);
        p.dnsServers = (String[]) ParcelableUtil.toParcelableArray(this.dnsServers, new InitialConfiguration$$ExternalSyntheticLambda11(), String.class);
        return p;
    }

    public static InitialConfiguration fromStableParcelable(InitialConfigurationParcelable p) {
        if (p != null) goto L5;
        return null;
    L5:
        InitialConfiguration config = new InitialConfiguration();
        config.ipAddresses.addAll(Arrays.asList(p.ipAddresses));
        config.directlyConnectedRoutes.addAll(Arrays.asList(p.directlyConnectedRoutes));
        config.dnsServers.addAll(ParcelableUtil.fromParcelableArray(p.dnsServers, new InitialConfiguration$$ExternalSyntheticLambda8()));
        return config;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof InitialConfiguration) == true) goto L5;
        return false;
    L5:
        InitialConfiguration other = (InitialConfiguration) obj;
        if (this.ipAddresses.equals(other.ipAddresses) == true) goto L8;
        return false;
    L8:
        if (this.directlyConnectedRoutes.equals(other.directlyConnectedRoutes) == true) goto L10;
        return false;
    L10:
        if (this.dnsServers.equals(other.dnsServers) == false) goto L16;
        return true;
    L16:
        return false;
    }

    private static boolean isDirectlyConnectedRoute(RouteInfo route, IpPrefix prefix) {
        if (route.hasGateway() == false) goto L5;
    L9:
        return false;
    L5:
        if (route.getType() != 1) goto L9;
        if (prefix.equals(route.getDestination()) == false) goto L9;
        return true;
    }

    private static boolean isPrefixLengthCompliant(LinkAddress addr) {
        if (isIPv4(addr) == false) goto L5;
    L8:
        return true;
    L5:
        if (isCompliantIPv6PrefixLength(addr.getPrefixLength()) == true) goto L8;
        return false;
    }

    private static boolean isPrefixLengthCompliant(IpPrefix prefix) {
        if (isIPv4(prefix) == false) goto L5;
    L8:
        return true;
    L5:
        if (isCompliantIPv6PrefixLength(prefix.getPrefixLength()) == true) goto L8;
        return false;
    }

    private static boolean isCompliantIPv6PrefixLength(int prefixLength) {
        if (48 <= prefixLength) goto L5;
    L7:
        return false;
    L5:
        if (prefixLength > 64) goto L7;
        return true;
    }

    private static boolean isIPv4(IpPrefix prefix) {
        return prefix.getAddress() instanceof Inet4Address;
    }

    private static boolean isIPv4(LinkAddress addr) {
        return addr.getAddress() instanceof Inet4Address;
    }

    private static boolean isIPv6DefaultRoute(IpPrefix prefix) {
        return prefix.getAddress().equals(INET6_ANY);
    }

    private static boolean isIPv6GUA(LinkAddress addr) {
        if (addr.isIpv6() == true) goto L5;
    L7:
        return false;
    L5:
        if (addr.isGlobalPreferred() == false) goto L7;
        return true;
    }

    public static <T> boolean any(Iterable<T> coll, Predicate<T> fn) {
        Iterator<T> r0 = coll.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        T t = r0.next();
        if (fn.test(t) == false) goto L4;
        return true;
    L10:
        return false;
    }

    public static <T> boolean all(Iterable<T> coll, Predicate<T> fn) {
        return !any(coll, not(fn));
    }

    private static /* synthetic */ boolean lambda$not$4(Predicate fn, Object t) {
        return !fn.test(t);
    }

    public static <T> Predicate<T> not(final Predicate<T> fn) {
        return new InitialConfiguration$$ExternalSyntheticLambda7(fn);
    }
}
