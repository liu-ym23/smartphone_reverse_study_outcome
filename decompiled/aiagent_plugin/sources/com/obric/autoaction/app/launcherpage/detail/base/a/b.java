package com.obric.autoaction.app.launcherpage.detail.base.a;

import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.EventTaskSpec;
import d.x;
import kotlinx.coroutines.b.h;

/* JADX INFO: compiled from: TaskDetailRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b<T extends EventTask, S extends EventTaskSpec> {
    Object a(String r1, T r2, d.c.d<? super x> r3);

    Object a(String r1, d.c.d<? super T> r2);

    h<EventTaskResult> a(S r1, String r2, String r3);

    h<String> a(String r1);

    h<EventTaskResult> delete(String r1);

    h<EventTaskResult> update(String r1, S r2, String r3, boolean r4);
}
