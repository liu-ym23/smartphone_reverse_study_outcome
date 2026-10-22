package j1;

import H.h;
import H4.o;
import L0.d;
import com.bytedance.apm.insight.ApmInsight;
import g1.AbstractC1451a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import o0.RunnableC1754a;
import org.json.JSONObject;
import x0.C2112a;

/* renamed from: j1.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1592a implements C.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4752a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C1592a(Object obj, int i) {
        this.f4752a = i;
        this.b = obj;
    }

    private final void a() {
    }

    private final void b() {
    }

    private final void c() {
    }

    @Override // C.a
    public final void onReady() {
        int i = this.f4752a;
    }

    @Override // C.a
    public final void onRefresh(JSONObject jSONObject, boolean z10) {
        switch (this.f4752a) {
            case 0:
                if (AbstractC1451a.f4467a) {
                    o.f("APM-Config", "config:" + jSONObject);
                }
                C1593b c1593b = (C1593b) this.b;
                c1593b.c = jSONObject;
                c1593b.d = true;
                CopyOnWriteArrayList copyOnWriteArrayList = c1593b.b;
                if (copyOnWriteArrayList != null) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        try {
                            ((c) it.next()).c(jSONObject);
                        } catch (Throwable unused) {
                        }
                    }
                    break;
                }
                break;
            case 1:
                if (!ApmInsight.b && h.f719x) {
                    RunnableC1754a runnableC1754a = (RunnableC1754a) this.b;
                    d.f925a.b(new RunnableC1754a(runnableC1754a.e, runnableC1754a.b, runnableC1754a.d, runnableC1754a.c));
                    boolean unused2 = ApmInsight.b = true;
                    break;
                }
                break;
            default:
                C2112a c2112a = (C2112a) this.b;
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("general");
                if (jSONObjectOptJSONObject == null) {
                    c2112a.b = false;
                    break;
                } else {
                    c2112a.b = jSONObjectOptJSONObject.optBoolean("enable_apmplus_alog", true);
                    break;
                }
        }
    }
}
