package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.android.scope.o;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a implements j, o, dy0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<com.bytedance.android.scope.j, h> f91180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f91181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f91182c;

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public final void I() {
        l r100 = this.f91181b;
        if (r100 == null) goto L7;
        zy0.b r101 = r100.f91209b;
        if (r101 == null) goto L7;
        r101.dispose();
    L7:
        this.f91181b = null;
        this.f91182c.E();
    }

    public a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "centerDriverService");
        this.f91182c = r100;
        this.f91180a = new LinkedHashMap();
    }

    public final String E(cy0.f r100) {
        h r101 = (h) ((LinkedHashMap) this.f91180a).get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getServiceVersion();
    }

    public final void K(h r100, com.bytedance.android.scope.j r101) {
        Intrinsics.checkNotNullParameter(r100, "centerServiceManager");
        Intrinsics.checkNotNullParameter(r101, "scope");
        if (Intrinsics.areEqual((h) ((LinkedHashMap) this.f91180a).get(r101), r100) == false) goto L5;
        this.f91180a.remove(r101);
        return;
    L5:
        jy0.b.c("NativeHostServiceImpl", "remove wrong manager", null, 4);
        this.f91180a.remove(r101);
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.j
    public final void notifyServiceCenterState(NotifyServiceCenterStateRequest r100, i57.a r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "aioCallContext");
        com.bytedance.android.scope.j r102 = (com.bytedance.android.scope.j) r101.a(i57.e.f488324f.b());
        if (r102 == null) goto L8;
        h r103 = (h) ((LinkedHashMap) this.f91180a).get(r102);
        if (r103 == null) goto L9;
        r103.b(r100);
        return;
    L9:
        return;
    }
}
