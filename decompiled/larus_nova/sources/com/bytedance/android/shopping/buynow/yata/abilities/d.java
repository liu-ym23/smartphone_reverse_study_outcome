package com.bytedance.android.shopping.buynow.yata.abilities;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.buynow.tracker.a f171289a;

    public d(com.bytedance.android.shopping.buynow.tracker.a r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        this.f171289a = r100;
    }

    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f171289a.b(r100, r101);
    }
}
