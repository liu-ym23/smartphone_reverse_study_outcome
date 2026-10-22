package g0;

import H.h;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b extends AbstractC1450a implements B.c, C.a {
    public boolean b;
    public boolean c;
    public g d;

    @Override // g0.AbstractC1450a
    public final void b(String str) {
        this.f4456a = true;
        if (this.c) {
            g gVar = this.d;
            gVar.getClass();
            try {
                if (gVar.f4462a.d != null) {
                    gVar.h = new c(SystemClock.uptimeMillis(), str);
                    gVar.f4462a.b(gVar.i, gVar.c);
                    if (gVar.b) {
                        gVar.f4462a.b(gVar.f4463j, gVar.d);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // B.c
    public final void c(Activity activity) {
    }

    @Override // g0.AbstractC1450a
    public final void d(boolean z10) {
        this.f4456a = false;
        if (this.c) {
            this.d.d(z10);
        }
    }

    public final void e() {
        if (!this.b || this.c) {
            return;
        }
        this.c = true;
        if (h.b) {
            Log.d("BlockDetector", U7.a.e(new String[]{"BlockDetector start: "}));
        }
    }

    @Override // B.c
    public final void f(Activity activity) {
        if (this.c) {
            this.c = false;
            this.d.d(false);
            if (h.b) {
                Log.d("BlockDetector", U7.a.e(new String[]{"BlockDetector stop: "}));
            }
        }
    }

    @Override // B.c
    public final void g(Bundle bundle) {
    }

    @Override // B.c
    public final void onActivityStarted(Activity activity) {
    }

    @Override // C.a
    public final void onReady() {
    }

    @Override // C.a
    public final void onRefresh(JSONObject jSONObject, boolean z10) {
        g gVar = this.d;
        JSONObject jSONObjectU = S0.b.u("performance_modules", jSONObject, "smooth");
        if (jSONObjectU == null) {
            return;
        }
        long jOptLong = jSONObjectU.optLong("block_threshold", 2500L);
        long jOptLong2 = jSONObjectU.optLong("serious_block_threshold", 5000L);
        gVar.getClass();
        long j5 = jOptLong >= 70 ? jOptLong : 2500L;
        gVar.c = j5;
        if (gVar.d < j5) {
            gVar.d = j5 + 50;
        }
        long j6 = jOptLong2 >= j5 ? jOptLong2 : 5000L;
        gVar.d = j6;
        if (j6 < j5) {
            gVar.d = j5 + 50;
        }
    }

    @Override // B.c
    /* renamed from: c */
    public final void mo0c() {
        e();
    }
}
