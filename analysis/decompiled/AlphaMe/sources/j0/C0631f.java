package j0;

import android.os.Bundle;
import androidx.lifecycle.C0322t;
import ch.qos.logback.core.joran.action.Action;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: j0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0631f {

    /* renamed from: b, reason: collision with root package name */
    public boolean f13121b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f13122c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13123d;

    /* renamed from: e, reason: collision with root package name */
    public C0626a f13124e;

    /* renamed from: a, reason: collision with root package name */
    public final m.g f13120a = new m.g();

    /* renamed from: f, reason: collision with root package name */
    public boolean f13125f = true;

    public final Bundle a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.f13123d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.f13122c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(key);
        Bundle bundle3 = this.f13122c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f13122c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f13122c = null;
        }
        return bundle2;
    }

    public final InterfaceC0630e b() {
        String str;
        InterfaceC0630e interfaceC0630e;
        Intrinsics.checkNotNullParameter("androidx.lifecycle.internal.SavedStateHandlesProvider", Action.KEY_ATTRIBUTE);
        Iterator it = this.f13120a.iterator();
        do {
            m.e eVar = (m.e) it;
            if (!eVar.hasNext()) {
                return null;
            }
            Map.Entry components = (Map.Entry) eVar.next();
            Intrinsics.checkNotNullExpressionValue(components, "components");
            str = (String) components.getKey();
            interfaceC0630e = (InterfaceC0630e) components.getValue();
        } while (!Intrinsics.areEqual(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return interfaceC0630e;
    }

    public final void c(String key, InterfaceC0630e provider) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(provider, "provider");
        m.g gVar = this.f13120a;
        m.c cVarA = gVar.a(key);
        if (cVarA != null) {
            obj = cVarA.f13510b;
        } else {
            m.c cVar = new m.c(key, provider);
            gVar.f13521d++;
            m.c cVar2 = gVar.f13519b;
            if (cVar2 == null) {
                gVar.f13518a = cVar;
                gVar.f13519b = cVar;
            } else {
                cVar2.f13511c = cVar;
                cVar.f13512d = cVar2;
                gVar.f13519b = cVar;
            }
            obj = null;
        }
        if (((InterfaceC0630e) obj) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void d() throws NoSuchMethodException, SecurityException {
        Intrinsics.checkNotNullParameter(C0322t.class, "clazz");
        if (!this.f13125f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        C0626a c0626a = this.f13124e;
        if (c0626a == null) {
            c0626a = new C0626a(this);
        }
        this.f13124e = c0626a;
        try {
            C0322t.class.getDeclaredConstructor(new Class[0]);
            C0626a c0626a2 = this.f13124e;
            if (c0626a2 != null) {
                String className = C0322t.class.getName();
                Intrinsics.checkNotNullExpressionValue(className, "clazz.name");
                Intrinsics.checkNotNullParameter(className, "className");
                c0626a2.f13117a.add(className);
            }
        } catch (NoSuchMethodException e4) {
            throw new IllegalArgumentException("Class " + C0322t.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e4);
        }
    }
}
