package androidx.room;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.collections.EmptySet;
import kotlin.collections.builders.SetBuilder;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f2539n = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f2540a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f2541b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f2542c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f2543d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f2544e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f2545f = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f2546g;
    public volatile y1.f h;

    /* renamed from: i, reason: collision with root package name */
    public final b f2547i;

    /* renamed from: j, reason: collision with root package name */
    public final n.b<c, d> f2548j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f2549k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f2550l;

    /* renamed from: m, reason: collision with root package name */
    public final g f2551m;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static String a(String tableName, String triggerType) {
            kotlin.jvm.internal.g.f(tableName, "tableName");
            kotlin.jvm.internal.g.f(triggerType, "triggerType");
            return "`room_table_modification_trigger_" + tableName + '_' + triggerType + '`';
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f2552a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f2553b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f2554c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2555d;

        public b(int i10) {
            this.f2552a = new long[i10];
            this.f2553b = new boolean[i10];
            this.f2554c = new int[i10];
        }

        public final int[] a() {
            synchronized (this) {
                try {
                    if (!this.f2555d) {
                        return null;
                    }
                    long[] jArr = this.f2552a;
                    int length = jArr.length;
                    int i10 = 0;
                    int i11 = 0;
                    while (i10 < length) {
                        int i12 = i11 + 1;
                        int i13 = 1;
                        boolean z = jArr[i10] > 0;
                        boolean[] zArr = this.f2553b;
                        if (z != zArr[i11]) {
                            int[] iArr = this.f2554c;
                            if (!z) {
                                i13 = 2;
                            }
                            iArr[i11] = i13;
                        } else {
                            this.f2554c[i11] = 0;
                        }
                        zArr[i11] = z;
                        i10++;
                        i11 = i12;
                    }
                    this.f2555d = false;
                    return (int[]) this.f2554c.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f2556a;

        public c(String[] tables) {
            kotlin.jvm.internal.g.f(tables, "tables");
            this.f2556a = tables;
        }

        public abstract void a(Set<String> set);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final c f2557a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f2558b;

        /* renamed from: c, reason: collision with root package name */
        public final String[] f2559c;

        /* renamed from: d, reason: collision with root package name */
        public final Set<String> f2560d;

        public d(c cVar, int[] iArr, String[] strArr) {
            this.f2557a = cVar;
            this.f2558b = iArr;
            this.f2559c = strArr;
            this.f2560d = strArr.length == 0 ? EmptySet.f10003a : y.M(strArr[0]);
            if (iArr.length != strArr.length) {
                throw new IllegalStateException("Check failed.");
            }
        }

        public final void a(Set<Integer> invalidatedTablesIds) {
            Set<String> setJ;
            kotlin.jvm.internal.g.f(invalidatedTablesIds, "invalidatedTablesIds");
            int[] iArr = this.f2558b;
            int length = iArr.length;
            if (length != 0) {
                int i10 = 0;
                if (length != 1) {
                    SetBuilder setBuilder = new SetBuilder();
                    int length2 = iArr.length;
                    int i11 = 0;
                    while (i10 < length2) {
                        int i12 = i11 + 1;
                        if (invalidatedTablesIds.contains(Integer.valueOf(iArr[i10]))) {
                            setBuilder.add(this.f2559c[i11]);
                        }
                        i10++;
                        i11 = i12;
                    }
                    setJ = y.j(setBuilder);
                } else {
                    setJ = invalidatedTablesIds.contains(Integer.valueOf(iArr[0])) ? this.f2560d : EmptySet.f10003a;
                }
            } else {
                setJ = EmptySet.f10003a;
            }
            if (setJ.isEmpty()) {
                return;
            }
            this.f2557a.a(setJ);
        }

        public final void b(String[] strArr) {
            Set<String> setJ;
            String[] strArr2 = this.f2559c;
            int length = strArr2.length;
            if (length == 0) {
                setJ = EmptySet.f10003a;
            } else if (length == 1) {
                int length2 = strArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length2) {
                        setJ = EmptySet.f10003a;
                        break;
                    } else {
                        if (gc.o.f0(strArr[i10], strArr2[0])) {
                            setJ = this.f2560d;
                            break;
                        }
                        i10++;
                    }
                }
            } else {
                SetBuilder setBuilder = new SetBuilder();
                for (String str : strArr) {
                    for (String str2 : strArr2) {
                        if (gc.o.f0(str2, str)) {
                            setBuilder.add(str2);
                        }
                    }
                }
                setJ = y.j(setBuilder);
            }
            if (setJ.isEmpty()) {
                return;
            }
            this.f2557a.a(setJ);
        }
    }

    public f(RoomDatabase roomDatabase, HashMap map, HashMap map2, String... strArr) {
        String lowerCase;
        this.f2540a = roomDatabase;
        this.f2541b = map;
        this.f2542c = map2;
        this.f2547i = new b(strArr.length);
        kotlin.jvm.internal.g.e(Collections.newSetFromMap(new IdentityHashMap()), "newSetFromMap(IdentityHashMap())");
        this.f2548j = new n.b<>();
        this.f2549k = new Object();
        this.f2550l = new Object();
        this.f2543d = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            Locale US = Locale.US;
            kotlin.jvm.internal.g.e(US, "US");
            String lowerCase2 = str.toLowerCase(US);
            kotlin.jvm.internal.g.e(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.f2543d.put(lowerCase2, Integer.valueOf(i10));
            String str2 = (String) this.f2541b.get(strArr[i10]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(US);
                kotlin.jvm.internal.g.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i10] = lowerCase2;
        }
        this.f2544e = strArr2;
        for (Map.Entry entry : this.f2541b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale US2 = Locale.US;
            kotlin.jvm.internal.g.e(US2, "US");
            String lowerCase3 = str3.toLowerCase(US2);
            kotlin.jvm.internal.g.e(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.f2543d.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(US2);
                kotlin.jvm.internal.g.e(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                LinkedHashMap linkedHashMap = this.f2543d;
                linkedHashMap.put(lowerCase4, kotlin.collections.b.e0(lowerCase3, linkedHashMap));
            }
        }
        this.f2551m = new g(this);
    }

    public final boolean a() {
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = this.f2540a.f2491a;
        if (frameworkSQLiteDatabase == null || !frameworkSQLiteDatabase.f2630a.isOpen()) {
            return false;
        }
        if (!this.f2546g) {
            this.f2540a.h().n0();
        }
        if (this.f2546g) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    @SuppressLint({"RestrictedApi"})
    public final void b(c cVar) {
        d dVarB;
        boolean z;
        RoomDatabase roomDatabase;
        FrameworkSQLiteDatabase frameworkSQLiteDatabase;
        synchronized (this.f2548j) {
            dVarB = this.f2548j.b(cVar);
        }
        if (dVarB != null) {
            b bVar = this.f2547i;
            int[] iArr = dVarB.f2558b;
            int[] tableIds = Arrays.copyOf(iArr, iArr.length);
            bVar.getClass();
            kotlin.jvm.internal.g.f(tableIds, "tableIds");
            synchronized (bVar) {
                try {
                    z = false;
                    for (int i10 : tableIds) {
                        long[] jArr = bVar.f2552a;
                        long j10 = jArr[i10];
                        jArr[i10] = j10 - 1;
                        if (j10 == 1) {
                            bVar.f2555d = true;
                            z = true;
                        }
                    }
                    lb.n nVar = lb.n.f10413a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z && (frameworkSQLiteDatabase = (roomDatabase = this.f2540a).f2491a) != null && frameworkSQLiteDatabase.f2630a.isOpen()) {
                d(roomDatabase.h().n0());
            }
        }
    }

    public final void c(y1.b bVar, int i10) {
        bVar.n("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i10 + ", 0)");
        String str = this.f2544e[i10];
        for (int i11 = 0; i11 < 3; i11++) {
            String str2 = f2539n[i11];
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + a.a(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i10 + " AND invalidated = 0; END";
            kotlin.jvm.internal.g.e(str3, "StringBuilder().apply(builderAction).toString()");
            bVar.n(str3);
        }
    }

    public final void d(y1.b database) {
        kotlin.jvm.internal.g.f(database, "database");
        if (database.w0()) {
            return;
        }
        try {
            ReentrantReadWriteLock.ReadLock lock = this.f2540a.h.readLock();
            kotlin.jvm.internal.g.e(lock, "readWriteLock.readLock()");
            lock.lock();
            try {
                synchronized (this.f2549k) {
                    int[] iArrA = this.f2547i.a();
                    if (iArrA != null) {
                        if (database.A0()) {
                            database.A();
                        } else {
                            database.l();
                        }
                        try {
                            int length = iArrA.length;
                            int i10 = 0;
                            int i11 = 0;
                            while (i10 < length) {
                                int i12 = iArrA[i10];
                                int i13 = i11 + 1;
                                if (i12 == 1) {
                                    c(database, i11);
                                } else if (i12 == 2) {
                                    String str = this.f2544e[i11];
                                    String[] strArr = f2539n;
                                    for (int i14 = 0; i14 < 3; i14++) {
                                        String str2 = "DROP TRIGGER IF EXISTS " + a.a(str, strArr[i14]);
                                        kotlin.jvm.internal.g.e(str2, "StringBuilder().apply(builderAction).toString()");
                                        database.n(str2);
                                    }
                                }
                                i10++;
                                i11 = i13;
                            }
                            database.y();
                            database.H();
                            lb.n nVar = lb.n.f10413a;
                        } catch (Throwable th) {
                            database.H();
                            throw th;
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        } catch (SQLiteException e10) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
        } catch (IllegalStateException e11) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e11);
        }
    }
}
