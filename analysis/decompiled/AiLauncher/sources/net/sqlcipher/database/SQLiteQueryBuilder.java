package net.sqlcipher.database;

import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import net.sqlcipher.Cursor;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes5.dex */
public class SQLiteQueryBuilder {
    private static final String TAG = "SQLiteQueryBuilder";
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private boolean mStrictProjectionMap;
    private Map<String, String> mProjectionMap = null;
    private String mTables = "";
    private StringBuilder mWhereClause = null;
    private boolean mDistinct = false;
    private SQLiteDatabase.CursorFactory mFactory = null;

    private static void appendClause(StringBuilder sb2, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        sb2.append(str);
        sb2.append(str2);
    }

    private static void appendClauseEscapeClause(StringBuilder sb2, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        sb2.append(str);
        DatabaseUtils.appendEscapedSQLString(sb2, str2);
    }

    public static void appendColumns(StringBuilder sb2, String[] strArr) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            if (str != null) {
                if (i10 > 0) {
                    sb2.append(", ");
                }
                sb2.append(str);
            }
        }
        sb2.append(' ');
    }

    public static String buildQueryString(boolean z10, String str, String[] strArr, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        }
        if (!TextUtils.isEmpty(str6) && !sLimitPattern.matcher(str6).matches()) {
            throw new IllegalArgumentException("invalid LIMIT clauses:" + str6);
        }
        StringBuilder sb2 = new StringBuilder(120);
        sb2.append("SELECT ");
        if (z10) {
            sb2.append("DISTINCT ");
        }
        if (strArr == null || strArr.length == 0) {
            sb2.append("* ");
        } else {
            appendColumns(sb2, strArr);
        }
        sb2.append("FROM ");
        sb2.append(str);
        appendClause(sb2, " WHERE ", str2);
        appendClause(sb2, " GROUP BY ", str3);
        appendClause(sb2, " HAVING ", str4);
        appendClause(sb2, " ORDER BY ", str5);
        appendClause(sb2, " LIMIT ", str6);
        return sb2.toString();
    }

    private String[] computeProjection(String[] strArr) {
        int i10 = 0;
        if (strArr == null || strArr.length <= 0) {
            Map<String, String> map = this.mProjectionMap;
            if (map == null) {
                return null;
            }
            Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
            String[] strArr2 = new String[setEntrySet.size()];
            for (Map.Entry<String, String> entry : setEntrySet) {
                if (!entry.getKey().equals("_count")) {
                    strArr2[i10] = entry.getValue();
                    i10++;
                }
            }
            return strArr2;
        }
        if (this.mProjectionMap == null) {
            return strArr;
        }
        String[] strArr3 = new String[strArr.length];
        int length = strArr.length;
        while (i10 < length) {
            String str = strArr[i10];
            String str2 = this.mProjectionMap.get(str);
            if (str2 != null) {
                strArr3[i10] = str2;
            } else {
                if (this.mStrictProjectionMap || !(str.contains(" AS ") || str.contains(" as "))) {
                    throw new IllegalArgumentException("Invalid column " + strArr[i10]);
                }
                strArr3[i10] = str;
            }
            i10++;
        }
        return strArr3;
    }

    public void appendWhere(CharSequence charSequence) {
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(charSequence.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        this.mWhereClause.append(charSequence);
    }

    public void appendWhereEscapeString(String str) {
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(str.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        DatabaseUtils.appendEscapedSQLString(this.mWhereClause, str);
    }

    public String buildQuery(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        String[] strArrComputeProjection = computeProjection(strArr);
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = this.mWhereClause;
        boolean z10 = sb3 != null && sb3.length() > 0;
        if (z10) {
            sb2.append(this.mWhereClause.toString());
            sb2.append(')');
        }
        if (str != null && str.length() > 0) {
            if (z10) {
                sb2.append(" AND ");
            }
            sb2.append('(');
            sb2.append(str);
            sb2.append(')');
        }
        return buildQueryString(this.mDistinct, this.mTables, strArrComputeProjection, sb2.toString(), str2, str3, str4, str5);
    }

    public String buildUnionQuery(String[] strArr, String str, String str2) {
        StringBuilder sb2 = new StringBuilder(128);
        int length = strArr.length;
        String str3 = this.mDistinct ? " UNION " : " UNION ALL ";
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 > 0) {
                sb2.append(str3);
            }
            sb2.append(strArr[i10]);
        }
        appendClause(sb2, " ORDER BY ", str);
        appendClause(sb2, " LIMIT ", str2);
        return sb2.toString();
    }

    public String buildUnionSubQuery(String str, String[] strArr, Set<String> set, int i10, String str2, String str3, String[] strArr2, String str4, String str5) {
        int length = strArr.length;
        String[] strArr3 = new String[length];
        for (int i11 = 0; i11 < length; i11++) {
            String str6 = strArr[i11];
            if (str6.equals(str)) {
                strArr3[i11] = "'" + str2 + "' AS " + str;
            } else if (i11 <= i10 || set.contains(str6)) {
                strArr3[i11] = str6;
            } else {
                strArr3[i11] = "NULL AS " + str6;
            }
        }
        return buildQuery(strArr3, str3, strArr2, str4, str5, null, null);
    }

    public String getTables() {
        return this.mTables;
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return query(sQLiteDatabase, strArr, str, strArr2, str2, str3, str4, null);
    }

    public void setCursorFactory(SQLiteDatabase.CursorFactory cursorFactory) {
        this.mFactory = cursorFactory;
    }

    public void setDistinct(boolean z10) {
        this.mDistinct = z10;
    }

    public void setProjectionMap(Map<String, String> map) {
        this.mProjectionMap = map;
    }

    public void setStrictProjectionMap(boolean z10) {
        this.mStrictProjectionMap = z10;
    }

    public void setTables(String str) {
        this.mTables = str;
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        if (this.mTables == null) {
            return null;
        }
        String strBuildQuery = buildQuery(strArr, str, strArr2, str2, str3, str4, str5);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Performing query: " + strBuildQuery);
        }
        return sQLiteDatabase.rawQueryWithFactory(this.mFactory, strBuildQuery, strArr2, SQLiteDatabase.findEditTable(this.mTables));
    }
}
