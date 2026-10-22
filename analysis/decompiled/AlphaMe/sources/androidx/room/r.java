package androidx.room;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.baidu.mapapi.http.wrapper.HttpManager;
import h.RunnableC0583a;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import k0.InterfaceC0674b;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f4229n = {"UPDATE", HttpManager.HTTP_DELETE, "INSERT"};

    /* renamed from: a, reason: collision with root package name */
    public final A f4230a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f4231b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f4232c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f4233d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f4234e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f4235f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f4236g;

    /* renamed from: h, reason: collision with root package name */
    public volatile k0.j f4237h;

    /* renamed from: i, reason: collision with root package name */
    public final p f4238i;

    /* renamed from: j, reason: collision with root package name */
    public final m.g f4239j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f4240k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f4241l;

    /* renamed from: m, reason: collision with root package name */
    public final RunnableC0583a f4242m;

    public r(A database, HashMap shadowTablesMap, HashMap viewTables, String... tableNames) {
        String lowerCase;
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(shadowTablesMap, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(viewTables, "viewTables");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        this.f4230a = database;
        this.f4231b = shadowTablesMap;
        this.f4235f = new AtomicBoolean(false);
        this.f4238i = new p(tableNames.length);
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullExpressionValue(Collections.newSetFromMap(new IdentityHashMap()), "newSetFromMap(IdentityHashMap())");
        this.f4239j = new m.g();
        this.f4240k = new Object();
        this.f4241l = new Object();
        this.f4233d = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i4 = 0; i4 < length; i4++) {
            String str = tableNames[i4];
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase2 = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.f4233d.put(lowerCase2, Integer.valueOf(i4));
            String str2 = (String) this.f4231b.get(tableNames[i4]);
            if (str2 != null) {
                Intrinsics.checkNotNullExpressionValue(US, "US");
                lowerCase = str2.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr[i4] = lowerCase2;
        }
        this.f4234e = strArr;
        for (Map.Entry entry : this.f4231b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale US2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US2, "US");
            String lowerCase3 = str3.toLowerCase(US2);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.f4233d.containsKey(lowerCase3)) {
                String str4 = (String) entry.getKey();
                Intrinsics.checkNotNullExpressionValue(US2, "US");
                String lowerCase4 = str4.toLowerCase(US2);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                LinkedHashMap linkedHashMap = this.f4233d;
                linkedHashMap.put(lowerCase4, MapsKt__MapsKt.getValue(linkedHashMap, lowerCase3));
            }
        }
        this.f4242m = new RunnableC0583a(6, this);
    }

    public final boolean a() {
        if (!this.f4230a.isOpenInternal()) {
            return false;
        }
        if (!this.f4236g) {
            this.f4230a.getOpenHelper().getWritableDatabase();
        }
        if (this.f4236g) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final void b(InterfaceC0674b interfaceC0674b, int i4) {
        interfaceC0674b.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i4 + ", 0)");
        String str = this.f4234e[i4];
        String[] strArr = f4229n;
        for (int i5 = 0; i5 < 3; i5++) {
            String str2 = strArr[i5];
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + E3.b.h(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i4 + " AND invalidated = 0; END";
            Intrinsics.checkNotNullExpressionValue(str3, "StringBuilder().apply(builderAction).toString()");
            interfaceC0674b.execSQL(str3);
        }
    }

    public final void c() {
    }

    public final void d(InterfaceC0674b database) {
        Intrinsics.checkNotNullParameter(database, "database");
        if (database.inTransaction()) {
            return;
        }
        try {
            Lock closeLock$room_runtime_release = this.f4230a.getCloseLock$room_runtime_release();
            closeLock$room_runtime_release.lock();
            try {
                synchronized (this.f4240k) {
                    int[] iArrA = this.f4238i.a();
                    if (iArrA == null) {
                        return;
                    }
                    Intrinsics.checkNotNullParameter(database, "database");
                    if (database.isWriteAheadLoggingEnabled()) {
                        database.beginTransactionNonExclusive();
                    } else {
                        database.beginTransaction();
                    }
                    try {
                        int length = iArrA.length;
                        int i4 = 0;
                        int i5 = 0;
                        while (i4 < length) {
                            int i6 = iArrA[i4];
                            int i7 = i5 + 1;
                            if (i6 == 1) {
                                b(database, i5);
                            } else if (i6 == 2) {
                                String str = this.f4234e[i5];
                                String[] strArr = f4229n;
                                for (int i8 = 0; i8 < 3; i8++) {
                                    String str2 = "DROP TRIGGER IF EXISTS " + E3.b.h(str, strArr[i8]);
                                    Intrinsics.checkNotNullExpressionValue(str2, "StringBuilder().apply(builderAction).toString()");
                                    database.execSQL(str2);
                                }
                            }
                            i4++;
                            i5 = i7;
                        }
                        database.setTransactionSuccessful();
                        database.endTransaction();
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        database.endTransaction();
                        throw th;
                    }
                }
            } finally {
                closeLock$room_runtime_release.unlock();
            }
        } catch (SQLiteException e4) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e4);
        } catch (IllegalStateException e5) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e5);
        }
    }
}
