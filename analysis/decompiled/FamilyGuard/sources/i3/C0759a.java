package i3;

import T2.d;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import f3.C0719a;
import g3.C0742e;
import java.util.ArrayList;
import java.util.List;
import org.libpag.BuildConfig;

/* renamed from: i3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0759a {

    /* renamed from: g, reason: collision with root package name */
    private static String f17613g = "a";

    /* renamed from: a, reason: collision with root package name */
    private final int f17614a = 200;

    /* renamed from: b, reason: collision with root package name */
    private final int f17615b = 10000;

    /* renamed from: c, reason: collision with root package name */
    private final int f17616c = 1000;

    /* renamed from: d, reason: collision with root package name */
    private SQLiteDatabase f17617d;

    /* renamed from: e, reason: collision with root package name */
    private C0760b f17618e;

    /* renamed from: f, reason: collision with root package name */
    private Context f17619f;

    public C0759a(Context context) {
        this.f17619f = context;
        Z2.a.h().i(context);
        this.f17618e = C0760b.a(context);
        k();
        C0742e.c(f17613g, "DB Path:" + this.f17617d.getPath());
    }

    private synchronized long a(String str, String str2) {
        return DatabaseUtils.queryNumEntries(this.f17617d, str, str2);
    }

    private synchronized List<d> d(String str, int i5) {
        return e("events", str, "eventId ASC LIMIT " + i5);
    }

    private synchronized List<d> e(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!j()) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.f17617d.query(str, null, str2, null, null, null, str3);
            if (cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                while (!cursorQuery.isAfterLast()) {
                    d dVar = new d();
                    if (cursorQuery.getColumnIndex("eventId") >= 0) {
                        dVar.k(cursorQuery.getInt(r13));
                    }
                    int columnIndex = cursorQuery.getColumnIndex("eventSessionId");
                    if (columnIndex >= 0) {
                        dVar.l(cursorQuery.getString(columnIndex));
                    }
                    int columnIndex2 = cursorQuery.getColumnIndex("encrypt");
                    if (columnIndex2 >= 0) {
                        dVar.h(cursorQuery.getInt(columnIndex2));
                    }
                    int columnIndex3 = cursorQuery.getColumnIndex("eventData");
                    if (columnIndex2 >= 0) {
                        dVar.i(cursorQuery.getString(columnIndex3));
                    }
                    int columnIndex4 = cursorQuery.getColumnIndex("dateCreated");
                    if (columnIndex4 >= 0) {
                        dVar.g(cursorQuery.getString(columnIndex4));
                    }
                    arrayList.add(dVar);
                    cursorQuery.moveToNext();
                }
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                C0719a.a(cursorQuery);
                return arrayList;
            } finally {
                C0719a.a(cursorQuery);
            }
        }
    }

    private boolean j() {
        SQLiteDatabase sQLiteDatabase = this.f17617d;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }

    private synchronized void k() {
        if (j()) {
            return;
        }
        SQLiteDatabase writableDatabase = this.f17618e.getWritableDatabase();
        this.f17617d = writableDatabase;
        writableDatabase.enableWriteAheadLogging();
    }

    public synchronized long b(String str, String str2, TrackerPayload trackerPayload) {
        long jInsertWithOnConflict;
        try {
            if (j()) {
                try {
                    d dVarA = d.a(C0719a.b(this.f17619f) ? 0 : 2, trackerPayload);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", str);
                    contentValues.put("rpkPkgName", str2);
                    contentValues.put("eventSessionId", dVarA.f());
                    contentValues.put("encrypt", Integer.valueOf(dVarA.b()));
                    contentValues.put("eventData", dVarA.c());
                    jInsertWithOnConflict = this.f17617d.insertWithOnConflict("events", null, contentValues, 5);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                jInsertWithOnConflict = -1;
            }
            C0742e.c(f17613g, "succ add event, inserted:" + jInsertWithOnConflict);
        } catch (Throwable th2) {
            throw th2;
        }
        return jInsertWithOnConflict;
    }

    public synchronized ArrayList<T2.a> c(String str) {
        ArrayList<T2.a> arrayList;
        arrayList = new ArrayList<>();
        for (d dVar : d("appKey='" + str + "'", 200)) {
            long jE = dVar.e();
            TrackerPayload trackerPayloadM = d.m(dVar);
            if (trackerPayloadM != null) {
                arrayList.add(new T2.a(BuildConfig.FLAVOR, jE, trackerPayloadM));
            }
        }
        return arrayList;
    }

    public synchronized void f() {
        if (j()) {
            try {
                long jA = a("events", null);
                if (jA > 10000) {
                    C0742e.c(f17613g, "clear old events, amount of events currently in the database: " + jA);
                    this.f17617d.execSQL("delete from events where (eventId not in (select eventId from events order by eventId desc limit 1000))");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized boolean g(String str, long j5) {
        int iDelete;
        try {
            if (j()) {
                try {
                    iDelete = this.f17617d.delete("events", "appKey='" + str + "' and eventId=" + j5, null);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                iDelete = -1;
            }
            C0742e.c(f17613g, "Removed event, appKey:" + str + ", eventId:" + j5);
        } catch (Throwable th2) {
            throw th2;
        }
        return iDelete == 1;
    }

    public synchronized long h(String str) {
        return a("events", "appKey='" + str + "'");
    }

    public synchronized List<String> i() {
        ArrayList arrayList = new ArrayList();
        if (!j()) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.f17617d.query(true, "events", new String[]{"appKey"}, null, null, null, null, null, null);
            cursorQuery.moveToFirst();
            while (!cursorQuery.isAfterLast()) {
                arrayList.add(cursorQuery.getString(0));
                cursorQuery.moveToNext();
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return arrayList;
            } finally {
                C0719a.a(cursorQuery);
            }
        }
    }
}
