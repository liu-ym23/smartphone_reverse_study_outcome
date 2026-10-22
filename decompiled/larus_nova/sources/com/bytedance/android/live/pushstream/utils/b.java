package com.bytedance.android.live.pushstream.utils;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import org.json.JSONObject;
import uf2.d0;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends PthreadHandlerThreadV2 implements d0.a.InterfaceC7875a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0.a.InterfaceC7875a f89523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f89524d;

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        super.onLooperPrepared();
        this.f89524d = new Handler(getLooper());
    }

    public b(d0.a.InterfaceC7875a r100) {
        super("LogMonitorAsynWrapper");
        this.f89523c = r100;
        ThreadMethodProxy.start(this);
    }

    @Override // uf2.d0.a.InterfaceC7875a
    public final void a(final String r100, final JSONObject r101) {
        Handler r102 = this.f89524d;
        if (r102 == null) goto L6;
        r102.post(new a(this, r100, r101));
        return;
    }
}
