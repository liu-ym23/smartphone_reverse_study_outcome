package com.bytedance.android.livesdkapi.depend.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import om0.c;
import pm0.a;

/* JADX INFO: loaded from: classes12.dex */
public class WeakHandler extends Handler {
    WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMsg(Message r100);
    }

    public WeakHandler(IHandler r100) {
        this.mRef = new WeakReference(r100);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r100) {
        IHandler r101 = this.mRef.get();
        if (r101 == null) goto L6;
        if (r100 == null) goto L6;
        r101.handleMsg(r100);
        return;
    L6:
        a r102 = c.c();
        if (r102 == null) goto L11;
        r102.e("WeakHandler", "[GIFT_MSG_MAIN] Error!!!! mRef handler is null");
        return;
    }

    public WeakHandler(Looper r100, IHandler r101) {
        super(r100);
        this.mRef = new WeakReference(r101);
    }
}
