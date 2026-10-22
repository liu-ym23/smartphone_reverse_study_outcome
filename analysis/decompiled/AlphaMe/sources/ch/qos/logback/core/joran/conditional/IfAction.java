package ch.qos.logback.core.joran.conditional;

import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.event.SaxEvent;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.spi.Interpreter;
import ch.qos.logback.core.util.EnvUtil;
import ch.qos.logback.core.util.OptionHelper;
import java.util.List;
import java.util.Stack;
import org.codehaus.commons.compiler.CompileException;
import org.xml.sax.Attributes;

/* loaded from: classes.dex */
public class IfAction extends Action {
    private static final String CONDITION_ATTR = "condition";
    public static final String MISSING_JANINO_MSG = "Could not find Janino library on the class path. Skipping conditional processing.";
    public static final String MISSING_JANINO_SEE = "See also http://logback.qos.ch/codes.html#ifJanino";
    Stack<IfState> stack = new Stack<>();

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) throws ActionException, CompileException {
        Condition conditionBuild;
        IfState ifState = new IfState();
        boolean zIsEmpty = this.stack.isEmpty();
        this.stack.push(ifState);
        if (zIsEmpty) {
            interpretationContext.pushObject(this);
            if (!EnvUtil.isJaninoAvailable()) {
                addError(MISSING_JANINO_MSG);
                addError(MISSING_JANINO_SEE);
                return;
            }
            ifState.active = true;
            String value = attributes.getValue(CONDITION_ATTR);
            if (OptionHelper.isEmpty(value)) {
                return;
            }
            String strSubstVars = OptionHelper.substVars(value, interpretationContext, this.context);
            PropertyEvalScriptBuilder propertyEvalScriptBuilder = new PropertyEvalScriptBuilder(interpretationContext);
            propertyEvalScriptBuilder.setContext(this.context);
            try {
                conditionBuild = propertyEvalScriptBuilder.build(strSubstVars);
            } catch (Exception e4) {
                this.addError("Failed to parse condition [" + strSubstVars + "]", e4);
                conditionBuild = null;
            }
            if (conditionBuild != null) {
                ifState.boolResult = Boolean.valueOf(conditionBuild.evaluate());
            }
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) throws ActionException {
        IfState ifStatePop = this.stack.pop();
        if (ifStatePop.active) {
            Object objPeekObject = interpretationContext.peekObject();
            if (objPeekObject == null) {
                throw new IllegalStateException("Unexpected null object on stack");
            }
            if (!(objPeekObject instanceof IfAction)) {
                throw new IllegalStateException("Unexpected object of type [" + objPeekObject.getClass() + "] on stack");
            }
            if (objPeekObject != this) {
                throw new IllegalStateException("IfAction different then current one on stack");
            }
            interpretationContext.popObject();
            if (ifStatePop.boolResult == null) {
                addError("Failed to determine \"if then else\" result");
                return;
            }
            Interpreter joranInterpreter = interpretationContext.getJoranInterpreter();
            List<SaxEvent> list = ifStatePop.thenSaxEventList;
            if (!ifStatePop.boolResult.booleanValue()) {
                list = ifStatePop.elseSaxEventList;
            }
            if (list != null) {
                joranInterpreter.getEventPlayer().addEventsDynamically(list, 1);
            }
        }
    }

    public boolean isActive() {
        Stack<IfState> stack = this.stack;
        if (stack == null || stack.isEmpty()) {
            return false;
        }
        return this.stack.peek().active;
    }

    public void setElseSaxEventList(List<SaxEvent> list) {
        IfState ifStateFirstElement = this.stack.firstElement();
        if (!ifStateFirstElement.active) {
            throw new IllegalStateException("setElseSaxEventList() invoked on inactive IfAction");
        }
        ifStateFirstElement.elseSaxEventList = list;
    }

    public void setThenSaxEventList(List<SaxEvent> list) {
        IfState ifStateFirstElement = this.stack.firstElement();
        if (!ifStateFirstElement.active) {
            throw new IllegalStateException("setThenSaxEventList() invoked on inactive IfAction");
        }
        ifStateFirstElement.thenSaxEventList = list;
    }
}
