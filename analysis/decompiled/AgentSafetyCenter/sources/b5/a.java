package b5;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import androidx.fragment.app.d;
import com.stepos.agentsafetycenter.R;
import com.stepos.statsrpk.h;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f1901d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f1902e = new Object();

    /* renamed from: a, reason: collision with root package name */
    public HashMap f1903a;

    /* renamed from: b, reason: collision with root package name */
    public HashSet f1904b;

    /* renamed from: c, reason: collision with root package name */
    public Context f1905c;

    public static a c(Context context) {
        if (f1901d == null) {
            synchronized (f1902e) {
                try {
                    if (f1901d == null) {
                        a aVar = new a();
                        aVar.f1905c = context.getApplicationContext();
                        aVar.f1904b = new HashSet();
                        aVar.f1903a = new HashMap();
                        VarHandle.storeStoreFence();
                        f1901d = aVar;
                    }
                } finally {
                }
            }
        }
        return f1901d;
    }

    public final void a(Bundle bundle) throws ClassNotFoundException {
        HashSet hashSet = this.f1904b;
        String string = this.f1905c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    b((Class) it.next(), hashSet2);
                }
            } catch (ClassNotFoundException e10) {
                throw new d(e10);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object objB;
        HashMap map = this.f1903a;
        if (c5.a.a()) {
            try {
                Trace.beginSection(h.J(cls.getSimpleName()));
            } finally {
                Trace.endSection();
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        if (map.containsKey(cls)) {
            objB = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = bVar.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!map.containsKey(cls2)) {
                            b(cls2, hashSet);
                        }
                    }
                }
                objB = bVar.b(this.f1905c);
                hashSet.remove(cls);
                map.put(cls, objB);
            } catch (Throwable th) {
                throw new d(th);
            }
        }
        return objB;
    }
}
