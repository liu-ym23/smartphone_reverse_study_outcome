package i0;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import k0.InterfaceC0674b;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f13014a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f13015b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f13016c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f13017d;

    public f(String name, Map columns, Set foreignKeys, Set set) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(columns, "columns");
        Intrinsics.checkNotNullParameter(foreignKeys, "foreignKeys");
        this.f13014a = name;
        this.f13015b = columns;
        this.f13016c = foreignKeys;
        this.f13017d = set;
    }

    /* JADX WARN: Finally extract failed */
    public static final f a(InterfaceC0674b database, String tableName) {
        Map mapBuild;
        Set set;
        int i4;
        int i5;
        Throwable th;
        e eVar;
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        StringBuilder sb = new StringBuilder("PRAGMA table_info(`");
        sb.append(tableName);
        String str = "`)";
        sb.append("`)");
        Cursor cursorQuery = database.query(sb.toString());
        try {
            Cursor cursor = cursorQuery;
            String str2 = "name";
            if (cursor.getColumnCount() <= 0) {
                mapBuild = MapsKt.emptyMap();
                CloseableKt.closeFinally(cursorQuery, null);
            } else {
                int columnIndex = cursor.getColumnIndex("name");
                int columnIndex2 = cursor.getColumnIndex("type");
                int columnIndex3 = cursor.getColumnIndex("notnull");
                int columnIndex4 = cursor.getColumnIndex("pk");
                int columnIndex5 = cursor.getColumnIndex("dflt_value");
                Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                while (cursor.moveToNext()) {
                    String name = cursor.getString(columnIndex);
                    int i6 = columnIndex;
                    String type = cursor.getString(columnIndex2);
                    boolean z4 = cursor.getInt(columnIndex3) != 0;
                    int i7 = cursor.getInt(columnIndex4);
                    String string = cursor.getString(columnIndex5);
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    Intrinsics.checkNotNullExpressionValue(type, "type");
                    mapCreateMapBuilder.put(name, new b(name, type, z4, i7, string, 2));
                    columnIndex = i6;
                    cursor = cursor;
                }
                mapBuild = MapsKt.build(mapCreateMapBuilder);
                CloseableKt.closeFinally(cursorQuery, null);
            }
            cursorQuery = database.query("PRAGMA foreign_key_list(`" + tableName + "`)");
            try {
                Cursor cursor2 = cursorQuery;
                int columnIndex6 = cursor2.getColumnIndex("id");
                int columnIndex7 = cursor2.getColumnIndex("seq");
                int columnIndex8 = cursor2.getColumnIndex("table");
                int columnIndex9 = cursor2.getColumnIndex("on_delete");
                int columnIndex10 = cursor2.getColumnIndex("on_update");
                int columnIndex11 = cursor2.getColumnIndex("id");
                int columnIndex12 = cursor2.getColumnIndex("seq");
                int columnIndex13 = cursor2.getColumnIndex("from");
                int columnIndex14 = cursor2.getColumnIndex("to");
                Map map = mapBuild;
                List listCreateListBuilder = CollectionsKt.createListBuilder();
                while (cursor2.moveToNext()) {
                    int i8 = cursor2.getInt(columnIndex11);
                    int i9 = columnIndex11;
                    int i10 = cursor2.getInt(columnIndex12);
                    int i11 = columnIndex12;
                    String string2 = cursor2.getString(columnIndex13);
                    int i12 = columnIndex13;
                    Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(fromColumnIndex)");
                    String string3 = cursor2.getString(columnIndex14);
                    Intrinsics.checkNotNullExpressionValue(string3, "cursor.getString(toColumnIndex)");
                    listCreateListBuilder.add(new d(i8, i10, string2, string3));
                    str2 = str2;
                    columnIndex11 = i9;
                    columnIndex12 = i11;
                    columnIndex13 = i12;
                    columnIndex14 = columnIndex14;
                }
                String str3 = str2;
                List listSorted = CollectionsKt.sorted(CollectionsKt.build(listCreateListBuilder));
                cursor2.moveToPosition(-1);
                Set setCreateSetBuilder = SetsKt.createSetBuilder();
                while (cursor2.moveToNext()) {
                    if (cursor2.getInt(columnIndex7) == 0) {
                        int i13 = cursor2.getInt(columnIndex6);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj : listSorted) {
                            List list = listSorted;
                            int i14 = columnIndex6;
                            if (((d) obj).f13006a == i13) {
                                arrayList3.add(obj);
                            }
                            listSorted = list;
                            columnIndex6 = i14;
                        }
                        List list2 = listSorted;
                        int i15 = columnIndex6;
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            d dVar = (d) it.next();
                            arrayList.add(dVar.f13008c);
                            arrayList2.add(dVar.f13009d);
                        }
                        String string4 = cursor2.getString(columnIndex8);
                        Intrinsics.checkNotNullExpressionValue(string4, "cursor.getString(tableColumnIndex)");
                        String string5 = cursor2.getString(columnIndex9);
                        Intrinsics.checkNotNullExpressionValue(string5, "cursor.getString(onDeleteColumnIndex)");
                        String string6 = cursor2.getString(columnIndex10);
                        Intrinsics.checkNotNullExpressionValue(string6, "cursor.getString(onUpdateColumnIndex)");
                        setCreateSetBuilder.add(new c(string4, string5, string6, arrayList, arrayList2));
                        listSorted = list2;
                        columnIndex6 = i15;
                    }
                }
                Set setBuild = SetsKt.build(setCreateSetBuilder);
                CloseableKt.closeFinally(cursorQuery, null);
                InterfaceC0674b interfaceC0674b = database;
                cursorQuery = interfaceC0674b.query("PRAGMA index_list(`" + tableName + "`)");
                try {
                    Cursor cursor3 = cursorQuery;
                    String str4 = str3;
                    int columnIndex15 = cursor3.getColumnIndex(str4);
                    int columnIndex16 = cursor3.getColumnIndex("origin");
                    int columnIndex17 = cursor3.getColumnIndex("unique");
                    if (columnIndex15 == -1 || columnIndex16 == -1 || columnIndex17 == -1) {
                        CloseableKt.closeFinally(cursorQuery, null);
                        set = null;
                    } else {
                        Set setCreateSetBuilder2 = SetsKt.createSetBuilder();
                        while (true) {
                            if (!cursor3.moveToNext()) {
                                Set setBuild2 = SetsKt.build(setCreateSetBuilder2);
                                CloseableKt.closeFinally(cursorQuery, null);
                                set = setBuild2;
                                break;
                            }
                            if (Intrinsics.areEqual("c", cursor3.getString(columnIndex16))) {
                                String string7 = cursor3.getString(columnIndex15);
                                boolean z5 = cursor3.getInt(columnIndex17) == 1;
                                Intrinsics.checkNotNullExpressionValue(string7, str4);
                                cursorQuery = interfaceC0674b.query("PRAGMA index_xinfo(`" + string7 + str);
                                try {
                                    Cursor cursor4 = cursorQuery;
                                    int columnIndex18 = cursor4.getColumnIndex("seqno");
                                    int columnIndex19 = cursor4.getColumnIndex("cid");
                                    Cursor cursor5 = cursor3;
                                    int columnIndex20 = cursor4.getColumnIndex(str4);
                                    String str5 = str4;
                                    int columnIndex21 = cursor4.getColumnIndex("desc");
                                    String str6 = str;
                                    if (columnIndex18 == -1 || columnIndex19 == -1 || columnIndex20 == -1 || columnIndex21 == -1) {
                                        i4 = columnIndex15;
                                        i5 = columnIndex16;
                                        th = null;
                                        CloseableKt.closeFinally(cursorQuery, null);
                                        eVar = null;
                                    } else {
                                        TreeMap treeMap = new TreeMap();
                                        i4 = columnIndex15;
                                        TreeMap treeMap2 = new TreeMap();
                                        while (cursor4.moveToNext()) {
                                            if (cursor4.getInt(columnIndex19) >= 0) {
                                                int i16 = cursor4.getInt(columnIndex18);
                                                int i17 = columnIndex19;
                                                String columnName = cursor4.getString(columnIndex20);
                                                int i18 = columnIndex20;
                                                String str7 = cursor4.getInt(columnIndex21) > 0 ? "DESC" : "ASC";
                                                int i19 = columnIndex21;
                                                Integer numValueOf = Integer.valueOf(i16);
                                                Intrinsics.checkNotNullExpressionValue(columnName, "columnName");
                                                treeMap.put(numValueOf, columnName);
                                                treeMap2.put(Integer.valueOf(i16), str7);
                                                columnIndex19 = i17;
                                                columnIndex21 = i19;
                                                columnIndex20 = i18;
                                                columnIndex16 = columnIndex16;
                                            }
                                        }
                                        i5 = columnIndex16;
                                        Collection collectionValues = treeMap.values();
                                        Intrinsics.checkNotNullExpressionValue(collectionValues, "columnsMap.values");
                                        List list3 = CollectionsKt.toList(collectionValues);
                                        Collection collectionValues2 = treeMap2.values();
                                        Intrinsics.checkNotNullExpressionValue(collectionValues2, "ordersMap.values");
                                        e eVar2 = new e(string7, z5, list3, CollectionsKt.toList(collectionValues2));
                                        CloseableKt.closeFinally(cursorQuery, null);
                                        eVar = eVar2;
                                        th = null;
                                    }
                                    if (eVar == null) {
                                        CloseableKt.closeFinally(cursorQuery, th);
                                        set = null;
                                        break;
                                    }
                                    setCreateSetBuilder2.add(eVar);
                                    interfaceC0674b = database;
                                    cursor3 = cursor5;
                                    str4 = str5;
                                    str = str6;
                                    columnIndex15 = i4;
                                    columnIndex16 = i5;
                                } finally {
                                }
                            }
                        }
                    }
                    return new f(tableName, map, setBuild, set);
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } finally {
                }
            }
        } finally {
            try {
                throw th2;
            } finally {
            }
        }
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (!Intrinsics.areEqual(this.f13014a, fVar.f13014a) || !Intrinsics.areEqual(this.f13015b, fVar.f13015b) || !Intrinsics.areEqual(this.f13016c, fVar.f13016c)) {
            return false;
        }
        Set set2 = this.f13017d;
        if (set2 == null || (set = fVar.f13017d) == null) {
            return true;
        }
        return Intrinsics.areEqual(set2, set);
    }

    public final int hashCode() {
        return this.f13016c.hashCode() + ((this.f13015b.hashCode() + (this.f13014a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "TableInfo{name='" + this.f13014a + "', columns=" + this.f13015b + ", foreignKeys=" + this.f13016c + ", indices=" + this.f13017d + '}';
    }
}
