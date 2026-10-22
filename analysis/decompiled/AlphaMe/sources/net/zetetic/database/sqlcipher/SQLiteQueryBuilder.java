package net.zetetic.database.sqlcipher;

import B0.g;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.CancellationSignal;
import android.text.TextUtils;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import net.zetetic.database.Logger;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes2.dex */
public class SQLiteQueryBuilder {
    private static final String TAG = "SQLiteQueryBuilder";
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private boolean mStrict;
    private Map<String, String> mProjectionMap = null;
    private String mTables = "";
    private StringBuilder mWhereClause = null;
    private boolean mDistinct = false;
    private SQLiteDatabase.CursorFactory mFactory = null;

    private static void appendClause(StringBuilder sb, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append(str2);
    }

    public static void appendColumns(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            String str = strArr[i4];
            if (str != null) {
                if (i4 > 0) {
                    sb.append(", ");
                }
                sb.append(str);
            }
        }
        sb.append(' ');
    }

    public static String buildQueryString(boolean z4, String str, String[] strArr, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        }
        if (!TextUtils.isEmpty(str6) && !sLimitPattern.matcher(str6).matches()) {
            throw new IllegalArgumentException(g.m("invalid LIMIT clauses:", str6));
        }
        StringBuilder sb = new StringBuilder(SyslogConstants.LOG_CLOCK);
        sb.append("SELECT ");
        if (z4) {
            sb.append("DISTINCT ");
        }
        if (strArr == null || strArr.length == 0) {
            sb.append("* ");
        } else {
            appendColumns(sb, strArr);
        }
        sb.append("FROM ");
        sb.append(str);
        appendClause(sb, " WHERE ", str2);
        appendClause(sb, " GROUP BY ", str3);
        appendClause(sb, " HAVING ", str4);
        appendClause(sb, " ORDER BY ", str5);
        appendClause(sb, " LIMIT ", str6);
        return sb.toString();
    }

    private String[] computeProjection(String[] strArr) {
        int i4 = 0;
        if (strArr == null || strArr.length <= 0) {
            Map<String, String> map = this.mProjectionMap;
            if (map == null) {
                return null;
            }
            Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
            String[] strArr2 = new String[setEntrySet.size()];
            for (Map.Entry<String, String> entry : setEntrySet) {
                if (!entry.getKey().equals("_count")) {
                    strArr2[i4] = entry.getValue();
                    i4++;
                }
            }
            return strArr2;
        }
        if (this.mProjectionMap == null) {
            return strArr;
        }
        String[] strArr3 = new String[strArr.length];
        int length = strArr.length;
        while (i4 < length) {
            String str = strArr[i4];
            String str2 = this.mProjectionMap.get(str);
            if (str2 != null) {
                strArr3[i4] = str2;
            } else {
                if (this.mStrict || !(str.contains(" AS ") || str.contains(" as "))) {
                    throw new IllegalArgumentException("Invalid column " + strArr[i4]);
                }
                strArr3[i4] = str;
            }
            i4++;
        }
        return strArr3;
    }

    public void appendWhere(CharSequence charSequence) {
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(charSequence.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
        }
        this.mWhereClause.append(charSequence);
    }

    public void appendWhereEscapeString(String str) {
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(str.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
        }
        DatabaseUtils.appendEscapedSQLString(this.mWhereClause, str);
    }

    public String buildQuery(String[] strArr, String str, String str2, String str3, String str4, String str5) {
        String[] strArrComputeProjection = computeProjection(strArr);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = this.mWhereClause;
        boolean z4 = sb2 != null && sb2.length() > 0;
        if (z4) {
            sb.append(this.mWhereClause.toString());
            sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        if (str != null && str.length() > 0) {
            if (z4) {
                sb.append(" AND ");
            }
            sb.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
            sb.append(str);
            sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        return buildQueryString(this.mDistinct, this.mTables, strArrComputeProjection, sb.toString(), str2, str3, str4, str5);
    }

    public String buildUnionQuery(String[] strArr, String str, String str2) {
        StringBuilder sb = new StringBuilder(128);
        int length = strArr.length;
        String str3 = this.mDistinct ? " UNION " : " UNION ALL ";
        for (int i4 = 0; i4 < length; i4++) {
            if (i4 > 0) {
                sb.append(str3);
            }
            sb.append(strArr[i4]);
        }
        appendClause(sb, " ORDER BY ", str);
        appendClause(sb, " LIMIT ", str2);
        return sb.toString();
    }

    public String buildUnionSubQuery(String str, String[] strArr, Set<String> set, int i4, String str2, String str3, String str4, String str5) {
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i5 = 0; i5 < length; i5++) {
            String str6 = strArr[i5];
            if (str6.equals(str)) {
                strArr2[i5] = "'" + str2 + "' AS " + str;
            } else if (i5 <= i4 || set.contains(str6)) {
                strArr2[i5] = str6;
            } else {
                strArr2[i5] = "NULL AS ".concat(str6);
            }
        }
        return buildQuery(strArr2, str3, str4, str5, null, null);
    }

    public String getTables() {
        return this.mTables;
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return query(sQLiteDatabase, strArr, str, strArr2, str2, str3, str4, null, null);
    }

    public void setCursorFactory(SQLiteDatabase.CursorFactory cursorFactory) {
        this.mFactory = cursorFactory;
    }

    public void setDistinct(boolean z4) {
        this.mDistinct = z4;
    }

    public void setProjectionMap(Map<String, String> map) {
        this.mProjectionMap = map;
    }

    public void setStrict(boolean z4) {
        this.mStrict = z4;
    }

    public void setTables(String str) {
        this.mTables = str;
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return query(sQLiteDatabase, strArr, str, strArr2, str2, str3, str4, str5, null);
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5, CancellationSignal cancellationSignal) {
        if (this.mTables == null) {
            return null;
        }
        if (this.mStrict && str != null && str.length() > 0) {
            sQLiteDatabase.validateSql(buildQuery(strArr, g.n("(", str, ")"), str2, str3, str4, str5), cancellationSignal);
        }
        String strBuildQuery = buildQuery(strArr, str, str2, str3, str4, str5);
        if (Logger.isLoggable(TAG, 3)) {
            Logger.d(TAG, "Performing query: " + strBuildQuery);
        }
        return sQLiteDatabase.rawQueryWithFactory(this.mFactory, strBuildQuery, strArr2, SQLiteDatabase.findEditTable(this.mTables), cancellationSignal);
    }

    @Deprecated
    public String buildUnionSubQuery(String str, String[] strArr, Set<String> set, int i4, String str2, String str3, String[] strArr2, String str4, String str5) {
        return buildUnionSubQuery(str, strArr, set, i4, str2, str3, str4, str5);
    }

    @Deprecated
    public String buildQuery(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return buildQuery(strArr, str, str2, str3, str4, str5);
    }
}
