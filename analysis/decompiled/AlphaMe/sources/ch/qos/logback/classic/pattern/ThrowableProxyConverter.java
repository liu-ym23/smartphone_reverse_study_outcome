package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.classic.spi.ThrowableProxyUtil;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.EventEvaluator;
import ch.qos.logback.core.status.ErrorStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ThrowableProxyConverter extends ThrowableHandlingConverter {
    protected static final int BUILDER_CAPACITY = 2048;
    int lengthOption;
    List<EventEvaluator<ILoggingEvent>> evaluatorList = null;
    int errorCount = 0;

    private void addEvaluator(EventEvaluator<ILoggingEvent> eventEvaluator) {
        if (this.evaluatorList == null) {
            this.evaluatorList = new ArrayList();
        }
        this.evaluatorList.add(eventEvaluator);
    }

    private void recursiveAppend(StringBuilder sb, String str, int i4, IThrowableProxy iThrowableProxy) {
        if (iThrowableProxy == null) {
            return;
        }
        subjoinFirstLine(sb, str, i4, iThrowableProxy);
        sb.append(CoreConstants.LINE_SEPARATOR);
        subjoinSTEPArray(sb, i4, iThrowableProxy);
        IThrowableProxy[] suppressed = iThrowableProxy.getSuppressed();
        if (suppressed != null) {
            for (IThrowableProxy iThrowableProxy2 : suppressed) {
                recursiveAppend(sb, CoreConstants.SUPPRESSED, i4 + 1, iThrowableProxy2);
            }
        }
        recursiveAppend(sb, CoreConstants.CAUSED_BY, i4, iThrowableProxy.getCause());
    }

    private void subjoinExceptionMessage(StringBuilder sb, IThrowableProxy iThrowableProxy) {
        sb.append(iThrowableProxy.getClassName());
        sb.append(": ");
        sb.append(iThrowableProxy.getMessage());
    }

    private void subjoinFirstLine(StringBuilder sb, String str, int i4, IThrowableProxy iThrowableProxy) {
        ThrowableProxyUtil.indent(sb, i4 - 1);
        if (str != null) {
            sb.append(str);
        }
        subjoinExceptionMessage(sb, iThrowableProxy);
    }

    public void extraData(StringBuilder sb, StackTraceElementProxy stackTraceElementProxy) {
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        String firstOption = getFirstOption();
        if (firstOption == null) {
            this.lengthOption = Integer.MAX_VALUE;
        } else {
            String lowerCase = firstOption.toLowerCase();
            if ("full".equals(lowerCase)) {
                this.lengthOption = Integer.MAX_VALUE;
            } else if ("short".equals(lowerCase)) {
                this.lengthOption = 1;
            } else {
                try {
                    this.lengthOption = Integer.parseInt(lowerCase);
                } catch (NumberFormatException unused) {
                    addError("Could not parse [" + lowerCase + "] as an integer");
                    this.lengthOption = Integer.MAX_VALUE;
                }
            }
        }
        List<String> optionList = getOptionList();
        if (optionList != null && optionList.size() > 1) {
            int size = optionList.size();
            for (int i4 = 1; i4 < size; i4++) {
                addEvaluator((EventEvaluator) ((Map) getContext().getObject(CoreConstants.EVALUATOR_MAP)).get(optionList.get(i4)));
            }
        }
        super.start();
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.evaluatorList = null;
        super.stop();
    }

    public void subjoinSTEPArray(StringBuilder sb, int i4, IThrowableProxy iThrowableProxy) {
        StackTraceElementProxy[] stackTraceElementProxyArray = iThrowableProxy.getStackTraceElementProxyArray();
        int commonFrames = iThrowableProxy.getCommonFrames();
        int length = this.lengthOption;
        boolean z4 = length > stackTraceElementProxyArray.length;
        if (z4) {
            length = stackTraceElementProxyArray.length;
        }
        if (commonFrames > 0 && z4) {
            length -= commonFrames;
        }
        for (int i5 = 0; i5 < length; i5++) {
            ThrowableProxyUtil.indent(sb, i4);
            sb.append(stackTraceElementProxyArray[i5]);
            extraData(sb, stackTraceElementProxyArray[i5]);
            sb.append(CoreConstants.LINE_SEPARATOR);
        }
        if (commonFrames <= 0 || !z4) {
            return;
        }
        ThrowableProxyUtil.indent(sb, i4);
        sb.append("... ");
        sb.append(iThrowableProxy.getCommonFrames());
        sb.append(" common frames omitted");
        sb.append(CoreConstants.LINE_SEPARATOR);
    }

    public String throwableProxyToString(IThrowableProxy iThrowableProxy) {
        StringBuilder sb = new StringBuilder(2048);
        recursiveAppend(sb, null, 1, iThrowableProxy);
        return sb.toString();
    }

    @Override // ch.qos.logback.core.pattern.Converter
    public String convert(ILoggingEvent iLoggingEvent) {
        IThrowableProxy throwableProxy = iLoggingEvent.getThrowableProxy();
        if (throwableProxy == null) {
            return "";
        }
        if (this.evaluatorList != null) {
            for (int i4 = 0; i4 < this.evaluatorList.size(); i4++) {
                EventEvaluator<ILoggingEvent> eventEvaluator = this.evaluatorList.get(i4);
                try {
                } catch (EvaluationException e4) {
                    this.errorCount++;
                    if (this.errorCount < 4) {
                        addError("Exception thrown for evaluator named [" + eventEvaluator.getName() + "]", e4);
                    } else if (this.errorCount == 4) {
                        ErrorStatus errorStatus = new ErrorStatus("Exception thrown for evaluator named [" + eventEvaluator.getName() + "].", this, e4);
                        errorStatus.add(new ErrorStatus("This was the last warning about this evaluator's errors.We don't want the StatusManager to get flooded.", this));
                        addStatus(errorStatus);
                    }
                }
                if (eventEvaluator.evaluate(iLoggingEvent)) {
                    return "";
                }
            }
        }
        return throwableProxyToString(throwableProxy);
    }
}
