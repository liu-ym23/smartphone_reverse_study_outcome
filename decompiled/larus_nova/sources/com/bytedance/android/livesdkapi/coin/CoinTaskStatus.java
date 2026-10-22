package com.bytedance.android.livesdkapi.coin;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/coin/CoinTaskStatus;", "", "logName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getLogName", "()Ljava/lang/String;", "UNKNOWN", "WATCH_FIRST", "WATCH_DAILY", "GIFT_FIRST", "GIFT_DAILY", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CoinTaskStatus extends Enum<CoinTaskStatus> {
    private static final /* synthetic */ CoinTaskStatus[] $VALUES = null;
    public static final Companion Companion = null;
    public static final CoinTaskStatus GIFT_DAILY = null;
    public static final CoinTaskStatus GIFT_FIRST = null;
    public static final CoinTaskStatus UNKNOWN = null;
    public static final CoinTaskStatus WATCH_DAILY = null;
    public static final CoinTaskStatus WATCH_FIRST = null;
    private final String logName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/coin/CoinTaskStatus$Companion;", "", "()V", "from", "Lcom/bytedance/android/livesdkapi/coin/CoinTaskStatus;", "string", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CoinTaskStatus from(String r100) {
            Intrinsics.checkNotNullParameter(r100, "string");
            switch(r100.hashCode()) {
                case -2037316153: goto L15;
                case -670705622: goto L12;
                case 829188185: goto L9;
                case 1446312952: goto L6;
                default: goto L18;
            };
        L6:
            if (r100.equals("send_gift_first") == false) goto L18;
            return CoinTaskStatus.GIFT_FIRST;
        L9:
            if (r100.equals("send_gift_everyday") == false) goto L18;
            return CoinTaskStatus.GIFT_DAILY;
        L12:
            if (r100.equals("duration_chest_everyday") == false) goto L18;
            return CoinTaskStatus.WATCH_DAILY;
        L15:
            if (r100.equals("duration_chest_first") == false) goto L18;
            return CoinTaskStatus.WATCH_FIRST;
        L18:
            return CoinTaskStatus.UNKNOWN;
        }
    }

    static {
        CoinTaskStatus r100 = new CoinTaskStatus("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        CoinTaskStatus r101 = new CoinTaskStatus("WATCH_FIRST", 1, "duration_chest_first");
        WATCH_FIRST = r101;
        CoinTaskStatus r102 = new CoinTaskStatus("WATCH_DAILY", 2, "duration_chest_everyday");
        WATCH_DAILY = r102;
        CoinTaskStatus r103 = new CoinTaskStatus("GIFT_FIRST", 3, "send_gift_first");
        GIFT_FIRST = r103;
        CoinTaskStatus r104 = new CoinTaskStatus("GIFT_DAILY", 4, "send_gift_everyday");
        GIFT_DAILY = r104;
        $VALUES = new CoinTaskStatus[]{r100, r101, r102, r103, r104};
        Companion = new Companion(null);
    }

    public static CoinTaskStatus valueOf(String r100) {
        return (CoinTaskStatus) a.a(CoinTaskStatus.class, r100);
    }

    public static CoinTaskStatus[] values() {
        return (CoinTaskStatus[]) $VALUES.clone();
    }

    public final String getLogName() {
        return this.logName;
    }

    private CoinTaskStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.logName = r102;
    }
}
