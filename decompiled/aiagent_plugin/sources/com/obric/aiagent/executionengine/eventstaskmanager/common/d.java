package com.obric.aiagent.executionengine.eventstaskmanager.common;

import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.h;
import com.obric.aiagent.privacy.IPrivacyService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.g;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;

/* JADX INFO: compiled from: TaskManagerClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static final String TAG = "TaskManagerClient";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f16682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f16683b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final am f16684c = null;

    private d() {
    }

    static {
        f16682a = new d();
        f16683b = new h();
        f16684c = an.a((g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.timertask.c.f17908a.b(), g.class, "com.obric.aiagent.plugin"));
    }

    public final boolean a() {
        IPrivacyService r2 = (IPrivacyService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacyService.class), IPrivacyService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        if (r2.isAgreed() != true) goto L8;
        return true;
    L8:
        return false;
    }
}
