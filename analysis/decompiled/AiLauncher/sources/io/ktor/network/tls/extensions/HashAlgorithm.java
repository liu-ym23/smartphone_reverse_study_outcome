package io.ktor.network.tls.extensions;

import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import io.ktor.network.tls.TLSException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.i;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/network/tls/extensions/HashAlgorithm;", "", "", "code", "", "openSSLName", "macName", "<init>", "(Ljava/lang/String;IBLjava/lang/String;Ljava/lang/String;)V", "B", "getCode", "()B", "Ljava/lang/String;", "getOpenSSLName", "()Ljava/lang/String;", "getMacName", "Companion", ModelFlowMeta.PLAN_NONE, "MD5", "SHA1", "SHA224", "SHA256", "SHA384", "SHA512", "INTRINSIC", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HashAlgorithm {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ HashAlgorithm[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final byte code;
    private final String macName;
    private final String openSSLName;
    public static final HashAlgorithm NONE = new HashAlgorithm(ModelFlowMeta.PLAN_NONE, 0, (byte) 0, "", "");
    public static final HashAlgorithm MD5 = new HashAlgorithm("MD5", 1, (byte) 1, "MD5", "HmacMD5");
    public static final HashAlgorithm SHA1 = new HashAlgorithm("SHA1", 2, (byte) 2, "SHA-1", "HmacSHA1");
    public static final HashAlgorithm SHA224 = new HashAlgorithm("SHA224", 3, (byte) 3, "SHA-224", "HmacSHA224");
    public static final HashAlgorithm SHA256 = new HashAlgorithm("SHA256", 4, (byte) 4, "SHA-256", "HmacSHA256");
    public static final HashAlgorithm SHA384 = new HashAlgorithm("SHA384", 5, (byte) 5, "SHA-384", "HmacSHA384");
    public static final HashAlgorithm SHA512 = new HashAlgorithm("SHA512", 6, (byte) 6, "SHA-512", "HmacSHA512");
    public static final HashAlgorithm INTRINSIC = new HashAlgorithm("INTRINSIC", 7, (byte) 8, "INTRINSIC", "Intrinsic");

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/network/tls/extensions/HashAlgorithm$Companion;", "", "<init>", "()V", "", "code", "Lio/ktor/network/tls/extensions/HashAlgorithm;", "byCode", "(B)Lio/ktor/network/tls/extensions/HashAlgorithm;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final HashAlgorithm byCode(byte code) throws TLSException {
            HashAlgorithm next;
            Iterator<HashAlgorithm> it = HashAlgorithm.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getCode() == code) {
                    break;
                }
            }
            HashAlgorithm hashAlgorithm = next;
            if (hashAlgorithm != null) {
                return hashAlgorithm;
            }
            throw new TLSException("Unknown hash algorithm: " + ((int) code), null, 2, null);
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ HashAlgorithm[] $values() {
        return new HashAlgorithm[]{NONE, MD5, SHA1, SHA224, SHA256, SHA384, SHA512, INTRINSIC};
    }

    static {
        HashAlgorithm[] hashAlgorithmArr$values = $values();
        $VALUES = hashAlgorithmArr$values;
        $ENTRIES = a.a(hashAlgorithmArr$values);
        INSTANCE = new Companion(null);
    }

    private HashAlgorithm(String str, int i10, byte b10, String str2, String str3) {
        this.code = b10;
        this.openSSLName = str2;
        this.macName = str3;
    }

    public static InterfaceC4149a<HashAlgorithm> getEntries() {
        return $ENTRIES;
    }

    public static HashAlgorithm valueOf(String str) {
        return (HashAlgorithm) Enum.valueOf(HashAlgorithm.class, str);
    }

    public static HashAlgorithm[] values() {
        return (HashAlgorithm[]) $VALUES.clone();
    }

    public final byte getCode() {
        return this.code;
    }

    public final String getMacName() {
        return this.macName;
    }

    public final String getOpenSSLName() {
        return this.openSSLName;
    }
}
