package ch.qos.logback.core.read;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.helpers.CyclicBuffer;

/* loaded from: classes.dex */
public class CyclicBufferAppender<E> extends AppenderBase<E> {
    CyclicBuffer<E> cb;
    int maxSize = 512;

    @Override // ch.qos.logback.core.AppenderBase
    public void append(E e4) {
        if (isStarted()) {
            this.cb.add(e4);
        }
    }

    public E get(int i4) {
        if (isStarted()) {
            return this.cb.get(i4);
        }
        return null;
    }

    public int getLength() {
        if (isStarted()) {
            return this.cb.length();
        }
        return 0;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public void reset() {
        this.cb.clear();
    }

    public void setMaxSize(int i4) {
        this.maxSize = i4;
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.cb = new CyclicBuffer<>(this.maxSize);
        super.start();
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.cb = null;
        super.stop();
    }
}
