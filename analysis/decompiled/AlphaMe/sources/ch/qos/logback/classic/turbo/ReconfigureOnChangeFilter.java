package ch.qos.logback.classic.turbo;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.gaffer.GafferUtil;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.classic.util.EnvUtil;
import ch.qos.logback.core.joran.GenericConfigurator;
import ch.qos.logback.core.joran.event.SaxEvent;
import ch.qos.logback.core.joran.spi.ConfigurationWatchList;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.status.StatusUtil;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import n3.e;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public class ReconfigureOnChangeFilter extends TurboFilter {
    public static final long DEFAULT_REFRESH_PERIOD = 60000;
    private static final long MASK_DECREASE_THRESHOLD = 800;
    private static final long MASK_INCREASE_THRESHOLD = 100;
    private static final int MAX_MASK = 65535;
    ConfigurationWatchList configurationWatchList;
    URL mainConfigurationURL;
    protected volatile long nextCheck;
    long refreshPeriod = 60000;
    private long invocationCounter = 0;
    private volatile long mask = 15;
    private volatile long lastMaskCheck = System.currentTimeMillis();

    public class ReconfiguringThread implements Runnable {
        public ReconfiguringThread() {
        }

        private void fallbackConfiguration(LoggerContext loggerContext, List<SaxEvent> list, URL url) {
            JoranConfigurator joranConfigurator = new JoranConfigurator();
            joranConfigurator.setContext(((ContextAwareBase) ReconfigureOnChangeFilter.this).context);
            if (list == null) {
                ReconfigureOnChangeFilter.this.addWarn("No previous configuration to fall back on.");
                return;
            }
            ReconfigureOnChangeFilter.this.addWarn("Falling back to previously registered safe configuration.");
            try {
                loggerContext.reset();
                GenericConfigurator.informContextOfURLUsedForConfiguration(((ContextAwareBase) ReconfigureOnChangeFilter.this).context, url);
                joranConfigurator.doConfigure(list);
                ReconfigureOnChangeFilter.this.addInfo("Re-registering previous fallback configuration once more as a fallback configuration point");
                joranConfigurator.registerSafeConfiguration();
            } catch (JoranException e4) {
                ReconfigureOnChangeFilter.this.addError("Unexpected exception thrown by a configuration considered safe.", e4);
            }
        }

        private void performXMLConfiguration(LoggerContext loggerContext) throws IOException {
            JoranConfigurator joranConfigurator = new JoranConfigurator();
            joranConfigurator.setContext(((ContextAwareBase) ReconfigureOnChangeFilter.this).context);
            StatusUtil statusUtil = new StatusUtil(((ContextAwareBase) ReconfigureOnChangeFilter.this).context);
            List<SaxEvent> listRecallSafeConfiguration = joranConfigurator.recallSafeConfiguration();
            URL mainWatchURL = ConfigurationWatchListUtil.getMainWatchURL(((ContextAwareBase) ReconfigureOnChangeFilter.this).context);
            loggerContext.reset();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                joranConfigurator.doConfigure(ReconfigureOnChangeFilter.this.mainConfigurationURL);
                if (statusUtil.hasXMLParsingErrors(jCurrentTimeMillis)) {
                    fallbackConfiguration(loggerContext, listRecallSafeConfiguration, mainWatchURL);
                }
            } catch (JoranException unused) {
                fallbackConfiguration(loggerContext, listRecallSafeConfiguration, mainWatchURL);
            }
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            ReconfigureOnChangeFilter reconfigureOnChangeFilter = ReconfigureOnChangeFilter.this;
            if (reconfigureOnChangeFilter.mainConfigurationURL == null) {
                reconfigureOnChangeFilter.addInfo("Due to missing top level configuration file, skipping reconfiguration");
                return;
            }
            LoggerContext loggerContext = (LoggerContext) ((ContextAwareBase) reconfigureOnChangeFilter).context;
            ReconfigureOnChangeFilter.this.addInfo("Will reset and reconfigure context named [" + ((ContextAwareBase) ReconfigureOnChangeFilter.this).context.getName() + "]");
            if (ReconfigureOnChangeFilter.this.mainConfigurationURL.toString().endsWith("xml")) {
                performXMLConfiguration(loggerContext);
                return;
            }
            if (ReconfigureOnChangeFilter.this.mainConfigurationURL.toString().endsWith("groovy")) {
                if (!EnvUtil.isGroovyAvailable()) {
                    ReconfigureOnChangeFilter.this.addError("Groovy classes are not available on the class path. ABORTING INITIALIZATION.");
                } else {
                    loggerContext.reset();
                    GafferUtil.runGafferConfiguratorOn(loggerContext, this, ReconfigureOnChangeFilter.this.mainConfigurationURL);
                }
            }
        }
    }

    private void updateMaskIfNecessary(long j4) {
        long j5 = j4 - this.lastMaskCheck;
        this.lastMaskCheck = j4;
        if (j5 < MASK_INCREASE_THRESHOLD && this.mask < WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.mask = (this.mask << 1) | 1;
        } else if (j5 > MASK_DECREASE_THRESHOLD) {
            this.mask >>>= 2;
        }
    }

    public boolean changeDetected(long j4) {
        if (j4 < this.nextCheck) {
            return false;
        }
        updateNextCheck(j4);
        return this.configurationWatchList.changeDetected();
    }

    @Override // ch.qos.logback.classic.turbo.TurboFilter
    public FilterReply decide(e eVar, Logger logger, Level level, String str, Object[] objArr, Throwable th) {
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }
        long j4 = this.invocationCounter;
        this.invocationCounter = 1 + j4;
        if ((j4 & this.mask) != this.mask) {
            return FilterReply.NEUTRAL;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.configurationWatchList) {
            try {
                updateMaskIfNecessary(jCurrentTimeMillis);
                if (changeDetected(jCurrentTimeMillis)) {
                    disableSubsequentReconfiguration();
                    detachReconfigurationToNewThread();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return FilterReply.NEUTRAL;
    }

    public void detachReconfigurationToNewThread() {
        addInfo("Detected change in [" + this.configurationWatchList.getCopyOfFileWatchList() + "]");
        this.context.getExecutorService().submit(new ReconfiguringThread());
    }

    public void disableSubsequentReconfiguration() {
        this.nextCheck = LongCompanionObject.MAX_VALUE;
    }

    public long getRefreshPeriod() {
        return this.refreshPeriod;
    }

    public void setRefreshPeriod(long j4) {
        this.refreshPeriod = j4;
    }

    @Override // ch.qos.logback.classic.turbo.TurboFilter, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        ConfigurationWatchList configurationWatchList = ConfigurationWatchListUtil.getConfigurationWatchList(this.context);
        this.configurationWatchList = configurationWatchList;
        if (configurationWatchList == null) {
            addWarn("Empty ConfigurationWatchList in context");
            return;
        }
        URL mainURL = configurationWatchList.getMainURL();
        this.mainConfigurationURL = mainURL;
        if (mainURL == null) {
            addWarn("Due to missing top level configuration file, automatic reconfiguration is impossible.");
            return;
        }
        addInfo("Will scan for changes in [" + this.configurationWatchList.getCopyOfFileWatchList() + "] every " + (this.refreshPeriod / 1000) + " seconds. ");
        synchronized (this.configurationWatchList) {
            updateNextCheck(System.currentTimeMillis());
        }
        super.start();
    }

    public String toString() {
        return "ReconfigureOnChangeFilter{invocationCounter=" + this.invocationCounter + '}';
    }

    public void updateNextCheck(long j4) {
        this.nextCheck = j4 + this.refreshPeriod;
    }
}
