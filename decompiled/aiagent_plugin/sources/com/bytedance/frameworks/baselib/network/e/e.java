package com.bytedance.frameworks.baselib.network.e;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.LifeCycleMonitor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: QueryFilterStateListener.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends LifeCycleMonitor.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile e f8082b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f8083a;

    public static e e() {
        if (f8082b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8082b != null) goto L9;
        f8082b = new e(30000);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f8082b;
    }

    public e(int r2) {
        super(r2);
        this.f8083a = new AtomicBoolean(false);
    }

    public void a(JSONObject r3) {
        a(r3.optInt("qf_enter_background_time", 30000));
    }

    @Override // com.bytedance.frameworks.baselib.network.LifeCycleMonitor.a
    public void c() {
        this.f8083a.set(false);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToForeground");
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.LifeCycleMonitor.a
    public void d() {
        this.f8083a.set(true);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToBackground");
        return;
    }
}
