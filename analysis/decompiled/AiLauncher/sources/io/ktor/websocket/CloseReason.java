package io.ktor.websocket;

import Z8.C1174w;
import Z8.Q;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import h9.InterfaceC4149a;
import io.ktor.utils.io.InternalAPI;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\b\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lio/ktor/websocket/CloseReason;", "", "", "code", "", "message", "<init>", "(SLjava/lang/String;)V", "Lio/ktor/websocket/CloseReason$Codes;", "(Lio/ktor/websocket/CloseReason$Codes;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "component1", "()S", "component2", ChatTracker.CLICK_COPY, "(SLjava/lang/String;)Lio/ktor/websocket/CloseReason;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", ExifInterface.LATITUDE_SOUTH, "getCode", "Ljava/lang/String;", "getMessage", "getKnownReason", "()Lio/ktor/websocket/CloseReason$Codes;", "knownReason", "Codes", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CloseReason {
    private final short code;
    private final String message;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\n\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/websocket/CloseReason$Codes;", "", "", "code", "<init>", "(Ljava/lang/String;IS)V", ExifInterface.LATITUDE_SOUTH, "getCode", "()S", "Companion", "NORMAL", "GOING_AWAY", "PROTOCOL_ERROR", "CANNOT_ACCEPT", "CLOSED_ABNORMALLY", "NOT_CONSISTENT", "VIOLATED_POLICY", "TOO_BIG", "NO_EXTENSION", "INTERNAL_ERROR", "SERVICE_RESTART", "TRY_AGAIN_LATER", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Codes {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Codes[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final Codes UNEXPECTED_CONDITION;
        private static final Map<Short, Codes> byCodeMap;
        private final short code;
        public static final Codes NORMAL = new Codes("NORMAL", 0, 1000);
        public static final Codes GOING_AWAY = new Codes("GOING_AWAY", 1, 1001);
        public static final Codes PROTOCOL_ERROR = new Codes("PROTOCOL_ERROR", 2, 1002);
        public static final Codes CANNOT_ACCEPT = new Codes("CANNOT_ACCEPT", 3, 1003);

        @InternalAPI
        public static final Codes CLOSED_ABNORMALLY = new Codes("CLOSED_ABNORMALLY", 4, 1006);
        public static final Codes NOT_CONSISTENT = new Codes("NOT_CONSISTENT", 5, 1007);
        public static final Codes VIOLATED_POLICY = new Codes("VIOLATED_POLICY", 6, 1008);
        public static final Codes TOO_BIG = new Codes("TOO_BIG", 7, 1009);
        public static final Codes NO_EXTENSION = new Codes("NO_EXTENSION", 8, 1010);
        public static final Codes INTERNAL_ERROR = new Codes("INTERNAL_ERROR", 9, 1011);
        public static final Codes SERVICE_RESTART = new Codes("SERVICE_RESTART", 10, 1012);
        public static final Codes TRY_AGAIN_LATER = new Codes("TRY_AGAIN_LATER", 11, 1013);

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u0012\u0004\b\u000e\u0010\u0003¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/CloseReason$Codes$Companion;", "", "<init>", "()V", "", "code", "Lio/ktor/websocket/CloseReason$Codes;", "byCode", "(S)Lio/ktor/websocket/CloseReason$Codes;", "", "byCodeMap", "Ljava/util/Map;", "UNEXPECTED_CONDITION", "Lio/ktor/websocket/CloseReason$Codes;", "getUNEXPECTED_CONDITION$annotations", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public static /* synthetic */ void getUNEXPECTED_CONDITION$annotations() {
            }

            public final Codes byCode(short code) {
                return (Codes) Codes.byCodeMap.get(Short.valueOf(code));
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ Codes[] $values() {
            return new Codes[]{NORMAL, GOING_AWAY, PROTOCOL_ERROR, CANNOT_ACCEPT, CLOSED_ABNORMALLY, NOT_CONSISTENT, VIOLATED_POLICY, TOO_BIG, NO_EXTENSION, INTERNAL_ERROR, SERVICE_RESTART, TRY_AGAIN_LATER};
        }

        static {
            Codes[] codesArr$values = $values();
            $VALUES = codesArr$values;
            $ENTRIES = kotlin.enums.a.a(codesArr$values);
            INSTANCE = new Companion(null);
            InterfaceC4149a<Codes> entries = getEntries();
            LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(entries, 10)), 16));
            for (Codes codes : entries) {
                linkedHashMap.put(Short.valueOf(codes.code), codes);
            }
            byCodeMap = linkedHashMap;
            UNEXPECTED_CONDITION = INTERNAL_ERROR;
        }

        private Codes(String str, int i10, short s10) {
            this.code = s10;
        }

        public static InterfaceC4149a<Codes> getEntries() {
            return $ENTRIES;
        }

        public static Codes valueOf(String str) {
            return (Codes) Enum.valueOf(Codes.class, str);
        }

        public static Codes[] values() {
            return (Codes[]) $VALUES.clone();
        }

        public final short getCode() {
            return this.code;
        }
    }

    public CloseReason(short s10, String message) {
        p.i(message, "message");
        this.code = s10;
        this.message = message;
    }

    public static /* synthetic */ CloseReason copy$default(CloseReason closeReason, short s10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            s10 = closeReason.code;
        }
        if ((i10 & 2) != 0) {
            str = closeReason.message;
        }
        return closeReason.copy(s10, str);
    }

    /* renamed from: component1, reason: from getter */
    public final short getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final CloseReason copy(short code, String message) {
        p.i(message, "message");
        return new CloseReason(code, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloseReason)) {
            return false;
        }
        CloseReason closeReason = (CloseReason) other;
        return this.code == closeReason.code && p.d(this.message, closeReason.message);
    }

    public final short getCode() {
        return this.code;
    }

    public final Codes getKnownReason() {
        return Codes.INSTANCE.byCode(this.code);
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (Short.hashCode(this.code) * 31) + this.message.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CloseReason(reason=");
        Object knownReason = getKnownReason();
        if (knownReason == null) {
            knownReason = Short.valueOf(this.code);
        }
        sb2.append(knownReason);
        sb2.append(", message=");
        sb2.append(this.message);
        sb2.append(')');
        return sb2.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseReason(Codes code, String message) {
        this(code.getCode(), message);
        p.i(code, "code");
        p.i(message, "message");
    }
}
