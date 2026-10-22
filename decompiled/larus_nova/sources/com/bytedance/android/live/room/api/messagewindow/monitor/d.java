package com.bytedance.android.live.room.api.messagewindow.monitor;

import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {
    @JvmStatic
    public static final i a() {
        IMiddlewareMsgWindowService r100 = (IMiddlewareMsgWindowService) k.f(IMiddlewareMsgWindowService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.cardMonitor();
    }

    static {
    }

    @JvmStatic
    public static final f b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeName");
        return new f(r100);
    }
}
