package com.bytedance.bdtracker;

import com.bytedance.applog.Level;
import com.bytedance.applog.log.EventBus;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.logpull.LogPullAuthActivity;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h0 extends c0 {
    public static final long[] g = {60000, 60000, 60000, 120000, 120000, 180000, 180000, Constants.SYSTEM_SERVER_ERROR_INTERVAL, Constants.SYSTEM_SERVER_ERROR_INTERVAL, 540000, 540000};
    public static final long[] h = {180000, 180000, Constants.SYSTEM_SERVER_ERROR_INTERVAL, Constants.SYSTEM_SERVER_ERROR_INTERVAL, 540000, 540000, 720000, 720000};
    public static final long[] i = {2000, 10000, 10000, 20000, 20000, 60000, 60000, 120000, 120000, 180000, 180000, Constants.SYSTEM_SERVER_ERROR_INTERVAL, Constants.SYSTEM_SERVER_ERROR_INTERVAL, 540000, 540000};

    public class a implements EventBus.DataFetcher {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public a(String str, String str2, String str3, String str4, String str5, String str6) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = str6;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", h0.this.f.m);
                jSONObject.put("did", this.a);
                jSONObject.put("installId", this.b);
                jSONObject.put("ssid", this.c);
                jSONObject.put("bdDid", this.d);
                jSONObject.put("uuid", this.e);
                jSONObject.put("uuidType", this.f);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(e0 e0Var) {
        super(e0Var);
        long jOptLong = e0Var.i.d.optLong("register_time", 0L);
        this.c = jOptLong;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean a(org.json.JSONObject r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.h0.a(org.json.JSONObject):boolean");
    }

    public JSONObject b(JSONObject jSONObject) {
        this.e.d.D.debug(1, "Start to invokeRegister", new Object[0]);
        try {
            if (jSONObject.opt(LogPullAuthActivity.EXTRA_OAID) instanceof String) {
                jSONObject.remove(LogPullAuthActivity.EXTRA_OAID);
                if (this.e.i != null && this.e.i.e() != null) {
                    Object objOpt = this.e.i.e().opt(LogPullAuthActivity.EXTRA_OAID);
                    if (objOpt instanceof JSONObject) {
                        jSONObject.put(LogPullAuthActivity.EXTRA_OAID, objOpt);
                    }
                }
            }
            JSONObject jSONObjectB = z3.b(jSONObject);
            return this.f.k.a(this.f.j.a(jSONObject, this.e.e().getRegisterUri(), true, Level.L1), jSONObjectB);
        } catch (Throwable th) {
            this.e.d.D.error(1, "Request to register server failed.", th, new Object[0]);
            return null;
        }
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean c() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, this.e.i.e());
        return a(jSONObject);
    }

    @Override // com.bytedance.bdtracker.c0
    public String d() {
        return "register";
    }

    @Override // com.bytedance.bdtracker.c0
    public long[] e() {
        int iH = this.e.i.h();
        if (iH == 0) {
            return i;
        }
        if (iH == 1) {
            return h;
        }
        if (iH == 2) {
            return g;
        }
        this.e.d.D.error(1, "Unknown register state", new Object[0]);
        return h;
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean g() {
        return true;
    }

    @Override // com.bytedance.bdtracker.c0
    public long h() {
        return this.e.n.j ? 21600000L : 43200000L;
    }

    public JSONObject c(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectB = z3.b(jSONObject);
            return this.f.k.b(this.e.e().getReportOaidUri(), jSONObjectB);
        } catch (Throwable th) {
            this.e.d.D.error(1, "Report oaid failed.", th, new Object[0]);
            return null;
        }
    }
}
