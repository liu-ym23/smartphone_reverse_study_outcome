package io.ktor.network.tls;

import io.ktor.network.tls.platform.PlatformVersionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003*\n\u0010\u0005\"\u00020\u00042\u00020\u0004*\n\u0010\u0007\"\u00020\u00062\u00020\u0006¨\u0006\b"}, d2 = {"Lio/ktor/network/tls/CipherSuite;", "", "isSupported", "(Lio/ktor/network/tls/CipherSuite;)Z", "Ljavax/net/ssl/SSLException;", "TlsException", "Ljavax/net/ssl/SSLPeerUnverifiedException;", "TlsPeerUnverifiedException", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CipherSuitesJvmKt {
    public static final boolean isSupported(CipherSuite cipherSuite) {
        p.i(cipherSuite, "<this>");
        String major = PlatformVersionKt.getPlatformVersion().getMajor();
        int iHashCode = major.hashCode();
        return iHashCode != 46676283 ? iHashCode != 46677244 ? iHashCode != 46678205 || !major.equals("1.8.0") || PlatformVersionKt.getPlatformVersion().getMinor() >= 161 || cipherSuite.getKeyStrength() <= 128 : !major.equals("1.7.0") || PlatformVersionKt.getPlatformVersion().getMinor() >= 171 || cipherSuite.getKeyStrength() <= 128 : !major.equals("1.6.0") || PlatformVersionKt.getPlatformVersion().getMinor() >= 181 || cipherSuite.getKeyStrength() <= 128;
        return true;
    }
}
