package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: RoomDatabase.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    protected volatile androidx.sqlite.db.c f2668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f2669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    protected List<b> f2670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Map<Class<? extends androidx.room.a.a>, androidx.room.a.a> f2671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Executor f2672e;
    private Executor f;
    private androidx.sqlite.db.d g;
    private final h h;
    private boolean i;
    private final ReentrantReadWriteLock j;
    private androidx.room.a k;
    private final ThreadLocal<Integer> l;
    private final Map<String, Object> m;
    private final Map<Class<?>, Object> n;

    /* JADX INFO: compiled from: RoomDatabase.java */
    public static class a<T extends p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<T> f2673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f2674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f2675c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ArrayList<b> f2676d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private e f2677e;
        private f f;
        private Executor g;
        private List<Object> h;
        private List<androidx.room.a.a> i;
        private Executor j;
        private Executor k;
        private androidx.sqlite.db.d.c l;
        private boolean m;
        private c n;
        private Intent o;
        private boolean p;
        private boolean q;
        private long r;
        private TimeUnit s;
        private final d t;
        private Set<Integer> u;
        private Set<Integer> v;
        private String w;
        private File x;
        private Callable<InputStream> y;

        a(Context r5, Class<T> r6, String r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            this.r = -1;
            this.f2675c = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
            this.f2673a = r6;
            this.f2674b = r7;
            this.n = c.f2678a;
            this.p = true;
            this.t = new d();
        }

        public a<T> a(File r1) {
            this.x = r1;
            return this;
        }

        public a<T> a(androidx.room.a.b... r6) {
            if (this.v != null) goto L5;
            this.v = new HashSet();
        L5:
            int r0 = r6.length;
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L8;
            androidx.room.a.b r2 = r6[r1];
            this.v.add(Integer.valueOf(r2.f2613a));
            this.v.add(Integer.valueOf(r2.f2614b));
            r1 = r1 + 1;
            goto L6
        L8:
            this.t.a(r6);
            return this;
        }

        public a<T> a() {
            this.p = false;
            this.q = true;
            return this;
        }

        public a<T> a(b r2) {
            if (this.f2676d != null) goto L5;
            this.f2676d = new ArrayList();
        L5:
            this.f2676d.add(r2);
            return this;
        }

        public T b() {
            if (this.f2675c == null) goto L77;
            if (this.f2673a == null) goto L75;
            Executor r1 = this.j;
            if (r1 == null) goto L9;
        L11:
            if (r1 != null) goto L13;
        L15:
            if (r1 != null) goto L19;
            Executor r2 = this.k;
            if (r2 == null) goto L19;
            this.j = r2;
        L19:
            Set<Integer> r3 = this.v;
            if (r3 != null) goto L22;
        L31:
            androidx.sqlite.db.d.c r4 = this.l;
            if (r4 != null) goto L35;
            r4 = new androidx.sqlite.db.framework.b();
        L35:
            if (this.r > 0) goto L37;
        L41:
            String r5 = this.w;
            if (r5 != null) goto L48;
            if (this.x != null) goto L48;
            if (this.y != null) goto L48;
        L65:
            if (this.f == null) goto L67;
            androidx.sqlite.db.d.c r9 = new l(r4, this.f, this.g);
        L68:
            Context r6 = this.f2675c;
            androidx.room.c r7 = new androidx.room.c(r6, this.f2674b, r9, this.t, this.f2676d, this.m, this.n.a(r6), this.j, this.k, this.o, this.p, this.q, this.u, this.w, this.x, this.y, this.f2677e, this.h, this.i);
            T r0 = (T) ZeusTransformUtils.preCheckCast(o.a(this.f2673a, "_Impl"), p.class, "com.obric.aiagent.plugin");
            r0.a(r7);
            return r0;
        L67:
            r9 = r4;
        L48:
            if (this.f2674b == null) goto L73;
            int r8 = 0;
            if (r5 != null) goto L52;
            int r10 = 0;
        L54:
            if (this.x != null) goto L56;
            int r11 = 0;
        L57:
            int r12 = r10 + r11;
            if (this.y == null) goto L62;
            r8 = 1;
        L62:
            if ((r12 + r8) != 1) goto L71;
            r4 = new u(this.w, this.x, this.y, r4);
            goto L65
        L71:
            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
        L56:
            r11 = 1;
            goto L57
        L52:
            r10 = 1;
            goto L54
        L73:
            throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
        L37:
            if (this.f2674b == null) goto L40;
            r4 = new androidx.room.b(r4, new androidx.room.a(this.r, this.s, this.k));
            goto L41
        L40:
            throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
        L22:
            if (this.u == null) goto L31;
            Iterator<Integer> r13 = r3.iterator();
        L25:
            if (r13.hasNext() == false) goto L31;
            Integer r14 = (Integer) ZeusTransformUtils.preCheckCast(r13.next(), Integer.class, "com.obric.aiagent.plugin");
            if (this.u.contains(r14) == false) goto L25;
            throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + r14);
        L13:
            if (this.k != null) goto L15;
            this.k = r1;
            goto L19
        L9:
            if (this.k != null) goto L11;
            Executor r15 = androidx.a.a.a.a.b();
            this.k = r15;
            this.j = r15;
            goto L19
        L75:
            throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
        L77:
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }
    }

    /* JADX INFO: compiled from: RoomDatabase.java */
    public static abstract class b {
        public void a(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        }

        public void b(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        }

        public void c(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        }

        public b() {
        }
    }

    /* JADX INFO: compiled from: RoomDatabase.java */
    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f2678a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f2679b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f2680c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ c[] f2681d = null;

        private c(String r1, int r2) {
            super(r1, r2);
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f2681d.clone(), c[].class, "com.obric.aiagent.plugin");
        }

        static {
            c r0 = new c("AUTOMATIC", 0);
            f2678a = r0;
            c r1 = new c("TRUNCATE", 1);
            f2679b = r1;
            c r3 = new c("WRITE_AHEAD_LOGGING", 2);
            f2680c = r3;
            f2681d = new c[]{r0, r1, r3};
        }

        c a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if (this == f2678a) goto L6;
            return this;
        L6:
            if (Build.VERSION.SDK_INT < 16) goto L14;
            ActivityManager r2 = (ActivityManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L14;
            if (a(r2) == true) goto L14;
            return f2680c;
        L14:
            return f2679b;
        }

        private static boolean a(ActivityManager r2) {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return false;
        L5:
            return androidx.sqlite.db.b.C0076b.a(r2);
        }
    }

    /* JADX INFO: compiled from: RoomDatabase.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private HashMap<Integer, TreeMap<Integer, androidx.room.a.b>> f2682a;

        public d() {
            this.f2682a = new HashMap();
        }

        public void a(androidx.room.a.b... r4) {
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            a(r4[r1]);
            r1 = r1 + 1;
            goto L3
        }

        private void a(androidx.room.a.b r6) {
            int r0 = r6.f2613a;
            int r1 = r6.f2614b;
            TreeMap<Integer, androidx.room.a.b> r2 = (TreeMap) ZeusTransformUtils.preCheckCast(this.f2682a.get(Integer.valueOf(r0)), TreeMap.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L5;
            r2 = new TreeMap();
            this.f2682a.put(Integer.valueOf(r0), r2);
        L5:
            androidx.room.a.b r5 = (androidx.room.a.b) ZeusTransformUtils.preCheckCast(r2.get(Integer.valueOf(r1)), androidx.room.a.b.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L8;
            a("ROOM", "Overriding migration " + r5 + " with " + r6);
        L8:
            r2.put(Integer.valueOf(r1), r6);
        }

        public Map<Integer, Map<Integer, androidx.room.a.b>> a() {
            return Collections.unmodifiableMap(this.f2682a);
        }

        public List<androidx.room.a.b> a(int r3, int r4) {
            if (r3 == r4) goto L4;
            if (r4 <= r3) goto L7;
            boolean r0 = true;
        L9:
            return a(new ArrayList(), r0, r3, r4);
        L7:
            r0 = false;
            goto L9
        L4:
            return Collections.emptyList();
        }

        private List<androidx.room.a.b> a(List<androidx.room.a.b> r9, boolean r10, int r11, int r12) {
            List<androidx.room.a.b> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        L3:
            if (r10 == false) goto L6;
            if (r11 >= r12) goto L29;
        L7:
            TreeMap r0 = (TreeMap) ZeusTransformUtils.preCheckCast(this.f2682a.get(Integer.valueOf(r11)), TreeMap.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L9;
            if (r10 == false) goto L12;
            Set r3 = r0.descendingKeySet();
        L13:
            Iterator r4 = r3.iterator();
        L14:
            boolean r5 = true;
            boolean r6 = false;
            if (r4.hasNext() == false) goto L26;
            int r7 = ((Integer) ZeusTransformUtils.preCheckCast(r4.next(), Integer.class, "com.obric.aiagent.plugin")).intValue();
            if (r10 == false) goto L21;
            if (r7 > r12) goto L24;
            if (r7 <= r11) goto L24;
        L20:
            r6 = true;
        L24:
            if (r6 == false) goto L14;
            r13.add((androidx.room.a.b) ZeusTransformUtils.preCheckCast(r0.get(Integer.valueOf(r7)), androidx.room.a.b.class, "com.obric.aiagent.plugin"));
            r11 = r7;
        L27:
            if (r5 == true) goto L3;
            return null;
        L21:
            if (r7 < r12) goto L24;
            if (r7 >= r11) goto L24;
        L26:
            r5 = false;
            goto L27
        L12:
            r3 = r0.keySet();
            goto L13
        L9:
            return null;
        L29:
            return r13;
        L6:
            if (r11 <= r12) goto L29;
            goto L7
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    /* JADX INFO: compiled from: RoomDatabase.java */
    public static abstract class e {
        public void a(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: RoomDatabase.java */
    public interface f {
        void a(String r1, List<Object> r2);
    }

    public static /* synthetic */ Object lambda$5C3IJImjjQLZ9TVqi_gurCx0e9k(p r0, androidx.sqlite.db.c r1) {
        return r0.b(r1);
    }

    public static /* synthetic */ Object lambda$K9MnaOAe30I4D3MDhIYPQJ3gdTY(p r0, androidx.sqlite.db.c r1) {
        return r0.c(r1);
    }

    public abstract androidx.sqlite.db.d b(androidx.room.c r1);

    public abstract h c();

    Lock a() {
        return this.j.readLock();
    }

    public p() {
        this.j = new ReentrantReadWriteLock();
        this.l = new ThreadLocal();
        this.m = Collections.synchronizedMap(new HashMap());
        this.h = c();
        this.n = new HashMap();
        this.f2671d = new HashMap();
    }

    public void a(androidx.room.c r12) {
        this.g = b(r12);
        Set<Class<? extends androidx.room.a.a>> r0 = e();
        BitSet r1 = new BitSet();
        Iterator<Class<? extends androidx.room.a.a>> r2 = r0.iterator();
    L3:
        int r3 = -1;
        if (r2.hasNext() == false) goto L15;
        Class<? extends androidx.room.a.a> r4 = (Class) ZeusTransformUtils.preCheckCast(r2.next(), Class.class, "com.obric.aiagent.plugin");
        int r6 = r12.h.size() - 1;
    L6:
        if (r6 < 0) goto L11;
        if (r4.isAssignableFrom(r12.h.get(r6).getClass()) == true) goto L9;
        r6 = r6 - 1;
        goto L6
    L9:
        r1.set(r6);
        r3 = r6;
    L11:
        if (r3 < 0) goto L14;
        this.f2671d.put(r4, (androidx.room.a.a) ZeusTransformUtils.preCheckCast(r12.h.get(r3), androidx.room.a.a.class, "com.obric.aiagent.plugin"));
        goto L3
    L14:
        throw new IllegalArgumentException("A required auto migration spec (" + r4.getCanonicalName() + ") is missing in the database configuration.");
    L15:
        int r5 = r12.h.size() - 1;
    L16:
        if (r5 < 0) goto L22;
        if (r1.get(r5) == false) goto L21;
        r5 = r5 - 1;
        goto L16
    L21:
        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
    L22:
        Iterator<androidx.room.a.b> r7 = a(this.f2671d).iterator();
    L23:
        boolean r8 = false;
        if (r7.hasNext() == false) goto L28;
        androidx.room.a.b r9 = (androidx.room.a.b) ZeusTransformUtils.preCheckCast(r7.next(), androidx.room.a.b.class, "com.obric.aiagent.plugin");
        if (r12.f2626d.a().containsKey(Integer.valueOf(r9.f2613a)) == true) goto L23;
        r12.f2626d.a(new androidx.room.a.b[]{r9});
        goto L23
    L28:
        t r10 = (t) ZeusTransformUtils.preCheckCast(a(t.class, this.g), t.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L31;
        r10.a(r12);
    L31:
        AutoClosingRoomOpenHelper r11 = (AutoClosingRoomOpenHelper) ZeusTransformUtils.preCheckCast(a(AutoClosingRoomOpenHelper.class, this.g), AutoClosingRoomOpenHelper.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L35;
        androidx.room.a r13 = r11.d();
        this.k = r13;
        this.h.a(r13);
    L35:
        if (Build.VERSION.SDK_INT >= 16) goto L37;
    L40:
        this.f2670c = r12.f2627e;
        this.f2672e = r12.k;
        this.f = new w(r12.l);
        this.i = r12.i;
        this.f2669b = r8;
        if (r12.n == null) goto L43;
        this.h.a(r12.f2624b, r12.f2625c, r12.n);
    L43:
        Map<Class<?>, List<Class<?>>> r14 = d();
        BitSet r15 = new BitSet();
        Iterator<Map.Entry<Class<?>, List<Class<?>>>> r16 = r14.entrySet().iterator();
    L45:
        if (r16.hasNext() == false) goto L60;
        Map.Entry r17 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Class r18 = (Class) ZeusTransformUtils.preCheckCast(r17.getKey(), Class.class, "com.obric.aiagent.plugin");
        Iterator r19 = ((List) ZeusTransformUtils.preCheckCast(r17.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();
    L48:
        if (r19.hasNext() == false) goto L45;
        Class<?> r20 = (Class) ZeusTransformUtils.preCheckCast(r19.next(), Class.class, "com.obric.aiagent.plugin");
        int r21 = r12.g.size() - 1;
    L50:
        if (r21 < 0) goto L55;
        if (r20.isAssignableFrom(r12.g.get(r21).getClass()) == true) goto L53;
        r21 = r21 - 1;
        goto L50
    L53:
        r15.set(r21);
    L56:
        if (r21 < 0) goto L59;
        this.n.put(r20, r12.g.get(r21));
        goto L48
    L59:
        throw new IllegalArgumentException("A required type converter (" + r20 + ") for " + r18.getCanonicalName() + " is missing in the database configuration.");
    L55:
        r21 = -1;
        goto L56
    L60:
        int r110 = r12.g.size() - 1;
    L61:
        if (r110 < 0) goto L67;
        if (r15.get(r110) == false) goto L66;
        r110 = r110 - 1;
        goto L61
    L66:
        throw new IllegalArgumentException("Unexpected type converter " + r12.g.get(r110) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
    L67:
        return;
    L37:
        if (r12.j != c.f2680c) goto L39;
        r8 = true;
    L39:
        this.g.a(r8);
        goto L40
    }

    public List<androidx.room.a.b> a(Map<Class<? extends androidx.room.a.a>, androidx.room.a.a> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        return Collections.emptyList();
    }

    private <T> T a(Class<T> r3, androidx.sqlite.db.d r4) {
        T r5 = (T) ((androidx.sqlite.db.d) ZeusTransformUtils.wrapperContextForParams(r4, androidx.sqlite.db.d.class, "com.obric.aiagent.plugin"));
        if (ZeusTransformUtils.instanceOf(r3, r5) == false) goto L6;
        return r5;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, androidx.room.d.class) == true) goto L8;
        return null;
    L8:
        return (T) a(r3, ((androidx.room.d) ZeusTransformUtils.preCheckCast(r5, androidx.room.d.class, "com.obric.aiagent.plugin")).e());
    }

    public androidx.sqlite.db.d b() {
        return this.g;
    }

    public Map<Class<?>, List<Class<?>>> d() {
        return Collections.emptyMap();
    }

    public Set<Class<? extends androidx.room.a.a>> e() {
        return Collections.emptySet();
    }

    public boolean f() {
        androidx.room.a r0 = this.k;
        if (r0 != null) goto L5;
        androidx.sqlite.db.c r1 = this.f2668a;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.g() == false) goto L11;
        return true;
    L5:
        return r0.e();
    }

    public void g() {
        if (f() == false) goto L10;
        ReentrantReadWriteLock.WriteLock r0 = this.j.writeLock();
        r0.lock();
        this.h.b();     // Catch: Throwable -> L7
        this.g.close();     // Catch: Throwable -> L7
        r0.unlock();
        return;
    L7:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public void h() {
        if (this.i == false) goto L6;
        return;
    L6:
        if (q() == true) goto L9;
        return;
    L9:
        throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
    }

    public void i() {
        if (n() == false) goto L5;
        return;
    L5:
        if (this.l.get() != null) goto L8;
        return;
    L8:
        throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
    }

    public Cursor query(String r2, Object[] r3) {
        return this.g.b().query(new androidx.sqlite.db.a(r2, r3));
    }

    public Cursor query(androidx.sqlite.db.f r3) {
        return query((androidx.sqlite.db.f) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.f.class, "com.obric.aiagent.plugin"), null);
    }

    public Cursor query(androidx.sqlite.db.f r3, CancellationSignal r4) {
        androidx.sqlite.db.f r5 = (androidx.sqlite.db.f) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.f.class, "com.obric.aiagent.plugin");
        h();
        i();
        if (r4 == null) goto L9;
        if (Build.VERSION.SDK_INT < 16) goto L9;
        return this.g.b().query(r5, r4);
    L9:
        return this.g.b().query(r5);
    }

    public androidx.sqlite.db.g a(String r1) {
        h();
        i();
        return this.g.b().a(r1);
    }

    @Deprecated
    public void j() {
        h();
        androidx.room.a r0 = this.k;
        if (r0 != null) goto L5;
        o();
        return;
    L5:
        r0.a(new $$Lambda$p$K9MnaOAe30I4D3MDhIYPQJ3gdTY(this));
    }

    private /* synthetic */ Object c(androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        o();
        return null;
    }

    private void o() {
        h();
        androidx.sqlite.db.c r0 = this.g.b();
        this.h.b(r0);
        if (Build.VERSION.SDK_INT >= 16) goto L5;
    L7:
        r0.b();
        return;
    L5:
        if (r0.i() == false) goto L7;
        r0.c();
    }

    @Deprecated
    public void k() {
        androidx.room.a r0 = this.k;
        if (r0 != null) goto L5;
        p();
        return;
    L5:
        r0.a(new $$Lambda$p$5C3IJImjjQLZ9TVqi_gurCx0e9k(this));
    }

    private /* synthetic */ Object b(androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        p();
        return null;
    }

    private void p() {
        this.g.b().d();
        if (n() == true) goto L6;
        this.h.d();
        return;
    }

    public Executor l() {
        return this.f2672e;
    }

    @Deprecated
    public void m() {
        this.g.b().e();
    }

    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        j();
        r4.run();     // Catch: Throwable -> L6
        m();     // Catch: Throwable -> L6
        k();
        return;
    L6:
        th = move-exception;
        k();
        throw th;
    }

    public <V> V a(Callable<V> r3) {
        Callable r4 = (Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.aiagent.plugin");
        j();
        V r5 = (V) r4.call();
        m();     // Catch: Throwable -> L6 Exception -> L8 RuntimeException -> L12
        k();
        return r5;
    L6:
        th = move-exception;
        k();
        throw th;
    L12:
        e = move-exception;
        throw e;     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        androidx.room.b.e.a(e);     // Catch: Throwable -> L6
        k();
        return null;
    }

    public void a(androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        this.h.a(r4);
    }

    public boolean n() {
        return this.g.b().f();
    }

    private static boolean q() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }
}
