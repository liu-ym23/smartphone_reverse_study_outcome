package ch.qos.logback.core;

import B0.g;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.FilterAttachableImpl;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.status.WarnStatus;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AppenderBase<E> extends ContextAwareBase implements Appender<E> {
    static final int ALLOWED_REPEATS = 5;
    protected String name;
    protected boolean started = false;
    private boolean guard = false;
    private FilterAttachableImpl<E> fai = new FilterAttachableImpl<>();
    private int statusRepeatCount = 0;
    private int exceptionCount = 0;

    @Override // ch.qos.logback.core.spi.FilterAttachable
    public void addFilter(Filter<E> filter) {
        this.fai.addFilter(filter);
    }

    public abstract void append(E e4);

    @Override // ch.qos.logback.core.spi.FilterAttachable
    public void clearAllFilters() {
        this.fai.clearAllFilters();
    }

    @Override // ch.qos.logback.core.Appender
    public synchronized void doAppend(E e4) {
        if (this.guard) {
            return;
        }
        try {
            try {
                this.guard = true;
            } catch (Exception e5) {
                int i4 = this.exceptionCount;
                this.exceptionCount = i4 + 1;
                if (i4 < 5) {
                    addError("Appender [" + this.name + "] failed to append.", e5);
                }
            }
            if (this.started) {
                if (getFilterChainDecision(e4) == FilterReply.DENY) {
                    return;
                }
                append(e4);
                return;
            }
            int i5 = this.statusRepeatCount;
            this.statusRepeatCount = i5 + 1;
            if (i5 < 5) {
                addStatus(new WarnStatus("Attempted to append to non started appender [" + this.name + "].", this));
            }
        } finally {
            this.guard = false;
        }
    }

    @Override // ch.qos.logback.core.spi.FilterAttachable
    public List<Filter<E>> getCopyOfAttachedFiltersList() {
        return this.fai.getCopyOfAttachedFiltersList();
    }

    @Override // ch.qos.logback.core.spi.FilterAttachable
    public FilterReply getFilterChainDecision(E e4) {
        return this.fai.getFilterChainDecision(e4);
    }

    @Override // ch.qos.logback.core.Appender
    public String getName() {
        return this.name;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.started;
    }

    @Override // ch.qos.logback.core.Appender
    public void setName(String str) {
        this.name = str;
    }

    public void start() {
        this.started = true;
    }

    public void stop() {
        this.started = false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[");
        return g.r(sb, this.name, "]");
    }
}
