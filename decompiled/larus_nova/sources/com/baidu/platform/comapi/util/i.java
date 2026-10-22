package com.baidu.platform.comapi.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes39.dex */
public abstract class i extends Handler {
    public abstract void a(Message r100);

    public i(Looper r100) {
        super(r100);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Message r101 = Message.obtain();
        r101.copyFrom(r100);
        a(r101);
        r101.recycle();
    }
}
