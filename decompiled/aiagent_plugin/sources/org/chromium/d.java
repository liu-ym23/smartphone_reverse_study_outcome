package org.chromium;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CronetDependManager.java */
/* JADX INFO: loaded from: classes5.dex */
public class d implements ICronetDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f40530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ICronetDepend f40531b;

    private d() {
    }

    public static d a() {
        if (f40530a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f40530a != null) goto L9;
        f40530a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f40530a;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void setAdapter(ICronetDepend r3) {
        this.f40531b = (ICronetDepend) ZeusTransformUtils.wrapperContextForParams(r3, ICronetDepend.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        ICronetDepend r0 = this.f40531b;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.loggerDebug();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void loggerD(String r1, String r2) {
        ICronetDepend r0 = this.f40531b;
        if (r0 == null) goto L6;
        r0.loggerD(r1, r2);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public String getSsCookieKey() {
        ICronetDepend r0 = this.f40531b;
        if (r0 != null) goto L5;
        return "X-SS-Cookie";
    L5:
        return r0.getSsCookieKey();
    }
}
