package com.bytedance.android.live.broadcastgame.opengame.runtime;

import java.lang.reflect.Proxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class u {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void a(s<T> r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindLifecycle");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r101.isInterface() == false) goto L7;
        r100.C(Proxy.newProxyInstance(r101.getClassLoader(), new Class[]{r101}, new i(r100.getListeners())));
        return;
    L7:
        throw new Exception("LiftCycleDelegate should delegate interface");
    }
}
