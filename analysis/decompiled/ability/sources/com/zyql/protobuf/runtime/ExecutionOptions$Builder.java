package com.zyql.protobuf.runtime;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.LogLevel;
import u7.f;

/* loaded from: classes2.dex */
public final class ExecutionOptions$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ExecutionOptions$Builder(int i) {
        this();
    }

    public ExecutionOptions$Builder clearIncludeFunctionCallOutput() {
        copyOnWrite();
        f.D((f) this.instance);
        return this;
    }

    public ExecutionOptions$Builder clearIncludeSubAgentOutput() {
        copyOnWrite();
        f.E((f) this.instance);
        return this;
    }

    public ExecutionOptions$Builder clearLogLevel() {
        copyOnWrite();
        f.F((f) this.instance);
        return this;
    }

    public ExecutionOptions$Builder clearObserverMode() {
        copyOnWrite();
        f.G((f) this.instance);
        return this;
    }

    public ExecutionOptions$Builder clearSendCompleteMessage() {
        copyOnWrite();
        f.H((f) this.instance);
        return this;
    }

    public boolean getIncludeFunctionCallOutput() {
        return ((f) this.instance).Q();
    }

    public boolean getIncludeSubAgentOutput() {
        return ((f) this.instance).R();
    }

    public LogLevel getLogLevel() {
        return ((f) this.instance).S();
    }

    public int getLogLevelValue() {
        return ((f) this.instance).T();
    }

    public boolean getObserverMode() {
        return ((f) this.instance).U();
    }

    public boolean getSendCompleteMessage() {
        return ((f) this.instance).V();
    }

    public boolean hasIncludeFunctionCallOutput() {
        return ((f) this.instance).W();
    }

    public boolean hasIncludeSubAgentOutput() {
        return ((f) this.instance).X();
    }

    public boolean hasLogLevel() {
        return ((f) this.instance).Y();
    }

    public boolean hasObserverMode() {
        return ((f) this.instance).Z();
    }

    public boolean hasSendCompleteMessage() {
        return ((f) this.instance).a0();
    }

    public ExecutionOptions$Builder setIncludeFunctionCallOutput(boolean z10) {
        copyOnWrite();
        f.I((f) this.instance, z10);
        return this;
    }

    public ExecutionOptions$Builder setIncludeSubAgentOutput(boolean z10) {
        copyOnWrite();
        f.J((f) this.instance, z10);
        return this;
    }

    public ExecutionOptions$Builder setLogLevel(LogLevel logLevel) {
        copyOnWrite();
        f.K((f) this.instance, logLevel);
        return this;
    }

    public ExecutionOptions$Builder setLogLevelValue(int i) {
        copyOnWrite();
        f.L((f) this.instance, i);
        return this;
    }

    public ExecutionOptions$Builder setObserverMode(boolean z10) {
        copyOnWrite();
        f.M((f) this.instance, z10);
        return this;
    }

    public ExecutionOptions$Builder setSendCompleteMessage(boolean z10) {
        copyOnWrite();
        f.N((f) this.instance, z10);
        return this;
    }

    private ExecutionOptions$Builder() {
        super(f.DEFAULT_INSTANCE);
    }
}
