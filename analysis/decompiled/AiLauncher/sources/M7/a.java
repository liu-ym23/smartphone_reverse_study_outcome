package M7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmittableEvent;
import com.stepos.statsapp.v3.lib.plugin.emitter.EventBean;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsapp.v3.lib.plugin.secure.SimpleCryptoAES;
import com.stepos.statsapp.v3.utils.CommonUtils;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    public static String f4643g = "a";

    /* renamed from: a, reason: collision with root package name */
    public final int f4644a = 200;

    /* renamed from: b, reason: collision with root package name */
    public final int f4645b = 10000;

    /* renamed from: c, reason: collision with root package name */
    public final int f4646c = 1000;

    /* renamed from: d, reason: collision with root package name */
    public SQLiteDatabase f4647d;

    /* renamed from: e, reason: collision with root package name */
    public b f4648e;

    /* renamed from: f, reason: collision with root package name */
    public Context f4649f;

    public a(Context context) {
        this.f4649f = context;
        SimpleCryptoAES.getInstance().init(context);
        this.f4648e = b.b(context);
        k();
        Logger.d(f4643g, "DB Path:" + this.f4647d.getPath());
    }

    public final synchronized long a(String str, String str2) {
        return DatabaseUtils.queryNumEntries(this.f4647d, str, str2);
    }

    public synchronized long b(String str, String str2, TrackerPayload trackerPayload) {
        long jInsertWithOnConflict;
        try {
            if (j()) {
                try {
                    EventBean eventBeanFromPayload = EventBean.fromPayload(CommonUtils.isDebugMode(this.f4649f) ? 0 : 2, trackerPayload);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", str);
                    contentValues.put("rpkPkgName", str2);
                    contentValues.put(com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30738e, eventBeanFromPayload.getSessionId());
                    contentValues.put(com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30736c, Integer.valueOf(eventBeanFromPayload.getEncrypt()));
                    contentValues.put(com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30740g, eventBeanFromPayload.getEventData());
                    jInsertWithOnConflict = this.f4647d.insertWithOnConflict("events", null, contentValues, 5);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                jInsertWithOnConflict = -1;
            }
            Logger.d(f4643g, "succ add event, inserted:" + jInsertWithOnConflict);
        } catch (Throwable th2) {
            throw th2;
        }
        return jInsertWithOnConflict;
    }

    public synchronized ArrayList<EmittableEvent> c(String str) {
        ArrayList<EmittableEvent> arrayList;
        arrayList = new ArrayList<>();
        for (EventBean eventBean : d("appKey='" + str + "'", 200)) {
            long id = eventBean.getId();
            TrackerPayload payload = EventBean.toPayload(eventBean);
            if (payload != null) {
                arrayList.add(new EmittableEvent("", id, payload));
            }
        }
        return arrayList;
    }

    public final synchronized List<EventBean> d(String str, int i10) {
        return e("events", str, "eventId ASC LIMIT " + i10);
    }

    public final synchronized List<EventBean> e(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!j()) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.f4647d.query(str, null, str2, null, null, null, str3);
            if (cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                while (!cursorQuery.isAfterLast()) {
                    EventBean eventBean = new EventBean();
                    if (cursorQuery.getColumnIndex(com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30737d) >= 0) {
                        eventBean.setId(cursorQuery.getInt(r13));
                    }
                    int columnIndex = cursorQuery.getColumnIndex(com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30738e);
                    if (columnIndex >= 0) {
                        eventBean.setSessionId(cursorQuery.getString(columnIndex));
                    }
                    int columnIndex2 = cursorQuery.getColumnIndex(com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30736c);
                    if (columnIndex2 >= 0) {
                        eventBean.setEncrypt(cursorQuery.getInt(columnIndex2));
                    }
                    int columnIndex3 = cursorQuery.getColumnIndex(com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30740g);
                    if (columnIndex2 >= 0) {
                        eventBean.setEventData(cursorQuery.getString(columnIndex3));
                    }
                    int columnIndex4 = cursorQuery.getColumnIndex(com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30741h);
                    if (columnIndex4 >= 0) {
                        eventBean.setDateCreated(cursorQuery.getString(columnIndex4));
                    }
                    arrayList.add(eventBean);
                    cursorQuery.moveToNext();
                }
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                CommonUtils.closeQuietly(cursorQuery);
                return arrayList;
            } finally {
                CommonUtils.closeQuietly(cursorQuery);
            }
        }
    }

    public synchronized void f() {
        if (j()) {
            try {
                long jA = a("events", null);
                if (jA > 10000) {
                    Logger.d(f4643g, "clear old events, amount of events currently in the database: " + jA);
                    this.f4647d.execSQL("delete from events where (eventId not in (select eventId from events order by eventId desc limit 1000))");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized boolean g(String str, long j10) {
        int iDelete;
        try {
            if (j()) {
                try {
                    iDelete = this.f4647d.delete("events", "appKey='" + str + "' and " + com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30737d + "=" + j10, null);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                iDelete = -1;
            }
            Logger.d(f4643g, "Removed event, appKey:" + str + ", eventId:" + j10);
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
            cursorQuery = this.f4647d.query(true, "events", new String[]{"appKey"}, null, null, null, null, null, null);
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
                CommonUtils.closeQuietly(cursorQuery);
            }
        }
    }

    public final boolean j() {
        SQLiteDatabase sQLiteDatabase = this.f4647d;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }

    public final synchronized void k() {
        if (j()) {
            return;
        }
        SQLiteDatabase writableDatabase = this.f4648e.getWritableDatabase();
        this.f4647d = writableDatabase;
        writableDatabase.enableWriteAheadLogging();
    }
}
