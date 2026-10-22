package com.obric.autoaction.inittasks;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.IAutoActionNotificationApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InitNotificationsTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitNotificationsTask implements IInitTask {
    public InitNotificationsTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        Loog.INSTANCE.i("Init-Notif", "initializing notification channels...");
        IAutoActionNotificationApi r2 = (IAutoActionNotificationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionNotificationApi.class), IAutoActionNotificationApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.initNotifications();
        return;
    }
}
