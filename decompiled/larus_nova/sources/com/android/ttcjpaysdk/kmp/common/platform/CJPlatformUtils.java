package com.android.ttcjpaysdk.kmp.common.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/platform/CJPlatformUtils;", "", "<init>", "()V", "resolveSchema", "", "url", "", "openSchema", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJPlatformUtils {
    public static final int $stable = 0;
    public static final CJPlatformUtils INSTANCE = null;

    static {
        INSTANCE = new CJPlatformUtils();
    }

    private CJPlatformUtils() {
    }

    public final void openSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        b r101 = c.f528682a;
        IKmpCJPlatformService r102 = (IKmpCJPlatformService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJPlatformService.class));
        if (r102 == null) goto L6;
        r102.openSchema(r100);
        return;
    }

    public final boolean resolveSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        b r101 = c.f528682a;
        IKmpCJPlatformService r102 = (IKmpCJPlatformService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJPlatformService.class));
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.resolveSchema(r100);
    }
}
