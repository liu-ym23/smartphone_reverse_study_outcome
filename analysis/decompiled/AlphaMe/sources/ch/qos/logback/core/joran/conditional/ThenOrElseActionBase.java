package ch.qos.logback.core.joran.conditional;

import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.event.SaxEvent;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import java.util.List;
import java.util.Stack;
import org.xml.sax.Attributes;

/* loaded from: classes.dex */
public abstract class ThenOrElseActionBase extends Action {
    Stack<ThenActionState> stateStack = new Stack<>();

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) throws ActionException {
        if (weAreActive(interpretationContext)) {
            ThenActionState thenActionState = new ThenActionState();
            if (interpretationContext.isListenerListEmpty()) {
                interpretationContext.addInPlayListener(thenActionState);
                thenActionState.isRegistered = true;
            }
            this.stateStack.push(thenActionState);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) throws ActionException {
        if (weAreActive(interpretationContext)) {
            ThenActionState thenActionStatePop = this.stateStack.pop();
            if (thenActionStatePop.isRegistered) {
                interpretationContext.removeInPlayListener(thenActionStatePop);
                Object objPeekObject = interpretationContext.peekObject();
                if (!(objPeekObject instanceof IfAction)) {
                    throw new IllegalStateException("Missing IfAction on top of stack");
                }
                removeFirstAndLastFromList(thenActionStatePop.eventList);
                registerEventList((IfAction) objPeekObject, thenActionStatePop.eventList);
            }
        }
    }

    public abstract void registerEventList(IfAction ifAction, List<SaxEvent> list);

    public void removeFirstAndLastFromList(List<SaxEvent> list) {
        list.remove(0);
        list.remove(list.size() - 1);
    }

    public boolean weAreActive(InterpretationContext interpretationContext) {
        Object objPeekObject = interpretationContext.peekObject();
        if (objPeekObject instanceof IfAction) {
            return ((IfAction) objPeekObject).isActive();
        }
        return false;
    }
}
