package com.obric.init.task.comon;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiagent.privacy_sec.IPrivacy;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: InitPrivacyTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitPrivacyTask implements IInitTask {
    public static final a Companion = null;
    public static final String ID = "INIT_PRIVACY_TASK";

    /* JADX INFO: compiled from: InitPrivacyTask.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public InitPrivacyTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        IPrivacy r2 = (IPrivacy) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacy.class), IPrivacy.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.init();
        return;
    }
}
