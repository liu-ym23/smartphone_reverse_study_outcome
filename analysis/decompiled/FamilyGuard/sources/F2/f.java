package F2;

import Z.e;
import android.database.Cursor;
import androidx.lifecycle.AbstractC0526f;
import androidx.lifecycle.AbstractC0545z;
import com.stepos.minor.Minor;
import com.stepos.minor.WhitelistApp;
import com.stepos.minor.state.MinorStateEntity;
import d0.InterfaceC0650e;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class f extends F2.e {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f1650a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f1651b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.d f1652c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.d f1653d;

    /* renamed from: e, reason: collision with root package name */
    private final Z.c f1654e;

    /* renamed from: f, reason: collision with root package name */
    private final Z.l f1655f;

    /* renamed from: g, reason: collision with root package name */
    private final Z.l f1656g;

    /* renamed from: h, reason: collision with root package name */
    private final Z.l f1657h;

    /* renamed from: i, reason: collision with root package name */
    private final Z.l f1658i;

    class a extends AbstractC0526f<List<Minor>> {

        /* renamed from: h, reason: collision with root package name */
        private e.c f1659h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Z.j f1660i;

        /* renamed from: F2.f$a$a, reason: collision with other inner class name */
        class C0025a extends e.c {
            C0025a(String str, String... strArr) {
                super(str, strArr);
            }

            @Override // Z.e.c
            public void a(Set<String> set) {
                a.this.f();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Executor executor, Z.j jVar) {
            super(executor);
            this.f1660i = jVar;
        }

        protected void finalize() {
            this.f1660i.r();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.AbstractC0526f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public List<Minor> c() {
            if (this.f1659h == null) {
                this.f1659h = new C0025a(Minor.TABLE_NAME, new String[0]);
                f.this.f1650a.h().b(this.f1659h);
            }
            Cursor cursorP = f.this.f1650a.p(this.f1660i);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_NAME);
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ICON);
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_TYPE);
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_DATE);
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_DATE_LUNAR);
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_AGE);
                int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_RANGE);
                int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("state");
                int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_AGE_RANGE);
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    Minor minor = new Minor(cursorP.getLong(columnIndexOrThrow), cursorP.getString(columnIndexOrThrow2), cursorP.getInt(columnIndexOrThrow4), cursorP.getLong(columnIndexOrThrow5), cursorP.getInt(columnIndexOrThrow6), cursorP.getInt(columnIndexOrThrow7), cursorP.getInt(columnIndexOrThrow8), cursorP.getInt(columnIndexOrThrow10));
                    minor.setIcon(cursorP.getBlob(columnIndexOrThrow3));
                    minor.setState(cursorP.getInt(columnIndexOrThrow9));
                    arrayList.add(minor);
                }
                return arrayList;
            } finally {
                cursorP.close();
            }
        }
    }

    class b extends AbstractC0526f<Minor> {

        /* renamed from: h, reason: collision with root package name */
        private e.c f1663h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Z.j f1664i;

        class a extends e.c {
            a(String str, String... strArr) {
                super(str, strArr);
            }

            @Override // Z.e.c
            public void a(Set<String> set) {
                b.this.f();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Executor executor, Z.j jVar) {
            super(executor);
            this.f1664i = jVar;
        }

        protected void finalize() {
            this.f1664i.r();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.AbstractC0526f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Minor c() {
            Minor minor;
            if (this.f1663h == null) {
                this.f1663h = new a(Minor.TABLE_NAME, new String[0]);
                f.this.f1650a.h().b(this.f1663h);
            }
            Cursor cursorP = f.this.f1650a.p(this.f1664i);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_NAME);
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ICON);
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_TYPE);
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_DATE);
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_DATE_LUNAR);
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_AGE);
                int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_RANGE);
                int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("state");
                int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_AGE_RANGE);
                if (cursorP.moveToFirst()) {
                    minor = new Minor(cursorP.getLong(columnIndexOrThrow), cursorP.getString(columnIndexOrThrow2), cursorP.getInt(columnIndexOrThrow4), cursorP.getLong(columnIndexOrThrow5), cursorP.getInt(columnIndexOrThrow6), cursorP.getInt(columnIndexOrThrow7), cursorP.getInt(columnIndexOrThrow8), cursorP.getInt(columnIndexOrThrow10));
                    minor.setIcon(cursorP.getBlob(columnIndexOrThrow3));
                    minor.setState(cursorP.getInt(columnIndexOrThrow9));
                } else {
                    minor = null;
                }
                return minor;
            } finally {
                cursorP.close();
            }
        }
    }

    class c extends Z.d<Minor> {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `minor`(`id`,`name`,`icon`,`birthType`,`birthdayDate`,`birthdayDateLunar`,`birthdayAge`,`birthdayRange`,`state`,`age_range`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, Minor minor) {
            interfaceC0651f.z(1, minor.getId());
            if (minor.getName() == null) {
                interfaceC0651f.Z(2);
            } else {
                interfaceC0651f.l(2, minor.getName());
            }
            if (minor.getIcon() == null) {
                interfaceC0651f.Z(3);
            } else {
                interfaceC0651f.F(3, minor.getIcon());
            }
            interfaceC0651f.z(4, minor.getBirthType());
            interfaceC0651f.z(5, minor.getBirthdayDate());
            interfaceC0651f.z(6, minor.getBirthdayDateLunar());
            interfaceC0651f.z(7, minor.getBirthdayAge());
            interfaceC0651f.z(8, minor.getBirthdayRange());
            interfaceC0651f.z(9, minor.getState());
            interfaceC0651f.z(10, minor.getAgeRange());
        }
    }

    class d extends Z.d<MinorStateEntity> {
        d(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `minor_state_entity`(`id`,`state`) VALUES (?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, MinorStateEntity minorStateEntity) {
            interfaceC0651f.z(1, minorStateEntity.id);
            interfaceC0651f.z(2, minorStateEntity.state);
        }
    }

    class e extends Z.d<WhitelistApp> {
        e(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `whitelist_app`(`minor_id`,`package_name`,`removable`) VALUES (?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, WhitelistApp whitelistApp) {
            interfaceC0651f.z(1, whitelistApp.minorId);
            String str = whitelistApp.packageName;
            if (str == null) {
                interfaceC0651f.Z(2);
            } else {
                interfaceC0651f.l(2, str);
            }
            interfaceC0651f.z(3, whitelistApp.removable ? 1L : 0L);
        }
    }

    /* renamed from: F2.f$f, reason: collision with other inner class name */
    class C0026f extends Z.c<Minor> {
        C0026f(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE OR ABORT `minor` SET `id` = ?,`name` = ?,`icon` = ?,`birthType` = ?,`birthdayDate` = ?,`birthdayDateLunar` = ?,`birthdayAge` = ?,`birthdayRange` = ?,`state` = ?,`age_range` = ? WHERE `id` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, Minor minor) {
            interfaceC0651f.z(1, minor.getId());
            if (minor.getName() == null) {
                interfaceC0651f.Z(2);
            } else {
                interfaceC0651f.l(2, minor.getName());
            }
            if (minor.getIcon() == null) {
                interfaceC0651f.Z(3);
            } else {
                interfaceC0651f.F(3, minor.getIcon());
            }
            interfaceC0651f.z(4, minor.getBirthType());
            interfaceC0651f.z(5, minor.getBirthdayDate());
            interfaceC0651f.z(6, minor.getBirthdayDateLunar());
            interfaceC0651f.z(7, minor.getBirthdayAge());
            interfaceC0651f.z(8, minor.getBirthdayRange());
            interfaceC0651f.z(9, minor.getState());
            interfaceC0651f.z(10, minor.getAgeRange());
            interfaceC0651f.z(11, minor.getId());
        }
    }

    class g extends Z.l {
        g(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE minor SET state = 0";
        }
    }

    class h extends Z.l {
        h(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "DELETE FROM minor WHERE id =?";
        }
    }

    class i extends Z.l {
        i(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE minor SET state = CASE WHEN id = ? THEN ? ELSE 0 END";
        }
    }

    class j extends Z.l {
        j(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE minor SET state = CASE WHEN ? THEN 2 ELSE 1 END WHERE state = (CASE WHEN ? THEN 1 ELSE 2 END)";
        }
    }

    class k extends AbstractC0526f<Minor> {

        /* renamed from: h, reason: collision with root package name */
        private e.c f1675h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Z.j f1676i;

        class a extends e.c {
            a(String str, String... strArr) {
                super(str, strArr);
            }

            @Override // Z.e.c
            public void a(Set<String> set) {
                k.this.f();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(Executor executor, Z.j jVar) {
            super(executor);
            this.f1676i = jVar;
        }

        protected void finalize() {
            this.f1676i.r();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.AbstractC0526f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Minor c() {
            Minor minor;
            if (this.f1675h == null) {
                this.f1675h = new a(Minor.TABLE_NAME, new String[0]);
                f.this.f1650a.h().b(this.f1675h);
            }
            Cursor cursorP = f.this.f1650a.p(this.f1676i);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_NAME);
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ICON);
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_TYPE);
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_DATE);
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_DATE_LUNAR);
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_AGE);
                int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_RANGE);
                int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("state");
                int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_AGE_RANGE);
                if (cursorP.moveToFirst()) {
                    minor = new Minor(cursorP.getLong(columnIndexOrThrow), cursorP.getString(columnIndexOrThrow2), cursorP.getInt(columnIndexOrThrow4), cursorP.getLong(columnIndexOrThrow5), cursorP.getInt(columnIndexOrThrow6), cursorP.getInt(columnIndexOrThrow7), cursorP.getInt(columnIndexOrThrow8), cursorP.getInt(columnIndexOrThrow10));
                    minor.setIcon(cursorP.getBlob(columnIndexOrThrow3));
                    minor.setState(cursorP.getInt(columnIndexOrThrow9));
                } else {
                    minor = null;
                }
                return minor;
            } finally {
                cursorP.close();
            }
        }
    }

    public f(Z.g gVar) {
        this.f1650a = gVar;
        this.f1651b = new c(gVar);
        this.f1652c = new d(gVar);
        this.f1653d = new e(gVar);
        this.f1654e = new C0026f(gVar);
        this.f1655f = new g(gVar);
        this.f1656g = new h(gVar);
        this.f1657h = new i(gVar);
        this.f1658i = new j(gVar);
    }

    @Override // F2.e
    public int A(Minor minor) {
        this.f1650a.b();
        try {
            int iH = this.f1654e.h(minor);
            this.f1650a.s();
            return iH;
        } finally {
            this.f1650a.f();
        }
    }

    @Override // F2.e
    public int a(long j5) {
        InterfaceC0651f interfaceC0651fA = this.f1656g.a();
        this.f1650a.b();
        try {
            interfaceC0651fA.z(1, j5);
            int iN = interfaceC0651fA.n();
            this.f1650a.s();
            return iN;
        } finally {
            this.f1650a.f();
            this.f1656g.f(interfaceC0651fA);
        }
    }

    @Override // F2.e
    public Minor d(long j5) {
        Minor minor;
        Z.j jVarF = Z.j.f("SELECT * FROM minor WHERE id =?", 1);
        jVarF.z(1, j5);
        Cursor cursorP = this.f1650a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_NAME);
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ICON);
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_TYPE);
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_DATE);
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_DATE_LUNAR);
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_AGE);
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_RANGE);
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("state");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_AGE_RANGE);
            if (cursorP.moveToFirst()) {
                minor = new Minor(cursorP.getLong(columnIndexOrThrow), cursorP.getString(columnIndexOrThrow2), cursorP.getInt(columnIndexOrThrow4), cursorP.getLong(columnIndexOrThrow5), cursorP.getInt(columnIndexOrThrow6), cursorP.getInt(columnIndexOrThrow7), cursorP.getInt(columnIndexOrThrow8), cursorP.getInt(columnIndexOrThrow10));
                minor.setIcon(cursorP.getBlob(columnIndexOrThrow3));
                minor.setState(cursorP.getInt(columnIndexOrThrow9));
            } else {
                minor = null;
            }
            return minor;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // F2.e
    public Cursor e(long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM minor WHERE id =?", 1);
        jVarF.z(1, j5);
        return this.f1650a.p(jVarF);
    }

    @Override // F2.e
    public AbstractC0545z<Minor> f(long j5) {
        Z.j jVarF = Z.j.f("SELECT * FROM minor WHERE id =?", 1);
        jVarF.z(1, j5);
        return new k(this.f1650a.j(), jVarF).e();
    }

    @Override // F2.e
    public Minor g() {
        Minor minor;
        Z.j jVarF = Z.j.f("SELECT * FROM minor WHERE state = 2", 0);
        Cursor cursorP = this.f1650a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_NAME);
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ICON);
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_TYPE);
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_DATE);
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_DATE_LUNAR);
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_AGE);
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_RANGE);
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("state");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_AGE_RANGE);
            if (cursorP.moveToFirst()) {
                minor = new Minor(cursorP.getLong(columnIndexOrThrow), cursorP.getString(columnIndexOrThrow2), cursorP.getInt(columnIndexOrThrow4), cursorP.getLong(columnIndexOrThrow5), cursorP.getInt(columnIndexOrThrow6), cursorP.getInt(columnIndexOrThrow7), cursorP.getInt(columnIndexOrThrow8), cursorP.getInt(columnIndexOrThrow10));
                minor.setIcon(cursorP.getBlob(columnIndexOrThrow3));
                minor.setState(cursorP.getInt(columnIndexOrThrow9));
            } else {
                minor = null;
            }
            return minor;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // F2.e
    public Cursor h() {
        return this.f1650a.p(Z.j.f("SELECT * FROM minor WHERE state = 2", 0));
    }

    @Override // F2.e
    public AbstractC0545z<Minor> i() {
        return new b(this.f1650a.j(), Z.j.f("SELECT * FROM minor WHERE state = 2", 0)).e();
    }

    @Override // F2.e
    public AbstractC0545z<List<Minor>> l() {
        return new a(this.f1650a.j(), Z.j.f("SELECT * FROM minor", 0)).e();
    }

    @Override // F2.e
    public Minor m() {
        Minor minor;
        Z.j jVarF = Z.j.f("SELECT * FROM minor WHERE state = 1", 0);
        Cursor cursorP = this.f1650a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_NAME);
            int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ICON);
            int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_TYPE);
            int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_DATE);
            int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_DATE_LUNAR);
            int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_AGE);
            int columnIndexOrThrow8 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_BIRTHDAY_RANGE);
            int columnIndexOrThrow9 = cursorP.getColumnIndexOrThrow("state");
            int columnIndexOrThrow10 = cursorP.getColumnIndexOrThrow(Minor.COLUMN_AGE_RANGE);
            if (cursorP.moveToFirst()) {
                minor = new Minor(cursorP.getLong(columnIndexOrThrow), cursorP.getString(columnIndexOrThrow2), cursorP.getInt(columnIndexOrThrow4), cursorP.getLong(columnIndexOrThrow5), cursorP.getInt(columnIndexOrThrow6), cursorP.getInt(columnIndexOrThrow7), cursorP.getInt(columnIndexOrThrow8), cursorP.getInt(columnIndexOrThrow10));
                minor.setIcon(cursorP.getBlob(columnIndexOrThrow3));
                minor.setState(cursorP.getInt(columnIndexOrThrow9));
            } else {
                minor = null;
            }
            return minor;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // F2.e
    public MinorStateEntity o() {
        MinorStateEntity minorStateEntity;
        Z.j jVarF = Z.j.f("SELECT * FROM minor_state_entity", 0);
        Cursor cursorP = this.f1650a.p(jVarF);
        try {
            int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
            int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("state");
            if (cursorP.moveToFirst()) {
                minorStateEntity = new MinorStateEntity(cursorP.getInt(columnIndexOrThrow2));
                minorStateEntity.id = cursorP.getLong(columnIndexOrThrow);
            } else {
                minorStateEntity = null;
            }
            return minorStateEntity;
        } finally {
            cursorP.close();
            jVarF.r();
        }
    }

    @Override // F2.e
    public long q(Minor minor) {
        this.f1650a.b();
        try {
            long jQ = super.q(minor);
            this.f1650a.s();
            return jQ;
        } finally {
            this.f1650a.f();
        }
    }

    @Override // F2.e
    public void r(MinorStateEntity minorStateEntity) {
        this.f1650a.b();
        try {
            this.f1652c.i(minorStateEntity);
            this.f1650a.s();
        } finally {
            this.f1650a.f();
        }
    }

    @Override // F2.e
    public long s(Minor minor) {
        this.f1650a.b();
        try {
            long j5 = this.f1651b.j(minor);
            this.f1650a.s();
            return j5;
        } finally {
            this.f1650a.f();
        }
    }

    @Override // F2.e
    public void t(List<WhitelistApp> list) {
        this.f1650a.b();
        try {
            this.f1653d.h(list);
            this.f1650a.s();
        } finally {
            this.f1650a.f();
        }
    }

    @Override // F2.e
    public Cursor u(InterfaceC0650e interfaceC0650e) {
        return this.f1650a.p(interfaceC0650e);
    }

    @Override // F2.e
    public void v(long j5, int i5) {
        InterfaceC0651f interfaceC0651fA = this.f1657h.a();
        this.f1650a.b();
        try {
            interfaceC0651fA.z(1, j5);
            interfaceC0651fA.z(2, i5);
            interfaceC0651fA.n();
            this.f1650a.s();
        } finally {
            this.f1650a.f();
            this.f1657h.f(interfaceC0651fA);
        }
    }

    @Override // F2.e
    public int x(boolean z5) {
        InterfaceC0651f interfaceC0651fA = this.f1658i.a();
        this.f1650a.b();
        try {
            interfaceC0651fA.z(1, z5 ? 1L : 0L);
            interfaceC0651fA.z(2, z5 ? 1L : 0L);
            int iN = interfaceC0651fA.n();
            this.f1650a.s();
            return iN;
        } finally {
            this.f1650a.f();
            this.f1658i.f(interfaceC0651fA);
        }
    }

    @Override // F2.e
    public void y() {
        InterfaceC0651f interfaceC0651fA = this.f1655f.a();
        this.f1650a.b();
        try {
            interfaceC0651fA.n();
            this.f1650a.s();
        } finally {
            this.f1650a.f();
            this.f1655f.f(interfaceC0651fA);
        }
    }

    @Override // F2.e
    public int z(Minor minor) {
        this.f1650a.b();
        try {
            int iZ = super.z(minor);
            this.f1650a.s();
            return iZ;
        } finally {
            this.f1650a.f();
        }
    }
}
