package com.obric.autoaction.inittasks.refactor;

import android.app.Application;
import android.content.Context;
import com.obric.autoaction.presentation.island.a;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.livecard.api.ILiveCard;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.h;
import d.o.o;
import d.x;

/* JADX INFO: compiled from: InitIslandTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitIslandTask implements IAutoActionFoundationReadyTask {
    public static final Companion Companion = null;
    private static final String TAG = "InitIsland";

    /* JADX INFO: compiled from: InitIslandTask.kt */
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

    public InitIslandTask() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d<? super x> r4) {
        d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        boolean r5 = false;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(ILiveCard.Companion.getInst().getPackageName(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        if (r6 == null) goto L7;
        if (o.d(r6) == true) goto L7;
    L8:
        r5 = !r5;
    L7:
        r5 = true;
    L9:
        Loog.INSTANCE.d(TAG, "InitIslandTask running. initialised=" + r5 + '.');
        if (r5 == false) goto L21;
    L15:
        a.b();
        IAutoActionPresentationApi r7 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L19;
        r7.initGui((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L19:
        return x.f38692a;
    L21:
        ILiveCard r8 = ILiveCard.Companion.getInst();     // Catch: Throwable -> L13
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        d.h.b.o.a(r9, "null cannot be cast to non-null type android.app.Application");     // Catch: Throwable -> L13
        r8.init((Application) ZeusTransformUtils.preCheckCast(r9, Application.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "InitIslandTask failed. ", th);
        goto L15
    }
}
