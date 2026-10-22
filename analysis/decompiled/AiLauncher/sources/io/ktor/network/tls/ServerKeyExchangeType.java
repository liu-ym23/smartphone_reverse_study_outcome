package io.ktor.network.tls;

import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lio/ktor/network/tls/ServerKeyExchangeType;", "", "", "code", "<init>", "(Ljava/lang/String;II)V", "I", "getCode", "()I", "Companion", "ExplicitPrime", "ExplicitChar", "NamedCurve", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerKeyExchangeType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ServerKeyExchangeType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final ServerKeyExchangeType[] byCode;
    private final int code;
    public static final ServerKeyExchangeType ExplicitPrime = new ServerKeyExchangeType("ExplicitPrime", 0, 1);
    public static final ServerKeyExchangeType ExplicitChar = new ServerKeyExchangeType("ExplicitChar", 1, 2);
    public static final ServerKeyExchangeType NamedCurve = new ServerKeyExchangeType("NamedCurve", 2, 3);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/network/tls/ServerKeyExchangeType$Companion;", "", "<init>", "()V", "", "code", "Lio/ktor/network/tls/ServerKeyExchangeType;", "byCode", "(I)Lio/ktor/network/tls/ServerKeyExchangeType;", "", "[Lio/ktor/network/tls/ServerKeyExchangeType;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ServerKeyExchangeType byCode(int code) {
            ServerKeyExchangeType serverKeyExchangeType = (code < 0 || code >= 256) ? null : ServerKeyExchangeType.byCode[code];
            if (serverKeyExchangeType != null) {
                return serverKeyExchangeType;
            }
            throw new IllegalArgumentException("Invalid TLS ServerKeyExchange type code: " + code);
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ServerKeyExchangeType[] $values() {
        return new ServerKeyExchangeType[]{ExplicitPrime, ExplicitChar, NamedCurve};
    }

    static {
        ServerKeyExchangeType next;
        ServerKeyExchangeType[] serverKeyExchangeTypeArr$values = $values();
        $VALUES = serverKeyExchangeTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(serverKeyExchangeTypeArr$values);
        INSTANCE = new Companion(null);
        ServerKeyExchangeType[] serverKeyExchangeTypeArr = new ServerKeyExchangeType[256];
        for (int i10 = 0; i10 < 256; i10++) {
            Iterator<ServerKeyExchangeType> it = getEntries().iterator();
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
            serverKeyExchangeTypeArr[i10] = next;
        }
        byCode = serverKeyExchangeTypeArr;
    }

    private ServerKeyExchangeType(String str, int i10, int i11) {
        this.code = i11;
    }

    public static InterfaceC4149a<ServerKeyExchangeType> getEntries() {
        return $ENTRIES;
    }

    public static ServerKeyExchangeType valueOf(String str) {
        return (ServerKeyExchangeType) Enum.valueOf(ServerKeyExchangeType.class, str);
    }

    public static ServerKeyExchangeType[] values() {
        return (ServerKeyExchangeType[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
