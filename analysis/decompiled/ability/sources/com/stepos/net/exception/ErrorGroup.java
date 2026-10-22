package com.stepos.net.exception;

import K7.a;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import stepai.android.llm.base.twoway.FlowType;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/net/exception/ErrorGroup;", "", "tag", "", "retriable", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;Z)V", "getTag", "()Ljava/lang/String;", "getRetriable", "()Z", "NETWORK", "AUTH", "RATE_LIMIT", "SERVER", "CLIENT", "PARSE", "BUSINESS", "CANCELED", "UNKNOWN", "Companion", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ErrorGroup {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ErrorGroup[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final boolean retriable;
    private final String tag;
    public static final ErrorGroup NETWORK = new ErrorGroup("NETWORK", 0, "network", true);
    public static final ErrorGroup AUTH = new ErrorGroup("AUTH", 1, "auth", false);
    public static final ErrorGroup RATE_LIMIT = new ErrorGroup("RATE_LIMIT", 2, "rate_limit", true);
    public static final ErrorGroup SERVER = new ErrorGroup("SERVER", 3, "server", true);
    public static final ErrorGroup CLIENT = new ErrorGroup("CLIENT", 4, "client", false);
    public static final ErrorGroup PARSE = new ErrorGroup("PARSE", 5, "parse", false);
    public static final ErrorGroup BUSINESS = new ErrorGroup("BUSINESS", 6, "business", false);
    public static final ErrorGroup CANCELED = new ErrorGroup("CANCELED", 7, FlowType.CANCELED, false);
    public static final ErrorGroup UNKNOWN = new ErrorGroup("UNKNOWN", 8, EnvironmentCompat.MEDIA_UNKNOWN, false);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/net/exception/ErrorGroup$Companion;", "", AppAgent.CONSTRUCT, "()V", "fromCode", "Lcom/stepos/net/exception/ErrorGroup;", "code", "", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final ErrorGroup fromCode(int code) {
            return code == -1004 ? ErrorGroup.CANCELED : (code == -1000 || code == -1001 || code == -1002) ? ErrorGroup.NETWORK : code == -1003 ? ErrorGroup.PARSE : code == -3000 ? ErrorGroup.BUSINESS : code == -2000 ? ErrorGroup.CLIENT : (401 > code || code >= 404) ? code == 429 ? ErrorGroup.RATE_LIMIT : (500 > code || code >= 600) ? (400 > code || code >= 500) ? ErrorGroup.UNKNOWN : ErrorGroup.CLIENT : ErrorGroup.SERVER : ErrorGroup.AUTH;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ErrorGroup[] $values() {
        return new ErrorGroup[]{NETWORK, AUTH, RATE_LIMIT, SERVER, CLIENT, PARSE, BUSINESS, CANCELED, UNKNOWN};
    }

    static {
        ErrorGroup[] errorGroupArr$values = $values();
        $VALUES = errorGroupArr$values;
        $ENTRIES = kotlin.enums.a.a(errorGroupArr$values);
        INSTANCE = new Companion(null);
    }

    private ErrorGroup(String str, int i, String str2, boolean z10) {
        this.tag = str2;
        this.retriable = z10;
    }

    public static final ErrorGroup fromCode(int i) {
        return INSTANCE.fromCode(i);
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static ErrorGroup valueOf(String str) {
        return (ErrorGroup) Enum.valueOf(ErrorGroup.class, str);
    }

    public static ErrorGroup[] values() {
        return (ErrorGroup[]) $VALUES.clone();
    }

    public final boolean getRetriable() {
        return this.retriable;
    }

    public final String getTag() {
        return this.tag;
    }
}
