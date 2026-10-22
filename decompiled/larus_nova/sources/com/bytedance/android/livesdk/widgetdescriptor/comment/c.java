package com.bytedance.android.livesdk.widgetdescriptor.comment;

import com.bytedance.android.livesdk.interactivity.api.IInteractivityPlatformService;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.f;
import j70.i;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends i<e0> {
    @Override // j70.o
    public final Class<? extends Widget> c() {
        IInteractivityPlatformService r100 = (IInteractivityPlatformService) k.f(IInteractivityPlatformService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getIInteractivityResourceServiceWidget();
    }

    public c() {
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return true;
    }

    @Override // j70.d
    public final f C(h70.b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d90.d.a.f467519h0;
    }
}
