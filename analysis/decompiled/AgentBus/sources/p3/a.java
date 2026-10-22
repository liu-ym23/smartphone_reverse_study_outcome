package p3;

import a4.u;
import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import com.stepos.agentbus.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import nb.i;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f8397d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f8398e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f8401c;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f8400b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f8399a = new HashMap();

    public a(Context context) {
        this.f8401c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f8397d == null) {
            synchronized (f8398e) {
                try {
                    if (f8397d == null) {
                        f8397d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f8397d;
    }

    public final void a(Bundle bundle) throws ClassNotFoundException {
        HashSet hashSet;
        String string = this.f8401c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    hashSet = this.f8400b;
                    if (!zHasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e10) {
                throw new u(e10);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object objB;
        HashMap map = this.f8399a;
        if (q3.a.a()) {
            try {
                i.f(cls.getSimpleName());
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
                objB = bVar.b(this.f8401c);
                hashSet.remove(cls);
                map.put(cls, objB);
            } catch (Throwable th) {
                throw new u(th);
            }
        }
        return objB;
    }
}
