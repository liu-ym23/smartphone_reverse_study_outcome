package n0;

import Z2.I;
import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import androidx.fragment.app.A;
import com.stepos.alphame.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: n0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0774a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile C0774a f13645d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f13646e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f13649c;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f13648b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f13647a = new HashMap();

    public C0774a(Context context) {
        this.f13649c = context.getApplicationContext();
    }

    public static C0774a c(Context context) {
        if (f13645d == null) {
            synchronized (f13646e) {
                try {
                    if (f13645d == null) {
                        f13645d = new C0774a(context);
                    }
                } finally {
                }
            }
        }
        return f13645d;
    }

    public final void a(Bundle bundle) throws ClassNotFoundException {
        HashSet hashSet;
        String string = this.f13649c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    hashSet = this.f13648b;
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
            } catch (ClassNotFoundException e4) {
                throw new A(1, e4);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object objCreate;
        if (I.x()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        HashMap map = this.f13647a;
        if (map.containsKey(cls)) {
            objCreate = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class> listDependencies = bVar.dependencies();
                if (!listDependencies.isEmpty()) {
                    for (Class cls2 : listDependencies) {
                        if (!map.containsKey(cls2)) {
                            b(cls2, hashSet);
                        }
                    }
                }
                objCreate = bVar.create(this.f13649c);
                hashSet.remove(cls);
                map.put(cls, objCreate);
            } catch (Throwable th2) {
                throw new A(1, th2);
            }
        }
        Trace.endSection();
        return objCreate;
    }
}
