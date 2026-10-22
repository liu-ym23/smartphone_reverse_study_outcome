package com.bytedance.frameworks.baselib.network.http.cronet.b;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: compiled from: StreamTrafficObservable.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile j f8239a;

    public j() {
    }

    public static j a() {
        if (f8239a != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8239a != null) goto L9;
        f8239a = new j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f8239a;
    }

    public void a(String r3, long r4, long r6, String r8, String r9) {
        HashMap r0 = new HashMap();
        r0.put("url", r3);
        r0.put("sent_bytes", Long.valueOf(r4));
        r0.put("received_bytes", Long.valueOf(r6));
        r0.put(MonitorConstants.EXTRA_CONTENT_TYPE, r8);
        r0.put(MonitorConstants.REQUEST_LOG, r9);
        a(r0);
    }

    private void a(Map<String, Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        setChanged();
        notifyObservers(r4);
    }
}
