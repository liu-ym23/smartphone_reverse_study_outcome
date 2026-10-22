package com.bytedance.android.ec.hybrid.card.util;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zz6.IKitView;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements com.bytedance.android.ec.hybrid.card.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uj.d f46617a;

    @Override // com.bytedance.android.ec.hybrid.card.event.a
    public final void release() {
    }

    public n(uj.d r100) {
        this.f46617a = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.card.event.a
    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        uj.d r102 = this.f46617a;
        r102.f550232e = r101;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r102.f550230c = r100;
        int r103 = m.f46615a;
        uj.d r104 = this.f46617a;
        Intrinsics.checkNotNullParameter(r104, "params");
        IKitView r105 = r104.f550234g.get();
        if (r105 == null) goto L6;
        r105.e();
        return;
    }
}
