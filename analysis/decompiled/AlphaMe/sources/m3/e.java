package m3;

import android.os.Looper;
import androidx.appcompat.widget.RunnableC0209k;
import androidx.fragment.app.A;
import h3.C0611u;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.android.AndroidComponentsImpl;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: q, reason: collision with root package name */
    public static volatile e f13595q;

    /* renamed from: r, reason: collision with root package name */
    public static final f f13596r;

    /* renamed from: s, reason: collision with root package name */
    public static final HashMap f13597s;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f13598a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f13599b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f13600c;

    /* renamed from: d, reason: collision with root package name */
    public final b f13601d = new b();

    /* renamed from: e, reason: collision with root package name */
    public final C0611u f13602e;

    /* renamed from: f, reason: collision with root package name */
    public final g f13603f;

    /* renamed from: g, reason: collision with root package name */
    public final RunnableC0772a f13604g;

    /* renamed from: h, reason: collision with root package name */
    public final RunnableC0209k f13605h;

    /* renamed from: i, reason: collision with root package name */
    public final n f13606i;

    /* renamed from: j, reason: collision with root package name */
    public final ExecutorService f13607j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f13608k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f13609l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f13610m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f13611n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f13612o;

    /* renamed from: p, reason: collision with root package name */
    public final h f13613p;

    static {
        f fVar = new f();
        fVar.f13615a = f.f13614b;
        f13596r = fVar;
        f13597s = new HashMap();
    }

    public e() {
        f fVar = f13596r;
        fVar.getClass();
        AndroidComponentsImpl androidComponentsImpl = AndroidComponentsImpl.f13811c;
        this.f13613p = androidComponentsImpl != null ? androidComponentsImpl.f13812a : new C0611u(16);
        this.f13598a = new HashMap();
        this.f13599b = new HashMap();
        this.f13600c = new ConcurrentHashMap();
        C0611u c0611u = androidComponentsImpl != null ? androidComponentsImpl.f13813b : null;
        this.f13602e = c0611u;
        this.f13603f = c0611u != null ? new g(this, Looper.getMainLooper()) : null;
        this.f13604g = new RunnableC0772a(this);
        this.f13605h = new RunnableC0209k(this);
        this.f13606i = new n();
        this.f13608k = true;
        this.f13609l = true;
        this.f13610m = true;
        this.f13611n = true;
        this.f13612o = true;
        this.f13607j = fVar.f13615a;
    }

    public static void a(ArrayList arrayList, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!arrayList.contains(cls)) {
                arrayList.add(cls);
                a(arrayList, cls.getInterfaces());
            }
        }
    }

    public static e b() {
        e eVar = f13595q;
        if (eVar == null) {
            synchronized (e.class) {
                try {
                    eVar = f13595q;
                    if (eVar == null) {
                        eVar = new e();
                        f13595q = eVar;
                    }
                } finally {
                }
            }
        }
        return eVar;
    }

    public final void c(Object obj, o oVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            oVar.f13644b.f13629a.invoke(oVar.f13643a, obj);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException("Unexpected exception", e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            boolean z4 = obj instanceof k;
            boolean z5 = this.f13608k;
            h hVar = this.f13613p;
            if (!z4) {
                if (z5) {
                    hVar.d(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + oVar.f13643a.getClass(), cause);
                }
                if (this.f13610m) {
                    e(new k(cause, obj, oVar.f13643a));
                    return;
                }
                return;
            }
            if (z5) {
                Level level = Level.SEVERE;
                hVar.d(level, "SubscriberExceptionEvent subscriber " + oVar.f13643a.getClass() + " threw an exception", cause);
                k kVar = (k) obj;
                hVar.d(level, "Initial event " + kVar.f13627b + " caused exception in " + kVar.f13628c, kVar.f13626a);
            }
        }
    }

    public final void d(j jVar) {
        Object obj = jVar.f13623a;
        o oVar = jVar.f13624b;
        jVar.f13623a = null;
        jVar.f13624b = null;
        jVar.f13625c = null;
        ArrayList arrayList = j.f13622d;
        synchronized (arrayList) {
            if (arrayList.size() < 10000) {
                arrayList.add(jVar);
            }
        }
        oVar.getClass();
        c(obj, oVar);
    }

    public final void e(Object obj) {
        d dVar = (d) this.f13601d.get();
        ArrayList arrayList = dVar.f13591a;
        arrayList.add(obj);
        if (dVar.f13592b) {
            return;
        }
        dVar.f13593c = this.f13602e == null || Looper.getMainLooper() == Looper.myLooper();
        dVar.f13592b = true;
        while (!arrayList.isEmpty()) {
            try {
                f(arrayList.remove(0), dVar);
            } finally {
                dVar.f13592b = false;
                dVar.f13593c = false;
            }
        }
    }

    public final void f(Object obj, d dVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean zG;
        List list;
        Class<?> cls = obj.getClass();
        if (this.f13612o) {
            HashMap map = f13597s;
            synchronized (map) {
                try {
                    List list2 = (List) map.get(cls);
                    list = list2;
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                            arrayList.add(superclass);
                            a(arrayList, superclass.getInterfaces());
                        }
                        f13597s.put(cls, arrayList);
                        list = arrayList;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int size = list.size();
            zG = false;
            for (int i4 = 0; i4 < size; i4++) {
                zG |= g(obj, dVar, (Class) list.get(i4));
            }
        } else {
            zG = g(obj, dVar, cls);
        }
        if (zG) {
            return;
        }
        if (this.f13609l) {
            this.f13613p.a(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.f13611n || cls == i.class || cls == k.class) {
            return;
        }
        e(new i(this, obj));
    }

    public final boolean g(Object obj, d dVar, Class cls) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.f13598a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            dVar.f13594d = obj;
            h(oVar, obj, dVar.f13593c);
        }
        return true;
    }

    public final void h(o oVar, Object obj, boolean z4) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i4 = c.f13590a[oVar.f13644b.f13630b.ordinal()];
        if (i4 == 1) {
            c(obj, oVar);
            return;
        }
        g gVar = this.f13603f;
        if (i4 == 2) {
            if (z4) {
                c(obj, oVar);
                return;
            } else {
                gVar.a(obj, oVar);
                return;
            }
        }
        if (i4 == 3) {
            if (gVar != null) {
                gVar.a(obj, oVar);
                return;
            } else {
                c(obj, oVar);
                return;
            }
        }
        if (i4 != 4) {
            if (i4 != 5) {
                throw new IllegalStateException("Unknown thread mode: " + oVar.f13644b.f13630b);
            }
            RunnableC0209k runnableC0209k = this.f13605h;
            runnableC0209k.getClass();
            ((i) runnableC0209k.f3116b).a(j.a(obj, oVar));
            ((e) runnableC0209k.f3117c).f13607j.execute(runnableC0209k);
            return;
        }
        if (!z4) {
            c(obj, oVar);
            return;
        }
        RunnableC0772a runnableC0772a = this.f13604g;
        runnableC0772a.getClass();
        j jVarA = j.a(obj, oVar);
        synchronized (runnableC0772a) {
            try {
                runnableC0772a.f13587a.a(jVarA);
                if (!runnableC0772a.f13589c) {
                    runnableC0772a.f13589c = true;
                    runnableC0772a.f13588b.f13607j.execute(runnableC0772a);
                }
            } finally {
            }
        }
    }

    public final void i(Object obj, l lVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object value;
        Class cls = lVar.f13631c;
        o oVar = new o(obj, lVar);
        HashMap map = this.f13598a;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) map.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            map.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(oVar)) {
            throw new A("Subscriber " + obj.getClass() + " already registered to event " + cls, 10);
        }
        int size = copyOnWriteArrayList.size();
        for (int i4 = 0; i4 <= size; i4++) {
            if (i4 != size) {
                if (lVar.f13632d <= ((o) copyOnWriteArrayList.get(i4)).f13644b.f13632d) {
                }
            }
            copyOnWriteArrayList.add(i4, oVar);
            break;
        }
        HashMap map2 = this.f13599b;
        List arrayList = (List) map2.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map2.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (lVar.f13633e) {
            ConcurrentHashMap concurrentHashMap = this.f13600c;
            C0611u c0611u = this.f13602e;
            if (!this.f13612o) {
                Object obj2 = concurrentHashMap.get(cls);
                if (obj2 != null) {
                    h(oVar, obj2, c0611u == null || Looper.getMainLooper() == Looper.myLooper());
                    return;
                }
                return;
            }
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey()) && (value = entry.getValue()) != null) {
                    h(oVar, value, c0611u == null || Looper.getMainLooper() == Looper.myLooper());
                }
            }
        }
    }

    public final String toString() {
        return "EventBus[indexCount=0, eventInheritance=" + this.f13612o + "]";
    }
}
