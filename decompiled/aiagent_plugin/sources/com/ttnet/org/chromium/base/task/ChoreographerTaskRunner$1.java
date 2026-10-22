package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class ChoreographerTaskRunner$1 implements Choreographer.FrameCallback {
    final /* synthetic */ c this$0;
    final /* synthetic */ Runnable val$task;

    ChoreographerTaskRunner$1(c r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        this.val$task = r5;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long r1) {
        this.val$task.run();
    }
}
