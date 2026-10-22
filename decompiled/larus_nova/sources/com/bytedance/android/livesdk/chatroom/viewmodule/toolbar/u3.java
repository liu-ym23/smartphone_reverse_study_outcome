package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class u3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f116787a = 0;

    static {
        LocalTestManager.a(new Class[]{wy.a.class});
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("ToolbarLogger", r100);
    }
}
