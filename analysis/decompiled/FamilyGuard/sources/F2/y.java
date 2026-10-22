package F2;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import androidx.lifecycle.AbstractC0545z;
import androidx.lifecycle.C0521a;
import com.stepos.digitalwellbeing.server.data.WhitelistAppInfo;
import com.stepos.minor.Minor;
import com.stepos.minor.MinorDataBase;
import com.stepos.minor.MinorProvider;
import com.stepos.minor.WhitelistApp;
import f2.C0702g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import v2.C1183b;
import w2.C1245p0;
import w2.W0;
import w2.o1;
import x3.AbstractC1286b;
import z3.C1347a;

/* loaded from: classes.dex */
public class y extends C0521a {

    /* renamed from: c, reason: collision with root package name */
    private final MinorDataBase f1717c;

    /* renamed from: d, reason: collision with root package name */
    private final AbstractC0545z<List<Minor>> f1718d;

    /* renamed from: e, reason: collision with root package name */
    private final AbstractC0545z<Minor> f1719e;

    /* renamed from: f, reason: collision with root package name */
    private final o1 f1720f;

    public y(Application application) {
        super(application);
        MinorDataBase minorDataBaseB = g.a(K()).b();
        this.f1717c = minorDataBaseB;
        e eVarT = minorDataBaseB.t();
        this.f1718d = eVarT.l();
        this.f1719e = eVarT.i();
        this.f1720f = new o1(new C1183b(application));
    }

