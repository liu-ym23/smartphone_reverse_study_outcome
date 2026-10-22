package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.util.Log;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import y1.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class RoomDatabase {

    /* renamed from: a, reason: collision with root package name */
    public volatile FrameworkSQLiteDatabase f2491a;

    /* renamed from: b, reason: collision with root package name */
    public Executor f2492b;

    /* renamed from: c, reason: collision with root package name */
    public y1.c f2493c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2495e;

    /* renamed from: f, reason: collision with root package name */
    public List<? extends b> f2496f;

    /* renamed from: j, reason: collision with root package name */
    public final Map<String, Object> f2499j;

    /* renamed from: k, reason: collision with root package name */
    public final LinkedHashMap f2500k;

    /* renamed from: d, reason: collision with root package name */
    public final f f2494d = e();

    /* renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f2497g = new LinkedHashMap();
    public final ReentrantReadWriteLock h = new ReentrantReadWriteLock();

    /* renamed from: i, reason: collision with root package name */
    public final ThreadLocal<Integer> f2498i = new ThreadLocal<>();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class JournalMode {

        /* renamed from: a, reason: collision with root package name */
        public static final JournalMode f2501a;

        /* renamed from: b, reason: collision with root package name */
        public static final JournalMode f2502b;

        /* renamed from: c, reason: collision with root package name */
        public static final JournalMode f2503c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ JournalMode[] f2504d;

        static {
            JournalMode journalMode = new JournalMode("AUTOMATIC", 0);
            f2501a = journalMode;
            JournalMode journalMode2 = new JournalMode("TRUNCATE", 1);
            f2502b = journalMode2;
            JournalMode journalMode3 = new JournalMode("WRITE_AHEAD_LOGGING", 2);
            f2503c = journalMode3;
            f2504d = new JournalMode[]{journalMode, journalMode2, journalMode3};
        }

        public JournalMode() {
            throw null;
        }

        public static JournalMode valueOf(String str) {
            return (JournalMode) Enum.valueOf(JournalMode.class, str);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) f2504d.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a<T extends RoomDatabase> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f2505a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<T> f2506b;

        /* renamed from: c, reason: collision with root package name */
        public final String f2507c;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f2508d;

        /* renamed from: e, reason: collision with root package name */
        public final ArrayList f2509e;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList f2510f;

        /* renamed from: g, reason: collision with root package name */
        public Executor f2511g;
        public Executor h;

        /* renamed from: i, reason: collision with root package name */
        public com.google.android.material.button.a f2512i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f2513j;

        /* renamed from: k, reason: collision with root package name */
        public final JournalMode f2514k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f2515l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f2516m;

        /* renamed from: n, reason: collision with root package name */
        public final long f2517n;

        /* renamed from: o, reason: collision with root package name */
        public final c f2518o;

        /* renamed from: p, reason: collision with root package name */
        public final LinkedHashSet f2519p;

        /* renamed from: q, reason: collision with root package name */
        public HashSet f2520q;

        public a(Context context, Class<T> cls, String str) {
            kotlin.jvm.internal.g.f(context, "context");
            this.f2505a = context;
            this.f2506b = cls;
            this.f2507c = str;
            this.f2508d = new ArrayList();
            this.f2509e = new ArrayList();
            this.f2510f = new ArrayList();
            this.f2514k = JournalMode.f2501a;
            this.f2515l = true;
            this.f2517n = -1L;
            this.f2518o = new c();
            this.f2519p = new LinkedHashSet();
        }

        public final void a(u1.a... migrations) {
            kotlin.jvm.internal.g.f(migrations, "migrations");
            if (this.f2520q == null) {
                this.f2520q = new HashSet();
            }
            for (u1.a aVar : migrations) {
                HashSet hashSet = this.f2520q;
                kotlin.jvm.internal.g.c(hashSet);
                hashSet.add(Integer.valueOf(aVar.f13141a));
                HashSet hashSet2 = this.f2520q;
                kotlin.jvm.internal.g.c(hashSet2);
                hashSet2.add(Integer.valueOf(aVar.f13142b));
            }
            this.f2518o.a((u1.a[]) Arrays.copyOf(migrations, migrations.length));
        }

        public final T b() throws ClassNotFoundException {
            Executor executor = this.f2511g;
            if (executor == null && this.h == null) {
                m.a aVar = m.b.f10432d;
                this.h = aVar;
                this.f2511g = aVar;
            } else if (executor != null && this.h == null) {
                this.h = executor;
            } else if (executor == null) {
                this.f2511g = this.h;
            }
            HashSet hashSet = this.f2520q;
            LinkedHashSet linkedHashSet = this.f2519p;
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    if (linkedHashSet.contains(Integer.valueOf(iIntValue))) {
                        throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(iIntValue, "Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ").toString());
                    }
                }
            }
            c.InterfaceC0177c cVar = this.f2512i;
            if (cVar == null) {
                cVar = new z1.c();
            }
            c.InterfaceC0177c interfaceC0177c = cVar;
            if (this.f2517n > 0) {
                if (this.f2507c != null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
            }
            boolean z = this.f2513j;
            JournalMode journalMode = this.f2514k;
            journalMode.getClass();
            Context context = this.f2505a;
            kotlin.jvm.internal.g.f(context, "context");
            JournalMode journalMode2 = JournalMode.f2501a;
            JournalMode journalMode3 = JournalMode.f2503c;
            if (journalMode == journalMode2) {
                Object systemService = context.getSystemService("activity");
                ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
                journalMode = (activityManager == null || activityManager.isLowRamDevice()) ? JournalMode.f2502b : journalMode3;
            }
            Executor executor2 = this.f2511g;
            if (executor2 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Executor executor3 = this.h;
            if (executor3 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            boolean z3 = this.f2515l;
            boolean z10 = this.f2516m;
            String str = this.f2507c;
            c cVar2 = this.f2518o;
            ArrayList arrayList = this.f2508d;
            ArrayList arrayList2 = this.f2509e;
            ArrayList arrayList3 = this.f2510f;
            androidx.room.c cVar3 = new androidx.room.c(context, str, interfaceC0177c, cVar2, arrayList, z, journalMode, executor2, executor3, z3, z10, linkedHashSet, arrayList2, arrayList3);
            Class<T> cls = this.f2506b;
            Package r42 = cls.getPackage();
            kotlin.jvm.internal.g.c(r42);
            String fullPackage = r42.getName();
            String canonicalName = cls.getCanonicalName();
            kotlin.jvm.internal.g.c(canonicalName);
            kotlin.jvm.internal.g.e(fullPackage, "fullPackage");
            if (fullPackage.length() != 0) {
                canonicalName = canonicalName.substring(fullPackage.length() + 1);
                kotlin.jvm.internal.g.e(canonicalName, "this as java.lang.String).substring(startIndex)");
            }
            String strConcat = gc.o.h0(canonicalName, '.', '_').concat("_Impl");
            try {
                Class<?> cls2 = Class.forName(fullPackage.length() == 0 ? strConcat : fullPackage + '.' + strConcat, true, cls.getClassLoader());
                kotlin.jvm.internal.g.d(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
                T t8 = (T) cls2.getDeclaredConstructor(null).newInstance(null);
                f fVar = t8.f2494d;
                LinkedHashMap linkedHashMap = t8.f2497g;
                t8.f2493c = t8.f(cVar3);
                Set<Class<Object>> setI = t8.i();
                BitSet bitSet = new BitSet();
                Iterator<Class<Object>> it2 = setI.iterator();
                while (true) {
                    int i10 = -1;
                    if (!it2.hasNext()) {
                        int size = arrayList3.size() - 1;
                        if (size >= 0) {
                            while (true) {
                                int i11 = size - 1;
                                if (!bitSet.get(size)) {
                                    throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                                }
                                if (i11 < 0) {
                                    break;
                                }
                                size = i11;
                            }
                        }
                        Iterator<u1.a> it3 = t8.g(linkedHashMap).iterator();
                        while (true) {
                            boolean zContainsKey = false;
                            if (!it3.hasNext()) {
                                break;
                            }
                            u1.a next = it3.next();
                            int i12 = next.f13141a;
                            int i13 = next.f13142b;
                            LinkedHashMap linkedHashMap2 = cVar2.f2521a;
                            if (linkedHashMap2.containsKey(Integer.valueOf(i12))) {
                                Map mapD0 = (Map) linkedHashMap2.get(Integer.valueOf(i12));
                                if (mapD0 == null) {
                                    mapD0 = kotlin.collections.b.d0();
                                }
                                zContainsKey = mapD0.containsKey(Integer.valueOf(i13));
                            }
                            if (!zContainsKey) {
                                cVar2.a(next);
                            }
                        }
                        if (((androidx.room.a) RoomDatabase.q(androidx.room.a.class, t8.h())) != null) {
                            throw null;
                        }
                        t8.h().setWriteAheadLoggingEnabled(cVar3.f2532g == journalMode3);
                        t8.f2496f = cVar3.f2530e;
                        t8.f2492b = cVar3.h;
                        new p(cVar3.f2533i);
                        t8.f2495e = cVar3.f2531f;
                        Map<Class<?>, List<Class<?>>> mapJ = t8.j();
                        BitSet bitSet2 = new BitSet();
                        for (Map.Entry<Class<?>, List<Class<?>>> entry : mapJ.entrySet()) {
                            Class<?> key = entry.getKey();
                            for (Class<?> cls3 : entry.getValue()) {
                                int size2 = arrayList2.size() - 1;
                                if (size2 >= 0) {
                                    while (true) {
                                        int i14 = size2 - 1;
                                        if (cls3.isAssignableFrom(arrayList2.get(size2).getClass())) {
                                            bitSet2.set(size2);
                                            break;
                                        }
                                        if (i14 < 0) {
                                            break;
                                        }
                                        size2 = i14;
                                    }
                                } else {
                                    size2 = -1;
                                }
                                if (!(size2 >= 0)) {
                                    throw new IllegalArgumentException(("A required type converter (" + cls3 + ") for " + key.getCanonicalName() + " is missing in the database configuration.").toString());
                                }
                                t8.f2500k.put(cls3, arrayList2.get(size2));
                            }
                        }
                        int size3 = arrayList2.size() - 1;
                        if (size3 >= 0) {
                            while (true) {
                                int i15 = size3 - 1;
                                if (!bitSet2.get(size3)) {
                                    throw new IllegalArgumentException("Unexpected type converter " + arrayList2.get(size3) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                                }
                                if (i15 < 0) {
                                    break;
                                }
                                size3 = i15;
                            }
                        }
                        return t8;
                    }
                    Class<Object> next2 = it2.next();
                    int size4 = arrayList3.size() - 1;
                    if (size4 >= 0) {
                        while (true) {
                            int i16 = size4 - 1;
                            if (next2.isAssignableFrom(arrayList3.get(size4).getClass())) {
                                bitSet.set(size4);
                                i10 = size4;
                                break;
                            }
                            if (i16 < 0) {
                                break;
                            }
                            size4 = i16;
                        }
                    }
                    if (i10 < 0) {
                        throw new IllegalArgumentException(("A required auto migration spec (" + next2.getCanonicalName() + ") is missing in the database configuration.").toString());
                    }
                    linkedHashMap.put(next2, arrayList3.get(i10));
                }
            } catch (ClassNotFoundException unused) {
                throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + strConcat + " does not exist");
            } catch (IllegalAccessException unused2) {
                throw new RuntimeException("Cannot access the constructor " + cls.getCanonicalName());
            } catch (InstantiationException unused3) {
                throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedHashMap f2521a = new LinkedHashMap();

        public final void a(u1.a... migrations) {
            kotlin.jvm.internal.g.f(migrations, "migrations");
            for (u1.a aVar : migrations) {
                int i10 = aVar.f13141a;
                int i11 = aVar.f13142b;
                Integer numValueOf = Integer.valueOf(i10);
                LinkedHashMap linkedHashMap = this.f2521a;
                Object treeMap = linkedHashMap.get(numValueOf);
                if (treeMap == null) {
                    treeMap = new TreeMap();
                    linkedHashMap.put(numValueOf, treeMap);
                }
                TreeMap treeMap2 = (TreeMap) treeMap;
                if (treeMap2.containsKey(Integer.valueOf(i11))) {
                    Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i11)) + " with " + aVar);
                }
                treeMap2.put(Integer.valueOf(i11), aVar);
            }
        }
    }

    public RoomDatabase() {
        Map<String, Object> mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        kotlin.jvm.internal.g.e(mapSynchronizedMap, "synchronizedMap(mutableMapOf())");
        this.f2499j = mapSynchronizedMap;
        this.f2500k = new LinkedHashMap();
    }

    public static Object q(Class cls, y1.c cVar) {
        if (cls.isInstance(cVar)) {
            return cVar;
        }
        if (cVar instanceof d) {
            return q(cls, ((d) cVar).j());
        }
        return null;
    }

    public final void a() {
        if (!this.f2495e && Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void b() {
        if (!h().n0().w0() && this.f2498i.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public final void c() {
        a();
        a();
        y1.b bVarN0 = h().n0();
        this.f2494d.d(bVarN0);
        if (bVarN0.A0()) {
            bVarN0.A();
        } else {
            bVarN0.l();
        }
    }

    public final void d() {
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = this.f2491a;
        if (kotlin.jvm.internal.g.b(frameworkSQLiteDatabase != null ? Boolean.valueOf(frameworkSQLiteDatabase.f2630a.isOpen()) : null, Boolean.TRUE)) {
            ReentrantReadWriteLock.WriteLock writeLock = this.h.writeLock();
            kotlin.jvm.internal.g.e(writeLock, "readWriteLock.writeLock()");
            writeLock.lock();
            try {
                this.f2494d.getClass();
                h().close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public abstract f e();

    public abstract y1.c f(androidx.room.c cVar);

    public List<u1.a> g(Map<Class<Object>, Object> autoMigrationSpecs) {
        kotlin.jvm.internal.g.f(autoMigrationSpecs, "autoMigrationSpecs");
        return EmptyList.f10001a;
    }

    public final y1.c h() {
        y1.c cVar = this.f2493c;
        if (cVar != null) {
            return cVar;
        }
        kotlin.jvm.internal.g.l("internalOpenHelper");
        throw null;
    }

    public Set<Class<Object>> i() {
        return EmptySet.f10003a;
    }

    public Map<Class<?>, List<Class<?>>> j() {
        return kotlin.collections.b.d0();
    }

    public final void k() {
        h().n0().H();
        if (h().n0().w0()) {
            return;
        }
        f fVar = this.f2494d;
        if (fVar.f2545f.compareAndSet(false, true)) {
            Executor executor = fVar.f2540a.f2492b;
            if (executor != null) {
                executor.execute(fVar.f2551m);
            } else {
                kotlin.jvm.internal.g.l("internalQueryExecutor");
                throw null;
            }
        }
    }

    public final void l(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        f fVar = this.f2494d;
        fVar.getClass();
        synchronized (fVar.f2550l) {
            if (fVar.f2546g) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            frameworkSQLiteDatabase.n("PRAGMA temp_store = MEMORY;");
            frameworkSQLiteDatabase.n("PRAGMA recursive_triggers='ON';");
            frameworkSQLiteDatabase.n("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            fVar.d(frameworkSQLiteDatabase);
            fVar.h = frameworkSQLiteDatabase.a0("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            fVar.f2546g = true;
            lb.n nVar = lb.n.f10413a;
        }
    }

    public final Cursor m(y1.e eVar) {
        a();
        b();
        return h().n0().b0(eVar);
    }

    public final <V> V n(Callable<V> callable) {
        c();
        try {
            V vCall = callable.call();
            p();
            return vCall;
        } finally {
            k();
        }
    }

    public final void o(Runnable runnable) {
        c();
        try {
            runnable.run();
            p();
        } finally {
            k();
        }
    }

    public final void p() {
        h().n0().y();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class b {
        public void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        }
    }
}
