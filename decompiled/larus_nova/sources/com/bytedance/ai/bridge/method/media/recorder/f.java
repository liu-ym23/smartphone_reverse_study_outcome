package com.bytedance.ai.bridge.method.media.recorder;

import com.bytedance.ai.bridge.context.RefType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {
    public static final RecorderManager a(e3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        RefType r101 = RefType.NORMAL;
        Object r102 = r100.d(RecorderManager.class);
        if (r102 != null) goto L6;
        r102 = new RecorderManager(r100);
        r100.b(RecorderManager.class, r102, r101);
    L6:
        return (RecorderManager) r102;
    }
}
