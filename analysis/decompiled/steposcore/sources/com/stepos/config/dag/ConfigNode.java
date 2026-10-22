package com.stepos.config.dag;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class ConfigNode {
    private final Class<? extends ConfigBean> beanClass;
    private volatile ConfigBean beanInstance;
    private final String configName;
    private final List<String> dependencies;
    private volatile long initDuration;
    private volatile Throwable initException;
    private volatile long initStartTime;
    private final int priority;
    private final InitializationStrategy strategy;
    private final ReentrantLock initLock = new ReentrantLock();
    private final AtomicReference<InitState> state = new AtomicReference<>(InitState.UNINITIALIZED);

    public enum InitState {
        UNINITIALIZED,
        INITIALIZING,
        INITIALIZED,
        FAILED,
        RECOVERING
    }

    public ConfigNode(String configName, Class<? extends ConfigBean> beanClass, List<String> dependencies, InitializationStrategy strategy, int priority) {
        this.configName = configName;
        this.beanClass = beanClass;
        this.dependencies = dependencies;
        this.strategy = strategy;
        this.priority = priority;
    }

    public String getConfigName() {
        return this.configName;
    }

    public Class<? extends ConfigBean> getBeanClass() {
        return this.beanClass;
    }

    public List<String> getDependencies() {
        return this.dependencies;
    }

    public InitializationStrategy getStrategy() {
        return this.strategy;
    }

    public int getPriority() {
        return this.priority;
    }

    public InitState getState() {
        return this.state.get();
    }

    public boolean compareAndSetState(InitState expect, InitState update) {
        return this.state.compareAndSet(expect, update);
    }

    public void setState(InitState newState) {
        this.state.set(newState);
    }

    public ConfigBean getBeanInstance() {
        return this.beanInstance;
    }

    public void setBeanInstance(ConfigBean bean) {
        this.beanInstance = bean;
    }

    public Throwable getInitException() {
        return this.initException;
    }

    public void setInitException(Throwable e) {
        this.initException = e;
    }

    public ReentrantLock getInitLock() {
        return this.initLock;
    }

    public long getInitStartTime() {
        return this.initStartTime;
    }

    public void setInitStartTime(long time) {
        this.initStartTime = time;
    }

    public long getInitDuration() {
        return this.initDuration;
    }

    public void setInitDuration(long duration) {
        this.initDuration = duration;
    }

    public boolean canRetry() {
        return getState() == InitState.FAILED;
    }

    public void resetForRetry() {
        if (compareAndSetState(InitState.FAILED, InitState.RECOVERING)) {
            setInitException(null);
        }
    }
}
