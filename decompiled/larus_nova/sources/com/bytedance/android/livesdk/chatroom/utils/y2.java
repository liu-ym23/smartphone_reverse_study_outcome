package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdkapi.room.handler.toolbar.ResKeyEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class y2 {
    public static final x2 b(ResKeyEnum r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$none");
        return new x2(r100, null);
    }

    public static final x2 a(ResKeyEnum r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$defaultV");
        if (r101 == null) goto L7;
        return new x2(r100, new v2(r101));
    L7:
        return new x2(r100, null);
    }
}
