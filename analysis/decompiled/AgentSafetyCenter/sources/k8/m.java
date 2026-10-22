package k8;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.stepos.agentsafetycenter.MainActivity;
import java.util.List;
import k0.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements androidx.lifecycle.v {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Context f7319c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ c1 f7320f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ c1 f7321g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ c1 f7322h;

    @Override // androidx.lifecycle.v
    public final void e(androidx.lifecycle.x xVar, androidx.lifecycle.o oVar) {
        d0 d0Var;
        Object objL;
        Context context = this.f7319c;
        c1 c1Var = this.f7320f;
        c1 c1Var2 = this.f7321g;
        c1 c1Var3 = this.f7322h;
        int i = MainActivity.f2491h;
        if (oVar == androidx.lifecycle.o.ON_RESUME && (d0Var = (d0) c1Var.getValue()) != null && context.getApplicationContext().getSharedPreferences("installed_apps_consent", 0).getBoolean("user_granted", false)) {
            try {
                objL = context.getPackageManager().getInstalledApplications(PackageManager.ApplicationInfoFlags.of(128));
            } catch (Throwable th) {
                objL = id.c.l(th);
            }
            Throwable thB = jb.i.b(objL);
            if (thB != null) {
                Log.w("InstalledAppsAccess", "queryInstalledApplications failed", thB);
            }
            if (objL instanceof jb.h) {
                objL = kb.s.f7404c;
            }
            if (((List) objL).isEmpty()) {
                return;
            }
            c1Var2.setValue(d0Var);
            c1Var.setValue(null);
            MainActivity.f(c1Var3, false);
        }
    }
}
