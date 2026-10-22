package com.obric.autogui.database.b;

import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Migration_3_4.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends androidx.room.a.b {
    public c() {
        super(3, 4);
    }

    @Override // androidx.room.a.b
    public void a(androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "database");
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), "migrating DB from ver. 3 -> ver. 4");
        r4.b("ALTER TABLE `tasks` ADD COLUMN `eventTaskId` TEXT");
        r4.b("UPDATE `tasks`\nSET `eventTaskId` = CAST(`timerTaskId` AS TEXT)\nWHERE `timerTaskId` IS NOT NULL");
    }
}
