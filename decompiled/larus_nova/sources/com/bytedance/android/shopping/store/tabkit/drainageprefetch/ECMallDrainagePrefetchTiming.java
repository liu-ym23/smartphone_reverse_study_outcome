package com.bytedance.android.shopping.store.tabkit.drainageprefetch;

import com.bytedance.bdp.appbase.settings.SettingsConstants;
import com.obric.sva.sdk.utils.InteractConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/drainageprefetch/ECMallDrainagePrefetchTiming;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NA_PREFETCH_STRATEGY", InteractConst.WAKEUP_REQUEST_FROM, "PREFETCH_REQUEST_STATE", "TASK_START_TIME", "REDIRECT_URL_START", "REDIRECT_URL_END", "PRELOAD_GECKO_START", "PRELOAD_GECKO_END", "PREFETCH_API_START", "PREFETCH_API_END", "TASK_END_TIME", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECMallDrainagePrefetchTiming extends Enum<ECMallDrainagePrefetchTiming> {
    private static final /* synthetic */ ECMallDrainagePrefetchTiming[] $VALUES = null;
    public static final ECMallDrainagePrefetchTiming NA_PREFETCH_STRATEGY = null;
    public static final ECMallDrainagePrefetchTiming PREFETCH_API_END = null;
    public static final ECMallDrainagePrefetchTiming PREFETCH_API_START = null;
    public static final ECMallDrainagePrefetchTiming PREFETCH_REQUEST_STATE = null;
    public static final ECMallDrainagePrefetchTiming PRELOAD_GECKO_END = null;
    public static final ECMallDrainagePrefetchTiming PRELOAD_GECKO_START = null;
    public static final ECMallDrainagePrefetchTiming REDIRECT_URL_END = null;
    public static final ECMallDrainagePrefetchTiming REDIRECT_URL_START = null;
    public static final ECMallDrainagePrefetchTiming REQUEST_FROM = null;
    public static final ECMallDrainagePrefetchTiming TASK_END_TIME = null;
    public static final ECMallDrainagePrefetchTiming TASK_START_TIME = null;
    private final String value;

    public static ECMallDrainagePrefetchTiming valueOf(String r100) {
        return (ECMallDrainagePrefetchTiming) r27.a.a(ECMallDrainagePrefetchTiming.class, r100);
    }

    public static ECMallDrainagePrefetchTiming[] values() {
        return (ECMallDrainagePrefetchTiming[]) $VALUES.clone();
    }

    static {
        ECMallDrainagePrefetchTiming r100 = new ECMallDrainagePrefetchTiming("NA_PREFETCH_STRATEGY", 0, "na_prefetch_strategy");
        NA_PREFETCH_STRATEGY = r100;
        ECMallDrainagePrefetchTiming r101 = new ECMallDrainagePrefetchTiming(InteractConst.WAKEUP_REQUEST_FROM, 1, SettingsConstants.SETTINGS_UPDATE_FROM);
        REQUEST_FROM = r101;
        ECMallDrainagePrefetchTiming r102 = new ECMallDrainagePrefetchTiming("PREFETCH_REQUEST_STATE", 2, "prefetch_request_state");
        PREFETCH_REQUEST_STATE = r102;
        ECMallDrainagePrefetchTiming r103 = new ECMallDrainagePrefetchTiming("TASK_START_TIME", 3, "task_start_time");
        TASK_START_TIME = r103;
        ECMallDrainagePrefetchTiming r104 = new ECMallDrainagePrefetchTiming("REDIRECT_URL_START", 4, "redirect_url_start");
        REDIRECT_URL_START = r104;
        ECMallDrainagePrefetchTiming r105 = new ECMallDrainagePrefetchTiming("REDIRECT_URL_END", 5, "redirect_url_end");
        REDIRECT_URL_END = r105;
        ECMallDrainagePrefetchTiming r106 = new ECMallDrainagePrefetchTiming("PRELOAD_GECKO_START", 6, "preload_gecko_start");
        PRELOAD_GECKO_START = r106;
        ECMallDrainagePrefetchTiming r107 = new ECMallDrainagePrefetchTiming("PRELOAD_GECKO_END", 7, "preload_gecko_end");
        PRELOAD_GECKO_END = r107;
        ECMallDrainagePrefetchTiming r108 = new ECMallDrainagePrefetchTiming("PREFETCH_API_START", 8, "prefetch_api_start");
        PREFETCH_API_START = r108;
        ECMallDrainagePrefetchTiming r109 = new ECMallDrainagePrefetchTiming("PREFETCH_API_END", 9, "prefetch_api_end");
        PREFETCH_API_END = r109;
        ECMallDrainagePrefetchTiming r110 = new ECMallDrainagePrefetchTiming("TASK_END_TIME", 10, "task_end_time");
        TASK_END_TIME = r110;
        $VALUES = new ECMallDrainagePrefetchTiming[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public final String getValue() {
        return this.value;
    }

    private ECMallDrainagePrefetchTiming(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
