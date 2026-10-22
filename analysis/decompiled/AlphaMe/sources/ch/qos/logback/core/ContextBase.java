package ch.qos.logback.core;

import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.spi.LogbackLock;
import ch.qos.logback.core.status.StatusManager;
import ch.qos.logback.core.util.ExecutorServiceUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class ContextBase implements Context, LifeCycle {
    private volatile ExecutorService executorService;
    private LifeCycleManager lifeCycleManager;
    private String name;
    private boolean started;
    private long birthTime = System.currentTimeMillis();
    private StatusManager sm = new BasicStatusManager();
    Map<String, String> propertyMap = new HashMap();
    Map<String, Object> objectMap = new HashMap();
    LogbackLock configurationLock = new LogbackLock();

    private synchronized void stopExecutorService() {
        if (this.executorService != null) {
            ExecutorServiceUtil.shutdown(this.executorService);
            this.executorService = null;
        }
    }

    @Override // ch.qos.logback.core.Context
    public long getBirthTime() {
        return this.birthTime;
    }

    @Override // ch.qos.logback.core.Context
    public Object getConfigurationLock() {
        return this.configurationLock;
    }

    @Override // ch.qos.logback.core.Context, ch.qos.logback.core.spi.PropertyContainer
    public Map<String, String> getCopyOfPropertyMap() {
        return new HashMap(this.propertyMap);
    }

    @Override // ch.qos.logback.core.Context
    public ExecutorService getExecutorService() {
        if (this.executorService == null) {
            synchronized (this) {
                try {
                    if (this.executorService == null) {
                        this.executorService = ExecutorServiceUtil.newExecutorService();
                    }
                } finally {
                }
            }
        }
        return this.executorService;
    }

    public synchronized LifeCycleManager getLifeCycleManager() {
        try {
            if (this.lifeCycleManager == null) {
                this.lifeCycleManager = new LifeCycleManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.lifeCycleManager;
    }

    @Override // ch.qos.logback.core.Context
    public String getName() {
        return this.name;
    }

    @Override // ch.qos.logback.core.Context
    public Object getObject(String str) {
        return this.objectMap.get(str);
    }

    @Override // ch.qos.logback.core.Context, ch.qos.logback.core.spi.PropertyContainer
    public String getProperty(String str) {
        return CoreConstants.CONTEXT_NAME_KEY.equals(str) ? getName() : this.propertyMap.get(str);
    }

    @Override // ch.qos.logback.core.Context
    public StatusManager getStatusManager() {
        return this.sm;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.started;
    }

    @Override // ch.qos.logback.core.Context
    public void putObject(String str, Object obj) {
        this.objectMap.put(str, obj);
    }

    @Override // ch.qos.logback.core.Context
    public void putProperty(String str, String str2) {
        this.propertyMap.put(str, str2);
    }

    @Override // ch.qos.logback.core.Context
    public void register(LifeCycle lifeCycle) {
        getLifeCycleManager().register(lifeCycle);
    }

    public void reset() {
        getLifeCycleManager().reset();
        this.propertyMap.clear();
        this.objectMap.clear();
    }

    @Override // ch.qos.logback.core.Context
    public void setName(String str) throws IllegalStateException {
        if (str == null || !str.equals(this.name)) {
            String str2 = this.name;
            if (str2 != null && !"default".equals(str2)) {
                throw new IllegalStateException("Context has been already given a name");
            }
            this.name = str;
        }
    }

    public void setStatusManager(StatusManager statusManager) {
        if (statusManager == null) {
            throw new IllegalArgumentException("null StatusManager not allowed");
        }
        this.sm = statusManager;
    }

    public void start() {
        this.started = true;
    }

    public void stop() {
        stopExecutorService();
        this.started = false;
    }

    public String toString() {
        return this.name;
    }
}
