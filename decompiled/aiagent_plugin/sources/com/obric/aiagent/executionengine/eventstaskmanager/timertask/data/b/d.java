package com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b;

import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskRecordBean;
import java.util.List;

/* JADX INFO: compiled from: TimerTaskRecordDao.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface d {
    int a(int r1);

    int a(String r1);

    int a(List<Integer> r1, String r2);

    List<TimerTaskRecordBean> a(int r1, long r2, long r4, String r6);

    List<TimerTaskRecordBean> a(long r1, long r3, String r5);

    void delete(TimerTaskRecordBean r1);

    long insert(TimerTaskRecordBean r1);
}
