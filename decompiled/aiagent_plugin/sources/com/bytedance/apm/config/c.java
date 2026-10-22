package com.bytedance.apm.config;

import android.os.Build;
import com.bytedance.apm.impl.DefaultTTNetImpl;
import com.bytedance.apm.util.q;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.i;
import com.bytedance.services.apm.api.j;
import com.obric.capabilitykit.entity.EntityContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApmStartConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private final com.bytedance.apm.g.b A;
    private final com.bytedance.apm.g.a B;
    private final com.bytedance.apm.g.f C;
    private final ExecutorService D;
    private final com.bytedance.services.apm.api.e E;
    private final String F;
    private final com.bytedance.apm.g.g G;
    private final com.bytedance.apm.g.e H;
    private final com.bytedance.apm.g.c I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final com.bytedance.apm.a.a f4484J;
    private final i K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f4485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f4486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f4487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f4488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.apm.g.d f4489e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final long m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final boolean t;
    private final JSONObject u;
    private final com.bytedance.apm.core.b v;
    private final com.bytedance.apm.core.d w;
    private final IHttpService x;
    private final Set<j> y;
    private final long z;

    /* JADX INFO: renamed from: com.bytedance.apm.config.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: ApmStartConfig.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: ApmStartConfig.java */
    public static final class a {
        com.bytedance.apm.g.f A;
        com.bytedance.apm.g.g B;
        com.bytedance.apm.g.c C;
        com.bytedance.apm.core.d D;
        ExecutorService E;
        com.bytedance.apm.g.d F;
        com.bytedance.services.apm.api.e G;
        com.bytedance.apm.h.c H;
        com.bytedance.apm6.foundation.a I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        i f4490J;
        String K;
        com.bytedance.apm.g.e L;
        com.bytedance.apm.a.a M;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f4491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f4492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f4493c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f4494d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f4495e;
        boolean f;
        boolean g;
        long h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        boolean n;
        boolean o;
        List<String> p;
        List<String> q;
        List<String> r;
        List<String> s;
        JSONObject t;
        com.bytedance.apm.core.b u;
        IHttpService v;
        Set<j> w;
        long x;
        com.bytedance.apm.g.b y;
        com.bytedance.apm.g.a z;

        a() {
            this.f4495e = false;
            this.k = true;
            this.p = com.bytedance.apm.c.a.f4460a;
            this.q = com.bytedance.apm.c.a.f4461b;
            this.r = com.bytedance.apm.c.a.f4463d;
            this.s = com.bytedance.apm.c.a.f4462c;
            this.t = new JSONObject();
            this.w = new HashSet();
            this.x = 0;
            this.h = EntityContentProvider.g;
            this.G = new AnonymousClass1(this);
            this.f4494d = h.f4523a;
            this.i = h.f4524b;
            this.j = h.f4525c;
        }

        public a a(String r2) {
            return a("release_build", r2);
        }

        public a a(int r2) {
            return a(WsConstants.KEY_APP_ID, r2);
        }

        public a b(String r2) {
            return a("device_id", r2);
        }

        public a c(String r2) {
            return a(WsConstants.KEY_APP_VERSION, r2);
        }

        public a d(String r2) {
            return a("update_version_code", r2);
        }

        public a e(String r2) {
            return a("channel", r2);
        }

        public a a(boolean r2) {
            if (r2 == true) goto L4;
        L6:
            boolean r3 = false;
        L7:
            this.f4494d = r3;
            return this;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r3 = true;
            goto L7
        }

        public a b(boolean r1) {
            this.f4495e = r1;
            return this;
        }

        public a c(boolean r2) {
            if (r2 == true) goto L4;
        L6:
            boolean r3 = false;
        L7:
            this.f = r3;
            return this;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r3 = true;
            goto L7
        }

        public a a(com.bytedance.apm.core.b r3) {
            this.u = (com.bytedance.apm.core.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.core.b.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a d(boolean r1) {
            if (r1 == false) goto L4;
            this.v = new DefaultTTNetImpl();
        L4:
            return this;
        }

        public a a(j r3) {
            j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L5;
        L10:
            return this;
        L5:
            if (com.bytedance.apm.c.d() == false) goto L7;
        L9:
            this.w.add(r4);
            goto L10
        L7:
            if (r4.isOnlyMainProcess() == false) goto L9;
            return this;
        }

        public a a(String r2, String r3) {
            this.t.put(r2, r3);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public a a(String r2, int r3) {
            this.t.put(r2, r3);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public c a() {
            q.a(this.t.optString(WsConstants.KEY_APP_ID), WsConstants.KEY_APP_ID);
            q.a(this.u, "dynamicParams");
            q.b(this.t.optString(WsConstants.KEY_APP_VERSION), WsConstants.KEY_APP_VERSION);
            q.b(this.t.optString("update_version_code"), "update_version_code");
            q.b(this.t.optString("device_id"), "device_id");
            q.b(this.t.optString("release_build"), "release_build");
            return new c(this, null);
        }
    }

    /* synthetic */ c(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static a a() {
        return new a();
    }

    private c(a r3) {
        this.u = r3.t;
        this.r = r3.f4491a;
        this.s = r3.f4492b;
        this.v = r3.u;
        this.f4485a = r3.p;
        this.x = r3.v;
        this.g = r3.k;
        this.f = r3.j;
        this.i = r3.f4494d;
        this.j = r3.f4495e;
        this.k = r3.f;
        this.l = r3.g;
        this.m = r3.h;
        this.o = r3.m;
        this.p = r3.n;
        this.q = r3.o;
        this.y = r3.w;
        this.f4486b = r3.q;
        this.f4487c = r3.r;
        this.f4488d = r3.s;
        this.z = r3.x;
        this.n = r3.i;
        this.h = r3.l;
        this.B = r3.z;
        this.A = r3.y;
        this.C = r3.A;
        this.D = r3.E;
        this.f4489e = r3.F;
        this.E = r3.G;
        this.t = r3.f4493c;
        this.F = r3.K;
        this.G = r3.B;
        this.H = r3.L;
        this.w = r3.D;
        this.I = r3.C;
        this.f4484J = r3.M;
        this.K = r3.f4490J;
        com.bytedance.apm.h.a.a(r3.H);
        com.bytedance.apm.h.a.a(r3.I);
    }

    public com.bytedance.apm.g.e b() {
        return this.H;
    }

    public com.bytedance.apm.core.d c() {
        return this.w;
    }

    public com.bytedance.apm.core.b d() {
        return this.v;
    }

    public com.bytedance.apm.g.d e() {
        return this.f4489e;
    }

    public List<String> f() {
        return this.f4485a;
    }

    public boolean g() {
        return this.r;
    }

    public boolean h() {
        return this.s;
    }

    public List<String> i() {
        return this.f4486b;
    }

    public void a(List<String> r3) {
        this.f4486b = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public void b(List<String> r3) {
        this.f4485a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public void c(List<String> r3) {
        this.f4487c = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public List<String> j() {
        return this.f4487c;
    }

    public List<String> k() {
        return this.f4488d;
    }

    public JSONObject l() {
        return this.u;
    }

    public IHttpService m() {
        return this.x;
    }

    public i n() {
        return this.K;
    }

    public Set<j> o() {
        return this.y;
    }

    public boolean p() {
        return this.i;
    }

    public boolean q() {
        return this.j;
    }

    public boolean r() {
        return this.k;
    }

    public boolean s() {
        return this.l;
    }

    public long t() {
        return this.m;
    }

    public long u() {
        return this.z;
    }

    public boolean v() {
        return this.o;
    }

    public boolean w() {
        return this.p;
    }

    public boolean x() {
        return this.q;
    }

    public com.bytedance.apm.g.b y() {
        return this.A;
    }

    public com.bytedance.apm.g.a z() {
        return this.B;
    }

    public com.bytedance.apm.g.f A() {
        return this.C;
    }

    public ExecutorService B() {
        return this.D;
    }

    public com.bytedance.services.apm.api.e C() {
        return this.E;
    }

    public boolean D() {
        return this.t;
    }

    public String E() {
        return this.F;
    }

    public com.bytedance.apm.g.g F() {
        return this.G;
    }

    public com.bytedance.apm.g.c G() {
        return this.I;
    }

    public String toString() {
        return "ApmStartConfig{mSlardarConfigUrls=" + this.f4485a + ", mDefaultLogReportUrls=" + this.f4486b + ", mExceptionLogReportUrls=" + this.f4487c + ", mTraceReportUrls=" + this.f4488d + ", mMemoryReachTopListener=" + this.f4489e + ", mWithExceptionTrafficDetect=" + this.f + ", mEnableTrafficDetect=" + this.g + ", mWithWebViewTrafficDetect=" + this.h + ", mWithBlockDetect=" + this.i + ", mEnableBlockOnlySampled=" + this.j + ", mWithSeriousBlockDetect=" + this.k + ", mBlockThresholdMs=" + this.m + ", mWithTemperatureDetect=" + this.n + ", mWithBatteryDetect=" + this.o + ", mEnableBatteryLocalRecord=" + this.p + ", mEnableTemperatureLocalRecord=" + this.q + ", mForceUpdateSlardarSetting=" + this.r + ", mEnableMultiProcessRequestSetting=" + this.s + ", mNetMonitorWithDisconnected=" + this.t + ", mHeader=" + this.u + ", mDynamicParams=" + this.v + ", mQueryParams=" + this.w + ", mHttpService=" + this.x + ", mWidgets=" + this.y + ", mDelayNetRequestSeconds=" + this.z + ", mApmStartListener=" + this.A + ", mApmLogListener=" + this.B + ", mStorageCheckListener=" + this.C + ", mExecutor=" + this.D + ", mEncryptor=" + this.E + ", mAlogFilesDir='" + this.F + "', mCallback=" + this.G + ", mNtpTimeService=" + this.H + '}';
    }

    public com.bytedance.apm6.monitor.d H() {
        return this.f4484J;
    }
}
