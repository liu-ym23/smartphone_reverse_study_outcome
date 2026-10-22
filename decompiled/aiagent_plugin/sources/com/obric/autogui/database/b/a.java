package com.obric.autogui.database.b;

import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Migration_1_2.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends androidx.room.a.b {
    public a() {
        super(1, 2);
    }

    @Override // androidx.room.a.b
    public void a(androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "database");
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), "migrating DB from ver. 1 -> ver. 2");
        r4.b("ALTER TABLE `tasks` ADD COLUMN `summary` TEXT");
        r4.b("ALTER TABLE `tasks` ADD COLUMN `journalPath` TEXT");
        r4.b("ALTER TABLE `tasks` ADD COLUMN `platformKey` TEXT NOT NULL DEFAULT ''");
        r4.b("ALTER TABLE `tasks` ADD COLUMN `endType` INTEGER NOT NULL DEFAULT 0");
        r4.b("ALTER TABLE `tasks` ADD COLUMN `termType` INTEGER NOT NULL DEFAULT 0");
    }
}
