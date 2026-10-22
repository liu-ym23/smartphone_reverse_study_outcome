package com.obric.eventkit.task.api;

/* JADX INFO: compiled from: EventTaskApis.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IEventTaskListenerApi {
    void registerEventTaskChangeListener(a r1);

    void registerEventTaskScheduleListener(b r1);

    void unregisterEventTaskChangeListener(a r1);

    void unregisterEventTaskScheduleListener(b r1);
}
