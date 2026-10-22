package ch.qos.logback.classic.boolex;

import B0.g;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.LoggerContextVO;
import ch.qos.logback.classic.spi.ThrowableProxy;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.boolex.JaninoEventEvaluatorBase;
import ch.qos.logback.core.boolex.Matcher;
import com.stepos.alphame.screen.ScreenEventStorable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import n3.e;

/* loaded from: classes.dex */
public class JaninoEventEvaluator extends JaninoEventEvaluatorBase<ILoggingEvent> {
    public static final List<String> DEFAULT_PARAM_NAME_LIST;
    public static final List<Class> DEFAULT_PARAM_TYPE_LIST;
    public static final String IMPORT_LEVEL = "import ch.qos.logback.classic.Level;\r\n";

    static {
        ArrayList arrayList = new ArrayList();
        DEFAULT_PARAM_NAME_LIST = arrayList;
        ArrayList arrayList2 = new ArrayList();
        DEFAULT_PARAM_TYPE_LIST = arrayList2;
        arrayList.add("DEBUG");
        arrayList.add("INFO");
        arrayList.add("WARN");
        arrayList.add("ERROR");
        arrayList.add(ScreenEventStorable.COLUMN_EVENT);
        arrayList.add("message");
        arrayList.add("formattedMessage");
        arrayList.add("logger");
        arrayList.add("loggerContext");
        arrayList.add("level");
        arrayList.add("timeStamp");
        arrayList.add("marker");
        arrayList.add("mdc");
        arrayList.add("throwableProxy");
        arrayList.add("throwable");
        Class cls = Integer.TYPE;
        arrayList2.add(cls);
        arrayList2.add(cls);
        arrayList2.add(cls);
        arrayList2.add(cls);
        arrayList2.add(ILoggingEvent.class);
        arrayList2.add(String.class);
        arrayList2.add(String.class);
        arrayList2.add(String.class);
        arrayList2.add(LoggerContextVO.class);
        arrayList2.add(cls);
        arrayList2.add(Long.TYPE);
        arrayList2.add(e.class);
        arrayList2.add(Map.class);
        arrayList2.add(IThrowableProxy.class);
        arrayList2.add(Throwable.class);
    }

    @Override // ch.qos.logback.core.boolex.JaninoEventEvaluatorBase
    public String getDecoratedExpression() {
        String expression = getExpression();
        if (!expression.contains("return")) {
            expression = g.n("return ", expression, ";");
            addInfo("Adding [return] prefix and a semicolon suffix. Expression becomes [" + expression + "]");
            addInfo("See also http://logback.qos.ch/codes.html#block");
        }
        return g.m(IMPORT_LEVEL, expression);
    }

    @Override // ch.qos.logback.core.boolex.JaninoEventEvaluatorBase
    public String[] getParameterNames() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(DEFAULT_PARAM_NAME_LIST);
        for (int i4 = 0; i4 < this.matcherList.size(); i4++) {
            arrayList.add(this.matcherList.get(i4).getName());
        }
        return (String[]) arrayList.toArray(CoreConstants.EMPTY_STRING_ARRAY);
    }

    @Override // ch.qos.logback.core.boolex.JaninoEventEvaluatorBase
    public Class[] getParameterTypes() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(DEFAULT_PARAM_TYPE_LIST);
        for (int i4 = 0; i4 < this.matcherList.size(); i4++) {
            arrayList.add(Matcher.class);
        }
        return (Class[]) arrayList.toArray(CoreConstants.EMPTY_CLASS_ARRAY);
    }

    @Override // ch.qos.logback.core.boolex.JaninoEventEvaluatorBase
    public Object[] getParameterValues(ILoggingEvent iLoggingEvent) {
        int size = this.matcherList.size();
        Object[] objArr = new Object[DEFAULT_PARAM_NAME_LIST.size() + size];
        int i4 = 0;
        objArr[0] = Level.DEBUG_INTEGER;
        objArr[1] = Level.INFO_INTEGER;
        objArr[2] = Level.WARN_INTEGER;
        objArr[3] = Level.ERROR_INTEGER;
        objArr[4] = iLoggingEvent;
        objArr[5] = iLoggingEvent.getMessage();
        objArr[6] = iLoggingEvent.getFormattedMessage();
        objArr[7] = iLoggingEvent.getLoggerName();
        objArr[8] = iLoggingEvent.getLoggerContextVO();
        objArr[9] = iLoggingEvent.getLevel().toInteger();
        objArr[10] = Long.valueOf(iLoggingEvent.getTimeStamp());
        objArr[11] = iLoggingEvent.getMarker();
        objArr[12] = iLoggingEvent.getMDCPropertyMap();
        IThrowableProxy throwableProxy = iLoggingEvent.getThrowableProxy();
        if (throwableProxy != null) {
            objArr[13] = throwableProxy;
            if (throwableProxy instanceof ThrowableProxy) {
                objArr[14] = ((ThrowableProxy) throwableProxy).getThrowable();
            } else {
                objArr[14] = null;
            }
        } else {
            objArr[13] = null;
            objArr[14] = null;
        }
        int i5 = 15;
        while (i4 < size) {
            objArr[i5] = this.matcherList.get(i4);
            i4++;
            i5++;
        }
        return objArr;
    }
}
