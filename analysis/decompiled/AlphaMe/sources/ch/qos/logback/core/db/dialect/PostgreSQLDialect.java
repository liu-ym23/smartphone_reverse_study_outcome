package ch.qos.logback.core.db.dialect;

/* loaded from: classes.dex */
public class PostgreSQLDialect implements SQLDialect {
    public static final String SELECT_CURRVAL = "SELECT currval('logging_event_id_seq')";

    @Override // ch.qos.logback.core.db.dialect.SQLDialect
    public String getSelectInsertId() {
        return SELECT_CURRVAL;
    }
}
