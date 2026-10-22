package com.bytedance.android.gamecp.business.gamedetail.component.layoutcomponent.collist;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class m implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f54449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f54450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.android.gamecp.business.gamedetail.component.nav.a> f54451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f54452e;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return false;
    }

    public m() {
        List<com.bytedance.android.gamecp.business.gamedetail.component.nav.a> r100 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter("", "id");
        Intrinsics.checkNotNullParameter(r100, "navInfo");
        this.f54448a = "";
        this.f54449b = 0;
        this.f54450c = 0;
        this.f54451d = r100;
        this.f54452e = false;
    }
}
