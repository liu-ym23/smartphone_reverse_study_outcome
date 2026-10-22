package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.apm.constant.CommonKey;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f4500i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final TreeMap f4501j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f4503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f4504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double[] f4505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f4506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[][] f4507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f4508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4509h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/room/RoomSQLiteQuery$Binding;", "", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Binding {
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final RoomSQLiteQuery a(String r10, int r11) {
            kotlin.jvm.internal.q.g(r10, "query");
            TreeMap r12 = RoomSQLiteQuery.f4501j;
            monitor-enter(r12);
            Map.Entry r13 = r12.ceilingEntry(Integer.valueOf(r11));     // Catch: Throwable -> L9
            if (r13 == null) goto L11;
            r12.remove(r13.getKey());     // Catch: Throwable -> L9
            RoomSQLiteQuery r14 = (RoomSQLiteQuery) r13.getValue();     // Catch: Throwable -> L9
            r14.b(r10, r11);     // Catch: Throwable -> L9
            kotlin.jvm.internal.q.f(r14, "sqliteQuery");     // Catch: Throwable -> L9
            monitor-exit(r12);
            return r14;
        L11:
            Unit r15 = Unit.f21064a;     // Catch: Throwable -> L9
            monitor-exit(r12);
            RoomSQLiteQuery r16 = new RoomSQLiteQuery(r11, null);
            r16.b(r10, r11);
            return r16;
        L9:
            th = move-exception;
            throw th;
        }

        public final void b() {
            TreeMap r10 = RoomSQLiteQuery.f4501j;
            if (r10.size() <= 15) goto L8;
            int r11 = r10.size() - 10;
            Iterator r12 = r10.descendingKeySet().iterator();
            kotlin.jvm.internal.q.f(r12, "queryPool.descendingKeySet().iterator()");
        L5:
            int r13 = r11 - 1;
            if (r11 <= 0) goto L10;
            r12.next();
            r12.remove();
            r11 = r13;
            goto L5
        L10:
            return;
        }

        public a() {
        }
    }

    static {
        f4500i = new a(null);
        f4501j = new TreeMap();
    }

    public /* synthetic */ RoomSQLiteQuery(int r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    public static final RoomSQLiteQuery a(String r10, int r11) {
        return f4500i.a(r10, r11);
    }

    public final void b(String r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "query");
        this.f4503b = r10;
        this.f4509h = r11;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r10, byte[] r11) {
        kotlin.jvm.internal.q.g(r11, CommonKey.KEY_VALUE);
        this.f4508g[r10] = 5;
        this.f4507f[r10] = r11;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r10, double r11) {
        this.f4508g[r10] = 3;
        this.f4505d[r10] = r11;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r10, long r11) {
        this.f4508g[r10] = 2;
        this.f4504c[r10] = r11;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r10) {
        this.f4508g[r10] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r10, String r11) {
        kotlin.jvm.internal.q.g(r11, CommonKey.KEY_VALUE);
        this.f4508g[r10] = 4;
        this.f4506e[r10] = r11;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram r10) {
        kotlin.jvm.internal.q.g(r10, "statement");
        int r11 = getArgCount();
        if (1 > r11) goto L31;
        int r12 = 1;
    L5:
        int r13 = this.f4508g[r12];
        if (r13 != 1) goto L8;
        r10.bindNull(r12);
    L29:
        if (r12 == r11) goto L35;
        r12 = r12 + 1;
        goto L5
    L35:
        return;
    L8:
        if (r13 != 2) goto L10;
        r10.bindLong(r12, this.f4504c[r12]);
        goto L29
    L10:
        if (r13 != 3) goto L12;
        r10.bindDouble(r12, this.f4505d[r12]);
        goto L29
    L12:
        if (r13 != 4) goto L14;
        String r14 = this.f4506e[r12];
        if (r14 == null) goto L25;
        r10.bindString(r12, r14);
        goto L29
    L25:
        throw new IllegalArgumentException("Required value was null.");
    L14:
        if (r13 != 5) goto L29;
        byte[] r15 = this.f4507f[r12];
        if (r15 == null) goto L20;
        r10.bindBlob(r12, r15);
        goto L29
    L20:
        throw new IllegalArgumentException("Required value was null.");
    }

    public final void c() {
        TreeMap r10 = f4501j;
        monitor-enter(r10);
        r10.put(Integer.valueOf(this.f4502a), this);     // Catch: Throwable -> L7
        f4500i.b();     // Catch: Throwable -> L7
        Unit r11 = Unit.f21064a;     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Arrays.fill(this.f4508g, 1);
        Arrays.fill(this.f4506e, null);
        Arrays.fill(this.f4507f, null);
        this.f4503b = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.f4509h;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        String r10 = this.f4503b;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Required value was null.");
    }

    public RoomSQLiteQuery(int r10) {
        this.f4502a = r10;
        int r11 = r10 + 1;
        this.f4508g = new int[r11];
        this.f4504c = new long[r11];
        this.f4505d = new double[r11];
        this.f4506e = new String[r11];
        this.f4507f = new byte[r11][];
    }
}
