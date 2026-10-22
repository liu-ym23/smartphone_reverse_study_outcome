package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import mq1.d0;

/* JADX INFO: loaded from: classes8.dex */
public final class ReplayRoomFragmentScopeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.bytedance.android.livesdk.chatroom.vs_base.base.d f117917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f117918b = null;

    static {
        f117918b = LazyKt.lazy(ReplayRoomFragmentScopeUtil$fallbackUIStateService$2.INSTANCE);
    }

    public static d0 b() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r100 = f117917a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (d0) com.bytedance.android.scope.m.f163449e.d(r100, d0.class);
    }

    public static ir1.c a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        d0 r101 = b();
        if (r101 != null) goto L6;
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.e("ReplayRoomFragmentScopeUtil", "fragment scope没enter");
        r101 = (d0) f117918b.getValue();
    L6:
        return r101.c(r100);
    }
}
