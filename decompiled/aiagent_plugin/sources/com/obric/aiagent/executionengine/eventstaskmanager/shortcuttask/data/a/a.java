package com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a;

import com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.bean.ShortcutTaskBean;
import java.util.List;

/* JADX INFO: compiled from: ShortcutTaskDao.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    int a(String r1, String r2, long r3);

    ShortcutTaskBean a(String r1);

    List<ShortcutTaskBean> a();

    List<ShortcutTaskBean> a(int r1, int r2);

    List<ShortcutTaskBean> a(String r1, int r2, int r3);

    List<Long> a(String r1, List<String> r2);

    Long b();

    List<ShortcutTaskBean> b(String r1);

    List<ShortcutTaskBean> c(String r1);

    List<ShortcutTaskBean> d(String r1);

    int delete(ShortcutTaskBean r1);

    List<ShortcutTaskBean> e(String r1);

    void insert(ShortcutTaskBean r1);

    int update(ShortcutTaskBean r1);
}
