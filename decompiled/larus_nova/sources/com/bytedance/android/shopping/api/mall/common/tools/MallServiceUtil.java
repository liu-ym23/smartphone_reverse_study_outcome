package com.bytedance.android.shopping.api.mall.common.tools;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes13.dex */
public final class MallServiceUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f170412a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f170413b = null;

    public static yj.u a() {
        return (yj.u) f170412a.getValue();
    }

    static {
        f170412a = LazyKt.lazy(MallServiceUtil$MallPluginCheck$2.INSTANCE);
        f170413b = LazyKt.lazy(MallServiceUtil$mallFrescoService$2.INSTANCE);
    }
}
