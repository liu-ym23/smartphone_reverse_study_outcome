package com.bytedance.apm.insight;

import H.h;
import S0.b;
import Z6.k;
import android.text.TextUtils;
import j0.AbstractC1591a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ApmInsightInitConfig {

    /* renamed from: A, reason: collision with root package name */
    public String f2216A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f2217B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f2218C;

    /* renamed from: D, reason: collision with root package name */
    public IActivityLeakListener f2219D;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2220a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f2221j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final String p;

    /* renamed from: q, reason: collision with root package name */
    public final String f2222q;

    /* renamed from: r, reason: collision with root package name */
    public final String f2223r;

    /* renamed from: s, reason: collision with root package name */
    public final long f2224s;

    /* renamed from: t, reason: collision with root package name */
    public final JSONObject f2225t;
    public final boolean u;

    /* renamed from: v, reason: collision with root package name */
    public List<String> f2226v;

    /* renamed from: w, reason: collision with root package name */
    public List<String> f2227w;

    /* renamed from: x, reason: collision with root package name */
    public List<String> f2228x;
    public IDynamicParams y;

    /* renamed from: z, reason: collision with root package name */
    public f2.a f2229z;

    public static final class Builder {

        /* renamed from: A, reason: collision with root package name */
        public List<String> f2230A;

        /* renamed from: B, reason: collision with root package name */
        public List<String> f2231B;

        /* renamed from: C, reason: collision with root package name */
        public IDynamicParams f2232C;

        /* renamed from: D, reason: collision with root package name */
        public f2.a f2233D;

        /* renamed from: a, reason: collision with root package name */
        public String f2234a;
        public String b;
        public String c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f2235j;
        public boolean k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f2236q;

        /* renamed from: r, reason: collision with root package name */
        public long f2237r;

        /* renamed from: s, reason: collision with root package name */
        public JSONObject f2238s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f2239t;
        public boolean u;

        /* renamed from: v, reason: collision with root package name */
        public IActivityLeakListener f2240v;

        /* renamed from: w, reason: collision with root package name */
        public String f2241w;

        /* renamed from: x, reason: collision with root package name */
        public boolean f2242x;
        public boolean y;

        /* renamed from: z, reason: collision with root package name */
        public List<String> f2243z;

        public Builder() {
            this.m = true;
            this.n = true;
            this.o = true;
            this.f2237r = 15000L;
            this.f2238s = new JSONObject();
            this.f2243z = AbstractC1591a.b;
            this.f2230A = AbstractC1591a.c;
            this.f2231B = AbstractC1591a.f;
        }

        public Builder addHeader(JSONObject jSONObject) {
            try {
                b.q0(this.f2238s, jSONObject);
            } catch (Exception unused) {
            }
            return this;
        }

        public Builder aid(String str) {
            this.f2234a = str;
            return this;
        }

        public Builder batteryMonitor(boolean z10) {
            this.f2235j = z10;
            return this;
        }

        public Builder blockDetect(boolean z10) {
            this.d = z10;
            return this;
        }

        public ApmInsightInitConfig build() {
            if (TextUtils.isEmpty(this.f2234a)) {
                throw new IllegalArgumentException("aid must not be empty");
            }
            return new ApmInsightInitConfig(this);
        }

        public Builder channel(String str) {
            this.c = str;
            return this;
        }

        public Builder cpuMonitor(boolean z10) {
            this.k = z10;
            return this;
        }

        public Builder debugMode(boolean z10) {
            this.f2239t = z10;
            return this;
        }

        public Builder defaultReportDomain(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith("http://")) {
                        h.f713q = str.replace("http://", "");
                        k.f = "http://";
                    } else if (str.startsWith(k.f)) {
                        h.f713q = str.replace(k.f, "");
                    } else {
                        h.f713q = str;
                    }
                }
                String str2 = h.f713q;
                List<String> list = this.f2230A;
                String str3 = AbstractC1591a.f4751a;
                this.f2230A = a(str2, list, str3);
                this.f2231B = a(h.f713q, this.f2231B, str3);
                this.f2243z = a(h.f713q, this.f2243z, str3);
            }
            return this;
        }

        public Builder detectActivityLeak(IActivityLeakListener iActivityLeakListener) {
            this.f2240v = iActivityLeakListener;
            return this;
        }

        public Builder diskMonitor(boolean z10) {
            this.l = z10;
            return this;
        }

        public Builder enableAPMPlusLocalLog(boolean z10) {
            this.y = z10;
            return this;
        }

        public Builder enableHybridMonitor(boolean z10) {
            this.g = z10;
            return this;
        }

        public Builder enableLogRecovery(boolean z10) {
            this.u = z10;
            return this;
        }

        public Builder enableNetTrace(boolean z10) {
            this.f2242x = z10;
            return this;
        }

        @Deprecated
        public Builder enableWebViewMonitor(boolean z10) {
            this.f = z10;
            return this;
        }

        public Builder fpsMonitor(boolean z10) {
            this.i = z10;
            return this;
        }

        public Builder memoryMonitor(boolean z10) {
            this.h = z10;
            return this;
        }

        public Builder netMonitor(boolean z10) {
            this.m = z10;
            return this;
        }

        public Builder operateMonitor(boolean z10) {
            this.f2236q = z10;
            return this;
        }

        public Builder pageMonitor(boolean z10) {
            this.o = z10;
            return this;
        }

        public Builder seriousBlockDetect(boolean z10) {
            this.e = z10;
            return this;
        }

        public Builder setDynamicParams(IDynamicParams iDynamicParams) {
            this.f2232C = iDynamicParams;
            return this;
        }

        public Builder setMaxLaunchTime(long j5) {
            this.f2237r = j5;
            return this;
        }

        public Builder setNetTraceId(String str) {
            this.f2241w = str;
            return this;
        }

        public Builder setNetworkClient(f2.a aVar) {
            this.f2233D = aVar;
            return this;
        }

        public Builder startMonitor(boolean z10) {
            this.n = z10;
            return this;
        }

        public Builder token(String str) {
            this.b = str;
            return this;
        }

        public Builder trafficMonitor(boolean z10) {
            this.p = z10;
            return this;
        }

        public final List<String> a(String str, List<String> list, String str2) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().replace(str2, k.f + str));
                }
            }
            return arrayList;
        }

        public Builder(ApmInsightInitConfig apmInsightInitConfig) {
            this.m = true;
            this.n = true;
            this.o = true;
            this.f2237r = 15000L;
            this.d = apmInsightInitConfig.f2220a;
            this.e = apmInsightInitConfig.b;
            this.f2238s = apmInsightInitConfig.f2225t;
            this.f2243z = apmInsightInitConfig.f2226v;
            this.f2230A = apmInsightInitConfig.f2227w;
            this.f2231B = apmInsightInitConfig.f2228x;
            this.f2242x = apmInsightInitConfig.f2217B;
        }
    }

    public ApmInsightInitConfig(Builder builder) {
        this.f2220a = builder.d;
        this.b = builder.e;
        this.c = builder.f;
        this.d = builder.g;
        this.e = builder.h;
        this.f = builder.i;
        this.p = builder.f2234a;
        this.f2222q = builder.b;
        this.f2223r = builder.c;
        this.f2225t = builder.f2238s;
        this.f2224s = builder.f2237r;
        this.u = builder.f2239t;
        this.f2226v = builder.f2243z;
        this.f2227w = builder.f2230A;
        this.f2228x = builder.f2231B;
        this.g = builder.f2235j;
        this.y = builder.f2232C;
        this.f2229z = builder.f2233D;
        this.h = builder.u;
        this.f2216A = builder.f2241w;
        this.i = builder.k;
        this.f2221j = builder.l;
        this.k = builder.p;
        this.f2217B = builder.f2242x;
        this.l = builder.f2236q;
        this.m = builder.m;
        this.n = builder.n;
        this.o = builder.o;
        this.f2218C = builder.y;
        this.f2219D = builder.f2240v;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean enableAPMPlusLocalLog() {
        return this.f2218C;
    }

    public boolean enableBatteryMonitor() {
        return this.g;
    }

    public boolean enableCpuMonitor() {
        return this.i;
    }

    public boolean enableDiskMonitor() {
        return this.f2221j;
    }

    public boolean enableHybridMonitor() {
        return this.d;
    }

    public boolean enableLogRecovery() {
        return this.h;
    }

    public boolean enableMemoryMonitor() {
        return this.e;
    }

    public boolean enableNetMonitor() {
        return this.m;
    }

    public boolean enableOperateMonitor() {
        return this.l;
    }

    public boolean enablePageMonitor() {
        return this.o;
    }

    public boolean enableStartMonitor() {
        return this.n;
    }

    public boolean enableTrace() {
        return this.f2217B;
    }

    public boolean enableTrafficMonitor() {
        return this.k;
    }

    public boolean enableWebViewMonitor() {
        return this.c;
    }

    public IActivityLeakListener getActivityLeakListener() {
        return this.f2219D;
    }

    public String getAid() {
        return this.p;
    }

    public String getChannel() {
        return this.f2223r;
    }

    public List<String> getDefaultLogReportUrls() {
        return this.f2227w;
    }

    public IDynamicParams getDynamicParams() {
        return this.y;
    }

    public List<String> getExceptionLogReportUrls() {
        return this.f2228x;
    }

    public String getExternalTraceId() {
        return this.f2216A;
    }

    public JSONObject getHeader() {
        return this.f2225t;
    }

    public long getMaxLaunchTime() {
        return this.f2224s;
    }

    public f2.a getNetworkClient() {
        return this.f2229z;
    }

    public List<String> getSlardarConfigUrls() {
        return this.f2226v;
    }

    public String getToken() {
        return this.f2222q;
    }

    public boolean isDebug() {
        return this.u;
    }

    public boolean isWithBlockDetect() {
        return this.f2220a;
    }

    public boolean isWithFpsMonitor() {
        return this.f;
    }

    public boolean isWithSeriousBlockDetect() {
        return this.b;
    }

    public static Builder builder(ApmInsightInitConfig apmInsightInitConfig) {
        return new Builder(apmInsightInitConfig);
    }
}
