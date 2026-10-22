package io.ktor.network.tls;

import com.autonavi.aps.amapapi.security.Encrypt;
import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lio/ktor/network/tls/SecretExchangeType;", "", "", "jvmName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getJvmName", "()Ljava/lang/String;", "ECDHE", Encrypt.KEY_ALGORITHM, "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SecretExchangeType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SecretExchangeType[] $VALUES;
    public static final SecretExchangeType ECDHE = new SecretExchangeType("ECDHE", 0, "ECDHE_ECDSA");
    public static final SecretExchangeType RSA = new SecretExchangeType(Encrypt.KEY_ALGORITHM, 1, Encrypt.KEY_ALGORITHM);
    private final String jvmName;

    private static final /* synthetic */ SecretExchangeType[] $values() {
        return new SecretExchangeType[]{ECDHE, RSA};
    }

    static {
        SecretExchangeType[] secretExchangeTypeArr$values = $values();
        $VALUES = secretExchangeTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(secretExchangeTypeArr$values);
    }

    private SecretExchangeType(String str, int i10, String str2) {
        this.jvmName = str2;
    }

    public static InterfaceC4149a<SecretExchangeType> getEntries() {
        return $ENTRIES;
    }

    public static SecretExchangeType valueOf(String str) {
        return (SecretExchangeType) Enum.valueOf(SecretExchangeType.class, str);
    }

    public static SecretExchangeType[] values() {
        return (SecretExchangeType[]) $VALUES.clone();
    }

    public final String getJvmName() {
        return this.jvmName;
    }
}
