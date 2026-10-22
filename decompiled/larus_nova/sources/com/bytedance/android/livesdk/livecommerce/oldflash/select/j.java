package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f149734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f149735b;

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.select.a
    public final List<String> a() {
        return this.f149735b;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.select.a
    public final List<String> b() {
        return this.f149734a;
    }

    public j(List<String> r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "originDataList");
        Intrinsics.checkNotNullParameter(r101, "selectedDataList");
        this.f149734a = r100;
        this.f149735b = r101;
    }
}
