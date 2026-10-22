package com.stepos.statsapp.v3.lib.plugin.emitter.local.storage;

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
    private static final String f30727g = "LocalEventStore";

    /* renamed from: d, reason: collision with root package name */
    private SQLiteDatabase f30731d;

    /* renamed from: e, reason: collision with root package name */
    private b f30732e;

    /* renamed from: a, reason: collision with root package name */
    private final int f30728a = 200;

    /* renamed from: b, reason: collision with root package name */
    private final int f30729b = 10000;

    /* renamed from: c, reason: collision with root package name */
    private final int f30730c = 1000;

    /* renamed from: f, reason: collision with root package name */
    private boolean f30733f = true;

    public a(Context context) {
        SimpleCryptoAES.getInstance().init(context);
        this.f30732e = b.a(context);
        h();
        if (g()) {
            Logger.d(f30727g, "DB Path:" + this.f30731d.getPath());
        }
    }

    private boolean g() {
        SQLiteDatabase sQLiteDatabase = this.f30731d;
        boolean z10 = sQLiteDatabase != null && sQLiteDatabase.isOpen();
        if (!z10) {
            Logger.d(f30727g, "database NOT open!");
        }
        return z10;
    }

    private synchronized void h() {
        if (g()) {
            return;
        }
        try {
            this.f30731d = this.f30732e.getWritableDatabase();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void a(boolean z10) {
        this.f30733f = z10;
    }

    public synchronized void b() {
        this.f30732e.close();
    }

    public synchronized void c(long j10) {
        if (g()) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(b.f30743j, Long.valueOf(j10));
                if (a(b.f30742i, (String) null) == 1) {
                    this.f30731d.update(b.f30742i, contentValues, null, null);
                } else {
                    this.f30731d.insertWithOnConflict(b.f30742i, null, contentValues, 4);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized ArrayList<EmittableEvent> d() {
        ArrayList<EmittableEvent> arrayList;
        arrayList = new ArrayList<>();
        if (g()) {
            try {
                for (EventBean eventBean : a((String) null, 500)) {
                    long id = eventBean.getId();
                    TrackerPayload payload = EventBean.toPayload(eventBean);
                    if (payload != null) {
                        arrayList.add(new EmittableEvent("", id, payload));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return arrayList;
            }
        }
        return arrayList;
    }

    public synchronized long e() {
        if (g()) {
            Cursor cursorQuery = null;
            try {
                cursorQuery = this.f30731d.query(true, b.f30742i, new String[]{b.f30743j}, null, null, null, null, null, null);
                return cursorQuery.moveToFirst() ? cursorQuery.getLong(0) : 0L;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    CommonUtils.closeQuietly(cursorQuery);
                } finally {
                    CommonUtils.closeQuietly(cursorQuery);
                }
            }
        }
        return 0L;
    }

    public synchronized int f() {
        if (g()) {
            Cursor cursorQuery = null;
            try {
                cursorQuery = this.f30731d.query(true, b.f30742i, new String[]{b.f30744k}, null, null, null, null, null, null);
                return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    CommonUtils.closeQuietly(cursorQuery);
                } finally {
                    CommonUtils.closeQuietly(cursorQuery);
                }
            }
        }
        return 0;
    }

    public synchronized long a(TrackerPayload trackerPayload) {
        long jInsert;
        try {
            if (g()) {
                try {
                    EventBean eventBeanFromPayload = EventBean.fromPayload(this.f30733f ? 2 : 0, trackerPayload);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(b.f30738e, eventBeanFromPayload.getSessionId());
                    contentValues.put(b.f30739f, eventBeanFromPayload.getEventSource());
                    contentValues.put(b.f30736c, Integer.valueOf(eventBeanFromPayload.getEncrypt()));
                    contentValues.put(b.f30740g, eventBeanFromPayload.getEventData());
                    jInsert = this.f30731d.insert("events", null, contentValues);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                jInsert = -1;
            }
            Logger.d(f30727g, "Added event:" + jInsert);
        } catch (Throwable th2) {
            throw th2;
        }
        return jInsert;
    }

    public synchronized boolean b(long j10) {
        int iDelete;
        try {
            if (g()) {
                try {
                    iDelete = this.f30731d.delete("events", "eventId=" + j10, null);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                iDelete = -1;
            }
            Logger.d(f30727g, "Removed event, eventId:" + j10);
        } catch (Throwable th2) {
            throw th2;
        }
        return iDelete == 1;
    }

    public synchronized List<EventBean> b(String str, int i10) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
            return new ArrayList();
        }
        return a("events", str, "eventId DESC LIMIT " + i10);
    }

    public synchronized ArrayList<EmittableEvent> c() {
        ArrayList<EmittableEvent> arrayList;
        arrayList = new ArrayList<>();
        if (g()) {
            try {
                for (EventBean eventBean : a((String) null, 200)) {
                    long id = eventBean.getId();
                    TrackerPayload payload = EventBean.toPayload(eventBean);
                    if (payload != null) {
                        arrayList.add(new EmittableEvent("", id, payload));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return arrayList;
            }
        }
        return arrayList;
    }

    public synchronized boolean b(String str, String str2) {
        if (g()) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(b.f30739f, str2);
                SQLiteDatabase sQLiteDatabase = this.f30731d;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("eventSessionId='");
                sb2.append(str);
                sb2.append("'");
                return sQLiteDatabase.update("events", contentValues, sb2.toString(), null) > 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public synchronized void a(int i10) {
        if (g()) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(b.f30744k, Integer.valueOf(i10));
                if (a(b.f30742i, (String) null) == 1) {
                    this.f30731d.update(b.f30742i, contentValues, null, null);
                } else {
                    this.f30731d.insertWithOnConflict(b.f30742i, null, contentValues, 4);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void a() {
        if (g()) {
            try {
                long jA = a((String) null);
                if (jA > 10000) {
                    Logger.d(f30727g, "clear old events, amount of events currently in the database: " + jA);
                    this.f30731d.execSQL("delete from events where (eventId not in (select eventId from events order by eventId desc limit 1000))");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private synchronized List<EventBean> a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!g()) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.f30731d.query(str, null, str2, null, null, null, str3);
            if (cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                while (!cursorQuery.isAfterLast()) {
                    EventBean eventBean = new EventBean();
                    if (cursorQuery.getColumnIndex(b.f30737d) >= 0) {
                        eventBean.setId(cursorQuery.getInt(r13));
                    }
                    int columnIndex = cursorQuery.getColumnIndex(b.f30738e);
                    if (columnIndex >= 0) {
                        eventBean.setSessionId(cursorQuery.getString(columnIndex));
                    }
                    int columnIndex2 = cursorQuery.getColumnIndex(b.f30739f);
                    if (columnIndex2 >= 0) {
                        eventBean.setEventSource(cursorQuery.getString(columnIndex2));
                    }
                    int columnIndex3 = cursorQuery.getColumnIndex(b.f30736c);
                    if (columnIndex3 >= 0) {
                        eventBean.setEncrypt(cursorQuery.getInt(columnIndex3));
                    }
                    int columnIndex4 = cursorQuery.getColumnIndex(b.f30740g);
                    if (columnIndex4 >= 0) {
                        eventBean.setEventData(cursorQuery.getString(columnIndex4));
                    }
                    int columnIndex5 = cursorQuery.getColumnIndex(b.f30741h);
                    if (columnIndex5 >= 0) {
                        eventBean.setDateCreated(cursorQuery.getString(columnIndex5));
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

    private synchronized long a(String str, String str2) {
        if (g()) {
            try {
                return DatabaseUtils.queryNumEntries(this.f30731d, str, str2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 0L;
    }

    public synchronized long a(String str) {
        if (g()) {
            try {
                return DatabaseUtils.queryNumEntries(this.f30731d, "events", str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 0L;
    }

    public synchronized EventBean a(long j10) {
        if (g()) {
            try {
                List<EventBean> listA = a("events", "eventId=" + j10, null);
                if (!listA.isEmpty()) {
                    return listA.get(0);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public synchronized List<EventBean> a(long j10, int i10) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
            return new ArrayList();
        }
        return a("events", "eventId >= " + j10, "eventId ASC LIMIT " + i10);
    }

    public synchronized List<EventBean> a(String str, int i10) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
            return new ArrayList();
        }
        return a("events", str, "eventId ASC LIMIT " + i10);
    }
}
