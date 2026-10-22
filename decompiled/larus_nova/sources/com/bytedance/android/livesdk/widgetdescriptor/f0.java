package com.bytedance.android.livesdk.widgetdescriptor;

import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f0 {
    public static final boolean a(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMultiTabRoom");
        nm1.r r101 = pm1.f.o();
        if (r101 == null) goto L7;
        r101.a();
        if (MultiTabManagerImpl.f159902e.h(r100.f467480h) != true) goto L7;
        return true;
    L7:
        return false;
    }
}
