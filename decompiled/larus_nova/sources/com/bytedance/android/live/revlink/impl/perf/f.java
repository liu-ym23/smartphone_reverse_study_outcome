package com.bytedance.android.live.revlink.impl.perf;

import com.bytedance.android.live.revlink.api.ILinkService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {
    public static final boolean a() {
        return ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getPerfManager().e();
    }

    public static final boolean b() {
        Integer r100 = (Integer) ((tr2.a) vh6.c.b(tr2.a.class)).Qm(0);
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.intValue() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public static final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getPerfManager().i(r100);
    }
}
