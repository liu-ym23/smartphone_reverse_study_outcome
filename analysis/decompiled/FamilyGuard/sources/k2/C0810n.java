package k2;

import android.database.Cursor;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.concurrent.Callable;
import x3.q;

/* renamed from: k2.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0810n extends AbstractC0809m {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f17899a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f17900b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.l f17901c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.l f17902d;

    /* renamed from: e, reason: collision with root package name */
    private final Z.l f17903e;

    /* renamed from: f, reason: collision with root package name */
    private final Z.l f17904f;

    /* renamed from: g, reason: collision with root package name */
    private final Z.l f17905g;

    /* renamed from: h, reason: collision with root package name */
    private final Z.l f17906h;

    /* renamed from: i, reason: collision with root package name */
    private final Z.l f17907i;

    /* renamed from: j, reason: collision with root package name */
    private final Z.l f17908j;

    /* renamed from: k, reason: collision with root package name */
    private final Z.l f17909k;

    /* renamed from: l, reason: collision with root package name */
    private final Z.l f17910l;

    /* renamed from: m, reason: collision with root package name */
    private final Z.l f17911m;

    /* renamed from: n, reason: collision with root package name */
    private final Z.l f17912n;

    /* renamed from: o, reason: collision with root package name */
    private final Z.l f17913o;

    /* renamed from: p, reason: collision with root package name */
    private final Z.l f17914p;

    /* renamed from: k2.n$a */
    class a extends Z.l {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from usingtimestatscache where relationId = (?)";
        }
    }

    /* renamed from: k2.n$b */
    class b extends Z.l {
        b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from packageusingtimestatscache where relationId = (?)";
        }
    }

    /* renamed from: k2.n$c */
    class c extends Z.l {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from categoryusingtimestatscache where relationId = (?)";
        }
    }

    /* renamed from: k2.n$d */
    class d extends Z.l {
        d(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from categorylimitcache where relationId = (?)";
        }
    }

    /* renamed from: k2.n$e */
    class e extends Z.l {
        e(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from packagelimitcache where relationId = (?)";
        }
    }

    /* renamed from: k2.n$f */
    class f extends Z.l {
        f(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from apppackage where relationId = (?)";
        }
    }

    /* renamed from: k2.n$g */
    class g implements Callable<l2.m> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f17921a;

        g(Z.j jVar) {
            this.f17921a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l2.m call() {
            l2.m mVar;
            Cursor cursorP = C0810n.this.f17899a.p(this.f17921a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow("role");
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("mImsi");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("mImei");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("mPhone");
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("lmodify");
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("postTime");
                int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("rImsi");
                int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("rImei");
                int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("rPhone");
                int columnIndexOrThrow11 = cursorP.getColumnIndexOrThrow("status");
                int columnIndexOrThrow12 = cursorP.getColumnIndexOrThrow("watchDays");
                int columnIndexOrThrow13 = cursorP.getColumnIndexOrThrow("mark");
                int columnIndexOrThrow14 = cursorP.getColumnIndexOrThrow("isTrack");
                int columnIndexOrThrow15 = cursorP.getColumnIndexOrThrow("rAppVersion");
                int columnIndexOrThrow16 = cursorP.getColumnIndexOrThrow("rLastAppVersion");
                int columnIndexOrThrow17 = cursorP.getColumnIndexOrThrow("type");
                int columnIndexOrThrow18 = cursorP.getColumnIndexOrThrow("masterRoleType");
                int columnIndexOrThrow19 = cursorP.getColumnIndexOrThrow("masterRoleName");
                int columnIndexOrThrow20 = cursorP.getColumnIndexOrThrow("slaveRoleName");
                if (cursorP.moveToFirst()) {
                    mVar = new l2.m();
                    mVar.f18243a = cursorP.getInt(columnIndexOrThrow);
                    mVar.f18244b = cursorP.getString(columnIndexOrThrow2);
                    mVar.f18245c = cursorP.getString(columnIndexOrThrow3);
                    mVar.f18246d = cursorP.getString(columnIndexOrThrow4);
                    mVar.f18247e = cursorP.getLong(columnIndexOrThrow5);
                    mVar.f18248f = cursorP.getLong(columnIndexOrThrow6);
                    mVar.f18249g = cursorP.getLong(columnIndexOrThrow7);
                    mVar.f18250h = cursorP.getString(columnIndexOrThrow8);
                    mVar.f18251i = cursorP.getString(columnIndexOrThrow9);
                    mVar.f18252j = cursorP.getString(columnIndexOrThrow10);
                    mVar.f18254l = cursorP.getInt(columnIndexOrThrow11);
                    mVar.f18255m = cursorP.getInt(columnIndexOrThrow12);
                    mVar.f18253k = cursorP.getInt(columnIndexOrThrow13);
                    mVar.f18257o = cursorP.getInt(columnIndexOrThrow14) != 0;
                    mVar.f18258p = cursorP.getInt(columnIndexOrThrow15);
                    mVar.f18259q = cursorP.getInt(columnIndexOrThrow16);
                    mVar.f18256n = cursorP.getInt(columnIndexOrThrow17);
                    mVar.f18260r = cursorP.getInt(columnIndexOrThrow18);
                    mVar.f18261s = cursorP.getString(columnIndexOrThrow19);
                    mVar.f18262t = cursorP.getString(columnIndexOrThrow20);
                } else {
                    mVar = null;
                }
                if (mVar != null) {
                    return mVar;
                }
                throw new Z.b("Query returned empty result set: " + this.f17921a.c());
            } finally {
                cursorP.close();
            }
        }

        protected void finalize() {
            this.f17921a.r();
        }
    }

    /* renamed from: k2.n$h */
    class h extends Z.d<l2.l> {
        h(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `Relation`(`id`,`userId`,`lmodify`,`postTime`,`imsi`,`imei`,`phone`,`status`,`watchDays`,`type`,`mark`,`sDeviceType`,`isTrack`,`appVersion`,`lastAppVersion`,`masterRoleType`,`masterRoleName`,`slaveRoleName`,`isDeleted`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, l2.l lVar) {
            Long l5 = lVar.f18224a;
            if (l5 == null) {
                interfaceC0651f.Z(1);
            } else {
                interfaceC0651f.z(1, l5.longValue());
            }
            interfaceC0651f.z(2, lVar.f18225b);
            interfaceC0651f.z(3, lVar.f18226c);
            interfaceC0651f.z(4, lVar.f18227d);
            String str = lVar.f18228e;
            if (str == null) {
                interfaceC0651f.Z(5);
            } else {
                interfaceC0651f.l(5, str);
            }
            String str2 = lVar.f18229f;
            if (str2 == null) {
                interfaceC0651f.Z(6);
            } else {
                interfaceC0651f.l(6, str2);
            }
            String str3 = lVar.f18230g;
            if (str3 == null) {
                interfaceC0651f.Z(7);
            } else {
                interfaceC0651f.l(7, str3);
            }
            interfaceC0651f.z(8, lVar.f18231h);
            interfaceC0651f.z(9, lVar.f18232i);
            interfaceC0651f.z(10, lVar.f18233j);
            interfaceC0651f.z(11, lVar.f18234k);
            interfaceC0651f.z(12, lVar.f18235l);
            interfaceC0651f.z(13, lVar.f18236m ? 1L : 0L);
            interfaceC0651f.z(14, lVar.f18237n);
            interfaceC0651f.z(15, lVar.f18238o);
            if (lVar.f18239p == null) {
                interfaceC0651f.Z(16);
            } else {
                interfaceC0651f.z(16, r3.intValue());
            }
            String str4 = lVar.f18240q;
            if (str4 == null) {
                interfaceC0651f.Z(17);
            } else {
                interfaceC0651f.l(17, str4);
            }
            String str5 = lVar.f18241r;
            if (str5 == null) {
                interfaceC0651f.Z(18);
            } else {
                interfaceC0651f.l(18, str5);
            }
            interfaceC0651f.z(19, lVar.f18242s ? 1L : 0L);
        }
    }

    /* renamed from: k2.n$i */
    class i extends Z.l {
        i(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "update Relation set isTrack = ? where id =?";
        }
    }

    /* renamed from: k2.n$j */
    class j extends Z.l {
        j(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "update Relation set isDeleted = 1 and userId = ?";
        }
    }

    /* renamed from: k2.n$k */
    class k extends Z.l {
        k(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from Timeline where relationId = ?";
        }
    }

    /* renamed from: k2.n$l */
    class l extends Z.l {
        l(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from timelineconfig where id = ?";
        }
    }

    /* renamed from: k2.n$m */
    class m extends Z.l {
        m(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from timelinestate where relationId = ?";
        }
    }

    /* renamed from: k2.n$n, reason: collision with other inner class name */
    class C0221n extends Z.l {
        C0221n(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from TimelineUpload where relationId = ?";
        }
    }

    /* renamed from: k2.n$o */
    class o extends Z.l {
        o(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from Relation where isDeleted = 1 and userId = ?";
        }
    }

    /* renamed from: k2.n$p */
    class p extends Z.l {
        p(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "delete from Relation where id =?";
        }
    }

    public C0810n(Z.g gVar) {
        this.f17899a = gVar;
        this.f17900b = new h(gVar);
        this.f17901c = new i(gVar);
        this.f17902d = new j(gVar);
        this.f17903e = new k(gVar);
        this.f17904f = new l(gVar);
        this.f17905g = new m(gVar);
        this.f17906h = new C0221n(gVar);
        this.f17907i = new o(gVar);
        this.f17908j = new p(gVar);
        this.f17909k = new a(gVar);
        this.f17910l = new b(gVar);
        this.f17911m = new c(gVar);
        this.f17912n = new d(gVar);
        this.f17913o = new e(gVar);
        this.f17914p = new f(gVar);
    }

    @Override // k2.AbstractC0809m
    public l2.m a(long j5) throws Throwable {
        Z.j jVar;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        l2.m mVar;
        Z.j jVarF = Z.j.f("SELECT B.role as role,B.imsi as mImsi,B.imei as mImei,B.phone as mPhone,A.id as id,A.lmodify as lmodify,A.postTime as postTime,A.imsi as rImsi,A.imei as rImei,A.phone as rPhone,A.status as status,A.watchDays as watchDays,A.mark as mark,A.isTrack as isTrack,A.appVersion as rAppVersion, A.lastAppVersion as rLastAppVersion,A.type as type,A.masterRoleType as masterRoleType,A.masterRoleName as masterRoleName,A.slaveRoleName as slaveRoleName FROM Relation AS A JOIN User AS B ON A.userId = B.id WHERE A.id = ?", 1);
        jVarF.z(1, j5);
        Cursor cursorP = this.f17899a.p(jVarF);
        try {
            columnIndexOrThrow = cursorP.getColumnIndexOrThrow("role");
            columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("mImsi");
            columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("mImei");
            columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("mPhone");
            columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("lmodify");
            columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("postTime");
            columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow("rImsi");
            columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("rImei");
            columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow("rPhone");
            columnIndexOrThrow11 = cursorP.getColumnIndexOrThrow("status");
            columnIndexOrThrow12 = cursorP.getColumnIndexOrThrow("watchDays");
            columnIndexOrThrow13 = cursorP.getColumnIndexOrThrow("mark");
            columnIndexOrThrow14 = cursorP.getColumnIndexOrThrow("isTrack");
            jVar = jVarF;
        } catch (Throwable th) {
            th = th;
            jVar = jVarF;
        }
        try {
            int columnIndexOrThrow15 = cursorP.getColumnIndexOrThrow("rAppVersion");
            int columnIndexOrThrow16 = cursorP.getColumnIndexOrThrow("rLastAppVersion");
            int columnIndexOrThrow17 = cursorP.getColumnIndexOrThrow("type");
            int columnIndexOrThrow18 = cursorP.getColumnIndexOrThrow("masterRoleType");
            int columnIndexOrThrow19 = cursorP.getColumnIndexOrThrow("masterRoleName");
            int columnIndexOrThrow20 = cursorP.getColumnIndexOrThrow("slaveRoleName");
            if (cursorP.moveToFirst()) {
                mVar = new l2.m();
                mVar.f18243a = cursorP.getInt(columnIndexOrThrow);
                mVar.f18244b = cursorP.getString(columnIndexOrThrow2);
                mVar.f18245c = cursorP.getString(columnIndexOrThrow3);
                mVar.f18246d = cursorP.getString(columnIndexOrThrow4);
                mVar.f18247e = cursorP.getLong(columnIndexOrThrow5);
                mVar.f18248f = cursorP.getLong(columnIndexOrThrow6);
                mVar.f18249g = cursorP.getLong(columnIndexOrThrow7);
                mVar.f18250h = cursorP.getString(columnIndexOrThrow8);
                mVar.f18251i = cursorP.getString(columnIndexOrThrow9);
                mVar.f18252j = cursorP.getString(columnIndexOrThrow10);
                mVar.f18254l = cursorP.getInt(columnIndexOrThrow11);
                mVar.f18255m = cursorP.getInt(columnIndexOrThrow12);
                mVar.f18253k = cursorP.getInt(columnIndexOrThrow13);
                mVar.f18257o = cursorP.getInt(columnIndexOrThrow14) != 0;
                mVar.f18258p = cursorP.getInt(columnIndexOrThrow15);
                mVar.f18259q = cursorP.getInt(columnIndexOrThrow16);
                mVar.f18256n = cursorP.getInt(columnIndexOrThrow17);
                mVar.f18260r = cursorP.getInt(columnIndexOrThrow18);
                mVar.f18261s = cursorP.getString(columnIndexOrThrow19);
                mVar.f18262t = cursorP.getString(columnIndexOrThrow20);
            } else {
                mVar = null;
            }
            cursorP.close();
            jVar.r();
            return mVar;
        } catch (Throwable th2) {
            th = th2;
            cursorP.close();
            jVar.r();
            throw th;
        }
    }

    @Override // k2.AbstractC0809m
    public q<l2.m> b(long j5) {
        Z.j jVarF = Z.j.f("SELECT B.role as role,B.imsi as mImsi,B.imei as mImei,B.phone as mPhone,A.id as id,A.lmodify as lmodify,A.postTime as postTime,A.imsi as rImsi,A.imei as rImei,A.phone as rPhone,A.status as status,A.watchDays as watchDays,A.mark as mark,A.isTrack as isTrack,A.appVersion as rAppVersion, A.lastAppVersion as rLastAppVersion,A.type as type,A.masterRoleType as masterRoleType,A.masterRoleName as masterRoleName,A.slaveRoleName as slaveRoleName FROM Relation AS A JOIN User AS B ON A.userId = B.id WHERE A.id = ?", 1);
        jVarF.z(1, j5);
        return q.h(new g(jVarF));
    }
}
