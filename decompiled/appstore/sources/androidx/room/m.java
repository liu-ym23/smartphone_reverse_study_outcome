package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f4581q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String[] f4582r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f4583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f4584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f4585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f4586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f4587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.room.e f4588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f4589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f4590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile SupportSQLiteStatement f4591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f4592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k f4593k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i.b f4594l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p f4595m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f4596n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Object f4597o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Runnable f4598p;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final void a(SupportSQLiteDatabase r10) {
            kotlin.jvm.internal.q.g(r10, "database");
            if (r10.isWriteAheadLoggingEnabled() == false) goto L5;
            r10.beginTransactionNonExclusive();
            return;
        L5:
            r10.beginTransaction();
        }

        public final String b(String r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "tableName");
            kotlin.jvm.internal.q.g(r11, "triggerType");
            return "`room_table_modification_trigger_" + r10 + '_' + r11 + '`';
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f4599e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f4600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f4601b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f4602c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f4603d;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public a() {
            }
        }

        static {
            f4599e = new a(null);
        }

        public b(int r10) {
            this.f4600a = new long[r10];
            this.f4601b = new boolean[r10];
            this.f4602c = new int[r10];
        }

        public final int[] a() {
            monitor-enter(this);
        L21:
            th = move-exception;
            throw th;
        L4:
            if (this.f4603d == true) goto L8;
            monitor-exit(this);
            return null;
        L8:
            long[] r10 = this.f4600a;     // Catch: Throwable -> L21
            int r11 = r10.length;     // Catch: Throwable -> L21
            int r12 = 0;
            int r13 = 0;
        L9:
            if (r12 >= r11) goto L25;
            int r14 = r13 + 1;     // Catch: Throwable -> L21
            int r15 = 1;
            if (r10[r12] <= 0) goto L13;
            boolean r16 = true;
        L14:
            boolean[] r17 = this.f4601b;     // Catch: Throwable -> L21
            if (r16 == r17[r13]) goto L23;
            int[] r18 = this.f4602c;     // Catch: Throwable -> L21
            if (r16 == true) goto L20;
            r15 = 2;
        L20:
            r18[r13] = r15;     // Catch: Throwable -> L21
        L24:
            r17[r13] = r16;     // Catch: Throwable -> L21
            r12 = r12 + 1;     // Catch: Throwable -> L21
            r13 = r14;
            goto L9
        L23:
            this.f4602c[r13] = 0;     // Catch: Throwable -> L21
            goto L24
        L13:
            r16 = false;
            goto L14
        L25:
            this.f4603d = false;     // Catch: Throwable -> L21
            int[] r19 = (int[]) this.f4602c.clone();     // Catch: Throwable -> L21
            monitor-exit(this);
            return r19;
        }

        public final boolean b(int... r11) {
            kotlin.jvm.internal.q.g(r11, "tableIds");
            monitor-enter(this);
            int r10 = r11.length;     // Catch: Throwable -> L9
            int r12 = 0;
            boolean r13 = false;
        L5:
            if (r12 >= r10) goto L12;
            int r14 = r11[r12];     // Catch: Throwable -> L9
            long[] r15 = this.f4600a;     // Catch: Throwable -> L9
            long r16 = r15[r14];     // Catch: Throwable -> L9
            r15[r14] = 1 + r16;     // Catch: Throwable -> L9
            if (r16 != 0) goto L11;
            this.f4603d = true;     // Catch: Throwable -> L9
            r13 = true;
        L11:
            r12 = r12 + 1;     // Catch: Throwable -> L9
            goto L5
        L12:
            Unit r17 = Unit.f21064a;     // Catch: Throwable -> L9
            monitor-exit(this);
            return r13;
        L9:
            th = move-exception;
            throw th;
        }

        public final boolean c(int... r13) {
            kotlin.jvm.internal.q.g(r13, "tableIds");
            monitor-enter(this);
            int r10 = r13.length;     // Catch: Throwable -> L9
            int r11 = 0;
            boolean r12 = false;
        L5:
            if (r11 >= r10) goto L12;
            int r14 = r13[r11];     // Catch: Throwable -> L9
            long[] r15 = this.f4600a;     // Catch: Throwable -> L9
            long r16 = r15[r14];     // Catch: Throwable -> L9
            r15[r14] = r16 - 1;     // Catch: Throwable -> L9
            if (r16 != 1) goto L11;
            this.f4603d = true;     // Catch: Throwable -> L9
            r12 = true;
        L11:
            r11 = r11 + 1;     // Catch: Throwable -> L9
            goto L5
        L12:
            Unit r17 = Unit.f21064a;     // Catch: Throwable -> L9
            monitor-exit(this);
            return r12;
        L9:
            th = move-exception;
            throw th;
        }

        public final void d() {
            monitor-enter(this);
            Arrays.fill(this.f4601b, false);     // Catch: Throwable -> L6
            this.f4603d = true;     // Catch: Throwable -> L6
            Unit r10 = Unit.f21064a;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f4604a;

        public c(String[] r10) {
            kotlin.jvm.internal.q.g(r10, "tables");
            this.f4604a = r10;
        }

        public final String[] a() {
            return this.f4604a;
        }

        public boolean b() {
            return false;
        }

        public abstract void c(Set r10);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f4605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f4606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String[] f4607c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set f4608d;

        public d(c r10, int[] r11, String[] r12) {
            kotlin.jvm.internal.q.g(r10, "observer");
            kotlin.jvm.internal.q.g(r11, "tableIds");
            kotlin.jvm.internal.q.g(r12, "tableNames");
            this.f4605a = r10;
            this.f4606b = r11;
            this.f4607c = r12;
            if (r12.length != 0) goto L5;
            boolean r13 = true;
        L6:
            if (r13 == true) goto L8;
            Set r14 = kotlin.collections.q0.d(r12[0]);
        L9:
            this.f4608d = r14;
            if (r11.length != r12.length) goto L13;
            return;
        L13:
            throw new IllegalStateException("Check failed.");
        L8:
            r14 = kotlin.collections.r0.e();
            goto L9
        L5:
            r13 = false;
            goto L6
        }

        public final int[] a() {
            return this.f4606b;
        }

        public final void b(Set r10) {
            kotlin.jvm.internal.q.g(r10, "invalidatedTablesIds");
            int[] r11 = this.f4606b;
            int r12 = r11.length;
            if (r12 == 0) goto L17;
            int r13 = 0;
            if (r12 == 1) goto L14;
            Set r14 = kotlin.collections.q0.b();
            int[] r15 = this.f4606b;
            int r16 = r15.length;
            int r17 = 0;
        L7:
            if (r13 >= r16) goto L12;
            int r18 = r17 + 1;
            if (r10.contains(Integer.valueOf(r15[r13])) == false) goto L11;
            r14.add(this.f4607c[r17]);
        L11:
            r13 = r13 + 1;
            r17 = r18;
            goto L7
        L12:
            Set r19 = kotlin.collections.q0.a(r14);
        L19:
            if (r19.isEmpty() == true) goto L25;
            this.f4605a.c(r19);
            return;
        L25:
            return;
        L14:
            if (r10.contains(Integer.valueOf(r11[0])) == false) goto L16;
            r19 = this.f4608d;
            goto L19
        L16:
            r19 = kotlin.collections.r0.e();
            goto L19
        L17:
            r19 = kotlin.collections.r0.e();
            goto L19
        }

        public final void c(String[] r12) {
            kotlin.jvm.internal.q.g(r12, "tables");
            int r10 = this.f4607c.length;
            if (r10 != 0) goto L5;
            Set r13 = kotlin.collections.r0.e();
        L25:
            if (r13.isEmpty() == true) goto L34;
            this.f4605a.c(r13);
            return;
        L34:
            return;
        L5:
            if (r10 == 1) goto L16;
            Set r11 = kotlin.collections.q0.b();
            int r14 = r12.length;
            int r15 = 0;
        L7:
            if (r15 >= r14) goto L15;
            String r16 = r12[r15];
            String[] r17 = this.f4607c;
            int r18 = r17.length;
            int r19 = 0;
        L9:
            if (r19 >= r18) goto L14;
            String r20 = r17[r19];
            if (kotlin.text.o.p(r20, r16, true) == false) goto L13;
            r11.add(r20);
        L13:
            r19 = r19 + 1;
            goto L9
        L14:
            r15 = r15 + 1;
            goto L7
        L15:
            r13 = kotlin.collections.q0.a(r11);
            goto L25
        L16:
            int r21 = r12.length;
            int r22 = 0;
        L17:
            if (r22 >= r21) goto L22;
            if (kotlin.text.o.p(r12[r22], this.f4607c[0], true) == true) goto L20;
            r22 = r22 + 1;
            goto L17
        L20:
            r13 = this.f4608d;
            goto L25
        L22:
            r13 = kotlin.collections.r0.e();
            goto L25
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m f4609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference f4610c;

        public e(m r10, c r11) {
            kotlin.jvm.internal.q.g(r10, "tracker");
            kotlin.jvm.internal.q.g(r11, "delegate");
            super(r11.a());
            this.f4609b = r10;
            this.f4610c = new WeakReference(r11);
        }

        @Override // androidx.room.m.c
        public void c(Set r10) {
            kotlin.jvm.internal.q.g(r10, "tables");
            c r11 = (c) this.f4610c.get();
            if (r11 != null) goto L5;
            this.f4609b.p(this);
            return;
        L5:
            r11.c(r10);
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f4611a;

        public f(m r10) {
            this.f4611a = r10;
        }

        public final Set a() {
            m r10 = this.f4611a;
            Set r11 = kotlin.collections.q0.b();
            Cursor r12 = RoomDatabase.B(r10.h(), new c0.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null, 2, null);
        L27:
        L6:
            th = move-exception;
            throw th;     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            kotlin.io.b.a(r12, th);
            throw th;
        L4:
            if (r12.moveToNext() == false) goto L8;
            r11.add(Integer.valueOf(r12.getInt(0)));     // Catch: Throwable -> L6
            goto L27
        L8:
            Unit r13 = Unit.f21064a;     // Catch: Throwable -> L6
            kotlin.io.b.a(r12, null);
            Set r14 = kotlin.collections.q0.a(r11);
            if (r14.isEmpty() == false) goto L12;
        L20:
            return r14;
        L12:
            if (this.f4611a.g() == null) goto L19;
            SupportSQLiteStatement r15 = this.f4611a.g();
            if (r15 == null) goto L17;
            r15.executeUpdateDelete();
            goto L20
        L17:
            throw new IllegalArgumentException("Required value was null.");
        L19:
            throw new IllegalStateException("Required value was null.");
        }

        @Override // java.lang.Runnable
        public void run() {
            Lock r10 = this.f4611a.h().l();
            r10.lock();
        L27:
            th = move-exception;
            r10.unlock();
            androidx.room.e r11 = m.b(this.f4611a);
            if (r11 == null) goto L63;
            r11.e();
        L63:
            throw th;
        L29:
            e = move-exception;
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);     // Catch: Throwable -> L27
            Set r12 = kotlin.collections.r0.e();     // Catch: Throwable -> L27
            r10.unlock();
            androidx.room.e r13 = m.b(this.f4611a);
            if (r13 == null) goto L45;
        L26:
            r13.e();
        L45:
            if (r12.isEmpty() == true) goto L59;
            i.b r14 = this.f4611a.i();
            m r15 = this.f4611a;
            monitor-enter(r14);
            Iterator r16 = r15.i().iterator();     // Catch: Throwable -> L52
        L50:
            if (r16.hasNext() == false) goto L54;
            ((d) ((Map.Entry) r16.next()).getValue()).b(r12);     // Catch: Throwable -> L52
            goto L50
        L54:
            Unit r17 = Unit.f21064a;     // Catch: Throwable -> L52
            monitor-exit(r14);
            return;
        L52:
            th = move-exception;
            throw th;
        L59:
            return;
        L31:
            e = move-exception;
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);     // Catch: Throwable -> L27
            r12 = kotlin.collections.r0.e();     // Catch: Throwable -> L27
            r10.unlock();
            r13 = m.b(this.f4611a);
            if (r13 == null) goto L45;
        L4:
            if (this.f4611a.f() == true) goto L10;
            r10.unlock();
            androidx.room.e r18 = m.b(this.f4611a);
            if (r18 == null) goto L70;
            r18.e();
            return;
        L70:
            return;
        L10:
            if (this.f4611a.j().compareAndSet(true, false) == true) goto L16;
            r10.unlock();
            androidx.room.e r19 = m.b(this.f4611a);
            if (r19 == null) goto L71;
            r19.e();
            return;
        L71:
            return;
        L16:
            if (this.f4611a.h().t() == false) goto L21;
            r10.unlock();
            androidx.room.e r20 = m.b(this.f4611a);
            if (r20 == null) goto L72;
            r20.e();
            return;
        L72:
            return;
        L21:
            SupportSQLiteDatabase r21 = this.f4611a.h().n().getWritableDatabase();     // Catch: Throwable -> L27 SQLiteException -> L29 IllegalStateException -> L31
            r21.beginTransactionNonExclusive();     // Catch: Throwable -> L27 SQLiteException -> L29 IllegalStateException -> L31
            r12 = a();     // Catch: Throwable -> L33
            r21.setTransactionSuccessful();     // Catch: Throwable -> L33
            r21.endTransaction();     // Catch: Throwable -> L27 SQLiteException -> L29 IllegalStateException -> L31
            r10.unlock();
            r13 = m.b(this.f4611a);
            if (r13 == null) goto L45;
        L33:
            th = move-exception;
            r21.endTransaction();     // Catch: Throwable -> L27 SQLiteException -> L29 IllegalStateException -> L31
            throw th;     // Catch: Throwable -> L27 SQLiteException -> L29 IllegalStateException -> L31
        }
    }

    static {
        f4581q = new a(null);
        f4582r = new String[]{"UPDATE", "DELETE", "INSERT"};
    }

    public m(RoomDatabase r10, Map r11, Map r12, String... r13) {
        kotlin.jvm.internal.q.g(r10, "database");
        kotlin.jvm.internal.q.g(r11, "shadowTablesMap");
        kotlin.jvm.internal.q.g(r12, "viewTables");
        kotlin.jvm.internal.q.g(r13, "tableNames");
        this.f4583a = r10;
        this.f4584b = r11;
        this.f4585c = r12;
        int r14 = 0;
        this.f4589g = new AtomicBoolean(false);
        this.f4592j = new b(r13.length);
        this.f4593k = new k(r10);
        this.f4594l = new i.b();
        this.f4596n = new Object();
        this.f4597o = new Object();
        this.f4586d = new LinkedHashMap();
        int r15 = r13.length;
        String[] r16 = new String[r15];
    L4:
        if (r14 >= r15) goto L13;
        String r17 = r13[r14];
        Locale r18 = Locale.US;
        kotlin.jvm.internal.q.f(r18, "US");
        String r19 = r17.toLowerCase(r18);
        kotlin.jvm.internal.q.f(r19, "this as java.lang.String).toLowerCase(locale)");
        Integer r20 = Integer.valueOf(r14);
        this.f4586d.put(r19, r20);
        String r21 = (String) this.f4584b.get(r13[r14]);
        if (r21 == null) goto L8;
        kotlin.jvm.internal.q.f(r18, "US");
        String r22 = r21.toLowerCase(r18);
        kotlin.jvm.internal.q.f(r22, "this as java.lang.String).toLowerCase(locale)");
    L9:
        if (r22 == null) goto L12;
        r19 = r22;
    L12:
        r16[r14] = r19;
        r14 = r14 + 1;
        goto L4
    L8:
        r22 = null;
        goto L9
    L13:
        this.f4587e = r16;
        Iterator r23 = this.f4584b.entrySet().iterator();
    L15:
        if (r23.hasNext() == false) goto L19;
        Map.Entry r24 = (Map.Entry) r23.next();
        String r25 = (String) r24.getValue();
        Locale r110 = Locale.US;
        kotlin.jvm.internal.q.f(r110, "US");
        String r26 = r25.toLowerCase(r110);
        kotlin.jvm.internal.q.f(r26, "this as java.lang.String).toLowerCase(locale)");
        if (this.f4586d.containsKey(r26) == false) goto L15;
        String r27 = (String) r24.getKey();
        kotlin.jvm.internal.q.f(r110, "US");
        String r28 = r27.toLowerCase(r110);
        kotlin.jvm.internal.q.f(r28, "this as java.lang.String).toLowerCase(locale)");
        Map r111 = this.f4586d;
        r111.put(r28, kotlin.collections.k0.i(r111, r26));
        goto L15
    L19:
        this.f4598p = new f(this);
    }

    public static /* synthetic */ void a(m r10) {
        r10.n();
    }

    public static final /* synthetic */ androidx.room.e b(m r10) {
        return r10.f4588f;
    }

    public void c(c r10) {
        kotlin.jvm.internal.q.g(r10, "observer");
        String[] r11 = q(r10.a());
        ArrayList r12 = new ArrayList(r11.length);
        int r13 = r11.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L9;
        String r15 = r11[r14];
        Map r16 = this.f4586d;
        Locale r17 = Locale.US;
        kotlin.jvm.internal.q.f(r17, "US");
        String r18 = r15.toLowerCase(r17);
        kotlin.jvm.internal.q.f(r18, "this as java.lang.String).toLowerCase(locale)");
        Integer r19 = (Integer) r16.get(r18);
        if (r19 == null) goto L8;
        r12.add(r19);
        r14 = r14 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("There is no table with name " + r15);
    L9:
        int[] r20 = kotlin.collections.b0.w0(r12);
        d r21 = new d(r10, r20, r11);
        i.b r22 = this.f4594l;
        monitor-enter(r22);
        d r23 = (d) this.f4594l.f(r10, r21);     // Catch: Throwable -> L18
        monitor-exit(r22);
        if (r23 == null) goto L15;
        return;
    L15:
        if (this.f4592j.b(Arrays.copyOf(r20, r20.length)) == false) goto L26;
        v();
        return;
    L26:
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public void d(c r10) {
        kotlin.jvm.internal.q.g(r10, "observer");
        c(new e(this, r10));
    }

    public LiveData e(String[] r10, boolean r11, Callable r12) {
        kotlin.jvm.internal.q.g(r10, "tableNames");
        kotlin.jvm.internal.q.g(r12, "computeFunction");
        return this.f4593k.a(x(r10), r11, r12);
    }

    public final boolean f() {
        if (this.f4583a.z() == true) goto L6;
        return false;
    L6:
        if (this.f4590h == true) goto L9;
        this.f4583a.n().getWritableDatabase();
    L9:
        if (this.f4590h == true) goto L12;
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    L12:
        return true;
    }

    public final SupportSQLiteStatement g() {
        return this.f4591i;
    }

    public final RoomDatabase h() {
        return this.f4583a;
    }

    public final i.b i() {
        return this.f4594l;
    }

    public final AtomicBoolean j() {
        return this.f4589g;
    }

    public final Map k() {
        return this.f4586d;
    }

    public final void l(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, "database");
        Object r11 = this.f4597o;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f4590h == false) goto L11;
        Log.e("ROOM", "Invalidation tracker is initialized twice :/.");     // Catch: Throwable -> L9
        monitor-exit(r11);
        return;
    L11:
        r10.execSQL("PRAGMA temp_store = MEMORY;");     // Catch: Throwable -> L9
        r10.execSQL("PRAGMA recursive_triggers='ON';");     // Catch: Throwable -> L9
        r10.execSQL("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");     // Catch: Throwable -> L9
        w(r10);     // Catch: Throwable -> L9
        this.f4591i = r10.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");     // Catch: Throwable -> L9
        this.f4590h = true;     // Catch: Throwable -> L9
        Unit r12 = Unit.f21064a;     // Catch: Throwable -> L9
        monitor-exit(r11);
    }

    public final void m(String... r10) {
        kotlin.jvm.internal.q.g(r10, "tables");
        i.b r11 = this.f4594l;
        monitor-enter(r11);
        Iterator r12 = this.f4594l.iterator();     // Catch: Throwable -> L10
    L6:
        if (r12.hasNext() == false) goto L12;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L10
        kotlin.jvm.internal.q.f(r13, "(observer, wrapper)");     // Catch: Throwable -> L10
        c r14 = (c) r13.getKey();     // Catch: Throwable -> L10
        d r15 = (d) r13.getValue();     // Catch: Throwable -> L10
        if (r14.b() == true) goto L6;
        r15.c(r10);     // Catch: Throwable -> L10
        goto L6
    L12:
        Unit r16 = Unit.f21064a;     // Catch: Throwable -> L10
        monitor-exit(r11);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void n() {
        Object r10 = this.f4597o;
        monitor-enter(r10);
        this.f4590h = false;     // Catch: Throwable -> L9
        this.f4592j.d();     // Catch: Throwable -> L9
        SupportSQLiteStatement r11 = this.f4591i;     // Catch: Throwable -> L9
        if (r11 == null) goto L11;
        r11.close();     // Catch: Throwable -> L9
        Unit r12 = Unit.f21064a;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void o() {
        if (this.f4589g.compareAndSet(false, true) == false) goto L9;
        androidx.room.e r10 = this.f4588f;
        if (r10 == null) goto L7;
        r10.j();
    L7:
        this.f4583a.o().execute(this.f4598p);
        return;
    }

    public void p(c r10) {
        kotlin.jvm.internal.q.g(r10, "observer");
        i.b r11 = this.f4594l;
        monitor-enter(r11);
        d r12 = (d) this.f4594l.g(r10);     // Catch: Throwable -> L11
        monitor-exit(r11);
        if (r12 == null) goto L16;
        b r13 = this.f4592j;
        int[] r14 = r12.a();
        if (r13.c(Arrays.copyOf(r14, r14.length)) == false) goto L17;
        v();
        return;
    L17:
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final String[] q(String[] r11) {
        Set r10 = kotlin.collections.q0.b();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L10;
        String r14 = r11[r13];
        Map r15 = this.f4585c;
        Locale r16 = Locale.US;
        kotlin.jvm.internal.q.f(r16, "US");
        String r17 = r14.toLowerCase(r16);
        kotlin.jvm.internal.q.f(r17, "this as java.lang.String).toLowerCase(locale)");
        if (r15.containsKey(r17) == false) goto L7;
        Map r18 = this.f4585c;
        kotlin.jvm.internal.q.f(r16, "US");
        String r19 = r14.toLowerCase(r16);
        kotlin.jvm.internal.q.f(r19, "this as java.lang.String).toLowerCase(locale)");
        Object r20 = r18.get(r19);
        kotlin.jvm.internal.q.d(r20);
        r10.addAll((Collection) r20);
    L8:
        r13 = r13 + 1;
        goto L3
    L7:
        r10.add(r14);
        goto L8
    L10:
        return (String[]) kotlin.collections.q0.a(r10).toArray(new String[0]);
    }

    public final void r(androidx.room.e r10) {
        kotlin.jvm.internal.q.g(r10, "autoCloser");
        this.f4588f = r10;
        r10.l(new l(this));
    }

    public final void s(Context r10, String r11, Intent r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "name");
        kotlin.jvm.internal.q.g(r12, "serviceIntent");
        this.f4595m = new p(r10, r11, r12, this, this.f4583a.o());
    }

    public final void t(SupportSQLiteDatabase r10, int r11) {
        r10.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + r11 + ", 0)");
        String r12 = this.f4587e[r11];
        String[] r13 = f4582r;
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        String r16 = r13[r15];
        String r17 = "CREATE TEMP TRIGGER IF NOT EXISTS " + f4581q.b(r12, r16) + " AFTER " + r16 + " ON `" + r12 + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + r11 + " AND invalidated = 0; END";
        kotlin.jvm.internal.q.f(r17, "StringBuilder().apply(builderAction).toString()");
        r10.execSQL(r17);
        r15 = r15 + 1;
        goto L3
    }

    public final void u(SupportSQLiteDatabase r10, int r11) {
        String r12 = this.f4587e[r11];
        String[] r13 = f4582r;
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        String r16 = "DROP TRIGGER IF EXISTS " + f4581q.b(r12, r13[r15]);
        kotlin.jvm.internal.q.f(r16, "StringBuilder().apply(builderAction).toString()");
        r10.execSQL(r16);
        r15 = r15 + 1;
        goto L3
    }

    public final void v() {
        if (this.f4583a.z() == true) goto L5;
        return;
    L5:
        w(this.f4583a.n().getWritableDatabase());
    }

    public final void w(SupportSQLiteDatabase r11) {
        kotlin.jvm.internal.q.g(r11, "database");
        if (r11.inTransaction() == false) goto L52;
        return;
    L52:
        Lock r10 = this.f4583a.l();     // Catch: SQLiteException -> L13 IllegalStateException -> L15
        r10.lock();     // Catch: SQLiteException -> L13 IllegalStateException -> L15
        Object r12 = this.f4596n;     // Catch: Throwable -> L17
        monitor-enter(r12);     // Catch: Throwable -> L17
        int[] r13 = this.f4592j.a();     // Catch: Throwable -> L37
        if (r13 != null) goto L19;
        monitor-exit(r12);     // Catch: Throwable -> L17
        r10.unlock();     // Catch: SQLiteException -> L13 IllegalStateException -> L15
        return;
    L19:
        f4581q.a(r11);     // Catch: Throwable -> L37
        int r14 = r13.length;     // Catch: Throwable -> L28
        int r15 = 0;
        int r16 = 0;
    L21:
        if (r15 >= r14) goto L32;
        int r17 = r13[r15];     // Catch: Throwable -> L28
        int r18 = r16 + 1;     // Catch: Throwable -> L28
        if (r17 != 1) goto L25;
        t(r11, r16);     // Catch: Throwable -> L28
    L31:
        r15 = r15 + 1;     // Catch: Throwable -> L28
        r16 = r18;
        goto L21
    L25:
        if (r17 != 2) goto L31;
        u(r11, r16);     // Catch: Throwable -> L28
        goto L31
    L32:
        r11.setTransactionSuccessful();     // Catch: Throwable -> L28
        r11.endTransaction();     // Catch: Throwable -> L37
        Unit r19 = Unit.f21064a;     // Catch: Throwable -> L37
        monitor-exit(r12);     // Catch: Throwable -> L17
        r10.unlock();     // Catch: SQLiteException -> L13 IllegalStateException -> L15
        return;
    L28:
        th = move-exception;
        r11.endTransaction();     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r10.unlock();     // Catch: SQLiteException -> L13 IllegalStateException -> L15
        throw th;     // Catch: SQLiteException -> L13 IllegalStateException -> L15
    L13:
        e = move-exception;
        Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
        return;
    L15:
        e = move-exception;
        Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
    }

    public final String[] x(String[] r10) {
        String[] r11 = q(r10);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        String r14 = r11[r13];
        Map r15 = this.f4586d;
        Locale r16 = Locale.US;
        kotlin.jvm.internal.q.f(r16, "US");
        String r17 = r14.toLowerCase(r16);
        kotlin.jvm.internal.q.f(r17, "this as java.lang.String).toLowerCase(locale)");
        if (r15.containsKey(r17) == false) goto L8;
        r13 = r13 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException(("There is no table with name " + r14).toString());
    L9:
        return r11;
    }
}
