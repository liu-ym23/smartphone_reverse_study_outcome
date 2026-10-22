package t4;

import android.os.Bundle;
import androidx.lifecycle.l;
import h.i;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import t.o;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public v4.b f13167a;

    /* renamed from: b, reason: collision with root package name */
    public i f13168b;

    public final Bundle a(String str) {
        v4.b bVar = this.f13167a;
        if (!bVar.f14770g) {
            od.f.e("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
            return null;
        }
        Bundle bundle = bVar.f14769f;
        if (bundle == null) {
            return null;
        }
        Bundle bundleI = bundle.containsKey(str) ? o.i(bundle, str) : null;
        bundle.remove(str);
        if (bundle.isEmpty()) {
            bVar.f14769f = null;
        }
        return bundleI;
    }

    public final c b() {
        c cVar;
        v4.b bVar = this.f13167a;
        synchronized (bVar.f14766c) {
            Iterator it = bVar.f14767d.entrySet().iterator();
            do {
                cVar = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                c cVar2 = (c) entry.getValue();
                if (k.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                    cVar = cVar2;
                }
            } while (cVar == null);
        }
        return cVar;
    }

    public final void c(String str, c cVar) {
        cVar.getClass();
        v4.b bVar = this.f13167a;
        synchronized (bVar.f14766c) {
            if (bVar.f14767d.containsKey(str)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            bVar.f14767d.put(str, cVar);
        }
    }

    public final void d() throws NoSuchMethodException, SecurityException {
        if (!this.f13167a.f14771h) {
            od.f.e("Can not perform this action after onSaveInstanceState");
            return;
        }
        i iVar = this.f13168b;
        if (iVar == null) {
            iVar = new i(1);
            iVar.f4842b = new LinkedHashSet();
            c("androidx.savedstate.Restarter", iVar);
            VarHandle.storeStoreFence();
        }
        this.f13168b = iVar;
        try {
            l.class.getDeclaredConstructor(null);
            i iVar2 = this.f13168b;
            if (iVar2 != null) {
                ((LinkedHashSet) iVar2.f4842b).add(l.class.getName());
            }
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class " + l.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
        }
    }
}
