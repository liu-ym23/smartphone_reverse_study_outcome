package com.bytedance.android.livesdk.revenue.perf.wto;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/perf/wto/WTOPriorityType;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "NOW", "SCHEDULE", "PARSE", "BACKGROUND", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum WTOPriorityType extends Enum<WTOPriorityType> {
    public static final WTOPriorityType BACKGROUND = null;
    public static final WTOPriorityType NOW = null;
    public static final WTOPriorityType PARSE = null;
    public static final WTOPriorityType SCHEDULE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WTOPriorityType[] f157228a = null;
    private final String tag;

    static {
        WTOPriorityType r100 = new WTOPriorityType("NOW", 0, "NOW");
        NOW = r100;
        WTOPriorityType r101 = new WTOPriorityType("SCHEDULE", 1, "SCHEDULE");
        SCHEDULE = r101;
        WTOPriorityType r102 = new WTOPriorityType("PARSE", 2, "PARSE");
        PARSE = r102;
        WTOPriorityType r103 = new WTOPriorityType("BACKGROUND", 3, "BACKGROUND");
        BACKGROUND = r103;
        f157228a = new WTOPriorityType[]{r100, r101, r102, r103};
    }

    public static WTOPriorityType valueOf(String r100) {
        return (WTOPriorityType) a.a(WTOPriorityType.class, r100);
    }

    public static WTOPriorityType[] values() {
        return (WTOPriorityType[]) f157228a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public WTOPriorityType(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
