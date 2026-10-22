package ch.qos.logback.core.joran.action;

import B0.g;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.util.OptionHelper;
import java.util.HashMap;
import org.xml.sax.Attributes;

/* loaded from: classes.dex */
public class AppenderAction<E> extends Action {
    Appender<E> appender;
    private boolean inError = false;

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) throws ActionException {
        this.appender = null;
        this.inError = false;
        String value = attributes.getValue(Action.CLASS_ATTRIBUTE);
        if (OptionHelper.isEmpty(value)) {
            StringBuilder sbW = g.w("Missing class name for appender. Near [", str, "] line ");
            sbW.append(getLineNumber(interpretationContext));
            addError(sbW.toString());
            this.inError = true;
            return;
        }
        try {
            addInfo("About to instantiate appender of type [" + value + "]");
            Appender<E> appender = (Appender) OptionHelper.instantiateByClassName(value, (Class<?>) Appender.class, this.context);
            this.appender = appender;
            appender.setContext(this.context);
            String strSubst = interpretationContext.subst(attributes.getValue("name"));
            if (OptionHelper.isEmpty(strSubst)) {
                addWarn("No appender name given for appender of type " + value + "].");
            } else {
                this.appender.setName(strSubst);
                addInfo("Naming appender as [" + strSubst + "]");
            }
            ((HashMap) interpretationContext.getObjectMap().get(ActionConst.APPENDER_BAG)).put(strSubst, this.appender);
            interpretationContext.pushObject(this.appender);
        } catch (Exception e4) {
            this.inError = true;
            addError("Could not create an Appender of type [" + value + "].", e4);
            throw new ActionException(e4);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) {
        if (this.inError) {
            return;
        }
        Appender<E> appender = this.appender;
        if (appender instanceof LifeCycle) {
            appender.start();
        }
        if (interpretationContext.peekObject() == this.appender) {
            interpretationContext.popObject();
            return;
        }
        addWarn("The object at the of the stack is not the appender named [" + this.appender.getName() + "] pushed earlier.");
    }
}
