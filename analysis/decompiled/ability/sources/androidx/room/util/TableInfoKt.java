package androidx.room.util;

import C7.r;
import D7.v;
import N9.j;
import androidx.appfunctions.metadata.a;
import androidx.room.util.TableInfo;
import j9.m;
import j9.n;
import j9.t;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\r\u001a!\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\fH\u0000¢\u0006\u0004\b\u0007\u0010\u0013\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\fH\u0000¢\u0006\u0004\b\n\u0010\u0014\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0016\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0015H\u0000¢\u0006\u0004\b\u0007\u0010\u0017\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\u0015H\u0000¢\u0006\u0004\b\n\u0010\u0018\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00192\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u001a\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0019H\u0000¢\u0006\u0004\b\u0007\u0010\u001b\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\u0019H\u0000¢\u0006\u0004\b\n\u0010\u001c\u001a\u001b\u0010\u001f\u001a\u00020\t2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0017\u0010\"\u001a\u00020!*\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b\"\u0010#\u001a\u0017\u0010$\u001a\u00020!*\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b$\u0010#¨\u0006%"}, d2 = {"Landroidx/room/util/TableInfo;", "", "other", "", "equalsCommon", "(Landroidx/room/util/TableInfo;Ljava/lang/Object;)Z", "", "hashCodeCommon", "(Landroidx/room/util/TableInfo;)I", "", "toStringCommon", "(Landroidx/room/util/TableInfo;)Ljava/lang/String;", "Landroidx/room/util/TableInfo$Column;", "(Landroidx/room/util/TableInfo$Column;Ljava/lang/Object;)Z", "current", "defaultValueEqualsCommon", "(Ljava/lang/String;Ljava/lang/String;)Z", "containsSurroundingParenthesis", "(Ljava/lang/String;)Z", "(Landroidx/room/util/TableInfo$Column;)I", "(Landroidx/room/util/TableInfo$Column;)Ljava/lang/String;", "Landroidx/room/util/TableInfo$ForeignKey;", "(Landroidx/room/util/TableInfo$ForeignKey;Ljava/lang/Object;)Z", "(Landroidx/room/util/TableInfo$ForeignKey;)I", "(Landroidx/room/util/TableInfo$ForeignKey;)Ljava/lang/String;", "Landroidx/room/util/TableInfo$Index;", "(Landroidx/room/util/TableInfo$Index;Ljava/lang/Object;)Z", "(Landroidx/room/util/TableInfo$Index;)I", "(Landroidx/room/util/TableInfo$Index;)Ljava/lang/String;", "", "collection", "formatString", "(Ljava/util/Collection;)Ljava/lang/String;", "LC7/r;", "joinToStringMiddleWithIndent", "(Ljava/util/Collection;)V", "joinToStringEndWithIndent", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TableInfoKt {
    private static final boolean containsSurroundingParenthesis(String str) {
        if (str.length() == 0) {
            return false;
        }
        int i = 0;
        int i6 = 0;
        int i10 = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            int i11 = i10 + 1;
            if (i10 == 0 && cCharAt != '(') {
                return false;
            }
            if (cCharAt == '(') {
                i6++;
            } else if (cCharAt == ')' && i6 - 1 == 0 && i10 != str.length() - 1) {
                return false;
            }
            i++;
            i10 = i11;
        }
        return i6 == 0;
    }

    public static final boolean defaultValueEqualsCommon(String current, String str) {
        k.f(current, "current");
        if (current.equals(str)) {
            return true;
        }
        if (!containsSurroundingParenthesis(current)) {
            return false;
        }
        String strSubstring = current.substring(1, current.length() - 1);
        k.e(strSubstring, "substring(...)");
        return k.b(m.R0(strSubstring).toString(), str);
    }

    public static final boolean equalsCommon(TableInfo tableInfo, Object obj) {
        Set<TableInfo.Index> set;
        k.f(tableInfo, "<this>");
        if (tableInfo == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo2 = (TableInfo) obj;
        if (!k.b(tableInfo.name, tableInfo2.name) || !k.b(tableInfo.columns, tableInfo2.columns) || !k.b(tableInfo.foreignKeys, tableInfo2.foreignKeys)) {
            return false;
        }
        Set<TableInfo.Index> set2 = tableInfo.indices;
        if (set2 == null || (set = tableInfo2.indices) == null) {
            return true;
        }
        return k.b(set2, set);
    }

    public static final String formatString(Collection<?> collection) {
        k.f(collection, "collection");
        if (collection.isEmpty()) {
            return " }";
        }
        return n.Q(v.I0(collection, ",\n", "\n", "\n", null, 56)) + "},";
    }

    public static final int hashCodeCommon(TableInfo tableInfo) {
        k.f(tableInfo, "<this>");
        return tableInfo.foreignKeys.hashCode() + a.f(tableInfo.columns, tableInfo.name.hashCode() * 31, 31);
    }

    private static final void joinToStringEndWithIndent(Collection<?> collection) {
        n.Q(v.I0(collection, ",", null, null, null, 62));
        n.Q(" }");
    }

    private static final void joinToStringMiddleWithIndent(Collection<?> collection) {
        n.Q(v.I0(collection, ",", null, null, null, 62));
        n.Q("},");
    }

    public static final String toStringCommon(TableInfo tableInfo) {
        Collection collectionZ0;
        k.f(tableInfo, "<this>");
        StringBuilder sb = new StringBuilder("\n            |TableInfo {\n            |    name = '");
        sb.append(tableInfo.name);
        sb.append("',\n            |    columns = {");
        sb.append(formatString(v.Z0(tableInfo.columns.values(), new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t9, T t10) {
                return j.m(((TableInfo.Column) t9).name, ((TableInfo.Column) t10).name);
            }
        })));
        sb.append("\n            |    foreignKeys = {");
        sb.append(formatString(tableInfo.foreignKeys));
        sb.append("\n            |    indices = {");
        Set<TableInfo.Index> set = tableInfo.indices;
        if (set == null || (collectionZ0 = v.Z0(set, new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t9, T t10) {
                return j.m(((TableInfo.Index) t9).name, ((TableInfo.Index) t10).name);
            }
        })) == null) {
            collectionZ0 = EmptyList.f4893a;
        }
        sb.append(formatString(collectionZ0));
        sb.append("\n            |}\n        ");
        return n.S(sb.toString());
    }

    public static final int hashCodeCommon(TableInfo.Column column) {
        k.f(column, "<this>");
        return (((((column.name.hashCode() * 31) + column.affinity) * 31) + (column.notNull ? 1231 : 1237)) * 31) + column.primaryKeyPosition;
    }

    public static final boolean equalsCommon(TableInfo.Column column, Object obj) {
        k.f(column, "<this>");
        if (column == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.Column)) {
            return false;
        }
        TableInfo.Column column2 = (TableInfo.Column) obj;
        if (column.isPrimaryKey() != column2.isPrimaryKey() || !k.b(column.name, column2.name) || column.notNull != column2.notNull) {
            return false;
        }
        String str = column.defaultValue;
        String str2 = column2.defaultValue;
        if (column.createdFrom == 1 && column2.createdFrom == 2 && str != null && !defaultValueEqualsCommon(str, str2)) {
            return false;
        }
        if (column.createdFrom == 2 && column2.createdFrom == 1 && str2 != null && !defaultValueEqualsCommon(str2, str)) {
            return false;
        }
        int i = column.createdFrom;
        return (i == 0 || i != column2.createdFrom || (str == null ? str2 == null : defaultValueEqualsCommon(str, str2))) && column.affinity == column2.affinity;
    }

    public static final int hashCodeCommon(TableInfo.ForeignKey foreignKey) {
        k.f(foreignKey, "<this>");
        return foreignKey.referenceColumnNames.hashCode() + a.e(foreignKey.columnNames, B7.a.c(B7.a.c(foreignKey.referenceTable.hashCode() * 31, 31, foreignKey.onDelete), 31, foreignKey.onUpdate), 31);
    }

    public static final int hashCodeCommon(TableInfo.Index index) {
        k.f(index, "<this>");
        return index.orders.hashCode() + a.e(index.columns, (((t.e0(index.name, TableInfo.Index.DEFAULT_PREFIX, false) ? -1184239155 : index.name.hashCode()) * 31) + (index.unique ? 1 : 0)) * 31, 31);
    }

    public static final boolean equalsCommon(TableInfo.ForeignKey foreignKey, Object obj) {
        k.f(foreignKey, "<this>");
        if (foreignKey == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.ForeignKey)) {
            return false;
        }
        TableInfo.ForeignKey foreignKey2 = (TableInfo.ForeignKey) obj;
        if (k.b(foreignKey.referenceTable, foreignKey2.referenceTable) && k.b(foreignKey.onDelete, foreignKey2.onDelete) && k.b(foreignKey.onUpdate, foreignKey2.onUpdate) && k.b(foreignKey.columnNames, foreignKey2.columnNames)) {
            return k.b(foreignKey.referenceColumnNames, foreignKey2.referenceColumnNames);
        }
        return false;
    }

    public static final String toStringCommon(TableInfo.Column column) {
        k.f(column, "<this>");
        StringBuilder sb = new StringBuilder("\n            |Column {\n            |   name = '");
        sb.append(column.name);
        sb.append("',\n            |   type = '");
        sb.append(column.type);
        sb.append("',\n            |   affinity = '");
        sb.append(column.affinity);
        sb.append("',\n            |   notNull = '");
        sb.append(column.notNull);
        sb.append("',\n            |   primaryKeyPosition = '");
        sb.append(column.primaryKeyPosition);
        sb.append("',\n            |   defaultValue = '");
        String str = column.defaultValue;
        if (str == null) {
            str = "undefined";
        }
        sb.append(str);
        sb.append("'\n            |}\n        ");
        return n.Q(n.S(sb.toString()));
    }

    public static final boolean equalsCommon(TableInfo.Index index, Object obj) {
        k.f(index, "<this>");
        if (index == obj) {
            return true;
        }
        if (obj instanceof TableInfo.Index) {
            TableInfo.Index index2 = (TableInfo.Index) obj;
            if (index.unique == index2.unique && k.b(index.columns, index2.columns) && k.b(index.orders, index2.orders)) {
                if (t.e0(index.name, TableInfo.Index.DEFAULT_PREFIX, false)) {
                    return t.e0(index2.name, TableInfo.Index.DEFAULT_PREFIX, false);
                }
                return k.b(index.name, index2.name);
            }
        }
        return false;
    }

    public static final String toStringCommon(TableInfo.ForeignKey foreignKey) {
        k.f(foreignKey, "<this>");
        StringBuilder sb = new StringBuilder("\n            |ForeignKey {\n            |   referenceTable = '");
        sb.append(foreignKey.referenceTable);
        sb.append("',\n            |   onDelete = '");
        sb.append(foreignKey.onDelete);
        sb.append("',\n            |   onUpdate = '");
        sb.append(foreignKey.onUpdate);
        sb.append("',\n            |   columnNames = {");
        joinToStringMiddleWithIndent(v.Y0(foreignKey.columnNames));
        r rVar = r.f317a;
        sb.append(rVar);
        sb.append("\n            |   referenceColumnNames = {");
        joinToStringEndWithIndent(v.Y0(foreignKey.referenceColumnNames));
        sb.append(rVar);
        sb.append("\n            |}\n        ");
        return n.Q(n.S(sb.toString()));
    }

    public static final String toStringCommon(TableInfo.Index index) {
        k.f(index, "<this>");
        StringBuilder sb = new StringBuilder("\n            |Index {\n            |   name = '");
        sb.append(index.name);
        sb.append("',\n            |   unique = '");
        sb.append(index.unique);
        sb.append("',\n            |   columns = {");
        joinToStringMiddleWithIndent(index.columns);
        r rVar = r.f317a;
        sb.append(rVar);
        sb.append("\n            |   orders = {");
        joinToStringEndWithIndent(index.orders);
        sb.append(rVar);
        sb.append("\n            |}\n        ");
        return n.Q(n.S(sb.toString()));
    }
}
