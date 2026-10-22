package com.bytedance.android.ec.hybrid.data.utils;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridChunkedApiHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f46820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f46821b = null;

    public ECHybridChunkedApiHelper() {
    }

    static {
        f46820a = LazyKt.lazy(ECHybridChunkedApiHelper$isMallChunkedApiEnable$2.INSTANCE);
        f46821b = LazyKt.lazy(ECHybridChunkedApiHelper$mallChunkedApiConfig$2.INSTANCE);
    }

    public static final d a() {
        return (d) f46821b.getValue();
    }

    public static List b(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        return (List) kk.d.a(null, new ECHybridChunkedApiHelper$getMallChunkedApiKeys$1(r100));
    }

    public static boolean c(final ECHybridNetworkVO r100) {
        Intrinsics.checkNotNullParameter(r100, "networkVO");
        return ((Boolean) kk.d.a(Boolean.FALSE, new ECHybridChunkedApiHelper$isMallChunkedApi$1(r100))).booleanValue();
    }
}
