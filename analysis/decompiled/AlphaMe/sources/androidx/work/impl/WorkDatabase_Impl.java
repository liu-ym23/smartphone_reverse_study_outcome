package androidx.work.impl;

import B0.b;
import B0.c;
import B0.e;
import B0.f;
import B0.i;
import B0.m;
import B0.p;
import B0.u;
import B0.w;
import androidx.room.C0353i;
import androidx.room.D;
import androidx.room.r;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k0.C0676d;
import k0.InterfaceC0674b;
import k0.g;
import kotlin.jvm.internal.Intrinsics;
import t0.C0908C;
import t0.C0909D;
import t0.C0910E;

/* loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: a, reason: collision with root package name */
    public volatile u f4322a;

    /* renamed from: b, reason: collision with root package name */
    public volatile c f4323b;

    /* renamed from: c, reason: collision with root package name */
    public volatile android.support.v4.media.session.c f4324c;

    /* renamed from: d, reason: collision with root package name */
    public volatile p f4325d;

    /* renamed from: e, reason: collision with root package name */
    public volatile m f4326e;

    /* renamed from: f, reason: collision with root package name */
    public volatile p f4327f;

    /* renamed from: g, reason: collision with root package name */
    public volatile e f4328g;

    @Override // androidx.work.impl.WorkDatabase
    public final c b() {
        c cVar;
        if (this.f4323b != null) {
            return this.f4323b;
        }
        synchronized (this) {
            try {
                if (this.f4323b == null) {
                    c cVar2 = new c();
                    cVar2.f136a = this;
                    cVar2.f137b = new b(cVar2, this, 0);
                    this.f4323b = cVar2;
                }
                cVar = this.f4323b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final e c() {
        e eVar;
        if (this.f4328g != null) {
            return this.f4328g;
        }
        synchronized (this) {
            try {
                if (this.f4328g == null) {
                    this.f4328g = new e((WorkDatabase) this);
                }
                eVar = this.f4328g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    @Override // androidx.room.A
    public final void clearAllTables() {
        super.assertNotMainThread();
        InterfaceC0674b writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
            writableDatabase.execSQL("DELETE FROM `Dependency`");
            writableDatabase.execSQL("DELETE FROM `WorkSpec`");
            writableDatabase.execSQL("DELETE FROM `WorkTag`");
            writableDatabase.execSQL("DELETE FROM `SystemIdInfo`");
            writableDatabase.execSQL("DELETE FROM `WorkName`");
            writableDatabase.execSQL("DELETE FROM `WorkProgress`");
            writableDatabase.execSQL("DELETE FROM `Preference`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.A
    public final r createInvalidationTracker() {
        return new r(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.room.A
    public final g createOpenHelper(C0353i c0353i) {
        D callback = new D(c0353i, new C0910E(this), "7d73d21f1bd82c9e5268b6dcf9fde2cb", "3071c8717539de5d5353f4c8cd59a032");
        C0676d c0676dD = E3.b.d(c0353i.f4205a);
        c0676dD.f13323b = c0353i.f4206b;
        Intrinsics.checkNotNullParameter(callback, "callback");
        c0676dD.f13324c = callback;
        return c0353i.f4207c.create(c0676dD.a());
    }

    @Override // androidx.work.impl.WorkDatabase
    public final i d() {
        p pVar;
        if (this.f4325d != null) {
            return this.f4325d;
        }
        synchronized (this) {
            try {
                if (this.f4325d == null) {
                    this.f4325d = new p(this, 1);
                }
                pVar = this.f4325d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final m e() {
        m mVar;
        if (this.f4326e != null) {
            return this.f4326e;
        }
        synchronized (this) {
            try {
                if (this.f4326e == null) {
                    this.f4326e = new m(this);
                }
                mVar = this.f4326e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final p f() {
        p pVar;
        if (this.f4327f != null) {
            return this.f4327f;
        }
        synchronized (this) {
            try {
                if (this.f4327f == null) {
                    this.f4327f = new p(this, 0);
                }
                pVar = this.f4327f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final u g() {
        u uVar;
        if (this.f4322a != null) {
            return this.f4322a;
        }
        synchronized (this) {
            try {
                if (this.f4322a == null) {
                    this.f4322a = new u(this);
                }
                uVar = this.f4322a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uVar;
    }

    @Override // androidx.room.A
    public final List getAutoMigrations(Map map) {
        return Arrays.asList(new C0908C(0), new C0909D(0), new C0908C(1), new C0908C(2), new C0908C(3), new C0909D(1));
    }

    @Override // androidx.room.A
    public final Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.A
    public final Map getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(u.class, Collections.emptyList());
        map.put(c.class, Collections.emptyList());
        map.put(w.class, Collections.emptyList());
        map.put(i.class, Collections.emptyList());
        map.put(m.class, Collections.emptyList());
        map.put(p.class, Collections.emptyList());
        map.put(e.class, Collections.emptyList());
        map.put(f.class, Collections.emptyList());
        return map;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final w h() {
        android.support.v4.media.session.c cVar;
        if (this.f4324c != null) {
            return this.f4324c;
        }
        synchronized (this) {
            try {
                if (this.f4324c == null) {
                    this.f4324c = new android.support.v4.media.session.c(this);
                }
                cVar = this.f4324c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }
}
