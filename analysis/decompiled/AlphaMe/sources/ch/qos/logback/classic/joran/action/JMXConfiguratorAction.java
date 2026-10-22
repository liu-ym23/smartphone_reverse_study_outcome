package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.jmx.JMXConfigurator;
import ch.qos.logback.classic.jmx.MBeanUtil;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import org.xml.sax.Attributes;

/* loaded from: classes.dex */
public class JMXConfiguratorAction extends Action {
    static final String CONTEXT_NAME_ATTRIBUTE_NAME = "contextName";
    static final char JMX_NAME_SEPARATOR = ',';
    static final String OBJECT_NAME_ATTRIBUTE_NAME = "objectName";

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) throws ActionException {
        addInfo("begin");
        String name = this.context.getName();
        String value = attributes.getValue(CONTEXT_NAME_ATTRIBUTE_NAME);
        if (!OptionHelper.isEmpty(value)) {
            name = value;
        }
        String value2 = attributes.getValue(OBJECT_NAME_ATTRIBUTE_NAME);
        if (OptionHelper.isEmpty(value2)) {
            value2 = MBeanUtil.getObjectNameFor(name, JMXConfigurator.class);
        }
        ObjectName objectNameString2ObjectName = MBeanUtil.string2ObjectName(this.context, this, value2);
        if (objectNameString2ObjectName == null) {
            addError("Failed construct ObjectName for [" + value2 + "]");
            return;
        }
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        if (MBeanUtil.isRegistered(platformMBeanServer, objectNameString2ObjectName)) {
            return;
        }
        try {
            platformMBeanServer.registerMBean(new JMXConfigurator((LoggerContext) this.context, platformMBeanServer, objectNameString2ObjectName), objectNameString2ObjectName);
        } catch (Exception e4) {
            addError("Failed to create mbean", e4);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) throws ActionException {
    }
}
