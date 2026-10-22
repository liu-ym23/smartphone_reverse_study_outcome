package Y5;

import W5.c;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.stepos.statsapp.v3.lib.plugin.emitter.d;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.ArrayList;
import java.util.Iterator;
import z2.l;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f1563a;
    public Context b;

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
            d dVar = (d) it.next();
            long j5 = dVar.f3968a;
            TrackerPayload trackerPayloadB = d.b(dVar);
            if (trackerPayloadB != null) {
                com.stepos.statsapp.v3.lib.plugin.emitter.a aVar = new com.stepos.statsapp.v3.lib.plugin.emitter.a();
                aVar.f3965a = j5;
                aVar.b = trackerPayloadB;
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
            cursorQuery = this.f1563a.query("events", null, str, null, null, null, str2);
            if (cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                while (!cursorQuery.isAfterLast()) {
                    d dVar = new d();
                    if (cursorQuery.getColumnIndex("eventId") >= 0) {
                        dVar.f3968a = cursorQuery.getInt(r12);
                    }
                    int columnIndex = cursorQuery.getColumnIndex("eventSessionId");
                    if (columnIndex >= 0) {
                        dVar.c = cursorQuery.getString(columnIndex);
                    }
                    int columnIndex2 = cursorQuery.getColumnIndex("encrypt");
                    if (columnIndex2 >= 0) {
                        dVar.b = cursorQuery.getInt(columnIndex2);
                    }
                    int columnIndex3 = cursorQuery.getColumnIndex("eventData");
                    if (columnIndex2 >= 0) {
                        dVar.e = cursorQuery.getString(columnIndex3);
                    }
                    int columnIndex4 = cursorQuery.getColumnIndex("dateCreated");
                    if (columnIndex4 >= 0) {
                        cursorQuery.getString(columnIndex4);
                    }
                    arrayList.add(dVar);
                    cursorQuery.moveToNext();
                }
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                l.o(cursorQuery);
                return arrayList;
            } finally {
                l.o(cursorQuery);
            }
        }
    }

    public final synchronized void c() {
        if (e()) {
            try {
                synchronized (this) {
                    long jQueryNumEntries = DatabaseUtils.queryNumEntries(this.f1563a, "events", null);
                    if (jQueryNumEntries > 10000) {
                        c.a("a", "clear old events, amount of events currently in the database: " + jQueryNumEntries);
                        this.f1563a.execSQL("delete from events where (eventId not in (select eventId from events order by eventId desc limit 1000))");
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
            cursorQuery = this.f1563a.query(true, "events", new String[]{"appKey"}, null, null, null, null, null, null);
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
                l.o(cursorQuery);
            }
        }
    }

    public final boolean e() {
        SQLiteDatabase sQLiteDatabase = this.f1563a;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }
}
