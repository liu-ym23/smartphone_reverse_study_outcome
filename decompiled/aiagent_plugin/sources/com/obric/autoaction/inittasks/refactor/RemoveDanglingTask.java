package com.obric.autoaction.inittasks.refactor;

import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.h;
import d.x;

/* JADX INFO: compiled from: RemoveDanglingTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RemoveDanglingTask implements IAutoActionFoundationReadyTask {
    public static final Companion Companion = null;
    private static final String TAG = "DanglingTaskRemove";

    /* JADX INFO: compiled from: RemoveDanglingTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RemoveDanglingTask() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d<? super x> r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "cleaning dangling tasks (if any)");
        AutoActionAgent.INSTANCE.cleanDanglingTask();
        return x.f38692a;
    }
}
