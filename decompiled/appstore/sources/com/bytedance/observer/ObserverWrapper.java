package com.bytedance.observer;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.Keep;
import com.bytedance.apm.block.i;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ObserverWrapper extends i.a implements Looper.Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7860a = 0;
    private Looper.Observer mOriginObserver;

    static {
    }

    public ObserverWrapper() {
    }

    public void dispatchingThrewException(Object r10, Message r11, Exception r12) {
        if (i.f6403c == null) goto L18;
        Looper.Observer r13 = this.mOriginObserver;
        if (r13 == null) goto L16;
        r13.dispatchingThrewException(r10, r11, r12);
        return;
    L16:
        i.f6406f.invoke(i.f6403c, new Object[]{r10, r11, r12});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L21:
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

    public Object messageDispatchStarting() {
        Object r10 = null;
        if (i.f6403c == null) goto L16;
        Looper.Observer r11 = this.mOriginObserver;
        if (r11 == null) goto L19;
        r10 = r11.messageDispatchStarting();
        goto L16
    L19:
        r10 = i.f6404d.invoke(i.f6403c, null);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (i.f6407g != Thread.currentThread()) goto L18;
        messageDispatchStarting(">>>>> Dispatching to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee: 0");
    L18:
        return r10;
    }

    public void messageDispatched(Object r10, Message r11) {
        if (i.f6403c == null) goto L16;
        Looper.Observer r12 = this.mOriginObserver;
        if (r12 == null) goto L19;
        r12.messageDispatched(r10, r11);
        goto L16
    L19:
        i.f6405e.invoke(i.f6403c, new Object[]{r10, r11});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (i.f6407g != Thread.currentThread()) goto L21;
        messageDispatched("<<<<< Finished to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee", r11);
        return;
    }

    @Override // com.bytedance.apm.block.i.a
    public void setup(Object r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof Looper.Observer) == false) goto L8;
        this.mOriginObserver = (Looper.Observer) r10;
        return;
    }
}
