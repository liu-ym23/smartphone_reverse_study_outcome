package com.obric.agent.e;

import com.obric.aiagent.applog.IAppLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventTaskMobHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14445a = null;

    static {
        f14445a = new a();
    }

    private a() {
    }

    public final void a(float r2, boolean r3) {
        JSONObject r1 = new JSONObject();
        r1.put("similarity", Float.valueOf(r2));
        r1.put("is_matched", r3);
        IAppLog r4 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        r4.reportToFlow("short_cut_query_match", r1);
        return;
    }
}
