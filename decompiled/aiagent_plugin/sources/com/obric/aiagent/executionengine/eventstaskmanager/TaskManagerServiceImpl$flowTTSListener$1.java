package com.obric.aiagent.executionengine.eventstaskmanager;

import com.obric.aiagent.assistant.idl.IFlowAssistantTTSStateListenerIDL;
import com.obric.aiagent.assistant.idl.bean.TtsInfo;
import com.obric.aiagent.ipc.utils.f;
import com.obric.eventkit.eventstaskmanager.IAssistantTtsStateListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: TaskManagerServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TaskManagerServiceImpl$flowTTSListener$1 extends IFlowAssistantTTSStateListenerIDL.Stub {
    final /* synthetic */ TaskManagerServiceImpl this$0;

    public static /* synthetic */ x lambda$mYK0ylD5sZGPcQkDB0yRLruBv8g(int r0, IAssistantTtsStateListener r1) {
        return onChanged$lambda$1$lambda$0(r0, r1);
    }

    TaskManagerServiceImpl$flowTTSListener$1(TaskManagerServiceImpl r3) {
        this.this$0 = (TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r3, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantTTSStateListenerIDL
    public void onChanged(TtsInfo r4) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b r0 = com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a;
        StringBuilder r1 = new StringBuilder().append("tts changed: ");
        if (r4 == null) goto L5;
        Integer r2 = r4.getPlayStateEnum();
    L6:
        r0.a("TaskManagerServiceImpl", r1.append(r2).toString());
        final int r3 = 0;
        if (r4 == null) goto L15;
        Integer r5 = r4.getPlayStateEnum();
        int r6 = com.obric.aiagent.assistant.idl.bean.b.a.f16267d.a();
        if (r5 == null) goto L15;
        if (r5.intValue() != r6) goto L15;
        r3 = 1;
    L15:
        if (TaskManagerServiceImpl.access$getTtsState$p(this.this$0) == r3) goto L22;
        ReentrantReadWriteLock r7 = TaskManagerServiceImpl.access$getLock$p(this.this$0);
        TaskManagerServiceImpl r8 = this.this$0;
        ReentrantReadWriteLock.ReadLock r9 = r7.readLock();
        r9.lock();
        TaskManagerServiceImpl.access$setTtsState$p(r8, r3);     // Catch: Throwable -> L19
        f.a(TaskManagerServiceImpl.access$getTtsListeners$p(r8), new $$Lambda$TaskManagerServiceImpl$flowTTSListener$1$mYK0ylD5sZGPcQkDB0yRLruBv8g(r3));     // Catch: Throwable -> L19
        x r10 = x.f38692a;     // Catch: Throwable -> L19
        r9.unlock();
        return;
    L19:
        th = move-exception;
        r9.unlock();
        throw th;
    L22:
        return;
    L5:
        r2 = null;
        goto L6
    }

    private static final x onChanged$lambda$1$lambda$0(int r2, IAssistantTtsStateListener r3) {
        IAssistantTtsStateListener r4 = (IAssistantTtsStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "it");
        r4.onAssistantTtsStateChanged(r2);
        return x.f38692a;
    }
}
