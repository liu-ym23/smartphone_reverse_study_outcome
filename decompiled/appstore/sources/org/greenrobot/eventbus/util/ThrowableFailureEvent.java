package org.greenrobot.eventbus.util;

/* JADX INFO: loaded from: classes4.dex */
public class ThrowableFailureEvent implements HasExecutionScope {
    private Object executionContext;
    protected final boolean suppressErrorUi;
    protected final Throwable throwable;

    public ThrowableFailureEvent(Throwable r10) {
        this.throwable = r10;
        this.suppressErrorUi = false;
    }

    @Override // org.greenrobot.eventbus.util.HasExecutionScope
    public Object getExecutionScope() {
        return this.executionContext;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public boolean isSuppressErrorUi() {
        return this.suppressErrorUi;
    }

    @Override // org.greenrobot.eventbus.util.HasExecutionScope
    public void setExecutionScope(Object r10) {
        this.executionContext = r10;
    }

    public ThrowableFailureEvent(Throwable r10, boolean r11) {
        this.throwable = r10;
        this.suppressErrorUi = r11;
    }
}
