package com.bytedance.android.livesdk.revenue.monitor;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.ss.ttvideoengine.FeatureManager;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/monitor/EventModule;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "GIFT", "LIVE_PROFIT", "PK", "PCDN", "LIVE_GIFT", "DRESS", "PRIVILEGE", "RECHARGE", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum EventModule extends Enum<EventModule> {
    public static final EventModule DRESS = null;
    public static final EventModule GIFT = null;
    public static final EventModule LIVE_GIFT = null;
    public static final EventModule LIVE_PROFIT = null;
    public static final EventModule PCDN = null;
    public static final EventModule PK = null;
    public static final EventModule PRIVILEGE = null;
    public static final EventModule RECHARGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventModule[] f157200a = null;
    private final String value;

    public static EventModule valueOf(String r100) {
        return (EventModule) a.a(EventModule.class, r100);
    }

    public static EventModule[] values() {
        return (EventModule[]) f157200a.clone();
    }

    static {
        EventModule r100 = new EventModule("GIFT", 0, PbRequest.SwitchType.GIFT);
        GIFT = r100;
        EventModule r101 = new EventModule("LIVE_PROFIT", 1, "live_profit");
        LIVE_PROFIT = r101;
        EventModule r102 = new EventModule("PK", 2, PbRequest.SwitchType.PK);
        PK = r102;
        EventModule r103 = new EventModule("PCDN", 3, FeatureManager.PCDN);
        PCDN = r103;
        EventModule r104 = new EventModule("LIVE_GIFT", 4, "live_gift");
        LIVE_GIFT = r104;
        EventModule r105 = new EventModule("DRESS", 5, "dress");
        DRESS = r105;
        EventModule r106 = new EventModule("PRIVILEGE", 6, "privilege");
        PRIVILEGE = r106;
        EventModule r107 = new EventModule("RECHARGE", 7, PbRequest.SwitchType.RECHARGE);
        RECHARGE = r107;
        f157200a = new EventModule[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final String getValue() {
        return this.value;
    }

    public EventModule(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
