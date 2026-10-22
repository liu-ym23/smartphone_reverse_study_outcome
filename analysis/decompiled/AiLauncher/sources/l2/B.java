package l2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import e2.AbstractC3981h;
import e2.C3980g;
import h2.C4124a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import m2.InterfaceC4893a;
import n2.InterfaceC4936a;
import o2.C4998a;

/* loaded from: classes2.dex */
public class B implements InterfaceC4863c, InterfaceC4893a {

    /* renamed from: e, reason: collision with root package name */
    public static final b2.b f36877e = b2.b.b("proto");

    /* renamed from: a, reason: collision with root package name */
    public final H f36878a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC4936a f36879b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC4936a f36880c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC4864d f36881d;

    public interface b<T, U> {
        U apply(T t10);
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f36882a;

        /* renamed from: b, reason: collision with root package name */
        public final String f36883b;

        public c(String str, String str2) {
            this.f36882a = str;
            this.f36883b = str2;
        }
    }

    public interface d<T> {
        T produce();
    }

    public B(InterfaceC4936a interfaceC4936a, InterfaceC4936a interfaceC4936a2, AbstractC4864d abstractC4864d, H h10) {
        this.f36878a = h10;
        this.f36879b = interfaceC4936a;
        this.f36880c = interfaceC4936a2;
        this.f36881d = abstractC4864d;
    }

