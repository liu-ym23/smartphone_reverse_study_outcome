package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import h9.InterfaceC4149a;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import p9.InterfaceC5063a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", Parameters.DEBUG, "info", "notice", "warning", "error", "critical", "alert", "emergency", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final class LoggingLevel {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ LoggingLevel[] $VALUES;
    private static final Y8.h<KSerializer<Object>> $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final LoggingLevel debug = new LoggingLevel(Parameters.DEBUG, 0);
    public static final LoggingLevel info = new LoggingLevel("info", 1);
    public static final LoggingLevel notice = new LoggingLevel("notice", 2);
    public static final LoggingLevel warning = new LoggingLevel("warning", 3);
    public static final LoggingLevel error = new LoggingLevel("error", 4);
    public static final LoggingLevel critical = new LoggingLevel("critical", 5);
    public static final LoggingLevel alert = new LoggingLevel("alert", 6);
    public static final LoggingLevel emergency = new LoggingLevel("emergency", 7);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) LoggingLevel.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<LoggingLevel> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    private static final /* synthetic */ LoggingLevel[] $values() {
        return new LoggingLevel[]{debug, info, notice, warning, error, critical, alert, emergency};
    }

    static {
        LoggingLevel[] loggingLevelArr$values = $values();
        $VALUES = loggingLevelArr$values;
        $ENTRIES = kotlin.enums.a.a(loggingLevelArr$values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.w
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return LoggingLevel._init_$_anonymous_();
            }
        });
    }

    private LoggingLevel(String str, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return pb.I.a("io.modelcontextprotocol.kotlin.sdk.LoggingLevel", values());
    }

    public static InterfaceC4149a<LoggingLevel> getEntries() {
        return $ENTRIES;
    }

    public static LoggingLevel valueOf(String str) {
        return (LoggingLevel) Enum.valueOf(LoggingLevel.class, str);
    }

    public static LoggingLevel[] values() {
        return (LoggingLevel[]) $VALUES.clone();
    }
}
