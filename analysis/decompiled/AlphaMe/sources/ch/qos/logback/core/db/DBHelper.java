package ch.qos.logback.core.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/* loaded from: classes.dex */
public class DBHelper {
    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException unused) {
            }
        }
    }

    public static void closeStatement(Statement statement) throws SQLException {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException unused) {
            }
        }
    }
}
