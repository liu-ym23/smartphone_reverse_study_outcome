package S;

import F9.A;
import F9.G;
import F9.M;
import F9.z;
import H.h;
import K9.g;
import S0.b;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes2.dex */
public final class a implements A {
    @Override // F9.A
    public final M intercept(z zVar) {
        if (h.b) {
            Log.d("ApmInsight", U7.a.e(new String[]{"intercept"}));
        }
        if (!h.u) {
            g gVar = (g) zVar;
            return gVar.b(gVar.e);
        }
        g gVar2 = (g) zVar;
        G g = gVar2.e;
        K1.a aVarB = g.b();
        try {
            if (TextUtils.isEmpty(g.a("x-rum-traceparent"))) {
                String strP0 = b.P0();
                aVarB.b("x-rum-traceparent", strP0);
                if (h.b) {
                    Log.d("ApmInsight", U7.a.e(new String[]{"x-rum-traceparent:".concat(strP0)}));
                }
            }
            if (TextUtils.isEmpty(g.a("x-rum-tracestate")) && !TextUtils.isEmpty(h.a())) {
                aVarB.b("x-rum-tracestate", "app_id=" + h.a() + ",origin=rum");
                if (h.b) {
                    Log.d("ApmInsight", U7.a.e(new String[]{"x-rum-tracestate:app_id=" + h.a() + ",origin=rum"}));
                }
            }
        } catch (Throwable th) {
            if (h.b) {
                th.printStackTrace();
            }
        }
        return gVar2.b(aVarB.d());
    }
}
