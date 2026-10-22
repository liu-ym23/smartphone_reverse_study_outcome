package com.bytedance.applog.monitor.v3;

import android.content.Context;
import com.bytedance.bdinstall.ai;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: MonitorV3Config.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f5789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ai f5791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ExecutorService f5792e;
    private final String f;
    private final b g;

    /* JADX INFO: renamed from: com.bytedance.applog.monitor.v3.e$1, reason: invalid class name */
    /* JADX INFO: compiled from: MonitorV3Config.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: MonitorV3Config.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f5793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f5794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f5795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ai f5796d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f5797e;
        private ExecutorService f;
        private b g;

        static /* synthetic */ Context a(a r0) {
            return r0.f5793a;
        }

        static /* synthetic */ d b(a r0) {
            return r0.f5794b;
        }

        static /* synthetic */ long c(a r2) {
            return r2.f5795c;
        }

        static /* synthetic */ ai d(a r0) {
            return r0.f5796d;
        }

        static /* synthetic */ String e(a r0) {
            return r0.f5797e;
        }

        static /* synthetic */ ExecutorService f(a r0) {
            return r0.f;
        }

        static /* synthetic */ b g(a r0) {
            return r0.g;
        }

        public a() {
        }

        public a a(Context r3) {
            this.f5793a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            return this;
        }

        public a a(d r1) {
            this.f5794b = r1;
            return this;
        }

        public a a(long r1) {
            this.f5795c = r1;
            return this;
        }

        public a a(ai r3) {
            this.f5796d = (ai) ZeusTransformUtils.wrapperContextForParams(r3, ai.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a(String r1) {
            this.f5797e = r1;
            return this;
        }

        public a a(ExecutorService r3) {
            this.f = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a(b r3) {
            this.g = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
            return this;
        }

        public e a() {
            return new e(this, null);
        }
    }

    /* synthetic */ e(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    public String toString() {
        return "MonitorV3Config{context=" + this.f5788a + ", appLogConfig=" + this.f5789b + ", eventReportInterval=" + this.f5790c + ", networkClient=" + this.f5791d + ", executor=" + this.f5792e + ", reportUrl='" + this.f + "'}";
    }

    private e(a r4) {
        this.f5790c = 60000;
        this.f5788a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.a(r4), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f5789b = a.b(r4);
        this.f5790c = a.c(r4);
        this.f5791d = a.d(r4);
        this.f = a.e(r4);
        this.f5792e = a.f(r4);
        this.g = a.g(r4);
    }

    public Context getContext() {
        return this.f5788a;
    }

    public d a() {
        return this.f5789b;
    }

    public long b() {
        return this.f5790c;
    }

    public ai c() {
        return this.f5791d;
    }

    public String d() {
        return this.f;
    }

    public ExecutorService e() {
        return this.f5792e;
    }

    public b f() {
        return this.g;
    }
}
