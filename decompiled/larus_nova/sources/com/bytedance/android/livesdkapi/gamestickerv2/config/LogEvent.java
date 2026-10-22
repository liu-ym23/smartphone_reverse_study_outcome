package com.bytedance.android.livesdkapi.gamestickerv2.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/config/LogEvent;", "", "event", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEvent", "()Ljava/lang/String;", "UNKNOWN", "CG_INTERACTION", "GAME_RECORD", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LogEvent extends Enum<LogEvent> {
    private static final /* synthetic */ LogEvent[] $VALUES = null;
    public static final LogEvent CG_INTERACTION = null;
    public static final Companion Companion = null;
    public static final LogEvent GAME_RECORD = null;
    public static final LogEvent UNKNOWN = null;
    private final String event;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/config/LogEvent$Companion;", "", "()V", "strToLogEvent", "Lcom/bytedance/android/livesdkapi/gamestickerv2/config/LogEvent;", "event", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final LogEvent strToLogEvent(String r100) {
            LogEvent[] r101 = LogEvent.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            LogEvent r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getEvent(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return LogEvent.UNKNOWN;
        L8:
            r104 = null;
            goto L9
        }
    }

    static {
        LogEvent r100 = new LogEvent("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        LogEvent r101 = new LogEvent("CG_INTERACTION", 1, "cg_interaction");
        CG_INTERACTION = r101;
        LogEvent r102 = new LogEvent("GAME_RECORD", 2, "game_record");
        GAME_RECORD = r102;
        $VALUES = new LogEvent[]{r100, r101, r102};
        Companion = new Companion(null);
    }

    public static LogEvent valueOf(String r100) {
        return (LogEvent) a.a(LogEvent.class, r100);
    }

    public static LogEvent[] values() {
        return (LogEvent[]) $VALUES.clone();
    }

    public final String getEvent() {
        return this.event;
    }

    private LogEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.event = r102;
    }
}
