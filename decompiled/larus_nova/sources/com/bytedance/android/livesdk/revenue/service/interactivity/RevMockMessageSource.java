package com.bytedance.android.livesdk.revenue.service.interactivity;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/interactivity/RevMockMessageSource;", "", "GIFT", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevMockMessageSource extends Enum<RevMockMessageSource> {
    public static final RevMockMessageSource GIFT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevMockMessageSource[] f157359a = null;

    static {
        RevMockMessageSource r100 = new RevMockMessageSource();
        GIFT = r100;
        f157359a = new RevMockMessageSource[]{r100};
    }

    public static RevMockMessageSource valueOf(String r100) {
        return (RevMockMessageSource) r27.a.a(RevMockMessageSource.class, r100);
    }

    public static RevMockMessageSource[] values() {
        return (RevMockMessageSource[]) f157359a.clone();
    }

    public RevMockMessageSource() {
        super("GIFT", 0);
    }
}
