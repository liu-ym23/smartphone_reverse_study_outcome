package com.android.server.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Ikev2VpnProfile;
import android.net.InetAddresses;
import android.net.IpPrefix;
import android.net.IpSecTransform;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.RouteInfo;
import android.net.eap.EapSessionConfig;
import android.net.ipsec.ike.ChildSaProposal;
import android.net.ipsec.ike.ChildSessionCallback;
import android.net.ipsec.ike.ChildSessionConfiguration;
import android.net.ipsec.ike.ChildSessionParams;
import android.net.ipsec.ike.IkeFqdnIdentification;
import android.net.ipsec.ike.IkeIdentification;
import android.net.ipsec.ike.IkeIpv4AddrIdentification;
import android.net.ipsec.ike.IkeIpv6AddrIdentification;
import android.net.ipsec.ike.IkeKeyIdIdentification;
import android.net.ipsec.ike.IkeRfc822AddrIdentification;
import android.net.ipsec.ike.IkeSaProposal;
import android.net.ipsec.ike.IkeSessionCallback;
import android.net.ipsec.ike.IkeSessionConfiguration;
import android.net.ipsec.ike.IkeSessionConnectionInfo;
import android.net.ipsec.ike.IkeSessionParams;
import android.net.ipsec.ike.IkeTrafficSelector;
import android.net.ipsec.ike.TunnelModeChildSessionParams;
import android.net.ipsec.ike.exceptions.IkeException;
import android.net.ipsec.ike.exceptions.IkeProtocolException;
import android.system.OsConstants;
import android.util.Log;
import com.android.internal.util.HexDump;
import com.android.net.module.util.IpRange;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class VpnIkev2Utils {
    private static final String TAG = null;

    static class ChildSessionCallbackImpl implements ChildSessionCallback {
        private final Vpn.IkeV2VpnRunnerCallback mCallback;
        private final String mTag;
        private final int mToken;

        ChildSessionCallbackImpl(String tag, Vpn.IkeV2VpnRunnerCallback callback, int token) {
            this.mTag = tag;
            this.mCallback = callback;
            this.mToken = token;
        }

        @Override // android.net.ipsec.ike.ChildSessionCallback
        public void onOpened(ChildSessionConfiguration childConfig) {
            Log.d(this.mTag, "ChildOpened for token " + this.mToken);
            this.mCallback.onChildOpened(this.mToken, childConfig);
        }

        @Override // android.net.ipsec.ike.ChildSessionCallback
        public void onClosed() {
            Log.d(this.mTag, "ChildClosed for token " + this.mToken);
            this.mCallback.onSessionLost(this.mToken, null);
        }

        public void onClosedExceptionally(IkeException exception) {
            Log.d(this.mTag, "ChildClosedExceptionally for token " + this.mToken, exception);
            this.mCallback.onSessionLost(this.mToken, exception);
        }

        @Override // android.net.ipsec.ike.ChildSessionCallback
        public void onIpSecTransformCreated(IpSecTransform transform, int direction) {
            Log.d(this.mTag, "ChildTransformCreated; Direction: " + direction + "; token " + this.mToken);
            this.mCallback.onChildTransformCreated(this.mToken, transform, direction);
        }

        @Override // android.net.ipsec.ike.ChildSessionCallback
        public void onIpSecTransformDeleted(IpSecTransform transform, int direction) {
            Log.d(this.mTag, "ChildTransformDeleted; Direction: " + direction + "; for token " + this.mToken);
        }

        public void onIpSecTransformsMigrated(IpSecTransform inIpSecTransform, IpSecTransform outIpSecTransform) {
            Log.d(this.mTag, "ChildTransformsMigrated; token " + this.mToken);
            this.mCallback.onChildMigrated(this.mToken, inIpSecTransform, outIpSecTransform);
        }
    }

    static class IkeSessionCallbackImpl implements IkeSessionCallback {
        private final Vpn.IkeV2VpnRunnerCallback mCallback;
        private final String mTag;
        private final int mToken;

        IkeSessionCallbackImpl(String tag, Vpn.IkeV2VpnRunnerCallback callback, int token) {
            this.mTag = tag;
            this.mCallback = callback;
            this.mToken = token;
        }

        @Override // android.net.ipsec.ike.IkeSessionCallback
        public void onOpened(IkeSessionConfiguration ikeSessionConfig) {
            Log.d(this.mTag, "IkeOpened for token " + this.mToken);
            this.mCallback.onIkeOpened(this.mToken, ikeSessionConfig);
        }

        @Override // android.net.ipsec.ike.IkeSessionCallback
        public void onClosed() {
            Log.d(this.mTag, "IkeClosed for token " + this.mToken);
            this.mCallback.onSessionLost(this.mToken, null);
        }

        public void onClosedExceptionally(IkeException exception) {
            Log.d(this.mTag, "IkeClosedExceptionally for token " + this.mToken, exception);
            this.mCallback.onSessionLost(this.mToken, exception);
        }

        public void onError(IkeProtocolException exception) {
            Log.d(this.mTag, "IkeError for token " + this.mToken, exception);
        }

        public void onIkeSessionConnectionInfoChanged(IkeSessionConnectionInfo connectionInfo) {
            Log.d(this.mTag, "onIkeSessionConnectionInfoChanged for token " + this.mToken);
            this.mCallback.onIkeConnectionInfoChanged(this.mToken, connectionInfo);
        }
    }

    static class Ikev2VpnNetworkCallback extends ConnectivityManager.NetworkCallback {
        private final Vpn.IkeV2VpnRunnerCallback mCallback;
        private final Executor mExecutor;
        private final String mTag;

        /* JADX INFO: renamed from: $r8$lambda$1DzUN_WqclhK_AkplcjQ79U-eVo, reason: not valid java name */
        public static /* synthetic */ void m3137$r8$lambda$1DzUN_WqclhK_AkplcjQ79UeVo(Ikev2VpnNetworkCallback r0, NetworkCapabilities r1) {
            r0.lambda$onCapabilitiesChanged$1(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$TAZntHUi8DRjqQIC098q-t34Hrg, reason: not valid java name */
        public static /* synthetic */ void m3138$r8$lambda$TAZntHUi8DRjqQIC098qt34Hrg(Ikev2VpnNetworkCallback r0, Network r1) {
            r0.lambda$onAvailable$0(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$c7F6DFbW9AIQIMSOOooepBc-Vrg, reason: not valid java name */
        public static /* synthetic */ void m3139$r8$lambda$c7F6DFbW9AIQIMSOOooepBcVrg(Ikev2VpnNetworkCallback r0, Network r1) {
            r0.lambda$onLost$3(r1);
        }

        public static /* synthetic */ void $r8$lambda$qNFOMYY48nzYgOOwNuUCGsvKA00(Ikev2VpnNetworkCallback r0, LinkProperties r1) {
            r0.lambda$onLinkPropertiesChanged$2(r1);
        }

        Ikev2VpnNetworkCallback(String tag, Vpn.IkeV2VpnRunnerCallback callback, Executor executor) {
            this.mTag = tag;
            this.mCallback = callback;
            this.mExecutor = executor;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(final Network network) {
            Log.d(this.mTag, "onAvailable called for network: " + network);
            this.mExecutor.execute(new VpnIkev2Utils$Ikev2VpnNetworkCallback$$ExternalSyntheticLambda1(this, network));
        }

        private /* synthetic */ void lambda$onAvailable$0(Network network) {
            this.mCallback.onDefaultNetworkChanged(network);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, final NetworkCapabilities networkCapabilities) {
            Log.d(this.mTag, "NC changed for net " + network + " : " + networkCapabilities);
            this.mExecutor.execute(new VpnIkev2Utils$Ikev2VpnNetworkCallback$$ExternalSyntheticLambda2(this, networkCapabilities));
        }

        private /* synthetic */ void lambda$onCapabilitiesChanged$1(NetworkCapabilities networkCapabilities) {
            this.mCallback.onDefaultNetworkCapabilitiesChanged(networkCapabilities);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, final LinkProperties linkProperties) {
            Log.d(this.mTag, "LP changed for net " + network + " : " + linkProperties);
            this.mExecutor.execute(new VpnIkev2Utils$Ikev2VpnNetworkCallback$$ExternalSyntheticLambda0(this, linkProperties));
        }

        private /* synthetic */ void lambda$onLinkPropertiesChanged$2(LinkProperties linkProperties) {
            this.mCallback.onDefaultNetworkLinkPropertiesChanged(linkProperties);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network network) {
            Log.d(this.mTag, "onLost called for network: " + network);
            this.mExecutor.execute(new VpnIkev2Utils$Ikev2VpnNetworkCallback$$ExternalSyntheticLambda3(this, network));
        }

        private /* synthetic */ void lambda$onLost$3(Network network) {
            this.mCallback.onDefaultNetworkLost(network);
        }
    }

    public VpnIkev2Utils() {
    }

    static {
        TAG = VpnIkev2Utils.class.getSimpleName();
    }

    static IkeSessionParams.Builder makeIkeSessionParamsBuilder(Context context, Ikev2VpnProfile profile, Network network) {
        IkeIdentification localId = parseIkeIdentification(profile.getUserIdentity());
        IkeIdentification remoteId = parseIkeIdentification(profile.getServerAddr());
        IkeSessionParams.Builder ikeOptionsBuilder = new IkeSessionParams.Builder(context).setServerHostname(profile.getServerAddr()).setNetwork(network).addIkeOption(2).setLocalIdentification(localId).setRemoteIdentification(remoteId);
        setIkeAuth(profile, ikeOptionsBuilder);
        Iterator<IkeSaProposal> r3 = getIkeSaProposals().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        IkeSaProposal ikeProposal = r3.next();
        ikeOptionsBuilder.addSaProposal(ikeProposal);
        goto L4
    L6:
        return ikeOptionsBuilder;
    }

    static ChildSessionParams buildChildSessionParams(List<String> allowedAlgorithms) {
        TunnelModeChildSessionParams.Builder childOptionsBuilder = new TunnelModeChildSessionParams.Builder();
        Iterator<ChildSaProposal> r1 = getChildSaProposals(allowedAlgorithms).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ChildSaProposal childProposal = r1.next();
        childOptionsBuilder.addSaProposal(childProposal);
        goto L4
    L6:
        childOptionsBuilder.addInternalAddressRequest(OsConstants.AF_INET);
        childOptionsBuilder.addInternalAddressRequest(OsConstants.AF_INET6);
        childOptionsBuilder.addInternalDnsServerRequest(OsConstants.AF_INET);
        childOptionsBuilder.addInternalDnsServerRequest(OsConstants.AF_INET6);
        return childOptionsBuilder.build();
    }

    private static void setIkeAuth(Ikev2VpnProfile profile, IkeSessionParams.Builder builder) {
        switch(profile.getType()) {
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        builder.setAuthDigitalSignature(profile.getServerRootCaCert(), profile.getUserCert(), profile.getRsaPrivateKey());
        return;
    L7:
        builder.setAuthPsk(profile.getPresharedKey());
        return;
    L8:
        EapSessionConfig eapConfig = new EapSessionConfig.Builder().setEapMsChapV2Config(profile.getUsername(), profile.getPassword()).build();
        builder.setAuthEap(profile.getServerRootCaCert(), eapConfig);
        return;
    L5:
        throw new IllegalArgumentException("Unknown auth method set");
    }

    private static List<IkeSaProposal> getIkeSaProposals() {
        List<IkeSaProposal> proposals = new ArrayList();
        IkeSaProposal.Builder normalModeBuilder = new IkeSaProposal.Builder();
        normalModeBuilder.addEncryptionAlgorithm(13, 256);
        normalModeBuilder.addEncryptionAlgorithm(12, 256);
        normalModeBuilder.addEncryptionAlgorithm(13, 192);
        normalModeBuilder.addEncryptionAlgorithm(12, 192);
        normalModeBuilder.addEncryptionAlgorithm(13, 128);
        normalModeBuilder.addEncryptionAlgorithm(12, 128);
        normalModeBuilder.addIntegrityAlgorithm(14);
        normalModeBuilder.addIntegrityAlgorithm(13);
        normalModeBuilder.addIntegrityAlgorithm(12);
        normalModeBuilder.addIntegrityAlgorithm(5);
        normalModeBuilder.addIntegrityAlgorithm(8);
        IkeSaProposal.Builder aeadBuilder = new IkeSaProposal.Builder();
        aeadBuilder.addEncryptionAlgorithm(28, 0);
        aeadBuilder.addEncryptionAlgorithm(20, 256);
        aeadBuilder.addEncryptionAlgorithm(19, 256);
        aeadBuilder.addEncryptionAlgorithm(18, 256);
        aeadBuilder.addEncryptionAlgorithm(20, 192);
        aeadBuilder.addEncryptionAlgorithm(19, 192);
        aeadBuilder.addEncryptionAlgorithm(18, 192);
        aeadBuilder.addEncryptionAlgorithm(20, 128);
        aeadBuilder.addEncryptionAlgorithm(19, 128);
        aeadBuilder.addEncryptionAlgorithm(18, 128);
        Iterator r5 = Arrays.asList(new IkeSaProposal.Builder[]{normalModeBuilder, aeadBuilder}).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        IkeSaProposal.Builder builder = (IkeSaProposal.Builder) r5.next();
        builder.addDhGroup(16);
        builder.addDhGroup(31);
        builder.addDhGroup(15);
        builder.addDhGroup(14);
        builder.addPseudorandomFunction(7);
        builder.addPseudorandomFunction(6);
        builder.addPseudorandomFunction(5);
        builder.addPseudorandomFunction(4);
        builder.addPseudorandomFunction(8);
        builder.addPseudorandomFunction(2);
        goto L4
    L6:
        proposals.add(normalModeBuilder.build());
        proposals.add(aeadBuilder.build());
        return proposals;
    }

    private static List<ChildSaProposal> getChildSaProposals(List<String> allowedAlgorithms) {
        List<ChildSaProposal> proposals = new ArrayList();
        List<Integer> aesKeyLenOptions = Arrays.asList(new Integer[]{256, 192, 128});
        if (Ikev2VpnProfile.hasNormalModeAlgorithms(allowedAlgorithms) == false) goto L34;
        ChildSaProposal.Builder normalModeBuilder = new ChildSaProposal.Builder();
        Iterator<Integer> r6 = aesKeyLenOptions.iterator();
    L6:
        if (r6.hasNext() == false) goto L15;
        int len = r6.next().intValue();
        if (allowedAlgorithms.contains("rfc3686(ctr(aes))") == false) goto L11;
        normalModeBuilder.addEncryptionAlgorithm(13, len);
    L11:
        if (allowedAlgorithms.contains("cbc(aes)") == false) goto L6;
        normalModeBuilder.addEncryptionAlgorithm(12, len);
        goto L6
    L15:
        if (allowedAlgorithms.contains("hmac(sha512)") == false) goto L18;
        normalModeBuilder.addIntegrityAlgorithm(14);
    L18:
        if (allowedAlgorithms.contains("hmac(sha384)") == false) goto L21;
        normalModeBuilder.addIntegrityAlgorithm(13);
    L21:
        if (allowedAlgorithms.contains("hmac(sha256)") == false) goto L24;
        normalModeBuilder.addIntegrityAlgorithm(12);
    L24:
        if (allowedAlgorithms.contains("xcbc(aes)") == false) goto L27;
        normalModeBuilder.addIntegrityAlgorithm(5);
    L27:
        if (allowedAlgorithms.contains("cmac(aes)") == false) goto L29;
        normalModeBuilder.addIntegrityAlgorithm(8);
    L29:
        ChildSaProposal proposal = normalModeBuilder.build();
        if (proposal.getIntegrityAlgorithms().isEmpty() == false) goto L32;
        Log.wtf(TAG, "Missing integrity algorithm when buildling Child SA proposal");
        goto L34
    L32:
        proposals.add(normalModeBuilder.build());
    L34:
        if (Ikev2VpnProfile.hasAeadAlgorithms(allowedAlgorithms) == false) goto L42;
        ChildSaProposal.Builder aeadBuilder = new ChildSaProposal.Builder();
        if (allowedAlgorithms.contains("rfc7539esp(chacha20,poly1305)") == false) goto L39;
        aeadBuilder.addEncryptionAlgorithm(28, 0);
    L39:
        if (allowedAlgorithms.contains("rfc4106(gcm(aes))") == false) goto L41;
        aeadBuilder.addEncryptionAlgorithm(20, 256);
        aeadBuilder.addEncryptionAlgorithm(19, 256);
        aeadBuilder.addEncryptionAlgorithm(18, 256);
        aeadBuilder.addEncryptionAlgorithm(20, 192);
        aeadBuilder.addEncryptionAlgorithm(19, 192);
        aeadBuilder.addEncryptionAlgorithm(18, 192);
        aeadBuilder.addEncryptionAlgorithm(20, 128);
        aeadBuilder.addEncryptionAlgorithm(19, 128);
        aeadBuilder.addEncryptionAlgorithm(18, 128);
    L41:
        proposals.add(aeadBuilder.build());
    L42:
        return proposals;
    }

    private static IkeIdentification parseIkeIdentification(String identityStr) {
        if (identityStr.contains("@") == false) goto L19;
        if (identityStr.startsWith("@#") == false) goto L9;
        String hexStr = identityStr.substring(2);
        return new IkeKeyIdIdentification(HexDump.hexStringToByteArray(hexStr));
    L9:
        if (identityStr.startsWith("@@") == false) goto L13;
        return new IkeRfc822AddrIdentification(identityStr.substring(2));
    L13:
        if (identityStr.startsWith("@") == false) goto L17;
        return new IkeFqdnIdentification(identityStr.substring(1));
    L17:
        return new IkeRfc822AddrIdentification(identityStr);
    L19:
        if (InetAddresses.isNumericAddress(identityStr) == false) goto L31;
        InetAddress addr = InetAddresses.parseNumericAddress(identityStr);
        if ((addr instanceof Inet4Address) == false) goto L25;
        return new IkeIpv4AddrIdentification((Inet4Address) addr);
    L25:
        if ((addr instanceof Inet6Address) == false) goto L29;
        return new IkeIpv6AddrIdentification((Inet6Address) addr);
    L29:
        throw new IllegalArgumentException("IP version not supported");
    L31:
        if (identityStr.contains(":") == false) goto L35;
        return new IkeKeyIdIdentification(identityStr.getBytes());
    L35:
        return new IkeFqdnIdentification(identityStr);
    }

    static Collection<RouteInfo> getRoutesFromTrafficSelectors(List<IkeTrafficSelector> trafficSelectors) {
        HashSet<RouteInfo> routes = new HashSet();
        Iterator<IkeTrafficSelector> r1 = trafficSelectors.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        IkeTrafficSelector selector = r1.next();
        Iterator r3 = new IpRange(selector.startingAddress, selector.endingAddress).asIpPrefixes().iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        IpPrefix prefix = (IpPrefix) r3.next();
        routes.add(new RouteInfo(prefix, null, null, 1));
        goto L7
    L10:
        return routes;
    }
}
