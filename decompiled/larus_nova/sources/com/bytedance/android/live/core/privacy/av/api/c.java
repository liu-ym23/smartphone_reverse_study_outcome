package com.bytedance.android.live.core.privacy.av.api;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class c implements b {
    public c() {
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void a(String r100, String r101, String r102, Map r103, a r104, AudioAndVideoException r105) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "sense");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "config");
        Intrinsics.checkNotNullParameter(r105, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void b(String r100, String r101, String r102, Map<String, String> r103, a r104) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "sense");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "config");
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void d(String r100, String r101, String r102, Map<String, String> r103, a r104) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "sense");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "config");
    }
}
