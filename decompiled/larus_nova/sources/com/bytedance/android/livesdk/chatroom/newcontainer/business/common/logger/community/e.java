package com.bytedance.android.livesdk.chatroom.newcontainer.business.common.logger.community;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public static final void a(Map<String, String> r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$putIfNotEmpty");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        r100.put(r101, r102);
        return;
    L12:
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
