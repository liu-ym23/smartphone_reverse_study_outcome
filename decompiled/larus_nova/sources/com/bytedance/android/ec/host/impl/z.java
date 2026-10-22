package com.bytedance.android.ec.host.impl;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.ss.android.ugc.aweme.app.api.RequestInfoSensitive;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class z extends com.bytedance.android.chunkstreamprediction.network.g<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f46228a;

    public z(Object r100) {
        this.f46228a = r100;
    }

    @Override // com.bytedance.android.chunkstreamprediction.network.a
    public final void onNext(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if ((r100 instanceof RequestInfoSensitive) == false) goto L5;
        RequestInfoSensitive r101 = (RequestInfoSensitive) r100;
    L6:
        if (r101 == null) goto L9;
        r101.setRequestInfo((BaseHttpRequestInfo) this.f46228a);
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }
}
