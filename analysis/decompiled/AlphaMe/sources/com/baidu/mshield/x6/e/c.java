package com.baidu.mshield.x6.e;

import android.content.Context;
import com.baidu.mshield.x6.f.l;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public Context f8483a;

    /* renamed from: b, reason: collision with root package name */
    public g f8484b;

    /* renamed from: c, reason: collision with root package name */
    public com.baidu.mshield.x6.b.b f8485c;

    /* renamed from: d, reason: collision with root package name */
    public int f8486d;

    public c(Context context, int i4) {
        this.f8483a = context;
        this.f8486d = i4;
        this.f8484b = new g(context, i4);
        this.f8485c = new com.baidu.mshield.x6.b.b(this.f8483a);
    }

    public final long a() {
        long j4 = VehicleBluetoothManager.FAIL_RETRY_TIMEOUT;
        try {
            int i4 = h.f8500d;
            if (i4 == 0 || i4 == 1 || i4 == 2) {
                j4 = 5000;
            } else if ((i4 < 3 || i4 >= 10) && i4 >= 10) {
                j4 = -1;
            }
            h.f8500d = i4 + 1;
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
        return j4;
    }

    public void b() {
        JSONObject jSONObjectA;
        try {
            com.baidu.mshield.b.c.a.a("report static alive for start");
            JSONObject jSONObjectA2 = this.f8484b.a();
            if (jSONObjectA2 != null) {
                jSONObjectA = com.baidu.mshield.x6.f.f.a(this.f8483a, jSONObjectA2, com.baidu.mshield.x6.f.g.f8515c, true);
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("11111", "-1");
                jSONObjectA = com.baidu.mshield.x6.f.f.a(this.f8483a, jSONObject, com.baidu.mshield.x6.f.g.f8515c, true);
            }
            com.baidu.mshield.b.c.a.a("sendJson:" + jSONObjectA);
        } finally {
            try {
            } finally {
            }
        }
        if (!com.baidu.mshield.b.a.d.b(this.f8483a)) {
            h.f8499c = false;
            return;
        }
        int iA = l.a(this.f8483a, jSONObjectA.toString());
        com.baidu.mshield.b.c.a.c("result: " + iA);
        if (iA == 0) {
            this.f8485c.s(com.baidu.mshield.x6.f.f.c());
            this.f8485c.b(true);
            this.f8485c.e(false);
        } else {
            long jA = a();
            if (com.baidu.mshield.b.a.d.b(this.f8483a) && jA > 0) {
                f.b(this.f8483a).a(jA);
            }
        }
    }
}
