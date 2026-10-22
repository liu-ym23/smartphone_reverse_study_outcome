package com.stepos.core.ota.crypto;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DecryptRequest {
    private final FekEnvelopeCipher envelope;
    private final CryptoHeader header;
    private final DeviceIdentity identity;
    private final String srcPath;

    public DecryptRequest(String srcPath, CryptoHeader header, FekEnvelopeCipher envelope, DeviceIdentity identity) {
        g.f(srcPath, "srcPath");
        g.f(header, "header");
        g.f(envelope, "envelope");
        g.f(identity, "identity");
        this.srcPath = srcPath;
        this.header = header;
        this.envelope = envelope;
        this.identity = identity;
    }

    public static /* synthetic */ DecryptRequest copy$default(DecryptRequest decryptRequest, String str, CryptoHeader cryptoHeader, FekEnvelopeCipher fekEnvelopeCipher, DeviceIdentity deviceIdentity, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = decryptRequest.srcPath;
        }
        if ((i10 & 2) != 0) {
            cryptoHeader = decryptRequest.header;
        }
        if ((i10 & 4) != 0) {
            fekEnvelopeCipher = decryptRequest.envelope;
        }
        if ((i10 & 8) != 0) {
            deviceIdentity = decryptRequest.identity;
        }
        return decryptRequest.copy(str, cryptoHeader, fekEnvelopeCipher, deviceIdentity);
    }

    public final String component1() {
        return this.srcPath;
    }

    public final CryptoHeader component2() {
        return this.header;
    }

    public final FekEnvelopeCipher component3() {
        return this.envelope;
    }

    public final DeviceIdentity component4() {
        return this.identity;
    }

    public final DecryptRequest copy(String srcPath, CryptoHeader header, FekEnvelopeCipher envelope, DeviceIdentity identity) {
        g.f(srcPath, "srcPath");
        g.f(header, "header");
        g.f(envelope, "envelope");
        g.f(identity, "identity");
        return new DecryptRequest(srcPath, header, envelope, identity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecryptRequest)) {
            return false;
        }
        DecryptRequest decryptRequest = (DecryptRequest) obj;
        return g.b(this.srcPath, decryptRequest.srcPath) && g.b(this.header, decryptRequest.header) && g.b(this.envelope, decryptRequest.envelope) && g.b(this.identity, decryptRequest.identity);
    }

    public final FekEnvelopeCipher getEnvelope() {
        return this.envelope;
    }

    public final CryptoHeader getHeader() {
        return this.header;
    }

    public final DeviceIdentity getIdentity() {
        return this.identity;
    }

    public final String getSrcPath() {
        return this.srcPath;
    }

    public int hashCode() {
        return this.identity.hashCode() + ((this.envelope.hashCode() + ((this.header.hashCode() + (this.srcPath.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        return "DecryptRequest(srcPath=" + this.srcPath + ", header=" + this.header + ", envelope=" + this.envelope + ", identity=" + this.identity + ")";
    }
}
