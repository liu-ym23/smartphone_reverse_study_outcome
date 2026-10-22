package com.bytedance.reparo;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ApplicationStateManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f9096b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f9097a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f9099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<a> f9100e;

    static {
    }

    static /* synthetic */ int a(b r0) {
        return r0.f9098c;
    }

    static /* synthetic */ boolean a(b r0, boolean r1) {
        r0.f9099d = r1;
        return r1;
    }

    static /* synthetic */ List b(b r0) {
        return r0.f9100e;
    }

    static /* synthetic */ int c(b r2) {
        int r0 = r2.f9098c;
        r2.f9098c = r0 + 1;
        return r0;
    }

    static /* synthetic */ int d(b r2) {
        int r0 = r2.f9098c;
        r2.f9098c = r0 - 1;
        return r0;
    }

    private b() {
        this.f9098c = 0;
        this.f9099d = true;
        this.f9100e = new ArrayList();
        this.f9097a = false;
    }

    public static b a() {
        if (f9096b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9096b != null) goto L9;
        f9096b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f9096b;
    }

    public void a(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        this.f9100e.add(r4);
    }

    public b a(Application r3) {
        ((Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin")).registerActivityLifecycleCallbacks(new ApplicationStateManager$1(this));
        return this;
    }
}
