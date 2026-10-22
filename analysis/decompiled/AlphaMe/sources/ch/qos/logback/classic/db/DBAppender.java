package ch.qos.logback.classic.db;

import B0.g;
import ch.qos.logback.classic.db.names.DBNameResolver;
import ch.qos.logback.classic.db.names.DefaultDBNameResolver;
import ch.qos.logback.classic.spi.CallerData;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.classic.spi.ThrowableProxyUtil;
import ch.qos.logback.core.db.DBAppenderBase;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class DBAppender extends DBAppenderBase<ILoggingEvent> {
    static final int ARG0_INDEX = 7;
    static final int ARG1_INDEX = 8;
    static final int ARG2_INDEX = 9;
    static final int ARG3_INDEX = 10;
    static final int CALLER_CLASS_INDEX = 12;
    static final int CALLER_FILENAME_INDEX = 11;
    static final int CALLER_LINE_INDEX = 14;
    static final int CALLER_METHOD_INDEX = 13;
    static final StackTraceElement EMPTY_CALLER_DATA = CallerData.naInstance();
    static final int EVENT_ID_INDEX = 15;
    static final int FORMATTED_MESSAGE_INDEX = 2;
    protected static final Method GET_GENERATED_KEYS_METHOD;
    static final int LEVEL_STRING_INDEX = 4;
    static final int LOGGER_NAME_INDEX = 3;
    static final int REFERENCE_FLAG_INDEX = 6;
    static final int THREAD_NAME_INDEX = 5;
    static final int TIMESTMP_INDEX = 1;
    private DBNameResolver dbNameResolver;
    protected String insertExceptionSQL;
    protected String insertPropertiesSQL;
    protected String insertSQL;

    static {
        Method method = null;
        try {
            method = PreparedStatement.class.getMethod("getGeneratedKeys", null);
        } catch (Exception unused) {
        }
        GET_GENERATED_KEYS_METHOD = method;
    }

    private StackTraceElement extractFirstCaller(StackTraceElement[] stackTraceElementArr) {
        return hasAtLeastOneNonNullElement(stackTraceElementArr) ? stackTraceElementArr[0] : EMPTY_CALLER_DATA;
    }

    private boolean hasAtLeastOneNonNullElement(StackTraceElement[] stackTraceElementArr) {
        return (stackTraceElementArr == null || stackTraceElementArr.length <= 0 || stackTraceElementArr[0] == null) ? false : true;
    }

    public String asStringTruncatedTo254(Object obj) {
        String string = obj != null ? obj.toString() : null;
        if (string == null) {
            return null;
        }
        return string.length() <= 254 ? string : string.substring(0, 254);
    }

    public void bindCallerDataWithPreparedStatement(PreparedStatement preparedStatement, StackTraceElement[] stackTraceElementArr) throws SQLException {
        StackTraceElement stackTraceElementExtractFirstCaller = extractFirstCaller(stackTraceElementArr);
        preparedStatement.setString(11, stackTraceElementExtractFirstCaller.getFileName());
        preparedStatement.setString(12, stackTraceElementExtractFirstCaller.getClassName());
        preparedStatement.setString(13, stackTraceElementExtractFirstCaller.getMethodName());
        preparedStatement.setString(14, Integer.toString(stackTraceElementExtractFirstCaller.getLineNumber()));
    }

    public void bindLoggingEventArgumentsWithPreparedStatement(PreparedStatement preparedStatement, Object[] objArr) throws SQLException {
        int length = objArr != null ? objArr.length : 0;
        for (int i4 = 0; i4 < length && i4 < 4; i4++) {
            preparedStatement.setString(i4 + 7, asStringTruncatedTo254(objArr[i4]));
        }
        if (length < 4) {
            while (length < 4) {
                preparedStatement.setString(length + 7, null);
                length++;
            }
        }
    }

    public void bindLoggingEventWithInsertStatement(PreparedStatement preparedStatement, ILoggingEvent iLoggingEvent) throws SQLException {
        preparedStatement.setLong(1, iLoggingEvent.getTimeStamp());
        preparedStatement.setString(2, iLoggingEvent.getFormattedMessage());
        preparedStatement.setString(3, iLoggingEvent.getLoggerName());
        preparedStatement.setString(4, iLoggingEvent.getLevel().toString());
        preparedStatement.setString(5, iLoggingEvent.getThreadName());
        preparedStatement.setShort(6, DBHelper.computeReferenceMask(iLoggingEvent));
    }

    public short buildExceptionStatement(IThrowableProxy iThrowableProxy, short s4, PreparedStatement preparedStatement, long j4) throws SQLException {
        short s5;
        StringBuilder sb = new StringBuilder();
        ThrowableProxyUtil.subjoinFirstLine(sb, iThrowableProxy);
        String string = sb.toString();
        short s6 = (short) (s4 + 1);
        updateExceptionStatement(preparedStatement, string, s4, j4);
        int commonFrames = iThrowableProxy.getCommonFrames();
        StackTraceElementProxy[] stackTraceElementProxyArray = iThrowableProxy.getStackTraceElementProxyArray();
        int i4 = 0;
        while (true) {
            s5 = s6;
            if (i4 >= stackTraceElementProxyArray.length - commonFrames) {
                break;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append('\t');
            ThrowableProxyUtil.subjoinSTEP(sb2, stackTraceElementProxyArray[i4]);
            String string2 = sb2.toString();
            s6 = (short) (s5 + 1);
            updateExceptionStatement(preparedStatement, string2, s5, j4);
            i4++;
        }
        if (commonFrames <= 0) {
            return s5;
        }
        short s7 = (short) (s5 + 1);
        updateExceptionStatement(preparedStatement, g.j("\t... ", commonFrames, " common frames omitted"), s5, j4);
        return s7;
    }

    @Override // ch.qos.logback.core.db.DBAppenderBase
    public Method getGeneratedKeysMethod() {
        return GET_GENERATED_KEYS_METHOD;
    }

    @Override // ch.qos.logback.core.db.DBAppenderBase
    public String getInsertSQL() {
        return this.insertSQL;
    }

    public void insertProperties(Map<String, String> map, Connection connection, long j4) throws SQLException {
        Set<String> setKeySet = map.keySet();
        if (setKeySet.size() > 0) {
            PreparedStatement preparedStatementPrepareStatement = null;
            try {
                preparedStatementPrepareStatement = connection.prepareStatement(this.insertPropertiesSQL);
                for (String str : setKeySet) {
                    String str2 = map.get(str);
                    preparedStatementPrepareStatement.setLong(1, j4);
                    preparedStatementPrepareStatement.setString(2, str);
                    preparedStatementPrepareStatement.setString(3, str2);
                    if (this.cnxSupportsBatchUpdates) {
                        preparedStatementPrepareStatement.addBatch();
                    } else {
                        preparedStatementPrepareStatement.execute();
                    }
                }
                if (this.cnxSupportsBatchUpdates) {
                    preparedStatementPrepareStatement.executeBatch();
                }
                ch.qos.logback.core.db.DBHelper.closeStatement(preparedStatementPrepareStatement);
            } catch (Throwable th) {
                ch.qos.logback.core.db.DBHelper.closeStatement(preparedStatementPrepareStatement);
                throw th;
            }
        }
    }

    public void insertThrowable(IThrowableProxy iThrowableProxy, Connection connection, long j4) throws SQLException {
        PreparedStatement preparedStatementPrepareStatement = null;
        try {
            preparedStatementPrepareStatement = connection.prepareStatement(this.insertExceptionSQL);
            short sBuildExceptionStatement = 0;
            while (iThrowableProxy != null) {
                sBuildExceptionStatement = buildExceptionStatement(iThrowableProxy, sBuildExceptionStatement, preparedStatementPrepareStatement, j4);
                iThrowableProxy = iThrowableProxy.getCause();
            }
            if (this.cnxSupportsBatchUpdates) {
                preparedStatementPrepareStatement.executeBatch();
            }
            ch.qos.logback.core.db.DBHelper.closeStatement(preparedStatementPrepareStatement);
        } catch (Throwable th) {
            ch.qos.logback.core.db.DBHelper.closeStatement(preparedStatementPrepareStatement);
            throw th;
        }
    }

    public Map<String, String> mergePropertyMaps(ILoggingEvent iLoggingEvent) {
        HashMap map = new HashMap();
        Map<String, String> propertyMap = iLoggingEvent.getLoggerContextVO().getPropertyMap();
        Map<String, String> mDCPropertyMap = iLoggingEvent.getMDCPropertyMap();
        if (propertyMap != null) {
            map.putAll(propertyMap);
        }
        if (mDCPropertyMap != null) {
            map.putAll(mDCPropertyMap);
        }
        return map;
    }

    public void setDbNameResolver(DBNameResolver dBNameResolver) {
        this.dbNameResolver = dBNameResolver;
    }

    @Override // ch.qos.logback.core.db.DBAppenderBase, ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.dbNameResolver == null) {
            this.dbNameResolver = new DefaultDBNameResolver();
        }
        this.insertExceptionSQL = SQLBuilder.buildInsertExceptionSQL(this.dbNameResolver);
        this.insertPropertiesSQL = SQLBuilder.buildInsertPropertiesSQL(this.dbNameResolver);
        this.insertSQL = SQLBuilder.buildInsertSQL(this.dbNameResolver);
        super.start();
    }

    public void updateExceptionStatement(PreparedStatement preparedStatement, String str, short s4, long j4) throws SQLException {
        preparedStatement.setLong(1, j4);
        preparedStatement.setShort(2, s4);
        preparedStatement.setString(3, str);
        if (this.cnxSupportsBatchUpdates) {
            preparedStatement.addBatch();
        } else {
            preparedStatement.execute();
        }
    }

    @Override // ch.qos.logback.core.db.DBAppenderBase
    public void secondarySubAppend(ILoggingEvent iLoggingEvent, Connection connection, long j4) throws Throwable {
        insertProperties(mergePropertyMaps(iLoggingEvent), connection, j4);
        if (iLoggingEvent.getThrowableProxy() != null) {
            insertThrowable(iLoggingEvent.getThrowableProxy(), connection, j4);
        }
    }

    @Override // ch.qos.logback.core.db.DBAppenderBase
    public void subAppend(ILoggingEvent iLoggingEvent, Connection connection, PreparedStatement preparedStatement) throws Throwable {
        bindLoggingEventWithInsertStatement(preparedStatement, iLoggingEvent);
        bindLoggingEventArgumentsWithPreparedStatement(preparedStatement, iLoggingEvent.getArgumentArray());
        bindCallerDataWithPreparedStatement(preparedStatement, iLoggingEvent.getCallerData());
        if (preparedStatement.executeUpdate() != 1) {
            addWarn("Failed to insert loggingEvent");
        }
    }
}
