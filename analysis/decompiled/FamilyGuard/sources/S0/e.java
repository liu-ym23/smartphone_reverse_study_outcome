package S0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import z0.i;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f5217a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f5218b = new HashMap();

    private static class a<T, R> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f5219a;

        /* renamed from: b, reason: collision with root package name */
        final Class<R> f5220b;

        /* renamed from: c, reason: collision with root package name */
        final i<T, R> f5221c;

        public a(Class<T> cls, Class<R> cls2, i<T, R> iVar) {
            this.f5219a = cls;
            this.f5220b = cls2;
            this.f5221c = iVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f5219a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f5220b);
        }
    }

    private synchronized List<a<?, ?>> c(String str) {
        List<a<?, ?>> arrayList;
        try {
            if (!this.f5217a.contains(str)) {
                this.f5217a.add(str);
            }
            arrayList = this.f5218b.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f5218b.put(str, arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized <T, R> void a(String str, i<T, R> iVar, Class<T> cls, Class<R> cls2) {
        c(str).add(new a<>(cls, cls2, iVar));
    }

    public synchronized <T, R> List<i<T, R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f5217a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f5218b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f5221c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<Class<R>> d(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f5217a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f5218b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f5220b)) {
                        arrayList.add(aVar.f5220b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(List<String> list) {
        ArrayList arrayList = new ArrayList(this.f5217a);
        this.f5217a.clear();
        this.f5217a.addAll(list);
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            String str = (String) obj;
            if (!list.contains(str)) {
                this.f5217a.add(str);
            }
        }
    }
}
