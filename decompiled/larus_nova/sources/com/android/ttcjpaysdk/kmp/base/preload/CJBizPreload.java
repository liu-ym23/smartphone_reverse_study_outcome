package com.android.ttcjpaysdk.kmp.base.preload;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/preload/CJBizPreload;", "", "<init>", "()V", "preloadForest", "", "mainUrl", "", "containerType", "subRes", "", "Lcom/android/ttcjpaysdk/kmp/base/preload/KmpPreloadSubResource;", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJBizPreload {
    public static final int $stable = 0;
    public static final CJBizPreload INSTANCE = null;

    static {
        INSTANCE = new CJBizPreload();
    }

    private CJBizPreload() {
    }

    public final void preloadForest(String r100, String r101, List<KmpPreloadSubResource> r102) {
        Intrinsics.checkNotNullParameter(r100, "mainUrl");
        b r103 = c.f528682a;
        IKmpCJBizPreloadService r104 = (IKmpCJBizPreloadService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJBizPreloadService.class));
        if (r104 == null) goto L6;
        r104.preloadForest(r100, r101, r102);
        return;
    }
}
