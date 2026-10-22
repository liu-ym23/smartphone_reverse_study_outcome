package io.ktor.network.tls;

import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b!\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lio/ktor/network/tls/TLSAlertType;", "", "", "code", "<init>", "(Ljava/lang/String;II)V", "I", "getCode", "()I", "Companion", "DecryptionFailed_RESERVED", "CloseNotify", "UnexpectedMessage", "BadRecordMac", "RecordOverflow", "DecompressionFailure", "HandshakeFailure", "NoCertificate_RESERVED", "BadCertificate", "UnsupportedCertificate", "CertificateRevoked", "CertificateExpired", "CertificateUnknown", "IllegalParameter", "UnknownCa", "AccessDenied", "DecodeError", "DecryptError", "ExportRestriction_RESERVED", "ProtocolVersion", "InsufficientSecurity", "InternalError", "UserCanceled", "NoRenegotiation", "UnsupportedExtension", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TLSAlertType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TLSAlertType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final TLSAlertType[] byCode;
    private final int code;
    public static final TLSAlertType DecryptionFailed_RESERVED = new TLSAlertType("DecryptionFailed_RESERVED", 0, 21);
    public static final TLSAlertType CloseNotify = new TLSAlertType("CloseNotify", 1, 0);
    public static final TLSAlertType UnexpectedMessage = new TLSAlertType("UnexpectedMessage", 2, 10);
    public static final TLSAlertType BadRecordMac = new TLSAlertType("BadRecordMac", 3, 20);
    public static final TLSAlertType RecordOverflow = new TLSAlertType("RecordOverflow", 4, 22);
    public static final TLSAlertType DecompressionFailure = new TLSAlertType("DecompressionFailure", 5, 30);
    public static final TLSAlertType HandshakeFailure = new TLSAlertType("HandshakeFailure", 6, 40);
    public static final TLSAlertType NoCertificate_RESERVED = new TLSAlertType("NoCertificate_RESERVED", 7, 41);
    public static final TLSAlertType BadCertificate = new TLSAlertType("BadCertificate", 8, 42);
    public static final TLSAlertType UnsupportedCertificate = new TLSAlertType("UnsupportedCertificate", 9, 43);
    public static final TLSAlertType CertificateRevoked = new TLSAlertType("CertificateRevoked", 10, 44);
    public static final TLSAlertType CertificateExpired = new TLSAlertType("CertificateExpired", 11, 45);
    public static final TLSAlertType CertificateUnknown = new TLSAlertType("CertificateUnknown", 12, 46);
    public static final TLSAlertType IllegalParameter = new TLSAlertType("IllegalParameter", 13, 47);
    public static final TLSAlertType UnknownCa = new TLSAlertType("UnknownCa", 14, 48);
    public static final TLSAlertType AccessDenied = new TLSAlertType("AccessDenied", 15, 49);
    public static final TLSAlertType DecodeError = new TLSAlertType("DecodeError", 16, 50);
    public static final TLSAlertType DecryptError = new TLSAlertType("DecryptError", 17, 51);
    public static final TLSAlertType ExportRestriction_RESERVED = new TLSAlertType("ExportRestriction_RESERVED", 18, 60);
    public static final TLSAlertType ProtocolVersion = new TLSAlertType("ProtocolVersion", 19, 70);
    public static final TLSAlertType InsufficientSecurity = new TLSAlertType("InsufficientSecurity", 20, 71);
    public static final TLSAlertType InternalError = new TLSAlertType("InternalError", 21, 80);
    public static final TLSAlertType UserCanceled = new TLSAlertType("UserCanceled", 22, 90);
    public static final TLSAlertType NoRenegotiation = new TLSAlertType("NoRenegotiation", 23, 100);
    public static final TLSAlertType UnsupportedExtension = new TLSAlertType("UnsupportedExtension", 24, 110);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/network/tls/TLSAlertType$Companion;", "", "<init>", "()V", "", "code", "Lio/ktor/network/tls/TLSAlertType;", "byCode", "(I)Lio/ktor/network/tls/TLSAlertType;", "", "[Lio/ktor/network/tls/TLSAlertType;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final TLSAlertType byCode(int code) {
            TLSAlertType tLSAlertType = (code < 0 || code >= 256) ? null : TLSAlertType.byCode[code];
            if (tLSAlertType != null) {
                return tLSAlertType;
            }
            throw new IllegalArgumentException("Invalid TLS record type code: " + code);
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ TLSAlertType[] $values() {
        return new TLSAlertType[]{DecryptionFailed_RESERVED, CloseNotify, UnexpectedMessage, BadRecordMac, RecordOverflow, DecompressionFailure, HandshakeFailure, NoCertificate_RESERVED, BadCertificate, UnsupportedCertificate, CertificateRevoked, CertificateExpired, CertificateUnknown, IllegalParameter, UnknownCa, AccessDenied, DecodeError, DecryptError, ExportRestriction_RESERVED, ProtocolVersion, InsufficientSecurity, InternalError, UserCanceled, NoRenegotiation, UnsupportedExtension};
    }

    static {
        TLSAlertType next;
        TLSAlertType[] tLSAlertTypeArr$values = $values();
        $VALUES = tLSAlertTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(tLSAlertTypeArr$values);
        INSTANCE = new Companion(null);
        TLSAlertType[] tLSAlertTypeArr = new TLSAlertType[256];
        for (int i10 = 0; i10 < 256; i10++) {
            Iterator<TLSAlertType> it = getEntries().iterator();
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
            tLSAlertTypeArr[i10] = next;
        }
        byCode = tLSAlertTypeArr;
    }

    private TLSAlertType(String str, int i10, int i11) {
        this.code = i11;
    }

    public static InterfaceC4149a<TLSAlertType> getEntries() {
        return $ENTRIES;
    }

    public static TLSAlertType valueOf(String str) {
        return (TLSAlertType) Enum.valueOf(TLSAlertType.class, str);
    }

    public static TLSAlertType[] values() {
        return (TLSAlertType[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
