package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.plantform.datamerge.d f76414a;

    public a() {
    }

    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d a() {
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r100 = this.f76414a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        return r100;
    }

    public final void c() {
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r100 = this.f76414a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        BehaviorSubject<List<ch0.e>> r101 = r100.f();
        if (r101 == null) goto L9;
        List<ch0.e> r102 = r101.getValue();
        if (r102 == null) goto L9;
    L10:
        h.a r103 = b(r102);
        if (r103.f76438a == false) goto L17;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r104 = this.f76414a;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L15:
        r104.v0(r103);
        return;
    L17:
        return;
    L9:
        r102 = new ArrayList();
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public h.a b(List<ch0.e> r100) {
        Intrinsics.checkNotNullParameter(r100, "oldMergeDataList");
        return new h.a(false, r100, null);
    }
}
