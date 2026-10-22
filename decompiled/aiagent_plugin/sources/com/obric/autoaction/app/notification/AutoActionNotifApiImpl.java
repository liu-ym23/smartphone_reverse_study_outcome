package com.obric.autoaction.app.notification;

import com.obric.autoaction.app.notification.a.c;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.app.foundation.AutoActionFoundation;
import com.obric.autogui.common.api.app.foundation.FoundationStatus;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.IAutoActionNotificationApi;
import com.obric.autogui.common.d;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AutoActionNotifApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionNotifApiImpl implements IAutoActionNotificationApi {
    private static final a Companion = null;
    private static final String TAG = "AutoActionNotifApiImpl";

    /* JADX INFO: compiled from: AutoActionNotifApiImpl.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$UlHDKhCGfd5UZq-BVekzPXArMCY, reason: not valid java name */
    public static /* synthetic */ boolean m577lambda$UlHDKhCGfd5UZqBVekzPXArMCY(IAutoActionAgentEventListener.SessionInfo r0, c.b r1) {
        return tryCancelAllNotifiers$lambda$0(r0, r1);
    }

    public AutoActionNotifApiImpl() {
    }

    private final c acquireChanManager() {
        return c.f24568a.a();
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionNotificationApi
    public void initNotifications() {
        acquireChanManager().a();
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionNotificationApi
    public void cancelNotifier(String r2) {
        o.e(r2, "notifierId");
        acquireChanManager().a(r2);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoActionNotificationApi
    public void tryCancelAllNotifiers() {
        if (AutoActionFoundation.INSTANCE.getStatus() != FoundationStatus.NotInitialised) goto L6;
        Loog.INSTANCE.w(TAG, "applyNightMode: AutoActionFoundation not created");
        return;
    L6:
        c r3 = acquireChanManager();
        IAutoActionAgentApi r0 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionAgentApi.class), IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L11;
        d<IAutoActionAgentEventListener.SessionInfo> r1 = r0.getOngoingSessionInfo();
        if (r1 == null) goto L11;
        final IAutoActionAgentEventListener.SessionInfo r2 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(r1.a(), IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
    L12:
        if (r2 != null) goto L14;
        r3.b();
        return;
    L14:
        r3.a(new $$Lambda$AutoActionNotifApiImpl$UlHDKhCGfd5UZqBVekzPXArMCY(r2));
        return;
    L11:
        r2 = null;
        goto L12
    }

    private static final boolean tryCancelAllNotifiers$lambda$0(IAutoActionAgentEventListener.SessionInfo r3, c.b r4) {
        o.e(r4, "it");
        if (ZeusTransformUtils.instanceOf(r4.a(), com.obric.autoaction.app.notification.b.a.class) == true) goto L5;
        return false;
    L5:
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3.getSessionKey(), CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.notification.b.a) ZeusTransformUtils.preCheckCast(r4.a(), com.obric.autoaction.app.notification.b.a.class, "com.obric.aiagent.plugin")).a(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L9;
        return true;
    L9:
        return false;
    }
}