    public static /* synthetic */ List D0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(e2.m.a().b(cursor.getString(1)).d(C4998a.b(cursor.getInt(2))).c(l1(cursor.getString(3))).a());
        }
        return arrayList;
    }

    public static /* synthetic */ List I0(SQLiteDatabase sQLiteDatabase) {
        return (List) v1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), t.a());
    }

    public static /* synthetic */ List N0(B b10, e2.m mVar, SQLiteDatabase sQLiteDatabase) {
        List<AbstractC4869i> listH1 = b10.h1(sQLiteDatabase, mVar);
        return b10.J(listH1, b10.k1(sQLiteDatabase, listH1));
    }

    public static /* synthetic */ Object R0(B b10, List list, e2.m mVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j10 = cursor.getLong(0);
            boolean z10 = cursor.getInt(7) != 0;
            AbstractC3981h.a aVarK = AbstractC3981h.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            if (z10) {
                aVarK.h(new C3980g(t1(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                aVarK.h(new C3980g(t1(cursor.getString(4)), b10.m1(j10)));
            }
            if (!cursor.isNull(6)) {
                aVarK.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(AbstractC4869i.a(j10, mVar, aVarK.d()));
        }
        return null;
    }

    public static /* synthetic */ Object T0(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j10 = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j10));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j10), hashSet);
            }
            hashSet.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    public static /* synthetic */ Object V(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    public static /* synthetic */ Object Y(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    public static /* synthetic */ Long Y0(B b10, e2.m mVar, AbstractC3981h abstractC3981h, SQLiteDatabase sQLiteDatabase) {
        if (b10.G()) {
            return -1L;
        }
        long jG = b10.g(sQLiteDatabase, mVar);
        int iE = b10.f36881d.e();
        byte[] bArrA = abstractC3981h.e().a();
        boolean z10 = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(jG));
        contentValues.put("transport_name", abstractC3981h.j());
        contentValues.put("timestamp_ms", Long.valueOf(abstractC3981h.f()));
        contentValues.put("uptime_ms", Long.valueOf(abstractC3981h.k()));
        contentValues.put("payload_encoding", abstractC3981h.e().b().a());
        contentValues.put("code", abstractC3981h.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z10));
        contentValues.put("payload", z10 ? bArrA : new byte[0]);
        long jInsert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z10) {
            int iCeil = (int) Math.ceil(bArrA.length / iE);
            for (int i10 = 1; i10 <= iCeil; i10++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i10 - 1) * iE, Math.min(i10 * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i10));
                contentValues2.put(SingleFileBundle.KEY_BYTES, bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : abstractC3981h.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(jInsert));
            contentValues3.put("name", entry.getKey());
            contentValues3.put(UxipConstants.f30680s, entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(jInsert);
    }

    public static /* synthetic */ byte[] a1(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            byte[] bArr2 = (byte[]) arrayList.get(i10);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    public static /* synthetic */ Object b1(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    public static /* synthetic */ SQLiteDatabase e0(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    public static /* synthetic */ Object f1(long j10, e2.m mVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j10));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{mVar.b(), String.valueOf(C4998a.a(mVar.d()))}) < 1) {
            contentValues.put("backend_name", mVar.b());
            contentValues.put("priority", Integer.valueOf(C4998a.a(mVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    public static /* synthetic */ Long g0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public static /* synthetic */ Long k0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    public static byte[] l1(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static b2.b t1(String str) {
        return str == null ? f36877e : b2.b.b(str);
    }

    public static String u1(Iterable<AbstractC4869i> iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator<AbstractC4869i> it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().c());
            if (it.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public static /* synthetic */ Boolean v0(B b10, e2.m mVar, SQLiteDatabase sQLiteDatabase) {
        Long lN = b10.n(sQLiteDatabase, mVar);
        return lN == null ? Boolean.FALSE : (Boolean) v1(b10.i().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lN.toString()}), u.a());
    }

    public static <T> T v1(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public <T> T A(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase sQLiteDatabaseI = i();
        sQLiteDatabaseI.beginTransaction();
        try {
            T tApply = bVar.apply(sQLiteDatabaseI);
            sQLiteDatabaseI.setTransactionSuccessful();
            return tApply;
        } finally {
            sQLiteDatabaseI.endTransaction();
        }
    }

    @Override // l2.InterfaceC4863c
    public boolean C0(e2.m mVar) {
        return ((Boolean) A(C4860A.a(this, mVar))).booleanValue();
    }

    @Override // l2.InterfaceC4863c
    public Iterable<e2.m> D() {
        return (Iterable) A(l.a());
    }

    public final boolean G() {
        return l() * m() >= this.f36881d.f();
    }

    public final List<AbstractC4869i> J(List<AbstractC4869i> list, Map<Long, Set<c>> map) {
        ListIterator<AbstractC4869i> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            AbstractC4869i next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                AbstractC3981h.a aVarL = next.b().l();
                for (c cVar : map.get(Long.valueOf(next.c()))) {
                    aVarL.c(cVar.f36882a, cVar.f36883b);
                }
                listIterator.set(AbstractC4869i.a(next.c(), next.d(), aVarL.d()));
            }
        }
        return list;
    }

    @Override // l2.InterfaceC4863c
    public Iterable<AbstractC4869i> M0(e2.m mVar) {
        return (Iterable) A(k.a(this, mVar));
    }

    @Override // l2.InterfaceC4863c
    public long W(e2.m mVar) {
        return ((Long) v1(i().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{mVar.b(), String.valueOf(C4998a.a(mVar.d()))}), z.a())).longValue();
    }

    @Override // m2.InterfaceC4893a
    public <T> T b(InterfaceC4893a.InterfaceC0472a<T> interfaceC0472a) {
        SQLiteDatabase sQLiteDatabaseI = i();
        e(sQLiteDatabaseI);
        try {
            T tExecute = interfaceC0472a.execute();
            sQLiteDatabaseI.setTransactionSuccessful();
            return tExecute;
        } finally {
            sQLiteDatabaseI.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f36878a.close();
    }

    @Override // l2.InterfaceC4863c
    public void d0(e2.m mVar, long j10) {
        A(j.a(j10, mVar));
    }

    public final void e(SQLiteDatabase sQLiteDatabase) {
        s1(q.a(sQLiteDatabase), r.a());
    }

    public final long g(SQLiteDatabase sQLiteDatabase, e2.m mVar) {
        Long lN = n(sQLiteDatabase, mVar);
        if (lN != null) {
            return lN.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", mVar.b());
        contentValues.put("priority", Integer.valueOf(C4998a.a(mVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (mVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(mVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    public final List<AbstractC4869i> h1(SQLiteDatabase sQLiteDatabase, e2.m mVar) {
        ArrayList arrayList = new ArrayList();
        Long lN = n(sQLiteDatabase, mVar);
        if (lN == null) {
            return arrayList;
        }
        v1(sQLiteDatabase.query("events", new String[]{StepOSRecipientEmailHistory._ID, "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lN.toString()}, null, null, null, String.valueOf(this.f36881d.d())), n.a(this, arrayList, mVar));
        return arrayList;
    }

    public SQLiteDatabase i() {
        H h10 = this.f36878a;
        h10.getClass();
        return (SQLiteDatabase) s1(s.a(h10), v.a());
    }

    public final Map<Long, Set<c>> k1(SQLiteDatabase sQLiteDatabase, List<AbstractC4869i> list) {
        HashMap map = new HashMap();
        StringBuilder sb2 = new StringBuilder("event_id IN (");
        for (int i10 = 0; i10 < list.size(); i10++) {
            sb2.append(list.get(i10).c());
            if (i10 < list.size() - 1) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        v1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", UxipConstants.f30680s}, sb2.toString(), null, null, null, null), p.a(map));
        return map;
    }

    public final long l() {
        return i().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    public final long m() {
        return i().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    public final byte[] m1(long j10) {
        return (byte[]) v1(i().query("event_payloads", new String[]{SingleFileBundle.KEY_BYTES}, "event_id = ?", new String[]{String.valueOf(j10)}, null, null, "sequence_num"), o.a());
    }

    public final Long n(SQLiteDatabase sQLiteDatabase, e2.m mVar) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(mVar.b(), String.valueOf(C4998a.a(mVar.d()))));
        if (mVar.c() != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(mVar.c(), 0));
        } else {
            sb2.append(" and extras is null");
        }
        return (Long) v1(sQLiteDatabase.query("transport_contexts", new String[]{StepOSRecipientEmailHistory._ID}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), x.a());
    }

    @Override // l2.InterfaceC4863c
    public int q() {
        return ((Integer) A(m.a(this.f36879b.a() - this.f36881d.c()))).intValue();
    }

    @Override // l2.InterfaceC4863c
    public void r(Iterable<AbstractC4869i> iterable) {
        if (iterable.iterator().hasNext()) {
            i().compileStatement("DELETE FROM events WHERE _id in " + u1(iterable)).execute();
        }
    }

    @Override // l2.InterfaceC4863c
    public void r0(Iterable<AbstractC4869i> iterable) {
        if (iterable.iterator().hasNext()) {
            A(y.a("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + u1(iterable)));
        }
    }

    @Override // l2.InterfaceC4863c
    public AbstractC4869i s(e2.m mVar, AbstractC3981h abstractC3981h) {
        C4124a.b("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", mVar.d(), abstractC3981h.j(), mVar.b());
        long jLongValue = ((Long) A(w.a(this, mVar, abstractC3981h))).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return AbstractC4869i.a(jLongValue, mVar, abstractC3981h);
    }

    public final <T> T s1(d<T> dVar, b<Throwable, T> bVar) {
        long jA = this.f36880c.a();
        while (true) {
            try {
                return dVar.produce();
            } catch (SQLiteDatabaseLockedException e10) {
                if (this.f36880c.a() >= this.f36881d.b() + jA) {
                    return bVar.apply(e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }
}
