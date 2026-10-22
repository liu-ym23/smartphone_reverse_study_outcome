package com.stepos.statsrpk;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.room.RoomDatabase;
import androidx.room.l;
import androidx.work.impl.WorkDatabase_Impl;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.stepos.core.download.ModelFlowMeta;
import com.tonyodev.fetch2.EnqueueAction;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Priority;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import q2.i;
import q2.j;
import q2.n;
import q2.o;
import q2.s;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements q2.h, o, za.b {

    /* renamed from: a, reason: collision with root package name */
    public Object f8087a;

    /* renamed from: b, reason: collision with root package name */
    public Object f8088b;

    /* renamed from: c, reason: collision with root package name */
    public Object f8089c;

    /* renamed from: d, reason: collision with root package name */
    public Object f8090d;

    public g() {
        this.f8087a = new p.a();
        this.f8088b = new SparseArray();
        this.f8089c = new p.e();
        this.f8090d = new p.a();
    }

    @Override // q2.o
    public void a(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f8087a;
        workDatabase_Impl.b();
        i iVar = (i) this.f8089c;
        y1.f fVarA = iVar.a();
        fVarA.Y(1, str);
        try {
            workDatabase_Impl.c();
            try {
                fVarA.r();
                workDatabase_Impl.p();
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            iVar.d(fVarA);
        }
    }

    @Override // za.b
    public void b(DownloadInfo downloadInfo) {
        RoomDatabase roomDatabase = (RoomDatabase) this.f8087a;
        roomDatabase.b();
        roomDatabase.c();
        try {
            ((za.d) this.f8089c).f(downloadInfo);
            roomDatabase.p();
        } finally {
            roomDatabase.k();
        }
    }

    @Override // za.b
    public void d(DownloadInfo downloadInfo) {
        RoomDatabase roomDatabase = (RoomDatabase) this.f8087a;
        roomDatabase.b();
        roomDatabase.c();
        try {
            ((s) this.f8090d).f(downloadInfo);
            roomDatabase.p();
        } finally {
            roomDatabase.k();
        }
    }

    @Override // za.b
    public long e(DownloadInfo downloadInfo) {
        RoomDatabase roomDatabase = (RoomDatabase) this.f8087a;
        roomDatabase.b();
        roomDatabase.c();
        try {
            za.c cVar = (za.c) this.f8088b;
            y1.f fVarA = cVar.a();
            try {
                cVar.e(fVarA, downloadInfo);
                long jU = fVarA.U();
                cVar.d(fVarA);
                roomDatabase.p();
                return jU;
            } catch (Throwable th) {
                cVar.d(fVarA);
                throw th;
            }
        } finally {
            roomDatabase.k();
        }
    }

    @Override // za.b
    public ArrayList f(int i10) throws Throwable {
        l lVar;
        l lVarW = l.w(1, "SELECT * FROM requests WHERE _group = ?");
        lVarW.h0(1, i10);
        RoomDatabase roomDatabase = (RoomDatabase) this.f8087a;
        roomDatabase.b();
        Cursor cursorM = roomDatabase.m(lVarW);
        try {
            int iA = v1.a.a(cursorM, "_id");
            int iA2 = v1.a.a(cursorM, "_namespace");
            int iA3 = v1.a.a(cursorM, "_url");
            int iA4 = v1.a.a(cursorM, "_file");
            int iA5 = v1.a.a(cursorM, "_group");
            int iA6 = v1.a.a(cursorM, "_priority");
            int iA7 = v1.a.a(cursorM, "_headers");
            int iA8 = v1.a.a(cursorM, "_written_bytes");
            int iA9 = v1.a.a(cursorM, "_total_bytes");
            int iA10 = v1.a.a(cursorM, "_status");
            int iA11 = v1.a.a(cursorM, "_error");
            int iA12 = v1.a.a(cursorM, "_network_type");
            int iA13 = v1.a.a(cursorM, "_created");
            int iA14 = v1.a.a(cursorM, "_tag");
            lVar = lVarW;
            try {
                int iA15 = v1.a.a(cursorM, "_enqueue_action");
                int iA16 = v1.a.a(cursorM, "_identifier");
                int iA17 = v1.a.a(cursorM, "_download_on_enqueue");
                int iA18 = v1.a.a(cursorM, "_extras");
                int iA19 = v1.a.a(cursorM, "_auto_retry_max_attempts");
                int iA20 = v1.a.a(cursorM, "_auto_retry_attempts");
                int i11 = iA14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    ArrayList arrayList2 = arrayList;
                    downloadInfo.setId(cursorM.getInt(iA));
                    downloadInfo.setNamespace(cursorM.getString(iA2));
                    downloadInfo.setUrl(cursorM.getString(iA3));
                    downloadInfo.setFile(cursorM.getString(iA4));
                    downloadInfo.setGroup(cursorM.getInt(iA5));
                    int i12 = cursorM.getInt(iA6);
                    Priority.f8179b.getClass();
                    downloadInfo.setPriority(Priority.a.a(i12));
                    downloadInfo.setHeaders(za.a.c(cursorM.getString(iA7)));
                    int i13 = iA;
                    int i14 = iA2;
                    downloadInfo.setDownloaded(cursorM.getLong(iA8));
                    downloadInfo.setTotal(cursorM.getLong(iA9));
                    int i15 = cursorM.getInt(iA10);
                    Status.f8188b.getClass();
                    downloadInfo.setStatus(Status.a.a(i15));
                    int i16 = cursorM.getInt(iA11);
                    Error.f8153b.getClass();
                    downloadInfo.setError(Error.a.a(i16));
                    int i17 = cursorM.getInt(iA12);
                    NetworkType.f8173b.getClass();
                    downloadInfo.setNetworkType(NetworkType.a.a(i17));
                    downloadInfo.setCreated(cursorM.getLong(iA13));
                    int i18 = i11;
                    downloadInfo.setTag(cursorM.isNull(i18) ? null : cursorM.getString(i18));
                    int i19 = iA15;
                    int i20 = cursorM.getInt(i19);
                    EnqueueAction.f8147b.getClass();
                    downloadInfo.setEnqueueAction(EnqueueAction.a.a(i20));
                    int i21 = iA16;
                    i11 = i18;
                    downloadInfo.setIdentifier(cursorM.getLong(i21));
                    int i22 = iA17;
                    downloadInfo.setDownloadOnEnqueue(cursorM.getInt(i22) != 0);
                    int i23 = iA18;
                    iA16 = i21;
                    downloadInfo.setExtras(za.a.a(cursorM.getString(i23)));
                    iA17 = i22;
                    int i24 = iA19;
                    downloadInfo.setAutoRetryMaxAttempts(cursorM.getInt(i24));
                    iA19 = i24;
                    int i25 = iA20;
                    downloadInfo.setAutoRetryAttempts(cursorM.getInt(i25));
                    arrayList = arrayList2;
                    arrayList.add(downloadInfo);
                    iA20 = i25;
                    iA18 = i23;
                    iA2 = i14;
                    iA = i13;
                    iA15 = i19;
                }
                cursorM.close();
                lVar.C();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorM.close();
                lVar.C();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = lVarW;
        }
    }

    @Override // za.b
    public void g(List list) {
        RoomDatabase roomDatabase = (RoomDatabase) this.f8087a;
        roomDatabase.b();
        roomDatabase.c();
        try {
            ((za.d) this.f8089c).g(list);
            roomDatabase.p();
        } finally {
            roomDatabase.k();
        }
    }

    @Override // za.b
    public ArrayList get() throws Throwable {
        l lVar;
        l lVarW = l.w(0, "SELECT * FROM requests");
        RoomDatabase roomDatabase = (RoomDatabase) this.f8087a;
        roomDatabase.b();
        Cursor cursorM = roomDatabase.m(lVarW);
        try {
            int iA = v1.a.a(cursorM, "_id");
            int iA2 = v1.a.a(cursorM, "_namespace");
            int iA3 = v1.a.a(cursorM, "_url");
            int iA4 = v1.a.a(cursorM, "_file");
            int iA5 = v1.a.a(cursorM, "_group");
            int iA6 = v1.a.a(cursorM, "_priority");
            int iA7 = v1.a.a(cursorM, "_headers");
            int iA8 = v1.a.a(cursorM, "_written_bytes");
            int iA9 = v1.a.a(cursorM, "_total_bytes");
            int iA10 = v1.a.a(cursorM, "_status");
            int iA11 = v1.a.a(cursorM, "_error");
            int iA12 = v1.a.a(cursorM, "_network_type");
            int iA13 = v1.a.a(cursorM, "_created");
            int iA14 = v1.a.a(cursorM, "_tag");
            lVar = lVarW;
            try {
                int iA15 = v1.a.a(cursorM, "_enqueue_action");
                int iA16 = v1.a.a(cursorM, "_identifier");
                int iA17 = v1.a.a(cursorM, "_download_on_enqueue");
                int iA18 = v1.a.a(cursorM, "_extras");
                int iA19 = v1.a.a(cursorM, "_auto_retry_max_attempts");
                int iA20 = v1.a.a(cursorM, "_auto_retry_attempts");
                int i10 = iA14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    ArrayList arrayList2 = arrayList;
                    downloadInfo.setId(cursorM.getInt(iA));
                    downloadInfo.setNamespace(cursorM.getString(iA2));
                    downloadInfo.setUrl(cursorM.getString(iA3));
                    downloadInfo.setFile(cursorM.getString(iA4));
                    downloadInfo.setGroup(cursorM.getInt(iA5));
                    int i11 = cursorM.getInt(iA6);
                    Priority.f8179b.getClass();
                    downloadInfo.setPriority(Priority.a.a(i11));
                    downloadInfo.setHeaders(za.a.c(cursorM.getString(iA7)));
                    int i12 = iA;
                    int i13 = iA2;
                    downloadInfo.setDownloaded(cursorM.getLong(iA8));
                    downloadInfo.setTotal(cursorM.getLong(iA9));
                    int i14 = cursorM.getInt(iA10);
                    Status.f8188b.getClass();
                    downloadInfo.setStatus(Status.a.a(i14));
                    int i15 = cursorM.getInt(iA11);
                    Error.f8153b.getClass();
                    downloadInfo.setError(Error.a.a(i15));
                    int i16 = cursorM.getInt(iA12);
                    NetworkType.f8173b.getClass();
                    downloadInfo.setNetworkType(NetworkType.a.a(i16));
                    downloadInfo.setCreated(cursorM.getLong(iA13));
                    int i17 = i10;
                    downloadInfo.setTag(cursorM.isNull(i17) ? null : cursorM.getString(i17));
                    int i18 = iA15;
                    int i19 = cursorM.getInt(i18);
                    EnqueueAction.f8147b.getClass();
                    downloadInfo.setEnqueueAction(EnqueueAction.a.a(i19));
                    i10 = i17;
                    int i20 = iA16;
                    downloadInfo.setIdentifier(cursorM.getLong(i20));
                    int i21 = iA17;
                    downloadInfo.setDownloadOnEnqueue(cursorM.getInt(i21) != 0);
                    int i22 = iA18;
                    downloadInfo.setExtras(za.a.a(cursorM.getString(i22)));
                    iA17 = i21;
                    int i23 = iA19;
                    downloadInfo.setAutoRetryMaxAttempts(cursorM.getInt(i23));
                    iA19 = i23;
                    int i24 = iA20;
                    downloadInfo.setAutoRetryAttempts(cursorM.getInt(i24));
                    arrayList = arrayList2;
                    arrayList.add(downloadInfo);
                    iA20 = i24;
                    iA = i12;
                    iA15 = i18;
                    iA16 = i20;
                    iA18 = i22;
                    iA2 = i13;
                }
                cursorM.close();
                lVar.C();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorM.close();
                lVar.C();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = lVarW;
        }
    }

    @Override // q2.h
    public q2.g h(int i10, String str) {
        l lVarW = l.w(2, "SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?");
        lVarW.Y(1, str);
        lVarW.h0(2, i10);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f8087a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            return cursorM.moveToFirst() ? new q2.g(cursorM.getString(v1.a.a(cursorM, "work_spec_id")), cursorM.getInt(v1.a.a(cursorM, "generation")), cursorM.getInt(v1.a.a(cursorM, "system_id"))) : null;
        } finally {
            cursorM.close();
            lVarW.C();
        }
    }

    @Override // za.b
    public ArrayList i(List list) throws Throwable {
        l lVar;
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        int iA10;
        int iA11;
        int iA12;
        int iA13;
        int iA14;
        RoomDatabase roomDatabase = (RoomDatabase) this.f8087a;
        StringBuilder sb2 = new StringBuilder("SELECT * FROM requests WHERE _id IN (");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            sb2.append("?");
            if (i10 < size - 1) {
                sb2.append(",");
            }
        }
        sb2.append(")");
        l lVarW = l.w(size, sb2.toString());
        Iterator it = list.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            lVarW.h0(i11, ((Integer) it.next()).intValue());
            i11++;
        }
        roomDatabase.b();
        Cursor cursorM = roomDatabase.m(lVarW);
        try {
            iA = v1.a.a(cursorM, "_id");
            iA2 = v1.a.a(cursorM, "_namespace");
            iA3 = v1.a.a(cursorM, "_url");
            iA4 = v1.a.a(cursorM, "_file");
            iA5 = v1.a.a(cursorM, "_group");
            iA6 = v1.a.a(cursorM, "_priority");
            iA7 = v1.a.a(cursorM, "_headers");
            iA8 = v1.a.a(cursorM, "_written_bytes");
            iA9 = v1.a.a(cursorM, "_total_bytes");
            iA10 = v1.a.a(cursorM, "_status");
            iA11 = v1.a.a(cursorM, "_error");
            iA12 = v1.a.a(cursorM, "_network_type");
            iA13 = v1.a.a(cursorM, "_created");
            iA14 = v1.a.a(cursorM, "_tag");
            lVar = lVarW;
        } catch (Throwable th) {
            th = th;
            lVar = lVarW;
        }
        try {
            int iA15 = v1.a.a(cursorM, "_enqueue_action");
            int iA16 = v1.a.a(cursorM, "_identifier");
            int iA17 = v1.a.a(cursorM, "_download_on_enqueue");
            int iA18 = v1.a.a(cursorM, "_extras");
            int iA19 = v1.a.a(cursorM, "_auto_retry_max_attempts");
            int iA20 = v1.a.a(cursorM, "_auto_retry_attempts");
            int i12 = iA14;
            ArrayList arrayList = new ArrayList(cursorM.getCount());
            while (cursorM.moveToNext()) {
                DownloadInfo downloadInfo = new DownloadInfo();
                ArrayList arrayList2 = arrayList;
                downloadInfo.setId(cursorM.getInt(iA));
                downloadInfo.setNamespace(cursorM.getString(iA2));
                downloadInfo.setUrl(cursorM.getString(iA3));
                downloadInfo.setFile(cursorM.getString(iA4));
                downloadInfo.setGroup(cursorM.getInt(iA5));
                int i13 = cursorM.getInt(iA6);
                Priority.f8179b.getClass();
                downloadInfo.setPriority(Priority.a.a(i13));
                downloadInfo.setHeaders(za.a.c(cursorM.getString(iA7)));
                int i14 = iA;
                downloadInfo.setDownloaded(cursorM.getLong(iA8));
                downloadInfo.setTotal(cursorM.getLong(iA9));
                int i15 = cursorM.getInt(iA10);
                Status.f8188b.getClass();
                downloadInfo.setStatus(Status.a.a(i15));
                int i16 = cursorM.getInt(iA11);
                Error.f8153b.getClass();
                downloadInfo.setError(Error.a.a(i16));
                int i17 = cursorM.getInt(iA12);
                NetworkType.f8173b.getClass();
                downloadInfo.setNetworkType(NetworkType.a.a(i17));
                downloadInfo.setCreated(cursorM.getLong(iA13));
                int i18 = i12;
                downloadInfo.setTag(cursorM.isNull(i18) ? null : cursorM.getString(i18));
                int i19 = iA15;
                int i20 = cursorM.getInt(i19);
                EnqueueAction.f8147b.getClass();
                i12 = i18;
                downloadInfo.setEnqueueAction(EnqueueAction.a.a(i20));
                int i21 = iA2;
                int i22 = iA16;
                int i23 = iA3;
                downloadInfo.setIdentifier(cursorM.getLong(i22));
                int i24 = iA17;
                downloadInfo.setDownloadOnEnqueue(cursorM.getInt(i24) != 0);
                int i25 = iA18;
                downloadInfo.setExtras(za.a.a(cursorM.getString(i25)));
                int i26 = iA19;
                downloadInfo.setAutoRetryMaxAttempts(cursorM.getInt(i26));
                iA19 = i26;
                int i27 = iA20;
                downloadInfo.setAutoRetryAttempts(cursorM.getInt(i27));
                arrayList2.add(downloadInfo);
                iA17 = i24;
                iA2 = i21;
                iA15 = i19;
                iA18 = i25;
                iA3 = i23;
                iA16 = i22;
                iA20 = i27;
                arrayList = arrayList2;
                iA = i14;
            }
            ArrayList arrayList3 = arrayList;
            cursorM.close();
            lVar.C();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorM.close();
            lVar.C();
            throw th;
        }
    }

    @Override // q2.o
    public void j(n nVar) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f8087a;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            ((q2.c) this.f8088b).h(nVar);
            workDatabase_Impl.p();
        } finally {
            workDatabase_Impl.k();
        }
    }

    @Override // za.b
    public DownloadInfo k(String str) throws Throwable {
        l lVar;
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        int iA10;
        int iA11;
        int iA12;
        int iA13;
        int iA14;
        l lVarW = l.w(1, "SELECT * FROM requests WHERE _file = ?");
        lVarW.Y(1, str);
        RoomDatabase roomDatabase = (RoomDatabase) this.f8087a;
        roomDatabase.b();
        Cursor cursorM = roomDatabase.m(lVarW);
        try {
            iA = v1.a.a(cursorM, "_id");
            iA2 = v1.a.a(cursorM, "_namespace");
            iA3 = v1.a.a(cursorM, "_url");
            iA4 = v1.a.a(cursorM, "_file");
            iA5 = v1.a.a(cursorM, "_group");
            iA6 = v1.a.a(cursorM, "_priority");
            iA7 = v1.a.a(cursorM, "_headers");
            iA8 = v1.a.a(cursorM, "_written_bytes");
            iA9 = v1.a.a(cursorM, "_total_bytes");
            iA10 = v1.a.a(cursorM, "_status");
            iA11 = v1.a.a(cursorM, "_error");
            iA12 = v1.a.a(cursorM, "_network_type");
            iA13 = v1.a.a(cursorM, "_created");
            iA14 = v1.a.a(cursorM, "_tag");
            lVar = lVarW;
        } catch (Throwable th) {
            th = th;
            lVar = lVarW;
        }
        try {
            int iA15 = v1.a.a(cursorM, "_enqueue_action");
            int iA16 = v1.a.a(cursorM, "_identifier");
            int iA17 = v1.a.a(cursorM, "_download_on_enqueue");
            int iA18 = v1.a.a(cursorM, "_extras");
            int iA19 = v1.a.a(cursorM, "_auto_retry_max_attempts");
            int iA20 = v1.a.a(cursorM, "_auto_retry_attempts");
            DownloadInfo downloadInfo = null;
            if (cursorM.moveToFirst()) {
                DownloadInfo downloadInfo2 = new DownloadInfo();
                downloadInfo2.setId(cursorM.getInt(iA));
                downloadInfo2.setNamespace(cursorM.getString(iA2));
                downloadInfo2.setUrl(cursorM.getString(iA3));
                downloadInfo2.setFile(cursorM.getString(iA4));
                downloadInfo2.setGroup(cursorM.getInt(iA5));
                int i10 = cursorM.getInt(iA6);
                Priority.f8179b.getClass();
                downloadInfo2.setPriority(Priority.a.a(i10));
                downloadInfo2.setHeaders(za.a.c(cursorM.getString(iA7)));
                downloadInfo2.setDownloaded(cursorM.getLong(iA8));
                downloadInfo2.setTotal(cursorM.getLong(iA9));
                int i11 = cursorM.getInt(iA10);
                Status.f8188b.getClass();
                downloadInfo2.setStatus(Status.a.a(i11));
                int i12 = cursorM.getInt(iA11);
                Error.f8153b.getClass();
                downloadInfo2.setError(Error.a.a(i12));
                int i13 = cursorM.getInt(iA12);
                NetworkType.f8173b.getClass();
                downloadInfo2.setNetworkType(NetworkType.a.a(i13));
                downloadInfo2.setCreated(cursorM.getLong(iA13));
                downloadInfo2.setTag(cursorM.isNull(iA14) ? null : cursorM.getString(iA14));
                int i14 = cursorM.getInt(iA15);
                EnqueueAction.f8147b.getClass();
                downloadInfo2.setEnqueueAction(EnqueueAction.a.a(i14));
                downloadInfo2.setIdentifier(cursorM.getLong(iA16));
                downloadInfo2.setDownloadOnEnqueue(cursorM.getInt(iA17) != 0);
                downloadInfo2.setExtras(za.a.a(cursorM.getString(iA18)));
                downloadInfo2.setAutoRetryMaxAttempts(cursorM.getInt(iA19));
                downloadInfo2.setAutoRetryAttempts(cursorM.getInt(iA20));
                downloadInfo = downloadInfo2;
            }
            cursorM.close();
            lVar.C();
            return downloadInfo;
        } catch (Throwable th2) {
            th = th2;
            cursorM.close();
            lVar.C();
            throw th;
        }
    }

    @Override // q2.o
    public void m() {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f8087a;
        workDatabase_Impl.b();
        j jVar = (j) this.f8090d;
        y1.f fVarA = jVar.a();
        try {
            workDatabase_Impl.c();
            try {
                fVarA.r();
                workDatabase_Impl.p();
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            jVar.d(fVarA);
        }
    }

    @Override // za.b
    public void n(List list) {
        RoomDatabase roomDatabase = (RoomDatabase) this.f8087a;
        roomDatabase.b();
        roomDatabase.c();
        try {
            ((s) this.f8090d).g(list);
            roomDatabase.p();
        } finally {
            roomDatabase.k();
        }
    }

    @Override // q2.h
    public ArrayList o() {
        l lVarW = l.w(0, "SELECT DISTINCT work_spec_id FROM SystemIdInfo");
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f8087a;
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

    @Override // q2.h
    public void p(q2.g gVar) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f8087a;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            ((q2.c) this.f8088b).h(gVar);
            workDatabase_Impl.p();
        } finally {
            workDatabase_Impl.k();
        }
    }

    @Override // q2.h
    public void q(int i10, String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f8087a;
        workDatabase_Impl.b();
        i iVar = (i) this.f8089c;
        y1.f fVarA = iVar.a();
        fVarA.Y(1, str);
        fVarA.h0(2, i10);
        try {
            workDatabase_Impl.c();
            try {
                fVarA.r();
                workDatabase_Impl.p();
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            iVar.d(fVarA);
        }
    }

    @Override // q2.h
    public void r(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f8087a;
        workDatabase_Impl.b();
        j jVar = (j) this.f8090d;
        y1.f fVarA = jVar.a();
        fVarA.Y(1, str);
        try {
            workDatabase_Impl.c();
            try {
                fVarA.r();
                workDatabase_Impl.p();
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            jVar.d(fVarA);
        }
    }

    @Override // za.b
    public ArrayList s() throws Throwable {
        l lVar;
        Status.a aVar = Status.f8188b;
        l lVarW = l.w(1, "SELECT * FROM requests WHERE _status = ? ORDER BY _priority DESC, _created ASC");
        lVarW.h0(1, 1);
        RoomDatabase roomDatabase = (RoomDatabase) this.f8087a;
        roomDatabase.b();
        Cursor cursorM = roomDatabase.m(lVarW);
        try {
            int iA = v1.a.a(cursorM, "_id");
            int iA2 = v1.a.a(cursorM, "_namespace");
            int iA3 = v1.a.a(cursorM, "_url");
            int iA4 = v1.a.a(cursorM, "_file");
            int iA5 = v1.a.a(cursorM, "_group");
            int iA6 = v1.a.a(cursorM, "_priority");
            int iA7 = v1.a.a(cursorM, "_headers");
            int iA8 = v1.a.a(cursorM, "_written_bytes");
            int iA9 = v1.a.a(cursorM, "_total_bytes");
            int iA10 = v1.a.a(cursorM, "_status");
            int iA11 = v1.a.a(cursorM, "_error");
            int iA12 = v1.a.a(cursorM, "_network_type");
            int iA13 = v1.a.a(cursorM, "_created");
            int iA14 = v1.a.a(cursorM, "_tag");
            lVar = lVarW;
            try {
                int iA15 = v1.a.a(cursorM, "_enqueue_action");
                int iA16 = v1.a.a(cursorM, "_identifier");
                int iA17 = v1.a.a(cursorM, "_download_on_enqueue");
                int iA18 = v1.a.a(cursorM, "_extras");
                int iA19 = v1.a.a(cursorM, "_auto_retry_max_attempts");
                int iA20 = v1.a.a(cursorM, "_auto_retry_attempts");
                int i10 = iA14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    ArrayList arrayList2 = arrayList;
                    downloadInfo.setId(cursorM.getInt(iA));
                    downloadInfo.setNamespace(cursorM.getString(iA2));
                    downloadInfo.setUrl(cursorM.getString(iA3));
                    downloadInfo.setFile(cursorM.getString(iA4));
                    downloadInfo.setGroup(cursorM.getInt(iA5));
                    int i11 = cursorM.getInt(iA6);
                    Priority.f8179b.getClass();
                    downloadInfo.setPriority(Priority.a.a(i11));
                    downloadInfo.setHeaders(za.a.c(cursorM.getString(iA7)));
                    int i12 = iA;
                    int i13 = iA2;
                    downloadInfo.setDownloaded(cursorM.getLong(iA8));
                    downloadInfo.setTotal(cursorM.getLong(iA9));
                    int i14 = cursorM.getInt(iA10);
                    Status.f8188b.getClass();
                    downloadInfo.setStatus(Status.a.a(i14));
                    int i15 = cursorM.getInt(iA11);
                    Error.f8153b.getClass();
                    downloadInfo.setError(Error.a.a(i15));
                    int i16 = cursorM.getInt(iA12);
                    NetworkType.f8173b.getClass();
                    downloadInfo.setNetworkType(NetworkType.a.a(i16));
                    downloadInfo.setCreated(cursorM.getLong(iA13));
                    int i17 = i10;
                    downloadInfo.setTag(cursorM.isNull(i17) ? null : cursorM.getString(i17));
                    int i18 = iA15;
                    int i19 = cursorM.getInt(i18);
                    EnqueueAction.f8147b.getClass();
                    downloadInfo.setEnqueueAction(EnqueueAction.a.a(i19));
                    i10 = i17;
                    int i20 = iA16;
                    downloadInfo.setIdentifier(cursorM.getLong(i20));
                    int i21 = iA17;
                    downloadInfo.setDownloadOnEnqueue(cursorM.getInt(i21) != 0);
                    int i22 = iA18;
                    downloadInfo.setExtras(za.a.a(cursorM.getString(i22)));
                    iA17 = i21;
                    int i23 = iA19;
                    downloadInfo.setAutoRetryMaxAttempts(cursorM.getInt(i23));
                    iA19 = i23;
                    int i24 = iA20;
                    downloadInfo.setAutoRetryAttempts(cursorM.getInt(i24));
                    arrayList = arrayList2;
                    arrayList.add(downloadInfo);
                    iA20 = i24;
                    iA = i12;
                    iA15 = i18;
                    iA16 = i20;
                    iA18 = i22;
                    iA2 = i13;
                }
                cursorM.close();
                lVar.C();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorM.close();
                lVar.C();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = lVarW;
        }
    }

    @Override // za.b
    public ArrayList t() throws Throwable {
        l lVar;
        Status.a aVar = Status.f8188b;
        l lVarW = l.w(1, "SELECT * FROM requests WHERE _status = ? ORDER BY _priority DESC, _created DESC");
        lVarW.h0(1, 1);
        RoomDatabase roomDatabase = (RoomDatabase) this.f8087a;
        roomDatabase.b();
        Cursor cursorM = roomDatabase.m(lVarW);
        try {
            int iA = v1.a.a(cursorM, "_id");
            int iA2 = v1.a.a(cursorM, "_namespace");
            int iA3 = v1.a.a(cursorM, "_url");
            int iA4 = v1.a.a(cursorM, "_file");
            int iA5 = v1.a.a(cursorM, "_group");
            int iA6 = v1.a.a(cursorM, "_priority");
            int iA7 = v1.a.a(cursorM, "_headers");
            int iA8 = v1.a.a(cursorM, "_written_bytes");
            int iA9 = v1.a.a(cursorM, "_total_bytes");
            int iA10 = v1.a.a(cursorM, "_status");
            int iA11 = v1.a.a(cursorM, "_error");
            int iA12 = v1.a.a(cursorM, "_network_type");
            int iA13 = v1.a.a(cursorM, "_created");
            int iA14 = v1.a.a(cursorM, "_tag");
            lVar = lVarW;
            try {
                int iA15 = v1.a.a(cursorM, "_enqueue_action");
                int iA16 = v1.a.a(cursorM, "_identifier");
                int iA17 = v1.a.a(cursorM, "_download_on_enqueue");
                int iA18 = v1.a.a(cursorM, "_extras");
                int iA19 = v1.a.a(cursorM, "_auto_retry_max_attempts");
                int iA20 = v1.a.a(cursorM, "_auto_retry_attempts");
                int i10 = iA14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    ArrayList arrayList2 = arrayList;
                    downloadInfo.setId(cursorM.getInt(iA));
                    downloadInfo.setNamespace(cursorM.getString(iA2));
                    downloadInfo.setUrl(cursorM.getString(iA3));
                    downloadInfo.setFile(cursorM.getString(iA4));
                    downloadInfo.setGroup(cursorM.getInt(iA5));
                    int i11 = cursorM.getInt(iA6);
                    Priority.f8179b.getClass();
                    downloadInfo.setPriority(Priority.a.a(i11));
                    downloadInfo.setHeaders(za.a.c(cursorM.getString(iA7)));
                    int i12 = iA;
                    int i13 = iA2;
                    downloadInfo.setDownloaded(cursorM.getLong(iA8));
                    downloadInfo.setTotal(cursorM.getLong(iA9));
                    int i14 = cursorM.getInt(iA10);
                    Status.f8188b.getClass();
                    downloadInfo.setStatus(Status.a.a(i14));
                    int i15 = cursorM.getInt(iA11);
                    Error.f8153b.getClass();
                    downloadInfo.setError(Error.a.a(i15));
                    int i16 = cursorM.getInt(iA12);
                    NetworkType.f8173b.getClass();
                    downloadInfo.setNetworkType(NetworkType.a.a(i16));
                    downloadInfo.setCreated(cursorM.getLong(iA13));
                    int i17 = i10;
                    downloadInfo.setTag(cursorM.isNull(i17) ? null : cursorM.getString(i17));
                    int i18 = iA15;
                    int i19 = cursorM.getInt(i18);
                    EnqueueAction.f8147b.getClass();
                    downloadInfo.setEnqueueAction(EnqueueAction.a.a(i19));
                    i10 = i17;
                    int i20 = iA16;
                    downloadInfo.setIdentifier(cursorM.getLong(i20));
                    int i21 = iA17;
                    downloadInfo.setDownloadOnEnqueue(cursorM.getInt(i21) != 0);
                    int i22 = iA18;
                    downloadInfo.setExtras(za.a.a(cursorM.getString(i22)));
                    iA17 = i21;
                    int i23 = iA19;
                    downloadInfo.setAutoRetryMaxAttempts(cursorM.getInt(i23));
                    iA19 = i23;
                    int i24 = iA20;
                    downloadInfo.setAutoRetryAttempts(cursorM.getInt(i24));
                    arrayList = arrayList2;
                    arrayList.add(downloadInfo);
                    iA20 = i24;
                    iA = i12;
                    iA15 = i18;
                    iA16 = i20;
                    iA18 = i22;
                    iA2 = i13;
                }
                cursorM.close();
                lVar.C();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorM.close();
                lVar.C();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = lVarW;
        }
    }

    public int u(String str) throws NumberFormatException {
        String string = ((sa.a) this.f8089c).f11898a.getString("event_filters", "");
        if (!TextUtils.isEmpty(string)) {
            for (String str2 : string.split(",")) {
                String str3 = str2.split(":")[0];
                int i10 = Integer.parseInt(str2.split(":")[1]);
                if (str3.equals(str)) {
                    return i10;
                }
            }
        }
        return 1;
    }

    public void v(String str, long j10, long j11, long j12) {
        if (((sa.a) this.f8089c).f11898a.getBoolean(ModelFlowMeta.KEY_ACTIVE, true) && u(str) != -1) {
            RpkEvent rpkEvent = new RpkEvent();
            rpkEvent.f8045a = "page";
            rpkEvent.f8046b = str;
            rpkEvent.f8047c = str;
            HashMap map = new HashMap();
            map.put("start", String.valueOf(j10));
            map.put("end", String.valueOf(j11));
            map.put("duration2", String.valueOf(j12));
            rpkEvent.f8048d = map;
            rpkEvent.f8049e = ((e) this.f8090d).f8077c.a();
            ((c) this.f8087a).a(rpkEvent, (RpkInfo) this.f8088b);
        }
    }

    public void w(Object obj, JsonGenerator jsonGenerator, b3.h hVar) throws InvalidDefinitionException {
        AnnotatedMember annotatedMember = (AnnotatedMember) this.f8088b;
        Object objK = annotatedMember.k(obj);
        if (objK == null) {
            return;
        }
        if (objK instanceof Map) {
            MapSerializer mapSerializer = (MapSerializer) this.f8090d;
            if (mapSerializer != null) {
                mapSerializer.s((Map) objK, jsonGenerator, hVar);
                return;
            } else {
                ((b3.f) this.f8089c).f(objK, jsonGenerator, hVar);
                return;
            }
        }
        hVar.j("Value returned by 'any-getter' " + annotatedMember.d() + "() not java.util.Map but " + objK.getClass().getName());
        throw null;
    }

    public g(WorkDatabase_Impl workDatabase_Impl, int i10) {
        switch (i10) {
            case 4:
                this.f8087a = workDatabase_Impl;
                this.f8088b = new q2.c(workDatabase_Impl, 4);
                int i11 = 1;
                this.f8089c = new i(workDatabase_Impl, i11);
                this.f8090d = new j(workDatabase_Impl, i11);
                break;
            default:
                this.f8087a = workDatabase_Impl;
                this.f8088b = new q2.c(workDatabase_Impl, 2);
                int i12 = 0;
                this.f8089c = new i(workDatabase_Impl, i12);
                this.f8090d = new j(workDatabase_Impl, i12);
                break;
        }
    }
}
