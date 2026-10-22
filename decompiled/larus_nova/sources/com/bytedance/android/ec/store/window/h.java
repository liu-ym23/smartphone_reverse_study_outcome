package com.bytedance.android.ec.store.window;

import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h extends f.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.core.event.c f49008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f49009c;

    @Override // com.bytedance.android.ec.store.window.f.a
    public final void b(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f49008b.doAnyEventAction(com.bytedance.android.ec.core.event.a.KEY_SHOW_PRODUCT, r101, new Pair[0]);
    }

    public h(com.bytedance.android.ec.core.event.c r100, Map r101, Map r102) {
        this.f49008b = r100;
        this.f49009c = r101;
        super(r102);
    }
}
