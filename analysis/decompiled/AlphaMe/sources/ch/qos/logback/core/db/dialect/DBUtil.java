package ch.qos.logback.core.db.dialect;

import ch.qos.logback.core.spi.ContextAwareBase;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/* loaded from: classes.dex */
public class DBUtil extends ContextAwareBase {
    private static final String H2_PART = "h2";
    private static final String HSQL_PART = "hsql";
    private static final String MSSQL_PART = "microsoft";
    private static final String MYSQL_PART = "mysql";
    private static final String ORACLE_PART = "oracle";
    private static final String POSTGRES_PART = "postgresql";
    private static final String SQLITE_PART = "sqlite";
    private static final String SYBASE_SQLANY_PART = "sql anywhere";

    /* renamed from: ch.qos.logback.core.db.dialect.DBUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ch$qos$logback$core$db$dialect$SQLDialectCode;

        static {
            int[] iArr = new int[SQLDialectCode.values().length];
            $SwitchMap$ch$qos$logback$core$db$dialect$SQLDialectCode = iArr;
            try {
                iArr[SQLDialectCode.POSTGRES_DIALECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$db$dialect$SQLDialectCode[SQLDialectCode.MYSQL_DIALECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$db$dialect$SQLDialectCode[SQLDialectCode.ORACLE_DIALECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$db$dialect$SQLDialectCode[SQLDialectCode.MSSQL_DIALECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$db$dialect$SQLDialectCode[SQLDialectCode.HSQL_DIALECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$db$dialect$SQLDialectCode[SQLDialectCode.H2_DIALECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$db$dialect$SQLDialectCode[SQLDialectCode.SYBASE_SQLANYWHERE_DIALECT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$db$dialect$SQLDialectCode[SQLDialectCode.SQLITE_DIALECT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static SQLDialectCode discoverSQLDialect(DatabaseMetaData databaseMetaData) {
        String lowerCase;
        SQLDialectCode sQLDialectCode = SQLDialectCode.UNKNOWN_DIALECT;
        try {
            lowerCase = databaseMetaData.getDatabaseProductName().toLowerCase();
        } catch (SQLException unused) {
        }
        if (lowerCase.indexOf(POSTGRES_PART) != -1) {
            return SQLDialectCode.POSTGRES_DIALECT;
        }
        if (lowerCase.indexOf(MYSQL_PART) != -1) {
            return SQLDialectCode.MYSQL_DIALECT;
        }
        if (lowerCase.indexOf(ORACLE_PART) != -1) {
            return SQLDialectCode.ORACLE_DIALECT;
        }
        if (lowerCase.indexOf(MSSQL_PART) != -1) {
            return SQLDialectCode.MSSQL_DIALECT;
        }
        if (lowerCase.indexOf(HSQL_PART) != -1) {
            return SQLDialectCode.HSQL_DIALECT;
        }
        if (lowerCase.indexOf(H2_PART) != -1) {
            return SQLDialectCode.H2_DIALECT;
        }
        if (lowerCase.indexOf(SYBASE_SQLANY_PART) != -1) {
            return SQLDialectCode.SYBASE_SQLANYWHERE_DIALECT;
        }
        if (lowerCase.indexOf(SQLITE_PART) != -1) {
            return SQLDialectCode.SQLITE_DIALECT;
        }
        return sQLDialectCode;
    }

    public static SQLDialect getDialectFromCode(SQLDialectCode sQLDialectCode) {
        switch (AnonymousClass1.$SwitchMap$ch$qos$logback$core$db$dialect$SQLDialectCode[sQLDialectCode.ordinal()]) {
            case 1:
                return new PostgreSQLDialect();
            case 2:
                return new MySQLDialect();
            case 3:
                return new OracleDialect();
            case 4:
                return new MsSQLDialect();
            case 5:
                return new HSQLDBDialect();
            case 6:
                return new H2Dialect();
            case 7:
                return new SybaseSqlAnywhereDialect();
            case 8:
                return new SQLiteDialect();
            default:
                return null;
        }
    }

    public boolean supportsBatchUpdates(DatabaseMetaData databaseMetaData) {
        try {
            return databaseMetaData.supportsBatchUpdates();
        } catch (Throwable unused) {
            this.addInfo("Missing DatabaseMetaData.supportsBatchUpdates method.");
            return false;
        }
    }

    public boolean supportsGetGeneratedKeys(DatabaseMetaData databaseMetaData) {
        try {
            return ((Boolean) DatabaseMetaData.class.getMethod("supportsGetGeneratedKeys", null).invoke(databaseMetaData, null)).booleanValue();
        } catch (Throwable unused) {
            this.addInfo("Could not call supportsGetGeneratedKeys method. This may be recoverable");
            return false;
        }
    }
}
