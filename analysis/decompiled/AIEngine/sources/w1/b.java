package w1;

import android.os.Bundle;
import androidx.lifecycle.j;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.g;
import lb.n;
import mb.y;
import w1.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final x1.a f13551a;

    /* renamed from: b, reason: collision with root package name */
    public a.C0160a f13552b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void a(d dVar);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: w1.b$b, reason: collision with other inner class name */
    public interface InterfaceC0161b {
        Bundle a();
    }

    public b(x1.a aVar) {
        this.f13551a = aVar;
    }

    public final Bundle a(String key) {
        g.f(key, "key");
        x1.a aVar = this.f13551a;
        if (!aVar.f13702g) {
            throw new IllegalStateException("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
        }
        Bundle bundle = aVar.f13701f;
        if (bundle == null) {
            return null;
        }
        Bundle bundleA = bundle.containsKey(key) ? y.A(bundle, key) : null;
        bundle.remove(key);
        if (bundle.isEmpty()) {
            aVar.f13701f = null;
        }
        return bundleA;
    }

    public final InterfaceC0161b b() {
        InterfaceC0161b interfaceC0161b;
        x1.a aVar = this.f13551a;
        synchronized (aVar.f13698c) {
            Iterator it = aVar.f13699d.entrySet().iterator();
            do {
                interfaceC0161b = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                InterfaceC0161b interfaceC0161b2 = (InterfaceC0161b) entry.getValue();
                if (g.b(str, "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                    interfaceC0161b = interfaceC0161b2;
                }
            } while (interfaceC0161b == null);
        }
        return interfaceC0161b;
    }

    public final void c(String str, InterfaceC0161b provider) {
        g.f(provider, "provider");
        x1.a aVar = this.f13551a;
        synchronized (aVar.f13698c) {
            if (aVar.f13699d.containsKey(str)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            aVar.f13699d.put(str, provider);
            n nVar = n.f10413a;
        }
    }

    public final void d() {
        if (!this.f13551a.h) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        a.C0160a c0160a = this.f13552b;
        if (c0160a == null) {
            c0160a = new a.C0160a(this);
        }
        this.f13552b = c0160a;
        try {
            j.a.class.getDeclaredConstructor(null);
            a.C0160a c0160a2 = this.f13552b;
            if (c0160a2 != null) {
                c0160a2.f13550a.add(j.a.class.getName());
            }
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class " + j.a.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
        }
    }
}
