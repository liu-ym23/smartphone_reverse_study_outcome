package Z;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import d0.InterfaceC0647b;
import d0.InterfaceC0651f;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import n.C0870b;
import q.C0933a;
import q.C0934b;

/* loaded from: classes.dex */
public class e {

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f6541m = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: b, reason: collision with root package name */
    private String[] f6543b;

    /* renamed from: c, reason: collision with root package name */
    long[] f6544c;

    /* renamed from: f, reason: collision with root package name */
    final g f6547f;

    /* renamed from: i, reason: collision with root package name */
    volatile InterfaceC0651f f6550i;

    /* renamed from: j, reason: collision with root package name */
    private b f6551j;

    /* renamed from: d, reason: collision with root package name */
    Object[] f6545d = new Object[1];

    /* renamed from: e, reason: collision with root package name */
    long f6546e = 0;

    /* renamed from: g, reason: collision with root package name */
    AtomicBoolean f6548g = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f6549h = false;

    /* renamed from: k, reason: collision with root package name */
    final C0870b<c, d> f6552k = new C0870b<>();

    /* renamed from: l, reason: collision with root package name */
    Runnable f6553l = new a();

    /* renamed from: a, reason: collision with root package name */
    C0933a<String, Integer> f6542a = new C0933a<>();

    class a implements Runnable {
        a() {
        }

        private boolean a() {
            e eVar = e.this;
            Cursor cursorQ = eVar.f6547f.q("SELECT * FROM room_table_modification_log WHERE version  > ? ORDER BY version ASC;", eVar.f6545d);
            boolean z5 = false;
            while (cursorQ.moveToNext()) {
                try {
                    long j5 = cursorQ.getLong(0);
                    int i5 = cursorQ.getInt(1);
                    e eVar2 = e.this;
                    eVar2.f6544c[i5] = j5;
                    eVar2.f6546e = j5;
                    z5 = true;
                } finally {
                    cursorQ.close();
                }
            }
            return z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Lock lockG = e.this.f6547f.g();
            boolean zA = false;
            try {
                try {
                    lockG.lock();
                } catch (SQLiteException | IllegalStateException e6) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e6);
                }
                if (!e.this.d()) {
                    lockG.unlock();
                    return;
                }
                if (!e.this.f6548g.compareAndSet(true, false)) {
                    lockG.unlock();
                    return;
                }
                if (e.this.f6547f.k()) {
                    lockG.unlock();
                    return;
                }
                e.this.f6550i.n();
                e eVar = e.this;
                eVar.f6545d[0] = Long.valueOf(eVar.f6546e);
                g gVar = e.this.f6547f;
                if (gVar.f6573f) {
                    InterfaceC0647b interfaceC0647bB = gVar.i().b();
                    try {
                        interfaceC0647bB.g();
                        zA = a();
                        interfaceC0647bB.B();
                        interfaceC0647bB.P();
                    } catch (Throwable th) {
                        interfaceC0647bB.P();
                        throw th;
                    }
                } else {
                    zA = a();
                }
                lockG.unlock();
                if (zA) {
                    synchronized (e.this.f6552k) {
                        try {
                            Iterator<Map.Entry<c, d>> it = e.this.f6552k.iterator();
                            while (it.hasNext()) {
                                it.next().getValue().a(e.this.f6544c);
                            }
                        } finally {
                        }
                    }
                }
            } finally {
                lockG.unlock();
            }
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        final long[] f6555a;

        /* renamed from: b, reason: collision with root package name */
        final boolean[] f6556b;

        /* renamed from: c, reason: collision with root package name */
        final int[] f6557c;

        /* renamed from: d, reason: collision with root package name */
        boolean f6558d;

        /* renamed from: e, reason: collision with root package name */
        boolean f6559e;

