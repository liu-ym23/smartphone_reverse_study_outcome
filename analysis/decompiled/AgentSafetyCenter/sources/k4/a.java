package k4;

import androidx.fragment.app.j;
import androidx.lifecycle.b1;
import androidx.lifecycle.c1;
import java.lang.invoke.VarHandle;
import yb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {
    public static c a(j jVar) {
        c1 viewModelStore = jVar.getViewModelStore();
        c cVar = new c();
        cVar.f7241a = jVar;
        cVar.f7242b = (b) new b1(viewModelStore, b.f7239c).a(v.a(b.class));
        VarHandle.storeStoreFence();
        return cVar;
    }
}
