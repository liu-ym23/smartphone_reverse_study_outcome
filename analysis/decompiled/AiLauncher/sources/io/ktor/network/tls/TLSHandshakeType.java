package io.ktor.network.tls;

import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/network/tls/TLSHandshakeType;", "", "", "code", "<init>", "(Ljava/lang/String;II)V", "I", "getCode", "()I", "Companion", "HelloRequest", "ClientHello", "ServerHello", "Certificate", "ServerKeyExchange", "CertificateRequest", "ServerDone", "CertificateVerify", "ClientKeyExchange", "Finished", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TLSHandshakeType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TLSHandshakeType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final TLSHandshakeType[] byCode;
    private final int code;
    public static final TLSHandshakeType HelloRequest = new TLSHandshakeType("HelloRequest", 0, 0);
    public static final TLSHandshakeType ClientHello = new TLSHandshakeType("ClientHello", 1, 1);
    public static final TLSHandshakeType ServerHello = new TLSHandshakeType("ServerHello", 2, 2);
    public static final TLSHandshakeType Certificate = new TLSHandshakeType("Certificate", 3, 11);
    public static final TLSHandshakeType ServerKeyExchange = new TLSHandshakeType("ServerKeyExchange", 4, 12);
    public static final TLSHandshakeType CertificateRequest = new TLSHandshakeType("CertificateRequest", 5, 13);
    public static final TLSHandshakeType ServerDone = new TLSHandshakeType("ServerDone", 6, 14);
    public static final TLSHandshakeType CertificateVerify = new TLSHandshakeType("CertificateVerify", 7, 15);
    public static final TLSHandshakeType ClientKeyExchange = new TLSHandshakeType("ClientKeyExchange", 8, 16);
    public static final TLSHandshakeType Finished = new TLSHandshakeType("Finished", 9, 20);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/network/tls/TLSHandshakeType$Companion;", "", "<init>", "()V", "", "code", "Lio/ktor/network/tls/TLSHandshakeType;", "byCode", "(I)Lio/ktor/network/tls/TLSHandshakeType;", "", "[Lio/ktor/network/tls/TLSHandshakeType;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final TLSHandshakeType byCode(int code) {
            TLSHandshakeType tLSHandshakeType = (code < 0 || code >= 256) ? null : TLSHandshakeType.byCode[code];
            if (tLSHandshakeType != null) {
                return tLSHandshakeType;
            }
            throw new IllegalArgumentException("Invalid TLS handshake type code: " + code);
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ TLSHandshakeType[] $values() {
        return new TLSHandshakeType[]{HelloRequest, ClientHello, ServerHello, Certificate, ServerKeyExchange, CertificateRequest, ServerDone, CertificateVerify, ClientKeyExchange, Finished};
    }

    static {
        TLSHandshakeType next;
        TLSHandshakeType[] tLSHandshakeTypeArr$values = $values();
        $VALUES = tLSHandshakeTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(tLSHandshakeTypeArr$values);
        INSTANCE = new Companion(null);
        TLSHandshakeType[] tLSHandshakeTypeArr = new TLSHandshakeType[256];
        for (int i10 = 0; i10 < 256; i10++) {
            Iterator<TLSHandshakeType> it = getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (next.code == i10) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            tLSHandshakeTypeArr[i10] = next;
        }
        byCode = tLSHandshakeTypeArr;
    }

    private TLSHandshakeType(String str, int i10, int i11) {
        this.code = i11;
    }

    public static InterfaceC4149a<TLSHandshakeType> getEntries() {
        return $ENTRIES;
    }

    public static TLSHandshakeType valueOf(String str) {
        return (TLSHandshakeType) Enum.valueOf(TLSHandshakeType.class, str);
    }

    public static TLSHandshakeType[] values() {
        return (TLSHandshakeType[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
