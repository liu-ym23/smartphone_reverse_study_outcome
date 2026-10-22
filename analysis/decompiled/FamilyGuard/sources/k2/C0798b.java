package k2;

import android.database.Cursor;
import com.stepos.minor.Minor;
import d0.InterfaceC0651f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import l2.C0832a;
import x3.q;

/* renamed from: k2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0798b extends AbstractC0797a {

    /* renamed from: a, reason: collision with root package name */
    private final Z.g f17845a;

    /* renamed from: b, reason: collision with root package name */
    private final Z.d f17846b;

    /* renamed from: c, reason: collision with root package name */
    private final Z.c f17847c;

    /* renamed from: d, reason: collision with root package name */
    private final Z.l f17848d;

    /* renamed from: k2.b$a */
    class a extends Z.d<C0832a> {
        a(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "INSERT OR REPLACE INTO `Account`(`id`,`type`,`status`,`phone`,`imei`,`featureVersion`,`imsi`) VALUES (?,?,?,?,?,?,?)";
        }

        @Override // Z.d
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, C0832a c0832a) {
            Long l5 = c0832a.f18158a;
            if (l5 == null) {
                interfaceC0651f.Z(1);
            } else {
                interfaceC0651f.z(1, l5.longValue());
            }
            interfaceC0651f.z(2, c0832a.f18159b);
            interfaceC0651f.z(3, c0832a.f18160c);
            String str = c0832a.f18161d;
            if (str == null) {
                interfaceC0651f.Z(4);
            } else {
                interfaceC0651f.l(4, str);
            }
            String str2 = c0832a.f18162e;
            if (str2 == null) {
                interfaceC0651f.Z(5);
            } else {
                interfaceC0651f.l(5, str2);
            }
            interfaceC0651f.z(6, c0832a.f18163f);
            String str3 = c0832a.f18164g;
            if (str3 == null) {
                interfaceC0651f.Z(7);
            } else {
                interfaceC0651f.l(7, str3);
            }
        }
    }

    /* renamed from: k2.b$b, reason: collision with other inner class name */
    class C0219b extends Z.c<C0832a> {
        C0219b(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "UPDATE OR ABORT `Account` SET `id` = ?,`type` = ?,`status` = ?,`phone` = ?,`imei` = ?,`featureVersion` = ?,`imsi` = ? WHERE `id` = ?";
        }

        @Override // Z.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(InterfaceC0651f interfaceC0651f, C0832a c0832a) {
            Long l5 = c0832a.f18158a;
            if (l5 == null) {
                interfaceC0651f.Z(1);
            } else {
                interfaceC0651f.z(1, l5.longValue());
            }
            interfaceC0651f.z(2, c0832a.f18159b);
            interfaceC0651f.z(3, c0832a.f18160c);
            String str = c0832a.f18161d;
            if (str == null) {
                interfaceC0651f.Z(4);
            } else {
                interfaceC0651f.l(4, str);
            }
            String str2 = c0832a.f18162e;
            if (str2 == null) {
                interfaceC0651f.Z(5);
            } else {
                interfaceC0651f.l(5, str2);
            }
            interfaceC0651f.z(6, c0832a.f18163f);
            String str3 = c0832a.f18164g;
            if (str3 == null) {
                interfaceC0651f.Z(7);
            } else {
                interfaceC0651f.l(7, str3);
            }
            Long l6 = c0832a.f18158a;
            if (l6 == null) {
                interfaceC0651f.Z(8);
            } else {
                interfaceC0651f.z(8, l6.longValue());
            }
        }
    }

    /* renamed from: k2.b$c */
    class c extends Z.l {
        c(Z.g gVar) {
            super(gVar);
        }

        @Override // Z.l
        public String d() {
            return "update Account set status=?";
        }
    }

    /* renamed from: k2.b$d */
    class d implements Callable<List<C0832a>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z.j f17852a;

        d(Z.j jVar) {
            this.f17852a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<C0832a> call() {
            Cursor cursorP = C0798b.this.f17845a.p(this.f17852a);
            try {
                int columnIndexOrThrow = cursorP.getColumnIndexOrThrow(Minor.COLUMN_ID);
                int columnIndexOrThrow2 = cursorP.getColumnIndexOrThrow("type");
                int columnIndexOrThrow3 = cursorP.getColumnIndexOrThrow("status");
                int columnIndexOrThrow4 = cursorP.getColumnIndexOrThrow("phone");
                int columnIndexOrThrow5 = cursorP.getColumnIndexOrThrow("imei");
                int columnIndexOrThrow6 = cursorP.getColumnIndexOrThrow("featureVersion");
                int columnIndexOrThrow7 = cursorP.getColumnIndexOrThrow("imsi");
                ArrayList arrayList = new ArrayList(cursorP.getCount());
                while (cursorP.moveToNext()) {
                    C0832a c0832a = new C0832a(cursorP.getInt(columnIndexOrThrow2), cursorP.getInt(columnIndexOrThrow3));
                    if (cursorP.isNull(columnIndexOrThrow)) {
                        c0832a.f18158a = null;
                    } else {
                        c0832a.f18158a = Long.valueOf(cursorP.getLong(columnIndexOrThrow));
                    }
                    c0832a.f18161d = cursorP.getString(columnIndexOrThrow4);
                    c0832a.f18162e = cursorP.getString(columnIndexOrThrow5);
                    c0832a.f18163f = cursorP.getInt(columnIndexOrThrow6);
                    c0832a.f18164g = cursorP.getString(columnIndexOrThrow7);
                    arrayList.add(c0832a);
                }
                cursorP.close();
                return arrayList;
            } catch (Throwable th) {
                cursorP.close();
                throw th;
            }
        }

        protected void finalize() {
            this.f17852a.r();
        }
    }

    public C0798b(Z.g gVar) {
        this.f17845a = gVar;
        this.f17846b = new a(gVar);
        this.f17847c = new C0219b(gVar);
        this.f17848d = new c(gVar);
    }

    @Override // k2.AbstractC0797a
    public q<List<C0832a>> a() {
        return q.h(new d(Z.j.f("select * from Account where status =1", 0)));
    }
}
