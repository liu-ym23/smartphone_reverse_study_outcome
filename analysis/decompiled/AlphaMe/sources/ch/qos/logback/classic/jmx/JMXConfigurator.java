package ch.qos.logback.classic.jmx;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusListener;
import ch.qos.logback.core.status.StatusListenerAsList;
import ch.qos.logback.core.util.StatusPrinter;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.ObjectName;

/* loaded from: classes.dex */
public class JMXConfigurator extends ContextAwareBase implements JMXConfiguratorMBean, LoggerContextListener {
    private static String EMPTY = "";
    LoggerContext loggerContext;
    MBeanServer mbs;
    ObjectName objectName;
    String objectNameAsString;
    boolean debug = true;
    boolean started = true;

    public JMXConfigurator(LoggerContext loggerContext, MBeanServer mBeanServer, ObjectName objectName) {
        this.context = loggerContext;
        this.loggerContext = loggerContext;
        this.mbs = mBeanServer;
        this.objectName = objectName;
        this.objectNameAsString = objectName.toString();
        if (!previouslyRegisteredListenerWithSameObjectName()) {
            loggerContext.addListener(this);
            return;
        }
        addError("Previously registered JMXConfigurator named [" + this.objectNameAsString + "] in the logger context named [" + loggerContext.getName() + "]");
    }

    private void clearFields() {
        this.mbs = null;
        this.objectName = null;
        this.loggerContext = null;
    }

    private boolean previouslyRegisteredListenerWithSameObjectName() {
        for (LoggerContextListener loggerContextListener : this.loggerContext.getCopyOfListenerList()) {
            if ((loggerContextListener instanceof JMXConfigurator) && this.objectName.equals(((JMXConfigurator) loggerContextListener).objectName)) {
                return true;
            }
        }
        return false;
    }

    private void stop() {
        this.started = false;
        clearFields();
    }

    public void addStatusListener(StatusListener statusListener) {
        this.loggerContext.getStatusManager().add(statusListener);
    }

    @Override // ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public String getLoggerEffectiveLevel(String str) {
        if (str == null) {
            return EMPTY;
        }
        Logger loggerExists = ((LoggerContext) this.context).exists(str.trim());
        return loggerExists != null ? loggerExists.getEffectiveLevel().toString() : EMPTY;
    }

    @Override // ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public String getLoggerLevel(String str) {
        if (str == null) {
            return EMPTY;
        }
        Logger loggerExists = ((LoggerContext) this.context).exists(str.trim());
        return (loggerExists == null || loggerExists.getLevel() == null) ? EMPTY : loggerExists.getLevel().toString();
    }

    @Override // ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public List<String> getLoggerList() {
        LoggerContext loggerContext = (LoggerContext) this.context;
        ArrayList arrayList = new ArrayList();
        Iterator<Logger> it = loggerContext.getLoggerList().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getName());
        }
        return arrayList;
    }

    @Override // ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public List<String> getStatuses() {
        ArrayList arrayList = new ArrayList();
        Iterator<Status> it = this.context.getStatusManager().getCopyOfStatusList().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        return arrayList;
    }

    @Override // ch.qos.logback.classic.spi.LoggerContextListener
    public boolean isResetResistant() {
        return true;
    }

    @Override // ch.qos.logback.classic.spi.LoggerContextListener
    public void onLevelChange(Logger logger, Level level) {
    }

    @Override // ch.qos.logback.classic.spi.LoggerContextListener
    public void onReset(LoggerContext loggerContext) {
        addInfo("onReset() method called JMXActivator [" + this.objectNameAsString + "]");
    }

    @Override // ch.qos.logback.classic.spi.LoggerContextListener
    public void onStart(LoggerContext loggerContext) {
    }

    @Override // ch.qos.logback.classic.spi.LoggerContextListener
    public void onStop(LoggerContext loggerContext) {
        if (!this.started) {
            addInfo("onStop() method called on a stopped JMXActivator [" + this.objectNameAsString + "]");
            return;
        }
        if (this.mbs.isRegistered(this.objectName)) {
            try {
                addInfo("Unregistering mbean [" + this.objectNameAsString + "]");
                this.mbs.unregisterMBean(this.objectName);
            } catch (MBeanRegistrationException e4) {
                addError("Failed to unregister [" + this.objectNameAsString + "]", e4);
            } catch (InstanceNotFoundException e5) {
                addError("Unable to find a verifiably registered mbean [" + this.objectNameAsString + "]", e5);
            }
        } else {
            addInfo("mbean [" + this.objectNameAsString + "] was not in the mbean registry. This is OK.");
        }
        stop();
    }

    @Override // ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public void reloadByFileName(String str) throws JoranException, FileNotFoundException {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            try {
                reloadByURL(file.toURI().toURL());
            } catch (MalformedURLException e4) {
                throw new RuntimeException("Unexpected MalformedURLException occured. See nexted cause.", e4);
            }
        } else {
            String str2 = "Could not find [" + str + "]";
            addInfo(str2);
            throw new FileNotFoundException(str2);
        }
    }

    @Override // ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public void reloadByURL(URL url) throws JoranException {
        StatusListenerAsList statusListenerAsList = new StatusListenerAsList();
        addStatusListener(statusListenerAsList);
        addInfo("Resetting context: " + this.loggerContext.getName());
        this.loggerContext.reset();
        addStatusListener(statusListenerAsList);
        try {
            JoranConfigurator joranConfigurator = new JoranConfigurator();
            joranConfigurator.setContext(this.loggerContext);
            joranConfigurator.doConfigure(url);
            addInfo("Context: " + this.loggerContext.getName() + " reloaded.");
        } finally {
            removeStatusListener(statusListenerAsList);
            if (this.debug) {
                StatusPrinter.print(statusListenerAsList.getStatusList());
            }
        }
    }

    @Override // ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public void reloadDefaultConfiguration() throws JoranException {
        reloadByURL(new ContextInitializer(this.loggerContext).findURLOfDefaultConfigurationFile(true));
    }

    public void removeStatusListener(StatusListener statusListener) {
        this.loggerContext.getStatusManager().remove(statusListener);
    }

    @Override // ch.qos.logback.classic.jmx.JMXConfiguratorMBean
    public void setLoggerLevel(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        String strTrim = str.trim();
        String strTrim2 = str2.trim();
        addInfo("Trying to set level " + strTrim2 + " to logger " + strTrim);
        Logger logger = ((LoggerContext) this.context).getLogger(strTrim);
        if ("null".equalsIgnoreCase(strTrim2)) {
            logger.setLevel(null);
            return;
        }
        Level level = Level.toLevel(strTrim2, (Level) null);
        if (level != null) {
            logger.setLevel(level);
        }
    }

    public String toString() {
        return getClass().getName() + "(" + this.context.getName() + ")";
    }
}
