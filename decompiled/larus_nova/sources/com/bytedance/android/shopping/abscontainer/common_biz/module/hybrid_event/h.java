package com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.r;

/* JADX INFO: loaded from: classes12.dex */
public final class h<STATE extends r, PROPS extends u33.a> extends s33.b<STATE, PROPS> implements o33.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f164342c;

    @Override // o33.b
    public final String getEventName() {
        return this.f164342c;
    }

    @Override // s33.b
    public final String j() {
        return this.f164341b;
    }

    public h(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164341b = "UpdateSelectedCarModule";
        this.f164342c = "updateSelectedCarModel";
    }

    @Override // o33.b
    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        ((r) this.f540457a.f507247a).k(r100);
        com.bytedance.android.shopping.abscontainer.common_biz.helper.b.a(this.f540457a.f507250d.c(), (r) this.f540457a.f507247a, "car_adapter");
    }
}
