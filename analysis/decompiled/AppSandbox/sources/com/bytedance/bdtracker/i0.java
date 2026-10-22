package com.bytedance.bdtracker;

import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class i0 extends c0 {
    public static final long[] h = {10000};
    public final f3 g;

    public class a implements EventBus.DataFetcher {
        public final /* synthetic */ Set a;
        public final /* synthetic */ boolean b;

        public a(Set set, boolean z) {
            this.a = set;
            this.b = z;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("$$APP_ID", i0.this.f.m);
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    jSONArray.put((String) it.next());
                }
                jSONObject.put("$$EVENT_LOCAL_ID_ARRAY", jSONArray);
                jSONObject.put("$$UPLOAD_STATUS", this.b ? "success" : "failed");
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public i0(e0 e0Var) {
        super(e0Var);
        this.g = new f3("sender_", e0Var.e);
    }

    public final void a(Set<String> set, boolean z) {
        if (LogUtils.isDisabled() || set == null || set.isEmpty()) {
            return;
        }
        LogUtils.sendJsonFetcher("event_upload_eid", new a(set, z));
    }

    public boolean a(n4 n4Var) {
        boolean z;
        b4 b4Var = this.f.j;
        e0 e0Var = this.e;
        String[] strArrA = b4Var.a(e0Var, e0Var.i.e(), n4Var.l);
        try {
            JSONObject jSONObject = new JSONObject(new String(n4Var.z));
            jSONObject.put("local_time", System.currentTimeMillis() / 1000);
            int iA = this.f.k.a(strArrA, jSONObject, this.e.e);
            z = true;
            if (iA == 200) {
                this.g.c();
                n4Var.A = 0;
                try {
                    a(n4Var.l(), true);
                    this.e.c().a(jSONObject);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    this.e.d.D.error(4, "Send pack failed", th, new Object[0]);
                    a(n4Var.l(), false);
                    return z;
                }
            }
            if (iA >= 500 && iA < 600) {
                this.g.b();
            }
            o2.a(this.e.q, 13L, this.e.d(), iA);
            this.e.d.D.error(4, "Send pack failed:{}", Integer.valueOf(iA));
            n4Var.A++;
            a(n4Var.l(), false);
            return false;
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00dd A[Catch: all -> 0x00f4, LOOP:2: B:35:0x00dd->B:37:0x00e3, LOOP_START, TRY_ENTER, TryCatch #1 {all -> 0x00f4, blocks: (B:32:0x00c7, B:35:0x00dd, B:37:0x00e3), top: B:71:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0131  */
    @Override // com.bytedance.bdtracker.c0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c() {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.i0.c():boolean");
    }

    @Override // com.bytedance.bdtracker.c0
    public String d() {
        return "sender";
    }

    @Override // com.bytedance.bdtracker.c0
    public long[] e() {
        return h;
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean g() {
        return true;
    }

    @Override // com.bytedance.bdtracker.c0
    public long h() {
        u1 u1Var = this.e.e;
        return u1Var.a(u1Var.p) ? u1Var.p : u1Var.f.getLong("batch_event_interval", 60000L);
    }
}
