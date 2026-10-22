package com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail;

import java.util.List;

/* JADX INFO: compiled from: ExecutionDetailRecordDao.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    int a(String r1);

    List<ExecutionDetailRecordBean> a(int r1, int r2);

    List<ExecutionDetailRecordBean> a(String r1, int r2, int r3);

    List<ExecutionDetailRecordBean> a(List<Long> r1);

    int b(List<ExecutionDetailRecordBean> r1);

    int c(List<Long> r1);

    List<Long> insert(List<ExecutionDetailRecordBean> r1);

    int update(ExecutionDetailRecordBean r1);
}
