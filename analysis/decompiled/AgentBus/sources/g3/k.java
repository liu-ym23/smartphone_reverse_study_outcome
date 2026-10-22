package g3;

import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import b0.x0;
import com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl;
import d7.e0;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f3810m = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a, reason: collision with root package name */
    public final OfflineQueueDatabase_Impl f3811a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3812b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f3813c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f3814d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f3815e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f3816f;

    /* renamed from: g, reason: collision with root package name */
    public volatile n3.j f3817g;

    /* renamed from: h, reason: collision with root package name */
    public final x0 f3818h;

    /* renamed from: i, reason: collision with root package name */
    public final j.f f3819i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f3820j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f3821k;

    /* renamed from: l, reason: collision with root package name */
    public final db.d f3822l;

    public k(OfflineQueueDatabase_Impl offlineQueueDatabase_Impl, HashMap map, HashMap map2, String... strArr) {
        String lowerCase;
        this.f3811a = offlineQueueDatabase_Impl;
        this.f3812b = map;
        this.f3818h = new x0(strArr.length);
        q7.k.d(Collections.newSetFromMap(new IdentityHashMap()), "newSetFromMap(IdentityHashMap())");
        this.f3819i = new j.f();
        this.f3820j = new Object();
        this.f3821k = new Object();
        this.f3813c = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            Locale locale = Locale.US;
            q7.k.d(locale, "US");
            String lowerCase2 = str.toLowerCase(locale);
            q7.k.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.f3813c.put(lowerCase2, Integer.valueOf(i2));
            String str2 = (String) this.f3812b.get(strArr[i2]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                q7.k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i2] = lowerCase2;
        }
        this.f3814d = strArr2;
        for (Map.Entry entry : this.f3812b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            q7.k.d(locale2, "US");
            String lowerCase3 = str3.toLowerCase(locale2);
            q7.k.d(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.f3813c.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                q7.k.d(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                LinkedHashMap linkedHashMap = this.f3813c;
                linkedHashMap.put(lowerCase4, e0.Q(lowerCase3, linkedHashMap));
            }
        }
        this.f3822l = new db.d(1, this);
    }

    public final boolean a() {
        if (!this.f3811a.l()) {
            return false;
        }
        if (!this.f3816f) {
            this.f3811a.h().N();
        }
        if (this.f3816f) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final void b(d dVar) {
        synchronized (this.f3819i) {
        }
    }

    public final void c(n3.c cVar, int i2) throws SQLException {
        cVar.g("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i2 + ", 0)");
        String str = this.f3814d[i2];
        for (int i10 = 0; i10 < 3; i10++) {
            String str2 = f3810m[i10];
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + d.c(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i2 + " AND invalidated = 0; END";
            q7.k.d(str3, "StringBuilder().apply(builderAction).toString()");
            cVar.g(str3);
        }
    }

    public final void d(n3.c cVar) {
        q7.k.e(cVar, "database");
        if (cVar.i()) {
            return;
        }
        try {
            ReentrantReadWriteLock.ReadLock lock = this.f3811a.f2673h.readLock();
            q7.k.d(lock, "readWriteLock.readLock()");
            lock.lock();
            try {
                synchronized (this.f3820j) {
                    int[] iArrC = this.f3818h.c();
                    if (iArrC != null) {
                        if (cVar.k()) {
                            cVar.b();
                        } else {
                            cVar.a();
                        }
                        try {
                            int length = iArrC.length;
                            int i2 = 0;
                            int i10 = 0;
                            while (i2 < length) {
                                int i11 = iArrC[i2];
                                int i12 = i10 + 1;
                                if (i11 == 1) {
                                    c(cVar, i10);
                                } else if (i11 == 2) {
                                    String str = this.f3814d[i10];
                                    String[] strArr = f3810m;
                                    for (int i13 = 0; i13 < 3; i13++) {
                                        String str2 = "DROP TRIGGER IF EXISTS " + d.c(str, strArr[i13]);
                                        q7.k.d(str2, "StringBuilder().apply(builderAction).toString()");
                                        cVar.g(str2);
                                    }
                                }
                                i2++;
                                i10 = i12;
                            }
                            cVar.q();
                            cVar.e();
                        } catch (Throwable th) {
                            cVar.e();
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
