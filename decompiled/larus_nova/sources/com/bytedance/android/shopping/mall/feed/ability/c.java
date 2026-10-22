package com.bytedance.android.shopping.mall.feed.ability;

import com.bytedance.android.shopping.api.mall.ILegouMallService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f176857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f176858b;

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        ILegouMallService r102 = (ILegouMallService) ServiceManager.get().getService(ILegouMallService.class);
        if ((!Intrinsics.areEqual(r100, null)) == true) goto L6;
        r102.g(r100);
        return;
    }
}
