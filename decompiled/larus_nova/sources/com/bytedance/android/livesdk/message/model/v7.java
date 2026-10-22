package com.bytedance.android.livesdk.message.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class v7 {
    public static final String a(u7 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$userIdString");
        int r101 = c11.a.f22011a;
        Long r102 = Long.valueOf(r100.getUserId());
        String r103 = r100.getRecipientUserOpenId();
        if (r102 == null) goto L5;
        String.valueOf(r102.longValue());
    L5:
        if (r103 != null) goto L8;
        return "0";
    L8:
        return r103;
    }
}
