package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1602s0;
import com.amap.api.col.jmsl.O2;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.h0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1559h0 {

    /* renamed from: c, reason: collision with root package name */
    public static C1559h0 f16649c;

    /* renamed from: d, reason: collision with root package name */
    public static Context f16650d;

    /* renamed from: a, reason: collision with root package name */
    public b f16651a;

    /* renamed from: b, reason: collision with root package name */
    public HandlerThread f16652b = new a("manifestThread");

    /* renamed from: com.amap.api.col.jmsl.h0$a */
    public class a extends HandlerThread {

        /* renamed from: com.amap.api.col.jmsl.h0$a$a, reason: collision with other inner class name */
        public class C0205a implements C1602s0.b {
            public C0205a() {
            }

            @Override // com.amap.api.col.jmsl.C1602s0.b
            public void onReceiveAuthConfig(C1602s0.c cVar) {
                JSONObject jSONObjectOptJSONObject;
                JSONObject jSONObjectOptJSONObject2;
                Message message = new Message();
                try {
                    C1602s0.c.a aVar = cVar.f16897d;
                    if (aVar != null) {
                        message.obj = new C1595q0(false, aVar.f16898a);
                    }
                    JSONObject jSONObject = cVar.f16896c;
                    if (jSONObject != null && (jSONObjectOptJSONObject2 = jSONObject.optJSONObject("184")) != null) {
                        C1559h0.this.h(jSONObjectOptJSONObject2);
                        r.p(C1559h0.f16650d, "amap_search", "cache_control", jSONObjectOptJSONObject2.toString());
                    }
                    JSONObject jSONObject2 = cVar.f16896c;
                    if (jSONObject2 != null && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("185")) != null) {
                        C1559h0.this.k(jSONObjectOptJSONObject);
                        r.p(C1559h0.f16650d, "amap_search", "parm_control", jSONObjectOptJSONObject.toString());
                    }
                    message.what = 3;
                    if (C1559h0.this.f16651a == null) {
                    }
                } catch (Throwable th) {
                    try {
                        C1631z1.o(th, "ManifestConfig", "run");
                    } finally {
                        message.what = 3;
                        if (C1559h0.this.f16651a != null) {
                            C1559h0.this.f16651a.sendMessage(message);
                        }
                    }
                }
            }
        }

        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            Thread.currentThread().setName("ManifestConfigThread");
            C1569j2 c1569j2A = T2.a(false);
            C1559h0.e(C1559h0.this, C1559h0.f16650d);
            C1602s0.h(C1559h0.f16650d, c1569j2A, "11K" + Const.STR_MART_SEMICOLON + "001" + Const.STR_MART_SEMICOLON + "184" + Const.STR_MART_SEMICOLON + "185", new C0205a());
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.h0$b */
    public class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public String f16655a;

        public b(C1559h0 c1559h0, Looper looper) {
            super(looper);
            this.f16655a = "handleMessage";
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    C1595q0 c1595q0 = (C1595q0) message.obj;
                    if (c1595q0 == null) {
                        c1595q0 = new C1595q0(false, false);
                    }
                    C1541c2.e(C1559h0.f16650d, T2.a(c1595q0.a()));
                    T2.a(c1595q0.a());
                } catch (Throwable th) {
                    C1631z1.o(th, "ManifestConfig", this.f16655a);
                }
            }
        }
    }

    public C1559h0(Context context) {
        f16650d = context;
        T2.a(false);
        try {
            i();
            this.f16651a = new b(this, Looper.getMainLooper());
            this.f16652b.start();
        } catch (Throwable th) {
            C1631z1.o(th, "ManifestConfig", "ManifestConfig");
        }
    }

    public static C1559h0 c(Context context) {
        if (f16649c == null) {
            f16649c = new C1559h0(context);
        }
        return f16649c;
    }

    public static void e(C1559h0 c1559h0, Context context) {
        c1559h0.getClass();
        try {
            String str = (String) r.k(context, "amap_search", "cache_control", "");
            if (!TextUtils.isEmpty(str)) {
                c1559h0.h(new JSONObject(str));
            }
            String str2 = (String) r.k(context, "amap_search", "parm_control", "");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            c1559h0.k(new JSONObject(str2));
        } catch (Throwable th) {
            C1631z1.o(th, "ManifestConfig", "ManifestConfig-readAuthFromCache");
        }
    }

    public final O2.a d(JSONObject jSONObject, boolean z10, O2.a aVar) {
        O2.a aVar2;
        Throwable th;
        boolean zOptBoolean;
        if (jSONObject == null) {
            return null;
        }
        try {
            aVar2 = new O2.a();
            boolean z11 = true;
            try {
                if (z10) {
                    String strOptString = jSONObject.optString("able");
                    if (aVar != null && !aVar.h()) {
                        z11 = false;
                    }
                    zOptBoolean = C1602s0.u(strOptString, z11);
                } else {
                    if (aVar != null && !aVar.h()) {
                        z11 = false;
                    }
                    zOptBoolean = jSONObject.optBoolean("able", z11);
                }
                int iOptInt = jSONObject.optInt("timeoffset", aVar != null ? (int) aVar.g() : 86400);
                int iOptInt2 = jSONObject.optInt("num", aVar != null ? aVar.f() : 10);
                double dOptDouble = jSONObject.optDouble("limitDistance", aVar != null ? aVar.a() : 0.0d);
                aVar2.e(zOptBoolean);
                aVar2.d(iOptInt);
                aVar2.c(iOptInt2);
                aVar2.b(dOptDouble);
                return aVar2;
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return aVar2;
            }
        } catch (Throwable th3) {
            aVar2 = null;
            th = th3;
        }
    }

    public final void g(String str, JSONObject jSONObject, O2.a aVar) {
        if (jSONObject.has(str)) {
            O2.b().f(str, d(jSONObject.optJSONObject(str), false, aVar));
        }
    }

    public final void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("able")) {
                    O2.a aVarD = d(jSONObject, true, null);
                    O2.b().d(aVarD);
                    if (aVarD.h()) {
                        g("regeo", jSONObject, aVarD);
                        g("geo", jSONObject, aVarD);
                        g("placeText", jSONObject, aVarD);
                        g("placeAround", jSONObject, aVarD);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void i() {
        H2.a();
    }

    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean zU = C1602s0.u(jSONObject.optString("passAreaAble"), true);
                boolean zU2 = C1602s0.u(jSONObject.optString("truckAble"), true);
                boolean zU3 = C1602s0.u(jSONObject.optString("poiPageAble"), true);
                boolean zU4 = C1602s0.u(jSONObject.optString("rideAble"), true);
                boolean zU5 = C1602s0.u(jSONObject.optString("walkAble"), true);
                boolean zU6 = C1602s0.u(jSONObject.optString("passPointAble"), true);
                boolean zU7 = C1602s0.u(jSONObject.optString("keyWordLenAble"), true);
                int iOptInt = jSONObject.optInt("poiPageMaxSize", 25);
                int iOptInt2 = jSONObject.optInt("passAreaMaxCount", 100);
                int iOptInt3 = jSONObject.optInt("walkMaxLength", 100);
                int iOptInt4 = jSONObject.optInt("passPointMaxCount", 6);
                int iOptInt5 = jSONObject.optInt("poiPageMaxNum", 100);
                int iOptInt6 = jSONObject.optInt("truckMaxLength", s7.DEFAULT_RETRY_TIMEOUT);
                int iOptInt7 = jSONObject.optInt("rideMaxLength", AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS);
                int iOptInt8 = jSONObject.optInt("passAreaMaxArea", 100000000);
                int iOptInt9 = jSONObject.optInt("passAreaPointCount", 16);
                int iOptInt10 = jSONObject.optInt("keyWordLenMaxNum", 100);
                C1542d.b().f16565a = zU;
                C1542d.b().f16574j = iOptInt2;
                C1542d.b().f16580p = iOptInt8;
                C1542d.b().f16581q = iOptInt9;
                C1542d.b().f16567c = zU2;
                C1542d.b().f16578n = iOptInt6;
                C1542d.b().f16568d = zU3;
                C1542d.b().f16577m = iOptInt5;
                C1542d.b().f16572h = iOptInt;
                C1542d.b().f16573i = iOptInt10;
                C1542d.b().f16566b = zU7;
                C1542d.b().f16569e = zU4;
                C1542d.b().f16579o = iOptInt7;
                C1542d.b().f16570f = zU5;
                C1542d.b().f16575k = iOptInt3;
                C1542d.b().f16571g = zU6;
                C1542d.b().f16576l = iOptInt4;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
