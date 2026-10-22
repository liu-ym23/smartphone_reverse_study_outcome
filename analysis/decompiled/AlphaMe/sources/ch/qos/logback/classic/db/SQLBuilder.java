package ch.qos.logback.classic.db;

import ch.qos.logback.classic.db.names.ColumnName;
import ch.qos.logback.classic.db.names.DBNameResolver;
import ch.qos.logback.classic.db.names.TableName;

/* loaded from: classes.dex */
public class SQLBuilder {
    public static String buildInsertExceptionSQL(DBNameResolver dBNameResolver) {
        return "INSERT INTO " + dBNameResolver.getTableName(TableName.LOGGING_EVENT_EXCEPTION) + " (" + dBNameResolver.getColumnName(ColumnName.EVENT_ID) + ", " + dBNameResolver.getColumnName(ColumnName.I) + ", " + dBNameResolver.getColumnName(ColumnName.TRACE_LINE) + ") VALUES (?, ?, ?)";
    }

    public static String buildInsertPropertiesSQL(DBNameResolver dBNameResolver) {
        return "INSERT INTO " + dBNameResolver.getTableName(TableName.LOGGING_EVENT_PROPERTY) + " (" + dBNameResolver.getColumnName(ColumnName.EVENT_ID) + ", " + dBNameResolver.getColumnName(ColumnName.MAPPED_KEY) + ", " + dBNameResolver.getColumnName(ColumnName.MAPPED_VALUE) + ") VALUES (?, ?, ?)";
    }

    public static String buildInsertSQL(DBNameResolver dBNameResolver) {
        return "INSERT INTO " + dBNameResolver.getTableName(TableName.LOGGING_EVENT) + " (" + dBNameResolver.getColumnName(ColumnName.TIMESTMP) + ", " + dBNameResolver.getColumnName(ColumnName.FORMATTED_MESSAGE) + ", " + dBNameResolver.getColumnName(ColumnName.LOGGER_NAME) + ", " + dBNameResolver.getColumnName(ColumnName.LEVEL_STRING) + ", " + dBNameResolver.getColumnName(ColumnName.THREAD_NAME) + ", " + dBNameResolver.getColumnName(ColumnName.REFERENCE_FLAG) + ", " + dBNameResolver.getColumnName(ColumnName.ARG0) + ", " + dBNameResolver.getColumnName(ColumnName.ARG1) + ", " + dBNameResolver.getColumnName(ColumnName.ARG2) + ", " + dBNameResolver.getColumnName(ColumnName.ARG3) + ", " + dBNameResolver.getColumnName(ColumnName.CALLER_FILENAME) + ", " + dBNameResolver.getColumnName(ColumnName.CALLER_CLASS) + ", " + dBNameResolver.getColumnName(ColumnName.CALLER_METHOD) + ", " + dBNameResolver.getColumnName(ColumnName.CALLER_LINE) + ") VALUES (?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }
}
