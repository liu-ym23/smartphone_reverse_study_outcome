package ch.qos.logback.classic.jmx;

import B0.g;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.status.StatusUtil;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

/* loaded from: classes.dex */
public class MBeanUtil {
    static final String DOMAIN = "ch.qos.logback.classic";

    public static void createAndRegisterJMXConfigurator(MBeanServer mBeanServer, LoggerContext loggerContext, JMXConfigurator jMXConfigurator, ObjectName objectName, Object obj) {
        try {
            mBeanServer.registerMBean(jMXConfigurator, objectName);
        } catch (Exception e4) {
            new StatusUtil(loggerContext).addError(obj, "Failed to create mbean", e4);
        }
    }

    public static String getObjectNameFor(String str, Class cls) {
        StringBuilder sbW = g.w("ch.qos.logback.classic:Name=", str, ",Type=");
        sbW.append(cls.getName());
        return sbW.toString();
    }

    public static boolean isRegistered(MBeanServer mBeanServer, ObjectName objectName) {
        return mBeanServer.isRegistered(objectName);
    }

    public static ObjectName string2ObjectName(Context context, Object obj, String str) {
        String strN = g.n("Failed to convert [", str, "] to ObjectName");
        StatusUtil statusUtil = new StatusUtil(context);
        try {
            return new ObjectName(str);
        } catch (NullPointerException e4) {
            statusUtil.addError(obj, strN, e4);
            return null;
        } catch (MalformedObjectNameException e5) {
            statusUtil.addError(obj, strN, e5);
            return null;
        }
    }

    public static void unregister(LoggerContext loggerContext, MBeanServer mBeanServer, ObjectName objectName, Object obj) {
        StatusUtil statusUtil = new StatusUtil(loggerContext);
        if (!mBeanServer.isRegistered(objectName)) {
            statusUtil.addInfo(obj, "mbean [" + objectName + "] does not seem to be registered");
            return;
        }
        try {
            statusUtil.addInfo(obj, "Unregistering mbean [" + objectName + "]");
            mBeanServer.unregisterMBean(objectName);
        } catch (MBeanRegistrationException e4) {
            statusUtil.addError(obj, "Failed to unregister mbean" + objectName, e4);
        } catch (InstanceNotFoundException e5) {
            statusUtil.addError(obj, "Failed to unregister mbean" + objectName, e5);
        }
    }
}
