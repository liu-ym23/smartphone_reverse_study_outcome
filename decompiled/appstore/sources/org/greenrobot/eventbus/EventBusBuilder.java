package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

/* JADX INFO: loaded from: classes4.dex */
public class EventBusBuilder {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = null;
    boolean eventInheritance;
    ExecutorService executorService;
    boolean ignoreGeneratedIndex;
    boolean logNoSubscriberMessages;
    boolean logSubscriberExceptions;
    Logger logger;
    MainThreadSupport mainThreadSupport;
    boolean sendNoSubscriberEvent;
    boolean sendSubscriberExceptionEvent;
    List<Class<?>> skipMethodVerificationForClasses;
    boolean strictMethodVerification;
    List<SubscriberInfoIndex> subscriberInfoIndexes;
    boolean throwSubscriberException;

    static {
        DEFAULT_EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    }

    public EventBusBuilder() {
        this.logSubscriberExceptions = true;
        this.logNoSubscriberMessages = true;
        this.sendSubscriberExceptionEvent = true;
        this.sendNoSubscriberEvent = true;
        this.eventInheritance = true;
        this.executorService = DEFAULT_EXECUTOR_SERVICE;
    }

    public EventBusBuilder addIndex(SubscriberInfoIndex r10) {
        if (this.subscriberInfoIndexes != null) goto L5;
        this.subscriberInfoIndexes = new ArrayList();
    L5:
        this.subscriberInfoIndexes.add(r10);
        return this;
    }

    public EventBus build() {
        return new EventBus(this);
    }

    public EventBusBuilder eventInheritance(boolean r10) {
        this.eventInheritance = r10;
        return this;
    }

    public EventBusBuilder executorService(ExecutorService r10) {
        this.executorService = r10;
        return this;
    }

    public Object getAndroidMainLooperOrNull() {
        return Looper.getMainLooper();
    L4:
        return null;
    }

    public Logger getLogger() {
        Logger r10 = this.logger;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (Logger.AndroidLogger.isAndroidLogAvailable() == false) goto L11;
        if (getAndroidMainLooperOrNull() == null) goto L11;
        return new Logger.AndroidLogger("EventBus");
    L11:
        return new Logger.SystemOutLogger();
    }

    public MainThreadSupport getMainThreadSupport() {
        MainThreadSupport r10 = this.mainThreadSupport;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (Logger.AndroidLogger.isAndroidLogAvailable() == false) goto L12;
        Object r11 = getAndroidMainLooperOrNull();
        if (r11 != null) goto L11;
        return null;
    L11:
        return new MainThreadSupport.AndroidHandlerMainThreadSupport((Looper) r11);
    L12:
        return null;
    }

    public EventBusBuilder ignoreGeneratedIndex(boolean r10) {
        this.ignoreGeneratedIndex = r10;
        return this;
    }

    public EventBus installDefaultEventBus() {
        monitor-enter(EventBus.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (EventBus.defaultInstance != null) goto L12;
        EventBus.defaultInstance = build();     // Catch: Throwable -> L9
        EventBus r10 = EventBus.defaultInstance;     // Catch: Throwable -> L9
        monitor-exit(EventBus.class);     // Catch: Throwable -> L9
        return r10;
    L12:
        throw new EventBusException("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");     // Catch: Throwable -> L9
    }

    public EventBusBuilder logNoSubscriberMessages(boolean r10) {
        this.logNoSubscriberMessages = r10;
        return this;
    }

    public EventBusBuilder logSubscriberExceptions(boolean r10) {
        this.logSubscriberExceptions = r10;
        return this;
    }

    public EventBusBuilder logger(Logger r10) {
        this.logger = r10;
        return this;
    }

    public EventBusBuilder sendNoSubscriberEvent(boolean r10) {
        this.sendNoSubscriberEvent = r10;
        return this;
    }

    public EventBusBuilder sendSubscriberExceptionEvent(boolean r10) {
        this.sendSubscriberExceptionEvent = r10;
        return this;
    }

    public EventBusBuilder skipMethodVerificationFor(Class<?> r10) {
        if (this.skipMethodVerificationForClasses != null) goto L5;
        this.skipMethodVerificationForClasses = new ArrayList();
    L5:
        this.skipMethodVerificationForClasses.add(r10);
        return this;
    }

    public EventBusBuilder strictMethodVerification(boolean r10) {
        this.strictMethodVerification = r10;
        return this;
    }

    public EventBusBuilder throwSubscriberException(boolean r10) {
        this.throwSubscriberException = r10;
        return this;
    }
}
