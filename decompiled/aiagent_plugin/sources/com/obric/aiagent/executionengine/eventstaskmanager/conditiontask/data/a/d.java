package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a;

import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.bean.ConditionTaskRecordBean;
import java.util.List;

/* JADX INFO: compiled from: ConditionTaskRecordDao.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface d {
    int a(List<Long> r1, String r2);

    Long a(String r1);

    List<ConditionTaskRecordBean> a(int r1, int r2);

    List<ConditionTaskRecordBean> a(long r1, long r3, String r5);

    List<ConditionTaskRecordBean> a(String r1, long r2, long r4, String r6);

    List<Long> a(List<ConditionTaskRecordBean> r1);

    int b(String r1);

    int c(String r1);

    long insert(ConditionTaskRecordBean r1);
}
