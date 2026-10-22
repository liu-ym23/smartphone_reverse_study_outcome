package o8;

import android.content.Intent;
import android.util.Log;
import com.stepos.agentsafetycenter.auth.LaunchAuthActivity;
import java.util.List;
import jb.v;
import k0.k1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9318c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ LaunchAuthActivity f9319f;

    public /* synthetic */ k(int i) {
        this.f9318c = i;
    }

    @Override // xb.a
    public final Object invoke() {
        Object objL;
        int i = this.f9318c;
        v vVar = v.f6774a;
        LaunchAuthActivity launchAuthActivity = this.f9319f;
        switch (i) {
            case 0:
                int i3 = LaunchAuthActivity.f2495l;
                Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
                intent.addFlags(268435456);
                try {
                    launchAuthActivity.startActivity(intent);
                    objL = vVar;
                } catch (Throwable th) {
                    objL = id.c.l(th);
                }
                Throwable thB = jb.i.b(objL);
                if (thB != null) {
                    Log.w("RiskyA11yInspector", "openAccessibilitySettings failed", thB);
                    break;
                }
                break;
            default:
                int i10 = LaunchAuthActivity.f2495l;
                List listQ = id.k.Q(launchAuthActivity);
                boolean zIsEmpty = listQ.isEmpty();
                k1 k1Var = launchAuthActivity.f2498g;
                if (!zIsEmpty) {
                    f fVar = new f();
                    fVar.f9312a = listQ;
                    k1Var.setValue(fVar);
                    break;
                } else {
                    k1Var.setValue(h.f9314a);
                    launchAuthActivity.g();
                    break;
                }
        }
        return vVar;
    }
}
