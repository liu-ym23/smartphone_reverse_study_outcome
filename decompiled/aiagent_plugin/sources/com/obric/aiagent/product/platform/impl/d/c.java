package com.obric.aiagent.product.platform.impl.d;

import android.app.AssistantNotificationManager;
import android.app.ObricNotificationManager;
import com.obric.aiagent.product.platform.api.notification.ObricToastShowListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ToastShowListenerBridge.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f18838a = null;

    static {
        f18838a = new c();
    }

    private c() {
    }

    public final boolean a(ObricToastShowListener r4) {
        o.e(r4, "listener");
        return a(ObricNotificationManager.class, "android.app.ObricNotificationManager$OnToastShowListener", "registerToastShowListener", r4.getObricStub());
    }

    public final boolean b(ObricToastShowListener r4) {
        o.e(r4, "listener");
        return a(ObricNotificationManager.class, "android.app.ObricNotificationManager$OnToastShowListener", "unregisterToastShowListener", r4.getObricStub());
    }

    public final boolean c(ObricToastShowListener r4) {
        o.e(r4, "listener");
        return a(AssistantNotificationManager.class, "android.app.AssistantNotificationManager$OnToastShowListener", "registerToastShowListener", r4.getAssistantStub());
    }

    public final boolean d(ObricToastShowListener r4) {
        o.e(r4, "listener");
        return a(AssistantNotificationManager.class, "android.app.AssistantNotificationManager$OnToastShowListener", "unregisterToastShowListener", r4.getAssistantStub());
    }

    private final boolean a(Class<?> r3, String r4, String r5, Object r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        r3.getMethod(r5, new Class[]{ZeusTransformUtils.forName(r4, "com.obric.aiagent.plugin")}).invoke(null, new Object[]{r6});
        return true;
    }
}
