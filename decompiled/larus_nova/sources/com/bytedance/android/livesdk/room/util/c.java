package com.bytedance.android.livesdk.room.util;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (Intrinsics.areEqual("local_test", ((IHostContext) jc1.k.n(IHostContext.class)).getChannel()) == false) goto L6;
        ALogger.e("Errors", r100, new Throwable(r100));
        return;
    }
}
