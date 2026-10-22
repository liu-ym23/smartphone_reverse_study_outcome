package com.bytedance.android.ec.hybrid.list.util;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridGsonUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f47294a = null;

    public static Gson a() {
        return (Gson) f47294a.getValue();
    }

    static {
        f47294a = LazyKt.lazy(ECHybridGsonUtil$gson$2.INSTANCE);
    }
}
