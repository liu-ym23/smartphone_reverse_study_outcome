package ha;

import android.text.TextUtils;
import com.stepos.agentsafetycenter.AgentSafetyApplication;
import i1.j;
import i1.m;
import i1.n;
import i1.s;
import i1.t;
import i1.z;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f5430a = new ArrayList(32);

    public void a(AgentSafetyApplication agentSafetyApplication, String str, String str2, Map map, int i) {
        StringBuilder sbP = androidx.activity.b.p("onActionXEvent, eventName: ", str, ", pageName: ", str2, ", properties: ");
        sbP.append(map);
        sbP.append(", sendType: ");
        sbP.append(i);
        sbP.append(", replaceMap: null");
        ua.c.a("EventController", sbP.toString());
        if (TextUtils.isEmpty(str)) {
            ua.c.b("EventController", "onActionXEvent fail, eventName is empty");
            return;
        }
        HashMap map2 = map == null ? null : new HashMap(map);
        b bVar = new b();
        bVar.f5424c = this;
        bVar.f5425f = agentSafetyApplication;
        bVar.f5426g = str;
        bVar.f5427h = str2;
        bVar.i = map2;
        bVar.f5428j = i;
        bVar.f5429k = null;
        VarHandle.storeStoreFence();
        sa.c.f(bVar);
    }

    public void b() {
        this.f5430a.add(j.f5707c);
    }

    public void c(float f5, float f10, float f11, float f12, float f13, float f14) {
        this.f5430a.add(new s(f5, f10, f11, f12, f13, f14));
    }

    public void d(float f5) {
        this.f5430a.add(new t(f5));
    }

    public void e(float f5, float f10) {
        this.f5430a.add(new m(f5, f10));
    }

    public void f(float f5, float f10) {
        this.f5430a.add(new n(f5, f10));
    }

    public void g(float f5) {
        this.f5430a.add(new z(f5));
    }
}
