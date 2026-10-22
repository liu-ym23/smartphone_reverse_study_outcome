package org.chromium.wschannel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: compiled from: TrafficChangedObservable.java */
/* JADX INFO: loaded from: classes5.dex */
public class d extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f40561a;

    public d() {
    }

    public static d a() {
        if (f40561a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f40561a != null) goto L9;
        f40561a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f40561a;
    }

    public void a(String r3, long r4, long r6, boolean r8) {
        HashMap r0 = new HashMap();
        r0.put("url", r3);
        r0.put("sent_bytes", Long.valueOf(r4));
        r0.put("received_bytes", Long.valueOf(r6));
        r0.put("is_heartbeat_frame", Boolean.valueOf(r8));
        a(r0);
    }

    private void a(Map<String, Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        setChanged();
        notifyObservers(r4);
    }
}
