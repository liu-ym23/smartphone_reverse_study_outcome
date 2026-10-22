package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public abstract class AbstractExecutionThreadService implements Service {
    private static final Logger logger = null;
    private final Service delegate;

    static {
        logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    }

    public AbstractExecutionThreadService() {
        this.delegate = new AnonymousClass1(this);
    }

    public static /* synthetic */ Logger access$000() {
        return logger;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener r10, Executor r11) {
        this.delegate.addListener(r10, r11);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public Executor executor() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public abstract void run() throws Exception;

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public void shutDown() throws Exception {
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    public void startUp() throws Exception {
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    public void triggerShutdown() {
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long r10, TimeUnit r11) throws TimeoutException {
        this.delegate.awaitRunning(r10, r11);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long r10, TimeUnit r11) throws TimeoutException {
        this.delegate.awaitTerminated(r10, r11);
    }
}
