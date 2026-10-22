package h1;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.core.IDynamicParams;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.listener.IApmLogListener;
import com.bytedance.apm.listener.IApmStartListener;
import com.bytedance.apm.listener.IBlockListener;
import com.bytedance.apm.listener.IMemoryReachTopListener;
import com.bytedance.apm.listener.INtpTimeService;
import com.bytedance.apm.listener.IStorageCheckListener;
import com.bytedance.apm.listener.ITrafficCallback;
import com.bytedance.apm.logging.IApmAlog;
import com.bytedance.apm.util.o;
import com.bytedance.apm6.foundation.UnSampleListener;
import com.bytedance.apm6.monitor.MonitorableInterceptor;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IWidget;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public final IApmStartListener A;
    public final IApmLogListener B;
    public final IStorageCheckListener C;
    public final ExecutorService D;
    public final IEncrypt E;
    public final String F;
    public final ITrafficCallback G;
    public final INtpTimeService H;
    public final IBlockListener I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f20207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f20208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f20209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f20210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IMemoryReachTopListener f20211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f20212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f20213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f20214h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f20215i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f20216j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f20217k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f20218l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f20219m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f20220n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f20221o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f20222p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f20223q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f20224r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f20225s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f20226t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final JSONObject f20227u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final IDynamicParams f20228v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final IQueryParams f20229w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final IHttpService f20230x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Set f20231y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f20232z;

    public static /* synthetic */ class a {
    }

    public static final class b {
        public IStorageCheckListener A;
        public ITrafficCallback B;
        public IBlockListener C;
        public IQueryParams D;
        public ExecutorService E;
        public IMemoryReachTopListener F;
        public IEncrypt G;
        public IApmAlog H;
        public UnSampleListener I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public String f20233J;
        public INtpTimeService K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f20235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f20236c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f20237d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f20238e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f20239f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f20240g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f20241h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f20242i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f20243j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f20244k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f20245l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f20246m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f20247n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f20248o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public List f20249p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public List f20250q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public List f20251r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public List f20252s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public JSONObject f20253t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public IDynamicParams f20254u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public IHttpService f20255v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public Set f20256w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public long f20257x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public IApmStartListener f20258y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public IApmLogListener f20259z;

        public class a implements IEncrypt {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f20260a;

            public a(b r10) {
                this.f20260a = r10;
            }

            @Override // com.bytedance.services.apm.api.IEncrypt
            public byte[] encrypt(byte[] r10) {
                return z4.a.a(r10, r10.length);
            }
        }

        public b() {
            this.f20238e = false;
            this.f20244k = true;
            this.f20249p = i1.a.f20484a;
            this.f20250q = i1.a.f20485b;
            this.f20251r = i1.a.f20487d;
            this.f20252s = i1.a.f20486c;
            this.f20253t = new JSONObject();
            this.f20256w = new HashSet();
            this.f20257x = 0;
            this.f20241h = PerfConsts.DEFAULT_BLOCK_INTERVAL_MS;
            this.G = new a(this);
            this.f20237d = g.f20315a;
            this.f20242i = g.f20316b;
            this.f20243j = g.f20317c;
        }

        public b a(int r10) {
            return j("aid", r10);
        }

        public b b(String r10) {
            return k("app_version", r10);
        }

        public b c(boolean r10) {
            this.f20246m = r10;
            return this;
        }

        public b d(boolean r10) {
            this.f20237d = r10;
            return this;
        }

        public b e(long r10) {
            this.f20241h = r10;
            return this;
        }

        public c f() {
            o.a(this.f20253t.optString("aid"), "aid");
            o.c(this.f20254u, "dynamicParams");
            o.b(this.f20253t.optString("app_version"), "app_version");
            o.b(this.f20253t.optString("update_version_code"), "update_version_code");
            o.b(this.f20253t.optString("device_id"), "device_id");
            o.b(this.f20253t.optString(CommonKey.KEY_RELEASE_BUILD), CommonKey.KEY_RELEASE_BUILD);
            return new c(this, null);
        }

        public b g(String r10) {
            return k("channel", r10);
        }

        public b h(String r10) {
            return k("device_id", r10);
        }

        public b i(IDynamicParams r10) {
            this.f20254u = r10;
            return this;
        }

        public b j(String r10, int r11) {
            this.f20253t.put(r10, r11);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public b k(String r10, String r11) {
            this.f20253t.put(r10, r11);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public b l(boolean r10) {
            this.f20239f = r10;
            return this;
        }

        public b m(String r10) {
            return k("update_version_code", r10);
        }

        public b n(IWidget r10) {
            if (r10 != null) goto L4;
        L9:
            return this;
        L4:
            if (w0.c.F() == false) goto L6;
        L8:
            this.f20256w.add(r10);
            goto L9
        L6:
            if (r10.isOnlyMainProcess() == false) goto L8;
            return this;
        }
    }

    public /* synthetic */ c(b r10, a r11) {
        this(r10);
    }

    public static b a() {
        return new b();
    }

    public boolean A() {
        return this.f20225s;
    }

    public boolean B() {
        return this.f20224r;
    }

    public boolean C() {
        return this.f20218l;
    }

    public boolean D() {
        return this.f20223q;
    }

    public boolean E() {
        return this.f20221o;
    }

    public boolean F() {
        return this.f20215i;
    }

    public boolean G() {
        return this.f20217k;
    }

    public void H(List r10) {
        this.f20208b = r10;
    }

    public void I(List r10) {
        this.f20209c = r10;
    }

    public void J(List r10) {
        this.f20207a = r10;
    }

    public String b() {
        return this.F;
    }

    public IApmLogListener c() {
        return this.B;
    }

    public IApmStartListener d() {
        return this.A;
    }

    public IBlockListener e() {
        return this.I;
    }

    public long f() {
        return this.f20219m;
    }

    public List g() {
        return this.f20208b;
    }

    public long h() {
        return this.f20232z;
    }

    public IDynamicParams i() {
        return this.f20228v;
    }

    public IEncrypt j() {
        return this.E;
    }

    public List k() {
        return this.f20209c;
    }

    public ExecutorService l() {
        return this.D;
    }

    public JSONObject m() {
        return this.f20227u;
    }

    public IHttpService n() {
        return this.f20230x;
    }

    public MonitorableInterceptor o() {
        return null;
    }

    public IMemoryReachTopListener p() {
        return this.f20211e;
    }

    public boolean q() {
        return this.f20226t;
    }

    public INtpTimeService r() {
        return this.H;
    }

    public IQueryParams s() {
        return this.f20229w;
    }

    public List t() {
        return this.f20207a;
    }

    public String toString() {
        return "ApmStartConfig{mSlardarConfigUrls=" + this.f20207a + ", mDefaultLogReportUrls=" + this.f20208b + ", mExceptionLogReportUrls=" + this.f20209c + ", mTraceReportUrls=" + this.f20210d + ", mMemoryReachTopListener=" + this.f20211e + ", mWithExceptionTrafficDetect=" + this.f20212f + ", mEnableTrafficDetect=" + this.f20213g + ", mWithWebViewTrafficDetect=" + this.f20214h + ", mWithBlockDetect=" + this.f20215i + ", mEnableBlockOnlySampled=" + this.f20216j + ", mWithSeriousBlockDetect=" + this.f20217k + ", mBlockThresholdMs=" + this.f20219m + ", mWithTemperatureDetect=" + this.f20220n + ", mWithBatteryDetect=" + this.f20221o + ", mEnableBatteryLocalRecord=" + this.f20222p + ", mEnableTemperatureLocalRecord=" + this.f20223q + ", mForceUpdateSlardarSetting=" + this.f20224r + ", mEnableMultiProcessRequestSetting=" + this.f20225s + ", mNetMonitorWithDisconnected=" + this.f20226t + ", mHeader=" + this.f20227u + ", mDynamicParams=" + this.f20228v + ", mQueryParams=" + this.f20229w + ", mHttpService=" + this.f20230x + ", mWidgets=" + this.f20231y + ", mDelayNetRequestSeconds=" + this.f20232z + ", mApmStartListener=" + this.A + ", mApmLogListener=" + this.B + ", mStorageCheckListener=" + this.C + ", mExecutor=" + this.D + ", mEncryptor=" + this.E + ", mAlogFilesDir='" + this.F + "', mCallback=" + this.G + ", mNtpTimeService=" + this.H + '}';
    }

    public IStorageCheckListener u() {
        return this.C;
    }

    public List v() {
        return this.f20210d;
    }

    public ITrafficCallback w() {
        return this.G;
    }

    public Set x() {
        return this.f20231y;
    }

    public boolean y() {
        return this.f20222p;
    }

    public boolean z() {
        return this.f20216j;
    }

    public c(b r10) {
        this.f20227u = r10.f20253t;
        this.f20224r = r10.f20234a;
        this.f20225s = r10.f20235b;
        this.f20228v = r10.f20254u;
        this.f20207a = r10.f20249p;
        this.f20230x = r10.f20255v;
        this.f20213g = r10.f20244k;
        this.f20212f = r10.f20243j;
        this.f20215i = r10.f20237d;
        this.f20216j = r10.f20238e;
        this.f20217k = r10.f20239f;
        this.f20218l = r10.f20240g;
        this.f20219m = r10.f20241h;
        this.f20221o = r10.f20246m;
        this.f20222p = r10.f20247n;
        this.f20223q = r10.f20248o;
        this.f20231y = r10.f20256w;
        this.f20208b = r10.f20250q;
        this.f20209c = r10.f20251r;
        this.f20210d = r10.f20252s;
        this.f20232z = r10.f20257x;
        this.f20220n = r10.f20242i;
        this.f20214h = r10.f20245l;
        this.B = r10.f20259z;
        this.A = r10.f20258y;
        this.C = r10.A;
        this.D = r10.E;
        this.f20211e = r10.F;
        this.E = r10.G;
        this.f20226t = r10.f20236c;
        this.F = r10.f20233J;
        this.G = r10.B;
        this.H = r10.K;
        this.f20229w = r10.D;
        this.I = r10.C;
        s1.a.h(r10.H);
        s1.a.j(r10.I);
    }
}
