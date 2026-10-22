package ch.qos.logback.classic;

import B0.g;
import androidx.room.AbstractC0351g;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.classic.util.LoggerNameUtil;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.spi.AppenderAttachable;
import ch.qos.logback.core.spi.AppenderAttachableImpl;
import ch.qos.logback.core.spi.FilterReply;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import n3.AbstractC0782c;
import n3.InterfaceC0781b;
import n3.e;

/* loaded from: classes.dex */
public final class Logger implements InterfaceC0781b, AppenderAttachable<ILoggingEvent>, Serializable {
    private static final int DEFAULT_CHILD_ARRAY_SIZE = 5;
    public static final String FQCN = "ch.qos.logback.classic.Logger";
    private static final long serialVersionUID = 5454405123156820674L;
    private transient AppenderAttachableImpl<ILoggingEvent> aai;
    private transient boolean additive = true;
    private transient List<Logger> childrenList;
    private transient int effectiveLevelInt;
    private transient Level level;
    final transient LoggerContext loggerContext;
    private String name;
    private transient Logger parent;

    public Logger(String str, Logger logger, LoggerContext loggerContext) {
        this.name = str;
        this.parent = logger;
        this.loggerContext = loggerContext;
    }

    private int appendLoopOnAppenders(ILoggingEvent iLoggingEvent) {
        AppenderAttachableImpl<ILoggingEvent> appenderAttachableImpl = this.aai;
        if (appenderAttachableImpl != null) {
            return appenderAttachableImpl.appendLoopOnAppenders(iLoggingEvent);
        }
        return 0;
    }

    private void buildLoggingEventAndAppend(String str, e eVar, Level level, String str2, Object[] objArr, Throwable th) {
        LoggingEvent loggingEvent = new LoggingEvent(str, this, level, str2, th, objArr);
        loggingEvent.setMarker(eVar);
        callAppenders(loggingEvent);
    }

    private FilterReply callTurboFilters(e eVar, Level level) {
        return this.loggerContext.getTurboFilterChainDecision_0_3OrMore(eVar, this, level, null, null, null);
    }

    private void filterAndLog_0_Or3Plus(String str, e eVar, Level level, String str2, Object[] objArr, Throwable th) {
        FilterReply turboFilterChainDecision_0_3OrMore = this.loggerContext.getTurboFilterChainDecision_0_3OrMore(eVar, this, level, str2, objArr, th);
        if (turboFilterChainDecision_0_3OrMore == FilterReply.NEUTRAL) {
            if (this.effectiveLevelInt > level.levelInt) {
                return;
            }
        } else if (turboFilterChainDecision_0_3OrMore == FilterReply.DENY) {
            return;
        }
        buildLoggingEventAndAppend(str, eVar, level, str2, objArr, th);
    }

    private void filterAndLog_1(String str, e eVar, Level level, String str2, Object obj, Throwable th) {
        FilterReply turboFilterChainDecision_1 = this.loggerContext.getTurboFilterChainDecision_1(eVar, this, level, str2, obj, th);
        if (turboFilterChainDecision_1 == FilterReply.NEUTRAL) {
            if (this.effectiveLevelInt > level.levelInt) {
                return;
            }
        } else if (turboFilterChainDecision_1 == FilterReply.DENY) {
            return;
        }
        buildLoggingEventAndAppend(str, eVar, level, str2, new Object[]{obj}, th);
    }

    private void filterAndLog_2(String str, e eVar, Level level, String str2, Object obj, Object obj2, Throwable th) {
        FilterReply turboFilterChainDecision_2 = this.loggerContext.getTurboFilterChainDecision_2(eVar, this, level, str2, obj, obj2, th);
        if (turboFilterChainDecision_2 == FilterReply.NEUTRAL) {
            if (this.effectiveLevelInt > level.levelInt) {
                return;
            }
        } else if (turboFilterChainDecision_2 == FilterReply.DENY) {
            return;
        }
        buildLoggingEventAndAppend(str, eVar, level, str2, new Object[]{obj, obj2}, th);
    }

