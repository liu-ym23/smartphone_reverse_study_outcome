package o2;

import H.f;
import com.apm.insight.CrashType;
import com.apm.insight.g;
import org.json.JSONObject;
import u1.d;
import w2.i;
import z2.l;

/* renamed from: o2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1756a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5416a;
    public final /* synthetic */ Throwable b;

    public /* synthetic */ RunnableC1756a(int i, Throwable th) {
        this.f5416a = i;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5416a) {
            case 0:
                S0.b.B0(null, this.b, "NPTH_ANR_MONITOR_ERROR", null, "EnsureNotReachHere");
                break;
            default:
                try {
                    n2.a aVarA = n2.a.a(System.currentTimeMillis(), g.f2160a, this.b);
                    aVarA.e(1, "userdefine");
                    n2.a aVarP = d.s().p(CrashType.CUSTOM_JAVA, aVarA);
                    if (aVarP != null) {
                        i iVarA = i.a();
                        JSONObject jSONObject = aVarP.f5345a;
                        iVarA.getClass();
                        if (jSONObject != null && jSONObject.length() != 0) {
                            l.i().a(new f(3, jSONObject));
                            break;
                        }
                    }
                } catch (Throwable unused) {
                    return;
                }
                break;
        }
    }
}
