package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.util.JNDIUtil;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.action.ActionUtil;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import javax.naming.NamingException;
import org.xml.sax.Attributes;

/* loaded from: classes.dex */
public class InsertFromJNDIAction extends Action {
    public static final String AS_ATTR = "as";
    public static final String ENV_ENTRY_NAME_ATTR = "env-entry-name";

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        int i4;
        String strSubst = interpretationContext.subst(attributes.getValue(ENV_ENTRY_NAME_ATTR));
        String strSubst2 = interpretationContext.subst(attributes.getValue(AS_ATTR));
        ActionUtil.Scope scopeStringToScope = ActionUtil.stringToScope(attributes.getValue(Action.SCOPE_ATTRIBUTE));
        if (OptionHelper.isEmpty(strSubst)) {
            addError("[env-entry-name] missing, around " + getLineColStr(interpretationContext));
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (OptionHelper.isEmpty(strSubst2)) {
            addError("[as] missing, around " + getLineColStr(interpretationContext));
            i4++;
        }
        if (i4 != 0) {
            return;
        }
        try {
            String strLookup = JNDIUtil.lookup(JNDIUtil.getInitialContext(), strSubst);
            if (OptionHelper.isEmpty(strLookup)) {
                addError("[" + strSubst + "] has null or empty value");
            } else {
                addInfo("Setting variable [" + strSubst2 + "] to [" + strLookup + "] in [" + scopeStringToScope + "] scope");
                ActionUtil.setProperty(interpretationContext, strSubst2, strLookup, scopeStringToScope);
            }
        } catch (NamingException unused) {
            addError("Failed to lookup JNDI env-entry [" + strSubst + "]");
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) {
    }
}
