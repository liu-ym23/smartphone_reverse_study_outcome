package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g0 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f76436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f76437c;

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        this.f76436b = true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.f76436b = false;
    }

    public g0() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r100) {
        Intrinsics.checkNotNullParameter(r100, "oldMergeDataList");
        return new h.a(true, r100, null);
    }

    public final void d(boolean r100, ILinkPlayerInfoBridge r101) {
        if (this.f76436b == true) goto L5;
        return;
    L5:
        boolean r102 = false;
        if (this.f76437c == r100) goto L12;
        this.f76437c = r100;
        if (r100 == false) goto L10;
        a().Y0(new ch0.k(r101, true));
    L11:
        r102 = true;
        goto L12
    L10:
        a().Y0(new ch0.k(null, false));
    L12:
        if (r102 == false) goto L15;
        c();
        return;
    }
}
