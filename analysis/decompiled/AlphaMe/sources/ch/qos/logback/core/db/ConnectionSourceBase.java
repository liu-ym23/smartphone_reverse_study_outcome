package ch.qos.logback.core.db;

import ch.qos.logback.core.db.dialect.DBUtil;
import ch.qos.logback.core.db.dialect.SQLDialectCode;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/* loaded from: classes.dex */
public abstract class ConnectionSourceBase extends ContextAwareBase implements ConnectionSource {
    private boolean started;
    private String user = null;
    private String password = null;
    private SQLDialectCode dialectCode = SQLDialectCode.UNKNOWN_DIALECT;
    private boolean supportsGetGeneratedKeys = false;
    private boolean supportsBatchUpdates = false;

    public void discoverConnectionProperties() throws SQLException {
        Connection connection = null;
        try {
            try {
                connection = getConnection();
            } catch (SQLException e4) {
                addWarn("Could not discover the dialect to use.", e4);
            }
            if (connection == null) {
                addWarn("Could not get a connection");
                return;
            }
            DatabaseMetaData metaData = connection.getMetaData();
            DBUtil dBUtil = new DBUtil();
            dBUtil.setContext(getContext());
            this.supportsGetGeneratedKeys = dBUtil.supportsGetGeneratedKeys(metaData);
            this.supportsBatchUpdates = dBUtil.supportsBatchUpdates(metaData);
            this.dialectCode = DBUtil.discoverSQLDialect(metaData);
            addInfo("Driver name=" + metaData.getDriverName());
            addInfo("Driver version=" + metaData.getDriverVersion());
            addInfo("supportsGetGeneratedKeys=" + this.supportsGetGeneratedKeys);
        } finally {
            DBHelper.closeConnection(null);
        }
    }

    public final String getPassword() {
        return this.password;
    }

    @Override // ch.qos.logback.core.db.ConnectionSource
    public final SQLDialectCode getSQLDialectCode() {
        return this.dialectCode;
    }

    public final String getUser() {
        return this.user;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.started;
    }

    public final void setPassword(String str) {
        this.password = str;
    }

    public final void setUser(String str) {
        this.user = str;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.started = true;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.started = false;
    }

    @Override // ch.qos.logback.core.db.ConnectionSource
    public final boolean supportsBatchUpdates() {
        return this.supportsBatchUpdates;
    }

    @Override // ch.qos.logback.core.db.ConnectionSource
    public final boolean supportsGetGeneratedKeys() {
        return this.supportsGetGeneratedKeys;
    }
}
