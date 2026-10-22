package org.chromium;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;

/* JADX INFO: loaded from: classes4.dex */
public class d implements ICronetDepend {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f23040b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICronetDepend f23041a;

    public d() {
    }

    public static d a() {
        if (f23040b != null) goto L16;
        monitor-enter(d.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f23040b != null) goto L11;
        f23040b = new d();     // Catch: Throwable -> L9
    L11:
        monitor-exit(d.class);     // Catch: Throwable -> L9
    L16:
        return f23040b;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public String getSsCookieKey() {
        ICronetDepend r10 = this.f23041a;
        if (r10 != null) goto L5;
        return "X-SS-Cookie";
    L5:
        return r10.getSsCookieKey();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void loggerD(String r10, String r11) {
        ICronetDepend r12 = this.f23041a;
        if (r12 == null) goto L6;
        r12.loggerD(r10, r11);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        ICronetDepend r10 = this.f23041a;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.loggerDebug();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void setAdapter(ICronetDepend r10) {
        this.f23041a = r10;
    }
}
