package com.bytedance.applet.aibridge.navigation;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f3.h<AbsStartMapNavigationIDL.b> f191315f;

    @Override // com.bytedance.applet.aibridge.navigation.c
    public final void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        f3.h.a.a(this.f191315f, r100, null, null, 14);
    }

    @Override // com.bytedance.applet.aibridge.navigation.c
    public final void m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        f3.h<AbsStartMapNavigationIDL.b> r101 = this.f191315f;
        Intrinsics.checkNotNullParameter(AbsStartMapNavigationIDL.b.class, "<this>");
        BaseModel r102 = k3.c.a(AbsStartMapNavigationIDL.b.class);
        ((AbsStartMapNavigationIDL.b) r102).setNavigationId(r100);
        f3.h.a.b(r101, (ResultModel) r102);
    }

    public f(f3.h<AbsStartMapNavigationIDL.b> r100, com.larus.navigation.api.w r101) {
        Intrinsics.checkNotNullParameter(r100, "jsbCallback");
        super(r101, "jsb_start_map_nav");
        this.f191315f = r100;
    }
}
