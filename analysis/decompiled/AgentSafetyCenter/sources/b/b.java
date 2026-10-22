package b;

import com.stepos.agentsafetycenter.auth.LaunchAuthActivity;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import k0.c1;
import o7.o;
import o7.u;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements d.b, cb.g, o {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1684c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1685f;

    public /* synthetic */ b(int i) {
        this.f1684c = i;
    }

    @Override // d.b
    public void a(Object obj) {
        int i = this.f1684c;
        Object obj2 = this.f1685f;
        switch (i) {
            case 0:
                ((xb.l) ((c1) obj2).getValue()).invoke(obj);
                break;
            default:
                LaunchAuthActivity launchAuthActivity = (LaunchAuthActivity) obj2;
                if (((d.a) obj).f2921c != -1) {
                    launchAuthActivity.e();
                    break;
                } else {
                    launchAuthActivity.f();
                    break;
                }
        }
    }

    @Override // o7.o
    public Object b() {
        int i = this.f1684c;
        Object obj = this.f1685f;
        switch (i) {
            case 4:
                Constructor constructor = (Constructor) obj;
                try {
                    return constructor.newInstance(null);
                } catch (IllegalAccessException e10) {
                    ac.a aVar = r7.c.f10473a;
                    od.f.g("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e10);
                    return null;
                } catch (InstantiationException e11) {
                    throw new RuntimeException("Failed to invoke constructor '" + r7.c.b(constructor) + "' with no args", e11);
                } catch (InvocationTargetException e12) {
                    od.f.g("Failed to invoke constructor '" + r7.c.b(constructor) + "' with no args", e12.getCause());
                    return null;
                }
            default:
                Class cls = (Class) obj;
                try {
                    return u.f9288a.a(cls);
                } catch (Exception e13) {
                    throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e13);
                }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Iterable, java.lang.Object] */
    public void c() {
        p pVar = (p) this.f1685f;
        synchronized (u0.m.f13676c) {
            ?? r12 = u0.m.f13681h;
            r12.getClass();
            ArrayList arrayList = new ArrayList(kb.m.m0(r12, 10));
            boolean z10 = false;
            for (Object obj : r12) {
                boolean z11 = true;
                if (!z10 && yb.k.a(obj, pVar)) {
                    z10 = true;
                    z11 = false;
                }
                if (z11) {
                    arrayList.add(obj);
                }
            }
            u0.m.f13681h = arrayList;
        }
    }
}
