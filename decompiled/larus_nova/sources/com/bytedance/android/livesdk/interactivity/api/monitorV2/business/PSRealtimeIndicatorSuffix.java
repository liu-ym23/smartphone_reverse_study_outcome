package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSRealtimeIndicatorSuffix;", "", "", "indicator", "Ljava/lang/String;", "getIndicator", "()Ljava/lang/String;", "RECEIVE_COUNT", "SHOW_COUNT", "SHOW_DELAY", "PRIORITY_SHOW_DELAY", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSRealtimeIndicatorSuffix extends Enum<PSRealtimeIndicatorSuffix> {
    public static final PSRealtimeIndicatorSuffix PRIORITY_SHOW_DELAY = null;
    public static final PSRealtimeIndicatorSuffix RECEIVE_COUNT = null;
    public static final PSRealtimeIndicatorSuffix SHOW_COUNT = null;
    public static final PSRealtimeIndicatorSuffix SHOW_DELAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PSRealtimeIndicatorSuffix[] f133347a = null;
    private final String indicator;

    static {
        PSRealtimeIndicatorSuffix r100 = new PSRealtimeIndicatorSuffix("RECEIVE_COUNT", 0, "_receive_count");
        RECEIVE_COUNT = r100;
        PSRealtimeIndicatorSuffix r101 = new PSRealtimeIndicatorSuffix("SHOW_COUNT", 1, "_show_count");
        SHOW_COUNT = r101;
        PSRealtimeIndicatorSuffix r102 = new PSRealtimeIndicatorSuffix("SHOW_DELAY", 2, "_show_delay_avg");
        SHOW_DELAY = r102;
        PSRealtimeIndicatorSuffix r103 = new PSRealtimeIndicatorSuffix("PRIORITY_SHOW_DELAY", 3, "_priority_show_delay");
        PRIORITY_SHOW_DELAY = r103;
        f133347a = new PSRealtimeIndicatorSuffix[]{r100, r101, r102, r103};
    }

    public static PSRealtimeIndicatorSuffix valueOf(String r100) {
        return (PSRealtimeIndicatorSuffix) a.a(PSRealtimeIndicatorSuffix.class, r100);
    }

    public static PSRealtimeIndicatorSuffix[] values() {
        return (PSRealtimeIndicatorSuffix[]) f133347a.clone();
    }

    public final String getIndicator() {
        return this.indicator;
    }

    public PSRealtimeIndicatorSuffix(String r100, int r101, String r102) {
        super(r100, r101);
        this.indicator = r102;
    }
}
