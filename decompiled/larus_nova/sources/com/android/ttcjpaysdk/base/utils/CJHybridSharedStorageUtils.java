package com.android.ttcjpaysdk.base.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJHybridSharedStorageUtils;", "", "()V", "CJ_PAY_CASHIER_TRACK_INFO", "", "CJ_PREFETCH_CASHDESK_LYNX", "cacheDataMap", "", "getCacheDataMap", "()Ljava/util/Map;", "setCacheDataMap", "(Ljava/util/Map;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJHybridSharedStorageUtils {
    public static final String CJ_PAY_CASHIER_TRACK_INFO = "cj_pay_cashier_track_info";
    public static final String CJ_PREFETCH_CASHDESK_LYNX = "cj_prefetch_cashdesk_lynx";
    public static final CJHybridSharedStorageUtils INSTANCE = null;
    private static Map<String, String> cacheDataMap;

    private CJHybridSharedStorageUtils() {
    }

    static {
        INSTANCE = new CJHybridSharedStorageUtils();
        cacheDataMap = new LinkedHashMap();
    }

    public final Map<String, String> getCacheDataMap() {
        return cacheDataMap;
    }

    public final void setCacheDataMap(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        cacheDataMap = r100;
    }
}