    public static int G0(Context context, e eVar, boolean z5) {
        synchronized (y.class) {
            try {
                if (z5) {
                    Minor minorM = eVar.m();
                    if (minorM == null) {
                        throw new IllegalStateException("can not find selected minor");
                    }
                    int iX = eVar.x(true);
                    Minor minorD = eVar.d(minorM.getId());
                    y0(context, -1L, minorD == null ? minorM.getId() : minorD.getId(), minorD == null ? minorM.getAgeRange() : minorD.getAgeRange());
                    MinorProvider.o(context, true);
                    C0702g.b("MinorModel", "switchMode: on = " + z5 + " updated = " + iX + " updatedMinor = " + minorD);
                } else {
                    Minor minorG = eVar.g();
                    if (minorG == null) {
                        C0702g.O("MinorModel", "switchMode() called, but no active minor");
                        return 0;
                    }
                    int iX2 = eVar.x(false);
                    Minor minorD2 = eVar.d(minorG.getId());
                    y0(context, minorG.getId(), -1L, 0);
                    MinorProvider.o(context, false);
                    C0702g.b("MinorModel", "switchMode: on = " + z5 + " updated = " + iX2 + " updatedMinor = " + minorD2);
                }
                return 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int H0(Context context, e eVar, Minor minor, W0 w02) {
        int iZ;
        synchronized (y.class) {
            try {
                Minor minorG = eVar.g();
                long id = minorG == null ? -1L : minorG.getId();
                iZ = eVar.z(minor);
                if (iZ > 0) {
                    if (minor.isActivated()) {
                        y0(context, id, minor.getId(), minor.getAgeRange());
                    } else {
                        MinorProvider.n(context);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iZ;
    }

    public static /* synthetic */ void R(Boolean bool) {
    }

    public static int a0(Context context, e eVar, long j5) {
        C0702g.b("MinorModel", "changeActiveMinor() called with: activeId = [" + j5 + "]");
        synchronized (e.class) {
            try {
                Minor minorG = eVar.g();
                long id = minorG == null ? -1L : minorG.getId();
                if (j5 == id) {
                    return 0;
                }
                eVar.v(j5, 2);
                Minor minorG2 = eVar.g();
                int ageRange = minorG2 != null ? minorG2.getAgeRange() : 0;
                if (minorG == null) {
                    y0(context, id, j5, ageRange);
                    MinorProvider.o(context, true);
                } else {
                    y0(context, id, j5, ageRange);
                }
                return 1;
            } finally {
            }
        }
    }

    public static int b0(Context context, e eVar, long j5) {
        C0702g.b("MinorModel", "changeSelectedMinor() called with: selectedId = [" + j5 + "]");
        synchronized (e.class) {
            try {
                Minor minorM = eVar.m();
                if (j5 == (minorM == null ? -1L : minorM.getId())) {
                    return 0;
                }
                eVar.v(j5, 1);
                return 1;
            } finally {
            }
        }
    }

    public static int d0(Context context, e eVar, long j5, o1 o1Var) {
        int iA;
        Context context2;
        synchronized (y.class) {
            try {
                Minor minorG = eVar.g();
                long id = minorG == null ? -1L : minorG.getId();
                iA = eVar.a(j5);
                if (j5 == id) {
                    MinorProvider.o(context, false);
                    context2 = context;
                    y0(context2, id, -1L, 0);
                } else {
                    context2 = context;
                }
                z0(context2, new long[]{j5}, o1Var);
            } catch (Throwable th) {
                throw th;
            }
        }
        return iA;
    }

    private void e0(Cursor cursor, Minor minor) {
        minor.setId(cursor.getLong(cursor.getColumnIndex(Minor.COLUMN_ID)));
        minor.setName(cursor.getString(cursor.getColumnIndex(Minor.COLUMN_NAME)));
        minor.setIcon(cursor.getBlob(cursor.getColumnIndex(Minor.COLUMN_ICON)));
        minor.setBirthType(cursor.getInt(cursor.getColumnIndex(Minor.COLUMN_BIRTHDAY_TYPE)));
        minor.setBirthdayDate(cursor.getLong(cursor.getColumnIndex(Minor.COLUMN_BIRTHDAY_DATE)));
        minor.setBirthdayDateLunar(cursor.getInt(cursor.getColumnIndex(Minor.COLUMN_BIRTHDAY_DATE_LUNAR)));
        minor.setBirthdayAge(cursor.getInt(cursor.getColumnIndex(Minor.COLUMN_BIRTHDAY_AGE)));
        minor.setBirthdayRange(cursor.getInt(cursor.getColumnIndex(Minor.COLUMN_BIRTHDAY_RANGE)));
        minor.setState(cursor.getInt(cursor.getColumnIndex("state")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public List<Minor> s0() {
        Cursor cursorQuery = K().getContentResolver().query(MinorProvider.f15365d, null, null, null, null);
        try {
            ArrayList arrayList = new ArrayList();
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            }
            if (cursorQuery.moveToFirst()) {
                do {
                    Minor minor = new Minor();
                    e0(cursorQuery, minor);
                    arrayList.add(minor);
                } while (cursorQuery.moveToNext());
            }
            cursorQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            try {
                cursorQuery.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public static long n0(Context context, e eVar, Minor minor, W0 w02) {
        Context context2;
        long jQ;
        synchronized (y.class) {
            try {
                if (minor.isActivated() || minor.isSelected()) {
                    Minor minorG = eVar.g();
                    long id = minorG == null ? -1L : minorG.getId();
                    long jQ2 = eVar.q(minor);
                    long j5 = minor.isActivated() ? jQ2 : -1L;
                    if (id != j5) {
                        if (id == -1) {
                            MinorProvider.o(context, true);
                        }
                        context2 = context;
                        y0(context2, id, j5, minor.getAgeRange());
                    } else {
                        context2 = context;
                    }
                    jQ = jQ2;
                } else {
                    jQ = eVar.q(minor);
                    context2 = context;
                }
                MinorProvider.n(context2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return jQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long p0(Minor minor) {
        return Long.valueOf(n0(K(), this.f1717c.t(), minor, this.f1720f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer q0(long j5) {
        return Integer.valueOf(d0(K(), this.f1717c.t(), j5, this.f1720f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Q4.a r0(Integer num) {
        return h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer t0(Minor minor) {
        return Integer.valueOf(H0(K(), this.f1717c.t(), minor, this.f1720f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(z zVar) {
        this.f1717c.t().w(zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean v0(long j5, Long l5) {
        boolean zO0 = o0();
        E0(j5, zO0);
        return Boolean.valueOf(zO0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer w0(long j5) {
        return Integer.valueOf(a0(K(), this.f1717c.t(), j5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer x0(long j5) {
        return Integer.valueOf(b0(K(), this.f1717c.t(), j5));
    }

    private static void y0(Context context, long j5, long j6, int i5) {
        C1245p0 c1245p0F = C1245p0.f();
        MinorProvider.l(context, j5, j6, i5);
        c1245p0F.g(j6);
    }

    private static void z0(Context context, long[] jArr, o1 o1Var) {
        if (jArr == null || jArr.length == 0) {
            return;
        }
        MinorProvider.m(context, jArr);
        for (long j5 : jArr) {
            o1Var.V(j5);
        }
    }

    public x3.f<z> A0() {
        return this.f1717c.t().p();
    }

    public void B0(long j5, String str) {
        this.f1720f.W(new WhitelistAppInfo(str, j5, false));
    }

    public void C0(final z zVar) {
        AbstractC1286b.d(new Runnable() { // from class: F2.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f1697a.u0(zVar);
            }
        }).j(T3.a.c()).e(C1347a.a()).f();
    }

    public void D0(final long j5) {
        x3.f.D(Long.valueOf(j5)).E(new D3.h() { // from class: F2.s
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f1707a.v0(j5, (Long) obj);
            }
        }).X(T3.a.c()).G(C1347a.a()).T(new D3.c() { // from class: F2.t
            @Override // D3.c
            public final void accept(Object obj) {
                y.R((Boolean) obj);
            }
        }, S1.a.b());
    }

    public void E0(final long j5, final boolean z5) {
        C0702g.b("MinorModel", "selectMinor() called with: minorId = [" + j5 + "], activate = [" + z5 + "]");
        x3.f.x(z5 ? new Callable() { // from class: F2.u
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f1709a.w0(j5);
            }
        } : new Callable() { // from class: F2.v
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f1711a.x0(j5);
            }
        }).X(T3.a.c()).G(C1347a.a()).T(new D3.c() { // from class: F2.w
            @Override // D3.c
            public final void accept(Object obj) {
                C0702g.b("MinorModel", "selectMinor() called with: minorId = [" + j5 + "], activate = [" + z5 + "]");
            }
        }, S1.a.b());
    }

    public int F0(boolean z5) {
        return G0(K(), this.f1717c.t(), z5);
    }

    @Override // androidx.lifecycle.T
    protected void J() {
        super.J();
    }

    public void Y(final Minor minor) {
        x3.f.x(new Callable() { // from class: F2.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f1704a.p0(minor);
            }
        }).X(T3.a.c()).G(C1347a.a()).S(new D3.c() { // from class: F2.r
            @Override // D3.c
            public final void accept(Object obj) {
                C0702g.b("MinorModel", "addMinor() called with: " + minor);
            }
        });
    }

    public void Z(long j5, String str) {
        this.f1720f.U(new WhitelistAppInfo(str, j5, true));
    }

    public void c0(final long j5) {
        x3.f.x(new Callable() { // from class: F2.x
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f1715a.q0(j5);
            }
        }).r(new D3.h() { // from class: F2.m
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f1699a.r0((Integer) obj);
            }
        }).X(T3.a.c()).G(C1347a.a()).S(new D3.c() { // from class: F2.n
            @Override // D3.c
            public final void accept(Object obj) {
                C0702g.b("MinorModel", "deleteMinor() called with: minorId = [" + j5 + "], result = [" + ((List) obj) + "]");
            }
        });
    }

    public AbstractC0545z<Minor> f0(long j5) {
        return this.f1717c.t().f(j5);
    }

    public AbstractC0545z<Minor> g0() {
        return this.f1719e;
    }

    public x3.f<List<Minor>> h0() {
        return x3.f.x(new Callable() { // from class: F2.o
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f1701a.s0();
            }
        });
    }

    public AbstractC0545z<List<Minor>> i0() {
        return this.f1718d;
    }

    public x3.f<Integer> k0(final Minor minor) {
        return x3.f.x(new Callable() { // from class: F2.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f1702a.t0(minor);
            }
        }).X(T3.a.c()).G(C1347a.a());
    }

    public x3.f<List<WhitelistApp>> l0(long j5) {
        return this.f1717c.u().f(j5);
    }

    public AbstractC0545z<List<WhitelistApp>> m0(long j5) {
        return this.f1717c.u().g(j5);
    }

    public boolean o0() {
        return this.f1717c.t().g() != null;
    }
}
