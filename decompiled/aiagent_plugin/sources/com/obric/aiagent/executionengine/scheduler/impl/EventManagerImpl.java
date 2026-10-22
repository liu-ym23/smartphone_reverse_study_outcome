package com.obric.aiagent.executionengine.scheduler.impl;

import com.obric.aiagent.executionengine.scheduler.api.IEventManagerApi;
import com.obric.aiagent.executionengine.scheduler.api.b;
import d.h.b.o;

/* JADX INFO: compiled from: EventManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EventManagerImpl implements IEventManagerApi {
    public EventManagerImpl() {
    }

    @Override // com.obric.aiagent.executionengine.scheduler.api.IEventManagerApi
    public boolean registerEvent(b r1, com.obric.aiagent.executionengine.scheduler.api.a r2) {
        o.e(r1, "type");
        o.e(r2, "eventInfo");
        return com.obric.aiagent.executionengine.scheduler.impl.c.b.f18362a.a(r1, r2);
    }
}
