package com.obric.oui.common.util;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ResourceUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h {
    private static final String TAG = "ResourceUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f34570a = null;

    static {
        f34570a = new h();
    }

    private h() {
    }

    public final boolean a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        if (ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin").getConfiguration().orientation == 2) goto L13;
        return false;
    L13:
        return true;
    L7:
        e = move-exception;
        com.obric.oui.d.a.b.b(TAG, "isLandscape error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }
}
