package com.obric.autoaction.app.launcherpage.detail.shortcut.a;

import android.content.Context;
import com.obric.autoaction.app.launcherpage.detail.base.a.d;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.ShortcutTaskSpec;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.k;

/* JADX INFO: compiled from: ShortcutTaskDetailRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final /* synthetic */ EventTaskResult a(d r0) {
        return b(r0);
    }

    public static final /* synthetic */ EventTaskResult a(ShortcutTaskSpec r0, int r1) {
        return b(r0, r1);
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

    private static final EventTaskResult b(ShortcutTaskSpec r7, int r8) {
        return new EventTaskResult(-100, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r8), p.b(), null, 8, null);
    }
}
