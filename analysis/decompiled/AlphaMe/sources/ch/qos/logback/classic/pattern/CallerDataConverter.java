package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.CallerData;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.EventEvaluator;
import ch.qos.logback.core.status.ErrorStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CallerDataConverter extends ClassicConverter {
    public static final String DEFAULT_CALLER_LINE_PREFIX = "Caller+";
    int depth = 5;
    List<EventEvaluator<ILoggingEvent>> evaluatorList = null;
    final int MAX_ERROR_COUNT = 4;
    int errorCount = 0;

    private void addEvaluator(EventEvaluator<ILoggingEvent> eventEvaluator) {
        if (this.evaluatorList == null) {
            this.evaluatorList = new ArrayList();
        }
        this.evaluatorList.add(eventEvaluator);
    }

    public String getCallerLinePrefix() {
        return DEFAULT_CALLER_LINE_PREFIX;
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        EventEvaluator<ILoggingEvent> eventEvaluator;
        String firstOption = getFirstOption();
        if (firstOption == null) {
            return;
        }
        try {
            this.depth = Integer.parseInt(firstOption);
        } catch (NumberFormatException e4) {
            addError("Failed to parse depth option [" + firstOption + "]", e4);
        }
        List<String> optionList = getOptionList();
        if (optionList != null) {
            if (optionList.size() > 1) {
                int size = optionList.size();
                for (int i4 = 1; i4 < size; i4++) {
                    String str = optionList.get(i4);
                    Context context = getContext();
                    if (context != null && (eventEvaluator = (EventEvaluator) ((Map) context.getObject(CoreConstants.EVALUATOR_MAP)).get(str)) != null) {
                        addEvaluator(eventEvaluator);
                    }
                }
            }
        }
    }

    @Override // ch.qos.logback.core.pattern.Converter
    public String convert(ILoggingEvent iLoggingEvent) {
        StringBuilder sb = new StringBuilder();
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
                if (!eventEvaluator.evaluate(iLoggingEvent)) {
                }
            }
            return "";
        }
        StackTraceElement[] callerData = iLoggingEvent.getCallerData();
        if (callerData == null || callerData.length <= 0) {
            return CallerData.CALLER_DATA_NA;
        }
        int length = this.depth;
        if (length >= callerData.length) {
            length = callerData.length;
        }
        for (int i5 = 0; i5 < length; i5++) {
            sb.append(getCallerLinePrefix());
            sb.append(i5);
            sb.append("\t at ");
            sb.append(callerData[i5]);
            sb.append(CoreConstants.LINE_SEPARATOR);
        }
        return sb.toString();
    }
}
