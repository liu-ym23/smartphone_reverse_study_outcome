package com.obric.aiagent.executionengine.eventstaskmanager.spi;

import com.obric.aiagent.executionengine.eventstaskmanager.b;
import com.obric.eventkit.task.api.IEventTaskListenerApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: EventTaskListenerApiImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EventTaskListenerApiImpl implements IEventTaskListenerApi {
    public EventTaskListenerApiImpl() {
    }

    @Override // com.obric.eventkit.task.api.IEventTaskListenerApi
    public void registerEventTaskChangeListener(com.obric.eventkit.task.api.a r2) {
        com.obric.eventkit.task.api.a r1 = (com.obric.eventkit.task.api.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.eventkit.task.api.a.class, "com.obric.aiagent.plugin");
        o.e(r1, "listener");
        String r3 = a.a();
        if (r3 != null) goto L5;
        return;
    L5:
        b.f16672a.a(r3, r1);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskListenerApi
    public void unregisterEventTaskChangeListener(com.obric.eventkit.task.api.a r2) {
        com.obric.eventkit.task.api.a r1 = (com.obric.eventkit.task.api.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.eventkit.task.api.a.class, "com.obric.aiagent.plugin");
        o.e(r1, "listener");
        String r3 = a.a();
        if (r3 != null) goto L5;
        return;
    L5:
        b.f16672a.b(r3, r1);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskListenerApi
    public void registerEventTaskScheduleListener(com.obric.eventkit.task.api.b r2) {
        com.obric.eventkit.task.api.b r1 = (com.obric.eventkit.task.api.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.eventkit.task.api.b.class, "com.obric.aiagent.plugin");
        o.e(r1, "listener");
        String r3 = a.a();
        if (r3 != null) goto L5;
        return;
    L5:
        b.f16672a.a(r3, r1);
    }

    @Override // com.obric.eventkit.task.api.IEventTaskListenerApi
    public void unregisterEventTaskScheduleListener(com.obric.eventkit.task.api.b r2) {
        com.obric.eventkit.task.api.b r1 = (com.obric.eventkit.task.api.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.eventkit.task.api.b.class, "com.obric.aiagent.plugin");
        o.e(r1, "listener");
        String r3 = a.a();
        if (r3 != null) goto L5;
        return;
    L5:
        b.f16672a.b(r3, r1);
    }
}
