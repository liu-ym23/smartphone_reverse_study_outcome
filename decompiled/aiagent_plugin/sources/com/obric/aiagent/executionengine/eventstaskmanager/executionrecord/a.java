package com.obric.aiagent.executionengine.eventstaskmanager.executionrecord;

import java.util.List;

/* JADX INFO: compiled from: ExecutionRecordDao.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    int a(String r1);

    List<ExecutionRecordBean> a(int r1, int r2);

    List<ExecutionRecordBean> a(String r1, int r2, int r3);

    List<ExecutionRecordBean> a(List<Long> r1);

    int b(List<ExecutionRecordBean> r1);

    int c(List<Long> r1);

    List<Long> insert(List<ExecutionRecordBean> r1);

    int update(ExecutionRecordBean r1);
}
