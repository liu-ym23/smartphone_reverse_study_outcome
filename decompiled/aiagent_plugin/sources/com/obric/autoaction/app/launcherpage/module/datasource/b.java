package com.obric.autoaction.app.launcherpage.module.datasource;

import com.obric.eventkit.task.model.TimerTaskResult;
import com.obric.eventkit.task.model.TimerTaskV2;
import d.h.a.m;
import d.x;
import java.util.List;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: ITimerTaskRepo.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b {
    Object a(String r1, d.c.d<? super x> r2);

    Object a(String r1, m<? super TimerTaskV2, ? super d.c.d<? super TimerTaskV2>, ? extends Object> r2, d.c.d<? super TimerTaskResult> r3);

    Object a(String r1, List<Long> r2, d.c.d<? super TimerTaskResult> r3);

    Object a(List<String> r1, d.c.d<? super x> r2);

    kotlinx.coroutines.b.x<List<f>> a();

    void a(String r1);

    void a(am r1);

    Object b(String r1, d.c.d<? super List<d>> r2);

    Object b(List<Integer> r1, d.c.d<? super x> r2);

    kotlinx.coroutines.b.x<List<j>> b();

    Object c(List<Long> r1, d.c.d<? super x> r2);

    kotlinx.coroutines.b.x<List<j>> c();
}
