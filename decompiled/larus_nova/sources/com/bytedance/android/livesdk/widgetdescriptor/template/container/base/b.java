package com.bytedance.android.livesdk.widgetdescriptor.template.container.base;

import com.bytedance.android.livesdk.widgetdescriptor.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class b extends a {
    public b() {
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.template.container.base.a
    public final boolean N(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return !d90.c.i(r100);
    }
}