    private synchronized void handleParentLevelChange(int i4) {
        if (this.level == null) {
            this.effectiveLevelInt = i4;
            List<Logger> list = this.childrenList;
            if (list != null) {
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    this.childrenList.get(i5).handleParentLevelChange(i4);
                }
            }
        }
    }

    private boolean isRootLogger() {
        return this.parent == null;
    }

    private void localLevelReset() {
        this.effectiveLevelInt = 10000;
        if (isRootLogger()) {
            this.level = Level.DEBUG;
        } else {
            this.level = null;
        }
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public synchronized void addAppender(Appender<ILoggingEvent> appender) {
        try {
            if (this.aai == null) {
                this.aai = new AppenderAttachableImpl<>();
            }
            this.aai.addAppender(appender);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void callAppenders(ILoggingEvent iLoggingEvent) {
        int iAppendLoopOnAppenders = 0;
        for (Logger logger = this; logger != null; logger = logger.parent) {
            iAppendLoopOnAppenders += logger.appendLoopOnAppenders(iLoggingEvent);
            if (!logger.additive) {
                break;
            }
        }
        if (iAppendLoopOnAppenders == 0) {
            this.loggerContext.noAppenderDefinedWarning(this);
        }
    }

    public Logger createChildByLastNamePart(String str) {
        Logger logger;
        if (LoggerNameUtil.getFirstSeparatorIndexOf(str) != -1) {
            throw new IllegalArgumentException(g.n("Child name [", str, " passed as parameter, may not include [.]"));
        }
        if (this.childrenList == null) {
            this.childrenList = new ArrayList();
        }
        if (isRootLogger()) {
            logger = new Logger(str, this, this.loggerContext);
        } else {
            logger = new Logger(this.name + CoreConstants.DOT + str, this, this.loggerContext);
        }
        this.childrenList.add(logger);
        logger.effectiveLevelInt = this.effectiveLevelInt;
        return logger;
    }

    public Logger createChildByName(String str) {
        if (LoggerNameUtil.getSeparatorIndexOf(str, this.name.length() + 1) != -1) {
            StringBuilder sb = new StringBuilder("For logger [");
            AbstractC0351g.C(sb, this.name, "] child name [", str, " passed as parameter, may not include '.' after index");
            sb.append(this.name.length() + 1);
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.childrenList == null) {
            this.childrenList = new ArrayList(5);
        }
        Logger logger = new Logger(str, this, this.loggerContext);
        this.childrenList.add(logger);
        logger.effectiveLevelInt = this.effectiveLevelInt;
        return logger;
    }

    public void debug(String str) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.DEBUG, str, null, null);
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public void detachAndStopAllAppenders() {
        AppenderAttachableImpl<ILoggingEvent> appenderAttachableImpl = this.aai;
        if (appenderAttachableImpl != null) {
            appenderAttachableImpl.detachAndStopAllAppenders();
        }
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public boolean detachAppender(String str) {
        AppenderAttachableImpl<ILoggingEvent> appenderAttachableImpl = this.aai;
        if (appenderAttachableImpl == null) {
            return false;
        }
        return appenderAttachableImpl.detachAppender(str);
    }

    public void error(String str) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.ERROR, str, null, null);
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public Appender<ILoggingEvent> getAppender(String str) {
        AppenderAttachableImpl<ILoggingEvent> appenderAttachableImpl = this.aai;
        if (appenderAttachableImpl == null) {
            return null;
        }
        return appenderAttachableImpl.getAppender(str);
    }

    public Logger getChildByName(String str) {
        List<Logger> list = this.childrenList;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            Logger logger = this.childrenList.get(i4);
            if (str.equals(logger.getName())) {
                return logger;
            }
        }
        return null;
    }

    public Level getEffectiveLevel() {
        return Level.toLevel(this.effectiveLevelInt);
    }

    public int getEffectiveLevelInt() {
        return this.effectiveLevelInt;
    }

    public Level getLevel() {
        return this.level;
    }

    public LoggerContext getLoggerContext() {
        return this.loggerContext;
    }

    public String getName() {
        return this.name;
    }

    @Override // n3.InterfaceC0781b
    public void info(String str) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.INFO, str, null, null);
    }

    public boolean isAdditive() {
        return this.additive;
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public boolean isAttached(Appender<ILoggingEvent> appender) {
        AppenderAttachableImpl<ILoggingEvent> appenderAttachableImpl = this.aai;
        if (appenderAttachableImpl == null) {
            return false;
        }
        return appenderAttachableImpl.isAttached(appender);
    }

    public boolean isDebugEnabled() {
        return isDebugEnabled(null);
    }

    public boolean isEnabledFor(e eVar, Level level) {
        FilterReply filterReplyCallTurboFilters = callTurboFilters(eVar, level);
        if (filterReplyCallTurboFilters == FilterReply.NEUTRAL) {
            return this.effectiveLevelInt <= level.levelInt;
        }
        if (filterReplyCallTurboFilters == FilterReply.DENY) {
            return false;
        }
        if (filterReplyCallTurboFilters == FilterReply.ACCEPT) {
            return true;
        }
        throw new IllegalStateException("Unknown FilterReply value: " + filterReplyCallTurboFilters);
    }

    public boolean isErrorEnabled() {
        return isErrorEnabled(null);
    }

    public boolean isInfoEnabled() {
        return isInfoEnabled(null);
    }

    public boolean isTraceEnabled() {
        return isTraceEnabled(null);
    }

    public boolean isWarnEnabled() {
        return isWarnEnabled(null);
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public Iterator<Appender<ILoggingEvent>> iteratorForAppenders() {
        AppenderAttachableImpl<ILoggingEvent> appenderAttachableImpl = this.aai;
        return appenderAttachableImpl == null ? Collections.EMPTY_LIST.iterator() : appenderAttachableImpl.iteratorForAppenders();
    }

    public void log(e eVar, String str, int i4, String str2, Object[] objArr, Throwable th) {
        filterAndLog_0_Or3Plus(str, eVar, Level.fromLocationAwareLoggerInteger(i4), str2, objArr, th);
    }

    public Object readResolve() throws ObjectStreamException {
        return AbstractC0782c.e(getName());
    }

    public void recursiveReset() {
        detachAndStopAllAppenders();
        localLevelReset();
        this.additive = true;
        List<Logger> list = this.childrenList;
        if (list == null) {
            return;
        }
        Iterator<Logger> it = list.iterator();
        while (it.hasNext()) {
            it.next().recursiveReset();
        }
    }

    public void setAdditive(boolean z4) {
        this.additive = z4;
    }

    public synchronized void setLevel(Level level) {
        try {
            if (this.level == level) {
                return;
            }
            if (level == null && isRootLogger()) {
                throw new IllegalArgumentException("The level of the root logger cannot be set to null");
            }
            this.level = level;
            if (level == null) {
                Logger logger = this.parent;
                this.effectiveLevelInt = logger.effectiveLevelInt;
                level = logger.getEffectiveLevel();
            } else {
                this.effectiveLevelInt = level.levelInt;
            }
            List<Logger> list = this.childrenList;
            if (list != null) {
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    this.childrenList.get(i4).handleParentLevelChange(this.effectiveLevelInt);
                }
            }
            this.loggerContext.fireOnLevelChange(this, level);
        } catch (Throwable th) {
            throw th;
        }
    }

    public String toString() {
        return g.r(new StringBuilder("Logger["), this.name, "]");
    }

    public void trace(String str) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.TRACE, str, null, null);
    }

    @Override // n3.InterfaceC0781b
    public void warn(String str) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.WARN, str, null, null);
    }

    @Override // n3.InterfaceC0781b
    public void debug(String str, Object obj) {
        filterAndLog_1(FQCN, null, Level.DEBUG, str, obj, null);
    }

    public void error(String str, Object obj) {
        filterAndLog_1(FQCN, null, Level.ERROR, str, obj, null);
    }

    public void info(String str, Object obj) {
        filterAndLog_1(FQCN, null, Level.INFO, str, obj, null);
    }

    public boolean isDebugEnabled(e eVar) {
        FilterReply filterReplyCallTurboFilters = callTurboFilters(eVar, Level.DEBUG);
        if (filterReplyCallTurboFilters == FilterReply.NEUTRAL) {
            return this.effectiveLevelInt <= 10000;
        }
        if (filterReplyCallTurboFilters == FilterReply.DENY) {
            return false;
        }
        if (filterReplyCallTurboFilters == FilterReply.ACCEPT) {
            return true;
        }
        throw new IllegalStateException("Unknown FilterReply value: " + filterReplyCallTurboFilters);
    }

    public boolean isErrorEnabled(e eVar) {
        FilterReply filterReplyCallTurboFilters = callTurboFilters(eVar, Level.ERROR);
        if (filterReplyCallTurboFilters == FilterReply.NEUTRAL) {
            return this.effectiveLevelInt <= 40000;
        }
        if (filterReplyCallTurboFilters == FilterReply.DENY) {
            return false;
        }
        if (filterReplyCallTurboFilters == FilterReply.ACCEPT) {
            return true;
        }
        throw new IllegalStateException("Unknown FilterReply value: " + filterReplyCallTurboFilters);
    }

    public boolean isInfoEnabled(e eVar) {
        FilterReply filterReplyCallTurboFilters = callTurboFilters(eVar, Level.INFO);
        if (filterReplyCallTurboFilters == FilterReply.NEUTRAL) {
            return this.effectiveLevelInt <= 20000;
        }
        if (filterReplyCallTurboFilters == FilterReply.DENY) {
            return false;
        }
        if (filterReplyCallTurboFilters == FilterReply.ACCEPT) {
            return true;
        }
        throw new IllegalStateException("Unknown FilterReply value: " + filterReplyCallTurboFilters);
    }

    public boolean isTraceEnabled(e eVar) {
        FilterReply filterReplyCallTurboFilters = callTurboFilters(eVar, Level.TRACE);
        if (filterReplyCallTurboFilters == FilterReply.NEUTRAL) {
            return this.effectiveLevelInt <= 5000;
        }
        if (filterReplyCallTurboFilters == FilterReply.DENY) {
            return false;
        }
        if (filterReplyCallTurboFilters == FilterReply.ACCEPT) {
            return true;
        }
        throw new IllegalStateException("Unknown FilterReply value: " + filterReplyCallTurboFilters);
    }

    public boolean isWarnEnabled(e eVar) {
        FilterReply filterReplyCallTurboFilters = callTurboFilters(eVar, Level.WARN);
        if (filterReplyCallTurboFilters == FilterReply.NEUTRAL) {
            return this.effectiveLevelInt <= 30000;
        }
        if (filterReplyCallTurboFilters == FilterReply.DENY) {
            return false;
        }
        if (filterReplyCallTurboFilters == FilterReply.ACCEPT) {
            return true;
        }
        throw new IllegalStateException("Unknown FilterReply value: " + filterReplyCallTurboFilters);
    }

    public void trace(String str, Object obj) {
        filterAndLog_1(FQCN, null, Level.TRACE, str, obj, null);
    }

    public void warn(String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.WARN, str, null, th);
    }

    public void debug(String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, null, Level.DEBUG, str, obj, obj2, null);
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public boolean detachAppender(Appender<ILoggingEvent> appender) {
        AppenderAttachableImpl<ILoggingEvent> appenderAttachableImpl = this.aai;
        if (appenderAttachableImpl == null) {
            return false;
        }
        return appenderAttachableImpl.detachAppender(appender);
    }

    public void error(String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, null, Level.ERROR, str, obj, obj2, null);
    }

    public void info(String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, null, Level.INFO, str, obj, obj2, null);
    }

    public void trace(String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, null, Level.TRACE, str, obj, obj2, null);
    }

    public void warn(String str, Object obj) {
        filterAndLog_1(FQCN, null, Level.WARN, str, obj, null);
    }

    public void debug(String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.DEBUG, str, objArr, null);
    }

    public void error(String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.ERROR, str, objArr, null);
    }

    public void info(String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.INFO, str, objArr, null);
    }

    public void trace(String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.TRACE, str, objArr, null);
    }

    public void warn(String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, null, Level.WARN, str, obj, obj2, null);
    }

    public void debug(String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.DEBUG, str, null, th);
    }

    @Override // n3.InterfaceC0781b
    public void error(String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.ERROR, str, null, th);
    }

    public void info(String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.INFO, str, null, th);
    }

    public void trace(String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.TRACE, str, null, th);
    }

    public void warn(String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.WARN, str, objArr, null);
    }

    public void debug(e eVar, String str) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.DEBUG, str, null, null);
    }

    public void error(e eVar, String str) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.ERROR, str, null, null);
    }

    public void info(e eVar, String str) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.INFO, str, null, null);
    }

    public void trace(e eVar, String str) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.TRACE, str, null, null);
    }

    public void warn(e eVar, String str) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.WARN, str, null, null);
    }

    public void debug(e eVar, String str, Object obj) {
        filterAndLog_1(FQCN, eVar, Level.DEBUG, str, obj, null);
    }

    public void error(e eVar, String str, Object obj) {
        filterAndLog_1(FQCN, eVar, Level.ERROR, str, obj, null);
    }

    public void info(e eVar, String str, Object obj) {
        filterAndLog_1(FQCN, eVar, Level.INFO, str, obj, null);
    }

    public boolean isEnabledFor(Level level) {
        return isEnabledFor(null, level);
    }

    public void trace(e eVar, String str, Object obj) {
        filterAndLog_1(FQCN, eVar, Level.TRACE, str, obj, null);
    }

    public void warn(e eVar, String str, Object obj) {
        filterAndLog_1(FQCN, eVar, Level.WARN, str, obj, null);
    }

    public void debug(e eVar, String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, eVar, Level.DEBUG, str, obj, obj2, null);
    }

    public void error(e eVar, String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, eVar, Level.ERROR, str, obj, obj2, null);
    }

    public void info(e eVar, String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, eVar, Level.INFO, str, obj, obj2, null);
    }

    public void trace(e eVar, String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, eVar, Level.TRACE, str, obj, obj2, null);
    }

    public void warn(e eVar, String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.WARN, str, objArr, null);
    }

    public void debug(e eVar, String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.DEBUG, str, objArr, null);
    }

    public void error(e eVar, String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.ERROR, str, objArr, null);
    }

    public void info(e eVar, String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.INFO, str, objArr, null);
    }

    public void trace(e eVar, String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.TRACE, str, objArr, null);
    }

    public void warn(e eVar, String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, eVar, Level.WARN, str, obj, obj2, null);
    }

    public void debug(e eVar, String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.DEBUG, str, null, th);
    }

    public void error(e eVar, String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.ERROR, str, null, th);
    }

    public void info(e eVar, String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.INFO, str, null, th);
    }

    public void trace(e eVar, String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.TRACE, str, null, th);
    }

    public void warn(e eVar, String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, eVar, Level.WARN, str, null, th);
    }
}
