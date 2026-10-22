package androidx.activity.result;

import android.os.Bundle;
import androidx.fragment.app.P;
import androidx.lifecycle.E;
import androidx.lifecycle.EnumC0326x;
import androidx.lifecycle.G;
import d.AbstractC0528b;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class c implements E {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2416a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f2417b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0528b f2418c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f2419d;

    public c(g gVar, String str, a aVar, AbstractC0528b abstractC0528b) {
        this.f2419d = gVar;
        this.f2416a = str;
        this.f2417b = aVar;
        this.f2418c = abstractC0528b;
    }

    @Override // androidx.lifecycle.E
    public final void a(G g4, EnumC0326x enumC0326x) {
        boolean zEquals = EnumC0326x.ON_START.equals(enumC0326x);
        String str = this.f2416a;
        g gVar = this.f2419d;
        if (!zEquals) {
            if (EnumC0326x.ON_STOP.equals(enumC0326x)) {
                gVar.f2432e.remove(str);
                return;
            } else {
                if (EnumC0326x.ON_DESTROY.equals(enumC0326x)) {
                    gVar.f(str);
                    return;
                }
                return;
            }
        }
        HashMap map = gVar.f2432e;
        AbstractC0528b abstractC0528b = this.f2418c;
        a aVar = this.f2417b;
        map.put(str, new e(abstractC0528b, aVar));
        HashMap map2 = gVar.f2433f;
        if (map2.containsKey(str)) {
            Object obj = map2.get(str);
            map2.remove(str);
            ((P) aVar).b(obj);
        }
        Bundle bundle = gVar.f2434g;
        ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str);
        if (activityResult != null) {
            bundle.remove(str);
            ((P) aVar).b(abstractC0528b.c(activityResult.f2410a, activityResult.f2411b));
        }
    }
}
