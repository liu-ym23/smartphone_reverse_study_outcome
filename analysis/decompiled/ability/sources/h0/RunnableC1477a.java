package h0;

import H.h;
import android.util.Log;
import androidx.compose.animation.core.AnimationKt;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import w0.C2086g;

/* renamed from: h0.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1477a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4534a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ C1479c d;

    public RunnableC1477a(C1479c c1479c, String str, long j5, long j6) {
        this.d = c1479c;
        this.f4534a = str;
        this.b = j5;
        this.c = j6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j5 = this.c - this.b;
        int i = (int) j5;
        C1479c c1479c = this.d;
        if (i > 0) {
            HashMap map = c1479c.c;
            String str = this.f4534a;
            C1478b c1478b = (C1478b) map.get(str);
            if (c1478b == null) {
                c1478b = new C1478b();
                c1478b.c = 0;
                c1478b.e = 0L;
                c1478b.f = new int[60];
                c1478b.f4535a = str;
                c1479c.c.put(str, c1478b);
            }
            C1478b c1478b2 = c1478b;
            long j6 = f.p.k;
            c1478b2.b += j5;
            int iMax = Math.max((int) ((j5 * AnimationKt.MillisToNanos) / j6), 0);
            c1478b2.e += iMax;
            int iMin = Math.min(iMax, 59);
            int[] iArr = c1478b2.f;
            iArr[iMin] = iArr[iMin] + 1;
            c1478b2.d += iMin;
            int i6 = c1478b2.c + 1;
            c1478b2.c = i6;
            if (i6 % 100 == 0) {
                int i10 = (int) (600000 / (c1478b2.e + 100));
                c1478b2.e = 0L;
                J.d dVar = J.c.f859a;
                dVar.getClass();
                L0.d.f925a.b(new J.a(dVar, c1478b2.f4535a, (float) (i10 / 100.0d)));
            }
            if (c1478b2.c >= 1000) {
                c1479c.c.remove(str);
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (int i11 = 0; i11 <= 59; i11++) {
                        if (c1478b2.f[i11] > 0) {
                            jSONObject.put(String.valueOf(i11), c1478b2.f[i11]);
                        }
                    }
                    JSONObject jSONObjectA = C2086g.b().a("fps_drop");
                    jSONObjectA.put("scene", c1478b2.f4535a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("total_scroll_time", c1478b2.b);
                    jSONObject2.put("drop_time_rate", 1.0f - ((c1478b2.c * 1.0f) / ((int) (c1478b2.b / 16.666668f))));
                    P.e eVar = new P.e("fps_drop", c1478b2.f4535a, "", jSONObject, jSONObjectA, jSONObject2);
                    eVar.f = O0.a.a().b();
                    O.a.g().c(eVar);
                    if (h.b) {
                        Log.d("ApmInsight", U7.a.e(new String[]{"Receive:fps_drop"}));
                    }
                } catch (JSONException unused) {
                } catch (Throwable th) {
                    c1478b2.c = 0;
                    c1478b2.d = 0;
                    c1478b2.b = 0L;
                    throw th;
                }
                c1478b2.c = 0;
                c1478b2.d = 0;
                c1478b2.b = 0L;
            }
        }
        if (c1479c.b.size() <= 0) {
            return;
        }
        c1479c.b.get(0).getClass();
        throw new ClassCastException();
    }
}
