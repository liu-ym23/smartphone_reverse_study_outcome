package com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b;

import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskBean;
import java.util.List;

/* JADX INFO: compiled from: TimerTaskDao.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    int a(TimerTaskBean r1);

    TimerTaskBean a(int r1);

    List<TimerTaskBean> a();

    List<TimerTaskBean> a(androidx.sqlite.db.f r1);

    List<TimerTaskBean> a(String r1);

    List<TimerTaskBean> a(String r1, int r2, int r3);

    int delete(TimerTaskBean r1);

    long insert(TimerTaskBean r1);
}
