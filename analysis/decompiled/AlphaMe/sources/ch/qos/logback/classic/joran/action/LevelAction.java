package ch.qos.logback.classic.joran.action;

import B0.g;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.action.ActionConst;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import org.xml.sax.Attributes;

/* loaded from: classes.dex */
public class LevelAction extends Action {
    boolean inError = false;

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        Object objPeekObject = interpretationContext.peekObject();
        if (!(objPeekObject instanceof Logger)) {
            this.inError = true;
            addError("For element <level>, could not find a logger at the top of execution stack.");
            return;
        }
        Logger logger = (Logger) objPeekObject;
        String name = logger.getName();
        String strSubst = interpretationContext.subst(attributes.getValue("value"));
        if (ActionConst.INHERITED.equalsIgnoreCase(strSubst) || ActionConst.NULL.equalsIgnoreCase(strSubst)) {
            logger.setLevel(null);
        } else {
            logger.setLevel(Level.toLevel(strSubst, Level.DEBUG));
        }
        StringBuilder sbV = g.v(name, " level set to ");
        sbV.append(logger.getLevel());
        addInfo(sbV.toString());
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) {
    }

    public void finish(InterpretationContext interpretationContext) {
    }
}
