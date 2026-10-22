package com.bytedance.platform.godzilla.anr.monitor.idletask;

import android.os.MessageQueue;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class IdleHandlerWrapper implements MessageQueue.IdleHandler {
    private MessageQueue.IdleHandler mOriginalIdleHandler;

    public IdleHandlerWrapper(MessageQueue.IdleHandler r3) {
        this.mOriginalIdleHandler = (MessageQueue.IdleHandler) ZeusTransformUtils.wrapperContextForParams(r3, MessageQueue.IdleHandler.class, "com.obric.aiagent.plugin");
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        String r0 = this.mOriginalIdleHandler.getClass().getName();
        a.a(">>>>> Dispatching to IdleTask " + r0);
        long r1 = System.currentTimeMillis();
        boolean r6 = this.mOriginalIdleHandler.queueIdle();
        a.a("<<<<< Finished to IdleTask " + r0);
        b.a().b().a(r0, System.currentTimeMillis() - r1);
        return r6;
    }

    public MessageQueue.IdleHandler getOriginalIdleHandler() {
        return this.mOriginalIdleHandler;
    }
}
