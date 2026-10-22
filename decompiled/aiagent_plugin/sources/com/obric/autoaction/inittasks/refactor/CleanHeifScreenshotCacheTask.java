package com.obric.autoaction.inittasks.refactor;

import android.content.Context;
import com.obric.autogui.common.api.app.foundation.AutoActionFoundation;
import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.capture.HeifScreenshotAttachment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.h;
import d.x;

/* JADX INFO: compiled from: CleanHeifScreenshotCacheTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CleanHeifScreenshotCacheTask implements IAutoActionFoundationReadyTask {
    public static final Companion Companion = null;
    private static final String TAG = "CleanHeifCache";

    /* JADX INFO: compiled from: CleanHeifScreenshotCacheTask.kt */
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

    public CleanHeifScreenshotCacheTask() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d<? super x> r3) {
        d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AutoActionFoundation.INSTANCE.getContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        Loog.INSTANCE.i(TAG, "clearing leftover heif screenshot temp files");
        HeifScreenshotAttachment.Companion.clearCacheDir(r4);
        return x.f38692a;
    L5:
        return x.f38692a;
    }
}
