package U6;

import La.H;
import U6.e;
import Y8.t;
import Z8.A;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import a7.InterfaceC1238b;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.C4851b;
import kotlin.jvm.internal.p;
import o9.C5013a;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00022,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001f\u0010 J7\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\r\u001a\u00020\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00142\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0004\b#\u0010$J'\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001a0'2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030%H\u0002¢\u0006\u0004\b(\u0010)R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020+0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R&\u00101\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0/0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010-¨\u00063"}, d2 = {"LU6/e;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "entityClass", "LU6/e$a;", "binding", "LY8/t;", "l", "(Lw9/d;LU6/e$a;)V", "", "entityType", "f", "(Ljava/lang/String;)LU6/e$a;", Const.LBS_FAIL_BD_ENTITY, "e", "(Ljava/lang/Object;)LU6/e$a;", "collection", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Ljava/util/List;", "", Const.INTENT_KEY_UMID, "()Ljava/util/Set;", "", "k", "(Ljava/lang/Object;)J", "id", "", "o", "(Ljava/lang/Object;J)Z", "expectedOrder", "fetched", "n", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Ljava/lang/Class;", "cls", "Lkotlin/Function1;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Class;)Lp9/l;", "Ljava/util/concurrent/ConcurrentHashMap;", "LU6/e$b;", Const.INTENT_KEY_PKGNAME, "Ljava/util/concurrent/ConcurrentHashMap;", "byEntityType", "", "c", "byCollection", Const.INTENT_KEY_APIKEY, "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f6308a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final ConcurrentHashMap<String, Entry> byEntityType = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final ConcurrentHashMap<String, List<Entry>> byCollection = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H¦@¢\u0006\u0004\b\b\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H¦@¢\u0006\u0004\b\t\u0010\u0006J$\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH¦@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"LU6/e$a;", "", ExifInterface.GPS_DIRECTION_TRUE, Const.LBS_FAIL_BD_ENTITY, "", "c", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "LY8/t;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "", "ids", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a<T> {
        Object a(T t10, InterfaceC4014c<? super t> interfaceC4014c);

        Object b(List<Long> list, InterfaceC4014c<? super List<? extends T>> interfaceC4014c);

        Object c(T t10, InterfaceC4014c<? super Long> interfaceC4014c);

        Object d(T t10, InterfaceC4014c<? super t> interfaceC4014c);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\u0018\u0010\rR\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u001bR#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0019\u0010\u001e¨\u0006\u001f"}, d2 = {"LU6/e$b;", "", "", "entityType", "collection", "LU6/e$a;", "binding", "Lkotlin/Function1;", "", "idGetter", "<init>", "(Ljava/lang/String;Ljava/lang/String;LU6/e$a;Lp9/l;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "getCollection", "c", "LU6/e$a;", "()LU6/e$a;", Const.INTENT_KEY_UMID, "Lp9/l;", "()Lp9/l;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: U6.e$b, reason: from toString */
    public static final /* data */ class Entry {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String entityType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String collection;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final a<Object> binding;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final InterfaceC5074l<Object, Long> idGetter;

        public Entry(String entityType, String collection, a<Object> aVar, InterfaceC5074l<Object, Long> idGetter) {
            p.i(entityType, "entityType");
            p.i(collection, "collection");
            p.i(idGetter, "idGetter");
            this.entityType = entityType;
            this.collection = collection;
            this.binding = aVar;
            this.idGetter = idGetter;
        }

        public final a<Object> a() {
            return this.binding;
        }

        /* renamed from: b, reason: from getter */
        public final String getEntityType() {
            return this.entityType;
        }

        public final InterfaceC5074l<Object, Long> c() {
            return this.idGetter;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return p.d(this.entityType, entry.entityType) && p.d(this.collection, entry.collection) && p.d(this.binding, entry.binding) && p.d(this.idGetter, entry.idGetter);
        }

        public int hashCode() {
            int iHashCode = ((this.entityType.hashCode() * 31) + this.collection.hashCode()) * 31;
            a<Object> aVar = this.binding;
            return ((iHashCode + (aVar == null ? 0 : aVar.hashCode())) * 31) + this.idGetter.hashCode();
        }

        public String toString() {
            return "Entry(entityType=" + this.entityType + ", collection=" + this.collection + ", binding=" + this.binding + ", idGetter=" + this.idGetter + ")";
        }
    }

    public static final long h(Field field, Object obj) throws IllegalAccessException, IllegalArgumentException {
        Object obj2;
        p.i(obj, "obj");
        try {
            obj2 = field.get(obj);
        } catch (Exception unused) {
        }
        if (obj2 instanceof Long) {
            return ((Number) obj2).longValue();
        }
        if (obj2 instanceof Integer) {
            return ((Number) obj2).intValue();
        }
        return 0L;
    }

    public static final long i(Object it) {
        p.i(it, "it");
        return 0L;
    }

    public static final boolean m(Entry entry, Entry it) {
        p.i(it, "it");
        return p.d(it.getEntityType(), entry.getEntityType());
    }

    public final Set<String> d() {
        Set<String> setKeySet = byCollection.keySet();
        p.h(setKeySet, "<get-keys>(...)");
        return F.r1(setKeySet);
    }

    public final a<Object> e(Object entity) {
        p.i(entity, "entity");
        String simpleName = entity.getClass().getSimpleName();
        p.h(simpleName, "getSimpleName(...)");
        return f(simpleName);
    }

    public final a<Object> f(String entityType) {
        p.i(entityType, "entityType");
        Entry entry = byEntityType.get(entityType);
        if (entry != null) {
            return entry.a();
        }
        return null;
    }

    public final InterfaceC5074l<Object, Long> g(Class<?> cls) throws SecurityException {
        while (cls != null && !p.d(cls, Object.class)) {
            Iterator itA = C4851b.a(cls.getDeclaredFields());
            while (itA.hasNext()) {
                final Field field = (Field) itA.next();
                if (p.d(field.getName(), "id")) {
                    Class<?> type = field.getType();
                    if (p.d(type, Long.TYPE) || p.d(type, Long.class) || p.d(type, Integer.TYPE) || p.d(type, Integer.class)) {
                        field.setAccessible(true);
                        return new InterfaceC5074l() { // from class: U6.c
                            @Override // p9.InterfaceC5074l
                            public final Object invoke(Object obj) {
                                return Long.valueOf(e.h(field, obj));
                            }
                        };
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return new InterfaceC5074l() { // from class: U6.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Long.valueOf(e.i(obj));
            }
        };
    }

    public final List<String> j(String collection) {
        ArrayList arrayList;
        p.i(collection, "collection");
        List<Entry> list = byCollection.get(collection);
        if (list != null) {
            List<Entry> list2 = list;
            arrayList = new ArrayList(C1174w.x(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((Entry) it.next()).getEntityType());
            }
        } else {
            arrayList = null;
        }
        return arrayList == null ? C1173v.m() : arrayList;
    }

    public final long k(Object entity) throws SecurityException {
        InterfaceC5074l<Object, Long> interfaceC5074lG;
        p.i(entity, "entity");
        Entry entry = byEntityType.get(entity.getClass().getSimpleName());
        if (entry == null || (interfaceC5074lG = entry.c()) == null) {
            interfaceC5074lG = g(entity.getClass());
        }
        return interfaceC5074lG.invoke(entity).longValue();
    }

    public final <T> void l(InterfaceC5745d<T> entityClass, a<T> binding) throws SecurityException {
        List<Entry> listPutIfAbsent;
        p.i(entityClass, "entityClass");
        p.i(binding, "binding");
        Class<?> clsB = C5013a.b(entityClass);
        InterfaceC1238b interfaceC1238b = (InterfaceC1238b) clsB.getAnnotation(InterfaceC1238b.class);
        String strCollection = interfaceC1238b != null ? interfaceC1238b.collection() : null;
        if (strCollection == null) {
            strCollection = "";
        }
        if (H.x0(strCollection)) {
            Log.w("EntityRegistry", "register: " + clsB.getSimpleName() + " 没有类级 @Vectorized(collection=) 注解；向量路径会跳过，FTS 仍可工作");
        }
        InterfaceC5074l<Object, Long> interfaceC5074lG = g(clsB);
        String simpleName = clsB.getSimpleName();
        p.h(simpleName, "getSimpleName(...)");
        final Entry entry = new Entry(simpleName, strCollection, binding, interfaceC5074lG);
        byEntityType.put(entry.getEntityType(), entry);
        if (!H.x0(strCollection)) {
            ConcurrentHashMap<String, List<Entry>> concurrentHashMap = byCollection;
            List<Entry> arrayList = concurrentHashMap.get(strCollection);
            if (arrayList == null && (listPutIfAbsent = concurrentHashMap.putIfAbsent(strCollection, (arrayList = new ArrayList<>()))) != null) {
                arrayList = listPutIfAbsent;
            }
            List<Entry> list = arrayList;
            p.f(list);
            synchronized (list) {
                A.L(list, new InterfaceC5074l() { // from class: U6.b
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(e.m(entry, (e.Entry) obj));
                    }
                });
                list.add(entry);
                t tVar = t.f7040a;
            }
        }
        Log.d("EntityRegistry", "register: " + entry.getEntityType() + " → collection='" + strCollection + "'");
    }

    public final List<Object> n(String entityType, List<Long> expectedOrder, List<? extends Object> fetched) {
        InterfaceC5074l<Object, Long> interfaceC5074lC;
        p.i(entityType, "entityType");
        p.i(expectedOrder, "expectedOrder");
        p.i(fetched, "fetched");
        Entry entry = byEntityType.get(entityType);
        if (entry == null || (interfaceC5074lC = entry.c()) == null) {
            return fetched;
        }
        HashMap map = new HashMap(fetched.size());
        for (Object obj : fetched) {
            map.put(interfaceC5074lC.invoke(obj), obj);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = expectedOrder.iterator();
        while (it.hasNext()) {
            Object obj2 = map.get(Long.valueOf(((Number) it.next()).longValue()));
            if (obj2 != null) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    public final boolean o(Object entity, long id) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        p.i(entity, "entity");
        for (Class<?> superclass = entity.getClass(); superclass != null && !p.d(superclass, Object.class); superclass = superclass.getSuperclass()) {
            Iterator itA = C4851b.a(superclass.getDeclaredFields());
            while (itA.hasNext()) {
                Field field = (Field) itA.next();
                if (p.d(field.getName(), "id")) {
                    Class<?> type = field.getType();
                    field.setAccessible(true);
                    try {
                        if (!p.d(type, Long.TYPE) && !p.d(type, Long.class)) {
                            if (!p.d(type, Integer.TYPE) && !p.d(type, Integer.class)) {
                            }
                            field.set(entity, Integer.valueOf((int) id));
                            return true;
                        }
                        field.set(entity, Long.valueOf(id));
                        return true;
                    } catch (Exception e10) {
                        Log.w("EntityRegistry", "trySetId failed on " + entity.getClass().getSimpleName() + ".id", e10);
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
