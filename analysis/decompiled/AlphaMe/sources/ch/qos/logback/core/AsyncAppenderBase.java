package ch.qos.logback.core;

import ch.qos.logback.core.spi.AppenderAttachable;
import ch.qos.logback.core.spi.AppenderAttachableImpl;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
public class AsyncAppenderBase<E> extends UnsynchronizedAppenderBase<E> implements AppenderAttachable<E> {
    public static final int DEFAULT_QUEUE_SIZE = 256;
    static final int UNDEFINED = -1;
    BlockingQueue<E> blockingQueue;
    AppenderAttachableImpl<E> aai = new AppenderAttachableImpl<>();
    int queueSize = 256;
    int appenderCount = 0;
    int discardingThreshold = -1;
    AsyncAppenderBase<E>.Worker worker = new Worker();

    public class Worker extends Thread {
        public Worker() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws LogbackException {
            AsyncAppenderBase asyncAppenderBase = AsyncAppenderBase.this;
            AppenderAttachableImpl<E> appenderAttachableImpl = asyncAppenderBase.aai;
            while (asyncAppenderBase.isStarted()) {
                try {
                    appenderAttachableImpl.appendLoopOnAppenders(asyncAppenderBase.blockingQueue.take());
                } catch (InterruptedException unused) {
                }
            }
            AsyncAppenderBase.this.addInfo("Worker thread will flush remaining events before exiting. ");
            Iterator<E> it = asyncAppenderBase.blockingQueue.iterator();
            while (it.hasNext()) {
                appenderAttachableImpl.appendLoopOnAppenders(it.next());
            }
            appenderAttachableImpl.detachAndStopAllAppenders();
        }
    }

    private boolean isQueueBelowDiscardingThreshold() {
        return this.blockingQueue.remainingCapacity() < this.discardingThreshold;
    }

    private void put(E e4) throws InterruptedException {
        try {
            this.blockingQueue.put(e4);
        } catch (InterruptedException unused) {
        }
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public void addAppender(Appender<E> appender) {
        int i4 = this.appenderCount;
        if (i4 != 0) {
            addWarn("One and only one appender may be attached to AsyncAppender.");
            addWarn("Ignoring additional appender named [" + appender.getName() + "]");
            return;
        }
        this.appenderCount = i4 + 1;
        addInfo("Attaching appender named [" + appender.getName() + "] to AsyncAppender.");
        this.aai.addAppender(appender);
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase
    public void append(E e4) throws InterruptedException {
        if (isQueueBelowDiscardingThreshold() && isDiscardable(e4)) {
            return;
        }
        preprocess(e4);
        put(e4);
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public void detachAndStopAllAppenders() {
        this.aai.detachAndStopAllAppenders();
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public boolean detachAppender(Appender<E> appender) {
        return this.aai.detachAppender(appender);
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public Appender<E> getAppender(String str) {
        return this.aai.getAppender(str);
    }

    public int getDiscardingThreshold() {
        return this.discardingThreshold;
    }

    public int getNumberOfElementsInQueue() {
        return this.blockingQueue.size();
    }

    public int getQueueSize() {
        return this.queueSize;
    }

    public int getRemainingCapacity() {
        return this.blockingQueue.remainingCapacity();
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public boolean isAttached(Appender<E> appender) {
        return this.aai.isAttached(appender);
    }

    public boolean isDiscardable(E e4) {
        return false;
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public Iterator<Appender<E>> iteratorForAppenders() {
        return this.aai.iteratorForAppenders();
    }

    public void preprocess(E e4) {
    }

    public void setDiscardingThreshold(int i4) {
        this.discardingThreshold = i4;
    }

    public void setQueueSize(int i4) {
        this.queueSize = i4;
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.appenderCount == 0) {
            addError("No attached appenders found.");
            return;
        }
        if (this.queueSize < 1) {
            addError("Invalid queue size [" + this.queueSize + "]");
            return;
        }
        this.blockingQueue = new ArrayBlockingQueue(this.queueSize);
        if (this.discardingThreshold == -1) {
            this.discardingThreshold = this.queueSize / 5;
        }
        addInfo("Setting discardingThreshold to " + this.discardingThreshold);
        this.worker.setDaemon(true);
        this.worker.setName("AsyncAppender-Worker-" + this.worker.getName());
        super.start();
        this.worker.start();
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void stop() throws InterruptedException {
        if (isStarted()) {
            super.stop();
            this.worker.interrupt();
            try {
                this.worker.join(1000L);
            } catch (InterruptedException e4) {
                addError("Failed to join worker thread", e4);
            }
        }
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public boolean detachAppender(String str) {
        return this.aai.detachAppender(str);
    }
}
