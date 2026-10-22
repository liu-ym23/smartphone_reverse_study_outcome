package ch.qos.logback.classic.boolex;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.EventEvaluatorBase;
import ch.qos.logback.core.util.FileUtil;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.Script;
import org.codehaus.groovy.control.CompilationFailedException;

/* loaded from: classes.dex */
public class GEventEvaluator extends EventEvaluatorBase<ILoggingEvent> {
    IEvaluator delegateEvaluator;
    String expression;
    Script script;

    public String getExpression() {
        return this.expression;
    }

    public void setExpression(String str) {
        this.expression = str;
    }

    @Override // ch.qos.logback.core.boolex.EventEvaluatorBase, ch.qos.logback.core.spi.LifeCycle
    public void start() throws Throwable {
        String str = this.expression;
        if (str == null || str.length() == 0) {
            addError("Empty expression");
            return;
        }
        addInfo("Expression to evaluate [" + this.expression + "]");
        ClassLoader classLoader = getClass().getClassLoader();
        String strReplace = getClass().getPackage().getName().replace(CoreConstants.DOT, '/');
        String strResourceAsString = new FileUtil(getContext()).resourceAsString(classLoader, strReplace + "/EvaluatorTemplate.groovy");
        if (strResourceAsString == null) {
            return;
        }
        try {
            this.delegateEvaluator = (GroovyObject) new GroovyClassLoader(classLoader).parseClass(strResourceAsString.replace("//EXPRESSION", this.expression)).newInstance();
            super.start();
        } catch (CompilationFailedException e4) {
            addError("Failed to compile expression [" + this.expression + "]", e4);
        } catch (Exception e5) {
            addError("Failed to compile expression [" + this.expression + "]", e5);
        }
    }

    @Override // ch.qos.logback.core.boolex.EventEvaluator
    public boolean evaluate(ILoggingEvent iLoggingEvent) throws NullPointerException, EvaluationException {
        IEvaluator iEvaluator = this.delegateEvaluator;
        if (iEvaluator == null) {
            return false;
        }
        return iEvaluator.doEvaluate(iLoggingEvent);
    }
}
