package ch.qos.logback.core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* loaded from: classes.dex */
public class DriverManagerConnectionSource extends ConnectionSourceBase {
    private String driverClass = null;
    private String url = null;

    @Override // ch.qos.logback.core.db.ConnectionSource
    public Connection getConnection() throws SQLException {
        return getUser() == null ? DriverManager.getConnection(this.url) : DriverManager.getConnection(this.url, getUser(), getPassword());
    }

    public String getDriverClass() {
        return this.driverClass;
    }

    public String getUrl() {
        return this.url;
    }

    public void setDriverClass(String str) {
        this.driverClass = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    @Override // ch.qos.logback.core.db.ConnectionSourceBase, ch.qos.logback.core.spi.LifeCycle
    public void start() throws SQLException, ClassNotFoundException {
        try {
            String str = this.driverClass;
            if (str != null) {
                Class.forName(str);
                discoverConnectionProperties();
            } else {
                addError("WARNING: No JDBC driver specified for logback DriverManagerConnectionSource.");
            }
        } catch (ClassNotFoundException e4) {
            addError("Could not load JDBC driver class: " + this.driverClass, e4);
        }
    }
}
