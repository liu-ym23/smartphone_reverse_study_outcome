package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b4 {
    public static final void a(Object r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "actionWhenNull");
        if (r100 != null) goto L6;
        r101.invoke();
        return;
    }
}
