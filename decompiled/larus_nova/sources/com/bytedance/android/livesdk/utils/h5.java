package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h5 {
    @JvmStatic
    public static final boolean a() {
        if (Intrinsics.areEqual("com.ss.android.live.broadcast", ((IHostPlugin) jc1.k.n(IHostPlugin.class)).getHostPackageName()) == false) goto L5;
        return true;
    L5:
        return false;
    }

    static {
    }
}
