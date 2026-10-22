package com.bytedance.android.live.core.privacy.av.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements com.bytedance.android.live.core.privacy.av.api.h {
    public h() {
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.h
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.h
    public final void b(String r100, Exception r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.h
    public final void c(com.bytedance.android.live.core.privacy.av.api.i r100) {
        Intrinsics.checkNotNullParameter(r100, "remoteData");
    }
}
