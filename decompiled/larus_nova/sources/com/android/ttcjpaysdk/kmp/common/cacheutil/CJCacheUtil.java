package com.android.ttcjpaysdk.kmp.common.cacheutil;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/cacheutil/CJCacheUtil;", "", "<init>", "()V", "setCacheData", "", "key", "", "value", "getCacheData", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJCacheUtil {
    public static final int $stable = 0;
    public static final CJCacheUtil INSTANCE = null;

    static {
        INSTANCE = new CJCacheUtil();
    }

    private CJCacheUtil() {
    }

    public final String getCacheData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b r101 = c.f528682a;
        IKmpCJCacheUtilService r102 = (IKmpCJCacheUtilService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJCacheUtilService.class));
        if (r102 == null) goto L6;
        String r103 = r102.getCacheData(r100);
        if (r103 == null) goto L6;
        return r103;
    L6:
        return "";
    }

    public final void setCacheData(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        b r102 = c.f528682a;
        IKmpCJCacheUtilService r103 = (IKmpCJCacheUtilService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJCacheUtilService.class));
        if (r103 == null) goto L6;
        r103.setCacheData(r100, r101);
        return;
    }
}