        b(int i5) {
            long[] jArr = new long[i5];
            this.f6555a = jArr;
            boolean[] zArr = new boolean[i5];
            this.f6556b = zArr;
            this.f6557c = new int[i5];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        int[] a() {
            synchronized (this) {
                try {
                    if (this.f6558d && !this.f6559e) {
                        int length = this.f6555a.length;
                        int i5 = 0;
                        while (true) {
                            int i6 = 1;
                            if (i5 >= length) {
                                this.f6559e = true;
                                this.f6558d = false;
                                return this.f6557c;
                            }
                            boolean z5 = this.f6555a[i5] > 0;
                            boolean[] zArr = this.f6556b;
                            if (z5 != zArr[i5]) {
                                int[] iArr = this.f6557c;
                                if (!z5) {
                                    i6 = 2;
                                }
                                iArr[i5] = i6;
                            } else {
                                this.f6557c[i5] = 0;
                            }
                            zArr[i5] = z5;
                            i5++;
                        }
                    }
                    return null;
                } finally {
                }
            }
        }

        boolean b(int... iArr) {
            boolean z5;
            synchronized (this) {
                try {
                    z5 = false;
                    for (int i5 : iArr) {
                        long[] jArr = this.f6555a;
                        long j5 = jArr[i5];
                        jArr[i5] = 1 + j5;
                        if (j5 == 0) {
                            z5 = true;
                            this.f6558d = true;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z5;
        }

        boolean c(int... iArr) {
            boolean z5;
            synchronized (this) {
                try {
                    z5 = false;
                    for (int i5 : iArr) {
                        long[] jArr = this.f6555a;
                        long j5 = jArr[i5];
                        jArr[i5] = j5 - 1;
                        if (j5 == 1) {
                            z5 = true;
                            this.f6558d = true;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z5;
        }

        void d() {
            synchronized (this) {
                this.f6559e = false;
            }
        }
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        final int[] f6561a;

        /* renamed from: b, reason: collision with root package name */
        private final String[] f6562b;

        /* renamed from: c, reason: collision with root package name */
        private final long[] f6563c;

        /* renamed from: d, reason: collision with root package name */
        final c f6564d;

        /* renamed from: e, reason: collision with root package name */
        private final Set<String> f6565e;

        d(c cVar, int[] iArr, String[] strArr, long[] jArr) {
            this.f6564d = cVar;
            this.f6561a = iArr;
            this.f6562b = strArr;
            this.f6563c = jArr;
            if (iArr.length != 1) {
                this.f6565e = null;
                return;
            }
            C0934b c0934b = new C0934b();
            c0934b.add(strArr[0]);
            this.f6565e = Collections.unmodifiableSet(c0934b);
        }

        void a(long[] jArr) {
            int length = this.f6561a.length;
            Set<String> c0934b = null;
            for (int i5 = 0; i5 < length; i5++) {
                long j5 = jArr[this.f6561a[i5]];
                long[] jArr2 = this.f6563c;
                if (jArr2[i5] < j5) {
                    jArr2[i5] = j5;
                    if (length == 1) {
                        c0934b = this.f6565e;
                    } else {
                        if (c0934b == null) {
                            c0934b = new C0934b<>(length);
                        }
                        c0934b.add(this.f6562b[i5]);
                    }
                }
            }
            if (c0934b != null) {
                this.f6564d.a(c0934b);
            }
        }
    }

    /* renamed from: Z.e$e, reason: collision with other inner class name */
    static class C0094e extends c {

        /* renamed from: b, reason: collision with root package name */
        final e f6566b;

        /* renamed from: c, reason: collision with root package name */
        final WeakReference<c> f6567c;

        C0094e(e eVar, c cVar) {
            super(cVar.f6560a);
            this.f6566b = eVar;
            this.f6567c = new WeakReference<>(cVar);
        }

        @Override // Z.e.c
        public void a(Set<String> set) {
            c cVar = this.f6567c.get();
            if (cVar == null) {
                this.f6566b.g(this);
            } else {
                cVar.a(set);
            }
        }
    }

    public e(g gVar, String... strArr) {
        this.f6547f = gVar;
        this.f6551j = new b(strArr.length);
        int length = strArr.length;
        this.f6543b = new String[length];
        for (int i5 = 0; i5 < length; i5++) {
            String lowerCase = strArr[i5].toLowerCase(Locale.US);
            this.f6542a.put(lowerCase, Integer.valueOf(i5));
            this.f6543b[i5] = lowerCase;
        }
        long[] jArr = new long[strArr.length];
        this.f6544c = jArr;
        Arrays.fill(jArr, 0L);
    }

    private static void c(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private void h(InterfaceC0647b interfaceC0647b, int i5) {
        String str = this.f6543b[i5];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f6541m) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            c(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN INSERT OR REPLACE INTO ");
            sb.append("room_table_modification_log");
            sb.append(" VALUES(null, ");
            sb.append(i5);
            sb.append("); END");
            interfaceC0647b.k(sb.toString());
        }
    }

    private void i(InterfaceC0647b interfaceC0647b, int i5) {
        String str = this.f6543b[i5];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f6541m) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            c(sb, str, str2);
            interfaceC0647b.k(sb.toString());
        }
    }

    public void a(c cVar) {
        d dVarM;
        String[] strArr = cVar.f6560a;
        int[] iArr = new int[strArr.length];
        int length = strArr.length;
        long[] jArr = new long[strArr.length];
        for (int i5 = 0; i5 < length; i5++) {
            Integer num = this.f6542a.get(strArr[i5].toLowerCase(Locale.US));
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + strArr[i5]);
            }
            iArr[i5] = num.intValue();
            jArr[i5] = this.f6546e;
        }
        d dVar = new d(cVar, iArr, strArr, jArr);
        synchronized (this.f6552k) {
            dVarM = this.f6552k.m(cVar, dVar);
        }
        if (dVarM == null && this.f6551j.b(iArr)) {
            j();
        }
    }

    public void b(c cVar) {
        a(new C0094e(this, cVar));
    }

    boolean d() {
        if (!this.f6547f.o()) {
            return false;
        }
        if (!this.f6549h) {
            this.f6547f.i().b();
        }
        if (this.f6549h) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    void e(InterfaceC0647b interfaceC0647b) {
        synchronized (this) {
            try {
                if (this.f6549h) {
                    Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                    return;
                }
                interfaceC0647b.g();
                try {
                    interfaceC0647b.k("PRAGMA temp_store = MEMORY;");
                    interfaceC0647b.k("PRAGMA recursive_triggers='ON';");
                    interfaceC0647b.k("CREATE TEMP TABLE room_table_modification_log(version INTEGER PRIMARY KEY AUTOINCREMENT, table_id INTEGER)");
                    interfaceC0647b.B();
                    interfaceC0647b.P();
                    k(interfaceC0647b);
                    this.f6550i = interfaceC0647b.p("DELETE FROM room_table_modification_log WHERE version NOT IN( SELECT MAX(version) FROM room_table_modification_log GROUP BY table_id)");
                    this.f6549h = true;
                } catch (Throwable th) {
                    interfaceC0647b.P();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void f() {
        if (this.f6548g.compareAndSet(false, true)) {
            this.f6547f.j().execute(this.f6553l);
        }
    }

    public void g(c cVar) {
        d dVarN;
        synchronized (this.f6552k) {
            dVarN = this.f6552k.n(cVar);
        }
        if (dVarN == null || !this.f6551j.c(dVarN.f6561a)) {
            return;
        }
        j();
    }

    void j() {
        if (this.f6547f.o()) {
            k(this.f6547f.i().b());
        }
    }

    void k(InterfaceC0647b interfaceC0647b) {
        if (interfaceC0647b.i0()) {
            return;
        }
        while (true) {
            try {
                Lock lockG = this.f6547f.g();
                lockG.lock();
                try {
                    int[] iArrA = this.f6551j.a();
                    if (iArrA == null) {
                        return;
                    }
                    int length = iArrA.length;
                    try {
                        interfaceC0647b.g();
                        for (int i5 = 0; i5 < length; i5++) {
                            int i6 = iArrA[i5];
                            if (i6 == 1) {
                                h(interfaceC0647b, i5);
                            } else if (i6 == 2) {
                                i(interfaceC0647b, i5);
                            }
                        }
                        interfaceC0647b.B();
                        interfaceC0647b.P();
                        this.f6551j.d();
                    } finally {
                    }
                } finally {
                    lockG.unlock();
                }
            } catch (SQLiteException | IllegalStateException e6) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e6);
                return;
            }
        }
    }

    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final String[] f6560a;

        protected c(String str, String... strArr) {
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
            this.f6560a = strArr2;
            strArr2[strArr.length] = str;
        }

        public abstract void a(Set<String> set);

        public c(String[] strArr) {
            this.f6560a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }
}
