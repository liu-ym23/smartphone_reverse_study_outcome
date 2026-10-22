package com.obric.autoaction.app.launcherpage.detail.base.container;

import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DetailInstructInfoViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static final /* synthetic */ g a(EventTask r0, String r1) {
        return b(r0, r1);
    }

    private static final g b(EventTask r25, String r26) {
        if (ZeusTransformUtils.instanceOf(r25, ShortcutTask.class) == false) goto L6;
        String r7 = com.obric.autoaction.app.launcherpage.detail.shortcut.data.e.a((ShortcutTask) ZeusTransformUtils.preCheckCast(r25, ShortcutTask.class, "com.obric.aiagent.plugin"), null, 1, null);
        boolean r10 = ((ShortcutTask) ZeusTransformUtils.preCheckCast(r25, ShortcutTask.class, "com.obric.aiagent.plugin")).isShortInstructEnable();
        return new g(3, r7, null, ((ShortcutTask) ZeusTransformUtils.preCheckCast(r25, ShortcutTask.class, "com.obric.aiagent.plugin")).getShortInstruct(), r10, null, false, 100, null);
    L6:
        if (ZeusTransformUtils.instanceOf(r25, ConditionTask.class) == false) goto L9;
        return new g(2, com.obric.autoaction.app.launcherpage.detail.condition.a.a.a((ConditionTask) ZeusTransformUtils.preCheckCast(r25, ConditionTask.class, "com.obric.aiagent.plugin"), null, 1, null), com.obric.autoaction.app.launcherpage.condition.a.a.a(((ConditionTask) ZeusTransformUtils.preCheckCast(r25, ConditionTask.class, "com.obric.aiagent.plugin")).getConditions()), null, false, null, false, 120, null);
    L9:
        return new g(3, null, null, null, false, null, false, 126, null);
    }
}
