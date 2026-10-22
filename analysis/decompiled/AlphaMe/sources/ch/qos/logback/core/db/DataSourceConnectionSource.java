package ch.qos.logback.core.db;

import ch.qos.logback.core.db.dialect.SQLDialectCode;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/* loaded from: classes.dex */
public class DataSourceConnectionSource extends ConnectionSourceBase {
    private DataSource dataSource;

    @Override // ch.qos.logback.core.db.ConnectionSource
    public Connection getConnection() throws SQLException {
        if (this.dataSource != null) {
            return getUser() == null ? this.dataSource.getConnection() : this.dataSource.getConnection(getUser(), getPassword());
        }
        addError("WARNING: No data source specified");
        return null;
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override // ch.qos.logback.core.db.ConnectionSourceBase, ch.qos.logback.core.spi.LifeCycle
    public void start() throws SQLException {
        if (this.dataSource == null) {
            addWarn("WARNING: No data source specified");
        } else {
            discoverConnectionProperties();
            if (!supportsGetGeneratedKeys() && getSQLDialectCode() == SQLDialectCode.UNKNOWN_DIALECT) {
                addWarn("Connection does not support GetGeneratedKey method and could not discover the dialect.");
            }
        }
        super.start();
    }
}
