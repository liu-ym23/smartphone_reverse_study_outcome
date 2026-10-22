package com.bytedance.observer;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.bytedance.apm.block.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class ObserverWrapper extends k.a implements Looper.Observer {
    private Looper.Observer mOriginObserver;

    public ObserverWrapper() {
    }

    static {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        return;
    L6:
        throw new IllegalStateException("load class error");
    }

    @Override // com.bytedance.apm.block.k.a
    public void setup(Object r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, Looper.Observer.class) == false) goto L8;
        this.mOriginObserver = (Looper.Observer) ZeusTransformUtils.preCheckCast(r3, Looper.Observer.class, "com.obric.aiagent.plugin");
        return;
    }

    public Object messageDispatchStarting() {
        if (k.f4368b == null) goto L13;
        Looper.Observer r0 = this.mOriginObserver;
        if (r0 == null) goto L18;
        Object r1 = r0.messageDispatchStarting();
    L15:
        if (k.f != Thread.currentThread()) goto L17;
        messageDispatchStarting(">>>>> Dispatching to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee: 0");
    L17:
        return r1;
    L18:
        r1 = k.f4369c.invoke(k.f4368b, new Object[0]);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L13:
        r1 = null;
        goto L15
    }

    public void messageDispatched(Object r5, Message r6) {
        if (k.f4368b == null) goto L14;
        Looper.Observer r0 = this.mOriginObserver;
        if (r0 == null) goto L17;
        r0.messageDispatched(r5, r6);
        goto L14
    L17:
        k.f4370d.invoke(k.f4368b, new Object[]{r5, r6});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L14:
        if (k.f != Thread.currentThread()) goto L19;
        messageDispatched("<<<<< Finished to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee", r6);
        return;
    }

    public void dispatchingThrewException(Object r4, Message r5, Exception r6) {
        if (k.f4368b == null) goto L16;
        Looper.Observer r3 = this.mOriginObserver;
        if (r3 == null) goto L14;
        r3.dispatchingThrewException(r4, r5, r6);
        return;
    L14:
        k.f4371e.invoke(k.f4368b, new Object[]{r4, r5, r6});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L19:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
