package com.bytedance.android.live.liveinteract.feed.datamerge;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f72943a;

    public a() {
    }

    public final k c() {
        k r100 = this.f72943a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public j.a a(List<ch0.e> r100) {
        Intrinsics.checkNotNullParameter(r100, "oldMergeDataList");
        return new j.a(false, r100, null);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public j.a b(List<ch0.e> r100) {
        Intrinsics.checkNotNullParameter(r100, "oldMergeDataList");
        return new j.a(false, r100, null);
    }

    public void d(k r100) {
        Intrinsics.checkNotNullParameter(r100, "proxy");
        this.f72943a = r100;
    }
}
