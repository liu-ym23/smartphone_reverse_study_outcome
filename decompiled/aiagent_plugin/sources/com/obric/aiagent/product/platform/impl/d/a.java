package com.obric.aiagent.product.platform.impl.d;

import android.app.AssistantNotificationManager;
import android.app.IAssistantNotificationListener;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.notification.IObricNotificationManager;
import com.obric.aiagent.product.platform.api.notification.ObricNotificationListener;
import com.obric.aiagent.product.platform.api.notification.ObricToastShowListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AssistantNotificationManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements IObricNotificationManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0403a f18836a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistantNotificationManagerImpl.kt */
    public static final class C0403a {
        public /* synthetic */ C0403a(h r1) {
            this();
        }

        private C0403a() {
        }
    }

    static {
        f18836a = new C0403a(null);
    }

    public a() {
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean registerNotificationListener(ObricNotificationListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IAssistantNotificationListener");
        return AssistantNotificationManager.registerNotificationListener((IAssistantNotificationListener) ZeusTransformUtils.preCheckCast(r1, IAssistantNotificationListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean unregisterNotificationListener(ObricNotificationListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IAssistantNotificationListener");
        return AssistantNotificationManager.unregisterNotificationListener((IAssistantNotificationListener) ZeusTransformUtils.preCheckCast(r1, IAssistantNotificationListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean registerToastShowListener(ObricToastShowListener r3) {
        o.e(r3, "listener");
        return c.f18838a.c(r3);
    L5:
        th = move-exception;
        ILogDepend.Companion.e("AssistantNotificationManagerImpl", "registerToastShowListener failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean unregisterToastShowListener(ObricToastShowListener r3) {
        o.e(r3, "listener");
        return c.f18838a.d(r3);
    L5:
        th = move-exception;
        ILogDepend.Companion.e("AssistantNotificationManagerImpl", "unregisterToastShowListener failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
    public boolean isPanelShown() {
        return AssistantNotificationManager.isPanelShown();
    }
}
