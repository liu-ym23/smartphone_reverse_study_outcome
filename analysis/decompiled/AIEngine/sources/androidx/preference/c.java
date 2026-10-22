package androidx.preference;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import androidx.room.l;
import androidx.work.impl.WorkDatabase_Impl;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import q2.k;
import q2.t;
import q2.u;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements u {

    /* renamed from: a, reason: collision with root package name */
    public Object f2400a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2401b;

    public c(int i10) {
        switch (i10) {
            case 7:
                this.f2400a = new AtomicReference(x.a.f13691a);
                this.f2401b = new Object();
                break;
            default:
                this.f2400a = new long[256];
                this.f2401b = new AtomicLong(0L);
                break;
        }
    }

    @Override // q2.u
    public ArrayList a(String str) {
        l lVarW = l.w(1, "SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?");
        lVarW.Y(1, str);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f2400a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            ArrayList arrayList = new ArrayList(cursorM.getCount());
            while (cursorM.moveToNext()) {
                arrayList.add(cursorM.getString(0));
            }
            return arrayList;
        } finally {
            cursorM.close();
            lVarW.C();
        }
    }

    @Override // q2.u
    public void b(t tVar) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f2400a;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            ((q2.c) this.f2401b).h(tVar);
            workDatabase_Impl.p();
        } finally {
            workDatabase_Impl.k();
        }
    }

    public synchronized ArrayList d(String str) {
        ArrayList arrayList;
        ArrayList arrayListE;
        arrayList = new ArrayList();
        String str2 = "appKey='" + str + "'";
        synchronized (this) {
            arrayListE = e(str2, "eventId ASC LIMIT 200");
        }
        return arrayList;
        int size = arrayListE.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayListE.get(i10);
            i10++;
            com.stepos.statsapp.v3.lib.plugin.emitter.e eVar = (com.stepos.statsapp.v3.lib.plugin.emitter.e) obj;
            long j10 = eVar.f8011a;
            TrackerPayload trackerPayloadB = com.stepos.statsapp.v3.lib.plugin.emitter.e.b(eVar);
            if (trackerPayloadB != null) {
                com.stepos.statsapp.v3.lib.plugin.emitter.a aVar = new com.stepos.statsapp.v3.lib.plugin.emitter.a();
                aVar.f8001a = j10;
                aVar.f8002b = trackerPayloadB;
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public synchronized ArrayList e(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!i()) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = ((SQLiteDatabase) this.f2400a).query("events", null, str, null, null, null, str2);
            if (cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                while (!cursorQuery.isAfterLast()) {
                    com.stepos.statsapp.v3.lib.plugin.emitter.e eVar = new com.stepos.statsapp.v3.lib.plugin.emitter.e();
                    if (cursorQuery.getColumnIndex("eventId") >= 0) {
                        eVar.f8011a = cursorQuery.getInt(r12);
                    }
                    int columnIndex = cursorQuery.getColumnIndex("eventSessionId");
                    if (columnIndex >= 0) {
                        eVar.f8013c = cursorQuery.getString(columnIndex);
                    }
                    int columnIndex2 = cursorQuery.getColumnIndex("encrypt");
                    if (columnIndex2 >= 0) {
                        eVar.f8012b = cursorQuery.getInt(columnIndex2);
                    }
                    int columnIndex3 = cursorQuery.getColumnIndex("eventData");
                    if (columnIndex2 >= 0) {
                        eVar.f8015e = cursorQuery.getString(columnIndex3);
                    }
                    int columnIndex4 = cursorQuery.getColumnIndex("dateCreated");
                    if (columnIndex4 >= 0) {
                        cursorQuery.getString(columnIndex4);
                    }
                    arrayList.add(eVar);
                    cursorQuery.moveToNext();
                }
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                jd.b.m(cursorQuery);
                return arrayList;
            } finally {
                jd.b.m(cursorQuery);
            }
        }
    }

    public synchronized void f() {
        if (i()) {
            try {
                synchronized (this) {
                    long jQueryNumEntries = DatabaseUtils.queryNumEntries((SQLiteDatabase) this.f2400a, "events", null);
                    if (jQueryNumEntries > TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS) {
                        ta.c.a("a", "clear old events, amount of events currently in the database: " + jQueryNumEntries);
                        ((SQLiteDatabase) this.f2400a).execSQL("delete from events where (eventId not in (select eventId from events order by eventId desc limit 1000))");
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized ArrayList g() {
        ArrayList arrayList = new ArrayList();
        if (!i()) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = ((SQLiteDatabase) this.f2400a).query(true, "events", new String[]{"appKey"}, null, null, null, null, null, null);
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
                jd.b.m(cursorQuery);
            }
        }
    }

    public boolean h(k kVar) {
        boolean zContainsKey;
        synchronized (this.f2401b) {
            zContainsKey = ((LinkedHashMap) ((stepos.support.v7.app.palette.b) this.f2400a).h).containsKey(kVar);
        }
        return zContainsKey;
    }

    public boolean i() {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.f2400a;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }

    public Object j() {
        long id2 = Thread.currentThread().getId();
        if (id2 == x.c.f13695a) {
            return null;
        }
        x.b bVar = (x.b) ((AtomicReference) this.f2400a).get();
        long[] jArr = bVar.f13693b;
        int i10 = bVar.f13692a - 1;
        int i11 = -1;
        if (i10 != -1) {
            int i12 = 0;
            if (i10 != 0) {
                while (true) {
                    if (i12 > i10) {
                        i11 = -(i12 + 1);
                        break;
                    }
                    i11 = (i12 + i10) >>> 1;
                    long j10 = jArr[i11] - id2;
                    if (j10 >= 0) {
                        if (j10 <= 0) {
                            break;
                        }
                        i10 = i11 - 1;
                    } else {
                        i12 = i11 + 1;
                    }
                }
            } else {
                long j11 = jArr[0];
                if (j11 == id2) {
                    i11 = 0;
                } else if (j11 > id2) {
                    i11 = -2;
                }
            }
        }
        if (i11 >= 0) {
            return bVar.f13694c[i11];
        }
        return null;
    }

    public long k() {
        int iO = o();
        if (iO == 0) {
            return -1L;
        }
        long[] jArrCopyOf = Arrays.copyOf((long[]) this.f2400a, iO);
        kotlin.jvm.internal.g.e(jArrCopyOf, "copyOf(...)");
        if (jArrCopyOf.length > 1) {
            Arrays.sort(jArrCopyOf);
        }
        int i10 = iO - 1;
        return jArrCopyOf[dc.h.a0((int) ((95 / 100.0d) * i10), 0, i10)];
    }

    public void l(long j10) {
        ((long[]) this.f2400a)[(int) (((AtomicLong) this.f2401b).getAndIncrement() % 256)] = j10;
    }

    public i2.k m(k id2) {
        i2.k kVarI;
        kotlin.jvm.internal.g.f(id2, "id");
        synchronized (this.f2401b) {
            kVarI = ((stepos.support.v7.app.palette.b) this.f2400a).i(id2);
        }
        return kVarI;
    }

    public List n(String workSpecId) {
        List listJ;
        kotlin.jvm.internal.g.f(workSpecId, "workSpecId");
        synchronized (this.f2401b) {
            listJ = ((stepos.support.v7.app.palette.b) this.f2400a).j(workSpecId);
        }
        return listJ;
    }

    public int o() {
        return (int) Math.min(((AtomicLong) this.f2401b).get(), 256);
    }

    public i2.k p(k kVar) {
        i2.k kVarL;
        synchronized (this.f2401b) {
            kVarL = ((stepos.support.v7.app.palette.b) this.f2400a).l(kVar);
        }
        return kVarL;
    }

    public c(stepos.support.v7.app.palette.b bVar) {
        this.f2400a = bVar;
        this.f2401b = new Object();
    }
}
