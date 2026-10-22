package io.ktor.network.tls;

import io.ktor.network.tls.extensions.HashAndSign;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/network/tls/CertificateInfo;", "", "", "types", "", "Lio/ktor/network/tls/extensions/HashAndSign;", "hashAndSign", "", "Ljavax/security/auth/x500/X500Principal;", "authorities", "<init>", "([B[Lio/ktor/network/tls/extensions/HashAndSign;Ljava/util/Set;)V", "[B", "getTypes", "()[B", "[Lio/ktor/network/tls/extensions/HashAndSign;", "getHashAndSign", "()[Lio/ktor/network/tls/extensions/HashAndSign;", "Ljava/util/Set;", "getAuthorities", "()Ljava/util/Set;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CertificateInfo {
    private final Set<X500Principal> authorities;
    private final HashAndSign[] hashAndSign;
    private final byte[] types;

    public CertificateInfo(byte[] types, HashAndSign[] hashAndSign, Set<X500Principal> authorities) {
        p.i(types, "types");
        p.i(hashAndSign, "hashAndSign");
        p.i(authorities, "authorities");
        this.types = types;
        this.hashAndSign = hashAndSign;
        this.authorities = authorities;
    }

    public final Set<X500Principal> getAuthorities() {
        return this.authorities;
    }

    public final HashAndSign[] getHashAndSign() {
        return this.hashAndSign;
    }

    public final byte[] getTypes() {
        return this.types;
    }
}
