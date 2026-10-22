package com.obric.autoaction.presentation.input.states.a;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.autogui.common.api.presentation.api.IAssistInputStateManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: StateInactivated.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.obric.autoaction.presentation.input.states.a {
    private static final String TAG = "AssistInput-Inac";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24980a = null;

    /* JADX INFO: compiled from: StateInactivated.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f24980a = new a(null);
    }

    public b() {
        super(IAssistInputStateManager.StateType.Inactivated);
    }

    @Override // com.obric.autogui.util.c.b
    public Object b(com.obric.autogui.util.c.b r2, d.c.d<? super com.obric.autogui.common.e> r3) {
        com.obric.autogui.util.c.b r1 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.common.e.f29014b.a();
    }

    @Override // com.obric.autogui.util.c.b
    public void b(com.obric.autogui.util.c.b r3) {
        o.e((com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin"), "fromState");
        Loog.INSTANCE.i(TAG, " - [AssistInput] inactivated.");
        IAssistInputHost r2 = (IAssistInputHost) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistInputHost.class), IAssistInputHost.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        r2.cancelInput();
    L5:
        IAssistInputHost r4 = (IAssistInputHost) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistInputHost.class), IAssistInputHost.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L8;
        r4.closeInput();
    L8:
        IAutoActionPresentationApi r5 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L12;
        r5.exitAssistInputMode();
        return;
    }
}
