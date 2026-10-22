package ch.qos.logback.classic.spi;

import Z2.I;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.util.LogbackMDCAdapter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import n3.AbstractC0783d;
import n3.e;
import q3.a;

/* loaded from: classes.dex */
public class LoggingEvent implements ILoggingEvent {
    private static final Map<String, String> CACHED_NULL_MAP = new HashMap();
    private transient Object[] argumentArray;
    private StackTraceElement[] callerDataArray;
    transient String formattedMessage;
    transient String fqnOfLoggerClass;
    private transient Level level;
    private LoggerContext loggerContext;
    private LoggerContextVO loggerContextVO;
    private String loggerName;
    private e marker;
    private Map<String, String> mdcPropertyMap;
    private String message;
    private String threadName;
    private ThrowableProxy throwableProxy;
    private long timeStamp;

    public LoggingEvent() {
    }

    private Throwable extractThrowableAnRearrangeArguments(Object[] objArr) {
        Throwable thExtractThrowable = EventArgUtil.extractThrowable(objArr);
        if (EventArgUtil.successfulExtraction(thExtractThrowable)) {
            this.argumentArray = EventArgUtil.trimmedCopy(objArr);
        }
        return thExtractThrowable;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        throw new UnsupportedOperationException(getClass() + " does not support serialization. Use LoggerEventVO instance instead. See also LoggerEventVO.build method.");
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public Object[] getArgumentArray() {
        return this.argumentArray;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public StackTraceElement[] getCallerData() {
        if (this.callerDataArray == null) {
            this.callerDataArray = CallerData.extract(new Throwable(), this.fqnOfLoggerClass, this.loggerContext.getMaxCallerDataDepth(), this.loggerContext.getFrameworkPackages());
        }
        return this.callerDataArray;
    }

    public long getContextBirthTime() {
        return this.loggerContextVO.getBirthTime();
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public String getFormattedMessage() {
        String str = this.formattedMessage;
        if (str != null) {
            return str;
        }
        Object[] objArr = this.argumentArray;
        if (objArr != null) {
            this.formattedMessage = I.c(this.message, objArr).f13806a;
        } else {
            this.formattedMessage = this.message;
        }
        return this.formattedMessage;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public Level getLevel() {
        return this.level;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public LoggerContextVO getLoggerContextVO() {
        return this.loggerContextVO;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public String getLoggerName() {
        return this.loggerName;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public Map<String, String> getMDCPropertyMap() {
        if (this.mdcPropertyMap == null) {
            a aVar = AbstractC0783d.f13669a;
            if (aVar instanceof LogbackMDCAdapter) {
                this.mdcPropertyMap = ((LogbackMDCAdapter) aVar).getPropertyMap();
            } else {
                this.mdcPropertyMap = aVar.getCopyOfContextMap();
            }
        }
        if (this.mdcPropertyMap == null) {
            this.mdcPropertyMap = CACHED_NULL_MAP;
        }
        return this.mdcPropertyMap;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public e getMarker() {
        return this.marker;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public Map<String, String> getMdc() {
        return getMDCPropertyMap();
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public String getMessage() {
        return this.message;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public String getThreadName() {
        if (this.threadName == null) {
            this.threadName = Thread.currentThread().getName();
        }
        return this.threadName;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public IThrowableProxy getThrowableProxy() {
        return this.throwableProxy;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public long getTimeStamp() {
        return this.timeStamp;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public boolean hasCallerData() {
        return this.callerDataArray != null;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent, ch.qos.logback.core.spi.DeferredProcessingAware
    public void prepareForDeferredProcessing() {
        getFormattedMessage();
        getThreadName();
        getMDCPropertyMap();
    }

    public void setArgumentArray(Object[] objArr) {
        if (this.argumentArray != null) {
            throw new IllegalStateException("argArray has been already set");
        }
        this.argumentArray = objArr;
    }

    public void setCallerData(StackTraceElement[] stackTraceElementArr) {
        this.callerDataArray = stackTraceElementArr;
    }

    public void setLevel(Level level) {
        if (this.level != null) {
            throw new IllegalStateException("The level has been already set for this event.");
        }
        this.level = level;
    }

    public void setLoggerContextRemoteView(LoggerContextVO loggerContextVO) {
        this.loggerContextVO = loggerContextVO;
    }

    public void setLoggerName(String str) {
        this.loggerName = str;
    }

    public void setMDCPropertyMap(Map<String, String> map) {
        if (this.mdcPropertyMap != null) {
            throw new IllegalStateException("The MDCPropertyMap has been already set for this event.");
        }
        this.mdcPropertyMap = map;
    }

    public void setMarker(e eVar) {
        if (this.marker != null) {
            throw new IllegalStateException("The marker has been already set for this event.");
        }
        this.marker = eVar;
    }

    public void setMessage(String str) {
        if (this.message != null) {
            throw new IllegalStateException("The message for this event has been set already.");
        }
        this.message = str;
    }

    public void setThreadName(String str) throws IllegalStateException {
        if (this.threadName != null) {
            throw new IllegalStateException("threadName has been already set");
        }
        this.threadName = str;
    }

    public void setThrowableProxy(ThrowableProxy throwableProxy) {
        if (this.throwableProxy != null) {
            throw new IllegalStateException("ThrowableProxy has been already set.");
        }
        this.throwableProxy = throwableProxy;
    }

    public void setTimeStamp(long j4) {
        this.timeStamp = j4;
    }

    public String toString() {
        return "[" + this.level + "] " + getFormattedMessage();
    }

    public LoggingEvent(String str, Logger logger, Level level, String str2, Throwable th, Object[] objArr) {
        this.fqnOfLoggerClass = str;
        this.loggerName = logger.getName();
        LoggerContext loggerContext = logger.getLoggerContext();
        this.loggerContext = loggerContext;
        this.loggerContextVO = loggerContext.getLoggerContextRemoteView();
        this.level = level;
        this.message = str2;
        this.argumentArray = objArr;
        th = th == null ? extractThrowableAnRearrangeArguments(objArr) : th;
        if (th != null) {
            this.throwableProxy = new ThrowableProxy(th);
            if (logger.getLoggerContext().isPackagingDataEnabled()) {
                this.throwableProxy.calculatePackagingData();
            }
        }
        this.timeStamp = System.currentTimeMillis();
    }
}
