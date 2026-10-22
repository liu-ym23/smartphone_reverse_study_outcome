package io.ktor.client.plugins;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@KtorDsl
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB-\b\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R(\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006\u001f"}, d2 = {"Lio/ktor/client/plugins/HttpTimeoutConfig;", "", "", "requestTimeoutMillis", "connectTimeoutMillis", "socketTimeoutMillis", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", UxipConstants.f30680s, "checkTimeoutValue", "(Ljava/lang/Long;)Ljava/lang/Long;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "_requestTimeoutMillis", "Ljava/lang/Long;", "_connectTimeoutMillis", "_socketTimeoutMillis", "getRequestTimeoutMillis", "()Ljava/lang/Long;", "setRequestTimeoutMillis", "(Ljava/lang/Long;)V", "getConnectTimeoutMillis", "setConnectTimeoutMillis", "getSocketTimeoutMillis", "setSocketTimeoutMillis", "Companion", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpTimeoutConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    public static final long INFINITE_TIMEOUT_MS = Long.MAX_VALUE;
    private static final AttributeKey<HttpTimeoutConfig> key;
    private Long _connectTimeoutMillis;
    private Long _requestTimeoutMillis;
    private Long _socketTimeoutMillis;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/client/plugins/HttpTimeoutConfig$Companion;", "", "<init>", "()V", "", "INFINITE_TIMEOUT_MS", "J", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/plugins/HttpTimeoutConfig;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AttributeKey<HttpTimeoutConfig> getKey() {
            return HttpTimeoutConfig.key;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        InterfaceC5755n interfaceC5755nM = null;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(HttpTimeoutConfig.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(HttpTimeoutConfig.class);
        } catch (Throwable unused) {
        }
        key = new AttributeKey<>("TimeoutConfiguration", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
    }

    public /* synthetic */ HttpTimeoutConfig(Long l10, Long l11, Long l12, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : l11, (i10 & 4) != 0 ? null : l12);
    }

    private final Long checkTimeoutValue(Long value) {
        if (value == null || value.longValue() > 0) {
            return value;
        }
        throw new IllegalArgumentException("Only positive timeout values are allowed, for infinite timeout use HttpTimeoutConfig.INFINITE_TIMEOUT_MS");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || HttpTimeoutConfig.class != other.getClass()) {
            return false;
        }
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) other;
        return kotlin.jvm.internal.p.d(this._requestTimeoutMillis, httpTimeoutConfig._requestTimeoutMillis) && kotlin.jvm.internal.p.d(this._connectTimeoutMillis, httpTimeoutConfig._connectTimeoutMillis) && kotlin.jvm.internal.p.d(this._socketTimeoutMillis, httpTimeoutConfig._socketTimeoutMillis);
    }

    /* renamed from: getConnectTimeoutMillis, reason: from getter */
    public final Long get_connectTimeoutMillis() {
        return this._connectTimeoutMillis;
    }

    /* renamed from: getRequestTimeoutMillis, reason: from getter */
    public final Long get_requestTimeoutMillis() {
        return this._requestTimeoutMillis;
    }

    /* renamed from: getSocketTimeoutMillis, reason: from getter */
    public final Long get_socketTimeoutMillis() {
        return this._socketTimeoutMillis;
    }

    public int hashCode() {
        Long l10 = this._requestTimeoutMillis;
        int iHashCode = (l10 != null ? l10.hashCode() : 0) * 31;
        Long l11 = this._connectTimeoutMillis;
        int iHashCode2 = (iHashCode + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this._socketTimeoutMillis;
        return iHashCode2 + (l12 != null ? l12.hashCode() : 0);
    }

    public final void setConnectTimeoutMillis(Long l10) {
        this._connectTimeoutMillis = checkTimeoutValue(l10);
    }

    public final void setRequestTimeoutMillis(Long l10) {
        this._requestTimeoutMillis = checkTimeoutValue(l10);
    }

    public final void setSocketTimeoutMillis(Long l10) {
        this._socketTimeoutMillis = checkTimeoutValue(l10);
    }

    public HttpTimeoutConfig(Long l10, Long l11, Long l12) {
        this._requestTimeoutMillis = 0L;
        this._connectTimeoutMillis = 0L;
        this._socketTimeoutMillis = 0L;
        setRequestTimeoutMillis(l10);
        setConnectTimeoutMillis(l11);
        setSocketTimeoutMillis(l12);
    }
}
