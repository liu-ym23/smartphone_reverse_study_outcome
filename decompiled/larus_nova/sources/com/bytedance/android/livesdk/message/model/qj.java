package com.bytedance.android.livesdk.message.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class qj {
    public static final Long a(yh6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$messageId");
        com.bytedance.android.live.base.model.message.m0 r101 = r100.getCommonData();
        if (r101 == null) goto L5;
        Intrinsics.checkNotNullParameter(r101, "$this$messageIdKt");
        return Long.valueOf(r101.getMessageId());
    L5:
        return null;
    }
}
