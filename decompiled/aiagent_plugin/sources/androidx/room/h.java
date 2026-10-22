package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: InvalidationTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    private static final String[] i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final HashMap<String, Integer> f2630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String[] f2631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    androidx.room.a f2632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final p f2633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    AtomicBoolean f2634e;
    volatile androidx.sqlite.db.g f;
    final androidx.a.a.b.b<b, c> g;
    Runnable h;
    private Map<String, Set<String>> j;
    private volatile boolean k;
    private final a l;
    private final g m;
    private i n;
    private final Object o;

    /* JADX INFO: compiled from: InvalidationTracker.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long[] f2636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean[] f2637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int[] f2638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f2639d;

        a(int r3) {
            long[] r0 = new long[r3];
            this.f2636a = r0;
            boolean[] r1 = new boolean[r3];
            this.f2637b = r1;
            this.f2638c = new int[r3];
            Arrays.fill(r0, 0);
            Arrays.fill(r1, false);
        }

        boolean a(int... r10) {
            monitor-enter(this);
            int r0 = r10.length;     // Catch: Throwable -> L11
            int r1 = 0;
            boolean r2 = false;
        L4:
            if (r1 >= r0) goto L9;
            int r3 = r10[r1];     // Catch: Throwable -> L11
            long[] r4 = this.f2636a;     // Catch: Throwable -> L11
            long r5 = r4[r3];     // Catch: Throwable -> L11
            r4[r3] = 1 + r5;     // Catch: Throwable -> L11
            if (r5 != 0) goto L8;
            this.f2639d = true;     // Catch: Throwable -> L11
            r2 = true;
        L8:
            r1 = r1 + 1;     // Catch: Throwable -> L11
            goto L4
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
            return r2;
        L11:
            th = move-exception;
            throw th;
        }

        boolean b(int... r12) {
            monitor-enter(this);
            int r0 = r12.length;     // Catch: Throwable -> L11
            int r1 = 0;
            boolean r2 = false;
        L4:
            if (r1 >= r0) goto L9;
            int r3 = r12[r1];     // Catch: Throwable -> L11
            long[] r4 = this.f2636a;     // Catch: Throwable -> L11
            long r5 = r4[r3];     // Catch: Throwable -> L11
            r4[r3] = r5 - 1;     // Catch: Throwable -> L11
            if (r5 != 1) goto L8;
            this.f2639d = true;     // Catch: Throwable -> L11
            r2 = true;
        L8:
            r1 = r1 + 1;     // Catch: Throwable -> L11
            goto L4
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
            return r2;
        L11:
            th = move-exception;
            throw th;
        }

        void a() {
            monitor-enter(this);
            Arrays.fill(this.f2637b, false);     // Catch: Throwable -> L6
            this.f2639d = true;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        int[] b() {
            monitor-enter(this);
        L26:
            th = move-exception;
            throw th;
        L4:
            if (this.f2639d == false) goto L6;
            int r0 = this.f2636a.length;     // Catch: Throwable -> L26
            int r2 = 0;
        L9:
            if (r2 >= r0) goto L23;
            int r4 = 1;
            if (this.f2636a[r2] <= 0) goto L13;
            boolean r3 = true;
        L14:
            boolean[] r5 = this.f2637b;     // Catch: Throwable -> L26
            if (r3 == r5[r2]) goto L21;
            int[] r6 = this.f2638c;     // Catch: Throwable -> L26
            if (r3 == true) goto L20;
            r4 = 2;
        L20:
            r6[r2] = r4;     // Catch: Throwable -> L26
        L22:
            r5[r2] = r3;     // Catch: Throwable -> L26
            r2 = r2 + 1;     // Catch: Throwable -> L26
            goto L9
        L21:
            this.f2638c[r2] = 0;     // Catch: Throwable -> L26
            goto L22
        L13:
            r3 = false;
            goto L14
        L23:
            this.f2639d = false;     // Catch: Throwable -> L26
            int[] r1 = (int[]) ZeusTransformUtils.preCheckCast(this.f2638c.clone(), int[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
            monitor-exit(this);     // Catch: Throwable -> L26
            return r1;
        L6:
            monitor-exit(this);     // Catch: Throwable -> L26
            return null;
        }
    }

    /* JADX INFO: compiled from: InvalidationTracker.java */
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String[] f2640a;

        public abstract void a(Set<String> r1);

        boolean a() {
            return false;
        }

        public b(String[] r3) {
            this.f2640a = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), String[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: InvalidationTracker.java */
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f2641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b f2642b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String[] f2643c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Set<String> f2644d;

        c(b r1, int[] r2, String[] r3) {
            this.f2642b = r1;
            this.f2641a = r2;
            this.f2643c = r3;
            if (r2.length != 1) goto L5;
            HashSet r4 = new HashSet();
            r4.add(r3[0]);
            this.f2644d = Collections.unmodifiableSet(r4);
            return;
        L5:
            this.f2644d = null;
        }

        void a(Set<Integer> r5) {
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
            int r0 = this.f2641a.length;
            Set<String> r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L13;
            if (r6.contains(Integer.valueOf(this.f2641a[r2])) == false) goto L12;
            if (r0 != 1) goto L9;
            r1 = this.f2644d;
            goto L12
        L9:
            if (r1 != null) goto L11;
            r1 = new HashSet(r0);
        L11:
            r1.add(this.f2643c[r2]);
        L12:
            r2 = r2 + 1;
            goto L3
        L13:
            if (r1 == null) goto L20;
            this.f2642b.a(r1);
            return;
        }

        void a(String[] r12) {
            Set<String> r3 = null;
            if (this.f2643c.length != 1) goto L10;
            int r0 = r12.length;
            int r2 = 0;
        L5:
            if (r2 >= r0) goto L22;
            if (r12[r2].equalsIgnoreCase(this.f2643c[0]) == true) goto L8;
            r2 = r2 + 1;
            goto L5
        L8:
            r3 = this.f2644d;
        L22:
            if (r3 == null) goto L31;
            this.f2642b.a(r3);
            return;
        L31:
            return;
        L10:
            HashSet r1 = new HashSet();
            int r4 = r12.length;
            int r5 = 0;
        L11:
            if (r5 >= r4) goto L20;
            String r6 = r12[r5];
            String[] r7 = this.f2643c;
            int r8 = r7.length;
            int r9 = 0;
        L13:
            if (r9 >= r8) goto L18;
            String r10 = r7[r9];
            if (r10.equalsIgnoreCase(r6) == true) goto L16;
            r9 = r9 + 1;
            goto L13
        L16:
            r1.add(r10);
        L18:
            r5 = r5 + 1;
            goto L11
        L20:
            if (r1.size() <= 0) goto L22;
            r3 = r1;
            goto L22
        }
    }

    static {
        i = new String[]{"UPDATE", "DELETE", "INSERT"};
    }

    public h(p r5, Map<String, String> r6, Map<String, Set<String>> r7, String... r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Map<String, Set<String>> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        this.f2632c = null;
        int r2 = 0;
        this.f2634e = new AtomicBoolean(false);
        this.k = false;
        this.g = new androidx.a.a.b.b();
        this.o = new Object();
        this.h = new AnonymousClass1(this);
        this.f2633d = r5;
        this.l = new a(r8.length);
        this.f2630a = new HashMap();
        this.j = r10;
        this.m = new g(r5);
        int r11 = r8.length;
        this.f2631b = new String[r11];
    L3:
        if (r2 >= r11) goto L9;
        String r12 = r8[r2].toLowerCase(Locale.US);
        this.f2630a.put(r12, Integer.valueOf(r2));
        String r0 = (String) ZeusTransformUtils.preCheckCast(r9.get(r8[r2]), String.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        this.f2631b[r2] = r0.toLowerCase(Locale.US);
    L8:
        r2 = r2 + 1;
        goto L3
    L7:
        this.f2631b[r2] = r12;
        goto L8
    L9:
        Iterator r13 = r9.entrySet().iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r15 = ((String) ZeusTransformUtils.preCheckCast(r14.getValue(), String.class, "com.obric.aiagent.plugin")).toLowerCase(Locale.US);
        if (this.f2630a.containsKey(r15) == false) goto L11;
        String r16 = ((String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.aiagent.plugin")).toLowerCase(Locale.US);
        HashMap<String, Integer> r17 = this.f2630a;
        r17.put(r16, (Integer) ZeusTransformUtils.preCheckCast(r17.get(r15), Integer.class, "com.obric.aiagent.plugin"));
        goto L11
    }

    void a(androidx.room.a r2) {
        this.f2632c = r2;
        r2.a(new $$Lambda$46buq0sc7b1dKplCpNtxiWvVkvg(this));
    }

    void a(androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.k == false) goto L9;
        a("ROOM", "Invalidation tracker is initialized twice :/.");     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L9:
        r4.b("PRAGMA temp_store = MEMORY;");     // Catch: Throwable -> L12
        r4.b("PRAGMA recursive_triggers='ON';");     // Catch: Throwable -> L12
        r4.b("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");     // Catch: Throwable -> L12
        b(r4);     // Catch: Throwable -> L12
        this.f = r4.a("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");     // Catch: Throwable -> L12
        this.k = true;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    }

    void a() {
        monitor-enter(this);
        this.k = false;     // Catch: Throwable -> L7
        this.l.a();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void a(Context r7, String r8, Intent r9) {
        this.n = new i((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), r8, r9, this, this.f2633d.l());
    }

    void b() {
        i r0 = this.n;
        if (r0 == null) goto L6;
        r0.a();
        this.n = null;
        return;
    }

    private static void a(StringBuilder r2, String r3, String r4) {
        r2.append("`").append("room_table_modification_trigger_").append(r3).append("_").append(r4).append("`");
    }

    private void a(androidx.sqlite.db.c r7, int r8) {
        androidx.sqlite.db.c r9 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r7, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        String r6 = this.f2631b[r8];
        StringBuilder r10 = new StringBuilder();
        String[] r0 = i;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        String r4 = r0[r3];
        r10.setLength(0);
        r10.append("DROP TRIGGER IF EXISTS ");
        a(r10, r6, r4);
        r9.b(r10.toString());
        r3 = r3 + 1;
        goto L3
    }

    private void b(androidx.sqlite.db.c r9, int r10) {
        androidx.sqlite.db.c r11 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r9, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        r11.b("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + r10 + ", 0)");
        String r8 = this.f2631b[r10];
        StringBuilder r0 = new StringBuilder();
        String[] r1 = i;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        String r5 = r1[r4];
        r0.setLength(0);
        r0.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
        a(r0, r8, r5);
        r0.append(" AFTER ").append(r5).append(" ON `").append(r8).append("` BEGIN UPDATE ").append("room_table_modification_log").append(" SET ").append("invalidated").append(" = 1").append(" WHERE ").append("table_id").append(" = ").append(r10).append(" AND ").append("invalidated").append(" = 0").append("; END");
        r11.b(r0.toString());
        r4 = r4 + 1;
        goto L3
    }

    public void a(b r8) {
        String[] r0 = b(r8.f2640a);
        int[] r1 = new int[r0.length];
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L9;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(this.f2630a.get(r0[r3].toLowerCase(Locale.US)), Integer.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L8;
        r1[r3] = r4.intValue();
        r3 = r3 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("There is no table with name " + r0[r3]);
    L9:
        c r5 = new c(r8, r1, r0);
        androidx.a.a.b.b<b, c> r6 = this.g;
        monitor-enter(r6);
        c r9 = (c) ZeusTransformUtils.preCheckCast(this.g.a(r8, r5), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        monitor-exit(r6);     // Catch: Throwable -> L18
        if (r9 == null) goto L15;
        return;
    L15:
        if (this.l.a(r1) == false) goto L26;
        e();
        return;
    L26:
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private String[] b(String[] r8) {
        HashSet r0 = new HashSet();
        int r1 = r8.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L11;
        String r4 = r8[r2];
        String r5 = r4.toLowerCase(Locale.US);
        if (this.j.containsKey(r5) == false) goto L8;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(this.j.get(r5), Collection.class, "com.obric.aiagent.plugin"));
    L9:
        r2 = r2 + 1;
        goto L4
    L8:
        r0.add(r4);
        goto L9
    L11:
        return (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[r0.size()]), String[].class, "com.obric.aiagent.plugin");
    }

    private static void c(androidx.sqlite.db.c r2) {
        androidx.sqlite.db.c r3 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 16) goto L5;
    L7:
        r3.b();
        return;
    L5:
        if (r3.i() == false) goto L7;
        r3.c();
    }

    public void b(b r4) {
        androidx.a.a.b.b<b, c> r0 = this.g;
        monitor-enter(r0);
        c r5 = (c) ZeusTransformUtils.preCheckCast(this.g.b(r4), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if (r5 != null) goto L8;
        return;
    L8:
        if (this.l.b(r5.f2641a) == false) goto L17;
        e();
        return;
    L17:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    boolean c() {
        if (this.f2633d.f() == true) goto L6;
        return false;
    L6:
        if (this.k == true) goto L9;
        this.f2633d.b().b();
    L9:
        if (this.k == true) goto L12;
        a("ROOM", "database is not initialized even though it is open");
        return false;
    L12:
        return true;
    }

    public void d() {
        if (this.f2634e.compareAndSet(false, true) == false) goto L9;
        androidx.room.a r0 = this.f2632c;
        if (r0 == null) goto L7;
        r0.a();
    L7:
        this.f2633d.l().execute(this.h);
        return;
    }

    public void a(String... r6) {
        androidx.a.a.b.b<b, c> r0 = this.g;
        monitor-enter(r0);
        Iterator<Map.Entry<b, c>> r5 = this.g.iterator();     // Catch: Throwable -> L12
    L6:
        if (r5.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (((b) ZeusTransformUtils.preCheckCast(r1.getKey(), b.class, "com.obric.aiagent.plugin")).a() == true) goto L6;
        ((c) ZeusTransformUtils.preCheckCast(r1.getValue(), c.class, "com.obric.aiagent.plugin")).a(r6);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void b(androidx.sqlite.db.c r8) {
        androidx.sqlite.db.c r9 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r8, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        if (r9.f() == false) goto L43;
        return;
    L43:
        Lock r0 = this.f2633d.a();     // Catch: Throwable -> L38
        r0.lock();     // Catch: Throwable -> L38
        Object r1 = this.o;     // Catch: Throwable -> L35
        monitor-enter(r1);     // Catch: Throwable -> L35
        int[] r2 = this.l.b();     // Catch: Throwable -> L32
        if (r2 != null) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L32
        r0.unlock();     // Catch: Throwable -> L38 Throwable -> L38
        return;
    L13:
        int r3 = r2.length;     // Catch: Throwable -> L32
        c(r9);     // Catch: Throwable -> L32
        int r4 = 0;
    L15:
        if (r4 >= r3) goto L24;
        int r5 = r2[r4];     // Catch: Throwable -> L29
        if (r5 != 1) goto L19;
        b(r9, r4);     // Catch: Throwable -> L29
    L23:
        r4 = r4 + 1;     // Catch: Throwable -> L29
        goto L15
    L19:
        if (r5 != 2) goto L23;
        a(r9, r4);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r9.d();     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L24:
        r9.e();     // Catch: Throwable -> L29
        r9.d();     // Catch: Throwable -> L32
        monitor-exit(r1);     // Catch: Throwable -> L32
        r0.unlock();     // Catch: Throwable -> L38 Throwable -> L38
        return;
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        r0.unlock();     // Catch: Throwable -> L38 Throwable -> L38
        throw th;     // Catch: Throwable -> L38 Throwable -> L38
    L38:
        e = move-exception;
        a("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
    }

    void e() {
        if (this.f2633d.f() == true) goto L5;
        return;
    L5:
        b(this.f2633d.b().b());
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
