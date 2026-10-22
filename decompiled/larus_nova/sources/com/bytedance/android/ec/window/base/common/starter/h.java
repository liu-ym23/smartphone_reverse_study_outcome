package com.bytedance.android.ec.window.base.common.starter;

import com.bytedance.android.ec.window.base.common.datachannel.ECWindowSourceMethod;
import com.bytedance.android.ec.window.base.common.datachannel.ECWindowStoreType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECWindowStoreType f49166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECWindowSourceMethod f49167b;

    public h(ECWindowStoreType r100, ECWindowSourceMethod r101) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE);
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD);
        this.f49166a = r100;
        this.f49167b = r101;
    }
}
