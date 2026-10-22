package ch.qos.logback.core.db;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/* loaded from: classes.dex */
public class JNDIConnectionSource extends ConnectionSourceBase {
    private String jndiLocation = null;
    private DataSource dataSource = null;

    private DataSource lookupDataSource() throws SQLException, NamingException {
        addInfo("Looking up [" + this.jndiLocation + "] in JNDI");
        DataSource dataSource = (DataSource) new InitialContext().lookup(this.jndiLocation);
        if (dataSource != null) {
            return dataSource;
        }
        throw new SQLException("Failed to obtain data source from JNDI location " + this.jndiLocation);
    }

    @Override // ch.qos.logback.core.db.ConnectionSource
    public Connection getConnection() throws SQLException {
        try {
            if (this.dataSource == null) {
                this.dataSource = lookupDataSource();
            }
            if (getUser() != null) {
                addWarn("Ignoring property [user] with value [" + getUser() + "] for obtaining a connection from a DataSource.");
            }
            return this.dataSource.getConnection();
        } catch (NamingException e4) {
            this.addError("Error while getting data source", e4);
            throw new SQLException("NamingException while looking up DataSource: " + e4.getMessage());
        } catch (ClassCastException e5) {
            this.addError("ClassCastException while looking up DataSource.", e5);
            throw new SQLException("ClassCastException while looking up DataSource: " + e5.getMessage());
        }
    }

    public String getJndiLocation() {
        return this.jndiLocation;
    }

    public void setJndiLocation(String str) {
        this.jndiLocation = str;
    }

    @Override // ch.qos.logback.core.db.ConnectionSourceBase, ch.qos.logback.core.spi.LifeCycle
    public void start() throws SQLException {
        if (this.jndiLocation == null) {
            addError("No JNDI location specified for JNDIConnectionSource.");
        }
        discoverConnectionProperties();
    }
}
