package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.aa1;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class r {
    @JvmStatic
    public static final Boolean a() {
        return aa1.f119774a.getValue();
    }

    static {
    }

    @JvmStatic
    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        ALogger.d("MicRoomFollowEnhance", r100);
        return;
    }
}
