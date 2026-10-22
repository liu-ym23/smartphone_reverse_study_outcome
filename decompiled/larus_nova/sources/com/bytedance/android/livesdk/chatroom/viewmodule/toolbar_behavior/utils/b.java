package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f117402a = 0;

    static {
    }

    public static c0.b a(ToolbarButton r100) {
        return b(r100, CollectionsKt.emptyList());
    }

    public static c0.b b(ToolbarButton r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "button");
        Intrinsics.checkNotNullParameter(r101, "args");
        Object r102 = ((IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class)).provideToolbarBehavior(r100.ordinal(), r101);
        if ((r102 instanceof c0.b) == true) goto L6;
        r102 = null;
    L6:
        return (c0.b) r102;
    }
}
