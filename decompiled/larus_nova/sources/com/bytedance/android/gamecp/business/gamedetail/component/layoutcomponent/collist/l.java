package com.bytedance.android.gamecp.business.gamedetail.component.layoutcomponent.collist;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class l implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.gamecp.business.gamedetail.component.nav.a> f54437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f54438b;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public l() {
        this(CollectionsKt.emptyList(), false);
    }

    public l(List<com.bytedance.android.gamecp.business.gamedetail.component.nav.a> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "navInfo");
        this.f54437a = r100;
        this.f54438b = r101;
    }
}
