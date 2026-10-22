package com.bytedance.android.ec.hybrid.card.event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f46488a;

    @Override // com.bytedance.android.ec.hybrid.card.event.a
    public final void release() {
    }

    public c(e r100) {
        this.f46488a = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.card.event.a
    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f46488a.a(new d(r100, r101));
    }
}
