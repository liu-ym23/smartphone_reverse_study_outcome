package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {
    public static final void a(Boolean r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "function");
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L6;
        r101.invoke();
        return;
    }
}
