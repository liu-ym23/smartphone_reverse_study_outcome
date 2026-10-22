package ch.qos.logback.core.db.dialect;

/* loaded from: classes.dex */
public class H2Dialect implements SQLDialect {
    public static final String SELECT_CURRVAL = "CALL IDENTITY()";

    @Override // ch.qos.logback.core.db.dialect.SQLDialect
    public String getSelectInsertId() {
        return "CALL IDENTITY()";
    }
}
