package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class v2<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v2 f116814a = null;

    static {
        f116814a = new v2();
    }

    public v2() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        ToolbarBubbleManager.BubbleInfo.State r101 = (ToolbarBubbleManager.BubbleInfo.State) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.isAtLeast(ToolbarBubbleManager.BubbleInfo.State.SHOWING);
    }
}
