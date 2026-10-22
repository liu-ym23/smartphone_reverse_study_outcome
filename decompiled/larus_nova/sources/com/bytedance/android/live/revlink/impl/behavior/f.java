package com.bytedance.android.live.revlink.impl.behavior;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f extends Handler {

    public static final class a {
    }

    static {
    }

    public f() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (r100.what != 1) goto L11;
        Object r101 = r100.obj;
        if ((r101 instanceof Runnable) == true) goto L7;
        r101 = null;
    L7:
        Runnable r102 = (Runnable) r101;
        if (r102 == null) goto L12;
        r102.run();
        return;
    L12:
        return;
    }
}
