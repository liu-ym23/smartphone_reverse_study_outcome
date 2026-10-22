package V2;

import G2.c;
import T2.d;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import ch.qos.logback.core.spi.AbstractComponentTracker;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.ArrayList;
import java.util.Iterator;
import t0.J;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f1933a;

    /* renamed from: b, reason: collision with root package name */
    public Context f1934b;

    public final synchronized ArrayList a(String str) {
        ArrayList arrayList;
        String str2;
        arrayList = new ArrayList();
        str2 = "appKey='" + str + "'";
        synchronized (this) {
        }
        return arrayList;
        Iterator it = b(str2, "eventId ASC LIMIT 200").iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            long j4 = cVar.f643a;
            TrackerPayload trackerPayloadB = c.b(cVar);
            if (trackerPayloadB != null) {
                G2.a aVar = new G2.a();
                aVar.f637a = j4;
                aVar.f638b = trackerPayloadB;
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList b(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!e()) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.f1933a.query("events", null, str, null, null, null, str2);
            if (cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                while (!cursorQuery.isAfterLast()) {
                    c cVar = new c();
                    if (cursorQuery.getColumnIndex("eventId") >= 0) {
                        cVar.f643a = cursorQuery.getInt(r12);
                    }
                    int columnIndex = cursorQuery.getColumnIndex("eventSessionId");
                    if (columnIndex >= 0) {
                        cVar.f645c = cursorQuery.getString(columnIndex);
                    }
                    int columnIndex2 = cursorQuery.getColumnIndex("encrypt");
                    if (columnIndex2 >= 0) {
                        cVar.f644b = cursorQuery.getInt(columnIndex2);
                    }
                    int columnIndex3 = cursorQuery.getColumnIndex("eventData");
                    if (columnIndex2 >= 0) {
                        cVar.f647e = cursorQuery.getString(columnIndex3);
                    }
                    int columnIndex4 = cursorQuery.getColumnIndex("dateCreated");
                    if (columnIndex4 >= 0) {
                        cursorQuery.getString(columnIndex4);
                    }
                    arrayList.add(cVar);
                    cursorQuery.moveToNext();
                }
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return arrayList;
            } finally {
                J.l(cursorQuery);
            }
        }
    }

    public final synchronized void c() {
        if (e()) {
            try {
                synchronized (this) {
                    long jQueryNumEntries = DatabaseUtils.queryNumEntries(this.f1933a, "events", null);
                    if (jQueryNumEntries > AbstractComponentTracker.LINGERING_TIMEOUT) {
                        d.a("a", "clear old events, amount of events currently in the database: " + jQueryNumEntries);
                        this.f1933a.execSQL("delete from events where (eventId not in (select eventId from events order by eventId desc limit 1000))");
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final synchronized ArrayList d() {
        ArrayList arrayList = new ArrayList();
        if (!e()) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.f1933a.query(true, "events", new String[]{"appKey"}, null, null, null, null, null, null);
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
                J.l(cursorQuery);
            }
        }
    }

    public final boolean e() {
        SQLiteDatabase sQLiteDatabase = this.f1933a;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }
}
