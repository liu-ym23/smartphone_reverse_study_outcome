package com.bytedance.apm6.traffic;

import A0.e;
import B0.b;
import H4.o;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import cc.dd.ee.jj.a;
import g1.AbstractC1451a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TrafficTransportService extends Service {
    public static final /* synthetic */ int b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final a f2246a = new a(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f2246a.asBinder();
    }

    public class a extends a.AbstractBinderC0142a {
        public a(TrafficTransportService trafficTransportService) {
        }

        @Override // cc.dd.ee.jj.a
        public void a(long j5, String str, String str2, String str3, String str4, String str5) {
            String str6;
            JSONObject jSONObject;
            JSONObject jSONObject2;
            if (AbstractC1451a.f4467a) {
                StringBuilder sb = new StringBuilder("trafficStats ");
                sb.append(j5);
                sb.append(", ");
                sb.append(str);
                str6 = str3;
                androidx.constraintlayout.core.dsl.a.A(sb, ", ", str2, ", ", str6);
                o.r("APM-Traffic-Detail", androidx.appfunctions.metadata.a.p(sb, ", ", str4, ", ", str5));
            } else {
                str6 = str3;
            }
            try {
                jSONObject = new JSONObject(str4);
            } catch (JSONException unused) {
                jSONObject = null;
            }
            try {
                jSONObject2 = new JSONObject(str5);
            } catch (JSONException unused2) {
                jSONObject2 = null;
                A0.a.f67a.k(j5, str, str2, str6, jSONObject, jSONObject2);
            }
            A0.a.f67a.k(j5, str, str2, str6, jSONObject, jSONObject2);
        }

        @Override // cc.dd.ee.jj.a
        public void b(String str) {
            if (AbstractC1451a.f4467a) {
                o.r("APM-Traffic-Detail", "initCustomMetricBizTrafficStats " + str);
            }
            A0.a.f67a.b(str);
        }

        @Override // cc.dd.ee.jj.a
        public void c(String str) {
            JSONObject jSONObject;
            if (AbstractC1451a.f4467a) {
                o.r("APM-Traffic-Detail", "httpImageApiTrafficStats " + str);
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                jSONObject = null;
            }
            A0.a.f67a.c(jSONObject);
        }

        @Override // cc.dd.ee.jj.a
        public void a(String str) {
            if (AbstractC1451a.f4467a) {
                o.r("APM-Traffic-Detail", "stopMetric " + str);
            }
            e.f71a.a(str);
        }

        @Override // cc.dd.ee.jj.a
        public void a(String str, String str2) {
            JSONObject jSONObject;
            if (AbstractC1451a.f4467a) {
                o.r("APM-Traffic-Detail", "httpApiTrafficStats " + str + ", " + str2);
            }
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException unused) {
                jSONObject = null;
            }
            ((b) A0.a.f67a.b).s(str, jSONObject);
        }

        @Override // cc.dd.ee.jj.a
        public void a(String str, boolean z10) {
            if (AbstractC1451a.f4467a) {
                o.r("APM-Traffic-Detail", "startMetric " + str + ", " + z10);
            }
            e.f71a.a(str, z10);
        }
    }
}
