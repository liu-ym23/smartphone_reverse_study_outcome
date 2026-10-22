package io.ktor.network.tls.extensions;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import io.ktor.network.tls.OID;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\u000fR\u0017\u0010\"\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u001b¨\u0006&"}, d2 = {"Lio/ktor/network/tls/extensions/HashAndSign;", "", "Lio/ktor/network/tls/extensions/HashAlgorithm;", "hash", "Lio/ktor/network/tls/extensions/SignatureAlgorithm;", Parameters.UXIP_REQUEST_PARAM_SIGN, "Lio/ktor/network/tls/OID;", "oid", "<init>", "(Lio/ktor/network/tls/extensions/HashAlgorithm;Lio/ktor/network/tls/extensions/SignatureAlgorithm;Lio/ktor/network/tls/OID;)V", "component1", "()Lio/ktor/network/tls/extensions/HashAlgorithm;", "component2", "()Lio/ktor/network/tls/extensions/SignatureAlgorithm;", "component3", "()Lio/ktor/network/tls/OID;", ChatTracker.CLICK_COPY, "(Lio/ktor/network/tls/extensions/HashAlgorithm;Lio/ktor/network/tls/extensions/SignatureAlgorithm;Lio/ktor/network/tls/OID;)Lio/ktor/network/tls/extensions/HashAndSign;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lio/ktor/network/tls/extensions/HashAlgorithm;", "getHash", "Lio/ktor/network/tls/extensions/SignatureAlgorithm;", "getSign", "Lio/ktor/network/tls/OID;", "getOid", "name", "Ljava/lang/String;", "getName", "Companion", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HashAndSign {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final HashAlgorithm hash;
    private final String name;
    private final OID oid;
    private final SignatureAlgorithm sign;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/network/tls/extensions/HashAndSign$Companion;", "", "<init>", "()V", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private Companion() {
        }
    }

    public HashAndSign(HashAlgorithm hash, SignatureAlgorithm sign, OID oid) {
        p.i(hash, "hash");
        p.i(sign, "sign");
        this.hash = hash;
        this.sign = sign;
        this.oid = oid;
        this.name = hash.name() + JsonPOJOBuilder.DEFAULT_WITH_PREFIX + sign.name();
    }

    public static /* synthetic */ HashAndSign copy$default(HashAndSign hashAndSign, HashAlgorithm hashAlgorithm, SignatureAlgorithm signatureAlgorithm, OID oid, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hashAlgorithm = hashAndSign.hash;
        }
        if ((i10 & 2) != 0) {
            signatureAlgorithm = hashAndSign.sign;
        }
        if ((i10 & 4) != 0) {
            oid = hashAndSign.oid;
        }
        return hashAndSign.copy(hashAlgorithm, signatureAlgorithm, oid);
    }

    /* renamed from: component1, reason: from getter */
    public final HashAlgorithm getHash() {
        return this.hash;
    }

    /* renamed from: component2, reason: from getter */
    public final SignatureAlgorithm getSign() {
        return this.sign;
    }

    /* renamed from: component3, reason: from getter */
    public final OID getOid() {
        return this.oid;
    }

    public final HashAndSign copy(HashAlgorithm hash, SignatureAlgorithm sign, OID oid) {
        p.i(hash, "hash");
        p.i(sign, "sign");
        return new HashAndSign(hash, sign, oid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HashAndSign)) {
            return false;
        }
        HashAndSign hashAndSign = (HashAndSign) other;
        return this.hash == hashAndSign.hash && this.sign == hashAndSign.sign && p.d(this.oid, hashAndSign.oid);
    }

    public final HashAlgorithm getHash() {
        return this.hash;
    }

    public final String getName() {
        return this.name;
    }

    public final OID getOid() {
        return this.oid;
    }

    public final SignatureAlgorithm getSign() {
        return this.sign;
    }

    public int hashCode() {
        int iHashCode = ((this.hash.hashCode() * 31) + this.sign.hashCode()) * 31;
        OID oid = this.oid;
        return iHashCode + (oid == null ? 0 : oid.hashCode());
    }

    public String toString() {
        return "HashAndSign(hash=" + this.hash + ", sign=" + this.sign + ", oid=" + this.oid + ')';
    }

    public /* synthetic */ HashAndSign(HashAlgorithm hashAlgorithm, SignatureAlgorithm signatureAlgorithm, OID oid, int i10, i iVar) {
        this(hashAlgorithm, signatureAlgorithm, (i10 & 4) != 0 ? null : oid);
    }
}
