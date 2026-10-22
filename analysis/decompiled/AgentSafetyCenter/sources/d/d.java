package d;

import android.os.Bundle;
import androidx.lifecycle.o;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements v {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ String f2923c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ b f2924f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ e.b f2925g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ h f2926h;

    @Override // androidx.lifecycle.v
    public final void e(x xVar, o oVar) {
        e.b bVar = this.f2925g;
        b bVar2 = this.f2924f;
        String str = this.f2923c;
        h hVar = this.f2926h;
        Bundle bundle = hVar.f2941g;
        HashMap map = hVar.f2939e;
        HashMap map2 = hVar.f2940f;
        if (!o.ON_START.equals(oVar)) {
            if (o.ON_STOP.equals(oVar)) {
                map.remove(str);
                return;
            } else {
                if (o.ON_DESTROY.equals(oVar)) {
                    hVar.e(str);
                    return;
                }
                return;
            }
        }
        map.put(str, new f(bVar, bVar2));
        if (map2.containsKey(str)) {
            Object obj = map2.get(str);
            map2.remove(str);
            bVar2.a(obj);
        }
        a aVar = (a) bundle.getParcelable(str);
        if (aVar != null) {
            bundle.remove(str);
            bVar2.a(bVar.c(aVar.f2922f, aVar.f2921c));
        }
    }
}
