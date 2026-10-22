package Y;

import H.f;
import H.h;
import android.text.TextUtils;
import ca.AbstractC0897f;
import com.apm.insight.CrashType;
import com.apm.insight.g;
import com.stepos.ability.task.executor.e;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import e2.C1404a;
import fa.C1449a;
import java.io.File;
import org.json.JSONObject;
import v2.RunnableC2056a;
import w2.i;
import z2.l;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1556a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(String str, int i) {
        this.f1556a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1556a) {
            case 0:
                long j5 = AbstractC0897f.f2125w;
                String str = this.b;
                if (j5 == 0) {
                    AbstractC0897f.f2115A = str;
                    AbstractC0897f.f2125w = System.currentTimeMillis();
                }
                AbstractC0897f.m = System.currentTimeMillis();
                AbstractC0897f.f2122s = str;
                if (e.e) {
                    e.e = false;
                    if (e.h.equals(e.i)) {
                        boolean z10 = e.g;
                        if (z10 && !e.f) {
                            AbstractC0897f.g(4, false);
                            break;
                        } else if (!z10) {
                            AbstractC0897f.g(3, false);
                            break;
                        }
                    }
                }
                break;
            case 1:
                try {
                    if (h.d() != null && TextUtils.isEmpty(h.d().optString("device_id"))) {
                        h.b("device_id", C1404a.c(this.b).b());
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
                break;
            case 2:
                try {
                    n2.a aVar = new n2.a();
                    aVar.e(this.b, SettingsConfig.KEY_DATA);
                    aVar.e(1, "userdefine");
                    n2.a aVarP = u1.d.s().p(CrashType.CUSTOM_JAVA, aVar);
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
            default:
                C1449a c1449aE = g.e();
                String str2 = this.b;
                c1449aE.b = str2;
                u1.d dVarB = u1.d.B();
                dVarB.getClass();
                try {
                    M.a.t(str2, (File) dVarB.c, false);
                } catch (Throwable unused2) {
                }
                RunnableC2056a.a();
                break;
        }
    }
}
