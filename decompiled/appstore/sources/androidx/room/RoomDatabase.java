package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedanceos.common.toolbox.ServerElements;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.File;
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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoomDatabase {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c f4458o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile SupportSQLiteDatabase f4459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f4460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Executor f4461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SupportSQLiteOpenHelper f4462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f4463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f4466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map f4467i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ReentrantReadWriteLock f4468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.room.e f4469k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ThreadLocal f4470l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map f4471m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f4472n;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Landroidx/room/RoomDatabase$JournalMode;", "", "(Ljava/lang/String;I)V", "isLowRamDevice", "", "activityManager", "Landroid/app/ActivityManager;", "resolve", "context", "Landroid/content/Context;", "resolve$room_runtime_release", "AUTOMATIC", "TRUNCATE", "WRITE_AHEAD_LOGGING", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum JournalMode extends Enum<JournalMode> {
        private static final /* synthetic */ JournalMode[] $VALUES = null;
        public static final JournalMode AUTOMATIC = null;
        public static final JournalMode TRUNCATE = null;
        public static final JournalMode WRITE_AHEAD_LOGGING = null;

        private static final /* synthetic */ JournalMode[] $values() {
            return new JournalMode[]{AUTOMATIC, TRUNCATE, WRITE_AHEAD_LOGGING};
        }

        static {
            AUTOMATIC = new JournalMode("AUTOMATIC", 0);
            TRUNCATE = new JournalMode("TRUNCATE", 1);
            WRITE_AHEAD_LOGGING = new JournalMode("WRITE_AHEAD_LOGGING", 2);
            $VALUES = $values();
        }

        private JournalMode(String r10, int r11) {
            super(r10, r11);
        }

        private final boolean isLowRamDevice(ActivityManager r10) {
            return c0.c.b(r10);
        }

        public static JournalMode valueOf(String r10) {
            return (JournalMode) Enum.valueOf(JournalMode.class, r10);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) $VALUES.clone();
        }

        @NotNull
        public final JournalMode resolve$room_runtime_release(@NotNull Context r10) {
            kotlin.jvm.internal.q.g(r10, "context");
            if (this == AUTOMATIC) goto L5;
            return this;
        L5:
            Object r11 = r10.getSystemService("activity");
            if ((r11 instanceof ActivityManager) == false) goto L8;
            ActivityManager r12 = (ActivityManager) r11;
        L9:
            if (r12 == null) goto L15;
            if (isLowRamDevice(r12) == true) goto L15;
            return WRITE_AHEAD_LOGGING;
        L15:
            return TRUNCATE;
        L8:
            r12 = null;
            goto L9
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/room/RoomDatabase$QueryCallback;", "", "onQuery", "", "sqlQuery", "", "bindArgs", "", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface QueryCallback {
        void onQuery(@NotNull String r10, @NotNull List<? extends Object> r11);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f4473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f4474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f4475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f4476d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public QueryCallback f4477e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Executor f4478f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List f4479g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List f4480h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Executor f4481i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Executor f4482j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public SupportSQLiteOpenHelper.Factory f4483k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f4484l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public JournalMode f4485m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Intent f4486n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f4487o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f4488p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f4489q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public TimeUnit f4490r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final d f4491s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public Set f4492t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Set f4493u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f4494v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public File f4495w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public Callable f4496x;

        public a(Context r10, Class r11, String r12) {
            kotlin.jvm.internal.q.g(r10, "context");
            kotlin.jvm.internal.q.g(r11, "klass");
            this.f4473a = r10;
            this.f4474b = r11;
            this.f4475c = r12;
            this.f4476d = new ArrayList();
            this.f4479g = new ArrayList();
            this.f4480h = new ArrayList();
            this.f4485m = JournalMode.AUTOMATIC;
            this.f4487o = true;
            this.f4489q = -1;
            this.f4491s = new d();
            this.f4492t = new LinkedHashSet();
        }

        public a a(b r10) {
            kotlin.jvm.internal.q.g(r10, "callback");
            this.f4476d.add(r10);
            return this;
        }

        public a b(a0.a... r10) {
            kotlin.jvm.internal.q.g(r10, "migrations");
            if (this.f4493u != null) goto L5;
            this.f4493u = new HashSet();
        L5:
            int r11 = r10.length;
            int r12 = 0;
        L6:
            if (r12 >= r11) goto L8;
            a0.a r13 = r10[r12];
            Set r14 = this.f4493u;
            kotlin.jvm.internal.q.d(r14);
            r14.add(Integer.valueOf(r13.f5a));
            Set r15 = this.f4493u;
            kotlin.jvm.internal.q.d(r15);
            r15.add(Integer.valueOf(r13.f6b));
            r12 = r12 + 1;
            goto L6
        L8:
            this.f4491s.b((a0.a[]) Arrays.copyOf(r10, r10.length));
            return this;
        }

        public a c() {
            this.f4484l = true;
            return this;
        }

        public RoomDatabase d() {
            Executor r10 = this.f4481i;
            if (r10 == null) goto L5;
        L7:
            if (r10 != null) goto L9;
        L11:
            if (r10 != null) goto L13;
            this.f4481i = this.f4482j;
        L13:
            Set r11 = this.f4493u;
            if (r11 == null) goto L23;
            kotlin.jvm.internal.q.d(r11);
            Iterator r12 = r11.iterator();
        L17:
            if (r12.hasNext() == false) goto L23;
            int r13 = ((Number) r12.next()).intValue();
            if (this.f4492t.contains(Integer.valueOf(r13)) == false) goto L17;
            throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + r13).toString());
        L23:
            SupportSQLiteOpenHelper.Factory r14 = this.f4483k;
            if (r14 != null) goto L27;
            r14 = new androidx.sqlite.db.framework.d();
        L27:
            if (r14 != null) goto L29;
            r14 = null;
        L71:
            if (r14 == null) goto L94;
            QueryCallback r15 = this.f4477e;
            if (r15 == null) goto L82;
            Executor r16 = this.f4478f;
            if (r16 == null) goto L81;
            if (r15 == null) goto L79;
            SupportSQLiteOpenHelper.Factory r17 = new f0(r14, r16, r15);
        L83:
            Context r18 = this.f4473a;
            String r19 = this.f4475c;
            d r20 = this.f4491s;
            List r21 = this.f4476d;
            boolean r22 = this.f4484l;
            JournalMode r110 = this.f4485m.resolve$room_runtime_release(r18);
            Executor r111 = this.f4481i;
            if (r111 == null) goto L92;
            Executor r112 = this.f4482j;
            if (r112 == null) goto L90;
            h r23 = new h(r18, r19, r17, r20, r21, r22, r110, r111, r112, this.f4486n, this.f4487o, this.f4488p, this.f4492t, this.f4494v, this.f4495w, this.f4496x, null, this.f4479g, this.f4480h);
            RoomDatabase r24 = (RoomDatabase) n0.b(this.f4474b, "_Impl");
            r24.u(r23);
            return r24;
        L90:
            throw new IllegalArgumentException("Required value was null.");
        L92:
            throw new IllegalArgumentException("Required value was null.");
        L79:
            throw new IllegalArgumentException("Required value was null.");
        L81:
            throw new IllegalArgumentException("Required value was null.");
        L82:
            r17 = r14;
            goto L83
        L94:
            throw new IllegalArgumentException("Required value was null.");
        L29:
            if (this.f4489q > 0) goto L31;
        L43:
            String r25 = this.f4494v;
            if (r25 != null) goto L50;
            if (this.f4495w != null) goto L50;
            if (this.f4496x == null) goto L71;
        L50:
            if (this.f4475c == null) goto L69;
            int r26 = 0;
            if (r25 != null) goto L54;
            int r27 = 0;
        L55:
            File r28 = this.f4495w;
            if (r28 != null) goto L58;
            int r29 = 0;
        L59:
            Callable r30 = this.f4496x;
            if (r30 == null) goto L64;
            r26 = 1;
        L64:
            if (((r27 + r29) + r26) != 1) goto L67;
            r14 = new v0(r25, r28, r30, r14);
            goto L71
        L67:
            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
        L58:
            r29 = 1;
            goto L59
        L54:
            r27 = 1;
            goto L55
        L69:
            throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
        L31:
            if (this.f4475c == null) goto L42;
            long r31 = this.f4489q;
            TimeUnit r32 = this.f4490r;
            if (r32 == null) goto L40;
            Executor r33 = this.f4481i;
            if (r33 == null) goto L38;
            r14 = new f(r14, new androidx.room.e(r31, r32, r33));
            goto L43
        L38:
            throw new IllegalArgumentException("Required value was null.");
        L40:
            throw new IllegalArgumentException("Required value was null.");
        L42:
            throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
        L9:
            if (this.f4482j != null) goto L11;
            this.f4482j = r10;
            goto L13
        L5:
            if (this.f4482j != null) goto L7;
            Executor r34 = h.c.g();
            this.f4482j = r34;
            this.f4481i = r34;
            goto L13
        }

        public a e() {
            this.f4487o = false;
            this.f4488p = true;
            return this;
        }

        public a f(SupportSQLiteOpenHelper.Factory r10) {
            this.f4483k = r10;
            return this;
        }

        public a g(Executor r10) {
            kotlin.jvm.internal.q.g(r10, "executor");
            this.f4481i = r10;
            return this;
        }
    }

    public static abstract class b {
        public b() {
        }

        public void a(SupportSQLiteDatabase r10) {
            kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        }

        public void b(SupportSQLiteDatabase r10) {
            kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        }

        public void c(SupportSQLiteDatabase r10) {
            kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        }
    }

    public static final class c {
        public /* synthetic */ c(DefaultConstructorMarker r10) {
            this();
        }

        public c() {
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f4497a;

        public d() {
            this.f4497a = new LinkedHashMap();
        }

        public final void a(a0.a r10) {
            int r11 = r10.f5a;
            int r12 = r10.f6b;
            Map r13 = this.f4497a;
            Integer r14 = Integer.valueOf(r11);
            Object r15 = r13.get(r14);
            if (r15 != null) goto L5;
            r15 = new TreeMap();
            r13.put(r14, r15);
        L5:
            TreeMap r16 = (TreeMap) r15;
            if (r16.containsKey(Integer.valueOf(r12)) == false) goto L8;
            Log.w("ROOM", "Overriding migration " + r16.get(Integer.valueOf(r12)) + " with " + r10);
        L8:
            r16.put(Integer.valueOf(r12), r10);
        }

        public void b(a0.a... r10) {
            kotlin.jvm.internal.q.g(r10, "migrations");
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            a(r10[r12]);
            r12 = r12 + 1;
            goto L3
        }

        public final boolean c(int r10, int r11) {
            Map r12 = f();
            if (r12.containsKey(Integer.valueOf(r10)) == false) goto L9;
            Map r13 = (Map) r12.get(Integer.valueOf(r10));
            if (r13 != null) goto L8;
            r13 = kotlin.collections.k0.h();
        L8:
            return r13.containsKey(Integer.valueOf(r11));
        L9:
            return false;
        }

        public List d(int r10, int r11) {
            if (r10 == r11) goto L4;
            if (r11 <= r10) goto L7;
            boolean r12 = true;
        L9:
            return e(new ArrayList(), r12, r10, r11);
        L7:
            r12 = false;
            goto L9
        L4:
            return kotlin.collections.t.i();
        }

        public final List e(List r10, boolean r11, int r12, int r13) {
        L2:
            if (r11 == false) goto L5;
            if (r12 >= r13) goto L28;
        L6:
            TreeMap r14 = (TreeMap) this.f4497a.get(Integer.valueOf(r12));
            if (r14 == null) goto L8;
            if (r11 == false) goto L11;
            Set r15 = r14.descendingKeySet();
        L12:
            Iterator r16 = r15.iterator();
        L14:
            if (r16.hasNext() == false) goto L25;
            Integer r17 = (Integer) r16.next();
            if (r11 == true) goto L17;
            kotlin.jvm.internal.q.f(r17, "targetVersion");
            int r18 = r17.intValue();
            if (r13 > r18) goto L14;
            if (r18 >= r12) goto L14;
        L24:
            Object r19 = r14.get(r17);
            kotlin.jvm.internal.q.d(r19);
            r10.add(r19);
            r12 = r17.intValue();
            boolean r20 = true;
        L26:
            if (r20 == true) goto L2;
            return null;
        L17:
            int r21 = r12 + 1;
            kotlin.jvm.internal.q.f(r17, "targetVersion");
            int r22 = r17.intValue();
            if (r21 > r22) goto L14;
            if (r22 > r13) goto L14;
        L25:
            r20 = false;
            goto L26
        L11:
            r15 = r14.keySet();
            goto L12
        L8:
            return null;
        L28:
            return r10;
        L5:
            if (r12 <= r13) goto L28;
            goto L6
        }

        public Map f() {
            return this.f4497a;
        }
    }

    public static abstract class e {
    }

    static {
        f4458o = new c(null);
    }

    public RoomDatabase() {
        this.f4463e = g();
        this.f4467i = new LinkedHashMap();
        this.f4468j = new ReentrantReadWriteLock();
        this.f4470l = new ThreadLocal();
        Map r10 = Collections.synchronizedMap(new LinkedHashMap());
        kotlin.jvm.internal.q.f(r10, "synchronizedMap(mutableMapOf())");
        this.f4471m = r10;
        this.f4472n = new LinkedHashMap();
    }

    public static /* synthetic */ Cursor B(RoomDatabase r10, SupportSQLiteQuery r11, CancellationSignal r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = null;
    L7:
        return r10.A(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
    }

    public static final /* synthetic */ void a(RoomDatabase r10) {
        r10.v();
    }

    public static final /* synthetic */ void b(RoomDatabase r10) {
        r10.w();
    }

    public Cursor A(SupportSQLiteQuery r10, CancellationSignal r11) {
        kotlin.jvm.internal.q.g(r10, "query");
        c();
        d();
        if (r11 == null) goto L6;
        return n().getWritableDatabase().query(r10, r11);
    L6:
        return n().getWritableDatabase().query(r10);
    }

    public Object C(Callable r10) {
        kotlin.jvm.internal.q.g(r10, ServerElements.BODY);
        e();
        Object r11 = r10.call();     // Catch: Throwable -> L6
        D();     // Catch: Throwable -> L6
        i();
        return r11;
    L6:
        th = move-exception;
        i();
        throw th;
    }

    public void D() {
        n().getWritableDatabase().setTransactionSuccessful();
    }

    public final Object E(Class r10, SupportSQLiteOpenHelper r11) {
        if (r10.isInstance(r11) == false) goto L6;
        return r11;
    L6:
        if ((r11 instanceof DelegatingOpenHelper) == true) goto L10;
        return null;
    L10:
        return E(r10, ((DelegatingOpenHelper) r11).getDelegate());
    }

    public void c() {
        if (this.f4464f == false) goto L6;
        return;
    L6:
        if (y() == true) goto L9;
        return;
    L9:
        throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
    }

    public void d() {
        if (t() == false) goto L5;
        return;
    L5:
        if (this.f4470l.get() != null) goto L8;
        return;
    L8:
        throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
    }

    public void e() {
        c();
        androidx.room.e r10 = this.f4469k;
        if (r10 != null) goto L5;
        v();
        return;
    L5:
        r10.g(new RoomDatabase$beginTransaction$1(this));
    }

    public SupportSQLiteStatement f(String r10) {
        kotlin.jvm.internal.q.g(r10, "sql");
        c();
        d();
        return n().getWritableDatabase().compileStatement(r10);
    }

    public abstract m g();

    public abstract SupportSQLiteOpenHelper h(h r10);

    public void i() {
        androidx.room.e r10 = this.f4469k;
        if (r10 != null) goto L5;
        w();
        return;
    L5:
        r10.g(new RoomDatabase$endTransaction$1(this));
    }

    public List j(Map r10) {
        kotlin.jvm.internal.q.g(r10, "autoMigrationSpecs");
        return kotlin.collections.t.i();
    }

    public final Map k() {
        return this.f4471m;
    }

    public final Lock l() {
        ReentrantReadWriteLock.ReadLock r10 = this.f4468j.readLock();
        kotlin.jvm.internal.q.f(r10, "readWriteLock.readLock()");
        return r10;
    }

    public m m() {
        return this.f4463e;
    }

    public SupportSQLiteOpenHelper n() {
        SupportSQLiteOpenHelper r10 = this.f4462d;
        if (r10 != null) goto L6;
        kotlin.jvm.internal.q.y("internalOpenHelper");
        return null;
    L6:
        return r10;
    }

    public Executor o() {
        Executor r10 = this.f4460b;
        if (r10 != null) goto L6;
        kotlin.jvm.internal.q.y("internalQueryExecutor");
        return null;
    L6:
        return r10;
    }

    public Set p() {
        return kotlin.collections.r0.e();
    }

    public Map q() {
        return kotlin.collections.k0.h();
    }

    public final ThreadLocal r() {
        return this.f4470l;
    }

    public Executor s() {
        Executor r10 = this.f4461c;
        if (r10 != null) goto L6;
        kotlin.jvm.internal.q.y("internalTransactionExecutor");
        return null;
    L6:
        return r10;
    }

    public boolean t() {
        return n().getWritableDatabase().inTransaction();
    }

    public void u(h r10) {
        kotlin.jvm.internal.q.g(r10, "configuration");
        this.f4462d = h(r10);
        Set r11 = p();
        BitSet r12 = new BitSet();
        Iterator r13 = r11.iterator();
    L3:
        int r14 = -1;
        if (r13.hasNext() == false) goto L17;
        Class r15 = (Class) r13.next();
        int r16 = r10.f4571r.size() - 1;
        if (r16 < 0) goto L13;
    L7:
        int r17 = r16 - 1;
        if (r15.isAssignableFrom(r10.f4571r.get(r16).getClass()) == true) goto L9;
        if (r17 < 0) goto L13;
        r16 = r17;
        goto L7
    L9:
        r12.set(r16);
        r14 = r16;
    L13:
        if (r14 < 0) goto L16;
        this.f4467i.put(r15, r10.f4571r.get(r14));
        goto L3
    L16:
        throw new IllegalArgumentException(("A required auto migration spec (" + r15.getCanonicalName() + ") is missing in the database configuration.").toString());
    L17:
        int r18 = r10.f4571r.size() - 1;
        if (r18 < 0) goto L26;
    L19:
        int r19 = r18 - 1;
        if (r12.get(r18) == false) goto L25;
        if (r19 < 0) goto L26;
        r18 = r19;
        goto L19
    L25:
        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
    L26:
        Iterator r20 = j(this.f4467i).iterator();
    L28:
        if (r20.hasNext() == false) goto L32;
        a0.a r21 = (a0.a) r20.next();
        if (r10.f4557d.c(r21.f5a, r21.f6b) == true) goto L28;
        r10.f4557d.b(new a0.a[]{r21});
        goto L28
    L32:
        u0 r22 = (u0) E(u0.class, n());
        if (r22 == null) goto L35;
        r22.c(r10);
    L35:
        AutoClosingRoomOpenHelper r23 = (AutoClosingRoomOpenHelper) E(AutoClosingRoomOpenHelper.class, n());
        if (r23 == null) goto L39;
        this.f4469k = r23.f4437b;
        m().r(r23.f4437b);
    L39:
        if (r10.f4560g != JournalMode.WRITE_AHEAD_LOGGING) goto L41;
        boolean r24 = true;
    L42:
        n().setWriteAheadLoggingEnabled(r24);
        this.f4466h = r10.f4558e;
        this.f4460b = r10.f4561h;
        this.f4461c = new y0(r10.f4562i);
        this.f4464f = r10.f4559f;
        this.f4465g = r24;
        if (r10.f4563j != null) goto L45;
    L49:
        Map r25 = q();
        BitSet r26 = new BitSet();
        Iterator r27 = r25.entrySet().iterator();
    L51:
        if (r27.hasNext() == false) goto L68;
        Map.Entry r28 = (Map.Entry) r27.next();
        Class r29 = (Class) r28.getKey();
        Iterator r30 = ((List) r28.getValue()).iterator();
    L54:
        if (r30.hasNext() == false) goto L51;
        Class r31 = (Class) r30.next();
        int r32 = r10.f4570q.size() - 1;
        if (r32 < 0) goto L63;
    L57:
        int r33 = r32 - 1;
        if (r31.isAssignableFrom(r10.f4570q.get(r32).getClass()) == true) goto L59;
        if (r33 < 0) goto L63;
        r32 = r33;
        goto L57
    L59:
        r26.set(r32);
    L64:
        if (r32 < 0) goto L67;
        this.f4472n.put(r31, r10.f4570q.get(r32));
        goto L54
    L67:
        throw new IllegalArgumentException(("A required type converter (" + r31 + ") for " + r29.getCanonicalName() + " is missing in the database configuration.").toString());
    L63:
        r32 = -1;
        goto L64
    L68:
        int r34 = r10.f4570q.size() - 1;
        if (r34 < 0) goto L77;
    L70:
        int r35 = r34 - 1;
        if (r26.get(r34) == false) goto L76;
        if (r35 < 0) goto L96;
        r34 = r35;
        goto L70
    L96:
        return;
    L76:
        throw new IllegalArgumentException("Unexpected type converter " + r10.f4570q.get(r34) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
    L77:
        return;
    L45:
        if (r10.f4555b == null) goto L48;
        m().s(r10.f4554a, r10.f4555b, r10.f4563j);
        goto L49
    L48:
        throw new IllegalArgumentException("Required value was null.");
    L41:
        r24 = false;
        goto L42
    }

    public final void v() {
        c();
        SupportSQLiteDatabase r10 = n().getWritableDatabase();
        m().w(r10);
        if (r10.isWriteAheadLoggingEnabled() == false) goto L5;
        r10.beginTransactionNonExclusive();
        return;
    L5:
        r10.beginTransaction();
    }

    public final void w() {
        n().getWritableDatabase().endTransaction();
        if (t() == true) goto L6;
        m().o();
        return;
    }

    public void x(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        m().l(r10);
    }

    public final boolean y() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean z() {
        SupportSQLiteDatabase r10 = this.f4459a;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.isOpen() == true) goto L7;
        return false;
    L7:
        return true;
    }
}
