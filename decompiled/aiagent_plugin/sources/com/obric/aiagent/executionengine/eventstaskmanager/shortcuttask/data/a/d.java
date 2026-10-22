package com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a;

import com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.bean.ShortcutTaskRecordBean;
import java.util.List;

/* JADX INFO: compiled from: ShortcutTaskRecordDao.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface d {
    int a(String r1);

    int a(List<Long> r1, String r2);

    List<ShortcutTaskRecordBean> a(int r1, int r2);

    List<ShortcutTaskRecordBean> a(long r1, long r3, String r5);

    List<ShortcutTaskRecordBean> a(String r1, long r2, long r4, String r6);

    List<Long> a(List<ShortcutTaskRecordBean> r1);

    int b(String r1);

    long insert(ShortcutTaskRecordBean r1);
}
