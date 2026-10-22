package com.bytedance.android.shopping.orderlist.common.utils;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f179986a = null;

    static {
        int[] r100 = new int[InflaterPriority.values().length];
        f179986a = r100;
        r100[InflaterPriority.ORIGIN_ASYNC_CONTEXT.ordinal()] = 1;
        r100[InflaterPriority.ASYNC_ORIGIN_CONTEXT.ordinal()] = 2;
        r100[InflaterPriority.CONTEXT_ORIGIN_ASYNC.ordinal()] = 3;
    }
}
