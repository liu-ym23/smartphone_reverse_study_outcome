package com.obric.autogui.database.b;

import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Migration_2_3.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends androidx.room.a.b {
    public b() {
        super(2, 3);
    }

    @Override // androidx.room.a.b
    public void a(androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "database");
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), "migrating DB from ver. 2 -> ver. 3");
        r4.b("ALTER TABLE `tasks` ADD COLUMN `timerTaskTriggerId` INTEGER");
        r4.b("ALTER TABLE `tasks` ADD COLUMN `timerTaskId` INTEGER");
    }
}
