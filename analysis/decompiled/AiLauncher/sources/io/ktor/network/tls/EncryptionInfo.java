package io.ktor.network.tls;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.security.PrivateKey;
import java.security.PublicKey;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001c\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\r¨\u0006\u001f"}, d2 = {"Lio/ktor/network/tls/EncryptionInfo;", "", "Ljava/security/PublicKey;", "serverPublic", "clientPublic", "Ljava/security/PrivateKey;", "clientPrivate", "<init>", "(Ljava/security/PublicKey;Ljava/security/PublicKey;Ljava/security/PrivateKey;)V", "component1", "()Ljava/security/PublicKey;", "component2", "component3", "()Ljava/security/PrivateKey;", ChatTracker.CLICK_COPY, "(Ljava/security/PublicKey;Ljava/security/PublicKey;Ljava/security/PrivateKey;)Lio/ktor/network/tls/EncryptionInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/security/PublicKey;", "getServerPublic", "getClientPublic", "Ljava/security/PrivateKey;", "getClientPrivate", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EncryptionInfo {
    private final PrivateKey clientPrivate;
    private final PublicKey clientPublic;
    private final PublicKey serverPublic;

    public EncryptionInfo(PublicKey serverPublic, PublicKey clientPublic, PrivateKey clientPrivate) {
        p.i(serverPublic, "serverPublic");
        p.i(clientPublic, "clientPublic");
        p.i(clientPrivate, "clientPrivate");
        this.serverPublic = serverPublic;
        this.clientPublic = clientPublic;
        this.clientPrivate = clientPrivate;
    }

    public static /* synthetic */ EncryptionInfo copy$default(EncryptionInfo encryptionInfo, PublicKey publicKey, PublicKey publicKey2, PrivateKey privateKey, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            publicKey = encryptionInfo.serverPublic;
        }
        if ((i10 & 2) != 0) {
            publicKey2 = encryptionInfo.clientPublic;
        }
        if ((i10 & 4) != 0) {
            privateKey = encryptionInfo.clientPrivate;
        }
        return encryptionInfo.copy(publicKey, publicKey2, privateKey);
    }

    /* renamed from: component1, reason: from getter */
    public final PublicKey getServerPublic() {
        return this.serverPublic;
    }

    /* renamed from: component2, reason: from getter */
    public final PublicKey getClientPublic() {
        return this.clientPublic;
    }

    /* renamed from: component3, reason: from getter */
    public final PrivateKey getClientPrivate() {
        return this.clientPrivate;
    }

    public final EncryptionInfo copy(PublicKey serverPublic, PublicKey clientPublic, PrivateKey clientPrivate) {
        p.i(serverPublic, "serverPublic");
        p.i(clientPublic, "clientPublic");
        p.i(clientPrivate, "clientPrivate");
        return new EncryptionInfo(serverPublic, clientPublic, clientPrivate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EncryptionInfo)) {
            return false;
        }
        EncryptionInfo encryptionInfo = (EncryptionInfo) other;
        return p.d(this.serverPublic, encryptionInfo.serverPublic) && p.d(this.clientPublic, encryptionInfo.clientPublic) && p.d(this.clientPrivate, encryptionInfo.clientPrivate);
    }

    public final PrivateKey getClientPrivate() {
        return this.clientPrivate;
    }

    public final PublicKey getClientPublic() {
        return this.clientPublic;
    }

    public final PublicKey getServerPublic() {
        return this.serverPublic;
    }

    public int hashCode() {
        return (((this.serverPublic.hashCode() * 31) + this.clientPublic.hashCode()) * 31) + this.clientPrivate.hashCode();
    }

    public String toString() {
        return "EncryptionInfo(serverPublic=" + this.serverPublic + ", clientPublic=" + this.clientPublic + ", clientPrivate=" + this.clientPrivate + ')';
    }
}
