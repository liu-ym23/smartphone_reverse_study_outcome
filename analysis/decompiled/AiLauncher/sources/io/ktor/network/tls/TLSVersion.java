package io.ktor.network.tls;

import h9.InterfaceC4149a;
import java.util.List;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lio/ktor/network/tls/TLSVersion;", "", "", "code", "<init>", "(Ljava/lang/String;II)V", "I", "getCode", "()I", "Companion", "SSL3", "TLS10", "TLS11", "TLS12", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TLSVersion {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TLSVersion[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final TLSVersion SSL3 = new TLSVersion("SSL3", 0, 768);
    public static final TLSVersion TLS10 = new TLSVersion("TLS10", 1, 769);
    public static final TLSVersion TLS11 = new TLSVersion("TLS11", 2, 770);
    public static final TLSVersion TLS12 = new TLSVersion("TLS12", 3, 771);
    private static final List<TLSVersion> byOrdinal;
    private final int code;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/network/tls/TLSVersion$Companion;", "", "<init>", "()V", "", "code", "Lio/ktor/network/tls/TLSVersion;", "byCode", "(I)Lio/ktor/network/tls/TLSVersion;", "", "byOrdinal", "Ljava/util/List;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final TLSVersion byCode(int code) {
            if (768 <= code && code < 772) {
                return (TLSVersion) TLSVersion.byOrdinal.get(code - 768);
            }
            throw new IllegalArgumentException("Invalid TLS version code " + code);
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ TLSVersion[] $values() {
        return new TLSVersion[]{SSL3, TLS10, TLS11, TLS12};
    }

    static {
        TLSVersion[] tLSVersionArr$values = $values();
        $VALUES = tLSVersionArr$values;
        $ENTRIES = kotlin.enums.a.a(tLSVersionArr$values);
        INSTANCE = new Companion(null);
        byOrdinal = getEntries();
    }

    private TLSVersion(String str, int i10, int i11) {
        this.code = i11;
    }

    public static InterfaceC4149a<TLSVersion> getEntries() {
        return $ENTRIES;
    }

    public static TLSVersion valueOf(String str) {
        return (TLSVersion) Enum.valueOf(TLSVersion.class, str);
    }

    public static TLSVersion[] values() {
        return (TLSVersion[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
