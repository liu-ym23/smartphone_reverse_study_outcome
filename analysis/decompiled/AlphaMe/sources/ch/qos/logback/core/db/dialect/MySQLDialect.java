package ch.qos.logback.core.db.dialect;

/* loaded from: classes.dex */
public class MySQLDialect implements SQLDialect {
    public static final String SELECT_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";

    @Override // ch.qos.logback.core.db.dialect.SQLDialect
    public String getSelectInsertId() {
        return SELECT_LAST_INSERT_ID;
    }
}
