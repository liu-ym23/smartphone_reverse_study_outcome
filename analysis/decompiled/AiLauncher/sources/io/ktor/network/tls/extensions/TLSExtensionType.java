package io.ktor.network.tls.extensions;

import androidx.exifinterface.media.ExifInterface;
import h9.InterfaceC4149a;
import io.ktor.network.tls.TLSException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.i;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\n\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/network/tls/extensions/TLSExtensionType;", "", "", "code", "<init>", "(Ljava/lang/String;IS)V", ExifInterface.LATITUDE_SOUTH, "getCode", "()S", "Companion", "SERVER_NAME", "MAX_FRAGMENT_LENGTH", "CLIENT_CERTIFICATE_URL", "TRUSTED_CA_KEYS", "TRUNCATED_HMAC", "STATUS_REQUEST", "ELLIPTIC_CURVES", "EC_POINT_FORMAT", "SIGNATURE_ALGORITHMS", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TLSExtensionType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TLSExtensionType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final short code;
    public static final TLSExtensionType SERVER_NAME = new TLSExtensionType("SERVER_NAME", 0, 0);
    public static final TLSExtensionType MAX_FRAGMENT_LENGTH = new TLSExtensionType("MAX_FRAGMENT_LENGTH", 1, 1);
    public static final TLSExtensionType CLIENT_CERTIFICATE_URL = new TLSExtensionType("CLIENT_CERTIFICATE_URL", 2, 2);
    public static final TLSExtensionType TRUSTED_CA_KEYS = new TLSExtensionType("TRUSTED_CA_KEYS", 3, 3);
    public static final TLSExtensionType TRUNCATED_HMAC = new TLSExtensionType("TRUNCATED_HMAC", 4, 4);
    public static final TLSExtensionType STATUS_REQUEST = new TLSExtensionType("STATUS_REQUEST", 5, 5);
    public static final TLSExtensionType ELLIPTIC_CURVES = new TLSExtensionType("ELLIPTIC_CURVES", 6, 10);
    public static final TLSExtensionType EC_POINT_FORMAT = new TLSExtensionType("EC_POINT_FORMAT", 7, 11);
    public static final TLSExtensionType SIGNATURE_ALGORITHMS = new TLSExtensionType("SIGNATURE_ALGORITHMS", 8, 13);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/network/tls/extensions/TLSExtensionType$Companion;", "", "<init>", "()V", "", "code", "Lio/ktor/network/tls/extensions/TLSExtensionType;", "byCode", "(I)Lio/ktor/network/tls/extensions/TLSExtensionType;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final TLSExtensionType byCode(int code) throws TLSException {
            TLSExtensionType next;
            Iterator<TLSExtensionType> it = TLSExtensionType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getCode() == ((short) code)) {
                    break;
                }
            }
            TLSExtensionType tLSExtensionType = next;
            if (tLSExtensionType != null) {
                return tLSExtensionType;
            }
            throw new TLSException("Unknown server hello extension type: " + code, null, 2, null);
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ TLSExtensionType[] $values() {
        return new TLSExtensionType[]{SERVER_NAME, MAX_FRAGMENT_LENGTH, CLIENT_CERTIFICATE_URL, TRUSTED_CA_KEYS, TRUNCATED_HMAC, STATUS_REQUEST, ELLIPTIC_CURVES, EC_POINT_FORMAT, SIGNATURE_ALGORITHMS};
    }

    static {
        TLSExtensionType[] tLSExtensionTypeArr$values = $values();
        $VALUES = tLSExtensionTypeArr$values;
        $ENTRIES = a.a(tLSExtensionTypeArr$values);
        INSTANCE = new Companion(null);
    }

    private TLSExtensionType(String str, int i10, short s10) {
        this.code = s10;
    }

    public static InterfaceC4149a<TLSExtensionType> getEntries() {
        return $ENTRIES;
    }

    public static TLSExtensionType valueOf(String str) {
        return (TLSExtensionType) Enum.valueOf(TLSExtensionType.class, str);
    }

    public static TLSExtensionType[] values() {
        return (TLSExtensionType[]) $VALUES.clone();
    }

    public final short getCode() {
        return this.code;
    }
}
