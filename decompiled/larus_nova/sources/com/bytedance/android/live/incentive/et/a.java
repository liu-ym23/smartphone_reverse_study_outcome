package com.bytedance.android.live.incentive.et;

import com.bytedance.android.scope.o;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements o, c {
    public a() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        mz0.d.a(d.class, d.f69339a);
    }

    @Override // com.bytedance.android.live.incentive.et.c
    public final void j(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "eventProperties");
        d.f69339a.getClass();
        d.a(r100, r101);
    }
}
