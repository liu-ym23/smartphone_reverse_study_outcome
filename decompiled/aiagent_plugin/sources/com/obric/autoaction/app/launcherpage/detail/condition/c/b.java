package com.obric.autoaction.app.launcherpage.detail.condition.c;

import com.obric.autoaction.app.launcherpage.detail.base.a.d;
import com.obric.eventkit.task.model.EventTaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.k;

/* JADX INFO: compiled from: ConditionTaskDetailRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final /* synthetic */ EventTaskResult a(d r0) {
        return b(r0);
    }

    private static final EventTaskResult b(d r6) {
        if (ZeusTransformUtils.instanceOf(r6, d.b.class) == false) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, d.a.class) == false) goto L10;
        return new EventTaskResult(((d.a) ZeusTransformUtils.preCheckCast(r6, d.a.class, "com.obric.aiagent.plugin")).a(), ((d.a) ZeusTransformUtils.preCheckCast(r6, d.a.class, "com.obric.aiagent.plugin")).b(), p.b(), ((d.a) ZeusTransformUtils.preCheckCast(r6, d.a.class, "com.obric.aiagent.plugin")).c());
    L10:
        throw new k();
    }
}
