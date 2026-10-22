package f1;

import La.D;
import La.H;
import La.w;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import f1.C4044n;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0006\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\r\u001a\u00020\u0003*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0013\u0010\u0014\u001a\u00020\u0006*\u00020\fH\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0016\u001a\u00020\t*\u00020\fH\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001d\u0010\u0019\u001a\u00020\u0003*\u00020\u00182\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0013\u0010\u001b\u001a\u00020\u0006*\u00020\u0018H\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0013\u0010\u001d\u001a\u00020\t*\u00020\u0018H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001d\u0010 \u001a\u00020\u0003*\u00020\u001f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b \u0010!\u001a\u0013\u0010\"\u001a\u00020\u0006*\u00020\u001fH\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0013\u0010$\u001a\u00020\t*\u00020\u001fH\u0000¢\u0006\u0004\b$\u0010%\u001a\u001b\u0010(\u001a\u00020\t2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030&H\u0000¢\u0006\u0004\b(\u0010)\u001a\u0017\u0010*\u001a\u00020\t*\u0006\u0012\u0002\b\u00030&H\u0002¢\u0006\u0004\b*\u0010)\u001a\u0017\u0010+\u001a\u00020\t*\u0006\u0012\u0002\b\u00030&H\u0002¢\u0006\u0004\b+\u0010)¨\u0006,"}, d2 = {"Lf1/n;", "", "other", "", "f", "(Lf1/n;Ljava/lang/Object;)Z", "", "k", "(Lf1/n;)I", "", "q", "(Lf1/n;)Ljava/lang/String;", "Lf1/n$a;", "c", "(Lf1/n$a;Ljava/lang/Object;)Z", "current", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Z", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lf1/n$a;)I", "n", "(Lf1/n$a;)Ljava/lang/String;", "Lf1/n$c;", Const.INTENT_KEY_UMID, "(Lf1/n$c;Ljava/lang/Object;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lf1/n$c;)I", "o", "(Lf1/n$c;)Ljava/lang/String;", "Lf1/n$d;", "e", "(Lf1/n$d;Ljava/lang/Object;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lf1/n$d;)I", "p", "(Lf1/n$d;)Ljava/lang/String;", "", "collection", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/Collection;)Ljava/lang/String;", "m", "l", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: f1.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4045o {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: f1.o$a */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(((C4044n.a) t10).name, ((C4044n.a) t11).name);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: f1.o$b */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(((C4044n.d) t10).name, ((C4044n.d) t11).name);
        }
    }

    public static final boolean a(String str) {
        if (str.length() == 0) {
            return false;
        }
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            int i13 = i12 + 1;
            if (i12 == 0 && cCharAt != '(') {
                return false;
            }
            if (cCharAt == '(') {
                i11++;
            } else if (cCharAt == ')' && i11 - 1 == 0 && i12 != str.length() - 1) {
                return false;
            }
            i10++;
            i12 = i13;
        }
        return i11 == 0;
    }

    public static final boolean b(String current, String str) {
        p.i(current, "current");
        if (p.d(current, str)) {
            return true;
        }
        if (!a(current)) {
            return false;
        }
        String strSubstring = current.substring(1, current.length() - 1);
        p.h(strSubstring, "substring(...)");
        return p.d(H.D1(strSubstring).toString(), str);
    }

    public static final boolean c(C4044n.a aVar, Object obj) {
        p.i(aVar, "<this>");
        if (aVar == obj) {
            return true;
        }
        if (!(obj instanceof C4044n.a)) {
            return false;
        }
        C4044n.a aVar2 = (C4044n.a) obj;
        if (aVar.a() != aVar2.a() || !p.d(aVar.name, aVar2.name) || aVar.notNull != aVar2.notNull) {
            return false;
        }
        String str = aVar.defaultValue;
        String str2 = aVar2.defaultValue;
        if (aVar.createdFrom == 1 && aVar2.createdFrom == 2 && str != null && !b(str, str2)) {
            return false;
        }
        if (aVar.createdFrom == 2 && aVar2.createdFrom == 1 && str2 != null && !b(str2, str)) {
            return false;
        }
        int i10 = aVar.createdFrom;
        return (i10 == 0 || i10 != aVar2.createdFrom || (str == null ? str2 == null : b(str, str2))) && aVar.affinity == aVar2.affinity;
    }

    public static final boolean d(C4044n.c cVar, Object obj) {
        p.i(cVar, "<this>");
        if (cVar == obj) {
            return true;
        }
        if (!(obj instanceof C4044n.c)) {
            return false;
        }
        C4044n.c cVar2 = (C4044n.c) obj;
        if (p.d(cVar.referenceTable, cVar2.referenceTable) && p.d(cVar.onDelete, cVar2.onDelete) && p.d(cVar.onUpdate, cVar2.onUpdate) && p.d(cVar.columnNames, cVar2.columnNames)) {
            return p.d(cVar.referenceColumnNames, cVar2.referenceColumnNames);
        }
        return false;
    }

    public static final boolean e(C4044n.d dVar, Object obj) {
        p.i(dVar, "<this>");
        if (dVar == obj) {
            return true;
        }
        if (!(obj instanceof C4044n.d)) {
            return false;
        }
        C4044n.d dVar2 = (C4044n.d) obj;
        if (dVar.unique == dVar2.unique && p.d(dVar.columns, dVar2.columns) && p.d(dVar.orders, dVar2.orders)) {
            return D.X(dVar.name, "index_", false, 2, null) ? D.X(dVar2.name, "index_", false, 2, null) : p.d(dVar.name, dVar2.name);
        }
        return false;
    }

    public static final boolean f(C4044n c4044n, Object obj) {
        Set<C4044n.d> set;
        p.i(c4044n, "<this>");
        if (c4044n == obj) {
            return true;
        }
        if (!(obj instanceof C4044n)) {
            return false;
        }
        C4044n c4044n2 = (C4044n) obj;
        if (!p.d(c4044n.name, c4044n2.name) || !p.d(c4044n.columns, c4044n2.columns) || !p.d(c4044n.foreignKeys, c4044n2.foreignKeys)) {
            return false;
        }
        Set<C4044n.d> set2 = c4044n.indices;
        if (set2 == null || (set = c4044n2.indices) == null) {
            return true;
        }
        return p.d(set2, set);
    }

    public static final String g(Collection<?> collection) {
        p.i(collection, "collection");
        if (collection.isEmpty()) {
            return " }";
        }
        return w.j(F.A0(collection, ",\n", "\n", "\n", 0, null, null, 56, null), null, 1, null) + "},";
    }

    public static final int h(C4044n.a aVar) {
        p.i(aVar, "<this>");
        return (((((aVar.name.hashCode() * 31) + aVar.affinity) * 31) + (aVar.notNull ? 1231 : 1237)) * 31) + aVar.primaryKeyPosition;
    }

    public static final int i(C4044n.c cVar) {
        p.i(cVar, "<this>");
        return (((((((cVar.referenceTable.hashCode() * 31) + cVar.onDelete.hashCode()) * 31) + cVar.onUpdate.hashCode()) * 31) + cVar.columnNames.hashCode()) * 31) + cVar.referenceColumnNames.hashCode();
    }

    public static final int j(C4044n.d dVar) {
        p.i(dVar, "<this>");
        return ((((((D.X(dVar.name, "index_", false, 2, null) ? -1184239155 : dVar.name.hashCode()) * 31) + (dVar.unique ? 1 : 0)) * 31) + dVar.columns.hashCode()) * 31) + dVar.orders.hashCode();
    }

    public static final int k(C4044n c4044n) {
        p.i(c4044n, "<this>");
        return (((c4044n.name.hashCode() * 31) + c4044n.columns.hashCode()) * 31) + c4044n.foreignKeys.hashCode();
    }

    public static final String l(Collection<?> collection) {
        return w.j(F.A0(collection, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null), null, 1, null) + w.j(" }", null, 1, null);
    }

    public static final String m(Collection<?> collection) {
        return w.j(F.A0(collection, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null), null, 1, null) + w.j("},", null, 1, null);
    }

    public static final String n(C4044n.a aVar) {
        p.i(aVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n            |Column {\n            |   name = '");
        sb2.append(aVar.name);
        sb2.append("',\n            |   type = '");
        sb2.append(aVar.type);
        sb2.append("',\n            |   affinity = '");
        sb2.append(aVar.affinity);
        sb2.append("',\n            |   notNull = '");
        sb2.append(aVar.notNull);
        sb2.append("',\n            |   primaryKeyPosition = '");
        sb2.append(aVar.primaryKeyPosition);
        sb2.append("',\n            |   defaultValue = '");
        String str = aVar.defaultValue;
        if (str == null) {
            str = "undefined";
        }
        sb2.append(str);
        sb2.append("'\n            |}\n        ");
        return w.j(w.p(sb2.toString(), null, 1, null), null, 1, null);
    }

    public static final String o(C4044n.c cVar) {
        p.i(cVar, "<this>");
        return w.j(w.p("\n            |ForeignKey {\n            |   referenceTable = '" + cVar.referenceTable + "',\n            |   onDelete = '" + cVar.onDelete + "',\n            |   onUpdate = '" + cVar.onUpdate + "',\n            |   columnNames = {" + m(F.b1(cVar.columnNames)) + "\n            |   referenceColumnNames = {" + l(F.b1(cVar.referenceColumnNames)) + "\n            |}\n        ", null, 1, null), null, 1, null);
    }

    public static final String p(C4044n.d dVar) {
        p.i(dVar, "<this>");
        return w.j(w.p("\n            |Index {\n            |   name = '" + dVar.name + "',\n            |   unique = '" + dVar.unique + "',\n            |   columns = {" + m(dVar.columns) + "\n            |   orders = {" + l(dVar.orders) + "\n            |}\n        ", null, 1, null), null, 1, null);
    }

    public static final String q(C4044n c4044n) {
        List listM;
        p.i(c4044n, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n            |TableInfo {\n            |    name = '");
        sb2.append(c4044n.name);
        sb2.append("',\n            |    columns = {");
        sb2.append(g(F.c1(c4044n.columns.values(), new a())));
        sb2.append("\n            |    foreignKeys = {");
        sb2.append(g(c4044n.foreignKeys));
        sb2.append("\n            |    indices = {");
        Set<C4044n.d> set = c4044n.indices;
        if (set == null || (listM = F.c1(set, new b())) == null) {
            listM = C1173v.m();
        }
        sb2.append(g(listM));
        sb2.append("\n            |}\n        ");
        return w.p(sb2.toString(), null, 1, null);
    }
}
