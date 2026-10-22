package N4;

import L4.AgentSkin;
import L4.a;
import L4.e;
import L4.r;
import android.content.Context;
import android.view.InterfaceC1387e;
import android.view.LifecycleOwner;
import b.q;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u000e\u001a\u00020\r*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001aE\u0010\u0011\u001a\u00020\r*\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aO\u0010\u0015\u001a\u00020\u0014*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/lifecycle/LifecycleOwner;", "Landroid/content/Context;", "context", "", "id", "LL4/h;", "initialSkin", "LL4/e;", "initialNightMode", "LL4/a;", "initialBackgroundRatio", "LL4/r;", "priorityPolicy", "LL4/b;", Const.INTENT_KEY_APIKEY, "(Landroidx/lifecycle/LifecycleOwner;Landroid/content/Context;Ljava/lang/String;LL4/h;LL4/e;LL4/a;LL4/r;)LL4/b;", "Lb/q;", Const.INTENT_KEY_PKGNAME, "(Lb/q;Ljava/lang/String;LL4/h;LL4/e;LL4/a;LL4/r;)LL4/b;", "assetsPackage", "LM4/c;", "e", "(Landroidx/lifecycle/LifecycleOwner;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;LL4/h;LL4/e;LL4/a;LL4/r;)LM4/c;", "agentsprite_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"N4/a$a", "Landroidx/lifecycle/e;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "LY8/t;", "onDestroy", "(Landroidx/lifecycle/LifecycleOwner;)V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: N4.a$a, reason: collision with other inner class name */
    public static final class C0086a implements InterfaceC1387e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ M4.c f4793a;

        public C0086a(M4.c cVar) {
            this.f4793a = cVar;
        }

        @Override // android.view.InterfaceC1387e
        public void onDestroy(LifecycleOwner owner) {
            p.i(owner, "owner");
            this.f4793a.s();
        }
    }

    public static final L4.b a(LifecycleOwner lifecycleOwner, Context context, String id, AgentSkin initialSkin, L4.e initialNightMode, L4.a initialBackgroundRatio, r priorityPolicy) {
        p.i(lifecycleOwner, "<this>");
        p.i(id, "id");
        p.i(initialSkin, "initialSkin");
        p.i(initialNightMode, "initialNightMode");
        p.i(initialBackgroundRatio, "initialBackgroundRatio");
        p.i(priorityPolicy, "priorityPolicy");
        return e(lifecycleOwner, context, id, "com.stepos.agentpack", initialSkin, initialNightMode, initialBackgroundRatio, priorityPolicy);
    }

    public static final L4.b b(q qVar, String id, AgentSkin initialSkin, L4.e initialNightMode, L4.a initialBackgroundRatio, r priorityPolicy) {
        p.i(qVar, "<this>");
        p.i(id, "id");
        p.i(initialSkin, "initialSkin");
        p.i(initialNightMode, "initialNightMode");
        p.i(initialBackgroundRatio, "initialBackgroundRatio");
        p.i(priorityPolicy, "priorityPolicy");
        return a(qVar, qVar, id, initialSkin, initialNightMode, initialBackgroundRatio, priorityPolicy);
    }

    public static /* synthetic */ L4.b c(LifecycleOwner lifecycleOwner, Context context, String str, AgentSkin agentSkin, L4.e eVar, L4.a aVar, r rVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            context = null;
        }
        if ((i10 & 2) != 0) {
            str = "default";
        }
        if ((i10 & 4) != 0) {
            agentSkin = AgentSkin.a.f4307b;
        }
        if ((i10 & 8) != 0) {
            eVar = e.b.f4304a;
        }
        if ((i10 & 16) != 0) {
            aVar = a.C0070a.f4301c;
        }
        if ((i10 & 32) != 0) {
            rVar = new L4.q();
        }
        L4.a aVar2 = aVar;
        r rVar2 = rVar;
        return a(lifecycleOwner, context, str, agentSkin, eVar, aVar2, rVar2);
    }

    public static /* synthetic */ L4.b d(q qVar, String str, AgentSkin agentSkin, L4.e eVar, L4.a aVar, r rVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "default";
        }
        if ((i10 & 2) != 0) {
            agentSkin = AgentSkin.a.f4307b;
        }
        if ((i10 & 4) != 0) {
            eVar = e.b.f4304a;
        }
        if ((i10 & 8) != 0) {
            aVar = a.C0070a.f4301c;
        }
        if ((i10 & 16) != 0) {
            rVar = new L4.q();
        }
        r rVar2 = rVar;
        L4.e eVar2 = eVar;
        return b(qVar, str, agentSkin, eVar2, aVar, rVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final M4.c e(LifecycleOwner lifecycleOwner, Context context, String str, String str2, AgentSkin agentSkin, L4.e eVar, L4.a aVar, r rVar) {
        if (context == null) {
            context = lifecycleOwner instanceof Context ? (Context) lifecycleOwner : null;
            if (context == null) {
                throw new IllegalStateException("obtainAgent(): no Context found. This LifecycleOwner is not a Context — pass `context = requireContext()` (or similar).");
            }
        }
        M4.j.f4631a.b();
        Context applicationContext = context.getApplicationContext();
        p.h(applicationContext, "getApplicationContext(...)");
        M4.c cVar = new M4.c(str, applicationContext, str2, agentSkin, eVar, aVar, rVar);
        lifecycleOwner.getLifecycle().a(new C0086a(cVar));
        return cVar;
    }
}
