package ch.qos.logback.core.joran.spi;

import B0.g;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.joran.event.InPlayListener;
import ch.qos.logback.core.joran.event.SaxEvent;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.PropertyContainer;
import ch.qos.logback.core.util.OptionHelper;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import org.xml.sax.Locator;

/* loaded from: classes.dex */
public class InterpretationContext extends ContextAwareBase implements PropertyContainer {
    Interpreter joranInterpreter;
    Map<String, Object> objectMap;
    Stack<Object> objectStack;
    Map<String, String> propertiesMap;
    final List<InPlayListener> listenerList = new ArrayList();
    DefaultNestedComponentRegistry defaultNestedComponentRegistry = new DefaultNestedComponentRegistry();

    public InterpretationContext(Context context, Interpreter interpreter) {
        this.context = context;
        this.joranInterpreter = interpreter;
        this.objectStack = new Stack<>();
        this.objectMap = new HashMap(5);
        this.propertiesMap = new HashMap(5);
    }

    public void addInPlayListener(InPlayListener inPlayListener) {
        if (!this.listenerList.contains(inPlayListener)) {
            this.listenerList.add(inPlayListener);
            return;
        }
        addWarn("InPlayListener " + inPlayListener + " has been already registered");
    }

    public void addSubstitutionProperties(Properties properties) {
        if (properties == null) {
            return;
        }
        for (String str : properties.keySet()) {
            addSubstitutionProperty(str, properties.getProperty(str));
        }
    }

    public void addSubstitutionProperty(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.propertiesMap.put(str, str2.trim());
    }

    public void fireInPlay(SaxEvent saxEvent) {
        Iterator<InPlayListener> it = this.listenerList.iterator();
        while (it.hasNext()) {
            it.next().inPlay(saxEvent);
        }
    }

    @Override // ch.qos.logback.core.spi.PropertyContainer
    public Map<String, String> getCopyOfPropertyMap() {
        return new HashMap(this.propertiesMap);
    }

    public DefaultNestedComponentRegistry getDefaultNestedComponentRegistry() {
        return this.defaultNestedComponentRegistry;
    }

    public Interpreter getJoranInterpreter() {
        return this.joranInterpreter;
    }

    public Locator getLocator() {
        return this.joranInterpreter.getLocator();
    }

    public Object getObject(int i4) {
        return this.objectStack.get(i4);
    }

    public Map<String, Object> getObjectMap() {
        return this.objectMap;
    }

    public Stack<Object> getObjectStack() {
        return this.objectStack;
    }

    @Override // ch.qos.logback.core.spi.PropertyContainer
    public String getProperty(String str) {
        String str2 = this.propertiesMap.get(str);
        return str2 != null ? str2 : this.context.getProperty(str);
    }

    public boolean isEmpty() {
        return this.objectStack.isEmpty();
    }

    public boolean isListenerListEmpty() {
        return this.listenerList.isEmpty();
    }

    public Object peekObject() {
        return this.objectStack.peek();
    }

    public Object popObject() {
        return this.objectStack.pop();
    }

    public void pushObject(Object obj) {
        this.objectStack.push(obj);
    }

    public boolean removeInPlayListener(InPlayListener inPlayListener) {
        return this.listenerList.remove(inPlayListener);
    }

    public void setPropertiesMap(Map<String, String> map) {
        this.propertiesMap = map;
    }

    public String subst(String str) {
        if (str == null) {
            return null;
        }
        return OptionHelper.substVars(str, this, this.context);
    }

    public String updateLocationInfo(String str) {
        Locator locator = this.joranInterpreter.getLocator();
        if (locator == null) {
            return str;
        }
        StringBuilder sbS = g.s(str);
        sbS.append(locator.getLineNumber());
        sbS.append(AwarenessDataItem.USERID_SPLITTER);
        sbS.append(locator.getColumnNumber());
        return sbS.toString();
    }
}
