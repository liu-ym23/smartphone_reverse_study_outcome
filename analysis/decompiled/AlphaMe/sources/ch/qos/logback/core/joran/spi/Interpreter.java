package ch.qos.logback.core.joran.spi;

import B0.g;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.action.ImplicitAction;
import ch.qos.logback.core.joran.event.BodyEvent;
import ch.qos.logback.core.joran.event.EndEvent;
import ch.qos.logback.core.joran.event.StartEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;

/* loaded from: classes.dex */
public class Interpreter {
    private static List<Action> EMPTY_LIST = new Vector(0);
    private final CAI_WithLocatorSupport cai;
    private ElementPath elementPath;
    private final InterpretationContext interpretationContext;
    Locator locator;
    private final RuleStore ruleStore;
    ElementPath skip = null;
    private final ArrayList<ImplicitAction> implicitActions = new ArrayList<>(3);
    Stack<List<Action>> actionListStack = new Stack<>();
    EventPlayer eventPlayer = new EventPlayer(this);

    public Interpreter(Context context, RuleStore ruleStore, ElementPath elementPath) {
        this.cai = new CAI_WithLocatorSupport(context, this);
        this.ruleStore = ruleStore;
        this.interpretationContext = new InterpretationContext(context, this);
        this.elementPath = elementPath;
    }

    private void callBodyAction(List<Action> list, String str) {
        if (list == null) {
            return;
        }
        for (Action action : list) {
            try {
                action.body(this.interpretationContext, str);
            } catch (ActionException e4) {
                this.cai.addError("Exception in end() methd for action [" + action + "]", e4);
            }
        }
    }

    private void callEndAction(List<Action> list, String str) {
        if (list == null) {
            return;
        }
        Iterator<Action> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().end(this.interpretationContext, str);
            } catch (ActionException e4) {
                this.cai.addError("ActionException in Action for tag [" + str + "]", e4);
            } catch (RuntimeException e5) {
                this.cai.addError("RuntimeException in Action for tag [" + str + "]", e5);
            }
        }
    }

    private void pushEmptyActionList() {
        this.actionListStack.add(EMPTY_LIST);
    }

    public void addImplicitAction(ImplicitAction implicitAction) {
        this.implicitActions.add(implicitAction);
    }

    public void callBeginAction(List<Action> list, String str, Attributes attributes) {
        if (list == null) {
            return;
        }
        Iterator<Action> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().begin(this.interpretationContext, str, attributes);
            } catch (ActionException e4) {
                this.skip = this.elementPath.duplicate();
                this.cai.addError("ActionException in Action for tag [" + str + "]", e4);
            } catch (RuntimeException e5) {
                this.skip = this.elementPath.duplicate();
                this.cai.addError("RuntimeException in Action for tag [" + str + "]", e5);
            }
        }
    }

    public void characters(BodyEvent bodyEvent) {
        setDocumentLocator(bodyEvent.locator);
        String text = bodyEvent.getText();
        List<Action> listPeek = this.actionListStack.peek();
        if (text != null) {
            String strTrim = text.trim();
            if (strTrim.length() > 0) {
                callBodyAction(listPeek, strTrim);
            }
        }
    }

    public void endElement(EndEvent endEvent) {
        setDocumentLocator(endEvent.locator);
        endElement(endEvent.namespaceURI, endEvent.localName, endEvent.qName);
    }

    public List<Action> getApplicableActionList(ElementPath elementPath, Attributes attributes) {
        List<Action> listMatchActions = this.ruleStore.matchActions(elementPath);
        return listMatchActions == null ? lookupImplicitAction(elementPath, attributes, this.interpretationContext) : listMatchActions;
    }

    public EventPlayer getEventPlayer() {
        return this.eventPlayer;
    }

    public InterpretationContext getExecutionContext() {
        return getInterpretationContext();
    }

    public InterpretationContext getInterpretationContext() {
        return this.interpretationContext;
    }

    public Locator getLocator() {
        return this.locator;
    }

    public RuleStore getRuleStore() {
        return this.ruleStore;
    }

    public String getTagName(String str, String str2) {
        return (str == null || str.length() < 1) ? str2 : str;
    }

    public List<Action> lookupImplicitAction(ElementPath elementPath, Attributes attributes, InterpretationContext interpretationContext) {
        int size = this.implicitActions.size();
        for (int i4 = 0; i4 < size; i4++) {
            ImplicitAction implicitAction = this.implicitActions.get(i4);
            if (implicitAction.isApplicable(elementPath, attributes, interpretationContext)) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(implicitAction);
                return arrayList;
            }
        }
        return null;
    }

    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
    }

    public void setInterpretationContextPropertiesMap(Map<String, String> map) {
        this.interpretationContext.setPropertiesMap(map);
    }

    public void startDocument() {
    }

    public void startElement(StartEvent startEvent) {
        setDocumentLocator(startEvent.getLocator());
        startElement(startEvent.namespaceURI, startEvent.localName, startEvent.qName, startEvent.attributes);
    }

    private void endElement(String str, String str2, String str3) {
        List<Action> listPop = this.actionListStack.pop();
        ElementPath elementPath = this.skip;
        if (elementPath != null) {
            if (elementPath.equals(this.elementPath)) {
                this.skip = null;
            }
        } else if (listPop != EMPTY_LIST) {
            callEndAction(listPop, getTagName(str2, str3));
        }
        this.elementPath.pop();
    }

    private void startElement(String str, String str2, String str3, Attributes attributes) {
        String tagName = getTagName(str2, str3);
        this.elementPath.push(tagName);
        if (this.skip != null) {
            pushEmptyActionList();
            return;
        }
        List<Action> applicableActionList = getApplicableActionList(this.elementPath, attributes);
        if (applicableActionList != null) {
            this.actionListStack.add(applicableActionList);
            callBeginAction(applicableActionList, tagName, attributes);
            return;
        }
        pushEmptyActionList();
        StringBuilder sbW = g.w("no applicable action for [", tagName, "], current ElementPath  is [");
        sbW.append(this.elementPath);
        sbW.append("]");
        this.cai.addError(sbW.toString());
    }
}
