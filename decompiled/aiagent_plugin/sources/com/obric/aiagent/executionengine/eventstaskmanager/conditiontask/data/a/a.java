package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a;

import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.bean.ConditionTaskBean;
import java.util.List;

/* JADX INFO: compiled from: ConditionTaskDao.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    int a(String r1, String r2, long r3);

    ConditionTaskBean a(String r1);

    List<ConditionTaskBean> a();

    List<ConditionTaskBean> a(int r1, int r2);

    List<ConditionTaskBean> a(String r1, int r2, int r3);

    List<Long> a(String r1, List<String> r2);

    Long b();

    List<ConditionTaskBean> b(String r1);

    List<ConditionTaskBean> c(String r1);

    List<ConditionTaskBean> d(String r1);

    int delete(ConditionTaskBean r1);

    void insert(ConditionTaskBean r1);

    int update(ConditionTaskBean r1);
}
