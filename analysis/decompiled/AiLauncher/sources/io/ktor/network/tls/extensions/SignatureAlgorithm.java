package io.ktor.network.tls.extensions;

import com.autonavi.aps.amapapi.security.Encrypt;
import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.i;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0005\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/network/tls/extensions/SignatureAlgorithm;", "", "", "code", "<init>", "(Ljava/lang/String;IB)V", "B", "getCode", "()B", "Companion", "ANON", Encrypt.KEY_ALGORITHM, "DSA", "ECDSA", "ED25519", "ED448", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SignatureAlgorithm {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SignatureAlgorithm[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final byte code;
    public static final SignatureAlgorithm ANON = new SignatureAlgorithm("ANON", 0, (byte) 0);
    public static final SignatureAlgorithm RSA = new SignatureAlgorithm(Encrypt.KEY_ALGORITHM, 1, (byte) 1);
    public static final SignatureAlgorithm DSA = new SignatureAlgorithm("DSA", 2, (byte) 2);
    public static final SignatureAlgorithm ECDSA = new SignatureAlgorithm("ECDSA", 3, (byte) 3);
    public static final SignatureAlgorithm ED25519 = new SignatureAlgorithm("ED25519", 4, (byte) 7);
    public static final SignatureAlgorithm ED448 = new SignatureAlgorithm("ED448", 5, (byte) 8);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/network/tls/extensions/SignatureAlgorithm$Companion;", "", "<init>", "()V", "", "code", "Lio/ktor/network/tls/extensions/SignatureAlgorithm;", "byCode", "(B)Lio/ktor/network/tls/extensions/SignatureAlgorithm;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final SignatureAlgorithm byCode(byte code) {
            SignatureAlgorithm next;
            Iterator<SignatureAlgorithm> it = SignatureAlgorithm.getEntries().iterator();
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
            return next;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SignatureAlgorithm[] $values() {
        return new SignatureAlgorithm[]{ANON, RSA, DSA, ECDSA, ED25519, ED448};
    }

    static {
        SignatureAlgorithm[] signatureAlgorithmArr$values = $values();
        $VALUES = signatureAlgorithmArr$values;
        $ENTRIES = a.a(signatureAlgorithmArr$values);
        INSTANCE = new Companion(null);
    }

    private SignatureAlgorithm(String str, int i10, byte b10) {
        this.code = b10;
    }

    public static InterfaceC4149a<SignatureAlgorithm> getEntries() {
        return $ENTRIES;
    }

    public static SignatureAlgorithm valueOf(String str) {
        return (SignatureAlgorithm) Enum.valueOf(SignatureAlgorithm.class, str);
    }

    public static SignatureAlgorithm[] values() {
        return (SignatureAlgorithm[]) $VALUES.clone();
    }

    public final byte getCode() {
        return this.code;
    }
}
