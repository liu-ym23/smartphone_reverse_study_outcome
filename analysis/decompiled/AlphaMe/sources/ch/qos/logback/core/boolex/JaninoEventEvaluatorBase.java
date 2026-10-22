package ch.qos.logback.core.boolex;

import B0.g;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.janino.ScriptEvaluator;

/* loaded from: classes.dex */
public abstract class JaninoEventEvaluatorBase<E> extends EventEvaluatorBase<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ERROR_THRESHOLD = 4;
    static Class<?> EXPRESSION_TYPE = Boolean.TYPE;
    static Class<?>[] THROWN_EXCEPTIONS = {EvaluationException.class};
    private String expression;
    ScriptEvaluator scriptEvaluator;
    private int errorCount = 0;
    protected List<Matcher> matcherList = new ArrayList();

    public void addMatcher(Matcher matcher) {
        this.matcherList.add(matcher);
    }

    @Override // ch.qos.logback.core.boolex.EventEvaluator
    public boolean evaluate(E e4) throws EvaluationException {
        if (!isStarted()) {
            throw new IllegalStateException(g.r(new StringBuilder("Evaluator ["), this.name, "] was called in stopped state"));
        }
        try {
            return ((Boolean) this.scriptEvaluator.evaluate(getParameterValues(e4))).booleanValue();
        } catch (Exception e5) {
            int i4 = this.errorCount + 1;
            this.errorCount = i4;
            if (i4 >= 4) {
                this.stop();
            }
            throw new EvaluationException(g.r(new StringBuilder("Evaluator ["), this.name, "] caused an exception"), e5);
        }
    }

    public abstract String getDecoratedExpression();

    public String getExpression() {
        return this.expression;
    }

    public List<Matcher> getMatcherList() {
        return this.matcherList;
    }

    public abstract String[] getParameterNames();

    public abstract Class<?>[] getParameterTypes();

    public abstract Object[] getParameterValues(E e4);

    public void setExpression(String str) {
        this.expression = str;
    }

    @Override // ch.qos.logback.core.boolex.EventEvaluatorBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        try {
            this.scriptEvaluator = new ScriptEvaluator(getDecoratedExpression(), EXPRESSION_TYPE, getParameterNames(), getParameterTypes(), THROWN_EXCEPTIONS);
            super.start();
        } catch (Exception e4) {
            addError("Could not start evaluator with expression [" + this.expression + "]", e4);
        }
    }
}
