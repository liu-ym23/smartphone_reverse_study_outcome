package ch.qos.logback.core.db;

import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.db.dialect.DBUtil;
import ch.qos.logback.core.db.dialect.SQLDialect;
import ch.qos.logback.core.db.dialect.SQLDialectCode;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* loaded from: classes.dex */
public abstract class DBAppenderBase<E> extends UnsynchronizedAppenderBase<E> {
    protected ConnectionSource connectionSource;
    protected SQLDialect sqlDialect;
    protected boolean cnxSupportsGetGeneratedKeys = false;
    protected boolean cnxSupportsBatchUpdates = false;

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase
    public void append(E e4) throws SQLException {
        PreparedStatement preparedStatement;
        long jSelectEventId;
        Connection connection = null;
        PreparedStatement preparedStatementPrepareStatement = null;
        try {
            Connection connection2 = this.connectionSource.getConnection();
            try {
                connection2.setAutoCommit(false);
                if (this.cnxSupportsGetGeneratedKeys) {
                    preparedStatementPrepareStatement = connection2.prepareStatement(getInsertSQL(), new String[]{this.connectionSource.getSQLDialectCode() == SQLDialectCode.POSTGRES_DIALECT ? "EVENT_ID".toLowerCase() : "EVENT_ID"});
                } else {
                    preparedStatementPrepareStatement = connection2.prepareStatement(getInsertSQL());
                }
                synchronized (this) {
                    subAppend(e4, connection2, preparedStatementPrepareStatement);
                    jSelectEventId = selectEventId(preparedStatementPrepareStatement, connection2);
                }
                secondarySubAppend(e4, connection2, jSelectEventId);
                connection2.commit();
                DBHelper.closeStatement(preparedStatementPrepareStatement);
                DBHelper.closeConnection(connection2);
            } catch (Throwable th) {
                th = th;
                preparedStatement = preparedStatementPrepareStatement;
                connection = connection2;
                try {
                    addError("problem appending event", th);
                } finally {
                    DBHelper.closeStatement(preparedStatement);
                    DBHelper.closeConnection(connection);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            preparedStatement = null;
        }
    }

    public ConnectionSource getConnectionSource() {
        return this.connectionSource;
    }

    public abstract Method getGeneratedKeysMethod();

    public abstract String getInsertSQL();

    public abstract void secondarySubAppend(E e4, Connection connection, long j4) throws Throwable;

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long selectEventId(java.sql.PreparedStatement r5, java.sql.Connection r6) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            boolean r1 = r4.cnxSupportsGetGeneratedKeys     // Catch: java.lang.Throwable -> L13
            r2 = 1
            if (r1 == 0) goto L2c
            java.lang.reflect.Method r1 = r4.getGeneratedKeysMethod()     // Catch: java.lang.Throwable -> L13 java.lang.IllegalAccessException -> L16 java.lang.reflect.InvocationTargetException -> L18
            java.lang.Object r5 = r1.invoke(r5, r0)     // Catch: java.lang.Throwable -> L13 java.lang.IllegalAccessException -> L16 java.lang.reflect.InvocationTargetException -> L18
            java.sql.ResultSet r5 = (java.sql.ResultSet) r5     // Catch: java.lang.Throwable -> L13 java.lang.IllegalAccessException -> L16 java.lang.reflect.InvocationTargetException -> L18
            r1 = r5
            r5 = r2
            goto L2e
        L13:
            r4 = move-exception
            r5 = r0
            goto L5d
        L16:
            r5 = move-exception
            goto L1a
        L18:
            r4 = move-exception
            goto L20
        L1a:
            java.lang.String r1 = "IllegalAccessException invoking PreparedStatement.getGeneratedKeys"
            r4.addWarn(r1, r5)     // Catch: java.lang.Throwable -> L13
            goto L2c
        L20:
            java.lang.Throwable r5 = r4.getTargetException()     // Catch: java.lang.Throwable -> L13
            boolean r6 = r5 instanceof java.sql.SQLException     // Catch: java.lang.Throwable -> L13
            if (r6 == 0) goto L2b
            java.sql.SQLException r5 = (java.sql.SQLException) r5     // Catch: java.lang.Throwable -> L13
            throw r5     // Catch: java.lang.Throwable -> L13
        L2b:
            throw r4     // Catch: java.lang.Throwable -> L13
        L2c:
            r5 = 0
            r1 = r0
        L2e:
            if (r5 != 0) goto L49
            java.sql.Statement r0 = r6.createStatement()     // Catch: java.lang.Throwable -> L45
            r0.setMaxRows(r2)     // Catch: java.lang.Throwable -> L45
            ch.qos.logback.core.db.dialect.SQLDialect r4 = r4.sqlDialect     // Catch: java.lang.Throwable -> L45
            java.lang.String r4 = r4.getSelectInsertId()     // Catch: java.lang.Throwable -> L45
            java.sql.ResultSet r4 = r0.executeQuery(r4)     // Catch: java.lang.Throwable -> L45
            r3 = r0
            r0 = r4
            r4 = r3
            goto L4b
        L45:
            r4 = move-exception
            r5 = r0
            r0 = r1
            goto L5d
        L49:
            r4 = r0
            r0 = r1
        L4b:
            r0.next()     // Catch: java.lang.Throwable -> L59
            long r5 = r0.getLong(r2)     // Catch: java.lang.Throwable -> L59
            r0.close()     // Catch: java.sql.SQLException -> L55
        L55:
            ch.qos.logback.core.db.DBHelper.closeStatement(r4)
            return r5
        L59:
            r5 = move-exception
            r3 = r5
            r5 = r4
            r4 = r3
        L5d:
            if (r0 == 0) goto L62
            r0.close()     // Catch: java.sql.SQLException -> L62
        L62:
            ch.qos.logback.core.db.DBHelper.closeStatement(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.core.db.DBAppenderBase.selectEventId(java.sql.PreparedStatement, java.sql.Connection):long");
    }

    public void setConnectionSource(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        ConnectionSource connectionSource = this.connectionSource;
        if (connectionSource == null) {
            throw new IllegalStateException("DBAppender cannot function without a connection source");
        }
        this.sqlDialect = DBUtil.getDialectFromCode(connectionSource.getSQLDialectCode());
        if (getGeneratedKeysMethod() != null) {
            this.cnxSupportsGetGeneratedKeys = this.connectionSource.supportsGetGeneratedKeys();
        } else {
            this.cnxSupportsGetGeneratedKeys = false;
        }
        this.cnxSupportsBatchUpdates = this.connectionSource.supportsBatchUpdates();
        if (!this.cnxSupportsGetGeneratedKeys && this.sqlDialect == null) {
            throw new IllegalStateException("DBAppender cannot function if the JDBC driver does not support getGeneratedKeys method *and* without a specific SQL dialect");
        }
        super.start();
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        super.stop();
    }

    public abstract void subAppend(E e4, Connection connection, PreparedStatement preparedStatement) throws Throwable;
}
