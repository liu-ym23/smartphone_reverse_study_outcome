package f1;

import La.H;
import Z8.C1172u;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import Z8.X;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.provider.c;
import f1.C4044n;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import n9.C4946a;

@Metadata(d1 = {"\u0000`\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001a\u0010\u000e\u001a)\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001f\"\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00000 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010!¨\u0006#"}, d2 = {"", "type", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)I", "Li1/b;", "connection", "tableName", "Lf1/n;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Li1/b;Ljava/lang/String;)Lf1/n;", "", "Lf1/n$c;", Const.INTENT_KEY_UMID, "(Li1/b;Ljava/lang/String;)Ljava/util/Set;", "Li1/d;", "stmt", "", "Lf1/d;", "c", "(Li1/d;)Ljava/util/List;", "", "Lf1/n$a;", Const.INTENT_KEY_PKGNAME, "(Li1/b;Ljava/lang/String;)Ljava/util/Map;", "Lf1/n$d;", "f", "name", "", "unique", "e", "(Li1/b;Ljava/lang/String;Z)Lf1/n$d;", "", "[Ljava/lang/String;", "FTS_OPTIONS", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: f1.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4042l {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f32505a = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: f1.l$a */
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d((Integer) ((Map.Entry) t10).getKey(), (Integer) ((Map.Entry) t11).getKey());
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: f1.l$b */
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d((Integer) ((Map.Entry) t10).getKey(), (Integer) ((Map.Entry) t11).getKey());
        }
    }

    public static final int a(String str) {
        if (str == null) {
            return 5;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        p.h(upperCase, "toUpperCase(...)");
        if (H.g0(upperCase, "INT", false, 2, null)) {
            return 3;
        }
        if (H.g0(upperCase, "CHAR", false, 2, null) || H.g0(upperCase, "CLOB", false, 2, null) || H.g0(upperCase, "TEXT", false, 2, null)) {
            return 2;
        }
        if (H.g0(upperCase, "BLOB", false, 2, null)) {
            return 5;
        }
        return (H.g0(upperCase, "REAL", false, 2, null) || H.g0(upperCase, "FLOA", false, 2, null) || H.g0(upperCase, "DOUB", false, 2, null)) ? 4 : 1;
    }

    public static final Map<String, C4044n.a> b(InterfaceC4160b interfaceC4160b, String str) throws Exception {
        InterfaceC4162d interfaceC4162dQ1 = interfaceC4160b.q1("PRAGMA table_info(`" + str + "`)");
        try {
            if (!interfaceC4162dQ1.n1()) {
                Map<String, C4044n.a> mapI = kotlin.collections.a.i();
                C4946a.a(interfaceC4162dQ1, null);
                return mapI;
            }
            int iA = C4039i.a(interfaceC4162dQ1, "name");
            int iA2 = C4039i.a(interfaceC4162dQ1, "type");
            int iA3 = C4039i.a(interfaceC4162dQ1, "notnull");
            int iA4 = C4039i.a(interfaceC4162dQ1, "pk");
            int iA5 = C4039i.a(interfaceC4162dQ1, "dflt_value");
            Map mapC = Q.c();
            do {
                String strX0 = interfaceC4162dQ1.X0(iA);
                mapC.put(strX0, new C4044n.a(strX0, interfaceC4162dQ1.X0(iA2), interfaceC4162dQ1.getLong(iA3) != 0, (int) interfaceC4162dQ1.getLong(iA4), interfaceC4162dQ1.isNull(iA5) ? null : interfaceC4162dQ1.X0(iA5), 2));
            } while (interfaceC4162dQ1.n1());
            Map<String, C4044n.a> mapB = Q.b(mapC);
            C4946a.a(interfaceC4162dQ1, null);
            return mapB;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C4946a.a(interfaceC4162dQ1, th);
                throw th2;
            }
        }
    }

    public static final List<C4034d> c(InterfaceC4162d interfaceC4162d) {
        int iA = C4039i.a(interfaceC4162d, "id");
        int iA2 = C4039i.a(interfaceC4162d, c.a.COL_SEQ);
        int iA3 = C4039i.a(interfaceC4162d, "from");
        int iA4 = C4039i.a(interfaceC4162d, "to");
        List listC = C1172u.c();
        while (interfaceC4162d.n1()) {
            listC.add(new C4034d((int) interfaceC4162d.getLong(iA), (int) interfaceC4162d.getLong(iA2), interfaceC4162d.X0(iA3), interfaceC4162d.X0(iA4)));
        }
        return F.b1(C1172u.a(listC));
    }

    public static final Set<C4044n.c> d(InterfaceC4160b interfaceC4160b, String str) throws Exception {
        InterfaceC4162d interfaceC4162dQ1 = interfaceC4160b.q1("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int iA = C4039i.a(interfaceC4162dQ1, "id");
            int iA2 = C4039i.a(interfaceC4162dQ1, c.a.COL_SEQ);
            int iA3 = C4039i.a(interfaceC4162dQ1, "table");
            int iA4 = C4039i.a(interfaceC4162dQ1, "on_delete");
            int iA5 = C4039i.a(interfaceC4162dQ1, "on_update");
            List<C4034d> listC = c(interfaceC4162dQ1);
            interfaceC4162dQ1.reset();
            Set setB = X.b();
            while (interfaceC4162dQ1.n1()) {
                if (interfaceC4162dQ1.getLong(iA2) == 0) {
                    int i10 = (int) interfaceC4162dQ1.getLong(iA);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<C4034d> arrayList3 = new ArrayList();
                    for (Object obj : listC) {
                        if (((C4034d) obj).getId() == i10) {
                            arrayList3.add(obj);
                        }
                    }
                    for (C4034d c4034d : arrayList3) {
                        arrayList.add(c4034d.getFrom());
                        arrayList2.add(c4034d.getTo());
                    }
                    setB.add(new C4044n.c(interfaceC4162dQ1.X0(iA3), interfaceC4162dQ1.X0(iA4), interfaceC4162dQ1.X0(iA5), arrayList, arrayList2));
                }
            }
            Set<C4044n.c> setA = X.a(setB);
            C4946a.a(interfaceC4162dQ1, null);
            return setA;
        } finally {
        }
    }

    public static final C4044n.d e(InterfaceC4160b interfaceC4160b, String str, boolean z10) throws Exception {
        InterfaceC4162d interfaceC4162dQ1 = interfaceC4160b.q1("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int iA = C4039i.a(interfaceC4162dQ1, "seqno");
            int iA2 = C4039i.a(interfaceC4162dQ1, "cid");
            int iA3 = C4039i.a(interfaceC4162dQ1, "name");
            int iA4 = C4039i.a(interfaceC4162dQ1, Const.JSON_KEY_DESC);
            if (iA != -1 && iA2 != -1 && iA3 != -1 && iA4 != -1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                while (interfaceC4162dQ1.n1()) {
                    if (((int) interfaceC4162dQ1.getLong(iA2)) >= 0) {
                        int i10 = (int) interfaceC4162dQ1.getLong(iA);
                        String strX0 = interfaceC4162dQ1.X0(iA3);
                        String str2 = interfaceC4162dQ1.getLong(iA4) > 0 ? "DESC" : "ASC";
                        linkedHashMap.put(Integer.valueOf(i10), strX0);
                        linkedHashMap2.put(Integer.valueOf(i10), str2);
                    }
                }
                List listC1 = F.c1(linkedHashMap.entrySet(), new a());
                ArrayList arrayList = new ArrayList(C1174w.x(listC1, 10));
                Iterator it = listC1.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Map.Entry) it.next()).getValue());
                }
                List listM1 = F.m1(arrayList);
                List listC12 = F.c1(linkedHashMap2.entrySet(), new b());
                ArrayList arrayList2 = new ArrayList(C1174w.x(listC12, 10));
                Iterator it2 = listC12.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((String) ((Map.Entry) it2.next()).getValue());
                }
                C4044n.d dVar = new C4044n.d(str, z10, listM1, F.m1(arrayList2));
                C4946a.a(interfaceC4162dQ1, null);
                return dVar;
            }
            C4946a.a(interfaceC4162dQ1, null);
            return null;
        } finally {
        }
    }

    public static final Set<C4044n.d> f(InterfaceC4160b interfaceC4160b, String str) throws Exception {
        InterfaceC4162d interfaceC4162dQ1 = interfaceC4160b.q1("PRAGMA index_list(`" + str + "`)");
        try {
            int iA = C4039i.a(interfaceC4162dQ1, "name");
            int iA2 = C4039i.a(interfaceC4162dQ1, "origin");
            int iA3 = C4039i.a(interfaceC4162dQ1, "unique");
            if (iA != -1 && iA2 != -1 && iA3 != -1) {
                Set setB = X.b();
                while (interfaceC4162dQ1.n1()) {
                    if (p.d("c", interfaceC4162dQ1.X0(iA2))) {
                        C4044n.d dVarE = e(interfaceC4160b, interfaceC4162dQ1.X0(iA), interfaceC4162dQ1.getLong(iA3) == 1);
                        if (dVarE == null) {
                            C4946a.a(interfaceC4162dQ1, null);
                            return null;
                        }
                        setB.add(dVarE);
                    }
                }
                Set<C4044n.d> setA = X.a(setB);
                C4946a.a(interfaceC4162dQ1, null);
                return setA;
            }
            C4946a.a(interfaceC4162dQ1, null);
            return null;
        } finally {
        }
    }

    public static final C4044n g(InterfaceC4160b connection, String tableName) {
        p.i(connection, "connection");
        p.i(tableName, "tableName");
        return new C4044n(tableName, b(connection, tableName), d(connection, tableName), f(connection, tableName));
    }
}
