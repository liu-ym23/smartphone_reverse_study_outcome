package com.android.ttcjpaysdk.base.h5.cjjsb.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBSession;", "", "()V", "endTimestamp", "", "getEndTimestamp", "()J", "setEndTimestamp", "(J)V", "feInvokeTimestamp", "getFeInvokeTimestamp", "setFeInvokeTimestamp", "inputParamsInitEndTimestamp", "getInputParamsInitEndTimestamp", "setInputParamsInitEndTimestamp", "inputParamsInitStartTimestamp", "getInputParamsInitStartTimestamp", "setInputParamsInitStartTimestamp", "nativeInvokeTimestamp", "getNativeInvokeTimestamp", "setNativeInvokeTimestamp", "realHandleStartTimestamp", "getRealHandleStartTimestamp", "setRealHandleStartTimestamp", "startTimestamp", "getStartTimestamp", "setStartTimestamp", "getDuration", "getFe2NativeDuration", "getInputParamsInitDuration", "getRealHandleDuaration", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBSession {
    private long endTimestamp;
    private long feInvokeTimestamp;
    private long inputParamsInitEndTimestamp;
    private long inputParamsInitStartTimestamp;
    private long nativeInvokeTimestamp;
    private long realHandleStartTimestamp;
    private long startTimestamp;

    public JSBSession() {
    }

    public final long getDuration() {
        return this.endTimestamp - this.startTimestamp;
    }

    public final long getFe2NativeDuration() {
        long r100 = this.nativeInvokeTimestamp;
        if (r100 <= 0) goto L8;
        long r101 = this.feInvokeTimestamp;
        if (r101 > 0) goto L7;
        return 0;
    L7:
        return r100 - r101;
    L8:
        return 0;
    }

    public final long getInputParamsInitDuration() {
        return this.inputParamsInitEndTimestamp - this.inputParamsInitStartTimestamp;
    }

    public final long getRealHandleDuaration() {
        return this.endTimestamp - this.realHandleStartTimestamp;
    }

    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final long getFeInvokeTimestamp() {
        return this.feInvokeTimestamp;
    }

    public final long getInputParamsInitEndTimestamp() {
        return this.inputParamsInitEndTimestamp;
    }

    public final long getInputParamsInitStartTimestamp() {
        return this.inputParamsInitStartTimestamp;
    }

    public final long getNativeInvokeTimestamp() {
        return this.nativeInvokeTimestamp;
    }

    public final long getRealHandleStartTimestamp() {
        return this.realHandleStartTimestamp;
    }

    public final long getStartTimestamp() {
        return this.startTimestamp;
    }

    public final void setEndTimestamp(long r100) {
        this.endTimestamp = r100;
    }

    public final void setFeInvokeTimestamp(long r100) {
        this.feInvokeTimestamp = r100;
    }

    public final void setInputParamsInitEndTimestamp(long r100) {
        this.inputParamsInitEndTimestamp = r100;
    }

    public final void setInputParamsInitStartTimestamp(long r100) {
        this.inputParamsInitStartTimestamp = r100;
    }

    public final void setNativeInvokeTimestamp(long r100) {
        this.nativeInvokeTimestamp = r100;
    }

    public final void setRealHandleStartTimestamp(long r100) {
        this.realHandleStartTimestamp = r100;
    }

    public final void setStartTimestamp(long r100) {
        this.startTimestamp = r100;
    }
}
