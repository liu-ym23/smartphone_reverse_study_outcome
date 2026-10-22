package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.LoadFailCode;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.ShareViewLoadError;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.platform.container.impl.core.h f91445a;

    public b(com.bytedance.android.live.revenue.platform.container.impl.core.h r100) {
        this.f91445a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((String) r100, "it");
        if (this.f91445a.getServiceVersion().compareTo((String) com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.f91390b.getValue(null, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.f91389a[0])) < 0) goto L7;
        return this.f91445a;
    L7:
        throw new ShareViewLoadError(LoadFailCode.SharerNotSupported, "service center not support ShareView");
    }
}
