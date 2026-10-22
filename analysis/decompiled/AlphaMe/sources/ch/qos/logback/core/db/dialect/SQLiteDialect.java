package ch.qos.logback.core.db.dialect;

/* loaded from: classes.dex */
public class SQLiteDialect implements SQLDialect {
    public static final String SELECT_CURRVAL = "SELECT last_insert_rowid();";

    @Override // ch.qos.logback.core.db.dialect.SQLDialect
    public String getSelectInsertId() {
        return SELECT_CURRVAL;
    }
}
