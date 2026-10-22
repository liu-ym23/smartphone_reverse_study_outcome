package v1;

import gc.o;
import gc.q;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f13347a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13348b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<b> f13349c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<d> f13350d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f13351a;

        /* renamed from: b, reason: collision with root package name */
        public final String f13352b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f13353c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13354d;

        /* renamed from: e, reason: collision with root package name */
        public final String f13355e;

        /* renamed from: f, reason: collision with root package name */
        public final int f13356f;

        /* renamed from: g, reason: collision with root package name */
        public final int f13357g;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: v1.c$a$a, reason: collision with other inner class name */
        public static final class C0153a {
            public static boolean a(String current, String str) {
                g.f(current, "current");
                if (current.equals(str)) {
                    return true;
                }
                if (current.length() != 0) {
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    while (true) {
                        if (i10 < current.length()) {
                            char cCharAt = current.charAt(i10);
                            int i13 = i12 + 1;
                            if (i12 == 0 && cCharAt != '(') {
                                break;
                            }
                            if (cCharAt != '(') {
                                if (cCharAt == ')' && i11 - 1 == 0 && i12 != current.length() - 1) {
                                    break;
                                }
                            } else {
                                i11++;
                            }
                            i10++;
                            i12 = i13;
                        } else if (i11 == 0) {
                            String strSubstring = current.substring(1, current.length() - 1);
                            g.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                            return g.b(q.L0(strSubstring).toString(), str);
                        }
                    }
                }
                return false;
            }
        }

        public a(String str, String str2, boolean z, int i10, String str3, int i11) {
            this.f13351a = str;
            this.f13352b = str2;
            this.f13353c = z;
            this.f13354d = i10;
            this.f13355e = str3;
            this.f13356f = i11;
            Locale US = Locale.US;
            g.e(US, "US");
            String upperCase = str2.toUpperCase(US);
            g.e(upperCase, "this as java.lang.String).toUpperCase(locale)");
            this.f13357g = q.l0(upperCase, "INT", false) ? 3 : (q.l0(upperCase, "CHAR", false) || q.l0(upperCase, "CLOB", false) || q.l0(upperCase, "TEXT", false)) ? 2 : q.l0(upperCase, "BLOB", false) ? 5 : (q.l0(upperCase, "REAL", false) || q.l0(upperCase, "FLOA", false) || q.l0(upperCase, "DOUB", false)) ? 4 : 1;
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                if (this.f13354d != aVar.f13354d) {
                    return false;
                }
                int i10 = aVar.f13356f;
                String str = aVar.f13355e;
                if (!this.f13351a.equals(aVar.f13351a) || this.f13353c != aVar.f13353c) {
                    return false;
                }
                String str2 = this.f13355e;
                int i11 = this.f13356f;
                if (i11 == 1 && i10 == 2 && str2 != null && !C0153a.a(str2, str)) {
                    return false;
                }
                if (i11 == 2 && i10 == 1 && str != null && !C0153a.a(str, str2)) {
                    return false;
                }
                if (i11 != 0 && i11 == i10) {
                    if (str2 != null) {
                        if (!C0153a.a(str2, str)) {
                            return false;
                        }
                    } else if (str != null) {
                        return false;
                    }
                }
                if (this.f13357g != aVar.f13357g) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            return (((((this.f13351a.hashCode() * 31) + this.f13357g) * 31) + (this.f13353c ? 1231 : 1237)) * 31) + this.f13354d;
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("Column{name='");
            sb2.append(this.f13351a);
            sb2.append("', type='");
            sb2.append(this.f13352b);
            sb2.append("', affinity='");
            sb2.append(this.f13357g);
            sb2.append("', notNull=");
            sb2.append(this.f13353c);
            sb2.append(", primaryKeyPosition=");
            sb2.append(this.f13354d);
            sb2.append(", defaultValue='");
            String str = this.f13355e;
            if (str == null) {
                str = "undefined";
            }
            return ai.onnxruntime.a.o(sb2, str, "'}");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f13358a;

        /* renamed from: b, reason: collision with root package name */
        public final String f13359b;

        /* renamed from: c, reason: collision with root package name */
        public final String f13360c;

        /* renamed from: d, reason: collision with root package name */
        public final List<String> f13361d;

        /* renamed from: e, reason: collision with root package name */
        public final List<String> f13362e;

        public b(String str, String str2, String str3, List<String> columnNames, List<String> referenceColumnNames) {
            g.f(columnNames, "columnNames");
            g.f(referenceColumnNames, "referenceColumnNames");
            this.f13358a = str;
            this.f13359b = str2;
            this.f13360c = str3;
            this.f13361d = columnNames;
            this.f13362e = referenceColumnNames;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (g.b(this.f13358a, bVar.f13358a) && g.b(this.f13359b, bVar.f13359b) && g.b(this.f13360c, bVar.f13360c) && g.b(this.f13361d, bVar.f13361d)) {
                return g.b(this.f13362e, bVar.f13362e);
            }
            return false;
        }

        public final int hashCode() {
            return this.f13362e.hashCode() + h0.e.b(this.f13361d, v1.d.a(v1.d.a(this.f13358a.hashCode() * 31, 31, this.f13359b), 31, this.f13360c), 31);
        }

        public final String toString() {
            return "ForeignKey{referenceTable='" + this.f13358a + "', onDelete='" + this.f13359b + " +', onUpdate='" + this.f13360c + "', columnNames=" + this.f13361d + ", referenceColumnNames=" + this.f13362e + '}';
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: v1.c$c, reason: collision with other inner class name */
    public static final class C0154c implements Comparable<C0154c> {

        /* renamed from: a, reason: collision with root package name */
        public final int f13363a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13364b;

        /* renamed from: c, reason: collision with root package name */
        public final String f13365c;

        /* renamed from: d, reason: collision with root package name */
        public final String f13366d;

        public C0154c(String str, int i10, int i11, String str2) {
            this.f13363a = i10;
            this.f13364b = i11;
            this.f13365c = str;
            this.f13366d = str2;
        }

        @Override // java.lang.Comparable
        public final int compareTo(C0154c c0154c) {
            C0154c other = c0154c;
            g.f(other, "other");
            int i10 = this.f13363a - other.f13363a;
            return i10 == 0 ? this.f13364b - other.f13364b : i10;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f13367a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f13368b;

        /* renamed from: c, reason: collision with root package name */
        public final List<String> f13369c;

        /* renamed from: d, reason: collision with root package name */
        public final List<String> f13370d;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Collection, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
        public d(String str, boolean z, List<String> columns, List<String> orders) {
            g.f(columns, "columns");
            g.f(orders, "orders");
            this.f13367a = str;
            this.f13368b = z;
            this.f13369c = columns;
            this.f13370d = orders;
            if (orders.isEmpty()) {
                int size = columns.size();
                orders = new ArrayList<>(size);
                for (int i10 = 0; i10 < size; i10++) {
                    orders.add("ASC");
                }
            }
            this.f13370d = orders;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                String str = dVar.f13367a;
                if (this.f13368b == dVar.f13368b && g.b(this.f13369c, dVar.f13369c) && g.b(this.f13370d, dVar.f13370d)) {
                    String str2 = this.f13367a;
                    return o.k0(str2, "index_", false) ? o.k0(str, "index_", false) : str2.equals(str);
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.f13367a;
            return this.f13370d.hashCode() + h0.e.b(this.f13369c, (((o.k0(str, "index_", false) ? -1184239155 : str.hashCode()) * 31) + (this.f13368b ? 1 : 0)) * 31, 31);
        }

        public final String toString() {
            return "Index{name='" + this.f13367a + "', unique=" + this.f13368b + ", columns=" + this.f13369c + ", orders=" + this.f13370d + "'}";
        }
    }

    public c(String str, Map map, AbstractSet foreignKeys, AbstractSet abstractSet) {
        g.f(foreignKeys, "foreignKeys");
        this.f13347a = str;
        this.f13348b = map;
        this.f13349c = foreignKeys;
        this.f13350d = abstractSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x01df, code lost:
    
        r9 = mb.y.j(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01e3, code lost:
    
        r3.close();
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final v1.c a(androidx.sqlite.db.framework.FrameworkSQLiteDatabase r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.c.a(androidx.sqlite.db.framework.FrameworkSQLiteDatabase, java.lang.String):v1.c");
    }

    public final boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f13347a.equals(cVar.f13347a) || !this.f13348b.equals(cVar.f13348b) || !g.b(this.f13349c, cVar.f13349c)) {
            return false;
        }
        Set<d> set2 = this.f13350d;
        if (set2 == null || (set = cVar.f13350d) == null) {
            return true;
        }
        return set2.equals(set);
    }

    public final int hashCode() {
        return this.f13349c.hashCode() + ((this.f13348b.hashCode() + (this.f13347a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "TableInfo{name='" + this.f13347a + "', columns=" + this.f13348b + ", foreignKeys=" + this.f13349c + ", indices=" + this.f13350d + '}';
    }
}
