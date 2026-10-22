package com.bytedance.android.shopping.orderlist.common.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/utils/InflaterPriority;", "", "ORIGIN_ASYNC_CONTEXT", "ASYNC_ORIGIN_CONTEXT", "CONTEXT_ORIGIN_ASYNC", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InflaterPriority extends Enum<InflaterPriority> {
    public static final InflaterPriority ASYNC_ORIGIN_CONTEXT = null;
    public static final InflaterPriority CONTEXT_ORIGIN_ASYNC = null;
    public static final InflaterPriority ORIGIN_ASYNC_CONTEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InflaterPriority[] f179946a = null;

    static {
        InflaterPriority r100 = new InflaterPriority("ORIGIN_ASYNC_CONTEXT", 0);
        ORIGIN_ASYNC_CONTEXT = r100;
        InflaterPriority r101 = new InflaterPriority("ASYNC_ORIGIN_CONTEXT", 1);
        ASYNC_ORIGIN_CONTEXT = r101;
        InflaterPriority r102 = new InflaterPriority("CONTEXT_ORIGIN_ASYNC", 2);
        CONTEXT_ORIGIN_ASYNC = r102;
        f179946a = new InflaterPriority[]{r100, r101, r102};
    }

    public static InflaterPriority valueOf(String r100) {
        return (InflaterPriority) r27.a.a(InflaterPriority.class, r100);
    }

    public static InflaterPriority[] values() {
        return (InflaterPriority[]) f179946a.clone();
    }

    public InflaterPriority(String r100, int r101) {
        super(r100, r101);
    }
}
