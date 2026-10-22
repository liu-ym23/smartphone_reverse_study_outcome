package b0;

import android.database.Cursor;
import com.stepos.minor.Minor;
import d0.InterfaceC0647b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* renamed from: b0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0552a {

    /* renamed from: a, reason: collision with root package name */
    public final String f11762a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, C0153a> f11763b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<b> f11764c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<d> f11765d;

    /* renamed from: b0.a$a, reason: collision with other inner class name */
    public static class C0153a {

        /* renamed from: a, reason: collision with root package name */
        public final String f11766a;

        /* renamed from: b, reason: collision with root package name */
        public final String f11767b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11768c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f11769d;

        /* renamed from: e, reason: collision with root package name */
        public final int f11770e;

        public C0153a(String str, String str2, boolean z5, int i5) {
            this.f11766a = str;
            this.f11767b = str2;
            this.f11769d = z5;
            this.f11770e = i5;
            this.f11768c = a(str2);
        }

        private static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                C0153a c0153a = (C0153a) obj;
                if (this.f11770e == c0153a.f11770e && this.f11766a.equals(c0153a.f11766a) && this.f11769d == c0153a.f11769d && this.f11768c == c0153a.f11768c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f11766a.hashCode() * 31) + this.f11768c) * 31) + (this.f11769d ? 1231 : 1237)) * 31) + this.f11770e;
        }

        public String toString() {
            return "Column{name='" + this.f11766a + "', type='" + this.f11767b + "', affinity='" + this.f11768c + "', notNull=" + this.f11769d + ", primaryKeyPosition=" + this.f11770e + '}';
        }
    }

    /* renamed from: b0.a$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f11771a;

        /* renamed from: b, reason: collision with root package name */
        public final String f11772b;

        /* renamed from: c, reason: collision with root package name */
        public final String f11773c;

        /* renamed from: d, reason: collision with root package name */
        public final List<String> f11774d;

        /* renamed from: e, reason: collision with root package name */
        public final List<String> f11775e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f11771a = str;
            this.f11772b = str2;
            this.f11773c = str3;
            this.f11774d = Collections.unmodifiableList(list);
            this.f11775e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f11771a.equals(bVar.f11771a) && this.f11772b.equals(bVar.f11772b) && this.f11773c.equals(bVar.f11773c) && this.f11774d.equals(bVar.f11774d)) {
                return this.f11775e.equals(bVar.f11775e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f11771a.hashCode() * 31) + this.f11772b.hashCode()) * 31) + this.f11773c.hashCode()) * 31) + this.f11774d.hashCode()) * 31) + this.f11775e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f11771a + "', onDelete='" + this.f11772b + "', onUpdate='" + this.f11773c + "', columnNames=" + this.f11774d + ", referenceColumnNames=" + this.f11775e + '}';
        }
    }

    /* renamed from: b0.a$c */
    static class c implements Comparable<c> {

        /* renamed from: a, reason: collision with root package name */
        final int f11776a;

        /* renamed from: b, reason: collision with root package name */
        final int f11777b;

        /* renamed from: c, reason: collision with root package name */
        final String f11778c;

        /* renamed from: d, reason: collision with root package name */
        final String f11779d;

        c(int i5, int i6, String str, String str2) {
            this.f11776a = i5;
            this.f11777b = i6;
            this.f11778c = str;
            this.f11779d = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            int i5 = this.f11776a - cVar.f11776a;
            return i5 == 0 ? this.f11777b - cVar.f11777b : i5;
        }
    }

    /* renamed from: b0.a$d */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f11780a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f11781b;

        /* renamed from: c, reason: collision with root package name */
        public final List<String> f11782c;

        public d(String str, boolean z5, List<String> list) {
            this.f11780a = str;
            this.f11781b = z5;
            this.f11782c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f11781b == dVar.f11781b && this.f11782c.equals(dVar.f11782c)) {
                return this.f11780a.startsWith("index_") ? dVar.f11780a.startsWith("index_") : this.f11780a.equals(dVar.f11780a);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f11780a.startsWith("index_") ? -1184239155 : this.f11780a.hashCode()) * 31) + (this.f11781b ? 1 : 0)) * 31) + this.f11782c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f11780a + "', unique=" + this.f11781b + ", columns=" + this.f11782c + '}';
        }
    }

    public C0552a(String str, Map<String, C0153a> map, Set<b> set, Set<d> set2) {
        this.f11762a = str;
        this.f11763b = Collections.unmodifiableMap(map);
        this.f11764c = Collections.unmodifiableSet(set);
        this.f11765d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public static C0552a a(InterfaceC0647b interfaceC0647b, String str) {
        return new C0552a(str, b(interfaceC0647b, str), d(interfaceC0647b, str), f(interfaceC0647b, str));
    }

    private static Map<String, C0153a> b(InterfaceC0647b interfaceC0647b, String str) {
        Cursor cursorD = interfaceC0647b.d("PRAGMA table_info(`" + str + "`)");
        HashMap map = new HashMap();
        try {
            if (cursorD.getColumnCount() > 0) {
                int columnIndex = cursorD.getColumnIndex(Minor.COLUMN_NAME);
                int columnIndex2 = cursorD.getColumnIndex("type");
                int columnIndex3 = cursorD.getColumnIndex("notnull");
                int columnIndex4 = cursorD.getColumnIndex("pk");
                while (cursorD.moveToNext()) {
                    String string = cursorD.getString(columnIndex);
                    map.put(string, new C0153a(string, cursorD.getString(columnIndex2), cursorD.getInt(columnIndex3) != 0, cursorD.getInt(columnIndex4)));
                }
            }
            return map;
        } finally {
            cursorD.close();
        }
    }

    private static List<c> c(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(Minor.COLUMN_ID);
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < count; i5++) {
            cursor.moveToPosition(i5);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Set<b> d(InterfaceC0647b interfaceC0647b, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorD = interfaceC0647b.d("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = cursorD.getColumnIndex(Minor.COLUMN_ID);
            int columnIndex2 = cursorD.getColumnIndex("seq");
            int columnIndex3 = cursorD.getColumnIndex("table");
            int columnIndex4 = cursorD.getColumnIndex("on_delete");
            int columnIndex5 = cursorD.getColumnIndex("on_update");
            List<c> listC = c(cursorD);
            int count = cursorD.getCount();
            for (int i5 = 0; i5 < count; i5++) {
                cursorD.moveToPosition(i5);
                if (cursorD.getInt(columnIndex2) == 0) {
                    int i6 = cursorD.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c cVar : listC) {
                        if (cVar.f11776a == i6) {
                            arrayList.add(cVar.f11778c);
                            arrayList2.add(cVar.f11779d);
                        }
                    }
                    hashSet.add(new b(cursorD.getString(columnIndex3), cursorD.getString(columnIndex4), cursorD.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            cursorD.close();
            return hashSet;
        } catch (Throwable th) {
            cursorD.close();
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    private static d e(InterfaceC0647b interfaceC0647b, String str, boolean z5) {
        Cursor cursorD = interfaceC0647b.d("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorD.getColumnIndex("seqno");
            int columnIndex2 = cursorD.getColumnIndex("cid");
            int columnIndex3 = cursorD.getColumnIndex(Minor.COLUMN_NAME);
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (cursorD.moveToNext()) {
                    if (cursorD.getInt(columnIndex2) >= 0) {
                        treeMap.put(Integer.valueOf(cursorD.getInt(columnIndex)), cursorD.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                d dVar = new d(str, z5, arrayList);
                cursorD.close();
                return dVar;
            }
            cursorD.close();
            return null;
        } catch (Throwable th) {
            cursorD.close();
            throw th;
        }
    }

    private static Set<d> f(InterfaceC0647b interfaceC0647b, String str) {
        Cursor cursorD = interfaceC0647b.d("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = cursorD.getColumnIndex(Minor.COLUMN_NAME);
            int columnIndex2 = cursorD.getColumnIndex("origin");
            int columnIndex3 = cursorD.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                HashSet hashSet = new HashSet();
                while (cursorD.moveToNext()) {
                    if ("c".equals(cursorD.getString(columnIndex2))) {
                        String string = cursorD.getString(columnIndex);
                        boolean z5 = true;
                        if (cursorD.getInt(columnIndex3) != 1) {
                            z5 = false;
                        }
                        d dVarE = e(interfaceC0647b, string, z5);
                        if (dVarE == null) {
                            return null;
                        }
                        hashSet.add(dVarE);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            cursorD.close();
        }
    }

    public boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0552a c0552a = (C0552a) obj;
        String str = this.f11762a;
        if (str == null ? c0552a.f11762a != null : !str.equals(c0552a.f11762a)) {
            return false;
        }
        Map<String, C0153a> map = this.f11763b;
        if (map == null ? c0552a.f11763b != null : !map.equals(c0552a.f11763b)) {
            return false;
        }
        Set<b> set2 = this.f11764c;
        if (set2 == null ? c0552a.f11764c != null : !set2.equals(c0552a.f11764c)) {
            return false;
        }
        Set<d> set3 = this.f11765d;
        if (set3 == null || (set = c0552a.f11765d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.f11762a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, C0153a> map = this.f11763b;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.f11764c;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "TableInfo{name='" + this.f11762a + "', columns=" + this.f11763b + ", foreignKeys=" + this.f11764c + ", indices=" + this.f11765d + '}';
    }
}
