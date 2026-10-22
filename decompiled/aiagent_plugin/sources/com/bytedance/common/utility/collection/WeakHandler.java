package com.bytedance.common.utility.collection;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class WeakHandler extends Handler {
    WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMsg(Message r1);
    }

    public WeakHandler(IHandler r3) {
        IHandler r4 = (IHandler) ZeusTransformUtils.wrapperContextForParams(r3, IHandler.class, "com.obric.aiagent.plugin");
        if (Looper.myLooper() != null) goto L5;
        Looper r0 = Looper.getMainLooper();
    L6:
        this(r0, r4);
        return;
    L5:
        r0 = Looper.myLooper();
        goto L6
    }

    public WeakHandler(Looper r3, IHandler r4) {
        IHandler r5 = (IHandler) ZeusTransformUtils.wrapperContextForParams(r4, IHandler.class, "com.obric.aiagent.plugin");
        super(r3);
        this.mRef = new WeakReference(r5);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r3) {
        IHandler r2 = (IHandler) ZeusTransformUtils.preCheckCast(this.mRef.get(), IHandler.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        r2.handleMsg(r3);
        return;
    L8:
        return;
    }
}
